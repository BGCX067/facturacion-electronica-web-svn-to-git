/*   1:    */ package ec.gob.sri.comprobantes.administracion.modelo;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ 
/*   5:    */ public class ImpuestoValor
/*   6:    */ {
/*   7:    */   private String codigo;
/*   8:    */   private Integer codigoImpuesto;
/*   9:    */   private Double porcentaje;
/*  10:    */   private Double porcentajeRentencion;
/*  11:    */   private String tipoImpuesto;
/*  12:    */   private String descripcion;
/*  13:    */   private Date fechaInicio;
/*  14:    */   private Date fechaFin;
/*  15:    */   
/*  16:    */   public String getCodigo()
/*  17:    */   {
/*  18: 28 */     return this.codigo;
/*  19:    */   }
/*  20:    */   
/*  21:    */   public ImpuestoValor() {}
/*  22:    */   
/*  23:    */   public ImpuestoValor(ImpuestoValor i)
/*  24:    */   {
/*  25: 35 */     this.codigo = i.getCodigo();
/*  26: 36 */     this.codigoImpuesto = i.getCodigoImpuesto();
/*  27: 37 */     this.porcentaje = i.getPorcentaje();
/*  28: 38 */     this.porcentajeRentencion = i.getPorcentajeRentencion();
/*  29: 39 */     this.tipoImpuesto = i.getTipoImpuesto();
/*  30: 40 */     this.descripcion = i.getDescripcion();
/*  31: 41 */     this.fechaInicio = i.getFechaInicio();
/*  32: 42 */     this.fechaFin = i.getFechaFin();
/*  33:    */   }
/*  34:    */   
/*  35:    */   public ImpuestoValor(Integer codigoImpuesto, String tipoImpuesto)
/*  36:    */   {
/*  37: 46 */     this.codigoImpuesto = codigoImpuesto;
/*  38: 47 */     this.tipoImpuesto = tipoImpuesto;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setCodigo(String codigo)
/*  42:    */   {
/*  43: 54 */     this.codigo = codigo;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public Integer getCodigoImpuesto()
/*  47:    */   {
/*  48: 61 */     return this.codigoImpuesto;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setCodigoImpuesto(Integer codigoImpuesto)
/*  52:    */   {
/*  53: 68 */     this.codigoImpuesto = codigoImpuesto;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Double getPorcentaje()
/*  57:    */   {
/*  58: 75 */     return this.porcentaje;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setPorcentaje(Double porcentaje)
/*  62:    */   {
/*  63: 82 */     this.porcentaje = porcentaje;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Double getPorcentajeRentencion()
/*  67:    */   {
/*  68: 89 */     return this.porcentajeRentencion;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setPorcentajeRentencion(Double porcentajeRentencion)
/*  72:    */   {
/*  73: 96 */     this.porcentajeRentencion = porcentajeRentencion;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String getTipoImpuesto()
/*  77:    */   {
/*  78:103 */     return this.tipoImpuesto;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setTipoImpuesto(String tipoImpuesto)
/*  82:    */   {
/*  83:110 */     this.tipoImpuesto = tipoImpuesto;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public String getDescripcion()
/*  87:    */   {
/*  88:117 */     return this.descripcion;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setDescripcion(String descripcion)
/*  92:    */   {
/*  93:124 */     this.descripcion = descripcion;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public Date getFechaFin()
/*  97:    */   {
/*  98:128 */     return this.fechaFin;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setFechaFin(Date fechaFin)
/* 102:    */   {
/* 103:132 */     this.fechaFin = fechaFin;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public Date getFechaInicio()
/* 107:    */   {
/* 108:136 */     return this.fechaInicio;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setFechaInicio(Date fechaInicio)
/* 112:    */   {
/* 113:140 */     this.fechaInicio = fechaInicio;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String toString()
/* 117:    */   {
/* 118:147 */     if (((this.codigoImpuesto.intValue() == 1) || (this.codigoImpuesto.intValue() == 2) || (this.codigoImpuesto.intValue() == 3) || (this.codigoImpuesto.intValue() == 5)) && ((this.tipoImpuesto.equals("R")) || (this.tipoImpuesto.equals("I")) || (this.tipoImpuesto.equals("A")) || (this.tipoImpuesto.equals("B"))))
/* 119:    */     {
/* 120:148 */       if (getCodigo() != null) {
/* 121:149 */         return getCodigo() + " - " + getDescripcion();
/* 122:    */       }
/* 123:151 */       return "Seleccione....";
/* 124:    */     }
/* 125:154 */     return null;
/* 126:    */   }
/* 127:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor
 * JD-Core Version:    0.7.0.1
 */