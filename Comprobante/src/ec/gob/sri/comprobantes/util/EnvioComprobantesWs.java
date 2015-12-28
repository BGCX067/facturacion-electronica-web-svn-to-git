/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.Respuesta;
/*   4:    */ import ec.gob.sri.comprobantes.sql.RespuestaSQL;
/*   5:    */ import ec.gob.sri.comprobantes.ws.Comprobante;
/*   6:    */ import ec.gob.sri.comprobantes.ws.Comprobante.Mensajes;
/*   7:    */ import ec.gob.sri.comprobantes.ws.Mensaje;
/*   8:    */ import ec.gob.sri.comprobantes.ws.RecepcionComprobantes;
/*   9:    */ import ec.gob.sri.comprobantes.ws.RecepcionComprobantesService;
/*  10:    */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
/*  11:    */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud.Comprobantes;
/*  12:    */ import java.io.File;
/*  13:    */ import java.net.MalformedURLException;
/*  14:    */ import java.net.URL;
/*  15:    */ import java.util.logging.Level;
/*  16:    */ import java.util.logging.Logger;
/*  17:    */ import javax.xml.namespace.QName;
/*  18:    */ import javax.xml.ws.WebServiceException;
/*  19:    */ 
/*  20:    */ public class EnvioComprobantesWs
/*  21:    */ {
/*  22:    */   private static RecepcionComprobantesService service;
/*  23:    */   private static final String VERSION = "1.0.0";
/*  24:    */   public static final String ESTADO_RECIBIDA = "RECIBIDA";
/*  25:    */   public static final String ESTADO_DEVUELTA = "DEVUELTA";
/*  26:    */   
/*  27:    */   public EnvioComprobantesWs(String wsdlLocation)
/*  28:    */     throws MalformedURLException, WebServiceException
/*  29:    */   {
/*  30: 38 */     URL url = new URL(wsdlLocation);
/*  31: 39 */     QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
/*  32: 40 */     service = new RecepcionComprobantesService(url, qname);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public static final Object webService(String wsdlLocation)
/*  36:    */   {
/*  37:    */     try
/*  38:    */     {
/*  39: 45 */       QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
/*  40: 46 */       URL url = new URL(wsdlLocation);
/*  41: 47 */       service = new RecepcionComprobantesService(url, qname);
/*  42: 48 */       return null;
/*  43:    */     }
/*  44:    */     catch (MalformedURLException ex)
/*  45:    */     {
/*  46: 50 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/*  47: 51 */       return ex;
/*  48:    */     }
/*  49:    */     catch (WebServiceException ws)
/*  50:    */     {
/*  51: 53 */       return ws;
/*  52:    */     }
/*  53:    */   }
/*  54:    */   
/*  55:    */   public RespuestaSolicitud enviarComprobante(String ruc, File xmlFile, String tipoComprobante, String versionXsd)
/*  56:    */   {
/*  57: 69 */     RespuestaSolicitud response = null;
/*  58:    */     try
/*  59:    */     {
/*  60: 71 */       RecepcionComprobantes port = service.getRecepcionComprobantesPort();
/*  61: 72 */       response = port.validarComprobante(ArchivoUtils.archivoToByte(xmlFile));
/*  62:    */     }
/*  63:    */     catch (Exception e)
/*  64:    */     {
/*  65: 75 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
/*  66: 76 */       response = new RespuestaSolicitud();
/*  67: 77 */       response.setEstado(e.getMessage());
/*  68: 78 */       return response;
/*  69:    */     }
/*  70: 81 */     return response;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public RespuestaSolicitud enviarComprobanteLotes(String ruc, byte[] xml, String tipoComprobante, String versionXsd)
/*  74:    */   {
/*  75: 96 */     RespuestaSolicitud response = null;
/*  76:    */     try
/*  77:    */     {
/*  78: 98 */       RecepcionComprobantes port = service.getRecepcionComprobantesPort();
/*  79:    */       
/*  80:100 */       response = port.validarComprobante(xml);
/*  81:    */     }
/*  82:    */     catch (Exception e)
/*  83:    */     {
/*  84:103 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
/*  85:104 */       response = new RespuestaSolicitud();
/*  86:105 */       response.setEstado(e.getMessage());
/*  87:106 */       return response;
/*  88:    */     }
/*  89:108 */     return response;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public RespuestaSolicitud enviarComprobanteLotes(String ruc, File xml, String tipoComprobante, String versionXsd)
/*  93:    */   {
/*  94:123 */     RespuestaSolicitud response = null;
/*  95:    */     try
/*  96:    */     {
/*  97:125 */       RecepcionComprobantes port = service.getRecepcionComprobantesPort();
/*  98:126 */       response = port.validarComprobante(ArchivoUtils.archivoToByte(xml));
/*  99:    */     }
/* 100:    */     catch (Exception e)
/* 101:    */     {
/* 102:128 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
/* 103:129 */       response = new RespuestaSolicitud();
/* 104:130 */       response.setEstado(e.getMessage());
/* 105:131 */       return response;
/* 106:    */     }
/* 107:133 */     return response;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public static RespuestaSolicitud obtenerRespuestaEnvio(File archivo, String ruc, String tipoComprobante, String claveDeAcceso, String urlWsdl)
/* 111:    */   {
/* 112:145 */     RespuestaSolicitud respuesta = new RespuestaSolicitud();
/* 113:146 */     EnvioComprobantesWs cliente = null;
/* 114:    */     try
/* 115:    */     {
/* 116:148 */       cliente = new EnvioComprobantesWs(urlWsdl);
/* 117:    */     }
/* 118:    */     catch (Exception ex)
/* 119:    */     {
/* 120:150 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/* 121:151 */       respuesta.setEstado(ex.getMessage());
/* 122:152 */       return respuesta;
/* 123:    */     }
/* 124:154 */     respuesta = cliente.enviarComprobante(ruc, archivo, tipoComprobante, "1.0.0");
/* 125:    */     
/* 126:156 */     return respuesta;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public static void guardarRespuesta(String claveDeAcceso, String archivo, String estado, java.util.Date fecha)
/* 130:    */   {
/* 131:    */     try
/* 132:    */     {
/* 133:170 */       java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
/* 134:    */       
/* 135:172 */       Respuesta item = new Respuesta(null, claveDeAcceso, archivo, estado, sqlDate);
/* 136:173 */       RespuestaSQL resp = new RespuestaSQL();
/* 137:174 */       resp.insertarRespuesta(item);
/* 138:    */     }
/* 139:    */     catch (Exception ex)
/* 140:    */     {
/* 141:177 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/* 142:    */     }
/* 143:    */   }
/* 144:    */   
/* 145:    */   public static String obtenerMensajeRespuesta(RespuestaSolicitud respuesta)
/* 146:    */   {
/* 147:189 */     StringBuilder mensajeDesplegable = new StringBuilder();
/* 148:190 */     if (respuesta.getEstado().equals("DEVUELTA") == true)
/* 149:    */     {
/* 150:192 */       RespuestaSolicitud.Comprobantes comprobantes = respuesta.getComprobantes();
/* 151:193 */       for (Comprobante comp : comprobantes.getComprobante())
/* 152:    */       {
/* 153:194 */         mensajeDesplegable.append(comp.getClaveAcceso());
/* 154:195 */         mensajeDesplegable.append("\n");
/* 155:196 */         for (Mensaje m : comp.getMensajes().getMensaje())
/* 156:    */         {
/* 157:197 */           mensajeDesplegable.append(m.getMensaje()).append(" :\n");
/* 158:198 */           mensajeDesplegable.append(m.getInformacionAdicional() != null ? m.getInformacionAdicional() : "");
/* 159:199 */           mensajeDesplegable.append("\n");
/* 160:    */         }
/* 161:201 */         mensajeDesplegable.append("\n");
/* 162:    */       }
/* 163:    */     }
/* 164:205 */     return mensajeDesplegable.toString();
/* 165:    */   }
/* 166:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.EnvioComprobantesWs
 * JD-Core Version:    0.7.0.1
 */