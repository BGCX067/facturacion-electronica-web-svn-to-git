/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import java.io.PrintStream;
/*   4:    */ import java.text.SimpleDateFormat;
/*   5:    */ import java.util.Date;
/*   6:    */ import java.util.InputMismatchException;
/*   7:    */ 
/*   8:    */ public class ClaveDeAcceso
/*   9:    */ {
/*  10:    */   private String claveGenerada;
/*  11:    */   
/*  12:    */   public String generaClave(Date fechaEmision, String tipoComprobante, String ruc, String ambiente, String serie, String numeroComprobante, String codigoNumerico, String tipoEmision)
/*  13:    */   {
/*  14: 37 */     int verificador = 0;
/*  15: 40 */     if ((ruc != null) && (ruc.length() < 13)) {
/*  16: 41 */       ruc = String.format("%013d", new Object[] { ruc });
/*  17:    */     }
/*  18: 44 */     SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
/*  19: 45 */     String fecha = dateFormat.format(fechaEmision);
/*  20:    */     
/*  21: 47 */     StringBuilder clave = new StringBuilder(fecha);
/*  22: 48 */     clave.append(tipoComprobante);
/*  23: 49 */     clave.append(ruc);
/*  24: 50 */     clave.append(ambiente);
/*  25: 51 */     clave.append(serie);
/*  26: 52 */     clave.append(numeroComprobante);
/*  27: 53 */     clave.append(codigoNumerico);
/*  28: 54 */     clave.append(tipoEmision);
/*  29:    */     
/*  30:    */ 
/*  31: 57 */     verificador = generaDigitoModulo11(clave.toString());
/*  32:    */     
/*  33: 59 */     clave.append(Integer.valueOf(verificador));
/*  34: 60 */     this.claveGenerada = clave.toString();
/*  35: 62 */     if (clave.toString().length() != 49) {
/*  36: 63 */       this.claveGenerada = null;
/*  37:    */     }
/*  38: 65 */     return this.claveGenerada;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public String generaClaveContingencia(Date fechaEmision, String tipoComprobante, String clavesContigencia, String tipoEmision)
/*  42:    */     throws InputMismatchException
/*  43:    */   {
/*  44: 71 */     int verificador = 0;
/*  45:    */     
/*  46: 73 */     SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
/*  47: 74 */     String fecha = dateFormat.format(fechaEmision);
/*  48:    */     
/*  49: 76 */     StringBuilder clave = new StringBuilder(fecha);
/*  50: 77 */     clave.append(tipoComprobante);
/*  51: 78 */     clave.append(clavesContigencia);
/*  52: 79 */     clave.append(tipoEmision);
/*  53:    */     
/*  54:    */ 
/*  55: 82 */     verificador = generaDigitoModulo11(clave.toString());
/*  56: 85 */     if (verificador != 10)
/*  57:    */     {
/*  58: 86 */       clave.append(Integer.valueOf(verificador));
/*  59: 87 */       this.claveGenerada = clave.toString();
/*  60:    */     }
/*  61: 90 */     if (clave.toString().length() != 49) {
/*  62: 91 */       this.claveGenerada = null;
/*  63:    */     }
/*  64: 94 */     return this.claveGenerada;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public int generaDigitoModulo11(String cadena)
/*  68:    */   {
/*  69:108 */     int baseMultiplicador = 7;
/*  70:109 */     System.out.println("CADENA-->" + cadena);
/*  71:110 */     int[] aux = new int[cadena.length()];
/*  72:111 */     int multiplicador = 2;
/*  73:112 */     int total = 0;
/*  74:113 */     int verificador = 0;
/*  75:114 */     for (int i = aux.length - 1; i >= 0; i--)
/*  76:    */     {
/*  77:115 */       aux[i] = Integer.parseInt("" + cadena.charAt(i));
/*  78:116 */       aux[i] *= multiplicador;
/*  79:117 */       multiplicador++;
/*  80:118 */       if (multiplicador > baseMultiplicador) {
/*  81:119 */         multiplicador = 2;
/*  82:    */       }
/*  83:121 */       total += aux[i];
/*  84:    */     }
/*  85:124 */     if ((total == 0) || (total == 1)) {
/*  86:125 */       verificador = 0;
/*  87:    */     } else {
/*  88:127 */       verificador = 11 - total % 11 == 11 ? 0 : 11 - total % 11;
/*  89:    */     }
/*  90:131 */     if (verificador == 10) {
/*  91:132 */       verificador = 1;
/*  92:    */     }
/*  93:135 */     return verificador;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getClaveGenerada()
/*  97:    */   {
/*  98:139 */     return this.claveGenerada;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setClaveGenerada(String claveGenerada)
/* 102:    */   {
/* 103:143 */     this.claveGenerada = claveGenerada;
/* 104:    */   }
/* 105:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.ClaveDeAcceso
 * JD-Core Version:    0.7.0.1
 */