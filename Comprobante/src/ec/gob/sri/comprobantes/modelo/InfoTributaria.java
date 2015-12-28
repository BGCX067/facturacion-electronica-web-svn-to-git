/*   1:    */ package ec.gob.sri.comprobantes.modelo;
/*   2:    */ 
/*   3:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   4:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   5:    */ import javax.xml.bind.annotation.XmlElement;
/*   6:    */ import javax.xml.bind.annotation.XmlType;
/*   7:    */ 
/*   8:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*   9:    */ @XmlType(name="infoTributaria", propOrder={"ambiente", "tipoEmision", "razonSocial", "nombreComercial", "ruc", "claveAcceso", "codDoc", "estab", "ptoEmi", "secuencial", "dirMatriz"})
/*  10:    */ public class InfoTributaria
/*  11:    */ {
/*  12:    */   @XmlElement(required=true)
/*  13:    */   protected String ambiente;
/*  14:    */   @XmlElement(required=true)
/*  15:    */   protected String tipoEmision;
/*  16:    */   @XmlElement(required=true)
/*  17:    */   protected String razonSocial;
/*  18:    */   protected String nombreComercial;
/*  19:    */   @XmlElement(required=true)
/*  20:    */   protected String ruc;
/*  21:    */   @XmlElement(required=true)
/*  22:    */   protected String claveAcceso;
/*  23:    */   @XmlElement(required=true)
/*  24:    */   protected String codDoc;
/*  25:    */   @XmlElement(required=true)
/*  26:    */   protected String estab;
/*  27:    */   @XmlElement(required=true)
/*  28:    */   protected String ptoEmi;
/*  29:    */   @XmlElement(required=true)
/*  30:    */   protected String secuencial;
/*  31:    */   @XmlElement(required=true)
/*  32:    */   protected String dirMatriz;
/*  33:    */   
/*  34:    */   public String getAmbiente()
/*  35:    */   {
/*  36: 95 */     return this.ambiente;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setAmbiente(String value)
/*  40:    */   {
/*  41:107 */     this.ambiente = value;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public String getTipoEmision()
/*  45:    */   {
/*  46:119 */     return this.tipoEmision;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setTipoEmision(String value)
/*  50:    */   {
/*  51:131 */     this.tipoEmision = value;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public String getRazonSocial()
/*  55:    */   {
/*  56:143 */     return this.razonSocial;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setRazonSocial(String value)
/*  60:    */   {
/*  61:155 */     this.razonSocial = value;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getNombreComercial()
/*  65:    */   {
/*  66:167 */     return this.nombreComercial;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setNombreComercial(String value)
/*  70:    */   {
/*  71:179 */     this.nombreComercial = value;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getRuc()
/*  75:    */   {
/*  76:191 */     return this.ruc;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setRuc(String value)
/*  80:    */   {
/*  81:203 */     this.ruc = value;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getClaveAcceso()
/*  85:    */   {
/*  86:215 */     return this.claveAcceso;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setClaveAcceso(String value)
/*  90:    */   {
/*  91:227 */     this.claveAcceso = value;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getCodDoc()
/*  95:    */   {
/*  96:239 */     return this.codDoc;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setCodDoc(String value)
/* 100:    */   {
/* 101:251 */     this.codDoc = value;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getEstab()
/* 105:    */   {
/* 106:263 */     return this.estab;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setEstab(String value)
/* 110:    */   {
/* 111:275 */     this.estab = value;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getPtoEmi()
/* 115:    */   {
/* 116:287 */     return this.ptoEmi;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setPtoEmi(String value)
/* 120:    */   {
/* 121:299 */     this.ptoEmi = value;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getSecuencial()
/* 125:    */   {
/* 126:311 */     return this.secuencial;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setSecuencial(String value)
/* 130:    */   {
/* 131:323 */     this.secuencial = value;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public String getDirMatriz()
/* 135:    */   {
/* 136:335 */     return this.dirMatriz;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setDirMatriz(String value)
/* 140:    */   {
/* 141:347 */     this.dirMatriz = value;
/* 142:    */   }
/* 143:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.InfoTributaria
 * JD-Core Version:    0.7.0.1
 */