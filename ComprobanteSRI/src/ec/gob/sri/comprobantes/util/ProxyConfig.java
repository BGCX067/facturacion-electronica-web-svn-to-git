/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ import java.net.Authenticator;
/*  4:   */ import java.net.InetSocketAddress;
/*  5:   */ import java.net.PasswordAuthentication;
/*  6:   */ import java.net.Proxy;
/*  7:   */ import java.net.Proxy.Type;
/*  8:   */ import java.net.ProxySelector;
/*  9:   */ import java.net.URI;
/* 10:   */ import java.util.Iterator;
/* 11:   */ import java.util.List;
/* 12:   */ import java.util.logging.Level;
/* 13:   */ import java.util.logging.Logger;
/* 14:   */ 
/* 15:   */ public class ProxyConfig
/* 16:   */ {
/* 17:   */   private static String host;
/* 18:   */   private static int port;
/* 19:   */   private static Proxy proxy;
/* 20:   */   
/* 21:   */   public static void init(String uri)
/* 22:   */   {
/* 23:31 */     System.setProperty("java.net.useSystemProxies", "true");
/* 24:32 */     System.setProperty("javax.net.ssl.trustStore", "resources/jssecacerts");
/* 25:33 */     System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
/* 26:   */     
/* 27:35 */     proxy = getProxy(uri);
/* 28:36 */     if ((proxy != null) && (!proxy.type().toString().equals("DIRECT")))
/* 29:   */     {
/* 30:37 */       InetSocketAddress addr = (InetSocketAddress)proxy.address();
/* 31:38 */       host = addr.getHostName();
/* 32:39 */       port = addr.getPort();
/* 33:   */     }
/* 34:   */     else
/* 35:   */     {
/* 36:56 */       System.setProperty("java.net.useSystemProxies", "true");
/* 37:   */     }
/* 38:   */   }
/* 39:   */   
/* 40:   */   private static Proxy getProxy(String uri)
/* 41:   */   {
/* 42:63 */     List<Proxy> l = null;
/* 43:   */     try
/* 44:   */     {
/* 45:65 */       ProxySelector def = ProxySelector.getDefault();
/* 46:   */       
/* 47:   */ 
/* 48:68 */       l = def.select(new URI("http://proxy/test"));
/* 49:69 */       ProxySelector.setDefault(ProxySelector.getDefault());
/* 50:   */     }
/* 51:   */     catch (Exception e)
/* 52:   */     {
/* 53:71 */       Logger.getLogger(ProxyConfig.class.getName()).log(Level.SEVERE, null, e);
/* 54:   */     }
/* 55:73 */     if (l != null)
/* 56:   */     {
/* 57:74 */       Iterator<Proxy> iter = l.iterator();
/* 58:74 */       if (iter.hasNext())
/* 59:   */       {
/* 60:75 */         Proxy proxy = (Proxy)iter.next();
/* 61:76 */         return proxy;
/* 62:   */       }
/* 63:   */     }
/* 64:79 */     return null;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public static class ProxyAuthenticator
/* 68:   */     extends Authenticator
/* 69:   */   {
/* 70:   */     private String userName;
/* 71:   */     private String password;
/* 72:   */     
/* 73:   */     protected PasswordAuthentication getPasswordAuthentication()
/* 74:   */     {
/* 75:87 */       return new PasswordAuthentication(this.userName, this.password.toCharArray());
/* 76:   */     }
/* 77:   */     
/* 78:   */     public ProxyAuthenticator(String userName, String password)
/* 79:   */     {
/* 80:91 */       this.userName = userName;
/* 81:92 */       this.password = password;
/* 82:   */     }
/* 83:   */   }
/* 84:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ProxyConfig
 * JD-Core Version:    0.7.0.1
 */