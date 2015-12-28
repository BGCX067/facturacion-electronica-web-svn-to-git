/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum TipoImpuestoEnum
/*  4:   */ {
/*  5:10 */   RENTA(1, "Impuesto a la Renta"),  IVA(2, "I.V.A."),  ICE(3, "I.C.E."),  IRBPNR(5, "IRBPNR");
/*  6:   */   
/*  7:   */   private int code;
/*  8:   */   private String descripcion;
/*  9:   */   
/* 10:   */   private TipoImpuestoEnum(int code, String descripcion)
/* 11:   */   {
/* 12:16 */     this.code = code;
/* 13:17 */     this.descripcion = descripcion;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getDescripcion()
/* 17:   */   {
/* 18:21 */     return this.descripcion;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public int getCode()
/* 22:   */   {
/* 23:25 */     return this.code;
/* 24:   */   }
/* 25:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoImpuestoEnum
 * JD-Core Version:    0.7.0.1
 */