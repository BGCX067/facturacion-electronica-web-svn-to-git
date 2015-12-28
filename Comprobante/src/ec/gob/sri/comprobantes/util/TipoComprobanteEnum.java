/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum TipoComprobanteEnum
/*  4:   */ {
/*  5: 9 */   LOTE("00", "lote.xsd", ""),  FACTURA("01", "factura.xsd", "FACTURA"),  NOTA_DE_CREDITO("04", "notaCredito.xsd", "NOTA DE CREDITO"),  NOTA_DE_DEBITO("05", "notaDebito.xsd", "NOTA DE DEBITO"),  GUIA_DE_REMISION("06", "guiaRemision.xsd", "GUIA DE REMISION"),  COMPROBANTE_DE_RETENCION("07", "comprobanteRetencion.xsd", "COMPROBANTE DE RETENCION"),  LIQUIDACION_DE_COMPRAS("03", "", "LIQ.DE COMPRAS");
/*  6:   */   
/*  7:   */   private String code;
/*  8:   */   private String xsd;
/*  9:   */   private String descripcion;
/* 10:   */   
/* 11:   */   private TipoComprobanteEnum(String code, String xsd, String descripcion)
/* 12:   */   {
/* 13:22 */     this.code = code;
/* 14:23 */     this.xsd = xsd;
/* 15:24 */     this.descripcion = descripcion;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getCode()
/* 19:   */   {
/* 20:33 */     return this.code;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getXsd()
/* 24:   */   {
/* 25:42 */     return this.xsd;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getDescripcion()
/* 29:   */   {
/* 30:46 */     return this.descripcion;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public static String retornaCodigo(String valor)
/* 34:   */   {
/* 35:57 */     String codigo = null;
/* 36:59 */     if (valor.equals(FACTURA.getDescripcion())) {
/* 37:60 */       codigo = FACTURA.getCode();
/* 38:61 */     } else if (valor.equals(NOTA_DE_DEBITO.getDescripcion())) {
/* 39:62 */       codigo = NOTA_DE_DEBITO.getCode();
/* 40:63 */     } else if (valor.equals(NOTA_DE_CREDITO.getDescripcion())) {
/* 41:64 */       codigo = NOTA_DE_CREDITO.getCode();
/* 42:65 */     } else if (valor.equals(COMPROBANTE_DE_RETENCION.getDescripcion())) {
/* 43:66 */       codigo = COMPROBANTE_DE_RETENCION.getCode();
/* 44:67 */     } else if (valor.equals(GUIA_DE_REMISION.getDescripcion())) {
/* 45:68 */       codigo = GUIA_DE_REMISION.getCode();
/* 46:69 */     } else if (valor.equals(LIQUIDACION_DE_COMPRAS.getDescripcion())) {
/* 47:70 */       codigo = LIQUIDACION_DE_COMPRAS.getCode();
/* 48:   */     }
/* 49:73 */     return codigo;
/* 50:   */   }
/* 51:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoComprobanteEnum
 * JD-Core Version:    0.7.0.1
 */