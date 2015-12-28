/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import com.thoughtworks.xstream.XStream;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   6:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   7:    */ import ec.gob.sri.comprobantes.sql.EmisorSQL;
/*   8:    */ import ec.gob.sri.comprobantes.util.xml.XStreamUtil;
/*   9:    */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
/*  10:    */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion.Mensajes;
/*  11:    */ import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantes;
/*  12:    */ import ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobantesService;
/*  13:    */ import ec.gob.sri.comprobantes.ws.aut.Mensaje;
/*  14:    */ import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;
/*  15:    */ import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante.Autorizaciones;
/*  16:    */ import ec.gob.sri.comprobantes.ws.aut.RespuestaLote;
/*  17:    */ import ec.gob.sri.comprobantes.ws.aut.RespuestaLote.Autorizaciones;
/*  18:    */ import java.io.ByteArrayOutputStream;
/*  19:    */ import java.io.File;
/*  20:    */ import java.io.OutputStreamWriter;
/*  21:    */ import java.io.Writer;
/*  22:    */ import java.net.URL;
/*  23:    */ import java.sql.SQLException;
/*  24:    */ import java.util.ArrayList;
/*  25:    */ import java.util.List;
/*  26:    */ import java.util.logging.Level;
/*  27:    */ import java.util.logging.Logger;
/*  28:    */ import javax.swing.JFrame;
/*  29:    */ import javax.swing.JOptionPane;
/*  30:    */ import javax.xml.datatype.XMLGregorianCalendar;
/*  31:    */ import javax.xml.namespace.QName;
/*  32:    */ 
/*  33:    */ public class AutorizacionComprobantesWs
/*  34:    */ {
/*  35:    */   private AutorizacionComprobantesService service;
/*  36:    */   public static final String ESTADO_AUTORIZADO = "AUTORIZADO";
/*  37:    */   public static final String ESTADO_NO_AUTORIZADO = "NO AUTORIZADO";
/*  38:    */   
/*  39:    */   public AutorizacionComprobantesWs(String wsdlLocation)
/*  40:    */   {
/*  41:    */     try
/*  42:    */     {
/*  43: 49 */       this.service = new AutorizacionComprobantesService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
/*  44:    */     }
/*  45:    */     catch (Exception ex)
/*  46:    */     {
/*  47: 52 */       Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/*  48: 53 */       JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Se ha producido un error ", 0);
/*  49:    */     }
/*  50:    */   }
/*  51:    */   
/*  52:    */   public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso)
/*  53:    */   {
/*  54: 66 */     RespuestaComprobante response = null;
/*  55:    */     try
/*  56:    */     {
/*  57: 69 */       AutorizacionComprobantes port = this.service.getAutorizacionComprobantesPort();
/*  58: 70 */       response = port.autorizacionComprobante(claveDeAcceso);
/*  59:    */     }
/*  60:    */     catch (Exception e)
/*  61:    */     {
/*  62: 73 */       Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
/*  63: 74 */       return response;
/*  64:    */     }
/*  65: 77 */     return response;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public RespuestaLote llamadaWsAutorizacionLote(String claveDeAcceso)
/*  69:    */   {
/*  70: 92 */     RespuestaLote response = null;
/*  71:    */     try
/*  72:    */     {
/*  73: 94 */       AutorizacionComprobantes port = this.service.getAutorizacionComprobantesPort();
/*  74: 95 */       response = port.autorizacionComprobanteLote(claveDeAcceso);
/*  75:    */     }
/*  76:    */     catch (Exception e)
/*  77:    */     {
/*  78: 98 */       Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
/*  79: 99 */       return response;
/*  80:    */     }
/*  81:101 */     return response;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public static String autorizarComprobanteIndividual(String claveDeAcceso, String nombreArchivo, String tipoAmbiente)
/*  85:    */   {
/*  86:113 */     StringBuilder mensaje = new StringBuilder();
/*  87:    */     try
/*  88:    */     {
/*  89:115 */       String dirAutorizados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.AUTORIZADOS.getCode()).getPath();
/*  90:116 */       String dirNoAutorizados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.NO_AUTORIZADOS.getCode()).getPath();
/*  91:    */       
/*  92:118 */       RespuestaComprobante respuesta = null;
/*  93:121 */       for (int i = 0; i < 5; i++)
/*  94:    */       {
/*  95:122 */         respuesta = new AutorizacionComprobantesWs(FormGenerales.devuelveUrlWs(tipoAmbiente, "AutorizacionComprobantes")).llamadaWSAutorizacionInd(claveDeAcceso);
/*  96:124 */         if (!respuesta.getAutorizaciones().getAutorizacion().isEmpty()) {
/*  97:    */           break;
/*  98:    */         }
/*  99:127 */         Thread.currentThread();Thread.sleep(300L);
/* 100:    */       }
/* 101:    */       int i;
/* 102:130 */       if (respuesta != null)
/* 103:    */       {
/* 104:131 */         i = 0;
/* 105:132 */         for (Autorizacion item : respuesta.getAutorizaciones().getAutorizacion())
/* 106:    */         {
/* 107:133 */           mensaje.append(item.getEstado());
/* 108:    */           
/* 109:    */ 
/* 110:136 */           item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");
/* 111:    */           
/* 112:138 */           XStream xstream = XStreamUtil.getRespuestaXStream();
/* 113:139 */           Writer writer = null;
/* 114:140 */           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 115:141 */           writer = new OutputStreamWriter(outputStream, "UTF-8");
/* 116:142 */           writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/* 117:    */           
/* 118:144 */           xstream.toXML(item, writer);
/* 119:145 */           String xmlAutorizacion = outputStream.toString("UTF-8");
/* 120:147 */           if ((i == 0) && (item.getEstado().equals("AUTORIZADO")))
/* 121:    */           {
/* 122:148 */             ArchivoUtils.stringToArchivo(dirAutorizados + File.separator + nombreArchivo, xmlAutorizacion);
/* 123:149 */             VisualizacionRideUtil.decodeArchivoBase64(dirAutorizados + File.separator + nombreArchivo, item.getNumeroAutorizacion(), item.getFechaAutorizacion().toString());
/* 124:150 */             break;
/* 125:    */           }
/* 126:152 */           if (item.getEstado().equals("NO AUTORIZADO"))
/* 127:    */           {
/* 128:153 */             ArchivoUtils.stringToArchivo(dirNoAutorizados + File.separator + nombreArchivo, xmlAutorizacion);
/* 129:154 */             mensaje.append("|" + obtieneMensajesAutorizacion(item));
/* 130:    */             
/* 131:    */ 
/* 132:157 */             verificarOCSP(item);
/* 133:    */             
/* 134:159 */             break;
/* 135:    */           }
/* 136:161 */           i++;
/* 137:    */         }
/* 138:    */       }
/* 139:165 */       if ((respuesta == null) || (respuesta.getAutorizaciones().getAutorizacion().isEmpty() == true))
/* 140:    */       {
/* 141:166 */         mensaje.append("TRANSMITIDO SIN RESPUESTA|Ha ocurrido un error en el proceso de la Autorización, por lo que se traslado el archivo a la carpeta de: transmitidosSinRespuesta");
/* 142:    */         
/* 143:168 */         String dirFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 144:169 */         String dirTransmitidos = dirFirmados + File.separator + "transmitidosSinRespuesta";
/* 145:    */         
/* 146:171 */         File transmitidos = new File(dirTransmitidos);
/* 147:172 */         if (!transmitidos.exists()) {
/* 148:173 */           new File(dirTransmitidos).mkdir();
/* 149:    */         }
/* 150:176 */         File archivoFirmado = new File(new File(dirFirmados), nombreArchivo);
/* 151:177 */         if (!ArchivoUtils.copiarArchivo(archivoFirmado, transmitidos.getPath() + File.separator + nombreArchivo)) {
/* 152:178 */           mensaje.append("\nError al mover el archivo a la carpeta de Transmitidos sin Respuesta");
/* 153:    */         } else {
/* 154:180 */           archivoFirmado.delete();
/* 155:    */         }
/* 156:    */       }
/* 157:    */     }
/* 158:    */     catch (Exception ex)
/* 159:    */     {
/* 160:185 */       Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/* 161:    */     }
/* 162:187 */     return mensaje.toString();
/* 163:    */   }
/* 164:    */   
/* 165:    */   public static List<Autorizacion> autorizarComprobanteLote(String claveDeAcceso, String nombreArchivoLote, int timeout, int cantidadArchivos, String tipoAmbiente)
/* 166:    */   {
/* 167:202 */     List<Autorizacion> autorizaciones = new ArrayList();
/* 168:203 */     RespuestaLote respuestaAutorizacion = null;
/* 169:    */     try
/* 170:    */     {
/* 171:206 */       dirAutorizados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.AUTORIZADOS.getCode()).getPath();
/* 172:207 */       dirRechazados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.NO_AUTORIZADOS.getCode()).getPath();
/* 173:208 */       dirFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 174:    */       
/* 175:    */ 
/* 176:211 */       Thread.currentThread();Thread.sleep(timeout * cantidadArchivos * 1000);
/* 177:214 */       for (int i = 0; i < 5; i++)
/* 178:    */       {
/* 179:215 */         respuestaAutorizacion = new AutorizacionComprobantesWs(FormGenerales.devuelveUrlWs(tipoAmbiente, "AutorizacionComprobantes")).llamadaWsAutorizacionLote(claveDeAcceso);
/* 180:217 */         if (!respuestaAutorizacion.getAutorizaciones().getAutorizacion().isEmpty()) {
/* 181:    */           break;
/* 182:    */         }
/* 183:220 */         Thread.currentThread();Thread.sleep(500L);
/* 184:    */       }
/* 185:223 */       comprobantesProcesados = respuestaAutorizacion.getNumeroComprobantesLote();
/* 186:224 */       for (Autorizacion item : respuestaAutorizacion.getAutorizaciones().getAutorizacion())
/* 187:    */       {
/* 188:227 */         item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");
/* 189:228 */         String claveAcceso = ArchivoUtils.obtieneClaveAccesoAutorizacion(item);
/* 190:    */         
/* 191:230 */         XStream xstream = XStreamUtil.getRespuestaLoteXStream();
/* 192:231 */         Writer writer = null;
/* 193:232 */         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 194:233 */         writer = new OutputStreamWriter(outputStream, "UTF-8");
/* 195:234 */         writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/* 196:    */         
/* 197:236 */         xstream.toXML(item, writer);
/* 198:    */         
/* 199:238 */         String nombreArchivoConRespuesta = claveAcceso + ".xml";
/* 200:239 */         String xmlAutorizacion = outputStream.toString("UTF-8");
/* 201:241 */         if (item.getEstado().equals("AUTORIZADO")) {
/* 202:242 */           ArchivoUtils.stringToArchivo(dirAutorizados + File.separator + nombreArchivoConRespuesta, xmlAutorizacion);
/* 203:    */         } else {
/* 204:244 */           ArchivoUtils.stringToArchivo(dirRechazados + File.separator + nombreArchivoConRespuesta, xmlAutorizacion);
/* 205:    */         }
/* 206:247 */         File archivoABorrar = new File(dirFirmados + File.separator + nombreArchivoConRespuesta);
/* 207:248 */         if (archivoABorrar.exists() == true) {
/* 208:249 */           archivoABorrar.delete();
/* 209:    */         }
/* 210:252 */         item.setEstado(nombreArchivoConRespuesta + "|" + item.getEstado() + "|" + comprobantesProcesados);
/* 211:253 */         autorizaciones.add(item);
/* 212:    */       }
/* 213:    */     }
/* 214:    */     catch (Exception ex)
/* 215:    */     {
/* 216:    */       String dirAutorizados;
/* 217:    */       String dirRechazados;
/* 218:    */       String dirFirmados;
/* 219:    */       String comprobantesProcesados;
/* 220:258 */       Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/* 221:    */     }
/* 222:260 */     return autorizaciones;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public static String obtieneMensajesAutorizacion(Autorizacion autorizacion)
/* 226:    */   {
/* 227:271 */     StringBuilder mensaje = new StringBuilder();
/* 228:272 */     for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
/* 229:273 */       if (m.getInformacionAdicional() != null) {
/* 230:274 */         mensaje.append("\n" + m.getMensaje() + ": " + m.getInformacionAdicional());
/* 231:    */       } else {
/* 232:276 */         mensaje.append("\n" + m.getMensaje());
/* 233:    */       }
/* 234:    */     }
/* 235:280 */     return mensaje.toString();
/* 236:    */   }
/* 237:    */   
/* 238:    */   public static boolean verificarOCSP(Autorizacion autorizacion)
/* 239:    */     throws SQLException, ClassNotFoundException
/* 240:    */   {
/* 241:293 */     boolean respuesta = true;
/* 242:295 */     for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
/* 243:296 */       if (m.getIdentificador().equals("61"))
/* 244:    */       {
/* 245:297 */         int i = JOptionPane.showConfirmDialog(null, "No se puede validar el certificado digital.\n Desea emitir en contingencia?", "Advertencia", 0);
/* 246:298 */         if (i == 0)
/* 247:    */         {
/* 248:299 */           Emisor emisor = new EmisorSQL().obtenerDatosEmisor();
/* 249:300 */           FormGenerales.actualizaEmisor(TipoEmisionEnum.CONTINGENCIA.getCode(), emisor);
/* 250:    */         }
/* 251:302 */         respuesta = false;
/* 252:    */       }
/* 253:    */     }
/* 254:305 */     return respuesta;
/* 255:    */   }
/* 256:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.AutorizacionComprobantesWs
 * JD-Core Version:    0.7.0.1
 */