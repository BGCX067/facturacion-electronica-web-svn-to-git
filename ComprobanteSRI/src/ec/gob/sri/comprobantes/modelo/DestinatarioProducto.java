/*  1:   */ package ec.gob.sri.comprobantes.modelo;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*  4:   */ import ec.gob.sri.comprobantes.modelo.guia.Destinatario;
/*  5:   */ import java.util.List;
/*  6:   */ 
/*  7:   */ public class DestinatarioProducto
/*  8:   */ {
/*  9:   */   private Destinatario destinatario;
/* 10:   */   private List<Producto> productos;
/* 11:   */   
/* 12:   */   public DestinatarioProducto(Destinatario destinatario, List<Producto> productos)
/* 13:   */   {
/* 14:23 */     this.destinatario = destinatario;
/* 15:24 */     this.productos = productos;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public Destinatario getDestinatario()
/* 19:   */   {
/* 20:28 */     return this.destinatario;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public void setDestinatario(Destinatario destinatario)
/* 24:   */   {
/* 25:32 */     this.destinatario = destinatario;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public List<Producto> getProductos()
/* 29:   */   {
/* 30:36 */     return this.productos;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setProductos(List<Producto> productos)
/* 34:   */   {
/* 35:40 */     this.productos = productos;
/* 36:   */   }
/* 37:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.DestinatarioProducto
 * JD-Core Version:    0.7.0.1
 */