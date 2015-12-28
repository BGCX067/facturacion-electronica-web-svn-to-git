/*  1:   */ package ec.gob.sri.comprobantes.util.xml;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*  4:   */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*  5:   */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*  6:   */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*  7:   */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*  8:   */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
/*  9:   */ import java.io.FileInputStream;
/* 10:   */ import java.io.FileReader;
/* 11:   */ import java.io.InputStreamReader;
/* 12:   */ import javax.xml.bind.JAXBContext;
/* 13:   */ import javax.xml.bind.Unmarshaller;
/* 14:   */ 
/* 15:   */ public class XML2Java
/* 16:   */ {
/* 17:   */   public static Factura unmarshalFactura(String pathArchivo)
/* 18:   */     throws Exception
/* 19:   */   {
/* 20:30 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.factura");
/* 21:   */     
/* 22:32 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 23:   */     
/* 24:34 */     Factura item = (Factura)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/* 25:35 */     return item;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public static NotaDebito unmarshalNotaDebito(String pathArchivo)
/* 29:   */     throws Exception
/* 30:   */   {
/* 31:40 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notadebito");
/* 32:   */     
/* 33:42 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 34:   */     
/* 35:44 */     NotaDebito item = (NotaDebito)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/* 36:45 */     return item;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public static NotaCredito unmarshalNotaCredito(String pathArchivo)
/* 40:   */     throws Exception
/* 41:   */   {
/* 42:50 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.notacredito");
/* 43:   */     
/* 44:52 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 45:   */     
/* 46:54 */     NotaCredito item = (NotaCredito)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/* 47:   */     
/* 48:   */ 
/* 49:57 */     return item;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public static GuiaRemision unmarshalGuiaRemision(String pathArchivo)
/* 53:   */     throws Exception
/* 54:   */   {
/* 55:62 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.guia");
/* 56:   */     
/* 57:64 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 58:   */     
/* 59:66 */     GuiaRemision item = (GuiaRemision)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/* 60:   */     
/* 61:   */ 
/* 62:69 */     return item;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public static ComprobanteRetencion unmarshalComprobanteRetencion(String pathArchivo)
/* 66:   */     throws Exception
/* 67:   */   {
/* 68:74 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.modelo.rentencion");
/* 69:   */     
/* 70:76 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 71:   */     
/* 72:78 */     ComprobanteRetencion item = (ComprobanteRetencion)unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(pathArchivo), "UTF-8"));
/* 73:79 */     return item;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public static Autorizacion unmarshalAutorizacion(String pathArchivo)
/* 77:   */     throws Exception
/* 78:   */   {
/* 79:84 */     JAXBContext context = JAXBContext.newInstance("ec.gob.sri.comprobantes.ws.aut.Autorizacion");
/* 80:   */     
/* 81:86 */     Unmarshaller unmarshaller = context.createUnmarshaller();
/* 82:87 */     Autorizacion item = (Autorizacion)unmarshaller.unmarshal(new FileReader(pathArchivo));
/* 83:   */     
/* 84:89 */     return item;
/* 85:   */   }
/* 86:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.XML2Java
 * JD-Core Version:    0.7.0.1
 */