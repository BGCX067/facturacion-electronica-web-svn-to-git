/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ import javax.swing.text.AttributeSet;
/*  4:   */ import javax.swing.text.BadLocationException;
/*  5:   */ import javax.swing.text.DocumentFilter;
/*  6:   */ import javax.swing.text.DocumentFilter.FilterBypass;
/*  7:   */ 
/*  8:   */ public class ConvertirMinusculas
/*  9:   */   extends DocumentFilter
/* 10:   */ {
/* 11:   */   public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr)
/* 12:   */     throws BadLocationException
/* 13:   */   {
/* 14:19 */     fb.insertString(offset, text.toUpperCase(), attr);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
/* 18:   */     throws BadLocationException
/* 19:   */   {
/* 20:24 */     fb.replace(offset, length, text.toLowerCase(), attrs);
/* 21:   */   }
/* 22:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ConvertirMinusculas
 * JD-Core Version:    0.7.0.1
 */