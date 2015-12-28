/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ import java.util.StringTokenizer;
/*  4:   */ 
/*  5:   */ public class X500NameGeneral
/*  6:   */ {
/*  7: 8 */   private String CN = null;
/*  8: 9 */   private String OU = null;
/*  9:10 */   private String O = null;
/* 10:11 */   private String L = null;
/* 11:12 */   private String ST = null;
/* 12:13 */   private String C = null;
/* 13:   */   
/* 14:   */   public X500NameGeneral(String name)
/* 15:   */   {
/* 16:16 */     StringTokenizer st = new StringTokenizer(name, ",");
/* 17:18 */     while (st.hasMoreTokens())
/* 18:   */     {
/* 19:19 */       String token = st.nextToken().trim();
/* 20:20 */       int idx = token.indexOf("=");
/* 21:21 */       if (idx >= 0)
/* 22:   */       {
/* 23:22 */         String label = token.substring(0, idx);
/* 24:23 */         String value = token.substring(idx + 1);
/* 25:25 */         if ("CN".equals(label)) {
/* 26:26 */           this.CN = value;
/* 27:27 */         } else if ("OU".equals(label)) {
/* 28:28 */           this.OU = value;
/* 29:29 */         } else if ("O".equals(label)) {
/* 30:30 */           this.O = value;
/* 31:31 */         } else if ("C".equals(label)) {
/* 32:32 */           this.C = value;
/* 33:33 */         } else if ("L".equals(label)) {
/* 34:34 */           this.L = value;
/* 35:35 */         } else if ("ST".equals(label)) {
/* 36:36 */           this.ST = value;
/* 37:   */         }
/* 38:   */       }
/* 39:   */     }
/* 40:   */   }
/* 41:   */   
/* 42:   */   public String getC()
/* 43:   */   {
/* 44:45 */     return this.C;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getCN()
/* 48:   */   {
/* 49:51 */     return this.CN;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public String getL()
/* 53:   */   {
/* 54:57 */     return this.L;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getO()
/* 58:   */   {
/* 59:63 */     return this.O;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public String getOU()
/* 63:   */   {
/* 64:69 */     return this.OU;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String getST()
/* 68:   */   {
/* 69:75 */     return this.ST;
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.X500NameGeneral
 * JD-Core Version:    0.7.0.1
 */