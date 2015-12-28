/*    1:     */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*    2:     */ 
/*    3:     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*    4:     */ import java.math.BigDecimal;
/*    5:     */ import java.util.ArrayList;
/*    6:     */ import java.util.List;
/*    7:     */ import javax.xml.bind.annotation.XmlAccessType;
/*    8:     */ import javax.xml.bind.annotation.XmlAccessorType;
/*    9:     */ import javax.xml.bind.annotation.XmlAttribute;
/*   10:     */ import javax.xml.bind.annotation.XmlElement;
/*   11:     */ import javax.xml.bind.annotation.XmlRootElement;
/*   12:     */ import javax.xml.bind.annotation.XmlSchemaType;
/*   13:     */ import javax.xml.bind.annotation.XmlType;
/*   14:     */ import javax.xml.bind.annotation.XmlValue;
/*   15:     */ import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
/*   16:     */ import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*   17:     */ 
/*   18:     */ @XmlAccessorType(XmlAccessType.FIELD)
/*   19:     */ @XmlType(name="", propOrder={"infoTributaria", "infoNotaCredito", "detalles", "infoAdicional"})
/*   20:     */ @XmlRootElement(name="notaCredito")
/*   21:     */ public class NotaCredito
/*   22:     */ {
/*   23:     */   @XmlElement(required=true)
/*   24:     */   protected InfoTributaria infoTributaria;
/*   25:     */   @XmlElement(required=true)
/*   26:     */   protected InfoNotaCredito infoNotaCredito;
/*   27:     */   @XmlElement(required=true)
/*   28:     */   protected Detalles detalles;
/*   29:     */   protected InfoAdicional infoAdicional;
/*   30:     */   @XmlAttribute(required=true)
/*   31:     */   protected String id;
/*   32:     */   @XmlAttribute(required=true)
/*   33:     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*   34:     */   @XmlSchemaType(name="NMTOKEN")
/*   35:     */   protected String version;
/*   36:     */   
/*   37:     */   public InfoTributaria getInfoTributaria()
/*   38:     */   {
/*   39: 203 */     return this.infoTributaria;
/*   40:     */   }
/*   41:     */   
/*   42:     */   public void setInfoTributaria(InfoTributaria value)
/*   43:     */   {
/*   44: 215 */     this.infoTributaria = value;
/*   45:     */   }
/*   46:     */   
/*   47:     */   public InfoNotaCredito getInfoNotaCredito()
/*   48:     */   {
/*   49: 227 */     return this.infoNotaCredito;
/*   50:     */   }
/*   51:     */   
/*   52:     */   public void setInfoNotaCredito(InfoNotaCredito value)
/*   53:     */   {
/*   54: 239 */     this.infoNotaCredito = value;
/*   55:     */   }
/*   56:     */   
/*   57:     */   public Detalles getDetalles()
/*   58:     */   {
/*   59: 251 */     return this.detalles;
/*   60:     */   }
/*   61:     */   
/*   62:     */   public void setDetalles(Detalles value)
/*   63:     */   {
/*   64: 263 */     this.detalles = value;
/*   65:     */   }
/*   66:     */   
/*   67:     */   public InfoAdicional getInfoAdicional()
/*   68:     */   {
/*   69: 275 */     return this.infoAdicional;
/*   70:     */   }
/*   71:     */   
/*   72:     */   public void setInfoAdicional(InfoAdicional value)
/*   73:     */   {
/*   74: 287 */     this.infoAdicional = value;
/*   75:     */   }
/*   76:     */   
/*   77:     */   public String getId()
/*   78:     */   {
/*   79: 299 */     return this.id;
/*   80:     */   }
/*   81:     */   
/*   82:     */   public void setId(String value)
/*   83:     */   {
/*   84: 311 */     this.id = value;
/*   85:     */   }
/*   86:     */   
/*   87:     */   public String getVersion()
/*   88:     */   {
/*   89: 323 */     return this.version;
/*   90:     */   }
/*   91:     */   
/*   92:     */   public void setVersion(String value)
/*   93:     */   {
/*   94: 335 */     this.version = value;
/*   95:     */   }
/*   96:     */   
/*   97:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*   98:     */   @XmlType(name="", propOrder={"detalle"})
/*   99:     */   public static class Detalles
/*  100:     */   {
/*  101:     */     @XmlElement(required=true)
/*  102:     */     protected List<Detalle> detalle;
/*  103:     */     
/*  104:     */     public List<Detalle> getDetalle()
/*  105:     */     {
/*  106: 450 */       if (this.detalle == null) {
/*  107: 451 */         this.detalle = new ArrayList();
/*  108:     */       }
/*  109: 453 */       return this.detalle;
/*  110:     */     }
/*  111:     */     
/*  112:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  113:     */     @XmlType(name="", propOrder={"codigoInterno", "codigoAdicional", "descripcion", "cantidad", "precioUnitario", "descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos"})
/*  114:     */     public static class Detalle
/*  115:     */     {
/*  116:     */       @XmlElement(required=true)
/*  117:     */       protected String codigoInterno;
/*  118:     */       protected String codigoAdicional;
/*  119:     */       @XmlElement(required=true)
/*  120:     */       protected String descripcion;
/*  121:     */       @XmlElement(required=true)
/*  122:     */       protected BigDecimal cantidad;
/*  123:     */       @XmlElement(required=true)
/*  124:     */       protected BigDecimal precioUnitario;
/*  125:     */       protected BigDecimal descuento;
/*  126:     */       @XmlElement(required=true)
/*  127:     */       protected BigDecimal precioTotalSinImpuesto;
/*  128:     */       protected DetallesAdicionales detallesAdicionales;
/*  129:     */       @XmlElement(required=true)
/*  130:     */       protected Impuestos impuestos;
/*  131:     */       
/*  132:     */       public String getCodigoInterno()
/*  133:     */       {
/*  134: 565 */         return this.codigoInterno;
/*  135:     */       }
/*  136:     */       
/*  137:     */       public void setCodigoInterno(String value)
/*  138:     */       {
/*  139: 577 */         this.codigoInterno = value;
/*  140:     */       }
/*  141:     */       
/*  142:     */       public String getCodigoAdicional()
/*  143:     */       {
/*  144: 589 */         return this.codigoAdicional;
/*  145:     */       }
/*  146:     */       
/*  147:     */       public void setCodigoAdicional(String value)
/*  148:     */       {
/*  149: 601 */         this.codigoAdicional = value;
/*  150:     */       }
/*  151:     */       
/*  152:     */       public String getDescripcion()
/*  153:     */       {
/*  154: 613 */         return this.descripcion;
/*  155:     */       }
/*  156:     */       
/*  157:     */       public void setDescripcion(String value)
/*  158:     */       {
/*  159: 625 */         this.descripcion = value;
/*  160:     */       }
/*  161:     */       
/*  162:     */       public BigDecimal getCantidad()
/*  163:     */       {
/*  164: 637 */         return this.cantidad;
/*  165:     */       }
/*  166:     */       
/*  167:     */       public void setCantidad(BigDecimal value)
/*  168:     */       {
/*  169: 649 */         this.cantidad = value;
/*  170:     */       }
/*  171:     */       
/*  172:     */       public BigDecimal getPrecioUnitario()
/*  173:     */       {
/*  174: 661 */         return this.precioUnitario;
/*  175:     */       }
/*  176:     */       
/*  177:     */       public void setPrecioUnitario(BigDecimal value)
/*  178:     */       {
/*  179: 673 */         this.precioUnitario = value;
/*  180:     */       }
/*  181:     */       
/*  182:     */       public BigDecimal getDescuento()
/*  183:     */       {
/*  184: 685 */         return this.descuento;
/*  185:     */       }
/*  186:     */       
/*  187:     */       public void setDescuento(BigDecimal value)
/*  188:     */       {
/*  189: 697 */         this.descuento = value;
/*  190:     */       }
/*  191:     */       
/*  192:     */       public BigDecimal getPrecioTotalSinImpuesto()
/*  193:     */       {
/*  194: 709 */         return this.precioTotalSinImpuesto;
/*  195:     */       }
/*  196:     */       
/*  197:     */       public void setPrecioTotalSinImpuesto(BigDecimal value)
/*  198:     */       {
/*  199: 721 */         this.precioTotalSinImpuesto = value;
/*  200:     */       }
/*  201:     */       
/*  202:     */       public DetallesAdicionales getDetallesAdicionales()
/*  203:     */       {
/*  204: 733 */         return this.detallesAdicionales;
/*  205:     */       }
/*  206:     */       
/*  207:     */       public void setDetallesAdicionales(DetallesAdicionales value)
/*  208:     */       {
/*  209: 745 */         this.detallesAdicionales = value;
/*  210:     */       }
/*  211:     */       
/*  212:     */       public Impuestos getImpuestos()
/*  213:     */       {
/*  214: 757 */         return this.impuestos;
/*  215:     */       }
/*  216:     */       
/*  217:     */       public void setImpuestos(Impuestos value)
/*  218:     */       {
/*  219: 769 */         this.impuestos = value;
/*  220:     */       }
/*  221:     */       
/*  222:     */       @XmlAccessorType(XmlAccessType.FIELD)
/*  223:     */       @XmlType(name="", propOrder={"detAdicional"})
/*  224:     */       public static class DetallesAdicionales
/*  225:     */       {
/*  226:     */         @XmlElement(required=true)
/*  227:     */         protected List<DetAdicional> detAdicional;
/*  228:     */         
/*  229:     */         public List<DetAdicional> getDetAdicional()
/*  230:     */         {
/*  231: 846 */           if (this.detAdicional == null) {
/*  232: 847 */             this.detAdicional = new ArrayList();
/*  233:     */           }
/*  234: 849 */           return this.detAdicional;
/*  235:     */         }
/*  236:     */         
/*  237:     */         @XmlAccessorType(XmlAccessType.FIELD)
/*  238:     */         @XmlType(name="")
/*  239:     */         public static class DetAdicional
/*  240:     */         {
/*  241:     */           @XmlAttribute
/*  242:     */           protected String nombre;
/*  243:     */           @XmlAttribute
/*  244:     */           protected String valor;
/*  245:     */           
/*  246:     */           public String getNombre()
/*  247:     */           {
/*  248: 902 */             return this.nombre;
/*  249:     */           }
/*  250:     */           
/*  251:     */           public void setNombre(String value)
/*  252:     */           {
/*  253: 914 */             this.nombre = value;
/*  254:     */           }
/*  255:     */           
/*  256:     */           public String getValor()
/*  257:     */           {
/*  258: 926 */             return this.valor;
/*  259:     */           }
/*  260:     */           
/*  261:     */           public void setValor(String value)
/*  262:     */           {
/*  263: 938 */             this.valor = value;
/*  264:     */           }
/*  265:     */         }
/*  266:     */       }
/*  267:     */       
/*  268:     */       @XmlAccessorType(XmlAccessType.FIELD)
/*  269:     */       @XmlType(name="", propOrder={"impuesto"})
/*  270:     */       public static class Impuestos
/*  271:     */       {
/*  272:     */         protected List<Impuesto> impuesto;
/*  273:     */         
/*  274:     */         public List<Impuesto> getImpuesto()
/*  275:     */         {
/*  276: 996 */           if (this.impuesto == null) {
/*  277: 997 */             this.impuesto = new ArrayList();
/*  278:     */           }
/*  279: 999 */           return this.impuesto;
/*  280:     */         }
/*  281:     */       }
/*  282:     */     }
/*  283:     */   }
/*  284:     */   
/*  285:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*  286:     */   @XmlType(name="", propOrder={"campoAdicional"})
/*  287:     */   public static class InfoAdicional
/*  288:     */   {
/*  289:     */     @XmlElement(required=true)
/*  290:     */     protected List<CampoAdicional> campoAdicional;
/*  291:     */     
/*  292:     */     public List<CampoAdicional> getCampoAdicional()
/*  293:     */     {
/*  294:1068 */       if (this.campoAdicional == null) {
/*  295:1069 */         this.campoAdicional = new ArrayList();
/*  296:     */       }
/*  297:1071 */       return this.campoAdicional;
/*  298:     */     }
/*  299:     */     
/*  300:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  301:     */     @XmlType(name="", propOrder={"value"})
/*  302:     */     public static class CampoAdicional
/*  303:     */     {
/*  304:     */       @XmlValue
/*  305:     */       protected String value;
/*  306:     */       @XmlAttribute
/*  307:     */       protected String nombre;
/*  308:     */       
/*  309:     */       public String getValue()
/*  310:     */       {
/*  311:1112 */         return this.value;
/*  312:     */       }
/*  313:     */       
/*  314:     */       public void setValue(String value)
/*  315:     */       {
/*  316:1124 */         this.value = value;
/*  317:     */       }
/*  318:     */       
/*  319:     */       public String getNombre()
/*  320:     */       {
/*  321:1136 */         return this.nombre;
/*  322:     */       }
/*  323:     */       
/*  324:     */       public void setNombre(String value)
/*  325:     */       {
/*  326:1148 */         this.nombre = value;
/*  327:     */       }
/*  328:     */     }
/*  329:     */   }
/*  330:     */   
/*  331:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*  332:     */   @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "valorModificacion", "moneda", "totalConImpuestos", "motivo"})
/*  333:     */   public static class InfoNotaCredito
/*  334:     */   {
/*  335:     */     @XmlElement(required=true)
/*  336:     */     protected String fechaEmision;
/*  337:     */     protected String dirEstablecimiento;
/*  338:     */     @XmlElement(required=true)
/*  339:     */     protected String tipoIdentificacionComprador;
/*  340:     */     @XmlElement(required=true)
/*  341:     */     protected String razonSocialComprador;
/*  342:     */     protected String identificacionComprador;
/*  343:     */     protected String contribuyenteEspecial;
/*  344:     */     protected String obligadoContabilidad;
/*  345:     */     protected String rise;
/*  346:     */     @XmlElement(required=true)
/*  347:     */     protected String codDocModificado;
/*  348:     */     @XmlElement(required=true)
/*  349:     */     protected String numDocModificado;
/*  350:     */     @XmlElement(required=true)
/*  351:     */     protected String fechaEmisionDocSustento;
/*  352:     */     @XmlElement(required=true)
/*  353:     */     protected BigDecimal totalSinImpuestos;
/*  354:     */     @XmlElement(required=true)
/*  355:     */     protected BigDecimal valorModificacion;
/*  356:     */     protected String moneda;
/*  357:     */     @XmlElement(required=true)
/*  358:     */     protected TotalConImpuestos totalConImpuestos;
/*  359:     */     @XmlElement(required=true)
/*  360:     */     protected String motivo;
/*  361:     */     
/*  362:     */     public String getFechaEmision()
/*  363:     */     {
/*  364:1247 */       return this.fechaEmision;
/*  365:     */     }
/*  366:     */     
/*  367:     */     public void setFechaEmision(String value)
/*  368:     */     {
/*  369:1259 */       this.fechaEmision = value;
/*  370:     */     }
/*  371:     */     
/*  372:     */     public String getDirEstablecimiento()
/*  373:     */     {
/*  374:1271 */       return this.dirEstablecimiento;
/*  375:     */     }
/*  376:     */     
/*  377:     */     public void setDirEstablecimiento(String value)
/*  378:     */     {
/*  379:1283 */       this.dirEstablecimiento = value;
/*  380:     */     }
/*  381:     */     
/*  382:     */     public String getTipoIdentificacionComprador()
/*  383:     */     {
/*  384:1295 */       return this.tipoIdentificacionComprador;
/*  385:     */     }
/*  386:     */     
/*  387:     */     public void setTipoIdentificacionComprador(String value)
/*  388:     */     {
/*  389:1307 */       this.tipoIdentificacionComprador = value;
/*  390:     */     }
/*  391:     */     
/*  392:     */     public String getRazonSocialComprador()
/*  393:     */     {
/*  394:1319 */       return this.razonSocialComprador;
/*  395:     */     }
/*  396:     */     
/*  397:     */     public void setRazonSocialComprador(String value)
/*  398:     */     {
/*  399:1331 */       this.razonSocialComprador = value;
/*  400:     */     }
/*  401:     */     
/*  402:     */     public String getIdentificacionComprador()
/*  403:     */     {
/*  404:1343 */       return this.identificacionComprador;
/*  405:     */     }
/*  406:     */     
/*  407:     */     public void setIdentificacionComprador(String value)
/*  408:     */     {
/*  409:1355 */       this.identificacionComprador = value;
/*  410:     */     }
/*  411:     */     
/*  412:     */     public String getContribuyenteEspecial()
/*  413:     */     {
/*  414:1367 */       return this.contribuyenteEspecial;
/*  415:     */     }
/*  416:     */     
/*  417:     */     public void setContribuyenteEspecial(String value)
/*  418:     */     {
/*  419:1379 */       this.contribuyenteEspecial = value;
/*  420:     */     }
/*  421:     */     
/*  422:     */     public String getObligadoContabilidad()
/*  423:     */     {
/*  424:1391 */       return this.obligadoContabilidad;
/*  425:     */     }
/*  426:     */     
/*  427:     */     public void setObligadoContabilidad(String value)
/*  428:     */     {
/*  429:1403 */       this.obligadoContabilidad = value;
/*  430:     */     }
/*  431:     */     
/*  432:     */     public String getRise()
/*  433:     */     {
/*  434:1415 */       return this.rise;
/*  435:     */     }
/*  436:     */     
/*  437:     */     public void setRise(String value)
/*  438:     */     {
/*  439:1427 */       this.rise = value;
/*  440:     */     }
/*  441:     */     
/*  442:     */     public String getCodDocModificado()
/*  443:     */     {
/*  444:1439 */       return this.codDocModificado;
/*  445:     */     }
/*  446:     */     
/*  447:     */     public void setCodDocModificado(String value)
/*  448:     */     {
/*  449:1451 */       this.codDocModificado = value;
/*  450:     */     }
/*  451:     */     
/*  452:     */     public String getNumDocModificado()
/*  453:     */     {
/*  454:1463 */       return this.numDocModificado;
/*  455:     */     }
/*  456:     */     
/*  457:     */     public void setNumDocModificado(String value)
/*  458:     */     {
/*  459:1475 */       this.numDocModificado = value;
/*  460:     */     }
/*  461:     */     
/*  462:     */     public String getFechaEmisionDocSustento()
/*  463:     */     {
/*  464:1487 */       return this.fechaEmisionDocSustento;
/*  465:     */     }
/*  466:     */     
/*  467:     */     public void setFechaEmisionDocSustento(String value)
/*  468:     */     {
/*  469:1499 */       this.fechaEmisionDocSustento = value;
/*  470:     */     }
/*  471:     */     
/*  472:     */     public BigDecimal getTotalSinImpuestos()
/*  473:     */     {
/*  474:1511 */       return this.totalSinImpuestos;
/*  475:     */     }
/*  476:     */     
/*  477:     */     public void setTotalSinImpuestos(BigDecimal value)
/*  478:     */     {
/*  479:1523 */       this.totalSinImpuestos = value;
/*  480:     */     }
/*  481:     */     
/*  482:     */     public BigDecimal getValorModificacion()
/*  483:     */     {
/*  484:1535 */       return this.valorModificacion;
/*  485:     */     }
/*  486:     */     
/*  487:     */     public void setValorModificacion(BigDecimal value)
/*  488:     */     {
/*  489:1547 */       this.valorModificacion = value;
/*  490:     */     }
/*  491:     */     
/*  492:     */     public String getMoneda()
/*  493:     */     {
/*  494:1559 */       return this.moneda;
/*  495:     */     }
/*  496:     */     
/*  497:     */     public void setMoneda(String value)
/*  498:     */     {
/*  499:1571 */       this.moneda = value;
/*  500:     */     }
/*  501:     */     
/*  502:     */     public TotalConImpuestos getTotalConImpuestos()
/*  503:     */     {
/*  504:1583 */       return this.totalConImpuestos;
/*  505:     */     }
/*  506:     */     
/*  507:     */     public void setTotalConImpuestos(TotalConImpuestos value)
/*  508:     */     {
/*  509:1595 */       this.totalConImpuestos = value;
/*  510:     */     }
/*  511:     */     
/*  512:     */     public String getMotivo()
/*  513:     */     {
/*  514:1607 */       return this.motivo;
/*  515:     */     }
/*  516:     */     
/*  517:     */     public void setMotivo(String value)
/*  518:     */     {
/*  519:1619 */       this.motivo = value;
/*  520:     */     }
/*  521:     */   }
/*  522:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito
 * JD-Core Version:    0.7.0.1
 */