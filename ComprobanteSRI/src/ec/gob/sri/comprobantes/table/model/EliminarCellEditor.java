/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.awt.Component;
/*  4:   */ import java.awt.event.ActionEvent;
/*  5:   */ import java.awt.event.ActionListener;
/*  6:   */ import javax.swing.AbstractCellEditor;
/*  7:   */ import javax.swing.JButton;
/*  8:   */ import javax.swing.JTable;
/*  9:   */ import javax.swing.table.TableCellEditor;
/* 10:   */ 
/* 11:   */ public class EliminarCellEditor
/* 12:   */   extends AbstractCellEditor
/* 13:   */   implements TableCellEditor, ActionListener
/* 14:   */ {
/* 15:22 */   int col = 0;
/* 16:22 */   int fila = 0;
/* 17:   */   private JTable tabla;
/* 18:   */   JButton button;
/* 19:   */   Boolean currentValue;
/* 20:   */   
/* 21:   */   public EliminarCellEditor(JTable jTable1)
/* 22:   */   {
/* 23:25 */     this.button = new JButton("Eliminar");
/* 24:26 */     this.button.setActionCommand("Eliminar");
/* 25:27 */     this.button.addActionListener(this);
/* 26:28 */     this.button.setBorderPainted(true);
/* 27:29 */     this.tabla = jTable1;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void actionPerformed(ActionEvent e)
/* 31:   */   {
/* 32:33 */     this.fila = this.tabla.getSelectedRow();
/* 33:34 */     if ((this.tabla.getModel() instanceof NotaDebitoTableModel))
/* 34:   */     {
/* 35:35 */       NotaDebitoTableModel model = (NotaDebitoTableModel)this.tabla.getModel();
/* 36:36 */       model.deleteRow(this.fila);
/* 37:   */     }
/* 38:38 */     if ((this.tabla.getModel() instanceof RetencionTableModel))
/* 39:   */     {
/* 40:39 */       RetencionTableModel model = (RetencionTableModel)this.tabla.getModel();
/* 41:40 */       model.deleteRow(this.fila);
/* 42:   */     }
/* 43:42 */     if ((this.tabla.getModel() instanceof ProductoTableModel))
/* 44:   */     {
/* 45:43 */       ProductoTableModel model = (ProductoTableModel)this.tabla.getModel();
/* 46:44 */       model.deleteRow(this.fila);
/* 47:   */     }
/* 48:46 */     if ((this.tabla.getModel() instanceof DestinatarioTableModel))
/* 49:   */     {
/* 50:47 */       DestinatarioTableModel model = (DestinatarioTableModel)this.tabla.getModel();
/* 51:48 */       model.deleteRow(this.fila);
/* 52:   */     }
/* 53:   */   }
/* 54:   */   
/* 55:   */   public Object getCellEditorValue()
/* 56:   */   {
/* 57:54 */     return this.currentValue;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 61:   */   {
/* 62:59 */     return this.button;
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.EliminarCellEditor
 * JD-Core Version:    0.7.0.1
 */