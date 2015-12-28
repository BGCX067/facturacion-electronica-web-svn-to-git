/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ import java.io.FileInputStream;
/*  4:   */ import java.io.FileNotFoundException;
/*  5:   */ import java.io.IOException;
/*  6:   */ import java.io.PrintStream;
/*  7:   */ import java.text.SimpleDateFormat;
/*  8:   */ import java.util.Properties;
/*  9:   */ 
/* 10:   */ public class Constantes
/* 11:   */ {
/* 12:   */   public static final String JDBC_CLASS = "org.hsqldb.jdbcDriver";
/* 13:   */   public static final String URL_CONECCION = "jdbc:hsqldb:file:";
/* 14:   */   public static final String CLIENTES_TABLE = "clientes";
/* 15:   */   public static final String TRANSPORTISTAS_TBLE = "transportistas";
/* 16:   */   public static final String EMISOR_TABLE = "emisor";
/* 17:   */   public static final String IMPUESTO_TABLE = "impuestos";
/* 18:   */   public static final String CLAVES_TABLE = "claves";
/* 19:   */   public static final String PRODUCTO_TABLE = "producto";
/* 20:   */   public static final String COMPROBANTES_TABLE = "comprobantes";
/* 21:   */   public static final String PROXY_TABLE = "PROXY";
/* 22:   */   public static final String RESPUESTA_TABLE = "respuesta";
/* 23:   */   public static final String RESOURCE_IMPUESTO_VALOR = "resources/impuesto_valor.sql";
/* 24:   */   public static final String CONFIGURACION_BD_TABLE = "configuracionBD";
/* 25:   */   public static final String CONFIGURACION_DIRECTORIOS_TABLE = "configuracionDirectorio";
/* 26:   */   public static final String IMPUESTO_SQL = "resources/impuesto.sql";
/* 27:   */   public static final String IMPUESTO_VALOR_SQl = "resources/impuesto_valor.sql";
/* 28:   */   public static final String IMPUESTO_VALOR_SQl_WIN = "resources/impuesto_valor_win.sql";
/* 29:   */   public static final String ACTUALIZAR_IMPUESTO_VALOR = "resources/actualizarImpuestoValor.sql";
/* 30:   */   public static final String ACTUALIZAR_IMPUESTO_IVA_IRBPNR = "resources/actualizarImpuestoIVA_IRBPNR.sql";
/* 31:   */   public static final String COMPROBANTES_SQL = "resources/comprobantes.sql";
/* 32:   */   public static final String VERSION = "1.0.0";
/* 33:   */   public static final String DIRECTORIO_RECHAZADOS = "rechazados";
/* 34:   */   public static final String DIRECTORIO_TRANSMITIDOS = "transmitidosSinRespuesta";
/* 35:   */   public static final String XML = ".xml";
/* 36:   */   public static final String COD_UTF8 = "UTF-8";
/* 37:   */   public static final String ID_FICTICIO_CONSUMIDOR_FINAL = "9999999999999";
/* 38:   */   public static final int LIMITE_COMP1 = 3;
/* 39:   */   public static final int LIMITE_COMP2 = 9;
/* 40:   */   public static final int LIMITE_COMP_MES = 2;
/* 41:   */   public static final int LIMITE_COMP_ANIO = 4;
/* 42:   */   public static final int LIMITE_CR_NUMDOC = 15;
/* 43:   */   public static final int LIMITE_GR_NUMAUT = 37;
/* 44:   */   public static final int LIMITE_NUEVA_LINEA = 160;
/* 45:   */   public static final int LIMITE_DOC_ADUA = 20;
/* 46:   */   public static final int LIMITE_TEXT_AREA = 300;
/* 47:   */   public static final String AUTORIDAD_CERT_NO_DISPONIBLE = "61";
/* 48:61 */   public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
/* 49:62 */   public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
/* 50:64 */   public static final Integer LONGITUD_CLAVE_CONTINGENCIA = Integer.valueOf(37);
/* 51:   */   public static final int INTENTOS_CONEXION_WS = 3;
/* 52:   */   public static final int INTENTOS_RESPUESTA_AUTORIZACION_WS = 5;
/* 53:   */   
/* 54:   */   public static void cargarJDC()
/* 55:   */     throws ClassNotFoundException
/* 56:   */   {
/* 57:69 */     Class.forName("org.hsqldb.jdbcDriver");
/* 58:   */   }
/* 59:   */   
/* 60:   */   public static String obtenerUrlBD()
/* 61:   */   {
/* 62:73 */     Properties props = new Properties();
/* 63:74 */     String home = System.getProperty("user.home");
/* 64:75 */     System.out.println(" user.home " + home);
/* 65:76 */     String urlBD = null;
/* 66:   */     try
/* 67:   */     {
/* 68:78 */       props.load(new FileInputStream(home + "/comprobantes.properties"));
/* 69:79 */       urlBD = props.getProperty("database");
/* 70:80 */       System.out.println(" obtenerUrlBD()  urlDB " + urlBD);
/* 71:   */     }
/* 72:   */     catch (FileNotFoundException ex)
/* 73:   */     {
/* 74:82 */       return null;
/* 75:   */     }
/* 76:   */     catch (IOException ex)
/* 77:   */     {
/* 78:85 */       return null;
/* 79:   */     }
/* 80:87 */     return urlBD;
/* 81:   */   }
/* 82:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.Constantes
 * JD-Core Version:    0.7.0.1
 */