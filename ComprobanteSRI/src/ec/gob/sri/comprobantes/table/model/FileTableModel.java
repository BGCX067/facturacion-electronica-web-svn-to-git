/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.FilenameFilter;
/*   5:    */ import java.text.DateFormat;
/*   6:    */ import java.text.SimpleDateFormat;
/*   7:    */ import java.util.Calendar;
/*   8:    */ import javax.swing.table.AbstractTableModel;
/*   9:    */ 
/*  10:    */ public class FileTableModel
/*  11:    */   extends AbstractTableModel
/*  12:    */ {
/*  13:    */   private static final int COLUMNAS_ARCHIVOS = 4;
/*  14: 24 */   final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
/*  15:    */   private File directorio;
/*  16:    */   private String[] filenames;
/*  17:    */   private Boolean[] seleccionados;
/*  18: 28 */   String[] columnNames = { "Seleccionar", "Nombre", "Tamaño", "Ultima modificación" };
/*  19: 29 */   boolean[] canEdit = { true, false, false, false };
/*  20: 30 */   Class[] columnClasses = { Boolean.class, String.class, String.class, String.class };
/*  21:    */   
/*  22:    */   public FileTableModel(File dir)
/*  23:    */   {
/*  24: 35 */     FilenameFilter only = new FiltroArchivosExtension("xml");
/*  25:    */     
/*  26: 37 */     this.directorio = dir;
/*  27: 38 */     this.filenames = dir.list(only);
/*  28: 40 */     if (this.filenames != null)
/*  29:    */     {
/*  30: 41 */       int numeroArchivos = dir.list().length;
/*  31: 42 */       this.seleccionados = new Boolean[numeroArchivos];
/*  32:    */     }
/*  33:    */   }
/*  34:    */   
/*  35:    */   public int getColumnCount()
/*  36:    */   {
/*  37: 48 */     return 4;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public int getRowCount()
/*  41:    */   {
/*  42: 52 */     return this.filenames.length;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getColumnName(int col)
/*  46:    */   {
/*  47: 58 */     return this.columnNames[col];
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Class getColumnClass(int col)
/*  51:    */   {
/*  52: 63 */     return this.columnClasses[col];
/*  53:    */   }
/*  54:    */   
/*  55:    */   public Object getValueAt(int row, int col)
/*  56:    */   {
/*  57: 68 */     File f = new File(this.directorio, this.filenames[row]);
/*  58: 69 */     switch (col)
/*  59:    */     {
/*  60:    */     case 0: 
/*  61: 71 */       return this.seleccionados[row];
/*  62:    */     case 1: 
/*  63: 73 */       return this.filenames[row];
/*  64:    */     case 2: 
/*  65: 75 */       return new Float((float)(f.length() / 1024L)).longValue() + " KB";
/*  66:    */     case 3: 
/*  67: 77 */       Calendar cal = Calendar.getInstance();
/*  68: 78 */       cal.setTimeInMillis(f.lastModified());
/*  69: 79 */       return this.formatter.format(cal.getTime());
/*  70:    */     }
/*  71: 81 */     return null;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public boolean isCellEditable(int rowIndex, int columnIndex)
/*  75:    */   {
/*  76: 87 */     return this.canEdit[columnIndex];
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setValueAt(Object value, int rowIndex, int columnIndex)
/*  80:    */   {
/*  81: 92 */     this.seleccionados[rowIndex] = ((Boolean)value);
/*  82: 93 */     super.fireTableCellUpdated(rowIndex, 0);
/*  83:    */   }
/*  84:    */   
/*  85:    */   public File getDirectorio()
/*  86:    */   {
/*  87: 97 */     return this.directorio;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setDirectorio(File directorio)
/*  91:    */   {
/*  92:101 */     this.directorio = directorio;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String[] getFilenames()
/*  96:    */   {
/*  97:105 */     return this.filenames;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setFilenames(String[] filenames)
/* 101:    */   {
/* 102:109 */     this.filenames = filenames;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public Boolean[] getSeleccionados()
/* 106:    */   {
/* 107:113 */     return this.seleccionados;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setSeleccionados(Boolean[] seleccionados)
/* 111:    */   {
/* 112:117 */     this.seleccionados = seleccionados;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void seleccionarTodos(boolean value)
/* 116:    */   {
/* 117:121 */     for (int i = 0; i < this.seleccionados.length; i++) {
/* 118:122 */       this.seleccionados[i] = Boolean.valueOf(value);
/* 119:    */     }
/* 120:    */   }
/* 121:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.FileTableModel
 * JD-Core Version:    0.7.0.1
 */