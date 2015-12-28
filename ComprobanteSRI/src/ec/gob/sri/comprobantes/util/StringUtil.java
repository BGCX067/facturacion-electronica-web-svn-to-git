/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import java.util.regex.Matcher;
/*   4:    */ import java.util.regex.Pattern;
/*   5:    */ import javax.swing.JTextField;
/*   6:    */ import javax.swing.text.AbstractDocument;
/*   7:    */ 
/*   8:    */ public class StringUtil
/*   9:    */ {
/*  10:    */   public static boolean validateEmail(String email)
/*  11:    */   {
/*  12: 19 */     Pattern p = Pattern.compile("[a-zA-Z0-9]+[.[a-zA-Z0-9_-]+]*@[a-z0-9][\\w\\.-]*[a-z0-9]\\.[a-z][a-z\\.]*[a-z]$");
/*  13: 20 */     Matcher m = p.matcher(email);
/*  14: 21 */     return m.matches();
/*  15:    */   }
/*  16:    */   
/*  17:    */   public static String getTipoIdentificacion(String tipoIddentificacion)
/*  18:    */   {
/*  19: 25 */     if (tipoIddentificacion.equals("TODOS")) {
/*  20: 26 */       return null;
/*  21:    */     }
/*  22: 28 */     return TipoIdentificacionEnum.obtenerTipoIdentificacionEnumPorDescripcion(tipoIddentificacion).getCode();
/*  23:    */   }
/*  24:    */   
/*  25:    */   public static String getSlectedItem(String tipoIddentificacion)
/*  26:    */   {
/*  27: 33 */     return TipoIdentificacionEnum.obtenerTipoIdentificacionEnumPorCodigo(tipoIddentificacion).getDescripcion();
/*  28:    */   }
/*  29:    */   
/*  30:    */   public static String getSlectedItemTipoProducto(String tipoIddentificacion)
/*  31:    */   {
/*  32: 37 */     if (tipoIddentificacion.equals("B")) {
/*  33: 38 */       return "BIEN";
/*  34:    */     }
/*  35: 40 */     if (tipoIddentificacion.equals("S")) {
/*  36: 41 */       return "SERVICIO";
/*  37:    */     }
/*  38: 43 */     return null;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public static String getTipoProducto(String tipoProducto)
/*  42:    */   {
/*  43: 47 */     if (tipoProducto.equals("BIEN")) {
/*  44: 48 */       return "B";
/*  45:    */     }
/*  46: 50 */     if (tipoProducto.equals("SERVICIO")) {
/*  47: 51 */       return "S";
/*  48:    */     }
/*  49: 53 */     return null;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public static String getSelectedTipoAmbiente(String tipoIddentificacion)
/*  53:    */   {
/*  54: 57 */     if (tipoIddentificacion.equals("2")) {
/*  55: 58 */       return "PRODUCCION";
/*  56:    */     }
/*  57: 60 */     if (tipoIddentificacion.equals("1")) {
/*  58: 61 */       return "PRUEBAS";
/*  59:    */     }
/*  60: 63 */     return null;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public static void convertirMayusculas(JTextField field)
/*  64:    */   {
/*  65: 67 */     ConvertirMayusculas filter = new ConvertirMayusculas();
/*  66: 68 */     ((AbstractDocument)field.getDocument()).setDocumentFilter(filter);
/*  67:    */   }
/*  68:    */   
/*  69:    */   public static void convertirMinusculas(JTextField field)
/*  70:    */   {
/*  71: 72 */     ConvertirMinusculas filter = new ConvertirMinusculas();
/*  72: 73 */     ((AbstractDocument)field.getDocument()).setDocumentFilter(filter);
/*  73:    */   }
/*  74:    */   
/*  75:    */   public static String obtenerTipoEmision(String valorCombo)
/*  76:    */   {
/*  77: 77 */     if (valorCombo.equalsIgnoreCase("NORMAL")) {
/*  78: 78 */       return "1";
/*  79:    */     }
/*  80: 80 */     if (valorCombo.equalsIgnoreCase("INDISPONIBILIDAD DE SISTEMA")) {
/*  81: 81 */       return "2";
/*  82:    */     }
/*  83: 83 */     return null;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public static String obtenerNumeroTipoEmision(String tipoEmision)
/*  87:    */   {
/*  88: 87 */     if (tipoEmision.equalsIgnoreCase("1")) {
/*  89: 88 */       return "NORMAL";
/*  90:    */     }
/*  91: 90 */     if (tipoEmision.equalsIgnoreCase("3")) {
/*  92: 91 */       return "BAJA CONECTIVIDAD";
/*  93:    */     }
/*  94: 93 */     if (tipoEmision.equalsIgnoreCase("2")) {
/*  95: 94 */       return "INDISPONIBILIDAD DE SISTEMA";
/*  96:    */     }
/*  97: 96 */     return null;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public static String quitarEnters(String cadenConEnters)
/* 101:    */   {
/* 102:100 */     String cadenaSinEnters = null;
/* 103:101 */     for (int x = 0; x < cadenConEnters.length(); x++) {
/* 104:102 */       if (cadenConEnters.charAt(x) == '\t') {
/* 105:103 */         cadenaSinEnters = cadenaSinEnters + cadenConEnters.charAt(x);
/* 106:    */       }
/* 107:    */     }
/* 108:106 */     return cadenaSinEnters;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public static boolean validarExpresionRegular(String patron, String valor)
/* 112:    */   {
/* 113:110 */     if ((patron != null) && (valor != null))
/* 114:    */     {
/* 115:111 */       Pattern pattern = Pattern.compile(patron);
/* 116:112 */       Matcher matcher = pattern.matcher(valor);
/* 117:113 */       return matcher.matches();
/* 118:    */     }
/* 119:115 */     return false;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public static String obtenerDocumentoModificado(String codDoc)
/* 123:    */   {
/* 124:119 */     if ("01".equals(codDoc)) {
/* 125:120 */       return "FACTURA";
/* 126:    */     }
/* 127:122 */     if ("04".equals(codDoc)) {
/* 128:123 */       return "NOTA DE CRÉDITO";
/* 129:    */     }
/* 130:125 */     if ("05".equals(codDoc)) {
/* 131:126 */       return "NOTA DE DÉBITO";
/* 132:    */     }
/* 133:128 */     if ("06".equals(codDoc)) {
/* 134:129 */       return "GUÍA REMISIÓN";
/* 135:    */     }
/* 136:131 */     if ("07".equals(codDoc)) {
/* 137:132 */       return "COMPROBANTE DE RETENCIÓN";
/* 138:    */     }
/* 139:134 */     return null;
/* 140:    */   }
/* 141:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */