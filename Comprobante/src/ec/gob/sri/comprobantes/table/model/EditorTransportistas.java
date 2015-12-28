/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*  4:   */ import ec.gob.sri.comprobantes.sql.TransportistaSQL;
/*  5:   */ import ec.gob.sri.comprobantes.view.modals.DialogoTransportista;
/*  6:   */ import java.awt.Component;
/*  7:   */ import java.awt.event.ActionEvent;
/*  8:   */ import java.awt.event.ActionListener;
/*  9:   */ import java.sql.SQLException;
/* 10:   */ import java.util.List;
/* 11:   */ import java.util.logging.Level;
/* 12:   */ import java.util.logging.Logger;
/* 13:   */ import javax.swing.AbstractCellEditor;
/* 14:   */ import javax.swing.Icon;
/* 15:   */ import javax.swing.ImageIcon;
/* 16:   */ import javax.swing.JButton;
/* 17:   */ import javax.swing.JTable;
/* 18:   */ import javax.swing.table.TableCellEditor;
/* 19:   */ import javax.swing.table.TableColumnModel;
/* 20:   */ import javax.swing.table.TableModel;
/* 21:   */ 
/* 22:   */ public class EditorTransportistas
/* 23:   */   extends AbstractCellEditor
/* 24:   */   implements TableCellEditor, ActionListener
/* 25:   */ {
/* 26:34 */   int col = 0;
/* 27:34 */   int fila = 0;
/* 28:   */   private JTable jTable1;
/* 29:   */   protected static final String EDIT = "edit";
/* 30:   */   JButton button;
/* 31:   */   Boolean currentValue;
/* 32:   */   
/* 33:   */   public EditorTransportistas(JTable jTable1)
/* 34:   */   {
/* 35:37 */     this.button = new JButton();
/* 36:38 */     this.button.setActionCommand("edit");
/* 37:39 */     this.button.addActionListener(this);
/* 38:40 */     this.button.setBorderPainted(true);
/* 39:41 */     Icon editImage = new ImageIcon("resources/icons/modificar.gif");
/* 40:42 */     this.button.setIcon(editImage);
/* 41:43 */     this.jTable1 = jTable1;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void actionPerformed(ActionEvent e)
/* 45:   */   {
/* 46:48 */     this.fila = this.jTable1.getSelectedRow();
/* 47:49 */     this.col = this.jTable1.getSelectedColumn();
/* 48:50 */     int columns = this.jTable1.getColumnModel().getColumnCount();
/* 49:51 */     String ruc = this.jTable1.getModel().getValueAt(this.fila, this.col - 1).toString();
/* 50:52 */     this.jTable1.setVisible(false);
/* 51:   */     try
/* 52:   */     {
/* 53:54 */       DialogoTransportista modal = new DialogoTransportista(null, true, getTransportistaSeleccionado(ruc));
/* 54:55 */       modal.setTitle("Administracionde Transportistas");
/* 55:56 */       modal.setLocationRelativeTo(null);
/* 56:57 */       modal.setVisible(true);
/* 57:   */     }
/* 58:   */     catch (SQLException ex)
/* 59:   */     {
/* 60:59 */       Logger.getLogger(EditorTransportistas.class.getName()).log(Level.SEVERE, null, ex);
/* 61:   */     }
/* 62:   */     catch (ClassNotFoundException ex)
/* 63:   */     {
/* 64:61 */       Logger.getLogger(EditorTransportistas.class.getName()).log(Level.SEVERE, null, ex);
/* 65:   */     }
/* 66:   */   }
/* 67:   */   
/* 68:   */   private Transportista getTransportistaSeleccionado(String identificacion)
/* 69:   */     throws SQLException, ClassNotFoundException
/* 70:   */   {
/* 71:66 */     TransportistaSQL transSQL = new TransportistaSQL();
/* 72:67 */     List<Transportista> list = transSQL.obtenerTransportista(null, identificacion, null);
/* 73:68 */     if ((list != null) && (!list.isEmpty())) {
/* 74:69 */       return (Transportista)list.get(0);
/* 75:   */     }
/* 76:71 */     return null;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public Object getCellEditorValue()
/* 80:   */   {
/* 81:75 */     return this.currentValue;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 85:   */   {
/* 86:79 */     return this.button;
/* 87:   */   }
/* 88:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.EditorTransportistas
 * JD-Core Version:    0.7.0.1
 */