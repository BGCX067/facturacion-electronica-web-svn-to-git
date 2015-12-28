/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   4:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   5:    */ import ec.gob.sri.comprobantes.view.modals.DialogoProductos;
/*   6:    */ import java.awt.Component;
/*   7:    */ import java.awt.Container;
/*   8:    */ import java.awt.event.ActionEvent;
/*   9:    */ import java.awt.event.ActionListener;
/*  10:    */ import java.sql.SQLException;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ import javax.swing.AbstractCellEditor;
/*  15:    */ import javax.swing.JButton;
/*  16:    */ import javax.swing.JTable;
/*  17:    */ import javax.swing.table.TableCellEditor;
/*  18:    */ import javax.swing.table.TableModel;
/*  19:    */ 
/*  20:    */ public class SeleccionarProductoCellEditor
/*  21:    */   extends AbstractCellEditor
/*  22:    */   implements TableCellEditor, ActionListener
/*  23:    */ {
/*  24: 36 */   int col = 0;
/*  25: 36 */   int fila = 0;
/*  26:    */   private JTable jTable1;
/*  27:    */   protected static final String SELECCION = "Seleccionado";
/*  28:    */   JButton button;
/*  29:    */   Boolean productoSeleccionado;
/*  30:    */   Boolean currentValue;
/*  31:    */   Producto producto;
/*  32:    */   
/*  33:    */   public SeleccionarProductoCellEditor(JTable jTable1)
/*  34:    */   {
/*  35: 39 */     this.button = new JButton();
/*  36: 40 */     this.button.setActionCommand("Seleccionado");
/*  37: 41 */     this.button.addActionListener(this);
/*  38: 42 */     this.button.setBorderPainted(true);
/*  39: 43 */     this.jTable1 = jTable1;
/*  40:    */   }
/*  41:    */   
/*  42:    */   private void obtenerInstancia(Container c)
/*  43:    */   {
/*  44: 47 */     if ((c instanceof DialogoProductos))
/*  45:    */     {
/*  46: 48 */       DialogoProductos dialog = (DialogoProductos)c;
/*  47: 49 */       dialog.setProducto(this.producto);
/*  48: 50 */       c.setVisible(false);
/*  49:    */     }
/*  50:    */     else
/*  51:    */     {
/*  52: 52 */       obtenerInstancia(c.getParent());
/*  53:    */     }
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void actionPerformed(ActionEvent e)
/*  57:    */   {
/*  58: 60 */     this.fila = this.jTable1.getSelectedRow();
/*  59:    */     try
/*  60:    */     {
/*  61: 64 */       String codigoPrincipal = this.jTable1.getModel().getValueAt(this.fila, 0).toString();
/*  62: 65 */       String codigoAuxiliar = this.jTable1.getModel().getValueAt(this.fila, 1).toString();
/*  63: 66 */       String descripcion = this.jTable1.getModel().getValueAt(this.fila, 2).toString();
/*  64: 67 */       this.producto = getProductoSeleccionado(codigoPrincipal, codigoAuxiliar, descripcion);
/*  65: 68 */       if (this.producto != null)
/*  66:    */       {
/*  67: 69 */         this.productoSeleccionado = Boolean.valueOf(true);
/*  68: 70 */         Container c = this.button.getParent();
/*  69: 71 */         obtenerInstancia(c);
/*  70:    */       }
/*  71:    */     }
/*  72:    */     catch (Exception ex)
/*  73:    */     {
/*  74: 75 */       Logger.getLogger(SeleccionarProductoCellEditor.class.getName()).log(Level.SEVERE, null, ex);
/*  75:    */     }
/*  76:    */   }
/*  77:    */   
/*  78:    */   private Producto getProductoSeleccionado(String codigoPrincipal, String codigoAuxiliar, String descripcion)
/*  79:    */     throws SQLException, ClassNotFoundException
/*  80:    */   {
/*  81: 80 */     ProductoSQL prodSQL = new ProductoSQL();
/*  82: 81 */     List<Producto> list = prodSQL.obtenerProducto(codigoPrincipal, codigoAuxiliar, descripcion);
/*  83: 82 */     if ((list != null) && (!list.isEmpty())) {
/*  84: 83 */       return (Producto)list.get(0);
/*  85:    */     }
/*  86: 85 */     return null;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Object getCellEditorValue()
/*  90:    */   {
/*  91: 90 */     return this.currentValue;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/*  95:    */   {
/*  96: 95 */     return this.button;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Boolean getProductoSeleccionado()
/* 100:    */   {
/* 101: 99 */     return this.productoSeleccionado;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setProductoSeleccionado(Boolean productoSeleccionado)
/* 105:    */   {
/* 106:103 */     this.productoSeleccionado = productoSeleccionado;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Producto getProducto()
/* 110:    */   {
/* 111:107 */     return this.producto;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setProducto(Producto producto)
/* 115:    */   {
/* 116:111 */     this.producto = producto;
/* 117:    */   }
/* 118:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.SeleccionarProductoCellEditor
 * JD-Core Version:    0.7.0.1
 */