/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ public enum AutoridadesCertificantes
/*  4:   */ {
/*  5:13 */   ANF("ANF EC 1", "ANF Autoridad Intermedia", "ANF AC", "EC", "1.3.6.1.4.1.37442"),  BANCO_CENTRAL("AC BANCO CENTRAL DEL ECUADOR", "ENTIDAD DE CERTIFICACION DE INFORMACION-ECIBCE", "BANCO CENTRAL DEL ECUADOR", "EC", "1.3.6.1.4.1.37947"),  SECURITY_DATA("AUTORIDAD DE CERTIFICACION SUB SECURITY DATA", "ENTIDAD DE CERTIFICACION DE INFORMACION", "SECURITY DATA S.A.", "EC", "1.3.6.1.4.1.37746");
/*  6:   */   
/*  7:   */   private final String cn;
/*  8:   */   private final String ou;
/*  9:   */   private final String o;
/* 10:   */   private final String c;
/* 11:   */   private final String oid;
/* 12:   */   
/* 13:   */   private AutoridadesCertificantes(String cn, String ou, String o, String c, String oid)
/* 14:   */   {
/* 15:26 */     this.c = c;
/* 16:27 */     this.o = o;
/* 17:28 */     this.cn = cn;
/* 18:29 */     this.ou = ou;
/* 19:30 */     this.oid = oid;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String getC()
/* 23:   */   {
/* 24:34 */     return this.c;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public String getCn()
/* 28:   */   {
/* 29:38 */     return this.cn;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getO()
/* 33:   */   {
/* 34:42 */     return this.o;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getOu()
/* 38:   */   {
/* 39:46 */     return this.ou;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getOid()
/* 43:   */   {
/* 44:50 */     return this.oid;
/* 45:   */   }
/* 46:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.AutoridadesCertificantes
 * JD-Core Version:    0.7.0.1
 */