/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum SiNoEnum
/*  4:   */ {
/*  5:12 */   SI("S"),  NO("N");
/*  6:   */   
/*  7:   */   private String code;
/*  8:   */   
/*  9:   */   private SiNoEnum(String code)
/* 10:   */   {
/* 11:16 */     this.code = code;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getCode()
/* 15:   */   {
/* 16:24 */     return this.code;
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.SiNoEnum
 * JD-Core Version:    0.7.0.1
 */