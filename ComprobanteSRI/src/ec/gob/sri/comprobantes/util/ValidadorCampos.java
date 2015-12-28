/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ import java.util.HashMap;
/*  4:   */ import java.util.List;
/*  5:   */ import java.util.Set;
/*  6:   */ import javax.swing.JComboBox;
/*  7:   */ import javax.swing.JTextField;
/*  8:   */ 
/*  9:   */ public class ValidadorCampos
/* 10:   */ {
/* 11:   */   public static String validarCampoObligatorio(HashMap<String, String> mapa)
/* 12:   */   {
/* 13:20 */     Set<String> keys = mapa.keySet();
/* 14:21 */     for (String key : keys) {
/* 15:22 */       if (validarObligatorio(key).booleanValue()) {
/* 16:23 */         return "El campo " + (String)mapa.get(key) + " es obligatorio";
/* 17:   */       }
/* 18:   */     }
/* 19:26 */     return null;
/* 20:   */   }
/* 21:   */   
/* 22:   */   private static Boolean validarObligatorio(String valor)
/* 23:   */   {
/* 24:30 */     if ((valor == null) || (valor.isEmpty())) {
/* 25:31 */       return Boolean.TRUE;
/* 26:   */     }
/* 27:33 */     return Boolean.FALSE;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public static String validarCampoLongitudDiferente(List<CampoModelo> campos)
/* 31:   */   {
/* 32:38 */     for (CampoModelo campoModelo : campos) {
/* 33:39 */       if ((campoModelo.getValor() != null) && (!campoModelo.getValor().isEmpty()) && (campoModelo.getValor().length() != campoModelo.getLongitud().intValue())) {
/* 34:40 */         return "La longitud del campo " + campoModelo.getEtiqueta() + " debe ser de " + campoModelo.getLongitud() + " caracteres";
/* 35:   */       }
/* 36:   */     }
/* 37:43 */     return null;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public static String validarCampoLongitudMayor(List<CampoModelo> campos)
/* 41:   */   {
/* 42:47 */     for (CampoModelo campoModelo : campos) {
/* 43:48 */       if ((campoModelo.getValor() != null) && (!campoModelo.getValor().isEmpty()) && (campoModelo.getValor().length() > campoModelo.getLongitud().intValue())) {
/* 44:49 */         return "La longitud máxima del campo " + campoModelo.getEtiqueta() + " es de " + campoModelo.getLongitud() + " caracteres";
/* 45:   */       }
/* 46:   */     }
/* 47:52 */     return null;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public static String validarTipoDocumento(JComboBox cbxTipoIdentificacion, JTextField txtIdentificacion)
/* 51:   */   {
/* 52:56 */     TipoIdentificacionEnum tipoIdentificacionEnum = (TipoIdentificacionEnum)cbxTipoIdentificacion.getSelectedItem();
/* 53:57 */     if ((TipoIdentificacionEnum.C.equals(tipoIdentificacionEnum)) && ((txtIdentificacion.getText().length() != TipoIdentificacionEnum.C.getLongitud().intValue()) || (!StringUtil.validarExpresionRegular("[0-9]+", txtIdentificacion.getText())))) {
/* 54:59 */       return "El número de placa debe ser menor o igual a 13 caracteres.";
/* 55:   */     }
/* 56:61 */     if ((TipoIdentificacionEnum.R.equals(tipoIdentificacionEnum)) && ((txtIdentificacion.getText().length() != TipoIdentificacionEnum.R.getLongitud().intValue()) || (!txtIdentificacion.getText().endsWith("001")) || (!StringUtil.validarExpresionRegular("[0-9]+", txtIdentificacion.getText())))) {
/* 57:65 */       return "El número de RUC ser igual a 13 caracteres numéricos y debe terminar en 001";
/* 58:   */     }
/* 59:67 */     if ((TipoIdentificacionEnum.P.equals(tipoIdentificacionEnum)) && (txtIdentificacion.getText().length() > TipoIdentificacionEnum.R.getLongitud().intValue())) {
/* 60:68 */       return "El número de pasaporte ser igual a 13 caracteres.";
/* 61:   */     }
/* 62:70 */     if ((TipoIdentificacionEnum.I.equals(tipoIdentificacionEnum)) && (txtIdentificacion.getText().length() > TipoIdentificacionEnum.I.getLongitud().intValue())) {
/* 63:72 */       return "El número de identificación del exterior debe ser menor o igual a 20 caracteres.";
/* 64:   */     }
/* 65:74 */     if ((TipoIdentificacionEnum.L.equals(tipoIdentificacionEnum)) && (txtIdentificacion.getText().length() > TipoIdentificacionEnum.L.getLongitud().intValue())) {
/* 66:76 */       return "El número de placa debe ser menor o igual a 13 caracteres.";
/* 67:   */     }
/* 68:78 */     return null;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public static Boolean validarDecimales(String valor, int numeroDecimales)
/* 72:   */   {
/* 73:84 */     String[] partesNumero = null;
/* 74:85 */     if (valor.indexOf(".") < 0) {
/* 75:86 */       return Boolean.TRUE;
/* 76:   */     }
/* 77:88 */     partesNumero = valor.split("\\.");
/* 78:89 */     return Boolean.valueOf(partesNumero[1].length() <= numeroDecimales);
/* 79:   */   }
/* 80:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ValidadorCampos
 * JD-Core Version:    0.7.0.1
 */