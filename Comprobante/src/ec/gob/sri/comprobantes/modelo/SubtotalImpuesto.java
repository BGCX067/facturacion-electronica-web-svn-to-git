/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class SubtotalImpuesto
/*  7:   */ {
/*  8:   */   Producto producto;
/*  9:   */   private Integer codigoImpuesto;
/* 10:   */   private String codigo;
/* 11:   */   private BigDecimal porcentaje;
/* 12:   */   private BigDecimal baseImponible;
/* 13:   */   private BigDecimal subtotal;
/* 14:   */   private BigDecimal valorIce;
/* 15:   */   
/* 16:   */   public BigDecimal getValorIce()
/* 17:   */   {
/* 18:28 */     return this.valorIce;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setValorIce(BigDecimal valorIce)
/* 22:   */   {
/* 23:32 */     this.valorIce = valorIce;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public SubtotalImpuesto(Producto producto, Integer codigoImpuesto, String codigo, BigDecimal porcentaje, BigDecimal baseImponible, BigDecimal subtotal)
/* 27:   */   {
/* 28:36 */     this.producto = producto;
/* 29:37 */     this.codigoImpuesto = codigoImpuesto;
/* 30:38 */     this.codigo = codigo;
/* 31:39 */     this.porcentaje = porcentaje;
/* 32:40 */     this.baseImponible = baseImponible;
/* 33:41 */     this.subtotal = subtotal;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getCodigo()
/* 37:   */   {
/* 38:45 */     return this.codigo;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setCodigo(String codigo)
/* 42:   */   {
/* 43:49 */     this.codigo = codigo;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public BigDecimal getSubtotal()
/* 47:   */   {
/* 48:53 */     return this.subtotal;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setSubtotal(BigDecimal subtotal)
/* 52:   */   {
/* 53:57 */     this.subtotal = subtotal;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public Integer getCodigoImpuesto()
/* 57:   */   {
/* 58:61 */     return this.codigoImpuesto;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setCodigoImpuesto(Integer codigoImpuesto)
/* 62:   */   {
/* 63:65 */     this.codigoImpuesto = codigoImpuesto;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public BigDecimal getPorcentaje()
/* 67:   */   {
/* 68:69 */     return this.porcentaje;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setPorcentaje(BigDecimal porcentaje)
/* 72:   */   {
/* 73:73 */     this.porcentaje = porcentaje;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public BigDecimal getBaseImponible()
/* 77:   */   {
/* 78:77 */     return this.baseImponible;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setBaseImponible(BigDecimal baseImponible)
/* 82:   */   {
/* 83:81 */     this.baseImponible = baseImponible;
/* 84:   */   }
/* 85:   */   
/* 86:   */   public boolean verificarProducto(Producto producto)
/* 87:   */   {
/* 88:85 */     return this.producto.verificarProducto(producto.getCodigoPrincipal(), producto.getCodigoAuxiliar(), producto.getNombre());
/* 89:   */   }
/* 90:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.SubtotalImpuesto
 * JD-Core Version:    0.7.0.1
 */