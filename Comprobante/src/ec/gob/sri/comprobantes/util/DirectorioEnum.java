/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum DirectorioEnum
/*  4:   */ {
/*  5:10 */   GENERADOS(1),  FIRMADOS(2),  AUTORIZADOS(3),  NO_AUTORIZADOS(4);
/*  6:   */   
/*  7:   */   private int code;
/*  8:   */   
/*  9:   */   private DirectorioEnum(int code)
/* 10:   */   {
/* 11:15 */     this.code = code;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public int getCode()
/* 15:   */   {
/* 16:19 */     return this.code;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setCode(int code)
/* 20:   */   {
/* 21:23 */     this.code = code;
/* 22:   */   }
/* 23:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.DirectorioEnum
 * JD-Core Version:    0.7.0.1
 */