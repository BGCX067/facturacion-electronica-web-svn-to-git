/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import java.awt.event.KeyAdapter;
/*   4:    */ import java.awt.event.KeyEvent;
/*   5:    */ import java.awt.event.KeyListener;
/*   6:    */ import javax.swing.JOptionPane;
/*   7:    */ import javax.swing.JTextField;
/*   8:    */ 
/*   9:    */ public class ListenerUtil
/*  10:    */ {
/*  11:    */   public void listenerLongitudBackSpace(final JTextField miTexto, final Integer longitudCampo)
/*  12:    */   {
/*  13: 20 */     miTexto.addKeyListener(new KeyAdapter()
/*  14:    */     {
/*  15:    */       public void keyTyped(KeyEvent e)
/*  16:    */       {
/*  17: 24 */         if (miTexto.getText().length() == longitudCampo.intValue()) {
/*  18: 25 */           e.consume();
/*  19:    */         }
/*  20:    */       }
/*  21:    */     });
/*  22:    */   }
/*  23:    */   
/*  24:    */   public void listenerLongitud(final JTextField texto, final Integer longitud)
/*  25:    */   {
/*  26: 32 */     texto.addKeyListener(new KeyAdapter()
/*  27:    */     {
/*  28:    */       public void keyTyped(KeyEvent e)
/*  29:    */       {
/*  30: 35 */         char caracter = e.getKeyChar();
/*  31: 36 */         if (texto.getText().length() == longitud.intValue()) {
/*  32: 37 */           e.consume();
/*  33:    */         }
/*  34: 39 */         if (caracter == '\b') {
/*  35: 40 */           e.consume();
/*  36:    */         }
/*  37:    */       }
/*  38:    */     });
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void listenerSolonumeros(JTextField txtField)
/*  42:    */   {
/*  43: 47 */     txtField.addKeyListener(new KeyAdapter()
/*  44:    */     {
/*  45:    */       public void keyTyped(KeyEvent e)
/*  46:    */       {
/*  47: 49 */         char caracter = e.getKeyChar();
/*  48: 50 */         if (((caracter < '0') || (caracter > '9')) && ((caracter < 'A') || (caracter > 'Z')) && (caracter != '\b')) {
/*  49: 53 */           e.consume();
/*  50:    */         }
/*  51:    */       }
/*  52:    */     });
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void listenerNumerosDecimales(final JTextField texto, final int longitud)
/*  56:    */   {
/*  57: 60 */     texto.addKeyListener(new KeyAdapter()
/*  58:    */     {
/*  59:    */       public void keyTyped(KeyEvent e)
/*  60:    */       {
/*  61: 62 */         char caracter = e.getKeyChar();
/*  62: 63 */         if (texto.getText().length() == longitud) {
/*  63: 65 */           e.consume();
/*  64:    */         }
/*  65: 68 */         if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {
/*  66: 69 */           e.consume();
/*  67:    */         }
/*  68: 71 */         if ((caracter == '.') && 
/*  69: 72 */           (texto.getText().indexOf(".") > 0)) {
/*  70: 73 */           e.consume();
/*  71:    */         }
/*  72:    */       }
/*  73:    */     });
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void listenerSolonumerosLongitud(final JTextField texto, final Integer longitud)
/*  77:    */   {
/*  78: 83 */     texto.addKeyListener(new KeyAdapter()
/*  79:    */     {
/*  80:    */       public void keyTyped(KeyEvent e)
/*  81:    */       {
/*  82: 86 */         char caracter = e.getKeyChar();
/*  83: 88 */         if (texto.getText().length() == longitud.intValue())
/*  84:    */         {
/*  85: 89 */           JOptionPane.showMessageDialog(null, "La longitud maxima es de " + longitud + " caracteres", "Mensaje", 1);
/*  86: 90 */           e.consume();
/*  87:    */         }
/*  88: 92 */         if (((caracter < '0') || (caracter > '9')) && ((caracter < 'A') || (caracter > 'Z')) && (caracter != '\b')) {
/*  89: 95 */           e.consume();
/*  90:    */         }
/*  91:    */       }
/*  92:    */     });
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void removeListener(JTextField txtIdentificacion)
/*  96:    */   {
/*  97:102 */     txtIdentificacion.setText(null);
/*  98:103 */     for (KeyListener list : txtIdentificacion.getKeyListeners()) {
/*  99:104 */       txtIdentificacion.removeKeyListener(list);
/* 100:    */     }
/* 101:    */   }
/* 102:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ListenerUtil
 * JD-Core Version:    0.7.0.1
 */