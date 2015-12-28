/*  1:   */ package ec.gob.sri.comprobantes.util.components;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import javax.swing.JDialog;
/*  5:   */ import javax.swing.JFileChooser;
/*  6:   */ import javax.swing.filechooser.FileFilter;
/*  7:   */ 
/*  8:   */ public class SRIFileChooser
/*  9:   */ {
/* 10:   */   public static JFileChooser obtenerFileChooserTxt()
/* 11:   */   {
/* 12:19 */     JDialog jd = new JDialog();
/* 13:20 */     JFileChooser jfc = new JFileChooser();
/* 14:21 */     jfc.setFileFilter(new FileFilter()
/* 15:   */     {
/* 16:   */       public boolean accept(File f)
/* 17:   */       {
/* 18:25 */         return (f.isDirectory()) || (f.getName().endsWith(".txt"));
/* 19:   */       }
/* 20:   */       
/* 21:   */       public String getDescription()
/* 22:   */       {
/* 23:30 */         return "text files (*.txt)";
/* 24:   */       }
/* 25:32 */     });
/* 26:33 */     jfc.showOpenDialog(jd);
/* 27:34 */     return jfc;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public static JFileChooser obtenerFileChooserImg()
/* 31:   */   {
/* 32:38 */     JDialog dialogoImagen = new JDialog();
/* 33:39 */     JFileChooser jfc = new JFileChooser();
/* 34:40 */     jfc.setFileSelectionMode(0);
/* 35:41 */     jfc.setAcceptAllFileFilterUsed(false);
/* 36:42 */     jfc.setFileFilter(new FileFilter()
/* 37:   */     {
/* 38:   */       public boolean accept(File file)
/* 39:   */       {
/* 40:46 */         String fileName = file.getName().toUpperCase();
/* 41:47 */         if ((file.isDirectory()) || (fileName.endsWith(".GIF")) || (fileName.endsWith(".JPEG")) || (fileName.endsWith(".JPG")) || (fileName.endsWith(".PNG"))) {
/* 42:48 */           return true;
/* 43:   */         }
/* 44:50 */         return false;
/* 45:   */       }
/* 46:   */       
/* 47:   */       public String getDescription()
/* 48:   */       {
/* 49:55 */         return "Image file (*.GIF, *.JPEG, *.jpg, *.png)";
/* 50:   */       }
/* 51:57 */     });
/* 52:58 */     jfc.showOpenDialog(dialogoImagen);
/* 53:59 */     return jfc;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public static JFileChooser obtenerFileChooserDirectorios()
/* 57:   */   {
/* 58:63 */     JDialog jd = new JDialog();
/* 59:64 */     JFileChooser jfc = new JFileChooser();
/* 60:65 */     jfc.setFileSelectionMode(1);
/* 61:66 */     jfc.showOpenDialog(jd);
/* 62:67 */     return jfc;
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.components.SRIFileChooser
 * JD-Core Version:    0.7.0.1
 */