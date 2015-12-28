/*  1:   */ package ec.gob.sri.comprobantes.table.model;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.io.FilenameFilter;
/*  5:   */ import java.text.DateFormat;
/*  6:   */ import java.text.SimpleDateFormat;
/*  7:   */ import java.util.Calendar;
/*  8:   */ import javax.swing.table.AbstractTableModel;
/*  9:   */ 
/* 10:   */ public class VisualizacionTableModel
/* 11:   */   extends AbstractTableModel
/* 12:   */ {
/* 13:   */   private static final int COLUMNAS_ARCHIVOS = 4;
/* 14:25 */   final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
/* 15:   */   private File directorio;
/* 16:   */   private String[] filenames;
/* 17:28 */   String[] columnNames = { "Nombre", "Tamaño", "Última Modificación", " " };
/* 18:29 */   boolean[] canEdit = { false, false, false, true };
/* 19:   */   
/* 20:   */   public VisualizacionTableModel(File dir)
/* 21:   */   {
/* 22:34 */     FilenameFilter only = new FiltroArchivosExtensionRide("xml");
/* 23:35 */     this.directorio = dir;
/* 24:36 */     this.filenames = dir.list(only);
/* 25:   */   }
/* 26:   */   
/* 27:   */   public int getColumnCount()
/* 28:   */   {
/* 29:42 */     return 4;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public int getRowCount()
/* 33:   */   {
/* 34:47 */     return this.filenames.length;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getColumnName(int col)
/* 38:   */   {
/* 39:53 */     return this.columnNames[col];
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Object getValueAt(int row, int col)
/* 43:   */   {
/* 44:64 */     File f = new File(this.directorio, this.filenames[row]);
/* 45:65 */     switch (col)
/* 46:   */     {
/* 47:   */     case 0: 
/* 48:67 */       return this.filenames[row];
/* 49:   */     case 1: 
/* 50:69 */       return new Float((float)(f.length() / 1024L)).longValue() + " KB";
/* 51:   */     case 2: 
/* 52:71 */       Calendar cal = Calendar.getInstance();
/* 53:72 */       cal.setTimeInMillis(f.lastModified());
/* 54:73 */       return this.formatter.format(cal.getTime());
/* 55:   */     }
/* 56:75 */     return null;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public boolean isCellEditable(int rowIndex, int columnIndex)
/* 60:   */   {
/* 61:81 */     return this.canEdit[columnIndex];
/* 62:   */   }
/* 63:   */   
/* 64:   */   public File getDirectorio()
/* 65:   */   {
/* 66:85 */     return this.directorio;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setDirectorio(File directorio)
/* 70:   */   {
/* 71:89 */     this.directorio = directorio;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public String[] getFilenames()
/* 75:   */   {
/* 76:93 */     return this.filenames;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public void setFilenames(String[] filenames)
/* 80:   */   {
/* 81:97 */     this.filenames = filenames;
/* 82:   */   }
/* 83:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.VisualizacionTableModel
 * JD-Core Version:    0.7.0.1
 */