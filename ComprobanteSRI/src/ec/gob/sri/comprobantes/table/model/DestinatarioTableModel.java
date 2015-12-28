/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.DestinatarioProducto;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.guia.Destinatario;
/*   6:    */ import java.util.ArrayList;
/*   7:    */ import java.util.List;
/*   8:    */ import javax.swing.table.AbstractTableModel;
/*   9:    */ 
/*  10:    */ public class DestinatarioTableModel
/*  11:    */   extends AbstractTableModel
/*  12:    */ {
/*  13:    */   private ArrayList<Object[]> data;
/*  14:    */   private List<DestinatarioProducto> destinatarios;
/*  15: 25 */   private String[] columnNames = { "Número", "Identificación", "Razón Social", "Nro. Comprobante", "Fecha Emisión", "Productos", "Acción" };
/*  16:    */   
/*  17:    */   public DestinatarioTableModel()
/*  18:    */   {
/*  19: 29 */     this.data = new ArrayList();
/*  20: 30 */     this.destinatarios = new ArrayList();
/*  21:    */   }
/*  22:    */   
/*  23:    */   public int getColumnCount()
/*  24:    */   {
/*  25: 34 */     return this.columnNames.length;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public int getRowCount()
/*  29:    */   {
/*  30: 38 */     return this.data.size();
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getColumnName(int col)
/*  34:    */   {
/*  35: 43 */     return this.columnNames[col];
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Object getValueAt(int row, int col)
/*  39:    */   {
/*  40: 47 */     return ((Object[])this.data.get(row))[col];
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Object[] getRow(int row)
/*  44:    */   {
/*  45: 51 */     return (Object[])this.data.get(row);
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Class getColumnClass(int c)
/*  49:    */   {
/*  50: 56 */     return getValueAt(0, c).getClass();
/*  51:    */   }
/*  52:    */   
/*  53:    */   public boolean isCellEditable(int row, int col)
/*  54:    */   {
/*  55: 61 */     boolean resp = false;
/*  56: 62 */     if ((col == 1) || (col == 6)) {
/*  57: 63 */       resp = true;
/*  58:    */     }
/*  59: 65 */     return resp;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setValueAt(Object value, int row, int col)
/*  63:    */   {
/*  64: 70 */     if ((this.data.size() == 1) && (row == 1)) {
/*  65: 71 */       row--;
/*  66:    */     }
/*  67: 73 */     ((Object[])this.data.get(row))[col] = value;
/*  68: 74 */     fireTableCellUpdated(row, col);
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void deleteRow(int fila)
/*  72:    */   {
/*  73: 83 */     if (fila == -1) {
/*  74: 84 */       fila = 0;
/*  75:    */     }
/*  76: 86 */     Object[] item = (Object[])this.data.get(fila);
/*  77: 87 */     this.data.remove(item);
/*  78:    */     
/*  79: 89 */     DestinatarioProducto destinatario = buscarDestinatario((String)item[1]);
/*  80: 90 */     this.destinatarios.remove(destinatario);
/*  81:    */     
/*  82: 92 */     fireTableRowsDeleted(fila, fila);
/*  83:    */   }
/*  84:    */   
/*  85:    */   private DestinatarioProducto buscarDestinatario(String codigo)
/*  86:    */   {
/*  87:103 */     DestinatarioProducto encontrado = null;
/*  88:105 */     for (DestinatarioProducto item : this.destinatarios) {
/*  89:106 */       if (item.getDestinatario().getIdentificacionDestinatario().equals(codigo)) {
/*  90:107 */         encontrado = item;
/*  91:    */       }
/*  92:    */     }
/*  93:110 */     return encontrado;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void addRow(int numeroItems, Destinatario destinatario, List<Producto> productos)
/*  97:    */   {
/*  98:122 */     int filas = this.data.size();
/*  99:    */     
/* 100:124 */     Object[] item = { Integer.valueOf(numeroItems), destinatario.getIdentificacionDestinatario(), destinatario.getRazonSocialDestinatario(), destinatario.getNumDocSustento() == null ? "" : destinatario.getNumDocSustento(), destinatario.getFechaEmisionDocSustento() == null ? "" : destinatario.getFechaEmisionDocSustento(), Integer.valueOf(productos.size()), "" };
/* 101:    */     
/* 102:    */ 
/* 103:127 */     this.data.add(item);
/* 104:128 */     this.destinatarios.add(new DestinatarioProducto(destinatario, productos));
/* 105:    */     
/* 106:130 */     fireTableRowsInserted(filas, this.data.size());
/* 107:    */   }
/* 108:    */   
/* 109:    */   public List<DestinatarioProducto> getDestinatarios()
/* 110:    */   {
/* 111:134 */     return this.destinatarios;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setDestinatarios(List<DestinatarioProducto> destinatarios)
/* 115:    */   {
/* 116:138 */     this.destinatarios = destinatarios;
/* 117:    */   }
/* 118:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.DestinatarioTableModel
 * JD-Core Version:    0.7.0.1
 */