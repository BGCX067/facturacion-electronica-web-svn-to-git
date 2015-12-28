/*  1:   */ package ec.gob.sri.comprobantes.sql;
/*  2:   */ 
/*  3:   */ import ec.gob.sri.comprobantes.administracion.modelo.Impuesto;
/*  4:   */ import ec.gob.sri.comprobantes.util.Constantes;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.DriverManager;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.sql.Statement;
/* 10:   */ import java.util.ArrayList;
/* 11:   */ import java.util.List;
/* 12:   */ 
/* 13:   */ public class ImpuestoSQL
/* 14:   */ {
/* 15:23 */   private Connection conn = null;
/* 16:24 */   private Statement statement = null;
/* 17:   */   private ResultSet rs;
/* 18:   */   private String url;
/* 19:   */   
/* 20:   */   public ImpuestoSQL()
/* 21:   */   {
/* 22:29 */     this.url = null;
/* 23:30 */     getStringURL();
/* 24:   */   }
/* 25:   */   
/* 26:   */   private String getStringURL()
/* 27:   */   {
/* 28:34 */     if (Constantes.obtenerUrlBD() != null) {
/* 29:35 */       this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "producto");
/* 30:   */     }
/* 31:37 */     return null;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public List<Impuesto> obtenerDatosEmisor()
/* 35:   */     throws SQLException, ClassNotFoundException
/* 36:   */   {
/* 37:41 */     if (this.url != null)
/* 38:   */     {
/* 39:42 */       Constantes.cargarJDC();
/* 40:43 */       this.conn = DriverManager.getConnection(this.url);
/* 41:44 */       StringBuilder sql = new StringBuilder("select * from impuesto");
/* 42:45 */       this.statement = this.conn.createStatement();
/* 43:46 */       this.rs = this.statement.executeQuery(sql.toString());
/* 44:47 */       return obetnerImpuestos();
/* 45:   */     }
/* 46:49 */     return new ArrayList();
/* 47:   */   }
/* 48:   */   
/* 49:   */   private List<Impuesto> obetnerImpuestos()
/* 50:   */     throws SQLException
/* 51:   */   {
/* 52:53 */     List<Impuesto> impuestos = new ArrayList();
/* 53:54 */     int i = 0;
/* 54:55 */     while (this.rs.next())
/* 55:   */     {
/* 56:56 */       if (i == 0)
/* 57:   */       {
/* 58:57 */         Impuesto seleccione = new Impuesto();
/* 59:58 */         seleccione.setDescripcion("Seleccione");
/* 60:59 */         impuestos.add(seleccione);
/* 61:   */       }
/* 62:61 */       Impuesto imp = new Impuesto();
/* 63:62 */       imp.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/* 64:63 */       imp.setDescripcion(this.rs.getString("TAIM_DES_IMP"));
/* 65:64 */       imp.setEstado(this.rs.getString("TAIM_ESTADO"));
/* 66:65 */       impuestos.add(imp);
/* 67:66 */       i++;
/* 68:   */     }
/* 69:68 */     return impuestos;
/* 70:   */   }
/* 71:   */   
/* 72:   */   private Impuesto obtenerImpuesto()
/* 73:   */     throws SQLException
/* 74:   */   {
/* 75:72 */     Impuesto imp = new Impuesto();
/* 76:73 */     while (this.rs.next())
/* 77:   */     {
/* 78:74 */       imp.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/* 79:75 */       imp.setDescripcion(this.rs.getString("TAIM_DES_IMP"));
/* 80:76 */       imp.setEstado(this.rs.getString("TAIM_ESTADO"));
/* 81:   */     }
/* 82:78 */     return imp;
/* 83:   */   }
/* 84:   */   
/* 85:   */   public Impuesto obtenerImpuestoPorCodigo(Integer codigo)
/* 86:   */     throws SQLException, ClassNotFoundException
/* 87:   */   {
/* 88:82 */     Constantes.cargarJDC();
/* 89:83 */     this.conn = DriverManager.getConnection(this.url);
/* 90:84 */     StringBuilder sql = new StringBuilder("select * from impuesto where CODIGO=" + codigo);
/* 91:85 */     this.statement = this.conn.createStatement();
/* 92:86 */     this.rs = this.statement.executeQuery(sql.toString());
/* 93:87 */     return obtenerImpuesto();
/* 94:   */   }
/* 95:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ImpuestoSQL
 * JD-Core Version:    0.7.0.1
 */