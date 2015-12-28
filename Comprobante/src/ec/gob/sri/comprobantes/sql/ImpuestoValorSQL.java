/*   1:    */ package ec.gob.sri.comprobantes.sql;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   4:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   5:    */ import java.sql.Connection;
/*   6:    */ import java.sql.DriverManager;
/*   7:    */ import java.sql.ResultSet;
/*   8:    */ import java.sql.SQLException;
/*   9:    */ import java.sql.Statement;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ 
/*  13:    */ public class ImpuestoValorSQL
/*  14:    */ {
/*  15: 23 */   private Connection conn = null;
/*  16: 24 */   private Statement statement = null;
/*  17:    */   private ResultSet rs;
/*  18: 26 */   String url = null;
/*  19:    */   
/*  20:    */   public ImpuestoValorSQL()
/*  21:    */   {
/*  22: 29 */     getStringURL();
/*  23:    */   }
/*  24:    */   
/*  25:    */   private String getStringURL()
/*  26:    */   {
/*  27: 33 */     if (Constantes.obtenerUrlBD() != null) {
/*  28: 34 */       this.url = ("jdbc:hsqldb:file:" + Constantes.obtenerUrlBD() + "/" + "producto");
/*  29:    */     }
/*  30: 36 */     return null;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public List<ImpuestoValor> obtenerValorImpuestoIVA()
/*  34:    */     throws SQLException, ClassNotFoundException
/*  35:    */   {
/*  36: 40 */     if (Constantes.obtenerUrlBD() != null)
/*  37:    */     {
/*  38: 41 */       Constantes.cargarJDC();
/*  39: 42 */       this.conn = DriverManager.getConnection(this.url);
/*  40: 43 */       StringBuilder sql = new StringBuilder("select * from impuesto_valor where codigo_impuesto=2and (TIPO_IMPUESTO='I' or TIPO_IMPUESTO='A')");
/*  41: 44 */       this.statement = this.conn.createStatement();
/*  42: 45 */       this.rs = this.statement.executeQuery(sql.toString());
/*  43: 46 */       return obtenerImpuestoValor();
/*  44:    */     }
/*  45: 48 */     return new ArrayList();
/*  46:    */   }
/*  47:    */   
/*  48:    */   public List<ImpuestoValor> obtenerValorImpuestoICE()
/*  49:    */     throws SQLException, ClassNotFoundException
/*  50:    */   {
/*  51: 52 */     if (Constantes.obtenerUrlBD() != null)
/*  52:    */     {
/*  53: 53 */       Constantes.cargarJDC();
/*  54: 54 */       this.conn = DriverManager.getConnection(this.url);
/*  55: 55 */       StringBuilder sql = new StringBuilder("select * from impuesto_valor where codigo_impuesto=3and (TIPO_IMPUESTO='I' or TIPO_IMPUESTO='A' )");
/*  56: 56 */       this.statement = this.conn.createStatement();
/*  57: 57 */       this.rs = this.statement.executeQuery(sql.toString());
/*  58: 58 */       return obtenerImpuestoValor();
/*  59:    */     }
/*  60: 60 */     return new ArrayList();
/*  61:    */   }
/*  62:    */   
/*  63:    */   public List<ImpuestoValor> obtenerValorImpuestoIRBPNR()
/*  64:    */     throws SQLException, ClassNotFoundException
/*  65:    */   {
/*  66: 64 */     if (Constantes.obtenerUrlBD() != null)
/*  67:    */     {
/*  68: 65 */       Constantes.cargarJDC();
/*  69: 66 */       this.conn = DriverManager.getConnection(this.url);
/*  70: 67 */       StringBuilder sql = new StringBuilder("select * from impuesto_valor where codigo_impuesto=5 and TIPO_IMPUESTO='B'");
/*  71: 68 */       this.statement = this.conn.createStatement();
/*  72: 69 */       this.rs = this.statement.executeQuery(sql.toString());
/*  73: 70 */       return obtenerImpuestoValor();
/*  74:    */     }
/*  75: 72 */     return new ArrayList();
/*  76:    */   }
/*  77:    */   
/*  78:    */   private List<ImpuestoValor> obtenerImpuestoValor()
/*  79:    */     throws SQLException
/*  80:    */   {
/*  81: 76 */     List<ImpuestoValor> impuestoValorList = new ArrayList();
/*  82: 77 */     while (this.rs.next())
/*  83:    */     {
/*  84: 78 */       ImpuestoValor imp = new ImpuestoValor();
/*  85: 79 */       imp.setCodigo(this.rs.getString("CODIGO"));
/*  86: 80 */       imp.setCodigoImpuesto(Integer.valueOf(this.rs.getInt("CODIGO_IMPUESTO")));
/*  87: 81 */       imp.setPorcentaje(Double.valueOf(this.rs.getDouble("PORCENTAJE")));
/*  88: 82 */       imp.setPorcentajeRentencion(Double.valueOf(this.rs.getDouble("PORCENTAJE_RETENCION")));
/*  89: 83 */       imp.setTipoImpuesto(this.rs.getString("TIPO_IMPUESTO"));
/*  90: 84 */       imp.setFechaInicio(this.rs.getDate("FECHA_INICIO"));
/*  91: 85 */       imp.setFechaFin(this.rs.getDate("FECHA_FIN"));
/*  92: 86 */       imp.setDescripcion(this.rs.getString("DESCRIPCION"));
/*  93:    */       
/*  94: 88 */       impuestoValorList.add(imp);
/*  95:    */     }
/*  96: 90 */     return impuestoValorList;
/*  97:    */   }
/*  98:    */   
/*  99:    */   private List<ImpuestoValor> obtenerImpuestoValorIVA()
/* 100:    */     throws SQLException
/* 101:    */   {
/* 102: 94 */     List<ImpuestoValor> impuestoValorList = new ArrayList();
/* 103: 95 */     while (this.rs.next())
/* 104:    */     {
/* 105: 96 */       ImpuestoValor imp = new ImpuestoValor();
/* 106: 97 */       imp.setCodigo(this.rs.getString("CODIGO_ADM"));
/* 107: 98 */       imp.setCodigoImpuesto(Integer.valueOf(this.rs.getInt("CODIGO_IMPUESTO")));
/* 108: 99 */       imp.setPorcentaje(Double.valueOf(this.rs.getDouble("PORCENTAJE")));
/* 109:100 */       imp.setPorcentajeRentencion(Double.valueOf(this.rs.getDouble("PORCENTAJE_RETENCION")));
/* 110:101 */       imp.setTipoImpuesto(this.rs.getString("TIPO_IMPUESTO"));
/* 111:102 */       imp.setFechaInicio(this.rs.getDate("FECHA_INICIO"));
/* 112:103 */       imp.setFechaFin(this.rs.getDate("FECHA_FIN"));
/* 113:104 */       imp.setDescripcion(this.rs.getString("DESCRIPCION"));
/* 114:    */       
/* 115:106 */       impuestoValorList.add(imp);
/* 116:    */     }
/* 117:108 */     return impuestoValorList;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public List<ImpuestoValor> obtenerValorImpuestoRenta()
/* 121:    */     throws SQLException, ClassNotFoundException
/* 122:    */   {
/* 123:119 */     Constantes.cargarJDC();
/* 124:120 */     this.conn = DriverManager.getConnection(this.url);
/* 125:121 */     StringBuilder sql = new StringBuilder("select * from impuesto_valor where  codigo_impuesto= 1 and TIPO_IMPUESTO='R' ");
/* 126:122 */     this.statement = this.conn.createStatement();
/* 127:123 */     this.rs = this.statement.executeQuery(sql.toString());
/* 128:124 */     return obtenerImpuestoValor();
/* 129:    */   }
/* 130:    */   
/* 131:    */   public List<ImpuestoValor> obtenerIVARetencion()
/* 132:    */     throws SQLException, ClassNotFoundException
/* 133:    */   {
/* 134:135 */     Constantes.cargarJDC();
/* 135:136 */     this.conn = DriverManager.getConnection(this.url);
/* 136:137 */     StringBuilder sql = new StringBuilder("select * from impuesto_valor where (codigo_impuesto=2 and TIPO_IMPUESTO='R') ");
/* 137:138 */     sql.append("or (codigo_impuesto= 2 and TIPO_IMPUESTO='A') order by CODIGO_ADM");
/* 138:139 */     this.statement = this.conn.createStatement();
/* 139:140 */     this.rs = this.statement.executeQuery(sql.toString());
/* 140:141 */     return obtenerImpuestoValorIVA();
/* 141:    */   }
/* 142:    */   
/* 143:    */   public ImpuestoValor obtenerValorPorCodigo(String codigo)
/* 144:    */     throws SQLException, ClassNotFoundException
/* 145:    */   {
/* 146:153 */     if (this.url != null)
/* 147:    */     {
/* 148:154 */       Constantes.cargarJDC();
/* 149:155 */       this.conn = DriverManager.getConnection(this.url);
/* 150:156 */       StringBuilder sql = new StringBuilder("select * from impuesto_valor where codigo = '");
/* 151:157 */       sql.append(codigo);
/* 152:158 */       sql.append("'");
/* 153:159 */       this.statement = this.conn.createStatement();
/* 154:160 */       this.rs = this.statement.executeQuery(sql.toString());
/* 155:161 */       List<ImpuestoValor> impuestos = obtenerImpuestoValor();
/* 156:162 */       if (!impuestos.isEmpty()) {
/* 157:163 */         return (ImpuestoValor)impuestos.get(0);
/* 158:    */       }
/* 159:165 */       return null;
/* 160:    */     }
/* 161:168 */     return null;
/* 162:    */   }
/* 163:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.sql.ImpuestoValorSQL
 * JD-Core Version:    0.7.0.1
 */