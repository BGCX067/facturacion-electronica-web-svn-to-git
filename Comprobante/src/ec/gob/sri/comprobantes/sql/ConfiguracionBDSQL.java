/*  1:   */ package ec.gob.sri.comprobantes.sql;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.util.Constantes;
/*  4:   */ import java.sql.Connection;
/*  5:   */ import java.sql.DriverManager;
/*  6:   */ import java.sql.ResultSet;
/*  7:   */ import java.sql.SQLException;
/*  8:   */ import java.sql.Statement;
/*  9:   */ 
/* 10:   */ public class ConfiguracionBDSQL
/* 11:   */ {
/* 12:20 */   private Connection conn = null;
/* 13:21 */   private Statement statement = null;
/* 14:   */   private ResultSet rs;
/* 15:   */   String url;
/* 16:   */   
/* 17:   */   public ConfiguracionBDSQL()
/* 18:   */   {
/* 19:26 */     this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "configuracionBD");
/* 20:   */   }
/* 21:   */   
/* 22:   */   public String obtenerUrlConexion()
/* 23:   */     throws ClassNotFoundException, SQLException
/* 24:   */   {
/* 25:30 */     String path = null;
/* 26:31 */     Constantes.cargarJDC();
/* 27:32 */     getConecction();
/* 28:33 */     this.rs = this.statement.executeQuery("SELECT * FROM BASE_DATOS ");
/* 29:34 */     if (this.rs.next()) {
/* 30:35 */       path = this.rs.getString("PATH_BD");
/* 31:   */     }
/* 32:38 */     cerrarConexion();
/* 33:39 */     return path;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getConfiguracionBD()
/* 37:   */     throws SQLException, ClassNotFoundException
/* 38:   */   {
/* 39:43 */     if (Constantes.obtenerUrlBD() != null)
/* 40:   */     {
/* 41:44 */       Constantes.cargarJDC();
/* 42:45 */       this.conn = DriverManager.getConnection(this.url);
/* 43:46 */       StringBuilder sql = new StringBuilder("select * from BASE_DATOS");
/* 44:47 */       this.statement = this.conn.createStatement();
/* 45:48 */       this.rs = this.statement.executeQuery(sql.toString());
/* 46:49 */       String urlBD = null;
/* 47:50 */       while (this.rs.next()) {
/* 48:51 */         urlBD = this.rs.getString("path_bd");
/* 49:   */       }
/* 50:53 */       return urlBD;
/* 51:   */     }
/* 52:55 */     return null;
/* 53:   */   }
/* 54:   */   
/* 55:   */   private void cerrarConexion()
/* 56:   */     throws SQLException
/* 57:   */   {
/* 58:59 */     this.statement.close();
/* 59:60 */     this.conn.close();
/* 60:   */   }
/* 61:   */   
/* 62:   */   private void getConecction()
/* 63:   */     throws SQLException
/* 64:   */   {
/* 65:64 */     this.conn = DriverManager.getConnection(this.url);
/* 66:65 */     this.statement = this.conn.createStatement();
/* 67:   */   }
/* 68:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ConfiguracionBDSQL
 * JD-Core Version:    0.7.0.1
 */