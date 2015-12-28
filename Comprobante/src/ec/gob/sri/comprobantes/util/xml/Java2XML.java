/*   1:    */ package ec.gob.sri.comprobantes.util.xml;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*   8:    */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
/*   9:    */ import java.io.FileOutputStream;
/*  10:    */ import java.io.OutputStreamWriter;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ import javax.xml.bind.JAXBContext;
/*  14:    */ import javax.xml.bind.Marshaller;
/*  15:    */ 
/*  16:    */ public class Java2XML
/*  17:    */ {
/*  18:    */   public static String marshalFactura(Factura comprobante, String pathArchivoSalida)
/*  19:    */   {
/*  20: 30 */     String respuesta = null;
/*  21:    */     try
/*  22:    */     {
/*  23: 33 */       JAXBContext context = JAXBContext.newInstance(new Class[] { Factura.class });
/*  24: 34 */       Marshaller marshaller = context.createMarshaller();
/*  25: 35 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  26: 36 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  27: 37 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  28: 38 */       marshaller.marshal(comprobante, out);
/*  29:    */     }
/*  30:    */     catch (Exception ex)
/*  31:    */     {
/*  32: 41 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  33: 42 */       return ex.getMessage();
/*  34:    */     }
/*  35: 44 */     return respuesta;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public static String marshalNotaDeDebito(NotaDebito comprobante, String pathArchivoSalida)
/*  39:    */   {
/*  40: 48 */     String respuesta = null;
/*  41:    */     try
/*  42:    */     {
/*  43: 51 */       JAXBContext context = JAXBContext.newInstance(new Class[] { NotaDebito.class });
/*  44: 52 */       Marshaller marshaller = context.createMarshaller();
/*  45: 53 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  46: 54 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  47: 55 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  48: 56 */       marshaller.marshal(comprobante, out);
/*  49:    */     }
/*  50:    */     catch (Exception ex)
/*  51:    */     {
/*  52: 58 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  53: 59 */       return ex.getMessage();
/*  54:    */     }
/*  55: 61 */     return respuesta;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public static String marshalNotaDeCredito(NotaCredito comprobante, String pathArchivoSalida)
/*  59:    */   {
/*  60: 65 */     String respuesta = null;
/*  61:    */     try
/*  62:    */     {
/*  63: 68 */       JAXBContext context = JAXBContext.newInstance(new Class[] { NotaCredito.class });
/*  64: 69 */       Marshaller marshaller = context.createMarshaller();
/*  65: 70 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  66: 71 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  67: 72 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  68: 73 */       marshaller.marshal(comprobante, out);
/*  69:    */     }
/*  70:    */     catch (Exception ex)
/*  71:    */     {
/*  72: 75 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  73: 76 */       return ex.getMessage();
/*  74:    */     }
/*  75: 78 */     return respuesta;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public static String marshalComprobanteRetencion(ComprobanteRetencion comprobante, String pathArchivoSalida)
/*  79:    */   {
/*  80: 82 */     String respuesta = null;
/*  81:    */     try
/*  82:    */     {
/*  83: 84 */       JAXBContext context = JAXBContext.newInstance(new Class[] { ComprobanteRetencion.class });
/*  84: 85 */       Marshaller marshaller = context.createMarshaller();
/*  85: 86 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  86: 87 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  87: 88 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  88: 89 */       marshaller.marshal(comprobante, out);
/*  89:    */     }
/*  90:    */     catch (Exception ex)
/*  91:    */     {
/*  92: 91 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  93: 92 */       return ex.getMessage();
/*  94:    */     }
/*  95: 94 */     return respuesta;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public static String marshalGuiaRemision(GuiaRemision comprobante, String pathArchivoSalida)
/*  99:    */   {
/* 100: 98 */     String respuesta = null;
/* 101:    */     try
/* 102:    */     {
/* 103:101 */       JAXBContext context = JAXBContext.newInstance(new Class[] { GuiaRemision.class });
/* 104:102 */       Marshaller marshaller = context.createMarshaller();
/* 105:103 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/* 106:104 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/* 107:105 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/* 108:106 */       marshaller.marshal(comprobante, out);
/* 109:    */     }
/* 110:    */     catch (Exception ex)
/* 111:    */     {
/* 112:108 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/* 113:109 */       return ex.getMessage();
/* 114:    */     }
/* 115:111 */     return respuesta;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public static String marshalRespuestaSolicitud(RespuestaSolicitud respuesta, String pathArchivoSalida)
/* 119:    */   {
/* 120:    */     try
/* 121:    */     {
/* 122:118 */       JAXBContext context = JAXBContext.newInstance(new Class[] { RespuestaSolicitud.class });
/* 123:119 */       Marshaller marshaller = context.createMarshaller();
/* 124:120 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/* 125:121 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/* 126:122 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/* 127:123 */       marshaller.marshal(respuesta, out);
/* 128:    */     }
/* 129:    */     catch (Exception ex)
/* 130:    */     {
/* 131:125 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/* 132:126 */       return ex.getMessage();
/* 133:    */     }
/* 134:128 */     return null;
/* 135:    */   }
/* 136:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.Java2XML
 * JD-Core Version:    0.7.0.1
 */