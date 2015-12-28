/*   1:    */ package ec.gob.sri.common.comprobantes.conexion;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   4:    */ import java.io.BufferedReader;
/*   5:    */ import java.io.File;
/*   6:    */ import java.io.FileNotFoundException;
/*   7:    */ import java.io.FileReader;
/*   8:    */ import java.io.IOException;
/*   9:    */ import java.io.PrintStream;
/*  10:    */ import java.sql.Connection;
/*  11:    */ import java.sql.DriverManager;
/*  12:    */ import java.sql.SQLException;
/*  13:    */ import java.sql.Statement;
/*  14:    */ import java.util.logging.Level;
/*  15:    */ import java.util.logging.Logger;
/*  16:    */ 
/*  17:    */ public class ConexionBD
/*  18:    */ {
/*  19: 18 */   private Connection conn = null;
/*  20: 19 */   private Statement statement = null;
/*  21:    */   
/*  22:    */   public void crearBaseDatos(String directorioBD)
/*  23:    */     throws SQLException, ClassNotFoundException
/*  24:    */   {
/*  25: 22 */     crearBD(directorioBD);
/*  26: 23 */     crearTableDirectorio(directorioBD);
/*  27: 24 */     crearTableCliente(directorioBD);
/*  28: 25 */     crearTablaTransportista(directorioBD);
/*  29: 26 */     crearTablaImpuestos(directorioBD);
/*  30: 27 */     cargarImpuestos(directorioBD, "resources/impuesto.sql");
/*  31: 28 */     crearTablaProducto(directorioBD);
/*  32: 29 */     crearTablaValorImpuestos(directorioBD);
/*  33: 30 */     crearTablaClaveContingencia(directorioBD);
/*  34: 31 */     crearTablaProductoImpuesto(directorioBD);
/*  35: 32 */     crearTablaInfoAdicional(directorioBD);
/*  36: 33 */     crearTablaEmisor(directorioBD);
/*  37: 34 */     crearTableComprobantes(directorioBD);
/*  38: 35 */     cargarComprobantes(directorioBD, "resources/comprobantes.sql");
/*  39: 36 */     String osName = System.getProperty("os.name");
/*  40: 37 */     System.out.println("OS NAME: " + System.getProperty("os.name"));
/*  41: 38 */     if (osName.toLowerCase().contains("win")) {
/*  42: 39 */       cargarImpuestos(directorioBD, "resources/impuesto_valor_win.sql");
/*  43:    */     } else {
/*  44: 41 */       cargarImpuestos(directorioBD, "resources/impuesto_valor.sql");
/*  45:    */     }
/*  46: 43 */     crearTablaProxy(directorioBD);
/*  47: 44 */     crearTablaRespuesta(directorioBD);
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void actualizarBaseDatos(String directorioBD)
/*  51:    */     throws SQLException, ClassNotFoundException
/*  52:    */   {
/*  53: 48 */     String rutaTablaProducto = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "producto";
/*  54: 49 */     leerArchivo(rutaTablaProducto, "resources/actualizarImpuestoValor.sql");
/*  55: 50 */     leerArchivo(rutaTablaProducto, "resources/actualizarImpuestoIVA_IRBPNR.sql");
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void cambiarBaseDatos(String directorioBD)
/*  59:    */     throws SQLException, ClassNotFoundException
/*  60:    */   {
/*  61: 54 */     String sql = "UPDATE  BASE_DATOS SET PATH_BD='" + directorioBD + "'";
/*  62: 55 */     String url = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "configuracionBD";
/*  63: 56 */     ejecutarSql(url, sql);
/*  64:    */   }
/*  65:    */   
/*  66:    */   private void crearBD(String nombreTabla)
/*  67:    */     throws ClassNotFoundException, SQLException
/*  68:    */   {
/*  69: 60 */     Constantes.cargarJDC();
/*  70: 61 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "configuracionBD";
/*  71: 62 */     this.conn = DriverManager.getConnection(url);
/*  72: 63 */     String sql = "CREATE  TABLE BASE_DATOS (codigo INTEGER PRIMARY KEY, path_bd VARCHAR(50))";
/*  73: 64 */     this.statement = this.conn.createStatement();
/*  74: 65 */     this.statement.executeUpdate(sql);
/*  75: 66 */     this.statement.executeUpdate("INSERT INTO BASE_DATOS(codigo, path_bd) VALUES (1,'" + nombreTabla + "')");
/*  76: 67 */     flushDataBase();
/*  77: 68 */     cerraConexion();
/*  78:    */   }
/*  79:    */   
/*  80:    */   private void crearTableDirectorio(String nombreTabla)
/*  81:    */     throws SQLException, ClassNotFoundException
/*  82:    */   {
/*  83: 72 */     Constantes.cargarJDC();
/*  84: 73 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "configuracionDirectorio";
/*  85: 74 */     this.conn = DriverManager.getConnection(url);
/*  86: 75 */     String sql = "CREATE  TABLE CONFIGURACION_DIRECTORIO (codigo INTEGER PRIMARY KEY, path VARCHAR(100))";
/*  87: 76 */     this.statement = this.conn.createStatement();
/*  88: 77 */     this.statement.executeUpdate(sql);
/*  89: 78 */     flushDataBase();
/*  90: 79 */     cerraConexion();
/*  91:    */   }
/*  92:    */   
/*  93:    */   private void crearTableCliente(String nombreTabla)
/*  94:    */     throws SQLException, ClassNotFoundException
/*  95:    */   {
/*  96: 83 */     Constantes.cargarJDC();
/*  97: 84 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "clientes";
/*  98: 85 */     this.conn = DriverManager.getConnection(url);
/*  99: 86 */     String sql = "CREATE  TABLE CLIENTES (codCliente INTEGER PRIMARY KEY, nombreRazonSocial VARCHAR(70),tipoIdentificacion VARCHAR(1),numeroIdentificacion VARCHAR(15),direccion VARCHAR(250),telefonoConvencional VARCHAR(15),extension VARCHAR(10),celular VARCHAR(15),correo VARCHAR(2),tipo_cliente varchar(1),CONSTRAINT UNIQUE_RUC UNIQUE(numeroIdentificacion,tipo_cliente))";
/* 100: 87 */     this.statement = this.conn.createStatement();
/* 101: 88 */     this.statement.executeUpdate(sql);
/* 102: 89 */     cerraConexion();
/* 103:    */   }
/* 104:    */   
/* 105:    */   private void crearTablaTransportista(String nombreTabla)
/* 106:    */     throws SQLException, ClassNotFoundException
/* 107:    */   {
/* 108: 93 */     Constantes.cargarJDC();
/* 109: 94 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "transportistas";
/* 110: 95 */     this.conn = DriverManager.getConnection(url);
/* 111: 96 */     String sql = "CREATE  TABLE TRANSPORTISTAS (codigo INTEGER PRIMARY KEY, RazonSocial VARCHAR(70),tipoIdentificacion VARCHAR(1),numeroIdentificacion VARCHAR(15),correo VARCHAR(2),placa VARCHAR(10),CONSTRAINT UNIQUE_RUC_TRA UNIQUE(numeroIdentificacion))";
/* 112: 97 */     this.statement = this.conn.createStatement();
/* 113: 98 */     this.statement.executeUpdate(sql);
/* 114: 99 */     cerraConexion();
/* 115:    */   }
/* 116:    */   
/* 117:    */   private void crearTablaEmisor(String nombreTabla)
/* 118:    */     throws SQLException, ClassNotFoundException
/* 119:    */   {
/* 120:103 */     Constantes.cargarJDC();
/* 121:104 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "emisor";
/* 122:105 */     this.conn = DriverManager.getConnection(url);
/* 123:106 */     String sql = "CREATE  TABLE EMISOR  (codigo INTEGER PRIMARY KEY, razonSocial VARCHAR(70), RUC VARCHAR(15),nomComercial VARCHAR(100),dirEstablecimiento VARCHAR(250), codEstablecimiento VARCHAR(50),resolusion VARCHAR(25),contribuyenteEspecial VARCHAR(255), codPintoEmision VARCHAR(25),llevaContabilidad VARCHAR(1),logoImagen VARCHAR(255),tipoEmision VARCHAR(1),tiempoEspera integer,CLAVE_INTERNA VARCHAR(25),TIPO_AMBIENTE VARCHAR(1),DIRECCION_MATRIZ VARCHAR(255),TOKEN VARCHAR(30))";
/* 124:    */     
/* 125:    */ 
/* 126:109 */     this.statement = this.conn.createStatement();
/* 127:110 */     this.statement.executeUpdate(sql);
/* 128:111 */     cerraConexion();
/* 129:    */   }
/* 130:    */   
/* 131:    */   private void crearTablaClaveContingencia(String nombreTabla)
/* 132:    */     throws SQLException, ClassNotFoundException
/* 133:    */   {
/* 134:115 */     Constantes.cargarJDC();
/* 135:116 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "claves";
/* 136:117 */     this.conn = DriverManager.getConnection(url);
/* 137:118 */     String sql = "CREATE  TABLE CLAVES (codigo INTEGER PRIMARY KEY, clave VARCHAR(70), utilizada VARCHAR(1),codigoComprobante VARCHAR(100),CONSTRAINT UNIQUE_CLAVE UNIQUE(clave))";
/* 138:119 */     this.statement = this.conn.createStatement();
/* 139:120 */     this.statement.executeUpdate(sql);
/* 140:121 */     flushDataBase();
/* 141:122 */     cerraConexion();
/* 142:    */   }
/* 143:    */   
/* 144:    */   private void crearTablaProducto(String nombreTabla)
/* 145:    */     throws SQLException, ClassNotFoundException
/* 146:    */   {
/* 147:126 */     Constantes.cargarJDC();
/* 148:127 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "producto";
/* 149:128 */     this.conn = DriverManager.getConnection(url);
/* 150:129 */     String sql = "CREATE  TABLE PRODUCTO (CODIGO INTEGER PRIMARY KEY, CODIGO_PRINCIPAL VARCHAR(70), CODIGO_AUXILIAR VARCHAR(70),NOMBRE VARCHAR(100),VALOR_UNITARIO DECIMAL,TIPO_PRODUCTO VARCHAR(1),IVA VARCHAR(1),ICE VARCHAR(1),CONSTRAINT UNIQUE_CODD_PRODUCTO UNIQUE(CODIGO_PRINCIPAL))";
/* 151:130 */     this.statement = this.conn.createStatement();
/* 152:131 */     this.statement.executeUpdate(sql);
/* 153:132 */     this.statement = this.conn.createStatement();
/* 154:133 */     flushDataBase();
/* 155:134 */     cerraConexion();
/* 156:    */   }
/* 157:    */   
/* 158:    */   private void crearTablaImpuestos(String nombreTabla)
/* 159:    */     throws SQLException, ClassNotFoundException
/* 160:    */   {
/* 161:138 */     Constantes.cargarJDC();
/* 162:139 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "producto";
/* 163:140 */     this.conn = DriverManager.getConnection(url);
/* 164:141 */     String sql = "CREATE  TABLE IMPUESTO (CODIGO INTEGER PRIMARY KEY,TAIM_DES_IMP VARCHAR(255),TAIM_ESTADO VARCHAR (1))";
/* 165:142 */     this.statement = this.conn.createStatement();
/* 166:143 */     this.statement.executeUpdate(sql);
/* 167:144 */     cerraConexion();
/* 168:    */   }
/* 169:    */   
/* 170:    */   private void crearTablaValorImpuestos(String nombreTabla)
/* 171:    */     throws SQLException, ClassNotFoundException
/* 172:    */   {
/* 173:148 */     Constantes.cargarJDC();
/* 174:149 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "producto";
/* 175:150 */     this.conn = DriverManager.getConnection(url);
/* 176:151 */     String sql = "CREATE  TABLE IMPUESTO_VALOR (CODIGO VARCHAR(255) PRIMARY KEY,CODIGO_IMPUESTO INTEGER, PORCENTAJE DECIMAL,PORCENTAJE_RETENCION DECIMAL,TIPO_IMPUESTO VARCHAR(1),DESCRIPCION VARCHAR(250),FECHA_INICIO DATE,FECHA_FIN DATE, foreign key (CODIGO_IMPUESTO) references IMPUESTO(CODIGO))";
/* 177:152 */     this.statement = this.conn.createStatement();
/* 178:153 */     this.statement.executeUpdate(sql);
/* 179:154 */     cerraConexion();
/* 180:    */   }
/* 181:    */   
/* 182:    */   private void crearTablaProductoImpuesto(String nombreTabla)
/* 183:    */     throws SQLException, ClassNotFoundException
/* 184:    */   {
/* 185:158 */     Constantes.cargarJDC();
/* 186:159 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "producto";
/* 187:160 */     this.conn = DriverManager.getConnection(url);
/* 188:161 */     String sql = "CREATE TABLE PRODUCTO_IMPUESTO (CODIGO_PRODUCTO INTEGER, CODIGO_IMPUESTO_VALOR VARCHAR(255), foreign key (CODIGO_PRODUCTO) references PRODUCTO(CODIGO),foreign key (CODIGO_IMPUESTO_VALOR) references IMPUESTO_VALOR(CODIGO))";
/* 189:162 */     this.statement = this.conn.createStatement();
/* 190:163 */     this.statement.executeUpdate(sql);
/* 191:164 */     cerraConexion();
/* 192:    */   }
/* 193:    */   
/* 194:    */   private void crearTablaInfoAdicional(String nombreTabla)
/* 195:    */     throws SQLException, ClassNotFoundException
/* 196:    */   {
/* 197:168 */     Constantes.cargarJDC();
/* 198:169 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "producto";
/* 199:170 */     this.conn = DriverManager.getConnection(url);
/* 200:171 */     String sql = "CREATE TABLE INFO_ADICIONAL(CODIGO INTEGER PRIMARY KEY, CODIGO_PRODUCTO INTEGER,ATRIBUTO VARCHAR(255),VALOR VARCHAR(255),foreign key (CODIGO_PRODUCTO) references PRODUCTO(CODIGO))";
/* 201:172 */     this.statement = this.conn.createStatement();
/* 202:173 */     this.statement.executeUpdate(sql);
/* 203:174 */     flushDataBase();
/* 204:175 */     cerraConexion();
/* 205:    */   }
/* 206:    */   
/* 207:    */   private void crearTablaProxy(String nombreTabla)
/* 208:    */     throws SQLException, ClassNotFoundException
/* 209:    */   {
/* 210:179 */     Constantes.cargarJDC();
/* 211:180 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "PROXY";
/* 212:181 */     this.conn = DriverManager.getConnection(url);
/* 213:182 */     String sql = "CREATE TABLE PROXY(CODIGO INTEGER PRIMARY KEY, URL VARCHAR(255),PUERTO INTEGER,USUARIO VARCHAR(255),CLAVE VARCHAR(255),WS_PRODUCCION VARCHAR(255),WS_PRUEBAS VARCHAR(255))";
/* 214:183 */     this.statement = this.conn.createStatement();
/* 215:184 */     this.statement.executeUpdate(sql);
/* 216:185 */     flushDataBase();
/* 217:186 */     cerraConexion();
/* 218:    */   }
/* 219:    */   
/* 220:    */   private void crearTablaRespuesta(String nombreTabla)
/* 221:    */     throws SQLException, ClassNotFoundException
/* 222:    */   {
/* 223:190 */     Constantes.cargarJDC();
/* 224:191 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "respuesta";
/* 225:192 */     this.conn = DriverManager.getConnection(url);
/* 226:193 */     String sql = "CREATE TABLE RESPUESTA(CODIGO INTEGER PRIMARY KEY, CLAVE_ACCESSO VARCHAR(49), ARCHIVO VARCHAR(50), ESTADO VARCHAR(20), FECHA DATETIME)";
/* 227:194 */     this.statement = this.conn.createStatement();
/* 228:195 */     this.statement.executeUpdate(sql);
/* 229:196 */     flushDataBase();
/* 230:197 */     cerraConexion();
/* 231:    */   }
/* 232:    */   
/* 233:    */   private void crearTableComprobantes(String nombreTabla)
/* 234:    */     throws SQLException, ClassNotFoundException
/* 235:    */   {
/* 236:208 */     Constantes.cargarJDC();
/* 237:209 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "comprobantes";
/* 238:210 */     this.conn = DriverManager.getConnection(url);
/* 239:211 */     String sql = "CREATE TABLE COMPROBANTES (codigo VARCHAR(2) PRIMARY KEY, secuencial BIGINT )";
/* 240:212 */     this.statement = this.conn.createStatement();
/* 241:213 */     this.statement.executeUpdate(sql);
/* 242:214 */     cerraConexion();
/* 243:    */   }
/* 244:    */   
/* 245:    */   private void cargarComprobantes(String nombreTabla, String fileSqlName)
/* 246:    */     throws SQLException, ClassNotFoundException
/* 247:    */   {
/* 248:226 */     File f = new File(fileSqlName);
/* 249:    */     try
/* 250:    */     {
/* 251:228 */       BufferedReader entrada = new BufferedReader(new FileReader(f));
/* 252:229 */       if (f.exists())
/* 253:    */       {
/* 254:    */         String sql;
/* 255:231 */         while ((sql = entrada.readLine()) != null) {
/* 256:232 */           insertComprobante(nombreTabla, sql);
/* 257:    */         }
/* 258:    */       }
/* 259:    */     }
/* 260:    */     catch (FileNotFoundException ex)
/* 261:    */     {
/* 262:236 */       Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 263:    */     }
/* 264:    */     catch (IOException ex)
/* 265:    */     {
/* 266:238 */       Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 267:    */     }
/* 268:    */   }
/* 269:    */   
/* 270:    */   private void insertComprobante(String nombreTabla, String sql)
/* 271:    */     throws SQLException, ClassNotFoundException
/* 272:    */   {
/* 273:251 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "comprobantes";
/* 274:252 */     Constantes.cargarJDC();
/* 275:253 */     this.conn = DriverManager.getConnection(url);
/* 276:254 */     this.statement = this.conn.createStatement();
/* 277:255 */     this.statement.executeUpdate(sql);
/* 278:256 */     this.statement = this.conn.createStatement();
/* 279:257 */     this.statement.executeUpdate("SHUTDOWN");
/* 280:258 */     cerraConexion();
/* 281:    */   }
/* 282:    */   
/* 283:    */   private void cargarImpuestos(String nombreTabla, String fileSqlName)
/* 284:    */     throws SQLException, ClassNotFoundException
/* 285:    */   {
/* 286:262 */     File f = new File(fileSqlName);
/* 287:    */     try
/* 288:    */     {
/* 289:264 */       BufferedReader entrada = new BufferedReader(new FileReader(f));
/* 290:265 */       if (f.exists())
/* 291:    */       {
/* 292:    */         String sql;
/* 293:267 */         while ((sql = entrada.readLine()) != null) {
/* 294:268 */           insertProducto(nombreTabla, sql);
/* 295:    */         }
/* 296:    */       }
/* 297:    */     }
/* 298:    */     catch (FileNotFoundException ex)
/* 299:    */     {
/* 300:272 */       Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 301:    */     }
/* 302:    */     catch (IOException ex)
/* 303:    */     {
/* 304:274 */       Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 305:    */     }
/* 306:    */   }
/* 307:    */   
/* 308:    */   private void insertProducto(String nombreTabla, String sql)
/* 309:    */     throws SQLException, ClassNotFoundException
/* 310:    */   {
/* 311:279 */     String url = "jdbc:hsqldb:file:" + nombreTabla + "/" + "producto";
/* 312:280 */     Constantes.cargarJDC();
/* 313:281 */     this.conn = DriverManager.getConnection(url);
/* 314:282 */     this.statement = this.conn.createStatement();
/* 315:283 */     this.statement.executeUpdate(sql);
/* 316:284 */     this.statement = this.conn.createStatement();
/* 317:285 */     this.statement.executeUpdate("SHUTDOWN");
/* 318:286 */     cerraConexion();
/* 319:    */   }
/* 320:    */   
/* 321:    */   private void leerArchivo(String url, String fileSqlName)
/* 322:    */     throws SQLException, ClassNotFoundException
/* 323:    */   {
/* 324:290 */     File f = new File(fileSqlName);
/* 325:    */     try
/* 326:    */     {
/* 327:292 */       BufferedReader entrada = new BufferedReader(new FileReader(f));
/* 328:293 */       if (f.exists())
/* 329:    */       {
/* 330:    */         String sql;
/* 331:295 */         while ((sql = entrada.readLine()) != null) {
/* 332:296 */           ejecutarSql(url, sql);
/* 333:    */         }
/* 334:    */       }
/* 335:    */     }
/* 336:    */     catch (FileNotFoundException ex)
/* 337:    */     {
/* 338:300 */       Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 339:    */     }
/* 340:    */     catch (IOException ex)
/* 341:    */     {
/* 342:302 */       Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 343:    */     }
/* 344:    */   }
/* 345:    */   
/* 346:    */   private void ejecutarSql(String url, String sql)
/* 347:    */     throws SQLException, ClassNotFoundException
/* 348:    */   {
/* 349:307 */     Constantes.cargarJDC();
/* 350:308 */     this.conn = DriverManager.getConnection(url);
/* 351:309 */     this.statement = this.conn.createStatement();
/* 352:310 */     this.statement.executeUpdate(sql);
/* 353:311 */     this.statement = this.conn.createStatement();
/* 354:312 */     this.statement.executeUpdate("SHUTDOWN");
/* 355:313 */     cerraConexion();
/* 356:    */   }
/* 357:    */   
/* 358:    */   private void cerraConexion()
/* 359:    */     throws SQLException
/* 360:    */   {
/* 361:317 */     if ((this.statement != null) && (this.conn != null))
/* 362:    */     {
/* 363:318 */       this.statement.close();
/* 364:319 */       this.conn.close();
/* 365:    */     }
/* 366:    */   }
/* 367:    */   
/* 368:    */   private void flushDataBase()
/* 369:    */     throws SQLException
/* 370:    */   {
/* 371:324 */     this.statement = this.conn.createStatement();
/* 372:325 */     this.statement.executeUpdate("SHUTDOWN");
/* 373:    */   }
/* 374:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.common.comprobantes.conexion.ConexionBD
 * JD-Core Version:    0.7.0.1
 */