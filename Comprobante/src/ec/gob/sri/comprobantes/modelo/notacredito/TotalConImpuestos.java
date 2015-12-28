/*   1:    */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   7:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   8:    */ import javax.xml.bind.annotation.XmlElement;
/*   9:    */ import javax.xml.bind.annotation.XmlRootElement;
/*  10:    */ import javax.xml.bind.annotation.XmlType;
/*  11:    */ 
/*  12:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*  13:    */ @XmlType(name="", propOrder={"totalImpuesto"})
/*  14:    */ @XmlRootElement(name="totalConImpuestos")
/*  15:    */ public class TotalConImpuestos
/*  16:    */ {
/*  17:    */   @XmlElement(required=true)
/*  18:    */   protected List<TotalImpuesto> totalImpuesto;
/*  19:    */   
/*  20:    */   public List<TotalImpuesto> getTotalImpuesto()
/*  21:    */   {
/*  22: 86 */     if (this.totalImpuesto == null) {
/*  23: 87 */       this.totalImpuesto = new ArrayList();
/*  24:    */     }
/*  25: 89 */     return this.totalImpuesto;
/*  26:    */   }
/*  27:    */   
/*  28:    */   @XmlAccessorType(XmlAccessType.FIELD)
/*  29:    */   @XmlType(name="", propOrder={"codigo", "codigoPorcentaje", "baseImponible", "valor"})
/*  30:    */   public static class TotalImpuesto
/*  31:    */   {
/*  32:    */     @XmlElement(required=true)
/*  33:    */     protected String codigo;
/*  34:    */     @XmlElement(required=true)
/*  35:    */     protected String codigoPorcentaje;
/*  36:    */     @XmlElement(required=true)
/*  37:    */     protected BigDecimal baseImponible;
/*  38:    */     @XmlElement(required=true)
/*  39:    */     protected BigDecimal valor;
/*  40:    */     
/*  41:    */     public String getCodigo()
/*  42:    */     {
/*  43:142 */       return this.codigo;
/*  44:    */     }
/*  45:    */     
/*  46:    */     public void setCodigo(String value)
/*  47:    */     {
/*  48:154 */       this.codigo = value;
/*  49:    */     }
/*  50:    */     
/*  51:    */     public String getCodigoPorcentaje()
/*  52:    */     {
/*  53:166 */       return this.codigoPorcentaje;
/*  54:    */     }
/*  55:    */     
/*  56:    */     public void setCodigoPorcentaje(String value)
/*  57:    */     {
/*  58:178 */       this.codigoPorcentaje = value;
/*  59:    */     }
/*  60:    */     
/*  61:    */     public BigDecimal getBaseImponible()
/*  62:    */     {
/*  63:190 */       return this.baseImponible;
/*  64:    */     }
/*  65:    */     
/*  66:    */     public void setBaseImponible(BigDecimal value)
/*  67:    */     {
/*  68:202 */       this.baseImponible = value;
/*  69:    */     }
/*  70:    */     
/*  71:    */     public BigDecimal getValor()
/*  72:    */     {
/*  73:214 */       return this.valor;
/*  74:    */     }
/*  75:    */     
/*  76:    */     public void setValor(BigDecimal value)
/*  77:    */     {
/*  78:226 */       this.valor = value;
/*  79:    */     }
/*  80:    */   }
/*  81:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos
 * JD-Core Version:    0.7.0.1
 */