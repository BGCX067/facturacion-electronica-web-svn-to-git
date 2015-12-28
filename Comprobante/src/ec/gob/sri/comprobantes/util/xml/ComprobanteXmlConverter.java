/*  1:   */ package ec.gob.sri.comprobantes.util.xml;
/*  2:   */ 
/*  3:   */ import com.thoughtworks.xstream.converters.Converter;
/*  4:   */ import com.thoughtworks.xstream.converters.MarshallingContext;
/*  5:   */ import com.thoughtworks.xstream.converters.UnmarshallingContext;
/*  6:   */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*  7:   */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*  8:   */ import ec.gob.sri.comprobantes.modelo.ComprobanteXml;
/*  9:   */ 
/* 10:   */ public class ComprobanteXmlConverter
/* 11:   */   implements Converter
/* 12:   */ {
/* 13:   */   public boolean canConvert(Class clazz)
/* 14:   */   {
/* 15:24 */     return clazz.equals(ComprobanteXml.class);
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc)
/* 19:   */   {
/* 20:28 */     ComprobanteXml i = (ComprobanteXml)o;
/* 21:   */     
/* 22:   */ 
/* 23:   */ 
/* 24:32 */     writer.setValue(i.getFileXML());
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc)
/* 28:   */   {
/* 29:36 */     ComprobanteXml item = new ComprobanteXml();
/* 30:37 */     item.setTipo(reader.getAttribute("tipo"));
/* 31:38 */     item.setVersion(reader.getAttribute("version"));
/* 32:39 */     item.setFileXML(reader.getValue());
/* 33:   */     
/* 34:41 */     return item;
/* 35:   */   }
/* 36:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.ComprobanteXmlConverter
 * JD-Core Version:    0.7.0.1
 */