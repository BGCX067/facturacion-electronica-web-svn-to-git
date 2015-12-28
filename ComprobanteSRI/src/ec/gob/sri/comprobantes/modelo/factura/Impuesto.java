/*   1:    */ package ec.gob.sri.comprobantes.modelo.factura;
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
/*  17:    */   @XmlElement(required=true)
/*  18:    */   protected BigDecimal tarifa;
/*  19:    */   @XmlElement(required=true)
/*  20:    */   protected BigDecimal baseImponible;
/*  21:    */   @XmlElement(required=true)
/*  22:    */   protected BigDecimal valor;
/*  23:    */   
/*  24:    */   public String getCodigo()
/*  25:    */   {
/*  26: 73 */     return this.codigo;
/*  27:    */   }
/*  28:    */   
/*  29:    */   public void setCodigo(String value)
/*  30:    */   {
/*  31: 85 */     this.codigo = value;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public String getCodigoPorcentaje()
/*  35:    */   {
/*  36: 97 */     return this.codigoPorcentaje;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public void setCodigoPorcentaje(String value)
/*  40:    */   {
/*  41:109 */     this.codigoPorcentaje = value;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public BigDecimal getTarifa()
/*  45:    */   {
/*  46:121 */     return this.tarifa;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setTarifa(BigDecimal value)
/*  50:    */   {
/*  51:133 */     this.tarifa = value;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public BigDecimal getBaseImponible()
/*  55:    */   {
/*  56:145 */     return this.baseImponible;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setBaseImponible(BigDecimal value)
/*  60:    */   {
/*  61:157 */     this.baseImponible = value;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public BigDecimal getValor()
/*  65:    */   {
/*  66:169 */     return this.valor;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setValor(BigDecimal value)
/*  70:    */   {
/*  71:181 */     this.valor = value;
/*  72:    */   }
/*  73:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.factura.Impuesto
 * JD-Core Version:    0.7.0.1
 */