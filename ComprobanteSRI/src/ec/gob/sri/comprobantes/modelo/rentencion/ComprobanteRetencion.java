/*   1:    */ package ec.gob.sri.comprobantes.modelo.rentencion;
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
/*  18:    */ @XmlType(name="", propOrder={"infoTributaria", "infoCompRetencion", "impuestos", "infoAdicional"})
/*  19:    */ @XmlRootElement(name="comprobanteRetencion")
/*  20:    */ public class ComprobanteRetencion
/*  21:    */ {
/*  22:    */   @XmlElement(required=true)
/*  23:    */   protected InfoTributaria infoTributaria;
/*  24:    */   @XmlElement(required=true)
/*  25:    */   protected InfoCompRetencion infoCompRetencion;
/*  26:    */   @XmlElement(required=true)
/*  27:    */   protected Impuestos impuestos;
/*  28:    */   protected InfoAdicional infoAdicional;
/*  29:    */   @XmlAttribute
/*  30:    */   protected String id;
/*  31:    */   @XmlAttribute(required=true)
/*  32:    */   @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
/*  33:    */   @XmlSchemaType(name="NMTOKEN")
/*  34:    */   protected String version;
/*  35:    */   
/*  36:    */   public InfoTributaria getInfoTributaria()
/*  37:    */   {
/*  38:134 */     return this.infoTributaria;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setInfoTributaria(InfoTributaria value)
/*  42:    */   {
/*  43:146 */     this.infoTributaria = value;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public InfoCompRetencion getInfoCompRetencion()
/*  47:    */   {
/*  48:158 */     return this.infoCompRetencion;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setInfoCompRetencion(InfoCompRetencion value)
/*  52:    */   {
/*  53:170 */     this.infoCompRetencion = value;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Impuestos getImpuestos()
/*  57:    */   {
/*  58:182 */     return this.impuestos;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setImpuestos(Impuestos value)
/*  62:    */   {
/*  63:194 */     this.impuestos = value;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public InfoAdicional getInfoAdicional()
/*  67:    */   {
/*  68:206 */     return this.infoAdicional;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setInfoAdicional(InfoAdicional value)
/*  72:    */   {
/*  73:218 */     this.infoAdicional = value;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getId()
/*  77:    */   {
/*  78:230 */     return this.id;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setId(String value)
/*  82:    */   {
/*  83:242 */     this.id = value;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getVersion()
/*  87:    */   {
/*  88:254 */     return this.version;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setVersion(String value)
/*  92:    */   {
/*  93:266 */     this.version = value;
/*  94:    */   }
/*  95:    */   
/*  96:    */   @XmlAccessorType(XmlAccessType.FIELD)
/*  97:    */   @XmlType(name="", propOrder={"impuesto"})
/*  98:    */   public static class Impuestos
/*  99:    */   {
/* 100:    */     @XmlElement(required=true)
/* 101:    */     protected List<Impuesto> impuesto;
/* 102:    */     
/* 103:    */     public List<Impuesto> getImpuesto()
/* 104:    */     {
/* 105:321 */       if (this.impuesto == null) {
/* 106:322 */         this.impuesto = new ArrayList();
/* 107:    */       }
/* 108:324 */       return this.impuesto;
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
/* 121:389 */       if (this.campoAdicional == null) {
/* 122:390 */         this.campoAdicional = new ArrayList();
/* 123:    */       }
/* 124:392 */       return this.campoAdicional;
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
/* 138:433 */         return this.value;
/* 139:    */       }
/* 140:    */       
/* 141:    */       public void setValue(String value)
/* 142:    */       {
/* 143:445 */         this.value = value;
/* 144:    */       }
/* 145:    */       
/* 146:    */       public String getNombre()
/* 147:    */       {
/* 148:457 */         return this.nombre;
/* 149:    */       }
/* 150:    */       
/* 151:    */       public void setNombre(String value)
/* 152:    */       {
/* 153:469 */         this.nombre = value;
/* 154:    */       }
/* 155:    */     }
/* 156:    */   }
/* 157:    */   
/* 158:    */   @XmlAccessorType(XmlAccessType.FIELD)
/* 159:    */   @XmlType(name="", propOrder={"fechaEmision", "dirEstablecimiento", "contribuyenteEspecial", "obligadoContabilidad", "tipoIdentificacionSujetoRetenido", "razonSocialSujetoRetenido", "identificacionSujetoRetenido", "periodoFiscal"})
/* 160:    */   public static class InfoCompRetencion
/* 161:    */   {
/* 162:    */     @XmlElement(required=true)
/* 163:    */     protected String fechaEmision;
/* 164:    */     protected String dirEstablecimiento;
/* 165:    */     protected String contribuyenteEspecial;
/* 166:    */     protected String obligadoContabilidad;
/* 167:    */     @XmlElement(required=true)
/* 168:    */     protected String tipoIdentificacionSujetoRetenido;
/* 169:    */     @XmlElement(required=true)
/* 170:    */     protected String razonSocialSujetoRetenido;
/* 171:    */     @XmlElement(required=true)
/* 172:    */     protected String identificacionSujetoRetenido;
/* 173:    */     @XmlElement(required=true)
/* 174:    */     protected String periodoFiscal;
/* 175:    */     
/* 176:    */     public String getFechaEmision()
/* 177:    */     {
/* 178:539 */       return this.fechaEmision;
/* 179:    */     }
/* 180:    */     
/* 181:    */     public void setFechaEmision(String value)
/* 182:    */     {
/* 183:551 */       this.fechaEmision = value;
/* 184:    */     }
/* 185:    */     
/* 186:    */     public String getDirEstablecimiento()
/* 187:    */     {
/* 188:563 */       return this.dirEstablecimiento;
/* 189:    */     }
/* 190:    */     
/* 191:    */     public void setDirEstablecimiento(String value)
/* 192:    */     {
/* 193:575 */       this.dirEstablecimiento = value;
/* 194:    */     }
/* 195:    */     
/* 196:    */     public String getContribuyenteEspecial()
/* 197:    */     {
/* 198:587 */       return this.contribuyenteEspecial;
/* 199:    */     }
/* 200:    */     
/* 201:    */     public void setContribuyenteEspecial(String value)
/* 202:    */     {
/* 203:599 */       this.contribuyenteEspecial = value;
/* 204:    */     }
/* 205:    */     
/* 206:    */     public String getObligadoContabilidad()
/* 207:    */     {
/* 208:611 */       return this.obligadoContabilidad;
/* 209:    */     }
/* 210:    */     
/* 211:    */     public void setObligadoContabilidad(String value)
/* 212:    */     {
/* 213:623 */       this.obligadoContabilidad = value;
/* 214:    */     }
/* 215:    */     
/* 216:    */     public String getTipoIdentificacionSujetoRetenido()
/* 217:    */     {
/* 218:635 */       return this.tipoIdentificacionSujetoRetenido;
/* 219:    */     }
/* 220:    */     
/* 221:    */     public void setTipoIdentificacionSujetoRetenido(String value)
/* 222:    */     {
/* 223:647 */       this.tipoIdentificacionSujetoRetenido = value;
/* 224:    */     }
/* 225:    */     
/* 226:    */     public String getRazonSocialSujetoRetenido()
/* 227:    */     {
/* 228:659 */       return this.razonSocialSujetoRetenido;
/* 229:    */     }
/* 230:    */     
/* 231:    */     public void setRazonSocialSujetoRetenido(String value)
/* 232:    */     {
/* 233:671 */       this.razonSocialSujetoRetenido = value;
/* 234:    */     }
/* 235:    */     
/* 236:    */     public String getIdentificacionSujetoRetenido()
/* 237:    */     {
/* 238:683 */       return this.identificacionSujetoRetenido;
/* 239:    */     }
/* 240:    */     
/* 241:    */     public void setIdentificacionSujetoRetenido(String value)
/* 242:    */     {
/* 243:695 */       this.identificacionSujetoRetenido = value;
/* 244:    */     }
/* 245:    */     
/* 246:    */     public String getPeriodoFiscal()
/* 247:    */     {
/* 248:707 */       return this.periodoFiscal;
/* 249:    */     }
/* 250:    */     
/* 251:    */     public void setPeriodoFiscal(String value)
/* 252:    */     {
/* 253:719 */       this.periodoFiscal = value;
/* 254:    */     }
/* 255:    */   }
/* 256:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion
 * JD-Core Version:    0.7.0.1
 */