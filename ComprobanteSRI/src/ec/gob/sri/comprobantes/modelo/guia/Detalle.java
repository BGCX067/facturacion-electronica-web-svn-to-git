/*   1:    */ package ec.gob.sri.comprobantes.modelo.guia;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.util.ArrayList;
/*   5:    */ import java.util.List;
/*   6:    */ import javax.xml.bind.annotation.XmlAccessType;
/*   7:    */ import javax.xml.bind.annotation.XmlAccessorType;
/*   8:    */ import javax.xml.bind.annotation.XmlAttribute;
/*   9:    */ import javax.xml.bind.annotation.XmlElement;
/*  10:    */ import javax.xml.bind.annotation.XmlType;
/*  11:    */ 
/*  12:    */ @XmlAccessorType(XmlAccessType.FIELD)
/*  13:    */ @XmlType(name="detalle", propOrder={"codigoInterno", "codigoAdicional", "descripcion", "cantidad", "detallesAdicionales"})
/*  14:    */ public class Detalle
/*  15:    */ {
/*  16:    */   @XmlElement(required=true)
/*  17:    */   protected String codigoInterno;
/*  18:    */   protected String codigoAdicional;
/*  19:    */   @XmlElement(required=true)
/*  20:    */   protected String descripcion;
/*  21:    */   @XmlElement(required=true)
/*  22:    */   protected BigDecimal cantidad;
/*  23:    */   protected DetallesAdicionales detallesAdicionales;
/*  24:    */   
/*  25:    */   public String getCodigoInterno()
/*  26:    */   {
/*  27:107 */     return this.codigoInterno;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public void setCodigoInterno(String value)
/*  31:    */   {
/*  32:119 */     this.codigoInterno = value;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public String getCodigoAdicional()
/*  36:    */   {
/*  37:131 */     return this.codigoAdicional;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setCodigoAdicional(String value)
/*  41:    */   {
/*  42:143 */     this.codigoAdicional = value;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public String getDescripcion()
/*  46:    */   {
/*  47:155 */     return this.descripcion;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setDescripcion(String value)
/*  51:    */   {
/*  52:167 */     this.descripcion = value;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public BigDecimal getCantidad()
/*  56:    */   {
/*  57:179 */     return this.cantidad;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setCantidad(BigDecimal value)
/*  61:    */   {
/*  62:191 */     this.cantidad = value;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public DetallesAdicionales getDetallesAdicionales()
/*  66:    */   {
/*  67:203 */     return this.detallesAdicionales;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setDetallesAdicionales(DetallesAdicionales value)
/*  71:    */   {
/*  72:215 */     this.detallesAdicionales = value;
/*  73:    */   }
/*  74:    */   
/*  75:    */   @XmlAccessorType(XmlAccessType.FIELD)
/*  76:    */   @XmlType(name="", propOrder={"detAdicional"})
/*  77:    */   public static class DetallesAdicionales
/*  78:    */   {
/*  79:    */     protected List<DetAdicional> detAdicional;
/*  80:    */     
/*  81:    */     public List<DetAdicional> getDetAdicional()
/*  82:    */     {
/*  83:292 */       if (this.detAdicional == null) {
/*  84:293 */         this.detAdicional = new ArrayList();
/*  85:    */       }
/*  86:295 */       return this.detAdicional;
/*  87:    */     }
/*  88:    */     
/*  89:    */     @XmlAccessorType(XmlAccessType.FIELD)
/*  90:    */     @XmlType(name="")
/*  91:    */     public static class DetAdicional
/*  92:    */     {
/*  93:    */       @XmlAttribute
/*  94:    */       protected String nombre;
/*  95:    */       @XmlAttribute
/*  96:    */       protected String valor;
/*  97:    */       
/*  98:    */       public String getNombre()
/*  99:    */       {
/* 100:349 */         return this.nombre;
/* 101:    */       }
/* 102:    */       
/* 103:    */       public void setNombre(String value)
/* 104:    */       {
/* 105:361 */         this.nombre = value;
/* 106:    */       }
/* 107:    */       
/* 108:    */       public String getValor()
/* 109:    */       {
/* 110:373 */         return this.valor;
/* 111:    */       }
/* 112:    */       
/* 113:    */       public void setValor(String value)
/* 114:    */       {
/* 115:385 */         this.valor = value;
/* 116:    */       }
/* 117:    */     }
/* 118:    */   }
/* 119:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.guia.Detalle
 * JD-Core Version:    0.7.0.1
 */