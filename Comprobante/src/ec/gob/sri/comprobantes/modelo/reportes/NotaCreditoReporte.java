/*   1:    */ package ec.gob.sri.comprobantes.modelo.reportes;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*   4:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles;
/*   5:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle.DetallesAdicionales;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional;
/*   8:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoAdicional;
/*   9:    */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoAdicional.CampoAdicional;
/*  10:    */ import java.math.BigDecimal;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.List;
/*  13:    */ 
/*  14:    */ public class NotaCreditoReporte
/*  15:    */ {
/*  16:    */   private NotaCredito notaCredito;
/*  17:    */   private List<DetallesAdicionalesReporte> detallesAdiciones;
/*  18:    */   private List<InformacionAdicional> infoAdicional;
/*  19:    */   
/*  20:    */   public NotaCreditoReporte(NotaCredito notaCredito)
/*  21:    */   {
/*  22: 21 */     this.notaCredito = notaCredito;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public NotaCredito getNotaCredito()
/*  26:    */   {
/*  27: 28 */     return this.notaCredito;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setNotaCredito(NotaCredito notaCredito)
/*  31:    */   {
/*  32: 35 */     this.notaCredito = notaCredito;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
/*  36:    */   {
/*  37: 42 */     this.detallesAdiciones = new ArrayList();
/*  38: 44 */     for (NotaCredito.Detalles.Detalle det : getNotaCredito().getDetalles().getDetalle())
/*  39:    */     {
/*  40: 45 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/*  41: 46 */       detAd.setCodigoPrincipal(det.getCodigoInterno());
/*  42: 47 */       detAd.setCodigoAuxiliar(det.getCodigoAdicional());
/*  43: 48 */       detAd.setDescripcion(det.getDescripcion());
/*  44: 49 */       detAd.setCantidad(det.getCantidad().toPlainString());
/*  45: 50 */       detAd.setPrecioTotalSinImpuesto(det.getPrecioTotalSinImpuesto().toString());
/*  46: 51 */       detAd.setPrecioUnitario(det.getPrecioUnitario().toString());
/*  47: 52 */       detAd.setDescuento(det.getDescuento().toString());
/*  48: 53 */       int i = 0;
/*  49: 54 */       if ((det.getDetallesAdicionales() != null) && (det.getDetallesAdicionales().getDetAdicional() != null)) {
/*  50: 55 */         for (NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional detAdicional : det.getDetallesAdicionales().getDetAdicional())
/*  51:    */         {
/*  52: 56 */           if (i == 0) {
/*  53: 57 */             detAd.setDetalle1(detAdicional.getNombre());
/*  54:    */           }
/*  55: 59 */           if (i == 1) {
/*  56: 60 */             detAd.setDetalle2(detAdicional.getNombre());
/*  57:    */           }
/*  58: 62 */           if (i == 2) {
/*  59: 63 */             detAd.setDetalle3(detAdicional.getNombre());
/*  60:    */           }
/*  61: 65 */           i++;
/*  62:    */         }
/*  63:    */       }
/*  64: 70 */       detAd.setInfoAdicional(getInfoAdicional());
/*  65: 71 */       this.detallesAdiciones.add(detAd);
/*  66:    */     }
/*  67: 73 */     return this.detallesAdiciones;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
/*  71:    */   {
/*  72: 80 */     this.detallesAdiciones = detallesAdiciones;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public List<InformacionAdicional> getInfoAdicional()
/*  76:    */   {
/*  77: 87 */     if (this.notaCredito.getInfoAdicional() != null)
/*  78:    */     {
/*  79: 88 */       this.infoAdicional = new ArrayList();
/*  80: 89 */       if ((this.notaCredito.getInfoAdicional().getCampoAdicional() != null) && (!this.notaCredito.getInfoAdicional().getCampoAdicional().isEmpty())) {
/*  81: 90 */         for (NotaCredito.InfoAdicional.CampoAdicional ca : this.notaCredito.getInfoAdicional().getCampoAdicional()) {
/*  82: 91 */           this.infoAdicional.add(new InformacionAdicional(ca.getValue(), ca.getNombre()));
/*  83:    */         }
/*  84:    */       }
/*  85:    */     }
/*  86: 95 */     return this.infoAdicional;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
/*  90:    */   {
/*  91:102 */     this.infoAdicional = infoAdicional;
/*  92:    */   }
/*  93:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte
 * JD-Core Version:    0.7.0.1
 */