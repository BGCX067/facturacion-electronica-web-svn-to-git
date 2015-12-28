/*  1:   */ package ec.gob.sri.comprobantes.administracion.modelo;
/*  2:   */ 
/*  3:   */ public class ImpuestoProducto
/*  4:   */ {
/*  5:   */   private Integer codigoProducto;
/*  6:   */   private String codigoImpuesto;
/*  7:   */   
/*  8:   */   public ImpuestoProducto() {}
/*  9:   */   
/* 10:   */   public ImpuestoProducto(String codigoImpuesto)
/* 11:   */   {
/* 12:20 */     this.codigoImpuesto = codigoImpuesto;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public Integer getCodigoProducto()
/* 16:   */   {
/* 17:27 */     return this.codigoProducto;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setCodigoProducto(Integer codigoProducto)
/* 21:   */   {
/* 22:34 */     this.codigoProducto = codigoProducto;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getCodigoImpuesto()
/* 26:   */   {
/* 27:41 */     return this.codigoImpuesto;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setCodigoImpuesto(String codigoImpuesto)
/* 31:   */   {
/* 32:48 */     this.codigoImpuesto = codigoImpuesto;
/* 33:   */   }
/* 34:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.ImpuestoProducto
 * JD-Core Version:    0.7.0.1
 */