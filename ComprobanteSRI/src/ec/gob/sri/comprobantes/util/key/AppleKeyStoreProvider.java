/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.security.KeyStore;
/*  5:   */ import java.security.KeyStoreException;
/*  6:   */ import java.security.NoSuchAlgorithmException;
/*  7:   */ import java.security.NoSuchProviderException;
/*  8:   */ import java.security.cert.CertificateException;
/*  9:   */ 
/* 10:   */ public class AppleKeyStoreProvider
/* 11:   */   implements KeyStoreProvider
/* 12:   */ {
/* 13:   */   private static final String APPLE_PROVIDER_TYPE = "KeychainStore";
/* 14:   */   private static final String APPLE_PROVIDER_NAME = "Apple";
/* 15:   */   
/* 16:   */   public KeyStore getKeystore(char[] password)
/* 17:   */     throws KeyStoreException
/* 18:   */   {
/* 19:   */     try
/* 20:   */     {
/* 21:33 */       KeyStore keyStore = KeyStore.getInstance("KeychainStore", "Apple");
/* 22:34 */       keyStore.load(null, null);
/* 23:35 */       return keyStore;
/* 24:   */     }
/* 25:   */     catch (NoSuchProviderException e)
/* 26:   */     {
/* 27:37 */       throw new KeyStoreException(e);
/* 28:   */     }
/* 29:   */     catch (NoSuchAlgorithmException e)
/* 30:   */     {
/* 31:39 */       throw new KeyStoreException(e);
/* 32:   */     }
/* 33:   */     catch (CertificateException e)
/* 34:   */     {
/* 35:41 */       throw new KeyStoreException(e);
/* 36:   */     }
/* 37:   */     catch (IOException e)
/* 38:   */     {
/* 39:43 */       throw new KeyStoreException(e);
/* 40:   */     }
/* 41:   */   }
/* 42:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.AppleKeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */