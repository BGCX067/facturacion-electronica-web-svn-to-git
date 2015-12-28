/*   1:    */ package ec.gob.sri.comprobantes.modelo.rentencion;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   5:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   6:    */ import javax.xml.bind.annotation.XmlElement;
/*   7:    */ import javax.xml.bind.annotation.XmlType;
/*   8:    */ 
/*   9:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*  10:    */ @XmlType(name="impuesto", propOrder={"codigo", "codigoRetencion", "baseImponible", "porcentajeRetener", "valorRetenido", "codDocSustento", "numDocSustento", "fechaEmisionDocSustento"})
/*  11:    */ public class Impuesto
/*  12:    */ {
/*  13:    */   @XmlElement(required=true)
/*  14:    */   protected String codigo;
/*  15:    */   @XmlElement(required=true)
/*  16:    */   protected String codigoRetencion;
/*  17:    */   @XmlElement(required=true)
/*  18:    */   protected BigDecimal baseImponible;
/*  19:    */   @XmlElement(required=true)
/*  20:    */   protected BigDecimal porcentajeRetener;
/*  21:    */   @XmlElement(required=true)
/*  22:    */   protected BigDecimal valorRetenido;
/*  23:    */   @XmlElement(required=true)
/*  24:    */   protected String codDocSustento;
/*  25:    */   protected String numDocSustento;
/*  26:    */   protected String fechaEmisionDocSustento;
/*  27:    */   
/*  28:    */   public String getCodigo()
/*  29:    */   {
/*  30: 80 */     return this.codigo;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setCodigo(String value)
/*  34:    */   {
/*  35: 92 */     this.codigo = value;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public String getCodigoRetencion()
/*  39:    */   {
/*  40:104 */     return this.codigoRetencion;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setCodigoRetencion(String value)
/*  44:    */   {
/*  45:116 */     this.codigoRetencion = value;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public BigDecimal getBaseImponible()
/*  49:    */   {
/*  50:128 */     return this.baseImponible;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setBaseImponible(BigDecimal value)
/*  54:    */   {
/*  55:140 */     this.baseImponible = value;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public BigDecimal getPorcentajeRetener()
/*  59:    */   {
/*  60:152 */     return this.porcentajeRetener;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setPorcentajeRetener(BigDecimal value)
/*  64:    */   {
/*  65:164 */     this.porcentajeRetener = value;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public BigDecimal getValorRetenido()
/*  69:    */   {
/*  70:176 */     return this.valorRetenido;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setValorRetenido(BigDecimal value)
/*  74:    */   {
/*  75:188 */     this.valorRetenido = value;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getCodDocSustento()
/*  79:    */   {
/*  80:200 */     return this.codDocSustento;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setCodDocSustento(String value)
/*  84:    */   {
/*  85:212 */     this.codDocSustento = value;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public String getNumDocSustento()
/*  89:    */   {
/*  90:224 */     return this.numDocSustento;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setNumDocSustento(String value)
/*  94:    */   {
/*  95:236 */     this.numDocSustento = value;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getFechaEmisionDocSustento()
/*  99:    */   {
/* 100:248 */     return this.fechaEmisionDocSustento;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setFechaEmisionDocSustento(String value)
/* 104:    */   {
/* 105:260 */     this.fechaEmisionDocSustento = value;
/* 106:    */   }
/* 107:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.rentencion.Impuesto
 * JD-Core Version:    0.7.0.1
 */