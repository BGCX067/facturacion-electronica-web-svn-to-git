/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*  4:   */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*  5:   */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  6:   */ import ec.gob.sri.comprobantes.view.modals.DialogoProducto;
/*  7:   */ import java.awt.Component;
/*  8:   */ import java.awt.event.ActionEvent;
/*  9:   */ import java.awt.event.ActionListener;
/* 10:   */ import java.sql.SQLException;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ import javax.swing.AbstractCellEditor;
/* 14:   */ import javax.swing.Icon;
/* 15:   */ import javax.swing.ImageIcon;
/* 16:   */ import javax.swing.JButton;
/* 17:   */ import javax.swing.JTable;
/* 18:   */ import javax.swing.table.TableCellEditor;
/* 19:   */ import javax.swing.table.TableModel;
/* 20:   */ 
/* 21:   */ public class EditorProducto
/* 22:   */   extends AbstractCellEditor
/* 23:   */   implements TableCellEditor, ActionListener
/* 24:   */ {
/* 25:34 */   int col = 0;
/* 26:34 */   int fila = 0;
/* 27:   */   private JTable jTable1;
/* 28:   */   protected static final String EDIT = "edit";
/* 29:   */   JButton button;
/* 30:   */   Boolean currentValue;
/* 31:   */   
/* 32:   */   public EditorProducto(JTable jTable1)
/* 33:   */   {
/* 34:37 */     this.button = new JButton();
/* 35:38 */     this.button.setActionCommand("edit");
/* 36:39 */     this.button.addActionListener(this);
/* 37:40 */     this.button.setBorderPainted(true);
/* 38:41 */     this.jTable1 = jTable1;
/* 39:   */     
/* 40:43 */     Icon editImage = new ImageIcon("resources/icons/modificar.gif");
/* 41:44 */     this.button.setIcon(editImage);
/* 42:45 */     this.jTable1 = jTable1;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void actionPerformed(ActionEvent e)
/* 46:   */   {
/* 47:50 */     this.fila = this.jTable1.getSelectedRow();
/* 48:51 */     this.col = this.jTable1.getSelectedColumn();
/* 49:52 */     String codigoPrincipal = this.jTable1.getModel().getValueAt(this.fila, 0).toString();
/* 50:53 */     String codigoAuxiliar = this.jTable1.getModel().getValueAt(this.fila, 1).toString();
/* 51:54 */     String descripcion = this.jTable1.getModel().getValueAt(this.fila, 2).toString();
/* 52:55 */     String tipoProducto = this.jTable1.getModel().getValueAt(this.fila, 3).toString();
/* 53:56 */     this.jTable1.setVisible(false);
/* 54:   */     try
/* 55:   */     {
/* 56:58 */       ProductoSQL sql = new ProductoSQL();
/* 57:59 */       Producto pro = sql.obtenerProductoPorTipo(codigoPrincipal, codigoAuxiliar, descripcion, StringUtil.getTipoProducto(tipoProducto));
/* 58:60 */       DialogoProducto modal = new DialogoProducto(null, true, pro);
/* 59:61 */       modal.setTitle("Administración Producto");
/* 60:62 */       modal.setLocationRelativeTo(null);
/* 61:63 */       modal.setVisible(true);
/* 62:   */     }
/* 63:   */     catch (SQLException ex)
/* 64:   */     {
/* 65:65 */       Logger.getLogger(EditorProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 66:   */     }
/* 67:   */     catch (ClassNotFoundException ex)
/* 68:   */     {
/* 69:67 */       Logger.getLogger(EditorProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 70:   */     }
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Object getCellEditorValue()
/* 74:   */   {
/* 75:72 */     return this.currentValue;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 79:   */   {
/* 80:76 */     return this.button;
/* 81:   */   }
/* 82:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.EditorProducto
 * JD-Core Version:    0.7.0.1
 */