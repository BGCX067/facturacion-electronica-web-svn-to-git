/*   1:    */ package ec.gob.sri.comprobantes.administracion.modelo;
/*   2:    */ 
/*   3:    */ public class Proxy
/*   4:    */ {
/*   5:    */   private String url;
/*   6:    */   private Integer puerto;
/*   7:    */   private String usuario;
/*   8:    */   private String clave;
/*   9:    */   private String wsProduccion;
/*  10:    */   private String wsPruebas;
/*  11:    */   
/*  12:    */   public Proxy() {}
/*  13:    */   
/*  14:    */   public Proxy(String url, Integer puerto, String usuario, String clave, String wsProduccion, String wsPruebas)
/*  15:    */   {
/*  16: 25 */     this.url = url;
/*  17: 26 */     this.puerto = puerto;
/*  18: 27 */     this.usuario = usuario;
/*  19: 28 */     this.clave = clave;
/*  20: 29 */     this.wsProduccion = wsProduccion;
/*  21: 30 */     this.wsPruebas = wsPruebas;
/*  22:    */   }
/*  23:    */   
/*  24:    */   public String getUrl()
/*  25:    */   {
/*  26: 37 */     return this.url;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setUrl(String url)
/*  30:    */   {
/*  31: 44 */     this.url = url;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public Integer getPuerto()
/*  35:    */   {
/*  36: 51 */     return this.puerto;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setPuerto(Integer puerto)
/*  40:    */   {
/*  41: 58 */     this.puerto = puerto;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getUsuario()
/*  45:    */   {
/*  46: 65 */     return this.usuario;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setUsuario(String usuario)
/*  50:    */   {
/*  51: 72 */     this.usuario = usuario;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getClave()
/*  55:    */   {
/*  56: 79 */     return this.clave;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setClave(String clave)
/*  60:    */   {
/*  61: 86 */     this.clave = clave;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getWsProduccion()
/*  65:    */   {
/*  66: 93 */     return this.wsProduccion;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setWsProduccion(String wsProduccion)
/*  70:    */   {
/*  71:100 */     this.wsProduccion = wsProduccion;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getWsPruebas()
/*  75:    */   {
/*  76:107 */     return this.wsPruebas;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setWsPruebas(String wsPruebas)
/*  80:    */   {
/*  81:114 */     this.wsPruebas = wsPruebas;
/*  82:    */   }
/*  83:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.Proxy
 * JD-Core Version:    0.7.0.1
 */