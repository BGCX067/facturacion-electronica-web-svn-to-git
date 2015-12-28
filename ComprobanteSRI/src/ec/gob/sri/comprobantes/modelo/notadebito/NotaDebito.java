/*    1:     */ package ec.gob.sri.comprobantes.modelo.notadebito;
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
/*   19:     */ @XmlType(name="", propOrder={"infoTributaria", "infoNotaDebito", "motivos", "infoAdicional"})
/*   20:     */ @XmlRootElement(name="notaDebito")
/*   21:     */ public class NotaDebito
/*   22:     */ {
/*   23:     */   @XmlElement(required=true)
/*   24:     */   protected InfoTributaria infoTributaria;
/*   25:     */   @XmlElement(required=true)
/*   26:     */   protected InfoNotaDebito infoNotaDebito;
/*   27:     */   @XmlElement(required=true)
/*   28:     */   protected Motivos motivos;
/*   29:     */   protected InfoAdicional infoAdicional;
/*   30:     */   @XmlAttribute
/*   31:     */   protected String id;
/*   32:     */   @XmlAttribute(required=true)
/*   33:     */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*   34:     */   @XmlSchemaType(name="NMTOKEN")
/*   35:     */   protected String version;
/*   36:     */   
/*   37:     */   public InfoTributaria getInfoTributaria()
/*   38:     */   {
/*   39: 162 */     return this.infoTributaria;
/*   40:     */   }
/*   41:     */   
/*   42:     */   public void setInfoTributaria(InfoTributaria value)
/*   43:     */   {
/*   44: 174 */     this.infoTributaria = value;
/*   45:     */   }
/*   46:     */   
/*   47:     */   public InfoNotaDebito getInfoNotaDebito()
/*   48:     */   {
/*   49: 186 */     return this.infoNotaDebito;
/*   50:     */   }
/*   51:     */   
/*   52:     */   public void setInfoNotaDebito(InfoNotaDebito value)
/*   53:     */   {
/*   54: 198 */     this.infoNotaDebito = value;
/*   55:     */   }
/*   56:     */   
/*   57:     */   public Motivos getMotivos()
/*   58:     */   {
/*   59: 210 */     return this.motivos;
/*   60:     */   }
/*   61:     */   
/*   62:     */   public void setMotivos(Motivos value)
/*   63:     */   {
/*   64: 222 */     this.motivos = value;
/*   65:     */   }
/*   66:     */   
/*   67:     */   public InfoAdicional getInfoAdicional()
/*   68:     */   {
/*   69: 234 */     return this.infoAdicional;
/*   70:     */   }
/*   71:     */   
/*   72:     */   public void setInfoAdicional(InfoAdicional value)
/*   73:     */   {
/*   74: 246 */     this.infoAdicional = value;
/*   75:     */   }
/*   76:     */   
/*   77:     */   public String getId()
/*   78:     */   {
/*   79: 258 */     return this.id;
/*   80:     */   }
/*   81:     */   
/*   82:     */   public void setId(String value)
/*   83:     */   {
/*   84: 270 */     this.id = value;
/*   85:     */   }
/*   86:     */   
/*   87:     */   public String getVersion()
/*   88:     */   {
/*   89: 282 */     return this.version;
/*   90:     */   }
/*   91:     */   
/*   92:     */   public void setVersion(String value)
/*   93:     */   {
/*   94: 294 */     this.version = value;
/*   95:     */   }
/*   96:     */   
/*   97:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*   98:     */   @XmlType(name="", propOrder={"campoAdicional"})
/*   99:     */   public static class InfoAdicional
/*  100:     */   {
/*  101:     */     @XmlElement(required=true)
/*  102:     */     protected List<CampoAdicional> campoAdicional;
/*  103:     */     
/*  104:     */     public List<CampoAdicional> getCampoAdicional()
/*  105:     */     {
/*  106: 357 */       if (this.campoAdicional == null) {
/*  107: 358 */         this.campoAdicional = new ArrayList();
/*  108:     */       }
/*  109: 360 */       return this.campoAdicional;
/*  110:     */     }
/*  111:     */     
/*  112:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  113:     */     @XmlType(name="", propOrder={"value"})
/*  114:     */     public static class CampoAdicional
/*  115:     */     {
/*  116:     */       @XmlValue
/*  117:     */       protected String value;
/*  118:     */       @XmlAttribute
/*  119:     */       protected String nombre;
/*  120:     */       
/*  121:     */       public String getValue()
/*  122:     */       {
/*  123: 401 */         return this.value;
/*  124:     */       }
/*  125:     */       
/*  126:     */       public void setValue(String value)
/*  127:     */       {
/*  128: 413 */         this.value = value;
/*  129:     */       }
/*  130:     */       
/*  131:     */       public String getNombre()
/*  132:     */       {
/*  133: 425 */         return this.nombre;
/*  134:     */       }
/*  135:     */       
/*  136:     */       public void setNombre(String value)
/*  137:     */       {
/*  138: 437 */         this.nombre = value;
/*  139:     */       }
/*  140:     */     }
/*  141:     */   }
/*  142:     */   
/*  143:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*  144:     */   @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "impuestos", "valorTotal"})
/*  145:     */   public static class InfoNotaDebito
/*  146:     */   {
/*  147:     */     @XmlElement(required=true)
/*  148:     */     protected String fechaEmision;
/*  149:     */     protected String dirEstablecimiento;
/*  150:     */     @XmlElement(required=true)
/*  151:     */     protected String tipoIdentificacionComprador;
/*  152:     */     protected String razonSocialComprador;
/*  153:     */     @XmlElement(required=true)
/*  154:     */     protected String identificacionComprador;
/*  155:     */     protected String contribuyenteEspecial;
/*  156:     */     protected String obligadoContabilidad;
/*  157:     */     protected String rise;
/*  158:     */     @XmlElement(required=true)
/*  159:     */     protected String codDocModificado;
/*  160:     */     @XmlElement(required=true)
/*  161:     */     protected String numDocModificado;
/*  162:     */     @XmlElement(required=true)
/*  163:     */     protected String fechaEmisionDocSustento;
/*  164:     */     @XmlElement(required=true)
/*  165:     */     protected BigDecimal totalSinImpuestos;
/*  166:     */     @XmlElement(required=true)
/*  167:     */     protected Impuestos impuestos;
/*  168:     */     @XmlElement(required=true)
/*  169:     */     protected BigDecimal valorTotal;
/*  170:     */     
/*  171:     */     public String getFechaEmision()
/*  172:     */     {
/*  173: 539 */       return this.fechaEmision;
/*  174:     */     }
/*  175:     */     
/*  176:     */     public void setFechaEmision(String value)
/*  177:     */     {
/*  178: 551 */       this.fechaEmision = value;
/*  179:     */     }
/*  180:     */     
/*  181:     */     public String getDirEstablecimiento()
/*  182:     */     {
/*  183: 563 */       return this.dirEstablecimiento;
/*  184:     */     }
/*  185:     */     
/*  186:     */     public void setDirEstablecimiento(String value)
/*  187:     */     {
/*  188: 575 */       this.dirEstablecimiento = value;
/*  189:     */     }
/*  190:     */     
/*  191:     */     public String getTipoIdentificacionComprador()
/*  192:     */     {
/*  193: 587 */       return this.tipoIdentificacionComprador;
/*  194:     */     }
/*  195:     */     
/*  196:     */     public void setTipoIdentificacionComprador(String value)
/*  197:     */     {
/*  198: 599 */       this.tipoIdentificacionComprador = value;
/*  199:     */     }
/*  200:     */     
/*  201:     */     public String getRazonSocialComprador()
/*  202:     */     {
/*  203: 611 */       return this.razonSocialComprador;
/*  204:     */     }
/*  205:     */     
/*  206:     */     public void setRazonSocialComprador(String value)
/*  207:     */     {
/*  208: 623 */       this.razonSocialComprador = value;
/*  209:     */     }
/*  210:     */     
/*  211:     */     public String getIdentificacionComprador()
/*  212:     */     {
/*  213: 635 */       return this.identificacionComprador;
/*  214:     */     }
/*  215:     */     
/*  216:     */     public void setIdentificacionComprador(String value)
/*  217:     */     {
/*  218: 647 */       this.identificacionComprador = value;
/*  219:     */     }
/*  220:     */     
/*  221:     */     public String getContribuyenteEspecial()
/*  222:     */     {
/*  223: 659 */       return this.contribuyenteEspecial;
/*  224:     */     }
/*  225:     */     
/*  226:     */     public void setContribuyenteEspecial(String value)
/*  227:     */     {
/*  228: 671 */       this.contribuyenteEspecial = value;
/*  229:     */     }
/*  230:     */     
/*  231:     */     public String getObligadoContabilidad()
/*  232:     */     {
/*  233: 683 */       return this.obligadoContabilidad;
/*  234:     */     }
/*  235:     */     
/*  236:     */     public void setObligadoContabilidad(String value)
/*  237:     */     {
/*  238: 695 */       this.obligadoContabilidad = value;
/*  239:     */     }
/*  240:     */     
/*  241:     */     public String getRise()
/*  242:     */     {
/*  243: 707 */       return this.rise;
/*  244:     */     }
/*  245:     */     
/*  246:     */     public void setRise(String value)
/*  247:     */     {
/*  248: 719 */       this.rise = value;
/*  249:     */     }
/*  250:     */     
/*  251:     */     public String getCodDocModificado()
/*  252:     */     {
/*  253: 731 */       return this.codDocModificado;
/*  254:     */     }
/*  255:     */     
/*  256:     */     public void setCodDocModificado(String value)
/*  257:     */     {
/*  258: 743 */       this.codDocModificado = value;
/*  259:     */     }
/*  260:     */     
/*  261:     */     public String getNumDocModificado()
/*  262:     */     {
/*  263: 755 */       return this.numDocModificado;
/*  264:     */     }
/*  265:     */     
/*  266:     */     public void setNumDocModificado(String value)
/*  267:     */     {
/*  268: 767 */       this.numDocModificado = value;
/*  269:     */     }
/*  270:     */     
/*  271:     */     public String getFechaEmisionDocSustento()
/*  272:     */     {
/*  273: 779 */       return this.fechaEmisionDocSustento;
/*  274:     */     }
/*  275:     */     
/*  276:     */     public void setFechaEmisionDocSustento(String value)
/*  277:     */     {
/*  278: 791 */       this.fechaEmisionDocSustento = value;
/*  279:     */     }
/*  280:     */     
/*  281:     */     public BigDecimal getTotalSinImpuestos()
/*  282:     */     {
/*  283: 803 */       return this.totalSinImpuestos;
/*  284:     */     }
/*  285:     */     
/*  286:     */     public void setTotalSinImpuestos(BigDecimal value)
/*  287:     */     {
/*  288: 815 */       this.totalSinImpuestos = value;
/*  289:     */     }
/*  290:     */     
/*  291:     */     public Impuestos getImpuestos()
/*  292:     */     {
/*  293: 827 */       return this.impuestos;
/*  294:     */     }
/*  295:     */     
/*  296:     */     public void setImpuestos(Impuestos value)
/*  297:     */     {
/*  298: 839 */       this.impuestos = value;
/*  299:     */     }
/*  300:     */     
/*  301:     */     public BigDecimal getValorTotal()
/*  302:     */     {
/*  303: 851 */       return this.valorTotal;
/*  304:     */     }
/*  305:     */     
/*  306:     */     public void setValorTotal(BigDecimal value)
/*  307:     */     {
/*  308: 863 */       this.valorTotal = value;
/*  309:     */     }
/*  310:     */     
/*  311:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  312:     */     @XmlType(name="", propOrder={"impuesto"})
/*  313:     */     public static class Impuestos
/*  314:     */     {
/*  315:     */       @XmlElement(required=true)
/*  316:     */       protected List<Impuesto> impuesto;
/*  317:     */       
/*  318:     */       public List<Impuesto> getImpuesto()
/*  319:     */       {
/*  320: 918 */         if (this.impuesto == null) {
/*  321: 919 */           this.impuesto = new ArrayList();
/*  322:     */         }
/*  323: 921 */         return this.impuesto;
/*  324:     */       }
/*  325:     */     }
/*  326:     */   }
/*  327:     */   
/*  328:     */   @XmlAccessorType(XmlAccessType.FIELD)
/*  329:     */   @XmlType(name="", propOrder={"motivo"})
/*  330:     */   public static class Motivos
/*  331:     */   {
/*  332:     */     @XmlElement(required=true)
/*  333:     */     protected List<Motivo> motivo;
/*  334:     */     
/*  335:     */     public List<Motivo> getMotivo()
/*  336:     */     {
/*  337: 991 */       if (this.motivo == null) {
/*  338: 992 */         this.motivo = new ArrayList();
/*  339:     */       }
/*  340: 994 */       return this.motivo;
/*  341:     */     }
/*  342:     */     
/*  343:     */     @XmlAccessorType(XmlAccessType.FIELD)
/*  344:     */     @XmlType(name="", propOrder={"razon", "valor"})
/*  345:     */     public static class Motivo
/*  346:     */     {
/*  347:     */       @XmlElement(required=true)
/*  348:     */       protected String razon;
/*  349:     */       @XmlElement(required=true)
/*  350:     */       protected BigDecimal valor;
/*  351:     */       
/*  352:     */       public String getRazon()
/*  353:     */       {
/*  354:1039 */         return this.razon;
/*  355:     */       }
/*  356:     */       
/*  357:     */       public void setRazon(String value)
/*  358:     */       {
/*  359:1051 */         this.razon = value;
/*  360:     */       }
/*  361:     */       
/*  362:     */       public BigDecimal getValor()
/*  363:     */       {
/*  364:1063 */         return this.valor;
/*  365:     */       }
/*  366:     */       
/*  367:     */       public void setValor(BigDecimal value)
/*  368:     */       {
/*  369:1075 */         this.valor = value;
/*  370:     */       }
/*  371:     */     }
/*  372:     */   }
/*  373:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito
 * JD-Core Version:    0.7.0.1
 */