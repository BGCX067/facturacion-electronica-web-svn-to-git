/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ import java.util.List;
/*  11:    */ 
/*  12:    */ public class ClavesSQL
/*  13:    */ {
/*  14: 22 */   private Connection conn = null;
/*  15: 23 */   private Statement statement = null;
/*  16:    */   private ResultSet rs;
/*  17: 25 */   String url = null;
/*  18:    */   
/*  19:    */   public ClavesSQL()
/*  20:    */   {
/*  21: 28 */     getStringURL();
/*  22:    */   }
/*  23:    */   
/*  24:    */   private String getStringURL()
/*  25:    */   {
/*  26: 32 */     if (Constantes.obtenerUrlBD() != null) {
/*  27: 33 */       this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "claves");
/*  28:    */     }
/*  29: 35 */     return null;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public void insertarClaves(List<ClaveContingencia> claves)
/*  33:    */     throws SQLException, ClassNotFoundException
/*  34:    */   {
/*  35: 39 */     Constantes.cargarJDC();
/*  36: 40 */     this.conn = DriverManager.getConnection(this.url);
/*  37: 41 */     for (ClaveContingencia claveContingencia : claves)
/*  38:    */     {
/*  39: 42 */       String values = getInsertValues(claveContingencia);
/*  40: 43 */       StringBuilder sql = new StringBuilder("INSERT INTO CLAVES VALUES(");
/*  41: 44 */       sql.append(values);
/*  42: 45 */       this.statement = this.conn.createStatement();
/*  43: 46 */       this.statement.executeUpdate(sql.toString());
/*  44:    */     }
/*  45: 49 */     flushDataBase();
/*  46: 50 */     cerrarConexion();
/*  47:    */   }
/*  48:    */   
/*  49:    */   private String getInsertValues(ClaveContingencia clave)
/*  50:    */     throws ClassNotFoundException, SQLException
/*  51:    */   {
/*  52: 54 */     String insertValues = obtenerMaximo().intValue() + 1 + ",'" + clave.getClave() + "','" + clave.getUsada() + "','')";
/*  53: 55 */     return insertValues;
/*  54:    */   }
/*  55:    */   
/*  56:    */   private Integer obtenerMaximo()
/*  57:    */     throws ClassNotFoundException, SQLException
/*  58:    */   {
/*  59: 59 */     Constantes.cargarJDC();
/*  60: 60 */     this.conn = DriverManager.getConnection(this.url);
/*  61: 61 */     StringBuilder sql = new StringBuilder("SELECT MAX(CODIGO) AS SECUENCIA FROM CLAVES");
/*  62: 62 */     this.statement = this.conn.createStatement();
/*  63: 63 */     this.rs = this.statement.executeQuery(sql.toString());
/*  64: 64 */     if (this.rs.next()) {
/*  65: 65 */       return Integer.valueOf(this.rs.getInt("SECUENCIA"));
/*  66:    */     }
/*  67: 67 */     return Integer.valueOf(0);
/*  68:    */   }
/*  69:    */   
/*  70:    */   public ClaveContingencia obtenerUltimaNoUsada()
/*  71:    */     throws ClassNotFoundException, SQLException
/*  72:    */   {
/*  73: 80 */     if (this.url != null)
/*  74:    */     {
/*  75: 81 */       Constantes.cargarJDC();
/*  76: 82 */       this.conn = DriverManager.getConnection(this.url);
/*  77: 83 */       ClaveContingencia clave = new ClaveContingencia();
/*  78: 84 */       StringBuilder sql = new StringBuilder("SELECT * FROM CLAVES WHERE CODIGO IN ( SELECT MIN(CODIGO) FROM CLAVES WHERE UTILIZADA <> 'S' )");
/*  79: 85 */       this.statement = this.conn.createStatement();
/*  80: 86 */       this.rs = this.statement.executeQuery(sql.toString());
/*  81: 87 */       while (this.rs.next())
/*  82:    */       {
/*  83: 88 */         clave.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/*  84: 89 */         clave.setClave(this.rs.getString("CLAVE"));
/*  85: 90 */         clave.setUsada(this.rs.getString("UTILIZADA"));
/*  86:    */       }
/*  87: 92 */       return clave;
/*  88:    */     }
/*  89: 94 */     return null;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void actualizaClave(ClaveContingencia clave)
/*  93:    */     throws SQLException, ClassNotFoundException
/*  94:    */   {
/*  95:105 */     if (this.url != null)
/*  96:    */     {
/*  97:106 */       Constantes.cargarJDC();
/*  98:107 */       this.conn = DriverManager.getConnection(this.url);
/*  99:    */       
/* 100:109 */       StringBuilder sql = new StringBuilder("UPDATE CLAVES SET UTILIZADA = '");
/* 101:110 */       sql.append(clave.getUsada());
/* 102:111 */       sql.append("', CODIGOCOMPROBANTE = '");
/* 103:112 */       sql.append(clave.getCodigoComprobante());
/* 104:113 */       sql.append("' WHERE CODIGO = ");
/* 105:114 */       sql.append(clave.getCodigo());
/* 106:115 */       this.statement = this.conn.createStatement();
/* 107:116 */       this.statement.executeUpdate(sql.toString());
/* 108:117 */       flushDataBase();
/* 109:118 */       cerrarConexion();
/* 110:    */     }
/* 111:    */   }
/* 112:    */   
/* 113:    */   private void cerrarConexion()
/* 114:    */     throws SQLException
/* 115:    */   {
/* 116:123 */     this.statement.close();
/* 117:124 */     this.conn.close();
/* 118:    */   }
/* 119:    */   
/* 120:    */   private void getConecction()
/* 121:    */     throws SQLException
/* 122:    */   {
/* 123:128 */     this.conn = DriverManager.getConnection(this.url);
/* 124:129 */     this.statement = this.conn.createStatement();
/* 125:    */   }
/* 126:    */   
/* 127:    */   private void flushDataBase()
/* 128:    */     throws SQLException
/* 129:    */   {
/* 130:133 */     this.statement = this.conn.createStatement();
/* 131:134 */     this.statement.executeUpdate("SHUTDOWN");
/* 132:    */   }
/* 133:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ClavesSQL
 * JD-Core Version:    0.7.0.1
 */