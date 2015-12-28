/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*   6:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
/*   7:    */ import java.io.PrintStream;
/*   8:    */ import java.sql.Connection;
/*   9:    */ import java.sql.DriverManager;
/*  10:    */ import java.sql.ResultSet;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.sql.Statement;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.HashMap;
/*  15:    */ import java.util.List;
/*  16:    */ import java.util.logging.Level;
/*  17:    */ import java.util.logging.Logger;
/*  18:    */ 
/*  19:    */ public class ClientesSQL
/*  20:    */ {
/*  21: 29 */   private Connection conn = null;
/*  22: 30 */   private Statement statement = null;
/*  23:    */   private ResultSet rs;
/*  24: 32 */   String url = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "clientes";
/*  25:    */   
/*  26:    */   private void coneccionBD()
/*  27:    */     throws SQLException, ClassNotFoundException
/*  28:    */   {}
/*  29:    */   
/*  30:    */   public List<Clientes> obtenerClientes(String numeroIdentificacion, String tipoIdentificacion, String razonSocial)
/*  31:    */     throws SQLException, ClassNotFoundException
/*  32:    */   {
/*  33: 38 */     Constantes.cargarJDC();
/*  34: 39 */     this.conn = DriverManager.getConnection(this.url);
/*  35: 40 */     StringBuilder sql = new StringBuilder("SELECT * FROM CLIENTES WHERE 1=1");
/*  36: 41 */     if ((numeroIdentificacion != null) && (!numeroIdentificacion.isEmpty())) {
/*  37: 42 */       sql.append(" and NUMEROIDENTIFICACION='" + numeroIdentificacion + "'");
/*  38:    */     }
/*  39: 45 */     if ((tipoIdentificacion != null) && (!tipoIdentificacion.isEmpty())) {
/*  40: 46 */       sql.append(" and TIPOIDENTIFICACION ='" + tipoIdentificacion + "'");
/*  41:    */     }
/*  42: 48 */     if ((razonSocial != null) && (!razonSocial.isEmpty())) {
/*  43: 49 */       sql.append(" and UCASE(NOMBRERAZONSOCIAL) like '%" + razonSocial.toUpperCase() + "%'");
/*  44:    */     }
/*  45: 51 */     this.statement = this.conn.createStatement();
/*  46: 52 */     this.rs = this.statement.executeQuery(sql.toString());
/*  47: 53 */     return obtenerListaClientes();
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Clientes obtenerClienteRuc(String identificacion)
/*  51:    */     throws SQLException, ClassNotFoundException
/*  52:    */   {
/*  53: 57 */     Constantes.cargarJDC();
/*  54: 58 */     this.conn = DriverManager.getConnection(this.url);
/*  55: 59 */     StringBuilder sql = new StringBuilder("SELECT * FROM CLIENTES WHERE 1=1");
/*  56: 60 */     sql.append(" and NUMEROIDENTIFICACION='" + identificacion + "'");
/*  57: 61 */     this.statement = this.conn.createStatement();
/*  58: 62 */     this.rs = this.statement.executeQuery(sql.toString());
/*  59: 63 */     return getCliente();
/*  60:    */   }
/*  61:    */   
/*  62:    */   public Clientes obtenerClientesTipo(String numeroIdentificacion, String razonSocial, TipoClienteEnum tipoClienteEnum)
/*  63:    */     throws SQLException, ClassNotFoundException
/*  64:    */   {
/*  65: 67 */     Constantes.cargarJDC();
/*  66: 68 */     this.conn = DriverManager.getConnection(this.url);
/*  67: 69 */     StringBuilder sql = new StringBuilder("SELECT * FROM CLIENTES WHERE 1=1");
/*  68: 70 */     if ((numeroIdentificacion != null) && (!numeroIdentificacion.isEmpty())) {
/*  69: 72 */       sql.append(" and UCASE(NUMEROIDENTIFICACION) like '%" + numeroIdentificacion.toUpperCase() + "%'");
/*  70:    */     }
/*  71: 74 */     if ((razonSocial != null) && (!razonSocial.isEmpty())) {
/*  72: 75 */       sql.append(" and UCASE(NOMBRERAZONSOCIAL) like '%" + razonSocial.toUpperCase() + "%'");
/*  73:    */     }
/*  74: 77 */     if (TipoClienteEnum.D.equals(tipoClienteEnum)) {
/*  75: 79 */       sql.append(" and TIPOIDENTIFICACION <> '" + TipoIdentificacionEnum.L.getCode() + "'");
/*  76:    */     }
/*  77: 81 */     sql.append(" and TIPO_CLIENTE = '" + tipoClienteEnum.getCode() + "'");
/*  78:    */     
/*  79: 83 */     this.statement = this.conn.createStatement();
/*  80: 84 */     this.rs = this.statement.executeQuery(sql.toString());
/*  81: 85 */     return getCliente();
/*  82:    */   }
/*  83:    */   
/*  84:    */   private Clientes getCliente()
/*  85:    */     throws SQLException
/*  86:    */   {
/*  87: 89 */     if (this.rs.next())
/*  88:    */     {
/*  89: 90 */       Clientes cliente = new Clientes();
/*  90: 91 */       cliente.setCodCliente(Integer.valueOf(this.rs.getInt("CODCLIENTE")));
/*  91: 92 */       cliente.setApellido(this.rs.getString("NOMBRERAZONSOCIAL"));
/*  92: 93 */       cliente.setTipoIdentificacion(this.rs.getString("TIPOIDENTIFICACION"));
/*  93: 94 */       cliente.setNumeroIdentificacio(this.rs.getString("NUMEROIDENTIFICACION"));
/*  94: 95 */       cliente.setTelefonoConvencional(this.rs.getString("TELEFONOCONVENCIONAL"));
/*  95: 96 */       cliente.setExtencion(this.rs.getString("EXTENSION"));
/*  96: 97 */       cliente.setCelular(this.rs.getString("CELULAR"));
/*  97: 98 */       cliente.setCorreo(this.rs.getString("CORREO"));
/*  98: 99 */       cliente.setDireccion(this.rs.getString("DIRECCION"));
/*  99:100 */       cliente.setTipoCliente(this.rs.getString("TIPO_CLIENTE"));
/* 100:101 */       return cliente;
/* 101:    */     }
/* 102:103 */     return null;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void crearCliente(Clientes cliente)
/* 106:    */     throws SQLException, ClassNotFoundException
/* 107:    */   {
/* 108:107 */     Constantes.cargarJDC();
/* 109:108 */     this.conn = DriverManager.getConnection(this.url);
/* 110:109 */     StringBuilder sql = new StringBuilder("INSERT INTO CLIENTES VALUES(");
/* 111:110 */     sql.append(getMaxCodigoCliente().intValue() + 1);
/* 112:111 */     sql.append(",'" + cliente.getApellido() + "'," + "'" + cliente.getTipoIdentificacion() + "',");
/* 113:112 */     sql.append("'" + cliente.getNumeroIdentificacio() + "'," + "'" + cliente.getDireccion() + "'," + "'" + cliente.getTelefonoConvencional() + "',");
/* 114:113 */     sql.append("'" + cliente.getExtencion() + "'," + "'" + cliente.getCelular() + "'," + "'" + cliente.getCorreo() + "','" + cliente.getTipoCliente() + "')");
/* 115:114 */     this.statement = this.conn.createStatement();
/* 116:115 */     this.statement.executeUpdate(sql.toString());
/* 117:116 */     flushDataBase();
/* 118:117 */     cerrarConexion();
/* 119:    */   }
/* 120:    */   
/* 121:    */   public HashMap<String, String> crearClientesMasivos(List<Clientes> clienetesList)
/* 122:    */   {
/* 123:121 */     HashMap<String, String> errores = new HashMap();
/* 124:122 */     for (Clientes cliente : clienetesList) {
/* 125:    */       try
/* 126:    */       {
/* 127:124 */         crearCliente(cliente);
/* 128:    */       }
/* 129:    */       catch (SQLException ex)
/* 130:    */       {
/* 131:126 */         if (ex.getMessage().contains("UNIQUE_RUC")) {
/* 132:127 */           errores.put(cliente.getNumeroIdentificacio(), "Ya existe el número de identificación " + cliente.getNumeroIdentificacio() + " con el mismo tipo de cliente");
/* 133:    */         }
/* 134:129 */         Logger.getLogger(ClientesSQL.class.getName()).log(Level.SEVERE, null, ex);
/* 135:    */       }
/* 136:    */       catch (ClassNotFoundException ex)
/* 137:    */       {
/* 138:131 */         Logger.getLogger(ClientesSQL.class.getName()).log(Level.SEVERE, null, ex);
/* 139:    */       }
/* 140:    */     }
/* 141:135 */     return errores;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void actualizarCliente(Clientes cliente)
/* 145:    */     throws SQLException, ClassNotFoundException
/* 146:    */   {
/* 147:139 */     System.out.println("SQL CLIENTE ");
/* 148:140 */     Constantes.cargarJDC();
/* 149:141 */     this.conn = DriverManager.getConnection(this.url);
/* 150:142 */     StringBuilder sql = new StringBuilder("UPDATE  CLIENTES SET ");
/* 151:143 */     sql.append("CODCLIENTE='" + cliente.getCodCliente() + "',");
/* 152:144 */     sql.append("NOMBRERAZONSOCIAL='" + cliente.getApellido() + "'," + "TIPOIDENTIFICACION=" + "'" + cliente.getTipoIdentificacion() + "',");
/* 153:145 */     sql.append("NUMEROIDENTIFICACION='" + cliente.getNumeroIdentificacio() + "'," + "DIRECCION=" + "'" + cliente.getDireccion() + "'," + "TELEFONOCONVENCIONAL=" + "'" + cliente.getTelefonoConvencional() + "',");
/* 154:146 */     sql.append("EXTENSION='" + cliente.getExtencion() + "'," + "CELULAR=" + "'" + cliente.getCelular() + "'," + "CORREO=" + "'" + cliente.getCorreo() + "',TIPO_CLIENTE='" + cliente.getTipoCliente() + "'");
/* 155:147 */     sql.append("where CODCLIENTE =" + cliente.getCodCliente());
/* 156:148 */     this.statement = this.conn.createStatement();
/* 157:149 */     this.statement.executeUpdate(sql.toString());
/* 158:150 */     cerrarConexion();
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void eliminarCliente(Clientes cliente)
/* 162:    */     throws SQLException, ClassNotFoundException
/* 163:    */   {
/* 164:154 */     Constantes.cargarJDC();
/* 165:155 */     this.conn = DriverManager.getConnection(this.url);
/* 166:156 */     StringBuilder sql = new StringBuilder("DELETE FROM CLIENTES WHERE CODCLIENTE =" + cliente.getCodCliente());
/* 167:157 */     this.statement = this.conn.createStatement();
/* 168:158 */     this.statement.executeUpdate(sql.toString());
/* 169:159 */     flushDataBase();
/* 170:160 */     cerrarConexion();
/* 171:    */   }
/* 172:    */   
/* 173:    */   private Integer getMaxCodigoCliente()
/* 174:    */     throws SQLException, ClassNotFoundException
/* 175:    */   {
/* 176:164 */     Constantes.cargarJDC();
/* 177:165 */     this.conn = DriverManager.getConnection(this.url);
/* 178:166 */     StringBuilder sql = new StringBuilder("SELECT MAX(CODCLIENTE) as SECUENCIA FROM CLIENTES");
/* 179:167 */     this.statement = this.conn.createStatement();
/* 180:168 */     this.rs = this.statement.executeQuery(sql.toString());
/* 181:169 */     if (this.rs.next()) {
/* 182:170 */       return Integer.valueOf(this.rs.getInt("SECUENCIA"));
/* 183:    */     }
/* 184:172 */     return Integer.valueOf(0);
/* 185:    */   }
/* 186:    */   
/* 187:    */   private void cerrarConexion()
/* 188:    */     throws SQLException
/* 189:    */   {
/* 190:176 */     this.statement.close();
/* 191:177 */     this.conn.close();
/* 192:    */   }
/* 193:    */   
/* 194:    */   private void flushDataBase()
/* 195:    */     throws SQLException
/* 196:    */   {
/* 197:181 */     this.statement = this.conn.createStatement();
/* 198:182 */     this.statement.executeUpdate("SHUTDOWN");
/* 199:    */   }
/* 200:    */   
/* 201:    */   private List<Clientes> obtenerListaClientes()
/* 202:    */     throws SQLException
/* 203:    */   {
/* 204:190 */     List<Clientes> clientes = new ArrayList();
/* 205:191 */     while (this.rs.next())
/* 206:    */     {
/* 207:192 */       Clientes cliente = new Clientes();
/* 208:193 */       cliente.setCodCliente(Integer.valueOf(this.rs.getInt("CODCLIENTE")));
/* 209:194 */       cliente.setApellido(this.rs.getString("NOMBRERAZONSOCIAL"));
/* 210:195 */       cliente.setTipoIdentificacion(this.rs.getString("TIPOIDENTIFICACION"));
/* 211:196 */       cliente.setNumeroIdentificacio(this.rs.getString("NUMEROIDENTIFICACION"));
/* 212:197 */       cliente.setTelefonoConvencional(this.rs.getString("TELEFONOCONVENCIONAL"));
/* 213:198 */       cliente.setExtencion(this.rs.getString("EXTENSION"));
/* 214:199 */       cliente.setCelular(this.rs.getString("CELULAR"));
/* 215:200 */       cliente.setCorreo(this.rs.getString("CORREO"));
/* 216:201 */       cliente.setDireccion(this.rs.getString("DIRECCION"));
/* 217:202 */       cliente.setTipoCliente(this.rs.getString("TIPO_CLIENTE"));
/* 218:203 */       clientes.add(cliente);
/* 219:    */     }
/* 220:205 */     return clientes;
/* 221:    */   }
/* 222:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ClientesSQL
 * JD-Core Version:    0.7.0.1
 */