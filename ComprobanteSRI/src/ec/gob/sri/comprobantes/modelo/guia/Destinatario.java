/*   1:    */ package ec.gob.sri.comprobantes.modelo.guia;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.List;
/*   5:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   6:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   7:    */ import javax.xml.bind.annotation.XmlElement;
/*   8:    */ import javax.xml.bind.annotation.XmlType;
/*   9:    */ 
/*  10:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*  11:    */ @XmlType(name="destinatario", propOrder={"identificacionDestinatario", "razonSocialDestinatario", "dirDestinatario", "motivoTraslado", "docAduaneroUnico", "codEstabDestino", "ruta", "codDocSustento", "numDocSustento", "numAutDocSustento", "fechaEmisionDocSustento", "detalles"})
/*  12:    */ public class Destinatario
/*  13:    */ {
/*  14:    */   protected String identificacionDestinatario;
/*  15:    */   @XmlElement(required=true)
/*  16:    */   protected String razonSocialDestinatario;
/*  17:    */   @XmlElement(required=true)
/*  18:    */   protected String dirDestinatario;
/*  19:    */   @XmlElement(required=true)
/*  20:    */   protected String motivoTraslado;
/*  21:    */   protected String docAduaneroUnico;
/*  22:    */   protected String codEstabDestino;
/*  23:    */   protected String ruta;
/*  24:    */   protected String codDocSustento;
/*  25:    */   protected String numDocSustento;
/*  26:    */   protected String numAutDocSustento;
/*  27:    */   protected String fechaEmisionDocSustento;
/*  28:    */   @XmlElement(required=true)
/*  29:    */   protected Detalles detalles;
/*  30:    */   
/*  31:    */   public String getIdentificacionDestinatario()
/*  32:    */   {
/*  33:104 */     return this.identificacionDestinatario;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setIdentificacionDestinatario(String value)
/*  37:    */   {
/*  38:116 */     this.identificacionDestinatario = value;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public String getRazonSocialDestinatario()
/*  42:    */   {
/*  43:128 */     return this.razonSocialDestinatario;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setRazonSocialDestinatario(String value)
/*  47:    */   {
/*  48:140 */     this.razonSocialDestinatario = value;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getDirDestinatario()
/*  52:    */   {
/*  53:152 */     return this.dirDestinatario;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setDirDestinatario(String value)
/*  57:    */   {
/*  58:164 */     this.dirDestinatario = value;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public String getMotivoTraslado()
/*  62:    */   {
/*  63:176 */     return this.motivoTraslado;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setMotivoTraslado(String value)
/*  67:    */   {
/*  68:188 */     this.motivoTraslado = value;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getDocAduaneroUnico()
/*  72:    */   {
/*  73:200 */     return this.docAduaneroUnico;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setDocAduaneroUnico(String value)
/*  77:    */   {
/*  78:212 */     this.docAduaneroUnico = value;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public String getCodEstabDestino()
/*  82:    */   {
/*  83:224 */     return this.codEstabDestino;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setCodEstabDestino(String value)
/*  87:    */   {
/*  88:236 */     this.codEstabDestino = value;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getRuta()
/*  92:    */   {
/*  93:248 */     return this.ruta;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setRuta(String value)
/*  97:    */   {
/*  98:260 */     this.ruta = value;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getCodDocSustento()
/* 102:    */   {
/* 103:272 */     return this.codDocSustento;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setCodDocSustento(String value)
/* 107:    */   {
/* 108:284 */     this.codDocSustento = value;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String getNumDocSustento()
/* 112:    */   {
/* 113:296 */     return this.numDocSustento;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setNumDocSustento(String value)
/* 117:    */   {
/* 118:308 */     this.numDocSustento = value;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public String getNumAutDocSustento()
/* 122:    */   {
/* 123:320 */     return this.numAutDocSustento;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setNumAutDocSustento(String value)
/* 127:    */   {
/* 128:332 */     this.numAutDocSustento = value;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public String getFechaEmisionDocSustento()
/* 132:    */   {
/* 133:344 */     return this.fechaEmisionDocSustento;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public void setFechaEmisionDocSustento(String value)
/* 137:    */   {
/* 138:356 */     this.fechaEmisionDocSustento = value;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public Detalles getDetalles()
/* 142:    */   {
/* 143:368 */     return this.detalles;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public void setDetalles(Detalles value)
/* 147:    */   {
/* 148:380 */     this.detalles = value;
/* 149:    */   }
/* 150:    */   
/* 151:    */   @XmlAccessorType(XmlAccessType.FIELD)
/* 152:    */   @XmlType(name="", propOrder={"detalle"})
/* 153:    */   public static class Detalles
/* 154:    */   {
/* 155:    */     @XmlElement(required=true)
/* 156:    */     protected List<Detalle> detalle;
/* 157:    */     
/* 158:    */     public List<Detalle> getDetalle()
/* 159:    */     {
/* 160:435 */       if (this.detalle == null) {
/* 161:436 */         this.detalle = new ArrayList();
/* 162:    */       }
/* 163:438 */       return this.detalle;
/* 164:    */     }
/* 165:    */   }
/* 166:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.guia.Destinatario
 * JD-Core Version:    0.7.0.1
 */