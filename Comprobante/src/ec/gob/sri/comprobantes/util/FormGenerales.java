/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   6:    */ import ec.gob.sri.comprobantes.administracion.modelo.Proxy;
/*   7:    */ import ec.gob.sri.comprobantes.sql.ClavesSQL;
/*   8:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   9:    */ import ec.gob.sri.comprobantes.sql.EmisorSQL;
/*  10:    */ import ec.gob.sri.comprobantes.sql.ProxySQL;
/*  11:    */ import ec.gob.sri.comprobantes.view.formas.comprobantes.Cabecera;
/*  12:    */ import ec.gob.sri.comprobantes.view.formas.comprobantes.ComprobanteRetencionView;
/*  13:    */ import ec.gob.sri.comprobantes.view.formas.comprobantes.FacturaView;
/*  14:    */ import java.awt.event.KeyEvent;
/*  15:    */ import java.io.File;
/*  16:    */ import java.io.PrintStream;
/*  17:    */ import java.net.MalformedURLException;
/*  18:    */ import java.sql.SQLException;
/*  19:    */ import java.util.Calendar;
/*  20:    */ import java.util.Date;
/*  21:    */ import java.util.logging.Level;
/*  22:    */ import java.util.logging.Logger;
/*  23:    */ import javax.swing.JButton;
/*  24:    */ import javax.swing.JFrame;
/*  25:    */ import javax.swing.JLabel;
/*  26:    */ import javax.swing.JOptionPane;
/*  27:    */ import javax.swing.JPasswordField;
/*  28:    */ import javax.swing.JTextArea;
/*  29:    */ import javax.swing.JTextField;
/*  30:    */ import javax.xml.ws.WebServiceException;
/*  31:    */ 
/*  32:    */ public class FormGenerales
/*  33:    */ {
/*  34: 42 */   private static char SEPARADOR_DECIMAL = '.';
/*  35:    */   
/*  36:    */   public static void limpiaDatosCliente(Object form)
/*  37:    */   {
/*  38: 50 */     ComprobanteRetencionView item = null;
/*  39: 52 */     if ((form instanceof ComprobanteRetencionView)) {
/*  40: 53 */       item = (ComprobanteRetencionView)form;
/*  41:    */     }
/*  42: 55 */     item.txtCedulaComprador.setText(null);
/*  43: 56 */     item.txtRazonComprador.setText(null);
/*  44: 57 */     item.txtCedulaComprador.setEnabled(false);
/*  45: 58 */     item.txtRazonComprador.setEnabled(false);
/*  46: 59 */     item.btnBuscar.setEnabled(false);
/*  47:    */   }
/*  48:    */   
/*  49:    */   public static void habilitaCamposCliente(Object form)
/*  50:    */   {
/*  51: 68 */     ComprobanteRetencionView item = null;
/*  52: 70 */     if ((form instanceof ComprobanteRetencionView)) {
/*  53: 71 */       item = (ComprobanteRetencionView)form;
/*  54:    */     }
/*  55: 74 */     item.txtCedulaComprador.setText(null);
/*  56: 75 */     item.txtRazonComprador.setText(null);
/*  57: 76 */     item.txtCedulaComprador.setEnabled(true);
/*  58: 77 */     item.txtRazonComprador.setEnabled(true);
/*  59: 78 */     item.btnBuscar.setEnabled(true);
/*  60:    */   }
/*  61:    */   
/*  62:    */   public static boolean validaValoresNumericos(KeyEvent evt, JTextField componente)
/*  63:    */   {
/*  64: 87 */     boolean resp = false;
/*  65: 88 */     String old = componente.getText();
/*  66: 89 */     char c = evt.getKeyChar();
/*  67: 91 */     if ((c == SEPARADOR_DECIMAL) && (old.indexOf(c) > -1))
/*  68:    */     {
/*  69: 92 */       JOptionPane.showMessageDialog(new JFrame(), "La cantidad ingresada no puede tener mas de un (.) decimal", "Se ha producido un error ", 0);
/*  70:    */       
/*  71: 94 */       componente.setText(old);
/*  72:    */     }
/*  73: 96 */     if (((Character.isLetter(c)) && (!evt.isAltDown())) || ("`~!@#$%^&*()_+=\\|\"':;?/><, -".indexOf(c) > -1))
/*  74:    */     {
/*  75: 97 */       JOptionPane.showMessageDialog(new JFrame(), "Solo se permiten valores numéricos", "Se ha producido un error ", 0);
/*  76:    */       
/*  77: 99 */       componente.setText(old);
/*  78:    */     }
/*  79:    */     else
/*  80:    */     {
/*  81:101 */       resp = true;
/*  82:    */     }
/*  83:103 */     return resp;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public static boolean validaSoloNumeros(KeyEvent evt, JTextField componente)
/*  87:    */   {
/*  88:112 */     boolean resp = false;
/*  89:113 */     String old = componente.getText();
/*  90:114 */     char c = evt.getKeyChar();
/*  91:116 */     if (((Character.isLetter(c)) && (!evt.isAltDown())) || ("`~!@#$%^&*()_+=\\|\"':;?/>.<, -".indexOf(c) > -1))
/*  92:    */     {
/*  93:117 */       JOptionPane.showMessageDialog(new JFrame(), "Solo se permiten números", "ERROR", 0);
/*  94:    */       
/*  95:119 */       componente.setText(old);
/*  96:    */     }
/*  97:    */     else
/*  98:    */     {
/*  99:121 */       resp = true;
/* 100:    */     }
/* 101:123 */     return resp;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public static boolean validaLongitud(KeyEvent evt, int longitudMaxima, JTextField componente)
/* 105:    */   {
/* 106:134 */     boolean resp = false;
/* 107:135 */     String old = componente.getText();
/* 108:136 */     char c = evt.getKeyChar();
/* 109:138 */     if ((old.length() >= longitudMaxima) && (c != '\b') && (!evt.isActionKey()))
/* 110:    */     {
/* 111:139 */       JOptionPane.showMessageDialog(new JFrame(), "La longitud máxima del campo ha sido alcanzada: " + longitudMaxima, "ERROR", 0);
/* 112:    */       
/* 113:141 */       componente.setText(old);
/* 114:    */     }
/* 115:    */     else
/* 116:    */     {
/* 117:143 */       resp = true;
/* 118:    */     }
/* 119:145 */     return resp;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public static String devuelveUrlWs(String ambiente, String nombreServicio)
/* 123:    */   {
/* 124:159 */     StringBuilder url = new StringBuilder();
/* 125:160 */     String direccionIPServicio = null;
/* 126:161 */     Proxy configuracion = null;
/* 127:    */     try
/* 128:    */     {
/* 129:164 */       configuracion = new ProxySQL().obtenerProxy();
/* 130:    */     }
/* 131:    */     catch (Exception ex)
/* 132:    */     {
/* 133:166 */       Logger.getLogger(FormGenerales.class.getName()).log(Level.SEVERE, null, ex);
/* 134:    */     }
/* 135:168 */     if (configuracion != null)
/* 136:    */     {
/* 137:170 */       if (configuracion.getUrl() != null)
/* 138:    */       {
/* 139:171 */         String uri = configuracion.getUrl() + ":" + configuracion.getPuerto();
/* 140:172 */         ProxyConfig.init(uri);
/* 141:    */       }
/* 142:175 */       if (ambiente.equals(TipoAmbienteEnum.PRODUCCION.getCode()) == true) {
/* 143:176 */         direccionIPServicio = configuracion.getWsProduccion();
/* 144:177 */       } else if (ambiente.equals(TipoAmbienteEnum.PRUEBAS.getCode()) == true) {
/* 145:178 */         direccionIPServicio = configuracion.getWsPruebas();
/* 146:    */       }
/* 147:180 */       url.append(direccionIPServicio);
/* 148:    */       
/* 149:182 */       url.append("/comprobantes-electronicos-ws/");
/* 150:183 */       url.append(nombreServicio);
/* 151:184 */       url.append("?wsdl");
/* 152:185 */       System.out.print(url.toString());
/* 153:    */     }
/* 154:187 */     return url.toString();
/* 155:    */   }
/* 156:    */   
/* 157:    */   public static String validarUrl(String tipoAmbiente, String nombreServicio)
/* 158:    */   {
/* 159:197 */     String mensaje = null;
/* 160:198 */     String url = devuelveUrlWs(tipoAmbiente, nombreServicio);
/* 161:199 */     Object c = EnvioComprobantesWs.webService(url);
/* 162:200 */     if ((c instanceof MalformedURLException)) {
/* 163:201 */       mensaje = ((MalformedURLException)c).getMessage();
/* 164:    */     }
/* 165:203 */     return mensaje;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public static boolean existConnection(String tipoAmbiente, String nombreServicio)
/* 169:    */   {
/* 170:215 */     String url = devuelveUrlWs(tipoAmbiente, nombreServicio);
/* 171:216 */     int i = 0;
/* 172:217 */     Boolean respuesta = Boolean.valueOf(false);
/* 173:218 */     while (i < 3)
/* 174:    */     {
/* 175:219 */       Object c = EnvioComprobantesWs.webService(url);
/* 176:220 */       if (c == null)
/* 177:    */       {
/* 178:221 */         respuesta = Boolean.valueOf(true);
/* 179:222 */         break;
/* 180:    */       }
/* 181:224 */       if ((c instanceof WebServiceException)) {
/* 182:225 */         respuesta = Boolean.valueOf(false);
/* 183:    */       }
/* 184:228 */       i++;
/* 185:    */     }
/* 186:230 */     return respuesta.booleanValue();
/* 187:    */   }
/* 188:    */   
/* 189:    */   public static boolean verificarClavesContingencia()
/* 190:    */   {
/* 191:239 */     boolean respuesta = false;
/* 192:    */     try
/* 193:    */     {
/* 194:241 */       ClavesSQL claves = new ClavesSQL();
/* 195:242 */       ClaveContingencia claveContingenciaExist = claves.obtenerUltimaNoUsada();
/* 196:243 */       if (claveContingenciaExist != null) {
/* 197:244 */         respuesta = true;
/* 198:    */       }
/* 199:    */     }
/* 200:    */     catch (ClassNotFoundException ex)
/* 201:    */     {
/* 202:247 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 203:    */     }
/* 204:    */     catch (SQLException ex)
/* 205:    */     {
/* 206:249 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 207:    */     }
/* 208:251 */     return respuesta;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public static Emisor actualizaEmisor(String tipoEmision, Emisor emisor)
/* 212:    */   {
/* 213:263 */     emisor.setTipoEmision(StringUtil.obtenerTipoEmision(tipoEmision));
/* 214:    */     try
/* 215:    */     {
/* 216:265 */       new EmisorSQL().crearEmisor(emisor);
/* 217:    */     }
/* 218:    */     catch (SQLException ex)
/* 219:    */     {
/* 220:268 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 221:    */     }
/* 222:    */     catch (ClassNotFoundException ex)
/* 223:    */     {
/* 224:270 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 225:    */     }
/* 226:272 */     return emisor;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public static void creaArchivoEnContingencia(String archivoACrear, Object comprobante, String nombreArchivo, ClaveContingencia claveContingencia, Long secuencial, Emisor emisor, String codigoTipoComprobante)
/* 230:    */   {
/* 231:290 */     String respuestaCrear = null;
/* 232:291 */     String password = null;
/* 233:    */     try
/* 234:    */     {
/* 235:294 */       String dirFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 236:    */       
/* 237:    */ 
/* 238:297 */       archivoACrear = archivoACrear.replaceFirst(".xml", "-cont.xml");
/* 239:    */       
/* 240:299 */       respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobante, claveContingencia, secuencial, codigoTipoComprobante);
/* 241:302 */       if ((emisor.getToken().equals("ANF_TOKEN")) || (System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) {
/* 242:305 */         password = ingresaPassword();
/* 243:    */       }
/* 244:308 */       if (respuestaCrear == null)
/* 245:    */       {
/* 246:309 */         String respuestaFirmar = ArchivoUtils.firmarArchivo(emisor, archivoACrear, dirFirmados, emisor.getToken(), password);
/* 247:310 */         if (respuestaFirmar == null)
/* 248:    */         {
/* 249:312 */           new File(archivoACrear).delete();
/* 250:313 */           JOptionPane.showMessageDialog(new JFrame(), archivoACrear, "El comprobante fue firmado exitósamente", 1);
/* 251:    */         }
/* 252:    */       }
/* 253:    */     }
/* 254:    */     catch (Exception ex)
/* 255:    */     {
/* 256:317 */       Logger.getLogger(FormGenerales.class.getName()).log(Level.SEVERE, null, ex);
/* 257:    */     }
/* 258:    */   }
/* 259:    */   
/* 260:    */   public static String obtieneTipoDeComprobante(String claveDeAcceso)
/* 261:    */   {
/* 262:328 */     String abreviatura = null;
/* 263:330 */     if ((claveDeAcceso != null) && (claveDeAcceso.length() == 49))
/* 264:    */     {
/* 265:331 */       String tipo = claveDeAcceso.substring(8, 10);
/* 266:333 */       if (tipo.equals(TipoComprobanteEnum.FACTURA.getCode())) {
/* 267:334 */         abreviatura = TipoComprobanteEnum.FACTURA.getDescripcion();
/* 268:335 */       } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode())) {
/* 269:336 */         abreviatura = TipoComprobanteEnum.NOTA_DE_DEBITO.getDescripcion();
/* 270:337 */       } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode())) {
/* 271:338 */         abreviatura = TipoComprobanteEnum.NOTA_DE_CREDITO.getDescripcion();
/* 272:339 */       } else if (tipo.equals(TipoComprobanteEnum.GUIA_DE_REMISION.getCode())) {
/* 273:340 */         abreviatura = TipoComprobanteEnum.GUIA_DE_REMISION.getDescripcion();
/* 274:341 */       } else if (tipo.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode())) {
/* 275:342 */         abreviatura = TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getDescripcion();
/* 276:343 */       } else if (tipo.equals(TipoComprobanteEnum.LOTE.getCode())) {
/* 277:344 */         abreviatura = TipoComprobanteEnum.LOTE.getDescripcion();
/* 278:    */       }
/* 279:    */     }
/* 280:347 */     return abreviatura;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public static Date eliminaHora(Date date)
/* 284:    */   {
/* 285:358 */     Calendar cal = Calendar.getInstance();
/* 286:359 */     cal.setTime(date);
/* 287:360 */     cal.set(11, 0);
/* 288:361 */     cal.set(12, 0);
/* 289:362 */     cal.set(13, 0);
/* 290:363 */     cal.set(14, 0);
/* 291:364 */     return cal.getTime();
/* 292:    */   }
/* 293:    */   
/* 294:    */   public static Emisor llenaDatosEmisor(Cabecera cabecera1)
/* 295:    */   {
/* 296:374 */     Emisor emisor = null;
/* 297:    */     try
/* 298:    */     {
/* 299:376 */       emisor = new EmisorSQL().obtenerDatosEmisor();
/* 300:378 */       if (emisor != null)
/* 301:    */       {
/* 302:379 */         String contribuyenteEsp = null;
/* 303:381 */         if (!emisor.getContribuyenteEspecial().isEmpty()) {
/* 304:382 */           contribuyenteEsp = emisor.getContribuyenteEspecial();
/* 305:    */         } else {
/* 306:384 */           contribuyenteEsp = "NO";
/* 307:    */         }
/* 308:386 */         cabecera1.lblContribuyente.setText(contribuyenteEsp);
/* 309:387 */         cabecera1.lblDirecEstabl.setText(emisor.getDirEstablecimiento());
/* 310:388 */         cabecera1.lblDirecMatriz.setText(emisor.getDireccionMatriz());
/* 311:389 */         cabecera1.lblNombreComercial.setText(emisor.getNombreComercial());
/* 312:390 */         cabecera1.lblRazonSocial.setText(emisor.getRazonSocial());
/* 313:391 */         cabecera1.lblRuc.setText(emisor.getRuc());
/* 314:392 */         cabecera1.lblObligado.setText(emisor.getLlevaContabilidad().equals("S") ? "SI" : "NO");
/* 315:    */       }
/* 316:    */     }
/* 317:    */     catch (SQLException ex)
/* 318:    */     {
/* 319:396 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 320:    */     }
/* 321:    */     catch (ClassNotFoundException ex)
/* 322:    */     {
/* 323:398 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 324:    */     }
/* 325:400 */     return emisor;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public static String insertarCaracteres(String cadenaLarga, String aInsertar, int longitud)
/* 329:    */   {
/* 330:412 */     StringBuilder sb = new StringBuilder(cadenaLarga);
/* 331:    */     
/* 332:414 */     int i = 0;
/* 333:415 */     while ((i = sb.indexOf(" ", i + longitud)) != -1) {
/* 334:416 */       sb.replace(i, i + 1, aInsertar);
/* 335:    */     }
/* 336:419 */     return sb.toString();
/* 337:    */   }
/* 338:    */   
/* 339:    */   public ClaveContingencia obtieneClaveDeAcceso(String secuencialComprobante, Emisor emisor, String serie, String claveDeAcceso, Date fechaEmision, String tipoComprobante)
/* 340:    */   {
/* 341:429 */     ClaveContingencia clave = new ClaveContingencia();
/* 342:430 */     if (emisor != null) {
/* 343:431 */       serie = emisor.getCodigoEstablecimiento().concat(emisor.getCodPuntoEmision());
/* 344:    */     }
/* 345:434 */     if ((emisor != null) && (emisor.getTipoEmision().equals("1")))
/* 346:    */     {
/* 347:435 */       claveDeAcceso = new ClaveDeAcceso().generaClave(fechaEmision, tipoComprobante, emisor.getRuc(), emisor.getTipoAmbiente(), serie, secuencialComprobante, emisor.getClaveInterna(), "1");
/* 348:    */       
/* 349:437 */       clave.setCodigoComprobante(claveDeAcceso);
/* 350:    */     }
/* 351:438 */     else if ((emisor != null) && ((emisor.getTipoEmision().equals("2")) || (emisor.getTipoEmision().equals("3"))))
/* 352:    */     {
/* 353:    */       try
/* 354:    */       {
/* 355:441 */         clave = new ClavesSQL().obtenerUltimaNoUsada();
/* 356:443 */         if (clave.getClave() != null)
/* 357:    */         {
/* 358:444 */           claveDeAcceso = new ClaveDeAcceso().generaClaveContingencia(fechaEmision, tipoComprobante, clave.getClave(), emisor.getTipoEmision());
/* 359:    */           
/* 360:446 */           clave.setCodigoComprobante(claveDeAcceso);
/* 361:    */         }
/* 362:    */         else
/* 363:    */         {
/* 364:448 */           JOptionPane.showMessageDialog(new JFrame(), "No existen claves de contingencia, por favor cargue claves en el Sistema o cambie su estado de Emisión a: NORMAL", "INFORMACION IMPORTANTE", 1);
/* 365:    */         }
/* 366:    */       }
/* 367:    */       catch (Exception ex)
/* 368:    */       {
/* 369:451 */         Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 370:    */       }
/* 371:    */     }
/* 372:454 */     return clave;
/* 373:    */   }
/* 374:    */   
/* 375:    */   public static boolean validaTextArea(KeyEvent evt, int longitudMaxima, JTextArea componente)
/* 376:    */   {
/* 377:465 */     boolean resp = false;
/* 378:466 */     String old = componente.getText();
/* 379:467 */     char c = evt.getKeyChar();
/* 380:468 */     int key = evt.getKeyCode();
/* 381:470 */     if (esTecladeControl(key) == true)
/* 382:    */     {
/* 383:471 */       resp = true;
/* 384:    */     }
/* 385:472 */     else if ((old.length() >= longitudMaxima) && (c != '\b') && (!evt.isActionKey()))
/* 386:    */     {
/* 387:473 */       JOptionPane.showMessageDialog(new JFrame(), "La longitud máxima del campo ha sido alcanzada: " + longitudMaxima, "ERROR", 0);
/* 388:    */       
/* 389:475 */       componente.setText(old);
/* 390:476 */       resp = false;
/* 391:    */     }
/* 392:    */     else
/* 393:    */     {
/* 394:478 */       resp = true;
/* 395:    */     }
/* 396:480 */     return resp;
/* 397:    */   }
/* 398:    */   
/* 399:    */   private static boolean esTecladeControl(int key)
/* 400:    */   {
/* 401:490 */     boolean resp = false;
/* 402:491 */     if ((key == 226) || (key == 37) || (key == 227) || (key == 39) || (key == 38) || (key == 40) || (key == 10) || (key == 9) || (key == 127)) {
/* 403:496 */       resp = true;
/* 404:    */     }
/* 405:498 */     return resp;
/* 406:    */   }
/* 407:    */   
/* 408:    */   public static String ingresaPassword()
/* 409:    */   {
/* 410:502 */     String password = null;
/* 411:    */     
/* 412:504 */     JPasswordField pwd = new JPasswordField(20);
/* 413:505 */     int action = JOptionPane.showConfirmDialog(null, pwd, "Ingrese la Contraseña del token", 2);
/* 414:506 */     if (action < 0) {
/* 415:507 */       JOptionPane.showMessageDialog(new JFrame(), "Usted canceló la operación");
/* 416:    */     } else {
/* 417:509 */       password = new String(pwd.getPassword());
/* 418:    */     }
/* 419:512 */     return password;
/* 420:    */   }
/* 421:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.FormGenerales
 * JD-Core Version:    0.7.0.1
 */