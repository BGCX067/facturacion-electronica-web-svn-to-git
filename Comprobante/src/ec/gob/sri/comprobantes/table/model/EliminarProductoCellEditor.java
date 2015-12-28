/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*  4:   */ import java.awt.Component;
/*  5:   */ import java.awt.event.ActionEvent;
/*  6:   */ import java.awt.event.ActionListener;
/*  7:   */ import javax.swing.AbstractCellEditor;
/*  8:   */ import javax.swing.JButton;
/*  9:   */ import javax.swing.JTable;
/* 10:   */ import javax.swing.table.TableCellEditor;
/* 11:   */ 
/* 12:   */ public class EliminarProductoCellEditor
/* 13:   */   extends AbstractCellEditor
/* 14:   */   implements TableCellEditor, ActionListener
/* 15:   */ {
/* 16:25 */   int col = 0;
/* 17:25 */   int fila = 0;
/* 18:   */   private JTable tabla;
/* 19:   */   JButton button;
/* 20:   */   Boolean productoSeleccionado;
/* 21:   */   Boolean currentValue;
/* 22:   */   Producto producto;
/* 23:   */   
/* 24:   */   public EliminarProductoCellEditor(JTable jTable1)
/* 25:   */   {
/* 26:28 */     this.button = new JButton("Eliminar");
/* 27:29 */     this.button.setActionCommand("Eliminar");
/* 28:30 */     this.button.addActionListener(this);
/* 29:31 */     this.button.setBorderPainted(true);
/* 30:32 */     this.tabla = jTable1;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void actionPerformed(ActionEvent e)
/* 34:   */   {
/* 35:36 */     this.fila = this.tabla.getSelectedRow();
/* 36:38 */     if ((this.tabla.getModel() instanceof FacturaModel))
/* 37:   */     {
/* 38:39 */       FacturaModel model = (FacturaModel)this.tabla.getModel();
/* 39:40 */       model.deleteRow(this.fila);
/* 40:   */     }
/* 41:43 */     if ((this.tabla.getModel() instanceof NotaCreditoModel))
/* 42:   */     {
/* 43:44 */       NotaCreditoModel model = (NotaCreditoModel)this.tabla.getModel();
/* 44:45 */       model.deleteRow(this.fila);
/* 45:   */     }
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Object getCellEditorValue()
/* 49:   */   {
/* 50:52 */     return this.currentValue;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 54:   */   {
/* 55:57 */     return this.button;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Boolean getProductoSeleccionado()
/* 59:   */   {
/* 60:61 */     return this.productoSeleccionado;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public void setProductoSeleccionado(Boolean productoSeleccionado)
/* 64:   */   {
/* 65:65 */     this.productoSeleccionado = productoSeleccionado;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public Producto getProducto()
/* 69:   */   {
/* 70:69 */     return this.producto;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setProducto(Producto producto)
/* 74:   */   {
/* 75:73 */     this.producto = producto;
/* 76:   */   }
/* 77:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.EliminarProductoCellEditor
 * JD-Core Version:    0.7.0.1
 */