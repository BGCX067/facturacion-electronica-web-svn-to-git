/*  1:   */ package ec.gob.sri.comprobantes.modelo.reportes;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*  4:   */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoAdicional;
/*  5:   */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoAdicional.CampoAdicional;
/*  6:   */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.Motivos;
/*  7:   */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.Motivos.Motivo;
/*  8:   */ import java.math.BigDecimal;
/*  9:   */ import java.util.ArrayList;
/* 10:   */ import java.util.List;
/* 11:   */ 
/* 12:   */ public class NotaDebitoReporte
/* 13:   */ {
/* 14:   */   private NotaDebito notaDebito;
/* 15:   */   private List<DetallesAdicionalesReporte> detallesAdiciones;
/* 16:   */   private List<InformacionAdicional> infoAdicional;
/* 17:   */   
/* 18:   */   public NotaDebitoReporte(NotaDebito notaDebito)
/* 19:   */   {
/* 20:22 */     this.notaDebito = notaDebito;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public List<DetallesAdicionalesReporte> getDetallesAdiciones()
/* 24:   */   {
/* 25:29 */     this.detallesAdiciones = new ArrayList();
/* 26:30 */     for (NotaDebito.Motivos.Motivo motivo : this.notaDebito.getMotivos().getMotivo())
/* 27:   */     {
/* 28:31 */       DetallesAdicionalesReporte detAd = new DetallesAdicionalesReporte();
/* 29:32 */       detAd.setRazonModificacion(motivo.getRazon());
/* 30:33 */       detAd.setValorModificacion(motivo.getValor().toString());
/* 31:34 */       detAd.setInfoAdicional(getInfoAdicional());
/* 32:35 */       this.detallesAdiciones.add(detAd);
/* 33:   */     }
/* 34:37 */     return this.detallesAdiciones;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setDetallesAdiciones(List<DetallesAdicionalesReporte> detallesAdiciones)
/* 38:   */   {
/* 39:44 */     this.detallesAdiciones = detallesAdiciones;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public NotaDebito getNotaDebito()
/* 43:   */   {
/* 44:51 */     return this.notaDebito;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setNotaDebito(NotaDebito notaDebito)
/* 48:   */   {
/* 49:58 */     this.notaDebito = notaDebito;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public List<InformacionAdicional> getInfoAdicional()
/* 53:   */   {
/* 54:66 */     if ((this.notaDebito.getInfoAdicional() != null) && (!this.notaDebito.getInfoAdicional().getCampoAdicional().isEmpty()))
/* 55:   */     {
/* 56:67 */       this.infoAdicional = new ArrayList();
/* 57:68 */       for (NotaDebito.InfoAdicional.CampoAdicional info : this.notaDebito.getInfoAdicional().getCampoAdicional())
/* 58:   */       {
/* 59:69 */         InformacionAdicional ia = new InformacionAdicional(info.getValue(), info.getNombre());
/* 60:70 */         this.infoAdicional.add(ia);
/* 61:   */       }
/* 62:   */     }
/* 63:73 */     return this.infoAdicional;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
/* 67:   */   {
/* 68:80 */     this.infoAdicional = infoAdicional;
/* 69:   */   }
/* 70:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte
 * JD-Core Version:    0.7.0.1
 */