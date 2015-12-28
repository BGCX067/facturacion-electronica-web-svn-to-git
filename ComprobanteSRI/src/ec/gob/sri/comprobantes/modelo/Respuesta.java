/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ import java.sql.Date;
/*  4:   */ 
/*  5:   */ public class Respuesta
/*  6:   */ {
/*  7:   */   private Integer codigo;
/*  8:   */   private String claveDeAcceso;
/*  9:   */   private String archivo;
/* 10:   */   private String estado;
/* 11:   */   private Date fecha;
/* 12:   */   
/* 13:   */   public Respuesta() {}
/* 14:   */   
/* 15:   */   public Respuesta(Integer codigo, String claveDeAcceso, String archivo, String estado, Date fecha)
/* 16:   */   {
/* 17:29 */     this.codigo = codigo;
/* 18:30 */     this.claveDeAcceso = claveDeAcceso;
/* 19:31 */     this.archivo = archivo;
/* 20:32 */     this.estado = estado;
/* 21:33 */     this.fecha = fecha;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String getArchivo()
/* 25:   */   {
/* 26:37 */     return this.archivo;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setArchivo(String archivo)
/* 30:   */   {
/* 31:41 */     this.archivo = archivo;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getClaveDeAcceso()
/* 35:   */   {
/* 36:45 */     return this.claveDeAcceso;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setClaveDeAcceso(String claveDeAcceso)
/* 40:   */   {
/* 41:49 */     this.claveDeAcceso = claveDeAcceso;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public Integer getCodigo()
/* 45:   */   {
/* 46:53 */     return this.codigo;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setCodigo(Integer codigo)
/* 50:   */   {
/* 51:57 */     this.codigo = codigo;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getEstado()
/* 55:   */   {
/* 56:61 */     return this.estado;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setEstado(String estado)
/* 60:   */   {
/* 61:65 */     this.estado = estado;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public Date getFecha()
/* 65:   */   {
/* 66:69 */     return this.fecha;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setFecha(Date fecha)
/* 70:   */   {
/* 71:73 */     this.fecha = fecha;
/* 72:   */   }
/* 73:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.Respuesta
 * JD-Core Version:    0.7.0.1
 */