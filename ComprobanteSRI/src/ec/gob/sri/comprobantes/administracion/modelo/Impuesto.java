/*  1:   */ package ec.gob.sri.comprobantes.administracion.modelo;
/*  2:   */ 
/*  3:   */ public class Impuesto
/*  4:   */ {
/*  5:   */   private Integer codigo;
/*  6:   */   private String descripcion;
/*  7:   */   private String estado;
/*  8:   */   private Double porcentaje;
/*  9:   */   
/* 10:   */   public Integer getCodigo()
/* 11:   */   {
/* 12:21 */     return this.codigo;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public void setCodigo(Integer codigo)
/* 16:   */   {
/* 17:28 */     this.codigo = codigo;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getDescripcion()
/* 21:   */   {
/* 22:35 */     return this.descripcion;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setDescripcion(String descripcion)
/* 26:   */   {
/* 27:42 */     this.descripcion = descripcion;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getEstado()
/* 31:   */   {
/* 32:49 */     return this.estado;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setEstado(String estado)
/* 36:   */   {
/* 37:56 */     this.estado = estado;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String toString()
/* 41:   */   {
/* 42:61 */     return getDescripcion();
/* 43:   */   }
/* 44:   */   
/* 45:   */   public Double getPorcentaje()
/* 46:   */   {
/* 47:68 */     return this.porcentaje;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setPorcentaje(Double porcentaje)
/* 51:   */   {
/* 52:75 */     this.porcentaje = porcentaje;
/* 53:   */   }
/* 54:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.Impuesto
 * JD-Core Version:    0.7.0.1
 */