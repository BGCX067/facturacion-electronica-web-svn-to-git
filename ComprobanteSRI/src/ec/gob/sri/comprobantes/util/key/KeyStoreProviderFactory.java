/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import java.util.logging.Logger;
/*  5:   */ 
/*  6:   */ public class KeyStoreProviderFactory
/*  7:   */ {
/*  8:12 */   private static final Logger log = Logger.getLogger(KeyStoreProviderFactory.class.getName());
/*  9:   */   
/* 10:   */   public static KeyStoreProvider createKeyStoreProvider()
/* 11:   */   {
/* 12:25 */     String osName = System.getProperty("os.name");
/* 13:27 */     if (osName.toUpperCase().indexOf("WINDOWS") == 0) {
/* 14:28 */       return new WindowsOtherKeyStoreProvider();
/* 15:   */     }
/* 16:29 */     if (osName.toUpperCase().indexOf("LINUX") == 0)
/* 17:   */     {
/* 18:30 */       if (existeLibreriaLinux() == true) {
/* 19:31 */         return new LinuxEProKeyStoreProvider();
/* 20:   */       }
/* 21:33 */       return new LinuxKeyStoreProvider();
/* 22:   */     }
/* 23:35 */     if (osName.toUpperCase().indexOf("MAC") == 0)
/* 24:   */     {
/* 25:36 */       if (existeLibreriaMac() == true) {
/* 26:37 */         return new DylibKeyStoreProvider();
/* 27:   */       }
/* 28:39 */       return new AppleKeyStoreProvider();
/* 29:   */     }
/* 30:42 */     throw new IllegalArgumentException("Sistema operativo no soportado!");
/* 31:   */   }
/* 32:   */   
/* 33:   */   private static boolean existeLibreriaLinux()
/* 34:   */   {
/* 35:53 */     boolean resultado = false;
/* 36:   */     
/* 37:55 */     File lib = new File("/usr/lib/libeTPkcs11.so");
/* 38:56 */     File lib32 = new File("/usr/lib32/libeTPkcs11.so");
/* 39:57 */     File lib64 = new File("/usr/lib64/libeTPkcs11.so");
/* 40:59 */     if ((lib.exists() == true) || (lib32.exists() == true) || (lib64.exists() == true)) {
/* 41:60 */       resultado = true;
/* 42:   */     }
/* 43:62 */     return resultado;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public static boolean existeLibreriaMac()
/* 47:   */   {
/* 48:73 */     boolean resultado = false;
/* 49:   */     
/* 50:75 */     File lib = new File("/usr/local/lib/libeTPkcs11.dylib");
/* 51:77 */     if (lib.exists() == true) {
/* 52:78 */       resultado = true;
/* 53:   */     }
/* 54:80 */     return resultado;
/* 55:   */   }
/* 56:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.KeyStoreProviderFactory
 * JD-Core Version:    0.7.0.1
 */