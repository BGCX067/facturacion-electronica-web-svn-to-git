/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.SubtotalImpuesto;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
/*   7:    */ import java.math.BigDecimal;
/*   8:    */ import java.math.RoundingMode;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ import javax.swing.table.AbstractTableModel;
/*  15:    */ 
/*  16:    */ public class NotaDebitoTableModel
/*  17:    */   extends AbstractTableModel
/*  18:    */ {
/*  19: 29 */   private BigDecimal totalIva = BigDecimal.ZERO;
/*  20: 30 */   private BigDecimal porcentajeIva = BigDecimal.ZERO;
/*  21: 31 */   private List<SubtotalImpuesto> listaIva = new ArrayList();
/*  22:    */   private ArrayList<Object[]> data;
/*  23: 33 */   private String[] columnNames = { "Nro.", "Razón de la modificación", "Valor de la modificación", "Acción" };
/*  24:    */   
/*  25:    */   public NotaDebitoTableModel()
/*  26:    */   {
/*  27: 37 */     this.data = new ArrayList();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public NotaDebitoTableModel(Integer numero, String razon, BigDecimal valorModificacion)
/*  31:    */   {
/*  32: 41 */     Object[] item = { numero, razon, valorModificacion, "" };
/*  33: 42 */     this.data.add(item);
/*  34:    */   }
/*  35:    */   
/*  36:    */   public int getColumnCount()
/*  37:    */   {
/*  38: 46 */     return this.columnNames.length;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public int getRowCount()
/*  42:    */   {
/*  43: 50 */     return this.data.size();
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getColumnName(int col)
/*  47:    */   {
/*  48: 55 */     return this.columnNames[col];
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Object getValueAt(int row, int col)
/*  52:    */   {
/*  53: 59 */     return ((Object[])this.data.get(row))[col];
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Class getColumnClass(int c)
/*  57:    */   {
/*  58: 64 */     return getValueAt(0, c).getClass();
/*  59:    */   }
/*  60:    */   
/*  61:    */   public boolean isCellEditable(int row, int col)
/*  62:    */   {
/*  63: 69 */     if (col == 0) {
/*  64: 70 */       return false;
/*  65:    */     }
/*  66: 72 */     return true;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setValueAt(Object value, int row, int col)
/*  70:    */   {
/*  71: 78 */     if (this.data.size() == row) {
/*  72: 79 */       row--;
/*  73:    */     }
/*  74: 81 */     if (col == 2)
/*  75:    */     {
/*  76: 82 */       String id = String.valueOf(getValueAt(row, 0));
/*  77: 83 */       BigDecimal valorModificacion = (BigDecimal)value;
/*  78: 85 */       if (valorModificacion.doubleValue() >= 0.0D)
/*  79:    */       {
/*  80: 86 */         ((Object[])this.data.get(row))[col] = value;
/*  81:    */         try
/*  82:    */         {
/*  83: 88 */           calculaImpuestosProducto(valorModificacion, id, true);
/*  84:    */         }
/*  85:    */         catch (Exception ex)
/*  86:    */         {
/*  87: 90 */           Logger.getLogger(NotaDebitoTableModel.class.getName()).log(Level.SEVERE, null, ex);
/*  88:    */         }
/*  89:    */       }
/*  90:    */       else
/*  91:    */       {
/*  92: 93 */         ((Object[])this.data.get(row))[col] = BigDecimal.ZERO;
/*  93:    */       }
/*  94:    */     }
/*  95:    */     else
/*  96:    */     {
/*  97: 96 */       ((Object[])this.data.get(row))[col] = value;
/*  98:    */     }
/*  99: 98 */     fireTableCellUpdated(row, col);
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void deleteRow(int fila)
/* 103:    */   {
/* 104:102 */     if (fila == -1) {
/* 105:103 */       fila = 0;
/* 106:    */     }
/* 107:105 */     Object[] item = (Object[])this.data.get(fila);
/* 108:    */     try
/* 109:    */     {
/* 110:107 */       String codigo = String.valueOf((Integer)getValueAt(fila, 0));
/* 111:108 */       eliminaImpuestosProducto(codigo);
/* 112:    */     }
/* 113:    */     catch (Exception ex)
/* 114:    */     {
/* 115:110 */       Logger.getLogger(NotaDebitoTableModel.class.getName()).log(Level.SEVERE, null, ex);
/* 116:    */     }
/* 117:112 */     this.data.remove(item);
/* 118:113 */     fireTableRowsDeleted(fila, fila);
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void addRow(Integer numero, String razon, BigDecimal valorModificacion)
/* 122:    */     throws SQLException
/* 123:    */   {
/* 124:126 */     int numRows = this.data.size();
/* 125:    */     
/* 126:128 */     Object[] item = { numero, razon, valorModificacion, "" };
/* 127:129 */     this.data.add(item);
/* 128:    */     
/* 129:131 */     fireTableRowsInserted(numRows, this.data.size());
/* 130:    */   }
/* 131:    */   
/* 132:    */   private void calculaImpuestosProducto(BigDecimal newCantidad, String contribuyente, boolean old)
/* 133:    */     throws SQLException, ClassNotFoundException
/* 134:    */   {
/* 135:142 */     ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode());
/* 136:143 */     if (iv != null) {
/* 137:144 */       this.porcentajeIva = BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D).setScale(2, RoundingMode.HALF_UP);
/* 138:    */     }
/* 139:146 */     BigDecimal baseimponible = newCantidad.setScale(2, RoundingMode.HALF_UP);
/* 140:147 */     BigDecimal total = baseimponible.multiply(this.porcentajeIva);
/* 141:148 */     SubtotalImpuesto subTotal = new SubtotalImpuesto(null, null, contribuyente, this.porcentajeIva, baseimponible, total);
/* 142:149 */     if (old == true) {
/* 143:150 */       remueveSubtotal(contribuyente, this.listaIva);
/* 144:    */     }
/* 145:152 */     this.listaIva.add(subTotal);
/* 146:153 */     this.totalIva = calcularTotal(this.listaIva);
/* 147:    */   }
/* 148:    */   
/* 149:    */   private void eliminaImpuestosProducto(String codigo)
/* 150:    */     throws SQLException, ClassNotFoundException
/* 151:    */   {
/* 152:165 */     remueveSubtotal(codigo, this.listaIva);
/* 153:166 */     this.totalIva = calcularTotal(this.listaIva);
/* 154:    */   }
/* 155:    */   
/* 156:    */   private BigDecimal calcularTotal(List<SubtotalImpuesto> lista)
/* 157:    */   {
/* 158:176 */     BigDecimal total = BigDecimal.ZERO;
/* 159:178 */     for (SubtotalImpuesto s : lista) {
/* 160:179 */       total = total.add(s.getBaseImponible());
/* 161:    */     }
/* 162:181 */     return total;
/* 163:    */   }
/* 164:    */   
/* 165:    */   private void remueveSubtotal(String codigo, List<SubtotalImpuesto> lista)
/* 166:    */     throws SQLException, ClassNotFoundException
/* 167:    */   {
/* 168:194 */     boolean itemEncontrado = false;
/* 169:195 */     for (int i = 0; i < lista.size(); i++) {
/* 170:196 */       if ((((SubtotalImpuesto)lista.get(i)).getCodigo().equals(codigo)) && (!itemEncontrado))
/* 171:    */       {
/* 172:198 */         lista.remove(i);
/* 173:199 */         itemEncontrado = true;
/* 174:    */       }
/* 175:    */     }
/* 176:    */   }
/* 177:    */   
/* 178:    */   public List<SubtotalImpuesto> getListaIva()
/* 179:    */   {
/* 180:205 */     return this.listaIva;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setListaIva(List<SubtotalImpuesto> listaIva)
/* 184:    */   {
/* 185:209 */     this.listaIva = listaIva;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public BigDecimal getTotalIva()
/* 189:    */   {
/* 190:213 */     return this.totalIva;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setTotalIva(BigDecimal totalIva)
/* 194:    */   {
/* 195:217 */     this.totalIva = totalIva;
/* 196:    */   }
/* 197:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.NotaDebitoTableModel
 * JD-Core Version:    0.7.0.1
 */