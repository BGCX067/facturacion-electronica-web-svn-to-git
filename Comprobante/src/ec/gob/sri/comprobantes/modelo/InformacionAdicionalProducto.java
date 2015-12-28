/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ public class InformacionAdicionalProducto
/*  4:   */ {
/*  5:   */   private String atributo;
/*  6:   */   private String valor;
/*  7:   */   private Integer codigoProducto;
/*  8:   */   private Integer codigo;
/*  9:   */   
/* 10:   */   public InformacionAdicionalProducto() {}
/* 11:   */   
/* 12:   */   public InformacionAdicionalProducto(String atributo, String valor)
/* 13:   */   {
/* 14:21 */     this.atributo = atributo;
/* 15:22 */     this.valor = valor;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getAtributo()
/* 19:   */   {
/* 20:29 */     return this.atributo;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setAtributo(String atributo)
/* 24:   */   {
/* 25:36 */     this.atributo = atributo;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getValor()
/* 29:   */   {
/* 30:43 */     return this.valor;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setValor(String valor)
/* 34:   */   {
/* 35:50 */     this.valor = valor;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Integer getCodigoProducto()
/* 39:   */   {
/* 40:57 */     return this.codigoProducto;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setCodigoProducto(Integer codigoProducto)
/* 44:   */   {
/* 45:64 */     this.codigoProducto = codigoProducto;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Integer getCodigo()
/* 49:   */   {
/* 50:71 */     return this.codigo;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setCodigo(Integer codigo)
/* 54:   */   {
/* 55:78 */     this.codigo = codigo;
/* 56:   */   }
/* 57:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto
 * JD-Core Version:    0.7.0.1
 */