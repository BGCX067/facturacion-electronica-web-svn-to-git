/*   1:    */ package ec.gob.sri.comprobantes.modelo.notadebito;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   4:    */ import javax.xml.bind.annotation.XmlRegistry;
/*   5:    */ 
/*   6:    */ @XmlRegistry
/*   7:    */ public class ObjectFactory
/*   8:    */ {
/*   9:    */   public NotaDebito.InfoAdicional createNotaDebitoInfoAdicional()
/*  10:    */   {
/*  11: 45 */     return new NotaDebito.InfoAdicional();
/*  12:    */   }
/*  13:    */   
/*  14:    */   public Impuesto createImpuesto()
/*  15:    */   {
/*  16: 53 */     return new Impuesto();
/*  17:    */   }
/*  18:    */   
/*  19:    */   public NotaDebito.Motivos createNotaDebitoMotivos()
/*  20:    */   {
/*  21: 61 */     return new NotaDebito.Motivos();
/*  22:    */   }
/*  23:    */   
/*  24:    */   public NotaDebito.InfoNotaDebito.Impuestos createNotaDebitoInfoNotaDebitoImpuestos()
/*  25:    */   {
/*  26: 69 */     return new NotaDebito.InfoNotaDebito.Impuestos();
/*  27:    */   }
/*  28:    */   
/*  29:    */   public NotaDebito.InfoNotaDebito createNotaDebitoInfoNotaDebito()
/*  30:    */   {
/*  31: 77 */     return new NotaDebito.InfoNotaDebito();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public NotaDebito.InfoAdicional.CampoAdicional createNotaDebitoInfoAdicionalCampoAdicional()
/*  35:    */   {
/*  36: 85 */     return new NotaDebito.InfoAdicional.CampoAdicional();
/*  37:    */   }
/*  38:    */   
/*  39:    */   public Detalle createDetalle()
/*  40:    */   {
/*  41: 93 */     return new Detalle();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public InfoTributaria createInfoTributaria()
/*  45:    */   {
/*  46:101 */     return new InfoTributaria();
/*  47:    */   }
/*  48:    */   
/*  49:    */   public NotaDebito createNotaDebito()
/*  50:    */   {
/*  51:109 */     return new NotaDebito();
/*  52:    */   }
/*  53:    */   
/*  54:    */   public NotaDebito.Motivos.Motivo createNotaDebitoMotivosMotivo()
/*  55:    */   {
/*  56:117 */     return new NotaDebito.Motivos.Motivo();
/*  57:    */   }
/*  58:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notadebito.ObjectFactory
 * JD-Core Version:    0.7.0.1
 */