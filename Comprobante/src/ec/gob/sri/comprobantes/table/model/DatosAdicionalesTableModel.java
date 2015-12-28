/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import javax.swing.JFrame;
/*  5:   */ import javax.swing.JOptionPane;
/*  6:   */ import javax.swing.table.AbstractTableModel;
/*  7:   */ 
/*  8:   */ public class DatosAdicionalesTableModel
/*  9:   */   extends AbstractTableModel
/* 10:   */ {
/* 11:23 */   int numeroRegistros = 0;
/* 12:24 */   String[] columnNames = { "Nombre", "Descripción", "Acción" };
/* 13:   */   private ArrayList<Object[]> data;
/* 14:   */   
/* 15:   */   public DatosAdicionalesTableModel()
/* 16:   */   {
/* 17:28 */     this.data = new ArrayList();
/* 18:   */   }
/* 19:   */   
/* 20:   */   public int getColumnCount()
/* 21:   */   {
/* 22:32 */     return this.columnNames.length;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public int getRowCount()
/* 26:   */   {
/* 27:36 */     return this.data.size();
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getColumnName(int col)
/* 31:   */   {
/* 32:41 */     return this.columnNames[col];
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Object getValueAt(int row, int col)
/* 36:   */   {
/* 37:45 */     return ((Object[])this.data.get(row))[col];
/* 38:   */   }
/* 39:   */   
/* 40:   */   public Class getColumnClass(int col)
/* 41:   */   {
/* 42:50 */     return getValueAt(0, col).getClass();
/* 43:   */   }
/* 44:   */   
/* 45:   */   public boolean isCellEditable(int row, int col)
/* 46:   */   {
/* 47:55 */     return true;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setValueAt(Object value, int row, int col)
/* 51:   */   {
/* 52:59 */     if ((this.data.size() == 1) && (row == 1)) {
/* 53:60 */       row--;
/* 54:   */     }
/* 55:62 */     if (value != null)
/* 56:   */     {
/* 57:63 */       if ((col == 1) && (col == 0))
/* 58:   */       {
/* 59:65 */         String descripcion = (String)value;
/* 60:66 */         ((Object[])this.data.get(row))[col] = descripcion.substring(0, descripcion.length() > 100 ? 100 : descripcion.length());
/* 61:   */       }
/* 62:   */       else
/* 63:   */       {
/* 64:68 */         ((Object[])this.data.get(row))[col] = value;
/* 65:   */       }
/* 66:71 */       super.fireTableCellUpdated(row, col);
/* 67:   */     }
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void addRow(String nombre, String descripcion)
/* 71:   */   {
/* 72:77 */     if (getRowCount() < 5)
/* 73:   */     {
/* 74:78 */       Object[] obj = { nombre, descripcion, "" };
/* 75:   */       
/* 76:80 */       this.data.add(obj);
/* 77:81 */       int numRows = this.data.size();
/* 78:82 */       fireTableRowsInserted(numRows, numRows + 1);
/* 79:   */     }
/* 80:   */     else
/* 81:   */     {
/* 82:84 */       JOptionPane.showMessageDialog(new JFrame(), "So puede ingresar hasta cinco detalles adicionales", "ERROR", 0);
/* 83:   */     }
/* 84:   */   }
/* 85:   */   
/* 86:   */   public void deleteRow(int fila)
/* 87:   */   {
/* 88:89 */     if (fila == -1) {
/* 89:90 */       fila = 0;
/* 90:   */     }
/* 91:92 */     Object[] pr = (Object[])this.data.get(fila);
/* 92:93 */     this.data.remove(pr);
/* 93:94 */     fireTableRowsDeleted(fila, fila);
/* 94:   */   }
/* 95:   */   
/* 96:   */   public void deleteAllRows()
/* 97:   */   {
/* 98:98 */     this.data.clear();
/* 99:99 */     super.fireTableDataChanged();
/* :0:   */   }
/* :1:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.DatosAdicionalesTableModel
 * JD-Core Version:    0.7.0.1
 */