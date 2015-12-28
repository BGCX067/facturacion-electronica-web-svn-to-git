/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ 
/*  15:    */ public class TransportistaSQL
/*  16:    */ {
/*  17: 23 */   private Connection conn = null;
/*  18: 24 */   private Statement statement = null;
/*  19:    */   private ResultSet rs;
/*  20: 26 */   String url = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "transportistas";
/*  21:    */   
/*  22:    */   public List<Transportista> obtenerTransportista(String tipoIdentificacion, String numeroIdentificacion, String razonSocial)
/*  23:    */     throws SQLException, ClassNotFoundException
/*  24:    */   {
/*  25: 29 */     Constantes.cargarJDC();
/*  26: 30 */     this.conn = DriverManager.getConnection(this.url);
/*  27: 31 */     StringBuilder sql = new StringBuilder("SELECT * FROM TRANSPORTISTAS WHERE 1=1");
/*  28: 32 */     if ((tipoIdentificacion != null) && (!tipoIdentificacion.isEmpty())) {
/*  29: 33 */       sql.append(" and TIPOIDENTIFICACION='" + tipoIdentificacion + "'");
/*  30:    */     }
/*  31: 35 */     if ((numeroIdentificacion != null) && (!numeroIdentificacion.isEmpty())) {
/*  32: 37 */       sql.append(" and UCASE(NUMEROIDENTIFICACION) like '%" + numeroIdentificacion.toUpperCase() + "%'");
/*  33:    */     }
/*  34: 39 */     if ((razonSocial != null) && (!razonSocial.isEmpty())) {
/*  35: 40 */       sql.append(" and UCASE(RAZONSOCIAL) like '%" + razonSocial.toUpperCase() + "%'");
/*  36:    */     }
/*  37: 42 */     this.statement = this.conn.createStatement();
/*  38: 43 */     this.rs = this.statement.executeQuery(sql.toString());
/*  39: 44 */     return listaTransportistas();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void crearTransportista(Transportista t)
/*  43:    */     throws SQLException, ClassNotFoundException
/*  44:    */   {
/*  45: 48 */     Constantes.cargarJDC();
/*  46: 49 */     this.conn = DriverManager.getConnection(this.url);
/*  47: 50 */     Integer secuencia = Integer.valueOf(getMaxCodigoTransportista().intValue() + 1);
/*  48: 51 */     StringBuilder sql = new StringBuilder("INSERT INTO TRANSPORTISTAS VALUES(" + secuencia + ",");
/*  49: 52 */     sql.append("'" + t.getRazonSocial() + "','" + t.getTipoIdentificacion() + "','" + t.getIdentificacion() + "','" + t.getMail() + "','" + t.getPlaca() + "')");
/*  50: 53 */     this.statement = this.conn.createStatement();
/*  51: 54 */     this.statement.executeUpdate(sql.toString());
/*  52: 55 */     flushDataBase();
/*  53: 56 */     cerrarConexion();
/*  54:    */   }
/*  55:    */   
/*  56:    */   public void crearTransportista(List<Transportista> transportistaList)
/*  57:    */   {
/*  58: 60 */     for (Transportista transportista : transportistaList) {
/*  59:    */       try
/*  60:    */       {
/*  61: 62 */         crearTransportista(transportista);
/*  62:    */       }
/*  63:    */       catch (SQLException ex)
/*  64:    */       {
/*  65: 64 */         Logger.getLogger(TransportistaSQL.class.getName()).log(Level.SEVERE, null, ex);
/*  66:    */       }
/*  67:    */       catch (ClassNotFoundException ex)
/*  68:    */       {
/*  69: 66 */         Logger.getLogger(TransportistaSQL.class.getName()).log(Level.SEVERE, null, ex);
/*  70:    */       }
/*  71:    */     }
/*  72:    */   }
/*  73:    */   
/*  74:    */   public void actualizarTransportista(Transportista t)
/*  75:    */     throws SQLException, ClassNotFoundException
/*  76:    */   {
/*  77: 73 */     Constantes.cargarJDC();
/*  78: 74 */     this.conn = DriverManager.getConnection(this.url);
/*  79: 75 */     StringBuilder sql = new StringBuilder("UPDATE TRANSPORTISTAS SET ");
/*  80: 76 */     sql.append("RAZONSOCIAL='" + t.getRazonSocial() + "',TIPOIDENTIFICACION=" + "'" + t.getTipoIdentificacion() + "',NUMEROIDENTIFICACION=" + "'" + t.getIdentificacion() + "',CORREO=" + "'" + t.getMail() + "',PLACA=" + "'" + t.getPlaca() + "'");
/*  81: 77 */     sql.append("where CODIGO=" + t.getCodigo());
/*  82: 78 */     this.statement = this.conn.createStatement();
/*  83: 79 */     this.statement.executeUpdate(sql.toString());
/*  84: 80 */     flushDataBase();
/*  85: 81 */     cerrarConexion();
/*  86:    */   }
/*  87:    */   
/*  88:    */   private Integer getMaxCodigoTransportista()
/*  89:    */     throws SQLException, ClassNotFoundException
/*  90:    */   {
/*  91: 85 */     Constantes.cargarJDC();
/*  92: 86 */     this.conn = DriverManager.getConnection(this.url);
/*  93: 87 */     StringBuilder sql = new StringBuilder("SELECT MAX(CODIGO) as SECUENCIA FROM TRANSPORTISTAS");
/*  94: 88 */     this.statement = this.conn.createStatement();
/*  95: 89 */     this.rs = this.statement.executeQuery(sql.toString());
/*  96: 90 */     if (this.rs.next()) {
/*  97: 91 */       return Integer.valueOf(this.rs.getInt("SECUENCIA"));
/*  98:    */     }
/*  99: 93 */     return Integer.valueOf(0);
/* 100:    */   }
/* 101:    */   
/* 102:    */   private List<Transportista> listaTransportistas()
/* 103:    */     throws SQLException
/* 104:    */   {
/* 105: 97 */     List<Transportista> list = new ArrayList();
/* 106: 98 */     while (this.rs.next()) {
/* 107: 99 */       list.add(obtenerTransportista(this.rs));
/* 108:    */     }
/* 109:101 */     return list;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public Transportista obtenerTransportistaIdentificacion(String numeroIdentificacion)
/* 113:    */     throws SQLException, ClassNotFoundException
/* 114:    */   {
/* 115:104 */     Constantes.cargarJDC();
/* 116:105 */     this.conn = DriverManager.getConnection(this.url);
/* 117:106 */     StringBuilder sql = new StringBuilder("SELECT * FROM TRANSPORTISTAS WHERE 1=1");
/* 118:107 */     sql.append(" and NUMEROIDENTIFICACION= '" + numeroIdentificacion + "'");
/* 119:108 */     this.statement = this.conn.createStatement();
/* 120:109 */     this.rs = this.statement.executeQuery(sql.toString());
/* 121:110 */     return getTransportista(this.rs);
/* 122:    */   }
/* 123:    */   
/* 124:    */   private Transportista getTransportista(ResultSet rs)
/* 125:    */     throws SQLException
/* 126:    */   {
/* 127:113 */     Transportista tr = null;
/* 128:114 */     if (rs.next()) {
/* 129:115 */       tr = obtenerTransportista(rs);
/* 130:    */     }
/* 131:118 */     return tr;
/* 132:    */   }
/* 133:    */   
/* 134:    */   private Transportista obtenerTransportista(ResultSet rs)
/* 135:    */     throws SQLException
/* 136:    */   {
/* 137:121 */     Transportista t = new Transportista();
/* 138:122 */     t.setCodigo(Integer.valueOf(rs.getInt("CODIGO")));
/* 139:123 */     t.setPlaca(rs.getString("PLACA"));
/* 140:124 */     t.setTipoIdentificacion(rs.getString("TIPOIDENTIFICACION"));
/* 141:125 */     t.setIdentificacion(rs.getString("NUMEROIDENTIFICACION"));
/* 142:126 */     t.setMail(rs.getString("CORREO"));
/* 143:127 */     t.setRazonSocial(rs.getString("RAZONSOCIAL"));
/* 144:128 */     return t;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void eliminarTransportista(Transportista tra)
/* 148:    */     throws SQLException, ClassNotFoundException
/* 149:    */   {
/* 150:131 */     Constantes.cargarJDC();
/* 151:132 */     this.conn = DriverManager.getConnection(this.url);
/* 152:133 */     StringBuilder sql = new StringBuilder("DELETE FROM TRANSPORTISTAS WHERE CODIGO =" + tra.getCodigo());
/* 153:134 */     this.statement = this.conn.createStatement();
/* 154:135 */     this.statement.executeUpdate(sql.toString());
/* 155:136 */     flushDataBase();
/* 156:137 */     cerrarConexion();
/* 157:    */   }
/* 158:    */   
/* 159:    */   private void cerrarConexion()
/* 160:    */     throws SQLException
/* 161:    */   {
/* 162:141 */     this.statement.close();
/* 163:142 */     this.conn.close();
/* 164:    */   }
/* 165:    */   
/* 166:    */   private void flushDataBase()
/* 167:    */     throws SQLException
/* 168:    */   {
/* 169:146 */     this.statement = this.conn.createStatement();
/* 170:147 */     this.statement.executeUpdate("SHUTDOWN");
/* 171:    */   }
/* 172:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.TransportistaSQL
 * JD-Core Version:    0.7.0.1
 */