/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.util.TokensValidos;
/*  4:   */ import javax.swing.AbstractListModel;
/*  5:   */ import javax.swing.ComboBoxModel;
/*  6:   */ 
/*  7:   */ public class TokenComboBoxModel
/*  8:   */   extends AbstractListModel
/*  9:   */   implements ComboBoxModel
/* 10:   */ {
/* 11:17 */   String[] listaTokens = { TokensValidos.ANF1.getId(), TokensValidos.BCE_ALADDIN.getId(), TokensValidos.BCE_IKEY2032.getId(), TokensValidos.SD_BIOPASS.getId(), TokensValidos.SD_EPASS3000.getId() };
/* 12:21 */   String selection = null;
/* 13:   */   
/* 14:   */   public Object getElementAt(int index)
/* 15:   */   {
/* 16:27 */     return this.listaTokens[index];
/* 17:   */   }
/* 18:   */   
/* 19:   */   public int getSize()
/* 20:   */   {
/* 21:31 */     return this.listaTokens.length;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setSelectedItem(Object anItem)
/* 25:   */   {
/* 26:35 */     this.selection = ((String)anItem);
/* 27:   */   }
/* 28:   */   
/* 29:   */   public Object getSelectedItem()
/* 30:   */   {
/* 31:40 */     return this.selection;
/* 32:   */   }
/* 33:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.TokenComboBoxModel
 * JD-Core Version:    0.7.0.1
 */