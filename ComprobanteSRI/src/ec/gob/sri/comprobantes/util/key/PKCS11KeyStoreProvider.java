/*  1:   */ package ec.gob.sri.comprobantes.util.key;
/*  2:   */ 
/*  3:   */ import java.io.ByteArrayInputStream;
/*  4:   */ import java.io.IOException;
/*  5:   */ import java.io.InputStream;
/*  6:   */ import java.lang.reflect.Constructor;
/*  7:   */ import java.lang.reflect.InvocationTargetException;
/*  8:   */ import java.security.KeyStore;
/*  9:   */ import java.security.KeyStoreException;
/* 10:   */ import java.security.NoSuchAlgorithmException;
/* 11:   */ import java.security.Provider;
/* 12:   */ import java.security.Security;
/* 13:   */ import java.security.cert.CertificateException;
/* 14:   */ 
/* 15:   */ public abstract class PKCS11KeyStoreProvider
/* 16:   */   implements KeyStoreProvider
/* 17:   */ {
/* 18:   */   public abstract String getConfig();
/* 19:   */   
/* 20:   */   public KeyStore getKeystore(char[] password)
/* 21:   */     throws KeyStoreException
/* 22:   */   {
/* 23:   */     try
/* 24:   */     {
/* 25:46 */       InputStream configStream = new ByteArrayInputStream(getConfig().getBytes());
/* 26:   */       
/* 27:48 */       Provider sunPKCS11Provider = createSunPKCS11Provider(configStream);
/* 28:49 */       Security.addProvider(sunPKCS11Provider);
/* 29:   */       
/* 30:51 */       KeyStore keyStore = KeyStore.getInstance("PKCS11");
/* 31:52 */       keyStore.load(null, password);
/* 32:   */       
/* 33:54 */       return keyStore;
/* 34:   */     }
/* 35:   */     catch (CertificateException e)
/* 36:   */     {
/* 37:56 */       throw new KeyStoreException(e);
/* 38:   */     }
/* 39:   */     catch (NoSuchAlgorithmException e)
/* 40:   */     {
/* 41:58 */       throw new KeyStoreException(e);
/* 42:   */     }
/* 43:   */     catch (IOException e)
/* 44:   */     {
/* 45:60 */       throw new KeyStoreException(e);
/* 46:   */     }
/* 47:   */   }
/* 48:   */   
/* 49:   */   private Provider createSunPKCS11Provider(InputStream configStream)
/* 50:   */     throws KeyStoreException
/* 51:   */   {
/* 52:   */     try
/* 53:   */     {
/* 54:73 */       Class sunPkcs11Class = Class.forName("sun.security.pkcs11.SunPKCS11");
/* 55:74 */       Constructor pkcs11Constr = sunPkcs11Class.getConstructor(new Class[] { InputStream.class });
/* 56:75 */       return (Provider)pkcs11Constr.newInstance(new Object[] { configStream });
/* 57:   */     }
/* 58:   */     catch (ClassNotFoundException e)
/* 59:   */     {
/* 60:77 */       throw new KeyStoreException(e);
/* 61:   */     }
/* 62:   */     catch (NoSuchMethodException e)
/* 63:   */     {
/* 64:79 */       throw new KeyStoreException(e);
/* 65:   */     }
/* 66:   */     catch (InvocationTargetException e)
/* 67:   */     {
/* 68:81 */       throw new KeyStoreException(e);
/* 69:   */     }
/* 70:   */     catch (IllegalAccessException e)
/* 71:   */     {
/* 72:83 */       throw new KeyStoreException(e);
/* 73:   */     }
/* 74:   */     catch (InstantiationException e)
/* 75:   */     {
/* 76:85 */       throw new KeyStoreException(e);
/* 77:   */     }
/* 78:   */   }
/* 79:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.PKCS11KeyStoreProvider
 * JD-Core Version:    0.7.0.1
 */