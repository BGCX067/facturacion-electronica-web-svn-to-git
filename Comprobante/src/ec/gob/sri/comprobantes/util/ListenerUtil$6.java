/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import java.awt.event.KeyAdapter;
/*   4:    */ import java.awt.event.KeyEvent;
/*   5:    */ import javax.swing.JOptionPane;
/*   6:    */ import javax.swing.JTextField;
/*   7:    */ 
/*   8:    */ class ListenerUtil$6
/*   9:    */   extends KeyAdapter
/*  10:    */ {
/*  11:    */   ListenerUtil$6(ListenerUtil paramListenerUtil, JTextField paramJTextField, Integer paramInteger) {}
/*  12:    */   
/*  13:    */   public void keyTyped(KeyEvent e)
/*  14:    */   {
/*  15:101 */     char caracter = e.getKeyChar();
/*  16:103 */     if (this.val$texto.getText().length() == this.val$longitud.intValue())
/*  17:    */     {
/*  18:104 */       JOptionPane.showMessageDialog(null, "La longitud maxima es de " + this.val$longitud + " caracteres", "Mensaje", 1);
/*  19:105 */       e.consume();
/*  20:    */     }
/*  21:107 */     if (((caracter < '0') || (caracter > '9')) && ((caracter < 'A') || (caracter > 'Z')) && (caracter != '\b')) {
/*  22:110 */       e.consume();
/*  23:    */     }
/*  24:    */   }
/*  25:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ListenerUtil.6
 * JD-Core Version:    0.7.0.1
 */