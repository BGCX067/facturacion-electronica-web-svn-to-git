/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*  4:   */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*  5:   */ import ec.gob.sri.comprobantes.view.modals.DialogoCliente;
/*  6:   */ import java.awt.Component;
/*  7:   */ import java.awt.event.ActionEvent;
/*  8:   */ import java.awt.event.ActionListener;
/*  9:   */ import java.sql.SQLException;
/* 10:   */ import java.util.logging.Level;
/* 11:   */ import java.util.logging.Logger;
/* 12:   */ import javax.swing.AbstractCellEditor;
/* 13:   */ import javax.swing.Icon;
/* 14:   */ import javax.swing.ImageIcon;
/* 15:   */ import javax.swing.JButton;
/* 16:   */ import javax.swing.JTable;
/* 17:   */ import javax.swing.table.TableCellEditor;
/* 18:   */ import javax.swing.table.TableModel;
/* 19:   */ 
/* 20:   */ public class MyEditor
/* 21:   */   extends AbstractCellEditor
/* 22:   */   implements TableCellEditor, ActionListener
/* 23:   */ {
/* 24:33 */   int col = 0;
/* 25:33 */   int fila = 0;
/* 26:   */   private JTable jTable1;
/* 27:   */   protected static final String EDIT = "edit";
/* 28:   */   JButton button;
/* 29:   */   Boolean currentValue;
/* 30:   */   
/* 31:   */   public MyEditor(JTable jTable1)
/* 32:   */   {
/* 33:36 */     inicializarDatos();
/* 34:37 */     this.jTable1 = jTable1;
/* 35:   */   }
/* 36:   */   
/* 37:   */   private void inicializarDatos()
/* 38:   */   {
/* 39:41 */     this.button = new JButton();
/* 40:42 */     this.button.setActionCommand("edit");
/* 41:43 */     this.button.addActionListener(this);
/* 42:44 */     this.button.setBorderPainted(true);
/* 43:45 */     Icon editImage = new ImageIcon("resources/icons/modificar.gif");
/* 44:46 */     this.button.setIcon(editImage);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void actionPerformed(ActionEvent e)
/* 48:   */   {
/* 49:53 */     this.fila = this.jTable1.getSelectedRow();
/* 50:54 */     this.col = this.jTable1.getSelectedColumn();
/* 51:55 */     String ruc = this.jTable1.getModel().getValueAt(this.fila, this.col - 2).toString();
/* 52:56 */     this.jTable1.setVisible(false);
/* 53:   */     try
/* 54:   */     {
/* 55:58 */       DialogoCliente modal = new DialogoCliente(null, true, getClienteSeleccionado(ruc));
/* 56:59 */       modal.setTitle("Administración de clientes");
/* 57:60 */       modal.setLocationRelativeTo(null);
/* 58:61 */       modal.setVisible(true);
/* 59:   */     }
/* 60:   */     catch (SQLException ex)
/* 61:   */     {
/* 62:63 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 63:   */     }
/* 64:   */     catch (ClassNotFoundException ex)
/* 65:   */     {
/* 66:65 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 67:   */     }
/* 68:   */   }
/* 69:   */   
/* 70:   */   private Clientes getClienteSeleccionado(String identificacion)
/* 71:   */     throws SQLException, ClassNotFoundException
/* 72:   */   {
/* 73:70 */     ClientesSQL clienteSQL = new ClientesSQL();
/* 74:71 */     Clientes c = clienteSQL.obtenerClienteRuc(identificacion);
/* 75:72 */     return c;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Object getCellEditorValue()
/* 79:   */   {
/* 80:77 */     return this.currentValue;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 84:   */   {
/* 85:82 */     return this.button;
/* 86:   */   }
/* 87:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.MyEditor
 * JD-Core Version:    0.7.0.1
 */