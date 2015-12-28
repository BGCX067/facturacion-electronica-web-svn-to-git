/*   1:    */ package ec.gob.sri.comprobantes.modelo.notacredito;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   5:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   6:    */ import javax.xml.bind.annotation.XmlElement;
/*   7:    */ import javax.xml.bind.annotation.XmlType;
/*   8:    */ 
/*   9:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*  10:    */ @XmlType(name="impuesto", propOrder={"codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor"})
/*  11:    */ public class Impuesto
/*  12:    */ {
/*  13:    */   @XmlElement(required=true)
/*  14:    */   protected String codigo;
/*  15:    */   @XmlElement(required=true)
/*  16:    */   protected String codigoPorcentaje;
/*  17:    */   protected BigDecimal tarifa;
/*  18:    */   @XmlElement(required=true)
/*  19:    */   protected BigDecimal baseImponible;
/*  20:    */   @XmlElement(required=true)
/*  21:    */   protected BigDecimal valor;
/*  22:    */   
/*  23:    */   public String getCodigo()
/*  24:    */   {
/*  25: 72 */     return this.codigo;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public void setCodigo(String value)
/*  29:    */   {
/*  30: 84 */     this.codigo = value;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public String getCodigoPorcentaje()
/*  34:    */   {
/*  35: 96 */     return this.codigoPorcentaje;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setCodigoPorcentaje(String value)
/*  39:    */   {
/*  40:108 */     this.codigoPorcentaje = value;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public BigDecimal getTarifa()
/*  44:    */   {
/*  45:120 */     return this.tarifa;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setTarifa(BigDecimal value)
/*  49:    */   {
/*  50:132 */     this.tarifa = value;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public BigDecimal getBaseImponible()
/*  54:    */   {
/*  55:144 */     return this.baseImponible;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setBaseImponible(BigDecimal value)
/*  59:    */   {
/*  60:156 */     this.baseImponible = value;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public BigDecimal getValor()
/*  64:    */   {
/*  65:168 */     return this.valor;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setValor(BigDecimal value)
/*  69:    */   {
/*  70:180 */     this.valor = value;
/*  71:    */   }
/*  72:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.notacredito.Impuesto
 * JD-Core Version:    0.7.0.1
 */