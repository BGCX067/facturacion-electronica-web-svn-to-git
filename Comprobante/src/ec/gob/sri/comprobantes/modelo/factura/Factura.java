/*    1:     */ package ec.gob.sri.comprobantes.modelo.factura;
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
/*   15:     */ 
/*   16:     */ @XmlAccessorType(XmlAccessType.FIELD)
/*   17:     */ @XmlType(name="", propOrder={"infoTributaria", "infoFactura", "detalles", "infoAdicional"})
/*   18:     */ @XmlRootElement(name="factura")
/*   19:     */ public class Factura
/*   20:     */ {
/*   21:     */   @XmlElement(required=true)
/*   22:     */   protected InfoTributaria infoTributaria;
/*   23:     */   @XmlElement(required=true)
/*   24:     */   protected InfoFactura infoFactura;
/*   25:     */   @XmlElement(required=true)
/*   26:     */   protected Detalles detalles;
/*   27:     */   protected InfoAdicional infoAdicional;
/*   28:     */   @XmlAttribute
/*   29:     */   protected String id;
/*   30:     */   @XmlAttribute
/*   31:     */   @XmlSchemaType(name="anySimpleType")
/*   32:     */   protected String version;
/*   33:     */   
/*   34:     */   public InfoTributaria getInfoTributaria()
/*   35:     */   {
/*   36: 221 */     return this.infoTributaria;
/*   37:     */   }
/*   38:     */   
/*   39:     */   public void setInfoTributaria(InfoTributaria value)
/*   40:     */   {
/*   41: 233 */     this.infoTributaria = value;
/*   42:     */   }
/*   43:     */   
/*   44:     */   public InfoFactura getInfoFactura()
/*   45:     */   {
/*   46: 245 */     return this.infoFactura;
/*   47:     */   }
/*   48:     */   
/*   49:     */   public void setInfoFactura(InfoFactura value)
/*   50:     */   {
/*   51: 257 */     this.infoFactura = value;
/*   52:     */   }
/*   53:     */   
/*   54:     */   public Detalles getDetalles()
/*   55:     */   {
/*   56: 269 */     return this.detalles;
/*   57:     */   }
/*   58:     */   
/*   59:     */   public void setDetalles(Detalles value)
/*   60:     */   {
/*   61: 281 */     this.detalles = value;
/*   62:     */   }
/*   63:     */   
/*   64:     */   public InfoAdicional getInfoAdicional()
/*   65:     */   {
/*   66: 293 */     return this.infoAdicional;
/*   67:     */   }
/*   68:     */   
/*   69:     */   public void setInfoAdicional(InfoAdicional value)
/*   70:     */   {
/*   71: 305 */     this.infoAdicional = value;
/*   72:     */   }
/*   73:     */   
/*   74:     */   public String getId()
/*   75:     */   {
/*   76: 317 */     return this.id;
/*   77:     */   }
/*   78:     */   
/*   79:     */   public void setId(String value)
/*   80:     */   {
/*   81: 329 */     this.id = value;
/*   82:     */   }
/*   83:     */   
/*   84:     */   public String getVersion()
/*   85:     */   {
/*   86: 341 */     return this.version;
/*   87:     */   }
/*   88:     */   
/*   89:     */   public void setVersion(String value)
/*   90:     */   {
/*   91: 353 */     this.version = value;
/*   92:     */   }
/*   93:     */   
/*   94:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*   95:     */   @XmlType(name="", propOrder={"detalle"})
/*   96:     */   public static class Detalles
/*   97:     */   {
/*   98:     */     @XmlElement(required=true)
/*   99:     */     protected List<Detalle> detalle;
/*  100:     */     
/*  101:     */     public List<Detalle> getDetalle()
/*  102:     */     {
/*  103: 467 */       if (this.detalle == null) {
/*  104: 468 */         this.detalle = new ArrayList();
/*  105:     */       }
/*  106: 470 */       return this.detalle;
/*  107:     */     }
/*  108:     */     
/*  109:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  110:     */     @XmlType(name="", propOrder={"codigoPrincipal", "codigoAuxiliar", "descripcion", "cantidad", "precioUnitario", "descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos"})
/*  111:     */     public static class Detalle
/*  112:     */     {
/*  113:     */       @XmlElement(required=true)
/*  114:     */       protected String codigoPrincipal;
/*  115:     */       protected String codigoAuxiliar;
/*  116:     */       @XmlElement(required=true)
/*  117:     */       protected String descripcion;
/*  118:     */       @XmlElement(required=true)
/*  119:     */       protected BigDecimal cantidad;
/*  120:     */       @XmlElement(required=true)
/*  121:     */       protected BigDecimal precioUnitario;
/*  122:     */       @XmlElement(required=true)
/*  123:     */       protected BigDecimal descuento;
/*  124:     */       @XmlElement(required=true)
/*  125:     */       protected BigDecimal precioTotalSinImpuesto;
/*  126:     */       protected DetallesAdicionales detallesAdicionales;
/*  127:     */       @XmlElement(required=true)
/*  128:     */       protected Impuestos impuestos;
/*  129:     */       
/*  130:     */       public String getCodigoPrincipal()
/*  131:     */       {
/*  132: 582 */         return this.codigoPrincipal;
/*  133:     */       }
/*  134:     */       
/*  135:     */       public void setCodigoPrincipal(String value)
/*  136:     */       {
/*  137: 594 */         this.codigoPrincipal = value;
/*  138:     */       }
/*  139:     */       
/*  140:     */       public String getCodigoAuxiliar()
/*  141:     */       {
/*  142: 606 */         return this.codigoAuxiliar;
/*  143:     */       }
/*  144:     */       
/*  145:     */       public void setCodigoAuxiliar(String value)
/*  146:     */       {
/*  147: 618 */         this.codigoAuxiliar = value;
/*  148:     */       }
/*  149:     */       
/*  150:     */       public String getDescripcion()
/*  151:     */       {
/*  152: 630 */         return this.descripcion;
/*  153:     */       }
/*  154:     */       
/*  155:     */       public void setDescripcion(String value)
/*  156:     */       {
/*  157: 642 */         this.descripcion = value;
/*  158:     */       }
/*  159:     */       
/*  160:     */       public BigDecimal getCantidad()
/*  161:     */       {
/*  162: 654 */         return this.cantidad;
/*  163:     */       }
/*  164:     */       
/*  165:     */       public void setCantidad(BigDecimal value)
/*  166:     */       {
/*  167: 666 */         this.cantidad = value;
/*  168:     */       }
/*  169:     */       
/*  170:     */       public BigDecimal getPrecioUnitario()
/*  171:     */       {
/*  172: 678 */         return this.precioUnitario;
/*  173:     */       }
/*  174:     */       
/*  175:     */       public void setPrecioUnitario(BigDecimal value)
/*  176:     */       {
/*  177: 690 */         this.precioUnitario = value;
/*  178:     */       }
/*  179:     */       
/*  180:     */       public BigDecimal getDescuento()
/*  181:     */       {
/*  182: 702 */         return this.descuento;
/*  183:     */       }
/*  184:     */       
/*  185:     */       public void setDescuento(BigDecimal value)
/*  186:     */       {
/*  187: 714 */         this.descuento = value;
/*  188:     */       }
/*  189:     */       
/*  190:     */       public BigDecimal getPrecioTotalSinImpuesto()
/*  191:     */       {
/*  192: 726 */         return this.precioTotalSinImpuesto;
/*  193:     */       }
/*  194:     */       
/*  195:     */       public void setPrecioTotalSinImpuesto(BigDecimal value)
/*  196:     */       {
/*  197: 738 */         this.precioTotalSinImpuesto = value;
/*  198:     */       }
/*  199:     */       
/*  200:     */       public DetallesAdicionales getDetallesAdicionales()
/*  201:     */       {
/*  202: 750 */         return this.detallesAdicionales;
/*  203:     */       }
/*  204:     */       
/*  205:     */       public void setDetallesAdicionales(DetallesAdicionales value)
/*  206:     */       {
/*  207: 762 */         this.detallesAdicionales = value;
/*  208:     */       }
/*  209:     */       
/*  210:     */       public Impuestos getImpuestos()
/*  211:     */       {
/*  212: 774 */         return this.impuestos;
/*  213:     */       }
/*  214:     */       
/*  215:     */       public void setImpuestos(Impuestos value)
/*  216:     */       {
/*  217: 786 */         this.impuestos = value;
/*  218:     */       }
/*  219:     */       
/*  220:     */       @XmlAccessorType(XmlAccessType.FIELD)
/*  221:     */       @XmlType(name="", propOrder={"detAdicional"})
/*  222:     */       public static class DetallesAdicionales
/*  223:     */       {
/*  224:     */         @XmlElement(required=true)
/*  225:     */         protected List<DetAdicional> detAdicional;
/*  226:     */         
/*  227:     */         public List<DetAdicional> getDetAdicional()
/*  228:     */         {
/*  229: 862 */           if (this.detAdicional == null) {
/*  230: 863 */             this.detAdicional = new ArrayList();
/*  231:     */           }
/*  232: 865 */           return this.detAdicional;
/*  233:     */         }
/*  234:     */         
/*  235:     */         @XmlAccessorType(XmlAccessType.FIELD)
/*  236:     */         @XmlType(name="")
/*  237:     */         public static class DetAdicional
/*  238:     */         {
/*  239:     */           @XmlAttribute
/*  240:     */           protected String nombre;
/*  241:     */           @XmlAttribute
/*  242:     */           protected String valor;
/*  243:     */           
/*  244:     */           public String getNombre()
/*  245:     */           {
/*  246: 917 */             return this.nombre;
/*  247:     */           }
/*  248:     */           
/*  249:     */           public void setNombre(String value)
/*  250:     */           {
/*  251: 929 */             this.nombre = value;
/*  252:     */           }
/*  253:     */           
/*  254:     */           public String getValor()
/*  255:     */           {
/*  256: 941 */             return this.valor;
/*  257:     */           }
/*  258:     */           
/*  259:     */           public void setValor(String value)
/*  260:     */           {
/*  261: 953 */             this.valor = value;
/*  262:     */           }
/*  263:     */         }
/*  264:     */       }
/*  265:     */       
/*  266:     */       @XmlAccessorType(XmlAccessType.FIELD)
/*  267:     */       @XmlType(name="", propOrder={"impuesto"})
/*  268:     */       public static class Impuestos
/*  269:     */       {
/*  270:     */         @XmlElement(required=true)
/*  271:     */         protected List<Impuesto> impuesto;
/*  272:     */         
/*  273:     */         public List<Impuesto> getImpuesto()
/*  274:     */         {
/*  275:1012 */           if (this.impuesto == null) {
/*  276:1013 */             this.impuesto = new ArrayList();
/*  277:     */           }
/*  278:1015 */           return this.impuesto;
/*  279:     */         }
/*  280:     */       }
/*  281:     */     }
/*  282:     */   }
/*  283:     */   
/*  284:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*  285:     */   @XmlType(name="", propOrder={"campoAdicional"})
/*  286:     */   public static class InfoAdicional
/*  287:     */   {
/*  288:     */     @XmlElement(required=true)
/*  289:     */     protected List<CampoAdicional> campoAdicional;
/*  290:     */     
/*  291:     */     public List<CampoAdicional> getCampoAdicional()
/*  292:     */     {
/*  293:1084 */       if (this.campoAdicional == null) {
/*  294:1085 */         this.campoAdicional = new ArrayList();
/*  295:     */       }
/*  296:1087 */       return this.campoAdicional;
/*  297:     */     }
/*  298:     */     
/*  299:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  300:     */     @XmlType(name="", propOrder={"value"})
/*  301:     */     public static class CampoAdicional
/*  302:     */     {
/*  303:     */       @XmlValue
/*  304:     */       protected String value;
/*  305:     */       @XmlAttribute
/*  306:     */       protected String nombre;
/*  307:     */       
/*  308:     */       public String getValue()
/*  309:     */       {
/*  310:1128 */         return this.value;
/*  311:     */       }
/*  312:     */       
/*  313:     */       public void setValue(String value)
/*  314:     */       {
/*  315:1140 */         this.value = value;
/*  316:     */       }
/*  317:     */       
/*  318:     */       public String getNombre()
/*  319:     */       {
/*  320:1152 */         return this.nombre;
/*  321:     */       }
/*  322:     */       
/*  323:     */       public void setNombre(String value)
/*  324:     */       {
/*  325:1164 */         this.nombre = value;
/*  326:     */       }
/*  327:     */     }
/*  328:     */   }
/*  329:     */   
/*  330:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*  331:     */   @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "contribuyenteEspecial", "obligadoContabilidad", "tipoIdentificacionComprador", "guiaRemision", "razonSocialComprador", "identificacionComprador", "totalSinImpuestos", "totalDescuento", "totalConImpuestos", "propina", "importeTotal", "moneda"})
/*  332:     */   public static class InfoFactura
/*  333:     */   {
/*  334:     */     @XmlElement(required=true)
/*  335:     */     protected String fechaEmision;
/*  336:     */     @XmlElement(required=true)
/*  337:     */     protected String dirEstablecimiento;
/*  338:     */     protected String contribuyenteEspecial;
/*  339:     */     protected String obligadoContabilidad;
/*  340:     */     @XmlElement(required=true)
/*  341:     */     protected String tipoIdentificacionComprador;
/*  342:     */     protected String guiaRemision;
/*  343:     */     @XmlElement(required=true)
/*  344:     */     protected String razonSocialComprador;
/*  345:     */     @XmlElement(required=true)
/*  346:     */     protected String identificacionComprador;
/*  347:     */     @XmlElement(required=true)
/*  348:     */     protected BigDecimal totalSinImpuestos;
/*  349:     */     @XmlElement(required=true)
/*  350:     */     protected BigDecimal totalDescuento;
/*  351:     */     @XmlElement(required=true)
/*  352:     */     protected TotalConImpuestos totalConImpuestos;
/*  353:     */     @XmlElement(required=true)
/*  354:     */     protected BigDecimal propina;
/*  355:     */     @XmlElement(required=true)
/*  356:     */     protected BigDecimal importeTotal;
/*  357:     */     protected String moneda;
/*  358:     */     
/*  359:     */     public String getFechaEmision()
/*  360:     */     {
/*  361:1281 */       return this.fechaEmision;
/*  362:     */     }
/*  363:     */     
/*  364:     */     public void setFechaEmision(String value)
/*  365:     */     {
/*  366:1293 */       this.fechaEmision = value;
/*  367:     */     }
/*  368:     */     
/*  369:     */     public String getDirEstablecimiento()
/*  370:     */     {
/*  371:1305 */       return this.dirEstablecimiento;
/*  372:     */     }
/*  373:     */     
/*  374:     */     public void setDirEstablecimiento(String value)
/*  375:     */     {
/*  376:1317 */       this.dirEstablecimiento = value;
/*  377:     */     }
/*  378:     */     
/*  379:     */     public String getContribuyenteEspecial()
/*  380:     */     {
/*  381:1329 */       return this.contribuyenteEspecial;
/*  382:     */     }
/*  383:     */     
/*  384:     */     public void setContribuyenteEspecial(String value)
/*  385:     */     {
/*  386:1341 */       this.contribuyenteEspecial = value;
/*  387:     */     }
/*  388:     */     
/*  389:     */     public String getObligadoContabilidad()
/*  390:     */     {
/*  391:1353 */       return this.obligadoContabilidad;
/*  392:     */     }
/*  393:     */     
/*  394:     */     public void setObligadoContabilidad(String value)
/*  395:     */     {
/*  396:1365 */       this.obligadoContabilidad = value;
/*  397:     */     }
/*  398:     */     
/*  399:     */     public String getTipoIdentificacionComprador()
/*  400:     */     {
/*  401:1377 */       return this.tipoIdentificacionComprador;
/*  402:     */     }
/*  403:     */     
/*  404:     */     public void setTipoIdentificacionComprador(String value)
/*  405:     */     {
/*  406:1389 */       this.tipoIdentificacionComprador = value;
/*  407:     */     }
/*  408:     */     
/*  409:     */     public String getGuiaRemision()
/*  410:     */     {
/*  411:1401 */       return this.guiaRemision;
/*  412:     */     }
/*  413:     */     
/*  414:     */     public void setGuiaRemision(String value)
/*  415:     */     {
/*  416:1413 */       this.guiaRemision = value;
/*  417:     */     }
/*  418:     */     
/*  419:     */     public String getRazonSocialComprador()
/*  420:     */     {
/*  421:1425 */       return this.razonSocialComprador;
/*  422:     */     }
/*  423:     */     
/*  424:     */     public void setRazonSocialComprador(String value)
/*  425:     */     {
/*  426:1437 */       this.razonSocialComprador = value;
/*  427:     */     }
/*  428:     */     
/*  429:     */     public String getIdentificacionComprador()
/*  430:     */     {
/*  431:1449 */       return this.identificacionComprador;
/*  432:     */     }
/*  433:     */     
/*  434:     */     public void setIdentificacionComprador(String value)
/*  435:     */     {
/*  436:1461 */       this.identificacionComprador = value;
/*  437:     */     }
/*  438:     */     
/*  439:     */     public BigDecimal getTotalSinImpuestos()
/*  440:     */     {
/*  441:1473 */       return this.totalSinImpuestos;
/*  442:     */     }
/*  443:     */     
/*  444:     */     public void setTotalSinImpuestos(BigDecimal value)
/*  445:     */     {
/*  446:1485 */       this.totalSinImpuestos = value;
/*  447:     */     }
/*  448:     */     
/*  449:     */     public BigDecimal getTotalDescuento()
/*  450:     */     {
/*  451:1497 */       return this.totalDescuento;
/*  452:     */     }
/*  453:     */     
/*  454:     */     public void setTotalDescuento(BigDecimal value)
/*  455:     */     {
/*  456:1509 */       this.totalDescuento = value;
/*  457:     */     }
/*  458:     */     
/*  459:     */     public TotalConImpuestos getTotalConImpuestos()
/*  460:     */     {
/*  461:1521 */       return this.totalConImpuestos;
/*  462:     */     }
/*  463:     */     
/*  464:     */     public void setTotalConImpuestos(TotalConImpuestos value)
/*  465:     */     {
/*  466:1533 */       this.totalConImpuestos = value;
/*  467:     */     }
/*  468:     */     
/*  469:     */     public BigDecimal getPropina()
/*  470:     */     {
/*  471:1545 */       return this.propina;
/*  472:     */     }
/*  473:     */     
/*  474:     */     public void setPropina(BigDecimal value)
/*  475:     */     {
/*  476:1557 */       this.propina = value;
/*  477:     */     }
/*  478:     */     
/*  479:     */     public BigDecimal getImporteTotal()
/*  480:     */     {
/*  481:1569 */       return this.importeTotal;
/*  482:     */     }
/*  483:     */     
/*  484:     */     public void setImporteTotal(BigDecimal value)
/*  485:     */     {
/*  486:1581 */       this.importeTotal = value;
/*  487:     */     }
/*  488:     */     
/*  489:     */     public String getMoneda()
/*  490:     */     {
/*  491:1593 */       return this.moneda;
/*  492:     */     }
/*  493:     */     
/*  494:     */     public void setMoneda(String value)
/*  495:     */     {
/*  496:1605 */       this.moneda = value;
/*  497:     */     }
/*  498:     */     
/*  499:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  500:     */     @XmlType(name="", propOrder={"totalImpuesto"})
/*  501:     */     public static class TotalConImpuestos
/*  502:     */     {
/*  503:     */       @XmlElement(required=true)
/*  504:     */       protected List<TotalImpuesto> totalImpuesto;
/*  505:     */       
/*  506:     */       public List<TotalImpuesto> getTotalImpuesto()
/*  507:     */       {
/*  508:1674 */         if (this.totalImpuesto == null) {
/*  509:1675 */           this.totalImpuesto = new ArrayList();
/*  510:     */         }
/*  511:1677 */         return this.totalImpuesto;
/*  512:     */       }
/*  513:     */       
/*  514:     */       @XmlAccessorType(XmlAccessType.FIELD)
/*  515:     */       @XmlType(name="", propOrder={"codigo", "codigoPorcentaje", "baseImponible", "tarifa", "valor"})
/*  516:     */       public static class TotalImpuesto
/*  517:     */       {
/*  518:     */         @XmlElement(required=true)
/*  519:     */         protected String codigo;
/*  520:     */         @XmlElement(required=true)
/*  521:     */         protected String codigoPorcentaje;
/*  522:     */         @XmlElement(required=true)
/*  523:     */         protected BigDecimal baseImponible;
/*  524:     */         protected BigDecimal tarifa;
/*  525:     */         @XmlElement(required=true)
/*  526:     */         protected BigDecimal valor;
/*  527:     */         
/*  528:     */         public String getCodigo()
/*  529:     */         {
/*  530:1733 */           return this.codigo;
/*  531:     */         }
/*  532:     */         
/*  533:     */         public void setCodigo(String value)
/*  534:     */         {
/*  535:1745 */           this.codigo = value;
/*  536:     */         }
/*  537:     */         
/*  538:     */         public String getCodigoPorcentaje()
/*  539:     */         {
/*  540:1757 */           return this.codigoPorcentaje;
/*  541:     */         }
/*  542:     */         
/*  543:     */         public void setCodigoPorcentaje(String value)
/*  544:     */         {
/*  545:1769 */           this.codigoPorcentaje = value;
/*  546:     */         }
/*  547:     */         
/*  548:     */         public BigDecimal getBaseImponible()
/*  549:     */         {
/*  550:1781 */           return this.baseImponible;
/*  551:     */         }
/*  552:     */         
/*  553:     */         public void setBaseImponible(BigDecimal value)
/*  554:     */         {
/*  555:1793 */           this.baseImponible = value;
/*  556:     */         }
/*  557:     */         
/*  558:     */         public BigDecimal getTarifa()
/*  559:     */         {
/*  560:1805 */           return this.tarifa;
/*  561:     */         }
/*  562:     */         
/*  563:     */         public void setTarifa(BigDecimal value)
/*  564:     */         {
/*  565:1817 */           this.tarifa = value;
/*  566:     */         }
/*  567:     */         
/*  568:     */         public BigDecimal getValor()
/*  569:     */         {
/*  570:1829 */           return this.valor;
/*  571:     */         }
/*  572:     */         
/*  573:     */         public void setValor(BigDecimal value)
/*  574:     */         {
/*  575:1841 */           this.valor = value;
/*  576:     */         }
/*  577:     */       }
/*  578:     */     }
/*  579:     */   }
/*  580:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.factura.Factura
 * JD-Core Version:    0.7.0.1
 */