/*   1:    */ package ec.gob.sri.comprobantes.administracion.modelo;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.util.List;
/*   6:    */ 
/*   7:    */ public class Producto
/*   8:    */ {
/*   9:    */   private Integer codigo;
/*  10:    */   private String codigoPrincipal;
/*  11:    */   private String codigoAuxiliar;
/*  12:    */   private String nombre;
/*  13:    */   private BigDecimal valorUnitario;
/*  14:    */   private String tipoProducto;
/*  15:    */   private List<InformacionAdicionalProducto> infoAdicionalList;
/*  16:    */   private List<ImpuestoProducto> impuestoProducto;
/*  17:    */   private List<ImpuestoValor> impuestoValor;
/*  18:    */   private Integer codigoImpuesto;
/*  19:    */   private String iva;
/*  20:    */   private String ice;
/*  21:    */   private String irbpnr;
/*  22:    */   private BigDecimal baseImponileIRBPNR;
/*  23:    */   private Double cantidad;
/*  24:    */   
/*  25:    */   public Integer getCodigo()
/*  26:    */   {
/*  27: 32 */     return this.codigo;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setCodigo(Integer codigo)
/*  31:    */   {
/*  32: 39 */     this.codigo = codigo;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String getCodigoPrincipal()
/*  36:    */   {
/*  37: 46 */     return this.codigoPrincipal;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setCodigoPrincipal(String codigoPrincipal)
/*  41:    */   {
/*  42: 53 */     this.codigoPrincipal = codigoPrincipal;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getCodigoAuxiliar()
/*  46:    */   {
/*  47: 60 */     return this.codigoAuxiliar;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setCodigoAuxiliar(String codigoAuxiliar)
/*  51:    */   {
/*  52: 67 */     this.codigoAuxiliar = codigoAuxiliar;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public String getNombre()
/*  56:    */   {
/*  57: 74 */     return this.nombre;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setNombre(String nombre)
/*  61:    */   {
/*  62: 81 */     this.nombre = nombre;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public BigDecimal getValorUnitario()
/*  66:    */   {
/*  67: 88 */     return this.valorUnitario;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setValorUnitario(BigDecimal valorUnitario)
/*  71:    */   {
/*  72: 95 */     this.valorUnitario = valorUnitario;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public String getTipoProducto()
/*  76:    */   {
/*  77:102 */     return this.tipoProducto;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setTipoProducto(String tipoProducto)
/*  81:    */   {
/*  82:109 */     this.tipoProducto = tipoProducto;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public List<InformacionAdicionalProducto> getInfoAdicionalList()
/*  86:    */   {
/*  87:116 */     return this.infoAdicionalList;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setInfoAdicionalList(List<InformacionAdicionalProducto> infoAdicionalList)
/*  91:    */   {
/*  92:123 */     this.infoAdicionalList = infoAdicionalList;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public List<ImpuestoProducto> getImpuestoProducto()
/*  96:    */   {
/*  97:130 */     return this.impuestoProducto;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setImpuestoProducto(List<ImpuestoProducto> impuestoProducto)
/* 101:    */   {
/* 102:137 */     this.impuestoProducto = impuestoProducto;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public String getIva()
/* 106:    */   {
/* 107:144 */     return this.iva;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setIva(String iva)
/* 111:    */   {
/* 112:151 */     this.iva = iva;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public String getIce()
/* 116:    */   {
/* 117:158 */     return this.ice;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setIce(String ice)
/* 121:    */   {
/* 122:165 */     this.ice = ice;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public List<ImpuestoValor> getImpuestoValor()
/* 126:    */   {
/* 127:172 */     return this.impuestoValor;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setImpuestoValor(List<ImpuestoValor> impuestoValor)
/* 131:    */   {
/* 132:179 */     this.impuestoValor = impuestoValor;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public Double getCantidad()
/* 136:    */   {
/* 137:183 */     return this.cantidad;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public void setCantidad(Double cantidad)
/* 141:    */   {
/* 142:187 */     this.cantidad = cantidad;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public Integer getCodigoImpuesto()
/* 146:    */   {
/* 147:191 */     return this.codigoImpuesto;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public void setCodigoImpuesto(Integer codigoImpuesto)
/* 151:    */   {
/* 152:195 */     this.codigoImpuesto = codigoImpuesto;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public String getIrbpnr()
/* 156:    */   {
/* 157:199 */     return this.irbpnr;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public void setIrbpnr(String irbpnr)
/* 161:    */   {
/* 162:203 */     this.irbpnr = irbpnr;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public BigDecimal getBaseImponileIRBPNR()
/* 166:    */   {
/* 167:207 */     return this.baseImponileIRBPNR;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public void setBaseImponileIRBPNR(BigDecimal baseImponileIRBPNR)
/* 171:    */   {
/* 172:211 */     this.baseImponileIRBPNR = baseImponileIRBPNR;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public boolean verificarProducto(String codigoPrincipal, String codigoAuxiliar, String nombre)
/* 176:    */   {
/* 177:215 */     return (this.codigoPrincipal.equals(codigoPrincipal)) && (this.codigoAuxiliar.equals(codigoAuxiliar)) && (this.nombre.equals(nombre));
/* 178:    */   }
/* 179:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.Producto
 * JD-Core Version:    0.7.0.1
 */