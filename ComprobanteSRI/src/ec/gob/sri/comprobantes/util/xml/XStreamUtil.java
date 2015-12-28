/*   1:    */ package ec.gob.sri.comprobantes.util.xml;
/*   2:    */ 
/*   3:    */ import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
/*   4:    */ import com.thoughtworks.xstream.XStream;
/*   5:    */ import com.thoughtworks.xstream.core.util.QuickWriter;
/*   6:    */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*   7:    */ import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
/*   8:    */ import com.thoughtworks.xstream.io.xml.XppDriver;
/*   9:    */ import ec.gob.sri.comprobantes.modelo.ComprobanteXml;
/*  10:    */ import ec.gob.sri.comprobantes.modelo.LoteXml;
/*  11:    */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
/*  12:    */ import ec.gob.sri.comprobantes.ws.aut.Mensaje;
/*  13:    */ import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;
/*  14:    */ import ec.gob.sri.comprobantes.ws.aut.RespuestaLote;
/*  15:    */ import java.io.Writer;
/*  16:    */ 
/*  17:    */ public class XStreamUtil
/*  18:    */ {
/*  19:    */   public static XStream getLoteXStream()
/*  20:    */   {
/*  21: 35 */     XStream xstream = new XStream(new XppDriver()
/*  22:    */     {
/*  23:    */       public HierarchicalStreamWriter createWriter(Writer out)
/*  24:    */       {
/*  25: 40 */         new PrettyPrintWriter(out)
/*  26:    */         {
/*  27:    */           protected void writeText(QuickWriter writer, String text)
/*  28:    */           {
/*  29: 44 */             writer.write(text);
/*  30:    */           }
/*  31:    */         };
/*  32:    */       }
/*  33: 49 */     });
/*  34: 50 */     xstream.alias("lote", LoteXml.class);
/*  35: 51 */     xstream.alias("comprobante", ComprobanteXml.class);
/*  36:    */     
/*  37:    */ 
/*  38: 54 */     xstream.registerConverter(new ComprobanteXmlConverter());
/*  39:    */     
/*  40: 56 */     return xstream;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public static XStream getRespuestaXStream()
/*  44:    */   {
/*  45: 66 */     XStream xstream = new XStream(new XppDriver()
/*  46:    */     {
/*  47:    */       public HierarchicalStreamWriter createWriter(Writer out)
/*  48:    */       {
/*  49: 71 */         new PrettyPrintWriter(out)
/*  50:    */         {
/*  51:    */           protected void writeText(QuickWriter writer, String text)
/*  52:    */           {
/*  53: 75 */             writer.write(text);
/*  54:    */           }
/*  55:    */         };
/*  56:    */       }
/*  57: 80 */     });
/*  58: 81 */     xstream.alias("respuesta", RespuestaComprobante.class);
/*  59: 82 */     xstream.alias("autorizacion", Autorizacion.class);
/*  60: 83 */     xstream.alias("fechaAutorizacion", XMLGregorianCalendarImpl.class);
/*  61: 84 */     xstream.alias("mensaje", Mensaje.class);
/*  62: 85 */     xstream.registerConverter(new RespuestaDateConverter());
/*  63:    */     
/*  64: 87 */     return xstream;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public static XStream getRespuestaLoteXStream()
/*  68:    */   {
/*  69: 97 */     XStream xstream = new XStream(new XppDriver()
/*  70:    */     {
/*  71:    */       public HierarchicalStreamWriter createWriter(Writer out)
/*  72:    */       {
/*  73:102 */         new PrettyPrintWriter(out)
/*  74:    */         {
/*  75:    */           protected void writeText(QuickWriter writer, String text)
/*  76:    */           {
/*  77:106 */             writer.write(text);
/*  78:    */           }
/*  79:    */         };
/*  80:    */       }
/*  81:111 */     });
/*  82:112 */     xstream.alias("respuesta", RespuestaLote.class);
/*  83:113 */     xstream.alias("autorizacion", Autorizacion.class);
/*  84:114 */     xstream.alias("fechaAutorizacion", XMLGregorianCalendarImpl.class);
/*  85:115 */     xstream.alias("mensaje", Mensaje.class);
/*  86:116 */     xstream.registerConverter(new RespuestaDateConverter());
/*  87:    */     
/*  88:118 */     return xstream;
/*  89:    */   }
/*  90:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.XStreamUtil
 * JD-Core Version:    0.7.0.1
 */