/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum TipoCompradorEnum
/*  4:   */ {
/*  5:10 */   CONSUMIDOR_FINAL("07"),  RUC("04"),  CEDULA("05"),  PASAPORTE("06"),  IDENTIFICACION_EXTERIOR("08"),  PLACA("09");
/*  6:   */   
/*  7:   */   private String code;
/*  8:   */   
/*  9:   */   private TipoCompradorEnum(String code)
/* 10:   */   {
/* 11:14 */     this.code = code;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getCode()
/* 15:   */   {
/* 16:23 */     return this.code;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public static String retornaCodigo(String valor)
/* 20:   */   {
/* 21:33 */     String codigo = null;
/* 22:34 */     if (valor.equals("C")) {
/* 23:35 */       codigo = CEDULA.getCode();
/* 24:   */     }
/* 25:37 */     if (valor.equals("R")) {
/* 26:38 */       codigo = RUC.getCode();
/* 27:   */     }
/* 28:40 */     if (valor.equals("P")) {
/* 29:41 */       codigo = PASAPORTE.getCode();
/* 30:   */     }
/* 31:43 */     if (valor.equals("I")) {
/* 32:44 */       codigo = IDENTIFICACION_EXTERIOR.getCode();
/* 33:   */     }
/* 34:46 */     if (valor.equals("L")) {
/* 35:47 */       codigo = PLACA.getCode();
/* 36:   */     }
/* 37:49 */     if (valor.equals("F")) {
/* 38:50 */       codigo = CONSUMIDOR_FINAL.getCode();
/* 39:   */     }
/* 40:52 */     return codigo;
/* 41:   */   }
/* 42:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoCompradorEnum
 * JD-Core Version:    0.7.0.1
 */