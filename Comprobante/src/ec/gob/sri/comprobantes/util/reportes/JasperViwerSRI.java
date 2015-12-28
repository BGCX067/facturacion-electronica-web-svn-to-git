/*  1:   */ package ec.gob.sri.comprobantes.util.reportes;
/*  2:   */ 
/*  3:   */ import java.awt.event.ActionEvent;
/*  4:   */ import java.io.InputStream;
/*  5:   */ import java.util.Locale;
/*  6:   */ import java.util.ResourceBundle;
/*  7:   */ import net.sf.jasperreports.engine.JRException;
/*  8:   */ import net.sf.jasperreports.engine.JasperPrint;
/*  9:   */ import net.sf.jasperreports.view.JRViewer;
/* 10:   */ 
/* 11:   */ public class JasperViwerSRI
/* 12:   */   extends JRViewer
/* 13:   */ {
/* 14:   */   public JasperViwerSRI(JasperPrint jrPrint)
/* 15:   */   {
/* 16:22 */     super(jrPrint);
/* 17:   */   }
/* 18:   */   
/* 19:   */   public JasperViwerSRI(JasperPrint jrPrint, Locale locale)
/* 20:   */   {
/* 21:26 */     super(jrPrint, locale);
/* 22:   */   }
/* 23:   */   
/* 24:   */   public JasperViwerSRI(InputStream is, boolean isXML)
/* 25:   */     throws JRException
/* 26:   */   {
/* 27:31 */     super(is, isXML);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public JasperViwerSRI(String fileName, boolean isXML, Locale locale)
/* 31:   */     throws JRException
/* 32:   */   {
/* 33:35 */     super(fileName, isXML, locale);
/* 34:   */   }
/* 35:   */   
/* 36:   */   public JasperViwerSRI(JasperPrint jrPrint, Locale locale, ResourceBundle resBundle)
/* 37:   */   {
/* 38:39 */     super(jrPrint, locale, resBundle);
/* 39:   */   }
/* 40:   */   
/* 41:   */   void btnNextActionPerformed(ActionEvent evt)
/* 42:   */   {
/* 43:44 */     throw new RuntimeException("Compiled Code");
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.reportes.JasperViwerSRI
 * JD-Core Version:    0.7.0.1
 */