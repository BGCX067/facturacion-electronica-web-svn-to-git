/*   1:    */ package ec.gob.sri.comprobantes.modelo;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.util.List;
/*   5:    */ 
/*   6:    */ public class ImpuestoRetencion
/*   7:    */ {
/*   8:    */   private Integer codigo;
/*   9:    */   private String codigoRetencion;
/*  10:    */   private BigDecimal baseImponible;
/*  11:    */   private BigDecimal porcentajeRetener;
/*  12:    */   private BigDecimal valorRetenido;
/*  13:    */   private String codDocSustento;
/*  14:    */   private String numDocSustento;
/*  15:    */   private String fechaEmisionDocSustento;
/*  16:    */   private String nombreImpuesto;
/*  17:    */   private List<CampoAdicional> camposAdicionales;
/*  18:    */   
/*  19:    */   public ImpuestoRetencion(Integer codigo, String codigoRetencion, BigDecimal porcentajeRetener, BigDecimal baseImponible, BigDecimal valorRetenido, String codDocSustento, String numDocSustento, String fechaEmisionDocSustento)
/*  20:    */   {
/*  21: 31 */     this.codigo = codigo;
/*  22: 32 */     this.codigoRetencion = codigoRetencion;
/*  23: 33 */     this.porcentajeRetener = porcentajeRetener;
/*  24: 34 */     this.baseImponible = baseImponible;
/*  25: 35 */     this.valorRetenido = valorRetenido;
/*  26: 36 */     this.codDocSustento = codDocSustento;
/*  27: 37 */     this.numDocSustento = numDocSustento;
/*  28: 38 */     this.fechaEmisionDocSustento = fechaEmisionDocSustento;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public String getNombreImpuesto()
/*  32:    */   {
/*  33: 45 */     return this.nombreImpuesto;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void setNombreImpuesto(String nombreImpuesto)
/*  37:    */   {
/*  38: 52 */     this.nombreImpuesto = nombreImpuesto;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public Integer getCodigo()
/*  42:    */   {
/*  43: 59 */     return this.codigo;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public void setCodigo(Integer codigo)
/*  47:    */   {
/*  48: 66 */     this.codigo = codigo;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public String getCodigoRetencion()
/*  52:    */   {
/*  53: 73 */     return this.codigoRetencion;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void setCodigoRetencion(String codigoRetencion)
/*  57:    */   {
/*  58: 80 */     this.codigoRetencion = codigoRetencion;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public BigDecimal getPorcentajeRetener()
/*  62:    */   {
/*  63: 87 */     return this.porcentajeRetener;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setPorcentajeRetener(BigDecimal porcentajeRetener)
/*  67:    */   {
/*  68: 94 */     this.porcentajeRetener = porcentajeRetener;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public BigDecimal getBaseImponible()
/*  72:    */   {
/*  73:101 */     return this.baseImponible;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setBaseImponible(BigDecimal baseImponible)
/*  77:    */   {
/*  78:108 */     this.baseImponible = baseImponible;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public BigDecimal getValorRetenido()
/*  82:    */   {
/*  83:115 */     return this.valorRetenido;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public void setValorRetenido(BigDecimal valorRetenido)
/*  87:    */   {
/*  88:122 */     this.valorRetenido = valorRetenido;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public String getCodDocSustento()
/*  92:    */   {
/*  93:129 */     return this.codDocSustento;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void setCodDocSustento(String codDocSustento)
/*  97:    */   {
/*  98:136 */     this.codDocSustento = codDocSustento;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public String getNumDocSustento()
/* 102:    */   {
/* 103:143 */     return this.numDocSustento;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setNumDocSustento(String numDocSustento)
/* 107:    */   {
/* 108:150 */     this.numDocSustento = numDocSustento;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public String getFechaEmisionDocSustento()
/* 112:    */   {
/* 113:157 */     return this.fechaEmisionDocSustento;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public void setFechaEmisionDocSustento(String fechaEmisionDocSustento)
/* 117:    */   {
/* 118:164 */     this.fechaEmisionDocSustento = fechaEmisionDocSustento;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public List<CampoAdicional> getCamposAdicionales()
/* 122:    */   {
/* 123:171 */     return this.camposAdicionales;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setCamposAdicionales(List<CampoAdicional> camposAdicionales)
/* 127:    */   {
/* 128:178 */     this.camposAdicionales = camposAdicionales;
/* 129:    */   }
/* 130:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.ImpuestoRetencion
 * JD-Core Version:    0.7.0.1
 */