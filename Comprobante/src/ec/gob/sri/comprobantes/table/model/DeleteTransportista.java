/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*  4:   */ import ec.gob.sri.comprobantes.sql.TransportistaSQL;
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
/* 20:   */ public class DeleteTransportista
/* 21:   */   extends AbstractCellEditor
/* 22:   */   implements TableCellEditor, ActionListener
/* 23:   */ {
/* 24:31 */   int col = 0;
/* 25:31 */   int fila = 0;
/* 26:   */   private JTable jTable1;
/* 27:   */   protected static final String EDIT = "edit";
/* 28:   */   JButton button;
/* 29:   */   Boolean currentValue;
/* 30:   */   
/* 31:   */   public DeleteTransportista(JTable jTable1)
/* 32:   */   {
/* 33:35 */     inicializarDatos();
/* 34:36 */     this.jTable1 = jTable1;
/* 35:   */   }
/* 36:   */   
/* 37:   */   private void inicializarDatos()
/* 38:   */   {
/* 39:39 */     this.button = new JButton();
/* 40:40 */     this.button.setActionCommand("edit");
/* 41:41 */     this.button.addActionListener(this);
/* 42:42 */     this.button.setBorderPainted(true);
/* 43:43 */     Icon editImage = new ImageIcon("resources/icons/eliminar.gif");
/* 44:44 */     this.button.setIcon(editImage);
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void actionPerformed(ActionEvent e)
/* 48:   */   {
/* 49:49 */     this.fila = this.jTable1.getSelectedRow();
/* 50:50 */     this.col = this.jTable1.getSelectedColumn();
/* 51:51 */     String ruc = this.jTable1.getModel().getValueAt(this.fila, this.col - 2).toString();
/* 52:52 */     TransportistaTableModel dftm = (TransportistaTableModel)this.jTable1.getModel();
/* 53:   */     try
/* 54:   */     {
/* 55:54 */       int i = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el transportista?", "Advertencia", 0);
/* 56:55 */       if (i == 0)
/* 57:   */       {
/* 58:56 */         eliminarTRansportista(ruc);
/* 59:57 */         dftm.deleteRow(this.fila);
/* 60:   */       }
/* 61:   */     }
/* 62:   */     catch (SQLException ex)
/* 63:   */     {
/* 64:60 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 65:   */     }
/* 66:   */     catch (ClassNotFoundException ex)
/* 67:   */     {
/* 68:62 */       Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
/* 69:   */     }
/* 70:   */   }
/* 71:   */   
/* 72:   */   private void eliminarTRansportista(String identificacion)
/* 73:   */     throws SQLException, ClassNotFoundException
/* 74:   */   {
/* 75:67 */     TransportistaSQL trSQL = new TransportistaSQL();
/* 76:68 */     trSQL.eliminarTransportista(getTransportistaSeleccionado(identificacion));
/* 77:   */   }
/* 78:   */   
/* 79:   */   private Transportista getTransportistaSeleccionado(String identificacion)
/* 80:   */     throws SQLException, ClassNotFoundException
/* 81:   */   {
/* 82:72 */     TransportistaSQL trSQL = new TransportistaSQL();
/* 83:73 */     Transportista tr = trSQL.obtenerTransportistaIdentificacion(identificacion);
/* 84:74 */     return tr;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public Object getCellEditorValue()
/* 88:   */   {
/* 89:78 */     return this.currentValue;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 93:   */   {
/* 94:82 */     return this.button;
/* 95:   */   }
/* 96:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.DeleteTransportista
 * JD-Core Version:    0.7.0.1
 */