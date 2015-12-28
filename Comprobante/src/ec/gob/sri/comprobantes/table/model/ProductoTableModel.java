/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   4:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   5:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.List;
/*   8:    */ import java.util.logging.Level;
/*   9:    */ import java.util.logging.Logger;
/*  10:    */ import javax.swing.JFrame;
/*  11:    */ import javax.swing.JOptionPane;
/*  12:    */ import javax.swing.table.AbstractTableModel;
/*  13:    */ 
/*  14:    */ public class ProductoTableModel
/*  15:    */   extends AbstractTableModel
/*  16:    */ {
/*  17:    */   public static final int DECIMALES_IVA_PRESUNTIVO = 2;
/*  18:    */   private ArrayList<Object[]> data;
/*  19:    */   private List<Producto> productos;
/*  20: 32 */   private String[] columnNames = { "Número", "Cantidad", "Código Principal", "Código Auxiliar", "Descripción", "Acción" };
/*  21:    */   
/*  22:    */   public ProductoTableModel()
/*  23:    */   {
/*  24: 35 */     this.data = new ArrayList();
/*  25: 36 */     this.productos = new ArrayList();
/*  26:    */   }
/*  27:    */   
/*  28:    */   public int getColumnCount()
/*  29:    */   {
/*  30: 40 */     return this.columnNames.length;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public int getRowCount()
/*  34:    */   {
/*  35: 44 */     return this.data.size();
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getColumnName(int col)
/*  39:    */   {
/*  40: 49 */     return this.columnNames[col];
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Object getValueAt(int row, int col)
/*  44:    */   {
/*  45: 53 */     return ((Object[])this.data.get(row))[col];
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Object[] getRow(int row)
/*  49:    */   {
/*  50: 57 */     return (Object[])this.data.get(row);
/*  51:    */   }
/*  52:    */   
/*  53:    */   public Class getColumnClass(int c)
/*  54:    */   {
/*  55: 62 */     return getValueAt(0, c).getClass();
/*  56:    */   }
/*  57:    */   
/*  58:    */   public boolean isCellEditable(int row, int col)
/*  59:    */   {
/*  60: 67 */     if ((col == 1) || (col == 5)) {
/*  61: 68 */       return true;
/*  62:    */     }
/*  63: 70 */     return false;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setValueAt(Object value, int row, int col)
/*  67:    */   {
/*  68: 76 */     if (this.data.isEmpty()) {
/*  69: 77 */       return;
/*  70:    */     }
/*  71: 79 */     if (this.data.size() == row) {
/*  72: 80 */       row--;
/*  73:    */     }
/*  74: 82 */     Producto prod = null;
/*  75: 84 */     if (col == 1)
/*  76:    */     {
/*  77:    */       try
/*  78:    */       {
/*  79: 86 */         String codigo = (String)getValueAt(row, 2);
/*  80: 87 */         prod = (Producto)new ProductoSQL().obtenerProducto(codigo, null, null).get(0);
/*  81: 88 */         Producto indexEncontrado = null;
/*  82: 90 */         for (Producto p : this.productos)
/*  83:    */         {
/*  84: 91 */           String codLista = p.getCodigoPrincipal();
/*  85: 92 */           if (codLista.equals(prod.getCodigoPrincipal())) {
/*  86: 93 */             indexEncontrado = p;
/*  87:    */           }
/*  88:    */         }
/*  89: 97 */         this.productos.remove(indexEncontrado);
/*  90:    */       }
/*  91:    */       catch (Exception ex)
/*  92:    */       {
/*  93:100 */         Logger.getLogger(ProductoTableModel.class.getName()).log(Level.SEVERE, null, ex);
/*  94:    */       }
/*  95:103 */       Double newCantidad = null;
/*  96:    */       try
/*  97:    */       {
/*  98:105 */         newCantidad = Double.valueOf(Double.parseDouble(value.toString()));
/*  99:    */       }
/* 100:    */       catch (NumberFormatException ex)
/* 101:    */       {
/* 102:107 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 103:    */         
/* 104:109 */         return;
/* 105:    */       }
/* 106:113 */       if (!ValidadorCampos.validarDecimales(value.toString(), 2).booleanValue())
/* 107:    */       {
/* 108:114 */         JOptionPane.showMessageDialog(new JFrame(), "El número máximo de decimales permitido es: ".concat(String.valueOf(2)), "Se ha producido un error ", 0);
/* 109:115 */         return;
/* 110:    */       }
/* 111:118 */       if (newCantidad.doubleValue() <= 0.0D)
/* 112:    */       {
/* 113:119 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "ERROR", 0);
/* 114:    */       }
/* 115:    */       else
/* 116:    */       {
/* 117:122 */         ((Object[])this.data.get(row))[col] = String.valueOf(value);
/* 118:123 */         prod.setCantidad(newCantidad);
/* 119:124 */         this.productos.add(prod);
/* 120:    */       }
/* 121:    */     }
/* 122:    */     else
/* 123:    */     {
/* 124:127 */       ((Object[])this.data.get(row))[col] = value;
/* 125:    */     }
/* 126:130 */     fireTableCellUpdated(row, col);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void deleteRow(int fila)
/* 130:    */   {
/* 131:139 */     if (fila == -1) {
/* 132:140 */       fila = 0;
/* 133:    */     }
/* 134:142 */     Object[] item = (Object[])this.data.get(fila);
/* 135:    */     try
/* 136:    */     {
/* 137:144 */       Producto prod = null;
/* 138:145 */       String codigo = (String)getValueAt(fila, 2);
/* 139:146 */       prod = (Producto)new ProductoSQL().obtenerProducto(codigo, null, null).get(0);
/* 140:147 */       Producto indexEncontrado = null;
/* 141:149 */       for (Producto p : this.productos)
/* 142:    */       {
/* 143:150 */         String codLista = p.getCodigoPrincipal();
/* 144:151 */         if (codLista.equals(prod.getCodigoPrincipal()))
/* 145:    */         {
/* 146:152 */           indexEncontrado = p;
/* 147:153 */           break;
/* 148:    */         }
/* 149:    */       }
/* 150:156 */       this.productos.remove(indexEncontrado);
/* 151:    */     }
/* 152:    */     catch (Exception ex)
/* 153:    */     {
/* 154:158 */       Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 155:    */     }
/* 156:160 */     this.data.remove(item);
/* 157:161 */     this.data.size();
/* 158:162 */     fireTableRowsDeleted(fila, fila);
/* 159:163 */     super.fireTableDataChanged();
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void addRow(int numeroItems, Producto producto)
/* 163:    */   {
/* 164:175 */     int filas = this.data.size();
/* 165:176 */     String cantidad = "1";
/* 166:    */     
/* 167:178 */     Object[] item = { Integer.valueOf(numeroItems), cantidad, producto.getCodigoPrincipal(), producto.getCodigoAuxiliar(), producto.getNombre(), "" };
/* 168:179 */     this.data.add(item);
/* 169:180 */     producto.setCantidad(Double.valueOf(Double.parseDouble(cantidad)));
/* 170:181 */     this.productos.add(producto);
/* 171:    */     
/* 172:183 */     fireTableRowsInserted(filas, this.data.size());
/* 173:    */   }
/* 174:    */   
/* 175:    */   public List<Producto> getProductos()
/* 176:    */   {
/* 177:187 */     return this.productos;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void setProductos(List<Producto> productos)
/* 181:    */   {
/* 182:191 */     this.productos = productos;
/* 183:    */   }
/* 184:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.ProductoTableModel
 * JD-Core Version:    0.7.0.1
 */