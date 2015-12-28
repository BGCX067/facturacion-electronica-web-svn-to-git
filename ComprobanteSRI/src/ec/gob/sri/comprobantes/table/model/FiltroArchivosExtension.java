/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import java.io.File;
/*   4:    */ import java.io.FilenameFilter;
/*   5:    */ 
/*   6:    */ class FiltroArchivosExtension
/*   7:    */   implements FilenameFilter
/*   8:    */ {
/*   9:    */   String ext;
/*  10:    */   
/*  11:    */   public FiltroArchivosExtension(String ext)
/*  12:    */   {
/*  13:136 */     this.ext = ("." + ext);
/*  14:    */   }
/*  15:    */   
/*  16:    */   public boolean accept(File dir, String name)
/*  17:    */   {
/*  18:140 */     return (name.endsWith(this.ext)) || (name.endsWith(this.ext.toUpperCase()));
/*  19:    */   }
/*  20:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.FiltroArchivosExtension
 * JD-Core Version:    0.7.0.1
 */