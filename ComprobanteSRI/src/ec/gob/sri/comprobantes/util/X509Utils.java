/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.util.key.KeyStoreProvider;
/*   4:    */ import ec.gob.sri.comprobantes.util.key.KeyStoreProviderFactory;
/*   5:    */ import ec.gob.sri.firmaxades.test.FirmasGenericasXAdES;
/*   6:    */ import ec.gob.sri.firmaxades.test.ValidacionBasica;
/*   7:    */ import java.io.ByteArrayInputStream;
/*   8:    */ import java.io.File;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.lang.reflect.Field;
/*  11:    */ import java.security.KeyStore;
/*  12:    */ import java.security.KeyStoreException;
/*  13:    */ import java.security.KeyStoreSpi;
/*  14:    */ import java.security.NoSuchAlgorithmException;
/*  15:    */ import java.security.Principal;
/*  16:    */ import java.security.PrivateKey;
/*  17:    */ import java.security.Provider;
/*  18:    */ import java.security.Security;
/*  19:    */ import java.security.cert.CertificateException;
/*  20:    */ import java.security.cert.CertificateExpiredException;
/*  21:    */ import java.security.cert.CertificateNotYetValidException;
/*  22:    */ import java.security.cert.X509Certificate;
/*  23:    */ import java.util.Collection;
/*  24:    */ import java.util.Enumeration;
/*  25:    */ import java.util.GregorianCalendar;
/*  26:    */ import java.util.logging.Level;
/*  27:    */ import java.util.logging.Logger;
/*  28:    */ import javax.xml.parsers.ParserConfigurationException;
/*  29:    */ import org.bouncycastle.asn1.ASN1InputStream;
/*  30:    */ import org.bouncycastle.asn1.DERObject;
/*  31:    */ import org.bouncycastle.asn1.DEROctetString;
/*  32:    */ import org.xml.sax.SAXException;
/*  33:    */ 
/*  34:    */ public class X509Utils
/*  35:    */ {
/*  36:    */   public static final int digitalSignature = 0;
/*  37:    */   public static final int nonRepudiation = 1;
/*  38:    */   public static final int keyEncipherment = 2;
/*  39:    */   public static final int dataEncipherment = 3;
/*  40:    */   public static final int keyAgreement = 4;
/*  41:    */   public static final int keyCertSign = 5;
/*  42:    */   public static final int cRLSign = 6;
/*  43:    */   
/*  44:    */   public static boolean puedeFirmar(X509Certificate cert)
/*  45:    */   {
/*  46: 60 */     boolean resp = false;
/*  47: 61 */     if (cert.getKeyUsage() == null) {
/*  48: 62 */       resp = true;
/*  49:    */     }
/*  50: 65 */     if ((cert.getKeyUsage()[0] != 0) || (cert.getKeyUsage()[1] != 0)) {
/*  51: 66 */       resp = true;
/*  52:    */     }
/*  53: 68 */     return resp;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public static String getUsage(X509Certificate cert)
/*  57:    */   {
/*  58: 79 */     StringBuilder sb = new StringBuilder();
/*  59: 81 */     if (cert.getKeyUsage() == null)
/*  60:    */     {
/*  61: 82 */       sb.append("no key usage defined for certificate");
/*  62:    */     }
/*  63:    */     else
/*  64:    */     {
/*  65: 85 */       if (cert.getKeyUsage()[0] != 0) {
/*  66: 86 */         sb.append(" digitalSignature ");
/*  67:    */       }
/*  68: 89 */       if (cert.getKeyUsage()[6] != 0) {
/*  69: 90 */         sb.append(" cRLSign ");
/*  70:    */       }
/*  71: 93 */       if (cert.getKeyUsage()[3] != 0) {
/*  72: 94 */         sb.append(" dataEncipherment ");
/*  73:    */       }
/*  74: 97 */       if (cert.getKeyUsage()[4] != 0) {
/*  75: 98 */         sb.append(" keyAgreement ");
/*  76:    */       }
/*  77:101 */       if (cert.getKeyUsage()[5] != 0) {
/*  78:102 */         sb.append(" keyCertSign ");
/*  79:    */       }
/*  80:105 */       if (cert.getKeyUsage()[2] != 0) {
/*  81:106 */         sb.append(" keyEncipherment ");
/*  82:    */       }
/*  83:109 */       if (cert.getKeyUsage()[1] != 0) {
/*  84:110 */         sb.append(" nonRepudiation ");
/*  85:    */       }
/*  86:    */     }
/*  87:113 */     return sb.toString();
/*  88:    */   }
/*  89:    */   
/*  90:    */   public static String getExtensionIdentifier(X509Certificate cert, String oid)
/*  91:    */     throws IOException
/*  92:    */   {
/*  93:126 */     String id = null;
/*  94:127 */     DERObject derObject = null;
/*  95:128 */     byte[] extensionValue = cert.getExtensionValue(oid);
/*  96:130 */     if (extensionValue != null)
/*  97:    */     {
/*  98:131 */       derObject = toDERObject(extensionValue);
/*  99:132 */       if ((derObject instanceof DEROctetString))
/* 100:    */       {
/* 101:133 */         DEROctetString derOctetString = (DEROctetString)derObject;
/* 102:134 */         derObject = toDERObject(derOctetString.getOctets());
/* 103:    */       }
/* 104:    */     }
/* 105:137 */     if (derObject != null) {
/* 106:138 */       id = derObject.toString();
/* 107:    */     } else {
/* 108:140 */       id = null;
/* 109:    */     }
/* 110:142 */     return id;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public static DERObject toDERObject(byte[] data)
/* 114:    */     throws IOException
/* 115:    */   {
/* 116:153 */     ByteArrayInputStream inStream = new ByteArrayInputStream(data);
/* 117:154 */     ASN1InputStream derInputStream = new ASN1InputStream(inStream);
/* 118:155 */     return derInputStream.readObject();
/* 119:    */   }
/* 120:    */   
/* 121:    */   public static String seleccionarCertificado(KeyStore keyStore, String tokenSeleccionado)
/* 122:    */     throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateExpiredException, CertificateNotYetValidException, CertificateException
/* 123:    */   {
/* 124:181 */     String aliasSeleccion = null;
/* 125:182 */     X509Certificate certificado = null;
/* 126:    */     
/* 127:184 */     Enumeration nombres = keyStore.aliases();
/* 128:185 */     while (nombres.hasMoreElements())
/* 129:    */     {
/* 130:186 */       String aliasKey = (String)nombres.nextElement();
/* 131:187 */       certificado = (X509Certificate)keyStore.getCertificate(aliasKey);
/* 132:    */       
/* 133:189 */       X500NameGeneral x500emisor = new X500NameGeneral(certificado.getIssuerDN().getName());
/* 134:190 */       X500NameGeneral x500sujeto = new X500NameGeneral(certificado.getSubjectDN().getName());
/* 135:193 */       if ((tokenSeleccionado.equals("SD_BIOPASS")) || ((tokenSeleccionado.equals("SD_EPASS3000")) && (x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA.getCn()))))
/* 136:    */       {
/* 137:198 */         if ((AutoridadesCertificantes.SECURITY_DATA.getO().equals(x500emisor.getO())) && (AutoridadesCertificantes.SECURITY_DATA.getC().equals(x500emisor.getC())) && (AutoridadesCertificantes.SECURITY_DATA.getO().equals(x500sujeto.getO())) && (AutoridadesCertificantes.SECURITY_DATA.getC().equals(x500sujeto.getC()))) {
/* 138:203 */           if ((certificado.getKeyUsage()[0] != 0) || (certificado.getKeyUsage()[1] != 0))
/* 139:    */           {
/* 140:204 */             aliasSeleccion = aliasKey;
/* 141:205 */             break;
/* 142:    */           }
/* 143:    */         }
/* 144:    */       }
/* 145:209 */       else if ((tokenSeleccionado.equals("BCE_ALADDIN")) || ((tokenSeleccionado.equals("BCE_IKEY2032")) && (x500emisor.getCN().contains(AutoridadesCertificantes.BANCO_CENTRAL.getCn()))))
/* 146:    */       {
/* 147:214 */         if ((x500emisor.getO().contains(AutoridadesCertificantes.BANCO_CENTRAL.getO())) && (AutoridadesCertificantes.BANCO_CENTRAL.getC().equals(x500emisor.getC())) && (x500sujeto.getO().contains(AutoridadesCertificantes.BANCO_CENTRAL.getO())) && (AutoridadesCertificantes.BANCO_CENTRAL.getC().equals(x500sujeto.getC()))) {
/* 148:219 */           if ((certificado.getKeyUsage()[0] != 0) || (certificado.getKeyUsage()[1] != 0))
/* 149:    */           {
/* 150:220 */             aliasSeleccion = aliasKey;
/* 151:221 */             break;
/* 152:    */           }
/* 153:    */         }
/* 154:    */       }
/* 155:226 */       else if ((tokenSeleccionado.equals("ANF1")) && (x500emisor.getCN().contains(AutoridadesCertificantes.ANF.getCn()))) {
/* 156:230 */         if ((AutoridadesCertificantes.ANF.getO().equals(x500emisor.getO())) && (AutoridadesCertificantes.ANF.getC().equals(x500emisor.getC())) && (AutoridadesCertificantes.ANF.getC().toLowerCase().equals(x500sujeto.getC()))) {
/* 157:234 */           if ((certificado.getKeyUsage()[0] != 0) || (certificado.getKeyUsage()[1] != 0))
/* 158:    */           {
/* 159:235 */             aliasSeleccion = aliasKey;
/* 160:236 */             break;
/* 161:    */           }
/* 162:    */         }
/* 163:    */       }
/* 164:    */     }
/* 165:242 */     return aliasSeleccion;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public static String firmaValidaArchivo(File archivo, String dirPathSalida, String rucEmisor, String tokenID, String password)
/* 169:    */   {
/* 170:263 */     String aliaskey = null;
/* 171:264 */     String respuesta = null;
/* 172:265 */     PrivateKey clavePrivada = null;
/* 173:266 */     KeyStore ks = null;
/* 174:    */     try
/* 175:    */     {
/* 176:270 */       if (System.getProperty("os.name").startsWith("Windows"))
/* 177:    */       {
/* 178:272 */         ks = KeyStore.getInstance("Windows-MY");
/* 179:273 */         ks.load(null, null);
/* 180:274 */         fixAliases(ks);
/* 181:    */       }
/* 182:275 */       else if (ks == null)
/* 183:    */       {
/* 184:276 */         ks = KeyStoreProviderFactory.createKeyStoreProvider().getKeystore(password.toCharArray());
/* 185:    */       }
/* 186:    */       else
/* 187:    */       {
/* 188:278 */         respuesta = "Sistema operativo o JRE no compatible los los tokens de firma";
/* 189:    */       }
/* 190:281 */       aliaskey = seleccionarCertificado(ks, tokenID);
/* 191:283 */       if (password == null)
/* 192:    */       {
/* 193:284 */         clavePrivada = (PrivateKey)ks.getKey(aliaskey, null);
/* 194:    */       }
/* 195:    */       else
/* 196:    */       {
/* 197:286 */         KeyStore tmpKs = ks;
/* 198:    */         
/* 199:288 */         PrivateKey key = (PrivateKey)tmpKs.getKey(aliaskey, password.toCharArray());
/* 200:289 */         clavePrivada = key;
/* 201:    */       }
/* 202:292 */       if (aliaskey != null)
/* 203:    */       {
/* 204:294 */         String archivoFirmado = dirPathSalida + File.separator + archivo.getName();
/* 205:    */         
/* 206:296 */         Provider provider = null;
/* 207:297 */         if ((System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0) && (!KeyStoreProviderFactory.existeLibreriaMac())) {
/* 208:299 */           provider = Security.getProvider("SunRsaSign");
/* 209:    */         } else {
/* 210:301 */           provider = ks.getProvider();
/* 211:    */         }
/* 212:303 */         FirmasGenericasXAdES firmador = new FirmasGenericasXAdES();
/* 213:304 */         X509Certificate certificado = (X509Certificate)ks.getCertificate(aliaskey);
/* 214:    */         
/* 215:    */ 
/* 216:307 */         certificado.checkValidity(new GregorianCalendar().getTime());
/* 217:    */         
/* 218:309 */         String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
/* 219:310 */         if ((rucEmisor.equals(rucCertificado)) && (clavePrivada != null))
/* 220:    */         {
/* 221:312 */           firmador.ejecutarFirmaXades(archivo.getAbsolutePath(), null, archivoFirmado, provider, certificado, clavePrivada);
/* 222:315 */           if (!new ValidacionBasica().validarArchivo(new File(archivoFirmado))) {
/* 223:316 */             respuesta = "Se ha producido un error al momento de crear \nla firma del comprobante electrónico, ya que el la firma digital no es válida";
/* 224:    */           }
/* 225:318 */           if (System.getProperty("os.name").startsWith("Windows") == true) {
/* 226:319 */             ks.load(null, null);
/* 227:    */           }
/* 228:    */         }
/* 229:321 */         else if (rucCertificado == null)
/* 230:    */         {
/* 231:322 */           respuesta = "El certificado digital proporcionado no posee los datos de RUC OID: 1.3.6.1.4.1.37XXX.3.11,\nrazón por la cual usted no podrá firmar digitalmente documentos para remitir al SRI,\nfavor actualize su certificado digital con la Autoridad Certificadora";
/* 232:    */         }
/* 233:323 */         else if (clavePrivada == null)
/* 234:    */         {
/* 235:324 */           respuesta = "No se pudo acceder a la clave privada del certificado";
/* 236:    */         }
/* 237:    */         else
/* 238:    */         {
/* 239:326 */           respuesta = "El Ruc presente en el certificado digital, no coincide con el Ruc registrado en el aplicativo";
/* 240:    */         }
/* 241:    */       }
/* 242:    */       else
/* 243:    */       {
/* 244:329 */         respuesta = "No se pudo encontrar un certificado válido para firmar el archivo";
/* 245:    */       }
/* 246:    */     }
/* 247:    */     catch (CertificateExpiredException ex)
/* 248:    */     {
/* 249:333 */       Logger.getLogger(X509Utils.class.getName()).log(Level.SEVERE, null, ex);
/* 250:334 */       return "El certificado con el que intenta firmar el comprobante esta expirado\nfavor actualize su certificado digital con la Autoridad Certificadora";
/* 251:    */     }
/* 252:    */     catch (ParserConfigurationException ex)
/* 253:    */     {
/* 254:336 */       Logger.getLogger(X509Utils.class.getName()).log(Level.SEVERE, null, ex);
/* 255:337 */       return "Archivo XML a firmar mal definido o estructurado";
/* 256:    */     }
/* 257:    */     catch (SAXException ex)
/* 258:    */     {
/* 259:339 */       Logger.getLogger(X509Utils.class.getName()).log(Level.SEVERE, null, ex);
/* 260:340 */       return "Archivo XML a firmar mal definido o estructurado";
/* 261:    */     }
/* 262:    */     catch (Exception ex)
/* 263:    */     {
/* 264:342 */       Logger.getLogger(X509Utils.class.getName()).log(Level.SEVERE, null, ex);
/* 265:343 */       if (ex.getMessage() == null) {
/* 266:344 */         respuesta = "Error al firmar archivo: No se pudo acceder a la clave privada del certificado";
/* 267:    */       }
/* 268:346 */       return "Error al firmar archivo: " + ex.getMessage();
/* 269:    */     }
/* 270:350 */     return respuesta;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public static String obtenerOidAutoridad(X509Certificate certificado)
/* 274:    */   {
/* 275:360 */     String oidRaiz = null;
/* 276:    */     
/* 277:    */ 
/* 278:363 */     X500NameGeneral x500emisor = new X500NameGeneral(certificado.getIssuerDN().getName());
/* 279:364 */     String nombreAutoridad = x500emisor.getCN();
/* 280:366 */     if (nombreAutoridad.equals(AutoridadesCertificantes.BANCO_CENTRAL.getCn())) {
/* 281:367 */       oidRaiz = AutoridadesCertificantes.BANCO_CENTRAL.getOid();
/* 282:368 */     } else if (nombreAutoridad.equals(AutoridadesCertificantes.ANF.getCn())) {
/* 283:369 */       oidRaiz = AutoridadesCertificantes.ANF.getOid();
/* 284:370 */     } else if (nombreAutoridad.equals(AutoridadesCertificantes.SECURITY_DATA.getCn())) {
/* 285:371 */       oidRaiz = AutoridadesCertificantes.SECURITY_DATA.getOid();
/* 286:    */     }
/* 287:374 */     oidRaiz = oidRaiz.concat(".3.11");
/* 288:375 */     return oidRaiz;
/* 289:    */   }
/* 290:    */   
/* 291:    */   private static void fixAliases(KeyStore keyStore)
/* 292:    */   {
/* 293:    */     try
/* 294:    */     {
/* 295:391 */       field = keyStore.getClass().getDeclaredField("keyStoreSpi");
/* 296:392 */       field.setAccessible(true);
/* 297:393 */       KeyStoreSpi keyStoreVeritable = (KeyStoreSpi)field.get(keyStore);
/* 298:395 */       if ("sun.security.mscapi.KeyStore$MY".equals(keyStoreVeritable.getClass().getName()))
/* 299:    */       {
/* 300:400 */         field = keyStoreVeritable.getClass().getEnclosingClass().getDeclaredField("entries");
/* 301:401 */         field.setAccessible(true);
/* 302:402 */         Collection entries = (Collection)field.get(keyStoreVeritable);
/* 303:404 */         for (Object entry : entries)
/* 304:    */         {
/* 305:405 */           field = entry.getClass().getDeclaredField("certChain");
/* 306:406 */           field.setAccessible(true);
/* 307:407 */           X509Certificate[] certificates = (X509Certificate[])field.get(entry);
/* 308:    */           
/* 309:409 */           String hashCode = Integer.toString(certificates[0].hashCode());
/* 310:    */           
/* 311:411 */           field = entry.getClass().getDeclaredField("alias");
/* 312:412 */           field.setAccessible(true);
/* 313:413 */           String alias = (String)field.get(entry);
/* 314:415 */           if (!alias.equals(hashCode)) {
/* 315:416 */             field.set(entry, alias.concat(" - ").concat(hashCode));
/* 316:    */           }
/* 317:    */         }
/* 318:    */       }
/* 319:    */     }
/* 320:    */     catch (Exception ex)
/* 321:    */     {
/* 322:    */       Field field;
/* 323:421 */       Logger.getLogger(X509Utils.class.getName()).log(Level.SEVERE, null, ex);
/* 324:    */     }
/* 325:    */   }
/* 326:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.X509Utils
 * JD-Core Version:    0.7.0.1
 */