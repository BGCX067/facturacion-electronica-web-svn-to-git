/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoProducto;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*   7:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.sql.Connection;
/*  10:    */ import java.sql.DriverManager;
/*  11:    */ import java.sql.ResultSet;
/*  12:    */ import java.sql.SQLException;
/*  13:    */ import java.sql.Statement;
/*  14:    */ import java.util.ArrayList;
/*  15:    */ import java.util.List;
/*  16:    */ 
/*  17:    */ public class ProductoSQL
/*  18:    */ {
/*  19: 26 */   private Connection conn = null;
/*  20: 27 */   private Statement statement = null;
/*  21:    */   private ResultSet rs;
/*  22: 29 */   String url = "jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "producto";
/*  23:    */   
/*  24:    */   public void crearProducto(Producto producto)
/*  25:    */     throws SQLException, ClassNotFoundException
/*  26:    */   {
/*  27: 32 */     Constantes.cargarJDC();
/*  28: 33 */     this.conn = DriverManager.getConnection(this.url);
/*  29: 34 */     Integer va = Integer.valueOf(obtenerMaxCodigoProducto().intValue() + 1);
/*  30:    */     
/*  31: 36 */     StringBuilder sql = new StringBuilder("INSERT INTO PRODUCTO VALUES(" + va + ",");
/*  32: 37 */     sql.append(getInsertSQL(producto));
/*  33: 38 */     this.statement = this.conn.createStatement();
/*  34: 39 */     this.statement.executeUpdate(sql.toString());
/*  35: 40 */     producto.setCodigo(va);
/*  36: 41 */     insertInfoAdicional(producto);
/*  37: 42 */     insertProductoImpuesto(producto);
/*  38: 43 */     flushDataBase();
/*  39: 44 */     cerrarConexion();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void crearProducto(List<Producto> productos)
/*  43:    */     throws SQLException, ClassNotFoundException
/*  44:    */   {
/*  45:    */     
/*  46: 49 */     for (Producto producto : productos)
/*  47:    */     {
/*  48: 50 */       this.conn = DriverManager.getConnection(this.url);
/*  49: 51 */       Integer va = Integer.valueOf(obtenerMaxCodigoProducto().intValue() + 1);
/*  50: 52 */       StringBuilder sql = new StringBuilder("INSERT INTO PRODUCTO VALUES(" + va + ",");
/*  51: 53 */       sql.append(getInsertSQL(producto));
/*  52: 54 */       this.statement = this.conn.createStatement();
/*  53: 55 */       this.statement.executeUpdate(sql.toString());
/*  54: 56 */       producto.setCodigo(va);
/*  55:    */     }
/*  56: 58 */     flushDataBase();
/*  57: 59 */     cerrarConexion();
/*  58:    */   }
/*  59:    */   
/*  60:    */   private String getInsertSQL(Producto producto)
/*  61:    */   {
/*  62: 63 */     return "'" + producto.getCodigoPrincipal() + "','" + producto.getCodigoAuxiliar() + "','" + producto.getNombre() + "'," + producto.getValorUnitario() + ",'" + producto.getTipoProducto() + "','" + producto.getIva() + "','" + producto.getIce() + "','" + producto.getIrbpnr() + "')";
/*  63:    */   }
/*  64:    */   
/*  65:    */   public Integer obtenerMaxCodigoProducto()
/*  66:    */     throws SQLException, ClassNotFoundException
/*  67:    */   {
/*  68: 69 */     Constantes.cargarJDC();
/*  69: 70 */     this.conn = DriverManager.getConnection(this.url);
/*  70: 71 */     StringBuilder sql = new StringBuilder("SELECT MAX(CODIGO) as SECUENCIA FROM PRODUCTO");
/*  71: 72 */     this.statement = this.conn.createStatement();
/*  72: 73 */     this.rs = this.statement.executeQuery(sql.toString());
/*  73: 74 */     if (this.rs.next()) {
/*  74: 75 */       return Integer.valueOf(this.rs.getInt("SECUENCIA"));
/*  75:    */     }
/*  76: 77 */     return Integer.valueOf(0);
/*  77:    */   }
/*  78:    */   
/*  79:    */   public Integer ObtenerMaxCodigoInfoAdicional()
/*  80:    */     throws SQLException, ClassNotFoundException
/*  81:    */   {
/*  82: 81 */     Constantes.cargarJDC();
/*  83: 82 */     this.conn = DriverManager.getConnection(this.url);
/*  84: 83 */     StringBuilder sql = new StringBuilder("SELECT MAX(CODIGO) as SECUENCIA FROM INFO_ADICIONAL");
/*  85: 84 */     this.statement = this.conn.createStatement();
/*  86: 85 */     this.rs = this.statement.executeQuery(sql.toString());
/*  87: 86 */     if (this.rs.next()) {
/*  88: 87 */       return Integer.valueOf(this.rs.getInt("SECUENCIA"));
/*  89:    */     }
/*  90: 89 */     return Integer.valueOf(0);
/*  91:    */   }
/*  92:    */   
/*  93:    */   private void insertInfoAdicional(Producto producto)
/*  94:    */     throws SQLException, ClassNotFoundException
/*  95:    */   {
/*  96: 94 */     Constantes.cargarJDC();
/*  97: 95 */     this.conn = DriverManager.getConnection(this.url);
/*  98: 96 */     for (InformacionAdicionalProducto inf : producto.getInfoAdicionalList())
/*  99:    */     {
/* 100: 97 */       Integer va = Integer.valueOf(ObtenerMaxCodigoInfoAdicional().intValue() + 1);
/* 101: 98 */       StringBuilder sql = new StringBuilder("INSERT INTO INFO_ADICIONAL VALUES(" + va + ",");
/* 102: 99 */       String sentencia = producto.getCodigo() + ",'" + inf.getAtributo() + "','" + inf.getValor() + "')";
/* 103:100 */       sql.append(sentencia);
/* 104:101 */       this.statement = this.conn.createStatement();
/* 105:102 */       this.statement.executeUpdate(sql.toString());
/* 106:    */     }
/* 107:    */   }
/* 108:    */   
/* 109:    */   private void insertProductoImpuesto(Producto producto)
/* 110:    */     throws SQLException, ClassNotFoundException
/* 111:    */   {
/* 112:107 */     Constantes.cargarJDC();
/* 113:108 */     this.conn = DriverManager.getConnection(this.url);
/* 114:109 */     for (ImpuestoProducto inf : producto.getImpuestoProducto())
/* 115:    */     {
/* 116:111 */       StringBuilder sql = new StringBuilder("INSERT INTO PRODUCTO_IMPUESTO VALUES(" + producto.getCodigo() + ",'" + inf.getCodigoImpuesto() + "')");
/* 117:112 */       this.statement = this.conn.createStatement();
/* 118:113 */       this.statement.executeUpdate(sql.toString());
/* 119:    */     }
/* 120:    */   }
/* 121:    */   
/* 122:    */   public List<Producto> buscarPorParametros(String codPrincipal, String codAux, String nomProd, String tipoProd, Integer tipoImpuesto)
/* 123:    */     throws SQLException, ClassNotFoundException
/* 124:    */   {
/* 125:118 */     Constantes.cargarJDC();
/* 126:119 */     this.conn = DriverManager.getConnection(this.url);
/* 127:120 */     StringBuilder sql = new StringBuilder("SELECT * FROM PRODUCTO WHERE 1=1 ");
/* 128:121 */     sql.append(getSqlBusquedaProducto(codPrincipal, codAux, nomProd, tipoProd, tipoImpuesto));
/* 129:122 */     this.statement = this.conn.createStatement();
/* 130:123 */     this.rs = this.statement.executeQuery(sql.toString());
/* 131:124 */     List<Producto> prd = new ArrayList();
/* 132:125 */     prd = obtenerProducto();
/* 133:126 */     return prd;
/* 134:    */   }
/* 135:    */   
/* 136:    */   private List<ImpuestoProducto> obtenerImpuestoProducto(Integer p)
/* 137:    */     throws SQLException, ClassNotFoundException
/* 138:    */   {
/* 139:130 */     Constantes.cargarJDC();
/* 140:131 */     this.conn = DriverManager.getConnection(this.url);
/* 141:132 */     StringBuilder sql = new StringBuilder("SELECT * FROM PRODUCTO_IMPUESTO WHERE CODIGO_PRODUCTO=" + p);
/* 142:133 */     this.statement = this.conn.createStatement();
/* 143:134 */     this.rs = this.statement.executeQuery(sql.toString());
/* 144:135 */     return getImpuestoProducto();
/* 145:    */   }
/* 146:    */   
/* 147:    */   private List<ImpuestoProducto> getImpuestoProducto()
/* 148:    */     throws SQLException
/* 149:    */   {
/* 150:139 */     List<ImpuestoProducto> impuestoProductoList = new ArrayList();
/* 151:140 */     while (this.rs.next())
/* 152:    */     {
/* 153:141 */       ImpuestoProducto imProd = new ImpuestoProducto();
/* 154:142 */       imProd.setCodigoProducto(Integer.valueOf(this.rs.getInt("CODIGO_PRODUCTO")));
/* 155:143 */       imProd.setCodigoImpuesto(this.rs.getString("CODIGO_IMPUESTO_VALOR"));
/* 156:144 */       impuestoProductoList.add(imProd);
/* 157:    */     }
/* 158:146 */     return impuestoProductoList;
/* 159:    */   }
/* 160:    */   
/* 161:    */   private List<InformacionAdicionalProducto> obtenerInfoAdicional(Integer p)
/* 162:    */     throws SQLException, ClassNotFoundException
/* 163:    */   {
/* 164:150 */     ResultSet result = null;
/* 165:151 */     Statement prepared = null;
/* 166:152 */     Constantes.cargarJDC();
/* 167:153 */     this.conn = DriverManager.getConnection(this.url);
/* 168:154 */     StringBuilder sql = new StringBuilder("SELECT * FROM INFO_ADICIONAL WHERE CODIGO_PRODUCTO=" + p);
/* 169:155 */     prepared = this.conn.createStatement();
/* 170:156 */     result = prepared.executeQuery(sql.toString());
/* 171:157 */     return getInfoAdicional(result);
/* 172:    */   }
/* 173:    */   
/* 174:    */   private List<ImpuestoValor> obtenerImpuestoValor(Integer p)
/* 175:    */     throws ClassNotFoundException, SQLException
/* 176:    */   {
/* 177:161 */     ResultSet result = null;
/* 178:162 */     Statement prepared = null;
/* 179:163 */     Constantes.cargarJDC();
/* 180:164 */     this.conn = DriverManager.getConnection(this.url);
/* 181:165 */     StringBuilder sql = new StringBuilder("select v.* from impuesto_valor v, producto_impuesto p");
/* 182:166 */     sql.append(" where v.codigo=p.codigo_impuesto_valor");
/* 183:167 */     sql.append(" and p.codigo_producto=");
/* 184:168 */     sql.append(p);
/* 185:169 */     sql.append(" and v.tipo_impuesto in('A','I','B')");
/* 186:170 */     prepared = this.conn.createStatement();
/* 187:171 */     result = prepared.executeQuery(sql.toString());
/* 188:172 */     return getImpuestoValor(result);
/* 189:    */   }
/* 190:    */   
/* 191:    */   private List<ImpuestoValor> getImpuestoValor(ResultSet result)
/* 192:    */     throws SQLException
/* 193:    */   {
/* 194:176 */     List<ImpuestoValor> impuestoValorList = new ArrayList();
/* 195:177 */     while (result.next())
/* 196:    */     {
/* 197:178 */       ImpuestoValor impValor = new ImpuestoValor();
/* 198:179 */       impValor.setCodigo(result.getString("CODIGO"));
/* 199:180 */       impValor.setCodigoImpuesto(Integer.valueOf(result.getInt("CODIGO_IMPUESTO")));
/* 200:181 */       impValor.setPorcentaje(Double.valueOf(result.getDouble("PORCENTAJE")));
/* 201:182 */       impValor.setPorcentajeRentencion(Double.valueOf(result.getDouble("PORCENTAJE_RETENCION")));
/* 202:183 */       impValor.setTipoImpuesto(result.getString("TIPO_IMPUESTO"));
/* 203:184 */       impValor.setDescripcion(result.getString("DESCRIPCION"));
/* 204:185 */       impuestoValorList.add(impValor);
/* 205:    */     }
/* 206:187 */     return impuestoValorList;
/* 207:    */   }
/* 208:    */   
/* 209:    */   private List<InformacionAdicionalProducto> getInfoAdicional(ResultSet rs)
/* 210:    */     throws SQLException
/* 211:    */   {
/* 212:191 */     List<InformacionAdicionalProducto> listInfoAdicional = new ArrayList();
/* 213:192 */     while (rs.next())
/* 214:    */     {
/* 215:193 */       InformacionAdicionalProducto infoPro = new InformacionAdicionalProducto();
/* 216:194 */       infoPro.setCodigo(Integer.valueOf(rs.getInt("CODIGO")));
/* 217:195 */       infoPro.setCodigoProducto(Integer.valueOf(rs.getInt("CODIGO_PRODUCTO")));
/* 218:196 */       infoPro.setAtributo(rs.getString("ATRIBUTO"));
/* 219:197 */       infoPro.setValor(rs.getString("VALOR"));
/* 220:198 */       listInfoAdicional.add(infoPro);
/* 221:    */     }
/* 222:200 */     return listInfoAdicional;
/* 223:    */   }
/* 224:    */   
/* 225:    */   private String getSqlBusquedaProducto(String codPrincipal, String codAux, String nomProd, String tipoProd, Integer tipoImpuesto)
/* 226:    */   {
/* 227:204 */     String sql = "";
/* 228:205 */     if ((codPrincipal != null) && (!codPrincipal.isEmpty())) {
/* 229:206 */       sql = sql + " and UCASE(CODIGO_PRINCIPAL)=" + "'" + codPrincipal.toUpperCase() + "'";
/* 230:    */     }
/* 231:208 */     if ((codAux != null) && (!codAux.isEmpty())) {
/* 232:209 */       sql = sql + " and UCASE(CODIGO_AUXILIAR)=" + "'" + codAux.toUpperCase() + "'";
/* 233:    */     }
/* 234:211 */     if ((nomProd != null) && (!nomProd.isEmpty())) {
/* 235:212 */       sql = sql + " and UCASE(nombre) = " + "'" + nomProd.toUpperCase() + "'";
/* 236:    */     }
/* 237:214 */     if ((tipoProd != null) && (!tipoProd.isEmpty())) {
/* 238:215 */       sql = sql + " and TIPO_PRODUCTO ='" + tipoProd + "'";
/* 239:    */     }
/* 240:217 */     if ((tipoImpuesto != null) && (tipoImpuesto.intValue() == 2)) {
/* 241:218 */       sql = sql + " and IVA='S'";
/* 242:    */     }
/* 243:220 */     if ((tipoImpuesto != null) && (tipoImpuesto.intValue() == 3)) {
/* 244:221 */       sql = sql + " and ICE='S'";
/* 245:    */     }
/* 246:223 */     if ((tipoImpuesto != null) && (tipoImpuesto.intValue() == 5)) {
/* 247:224 */       sql = sql + " and IRBPNR='S'";
/* 248:    */     }
/* 249:226 */     return sql;
/* 250:    */   }
/* 251:    */   
/* 252:    */   private List<Producto> obtenerProducto()
/* 253:    */     throws SQLException, ClassNotFoundException
/* 254:    */   {
/* 255:230 */     List<Producto> productoList = new ArrayList();
/* 256:231 */     while (this.rs.next())
/* 257:    */     {
/* 258:232 */       Producto p = new Producto();
/* 259:233 */       p.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/* 260:234 */       p.setCodigoPrincipal(this.rs.getString("CODIGO_PRINCIPAL"));
/* 261:235 */       p.setCodigoAuxiliar(this.rs.getString("CODIGO_AUXILIAR"));
/* 262:236 */       p.setNombre(this.rs.getString("NOMBRE"));
/* 263:237 */       p.setValorUnitario(this.rs.getBigDecimal("VALOR_UNITARIO"));
/* 264:238 */       p.setTipoProducto(this.rs.getString("TIPO_PRODUCTO"));
/* 265:239 */       p.setIva(this.rs.getString("IVA"));
/* 266:240 */       p.setIce(this.rs.getString("ICE"));
/* 267:241 */       p.setIrbpnr(this.rs.getString("IRBPNR"));
/* 268:242 */       p.setInfoAdicionalList(obtenerInfoAdicional(p.getCodigo()));
/* 269:243 */       p.setImpuestoValor(obtenerImpuestoValor(p.getCodigo()));
/* 270:244 */       productoList.add(p);
/* 271:    */     }
/* 272:246 */     return productoList;
/* 273:    */   }
/* 274:    */   
/* 275:    */   private void deleteInfoAdicionalProducto(List<InformacionAdicionalProducto> listInfoAdicional)
/* 276:    */     throws SQLException, ClassNotFoundException
/* 277:    */   {
/* 278:250 */     Constantes.cargarJDC();
/* 279:251 */     this.conn = DriverManager.getConnection(this.url);
/* 280:252 */     for (InformacionAdicionalProducto infoAd : listInfoAdicional)
/* 281:    */     {
/* 282:253 */       StringBuilder sql = new StringBuilder("DELETE FROM INFO_ADICIONAL  WHERE CODIGO=" + infoAd.getCodigo());
/* 283:254 */       this.statement = this.conn.createStatement();
/* 284:255 */       this.statement.executeUpdate(sql.toString());
/* 285:    */     }
/* 286:    */   }
/* 287:    */   
/* 288:    */   private void deleteImpuestoProducto(List<ImpuestoProducto> impuestoProdList)
/* 289:    */     throws SQLException, ClassNotFoundException
/* 290:    */   {
/* 291:260 */     Constantes.cargarJDC();
/* 292:261 */     Constantes.cargarJDC();
/* 293:262 */     this.conn = DriverManager.getConnection(this.url);
/* 294:263 */     for (ImpuestoProducto impProd : impuestoProdList)
/* 295:    */     {
/* 296:264 */       StringBuilder sql = new StringBuilder("DELETE FROM PRODUCTO_IMPUESTO  WHERE CODIGO_PRODUCTO=" + impProd.getCodigoProducto());
/* 297:265 */       this.statement = this.conn.createStatement();
/* 298:266 */       this.statement.executeUpdate(sql.toString());
/* 299:    */     }
/* 300:    */   }
/* 301:    */   
/* 302:    */   private void executeUpdateProducto(Producto p)
/* 303:    */     throws SQLException, ClassNotFoundException
/* 304:    */   {
/* 305:272 */     Constantes.cargarJDC();
/* 306:273 */     this.conn = DriverManager.getConnection(this.url);
/* 307:274 */     StringBuilder sql = new StringBuilder("UPDATE PRODUCTO SET ");
/* 308:275 */     sql.append(getSteStatament(p));
/* 309:276 */     this.statement = this.conn.createStatement();
/* 310:277 */     this.statement.executeUpdate(sql.toString());
/* 311:    */   }
/* 312:    */   
/* 313:    */   private String getSteStatament(Producto p)
/* 314:    */   {
/* 315:283 */     String sql = "CODIGO_PRINCIPAL='" + p.getCodigoPrincipal() + "'," + "CODIGO_AUXILIAR='" + p.getCodigoAuxiliar() + "'," + "NOMBRE='" + p.getNombre() + "'," + "VALOR_UNITARIO=" + p.getValorUnitario() + "," + "TIPO_PRODUCTO='" + p.getTipoProducto() + "'," + "IVA='" + p.getIva() + "'," + "ICE='" + p.getIce() + "' where codigo=" + p.getCodigo();
/* 316:    */     
/* 317:    */ 
/* 318:286 */     return sql;
/* 319:    */   }
/* 320:    */   
/* 321:    */   public void updateProducto(Producto producto)
/* 322:    */     throws SQLException, ClassNotFoundException
/* 323:    */   {
/* 324:290 */     deleteImpuestoProducto(obtenerImpuestoProducto(producto.getCodigo()));
/* 325:291 */     deleteInfoAdicionalProducto(obtenerInfoAdicional(producto.getCodigo()));
/* 326:292 */     executeUpdateProducto(producto);
/* 327:293 */     insertInfoAdicional(producto);
/* 328:294 */     insertProductoImpuesto(producto);
/* 329:295 */     flushDataBase();
/* 330:296 */     cerrarConexion();
/* 331:    */   }
/* 332:    */   
/* 333:    */   public List<Producto> obtenerProducto(String codigoPrincipal, String codigoAuxiliar, String descripcion)
/* 334:    */     throws SQLException, ClassNotFoundException
/* 335:    */   {
/* 336:311 */     Constantes.cargarJDC();
/* 337:    */     
/* 338:313 */     this.conn = DriverManager.getConnection(this.url);
/* 339:    */     
/* 340:315 */     StringBuilder sql = new StringBuilder("SELECT * FROM PRODUCTO WHERE 1=1");
/* 341:316 */     if (codigoPrincipal != null) {
/* 342:317 */       sql.append(" and CODIGO_PRINCIPAL = '" + codigoPrincipal + "'");
/* 343:    */     }
/* 344:319 */     if (codigoAuxiliar != null) {
/* 345:320 */       sql.append(" and CODIGO_AUXILIAR = '" + codigoAuxiliar.toUpperCase() + "'");
/* 346:    */     }
/* 347:322 */     if (descripcion != null) {
/* 348:323 */       sql.append(" and NOMBRE = '" + descripcion.toUpperCase() + "'");
/* 349:    */     }
/* 350:325 */     this.statement = this.conn.createStatement();
/* 351:326 */     this.rs = this.statement.executeQuery(sql.toString());
/* 352:327 */     return listaProductos();
/* 353:    */   }
/* 354:    */   
/* 355:    */   public Producto obtenerProductoPorTipo(String codigoPrincipal, String codigoAuxiliar, String nombre, String tipoProducto)
/* 356:    */     throws SQLException, ClassNotFoundException
/* 357:    */   {
/* 358:332 */     Constantes.cargarJDC();
/* 359:    */     
/* 360:334 */     this.conn = DriverManager.getConnection(this.url);
/* 361:    */     
/* 362:336 */     String sql = "SELECT * FROM PRODUCTO WHERE 1=1";
/* 363:337 */     if (codigoPrincipal != null) {
/* 364:338 */       sql = sql + " and UCASE(CODIGO_PRINCIPAL)=" + "'" + codigoPrincipal.toUpperCase() + "'";
/* 365:    */     }
/* 366:340 */     if (codigoAuxiliar != null) {
/* 367:341 */       sql = sql + " and UCASE(CODIGO_AUXILIAR)=" + "'" + codigoAuxiliar.toUpperCase() + "'";
/* 368:    */     }
/* 369:343 */     if (nombre != null) {
/* 370:344 */       sql = sql + " and UCASE(nombre) = " + "'" + nombre.toUpperCase() + "'";
/* 371:    */     }
/* 372:346 */     if (tipoProducto != null) {
/* 373:347 */       sql = sql + " and TIPO_PRODUCTO ='" + tipoProducto + "'";
/* 374:    */     }
/* 375:349 */     this.statement = this.conn.createStatement();
/* 376:350 */     this.rs = this.statement.executeQuery(sql);
/* 377:351 */     List<Producto> listaProductos = obtenerProducto();
/* 378:352 */     if (listaProductos.isEmpty()) {
/* 379:353 */       return null;
/* 380:    */     }
/* 381:355 */     return (Producto)listaProductos.get(0);
/* 382:    */   }
/* 383:    */   
/* 384:    */   private List<Producto> listaProductos()
/* 385:    */     throws SQLException, ClassNotFoundException
/* 386:    */   {
/* 387:359 */     List<Producto> list = new ArrayList();
/* 388:360 */     while (this.rs.next())
/* 389:    */     {
/* 390:361 */       Producto p = new Producto();
/* 391:    */       
/* 392:363 */       p.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/* 393:364 */       p.setCodigoPrincipal(this.rs.getString("CODIGO_PRINCIPAL"));
/* 394:365 */       p.setCodigoAuxiliar(this.rs.getString("CODIGO_AUXILIAR"));
/* 395:366 */       p.setNombre(this.rs.getString("NOMBRE"));
/* 396:367 */       p.setValorUnitario(this.rs.getBigDecimal("VALOR_UNITARIO"));
/* 397:368 */       p.setTipoProducto(this.rs.getString("TIPO_PRODUCTO"));
/* 398:    */       
/* 399:370 */       p.setImpuestoProducto(new ProductoImpuestoSQL().obtenerImpuestoProducto(p.getCodigo()));
/* 400:371 */       p.setInfoAdicionalList(new InformacionAdicionalSQL().obtenerInformacionAdicional(p.getCodigo()));
/* 401:    */       
/* 402:373 */       list.add(p);
/* 403:    */     }
/* 404:375 */     cerrarConexion();
/* 405:376 */     return list;
/* 406:    */   }
/* 407:    */   
/* 408:    */   public void deleteProducto(String codigoPrincipal)
/* 409:    */     throws SQLException, ClassNotFoundException
/* 410:    */   {
/* 411:380 */     Producto p = obtenerProductoCodigoPrincipal(codigoPrincipal);
/* 412:381 */     if ((p.getImpuestoProducto() != null) && (!p.getImpuestoProducto().isEmpty())) {
/* 413:382 */       deleteImpuestoProducto(p.getImpuestoProducto());
/* 414:    */     }
/* 415:384 */     if ((p.getInfoAdicionalList() != null) && (!p.getInfoAdicionalList().isEmpty())) {
/* 416:385 */       deleteInfoAdicionalProducto(p.getInfoAdicionalList());
/* 417:    */     }
/* 418:387 */     deleteProductoSQL(p);
/* 419:    */   }
/* 420:    */   
/* 421:    */   private void deleteProductoSQL(Producto p)
/* 422:    */     throws SQLException, ClassNotFoundException
/* 423:    */   {
/* 424:391 */     Connection connection = null;
/* 425:392 */     Statement stat = null;
/* 426:393 */     Constantes.cargarJDC();
/* 427:394 */     connection = DriverManager.getConnection(this.url);
/* 428:    */     
/* 429:396 */     StringBuilder sql = new StringBuilder("DELETE FROM PRODUCTO  WHERE CODIGO=" + p.getCodigo());
/* 430:397 */     stat = connection.createStatement();
/* 431:398 */     stat.executeUpdate(sql.toString());
/* 432:399 */     stat.executeUpdate("SHUTDOWN");
/* 433:400 */     stat.close();
/* 434:401 */     connection.close();
/* 435:    */   }
/* 436:    */   
/* 437:    */   private Producto obtenerProductoCodigoPrincipal(String codigoPrincipal)
/* 438:    */     throws SQLException, ClassNotFoundException
/* 439:    */   {
/* 440:405 */     Connection connection = null;
/* 441:406 */     Statement stat = null;
/* 442:    */     
/* 443:408 */     Constantes.cargarJDC();
/* 444:409 */     connection = DriverManager.getConnection(this.url);
/* 445:410 */     StringBuilder sql = new StringBuilder("SELECT * FROM PRODUCTO WHERE 1=1");
/* 446:411 */     sql.append(" and CODIGO_PRINCIPAL = '" + codigoPrincipal + "'");
/* 447:412 */     stat = connection.createStatement();
/* 448:413 */     ResultSet result = stat.executeQuery(sql.toString());
/* 449:414 */     return getProducto(result);
/* 450:    */   }
/* 451:    */   
/* 452:    */   private Producto getProducto(ResultSet result)
/* 453:    */     throws SQLException, ClassNotFoundException
/* 454:    */   {
/* 455:418 */     Producto p = new Producto();
/* 456:419 */     while (result.next())
/* 457:    */     {
/* 458:420 */       p.setCodigo(Integer.valueOf(result.getInt("CODIGO")));
/* 459:421 */       p.setCodigoPrincipal(result.getString("CODIGO_PRINCIPAL"));
/* 460:422 */       p.setCodigoAuxiliar(result.getString("CODIGO_AUXILIAR"));
/* 461:423 */       p.setNombre(result.getString("NOMBRE"));
/* 462:424 */       p.setValorUnitario(result.getBigDecimal("VALOR_UNITARIO"));
/* 463:425 */       p.setTipoProducto(result.getString("TIPO_PRODUCTO"));
/* 464:426 */       System.out.println("CODIGO ....." + p.getCodigo());
/* 465:427 */       p.setImpuestoProducto(new ProductoImpuestoSQL().obtenerImpuestoProducto(p.getCodigo()));
/* 466:428 */       p.setInfoAdicionalList(new InformacionAdicionalSQL().obtenerInformacionAdicional(p.getCodigo()));
/* 467:    */     }
/* 468:430 */     return p;
/* 469:    */   }
/* 470:    */   
/* 471:    */   private void cerrarConexion()
/* 472:    */     throws SQLException
/* 473:    */   {
/* 474:434 */     this.statement.close();
/* 475:435 */     this.conn.close();
/* 476:    */   }
/* 477:    */   
/* 478:    */   private void flushDataBase()
/* 479:    */     throws SQLException
/* 480:    */   {
/* 481:439 */     this.statement = this.conn.createStatement();
/* 482:440 */     this.statement.executeUpdate("SHUTDOWN");
/* 483:    */   }
/* 484:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ProductoSQL
 * JD-Core Version:    0.7.0.1
 */