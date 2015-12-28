/*   1:    */ package ec.gob.sri.comprobantes.modelo.factura;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   4:    */ import javax.xml.bind.annotation.XmlRegistry;
/*   5:    */ 
/*   6:    */ @XmlRegistry
/*   7:    */ public class ObjectFactory
/*   8:    */ {
/*   9:    */   public Factura.Detalles.Detalle.DetallesAdicionales createFacturaDetallesDetalleDetallesAdicionales()
/*  10:    */   {
/*  11: 45 */     return new Factura.Detalles.Detalle.DetallesAdicionales();
/*  12:    */   }
/*  13:    */   
/*  14:    */   public Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional createFacturaDetallesDetalleDetallesAdicionalesDetAdicional()
/*  15:    */   {
/*  16: 53 */     return new Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public Factura.Detalles createFacturaDetalles()
/*  20:    */   {
/*  21: 61 */     return new Factura.Detalles();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public Factura.Detalles.Detalle createFacturaDetallesDetalle()
/*  25:    */   {
/*  26: 69 */     return new Factura.Detalles.Detalle();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public Factura.InfoFactura createFacturaInfoFactura()
/*  30:    */   {
/*  31: 77 */     return new Factura.InfoFactura();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public Factura.InfoAdicional createFacturaInfoAdicional()
/*  35:    */   {
/*  36: 85 */     return new Factura.InfoAdicional();
/*  37:    */   }
/*  38:    */   
/*  39:    */   public Impuesto createImpuesto()
/*  40:    */   {
/*  41: 93 */     return new Impuesto();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public InfoTributaria createInfoTributaria()
/*  45:    */   {
/*  46:101 */     return new InfoTributaria();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public Factura createFactura()
/*  50:    */   {
/*  51:109 */     return new Factura();
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Factura.InfoAdicional.CampoAdicional createFacturaInfoAdicionalCampoAdicional()
/*  55:    */   {
/*  56:117 */     return new Factura.InfoAdicional.CampoAdicional();
/*  57:    */   }
/*  58:    */   
/*  59:    */   public Factura.InfoFactura.TotalConImpuestos createFacturaInfoFacturaTotalConImpuestos()
/*  60:    */   {
/*  61:125 */     return new Factura.InfoFactura.TotalConImpuestos();
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Factura.Detalles.Detalle.Impuestos createFacturaDetallesDetalleImpuestos()
/*  65:    */   {
/*  66:133 */     return new Factura.Detalles.Detalle.Impuestos();
/*  67:    */   }
/*  68:    */   
/*  69:    */   public Factura.InfoFactura.TotalConImpuestos.TotalImpuesto createFacturaInfoFacturaTotalConImpuestosTotalImpuesto()
/*  70:    */   {
/*  71:141 */     return new Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
/*  72:    */   }
/*  73:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.factura.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */