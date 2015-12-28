/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ 
/*  5:   */ public class LinuxEProKeyStoreProvider
/*  6:   */   extends PKCS11KeyStoreProvider
/*  7:   */ {
/*  8:   */   private static String CONFIG;
/*  9:   */   private static String PATH;
/* 10:   */   
/* 11:   */   public LinuxEProKeyStoreProvider()
/* 12:   */   {
/* 13:26 */     File lib = new File("/usr/lib/libeTPkcs11.so");
/* 14:27 */     File lib32 = new File("/usr/lib32/libeTPkcs11.so");
/* 15:28 */     File lib64 = new File("/usr/lib64/libeTPkcs11.so");
/* 16:30 */     if (lib.exists() == true) {
/* 17:31 */       PATH = "/usr/lib/";
/* 18:32 */     } else if (lib32.exists() == true) {
/* 19:33 */       PATH = "/usr/lib32/";
/* 20:34 */     } else if (lib64.exists() == true) {
/* 21:35 */       PATH = "/usr/lib64/";
/* 22:   */     }
/* 23:38 */     StringBuffer config = new StringBuffer();
/* 24:39 */     config.append("name=eToken\n");
/* 25:40 */     config.append("library=");
/* 26:41 */     config.append(PATH);
/* 27:42 */     config.append("libeTPkcs11.so\n");
/* 28:   */     
/* 29:44 */     CONFIG = config.toString();
/* 30:   */   }
/* 31:   */   
/* 32:   */   public String getConfig()
/* 33:   */   {
/* 34:49 */     return CONFIG;
/* 35:   */   }
/* 36:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.LinuxEProKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */