/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ public class WindowsOtherKeyStoreProvider
/*  4:   */   extends PKCS11KeyStoreProvider
/*  5:   */ {
/*  6:   */   private static final String config;
/*  7:   */   
/*  8:   */   static
/*  9:   */   {
/* 10:28 */     StringBuffer sb = new StringBuffer();
/* 11:29 */     sb.append("name=Safenetikey2032\n");
/* 12:30 */     sb.append("library=C:\\WINDOWS\\SYSTEM32\\dkck201.dll\n");
/* 13:31 */     sb.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
/* 14:32 */     config = sb.toString();
/* 15:   */   }
/* 16:   */   
/* 17:   */   public String getConfig()
/* 18:   */   {
/* 19:37 */     return config;
/* 20:   */   }
/* 21:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.WindowsOtherKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */