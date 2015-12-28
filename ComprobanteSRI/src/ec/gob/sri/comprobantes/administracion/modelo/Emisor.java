/*   1:    */ package ec.gob.sri.comprobantes.administracion.modelo;
/*   2:    */ 
/*   3:    */ public class Emisor
/*   4:    */ {
/*   5:    */   private Integer codigo;
/*   6:    */   private Integer tiempoEspera;
/*   7:    */   private String ruc;
/*   8:    */   private String razonSocial;
/*   9:    */   private String nombreComercial;
/*  10:    */   private String dirEstablecimiento;
/*  11:    */   private String codigoEstablecimiento;
/*  12:    */   private String numeroResolusion;
/*  13:    */   private String contribuyenteEspecial;
/*  14:    */   private String llevaContabilidad;
/*  15:    */   private String pathLogo;
/*  16:    */   private String tipoEmision;
/*  17:    */   private String codPuntoEmision;
/*  18:    */   private String tipoAmbiente;
/*  19:    */   private String claveInterna;
/*  20:    */   private String direccionMatriz;
/*  21:    */   private String token;
/*  22:    */   
/*  23:    */   public String getTipoAmbiente()
/*  24:    */   {
/*  25: 35 */     return this.tipoAmbiente;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public void setTipoAmbiente(String tipoAmbiente)
/*  29:    */   {
/*  30: 42 */     this.tipoAmbiente = tipoAmbiente;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getClaveInterna()
/*  34:    */   {
/*  35: 49 */     return this.claveInterna;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setClaveInterna(String claveInterna)
/*  39:    */   {
/*  40: 56 */     this.claveInterna = claveInterna;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Integer getCodigo()
/*  44:    */   {
/*  45: 63 */     return this.codigo;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setCodigo(Integer codigo)
/*  49:    */   {
/*  50: 70 */     this.codigo = codigo;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getRuc()
/*  54:    */   {
/*  55: 77 */     return this.ruc;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setRuc(String ruc)
/*  59:    */   {
/*  60: 84 */     this.ruc = ruc;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getRazonSocial()
/*  64:    */   {
/*  65: 91 */     return this.razonSocial;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setRazonSocial(String razonSocial)
/*  69:    */   {
/*  70: 98 */     this.razonSocial = razonSocial;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getNombreComercial()
/*  74:    */   {
/*  75:105 */     return this.nombreComercial;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setNombreComercial(String nombreComercial)
/*  79:    */   {
/*  80:112 */     this.nombreComercial = nombreComercial;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getDirEstablecimiento()
/*  84:    */   {
/*  85:119 */     return this.dirEstablecimiento;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setDirEstablecimiento(String dirEstablecimiento)
/*  89:    */   {
/*  90:126 */     this.dirEstablecimiento = dirEstablecimiento;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getCodigoEstablecimiento()
/*  94:    */   {
/*  95:133 */     return this.codigoEstablecimiento;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setCodigoEstablecimiento(String codigoEstablecimiento)
/*  99:    */   {
/* 100:140 */     this.codigoEstablecimiento = codigoEstablecimiento;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getNumeroResolusion()
/* 104:    */   {
/* 105:147 */     return this.numeroResolusion;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setNumeroResolusion(String numeroResolusion)
/* 109:    */   {
/* 110:154 */     this.numeroResolusion = numeroResolusion;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getContribuyenteEspecial()
/* 114:    */   {
/* 115:161 */     return this.contribuyenteEspecial;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setContribuyenteEspecial(String contribuyenteEspecial)
/* 119:    */   {
/* 120:168 */     this.contribuyenteEspecial = contribuyenteEspecial;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getLlevaContabilidad()
/* 124:    */   {
/* 125:175 */     return this.llevaContabilidad;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setLlevaContabilidad(String llevaContabilidad)
/* 129:    */   {
/* 130:182 */     this.llevaContabilidad = llevaContabilidad;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getPathLogo()
/* 134:    */   {
/* 135:189 */     return this.pathLogo;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setPathLogo(String pathLogo)
/* 139:    */   {
/* 140:196 */     this.pathLogo = pathLogo;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public String getTipoEmision()
/* 144:    */   {
/* 145:203 */     return this.tipoEmision;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setTipoEmision(String tipoEmision)
/* 149:    */   {
/* 150:210 */     this.tipoEmision = tipoEmision;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public Integer getTiempoEspera()
/* 154:    */   {
/* 155:217 */     return this.tiempoEspera;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setTiempoEspera(Integer tiempoEspera)
/* 159:    */   {
/* 160:224 */     this.tiempoEspera = tiempoEspera;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public String getCodPuntoEmision()
/* 164:    */   {
/* 165:231 */     return this.codPuntoEmision;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setCodPuntoEmision(String codPuntoEmision)
/* 169:    */   {
/* 170:238 */     this.codPuntoEmision = codPuntoEmision;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String getDireccionMatriz()
/* 174:    */   {
/* 175:245 */     return this.direccionMatriz;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setDireccionMatriz(String direccionMatriz)
/* 179:    */   {
/* 180:252 */     this.direccionMatriz = direccionMatriz;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public String getToken()
/* 184:    */   {
/* 185:259 */     return this.token;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setToken(String token)
/* 189:    */   {
/* 190:266 */     this.token = token;
/* 191:    */   }
/* 192:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.Emisor
 * JD-Core Version:    0.7.0.1
 */