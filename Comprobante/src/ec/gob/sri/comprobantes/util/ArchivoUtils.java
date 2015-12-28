/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import com.thoughtworks.xstream.XStream;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   6:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*   8:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*   9:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*  10:    */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*  11:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*  12:    */ import ec.gob.sri.comprobantes.sql.ClavesSQL;
/*  13:    */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*  14:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*  15:    */ import ec.gob.sri.comprobantes.util.xml.Java2XML;
/*  16:    */ import ec.gob.sri.comprobantes.util.xml.LectorXPath;
/*  17:    */ import ec.gob.sri.comprobantes.util.xml.ValidadorEstructuraDocumento;
/*  18:    */ import ec.gob.sri.comprobantes.util.xml.XStreamUtil;
/*  19:    */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
/*  20:    */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
/*  21:    */ import java.io.BufferedReader;
/*  22:    */ import java.io.ByteArrayInputStream;
/*  23:    */ import java.io.File;
/*  24:    */ import java.io.FileInputStream;
/*  25:    */ import java.io.FileOutputStream;
/*  26:    */ import java.io.FileReader;
/*  27:    */ import java.io.FileWriter;
/*  28:    */ import java.io.IOException;
/*  29:    */ import java.io.InputStream;
/*  30:    */ import java.io.InputStreamReader;
/*  31:    */ import java.io.OutputStream;
/*  32:    */ import java.io.OutputStreamWriter;
/*  33:    */ import java.io.PrintStream;
/*  34:    */ import java.io.Reader;
/*  35:    */ import java.util.logging.Level;
/*  36:    */ import java.util.logging.Logger;
/*  37:    */ import javax.swing.JFrame;
/*  38:    */ import javax.swing.JOptionPane;
/*  39:    */ import javax.xml.parsers.DocumentBuilder;
/*  40:    */ import javax.xml.parsers.DocumentBuilderFactory;
/*  41:    */ import javax.xml.transform.Transformer;
/*  42:    */ import javax.xml.transform.TransformerFactory;
/*  43:    */ import javax.xml.transform.dom.DOMSource;
/*  44:    */ import javax.xml.transform.stream.StreamResult;
/*  45:    */ import javax.xml.xpath.XPath;
/*  46:    */ import javax.xml.xpath.XPathConstants;
/*  47:    */ import javax.xml.xpath.XPathExpression;
/*  48:    */ import javax.xml.xpath.XPathFactory;
/*  49:    */ import org.w3c.dom.Document;
/*  50:    */ import org.w3c.dom.Node;
/*  51:    */ import xadesbes.ServicioFirmaXades;
/*  52:    */ 
/*  53:    */ public class ArchivoUtils
/*  54:    */ {
/*  55:    */   public static String archivoToString(String rutaArchivo)
/*  56:    */   {
/*  57: 70 */     StringBuffer buffer = new StringBuffer();
/*  58:    */     try
/*  59:    */     {
/*  60: 73 */       FileInputStream fis = new FileInputStream(rutaArchivo);
/*  61: 74 */       InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
/*  62: 75 */       Reader in = new BufferedReader(isr);
/*  63:    */       int ch;
/*  64: 77 */       while ((ch = in.read()) > -1) {
/*  65: 78 */         buffer.append((char)ch);
/*  66:    */       }
/*  67: 80 */       in.close();
/*  68: 81 */       return buffer.toString();
/*  69:    */     }
/*  70:    */     catch (IOException e)
/*  71:    */     {
/*  72: 83 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
/*  73:    */     }
/*  74: 84 */     return null;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public static File stringToArchivo(String rutaArchivo, String contenidoArchivo)
/*  78:    */   {
/*  79: 97 */     FileOutputStream fos = null;
/*  80: 98 */     archivoCreado = null;
/*  81:    */     try
/*  82:    */     {
/*  83:102 */       fos = new FileOutputStream(rutaArchivo);
/*  84:103 */       OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
/*  85:104 */       for (int i = 0; i < contenidoArchivo.length(); i++) {
/*  86:105 */         out.write(contenidoArchivo.charAt(i));
/*  87:    */       }
/*  88:107 */       out.close();
/*  89:    */       
/*  90:109 */       return new File(rutaArchivo);
/*  91:    */     }
/*  92:    */     catch (Exception ex)
/*  93:    */     {
/*  94:112 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/*  95:113 */       return null;
/*  96:    */     }
/*  97:    */     finally
/*  98:    */     {
/*  99:    */       try
/* 100:    */       {
/* 101:116 */         if (fos != null) {
/* 102:117 */           fos.close();
/* 103:    */         }
/* 104:    */       }
/* 105:    */       catch (Exception ex)
/* 106:    */       {
/* 107:120 */         Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 108:    */       }
/* 109:    */     }
/* 110:    */   }
/* 111:    */   
/* 112:    */   public static byte[] archivoToByte(File file)
/* 113:    */     throws IOException
/* 114:    */   {
/* 115:136 */     buffer = new byte[(int)file.length()];
/* 116:137 */     InputStream ios = null;
/* 117:    */     try
/* 118:    */     {
/* 119:139 */       ios = new FileInputStream(file);
/* 120:140 */       if (ios.read(buffer) == -1) {
/* 121:141 */         throw new IOException("EOF reached while trying to read the whole file");
/* 122:    */       }
/* 123:153 */       return buffer;
/* 124:    */     }
/* 125:    */     finally
/* 126:    */     {
/* 127:    */       try
/* 128:    */       {
/* 129:145 */         if (ios != null) {
/* 130:146 */           ios.close();
/* 131:    */         }
/* 132:    */       }
/* 133:    */       catch (IOException e)
/* 134:    */       {
/* 135:149 */         Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
/* 136:    */       }
/* 137:    */     }
/* 138:    */   }
/* 139:    */   
/* 140:    */   public static boolean byteToFile(byte[] arrayBytes, String rutaArchivo)
/* 141:    */   {
/* 142:164 */     boolean respuesta = false;
/* 143:    */     try
/* 144:    */     {
/* 145:166 */       File file = new File(rutaArchivo);
/* 146:167 */       file.createNewFile();
/* 147:168 */       FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
/* 148:169 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayBytes);
/* 149:170 */       OutputStream outputStream = new FileOutputStream(rutaArchivo);
/* 150:    */       int data;
/* 151:173 */       while ((data = byteArrayInputStream.read()) != -1) {
/* 152:174 */         outputStream.write(data);
/* 153:    */       }
/* 154:177 */       fileInputStream.close();
/* 155:178 */       outputStream.close();
/* 156:179 */       respuesta = true;
/* 157:    */     }
/* 158:    */     catch (IOException ex)
/* 159:    */     {
/* 160:181 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 161:    */     }
/* 162:183 */     return respuesta;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public static String obtenerValorXML(File xmlDocument, String expression)
/* 166:    */   {
/* 167:195 */     String valor = null;
/* 168:    */     try
/* 169:    */     {
/* 170:198 */       LectorXPath reader = new LectorXPath(xmlDocument.getPath());
/* 171:199 */       valor = (String)reader.leerArchivo(expression, XPathConstants.STRING);
/* 172:    */     }
/* 173:    */     catch (Exception e)
/* 174:    */     {
/* 175:202 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
/* 176:    */     }
/* 177:205 */     return valor;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public static String seleccionaXsd(String tipo)
/* 181:    */   {
/* 182:215 */     String nombreXsd = null;
/* 183:217 */     if (tipo.equals(TipoComprobanteEnum.FACTURA.getCode())) {
/* 184:218 */       nombreXsd = TipoComprobanteEnum.FACTURA.getXsd();
/* 185:219 */     } else if (tipo.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode())) {
/* 186:220 */       nombreXsd = TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getXsd();
/* 187:221 */     } else if (tipo.equals(TipoComprobanteEnum.GUIA_DE_REMISION.getCode())) {
/* 188:222 */       nombreXsd = TipoComprobanteEnum.GUIA_DE_REMISION.getXsd();
/* 189:223 */     } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode())) {
/* 190:224 */       nombreXsd = TipoComprobanteEnum.NOTA_DE_CREDITO.getXsd();
/* 191:225 */     } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode())) {
/* 192:226 */       nombreXsd = TipoComprobanteEnum.NOTA_DE_DEBITO.getXsd();
/* 193:227 */     } else if (tipo.equals(TipoComprobanteEnum.LOTE.getCode())) {
/* 194:228 */       nombreXsd = TipoComprobanteEnum.LOTE.getXsd();
/* 195:    */     }
/* 196:231 */     return nombreXsd;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public static void firmarEnviarAutorizar(Emisor emisor, String pathCompletoArchivoAFirmar, String nombreArchivo, String ruc, String codDoc, String claveDeAcceso, String password)
/* 200:    */     throws InterruptedException
/* 201:    */   {
/* 202:246 */     RespuestaSolicitud respuestaRecepcion = new RespuestaSolicitud();
/* 203:247 */     String respuestaFirma = null;
/* 204:248 */     String respAutorizacion = null;
/* 205:    */     try
/* 206:    */     {
/* 207:251 */       String dirFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 208:    */       
/* 209:    */ 
/* 210:254 */       respuestaFirma = firmarArchivo(emisor, pathCompletoArchivoAFirmar, dirFirmados, null, password);
/* 211:256 */       if (respuestaFirma == null)
/* 212:    */       {
/* 213:258 */         new File(pathCompletoArchivoAFirmar).delete();
/* 214:    */         
/* 215:260 */         File archivoFirmado = new File(dirFirmados + File.separator + nombreArchivo);
/* 216:    */         
/* 217:    */ 
/* 218:263 */         respuestaRecepcion = EnvioComprobantesWs.obtenerRespuestaEnvio(archivoFirmado, ruc, codDoc, claveDeAcceso, FormGenerales.devuelveUrlWs(emisor.getTipoAmbiente(), "RecepcionComprobantes"));
/* 219:266 */         if (respuestaRecepcion.getEstado().equals("RECIBIDA"))
/* 220:    */         {
/* 221:269 */           Thread.currentThread();Thread.sleep(emisor.getTiempoEspera().intValue() * 1000);
/* 222:270 */           respAutorizacion = AutorizacionComprobantesWs.autorizarComprobanteIndividual(claveDeAcceso, nombreArchivo, emisor.getTipoAmbiente());
/* 223:272 */           if (respAutorizacion.equals("AUTORIZADO"))
/* 224:    */           {
/* 225:273 */             JOptionPane.showMessageDialog(new JFrame(), "El comprobante fue autorizado por el SRI", "Respuesta", 1);
/* 226:274 */             archivoFirmado.delete();
/* 227:    */           }
/* 228:276 */           else if (respAutorizacion != null)
/* 229:    */           {
/* 230:277 */             String estado = respAutorizacion.substring(0, respAutorizacion.lastIndexOf("|"));
/* 231:278 */             String resultado = respAutorizacion.substring(respAutorizacion.lastIndexOf("|") + 1, respAutorizacion.length());
/* 232:279 */             JOptionPane.showMessageDialog(new JFrame(), "El comprobante fue guardado, firmado y enviado exitósamente, pero no fue Autorizado\n" + estado + "\n" + FormGenerales.insertarCaracteres(resultado, "\n", 160), "Respuesta", 1);
/* 233:    */           }
/* 234:    */         }
/* 235:282 */         else if (respuestaRecepcion.getEstado().equals("DEVUELTA"))
/* 236:    */         {
/* 237:285 */           String dirRechazados = dirFirmados + File.separator + "rechazados";
/* 238:286 */           String resultado = FormGenerales.insertarCaracteres(EnvioComprobantesWs.obtenerMensajeRespuesta(respuestaRecepcion), "\n", 160);
/* 239:    */           
/* 240:    */ 
/* 241:289 */           anadirMotivosRechazo(archivoFirmado, respuestaRecepcion);
/* 242:    */           
/* 243:291 */           File rechazados = new File(dirRechazados);
/* 244:292 */           if (!rechazados.exists()) {
/* 245:293 */             new File(dirRechazados).mkdir();
/* 246:    */           }
/* 247:296 */           if (!copiarArchivo(archivoFirmado, rechazados.getPath() + File.separator + nombreArchivo)) {
/* 248:297 */             JOptionPane.showMessageDialog(new JFrame(), "Error al mover archivo a carpeta rechazados", "Respuesta", 1);
/* 249:    */           } else {
/* 250:299 */             archivoFirmado.delete();
/* 251:    */           }
/* 252:302 */           JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + resultado, "Se ha producido un error ", 0);
/* 253:    */         }
/* 254:    */       }
/* 255:    */       else
/* 256:    */       {
/* 257:305 */         JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de firmar digitalmente el archivo:\n" + respuestaFirma, "Se ha producido un error ", 0);
/* 258:    */       }
/* 259:    */     }
/* 260:    */     catch (Exception ex)
/* 261:    */     {
/* 262:309 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 263:    */     }
/* 264:    */   }
/* 265:    */   
/* 266:    */   public static String firmarArchivo(Emisor emisor, String archivoACrear, String dirFirmados, String tokenId, String password)
/* 267:    */   {
/* 268:315 */     String respuestaFirma = null;
/* 269:    */     try
/* 270:    */     {
/* 271:318 */       if (tokenId == null) {
/* 272:319 */         tokenId = emisor.getToken();
/* 273:    */       }
/* 274:322 */       if ((password == null) || (System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) {
/* 275:325 */         respuestaFirma = X509Utils.firmaValidaArchivo(new File(archivoACrear), dirFirmados, emisor.getRuc(), tokenId, password);
/* 276:    */       } else {
/* 277:327 */         respuestaFirma = ServicioFirmaXades.firmaValidaArchivo(new File(archivoACrear), dirFirmados, emisor.getRuc(), password.toCharArray());
/* 278:    */       }
/* 279:    */     }
/* 280:    */     catch (Exception ex)
/* 281:    */     {
/* 282:331 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 283:332 */       return ex.getMessage();
/* 284:    */     }
/* 285:334 */     return respuestaFirma;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public static String validaArchivoXSD(String tipoComprobante, String pathArchivoXML)
/* 289:    */   {
/* 290:346 */     String respuestaValidacion = null;
/* 291:    */     try
/* 292:    */     {
/* 293:350 */       ValidadorEstructuraDocumento validador = new ValidadorEstructuraDocumento();
/* 294:351 */       String nombreXsd = seleccionaXsd(tipoComprobante);
/* 295:    */       
/* 296:353 */       String pathArchivoXSD = "resources/xsd/" + nombreXsd;
/* 297:355 */       if (pathArchivoXML != null)
/* 298:    */       {
/* 299:356 */         validador.setArchivoXML(new File(pathArchivoXML));
/* 300:357 */         validador.setArchivoXSD(new File(pathArchivoXSD));
/* 301:    */         
/* 302:359 */         respuestaValidacion = validador.validacion();
/* 303:    */       }
/* 304:    */     }
/* 305:    */     catch (Exception ex)
/* 306:    */     {
/* 307:362 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 308:    */     }
/* 309:364 */     return respuestaValidacion;
/* 310:    */   }
/* 311:    */   
/* 312:    */   private static String realizaMarshal(Object comprobante, String pathArchivo)
/* 313:    */   {
/* 314:375 */     String respuesta = null;
/* 315:377 */     if ((comprobante instanceof Factura)) {
/* 316:378 */       respuesta = Java2XML.marshalFactura((Factura)comprobante, pathArchivo);
/* 317:379 */     } else if ((comprobante instanceof NotaDebito)) {
/* 318:380 */       respuesta = Java2XML.marshalNotaDeDebito((NotaDebito)comprobante, pathArchivo);
/* 319:381 */     } else if ((comprobante instanceof NotaCredito)) {
/* 320:382 */       respuesta = Java2XML.marshalNotaDeCredito((NotaCredito)comprobante, pathArchivo);
/* 321:383 */     } else if ((comprobante instanceof ComprobanteRetencion)) {
/* 322:384 */       respuesta = Java2XML.marshalComprobanteRetencion((ComprobanteRetencion)comprobante, pathArchivo);
/* 323:385 */     } else if ((comprobante instanceof GuiaRemision)) {
/* 324:386 */       respuesta = Java2XML.marshalGuiaRemision((GuiaRemision)comprobante, pathArchivo);
/* 325:    */     }
/* 326:388 */     return respuesta;
/* 327:    */   }
/* 328:    */   
/* 329:    */   public static String crearArchivoXml2(String pathArchivo, Object objetoModelo, ClaveContingencia claveContingencia, Long secuencial, String tipoComprobante)
/* 330:    */   {
/* 331:400 */     String respuestaCreacion = null;
/* 332:401 */     if (objetoModelo != null) {
/* 333:    */       try
/* 334:    */       {
/* 335:403 */         respuestaCreacion = realizaMarshal(objetoModelo, pathArchivo);
/* 336:408 */         if (respuestaCreacion == null)
/* 337:    */         {
/* 338:410 */           if ((claveContingencia != null) && (claveContingencia.getCodigoComprobante() != null))
/* 339:    */           {
/* 340:411 */             claveContingencia.setUsada("S");
/* 341:412 */             new ClavesSQL().actualizaClave(claveContingencia);
/* 342:    */           }
/* 343:415 */           new ComprobantesSQL().actualizaSecuencial(tipoComprobante, Long.valueOf(secuencial.longValue() + 1L));
/* 344:    */         }
/* 345:    */       }
/* 346:    */       catch (Exception ex)
/* 347:    */       {
/* 348:418 */         Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 349:    */       }
/* 350:    */     } else {
/* 351:421 */       respuestaCreacion = "Ingrese los campos obligatorios del comprobante";
/* 352:    */     }
/* 353:423 */     return respuestaCreacion;
/* 354:    */   }
/* 355:    */   
/* 356:    */   public static String obtieneClaveAccesoAutorizacion(Autorizacion item)
/* 357:    */   {
/* 358:433 */     String claveAcceso = null;
/* 359:    */     
/* 360:435 */     String xmlAutorizacion = XStreamUtil.getRespuestaLoteXStream().toXML(item);
/* 361:436 */     File archivoTemporal = new File("temp.xml");
/* 362:    */     
/* 363:438 */     stringToArchivo(archivoTemporal.getPath(), xmlAutorizacion);
/* 364:439 */     String contenidoXML = decodeArchivoBase64(archivoTemporal.getPath());
/* 365:441 */     if (contenidoXML != null)
/* 366:    */     {
/* 367:442 */       stringToArchivo(archivoTemporal.getPath(), contenidoXML);
/* 368:443 */       claveAcceso = obtenerValorXML(archivoTemporal, "/*/infoTributaria/claveAcceso");
/* 369:    */     }
/* 370:447 */     return claveAcceso;
/* 371:    */   }
/* 372:    */   
/* 373:    */   public static String decodeArchivoBase64(String pathArchivo)
/* 374:    */   {
/* 375:458 */     String xmlDecodificado = null;
/* 376:    */     try
/* 377:    */     {
/* 378:460 */       File file = new File(pathArchivo);
/* 379:461 */       if (file.exists())
/* 380:    */       {
/* 381:463 */         String encd = obtenerValorXML(file, "/*/comprobante");
/* 382:    */         
/* 383:    */ 
/* 384:466 */         xmlDecodificado = encd;
/* 385:    */       }
/* 386:    */       else
/* 387:    */       {
/* 388:469 */         System.out.print("File not found!");
/* 389:    */       }
/* 390:    */     }
/* 391:    */     catch (Exception e)
/* 392:    */     {
/* 393:472 */       Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
/* 394:    */     }
/* 395:474 */     return xmlDecodificado;
/* 396:    */   }
/* 397:    */   
/* 398:    */   public static boolean anadirMotivosRechazo(File archivo, RespuestaSolicitud respuestaRecepcion)
/* 399:    */   {
/* 400:489 */     boolean exito = false;
/* 401:490 */     File respuesta = new File("respuesta.xml");
/* 402:491 */     Java2XML.marshalRespuestaSolicitud(respuestaRecepcion, respuesta.getPath());
/* 403:492 */     if (adjuntarArchivo(respuesta, archivo) == true)
/* 404:    */     {
/* 405:493 */       exito = true;
/* 406:494 */       respuesta.delete();
/* 407:    */     }
/* 408:496 */     return exito;
/* 409:    */   }
/* 410:    */   
/* 411:    */   public static boolean adjuntarArchivo(File respuesta, File comprobante)
/* 412:    */   {
/* 413:507 */     boolean exito = false;
/* 414:    */     try
/* 415:    */     {
/* 416:510 */       Document document = merge("*", new File[] { comprobante, respuesta });
/* 417:    */       
/* 418:512 */       DOMSource source = new DOMSource(document);
/* 419:    */       
/* 420:514 */       StreamResult result = new StreamResult(new OutputStreamWriter(new FileOutputStream(comprobante), "UTF-8"));
/* 421:    */       
/* 422:516 */       TransformerFactory transFactory = TransformerFactory.newInstance();
/* 423:517 */       Transformer transformer = transFactory.newTransformer();
/* 424:    */       
/* 425:519 */       transformer.transform(source, result);
/* 426:    */     }
/* 427:    */     catch (Exception ex)
/* 428:    */     {
/* 429:522 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 430:    */     }
/* 431:524 */     return exito;
/* 432:    */   }
/* 433:    */   
/* 434:    */   private static Document merge(String exp, File... files)
/* 435:    */     throws Exception
/* 436:    */   {
/* 437:537 */     XPathFactory xPathFactory = XPathFactory.newInstance();
/* 438:538 */     XPath xpath = xPathFactory.newXPath();
/* 439:539 */     XPathExpression expression = xpath.compile(exp);
/* 440:    */     
/* 441:541 */     DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
/* 442:542 */     docBuilderFactory.setIgnoringElementContentWhitespace(true);
/* 443:543 */     DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
/* 444:544 */     Document base = docBuilder.parse(files[0]);
/* 445:    */     
/* 446:546 */     Node results = (Node)expression.evaluate(base, XPathConstants.NODE);
/* 447:547 */     if (results == null) {
/* 448:548 */       throw new IOException(files[0] + ": expression does not evaluate to node");
/* 449:    */     }
/* 450:551 */     for (int i = 1; i < files.length; i++)
/* 451:    */     {
/* 452:552 */       Document merge = docBuilder.parse(files[i]);
/* 453:553 */       Node nextResults = (Node)expression.evaluate(merge, XPathConstants.NODE);
/* 454:554 */       results.appendChild(base.importNode(nextResults, true));
/* 455:    */     }
/* 456:563 */     return base;
/* 457:    */   }
/* 458:    */   
/* 459:    */   public static boolean copiarArchivo(File archivoOrigen, String pathDestino)
/* 460:    */   {
/* 461:574 */     FileReader in = null;
/* 462:575 */     resultado = false;
/* 463:    */     try
/* 464:    */     {
/* 465:578 */       File outputFile = new File(pathDestino);
/* 466:579 */       in = new FileReader(archivoOrigen);
/* 467:580 */       FileWriter out = new FileWriter(outputFile);
/* 468:    */       int c;
/* 469:582 */       while ((c = in.read()) != -1) {
/* 470:583 */         out.write(c);
/* 471:    */       }
/* 472:585 */       in.close();
/* 473:586 */       out.close();
/* 474:587 */       return true;
/* 475:    */     }
/* 476:    */     catch (Exception ex)
/* 477:    */     {
/* 478:590 */       Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 479:    */     }
/* 480:    */     finally
/* 481:    */     {
/* 482:    */       try
/* 483:    */       {
/* 484:593 */         in.close();
/* 485:    */       }
/* 486:    */       catch (IOException ex)
/* 487:    */       {
/* 488:595 */         Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
/* 489:    */       }
/* 490:    */     }
/* 491:    */   }
/* 492:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ArchivoUtils
 * JD-Core Version:    0.7.0.1
 */