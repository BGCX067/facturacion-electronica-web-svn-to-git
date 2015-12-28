/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ public class LinuxKeyStoreProvider
/*  4:   */   extends PKCS11KeyStoreProvider
/*  5:   */ {
/*  6:   */   private static final String CONFIG;
/*  7:   */   
/*  8:   */   static
/*  9:   */   {
/* 10:24 */     StringBuffer config = new StringBuffer();
/* 11:25 */     config.append("name=Safenetikey2032\n");
/* 12:26 */     config.append("library=/usr/local/SafeNet/lib/libsfntpkcs11.so\n");
/* 13:27 */     config.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
/* 14:28 */     CONFIG = config.toString();
/* 15:   */   }
/* 16:   */   
/* 17:   */   public String getConfig()
/* 18:   */   {
/* 19:33 */     return CONFIG;
/* 20:   */   }
/* 21:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.LinuxKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */