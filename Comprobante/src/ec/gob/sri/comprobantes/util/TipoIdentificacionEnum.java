/*  1:   */ package ec.gob.sri.comprobantes.util;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public enum TipoIdentificacionEnum
/*  7:   */ {
/*  8:16 */   C("CEDULA", "C", ConstantesDimensiones.LONGITUD_CEDULA, TipoCampo.NUMERICO),  R("RUC", "R", ConstantesDimensiones.LONGITUD_RUC, TipoCampo.NUMERICO),  P("PASAPORTE", "P", ConstantesDimensiones.LONGITUD_PASAPORTE, TipoCampo.TEXTO),  I("IDENTIFICACION DEL EXTERIOR", "I", ConstantesDimensiones.LONGITUD_IDENTIFICACION_EXTERIOR, TipoCampo.TEXTO),  L("PLACA", "L", ConstantesDimensiones.LONGITUD_PLACA, TipoCampo.TEXTO);
/*  9:   */   
/* 10:   */   private String code;
/* 11:   */   private String descripcion;
/* 12:   */   private Integer longitud;
/* 13:   */   private TipoCampo tipoCampo;
/* 14:   */   
/* 15:   */   private TipoIdentificacionEnum(String descripcion, String code, Integer longitud, TipoCampo tipoCampo)
/* 16:   */   {
/* 17:23 */     this.code = code;
/* 18:24 */     this.descripcion = descripcion;
/* 19:25 */     this.longitud = longitud;
/* 20:26 */     this.tipoCampo = tipoCampo;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getCode()
/* 24:   */   {
/* 25:35 */     return this.code;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String getDescripcion()
/* 29:   */   {
/* 30:39 */     return this.descripcion;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String toString()
/* 34:   */   {
/* 35:44 */     return this.descripcion;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public Integer getLongitud()
/* 39:   */   {
/* 40:48 */     return this.longitud;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setLongitud(Integer longitud)
/* 44:   */   {
/* 45:52 */     this.longitud = longitud;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public TipoCampo getTipoCampo()
/* 49:   */   {
/* 50:56 */     return this.tipoCampo;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setTipoCampo(TipoCampo tipoCampo)
/* 54:   */   {
/* 55:60 */     this.tipoCampo = tipoCampo;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public static TipoIdentificacionEnum[] obtenerTipoIdentificacionTransportista()
/* 59:   */   {
/* 60:64 */     List<TipoIdentificacionEnum> listaTipoIdentificacion = new ArrayList();
/* 61:65 */     for (TipoIdentificacionEnum tipoIdentificacionEnum : values()) {
/* 62:66 */       if (!L.equals(tipoIdentificacionEnum)) {
/* 63:67 */         listaTipoIdentificacion.add(tipoIdentificacionEnum);
/* 64:   */       }
/* 65:   */     }
/* 66:70 */     return (TipoIdentificacionEnum[])listaTipoIdentificacion.toArray(new TipoIdentificacionEnum[listaTipoIdentificacion.size()]);
/* 67:   */   }
/* 68:   */   
/* 69:   */   public static TipoIdentificacionEnum obtenerTipoIdentificacionEnumPorDescripcion(String descripcion)
/* 70:   */   {
/* 71:74 */     for (TipoIdentificacionEnum tipoIdentificacionEnum : ) {
/* 72:75 */       if (tipoIdentificacionEnum.getDescripcion().equals(descripcion)) {
/* 73:76 */         return tipoIdentificacionEnum;
/* 74:   */       }
/* 75:   */     }
/* 76:79 */     return null;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public static TipoIdentificacionEnum obtenerTipoIdentificacionEnumPorCodigo(String codigo)
/* 80:   */   {
/* 81:83 */     for (TipoIdentificacionEnum tipoIdentificacionEnum : ) {
/* 82:84 */       if (tipoIdentificacionEnum.getCode().equals(codigo)) {
/* 83:85 */         return tipoIdentificacionEnum;
/* 84:   */       }
/* 85:   */     }
/* 86:88 */     return null;
/* 87:   */   }
/* 88:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.TipoIdentificacionEnum
 * JD-Core Version:    0.7.0.1
 */