/*  1:   */ package ec.gob.sri.comprobantes.sql;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*  4:   */ import ec.gob.sri.comprobantes.util.Constantes;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.DriverManager;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.sql.Statement;
/* 10:   */ import java.util.ArrayList;
/* 11:   */ import java.util.List;
/* 12:   */ 
/* 13:   */ public class InformacionAdicionalSQL
/* 14:   */ {
/* 15:25 */   private Connection conn = null;
/* 16:26 */   private Statement statement = null;
/* 17:   */   private ResultSet rs;
/* 18:28 */   String url = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "producto";
/* 19:   */   
/* 20:   */   public List<InformacionAdicionalProducto> obtenerInformacionAdicional(Integer codigoProducto)
/* 21:   */     throws SQLException, ClassNotFoundException
/* 22:   */   {
/* 23:38 */     Constantes.cargarJDC();
/* 24:39 */     this.conn = DriverManager.getConnection(this.url);
/* 25:40 */     StringBuilder sql = new StringBuilder("SELECT * FROM INFO_ADICIONAL WHERE CODIGO_PRODUCTO = ");
/* 26:41 */     sql.append(codigoProducto.toString());
/* 27:   */     
/* 28:43 */     this.statement = this.conn.createStatement();
/* 29:44 */     this.rs = this.statement.executeQuery(sql.toString());
/* 30:   */     
/* 31:46 */     List<InformacionAdicionalProducto> list = new ArrayList();
/* 32:47 */     while (this.rs.next())
/* 33:   */     {
/* 34:48 */       InformacionAdicionalProducto inf = new InformacionAdicionalProducto();
/* 35:49 */       inf.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/* 36:50 */       inf.setCodigoProducto(Integer.valueOf(this.rs.getInt("CODIGO_PRODUCTO")));
/* 37:51 */       inf.setAtributo(this.rs.getString("ATRIBUTO"));
/* 38:52 */       inf.setValor(this.rs.getString("VALOR"));
/* 39:   */       
/* 40:54 */       list.add(inf);
/* 41:   */     }
/* 42:56 */     return list;
/* 43:   */   }
/* 44:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.InformacionAdicionalSQL
 * JD-Core Version:    0.7.0.1
 */