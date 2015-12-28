/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.awt.Component;
/*  4:   */ import javax.swing.JButton;
/*  5:   */ import javax.swing.JLabel;
/*  6:   */ import javax.swing.JTable;
/*  7:   */ import javax.swing.table.TableCellRenderer;
/*  8:   */ 
/*  9:   */ public class EliminarRenderer
/* 10:   */   extends JLabel
/* 11:   */   implements TableCellRenderer
/* 12:   */ {
/* 13:15 */   boolean isBordered = true;
/* 14:   */   
/* 15:   */   public EliminarRenderer(boolean isBordered)
/* 16:   */   {
/* 17:18 */     this.isBordered = isBordered;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column)
/* 21:   */   {
/* 22:23 */     JButton boton = new JButton("Eliminar");
/* 23:24 */     return boton;
/* 24:   */   }
/* 25:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.EliminarRenderer
 * JD-Core Version:    0.7.0.1
 */