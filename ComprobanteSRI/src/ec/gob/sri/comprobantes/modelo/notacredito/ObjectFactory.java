/*   1:    */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   4:    */ import javax.xml.bind.annotation.XmlRegistry;
/*   5:    */ 
/*   6:    */ @XmlRegistry
/*   7:    */ public class ObjectFactory
/*   8:    */ {
/*   9:    */   public NotaCredito createNotaCredito()
/*  10:    */   {
/*  11: 45 */     return new NotaCredito();
/*  12:    */   }
/*  13:    */   
/*  14:    */   public Detalle createDetalle()
/*  15:    */   {
/*  16: 53 */     return new Detalle();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public TotalConImpuestos createTotalConImpuestos()
/*  20:    */   {
/*  21: 61 */     return new TotalConImpuestos();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public TotalConImpuestos.TotalImpuesto createTotalConImpuestosTotalImpuesto()
/*  25:    */   {
/*  26: 69 */     return new TotalConImpuestos.TotalImpuesto();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public NotaCredito.InfoNotaCredito createNotaCreditoInfoNotaCredito()
/*  30:    */   {
/*  31: 77 */     return new NotaCredito.InfoNotaCredito();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public NotaCredito.InfoAdicional.CampoAdicional createNotaCreditoInfoAdicionalCampoAdicional()
/*  35:    */   {
/*  36: 85 */     return new NotaCredito.InfoAdicional.CampoAdicional();
/*  37:    */   }
/*  38:    */   
/*  39:    */   public NotaCredito.Detalles createNotaCreditoDetalles()
/*  40:    */   {
/*  41: 93 */     return new NotaCredito.Detalles();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public InfoTributaria createInfoTributaria()
/*  45:    */   {
/*  46:101 */     return new InfoTributaria();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public Impuesto createImpuesto()
/*  50:    */   {
/*  51:109 */     return new Impuesto();
/*  52:    */   }
/*  53:    */   
/*  54:    */   public NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional createNotaCreditoDetallesDetalleDetallesAdicionalesDetAdicional()
/*  55:    */   {
/*  56:117 */     return new NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional();
/*  57:    */   }
/*  58:    */   
/*  59:    */   public NotaCredito.Detalles.Detalle createNotaCreditoDetallesDetalle()
/*  60:    */   {
/*  61:125 */     return new NotaCredito.Detalles.Detalle();
/*  62:    */   }
/*  63:    */   
/*  64:    */   public NotaCredito.Detalles.Detalle.DetallesAdicionales createNotaCreditoDetallesDetalleDetallesAdicionales()
/*  65:    */   {
/*  66:133 */     return new NotaCredito.Detalles.Detalle.DetallesAdicionales();
/*  67:    */   }
/*  68:    */   
/*  69:    */   public NotaCredito.InfoAdicional createNotaCreditoInfoAdicional()
/*  70:    */   {
/*  71:141 */     return new NotaCredito.InfoAdicional();
/*  72:    */   }
/*  73:    */   
/*  74:    */   public NotaCredito.Detalles.Detalle.Impuestos createNotaCreditoDetallesDetalleImpuestos()
/*  75:    */   {
/*  76:149 */     return new NotaCredito.Detalles.Detalle.Impuestos();
/*  77:    */   }
/*  78:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */