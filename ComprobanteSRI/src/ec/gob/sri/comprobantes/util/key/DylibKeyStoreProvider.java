/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ public class DylibKeyStoreProvider
/*  4:   */   extends PKCS11KeyStoreProvider
/*  5:   */ {
/*  6:   */   private static String CONFIG;
/*  7:   */   
/*  8:   */   public DylibKeyStoreProvider()
/*  9:   */   {
/* 10:25 */     StringBuffer config = new StringBuffer();
/* 11:26 */     config.append("name=eToken\n");
/* 12:27 */     config.append("library=/usr/local/lib/libeTPkcs11.dylib\n");
/* 13:   */     
/* 14:29 */     CONFIG = config.toString();
/* 15:   */   }
/* 16:   */   
/* 17:   */   public String getConfig()
/* 18:   */   {
/* 19:34 */     return CONFIG;
/* 20:   */   }
/* 21:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.DylibKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */