/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*  4:   */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*  5:   */ import java.awt.Component;
/*  6:   */ import java.awt.event.ActionEvent;
/*  7:   */ import java.awt.event.ActionListener;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ import javax.swing.AbstractCellEditor;
/* 12:   */ import javax.swing.Icon;
/* 13:   */ import javax.swing.ImageIcon;
/* 14:   */ import javax.swing.JButton;
/* 15:   */ import javax.swing.JOptionPane;
/* 16:   */ import javax.swing.JTable;
/* 17:   */ import javax.swing.table.TableCellEditor;
/* 18:   */ import javax.swing.table.TableModel;
/* 19:   */ 
/* 20:   */ public class DeleteEditor
/* 21:   */   extends AbstractCellEditor
/* 22:   */   implements TableCellEditor, ActionListener
/* 23:   */ {
/* 24:30 */   int col = 0;
/* 25:30 */   int fila = 0;
/* 26:   */   private JTable jTable1;
/* 27:   */   protected static final String EDIT = "edit";
/* 28:   */   JButton button;
/* 29:   */   Boolean currentValue;
/* 30:   */   
/* 31:   */   public DeleteEditor(JTable jTable1)
/* 32:   */   {
/* 33:34 */     inicializarDatos();
/* 34:35 */     this.jTable1 = jTable1;
/* 35:   */   }
/* 36:   */   
/* 37:   */   private void inicializarDatos()
/* 38:   */   {
/* 39:38 */     this.button = new JButton();
/* 40:39 */     this.button.setActionCommand("edit");
/* 41:40 */     this.button.addActionListener(this);
/* 42:41 */     this.button.setBorderPainted(true);
/* 43:42 */     Icon editImage = new ImageIcon("resources/icons/eliminar.gif");
/* 44:43 */     this.button.setIcon(editImage);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void actionPerformed(ActionEvent e)
/* 48:   */   {
/* 49:48 */     this.fila = this.jTable1.getSelectedRow();
/* 50:49 */     this.col = this.jTable1.getSelectedColumn();
/* 51:50 */     String ruc = this.jTable1.getModel().getValueAt(this.fila, this.col - 3).toString();
/* 52:51 */     ClienteTableModel dftm = (ClienteTableModel)this.jTable1.getModel();
/* 53:   */     try
/* 54:   */     {
/* 55:53 */       int i = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el cliente?", "Advertencia", 0);
/* 56:54 */       if (i == 0)
/* 57:   */       {
/* 58:55 */         eliminarCliente(ruc);
/* 59:56 */         dftm.deleteRow(this.fila);
/* 60:   */       }
/* 61:   */     }
/* 62:   */     catch (SQLException ex)
/* 63:   */     {
/* 64:59 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 65:   */     }
/* 66:   */     catch (ClassNotFoundException ex)
/* 67:   */     {
/* 68:61 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 69:   */     }
/* 70:   */   }
/* 71:   */   
/* 72:   */   private void eliminarCliente(String identificacion)
/* 73:   */     throws SQLException, ClassNotFoundException
/* 74:   */   {
/* 75:66 */     ClientesSQL clienteSQL = new ClientesSQL();
/* 76:67 */     clienteSQL.eliminarCliente(getClienteSeleccionado(identificacion));
/* 77:   */   }
/* 78:   */   
/* 79:   */   private Clientes getClienteSeleccionado(String identificacion)
/* 80:   */     throws SQLException, ClassNotFoundException
/* 81:   */   {
/* 82:71 */     ClientesSQL clienteSQL = new ClientesSQL();
/* 83:72 */     Clientes c = clienteSQL.obtenerClienteRuc(identificacion);
/* 84:73 */     return c;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public Object getCellEditorValue()
/* 88:   */   {
/* 89:77 */     return this.currentValue;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 93:   */   {
/* 94:81 */     return this.button;
/* 95:   */   }
/* 96:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.DeleteEditor
 * JD-Core Version:    0.7.0.1
 */