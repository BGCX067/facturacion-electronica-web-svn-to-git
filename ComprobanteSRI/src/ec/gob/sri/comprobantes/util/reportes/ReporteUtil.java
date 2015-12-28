/*   1:    */ package ec.gob.sri.comprobantes.util.reportes;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.TotalConImpuestos;
/*   8:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto;
/*   9:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*  10:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoAdicional;
/*  11:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoAdicional.CampoAdicional;
/*  12:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoGuiaRemision;
/*  13:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*  14:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoNotaCredito;
/*  15:    */ import ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos;
/*  16:    */ import ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos.TotalImpuesto;
/*  17:    */ import ec.gob.sri.comprobantes.modelo.notadebito.Impuesto;
/*  18:    */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*  19:    */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoNotaDebito;
/*  20:    */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoNotaDebito.Impuestos;
/*  21:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*  22:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoCompRetencion;
/*  23:    */ import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
/*  24:    */ import ec.gob.sri.comprobantes.modelo.reportes.DetallesAdicionalesReporte;
/*  25:    */ import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
/*  26:    */ import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
/*  27:    */ import ec.gob.sri.comprobantes.modelo.reportes.InformacionAdicional;
/*  28:    */ import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
/*  29:    */ import ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte;
/*  30:    */ import ec.gob.sri.comprobantes.modelo.reportes.TotalComprobante;
/*  31:    */ import ec.gob.sri.comprobantes.sql.EmisorSQL;
/*  32:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  33:    */ import ec.gob.sri.comprobantes.util.TipoAmbienteEnum;
/*  34:    */ import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
/*  35:    */ import ec.gob.sri.comprobantes.util.TipoImpuestoEnum;
/*  36:    */ import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
/*  37:    */ import java.awt.Container;
/*  38:    */ import java.awt.Dimension;
/*  39:    */ import java.io.BufferedInputStream;
/*  40:    */ import java.io.FileInputStream;
/*  41:    */ import java.io.FileNotFoundException;
/*  42:    */ import java.io.IOException;
/*  43:    */ import java.io.InputStream;
/*  44:    */ import java.math.BigDecimal;
/*  45:    */ import java.sql.SQLException;
/*  46:    */ import java.util.ArrayList;
/*  47:    */ import java.util.HashMap;
/*  48:    */ import java.util.LinkedList;
/*  49:    */ import java.util.List;
/*  50:    */ import java.util.Locale;
/*  51:    */ import java.util.Map;
/*  52:    */ import java.util.logging.Level;
/*  53:    */ import java.util.logging.Logger;
/*  54:    */ import javax.swing.JFrame;
/*  55:    */ import net.sf.jasperreports.engine.JRDataSource;
/*  56:    */ import net.sf.jasperreports.engine.JRException;
/*  57:    */ import net.sf.jasperreports.engine.JasperFillManager;
/*  58:    */ import net.sf.jasperreports.engine.JasperPrint;
/*  59:    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*  60:    */ import net.sf.jasperreports.view.JRSaveContributor;
/*  61:    */ import net.sf.jasperreports.view.save.JRPdfSaveContributor;
/*  62:    */ 
/*  63:    */ public class ReporteUtil
/*  64:    */ {
/*  65:    */   private static final String DIR_SUCURSAL = "DIR_SUCURSAL";
/*  66:    */   private static final String CONT_ESPECIAL = "CONT_ESPECIAL";
/*  67:    */   private static final String LLEVA_CONTABILIDAD = "LLEVA_CONTABILIDAD";
/*  68:    */   
/*  69:    */   private static Emisor obtenerEmisor()
/*  70:    */     throws SQLException, ClassNotFoundException
/*  71:    */   {
/*  72: 68 */     EmisorSQL emisSQL = new EmisorSQL();
/*  73: 69 */     return emisSQL.obtenerDatosEmisor();
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void generarReporte(String urlReporte, FacturaReporte fact, String numAut, String fechaAut)
/*  77:    */     throws SQLException, ClassNotFoundException
/*  78:    */   {
/*  79: 76 */     FileInputStream is = null;
/*  80:    */     try
/*  81:    */     {
/*  82: 78 */       JRDataSource dataSource = new JRBeanCollectionDataSource(fact.getDetallesAdiciones());
/*  83: 79 */       is = new FileInputStream(urlReporte);
/*  84: 80 */       JasperPrint reporte_view = JasperFillManager.fillReport(is, obtenerMapaParametrosReportes(obtenerParametrosInfoTriobutaria(fact.getFactura().getInfoTributaria(), numAut, fechaAut), obtenerInfoFactura(fact.getFactura().getInfoFactura(), fact)), dataSource);
/*  85: 81 */       showReport(reporte_view); return;
/*  86:    */     }
/*  87:    */     catch (FileNotFoundException ex)
/*  88:    */     {
/*  89: 83 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/*  90:    */     }
/*  91:    */     catch (JRException e)
/*  92:    */     {
/*  93: 85 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
/*  94:    */     }
/*  95:    */     finally
/*  96:    */     {
/*  97:    */       try
/*  98:    */       {
/*  99: 88 */         if (is != null) {
/* 100: 89 */           is.close();
/* 101:    */         }
/* 102:    */       }
/* 103:    */       catch (IOException ex)
/* 104:    */       {
/* 105: 92 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 106:    */       }
/* 107:    */     }
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void generarReporte(String urlReporte, NotaDebitoReporte rep, String numAut, String fechaAut)
/* 111:    */     throws SQLException, ClassNotFoundException
/* 112:    */   {
/* 113:101 */     FileInputStream is = null;
/* 114:    */     try
/* 115:    */     {
/* 116:103 */       JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getDetallesAdiciones());
/* 117:104 */       is = new FileInputStream(urlReporte);
/* 118:105 */       JasperPrint reporte_view = JasperFillManager.fillReport(is, obtenerMapaParametrosReportes(obtenerParametrosInfoTriobutaria(rep.getNotaDebito().getInfoTributaria(), numAut, fechaAut), obtenerInfoND(rep.getNotaDebito().getInfoNotaDebito())), dataSource);
/* 119:    */       
/* 120:107 */       showReport(reporte_view); return;
/* 121:    */     }
/* 122:    */     catch (FileNotFoundException ex)
/* 123:    */     {
/* 124:109 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 125:    */     }
/* 126:    */     catch (JRException e)
/* 127:    */     {
/* 128:111 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
/* 129:    */     }
/* 130:    */     finally
/* 131:    */     {
/* 132:    */       try
/* 133:    */       {
/* 134:114 */         if (is != null) {
/* 135:115 */           is.close();
/* 136:    */         }
/* 137:    */       }
/* 138:    */       catch (IOException ex)
/* 139:    */       {
/* 140:118 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 141:    */       }
/* 142:    */     }
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void generarReporte(String urlReporte, NotaCreditoReporte rep, String numAut, String fechaAut)
/* 146:    */     throws SQLException, ClassNotFoundException
/* 147:    */   {
/* 148:127 */     FileInputStream is = null;
/* 149:    */     try
/* 150:    */     {
/* 151:129 */       JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getDetallesAdiciones());
/* 152:130 */       is = new FileInputStream(urlReporte);
/* 153:131 */       JasperPrint reporte_view = JasperFillManager.fillReport(is, obtenerMapaParametrosReportes(obtenerParametrosInfoTriobutaria(rep.getNotaCredito().getInfoTributaria(), numAut, fechaAut), obtenerInfoNC(rep.getNotaCredito().getInfoNotaCredito(), rep)), dataSource);
/* 154:    */       
/* 155:133 */       showReport(reporte_view); return;
/* 156:    */     }
/* 157:    */     catch (FileNotFoundException ex)
/* 158:    */     {
/* 159:135 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 160:    */     }
/* 161:    */     catch (JRException e)
/* 162:    */     {
/* 163:137 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
/* 164:    */     }
/* 165:    */     finally
/* 166:    */     {
/* 167:    */       try
/* 168:    */       {
/* 169:140 */         if (is != null) {
/* 170:141 */           is.close();
/* 171:    */         }
/* 172:    */       }
/* 173:    */       catch (IOException ex)
/* 174:    */       {
/* 175:144 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 176:    */       }
/* 177:    */     }
/* 178:    */   }
/* 179:    */   
/* 180:    */   public void generarReporte(String urlReporte, GuiaRemisionReporte rep, String numAut, String fechaAut, GuiaRemision guiaRemision)
/* 181:    */     throws SQLException, ClassNotFoundException
/* 182:    */   {
/* 183:153 */     FileInputStream is = null;
/* 184:    */     try
/* 185:    */     {
/* 186:155 */       JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getGuiaRemisionList());
/* 187:156 */       is = new FileInputStream(urlReporte);
/* 188:157 */       JasperPrint reporte_view = JasperFillManager.fillReport(is, obtenerMapaParametrosReportes(obtenerParametrosInfoTriobutaria(rep.getGuiaRemision().getInfoTributaria(), numAut, fechaAut), obtenerInfoGR(rep.getGuiaRemision().getInfoGuiaRemision(), guiaRemision)), dataSource);
/* 189:    */       
/* 190:159 */       showReport(reporte_view); return;
/* 191:    */     }
/* 192:    */     catch (FileNotFoundException ex)
/* 193:    */     {
/* 194:161 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 195:    */     }
/* 196:    */     catch (JRException e)
/* 197:    */     {
/* 198:163 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
/* 199:    */     }
/* 200:    */     finally
/* 201:    */     {
/* 202:    */       try
/* 203:    */       {
/* 204:166 */         if (is != null) {
/* 205:167 */           is.close();
/* 206:    */         }
/* 207:    */       }
/* 208:    */       catch (IOException ex)
/* 209:    */       {
/* 210:170 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 211:    */       }
/* 212:    */     }
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void generarReporte(String urlReporte, ComprobanteRetencionReporte rep, String numAut, String fechaAut)
/* 216:    */     throws SQLException, ClassNotFoundException
/* 217:    */   {
/* 218:179 */     FileInputStream is = null;
/* 219:    */     try
/* 220:    */     {
/* 221:181 */       JRDataSource dataSource = new JRBeanCollectionDataSource(rep.getDetallesAdiciones());
/* 222:182 */       is = new FileInputStream(urlReporte);
/* 223:183 */       JasperPrint reporte_view = JasperFillManager.fillReport(is, obtenerMapaParametrosReportes(obtenerParametrosInfoTriobutaria(rep.getComprobanteRetencion().getInfoTributaria(), numAut, fechaAut), obtenerInfoCompRetencion(rep.getComprobanteRetencion().getInfoCompRetencion())), dataSource);
/* 224:    */       
/* 225:185 */       showReport(reporte_view); return;
/* 226:    */     }
/* 227:    */     catch (FileNotFoundException ex)
/* 228:    */     {
/* 229:187 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 230:    */     }
/* 231:    */     catch (JRException e)
/* 232:    */     {
/* 233:189 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, e);
/* 234:    */     }
/* 235:    */     finally
/* 236:    */     {
/* 237:    */       try
/* 238:    */       {
/* 239:192 */         if (is != null) {
/* 240:193 */           is.close();
/* 241:    */         }
/* 242:    */       }
/* 243:    */       catch (IOException ex)
/* 244:    */       {
/* 245:196 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 246:    */       }
/* 247:    */     }
/* 248:    */   }
/* 249:    */   
/* 250:    */   private Map<String, Object> obtenerMapaParametrosReportes(Map<String, Object> mapa1, Map<String, Object> mapa2)
/* 251:    */   {
/* 252:203 */     mapa1.putAll(mapa2);
/* 253:204 */     return mapa1;
/* 254:    */   }
/* 255:    */   
/* 256:    */   private Map<String, Object> obtenerParametrosInfoTriobutaria(InfoTributaria infoTributaria, String numAut, String fechaAut)
/* 257:    */     throws SQLException, ClassNotFoundException
/* 258:    */   {
/* 259:208 */     Map<String, Object> param = new HashMap();
/* 260:209 */     param.put("RUC", infoTributaria.getRuc());
/* 261:210 */     param.put("CLAVE_ACC", infoTributaria.getClaveAcceso());
/* 262:211 */     param.put("RAZON_SOCIAL", infoTributaria.getRazonSocial());
/* 263:212 */     param.put("DIR_MATRIZ", infoTributaria.getDirMatriz());
/* 264:    */     try
/* 265:    */     {
/* 266:214 */       if ((obtenerEmisor().getPathLogo() != null) && (!obtenerEmisor().getPathLogo().isEmpty())) {
/* 267:215 */         param.put("LOGO", new FileInputStream(obtenerEmisor().getPathLogo()));
/* 268:    */       } else {
/* 269:217 */         param.put("LOGO", new FileInputStream("resources/images/logo.jpeg"));
/* 270:    */       }
/* 271:    */     }
/* 272:    */     catch (FileNotFoundException ex)
/* 273:    */     {
/* 274:    */       try
/* 275:    */       {
/* 276:221 */         param.put("LOGO", new FileInputStream("resources/images/logo.jpeg"));
/* 277:222 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
/* 278:    */       }
/* 279:    */       catch (FileNotFoundException ex1)
/* 280:    */       {
/* 281:224 */         Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex1);
/* 282:    */       }
/* 283:    */     }
/* 284:227 */     param.put("SUBREPORT_DIR", "resources/reportes/");
/* 285:228 */     param.put("TIPO_EMISION", obtenerTipoEmision(infoTributaria));
/* 286:229 */     param.put("NUM_AUT", numAut);
/* 287:230 */     param.put("FECHA_AUT", fechaAut);
/* 288:231 */     param.put("MARCA_AGUA", obtenerMarcaAgua(infoTributaria.getAmbiente()));
/* 289:232 */     param.put("NUM_FACT", infoTributaria.getEstab() + "-" + infoTributaria.getPtoEmi() + "-" + infoTributaria.getSecuencial());
/* 290:233 */     param.put("AMBIENTE", obtenerAmbiente(infoTributaria));
/* 291:234 */     param.put("NOM_COMERCIAL", infoTributaria.getNombreComercial());
/* 292:235 */     return param;
/* 293:    */   }
/* 294:    */   
/* 295:    */   private String obtenerAmbiente(InfoTributaria infoTributaria)
/* 296:    */   {
/* 297:239 */     if (infoTributaria.getAmbiente().equals("2")) {
/* 298:240 */       return TipoAmbienteEnum.PRODUCCION.toString();
/* 299:    */     }
/* 300:242 */     return TipoAmbienteEnum.PRUEBAS.toString();
/* 301:    */   }
/* 302:    */   
/* 303:    */   private String obtenerTipoEmision(InfoTributaria infoTributaria)
/* 304:    */   {
/* 305:247 */     if (infoTributaria.getTipoEmision().equals("2")) {
/* 306:248 */       return TipoEmisionEnum.CONTINGENCIA.getCode();
/* 307:    */     }
/* 308:250 */     if (infoTributaria.getTipoEmision().equals("1")) {
/* 309:251 */       return TipoEmisionEnum.NORMAL.getCode();
/* 310:    */     }
/* 311:253 */     return null;
/* 312:    */   }
/* 313:    */   
/* 314:    */   private InputStream obtenerMarcaAgua(String ambiente)
/* 315:    */   {
/* 316:    */     try
/* 317:    */     {
/* 318:258 */       if (ambiente.equals(TipoAmbienteEnum.PRODUCCION.getCode())) {
/* 319:259 */         return new BufferedInputStream(new FileInputStream("resources/images/produccion.jpeg"));
/* 320:    */       }
/* 321:262 */       return new BufferedInputStream(new FileInputStream("resources/images/pruebas.jpeg"));
/* 322:    */     }
/* 323:    */     catch (FileNotFoundException fe)
/* 324:    */     {
/* 325:266 */       Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, fe);
/* 326:    */     }
/* 327:268 */     return null;
/* 328:    */   }
/* 329:    */   
/* 330:    */   private Map<String, Object> obtenerInfoFactura(Factura.InfoFactura infoFactura, FacturaReporte fact)
/* 331:    */   {
/* 332:272 */     Map<String, Object> param = new HashMap();
/* 333:273 */     param.put("DIR_SUCURSAL", infoFactura.getDirEstablecimiento());
/* 334:274 */     param.put("CONT_ESPECIAL", infoFactura.getContribuyenteEspecial());
/* 335:275 */     param.put("LLEVA_CONTABILIDAD", infoFactura.getObligadoContabilidad());
/* 336:276 */     param.put("RS_COMPRADOR", infoFactura.getRazonSocialComprador());
/* 337:277 */     param.put("RUC_COMPRADOR", infoFactura.getIdentificacionComprador());
/* 338:278 */     param.put("FECHA_EMISION", infoFactura.getFechaEmision());
/* 339:279 */     param.put("GUIA", infoFactura.getGuiaRemision());
/* 340:280 */     TotalComprobante tc = getTotales(infoFactura);
/* 341:281 */     param.put("VALOR_TOTAL", infoFactura.getImporteTotal());
/* 342:282 */     param.put("DESCUENTO", infoFactura.getTotalDescuento());
/* 343:283 */     param.put("IVA", tc.getIva12());
/* 344:284 */     param.put("IVA_0", tc.getSubtotal0());
/* 345:285 */     param.put("IVA_12", tc.getSubtotal12());
/* 346:286 */     param.put("EXENTO_IVA", tc.getSubtotalExentoIVA());
/* 347:287 */     param.put("ICE", tc.getTotalIce());
/* 348:288 */     param.put("IRBPNR", tc.getTotalIRBPNR());
/* 349:289 */     param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
/* 350:290 */     param.put("SUBTOTAL", infoFactura.getTotalSinImpuestos());
/* 351:291 */     if (infoFactura.getPropina() != null) {
/* 352:292 */       param.put("PROPINA", infoFactura.getPropina().toString());
/* 353:    */     }
/* 354:294 */     param.put("TOTAL_DESCUENTO", calcularDescuento(fact));
/* 355:295 */     return param;
/* 356:    */   }
/* 357:    */   
/* 358:    */   private String calcularDescuento(FacturaReporte fact)
/* 359:    */   {
/* 360:299 */     BigDecimal descuento = new BigDecimal(0);
/* 361:300 */     for (DetallesAdicionalesReporte detalle : fact.getDetallesAdiciones()) {
/* 362:301 */       descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
/* 363:    */     }
/* 364:303 */     return descuento.toString();
/* 365:    */   }
/* 366:    */   
/* 367:    */   private TotalComprobante getTotales(Factura.InfoFactura infoFactura)
/* 368:    */   {
/* 369:307 */     BigDecimal totalIva12 = new BigDecimal(0.0D);
/* 370:308 */     BigDecimal totalIva0 = new BigDecimal(0.0D);
/* 371:309 */     BigDecimal totalExentoIVA = new BigDecimal(0.0D);
/* 372:310 */     BigDecimal iva12 = new BigDecimal(0.0D);
/* 373:311 */     BigDecimal totalICE = new BigDecimal(0.0D);
/* 374:312 */     BigDecimal totalIRBPNR = new BigDecimal(0.0D);
/* 375:313 */     BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
/* 376:314 */     TotalComprobante tc = new TotalComprobante();
/* 377:315 */     for (Factura.InfoFactura.TotalConImpuestos.TotalImpuesto ti : infoFactura.getTotalConImpuestos().getTotalImpuesto())
/* 378:    */     {
/* 379:316 */       Integer cod = new Integer(ti.getCodigo());
/* 380:317 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje())))
/* 381:    */       {
/* 382:319 */         totalIva12 = totalIva12.add(ti.getBaseImponible());
/* 383:320 */         iva12 = iva12.add(ti.getValor());
/* 384:    */       }
/* 385:322 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 386:324 */         totalIva0 = totalIva0.add(ti.getBaseImponible());
/* 387:    */       }
/* 388:326 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_NO_OBJETO.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 389:328 */         totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
/* 390:    */       }
/* 391:330 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 392:332 */         totalExentoIVA = totalExentoIVA.add(ti.getBaseImponible());
/* 393:    */       }
/* 394:334 */       if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
/* 395:335 */         totalICE = totalICE.add(ti.getValor());
/* 396:    */       }
/* 397:337 */       if (TipoImpuestoEnum.IRBPNR.getCode() == cod.intValue()) {
/* 398:338 */         totalIRBPNR = totalIRBPNR.add(ti.getValor());
/* 399:    */       }
/* 400:    */     }
/* 401:341 */     tc.setIva12(iva12.toString());
/* 402:342 */     tc.setSubtotal0(totalIva0.toString());
/* 403:343 */     tc.setSubtotal12(totalIva12.toString());
/* 404:344 */     tc.setTotalIce(totalICE.toString());
/* 405:345 */     tc.setSubtotal(totalIva0.add(totalIva12));
/* 406:346 */     tc.setSubtotalExentoIVA(totalExentoIVA);
/* 407:347 */     tc.setTotalIRBPNR(totalIRBPNR);
/* 408:348 */     tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
/* 409:349 */     return tc;
/* 410:    */   }
/* 411:    */   
/* 412:    */   private TotalComprobante getTotalesNC(NotaCredito.InfoNotaCredito infoNc)
/* 413:    */   {
/* 414:354 */     BigDecimal totalIva12 = new BigDecimal(0.0D);
/* 415:355 */     BigDecimal totalIva0 = new BigDecimal(0.0D);
/* 416:356 */     BigDecimal iva12 = new BigDecimal(0.0D);
/* 417:357 */     BigDecimal totalExentoIVA = new BigDecimal(0.0D);
/* 418:358 */     BigDecimal totalICE = new BigDecimal(0.0D);
/* 419:359 */     BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
/* 420:360 */     BigDecimal totalIRBPNR = new BigDecimal(0.0D);
/* 421:361 */     TotalComprobante tc = new TotalComprobante();
/* 422:362 */     for (TotalConImpuestos.TotalImpuesto ti : infoNc.getTotalConImpuestos().getTotalImpuesto())
/* 423:    */     {
/* 424:363 */       Integer cod = new Integer(ti.getCodigo());
/* 425:364 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje())))
/* 426:    */       {
/* 427:366 */         totalIva12 = totalIva12.add(ti.getBaseImponible());
/* 428:367 */         iva12 = iva12.add(ti.getValor());
/* 429:    */       }
/* 430:369 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 431:371 */         totalIva0 = totalIva0.add(ti.getBaseImponible());
/* 432:    */       }
/* 433:373 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_NO_OBJETO.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 434:375 */         totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
/* 435:    */       }
/* 436:377 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 437:379 */         totalExentoIVA = totalExentoIVA.add(ti.getBaseImponible());
/* 438:    */       }
/* 439:381 */       if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
/* 440:382 */         totalICE = totalICE.add(ti.getValor());
/* 441:    */       }
/* 442:384 */       if (TipoImpuestoEnum.IRBPNR.getCode() == cod.intValue()) {
/* 443:385 */         totalIRBPNR = totalIRBPNR.add(ti.getValor());
/* 444:    */       }
/* 445:    */     }
/* 446:388 */     tc.setIva12(iva12.toString());
/* 447:389 */     tc.setSubtotal0(totalIva0.toString());
/* 448:390 */     tc.setSubtotal12(totalIva12.toString());
/* 449:391 */     tc.setTotalIce(totalICE.toString());
/* 450:392 */     tc.setSubtotal(totalIva0.add(totalIva12));
/* 451:393 */     tc.setSubtotalExentoIVA(totalExentoIVA);
/* 452:394 */     tc.setTotalIRBPNR(totalIRBPNR);
/* 453:395 */     tc.setSubtotalNoSujetoIva(totalSinImpuesto.toString());
/* 454:396 */     return tc;
/* 455:    */   }
/* 456:    */   
/* 457:    */   private TotalComprobante getTotalesND(NotaDebito.InfoNotaDebito infoNotaDebito)
/* 458:    */   {
/* 459:400 */     BigDecimal totalIva12 = new BigDecimal(0.0D);
/* 460:401 */     BigDecimal totalIva0 = new BigDecimal(0.0D);
/* 461:402 */     BigDecimal totalICE = new BigDecimal(0.0D);
/* 462:403 */     BigDecimal iva12 = new BigDecimal(0.0D);
/* 463:404 */     BigDecimal totalExentoIVA = new BigDecimal(0.0D);
/* 464:405 */     BigDecimal totalSinImpuesto = new BigDecimal(0.0D);
/* 465:406 */     TotalComprobante tc = new TotalComprobante();
/* 466:407 */     for (Impuesto ti : infoNotaDebito.getImpuestos().getImpuesto())
/* 467:    */     {
/* 468:409 */       Integer cod = new Integer(ti.getCodigo());
/* 469:410 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_VENTA_12.getCode().equals(ti.getCodigoPorcentaje())))
/* 470:    */       {
/* 471:412 */         totalIva12 = totalIva12.add(ti.getBaseImponible());
/* 472:413 */         iva12 = iva12.add(ti.getValor());
/* 473:    */       }
/* 474:415 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_VENTA_0.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 475:417 */         totalIva0 = totalIva0.add(ti.getBaseImponible());
/* 476:    */       }
/* 477:419 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_NO_OBJETO.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 478:421 */         totalSinImpuesto = totalSinImpuesto.add(ti.getBaseImponible());
/* 479:    */       }
/* 480:423 */       if ((TipoImpuestoEnum.IVA.getCode() == cod.intValue()) && (TipoImpuestoIvaEnum.IVA_EXCENTO.getCode().equals(ti.getCodigoPorcentaje()))) {
/* 481:425 */         totalExentoIVA = totalExentoIVA.add(ti.getBaseImponible());
/* 482:    */       }
/* 483:427 */       if (TipoImpuestoEnum.ICE.getCode() == cod.intValue()) {
/* 484:428 */         totalICE = totalICE.add(ti.getValor());
/* 485:    */       }
/* 486:    */     }
/* 487:431 */     tc.setSubtotal0(totalIva0.toString());
/* 488:432 */     tc.setSubtotal12(totalIva12.toString());
/* 489:433 */     tc.setTotalIce(totalICE.toString());
/* 490:434 */     tc.setIva12(iva12.toString());
/* 491:435 */     tc.setSubtotalExentoIVA(totalExentoIVA);
/* 492:436 */     tc.setSubtotalNoSujetoIva(totalSinImpuesto.toPlainString());
/* 493:437 */     return tc;
/* 494:    */   }
/* 495:    */   
/* 496:    */   private Map<String, Object> obtenerInfoNC(NotaCredito.InfoNotaCredito infoNC, NotaCreditoReporte nc)
/* 497:    */   {
/* 498:441 */     Map<String, Object> param = new HashMap();
/* 499:442 */     param.put("DIR_SUCURSAL", infoNC.getDirEstablecimiento());
/* 500:443 */     param.put("CONT_ESPECIAL", infoNC.getContribuyenteEspecial());
/* 501:444 */     param.put("LLEVA_CONTABILIDAD", infoNC.getObligadoContabilidad());
/* 502:445 */     param.put("RS_COMPRADOR", infoNC.getRazonSocialComprador());
/* 503:446 */     param.put("RUC_COMPRADOR", infoNC.getIdentificacionComprador());
/* 504:447 */     param.put("FECHA_EMISION", infoNC.getFechaEmision());
/* 505:448 */     TotalComprobante tc = getTotalesNC(infoNC);
/* 506:449 */     param.put("IVA_0", tc.getSubtotal0());
/* 507:450 */     param.put("IVA_12", tc.getSubtotal12());
/* 508:451 */     param.put("EXENTO_IVA", tc.getSubtotalExentoIVA());
/* 509:452 */     param.put("ICE", tc.getTotalIce());
/* 510:453 */     param.put("IRBPNR", tc.getTotalIRBPNR());
/* 511:454 */     param.put("VALOR_TOTAL", infoNC.getValorModificacion());
/* 512:455 */     param.put("IVA", tc.getIva12());
/* 513:456 */     param.put("SUBTOTAL", infoNC.getTotalSinImpuestos());
/* 514:457 */     param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
/* 515:458 */     param.put("NUM_DOC_MODIFICADO", infoNC.getNumDocModificado());
/* 516:459 */     param.put("FECHA_EMISION_DOC_SUSTENTO", infoNC.getFechaEmisionDocSustento());
/* 517:460 */     param.put("DOC_MODIFICADO", StringUtil.obtenerDocumentoModificado(infoNC.getCodDocModificado()));
/* 518:461 */     param.put("TOTAL_DESCUENTO", obtenerTotalDescuento(nc));
/* 519:462 */     param.put("RAZON_MODIF", infoNC.getMotivo());
/* 520:463 */     return param;
/* 521:    */   }
/* 522:    */   
/* 523:    */   private Map<String, Object> obtenerInfoGR(GuiaRemision.InfoGuiaRemision igr, GuiaRemision guiaRemision)
/* 524:    */   {
/* 525:467 */     Map<String, Object> param = new HashMap();
/* 526:468 */     param.put("DIR_SUCURSAL", igr.getDirEstablecimiento());
/* 527:469 */     param.put("CONT_ESPECIAL", igr.getContribuyenteEspecial());
/* 528:470 */     param.put("LLEVA_CONTABILIDAD", igr.getObligadoContabilidad());
/* 529:471 */     param.put("FECHA_INI_TRANSPORTE", igr.getFechaIniTransporte());
/* 530:472 */     param.put("FECHA_FIN_TRANSPORTE", igr.getFechaFinTransporte());
/* 531:473 */     param.put("RUC_TRANSPORTISTA", igr.getRucTransportista());
/* 532:474 */     param.put("RS_TRANSPORTISTA", igr.getRazonSocialTransportista());
/* 533:475 */     param.put("PLACA", igr.getPlaca());
/* 534:476 */     param.put("PUNTO_PARTIDA", igr.getDirPartida());
/* 535:477 */     param.put("INFO_ADICIONAL", getInfoAdicional(guiaRemision));
/* 536:478 */     return param;
/* 537:    */   }
/* 538:    */   
/* 539:    */   public List<InformacionAdicional> getInfoAdicional(GuiaRemision guiaRemision)
/* 540:    */   {
/* 541:482 */     List<InformacionAdicional> infoAdicional = new ArrayList();
/* 542:483 */     if (guiaRemision.getInfoAdicional() != null) {
/* 543:484 */       for (GuiaRemision.InfoAdicional.CampoAdicional ca : guiaRemision.getInfoAdicional().getCampoAdicional()) {
/* 544:485 */         infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
/* 545:    */       }
/* 546:    */     }
/* 547:488 */     if ((infoAdicional != null) && (!infoAdicional.isEmpty())) {
/* 548:489 */       return infoAdicional;
/* 549:    */     }
/* 550:491 */     return null;
/* 551:    */   }
/* 552:    */   
/* 553:    */   private String obtenerTotalDescuento(NotaCreditoReporte nc)
/* 554:    */   {
/* 555:495 */     BigDecimal descuento = new BigDecimal(0);
/* 556:496 */     for (DetallesAdicionalesReporte detalle : nc.getDetallesAdiciones()) {
/* 557:497 */       descuento = descuento.add(new BigDecimal(detalle.getDescuento()));
/* 558:    */     }
/* 559:499 */     return descuento.toString();
/* 560:    */   }
/* 561:    */   
/* 562:    */   private Map<String, Object> obtenerInfoND(NotaDebito.InfoNotaDebito notaDebito)
/* 563:    */   {
/* 564:503 */     Map<String, Object> param = new HashMap();
/* 565:504 */     param.put("DIR_SUCURSAL", notaDebito.getDirEstablecimiento());
/* 566:505 */     param.put("CONT_ESPECIAL", notaDebito.getContribuyenteEspecial());
/* 567:506 */     param.put("LLEVA_CONTABILIDAD", notaDebito.getObligadoContabilidad());
/* 568:507 */     param.put("RS_COMPRADOR", notaDebito.getRazonSocialComprador());
/* 569:508 */     param.put("RUC_COMPRADOR", notaDebito.getIdentificacionComprador());
/* 570:509 */     param.put("FECHA_EMISION", notaDebito.getFechaEmision());
/* 571:510 */     TotalComprobante tc = getTotalesND(notaDebito);
/* 572:511 */     param.put("IVA_0", tc.getSubtotal0());
/* 573:512 */     param.put("IVA_12", tc.getSubtotal12());
/* 574:513 */     param.put("EXENTO_IVA", tc.getSubtotalExentoIVA());
/* 575:514 */     param.put("ICE", tc.getTotalIce());
/* 576:515 */     param.put("TOTAL", notaDebito.getValorTotal());
/* 577:516 */     param.put("IVA", tc.getIva12());
/* 578:517 */     param.put("NO_OBJETO_IVA", tc.getSubtotalNoSujetoIva());
/* 579:518 */     param.put("NUM_DOC_MODIFICADO", notaDebito.getNumDocModificado());
/* 580:519 */     param.put("FECHA_EMISION_DOC_SUSTENTO", notaDebito.getFechaEmisionDocSustento());
/* 581:520 */     param.put("DOC_MODIFICADO", StringUtil.obtenerDocumentoModificado(notaDebito.getCodDocModificado()));
/* 582:521 */     param.put("TOTAL_SIN_IMP", notaDebito.getTotalSinImpuestos());
/* 583:522 */     return param;
/* 584:    */   }
/* 585:    */   
/* 586:    */   private Map<String, Object> obtenerInfoCompRetencion(ComprobanteRetencion.InfoCompRetencion infoComp)
/* 587:    */   {
/* 588:526 */     Map<String, Object> param = new HashMap();
/* 589:527 */     param.put("DIR_SUCURSAL", infoComp.getDirEstablecimiento());
/* 590:528 */     param.put("RS_COMPRADOR", infoComp.getRazonSocialSujetoRetenido());
/* 591:529 */     param.put("RUC_COMPRADOR", infoComp.getIdentificacionSujetoRetenido());
/* 592:530 */     param.put("FECHA_EMISION", infoComp.getFechaEmision());
/* 593:531 */     param.put("CONT_ESPECIAL", infoComp.getContribuyenteEspecial());
/* 594:532 */     param.put("LLEVA_CONTABILIDAD", infoComp.getObligadoContabilidad());
/* 595:533 */     param.put("EJERCICIO_FISCAL", infoComp.getPeriodoFiscal());
/* 596:534 */     return param;
/* 597:    */   }
/* 598:    */   
/* 599:    */   public void showReport(JasperPrint jp)
/* 600:    */   {
/* 601:539 */     JasperViwerSRI jv = new JasperViwerSRI(jp, Locale.getDefault());
/* 602:540 */     List<JRSaveContributor> newSaveContributors = new LinkedList();
/* 603:541 */     JRSaveContributor[] saveContributors = jv.getSaveContributors();
/* 604:542 */     for (int i = 0; i < saveContributors.length; i++) {
/* 605:543 */       if ((saveContributors[i] instanceof JRPdfSaveContributor)) {
/* 606:544 */         newSaveContributors.add(saveContributors[i]);
/* 607:    */       }
/* 608:    */     }
/* 609:547 */     jv.setSaveContributors((JRSaveContributor[])newSaveContributors.toArray(new JRSaveContributor[0]));
/* 610:    */     
/* 611:549 */     JFrame jf = new JFrame();
/* 612:550 */     jf.setTitle("Generador de RIDE");
/* 613:551 */     jf.getContentPane().add(jv);
/* 614:552 */     jf.validate();
/* 615:553 */     jf.setVisible(true);
/* 616:554 */     jf.setSize(new Dimension(800, 650));
/* 617:555 */     jf.setLocation(300, 100);
/* 618:556 */     jf.setDefaultCloseOperation(1);
/* 619:    */   }
/* 620:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.reportes.ReporteUtil
 * JD-Core Version:    0.7.0.1
 */