/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.modelo.Respuesta;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ 
/*  13:    */ public class RespuestaSQL
/*  14:    */ {
/*  15: 23 */   private Connection conn = null;
/*  16: 24 */   private Statement statement = null;
/*  17:    */   private ResultSet rs;
/*  18: 26 */   String url = null;
/*  19:    */   
/*  20:    */   public RespuestaSQL()
/*  21:    */   {
/*  22: 29 */     getStringURL();
/*  23:    */   }
/*  24:    */   
/*  25:    */   private String getStringURL()
/*  26:    */   {
/*  27: 33 */     if (Constantes.obtenerUrlBD() != null) {
/*  28: 34 */       this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "respuesta");
/*  29:    */     }
/*  30: 36 */     return null;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void insertarRespuesta(Respuesta respuesta)
/*  34:    */     throws SQLException, ClassNotFoundException
/*  35:    */   {
/*  36: 40 */     Constantes.cargarJDC();
/*  37: 41 */     this.conn = DriverManager.getConnection(this.url);
/*  38:    */     
/*  39: 43 */     String values = getInsertValues(respuesta);
/*  40: 44 */     StringBuilder sql = new StringBuilder("INSERT INTO RESPUESTA VALUES(");
/*  41: 45 */     sql.append(values);
/*  42: 46 */     this.statement = this.conn.createStatement();
/*  43: 47 */     this.statement.executeUpdate(sql.toString());
/*  44: 48 */     flushDataBase();
/*  45:    */     
/*  46: 50 */     cerrarConexion();
/*  47:    */   }
/*  48:    */   
/*  49:    */   private String getInsertValues(Respuesta respuesta)
/*  50:    */     throws ClassNotFoundException, SQLException
/*  51:    */   {
/*  52: 55 */     String insertValues = obtenerMaximo().intValue() + 1 + ",'" + respuesta.getClaveDeAcceso() + "','" + respuesta.getArchivo() + "','" + respuesta.getEstado() + "','" + respuesta.getFecha() + "')";
/*  53:    */     
/*  54:    */ 
/*  55: 58 */     return insertValues;
/*  56:    */   }
/*  57:    */   
/*  58:    */   private Integer obtenerMaximo()
/*  59:    */     throws ClassNotFoundException, SQLException
/*  60:    */   {
/*  61: 62 */     Constantes.cargarJDC();
/*  62: 63 */     this.conn = DriverManager.getConnection(this.url);
/*  63: 64 */     StringBuilder sql = new StringBuilder("SELECT MAX(CODIGO) AS SECUENCIA FROM RESPUESTA");
/*  64: 65 */     this.statement = this.conn.createStatement();
/*  65: 66 */     this.rs = this.statement.executeQuery(sql.toString());
/*  66: 67 */     int secuencial = 0;
/*  67: 68 */     while (this.rs.next()) {
/*  68: 69 */       secuencial = this.rs.getInt("SECUENCIA");
/*  69:    */     }
/*  70: 72 */     if (secuencial == 0)
/*  71:    */     {
/*  72: 73 */       sql = new StringBuilder("INSERT INTO RESPUESTA VALUES (1,'','','','')");
/*  73: 74 */       this.statement.executeUpdate(sql.toString());
/*  74: 75 */       secuencial = Integer.valueOf(1).intValue();
/*  75:    */     }
/*  76: 78 */     return Integer.valueOf(secuencial);
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void actualizaRespuesta(Respuesta respuesta)
/*  80:    */     throws SQLException, ClassNotFoundException
/*  81:    */   {
/*  82: 82 */     if (this.url != null)
/*  83:    */     {
/*  84: 83 */       Constantes.cargarJDC();
/*  85: 84 */       this.conn = DriverManager.getConnection(this.url);
/*  86:    */       
/*  87: 86 */       StringBuilder sql = new StringBuilder("UPDATE RESPUESTA SET ESTADO = '");
/*  88: 87 */       sql.append(respuesta.getEstado());
/*  89: 88 */       sql.append("' WHERE CODIGO = ");
/*  90: 89 */       sql.append(respuesta.getCodigo());
/*  91: 90 */       sql.append(" AND CLAVE_ACCESSO = '");
/*  92: 91 */       sql.append(respuesta.getClaveDeAcceso());
/*  93: 92 */       sql.append("')");
/*  94: 93 */       this.statement = this.conn.createStatement();
/*  95: 94 */       this.statement.executeUpdate(sql.toString());
/*  96: 95 */       flushDataBase();
/*  97: 96 */       cerrarConexion();
/*  98:    */     }
/*  99:    */   }
/* 100:    */   
/* 101:    */   public List<Respuesta> buscarRespuesta(String claveAcceso)
/* 102:    */     throws SQLException, ClassNotFoundException
/* 103:    */   {
/* 104:102 */     if (this.url != null)
/* 105:    */     {
/* 106:103 */       Constantes.cargarJDC();
/* 107:104 */       this.conn = DriverManager.getConnection(this.url);
/* 108:    */       
/* 109:106 */       StringBuilder sql = new StringBuilder("SELECT * FROM RESPUESTA  WHERE CLAVE_ACCESSO = '");
/* 110:107 */       sql.append(claveAcceso);
/* 111:108 */       sql.append("')");
/* 112:109 */       this.statement = this.conn.createStatement();
/* 113:110 */       this.rs = this.statement.executeQuery(sql.toString());
/* 114:    */     }
/* 115:113 */     return getListaRespuestas();
/* 116:    */   }
/* 117:    */   
/* 118:    */   private List<Respuesta> getListaRespuestas()
/* 119:    */     throws SQLException
/* 120:    */   {
/* 121:118 */     List<Respuesta> lista = new ArrayList();
/* 122:120 */     while (this.rs.next())
/* 123:    */     {
/* 124:122 */       Respuesta item = new Respuesta();
/* 125:123 */       item.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/* 126:124 */       item.setClaveDeAcceso(this.rs.getString("CLAVE_ACCESSO"));
/* 127:125 */       item.setArchivo(this.rs.getString("ARCHIVO"));
/* 128:126 */       item.setEstado(this.rs.getString("ESTADO"));
/* 129:127 */       item.setFecha(this.rs.getDate("FECHA"));
/* 130:128 */       lista.add(item);
/* 131:    */     }
/* 132:130 */     return lista;
/* 133:    */   }
/* 134:    */   
/* 135:    */   private void cerrarConexion()
/* 136:    */     throws SQLException
/* 137:    */   {
/* 138:134 */     this.statement.close();
/* 139:135 */     this.conn.close();
/* 140:    */   }
/* 141:    */   
/* 142:    */   private void getConecction()
/* 143:    */     throws SQLException
/* 144:    */   {
/* 145:139 */     this.conn = DriverManager.getConnection(this.url);
/* 146:140 */     this.statement = this.conn.createStatement();
/* 147:    */   }
/* 148:    */   
/* 149:    */   private void flushDataBase()
/* 150:    */     throws SQLException
/* 151:    */   {
/* 152:144 */     this.statement = this.conn.createStatement();
/* 153:145 */     this.statement.executeUpdate("SHUTDOWN");
/* 154:    */   }
/* 155:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.RespuestaSQL
 * JD-Core Version:    0.7.0.1
 */