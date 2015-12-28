/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum TipoClienteEnum
/*  4:   */ {
/*  5:12 */   C("CLIENTE", "C"),  R("SUJETO RETENIDO", "R"),  D("DESTINATARIO", "D");
/*  6:   */   
/*  7:   */   private String code;
/*  8:   */   private String descripcion;
/*  9:   */   
/* 10:   */   private TipoClienteEnum(String descripcion, String code)
/* 11:   */   {
/* 12:17 */     this.code = code;
/* 13:18 */     this.descripcion = descripcion;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getCode()
/* 17:   */   {
/* 18:26 */     return this.code;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getDescripcion()
/* 22:   */   {
/* 23:29 */     return this.descripcion;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String toString()
/* 27:   */   {
/* 28:33 */     return this.descripcion;
/* 29:   */   }
/* 30:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoClienteEnum
 * JD-Core Version:    0.7.0.1
 */