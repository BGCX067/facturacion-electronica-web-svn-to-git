/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.ImpuestoRetencion;
/*   5:    */ import java.math.BigDecimal;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.List;
/*   8:    */ import javax.swing.table.AbstractTableModel;
/*   9:    */ import javax.swing.table.DefaultTableModel;
/*  10:    */ 
/*  11:    */ public class RetencionTableModel
/*  12:    */   extends AbstractTableModel
/*  13:    */ {
/*  14:    */   DefaultTableModel t;
/*  15:    */   private ArrayList<Object[]> data;
/*  16:    */   private List<ImpuestoRetencion> impuestos;
/*  17: 27 */   private String[] columnNames = { "Cod. Reten.", "Código", "Descripción", "Base Imponible", "Porcentaje", "Total", "Documento", "Fecha", "Tipo", "Acción" };
/*  18:    */   
/*  19:    */   public RetencionTableModel()
/*  20:    */   {
/*  21: 31 */     this.data = new ArrayList();
/*  22: 32 */     this.impuestos = new ArrayList();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public int getColumnCount()
/*  26:    */   {
/*  27: 36 */     return this.columnNames.length;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public int getRowCount()
/*  31:    */   {
/*  32: 40 */     return this.data.size();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String getColumnName(int col)
/*  36:    */   {
/*  37: 45 */     return this.columnNames[col];
/*  38:    */   }
/*  39:    */   
/*  40:    */   public Object getValueAt(int row, int col)
/*  41:    */   {
/*  42: 49 */     return ((Object[])this.data.get(row))[col];
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Object[] getRow(int row)
/*  46:    */   {
/*  47: 53 */     return (Object[])this.data.get(row);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Class getColumnClass(int c)
/*  51:    */   {
/*  52: 58 */     return getValueAt(0, c).getClass();
/*  53:    */   }
/*  54:    */   
/*  55:    */   public boolean isCellEditable(int row, int col)
/*  56:    */   {
/*  57: 63 */     if (col == 9) {
/*  58: 64 */       return true;
/*  59:    */     }
/*  60: 66 */     return false;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setValueAt(Object value, int row, int col)
/*  64:    */   {
/*  65: 72 */     if ((this.data.size() == 1) && (row == 1)) {
/*  66: 73 */       row--;
/*  67:    */     }
/*  68: 76 */     ((Object[])this.data.get(row))[col] = value;
/*  69: 77 */     fireTableCellUpdated(row, col);
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void deleteRow(int fila)
/*  73:    */   {
/*  74: 86 */     if (fila == -1) {
/*  75: 87 */       fila = 0;
/*  76:    */     }
/*  77: 89 */     Object[] item = (Object[])this.data.get(fila);
/*  78: 90 */     this.data.remove(item);
/*  79:    */     
/*  80:    */ 
/*  81: 93 */     fireTableRowsDeleted(fila, fila);
/*  82:    */   }
/*  83:    */   
/*  84:    */   public void addRow(ImpuestoValor impuesto, BigDecimal baseImponible, BigDecimal porcentaje, BigDecimal valorTotal, String doc, String fechaEmision, String tipoDoc)
/*  85:    */   {
/*  86:107 */     int filas = this.data.size();
/*  87:    */     
/*  88:109 */     Object[] item = { impuesto.getCodigo(), impuesto.getCodigoImpuesto(), impuesto.getDescripcion(), baseImponible, porcentaje, valorTotal, doc, fechaEmision, tipoDoc, "" };
/*  89:110 */     this.data.add(item);
/*  90:    */     
/*  91:112 */     fireTableRowsInserted(filas, this.data.size());
/*  92:    */   }
/*  93:    */   
/*  94:    */   public List<ImpuestoRetencion> getImpuestos()
/*  95:    */   {
/*  96:116 */     return this.impuestos;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setImpuestos(List<ImpuestoRetencion> impuestos)
/* 100:    */   {
/* 101:120 */     this.impuestos = impuestos;
/* 102:    */   }
/* 103:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.RetencionTableModel
 * JD-Core Version:    0.7.0.1
 */