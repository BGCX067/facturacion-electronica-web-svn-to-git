/*  1:   */ package ec.gob.sri.comprobantes.sql;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoProducto;
/*  4:   */ import ec.gob.sri.comprobantes.util.Constantes;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.DriverManager;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.sql.Statement;
/* 10:   */ import java.util.ArrayList;
/* 11:   */ import java.util.List;
/* 12:   */ 
/* 13:   */ public class ProductoImpuestoSQL
/* 14:   */ {
/* 15:25 */   private Connection conn = null;
/* 16:26 */   private Statement statement = null;
/* 17:   */   private ResultSet rs;
/* 18:28 */   String url = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "producto";
/* 19:   */   
/* 20:   */   public List<ImpuestoProducto> obtenerImpuestoProducto(Integer codigoProducto)
/* 21:   */     throws SQLException, ClassNotFoundException
/* 22:   */   {
/* 23:38 */     Constantes.cargarJDC();
/* 24:39 */     this.conn = DriverManager.getConnection(this.url);
/* 25:   */     
/* 26:41 */     StringBuilder sql = new StringBuilder("SELECT * FROM PRODUCTO_IMPUESTO WHERE CODIGO_PRODUCTO = '");
/* 27:42 */     sql.append(codigoProducto.toString());
/* 28:43 */     sql.append("'");
/* 29:   */     
/* 30:45 */     this.statement = this.conn.createStatement();
/* 31:46 */     this.rs = this.statement.executeQuery(sql.toString());
/* 32:   */     
/* 33:48 */     List<ImpuestoProducto> list = new ArrayList();
/* 34:49 */     while (this.rs.next())
/* 35:   */     {
/* 36:50 */       ImpuestoProducto p = new ImpuestoProducto();
/* 37:51 */       p.setCodigoProducto(Integer.valueOf(this.rs.getInt("CODIGO_PRODUCTO")));
/* 38:52 */       p.setCodigoImpuesto(this.rs.getString("CODIGO_IMPUESTO_VALOR"));
/* 39:53 */       list.add(p);
/* 40:   */     }
/* 41:55 */     return list;
/* 42:   */   }
/* 43:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ProductoImpuestoSQL
 * JD-Core Version:    0.7.0.1
 */