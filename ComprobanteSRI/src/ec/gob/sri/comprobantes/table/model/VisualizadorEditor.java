/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*  4:   */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*  5:   */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*  6:   */ import ec.gob.sri.comprobantes.util.VisualizacionRideUtil;
/*  7:   */ import java.awt.Component;
/*  8:   */ import java.awt.event.ActionEvent;
/*  9:   */ import java.awt.event.ActionListener;
/* 10:   */ import java.io.File;
/* 11:   */ import java.sql.SQLException;
/* 12:   */ import javax.swing.AbstractCellEditor;
/* 13:   */ import javax.swing.Icon;
/* 14:   */ import javax.swing.ImageIcon;
/* 15:   */ import javax.swing.JButton;
/* 16:   */ import javax.swing.JTable;
/* 17:   */ import javax.swing.table.TableCellEditor;
/* 18:   */ import javax.swing.table.TableModel;
/* 19:   */ 
/* 20:   */ public class VisualizadorEditor
/* 21:   */   extends AbstractCellEditor
/* 22:   */   implements TableCellEditor, ActionListener
/* 23:   */ {
/* 24:   */   File path;
/* 25:32 */   int col = 0;
/* 26:32 */   int fila = 0;
/* 27:   */   private JTable jTable1;
/* 28:   */   protected static final String EDIT = "edit";
/* 29:   */   JButton button;
/* 30:   */   Boolean currentValue;
/* 31:   */   
/* 32:   */   public VisualizadorEditor(JTable jTable1, File path)
/* 33:   */   {
/* 34:36 */     inicializarDatos();
/* 35:37 */     this.jTable1 = jTable1;
/* 36:38 */     this.path = path;
/* 37:   */   }
/* 38:   */   
/* 39:   */   private void inicializarDatos()
/* 40:   */   {
/* 41:42 */     this.button = new JButton();
/* 42:43 */     this.button.setActionCommand("edit");
/* 43:44 */     this.button.addActionListener(this);
/* 44:45 */     this.button.setBorderPainted(true);
/* 45:46 */     this.button.setSize(25, 15);
/* 46:47 */     Icon editImage = new ImageIcon("resources/icons/exportar_pdf.gif");
/* 47:48 */     this.button.setIcon(editImage);
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void actionPerformed(ActionEvent e)
/* 51:   */   {
/* 52:53 */     this.fila = this.jTable1.getSelectedRow();
/* 53:54 */     this.col = this.jTable1.getSelectedColumn();
/* 54:55 */     String pathFile = this.jTable1.getModel().getValueAt(this.fila, this.col - 3).toString();
/* 55:56 */     VisualizacionRideUtil.decodeArchivoBase64(this.path.getPath() + File.separator + pathFile, null, null);
/* 56:   */   }
/* 57:   */   
/* 58:   */   private String getDirectorioAutorizados()
/* 59:   */     throws SQLException, ClassNotFoundException
/* 60:   */   {
/* 61:60 */     String pathAutorizados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.AUTORIZADOS.getCode()).getPath();
/* 62:61 */     return pathAutorizados;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Object getCellEditorValue()
/* 66:   */   {
/* 67:67 */     return this.currentValue;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/* 71:   */   {
/* 72:73 */     return this.button;
/* 73:   */   }
/* 74:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.VisualizadorEditor
 * JD-Core Version:    0.7.0.1
 */