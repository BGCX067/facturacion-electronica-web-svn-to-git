/*   1:    */ package ec.gob.sri.comprobantes.modelo.reportes;
/*   2:    */ 
/*   3:    */ import java.util.List;
/*   4:    */ 
/*   5:    */ public class DetallesAdicionalesReporte
/*   6:    */ {
/*   7:    */   private String codigoPrincipal;
/*   8:    */   private String codigoAuxiliar;
/*   9:    */   private String cantidad;
/*  10:    */   private String descripcion;
/*  11:    */   private String precioUnitario;
/*  12:    */   private String precioTotalSinImpuesto;
/*  13:    */   private String descuento;
/*  14:    */   private String numeroComprobante;
/*  15:    */   private String nombreComprobante;
/*  16:    */   private String detalle1;
/*  17:    */   private String detalle2;
/*  18:    */   private String detalle3;
/*  19:    */   private String fechaEmisionCcompModificado;
/*  20:    */   private List<InformacionAdicional> infoAdicional;
/*  21:    */   private String razonModificacion;
/*  22:    */   private String valorModificacion;
/*  23:    */   private String baseImponible;
/*  24:    */   private String nombreImpuesto;
/*  25:    */   private String porcentajeRetener;
/*  26:    */   private String valorRetenido;
/*  27:    */   
/*  28:    */   public String getCodigoPrincipal()
/*  29:    */   {
/*  30: 47 */     return this.codigoPrincipal;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setCodigoPrincipal(String codigoPrincipal)
/*  34:    */   {
/*  35: 54 */     this.codigoPrincipal = codigoPrincipal;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getCodigoAuxiliar()
/*  39:    */   {
/*  40: 61 */     return this.codigoAuxiliar;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setCodigoAuxiliar(String codigoAuxiliar)
/*  44:    */   {
/*  45: 68 */     this.codigoAuxiliar = codigoAuxiliar;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getCantidad()
/*  49:    */   {
/*  50: 75 */     return this.cantidad;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setCantidad(String cantidad)
/*  54:    */   {
/*  55: 82 */     this.cantidad = cantidad;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getDescripcion()
/*  59:    */   {
/*  60: 89 */     return this.descripcion;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setDescripcion(String descripcion)
/*  64:    */   {
/*  65: 96 */     this.descripcion = descripcion;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getPrecioUnitario()
/*  69:    */   {
/*  70:103 */     return this.precioUnitario;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setPrecioUnitario(String precioUnitario)
/*  74:    */   {
/*  75:110 */     this.precioUnitario = precioUnitario;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getPrecioTotalSinImpuesto()
/*  79:    */   {
/*  80:117 */     return this.precioTotalSinImpuesto;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setPrecioTotalSinImpuesto(String precioTotalSinImpuesto)
/*  84:    */   {
/*  85:124 */     this.precioTotalSinImpuesto = precioTotalSinImpuesto;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getDetalle1()
/*  89:    */   {
/*  90:131 */     return this.detalle1;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setDetalle1(String detalle1)
/*  94:    */   {
/*  95:138 */     this.detalle1 = detalle1;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getDetalle2()
/*  99:    */   {
/* 100:145 */     return this.detalle2;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setDetalle2(String detalle2)
/* 104:    */   {
/* 105:152 */     this.detalle2 = detalle2;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getDetalle3()
/* 109:    */   {
/* 110:159 */     return this.detalle3;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setDetalle3(String detalle3)
/* 114:    */   {
/* 115:166 */     this.detalle3 = detalle3;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public List<InformacionAdicional> getInfoAdicional()
/* 119:    */   {
/* 120:173 */     return this.infoAdicional;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
/* 124:    */   {
/* 125:180 */     this.infoAdicional = infoAdicional;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public String getRazonModificacion()
/* 129:    */   {
/* 130:187 */     return this.razonModificacion;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setRazonModificacion(String razonModificacion)
/* 134:    */   {
/* 135:194 */     this.razonModificacion = razonModificacion;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public String getValorModificacion()
/* 139:    */   {
/* 140:201 */     return this.valorModificacion;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setValorModificacion(String valorModificacion)
/* 144:    */   {
/* 145:208 */     this.valorModificacion = valorModificacion;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public String getBaseImponible()
/* 149:    */   {
/* 150:215 */     return this.baseImponible;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setBaseImponible(String baseImponible)
/* 154:    */   {
/* 155:222 */     this.baseImponible = baseImponible;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public String getNombreImpuesto()
/* 159:    */   {
/* 160:229 */     return this.nombreImpuesto;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setNombreImpuesto(String nombreImpuesto)
/* 164:    */   {
/* 165:236 */     this.nombreImpuesto = nombreImpuesto;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public String getPorcentajeRetener()
/* 169:    */   {
/* 170:243 */     return this.porcentajeRetener;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public void setPorcentajeRetener(String porcentajeRetener)
/* 174:    */   {
/* 175:250 */     this.porcentajeRetener = porcentajeRetener;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public String getValorRetenido()
/* 179:    */   {
/* 180:257 */     return this.valorRetenido;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public void setValorRetenido(String valorRetenido)
/* 184:    */   {
/* 185:264 */     this.valorRetenido = valorRetenido;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public String getDescuento()
/* 189:    */   {
/* 190:271 */     return this.descuento;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public void setDescuento(String descuento)
/* 194:    */   {
/* 195:278 */     this.descuento = descuento;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public String getNumeroComprobante()
/* 199:    */   {
/* 200:285 */     return this.numeroComprobante;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public void setNumeroComprobante(String numeroComprobante)
/* 204:    */   {
/* 205:292 */     this.numeroComprobante = numeroComprobante;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public String getNombreComprobante()
/* 209:    */   {
/* 210:299 */     return this.nombreComprobante;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public void setNombreComprobante(String nombreComprobante)
/* 214:    */   {
/* 215:306 */     this.nombreComprobante = nombreComprobante;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public String getFechaEmisionCcompModificado()
/* 219:    */   {
/* 220:313 */     return this.fechaEmisionCcompModificado;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public void setFechaEmisionCcompModificado(String fechaEmisionCcompModificado)
/* 224:    */   {
/* 225:320 */     this.fechaEmisionCcompModificado = fechaEmisionCcompModificado;
/* 226:    */   }
/* 227:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.DetallesAdicionalesReporte
 * JD-Core Version:    0.7.0.1
 */