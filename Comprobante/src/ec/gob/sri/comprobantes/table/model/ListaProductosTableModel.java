/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import javax.swing.table.AbstractTableModel;
/*  4:   */ 
/*  5:   */ public class ListaProductosTableModel
/*  6:   */   extends AbstractTableModel
/*  7:   */ {
/*  8:17 */   Object[] columnNames = { "Código principal", "Código auxiliar", "Descripción", "P. Unitario", "" };
/*  9:19 */   String[][] data = { { "0", "0", "descripcion", "0.00", "0.00", "" } };
/* 10:20 */   Object[][] filas = (Object[][])null;
/* 11:   */   
/* 12:   */   public ListaProductosTableModel() {}
/* 13:   */   
/* 14:   */   public ListaProductosTableModel(Object[][] fila)
/* 15:   */   {
/* 16:26 */     this.filas = fila;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getColumnName(int col)
/* 20:   */   {
/* 21:32 */     return (String)this.columnNames[col];
/* 22:   */   }
/* 23:   */   
/* 24:   */   public boolean isCellEditable(int row, int col)
/* 25:   */   {
/* 26:38 */     boolean resp = false;
/* 27:39 */     if (col == 4) {
/* 28:40 */       resp = true;
/* 29:   */     }
/* 30:42 */     return resp;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public int getRowCount()
/* 34:   */   {
/* 35:46 */     return this.filas.length;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public int getColumnCount()
/* 39:   */   {
/* 40:50 */     return this.columnNames.length;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public Object getValueAt(int rowIndex, int columnIndex)
/* 44:   */   {
/* 45:54 */     return this.filas[rowIndex][columnIndex];
/* 46:   */   }
/* 47:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.ListaProductosTableModel
 * JD-Core Version:    0.7.0.1
 */