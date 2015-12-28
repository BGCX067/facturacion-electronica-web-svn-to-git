/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.util.ArrayList;
/*  5:   */ import javax.swing.table.AbstractTableModel;
/*  6:   */ 
/*  7:   */ public class ProductosTableModel
/*  8:   */   extends AbstractTableModel
/*  9:   */ {
/* 10:   */   private static final int COLUMNAS_ARCHIVOS = 6;
/* 11:   */   private File directorio;
/* 12:22 */   private ArrayList<Object[]> fila = null;
/* 13:23 */   String[] columnNames = { "Código Producto", "Código Auxiliar", "Descripción", "Tipo Producto", "Actualizar", "Eliminar" };
/* 14:24 */   boolean[] canEdit = { false, false, false, false, true, true };
/* 15:   */   
/* 16:   */   public ProductosTableModel(ArrayList<Object[]> fila)
/* 17:   */   {
/* 18:28 */     this.fila = fila;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void deleteRow(int row)
/* 22:   */   {
/* 23:32 */     if (row == -1) {
/* 24:33 */       row = 0;
/* 25:   */     }
/* 26:35 */     Object[] pr = (Object[])this.fila.get(row);
/* 27:36 */     this.fila.remove(pr);
/* 28:37 */     fireTableRowsDeleted(row, row);
/* 29:   */   }
/* 30:   */   
/* 31:   */   public int getColumnCount()
/* 32:   */   {
/* 33:43 */     return 6;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public int getRowCount()
/* 37:   */   {
/* 38:48 */     return this.fila.size();
/* 39:   */   }
/* 40:   */   
/* 41:   */   public String getColumnName(int col)
/* 42:   */   {
/* 43:54 */     return this.columnNames[col];
/* 44:   */   }
/* 45:   */   
/* 46:   */   public Object getValueAt(int row, int col)
/* 47:   */   {
/* 48:61 */     if ((this.fila.size() == 1) && (row == 1)) {
/* 49:62 */       row--;
/* 50:   */     }
/* 51:64 */     if (row == -1) {
/* 52:65 */       row = 0;
/* 53:   */     }
/* 54:67 */     return ((Object[])this.fila.get(row))[col];
/* 55:   */   }
/* 56:   */   
/* 57:   */   public boolean isCellEditable(int rowIndex, int columnIndex)
/* 58:   */   {
/* 59:72 */     return this.canEdit[columnIndex];
/* 60:   */   }
/* 61:   */   
/* 62:   */   public File getDirectorio()
/* 63:   */   {
/* 64:76 */     return this.directorio;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setDirectorio(File directorio)
/* 68:   */   {
/* 69:80 */     this.directorio = directorio;
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.ProductosTableModel
 * JD-Core Version:    0.7.0.1
 */