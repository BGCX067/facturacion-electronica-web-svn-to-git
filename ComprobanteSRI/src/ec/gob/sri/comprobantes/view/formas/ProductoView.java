/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoProducto;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   6:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*   8:    */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   9:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*  10:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*  11:    */ import ec.gob.sri.comprobantes.util.SiNoEnum;
/*  12:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  13:    */ import ec.gob.sri.comprobantes.util.TipoProductoEnum;
/*  14:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  15:    */ import ec.gob.sri.comprobantes.view.modals.DialogoProducto;
/*  16:    */ import java.awt.Container;
/*  17:    */ import java.awt.Cursor;
/*  18:    */ import java.awt.event.ActionEvent;
/*  19:    */ import java.awt.event.ActionListener;
/*  20:    */ import java.math.BigDecimal;
/*  21:    */ import java.sql.SQLException;
/*  22:    */ import java.util.ArrayList;
/*  23:    */ import java.util.List;
/*  24:    */ import java.util.logging.Level;
/*  25:    */ import java.util.logging.Logger;
/*  26:    */ import javax.swing.BorderFactory;
/*  27:    */ import javax.swing.ComboBoxModel;
/*  28:    */ import javax.swing.DefaultComboBoxModel;
/*  29:    */ import javax.swing.GroupLayout;
/*  30:    */ import javax.swing.GroupLayout.Alignment;
/*  31:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  32:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  33:    */ import javax.swing.JButton;
/*  34:    */ import javax.swing.JComboBox;
/*  35:    */ import javax.swing.JFormattedTextField;
/*  36:    */ import javax.swing.JFrame;
/*  37:    */ import javax.swing.JLabel;
/*  38:    */ import javax.swing.JOptionPane;
/*  39:    */ import javax.swing.JPanel;
/*  40:    */ import javax.swing.JTextField;
/*  41:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  42:    */ import javax.swing.border.SoftBevelBorder;
/*  43:    */ import org.jdesktop.application.Application;
/*  44:    */ import org.jdesktop.application.ApplicationContext;
/*  45:    */ import org.jdesktop.application.ResourceMap;
/*  46:    */ 
/*  47:    */ public class ProductoView
/*  48:    */   extends JPanel
/*  49:    */ {
/*  50:    */   Producto produtoEdit;
/*  51:    */   DefaultComboBoxModel modeloIVA;
/*  52:    */   DefaultComboBoxModel modeloICE;
/*  53:    */   List<ImpuestoValor> listIVA;
/*  54:    */   List<ImpuestoValor> listICE;
/*  55:    */   List<ImpuestoValor> listIRBPNR;
/*  56:    */   private static final String ERROR = "Error";
/*  57: 51 */   ListenerUtil listenerUtil = new ListenerUtil();
/*  58:    */   public static final int DECIMALES_IVA_PRESUNTIVO = 2;
/*  59:    */   private JButton btnCrearProducto;
/*  60:    */   private JButton btnLimpiar;
/*  61:    */   private JComboBox cbxICE;
/*  62:    */   private JComboBox cbxIRBPNR;
/*  63:    */   private JComboBox cbxIVA;
/*  64:    */   private JComboBox cbxtipoProducto;
/*  65:    */   private JButton jButton1;
/*  66:    */   private JLabel jLabel1;
/*  67:    */   private JLabel jLabel10;
/*  68:    */   private JLabel jLabel11;
/*  69:    */   private JLabel jLabel12;
/*  70:    */   private JLabel jLabel13;
/*  71:    */   private JLabel jLabel14;
/*  72:    */   private JLabel jLabel15;
/*  73:    */   private JLabel jLabel2;
/*  74:    */   private JLabel jLabel3;
/*  75:    */   private JLabel jLabel5;
/*  76:    */   private JLabel jLabel6;
/*  77:    */   private JLabel jLabel7;
/*  78:    */   private JLabel jLabel8;
/*  79:    */   private JLabel jLabel9;
/*  80:    */   private JPanel jPanel1;
/*  81:    */   private JPanel jPanel2;
/*  82:    */   private JPanel jPanel3;
/*  83:    */   private JPanel jPanel4;
/*  84:    */   private JLabel lblDetalleProducto;
/*  85:    */   private JTextField txtAtributo1;
/*  86:    */   private JTextField txtAtributo2;
/*  87:    */   private JTextField txtAtributo3;
/*  88:    */   private JTextField txtCodigoAuxiliar;
/*  89:    */   private JTextField txtCodigoPrincipal;
/*  90:    */   private JTextField txtNombre;
/*  91:    */   private JTextField txtValor1;
/*  92:    */   private JTextField txtValor2;
/*  93:    */   private JTextField txtValor3;
/*  94:    */   private JFormattedTextField txtValorUnitario;
/*  95:    */   
/*  96:    */   public ProductoView()
/*  97:    */   {
/*  98: 56 */     initComponents();
/*  99: 57 */     loadModel();
/* 100: 58 */     inicializarLongitudes();
/* 101: 59 */     this.jButton1.setVisible(false);
/* 102: 60 */     this.btnLimpiar.setVisible(true);
/* 103:    */   }
/* 104:    */   
/* 105:    */   public ProductoView(Producto producto)
/* 106:    */   {
/* 107: 64 */     this.produtoEdit = producto;
/* 108: 65 */     initComponents();
/* 109: 66 */     loadModel();
/* 110: 67 */     inicarTextos();
/* 111: 68 */     inicializarLongitudes();
/* 112: 69 */     this.jButton1.setVisible(true);
/* 113: 70 */     this.btnLimpiar.setVisible(false);
/* 114:    */   }
/* 115:    */   
/* 116:    */   private void inicializarLongitudes()
/* 117:    */   {
/* 118: 74 */     this.listenerUtil.listenerLongitud(this.txtCodigoPrincipal, Integer.valueOf(25));
/* 119: 75 */     this.listenerUtil.listenerLongitud(this.txtCodigoAuxiliar, Integer.valueOf(25));
/* 120: 76 */     this.listenerUtil.listenerNumerosDecimales(this.txtValorUnitario, 17);
/* 121: 77 */     this.listenerUtil.listenerLongitud(this.txtValor1, Integer.valueOf(300));
/* 122: 78 */     this.listenerUtil.listenerLongitud(this.txtValor2, Integer.valueOf(300));
/* 123: 79 */     this.listenerUtil.listenerLongitud(this.txtValor3, Integer.valueOf(300));
/* 124: 80 */     this.listenerUtil.listenerLongitud(this.txtAtributo1, Integer.valueOf(300));
/* 125: 81 */     this.listenerUtil.listenerLongitud(this.txtAtributo2, Integer.valueOf(300));
/* 126: 82 */     this.listenerUtil.listenerLongitud(this.txtAtributo3, Integer.valueOf(300));
/* 127: 83 */     StringUtil.convertirMayusculas(this.txtNombre);
/* 128: 84 */     this.listenerUtil.listenerLongitud(this.txtNombre, Integer.valueOf(300));
/* 129:    */   }
/* 130:    */   
/* 131:    */   private void loadModel()
/* 132:    */   {
/* 133: 89 */     ImpuestoValorSQL impvalorSQL = new ImpuestoValorSQL();
/* 134:    */     try
/* 135:    */     {
/* 136: 91 */       cargarModeloComboTipoProducto();
/* 137: 92 */       this.listIVA = new ArrayList();
/* 138: 93 */       this.listIVA.addAll(impvalorSQL.obtenerValorImpuestoIVA());
/* 139: 94 */       this.cbxIVA.setModel(new DefaultComboBoxModel(this.listIVA.toArray()));
/* 140: 95 */       this.listICE = new ArrayList();
/* 141: 96 */       this.listICE.add(new ImpuestoValor(Integer.valueOf(2), "A"));
/* 142: 97 */       this.listICE.addAll(impvalorSQL.obtenerValorImpuestoICE());
/* 143: 98 */       this.cbxICE.setModel(new DefaultComboBoxModel(this.listICE.toArray()));
/* 144: 99 */       this.listIRBPNR = new ArrayList();
/* 145:100 */       this.listIRBPNR.add(new ImpuestoValor(Integer.valueOf(2), "A"));
/* 146:101 */       this.listIRBPNR.addAll(impvalorSQL.obtenerValorImpuestoIRBPNR());
/* 147:102 */       this.cbxIRBPNR.setModel(new DefaultComboBoxModel(this.listIRBPNR.toArray()));
/* 148:103 */       if (this.produtoEdit != null) {
/* 149:104 */         this.cbxtipoProducto.getModel().setSelectedItem(StringUtil.getSlectedItemTipoProducto(this.produtoEdit.getTipoProducto()));
/* 150:    */       }
/* 151:    */     }
/* 152:    */     catch (SQLException ex)
/* 153:    */     {
/* 154:107 */       Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 155:    */     }
/* 156:    */     catch (ClassNotFoundException ex)
/* 157:    */     {
/* 158:109 */       Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 159:    */     }
/* 160:    */   }
/* 161:    */   
/* 162:    */   private void cargarModeloComboTipoProducto()
/* 163:    */   {
/* 164:114 */     List<String> tps = new ArrayList();
/* 165:115 */     int i = 0;
/* 166:116 */     for (TipoProductoEnum tp : TipoProductoEnum.values())
/* 167:    */     {
/* 168:117 */       if (i != 0) {
/* 169:118 */         tps.add(tp.name());
/* 170:    */       }
/* 171:120 */       i++;
/* 172:    */     }
/* 173:122 */     this.cbxtipoProducto.setModel(new DefaultComboBoxModel(tps.toArray()));
/* 174:    */   }
/* 175:    */   
/* 176:    */   private void inicarTextos()
/* 177:    */   {
/* 178:126 */     this.txtCodigoPrincipal.setText(this.produtoEdit.getCodigoPrincipal());
/* 179:    */     
/* 180:128 */     this.txtCodigoAuxiliar.setText(this.produtoEdit.getCodigoAuxiliar());
/* 181:    */     
/* 182:130 */     this.txtNombre.setText(this.produtoEdit.getNombre());
/* 183:    */     
/* 184:132 */     this.txtValorUnitario.setText(this.produtoEdit.getValorUnitario().toString());
/* 185:133 */     String item = StringUtil.getSlectedItemTipoProducto(this.produtoEdit.getTipoProducto());
/* 186:134 */     if (item != null) {
/* 187:135 */       this.cbxtipoProducto.setSelectedItem(TipoProductoEnum.valueOf(item));
/* 188:    */     }
/* 189:137 */     int i = 0;
/* 190:138 */     for (InformacionAdicionalProducto infoAd : this.produtoEdit.getInfoAdicionalList())
/* 191:    */     {
/* 192:139 */       if (i == 0)
/* 193:    */       {
/* 194:140 */         this.txtAtributo1.setText(infoAd.getAtributo());
/* 195:141 */         this.txtValor1.setText(infoAd.getValor());
/* 196:    */       }
/* 197:143 */       if (i == 1)
/* 198:    */       {
/* 199:144 */         this.txtAtributo2.setText(infoAd.getAtributo());
/* 200:145 */         this.txtValor2.setText(infoAd.getValor());
/* 201:    */       }
/* 202:147 */       if (i == 2)
/* 203:    */       {
/* 204:148 */         this.txtAtributo3.setText(infoAd.getAtributo());
/* 205:149 */         this.txtValor3.setText(infoAd.getValor());
/* 206:    */       }
/* 207:151 */       i++;
/* 208:    */     }
/* 209:154 */     for (ImpuestoValor iv : this.produtoEdit.getImpuestoValor())
/* 210:    */     {
/* 211:155 */       if (iv.getCodigoImpuesto().intValue() == 2) {
/* 212:156 */         this.cbxIVA.getModel().setSelectedItem(iv);
/* 213:    */       }
/* 214:158 */       if (iv.getCodigoImpuesto().intValue() == 3) {
/* 215:159 */         this.cbxICE.getModel().setSelectedItem(iv);
/* 216:    */       }
/* 217:161 */       if (iv.getCodigoImpuesto().intValue() == 5) {
/* 218:162 */         this.cbxIRBPNR.getModel().setSelectedItem(iv);
/* 219:    */       }
/* 220:    */     }
/* 221:    */   }
/* 222:    */   
/* 223:    */   private void initComponents()
/* 224:    */   {
/* 225:176 */     this.lblDetalleProducto = new JLabel();
/* 226:177 */     this.jPanel1 = new JPanel();
/* 227:178 */     this.jLabel1 = new JLabel();
/* 228:179 */     this.txtCodigoPrincipal = new JTextField();
/* 229:180 */     this.txtCodigoAuxiliar = new JTextField();
/* 230:181 */     this.jLabel2 = new JLabel();
/* 231:182 */     this.jLabel5 = new JLabel();
/* 232:183 */     this.cbxtipoProducto = new JComboBox();
/* 233:184 */     this.jLabel3 = new JLabel();
/* 234:185 */     this.txtNombre = new JTextField();
/* 235:186 */     this.txtValorUnitario = new JFormattedTextField();
/* 236:187 */     this.jLabel15 = new JLabel();
/* 237:188 */     this.jPanel2 = new JPanel();
/* 238:189 */     this.jLabel6 = new JLabel();
/* 239:190 */     this.cbxIVA = new JComboBox();
/* 240:191 */     this.jLabel7 = new JLabel();
/* 241:192 */     this.cbxICE = new JComboBox();
/* 242:193 */     this.jLabel8 = new JLabel();
/* 243:194 */     this.cbxIRBPNR = new JComboBox();
/* 244:195 */     this.jPanel3 = new JPanel();
/* 245:196 */     this.jLabel9 = new JLabel();
/* 246:197 */     this.jLabel10 = new JLabel();
/* 247:198 */     this.jLabel11 = new JLabel();
/* 248:199 */     this.txtAtributo1 = new JTextField();
/* 249:200 */     this.txtAtributo2 = new JTextField();
/* 250:201 */     this.txtAtributo3 = new JTextField();
/* 251:202 */     this.jLabel12 = new JLabel();
/* 252:203 */     this.jLabel13 = new JLabel();
/* 253:204 */     this.jLabel14 = new JLabel();
/* 254:205 */     this.txtValor1 = new JTextField();
/* 255:206 */     this.txtValor2 = new JTextField();
/* 256:207 */     this.txtValor3 = new JTextField();
/* 257:208 */     this.jPanel4 = new JPanel();
/* 258:209 */     this.jButton1 = new JButton();
/* 259:210 */     this.btnCrearProducto = new JButton();
/* 260:211 */     this.btnLimpiar = new JButton();
/* 261:    */     
/* 262:213 */     setName("Form");
/* 263:    */     
/* 264:215 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ProductoView.class);
/* 265:216 */     this.lblDetalleProducto.setFont(resourceMap.getFont("lblDetalleProducto.font"));
/* 266:217 */     this.lblDetalleProducto.setText(resourceMap.getString("lblDetalleProducto.text", new Object[0]));
/* 267:218 */     this.lblDetalleProducto.setName("lblDetalleProducto");
/* 268:    */     
/* 269:220 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 270:221 */     this.jPanel1.setName("jPanel1");
/* 271:    */     
/* 272:223 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 273:224 */     this.jLabel1.setName("jLabel1");
/* 274:    */     
/* 275:226 */     this.txtCodigoPrincipal.setText(resourceMap.getString("txtCodigoPrincipal.text", new Object[0]));
/* 276:227 */     this.txtCodigoPrincipal.setName("txtCodigoPrincipal");
/* 277:    */     
/* 278:229 */     this.txtCodigoAuxiliar.setText(resourceMap.getString("txtCodigoAuxiliar.text", new Object[0]));
/* 279:230 */     this.txtCodigoAuxiliar.setName("txtCodigoAuxiliar");
/* 280:    */     
/* 281:232 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 282:233 */     this.jLabel2.setName("jLabel2");
/* 283:    */     
/* 284:235 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 285:236 */     this.jLabel5.setName("jLabel5");
/* 286:    */     
/* 287:238 */     this.cbxtipoProducto.setName("cbxtipoProducto");
/* 288:    */     
/* 289:240 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 290:241 */     this.jLabel3.setName("jLabel3");
/* 291:    */     
/* 292:243 */     this.txtNombre.setName("txtNombre");
/* 293:    */     
/* 294:245 */     this.txtValorUnitario.setHorizontalAlignment(4);
/* 295:246 */     this.txtValorUnitario.setToolTipText(resourceMap.getString("txtValorUnitario.toolTipText", new Object[0]));
/* 296:247 */     this.txtValorUnitario.setCursor(new Cursor(0));
/* 297:248 */     this.txtValorUnitario.setName("txtValorUnitario");
/* 298:    */     
/* 299:250 */     this.jLabel15.setText(resourceMap.getString("jLabel15.text", new Object[0]));
/* 300:251 */     this.jLabel15.setName("jLabel15");
/* 301:    */     
/* 302:253 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 303:254 */     this.jPanel1.setLayout(jPanel1Layout);
/* 304:255 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(196, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel3).addComponent(this.jLabel15).addComponent(this.jLabel2).addComponent(this.jLabel5)).addGap(40, 40, 40).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtCodigoPrincipal, GroupLayout.Alignment.LEADING).addComponent(this.txtCodigoAuxiliar, GroupLayout.Alignment.LEADING, -1, 216, 32767).addComponent(this.cbxtipoProducto, GroupLayout.Alignment.LEADING, 0, -1, 32767)).addComponent(this.txtNombre, -2, 480, -2).addComponent(this.txtValorUnitario, -2, 179, -2)).addGap(79, 79, 79)));
/* 305:    */     
/* 306:    */ 
/* 307:    */ 
/* 308:    */ 
/* 309:    */ 
/* 310:    */ 
/* 311:    */ 
/* 312:    */ 
/* 313:    */ 
/* 314:    */ 
/* 315:    */ 
/* 316:    */ 
/* 317:    */ 
/* 318:    */ 
/* 319:    */ 
/* 320:    */ 
/* 321:    */ 
/* 322:    */ 
/* 323:    */ 
/* 324:275 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txtCodigoPrincipal)).addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtCodigoAuxiliar, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbxtipoProducto, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.txtNombre, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.txtValorUnitario, -2, -1, -2)).addContainerGap()));
/* 325:    */     
/* 326:    */ 
/* 327:    */ 
/* 328:    */ 
/* 329:    */ 
/* 330:    */ 
/* 331:    */ 
/* 332:    */ 
/* 333:    */ 
/* 334:    */ 
/* 335:    */ 
/* 336:    */ 
/* 337:    */ 
/* 338:    */ 
/* 339:    */ 
/* 340:    */ 
/* 341:    */ 
/* 342:    */ 
/* 343:    */ 
/* 344:    */ 
/* 345:    */ 
/* 346:    */ 
/* 347:    */ 
/* 348:    */ 
/* 349:    */ 
/* 350:301 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/* 351:302 */     this.jPanel2.setName("jPanel2");
/* 352:    */     
/* 353:304 */     this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
/* 354:305 */     this.jLabel6.setName("jLabel6");
/* 355:    */     
/* 356:307 */     this.cbxIVA.setName("cbxIVA");
/* 357:    */     
/* 358:309 */     this.jLabel7.setText(resourceMap.getString("jLabel7.text", new Object[0]));
/* 359:310 */     this.jLabel7.setName("jLabel7");
/* 360:    */     
/* 361:312 */     this.cbxICE.setName("cbxICE");
/* 362:    */     
/* 363:314 */     this.jLabel8.setText(resourceMap.getString("jLabel8.text", new Object[0]));
/* 364:315 */     this.jLabel8.setName("jLabel8");
/* 365:    */     
/* 366:317 */     this.cbxIRBPNR.setInheritsPopupMenu(true);
/* 367:318 */     this.cbxIRBPNR.setName("cbxIRBPNR");
/* 368:    */     
/* 369:320 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 370:321 */     this.jPanel2.setLayout(jPanel2Layout);
/* 371:322 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel6).addComponent(this.cbxICE, 0, 740, 32767).addComponent(this.jLabel7).addComponent(this.cbxIVA, 0, -1, 32767).addComponent(this.jLabel8).addComponent(this.cbxIRBPNR, 0, -1, 32767)).addContainerGap(126, 32767)));
/* 372:    */     
/* 373:    */ 
/* 374:    */ 
/* 375:    */ 
/* 376:    */ 
/* 377:    */ 
/* 378:    */ 
/* 379:    */ 
/* 380:    */ 
/* 381:    */ 
/* 382:    */ 
/* 383:    */ 
/* 384:335 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cbxIVA, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cbxICE, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cbxIRBPNR, -2, -1, -2).addContainerGap(-1, 32767)));
/* 385:    */     
/* 386:    */ 
/* 387:    */ 
/* 388:    */ 
/* 389:    */ 
/* 390:    */ 
/* 391:    */ 
/* 392:    */ 
/* 393:    */ 
/* 394:    */ 
/* 395:    */ 
/* 396:    */ 
/* 397:    */ 
/* 398:    */ 
/* 399:    */ 
/* 400:    */ 
/* 401:352 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/* 402:353 */     this.jPanel3.setName("jPanel3");
/* 403:    */     
/* 404:355 */     this.jLabel9.setText(resourceMap.getString("jLabel9.text", new Object[0]));
/* 405:356 */     this.jLabel9.setName("jLabel9");
/* 406:    */     
/* 407:358 */     this.jLabel10.setText(resourceMap.getString("jLabel10.text", new Object[0]));
/* 408:359 */     this.jLabel10.setName("jLabel10");
/* 409:    */     
/* 410:361 */     this.jLabel11.setText(resourceMap.getString("jLabel11.text", new Object[0]));
/* 411:362 */     this.jLabel11.setName("jLabel11");
/* 412:    */     
/* 413:364 */     this.txtAtributo1.setText(resourceMap.getString("txtAtributo1.text", new Object[0]));
/* 414:365 */     this.txtAtributo1.setName("txtAtributo1");
/* 415:    */     
/* 416:367 */     this.txtAtributo2.setText(resourceMap.getString("txtAtributo2.text", new Object[0]));
/* 417:368 */     this.txtAtributo2.setName("txtAtributo2");
/* 418:    */     
/* 419:370 */     this.txtAtributo3.setText(resourceMap.getString("txtAtributo3.text", new Object[0]));
/* 420:371 */     this.txtAtributo3.setName("txtAtributo3");
/* 421:    */     
/* 422:373 */     this.jLabel12.setText(resourceMap.getString("jLabel12.text", new Object[0]));
/* 423:374 */     this.jLabel12.setName("jLabel12");
/* 424:    */     
/* 425:376 */     this.jLabel13.setText(resourceMap.getString("jLabel13.text", new Object[0]));
/* 426:377 */     this.jLabel13.setName("jLabel13");
/* 427:    */     
/* 428:379 */     this.jLabel14.setText(resourceMap.getString("jLabel14.text", new Object[0]));
/* 429:380 */     this.jLabel14.setName("jLabel14");
/* 430:    */     
/* 431:382 */     this.txtValor1.setText(resourceMap.getString("txtValor1.text", new Object[0]));
/* 432:383 */     this.txtValor1.setName("txtValor1");
/* 433:    */     
/* 434:385 */     this.txtValor2.setText(resourceMap.getString("txtValor2.text", new Object[0]));
/* 435:386 */     this.txtValor2.setName("txtValor2");
/* 436:    */     
/* 437:388 */     this.txtValor3.setText(resourceMap.getString("txtValor3.text", new Object[0]));
/* 438:389 */     this.txtValor3.setName("txtValor3");
/* 439:    */     
/* 440:391 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 441:392 */     this.jPanel3.setLayout(jPanel3Layout);
/* 442:393 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.jLabel10, -1, 105, 32767).addComponent(this.jLabel11, -1, 105, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtValor2).addComponent(this.txtValor3).addComponent(this.txtValor1, GroupLayout.Alignment.LEADING, -2, 210, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 140, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel13).addComponent(this.jLabel12).addComponent(this.jLabel14)).addGap(46, 46, 46).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtAtributo3).addComponent(this.txtAtributo2).addComponent(this.txtAtributo1, -1, 236, 32767)).addGap(71, 71, 71)));
/* 443:    */     
/* 444:    */ 
/* 445:    */ 
/* 446:    */ 
/* 447:    */ 
/* 448:    */ 
/* 449:    */ 
/* 450:    */ 
/* 451:    */ 
/* 452:    */ 
/* 453:    */ 
/* 454:    */ 
/* 455:    */ 
/* 456:    */ 
/* 457:    */ 
/* 458:    */ 
/* 459:    */ 
/* 460:    */ 
/* 461:    */ 
/* 462:    */ 
/* 463:    */ 
/* 464:    */ 
/* 465:    */ 
/* 466:    */ 
/* 467:418 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel9).addComponent(this.txtValor1, -2, -1, -2).addComponent(this.jLabel12).addComponent(this.txtAtributo1, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel10).addComponent(this.txtValor2, -2, -1, -2).addComponent(this.jLabel13).addComponent(this.txtAtributo2, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel11).addComponent(this.txtValor3, -2, -1, -2).addComponent(this.jLabel14).addComponent(this.txtAtributo3, -2, -1, -2)).addContainerGap(35, 32767)));
/* 468:    */     
/* 469:    */ 
/* 470:    */ 
/* 471:    */ 
/* 472:    */ 
/* 473:    */ 
/* 474:    */ 
/* 475:    */ 
/* 476:    */ 
/* 477:    */ 
/* 478:    */ 
/* 479:    */ 
/* 480:    */ 
/* 481:    */ 
/* 482:    */ 
/* 483:    */ 
/* 484:    */ 
/* 485:    */ 
/* 486:    */ 
/* 487:    */ 
/* 488:    */ 
/* 489:    */ 
/* 490:    */ 
/* 491:442 */     this.jPanel4.setBackground(resourceMap.getColor("jPanel4.background"));
/* 492:443 */     this.jPanel4.setBorder(new SoftBevelBorder(0));
/* 493:444 */     this.jPanel4.setName("jPanel4");
/* 494:    */     
/* 495:446 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/* 496:447 */     this.jButton1.setName("jButton1");
/* 497:448 */     this.jButton1.addActionListener(new ActionListener()
/* 498:    */     {
/* 499:    */       public void actionPerformed(ActionEvent evt)
/* 500:    */       {
/* 501:450 */         ProductoView.this.jButton1ActionPerformed(evt);
/* 502:    */       }
/* 503:453 */     });
/* 504:454 */     this.btnCrearProducto.setText(resourceMap.getString("btnCrearProducto.text", new Object[0]));
/* 505:455 */     this.btnCrearProducto.setName("btnCrearProducto");
/* 506:456 */     this.btnCrearProducto.addActionListener(new ActionListener()
/* 507:    */     {
/* 508:    */       public void actionPerformed(ActionEvent evt)
/* 509:    */       {
/* 510:458 */         ProductoView.this.btnCrearProductoActionPerformed(evt);
/* 511:    */       }
/* 512:461 */     });
/* 513:462 */     this.btnLimpiar.setText(resourceMap.getString("btnLimpiar.text", new Object[0]));
/* 514:463 */     this.btnLimpiar.setName("btnLimpiar");
/* 515:464 */     this.btnLimpiar.addActionListener(new ActionListener()
/* 516:    */     {
/* 517:    */       public void actionPerformed(ActionEvent evt)
/* 518:    */       {
/* 519:466 */         ProductoView.this.btnLimpiarActionPerformed(evt);
/* 520:    */       }
/* 521:469 */     });
/* 522:470 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 523:471 */     this.jPanel4.setLayout(jPanel4Layout);
/* 524:472 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(225, 225, 225).addComponent(this.btnCrearProducto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnLimpiar).addContainerGap(378, 32767)));
/* 525:    */     
/* 526:    */ 
/* 527:    */ 
/* 528:    */ 
/* 529:    */ 
/* 530:    */ 
/* 531:    */ 
/* 532:    */ 
/* 533:    */ 
/* 534:    */ 
/* 535:483 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnCrearProducto).addComponent(this.jButton1).addComponent(this.btnLimpiar)).addContainerGap(-1, 32767)));
/* 536:    */     
/* 537:    */ 
/* 538:    */ 
/* 539:    */ 
/* 540:    */ 
/* 541:    */ 
/* 542:    */ 
/* 543:    */ 
/* 544:    */ 
/* 545:    */ 
/* 546:494 */     GroupLayout layout = new GroupLayout(this);
/* 547:495 */     setLayout(layout);
/* 548:496 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.lblDetalleProducto, -2, 242, -2).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addContainerGap()));
/* 549:    */     
/* 550:    */ 
/* 551:    */ 
/* 552:    */ 
/* 553:    */ 
/* 554:    */ 
/* 555:    */ 
/* 556:    */ 
/* 557:    */ 
/* 558:    */ 
/* 559:    */ 
/* 560:508 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblDetalleProducto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addContainerGap(93, 32767)));
/* 561:    */   }
/* 562:    */   
/* 563:    */   private String validarProducto(Producto p)
/* 564:    */   {
/* 565:525 */     if ((p.getTipoProducto() == null) || (p.getTipoProducto().isEmpty())) {
/* 566:526 */       return "El tipo de producto es obligatorio";
/* 567:    */     }
/* 568:528 */     if ((p.getNombre() == null) || (p.getNombre().isEmpty())) {
/* 569:529 */       return "El Nombre del producto es obligatorio";
/* 570:    */     }
/* 571:531 */     if ((p.getImpuestoProducto() == null) || (p.getImpuestoProducto().isEmpty())) {
/* 572:532 */       return "Debe asociar por lo menos un impuesto al producto";
/* 573:    */     }
/* 574:534 */     if ((p.getTipoProducto().equals("B")) && ((p.getCodigoPrincipal() == null) || (p.getCodigoPrincipal().isEmpty()))) {
/* 575:535 */       return "El codigo principal es obligatorio";
/* 576:    */     }
/* 577:537 */     String validarAtributoValor = validarValorAtributo(this.txtAtributo1, this.txtValor1, "1");
/* 578:538 */     if (validarAtributoValor != null) {
/* 579:539 */       return validarAtributoValor;
/* 580:    */     }
/* 581:541 */     String validarAtributoValor1 = validarValorAtributo(this.txtAtributo2, this.txtValor2, "2");
/* 582:542 */     if (validarAtributoValor1 != null) {
/* 583:543 */       return validarAtributoValor1;
/* 584:    */     }
/* 585:546 */     String validarAtributoValor2 = validarValorAtributo(this.txtAtributo3, this.txtValor3, "3");
/* 586:547 */     if (validarAtributoValor2 != null) {
/* 587:548 */       return validarAtributoValor2;
/* 588:    */     }
/* 589:550 */     return validarLongitudes();
/* 590:    */   }
/* 591:    */   
/* 592:    */   private String validarLongitudes()
/* 593:    */   {
/* 594:554 */     if ((this.txtNombre.getText() != null) && (this.txtNombre.getText().length() > 300)) {
/* 595:555 */       return "El longitud máxima del campo nombre es de 300 caracteres";
/* 596:    */     }
/* 597:557 */     if ((this.txtCodigoPrincipal.getText() != null) && (this.txtCodigoPrincipal.getText().length() > 25)) {
/* 598:558 */       return "El longitud máxima del campo Código principal es de 25 caracteres";
/* 599:    */     }
/* 600:560 */     if ((this.txtCodigoAuxiliar.getText() != null) && (this.txtCodigoAuxiliar.getText().length() > 25)) {
/* 601:561 */       return "El longitud máxima del campo Código auxiliar es de 25 caracteres";
/* 602:    */     }
/* 603:564 */     return validarLongitudesCamposAdicionales();
/* 604:    */   }
/* 605:    */   
/* 606:    */   private String validarLongitudesCamposAdicionales()
/* 607:    */   {
/* 608:568 */     if ((this.txtAtributo1.getText() != null) && (!this.txtAtributo1.getText().isEmpty()) && (this.txtAtributo1.getText().length() > 300)) {
/* 609:569 */       return "La longitud máxima del campo  atributo 1 es de 300 caracteres";
/* 610:    */     }
/* 611:571 */     if ((this.txtAtributo2.getText() != null) && (!this.txtAtributo2.getText().isEmpty()) && (this.txtAtributo2.getText().length() > 300)) {
/* 612:572 */       return "La longitud máxima del campo  atributo 2 es de 300 caracteres";
/* 613:    */     }
/* 614:574 */     if ((this.txtAtributo3.getText() != null) && (!this.txtAtributo3.getText().isEmpty()) && (this.txtAtributo3.getText().length() > 300)) {
/* 615:575 */       return "La longitud máxima del campo  atributo 3 es de 300 caracteres";
/* 616:    */     }
/* 617:577 */     if ((this.txtValor1.getText() != null) && (!this.txtValor1.getText().isEmpty()) && (this.txtValor1.getText().length() > 300)) {
/* 618:578 */       return "La longitud máxima del campo  valor 1 es de 300 caracteres";
/* 619:    */     }
/* 620:580 */     if ((this.txtValor2.getText() != null) && (!this.txtValor2.getText().isEmpty()) && (this.txtValor2.getText().length() > 300)) {
/* 621:581 */       return "La longitud máxima del campo  valor 2 es de 300 caracteres";
/* 622:    */     }
/* 623:583 */     if ((this.txtValor3.getText() != null) && (!this.txtValor3.getText().isEmpty()) && (this.txtValor3.getText().length() > 300)) {
/* 624:584 */       return "La longitud máxima del campo  valor 3 es de 300 caracteres";
/* 625:    */     }
/* 626:586 */     if ((this.txtValorUnitario.getText() != null) && (!this.txtValorUnitario.getText().isEmpty()) && (this.txtValorUnitario.getText().length() > 17)) {
/* 627:587 */       return "La longitud maxima del campo valor unitario es de 14 enteros y 2 decimales";
/* 628:    */     }
/* 629:589 */     return null;
/* 630:    */   }
/* 631:    */   
/* 632:    */   private String validarValorAtributo(JTextField atributo, JTextField valor, String numeroAtributo)
/* 633:    */   {
/* 634:593 */     if ((atributo.getText() != null) && (!atributo.getText().isEmpty()) && ((valor.getText() == null) || (valor.getText().isEmpty()))) {
/* 635:594 */       return "El campo valor  " + numeroAtributo + " es obligatorio ";
/* 636:    */     }
/* 637:596 */     if (((atributo.getText() == null) || (atributo.getText().isEmpty())) && (valor.getText() != null) && (!valor.getText().isEmpty())) {
/* 638:597 */       return "El campo atributo  " + numeroAtributo + " es obligatorio ";
/* 639:    */     }
/* 640:600 */     return null;
/* 641:    */   }
/* 642:    */   
/* 643:    */   private void crearProducto()
/* 644:    */   {
/* 645:    */     try
/* 646:    */     {
/* 647:605 */       Producto p = obtenerProductonuevo();
/* 648:606 */       String esValido = validarProducto(p);
/* 649:607 */       if (esValido == null)
/* 650:    */       {
/* 651:608 */         ProductoSQL pSQl = new ProductoSQL();
/* 652:609 */         pSQl.crearProducto(p);
/* 653:610 */         JOptionPane.showMessageDialog(this, "Se creó con éxito el nuevo producto", "Mensaje", 1);
/* 654:611 */         limpiarComponentes();
/* 655:    */       }
/* 656:    */       else
/* 657:    */       {
/* 658:613 */         JOptionPane.showMessageDialog(this, esValido, "Error", 0);
/* 659:    */       }
/* 660:    */     }
/* 661:    */     catch (SQLException ex)
/* 662:    */     {
/* 663:616 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 664:    */     }
/* 665:    */     catch (ClassNotFoundException ex)
/* 666:    */     {
/* 667:618 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 668:    */     }
/* 669:    */     catch (NumberFormatException ex)
/* 670:    */     {
/* 671:620 */       JOptionPane.showMessageDialog(this, "El valor unitario debe ser un número decimal", "Error", 0);
/* 672:    */     }
/* 673:    */   }
/* 674:    */   
/* 675:    */   private void editarProducto()
/* 676:    */   {
/* 677:    */     try
/* 678:    */     {
/* 679:626 */       this.produtoEdit = obtenerProductonuevo();
/* 680:627 */       String esValido = validarProducto(this.produtoEdit);
/* 681:628 */       if (esValido == null)
/* 682:    */       {
/* 683:629 */         ProductoSQL pSQl = new ProductoSQL();
/* 684:630 */         pSQl.updateProducto(this.produtoEdit);
/* 685:631 */         JOptionPane.showMessageDialog(this, "Se actualizó con exito el nuevo producto", "Mensaje", 1);
/* 686:632 */         obtenerInstancia(this.btnCrearProducto.getParent());
/* 687:    */       }
/* 688:    */       else
/* 689:    */       {
/* 690:634 */         JOptionPane.showMessageDialog(this, esValido, "Error", 0);
/* 691:    */       }
/* 692:    */     }
/* 693:    */     catch (SQLException ex)
/* 694:    */     {
/* 695:637 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 696:    */     }
/* 697:    */     catch (ClassNotFoundException ex)
/* 698:    */     {
/* 699:639 */       Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
/* 700:    */     }
/* 701:    */     catch (NumberFormatException ex)
/* 702:    */     {
/* 703:641 */       JOptionPane.showMessageDialog(this, "El valor unitario debe ser un númro " + ex.getMessage(), "Error", 0);
/* 704:    */     }
/* 705:    */   }
/* 706:    */   
/* 707:    */   private void btnCrearProductoActionPerformed(ActionEvent evt)
/* 708:    */   {
/* 709:646 */     if (!ValidadorCampos.validarDecimales(this.txtValorUnitario.getText(), 2).booleanValue())
/* 710:    */     {
/* 711:647 */       JOptionPane.showMessageDialog(new JFrame(), "El número máximo de decimales permitido es: ".concat(String.valueOf(2)), "Error en Valor Unitario", 0);
/* 712:648 */       return;
/* 713:    */     }
/* 714:650 */     if (this.produtoEdit == null) {
/* 715:651 */       crearProducto();
/* 716:    */     } else {
/* 717:653 */       editarProducto();
/* 718:    */     }
/* 719:    */   }
/* 720:    */   
/* 721:    */   private void obtenerInstancia(Container c)
/* 722:    */   {
/* 723:658 */     if ((c instanceof DialogoProducto)) {
/* 724:659 */       c.setVisible(false);
/* 725:    */     } else {
/* 726:661 */       obtenerInstancia(c.getParent());
/* 727:    */     }
/* 728:    */   }
/* 729:    */   
/* 730:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 731:    */   {
/* 732:666 */     Container c = this.jButton1.getParent();
/* 733:667 */     obtenerInstancia(c);
/* 734:    */   }
/* 735:    */   
/* 736:    */   private void limpiarComponentes()
/* 737:    */   {
/* 738:670 */     this.txtAtributo1.setText("");
/* 739:671 */     this.txtAtributo2.setText("");
/* 740:672 */     this.txtAtributo3.setText("");
/* 741:673 */     this.txtValor1.setText("");
/* 742:674 */     this.txtValor2.setText("");
/* 743:675 */     this.txtValor3.setText("");
/* 744:676 */     this.txtValorUnitario.setText("");
/* 745:677 */     this.txtNombre.setText("");
/* 746:678 */     this.txtCodigoPrincipal.setText("");
/* 747:679 */     this.txtCodigoAuxiliar.setText("");
/* 748:680 */     loadModel();
/* 749:681 */     this.jButton1.setVisible(false);
/* 750:    */   }
/* 751:    */   
/* 752:    */   private void btnLimpiarActionPerformed(ActionEvent evt)
/* 753:    */   {
/* 754:684 */     limpiarComponentes();
/* 755:    */   }
/* 756:    */   
/* 757:    */   private String getuniqueConstraintViolado(String mensaje)
/* 758:    */   {
/* 759:687 */     if (mensaje.contains("UNIQUE_CODD_PRODUCTO")) {
/* 760:688 */       return "Ya existe producto";
/* 761:    */     }
/* 762:690 */     if (mensaje.contains("UNIQUE_COD_AUX")) {
/* 763:691 */       return "Ya existe producto con el código auxiliar " + this.txtCodigoAuxiliar.getText();
/* 764:    */     }
/* 765:693 */     return mensaje;
/* 766:    */   }
/* 767:    */   
/* 768:    */   private Producto obtenerProductonuevo()
/* 769:    */     throws NumberFormatException
/* 770:    */   {
/* 771:    */     Producto producto;
/* 772:    */     Producto producto;
/* 773:698 */     if (this.produtoEdit == null) {
/* 774:699 */       producto = new Producto();
/* 775:    */     } else {
/* 776:701 */       producto = this.produtoEdit;
/* 777:    */     }
/* 778:703 */     producto.setCodigoPrincipal(this.txtCodigoPrincipal.getText());
/* 779:704 */     producto.setCodigoAuxiliar(this.txtCodigoAuxiliar.getText());
/* 780:705 */     producto.setNombre(this.txtNombre.getText());
/* 781:706 */     producto.setTipoProducto(TipoProductoEnum.valueOf(this.cbxtipoProducto.getSelectedItem().toString()).getCode());
/* 782:707 */     producto.setValorUnitario(new BigDecimal(this.txtValorUnitario.getText()));
/* 783:708 */     producto.setInfoAdicionalList(obtenerInformacionAdicionalProducto());
/* 784:709 */     producto.setImpuestoProducto(obtenerImpuestoProducto());
/* 785:710 */     if ((this.cbxICE.getSelectedItem() != null) && (((ImpuestoValor)this.cbxICE.getSelectedItem()).getCodigo() != null)) {
/* 786:711 */       producto.setIce(SiNoEnum.SI.getCode());
/* 787:    */     } else {
/* 788:713 */       producto.setIce(SiNoEnum.NO.getCode());
/* 789:    */     }
/* 790:715 */     if ((this.cbxIVA.getSelectedItem() != null) && (((ImpuestoValor)this.cbxIVA.getSelectedItem()).getCodigo() != null)) {
/* 791:716 */       producto.setIva(SiNoEnum.SI.getCode());
/* 792:    */     } else {
/* 793:718 */       producto.setIva(SiNoEnum.NO.getCode());
/* 794:    */     }
/* 795:720 */     if ((this.cbxIRBPNR.getSelectedItem() != null) && (((ImpuestoValor)this.cbxIRBPNR.getSelectedItem()).getCodigo() != null)) {
/* 796:721 */       producto.setIrbpnr(SiNoEnum.SI.getCode());
/* 797:    */     } else {
/* 798:723 */       producto.setIrbpnr(SiNoEnum.NO.getCode());
/* 799:    */     }
/* 800:725 */     return producto;
/* 801:    */   }
/* 802:    */   
/* 803:    */   private List<ImpuestoProducto> obtenerImpuestoProducto()
/* 804:    */   {
/* 805:729 */     List<ImpuestoProducto> listProducto = new ArrayList();
/* 806:730 */     if ((this.cbxICE.getSelectedItem() != null) && (((ImpuestoValor)this.cbxICE.getSelectedItem()).getCodigo() != null))
/* 807:    */     {
/* 808:731 */       ImpuestoValor iv = (ImpuestoValor)this.cbxICE.getSelectedItem();
/* 809:732 */       ImpuestoProducto ipICE = new ImpuestoProducto(iv.getCodigo());
/* 810:733 */       listProducto.add(ipICE);
/* 811:    */     }
/* 812:735 */     if ((this.cbxIVA.getSelectedItem() != null) && (((ImpuestoValor)this.cbxIVA.getSelectedItem()).getCodigo() != null))
/* 813:    */     {
/* 814:736 */       ImpuestoValor iv = (ImpuestoValor)this.cbxIVA.getSelectedItem();
/* 815:737 */       ImpuestoProducto ipIVA = new ImpuestoProducto(iv.getCodigo());
/* 816:738 */       listProducto.add(ipIVA);
/* 817:    */     }
/* 818:740 */     if ((this.cbxIRBPNR.getSelectedItem() != null) && (((ImpuestoValor)this.cbxIRBPNR.getSelectedItem()).getCodigo() != null))
/* 819:    */     {
/* 820:741 */       ImpuestoValor iv = (ImpuestoValor)this.cbxIRBPNR.getSelectedItem();
/* 821:742 */       ImpuestoProducto impuestoValorIRBPNR = new ImpuestoProducto(iv.getCodigo());
/* 822:743 */       listProducto.add(impuestoValorIRBPNR);
/* 823:    */     }
/* 824:745 */     return listProducto;
/* 825:    */   }
/* 826:    */   
/* 827:    */   private List<InformacionAdicionalProducto> obtenerInformacionAdicionalProducto()
/* 828:    */   {
/* 829:749 */     List<InformacionAdicionalProducto> infoAdicionalList = new ArrayList();
/* 830:750 */     if ((this.txtAtributo1.getText() != null) && (!this.txtAtributo1.getText().isEmpty()) && (this.txtValor1.getText() != null) && (!this.txtValor1.getText().isEmpty()))
/* 831:    */     {
/* 832:751 */       InformacionAdicionalProducto infoAd1 = new InformacionAdicionalProducto(this.txtAtributo1.getText(), this.txtValor1.getText());
/* 833:752 */       infoAdicionalList.add(infoAd1);
/* 834:    */     }
/* 835:754 */     if ((this.txtAtributo2.getText() != null) && (!this.txtAtributo2.getText().isEmpty()) && (this.txtValor2.getText() != null) && (!this.txtValor2.getText().isEmpty()))
/* 836:    */     {
/* 837:755 */       InformacionAdicionalProducto infoAd2 = new InformacionAdicionalProducto(this.txtAtributo2.getText(), this.txtValor2.getText());
/* 838:756 */       infoAdicionalList.add(infoAd2);
/* 839:    */     }
/* 840:758 */     if ((this.txtAtributo3.getText() != null) && (!this.txtAtributo3.getText().isEmpty()) && (this.txtValor3.getText() != null) && (!this.txtValor3.getText().isEmpty()))
/* 841:    */     {
/* 842:759 */       InformacionAdicionalProducto infoAd3 = new InformacionAdicionalProducto(this.txtAtributo3.getText(), this.txtValor3.getText());
/* 843:760 */       infoAdicionalList.add(infoAd3);
/* 844:    */     }
/* 845:762 */     return infoAdicionalList;
/* 846:    */   }
/* 847:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ProductoView
 * JD-Core Version:    0.7.0.1
 */