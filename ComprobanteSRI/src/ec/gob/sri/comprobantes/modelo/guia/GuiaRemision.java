/*   1:    */ package ec.gob.sri.comprobantes.modelo.guia;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   7:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   8:    */ import javax.xml.bind.annotation.XmlAttribute;
/*   9:    */ import javax.xml.bind.annotation.XmlElement;
/*  10:    */ import javax.xml.bind.annotation.XmlRootElement;
/*  11:    */ import javax.xml.bind.annotation.XmlSchemaType;
/*  12:    */ import javax.xml.bind.annotation.XmlType;
/*  13:    */ import javax.xml.bind.annotation.XmlValue;
/*  14:    */ import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
/*  15:    */ import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/*  16:    */ 
/*  17:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*  18:    */ @XmlType(name="", propOrder={"infoTributaria", "infoGuiaRemision", "destinatarios", "infoAdicional"})
/*  19:    */ @XmlRootElement(name="guiaRemision")
/*  20:    */ public class GuiaRemision
/*  21:    */ {
/*  22:    */   @XmlElement(required=true)
/*  23:    */   protected InfoTributaria infoTributaria;
/*  24:    */   @XmlElement(required=true)
/*  25:    */   protected InfoGuiaRemision infoGuiaRemision;
/*  26:    */   @XmlElement(required=true)
/*  27:    */   protected Destinatarios destinatarios;
/*  28:    */   protected InfoAdicional infoAdicional;
/*  29:    */   @XmlAttribute(required=true)
/*  30:    */   protected String id;
/*  31:    */   @XmlAttribute(required=true)
/*  32:    */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*  33:    */   @XmlSchemaType(name="NMTOKEN")
/*  34:    */   protected String version;
/*  35:    */   
/*  36:    */   public InfoTributaria getInfoTributaria()
/*  37:    */   {
/*  38:137 */     return this.infoTributaria;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setInfoTributaria(InfoTributaria value)
/*  42:    */   {
/*  43:149 */     this.infoTributaria = value;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public InfoGuiaRemision getInfoGuiaRemision()
/*  47:    */   {
/*  48:161 */     return this.infoGuiaRemision;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setInfoGuiaRemision(InfoGuiaRemision value)
/*  52:    */   {
/*  53:173 */     this.infoGuiaRemision = value;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Destinatarios getDestinatarios()
/*  57:    */   {
/*  58:185 */     return this.destinatarios;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setDestinatarios(Destinatarios value)
/*  62:    */   {
/*  63:197 */     this.destinatarios = value;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public InfoAdicional getInfoAdicional()
/*  67:    */   {
/*  68:209 */     return this.infoAdicional;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setInfoAdicional(InfoAdicional value)
/*  72:    */   {
/*  73:221 */     this.infoAdicional = value;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getId()
/*  77:    */   {
/*  78:233 */     return this.id;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setId(String value)
/*  82:    */   {
/*  83:245 */     this.id = value;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getVersion()
/*  87:    */   {
/*  88:257 */     return this.version;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setVersion(String value)
/*  92:    */   {
/*  93:269 */     this.version = value;
/*  94:    */   }
/*  95:    */   
/*  96:    */   @XmlAccessorType(XmlAccessType.FIELD)
/*  97:    */   @XmlType(name="", propOrder={"destinatario"})
/*  98:    */   public static class Destinatarios
/*  99:    */   {
/* 100:    */     @XmlElement(required=true)
/* 101:    */     protected List<Destinatario> destinatario;
/* 102:    */     
/* 103:    */     public List<Destinatario> getDestinatario()
/* 104:    */     {
/* 105:324 */       if (this.destinatario == null) {
/* 106:325 */         this.destinatario = new ArrayList();
/* 107:    */       }
/* 108:327 */       return this.destinatario;
/* 109:    */     }
/* 110:    */   }
/* 111:    */   
/* 112:    */   @XmlAccessorType(XmlAccessType.FIELD)
/* 113:    */   @XmlType(name="", propOrder={"campoAdicional"})
/* 114:    */   public static class InfoAdicional
/* 115:    */   {
/* 116:    */     @XmlElement(required=true)
/* 117:    */     protected List<CampoAdicional> campoAdicional;
/* 118:    */     
/* 119:    */     public List<CampoAdicional> getCampoAdicional()
/* 120:    */     {
/* 121:392 */       if (this.campoAdicional == null) {
/* 122:393 */         this.campoAdicional = new ArrayList();
/* 123:    */       }
/* 124:395 */       return this.campoAdicional;
/* 125:    */     }
/* 126:    */     
/* 127:    */     @XmlAccessorType(XmlAccessType.FIELD)
/* 128:    */     @XmlType(name="", propOrder={"value"})
/* 129:    */     public static class CampoAdicional
/* 130:    */     {
/* 131:    */       @XmlValue
/* 132:    */       protected String value;
/* 133:    */       @XmlAttribute
/* 134:    */       protected String nombre;
/* 135:    */       
/* 136:    */       public String getValue()
/* 137:    */       {
/* 138:436 */         return this.value;
/* 139:    */       }
/* 140:    */       
/* 141:    */       public void setValue(String value)
/* 142:    */       {
/* 143:448 */         this.value = value;
/* 144:    */       }
/* 145:    */       
/* 146:    */       public String getNombre()
/* 147:    */       {
/* 148:460 */         return this.nombre;
/* 149:    */       }
/* 150:    */       
/* 151:    */       public void setNombre(String value)
/* 152:    */       {
/* 153:472 */         this.nombre = value;
/* 154:    */       }
/* 155:    */     }
/* 156:    */   }
/* 157:    */   
/* 158:    */   @XmlAccessorType(XmlAccessType.FIELD)
/* 159:    */   @XmlType(name="", propOrder={"dirEstablecimiento", "dirPartida", "razonSocialTransportista", "tipoIdentificacionTransportista", "rucTransportista", "rise", "obligadoContabilidad", "contribuyenteEspecial", "fechaIniTransporte", "fechaFinTransporte", "placa"})
/* 160:    */   public static class InfoGuiaRemision
/* 161:    */   {
/* 162:    */     protected String dirEstablecimiento;
/* 163:    */     @XmlElement(required=true)
/* 164:    */     protected String dirPartida;
/* 165:    */     @XmlElement(required=true)
/* 166:    */     protected String razonSocialTransportista;
/* 167:    */     @XmlElement(required=true)
/* 168:    */     protected String tipoIdentificacionTransportista;
/* 169:    */     @XmlElement(required=true)
/* 170:    */     protected String rucTransportista;
/* 171:    */     protected String rise;
/* 172:    */     protected String obligadoContabilidad;
/* 173:    */     protected String contribuyenteEspecial;
/* 174:    */     @XmlElement(required=true)
/* 175:    */     protected String fechaIniTransporte;
/* 176:    */     @XmlElement(required=true)
/* 177:    */     protected String fechaFinTransporte;
/* 178:    */     @XmlElement(required=true)
/* 179:    */     protected String placa;
/* 180:    */     
/* 181:    */     public String getDirEstablecimiento()
/* 182:    */     {
/* 183:553 */       return this.dirEstablecimiento;
/* 184:    */     }
/* 185:    */     
/* 186:    */     public void setDirEstablecimiento(String value)
/* 187:    */     {
/* 188:565 */       this.dirEstablecimiento = value;
/* 189:    */     }
/* 190:    */     
/* 191:    */     public String getDirPartida()
/* 192:    */     {
/* 193:577 */       return this.dirPartida;
/* 194:    */     }
/* 195:    */     
/* 196:    */     public void setDirPartida(String value)
/* 197:    */     {
/* 198:589 */       this.dirPartida = value;
/* 199:    */     }
/* 200:    */     
/* 201:    */     public String getRazonSocialTransportista()
/* 202:    */     {
/* 203:601 */       return this.razonSocialTransportista;
/* 204:    */     }
/* 205:    */     
/* 206:    */     public void setRazonSocialTransportista(String value)
/* 207:    */     {
/* 208:613 */       this.razonSocialTransportista = value;
/* 209:    */     }
/* 210:    */     
/* 211:    */     public String getTipoIdentificacionTransportista()
/* 212:    */     {
/* 213:625 */       return this.tipoIdentificacionTransportista;
/* 214:    */     }
/* 215:    */     
/* 216:    */     public void setTipoIdentificacionTransportista(String value)
/* 217:    */     {
/* 218:637 */       this.tipoIdentificacionTransportista = value;
/* 219:    */     }
/* 220:    */     
/* 221:    */     public String getRucTransportista()
/* 222:    */     {
/* 223:649 */       return this.rucTransportista;
/* 224:    */     }
/* 225:    */     
/* 226:    */     public void setRucTransportista(String value)
/* 227:    */     {
/* 228:661 */       this.rucTransportista = value;
/* 229:    */     }
/* 230:    */     
/* 231:    */     public String getRise()
/* 232:    */     {
/* 233:673 */       return this.rise;
/* 234:    */     }
/* 235:    */     
/* 236:    */     public void setRise(String value)
/* 237:    */     {
/* 238:685 */       this.rise = value;
/* 239:    */     }
/* 240:    */     
/* 241:    */     public String getObligadoContabilidad()
/* 242:    */     {
/* 243:697 */       return this.obligadoContabilidad;
/* 244:    */     }
/* 245:    */     
/* 246:    */     public void setObligadoContabilidad(String value)
/* 247:    */     {
/* 248:709 */       this.obligadoContabilidad = value;
/* 249:    */     }
/* 250:    */     
/* 251:    */     public String getContribuyenteEspecial()
/* 252:    */     {
/* 253:721 */       return this.contribuyenteEspecial;
/* 254:    */     }
/* 255:    */     
/* 256:    */     public void setContribuyenteEspecial(String value)
/* 257:    */     {
/* 258:733 */       this.contribuyenteEspecial = value;
/* 259:    */     }
/* 260:    */     
/* 261:    */     public String getFechaIniTransporte()
/* 262:    */     {
/* 263:745 */       return this.fechaIniTransporte;
/* 264:    */     }
/* 265:    */     
/* 266:    */     public void setFechaIniTransporte(String value)
/* 267:    */     {
/* 268:757 */       this.fechaIniTransporte = value;
/* 269:    */     }
/* 270:    */     
/* 271:    */     public String getFechaFinTransporte()
/* 272:    */     {
/* 273:769 */       return this.fechaFinTransporte;
/* 274:    */     }
/* 275:    */     
/* 276:    */     public void setFechaFinTransporte(String value)
/* 277:    */     {
/* 278:781 */       this.fechaFinTransporte = value;
/* 279:    */     }
/* 280:    */     
/* 281:    */     public String getPlaca()
/* 282:    */     {
/* 283:793 */       return this.placa;
/* 284:    */     }
/* 285:    */     
/* 286:    */     public void setPlaca(String value)
/* 287:    */     {
/* 288:805 */       this.placa = value;
/* 289:    */     }
/* 290:    */   }
/* 291:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.guia.GuiaRemision
 * JD-Core Version:    0.7.0.1
 */