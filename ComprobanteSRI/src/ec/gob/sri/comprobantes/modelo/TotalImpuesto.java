/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class TotalImpuesto
/*  6:   */ {
/*  7:   */   Integer codigo;
/*  8:   */   String codigoPorcentaje;
/*  9:   */   BigDecimal baseImponible;
/* 10:   */   BigDecimal valor;
/* 11:   */   
/* 12:   */   public BigDecimal getBaseImponible()
/* 13:   */   {
/* 14:23 */     return this.baseImponible;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void setBaseImponible(BigDecimal baseImponible)
/* 18:   */   {
/* 19:27 */     this.baseImponible = baseImponible;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public Integer getCodigo()
/* 23:   */   {
/* 24:31 */     return this.codigo;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setCodigo(Integer codigo)
/* 28:   */   {
/* 29:35 */     this.codigo = codigo;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getCodigoPorcentaje()
/* 33:   */   {
/* 34:39 */     return this.codigoPorcentaje;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setCodigoPorcentaje(String codigoPorcentaje)
/* 38:   */   {
/* 39:43 */     this.codigoPorcentaje = codigoPorcentaje;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public BigDecimal getValor()
/* 43:   */   {
/* 44:47 */     return this.valor;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setValor(BigDecimal valor)
/* 48:   */   {
/* 49:51 */     this.valor = valor;
/* 50:   */   }
/* 51:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.TotalImpuesto
 * JD-Core Version:    0.7.0.1
 */