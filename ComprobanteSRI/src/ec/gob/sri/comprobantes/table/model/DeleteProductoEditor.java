/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*  4:   */ import java.awt.Component;
/*  5:   */ import java.awt.event.ActionEvent;
/*  6:   */ import java.awt.event.ActionListener;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;
/* 10:   */ import javax.swing.AbstractCellEditor;
/* 11:   */ import javax.swing.Icon;
/* 12:   */ import javax.swing.ImageIcon;
/* 13:   */ import javax.swing.JButton;
/* 14:   */ import javax.swing.JOptionPane;
/* 15:   */ import javax.swing.JTable;
/* 16:   */ import javax.swing.table.TableCellEditor;
/* 17:   */ import javax.swing.table.TableModel;
/* 18:   */ 
/* 19:   */ public class DeleteProductoEditor
/* 20:   */   extends AbstractCellEditor
/* 21:   */   implements TableCellEditor, ActionListener
/* 22:   */ {
/* 23:29 */   int col = 0;
/* 24:29 */   int fila = 0;
/* 25:   */   private JTable jTable1;
/* 26:   */   protected static final String EDIT = "edit";
/* 27:   */   JButton button;
/* 28:   */   Boolean currentValue;
/* 29:   */   
/* 30:   */   public DeleteProductoEditor(JTable jTable1)
/* 31:   */   {
/* 32:33 */     inicializarDatos();
/* 33:34 */     this.jTable1 = jTable1;
/* 34:   */   }
/* 35:   */   
/* 36:   */   private void inicializarDatos()
/* 37:   */   {
/* 38:37 */     this.button = new JButton();
/* 39:38 */     this.button.setActionCommand("edit");
/* 40:39 */     this.button.addActionListener(this);
/* 41:40 */     this.button.setBorderPainted(true);
/* 42:41 */     Icon editImage = new ImageIcon("resources/icons/eliminar.gif");
/* 43:42 */     this.button.setIcon(editImage);
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void actionPerformed(ActionEvent e)
/* 47:   */   {
/* 48:48 */     this.fila = this.jTable1.getSelectedRow();
/* 49:49 */     this.col = this.jTable1.getSelectedColumn();
/* 50:50 */     String codigoProducto = this.jTable1.getModel().getValueAt(this.fila, 0).toString();
/* 51:51 */     ProductosTableModel dftm = (ProductosTableModel)this.jTable1.getModel();
/* 52:   */     try
/* 53:   */     {
/* 54:53 */       int i = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el Producto?", "Advertencia", 0);
/* 55:54 */       if (i == 0)
/* 56:   */       {
/* 57:55 */         eliminarProducto(codigoProducto);
/* 58:56 */         dftm.deleteRow(this.fila);
/* 59:   */       }
/* 60:   */     }
/* 61:   */     catch (SQLException ex)
/* 62:   */     {
/* 63:59 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 64:   */     }
/* 65:   */     catch (ClassNotFoundException ex)
/* 66:   */     {
/* 67:61 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 68:   */     }
/* 69:   */   }
/* 70:   */   
/* 71:   */   private void eliminarProducto(String codigoProducto)
/* 72:   */     throws SQLException, ClassNotFoundException
/* 73:   */   {
/* 74:66 */     ProductoSQL productoSQL = new ProductoSQL();
/* 75:67 */     productoSQL.deleteProducto(codigoProducto);
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Object getCellEditorValue()
/* 79:   */   {
/* 80:73 */     return this.currentValue;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 84:   */   {
/* 85:78 */     return this.button;
/* 86:   */   }
/* 87:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.DeleteProductoEditor
 * JD-Core Version:    0.7.0.1
 */