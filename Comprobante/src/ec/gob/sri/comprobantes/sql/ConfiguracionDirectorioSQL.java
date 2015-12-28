/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ 
/*  13:    */ public class ConfiguracionDirectorioSQL
/*  14:    */ {
/*  15: 23 */   private Connection conn = null;
/*  16: 24 */   private Statement statement = null;
/*  17:    */   private ResultSet rs;
/*  18:    */   private String url;
/*  19:    */   
/*  20:    */   public ConfiguracionDirectorioSQL()
/*  21:    */   {
/*  22: 29 */     this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "configuracionDirectorio");
/*  23:    */   }
/*  24:    */   
/*  25:    */   private void crear(List<ConfiguracionDirectorio> directorios)
/*  26:    */     throws ClassNotFoundException, SQLException
/*  27:    */   {
/*  28: 34 */     Constantes.cargarJDC();
/*  29: 35 */     Connection connection = DriverManager.getConnection(this.url);
/*  30: 36 */     Statement stat = connection.createStatement();
/*  31: 37 */     for (ConfiguracionDirectorio configuracionDirectorio : directorios)
/*  32:    */     {
/*  33: 38 */       String sql = "INSERT INTO CONFIGURACION_DIRECTORIO(CODIGO,PATH) VALUES (" + configuracionDirectorio.getCodigoDirectorio() + "," + "'" + configuracionDirectorio.getPath() + "')";
/*  34:    */       
/*  35: 40 */       stat.executeUpdate(sql);
/*  36:    */     }
/*  37: 42 */     stat.executeUpdate("SHUTDOWN");
/*  38: 43 */     stat.close();
/*  39: 44 */     connection.close();
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void crearDirectorios(List<ConfiguracionDirectorio> directorios)
/*  43:    */     throws ClassNotFoundException, SQLException
/*  44:    */   {
/*  45: 48 */     eliminarDirectorios();
/*  46: 49 */     crear(directorios);
/*  47:    */   }
/*  48:    */   
/*  49:    */   public Boolean hayRegistros()
/*  50:    */     throws ClassNotFoundException, SQLException
/*  51:    */   {
/*  52: 53 */     if (Constantes.obtenerUrlBD() != null)
/*  53:    */     {
/*  54: 54 */       Constantes.cargarJDC();
/*  55: 55 */       Connection connection = DriverManager.getConnection(this.url);
/*  56: 56 */       Statement stat = connection.createStatement();
/*  57: 57 */       ResultSet result = stat.executeQuery("SELECT * FROM CONFIGURACION_DIRECTORIO");
/*  58: 58 */       int i = 0;
/*  59: 59 */       if (result.next()) {
/*  60: 60 */         i++;
/*  61:    */       }
/*  62: 63 */       stat.close();
/*  63: 64 */       connection.close();
/*  64: 65 */       if (i > 0) {
/*  65: 66 */         return Boolean.valueOf(true);
/*  66:    */       }
/*  67: 68 */       return Boolean.valueOf(false);
/*  68:    */     }
/*  69: 71 */     return Boolean.valueOf(false);
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void eliminarDirectorios()
/*  73:    */     throws ClassNotFoundException, SQLException
/*  74:    */   {
/*  75: 75 */     Constantes.cargarJDC();
/*  76: 76 */     Connection connection = DriverManager.getConnection(this.url);
/*  77: 77 */     Statement stat = connection.createStatement();
/*  78: 78 */     stat.executeUpdate("DELETE FROM CONFIGURACION_DIRECTORIO");
/*  79: 79 */     stat.executeUpdate("SHUTDOWN");
/*  80: 80 */     stat.close();
/*  81: 81 */     connection.close();
/*  82:    */   }
/*  83:    */   
/*  84:    */   private void cerrarConexion()
/*  85:    */     throws SQLException
/*  86:    */   {
/*  87: 85 */     this.statement.close();
/*  88: 86 */     this.conn.close();
/*  89:    */   }
/*  90:    */   
/*  91:    */   public ConfiguracionDirectorio obtenerDirectorio(int directorio)
/*  92:    */     throws SQLException, ClassNotFoundException
/*  93:    */   {
/*  94:107 */     if (Constantes.obtenerUrlBD() != null)
/*  95:    */     {
/*  96:108 */       Constantes.cargarJDC();
/*  97:109 */       this.conn = DriverManager.getConnection(this.url);
/*  98:110 */       StringBuilder sql = new StringBuilder("select * from CONFIGURACION_DIRECTORIO where 1=1 and ");
/*  99:111 */       sql.append("CODIGO = ");
/* 100:112 */       sql.append(directorio);
/* 101:    */       
/* 102:114 */       this.statement = this.conn.createStatement();
/* 103:115 */       this.rs = this.statement.executeQuery(sql.toString());
/* 104:116 */       return getDirectorio();
/* 105:    */     }
/* 106:118 */     return null;
/* 107:    */   }
/* 108:    */   
/* 109:    */   private ConfiguracionDirectorio getDirectorio()
/* 110:    */     throws SQLException
/* 111:    */   {
/* 112:128 */     ConfiguracionDirectorio dir = null;
/* 113:129 */     if (this.rs.next())
/* 114:    */     {
/* 115:130 */       dir = new ConfiguracionDirectorio();
/* 116:131 */       dir.setCodigoDirectorio(Integer.valueOf(Integer.valueOf(this.rs.getInt("CODIGO")).intValue()));
/* 117:132 */       dir.setPath(this.rs.getString("PATH"));
/* 118:133 */       return dir;
/* 119:    */     }
/* 120:135 */     return dir;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public List<ConfiguracionDirectorio> obtenerTodosDirectorios()
/* 124:    */     throws SQLException, ClassNotFoundException
/* 125:    */   {
/* 126:139 */     if (Constantes.obtenerUrlBD() != null)
/* 127:    */     {
/* 128:140 */       Constantes.cargarJDC();
/* 129:141 */       this.conn = DriverManager.getConnection(this.url);
/* 130:142 */       StringBuilder sql = new StringBuilder("select * from CONFIGURACION_DIRECTORIO where 1=1 ");
/* 131:143 */       this.statement = this.conn.createStatement();
/* 132:144 */       this.rs = this.statement.executeQuery(sql.toString());
/* 133:145 */       return obtenerDirectoriosList();
/* 134:    */     }
/* 135:147 */     return null;
/* 136:    */   }
/* 137:    */   
/* 138:    */   private List<ConfiguracionDirectorio> obtenerDirectoriosList()
/* 139:    */     throws SQLException, ClassNotFoundException
/* 140:    */   {
/* 141:151 */     List<ConfiguracionDirectorio> directorios = new ArrayList();
/* 142:152 */     while (this.rs.next())
/* 143:    */     {
/* 144:153 */       ConfiguracionDirectorio directorio = new ConfiguracionDirectorio();
/* 145:154 */       directorio.setCodigoDirectorio(new Integer(this.rs.getInt("CODIGO")));
/* 146:155 */       directorio.setPath(this.rs.getString("PATH"));
/* 147:156 */       directorios.add(directorio);
/* 148:    */     }
/* 149:158 */     return directorios;
/* 150:    */   }
/* 151:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL
 * JD-Core Version:    0.7.0.1
 */