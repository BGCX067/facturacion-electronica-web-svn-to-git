/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class LoteXml
/*  7:   */ {
/*  8:   */   private String version;
/*  9:   */   private String claveAcceso;
/* 10:   */   private String ruc;
/* 11:   */   private List<ComprobanteXml> comprobantes;
/* 12:   */   
/* 13:   */   public LoteXml()
/* 14:   */   {
/* 15:24 */     this.comprobantes = new ArrayList();
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getClaveAcceso()
/* 19:   */   {
/* 20:28 */     return this.claveAcceso;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setClaveAcceso(String claveAcceso)
/* 24:   */   {
/* 25:32 */     this.claveAcceso = claveAcceso;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<ComprobanteXml> getComprobantes()
/* 29:   */   {
/* 30:36 */     return this.comprobantes;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setComprobantes(List<ComprobanteXml> comprobantes)
/* 34:   */   {
/* 35:40 */     this.comprobantes = comprobantes;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getRuc()
/* 39:   */   {
/* 40:44 */     return this.ruc;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setRuc(String ruc)
/* 44:   */   {
/* 45:48 */     this.ruc = ruc;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public String getVersion()
/* 49:   */   {
/* 50:52 */     return this.version;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setVersion(String version)
/* 54:   */   {
/* 55:56 */     this.version = version;
/* 56:   */   }
/* 57:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.LoteXml
 * JD-Core Version:    0.7.0.1
 */