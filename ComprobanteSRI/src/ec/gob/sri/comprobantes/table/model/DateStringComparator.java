/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.text.ParseException;
/*  4:   */ import java.text.SimpleDateFormat;
/*  5:   */ import java.util.Comparator;
/*  6:   */ import java.util.Date;
/*  7:   */ import java.util.logging.Level;
/*  8:   */ import java.util.logging.Logger;
/*  9:   */ 
/* 10:   */ public class DateStringComparator
/* 11:   */   implements Comparator<String>
/* 12:   */ {
/* 13:   */   public int compare(String strDate1, String strDate2)
/* 14:   */   {
/* 15:23 */     int result = 0;
/* 16:   */     
/* 17:25 */     SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
/* 18:26 */     SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
/* 19:   */     try
/* 20:   */     {
/* 21:29 */       if ((strDate1 != null) && (strDate2 != null))
/* 22:   */       {
/* 23:30 */         if (strDate1.length() <= 11) {
/* 24:31 */           dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
/* 25:   */         }
/* 26:33 */         if (strDate2.length() <= 11) {
/* 27:34 */           dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
/* 28:   */         }
/* 29:36 */         Date date1 = dateFormat1.parse(strDate1);
/* 30:37 */         Date date2 = dateFormat2.parse(strDate2);
/* 31:   */         
/* 32:39 */         result = date1.compareTo(date2);
/* 33:   */       }
/* 34:   */     }
/* 35:   */     catch (ParseException ex)
/* 36:   */     {
/* 37:43 */       Logger.getLogger(DateStringComparator.class.getName()).log(Level.SEVERE, null, ex);
/* 38:   */     }
/* 39:46 */     return result;
/* 40:   */   }
/* 41:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.DateStringComparator
 * JD-Core Version:    0.7.0.1
 */