/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.util.ArrayList;
/*  5:   */ import javax.swing.table.AbstractTableModel;
/*  6:   */ 
/*  7:   */ public class ClienteTableModel
/*  8:   */   extends AbstractTableModel
/*  9:   */ {
/* 10:   */   private static final int COLUMNAS_ARCHIVOS = 6;
/* 11:   */   private File directorio;
/* 12:23 */   private ArrayList<Object[]> fila = null;
/* 13:24 */   String[] columnNames = { "Apellidos y Nombres / Razón Social", "Tipo Identificación", "Número Identidicación", "Tipo Cliente", "Actualizar", "Eliminar" };
/* 14:25 */   boolean[] canEdit = { false, false, false, false, true, true };
/* 15:   */   
/* 16:   */   public ClienteTableModel(ArrayList<Object[]> fila)
/* 17:   */   {
/* 18:29 */     this.fila = fila;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void deleteRow(int row)
/* 22:   */   {
/* 23:33 */     if (row == -1) {
/* 24:34 */       row = 0;
/* 25:   */     }
/* 26:36 */     Object[] pr = (Object[])this.fila.get(row);
/* 27:37 */     this.fila.remove(pr);
/* 28:38 */     fireTableRowsDeleted(row, row);
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
/* 48:60 */     if ((this.fila.size() == 1) && (row == 1)) {
/* 49:61 */       row--;
/* 50:   */     }
/* 51:63 */     if (row == -1) {
/* 52:64 */       row = 0;
/* 53:   */     }
/* 54:66 */     return ((Object[])this.fila.get(row))[col];
/* 55:   */   }
/* 56:   */   
/* 57:   */   public boolean isCellEditable(int rowIndex, int columnIndex)
/* 58:   */   {
/* 59:71 */     return this.canEdit[columnIndex];
/* 60:   */   }
/* 61:   */   
/* 62:   */   public File getDirectorio()
/* 63:   */   {
/* 64:75 */     return this.directorio;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setDirectorio(File directorio)
/* 68:   */   {
/* 69:79 */     this.directorio = directorio;
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.ClienteTableModel
 * JD-Core Version:    0.7.0.1
 */