/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Proxy;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ 
/*  11:    */ public class ProxySQL
/*  12:    */ {
/*  13: 21 */   private Connection conn = null;
/*  14: 22 */   private Statement statement = null;
/*  15:    */   private ResultSet rs;
/*  16:    */   private String url;
/*  17:    */   
/*  18:    */   public ProxySQL()
/*  19:    */   {
/*  20: 27 */     this.url = null;
/*  21: 28 */     getStringURL();
/*  22:    */   }
/*  23:    */   
/*  24:    */   private String getStringURL()
/*  25:    */   {
/*  26: 32 */     if (Constantes.obtenerUrlBD() != null) {
/*  27: 33 */       this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "PROXY");
/*  28:    */     }
/*  29: 35 */     return null;
/*  30:    */   }
/*  31:    */   
/*  32:    */   private void crear(Proxy proxy)
/*  33:    */     throws ClassNotFoundException, SQLException
/*  34:    */   {
/*  35: 39 */     Constantes.cargarJDC();
/*  36: 40 */     getConecction();
/*  37: 41 */     String sql = "INSERT INTO PROXY(CODIGO,URL,PUERTO,USUARIO,CLAVE ,WS_PRODUCCION ,WS_PRUEBAS ) VALUES (1,'" + proxy.getUrl() + "','" + proxy.getPuerto() + "','" + proxy.getUsuario() + "','" + proxy.getClave() + "','" + proxy.getWsProduccion() + "','" + proxy.getWsPruebas() + "')";
/*  38:    */     
/*  39: 43 */     this.statement.executeUpdate(sql);
/*  40: 44 */     flushDataBase();
/*  41: 45 */     cerrarConexion();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void crearProxy(Proxy proxy)
/*  45:    */     throws ClassNotFoundException, SQLException
/*  46:    */   {
/*  47: 49 */     eliminarProxy();
/*  48: 50 */     crear(proxy);
/*  49:    */   }
/*  50:    */   
/*  51:    */   public Boolean hayRegistros()
/*  52:    */     throws ClassNotFoundException, SQLException
/*  53:    */   {
/*  54: 54 */     Constantes.cargarJDC();
/*  55: 55 */     getConecction();
/*  56: 56 */     this.rs = this.statement.executeQuery("SELECT * FROM PROXY");
/*  57: 57 */     int i = 0;
/*  58: 58 */     if (this.rs.next()) {
/*  59: 59 */       i++;
/*  60:    */     }
/*  61: 62 */     cerrarConexion();
/*  62: 63 */     if (i > 0) {
/*  63: 64 */       return Boolean.valueOf(true);
/*  64:    */     }
/*  65: 66 */     return Boolean.valueOf(false);
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void eliminarProxy()
/*  69:    */     throws ClassNotFoundException, SQLException
/*  70:    */   {
/*  71: 71 */     Constantes.cargarJDC();
/*  72: 72 */     getConecction();
/*  73: 73 */     this.statement.executeUpdate("DELETE FROM PROXY");
/*  74: 74 */     flushDataBase();
/*  75: 75 */     cerrarConexion();
/*  76:    */   }
/*  77:    */   
/*  78:    */   private void cerrarConexion()
/*  79:    */     throws SQLException
/*  80:    */   {
/*  81: 79 */     this.statement.close();
/*  82: 80 */     this.conn.close();
/*  83:    */   }
/*  84:    */   
/*  85:    */   private void getConecction()
/*  86:    */     throws SQLException
/*  87:    */   {
/*  88: 84 */     this.conn = DriverManager.getConnection(this.url);
/*  89: 85 */     this.statement = this.conn.createStatement();
/*  90:    */   }
/*  91:    */   
/*  92:    */   private void flushDataBase()
/*  93:    */     throws SQLException
/*  94:    */   {
/*  95: 89 */     this.statement = this.conn.createStatement();
/*  96: 90 */     this.statement.executeUpdate("SHUTDOWN");
/*  97:    */   }
/*  98:    */   
/*  99:    */   public Proxy obtenerProxy()
/* 100:    */     throws SQLException, ClassNotFoundException
/* 101:    */   {
/* 102:102 */     if (Constantes.obtenerUrlBD() != null)
/* 103:    */     {
/* 104:103 */       Constantes.cargarJDC();
/* 105:104 */       this.conn = DriverManager.getConnection(this.url);
/* 106:105 */       StringBuilder sql = new StringBuilder("select * from PROXY ");
/* 107:106 */       this.statement = this.conn.createStatement();
/* 108:107 */       this.rs = this.statement.executeQuery(sql.toString());
/* 109:108 */       return getProxy();
/* 110:    */     }
/* 111:110 */     return null;
/* 112:    */   }
/* 113:    */   
/* 114:    */   private Proxy getProxy()
/* 115:    */     throws SQLException
/* 116:    */   {
/* 117:120 */     Proxy proxy = null;
/* 118:121 */     while (this.rs.next())
/* 119:    */     {
/* 120:122 */       proxy = new Proxy();
/* 121:123 */       proxy.setUrl(this.rs.getString("URL"));
/* 122:124 */       proxy.setPuerto(Integer.valueOf(this.rs.getInt("PUERTO")));
/* 123:125 */       proxy.setUsuario(this.rs.getString("USUARIO"));
/* 124:126 */       proxy.setClave(this.rs.getString("CLAVE"));
/* 125:127 */       proxy.setWsProduccion(this.rs.getString("WS_PRODUCCION"));
/* 126:128 */       proxy.setWsPruebas(this.rs.getString("WS_PRUEBAS"));
/* 127:    */     }
/* 128:130 */     return proxy;
/* 129:    */   }
/* 130:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ProxySQL
 * JD-Core Version:    0.7.0.1
 */