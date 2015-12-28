/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ public class ComprobanteXml
/*  4:   */ {
/*  5:   */   private String tipo;
/*  6:   */   private String version;
/*  7:   */   private String fileXML;
/*  8:   */   
/*  9:   */   public String getFileXML()
/* 10:   */   {
/* 11:20 */     return this.fileXML;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public void setFileXML(String fileXML)
/* 15:   */   {
/* 16:24 */     this.fileXML = ("<![CDATA[" + fileXML + "]]>");
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getTipo()
/* 20:   */   {
/* 21:29 */     return this.tipo;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setTipo(String tipo)
/* 25:   */   {
/* 26:33 */     this.tipo = tipo;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getVersion()
/* 30:   */   {
/* 31:37 */     return this.version;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setVersion(String version)
/* 35:   */   {
/* 36:41 */     this.version = version;
/* 37:   */   }
/* 38:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.ComprobanteXml
 * JD-Core Version:    0.7.0.1
 */