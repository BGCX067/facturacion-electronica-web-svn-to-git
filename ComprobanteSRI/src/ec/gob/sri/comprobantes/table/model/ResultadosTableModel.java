/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import javax.swing.table.AbstractTableModel;
/*  5:   */ 
/*  6:   */ public class ResultadosTableModel
/*  7:   */   extends AbstractTableModel
/*  8:   */ {
/*  9:   */   private ArrayList<Object[]> data;
/* 10:20 */   private String[] columnNames = { "Nro.", "Archivo XML", "Tipo Comprobante", "Resultado", "Motivo" };
/* 11:   */   
/* 12:   */   public ResultadosTableModel()
/* 13:   */   {
/* 14:23 */     this.data = new ArrayList();
/* 15:   */   }
/* 16:   */   
/* 17:   */   public int getColumnCount()
/* 18:   */   {
/* 19:27 */     return this.columnNames.length;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public int getRowCount()
/* 23:   */   {
/* 24:31 */     return this.data.size();
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getColumnName(int col)
/* 28:   */   {
/* 29:36 */     return this.columnNames[col];
/* 30:   */   }
/* 31:   */   
/* 32:   */   public Object getValueAt(int row, int col)
/* 33:   */   {
/* 34:40 */     return ((Object[])this.data.get(row))[col];
/* 35:   */   }
/* 36:   */   
/* 37:   */   public Object[] getRow(int row)
/* 38:   */   {
/* 39:44 */     return (Object[])this.data.get(row);
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Class<?> getColumnClass(int column)
/* 43:   */   {
/* 44:49 */     return getValueAt(0, column).getClass();
/* 45:   */   }
/* 46:   */   
/* 47:   */   public boolean isCellEditable(int row, int col)
/* 48:   */   {
/* 49:54 */     return false;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setValueAt(Object value, int row, int col)
/* 53:   */   {
/* 54:59 */     if ((this.data.size() == 1) && (row == 1)) {
/* 55:60 */       row--;
/* 56:   */     }
/* 57:62 */     ((Object[])this.data.get(row))[col] = value;
/* 58:63 */     fireTableCellUpdated(row, col);
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void addRow(Integer num, String archivo, String tipo, String resultado, String motivo)
/* 62:   */   {
/* 63:68 */     if (motivo == null) {
/* 64:69 */       motivo = "";
/* 65:   */     }
/* 66:72 */     Object[] obj = { num, archivo, tipo, resultado, motivo };
/* 67:   */     
/* 68:74 */     this.data.add(obj);
/* 69:75 */     int numRows = this.data.size();
/* 70:76 */     fireTableRowsInserted(numRows, numRows + 1);
/* 71:   */   }
/* 72:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.ResultadosTableModel
 * JD-Core Version:    0.7.0.1
 */