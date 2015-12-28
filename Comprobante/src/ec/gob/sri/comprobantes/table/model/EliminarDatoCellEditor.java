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
/* 12:   */ public class EliminarDatoCellEditor
/* 13:   */   extends AbstractCellEditor
/* 14:   */   implements TableCellEditor, ActionListener
/* 15:   */ {
/* 16:25 */   int col = 0;
/* 17:25 */   int fila = 0;
/* 18:   */   private JTable jTable1;
/* 19:   */   JButton button;
/* 20:   */   Boolean productoSeleccionado;
/* 21:   */   Boolean currentValue;
/* 22:   */   Producto producto;
/* 23:   */   
/* 24:   */   public EliminarDatoCellEditor(JTable jTable1)
/* 25:   */   {
/* 26:28 */     this.button = new JButton("Eliminar");
/* 27:29 */     this.button.setActionCommand("Eliminar");
/* 28:30 */     this.button.addActionListener(this);
/* 29:31 */     this.button.setBorderPainted(true);
/* 30:32 */     this.jTable1 = jTable1;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void actionPerformed(ActionEvent e)
/* 34:   */   {
/* 35:36 */     this.fila = this.jTable1.getSelectedRow();
/* 36:37 */     DatosAdicionalesTableModel model = (DatosAdicionalesTableModel)this.jTable1.getModel();
/* 37:38 */     model.deleteRow(this.fila);
/* 38:   */   }
/* 39:   */   
/* 40:   */   public Object getCellEditorValue()
/* 41:   */   {
/* 42:43 */     return this.currentValue;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 46:   */   {
/* 47:48 */     return this.button;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public Boolean getProductoSeleccionado()
/* 51:   */   {
/* 52:52 */     return this.productoSeleccionado;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setProductoSeleccionado(Boolean productoSeleccionado)
/* 56:   */   {
/* 57:56 */     this.productoSeleccionado = productoSeleccionado;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public Producto getProducto()
/* 61:   */   {
/* 62:60 */     return this.producto;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setProducto(Producto producto)
/* 66:   */   {
/* 67:64 */     this.producto = producto;
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.EliminarDatoCellEditor
 * JD-Core Version:    0.7.0.1
 */