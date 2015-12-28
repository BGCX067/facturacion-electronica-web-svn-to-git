/*   1:    */ package ec.gob.sri.comprobantes.modelo.reportes;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.guia.Destinatario;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.guia.Destinatario.Detalles;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.guia.Detalle;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.Destinatarios;
/*   8:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   9:    */ import java.math.BigDecimal;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ 
/*  13:    */ public class GuiaRemisionReporte
/*  14:    */ {
/*  15:    */   private GuiaRemision guiaRemision;
/*  16:    */   private String nombreComprobante;
/*  17:    */   private String numDocSustento;
/*  18:    */   private String fechaEmisionSustento;
/*  19:    */   private String numeroAutorizacion;
/*  20:    */   private String motivoTraslado;
/*  21:    */   private String destino;
/*  22:    */   private String rucDestinatario;
/*  23:    */   private String razonSocial;
/*  24:    */   private String docAduanero;
/*  25:    */   private String codigoEstab;
/*  26:    */   private String ruta;
/*  27:    */   private List<DetalleGuiaReporte> detalles;
/*  28:    */   private List<GuiaRemisionReporte> guiaRemisionList;
/*  29:    */   
/*  30:    */   public GuiaRemisionReporte(GuiaRemision guiaRemision)
/*  31:    */   {
/*  32: 36 */     this.guiaRemision = guiaRemision;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public GuiaRemisionReporte() {}
/*  36:    */   
/*  37:    */   public GuiaRemision getGuiaRemision()
/*  38:    */   {
/*  39: 47 */     return this.guiaRemision;
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void setGuiaRemision(GuiaRemision guiaRemision)
/*  43:    */   {
/*  44: 54 */     this.guiaRemision = guiaRemision;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public String getNombreComprobante()
/*  48:    */   {
/*  49: 61 */     return this.nombreComprobante;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void setNombreComprobante(String nombreComprobante)
/*  53:    */   {
/*  54: 68 */     this.nombreComprobante = nombreComprobante;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getNumDocSustento()
/*  58:    */   {
/*  59: 75 */     return this.numDocSustento;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setNumDocSustento(String numDocSustento)
/*  63:    */   {
/*  64: 82 */     this.numDocSustento = numDocSustento;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getFechaEmisionSustento()
/*  68:    */   {
/*  69: 89 */     return this.fechaEmisionSustento;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setFechaEmisionSustento(String fechaEmisionSustento)
/*  73:    */   {
/*  74: 96 */     this.fechaEmisionSustento = fechaEmisionSustento;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getNumeroAutorizacion()
/*  78:    */   {
/*  79:103 */     return this.numeroAutorizacion;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setNumeroAutorizacion(String numeroAutorizacion)
/*  83:    */   {
/*  84:110 */     this.numeroAutorizacion = numeroAutorizacion;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getMotivoTraslado()
/*  88:    */   {
/*  89:117 */     return this.motivoTraslado;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setMotivoTraslado(String motivoTraslado)
/*  93:    */   {
/*  94:124 */     this.motivoTraslado = motivoTraslado;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getDestino()
/*  98:    */   {
/*  99:131 */     return this.destino;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setDestino(String destino)
/* 103:    */   {
/* 104:138 */     this.destino = destino;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getRucDestinatario()
/* 108:    */   {
/* 109:145 */     return this.rucDestinatario;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setRucDestinatario(String rucDestinatario)
/* 113:    */   {
/* 114:152 */     this.rucDestinatario = rucDestinatario;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getRazonSocial()
/* 118:    */   {
/* 119:159 */     return this.razonSocial;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setRazonSocial(String razonSocial)
/* 123:    */   {
/* 124:166 */     this.razonSocial = razonSocial;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String getDocAduanero()
/* 128:    */   {
/* 129:173 */     return this.docAduanero;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setDocAduanero(String docAduanero)
/* 133:    */   {
/* 134:180 */     this.docAduanero = docAduanero;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public String getCodigoEstab()
/* 138:    */   {
/* 139:187 */     return this.codigoEstab;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setCodigoEstab(String cosdigoEstab)
/* 143:    */   {
/* 144:194 */     this.codigoEstab = cosdigoEstab;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getRuta()
/* 148:    */   {
/* 149:201 */     return this.ruta;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setRuta(String ruta)
/* 153:    */   {
/* 154:208 */     this.ruta = ruta;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public List<GuiaRemisionReporte> getGuiaRemisionList()
/* 158:    */   {
/* 159:217 */     this.guiaRemisionList = new ArrayList();
/* 160:218 */     for (Destinatario dest : this.guiaRemision.getDestinatarios().getDestinatario())
/* 161:    */     {
/* 162:219 */       GuiaRemisionReporte gr = new GuiaRemisionReporte();
/* 163:220 */       gr.setNombreComprobante(StringUtil.obtenerDocumentoModificado(dest.getCodDocSustento()));
/* 164:221 */       gr.setNumDocSustento(dest.getNumDocSustento());
/* 165:222 */       gr.setFechaEmisionSustento(dest.getFechaEmisionDocSustento());
/* 166:223 */       gr.setNumeroAutorizacion(dest.getNumAutDocSustento());
/* 167:224 */       gr.setMotivoTraslado(dest.getMotivoTraslado());
/* 168:225 */       gr.setDestino(dest.getDirDestinatario());
/* 169:226 */       gr.setRucDestinatario(dest.getIdentificacionDestinatario());
/* 170:227 */       gr.setRazonSocial(dest.getRazonSocialDestinatario());
/* 171:228 */       gr.setDocAduanero(dest.getDocAduaneroUnico());
/* 172:229 */       gr.setCodigoEstab(dest.getCodEstabDestino());
/* 173:230 */       gr.setRuta(dest.getRuta());
/* 174:231 */       gr.setDetalles(obtenerDetalles(dest));
/* 175:    */       
/* 176:233 */       this.guiaRemisionList.add(gr);
/* 177:    */     }
/* 178:236 */     return this.guiaRemisionList;
/* 179:    */   }
/* 180:    */   
/* 181:    */   private List<DetalleGuiaReporte> obtenerDetalles(Destinatario dest)
/* 182:    */   {
/* 183:239 */     List<DetalleGuiaReporte> list = new ArrayList();
/* 184:240 */     for (Detalle detalle : dest.getDetalles().getDetalle())
/* 185:    */     {
/* 186:241 */       DetalleGuiaReporte dgr = new DetalleGuiaReporte();
/* 187:242 */       dgr.setCantidad(detalle.getCantidad().toPlainString());
/* 188:243 */       dgr.setDescripcion(detalle.getDescripcion());
/* 189:244 */       dgr.setCodigoPrincipal(detalle.getCodigoInterno());
/* 190:245 */       dgr.setCodigoAuxiliar(detalle.getCodigoAdicional());
/* 191:246 */       list.add(dgr);
/* 192:    */     }
/* 193:248 */     return list;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public void setGuiaRemisionList(List<GuiaRemisionReporte> guiaRemisionList)
/* 197:    */   {
/* 198:255 */     this.guiaRemisionList = guiaRemisionList;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public List<DetalleGuiaReporte> getDetalles()
/* 202:    */   {
/* 203:262 */     return this.detalles;
/* 204:    */   }
/* 205:    */   
/* 206:    */   public void setDetalles(List<DetalleGuiaReporte> detalles)
/* 207:    */   {
/* 208:269 */     this.detalles = detalles;
/* 209:    */   }
/* 210:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte
 * JD-Core Version:    0.7.0.1
 */