/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Comprobante;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.math.BigInteger;
/*   6:    */ import java.sql.Connection;
/*   7:    */ import java.sql.DriverManager;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.sql.Statement;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.List;
/*  13:    */ 
/*  14:    */ public class ComprobantesSQL
/*  15:    */ {
/*  16: 24 */   private Connection conn = null;
/*  17: 25 */   private Statement statement = null;
/*  18:    */   private ResultSet rs;
/*  19:    */   String url;
/*  20:    */   
/*  21:    */   public ComprobantesSQL()
/*  22:    */   {
/*  23: 31 */     this.url = null;
/*  24: 32 */     getStringURL();
/*  25:    */   }
/*  26:    */   
/*  27:    */   private String getStringURL()
/*  28:    */   {
/*  29: 36 */     if (Constantes.obtenerUrlBD() != null) {
/*  30: 37 */       this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "comprobantes");
/*  31:    */     }
/*  32: 39 */     return null;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void insertarClaves(String codigo, Long secuencial)
/*  36:    */     throws SQLException, ClassNotFoundException
/*  37:    */   {
/*  38: 52 */     Constantes.cargarJDC();
/*  39: 53 */     this.conn = DriverManager.getConnection(this.url);
/*  40: 54 */     StringBuilder sql = new StringBuilder("INSERT INTO COMPROBANTES VALUES('");
/*  41: 55 */     sql.append(codigo);
/*  42: 56 */     sql.append("', ");
/*  43: 57 */     sql.append(secuencial);
/*  44: 58 */     sql.append(")");
/*  45: 59 */     this.statement = this.conn.createStatement();
/*  46: 60 */     this.statement.executeUpdate(sql.toString());
/*  47:    */     
/*  48: 62 */     flushDataBase();
/*  49: 63 */     cerrarConexion();
/*  50:    */   }
/*  51:    */   
/*  52:    */   public Long obtenerMaximo(String codigo)
/*  53:    */     throws ClassNotFoundException, SQLException
/*  54:    */   {
/*  55: 76 */     if (Constantes.obtenerUrlBD() != null)
/*  56:    */     {
/*  57: 77 */       Long secuencial = null;
/*  58:    */       
/*  59: 79 */       Constantes.cargarJDC();
/*  60: 80 */       this.conn = DriverManager.getConnection(this.url);
/*  61: 81 */       StringBuilder sql = new StringBuilder("SELECT MAX(secuencial) AS SECUENCIA FROM COMPROBANTES WHERE codigo = '");
/*  62: 82 */       sql.append(codigo);
/*  63: 83 */       sql.append("'");
/*  64: 84 */       this.statement = this.conn.createStatement();
/*  65: 85 */       this.rs = this.statement.executeQuery(sql.toString());
/*  66: 86 */       while (this.rs.next()) {
/*  67: 87 */         secuencial = Long.valueOf(this.rs.getLong("SECUENCIA"));
/*  68:    */       }
/*  69: 90 */       if (secuencial.longValue() == 0L)
/*  70:    */       {
/*  71: 91 */         sql = new StringBuilder("INSERT INTO COMPROBANTES VALUES ('00',1)");
/*  72: 92 */         this.statement.executeUpdate(sql.toString());
/*  73: 93 */         secuencial = Long.valueOf(1L);
/*  74:    */       }
/*  75: 96 */       return secuencial;
/*  76:    */     }
/*  77: 98 */     return Long.valueOf(0L);
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void actualizaSecuencial(String codigo, Long siguiente)
/*  81:    */     throws SQLException, ClassNotFoundException
/*  82:    */   {
/*  83:112 */     Constantes.cargarJDC();
/*  84:113 */     this.conn = DriverManager.getConnection(this.url);
/*  85:    */     
/*  86:115 */     StringBuilder sql = new StringBuilder("UPDATE COMPROBANTES SET secuencial = ");
/*  87:116 */     sql.append(siguiente);
/*  88:117 */     sql.append(" WHERE CODIGO = '");
/*  89:118 */     sql.append(codigo);
/*  90:119 */     sql.append("'");
/*  91:120 */     this.statement = this.conn.createStatement();
/*  92:121 */     this.statement.executeUpdate(sql.toString());
/*  93:122 */     flushDataBase();
/*  94:123 */     cerrarConexion();
/*  95:    */   }
/*  96:    */   
/*  97:    */   private void cerrarConexion()
/*  98:    */     throws SQLException
/*  99:    */   {
/* 100:127 */     this.statement.close();
/* 101:128 */     this.conn.close();
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void ActualizarSecuencial(List<Comprobante> comprobantesList)
/* 105:    */     throws SQLException, ClassNotFoundException
/* 106:    */   {
/* 107:132 */     Constantes.cargarJDC();
/* 108:133 */     this.conn = DriverManager.getConnection(this.url);
/* 109:134 */     for (Comprobante comprobante : comprobantesList)
/* 110:    */     {
/* 111:135 */       StringBuilder sql = new StringBuilder("UPDATE COMPROBANTES SET secuencial = ");
/* 112:136 */       sql.append(comprobante.getInicioSecuencia());
/* 113:137 */       sql.append(" WHERE CODIGO = '");
/* 114:138 */       sql.append(comprobante.getCodigo());
/* 115:139 */       sql.append("'");
/* 116:140 */       this.statement = this.conn.createStatement();
/* 117:141 */       this.statement.executeUpdate(sql.toString());
/* 118:    */     }
/* 119:143 */     flushDataBase();
/* 120:144 */     this.conn.close();
/* 121:    */   }
/* 122:    */   
/* 123:    */   public List<Comprobante> obtenerComprobantes()
/* 124:    */     throws SQLException, ClassNotFoundException
/* 125:    */   {
/* 126:148 */     Constantes.cargarJDC();
/* 127:149 */     this.conn = DriverManager.getConnection(this.url);
/* 128:150 */     this.statement = this.conn.createStatement();
/* 129:151 */     this.rs = this.statement.executeQuery("SELECT * FROM COMPROBANTES");
/* 130:152 */     return obtenerComprobantesModel();
/* 131:    */   }
/* 132:    */   
/* 133:    */   private List<Comprobante> obtenerComprobantesModel()
/* 134:    */     throws SQLException
/* 135:    */   {
/* 136:156 */     List<Comprobante> listComp = new ArrayList();
/* 137:157 */     while (this.rs.next()) {
/* 138:158 */       listComp.add(new Comprobante(this.rs.getString("CODIGO"), new BigInteger(this.rs.getString("SECUENCIAL"))));
/* 139:    */     }
/* 140:161 */     return listComp;
/* 141:    */   }
/* 142:    */   
/* 143:    */   private void flushDataBase()
/* 144:    */     throws SQLException
/* 145:    */   {
/* 146:169 */     this.statement = this.conn.createStatement();
/* 147:170 */     this.statement.executeUpdate("SHUTDOWN");
/* 148:    */   }
/* 149:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ComprobantesSQL
 * JD-Core Version:    0.7.0.1
 */