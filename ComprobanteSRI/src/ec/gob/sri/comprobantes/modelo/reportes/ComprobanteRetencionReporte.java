/*   1:    */ package ec.gob.sri.comprobantes.modelo.reportes;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.Impuestos;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional.CampoAdicional;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.rentencion.Impuesto;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.math.BigDecimal;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ 
/*  13:    */ public class ComprobanteRetencionReporte
/*  14:    */ {
/*  15:    */   private ComprobanteRetencion comprobanteRetencion;
/*  16:    */   private List<DetallesAdicionalesReporte> detallesAdiciones;
/*  17:    */   private List<InformacionAdicional> infoAdicional;
/*  18:    */   private static final String IVA = "IVA";
/*  19:    */   private static final String RENTA = "RENTA";
/*  20:    */   private static final String ICE = "ICE";
/*  21:    */   private static final String ISD = "IMPUESTO A LA SALIDA DE DIVISAS";
/*  22:    */   private static final String FACTURA = "FACTURA";
/*  23:    */   private static final String NOTA_CREDITO = "NOTA DE CRÉDITO";
/*  24:    */   private static final String NOTA_DEBITO = "NOTA DE DÉBITO";
/*  25:    */   private static final String GUIA_REMISION = "GUÍA DE REMISIÓN";
/*  26:    */   private static final String COMP_RETENCION = "COMPROBANTE RETENCIÓN";
/*  27:    */   
/*  28:    */   public ComprobanteRetencionReporte(ComprobanteRetencion comprobanteRetencion)
/*  29:    */   {
/*  30: 31 */     this.comprobanteRetencion = comprobanteRetencion;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public ComprobanteRetencion getComprobanteRetencion()
/*  34:    */   {
/*  35: 38 */     return this.comprobanteRetencion;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setComprobanteRetencion(ComprobanteRetencion comprobanteRetencion)
/*  39:    */   {
/*  40: 45 */     this.comprobanteRetencion = comprobanteRetencion;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
/*  44:    */   {
/*  45: 52 */     this.detallesAdiciones = new ArrayList();
/*  46: 53 */     System.out.println(this.comprobanteRetencion.getImpuestos().getImpuesto().size());
/*  47: 54 */     for (Impuesto im : this.comprobanteRetencion.getImpuestos().getImpuesto())
/*  48:    */     {
/*  49: 55 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/*  50: 56 */       detAd.setBaseImponible(im.getBaseImponible().toString());
/*  51: 57 */       detAd.setPorcentajeRetener(im.getPorcentajeRetener().toString());
/*  52: 58 */       detAd.setValorRetenido(im.getValorRetenido().toString());
/*  53: 59 */       detAd.setNombreImpuesto(obtenerImpuestoDecripcion(im.getCodigo()));
/*  54: 60 */       detAd.setInfoAdicional(getInfoAdicional());
/*  55: 61 */       detAd.setNumeroComprobante(im.getNumDocSustento());
/*  56: 62 */       detAd.setNombreComprobante(obtenerDecripcionComprobante(im.getCodDocSustento()));
/*  57: 63 */       detAd.setFechaEmisionCcompModificado(im.getFechaEmisionDocSustento());
/*  58: 64 */       this.detallesAdiciones.add(detAd);
/*  59:    */     }
/*  60: 66 */     return this.detallesAdiciones;
/*  61:    */   }
/*  62:    */   
/*  63:    */   private String obtenerDecripcionComprobante(String codDocSustento)
/*  64:    */   {
/*  65: 70 */     if ("01".equals(codDocSustento)) {
/*  66: 71 */       return "FACTURA";
/*  67:    */     }
/*  68: 73 */     if ("04".equals(codDocSustento)) {
/*  69: 74 */       return "NOTA DE CRÉDITO";
/*  70:    */     }
/*  71: 76 */     if ("05".equals(codDocSustento)) {
/*  72: 77 */       return "NOTA DE DÉBITO";
/*  73:    */     }
/*  74: 79 */     if ("06".equals(codDocSustento)) {
/*  75: 80 */       return "GUÍA DE REMISIÓN";
/*  76:    */     }
/*  77: 82 */     if ("07".equals(codDocSustento)) {
/*  78: 83 */       return "COMPROBANTE RETENCIÓN";
/*  79:    */     }
/*  80: 85 */     return null;
/*  81:    */   }
/*  82:    */   
/*  83:    */   private String obtenerImpuestoDecripcion(String codigoImpuesto)
/*  84:    */   {
/*  85: 89 */     if (codigoImpuesto.equals("1")) {
/*  86: 90 */       return "RENTA";
/*  87:    */     }
/*  88: 92 */     if (codigoImpuesto.equals("2")) {
/*  89: 93 */       return "IVA";
/*  90:    */     }
/*  91: 95 */     if (codigoImpuesto.equals("3")) {
/*  92: 96 */       return "ICE";
/*  93:    */     }
/*  94: 98 */     if (codigoImpuesto.equals("6")) {
/*  95: 99 */       return "IMPUESTO A LA SALIDA DE DIVISAS";
/*  96:    */     }
/*  97:101 */     return null;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
/* 101:    */   {
/* 102:108 */     this.detallesAdiciones = detallesAdiciones;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public List<InformacionAdicional> getInfoAdicional()
/* 106:    */   {
/* 107:115 */     if (this.comprobanteRetencion.getInfoAdicional() != null)
/* 108:    */     {
/* 109:116 */       this.infoAdicional = new ArrayList();
/* 110:117 */       if ((this.comprobanteRetencion.getInfoAdicional().getCampoAdicional() != null) && (!this.comprobanteRetencion.getInfoAdicional().getCampoAdicional().isEmpty())) {
/* 111:118 */         for (ComprobanteRetencion.InfoAdicional.CampoAdicional ca : this.comprobanteRetencion.getInfoAdicional().getCampoAdicional()) {
/* 112:119 */           this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
/* 113:    */         }
/* 114:    */       }
/* 115:    */     }
/* 116:123 */     return this.infoAdicional;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
/* 120:    */   {
/* 121:130 */     this.infoAdicional = infoAdicional;
/* 122:    */   }
/* 123:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte
 * JD-Core Version:    0.7.0.1
 */