/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public class CampoModelo
/*  4:   */ {
/*  5:   */   private String valor;
/*  6:   */   private String etiqueta;
/*  7:   */   private Integer longitud;
/*  8:   */   
/*  9:   */   public CampoModelo(String valor, String etiqueta, Integer longitud)
/* 10:   */   {
/* 11:17 */     this.valor = valor;
/* 12:18 */     this.etiqueta = etiqueta;
/* 13:19 */     this.longitud = longitud;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public String getValor()
/* 17:   */   {
/* 18:27 */     return this.valor;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setValor(String valor)
/* 22:   */   {
/* 23:34 */     this.valor = valor;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getEtiqueta()
/* 27:   */   {
/* 28:41 */     return this.etiqueta;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setEtiqueta(String etiqueta)
/* 32:   */   {
/* 33:48 */     this.etiqueta = etiqueta;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Integer getLongitud()
/* 37:   */   {
/* 38:55 */     return this.longitud;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setLongitud(Integer longitud)
/* 42:   */   {
/* 43:62 */     this.longitud = longitud;
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.CampoModelo
 * JD-Core Version:    0.7.0.1
 */