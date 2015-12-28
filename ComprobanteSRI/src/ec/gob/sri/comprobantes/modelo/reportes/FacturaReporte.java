/*   1:    */ package ec.gob.sri.comprobantes.modelo.reportes;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle.DetallesAdicionales;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional;
/*   8:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional;
/*   9:    */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional.CampoAdicional;
/*  10:    */ import java.io.PrintStream;
/*  11:    */ import java.math.BigDecimal;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ 
/*  15:    */ public class FacturaReporte
/*  16:    */ {
/*  17:    */   private Factura factura;
/*  18:    */   private String detalle1;
/*  19:    */   private String detalle2;
/*  20:    */   private String detalle3;
/*  21:    */   private List<DetallesAdicionalesReporte> detallesAdiciones;
/*  22:    */   private List<InformacionAdicional> infoAdicional;
/*  23:    */   
/*  24:    */   public FacturaReporte(Factura factura)
/*  25:    */   {
/*  26: 25 */     this.factura = factura;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public Factura getFactura()
/*  30:    */   {
/*  31: 32 */     return this.factura;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void setFactura(Factura factura)
/*  35:    */   {
/*  36: 39 */     this.factura = factura;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getDetalle1()
/*  40:    */   {
/*  41: 46 */     return this.detalle1;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void setDetalle1(String detalle1)
/*  45:    */   {
/*  46: 53 */     this.detalle1 = detalle1;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getDetalle2()
/*  50:    */   {
/*  51: 60 */     return this.detalle2;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setDetalle2(String detalle2)
/*  55:    */   {
/*  56: 67 */     this.detalle2 = detalle2;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public String getDetalle3()
/*  60:    */   {
/*  61: 74 */     return this.detalle3;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public void setDetalle3(String detalle3)
/*  65:    */   {
/*  66: 81 */     this.detalle3 = detalle3;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
/*  70:    */   {
/*  71: 88 */     this.detallesAdiciones = new ArrayList();
/*  72: 90 */     for (Factura.Detalles.Detalle det : getFactura().getDetalles().getDetalle())
/*  73:    */     {
/*  74: 91 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/*  75: 92 */       detAd.setCodigoPrincipal(det.getCodigoPrincipal());
/*  76: 93 */       detAd.setCodigoAuxiliar(det.getCodigoAuxiliar());
/*  77: 94 */       detAd.setDescripcion(det.getDescripcion());
/*  78: 95 */       detAd.setCantidad(det.getCantidad().toPlainString());
/*  79: 96 */       detAd.setPrecioTotalSinImpuesto(det.getPrecioTotalSinImpuesto().toString());
/*  80: 97 */       detAd.setPrecioUnitario(det.getPrecioUnitario().toString());
/*  81: 98 */       if (det.getDescuento() != null) {
/*  82: 99 */         detAd.setDescuento(det.getDescuento().toString());
/*  83:    */       }
/*  84:101 */       int i = 0;
/*  85:102 */       if ((det.getDetallesAdicionales() != null) && (det.getDetallesAdicionales().getDetAdicional() != null) && (!det.getDetallesAdicionales().getDetAdicional().isEmpty())) {
/*  86:103 */         for (Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional detAdicional : det.getDetallesAdicionales().getDetAdicional())
/*  87:    */         {
/*  88:104 */           if (i == 0) {
/*  89:105 */             detAd.setDetalle1(detAdicional.getNombre());
/*  90:    */           }
/*  91:107 */           if (i == 1) {
/*  92:108 */             detAd.setDetalle2(detAdicional.getNombre());
/*  93:    */           }
/*  94:110 */           if (i == 2) {
/*  95:111 */             detAd.setDetalle3(detAdicional.getNombre());
/*  96:    */           }
/*  97:113 */           i++;
/*  98:    */         }
/*  99:    */       }
/* 100:116 */       detAd.setInfoAdicional(getInfoAdicional());
/* 101:117 */       this.detallesAdiciones.add(detAd);
/* 102:    */     }
/* 103:120 */     return this.detallesAdiciones;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
/* 107:    */   {
/* 108:127 */     this.detallesAdiciones = detallesAdiciones;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public List<InformacionAdicional> getInfoAdicional()
/* 112:    */   {
/* 113:134 */     System.out.println("--->" + getFactura());
/* 114:135 */     if (getFactura().getInfoAdicional() != null)
/* 115:    */     {
/* 116:136 */       this.infoAdicional = new ArrayList();
/* 117:137 */       if ((getFactura().getInfoAdicional().getCampoAdicional() != null) && (!this.factura.getInfoAdicional().getCampoAdicional().isEmpty())) {
/* 118:138 */         for (Factura.InfoAdicional.CampoAdicional ca : getFactura().getInfoAdicional().getCampoAdicional()) {
/* 119:139 */           this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
/* 120:    */         }
/* 121:    */       }
/* 122:    */     }
/* 123:143 */     return this.infoAdicional;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
/* 127:    */   {
/* 128:150 */     this.infoAdicional = infoAdicional;
/* 129:    */   }
/* 130:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte
 * JD-Core Version:    0.7.0.1
 */