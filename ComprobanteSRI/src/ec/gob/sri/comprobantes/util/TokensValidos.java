/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum TokensValidos
/*  4:   */ {
/*  5:16 */   ANF1("ANF - Certificado Exportado"),  ANF_TOKEN("ANF - Plug & Sign"),  BCE_IKEY2032("BCE - iKey2032"),  BCE_ALADDIN("BCE - Aladdin eToken Pro"),  SD_EPASS3000("SD - ePass3003 auto"),  SD_BIOPASS("SD - BioPass3000");
/*  6:   */   
/*  7:   */   String id;
/*  8:   */   
/*  9:   */   private TokensValidos(String modelo)
/* 10:   */   {
/* 11:26 */     this.id = modelo;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public String getId()
/* 15:   */   {
/* 16:30 */     return this.id;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public void setId(String id)
/* 20:   */   {
/* 21:34 */     this.id = id;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public String toString()
/* 25:   */   {
/* 26:39 */     return getId();
/* 27:   */   }
/* 28:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TokensValidos
 * JD-Core Version:    0.7.0.1
 */