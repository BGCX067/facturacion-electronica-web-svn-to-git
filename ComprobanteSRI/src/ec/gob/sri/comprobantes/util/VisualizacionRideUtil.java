/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*   8:    */ import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
/*   9:    */ import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
/*  10:    */ import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
/*  11:    */ import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
/*  12:    */ import ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte;
/*  13:    */ import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
/*  14:    */ import ec.gob.sri.comprobantes.util.xml.XML2Java;
/*  15:    */ import java.io.File;
/*  16:    */ import java.io.PrintStream;
/*  17:    */ import java.sql.SQLException;
/*  18:    */ import java.util.logging.Level;
/*  19:    */ import java.util.logging.Logger;
/*  20:    */ import javax.swing.JOptionPane;
/*  21:    */ import javax.swing.JPanel;
/*  22:    */ import javax.xml.parsers.DocumentBuilder;
/*  23:    */ import javax.xml.parsers.DocumentBuilderFactory;
/*  24:    */ import org.w3c.dom.Document;
/*  25:    */ import org.w3c.dom.Element;
/*  26:    */ import org.w3c.dom.Node;
/*  27:    */ import org.w3c.dom.NodeList;
/*  28:    */ 
/*  29:    */ public class VisualizacionRideUtil
/*  30:    */ {
/*  31:    */   private static final String ESTADO = "AUTORIZADO";
/*  32:    */   
/*  33:    */   public static void decodeArchivoBase64(String nombreArch, String numeroAutorizacion, String fechaAut)
/*  34:    */   {
/*  35:    */     try
/*  36:    */     {
/*  37: 39 */       File file = new File(nombreArch);
/*  38: 40 */       if (file.exists())
/*  39:    */       {
/*  40: 41 */         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
/*  41:    */         
/*  42:    */ 
/*  43: 44 */         DocumentBuilder builder = factory.newDocumentBuilder();
/*  44: 45 */         Document doc = builder.parse(file);
/*  45: 46 */         NodeList list = doc.getElementsByTagName("*");
/*  46: 47 */         String docu = null;
/*  47: 48 */         String numeroAut = "";
/*  48: 49 */         String fechaAutorizacion = "";
/*  49: 50 */         String estado = "";
/*  50: 51 */         for (int i = 0; i < list.getLength(); i++)
/*  51:    */         {
/*  52: 52 */           Element element = (Element)list.item(i);
/*  53: 53 */           if (element.getNodeName().equals("comprobante")) {
/*  54: 54 */             docu = element.getChildNodes().item(0).getNodeValue();
/*  55:    */           }
/*  56: 56 */           if (element.getNodeName().equals("estado")) {
/*  57: 57 */             estado = element.getChildNodes().item(0).getNodeValue();
/*  58:    */           }
/*  59: 59 */           if ((numeroAutorizacion == null) && (fechaAut == null))
/*  60:    */           {
/*  61: 60 */             if (element.getNodeName().equals("numeroAutorizacion")) {
/*  62: 61 */               numeroAut = element.getChildNodes().item(0).getNodeValue();
/*  63:    */             }
/*  64: 63 */             if (element.getNodeName().equals("fechaAutorizacion")) {
/*  65: 64 */               fechaAutorizacion = fechaAutorizacion + element.getChildNodes().item(0).getNodeValue();
/*  66:    */             }
/*  67:    */           }
/*  68:    */         }
/*  69: 68 */         if ((fechaAut == null) && (numeroAutorizacion == null))
/*  70:    */         {
/*  71: 69 */           fechaAut = fechaAutorizacion;
/*  72: 70 */           numeroAutorizacion = numeroAut;
/*  73:    */         }
/*  74: 72 */         if ("AUTORIZADO".equalsIgnoreCase(estado)) {
/*  75: 73 */           generar(docu, numeroAutorizacion, fechaAut);
/*  76:    */         } else {
/*  77: 75 */           JOptionPane.showMessageDialog(new JPanel(), "El archivo seleccionado no es un comprobante autorizado.", "ERROR", 0);
/*  78:    */         }
/*  79:    */       }
/*  80:    */       else
/*  81:    */       {
/*  82: 78 */         Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.INFO, "No existe archivo");
/*  83:    */       }
/*  84:    */     }
/*  85:    */     catch (Exception e)
/*  86:    */     {
/*  87: 81 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, e);
/*  88:    */     }
/*  89:    */   }
/*  90:    */   
/*  91:    */   private static void generar(String docu, String numeroAutorizacion, String fechaAut)
/*  92:    */   {
/*  93: 87 */     if (docu != null)
/*  94:    */     {
/*  95: 88 */       File c = ArchivoUtils.stringToArchivo("factura.xml", docu);
/*  96: 89 */       if (obtenerTipoComprobante(docu).equals("FA")) {
/*  97:    */         try
/*  98:    */         {
/*  99: 91 */           Factura f = XML2Java.unmarshalFactura(c.getPath());
/* 100: 92 */           FacturaReporte fr = new FacturaReporte(f);
/* 101: 93 */           generarReporte(fr, numeroAutorizacion, fechaAut);
/* 102:    */         }
/* 103:    */         catch (Exception ex)
/* 104:    */         {
/* 105: 96 */           Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 106:    */         }
/* 107:    */       }
/* 108: 99 */       if (obtenerTipoComprobante(docu).equals("ND")) {
/* 109:    */         try
/* 110:    */         {
/* 111:101 */           NotaDebito nd = XML2Java.unmarshalNotaDebito(c.getPath());
/* 112:102 */           NotaDebitoReporte ndR = new NotaDebitoReporte(nd);
/* 113:103 */           generarReporte(ndR, numeroAutorizacion, fechaAut);
/* 114:    */         }
/* 115:    */         catch (Exception ex)
/* 116:    */         {
/* 117:105 */           Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 118:    */         }
/* 119:    */       }
/* 120:108 */       if (obtenerTipoComprobante(docu).equals("NC")) {
/* 121:    */         try
/* 122:    */         {
/* 123:110 */           NotaCredito nd = XML2Java.unmarshalNotaCredito(c.getPath());
/* 124:111 */           NotaCreditoReporte ndR = new NotaCreditoReporte(nd);
/* 125:112 */           generarReporte(ndR, numeroAutorizacion, fechaAut);
/* 126:    */         }
/* 127:    */         catch (Exception ex)
/* 128:    */         {
/* 129:114 */           Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 130:    */         }
/* 131:    */       }
/* 132:118 */       if (obtenerTipoComprobante(docu).equals("CR")) {
/* 133:    */         try
/* 134:    */         {
/* 135:120 */           ComprobanteRetencion nd = XML2Java.unmarshalComprobanteRetencion(c.getPath());
/* 136:121 */           ComprobanteRetencionReporte ndR = new ComprobanteRetencionReporte(nd);
/* 137:122 */           generarReporte(ndR, numeroAutorizacion, fechaAut);
/* 138:    */         }
/* 139:    */         catch (Exception ex)
/* 140:    */         {
/* 141:124 */           Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 142:    */         }
/* 143:    */       }
/* 144:127 */       if (obtenerTipoComprobante(docu).equals("GR")) {
/* 145:    */         try
/* 146:    */         {
/* 147:129 */           GuiaRemision gr = XML2Java.unmarshalGuiaRemision(c.getPath());
/* 148:130 */           GuiaRemisionReporte grr = new GuiaRemisionReporte(gr);
/* 149:131 */           generarReporte(grr, numeroAutorizacion, fechaAut, gr);
/* 150:    */         }
/* 151:    */         catch (Exception ex)
/* 152:    */         {
/* 153:133 */           Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 154:    */         }
/* 155:    */       }
/* 156:    */     }
/* 157:    */     else
/* 158:    */     {
/* 159:137 */       JOptionPane.showMessageDialog(new JPanel(), "El archivo seleccionado no es un comprobante autorizado.", "ERROR", 0);
/* 160:    */     }
/* 161:    */   }
/* 162:    */   
/* 163:    */   private static String obtenerTipoComprobante(String docu)
/* 164:    */   {
/* 165:142 */     if (docu.contains("<factura")) {
/* 166:143 */       return "FA";
/* 167:    */     }
/* 168:145 */     if (docu.contains("<comprobanteRetencion")) {
/* 169:146 */       return "CR";
/* 170:    */     }
/* 171:148 */     if (docu.contains("<notaCredito")) {
/* 172:149 */       return "NC";
/* 173:    */     }
/* 174:151 */     if (docu.contains("<notaDebito")) {
/* 175:152 */       return "ND";
/* 176:    */     }
/* 177:154 */     if (docu.contains("<guiaRemision")) {
/* 178:155 */       return "GR";
/* 179:    */     }
/* 180:157 */     return null;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public static void generarReporte(FacturaReporte xml, String numAut, String fechaAut)
/* 184:    */   {
/* 185:161 */     ReporteUtil repUtil = new ReporteUtil();
/* 186:    */     try
/* 187:    */     {
/* 188:163 */       repUtil.generarReporte("resources/reportes/factura.jasper", xml, numAut, fechaAut);
/* 189:    */     }
/* 190:    */     catch (SQLException ex)
/* 191:    */     {
/* 192:165 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 193:    */     }
/* 194:    */     catch (ClassNotFoundException ex)
/* 195:    */     {
/* 196:167 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 197:    */     }
/* 198:    */   }
/* 199:    */   
/* 200:    */   public static void generarReporte(NotaCreditoReporte xml, String numAut, String fechaAut)
/* 201:    */   {
/* 202:172 */     ReporteUtil repUtil = new ReporteUtil();
/* 203:    */     try
/* 204:    */     {
/* 205:174 */       repUtil.generarReporte("resources/reportes/notaCreditoFinal.jasper", xml, numAut, fechaAut);
/* 206:    */     }
/* 207:    */     catch (SQLException ex)
/* 208:    */     {
/* 209:176 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 210:    */     }
/* 211:    */     catch (ClassNotFoundException ex)
/* 212:    */     {
/* 213:178 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 214:    */     }
/* 215:    */   }
/* 216:    */   
/* 217:    */   public static void generarReporte(NotaDebitoReporte xml, String numAut, String fechaAut)
/* 218:    */   {
/* 219:183 */     ReporteUtil repUtil = new ReporteUtil();
/* 220:    */     try
/* 221:    */     {
/* 222:185 */       repUtil.generarReporte("resources/reportes/notaDebitoFinal.jasper", xml, numAut, fechaAut);
/* 223:    */     }
/* 224:    */     catch (SQLException ex)
/* 225:    */     {
/* 226:187 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 227:    */     }
/* 228:    */     catch (ClassNotFoundException ex)
/* 229:    */     {
/* 230:189 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 231:    */     }
/* 232:    */   }
/* 233:    */   
/* 234:    */   public static void generarReporte(ComprobanteRetencionReporte xml, String numAut, String fechaAut)
/* 235:    */   {
/* 236:194 */     ReporteUtil repUtil = new ReporteUtil();
/* 237:    */     try
/* 238:    */     {
/* 239:196 */       repUtil.generarReporte("resources/reportes/comprobanteRetencion.jasper", xml, numAut, fechaAut);
/* 240:    */     }
/* 241:    */     catch (SQLException ex)
/* 242:    */     {
/* 243:198 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 244:    */     }
/* 245:    */     catch (ClassNotFoundException ex)
/* 246:    */     {
/* 247:200 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 248:    */     }
/* 249:    */   }
/* 250:    */   
/* 251:    */   public static void generarReporte(GuiaRemisionReporte xml, String numAut, String fechaAut, GuiaRemision gr)
/* 252:    */   {
/* 253:204 */     System.out.println("GUIA REMISION");
/* 254:205 */     ReporteUtil repUtil = new ReporteUtil();
/* 255:    */     try
/* 256:    */     {
/* 257:207 */       repUtil.generarReporte("resources/reportes/guiaRemisionFinal.jasper", xml, numAut, fechaAut, gr);
/* 258:    */     }
/* 259:    */     catch (SQLException ex)
/* 260:    */     {
/* 261:209 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 262:    */     }
/* 263:    */     catch (ClassNotFoundException ex)
/* 264:    */     {
/* 265:211 */       Logger.getLogger(VisualizacionRideUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 266:    */     }
/* 267:    */   }
/* 268:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.VisualizacionRideUtil
 * JD-Core Version:    0.7.0.1
 */