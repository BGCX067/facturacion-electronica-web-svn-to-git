/*   1:    */ package ec.gob.sri.comprobantes.table.model;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoProducto;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   6:    */ import ec.gob.sri.comprobantes.modelo.SubtotalImpuesto;
/*   7:    */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   8:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   9:    */ import ec.gob.sri.comprobantes.util.TipoImpuestoEnum;
/*  10:    */ import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
/*  11:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  12:    */ import java.math.BigDecimal;
/*  13:    */ import java.math.RoundingMode;
/*  14:    */ import java.sql.SQLException;
/*  15:    */ import java.util.ArrayList;
/*  16:    */ import java.util.List;
/*  17:    */ import java.util.logging.Level;
/*  18:    */ import java.util.logging.Logger;
/*  19:    */ import javax.swing.JFrame;
/*  20:    */ import javax.swing.JOptionPane;
/*  21:    */ import javax.swing.table.AbstractTableModel;
/*  22:    */ 
/*  23:    */ public class FacturaModel
/*  24:    */   extends AbstractTableModel
/*  25:    */ {
/*  26:    */   public static final int CANTIDAD = 0;
/*  27:    */   public static final int COD_PROD = 1;
/*  28:    */   public static final int CODIGO_AUXILIAR = 2;
/*  29:    */   public static final int PROD_DESC = 3;
/*  30:    */   public static final int PREC_UNIT = 4;
/*  31:    */   public static final int DESCUENTO = 5;
/*  32:    */   public static final int VAL_TOTAL = 6;
/*  33:    */   public static final int VAL_ICE = 7;
/*  34:    */   public static final int BASE_IMPONIBLE_IRBPNR = 8;
/*  35:    */   public static final int VAL_IRBPNR = 9;
/*  36:    */   public static final int ACCION = 10;
/*  37:    */   public static final int DECIMALES_IVA_PRESUNTIVO = 2;
/*  38: 49 */   private BigDecimal subtotalIva12 = BigDecimal.ZERO;
/*  39: 50 */   private BigDecimal subtotalIva0 = BigDecimal.ZERO;
/*  40: 51 */   private BigDecimal subtotalNoIva = BigDecimal.ZERO;
/*  41: 52 */   private BigDecimal subtotalICE = BigDecimal.ZERO;
/*  42: 53 */   private BigDecimal subtotalExentoIVA = BigDecimal.ZERO;
/*  43: 54 */   private BigDecimal subtotalIRBPNR = BigDecimal.ZERO;
/*  44: 55 */   private List<SubtotalImpuesto> listaIva12 = new ArrayList();
/*  45: 56 */   private List<SubtotalImpuesto> listaIva0 = new ArrayList();
/*  46: 57 */   private List<SubtotalImpuesto> listaNoIva = new ArrayList();
/*  47: 58 */   private List<SubtotalImpuesto> listaIRBPNR = new ArrayList();
/*  48: 59 */   private List<SubtotalImpuesto> listaExentoIVA = new ArrayList();
/*  49: 60 */   private List<SubtotalImpuesto> listaICE = new ArrayList();
/*  50:    */   private ArrayList<Object[]> data;
/*  51: 62 */   private String[] columnNames = { "Cantidad", "Código principal", "Código auxiliar", "Descripción", "Precio Unitario", "Descuento", "Valor Total", "Valor ICE", "B.I. IRBPNR", "Valor IRBPNR", "Acción" };
/*  52:    */   
/*  53:    */   public FacturaModel()
/*  54:    */   {
/*  55: 66 */     this.data = new ArrayList();
/*  56:    */   }
/*  57:    */   
/*  58:    */   public FacturaModel(Producto prod, Double cantidad)
/*  59:    */   {
/*  60: 70 */     Object[] p = { cantidad, prod.getCodigoPrincipal(), prod.getCodigoAuxiliar(), prod.getNombre(), prod.getValorUnitario(), BigDecimal.ZERO, new BigDecimal(prod.getValorUnitario().doubleValue() * cantidad.doubleValue()), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "" };
/*  61:    */     
/*  62:    */ 
/*  63:    */ 
/*  64: 74 */     this.data.add(p);
/*  65:    */   }
/*  66:    */   
/*  67:    */   public int getColumnCount()
/*  68:    */   {
/*  69: 78 */     return this.columnNames.length;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public int getRowCount()
/*  73:    */   {
/*  74: 82 */     return this.data.size();
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getColumnName(int col)
/*  78:    */   {
/*  79: 87 */     return this.columnNames[col];
/*  80:    */   }
/*  81:    */   
/*  82:    */   public Object getValueAt(int row, int col)
/*  83:    */   {
/*  84: 92 */     if ((col == 4) || (col == 5) || (col == 8) || (col == 9)) {
/*  85: 93 */       return convertirABigDecimal(((Object[])this.data.get(row))[col]);
/*  86:    */     }
/*  87: 94 */     if (col == 0) {
/*  88: 95 */       return convertirADouble(((Object[])this.data.get(row))[col]);
/*  89:    */     }
/*  90: 97 */     return ((Object[])this.data.get(row))[col];
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Class getColumnClass(int c)
/*  94:    */   {
/*  95:102 */     return getValueAt(0, c).getClass();
/*  96:    */   }
/*  97:    */   
/*  98:    */   public boolean isCellEditable(int row, int col)
/*  99:    */   {
/* 100:107 */     boolean resp = false;
/* 101:108 */     if ((col == 0) || (col == 4) || (col == 5) || (col == 7) || (col == 8) || (col == 9) || (col == 10)) {
/* 102:109 */       resp = true;
/* 103:    */     }
/* 104:111 */     return resp;
/* 105:    */   }
/* 106:    */   
/* 107:    */   private BigDecimal getTotal(int row)
/* 108:    */   {
/* 109:120 */     BigDecimal total = null;
/* 110:121 */     BigDecimal precio = (BigDecimal)getValueAt(row, 4);
/* 111:122 */     Double cantidad = (Double)getValueAt(row, 0);
/* 112:123 */     BigDecimal descuento = (BigDecimal)getValueAt(row, 5);
/* 113:124 */     if ((precio == null) || (cantidad == null)) {
/* 114:125 */       total = BigDecimal.ZERO;
/* 115:    */     } else {
/* 116:127 */       total = precio.multiply(new BigDecimal(cantidad.doubleValue())).subtract(descuento).setScale(2, RoundingMode.HALF_UP);
/* 117:    */     }
/* 118:129 */     return total;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public BigDecimal getTotalDescuento()
/* 122:    */   {
/* 123:139 */     BigDecimal total = BigDecimal.ZERO;
/* 124:141 */     for (int i = 0; i < this.data.size(); i++)
/* 125:    */     {
/* 126:142 */       BigDecimal parcial = getValueAt(i, 5) == null ? BigDecimal.ZERO : (BigDecimal)getValueAt(i, 5);
/* 127:143 */       total = total.add(parcial);
/* 128:    */     }
/* 129:145 */     return total;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setValueAt(Object value, int row, int col)
/* 133:    */   {
/* 134:150 */     if (this.data.isEmpty()) {
/* 135:151 */       return;
/* 136:    */     }
/* 137:153 */     if (this.data.size() == row) {
/* 138:154 */       row--;
/* 139:    */     }
/* 140:156 */     String codigoPrincipal = (String)getValueAt(row, 1);
/* 141:157 */     String codigoAuxiliar = (String)getValueAt(row, 2);
/* 142:158 */     String descripcion = (String)getValueAt(row, 3);
/* 143:159 */     Producto prod = null;
/* 144:    */     try
/* 145:    */     {
/* 146:161 */       prod = (Producto)new ProductoSQL().obtenerProducto(codigoPrincipal, codigoAuxiliar, descripcion).get(0);
/* 147:    */     }
/* 148:    */     catch (Exception ex)
/* 149:    */     {
/* 150:163 */       Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 151:    */     }
/* 152:166 */     if (col == 0)
/* 153:    */     {
/* 154:167 */       Double newCantidad = null;
/* 155:    */       try
/* 156:    */       {
/* 157:169 */         newCantidad = Double.valueOf(Double.parseDouble(value.toString()));
/* 158:    */       }
/* 159:    */       catch (NumberFormatException ex)
/* 160:    */       {
/* 161:171 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 162:    */         
/* 163:173 */         return;
/* 164:    */       }
/* 165:175 */       if (!ValidadorCampos.validarDecimales(value.toString(), 2).booleanValue())
/* 166:    */       {
/* 167:176 */         JOptionPane.showMessageDialog(new JFrame(), "El número máximo de decimales permitido es: ".concat(String.valueOf(2)), "Se ha producido un error ", 0);
/* 168:177 */         return;
/* 169:    */       }
/* 170:180 */       if (newCantidad.doubleValue() <= 0.0D)
/* 171:    */       {
/* 172:181 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 173:    */       }
/* 174:    */       else
/* 175:    */       {
/* 176:184 */         ((Object[])this.data.get(row))[col] = String.valueOf(value);
/* 177:185 */         BigDecimal totalFila = getTotal(row);
/* 178:186 */         setValueAt(totalFila, row, 6);
/* 179:    */         try
/* 180:    */         {
/* 181:189 */           setValueAt(calculaICEProducto(prod), row, 7);
/* 182:190 */           calculaImpuestosProducto(prod, newCantidad.doubleValue(), true, row);
/* 183:    */         }
/* 184:    */         catch (Exception ex)
/* 185:    */         {
/* 186:193 */           Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 187:    */         }
/* 188:    */       }
/* 189:    */     }
/* 190:196 */     else if (col == 4)
/* 191:    */     {
/* 192:197 */       Double newCantidad = (Double)getValueAt(row, 0);
/* 193:198 */       ((Object[])this.data.get(row))[col] = value;
/* 194:    */       try
/* 195:    */       {
/* 196:200 */         BigDecimal nuevoPrecio = (BigDecimal)getValueAt(row, 4);
/* 197:201 */         prod.setValorUnitario(nuevoPrecio);
/* 198:202 */         setValueAt(getTotal(row), row, 6);
/* 199:203 */         calculaImpuestosProducto(prod, newCantidad.doubleValue(), true, row);
/* 200:    */       }
/* 201:    */       catch (Exception ex)
/* 202:    */       {
/* 203:205 */         Logger.getLogger(NotaCreditoModel.class.getName()).log(Level.SEVERE, null, ex);
/* 204:    */       }
/* 205:    */     }
/* 206:207 */     else if (col == 5)
/* 207:    */     {
/* 208:208 */       Double newCantidad = (Double)getValueAt(row, 0);
/* 209:209 */       BigDecimal newDescuento = null;
/* 210:    */       try
/* 211:    */       {
/* 212:211 */         newDescuento = new BigDecimal(Double.parseDouble(value.toString())).setScale(2, RoundingMode.HALF_UP);
/* 213:    */       }
/* 214:    */       catch (Exception ex)
/* 215:    */       {
/* 216:213 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 217:    */       }
/* 218:216 */       if (newDescuento.doubleValue() < 0.0D)
/* 219:    */       {
/* 220:217 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 221:    */       }
/* 222:    */       else
/* 223:    */       {
/* 224:220 */         if (!ValidadorCampos.validarDecimales(value.toString(), 2).booleanValue())
/* 225:    */         {
/* 226:221 */           JOptionPane.showMessageDialog(new JFrame(), "El número máximo de decimales permitido es: ".concat(String.valueOf(2)), "Se ha producido un error ", 0);
/* 227:222 */           return;
/* 228:    */         }
/* 229:224 */         ((Object[])this.data.get(row))[col] = value;
/* 230:225 */         BigDecimal totalFila = getTotal(row);
/* 231:226 */         setValueAt(totalFila, row, 6);
/* 232:    */         try
/* 233:    */         {
/* 234:228 */           BigDecimal nuevoPrecio = (BigDecimal)getValueAt(row, 4);
/* 235:229 */           prod.setValorUnitario(nuevoPrecio);
/* 236:230 */           setValueAt(calculaICEProducto(prod), row, 7);
/* 237:231 */           calculaImpuestosProducto(prod, newCantidad.doubleValue(), true, row);
/* 238:    */         }
/* 239:    */         catch (Exception ex)
/* 240:    */         {
/* 241:233 */           Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 242:    */         }
/* 243:    */       }
/* 244:    */     }
/* 245:236 */     else if (col == 7)
/* 246:    */     {
/* 247:237 */       BigDecimal valorIce = null;
/* 248:    */       try
/* 249:    */       {
/* 250:239 */         if (!((String)value).isEmpty()) {
/* 251:240 */           valorIce = new BigDecimal(Double.parseDouble(value.toString())).setScale(2, RoundingMode.HALF_UP);
/* 252:    */         }
/* 253:    */       }
/* 254:    */       catch (Exception ex)
/* 255:    */       {
/* 256:243 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 257:    */       }
/* 258:246 */       if ((valorIce != null) && (valorIce.doubleValue() < 0.0D))
/* 259:    */       {
/* 260:247 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 261:    */       }
/* 262:    */       else
/* 263:    */       {
/* 264:250 */         if (valorIce != null) {
/* 265:251 */           ((Object[])this.data.get(row))[col] = valorIce.toPlainString();
/* 266:    */         } else {
/* 267:253 */           ((Object[])this.data.get(row))[col] = "";
/* 268:    */         }
/* 269:255 */         Double newCantidad = (Double)getValueAt(row, 0);
/* 270:    */         try
/* 271:    */         {
/* 272:257 */           calculaImpuestosProducto(prod, newCantidad.doubleValue(), true, row);
/* 273:    */         }
/* 274:    */         catch (Exception ex)
/* 275:    */         {
/* 276:259 */           Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 277:    */         }
/* 278:    */       }
/* 279:    */     }
/* 280:262 */     else if ((col == 9) || (col == 8))
/* 281:    */     {
/* 282:263 */       ((Object[])this.data.get(row))[col] = value;
/* 283:264 */       BigDecimal valorIRBPNR = ((BigDecimal)getValueAt(row, 9)).setScale(2, RoundingMode.HALF_UP);
/* 284:265 */       if ((valorIRBPNR != null) && (valorIRBPNR.doubleValue() < 0.0D))
/* 285:    */       {
/* 286:266 */         JOptionPane.showMessageDialog(new JFrame(), "Valor no permitido", "Se ha producido un error ", 0);
/* 287:    */       }
/* 288:    */       else
/* 289:    */       {
/* 290:269 */         Double newCantidad = (Double)getValueAt(row, 0);
/* 291:    */         try
/* 292:    */         {
/* 293:271 */           calculaImpuestosProducto(prod, newCantidad.doubleValue(), true, row);
/* 294:    */         }
/* 295:    */         catch (Exception ex)
/* 296:    */         {
/* 297:273 */           Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 298:    */         }
/* 299:    */       }
/* 300:    */     }
/* 301:    */     else
/* 302:    */     {
/* 303:277 */       ((Object[])this.data.get(row))[col] = value;
/* 304:    */     }
/* 305:279 */     fireTableCellUpdated(row, col);
/* 306:    */   }
/* 307:    */   
/* 308:    */   public void deleteRow(int fila)
/* 309:    */   {
/* 310:283 */     if (fila == -1) {
/* 311:284 */       fila = 0;
/* 312:    */     }
/* 313:286 */     Object[] pr = (Object[])this.data.get(fila);
/* 314:    */     try
/* 315:    */     {
/* 316:288 */       String codigoPrincipal = (String)getValueAt(fila, 1);
/* 317:289 */       String codigoAuxiliar = (String)getValueAt(fila, 2);
/* 318:290 */       String descripcion = (String)getValueAt(fila, 3);
/* 319:291 */       Producto prod = (Producto)new ProductoSQL().obtenerProducto(codigoPrincipal, codigoAuxiliar, descripcion).get(0);
/* 320:292 */       eliminaImpuestosProducto(prod);
/* 321:    */     }
/* 322:    */     catch (SQLException ex)
/* 323:    */     {
/* 324:294 */       Logger.getLogger(NotaCreditoModel.class.getName()).log(Level.SEVERE, null, ex);
/* 325:    */     }
/* 326:    */     catch (ClassNotFoundException ex)
/* 327:    */     {
/* 328:296 */       Logger.getLogger(NotaCreditoModel.class.getName()).log(Level.SEVERE, null, ex);
/* 329:    */     }
/* 330:298 */     this.data.remove(pr);
/* 331:299 */     this.data.size();
/* 332:300 */     fireTableRowsDeleted(fila, fila);
/* 333:301 */     super.fireTableDataChanged();
/* 334:    */   }
/* 335:    */   
/* 336:    */   public void addRow(Producto producto)
/* 337:    */   {
/* 338:313 */     int numRows = this.data.size();
/* 339:314 */     String cantidad = "1";
/* 340:315 */     BigDecimal subtotalProducto = new BigDecimal(producto.getValorUnitario().doubleValue() * Double.parseDouble(cantidad)).setScale(2, RoundingMode.HALF_UP);
/* 341:316 */     Object[] fila = { cantidad, producto.getCodigoPrincipal(), producto.getCodigoAuxiliar(), producto.getNombre(), producto.getValorUnitario(), BigDecimal.ZERO, subtotalProducto, calculaICEProducto(producto), BigDecimal.ZERO, BigDecimal.ZERO, "" };
/* 342:    */     
/* 343:    */ 
/* 344:319 */     this.data.add(fila);
/* 345:    */     try
/* 346:    */     {
/* 347:321 */       calculaImpuestosProducto(producto, Double.parseDouble(cantidad), false, this.data.size() - 1);
/* 348:    */     }
/* 349:    */     catch (Exception ex)
/* 350:    */     {
/* 351:323 */       Logger.getLogger(NotaCreditoModel.class.getName()).log(Level.SEVERE, null, ex);
/* 352:    */     }
/* 353:325 */     fireTableRowsInserted(numRows, this.data.size() - 1);
/* 354:    */   }
/* 355:    */   
/* 356:    */   private void calculaImpuestosProducto(Producto producto, double newCantidad, boolean old, int row)
/* 357:    */     throws SQLException, ClassNotFoundException
/* 358:    */   {
/* 359:339 */     List<ImpuestoProducto> impuestosProducto = producto.getImpuestoProducto();
/* 360:    */     BigDecimal iceItem;
/* 361:340 */     if (!impuestosProducto.isEmpty())
/* 362:    */     {
/* 363:341 */       iceItem = BigDecimal.ZERO;
/* 364:342 */       for (ImpuestoProducto ip : impuestosProducto)
/* 365:    */       {
/* 366:343 */         ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(ip.getCodigoImpuesto());
/* 367:344 */         BigDecimal descuento = ((BigDecimal)getValueAt(row, 5)).setScale(2, RoundingMode.HALF_UP);
/* 368:345 */         BigDecimal baseimponible = new BigDecimal(producto.getValorUnitario().doubleValue() * newCantidad).subtract(descuento).setScale(2, RoundingMode.HALF_UP);
/* 369:346 */         if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.ICE.getCode())
/* 370:    */         {
/* 371:347 */           BigDecimal iceManual = null;
/* 372:348 */           if (!((String)getValueAt(row, 7)).isEmpty()) {
/* 373:349 */             iceManual = new BigDecimal((String)getValueAt(row, 7)).setScale(2, RoundingMode.HALF_UP);
/* 374:    */           }
/* 375:351 */           BigDecimal newIceIndividual = null;
/* 376:352 */           if (iceManual != null) {
/* 377:353 */             newIceIndividual = iceManual;
/* 378:    */           } else {
/* 379:355 */             newIceIndividual = BigDecimal.ZERO;
/* 380:    */           }
/* 381:357 */           if (old == true) {
/* 382:358 */             remueveSubtotal(producto, this.listaICE);
/* 383:    */           }
/* 384:360 */           this.listaICE.add(new SubtotalImpuesto(producto, iv.getCodigoImpuesto(), iv.getCodigo(), BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), baseimponible, newIceIndividual));
/* 385:    */           
/* 386:362 */           this.subtotalICE = calcularTotalICE(this.listaICE);
/* 387:363 */           iceItem = newIceIndividual;
/* 388:    */         }
/* 389:364 */         else if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.IRBPNR.getCode())
/* 390:    */         {
/* 391:365 */           BigDecimal valorImpuestoBotellas = null;
/* 392:366 */           BigDecimal baseImponibleIRBPNR = ((BigDecimal)getValueAt(row, 8)).setScale(2, RoundingMode.HALF_UP);
/* 393:367 */           valorImpuestoBotellas = ((BigDecimal)getValueAt(row, 9)).setScale(2, RoundingMode.HALF_UP);
/* 394:368 */           if (old == true) {
/* 395:369 */             remueveSubtotal(producto, this.listaIRBPNR);
/* 396:    */           }
/* 397:371 */           if (producto.getBaseImponileIRBPNR() != null) {
/* 398:372 */             baseImponibleIRBPNR = producto.getBaseImponileIRBPNR();
/* 399:    */           }
/* 400:374 */           this.listaIRBPNR.add(new SubtotalImpuesto(producto, iv.getCodigoImpuesto(), iv.getCodigo(), BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), baseImponibleIRBPNR, valorImpuestoBotellas));
/* 401:    */           
/* 402:376 */           this.subtotalIRBPNR = sumarListaImpuestos(this.listaIRBPNR);
/* 403:    */         }
/* 404:377 */         else if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.IVA.getCode())
/* 405:    */         {
/* 406:378 */           BigDecimal temp = BigDecimal.ZERO;
/* 407:379 */           BigDecimal total = BigDecimal.ZERO;
/* 408:380 */           SubtotalImpuesto subTotal = null;
/* 409:381 */           if (iceItem.doubleValue() > 0.0D)
/* 410:    */           {
/* 411:382 */             temp = baseimponible;
/* 412:383 */             baseimponible = baseimponible.add(iceItem);
/* 413:384 */             total = baseimponible.multiply(BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D)).setScale(2, RoundingMode.HALF_UP);
/* 414:385 */             subTotal = new SubtotalImpuesto(producto, iv.getCodigoImpuesto(), iv.getCodigo(), BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D).setScale(2, RoundingMode.HALF_UP), baseimponible, total);
/* 415:    */             
/* 416:387 */             baseimponible = temp;
/* 417:    */           }
/* 418:    */           else
/* 419:    */           {
/* 420:389 */             total = baseimponible.multiply(BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D)).setScale(2, RoundingMode.HALF_UP);
/* 421:390 */             subTotal = new SubtotalImpuesto(producto, iv.getCodigoImpuesto(), iv.getCodigo(), BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D).setScale(2, RoundingMode.HALF_UP), baseimponible, total);
/* 422:    */           }
/* 423:393 */           subTotal.setValorIce(iceItem);
/* 424:394 */           if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_VENTA_0.getCode()))
/* 425:    */           {
/* 426:395 */             if (old == true) {
/* 427:396 */               remueveSubtotal(producto, this.listaIva0);
/* 428:    */             }
/* 429:398 */             this.listaIva0.add(subTotal);
/* 430:399 */             this.subtotalIva0 = calcularTotal(this.listaIva0);
/* 431:    */           }
/* 432:400 */           else if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_NO_OBJETO.getCode()))
/* 433:    */           {
/* 434:401 */             if (old == true) {
/* 435:402 */               remueveSubtotal(producto, this.listaNoIva);
/* 436:    */             }
/* 437:404 */             this.listaNoIva.add(subTotal);
/* 438:405 */             this.subtotalNoIva = calcularTotal(this.listaNoIva);
/* 439:    */           }
/* 440:406 */           else if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_EXCENTO.getCode()))
/* 441:    */           {
/* 442:407 */             if (old == true) {
/* 443:408 */               remueveSubtotal(producto, this.listaExentoIVA);
/* 444:    */             }
/* 445:410 */             this.listaExentoIVA.add(subTotal);
/* 446:411 */             this.subtotalExentoIVA = calcularTotal(this.listaExentoIVA);
/* 447:    */           }
/* 448:412 */           else if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode()))
/* 449:    */           {
/* 450:413 */             if (old == true) {
/* 451:414 */               remueveSubtotal(producto, this.listaIva12);
/* 452:    */             }
/* 453:416 */             this.listaIva12.add(subTotal);
/* 454:417 */             this.subtotalIva12 = calcularTotal(this.listaIva12);
/* 455:    */           }
/* 456:    */         }
/* 457:    */       }
/* 458:    */     }
/* 459:    */   }
/* 460:    */   
/* 461:    */   private void eliminaImpuestosProducto(Producto prod)
/* 462:    */     throws SQLException, ClassNotFoundException
/* 463:    */   {
/* 464:434 */     List<ImpuestoProducto> impuestosProducto = prod.getImpuestoProducto();
/* 465:435 */     for (ImpuestoProducto ip : impuestosProducto)
/* 466:    */     {
/* 467:436 */       ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(ip.getCodigoImpuesto());
/* 468:437 */       if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.IVA.getCode())
/* 469:    */       {
/* 470:438 */         if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_VENTA_0.getCode()))
/* 471:    */         {
/* 472:439 */           remueveSubtotal(prod, this.listaIva0);
/* 473:440 */           this.subtotalIva0 = calcularTotal(this.listaIva0);
/* 474:    */         }
/* 475:441 */         else if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_NO_OBJETO.getCode()))
/* 476:    */         {
/* 477:442 */           remueveSubtotal(prod, this.listaNoIva);
/* 478:443 */           this.subtotalNoIva = calcularTotal(this.listaNoIva);
/* 479:    */         }
/* 480:444 */         else if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_EXCENTO.getCode()))
/* 481:    */         {
/* 482:445 */           remueveSubtotal(prod, this.listaExentoIVA);
/* 483:446 */           this.subtotalExentoIVA = calcularTotal(this.listaExentoIVA);
/* 484:    */         }
/* 485:447 */         else if (iv.getCodigo().equals(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode()))
/* 486:    */         {
/* 487:448 */           remueveSubtotal(prod, this.listaIva12);
/* 488:449 */           this.subtotalIva12 = calcularTotal(this.listaIva12);
/* 489:    */         }
/* 490:    */       }
/* 491:451 */       else if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.ICE.getCode())
/* 492:    */       {
/* 493:452 */         remueveSubtotal(prod, this.listaICE);
/* 494:453 */         this.subtotalICE = sumarListaImpuestos(this.listaICE);
/* 495:    */       }
/* 496:454 */       else if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.IRBPNR.getCode())
/* 497:    */       {
/* 498:455 */         remueveSubtotal(prod, this.listaIRBPNR);
/* 499:456 */         this.subtotalIRBPNR = sumarListaImpuestos(this.listaIRBPNR);
/* 500:    */       }
/* 501:    */     }
/* 502:    */   }
/* 503:    */   
/* 504:    */   private BigDecimal sumarListaImpuestos(List<SubtotalImpuesto> lista)
/* 505:    */   {
/* 506:462 */     BigDecimal total = BigDecimal.ZERO;
/* 507:463 */     for (SubtotalImpuesto s : lista) {
/* 508:464 */       total = total.add(s.getSubtotal());
/* 509:    */     }
/* 510:466 */     return total;
/* 511:    */   }
/* 512:    */   
/* 513:    */   private BigDecimal calcularTotal(List<SubtotalImpuesto> lista)
/* 514:    */   {
/* 515:476 */     BigDecimal total = BigDecimal.ZERO;
/* 516:477 */     for (SubtotalImpuesto s : lista) {
/* 517:478 */       total = total.add(s.getBaseImponible().subtract(s.getValorIce() == null ? BigDecimal.ZERO : s.getValorIce()));
/* 518:    */     }
/* 519:480 */     return total;
/* 520:    */   }
/* 521:    */   
/* 522:    */   private BigDecimal calcularTotalICE(List<SubtotalImpuesto> lista)
/* 523:    */   {
/* 524:490 */     BigDecimal total = BigDecimal.ZERO;
/* 525:491 */     for (SubtotalImpuesto s : lista) {
/* 526:492 */       total = total.add(s.getSubtotal());
/* 527:    */     }
/* 528:494 */     return total;
/* 529:    */   }
/* 530:    */   
/* 531:    */   public BigDecimal calcularTotalIva12()
/* 532:    */   {
/* 533:501 */     BigDecimal total = BigDecimal.ZERO;
/* 534:502 */     for (SubtotalImpuesto s : this.listaIva12) {
/* 535:503 */       total = total.add(s.getSubtotal());
/* 536:    */     }
/* 537:505 */     return total;
/* 538:    */   }
/* 539:    */   
/* 540:    */   private void remueveSubtotal(Producto producto, List<SubtotalImpuesto> lista)
/* 541:    */     throws SQLException, ClassNotFoundException
/* 542:    */   {
/* 543:518 */     boolean itemEncontrado = false;
/* 544:519 */     for (int i = 0; i < lista.size(); i++) {
/* 545:520 */       if ((((SubtotalImpuesto)lista.get(i)).verificarProducto(producto)) && (!itemEncontrado))
/* 546:    */       {
/* 547:522 */         lista.remove(i);
/* 548:523 */         itemEncontrado = true;
/* 549:    */       }
/* 550:    */     }
/* 551:    */   }
/* 552:    */   
/* 553:    */   private Double convertirADouble(Object objeto)
/* 554:    */   {
/* 555:535 */     Double cantidad = null;
/* 556:536 */     if ((objeto instanceof String)) {
/* 557:537 */       cantidad = Double.valueOf(Double.parseDouble((String)objeto));
/* 558:538 */     } else if ((objeto instanceof Double)) {
/* 559:539 */       cantidad = (Double)objeto;
/* 560:540 */     } else if ((objeto instanceof Integer)) {
/* 561:541 */       cantidad = Double.valueOf(Double.parseDouble(objeto.toString()));
/* 562:    */     }
/* 563:543 */     return cantidad;
/* 564:    */   }
/* 565:    */   
/* 566:    */   private BigDecimal convertirABigDecimal(Object objeto)
/* 567:    */   {
/* 568:547 */     BigDecimal cantidad = null;
/* 569:548 */     if ((objeto instanceof String)) {
/* 570:549 */       cantidad = new BigDecimal((String)objeto);
/* 571:550 */     } else if ((objeto instanceof Double)) {
/* 572:551 */       cantidad = new BigDecimal(((Double)objeto).doubleValue());
/* 573:552 */     } else if ((objeto instanceof Integer)) {
/* 574:553 */       cantidad = new BigDecimal(((Integer)objeto).intValue());
/* 575:554 */     } else if ((objeto instanceof BigDecimal)) {
/* 576:555 */       cantidad = (BigDecimal)objeto;
/* 577:    */     }
/* 578:557 */     return cantidad;
/* 579:    */   }
/* 580:    */   
/* 581:    */   private String calculaICEProducto(Producto producto)
/* 582:    */   {
/* 583:568 */     String newIceIndividual = "0";
/* 584:569 */     List<ImpuestoProducto> impuestosProducto = producto.getImpuestoProducto();
/* 585:570 */     if (!impuestosProducto.isEmpty()) {
/* 586:571 */       for (ImpuestoProducto ip : impuestosProducto)
/* 587:    */       {
/* 588:572 */         ImpuestoValor iv = null;
/* 589:    */         try
/* 590:    */         {
/* 591:574 */           iv = new ImpuestoValorSQL().obtenerValorPorCodigo(ip.getCodigoImpuesto());
/* 592:    */         }
/* 593:    */         catch (Exception ex)
/* 594:    */         {
/* 595:576 */           Logger.getLogger(FacturaModel.class.getName()).log(Level.SEVERE, null, ex);
/* 596:    */         }
/* 597:578 */         if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.ICE.getCode())
/* 598:    */         {
/* 599:579 */           newIceIndividual = "";
/* 600:580 */           break;
/* 601:    */         }
/* 602:    */       }
/* 603:    */     }
/* 604:584 */     return newIceIndividual;
/* 605:    */   }
/* 606:    */   
/* 607:    */   public static boolean esImpuestoEspecial(String codigo)
/* 608:    */   {
/* 609:594 */     boolean respuesta = false;
/* 610:595 */     if ((codigo.equals("3011")) || (codigo.equals("3021")) || (codigo.equals("3031")) || (codigo.equals("3041"))) {
/* 611:596 */       respuesta = true;
/* 612:    */     }
/* 613:598 */     return respuesta;
/* 614:    */   }
/* 615:    */   
/* 616:    */   public List<SubtotalImpuesto> getListaICE()
/* 617:    */   {
/* 618:602 */     return this.listaICE;
/* 619:    */   }
/* 620:    */   
/* 621:    */   public void setListaICE(List<SubtotalImpuesto> listaICE)
/* 622:    */   {
/* 623:606 */     this.listaICE = listaICE;
/* 624:    */   }
/* 625:    */   
/* 626:    */   public List<SubtotalImpuesto> getListaIva0()
/* 627:    */   {
/* 628:610 */     return this.listaIva0;
/* 629:    */   }
/* 630:    */   
/* 631:    */   public void setListaIva0(List<SubtotalImpuesto> listaIva0)
/* 632:    */   {
/* 633:614 */     this.listaIva0 = listaIva0;
/* 634:    */   }
/* 635:    */   
/* 636:    */   public List<SubtotalImpuesto> getListaIva12()
/* 637:    */   {
/* 638:618 */     return this.listaIva12;
/* 639:    */   }
/* 640:    */   
/* 641:    */   public void setListaIva12(List<SubtotalImpuesto> listaIva12)
/* 642:    */   {
/* 643:622 */     this.listaIva12 = listaIva12;
/* 644:    */   }
/* 645:    */   
/* 646:    */   public List<SubtotalImpuesto> getListaNoIva()
/* 647:    */   {
/* 648:626 */     return this.listaNoIva;
/* 649:    */   }
/* 650:    */   
/* 651:    */   public void setListaNoIva(List<SubtotalImpuesto> listaNoIva)
/* 652:    */   {
/* 653:630 */     this.listaNoIva = listaNoIva;
/* 654:    */   }
/* 655:    */   
/* 656:    */   public BigDecimal getSubtotalICE()
/* 657:    */   {
/* 658:634 */     return this.subtotalICE;
/* 659:    */   }
/* 660:    */   
/* 661:    */   public void setSubtotalICE(BigDecimal subtotalICE)
/* 662:    */   {
/* 663:638 */     this.subtotalICE = subtotalICE;
/* 664:    */   }
/* 665:    */   
/* 666:    */   public BigDecimal getSubtotalIva0()
/* 667:    */   {
/* 668:642 */     return this.subtotalIva0;
/* 669:    */   }
/* 670:    */   
/* 671:    */   public void setSubtotalIva0(BigDecimal subtotalIva0)
/* 672:    */   {
/* 673:646 */     this.subtotalIva0 = subtotalIva0;
/* 674:    */   }
/* 675:    */   
/* 676:    */   public BigDecimal getSubtotalIva12()
/* 677:    */   {
/* 678:650 */     return this.subtotalIva12;
/* 679:    */   }
/* 680:    */   
/* 681:    */   public void setSubtotalIva12(BigDecimal subtotalIva12)
/* 682:    */   {
/* 683:654 */     this.subtotalIva12 = subtotalIva12;
/* 684:    */   }
/* 685:    */   
/* 686:    */   public BigDecimal getSubtotalNoIva()
/* 687:    */   {
/* 688:658 */     return this.subtotalNoIva;
/* 689:    */   }
/* 690:    */   
/* 691:    */   public void setSubtotalNoIva(BigDecimal subtotalNoIva)
/* 692:    */   {
/* 693:662 */     this.subtotalNoIva = subtotalNoIva;
/* 694:    */   }
/* 695:    */   
/* 696:    */   public BigDecimal getSubtotalExentoIVA()
/* 697:    */   {
/* 698:666 */     return this.subtotalExentoIVA;
/* 699:    */   }
/* 700:    */   
/* 701:    */   public void setSubtotalExentoIVA(BigDecimal subtotalExentoIVA)
/* 702:    */   {
/* 703:670 */     this.subtotalExentoIVA = subtotalExentoIVA;
/* 704:    */   }
/* 705:    */   
/* 706:    */   public List<SubtotalImpuesto> getListaExentoIVA()
/* 707:    */   {
/* 708:674 */     return this.listaExentoIVA;
/* 709:    */   }
/* 710:    */   
/* 711:    */   public void setListaExentoIVA(List<SubtotalImpuesto> listaExentoIVA)
/* 712:    */   {
/* 713:678 */     this.listaExentoIVA = listaExentoIVA;
/* 714:    */   }
/* 715:    */   
/* 716:    */   public List<SubtotalImpuesto> getListaIRBPNR()
/* 717:    */   {
/* 718:682 */     return this.listaIRBPNR;
/* 719:    */   }
/* 720:    */   
/* 721:    */   public void setListaIRBPNR(List<SubtotalImpuesto> listaIRBPNR)
/* 722:    */   {
/* 723:686 */     this.listaIRBPNR = listaIRBPNR;
/* 724:    */   }
/* 725:    */   
/* 726:    */   public BigDecimal getSubtotalIRBPNR()
/* 727:    */   {
/* 728:690 */     return this.subtotalIRBPNR;
/* 729:    */   }
/* 730:    */   
/* 731:    */   public void setSubtotalIRBPNR(BigDecimal subtotalIRBPNR)
/* 732:    */   {
/* 733:694 */     this.subtotalIRBPNR = subtotalIRBPNR;
/* 734:    */   }
/* 735:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.table.model.FacturaModel
 * JD-Core Version:    0.7.0.1
 */