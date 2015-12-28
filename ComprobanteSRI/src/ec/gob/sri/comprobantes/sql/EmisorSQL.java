/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ 
/*  11:    */ public class EmisorSQL
/*  12:    */ {
/*  13: 21 */   private Connection conn = null;
/*  14: 22 */   private Statement statement = null;
/*  15:    */   private ResultSet rs;
/*  16:    */   private String url;
/*  17:    */   
/*  18:    */   public EmisorSQL()
/*  19:    */   {
/*  20: 28 */     this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "emisor");
/*  21:    */   }
/*  22:    */   
/*  23:    */   private void crear(Emisor em)
/*  24:    */     throws SQLException, ClassNotFoundException
/*  25:    */   {
/*  26: 33 */     Constantes.cargarJDC();
/*  27: 34 */     this.conn = DriverManager.getConnection(this.url);
/*  28: 35 */     String values = getInsertValues(em);
/*  29: 36 */     StringBuilder sql = new StringBuilder("INSERT INTO EMISOR VALUES(");
/*  30: 37 */     sql.append(values);
/*  31: 38 */     this.statement = this.conn.createStatement();
/*  32: 39 */     this.statement.executeUpdate(sql.toString());
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void crearEmisor(Emisor em)
/*  36:    */     throws SQLException, ClassNotFoundException
/*  37:    */   {
/*  38: 43 */     if (obtenerDatosEmisor() == null)
/*  39:    */     {
/*  40: 44 */       crear(em);
/*  41:    */     }
/*  42:    */     else
/*  43:    */     {
/*  44: 46 */       eliminarEmisor();
/*  45: 47 */       crear(em);
/*  46:    */     }
/*  47: 49 */     flushDataBase();
/*  48: 50 */     cerrarConexion();
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void eliminarEmisor()
/*  52:    */     throws SQLException, ClassNotFoundException
/*  53:    */   {
/*  54: 54 */     Constantes.cargarJDC();
/*  55: 55 */     this.conn = DriverManager.getConnection(this.url);
/*  56: 56 */     StringBuilder sql = new StringBuilder("DELETE FROM EMISOR");
/*  57: 57 */     this.statement = this.conn.createStatement();
/*  58: 58 */     this.statement.executeUpdate(sql.toString());
/*  59:    */   }
/*  60:    */   
/*  61:    */   public Emisor obtenerDatosEmisor()
/*  62:    */     throws SQLException, ClassNotFoundException
/*  63:    */   {
/*  64: 62 */     if (Constantes.obtenerUrlBD() != null)
/*  65:    */     {
/*  66: 63 */       Constantes.cargarJDC();
/*  67: 64 */       this.conn = DriverManager.getConnection(this.url);
/*  68: 65 */       StringBuilder sql = new StringBuilder("select * from EMISOR");
/*  69: 66 */       this.statement = this.conn.createStatement();
/*  70: 67 */       this.rs = this.statement.executeQuery(sql.toString());
/*  71: 68 */       return getEmisor();
/*  72:    */     }
/*  73: 70 */     return null;
/*  74:    */   }
/*  75:    */   
/*  76:    */   private Emisor getEmisor()
/*  77:    */     throws SQLException
/*  78:    */   {
/*  79: 74 */     Emisor emi = null;
/*  80: 75 */     if (this.rs.next())
/*  81:    */     {
/*  82: 76 */       emi = new Emisor();
/*  83: 77 */       emi.setCodigo(Integer.valueOf(this.rs.getInt("CODIGO")));
/*  84: 78 */       emi.setRazonSocial(this.rs.getString("RAZONSOCIAL"));
/*  85: 79 */       emi.setRuc(this.rs.getString("RUC"));
/*  86: 80 */       emi.setNombreComercial(this.rs.getString("NOMCOMERCIAL"));
/*  87: 81 */       emi.setDirEstablecimiento(this.rs.getString("DIRESTABLECIMIENTO"));
/*  88: 82 */       emi.setCodigoEstablecimiento(this.rs.getString("CODESTABLECIMIENTO"));
/*  89: 83 */       emi.setNumeroResolusion(this.rs.getString("RESOLUSION"));
/*  90: 84 */       emi.setContribuyenteEspecial(this.rs.getString("CONTRIBUYENTEESPECIAL"));
/*  91: 85 */       emi.setCodPuntoEmision(this.rs.getString("CODPINTOEMISION"));
/*  92: 86 */       emi.setLlevaContabilidad(this.rs.getString("LLEVACONTABILIDAD"));
/*  93: 87 */       emi.setPathLogo(this.rs.getString("LOGOIMAGEN"));
/*  94: 88 */       emi.setTipoEmision(this.rs.getString("TIPOEMISION"));
/*  95: 89 */       emi.setTiempoEspera(Integer.valueOf(this.rs.getInt("TIEMPOESPERA")));
/*  96: 90 */       emi.setTipoAmbiente(this.rs.getString("TIPO_AMBIENTE"));
/*  97: 91 */       emi.setClaveInterna(this.rs.getString("CLAVE_INTERNA"));
/*  98: 92 */       emi.setDireccionMatriz(this.rs.getString("DIRECCION_MATRIZ"));
/*  99: 93 */       emi.setToken(this.rs.getString("TOKEN"));
/* 100: 94 */       return emi;
/* 101:    */     }
/* 102: 96 */     return emi;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void actualizarImagen(String imagen)
/* 106:    */     throws SQLException, ClassNotFoundException
/* 107:    */   {
/* 108:100 */     Constantes.cargarJDC();
/* 109:101 */     this.conn = DriverManager.getConnection(this.url);
/* 110:102 */     StringBuilder sql = new StringBuilder("UPDATE  EMISOR SET LOGOIMAGEN='" + imagen + "'");
/* 111:103 */     this.statement = this.conn.createStatement();
/* 112:104 */     this.statement.executeUpdate(sql.toString());
/* 113:105 */     cerrarConexion();
/* 114:    */   }
/* 115:    */   
/* 116:    */   private String getInsertValues(Emisor em)
/* 117:    */   {
/* 118:110 */     String insertValues = em.getCodigo() + ",'" + em.getRazonSocial() + "','" + em.getRuc() + "','" + em.getNombreComercial() + "','" + em.getDirEstablecimiento() + "','" + em.getCodigoEstablecimiento() + "','" + em.getNumeroResolusion() + "','" + em.getContribuyenteEspecial() + "','" + em.getCodPuntoEmision() + "','" + em.getLlevaContabilidad() + "','" + em.getPathLogo() + "','" + em.getTipoEmision() + "'," + em.getTiempoEspera() + ",'" + em.getClaveInterna() + "','" + em.getTipoAmbiente() + "','" + em.getDireccionMatriz() + "','" + em.getToken() + "')";
/* 119:    */     
/* 120:    */ 
/* 121:    */ 
/* 122:114 */     return insertValues;
/* 123:    */   }
/* 124:    */   
/* 125:    */   private void cerrarConexion()
/* 126:    */     throws SQLException
/* 127:    */   {
/* 128:118 */     this.statement.close();
/* 129:119 */     this.conn.close();
/* 130:    */   }
/* 131:    */   
/* 132:    */   private void flushDataBase()
/* 133:    */     throws SQLException
/* 134:    */   {
/* 135:123 */     this.statement = this.conn.createStatement();
/* 136:124 */     this.statement.executeUpdate("SHUTDOWN");
/* 137:    */   }
/* 138:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.EmisorSQL
 * JD-Core Version:    0.7.0.1
 */