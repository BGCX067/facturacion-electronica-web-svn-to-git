/*  1:   */ package ec.gob.sri.comprobantes.util.xml;
/*  2:   */ 
/*  3:   */ import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
/*  4:   */ import com.thoughtworks.xstream.converters.Converter;
/*  5:   */ import com.thoughtworks.xstream.converters.MarshallingContext;
/*  6:   */ import com.thoughtworks.xstream.converters.UnmarshallingContext;
/*  7:   */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*  8:   */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*  9:   */ import ec.gob.sri.comprobantes.util.Constantes;
/* 10:   */ import java.text.ParseException;
/* 11:   */ import java.text.SimpleDateFormat;
/* 12:   */ import java.util.Date;
/* 13:   */ import java.util.GregorianCalendar;
/* 14:   */ import java.util.logging.Level;
/* 15:   */ import java.util.logging.Logger;
/* 16:   */ 
/* 17:   */ public class RespuestaDateConverter
/* 18:   */   implements Converter
/* 19:   */ {
/* 20:   */   public boolean canConvert(Class clazz)
/* 21:   */   {
/* 22:30 */     return clazz.equals(XMLGregorianCalendarImpl.class);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc)
/* 26:   */   {
/* 27:34 */     XMLGregorianCalendarImpl i = (XMLGregorianCalendarImpl)o;
/* 28:35 */     writer.setValue(Constantes.dateTimeFormat.format(i.toGregorianCalendar().getTime()));
/* 29:   */   }
/* 30:   */   
/* 31:   */   public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc)
/* 32:   */   {
/* 33:40 */     Date date = null;
/* 34:   */     try
/* 35:   */     {
/* 36:42 */       date = Constantes.dateTimeFormat.parse(reader.getValue());
/* 37:   */     }
/* 38:   */     catch (ParseException ex)
/* 39:   */     {
/* 40:44 */       Logger.getLogger(RespuestaDateConverter.class.getName()).log(Level.SEVERE, null, ex);
/* 41:   */     }
/* 42:46 */     GregorianCalendar cal = new GregorianCalendar();
/* 43:47 */     cal.setTime(date);
/* 44:48 */     XMLGregorianCalendarImpl item = new XMLGregorianCalendarImpl(cal);
/* 45:   */     
/* 46:50 */     return item;
/* 47:   */   }
/* 48:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.RespuestaDateConverter
 * JD-Core Version:    0.7.0.1
 */