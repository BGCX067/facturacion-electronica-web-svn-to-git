/*  1:   */ package ec.gob.sri.comprobantes.administracion.modelo;
/*  2:   */ 
/*  3:   */ import java.math.BigInteger;
/*  4:   */ 
/*  5:   */ public class Comprobante
/*  6:   */ {
/*  7:   */   private String codigo;
/*  8:   */   private BigInteger inicioSecuencia;
/*  9:   */   
/* 10:   */   public Comprobante(String codigo, BigInteger inicioSecuencia)
/* 11:   */   {
/* 12:18 */     this.codigo = codigo;
/* 13:19 */     this.inicioSecuencia = inicioSecuencia;
/* 14:   */   }
/* 15:   */   
/* 16:   */   public Comprobante() {}
/* 17:   */   
/* 18:   */   public String getCodigo()
/* 19:   */   {
/* 20:29 */     return this.codigo;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setCodigo(String codigo)
/* 24:   */   {
/* 25:36 */     this.codigo = codigo;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public BigInteger getInicioSecuencia()
/* 29:   */   {
/* 30:43 */     return this.inicioSecuencia;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setInicioSecuencia(BigInteger inicioSecuencia)
/* 34:   */   {
/* 35:50 */     this.inicioSecuencia = inicioSecuencia;
/* 36:   */   }
/* 37:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.Comprobante
 * JD-Core Version:    0.7.0.1
 */