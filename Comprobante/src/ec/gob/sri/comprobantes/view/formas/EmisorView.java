/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   5:    */ import ec.gob.sri.comprobantes.sql.EmisorSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.CampoModelo;
/*   7:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   8:    */ import ec.gob.sri.comprobantes.util.SiNoEnum;
/*   9:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  10:    */ import ec.gob.sri.comprobantes.util.TipoAmbienteEnum;
/*  11:    */ import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
/*  12:    */ import ec.gob.sri.comprobantes.util.TokensValidos;
/*  13:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  14:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*  15:    */ import java.awt.event.ActionEvent;
/*  16:    */ import java.awt.event.ActionListener;
/*  17:    */ import java.awt.event.FocusAdapter;
/*  18:    */ import java.awt.event.FocusEvent;
/*  19:    */ import java.io.File;
/*  20:    */ import java.sql.SQLException;
/*  21:    */ import java.util.ArrayList;
/*  22:    */ import java.util.HashMap;
/*  23:    */ import java.util.List;
/*  24:    */ import java.util.logging.Level;
/*  25:    */ import java.util.logging.Logger;
/*  26:    */ import javax.swing.BorderFactory;
/*  27:    */ import javax.swing.DefaultComboBoxModel;
/*  28:    */ import javax.swing.GroupLayout;
/*  29:    */ import javax.swing.GroupLayout.Alignment;
/*  30:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  31:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  32:    */ import javax.swing.ImageIcon;
/*  33:    */ import javax.swing.JButton;
/*  34:    */ import javax.swing.JCheckBox;
/*  35:    */ import javax.swing.JComboBox;
/*  36:    */ import javax.swing.JFileChooser;
/*  37:    */ import javax.swing.JLabel;
/*  38:    */ import javax.swing.JOptionPane;
/*  39:    */ import javax.swing.JPanel;
/*  40:    */ import javax.swing.JScrollPane;
/*  41:    */ import javax.swing.JSpinner;
/*  42:    */ import javax.swing.JTextArea;
/*  43:    */ import javax.swing.JTextField;
/*  44:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  45:    */ import javax.swing.SpinnerModel;
/*  46:    */ import javax.swing.SpinnerNumberModel;
/*  47:    */ import javax.swing.border.SoftBevelBorder;
/*  48:    */ import org.jdesktop.application.Application;
/*  49:    */ import org.jdesktop.application.ApplicationContext;
/*  50:    */ import org.jdesktop.application.ResourceMap;
/*  51:    */ 
/*  52:    */ public class EmisorView
/*  53:    */   extends JPanel
/*  54:    */ {
/*  55: 21 */   ListenerUtil listenerUtil = new ListenerUtil();
/*  56:    */   private Emisor emisor;
/*  57: 23 */   SpinnerModel modeltau = new SpinnerNumberModel(3, 3, 99999, 1);
/*  58:    */   private JScrollPane Jscroll1;
/*  59:    */   private JButton btnEliminarImagen;
/*  60:    */   private JButton btnImagen;
/*  61:    */   private JComboBox cbxAmbiente;
/*  62:    */   private JComboBox cbxComboTokens;
/*  63:    */   private JComboBox cbxTipoEmision;
/*  64:    */   private JCheckBox chkLlevaContabilidad;
/*  65:    */   private JButton jButton2;
/*  66:    */   private JLabel jLabel14;
/*  67:    */   private JPanel jPanel3;
/*  68:    */   private JPanel jPanel4;
/*  69:    */   private JScrollPane jScroll2;
/*  70:    */   private JLabel lblCodiEstablecimietno;
/*  71:    */   private JLabel lblContribuyenteEspecial;
/*  72:    */   private JLabel lblDirEstablecimiento;
/*  73:    */   private JLabel lblDirMatriz;
/*  74:    */   private JLabel lblImagen;
/*  75:    */   private JLabel lblNombreComercial;
/*  76:    */   private JLabel lblObligadoContabilidad;
/*  77:    */   private JLabel lblPuntoEmision;
/*  78:    */   private JLabel lblRazonSocial;
/*  79:    */   private JLabel lblRuc;
/*  80:    */   private JLabel lblTiempoEspera;
/*  81:    */   private JLabel lblTipoAmbiente;
/*  82:    */   private JLabel lblTipoEmision;
/*  83:    */   private JLabel lblToken;
/*  84:    */   private JSpinner spnTiempoAutorizacion;
/*  85:    */   private JTextField txtCodEstablecimiento;
/*  86:    */   private JTextField txtContribuyenteEspecial;
/*  87:    */   private JTextArea txtDirEstablecimiento;
/*  88:    */   private JTextArea txtDireccionMatriz;
/*  89:    */   private JTextField txtImagen;
/*  90:    */   private JTextField txtNombreComercial;
/*  91:    */   private JTextField txtPuntoEmision;
/*  92:    */   private JTextField txtRazonSocial;
/*  93:    */   private JTextField txtRuc;
/*  94:    */   
/*  95:    */   public EmisorView()
/*  96:    */   {
/*  97: 26 */     initComponents();
/*  98: 27 */     setModelCombo();
/*  99: 28 */     loadEmisor();
/* 100: 29 */     if (this.emisor != null)
/* 101:    */     {
/* 102: 30 */       initComponentesParametro();
/* 103:    */     }
/* 104:    */     else
/* 105:    */     {
/* 106: 33 */       this.btnEliminarImagen.setVisible(false);
/* 107: 34 */       this.spnTiempoAutorizacion.setModel(this.modeltau);
/* 108:    */     }
/* 109: 36 */     inicializarInstancias();
/* 110:    */   }
/* 111:    */   
/* 112:    */   private void inicializarInstancias()
/* 113:    */   {
/* 114: 40 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtPuntoEmision, Integer.valueOf(3));
/* 115: 41 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtCodEstablecimiento, Integer.valueOf(3));
/* 116: 42 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtRuc, Integer.valueOf(13));
/* 117: 43 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtContribuyenteEspecial, Integer.valueOf(5));
/* 118: 44 */     this.listenerUtil.listenerLongitud(this.txtRazonSocial, Integer.valueOf(300));
/* 119: 45 */     this.listenerUtil.listenerLongitud(this.txtNombreComercial, Integer.valueOf(300));
/* 120:    */   }
/* 121:    */   
/* 122:    */   private void loadEmisor()
/* 123:    */   {
/* 124:    */     try
/* 125:    */     {
/* 126: 51 */       EmisorSQL emiSQL = new EmisorSQL();
/* 127: 52 */       Emisor em = emiSQL.obtenerDatosEmisor();
/* 128: 53 */       if (em != null) {
/* 129: 54 */         this.emisor = em;
/* 130:    */       }
/* 131:    */     }
/* 132:    */     catch (SQLException ex)
/* 133:    */     {
/* 134: 57 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 135:    */     }
/* 136:    */     catch (ClassNotFoundException ex)
/* 137:    */     {
/* 138: 59 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   public EmisorView(Emisor emi)
/* 143:    */   {
/* 144: 64 */     this.emisor = emi;
/* 145: 65 */     setModelCombo();
/* 146: 66 */     initComponentesParametro();
/* 147: 67 */     inicializarInstancias();
/* 148:    */   }
/* 149:    */   
/* 150:    */   private void initComponentesParametro()
/* 151:    */   {
/* 152: 71 */     this.txtRuc.setText(this.emisor.getRuc());
/* 153: 72 */     this.txtRazonSocial.setText(this.emisor.getRazonSocial());
/* 154: 73 */     this.txtNombreComercial.setText(this.emisor.getNombreComercial());
/* 155: 74 */     this.txtDirEstablecimiento.setText(this.emisor.getDirEstablecimiento());
/* 156: 75 */     this.txtCodEstablecimiento.setText(this.emisor.getCodigoEstablecimiento());
/* 157: 76 */     this.txtPuntoEmision.setText(this.emisor.getCodPuntoEmision());
/* 158: 77 */     this.txtImagen.setText(this.emisor.getPathLogo());
/* 159: 78 */     this.txtContribuyenteEspecial.setText(this.emisor.getContribuyenteEspecial());
/* 160: 79 */     if ((this.emisor.getLlevaContabilidad() == null) || (this.emisor.getLlevaContabilidad().equals(SiNoEnum.NO.getCode()))) {
/* 161: 80 */       this.chkLlevaContabilidad.setSelected(false);
/* 162:    */     } else {
/* 163: 82 */       this.chkLlevaContabilidad.setSelected(true);
/* 164:    */     }
/* 165: 84 */     this.cbxTipoEmision.setSelectedItem(StringUtil.obtenerNumeroTipoEmision(this.emisor.getTipoEmision()));
/* 166: 85 */     String item = StringUtil.getSelectedTipoAmbiente(this.emisor.getTipoAmbiente());
/* 167: 86 */     this.cbxAmbiente.setSelectedItem(TipoAmbienteEnum.valueOf(item));
/* 168: 87 */     this.txtDireccionMatriz.setText(this.emisor.getDireccionMatriz());
/* 169: 88 */     this.cbxComboTokens.setSelectedItem(TokensValidos.valueOf(TokensValidos.class, this.emisor.getToken()));
/* 170: 89 */     this.spnTiempoAutorizacion.setModel(this.modeltau);
/* 171: 90 */     this.spnTiempoAutorizacion.setValue(this.emisor.getTiempoEspera());
/* 172: 91 */     renderImageneliminar(this.emisor);
/* 173:    */   }
/* 174:    */   
/* 175:    */   private void setModelCombo()
/* 176:    */   {
/* 177: 95 */     List<String> items = new ArrayList();
/* 178: 96 */     for (TipoEmisionEnum enumer : TipoEmisionEnum.values()) {
/* 179: 97 */       items.add(enumer.getCode());
/* 180:    */     }
/* 181: 99 */     DefaultComboBoxModel cm = new DefaultComboBoxModel(items.toArray());
/* 182:100 */     this.cbxTipoEmision.setModel(cm);
/* 183:    */   }
/* 184:    */   
/* 185:    */   private void initComponents()
/* 186:    */   {
/* 187:112 */     this.jPanel3 = new JPanel();
/* 188:113 */     this.lblRuc = new JLabel();
/* 189:114 */     this.lblRazonSocial = new JLabel();
/* 190:115 */     this.lblNombreComercial = new JLabel();
/* 191:116 */     this.lblDirEstablecimiento = new JLabel();
/* 192:117 */     this.txtRuc = new JTextField();
/* 193:118 */     this.txtRazonSocial = new JTextField();
/* 194:119 */     this.txtNombreComercial = new JTextField();
/* 195:120 */     this.Jscroll1 = new JScrollPane();
/* 196:121 */     this.txtDirEstablecimiento = new JTextArea();
/* 197:122 */     this.lblCodiEstablecimietno = new JLabel();
/* 198:123 */     this.txtCodEstablecimiento = new JTextField();
/* 199:124 */     this.lblPuntoEmision = new JLabel();
/* 200:125 */     this.lblContribuyenteEspecial = new JLabel();
/* 201:126 */     this.txtPuntoEmision = new JTextField();
/* 202:127 */     this.lblObligadoContabilidad = new JLabel();
/* 203:128 */     this.chkLlevaContabilidad = new JCheckBox();
/* 204:129 */     this.lblImagen = new JLabel();
/* 205:130 */     this.txtImagen = new JTextField();
/* 206:131 */     this.btnImagen = new JButton();
/* 207:132 */     this.lblTipoEmision = new JLabel();
/* 208:133 */     this.cbxTipoEmision = new JComboBox();
/* 209:134 */     this.spnTiempoAutorizacion = new JSpinner();
/* 210:135 */     this.lblTiempoEspera = new JLabel();
/* 211:136 */     this.jPanel4 = new JPanel();
/* 212:137 */     this.jButton2 = new JButton();
/* 213:138 */     this.lblTipoAmbiente = new JLabel();
/* 214:139 */     this.cbxAmbiente = new JComboBox();
/* 215:140 */     this.txtContribuyenteEspecial = new JTextField();
/* 216:141 */     this.lblDirMatriz = new JLabel();
/* 217:142 */     this.jScroll2 = new JScrollPane();
/* 218:143 */     this.txtDireccionMatriz = new JTextArea();
/* 219:144 */     this.jLabel14 = new JLabel();
/* 220:145 */     this.lblToken = new JLabel();
/* 221:146 */     this.cbxComboTokens = new JComboBox();
/* 222:147 */     this.btnEliminarImagen = new JButton();
/* 223:    */     
/* 224:149 */     setName("Form");
/* 225:    */     
/* 226:151 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(EmisorView.class);
/* 227:152 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/* 228:153 */     this.jPanel3.setName("jPanel3");
/* 229:    */     
/* 230:155 */     this.lblRuc.setText(resourceMap.getString("lblRuc.text", new Object[0]));
/* 231:156 */     this.lblRuc.setName("lblRuc");
/* 232:    */     
/* 233:158 */     this.lblRazonSocial.setText(resourceMap.getString("lblRazonSocial.text", new Object[0]));
/* 234:159 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 235:    */     
/* 236:161 */     this.lblNombreComercial.setText(resourceMap.getString("lblNombreComercial.text", new Object[0]));
/* 237:162 */     this.lblNombreComercial.setName("lblNombreComercial");
/* 238:    */     
/* 239:164 */     this.lblDirEstablecimiento.setText(resourceMap.getString("lblDirEstablecimiento.text", new Object[0]));
/* 240:165 */     this.lblDirEstablecimiento.setName("lblDirEstablecimiento");
/* 241:    */     
/* 242:167 */     this.txtRuc.setToolTipText(resourceMap.getString("txtRuc.toolTipText", new Object[0]));
/* 243:168 */     this.txtRuc.setName("txtRuc");
/* 244:169 */     this.txtRuc.setSelectedTextColor(resourceMap.getColor("txtRuc.selectedTextColor"));
/* 245:170 */     this.txtRuc.setSelectionColor(resourceMap.getColor("txtRuc.selectionColor"));
/* 246:    */     
/* 247:172 */     this.txtRazonSocial.setToolTipText(resourceMap.getString("txtRazonSocial.toolTipText", new Object[0]));
/* 248:173 */     this.txtRazonSocial.setName("txtRazonSocial");
/* 249:174 */     this.txtRazonSocial.setSelectedTextColor(resourceMap.getColor("txtRazonSocial.selectedTextColor"));
/* 250:175 */     this.txtRazonSocial.setSelectionColor(resourceMap.getColor("txtRazonSocial.selectionColor"));
/* 251:    */     
/* 252:177 */     this.txtNombreComercial.setToolTipText(resourceMap.getString("txtNombreComercial.toolTipText", new Object[0]));
/* 253:178 */     this.txtNombreComercial.setName("txtNombreComercial");
/* 254:179 */     this.txtNombreComercial.setSelectedTextColor(resourceMap.getColor("txtNombreComercial.selectedTextColor"));
/* 255:    */     
/* 256:181 */     this.Jscroll1.setName("Jscroll1");
/* 257:    */     
/* 258:183 */     this.txtDirEstablecimiento.setColumns(20);
/* 259:184 */     this.txtDirEstablecimiento.setRows(5);
/* 260:185 */     this.txtDirEstablecimiento.setTabSize(2);
/* 261:186 */     this.txtDirEstablecimiento.setToolTipText(resourceMap.getString("txtDirEstablecimiento.toolTipText", new Object[0]));
/* 262:187 */     this.txtDirEstablecimiento.setName("txtDirEstablecimiento");
/* 263:188 */     this.txtDirEstablecimiento.setSelectedTextColor(resourceMap.getColor("txtDirEstablecimiento.selectedTextColor"));
/* 264:189 */     this.txtDirEstablecimiento.setSelectionColor(resourceMap.getColor("txtDirEstablecimiento.selectionColor"));
/* 265:190 */     this.txtDirEstablecimiento.addFocusListener(new FocusAdapter()
/* 266:    */     {
/* 267:    */       public void focusLost(FocusEvent evt)
/* 268:    */       {
/* 269:192 */         EmisorView.this.txtDirEstablecimientoFocusLost(evt);
/* 270:    */       }
/* 271:194 */     });
/* 272:195 */     this.Jscroll1.setViewportView(this.txtDirEstablecimiento);
/* 273:    */     
/* 274:197 */     this.lblCodiEstablecimietno.setText(resourceMap.getString("lblCodiEstablecimietno.text", new Object[0]));
/* 275:198 */     this.lblCodiEstablecimietno.setName("lblCodiEstablecimietno");
/* 276:    */     
/* 277:200 */     this.txtCodEstablecimiento.setToolTipText(resourceMap.getString("txtCodEstablecimiento.toolTipText", new Object[0]));
/* 278:201 */     this.txtCodEstablecimiento.setName("txtCodEstablecimiento");
/* 279:202 */     this.txtCodEstablecimiento.setSelectedTextColor(resourceMap.getColor("txtCodEstablecimiento.selectedTextColor"));
/* 280:    */     
/* 281:204 */     this.lblPuntoEmision.setText(resourceMap.getString("lblPuntoEmision.text", new Object[0]));
/* 282:205 */     this.lblPuntoEmision.setName("lblPuntoEmision");
/* 283:    */     
/* 284:207 */     this.lblContribuyenteEspecial.setText(resourceMap.getString("lblContribuyenteEspecial.text", new Object[0]));
/* 285:208 */     this.lblContribuyenteEspecial.setName("lblContribuyenteEspecial");
/* 286:    */     
/* 287:210 */     this.txtPuntoEmision.setToolTipText(resourceMap.getString("txtPuntoEmision.toolTipText", new Object[0]));
/* 288:211 */     this.txtPuntoEmision.setName("txtPuntoEmision");
/* 289:212 */     this.txtPuntoEmision.setSelectedTextColor(resourceMap.getColor("txtPuntoEmision.selectedTextColor"));
/* 290:    */     
/* 291:214 */     this.lblObligadoContabilidad.setText(resourceMap.getString("lblObligadoContabilidad.text", new Object[0]));
/* 292:215 */     this.lblObligadoContabilidad.setName("lblObligadoContabilidad");
/* 293:    */     
/* 294:217 */     this.chkLlevaContabilidad.setName("chkLlevaContabilidad");
/* 295:    */     
/* 296:219 */     this.lblImagen.setText(resourceMap.getString("lblImagen.text", new Object[0]));
/* 297:220 */     this.lblImagen.setName("lblImagen");
/* 298:    */     
/* 299:222 */     this.txtImagen.setDisabledTextColor(resourceMap.getColor("txtImagen.disabledTextColor"));
/* 300:223 */     this.txtImagen.setEnabled(false);
/* 301:224 */     this.txtImagen.setName("txtImagen");
/* 302:    */     
/* 303:226 */     this.btnImagen.setText(resourceMap.getString("btnImagen.text", new Object[0]));
/* 304:227 */     this.btnImagen.setToolTipText(resourceMap.getString("btnImagen.toolTipText", new Object[0]));
/* 305:228 */     this.btnImagen.setName("btnImagen");
/* 306:229 */     this.btnImagen.addActionListener(new ActionListener()
/* 307:    */     {
/* 308:    */       public void actionPerformed(ActionEvent evt)
/* 309:    */       {
/* 310:231 */         EmisorView.this.btnImagenActionPerformed(evt);
/* 311:    */       }
/* 312:234 */     });
/* 313:235 */     this.lblTipoEmision.setText(resourceMap.getString("lblTipoEmision.text", new Object[0]));
/* 314:236 */     this.lblTipoEmision.setName("lblTipoEmision");
/* 315:    */     
/* 316:238 */     this.cbxTipoEmision.setToolTipText(resourceMap.getString("cbxTipoEmision.toolTipText", new Object[0]));
/* 317:239 */     this.cbxTipoEmision.setName("cbxTipoEmision");
/* 318:    */     
/* 319:241 */     this.spnTiempoAutorizacion.setToolTipText(resourceMap.getString("spnTiempoAutorizacion.toolTipText", new Object[0]));
/* 320:242 */     this.spnTiempoAutorizacion.setName("spnTiempoAutorizacion");
/* 321:    */     
/* 322:244 */     this.lblTiempoEspera.setText(resourceMap.getString("lblTiempoEspera.text", new Object[0]));
/* 323:245 */     this.lblTiempoEspera.setName("lblTiempoEspera");
/* 324:    */     
/* 325:247 */     this.jPanel4.setBackground(resourceMap.getColor("jPanel4.background"));
/* 326:248 */     this.jPanel4.setBorder(new SoftBevelBorder(0));
/* 327:249 */     this.jPanel4.setName("jPanel4");
/* 328:    */     
/* 329:251 */     this.jButton2.setText(resourceMap.getString("jButton2.text", new Object[0]));
/* 330:252 */     this.jButton2.setToolTipText(resourceMap.getString("jButton2.toolTipText", new Object[0]));
/* 331:253 */     this.jButton2.setName("jButton2");
/* 332:254 */     this.jButton2.addActionListener(new ActionListener()
/* 333:    */     {
/* 334:    */       public void actionPerformed(ActionEvent evt)
/* 335:    */       {
/* 336:256 */         EmisorView.this.jButton2ActionPerformed(evt);
/* 337:    */       }
/* 338:259 */     });
/* 339:260 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 340:261 */     this.jPanel4.setLayout(jPanel4Layout);
/* 341:262 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(690, 32767).addComponent(this.jButton2).addGap(42, 42, 42)));
/* 342:    */     
/* 343:    */ 
/* 344:    */ 
/* 345:    */ 
/* 346:    */ 
/* 347:    */ 
/* 348:269 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton2).addContainerGap(-1, 32767)));
/* 349:    */     
/* 350:    */ 
/* 351:    */ 
/* 352:    */ 
/* 353:    */ 
/* 354:    */ 
/* 355:    */ 
/* 356:277 */     this.lblTipoAmbiente.setText(resourceMap.getString("lblTipoAmbiente.text", new Object[0]));
/* 357:278 */     this.lblTipoAmbiente.setName("lblTipoAmbiente");
/* 358:    */     
/* 359:280 */     this.cbxAmbiente.setModel(new DefaultComboBoxModel(TipoAmbienteEnum.values()));
/* 360:281 */     this.cbxAmbiente.setToolTipText(resourceMap.getString("cbxAmbiente.toolTipText", new Object[0]));
/* 361:282 */     this.cbxAmbiente.setName("cbxAmbiente");
/* 362:    */     
/* 363:284 */     this.txtContribuyenteEspecial.setText(resourceMap.getString("txtContribuyenteEspecial.text", new Object[0]));
/* 364:285 */     this.txtContribuyenteEspecial.setName("txtContribuyenteEspecial");
/* 365:    */     
/* 366:287 */     this.lblDirMatriz.setText(resourceMap.getString("lblDirMatriz.text", new Object[0]));
/* 367:288 */     this.lblDirMatriz.setName("lblDirMatriz");
/* 368:    */     
/* 369:290 */     this.jScroll2.setName("jScroll2");
/* 370:    */     
/* 371:292 */     this.txtDireccionMatriz.setColumns(20);
/* 372:293 */     this.txtDireccionMatriz.setRows(5);
/* 373:294 */     this.txtDireccionMatriz.setTabSize(2);
/* 374:295 */     this.txtDireccionMatriz.setToolTipText(resourceMap.getString("txtDireccionMatriz.toolTipText", new Object[0]));
/* 375:296 */     this.txtDireccionMatriz.setName("txtDireccionMatriz");
/* 376:297 */     this.txtDireccionMatriz.addFocusListener(new FocusAdapter()
/* 377:    */     {
/* 378:    */       public void focusLost(FocusEvent evt)
/* 379:    */       {
/* 380:299 */         EmisorView.this.txtDireccionMatrizFocusLost(evt);
/* 381:    */       }
/* 382:301 */     });
/* 383:302 */     this.jScroll2.setViewportView(this.txtDireccionMatriz);
/* 384:    */     
/* 385:304 */     this.jLabel14.setText(resourceMap.getString("jLabel14.text", new Object[0]));
/* 386:305 */     this.jLabel14.setName("jLabel14");
/* 387:    */     
/* 388:307 */     this.lblToken.setText(resourceMap.getString("lblToken.text", new Object[0]));
/* 389:308 */     this.lblToken.setName("lblToken");
/* 390:    */     
/* 391:310 */     this.cbxComboTokens.setModel(new DefaultComboBoxModel(TokensValidos.values()));
/* 392:311 */     this.cbxComboTokens.setToolTipText(resourceMap.getString("cbxComboTokens.toolTipText", new Object[0]));
/* 393:312 */     this.cbxComboTokens.setName("cbxComboTokens");
/* 394:    */     
/* 395:314 */     this.btnEliminarImagen.setIcon(new ImageIcon("resources/icons/eliminar.gif"));
/* 396:315 */     this.btnEliminarImagen.setToolTipText(resourceMap.getString("btnEliminarImagen.toolTipText", new Object[0]));
/* 397:316 */     this.btnEliminarImagen.setName("btnEliminarImagen");
/* 398:317 */     this.btnEliminarImagen.addActionListener(new ActionListener()
/* 399:    */     {
/* 400:    */       public void actionPerformed(ActionEvent evt)
/* 401:    */       {
/* 402:319 */         EmisorView.this.btnEliminarImagenActionPerformed(evt);
/* 403:    */       }
/* 404:322 */     });
/* 405:323 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 406:324 */     this.jPanel3.setLayout(jPanel3Layout);
/* 407:325 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblRuc).addComponent(this.lblRazonSocial, -2, -1, -2).addComponent(this.lblNombreComercial).addComponent(this.lblDirMatriz).addComponent(this.lblDirEstablecimiento).addComponent(this.lblCodiEstablecimietno).addComponent(this.lblContribuyenteEspecial, 0, 0, 32767).addComponent(this.lblObligadoContabilidad).addComponent(this.lblImagen).addComponent(this.lblTipoEmision).addComponent(this.lblTiempoEspera, -1, 191, 32767).addComponent(this.lblTipoAmbiente).addComponent(this.lblToken)).addGap(45, 45, 45).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.chkLlevaContabilidad).addGap(514, 514, 514)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.txtImagen, -2, 371, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnImagen, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnEliminarImagen, -2, 40, -2)).addComponent(this.jScroll2, -1, 590, 32767).addComponent(this.txtNombreComercial, -1, 590, 32767).addComponent(this.txtRazonSocial, -1, 590, 32767).addComponent(this.txtRuc, -2, 177, -2).addComponent(this.Jscroll1, -1, 590, 32767).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtContribuyenteEspecial, GroupLayout.Alignment.LEADING).addComponent(this.txtCodEstablecimiento, GroupLayout.Alignment.LEADING, -1, 132, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 148, 32767).addComponent(this.lblPuntoEmision, -2, -1, -2).addGap(18, 18, 18).addComponent(this.txtPuntoEmision, -2, 184, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.cbxComboTokens, GroupLayout.Alignment.LEADING, 0, 383, 32767).addComponent(this.cbxAmbiente, GroupLayout.Alignment.LEADING, 0, 383, 32767).addComponent(this.spnTiempoAutorizacion, GroupLayout.Alignment.LEADING, -1, 383, 32767).addComponent(this.cbxTipoEmision, GroupLayout.Alignment.LEADING, 0, 383, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addGap(131, 131, 131))).addGap(77, 77, 77)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addContainerGap(101, 32767)))));
/* 408:    */     
/* 409:    */ 
/* 410:    */ 
/* 411:    */ 
/* 412:    */ 
/* 413:    */ 
/* 414:    */ 
/* 415:    */ 
/* 416:    */ 
/* 417:    */ 
/* 418:    */ 
/* 419:    */ 
/* 420:    */ 
/* 421:    */ 
/* 422:    */ 
/* 423:    */ 
/* 424:    */ 
/* 425:    */ 
/* 426:    */ 
/* 427:    */ 
/* 428:    */ 
/* 429:    */ 
/* 430:    */ 
/* 431:    */ 
/* 432:    */ 
/* 433:    */ 
/* 434:    */ 
/* 435:    */ 
/* 436:    */ 
/* 437:    */ 
/* 438:    */ 
/* 439:    */ 
/* 440:    */ 
/* 441:    */ 
/* 442:    */ 
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
/* 465:383 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblRuc).addComponent(this.txtRuc, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblRazonSocial, -2, -1, -2).addComponent(this.txtRazonSocial, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblNombreComercial).addComponent(this.txtNombreComercial, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblDirMatriz).addComponent(this.jScroll2, -2, 63, -2)).addGap(34, 34, 34).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblDirEstablecimiento).addComponent(this.Jscroll1, -2, 61, -2)).addGap(43, 43, 43).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblCodiEstablecimietno).addComponent(this.txtCodEstablecimiento, -2, -1, -2).addComponent(this.lblPuntoEmision, -2, -1, -2).addComponent(this.txtPuntoEmision, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblContribuyenteEspecial, -2, -1, -2).addComponent(this.txtContribuyenteEspecial, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblObligadoContabilidad).addComponent(this.chkLlevaContabilidad)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblImagen).addComponent(this.txtImagen, -2, -1, -2).addComponent(this.btnImagen).addComponent(this.btnEliminarImagen, -2, 27, -2)).addGap(13, 13, 13).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblTipoEmision).addComponent(this.cbxTipoEmision, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel14).addComponent(this.spnTiempoAutorizacion, -2, -1, -2).addComponent(this.lblTiempoEspera, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.cbxAmbiente, -2, -1, -2).addComponent(this.lblTipoAmbiente)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbxComboTokens, -2, -1, -2).addComponent(this.lblToken)).addGap(18, 18, 18).addComponent(this.jPanel4, -2, -1, -2).addContainerGap(-1, 32767)));
/* 466:    */     
/* 467:    */ 
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
/* 491:    */ 
/* 492:    */ 
/* 493:    */ 
/* 494:    */ 
/* 495:    */ 
/* 496:    */ 
/* 497:    */ 
/* 498:    */ 
/* 499:    */ 
/* 500:    */ 
/* 501:    */ 
/* 502:    */ 
/* 503:    */ 
/* 504:    */ 
/* 505:    */ 
/* 506:    */ 
/* 507:    */ 
/* 508:    */ 
/* 509:    */ 
/* 510:    */ 
/* 511:    */ 
/* 512:    */ 
/* 513:    */ 
/* 514:    */ 
/* 515:    */ 
/* 516:    */ 
/* 517:    */ 
/* 518:    */ 
/* 519:    */ 
/* 520:    */ 
/* 521:    */ 
/* 522:    */ 
/* 523:    */ 
/* 524:    */ 
/* 525:    */ 
/* 526:    */ 
/* 527:    */ 
/* 528:    */ 
/* 529:    */ 
/* 530:448 */     GroupLayout layout = new GroupLayout(this);
/* 531:449 */     setLayout(layout);
/* 532:450 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
/* 533:    */     
/* 534:    */ 
/* 535:    */ 
/* 536:    */ 
/* 537:    */ 
/* 538:    */ 
/* 539:457 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -1, 812, 32767).addContainerGap()));
/* 540:    */   }
/* 541:    */   
/* 542:    */   private void btnImagenActionPerformed(ActionEvent evt)
/* 543:    */   {
/* 544:466 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserImg();
/* 545:467 */     if (jfc.getSelectedFile() != null) {
/* 546:468 */       this.txtImagen.setText(jfc.getSelectedFile().getPath());
/* 547:    */     }
/* 548:    */   }
/* 549:    */   
/* 550:    */   private void jButton2ActionPerformed(ActionEvent evt)
/* 551:    */   {
/* 552:473 */     guardarActualizarEmisor();
/* 553:    */   }
/* 554:    */   
/* 555:    */   private void renderImageneliminar(Emisor emisorRenderImage)
/* 556:    */   {
/* 557:477 */     if ((emisorRenderImage.getPathLogo() != null) && (!emisorRenderImage.getPathLogo().isEmpty())) {
/* 558:478 */       this.btnEliminarImagen.setVisible(true);
/* 559:    */     } else {
/* 560:480 */       this.btnEliminarImagen.setVisible(false);
/* 561:    */     }
/* 562:    */   }
/* 563:    */   
/* 564:    */   private Emisor existeEmisor()
/* 565:    */   {
/* 566:485 */     EmisorSQL emisorExiste = new EmisorSQL();
/* 567:    */     try
/* 568:    */     {
/* 569:487 */       return emisorExiste.obtenerDatosEmisor();
/* 570:    */     }
/* 571:    */     catch (SQLException ex)
/* 572:    */     {
/* 573:489 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 574:    */     }
/* 575:    */     catch (ClassNotFoundException ex)
/* 576:    */     {
/* 577:491 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 578:    */     }
/* 579:493 */     return null;
/* 580:    */   }
/* 581:    */   
/* 582:    */   private void presentarMensajeEmisor(Emisor em)
/* 583:    */   {
/* 584:496 */     if (em == null) {
/* 585:497 */       JOptionPane.showMessageDialog(this, "Se ha creado con éxito los datos del Emisor.\nDebe reiniciar la aplicación para poder emitir comprobantes");
/* 586:    */     } else {
/* 587:499 */       JOptionPane.showMessageDialog(this, "Se han guardado con éxito los datos del Emisor");
/* 588:    */     }
/* 589:    */   }
/* 590:    */   
/* 591:    */   private void guardarActualizarEmisor()
/* 592:    */   {
/* 593:    */     try
/* 594:    */     {
/* 595:504 */       Emisor emisorNuevo = existeEmisor();
/* 596:505 */       String valido = validarCampos();
/* 597:506 */       if (valido == null)
/* 598:    */       {
/* 599:507 */         EmisorSQL emiSQL = new EmisorSQL();
/* 600:508 */         Emisor em = obtenerEmisorModelo();
/* 601:509 */         emiSQL.crearEmisor(em);
/* 602:510 */         renderImageneliminar(em);
/* 603:511 */         presentarMensajeEmisor(emisorNuevo);
/* 604:    */       }
/* 605:    */       else
/* 606:    */       {
/* 607:514 */         JOptionPane.showMessageDialog(this, valido, "Error", 0);
/* 608:    */       }
/* 609:    */     }
/* 610:    */     catch (SQLException ex)
/* 611:    */     {
/* 612:517 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 613:    */     }
/* 614:    */     catch (ClassNotFoundException ex)
/* 615:    */     {
/* 616:519 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 617:    */     }
/* 618:    */   }
/* 619:    */   
/* 620:    */   private void txtDirEstablecimientoFocusLost(FocusEvent evt)
/* 621:    */   {
/* 622:525 */     if ((this.txtDirEstablecimiento.getText() != null) && (this.txtDirEstablecimiento.getText().length() > 300)) {
/* 623:526 */       JOptionPane.showMessageDialog(new JPanel(), "La longitud del campo Dirección de Establecimiento es maximo de 300 caracteres", "ERROR", 0);
/* 624:    */     }
/* 625:    */   }
/* 626:    */   
/* 627:    */   private void txtDireccionMatrizFocusLost(FocusEvent evt)
/* 628:    */   {
/* 629:531 */     if ((this.txtDireccionMatriz.getText() != null) && (this.txtDireccionMatriz.getText().length() > 300)) {
/* 630:532 */       JOptionPane.showMessageDialog(new JPanel(), "La longitud del campo Dirección de Matriz es maximo de 300 caracteres", "ERROR", 0);
/* 631:    */     }
/* 632:    */   }
/* 633:    */   
/* 634:    */   private void btnEliminarImagenActionPerformed(ActionEvent evt)
/* 635:    */   {
/* 636:    */     try
/* 637:    */     {
/* 638:538 */       this.txtImagen.setText(null);
/* 639:539 */       EmisorSQL emisorSQl = new EmisorSQL();
/* 640:540 */       emisorSQl.actualizarImagen(this.txtImagen.getText());
/* 641:541 */       this.btnEliminarImagen.setVisible(false);
/* 642:542 */       JOptionPane.showMessageDialog(this, "Se ha actualizado con éxito el emisor");
/* 643:    */     }
/* 644:    */     catch (SQLException ex)
/* 645:    */     {
/* 646:544 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 647:    */     }
/* 648:    */     catch (ClassNotFoundException ex)
/* 649:    */     {
/* 650:546 */       Logger.getLogger(EmisorView.class.getName()).log(Level.SEVERE, null, ex);
/* 651:    */     }
/* 652:    */   }
/* 653:    */   
/* 654:    */   private String validarCampos()
/* 655:    */   {
/* 656:551 */     if (validarObligatorios() != null) {
/* 657:552 */       return validarObligatorios();
/* 658:    */     }
/* 659:554 */     if (validarLongitudCampos() != null) {
/* 660:555 */       return validarLongitudCampos();
/* 661:    */     }
/* 662:557 */     if (validarLongitudMayor() != null) {
/* 663:558 */       return validarLongitudMayor();
/* 664:    */     }
/* 665:560 */     return validarCamposExpresion();
/* 666:    */   }
/* 667:    */   
/* 668:    */   private String validarObligatorios()
/* 669:    */   {
/* 670:564 */     HashMap<String, String> mapaCampos = new HashMap();
/* 671:565 */     mapaCampos.put(this.txtRuc.getText(), "RUC");
/* 672:566 */     mapaCampos.put(this.txtRazonSocial.getText(), "Razón Social");
/* 673:567 */     mapaCampos.put(this.txtPuntoEmision.getText(), "Punto de emisión");
/* 674:568 */     mapaCampos.put(this.txtCodEstablecimiento.getText(), "Código Establecimiento");
/* 675:569 */     mapaCampos.put(this.txtDireccionMatriz.getText(), "Dirección Matriz");
/* 676:570 */     return ValidadorCampos.validarCampoObligatorio(mapaCampos);
/* 677:    */   }
/* 678:    */   
/* 679:    */   private String validarLongitudCampos()
/* 680:    */   {
/* 681:574 */     List<CampoModelo> listaCampos = new ArrayList();
/* 682:575 */     listaCampos.add(obtenerCampoModelo(this.txtRuc.getText(), "RUC", Integer.valueOf(13)));
/* 683:576 */     listaCampos.add(obtenerCampoModelo(this.txtPuntoEmision.getText(), "Punto emisión", Integer.valueOf(3)));
/* 684:577 */     listaCampos.add(obtenerCampoModelo(this.txtCodEstablecimiento.getText(), "Código Establecimiento", Integer.valueOf(3)));
/* 685:578 */     return ValidadorCampos.validarCampoLongitudDiferente(listaCampos);
/* 686:    */   }
/* 687:    */   
/* 688:    */   private String validarLongitudMayor()
/* 689:    */   {
/* 690:582 */     List<CampoModelo> listaCampos = new ArrayList();
/* 691:583 */     listaCampos.add(obtenerCampoModelo(this.txtDirEstablecimiento.getText(), "Dirección Establecimiento", Integer.valueOf(300)));
/* 692:584 */     listaCampos.add(obtenerCampoModelo(this.txtDireccionMatriz.getText(), "Dirección Matriz", Integer.valueOf(300)));
/* 693:585 */     listaCampos.add(obtenerCampoModelo(this.txtRazonSocial.getText(), "Razón Social", Integer.valueOf(300)));
/* 694:586 */     listaCampos.add(obtenerCampoModelo(this.txtNombreComercial.getText(), "Nombre Comercial", Integer.valueOf(300)));
/* 695:587 */     return ValidadorCampos.validarCampoLongitudMayor(listaCampos);
/* 696:    */   }
/* 697:    */   
/* 698:    */   private CampoModelo obtenerCampoModelo(String valor, String etiqueta, Integer longitud)
/* 699:    */   {
/* 700:591 */     return new CampoModelo(valor, etiqueta, longitud);
/* 701:    */   }
/* 702:    */   
/* 703:    */   private String validarCamposExpresion()
/* 704:    */   {
/* 705:595 */     if ((this.txtRuc.getText() != null) && (!StringUtil.validarExpresionRegular("\\d{10}001", this.txtRuc.getText()))) {
/* 706:596 */       return "La longitud del campo ruc es de 13 caracteres númericos y debe terminar en 001";
/* 707:    */     }
/* 708:598 */     if ((this.txtPuntoEmision.getText() != null) && (!StringUtil.validarExpresionRegular("\\d{3}", this.txtPuntoEmision.getText()))) {
/* 709:599 */       return "La longitud del campo Punto de Emisión es de 3 caracteres numéricos ";
/* 710:    */     }
/* 711:601 */     if ((this.txtCodEstablecimiento.getText() != null) && (!StringUtil.validarExpresionRegular("\\d{3}", this.txtCodEstablecimiento.getText()))) {
/* 712:602 */       return "La longitud del campo Código Establecimiento es de 3 caracteres  numéricos ";
/* 713:    */     }
/* 714:604 */     if ((this.txtContribuyenteEspecial.getText() != null) && (!this.txtContribuyenteEspecial.getText().isEmpty()) && (!StringUtil.validarExpresionRegular("\\d{5}|\\d{3}|\\d{4}|", this.txtContribuyenteEspecial.getText()))) {
/* 715:605 */       return "La longitud del campo Contribuyente Especial es de mínimo 3 caracters y máximo 5 caracteres numéricos ";
/* 716:    */     }
/* 717:607 */     return null;
/* 718:    */   }
/* 719:    */   
/* 720:    */   private Emisor obtenerEmisorModelo()
/* 721:    */   {
/* 722:611 */     Emisor emi = new Emisor();
/* 723:612 */     emi.setCodigo(Integer.valueOf(1));
/* 724:613 */     emi.setRuc(this.txtRuc.getText());
/* 725:614 */     emi.setRazonSocial(this.txtRazonSocial.getText());
/* 726:615 */     emi.setNombreComercial(this.txtNombreComercial.getText());
/* 727:616 */     emi.setDirEstablecimiento(this.txtDirEstablecimiento.getText());
/* 728:617 */     emi.setCodigoEstablecimiento(this.txtCodEstablecimiento.getText());
/* 729:618 */     emi.setNumeroResolusion("");
/* 730:619 */     emi.setCodPuntoEmision(this.txtPuntoEmision.getText());
/* 731:620 */     emi.setPathLogo(this.txtImagen.getText());
/* 732:621 */     emi.setTiempoEspera(new Integer(this.spnTiempoAutorizacion.getValue().toString()));
/* 733:622 */     emi.setContribuyenteEspecial(this.txtContribuyenteEspecial.getText());
/* 734:623 */     if (this.chkLlevaContabilidad.isSelected()) {
/* 735:624 */       emi.setLlevaContabilidad(SiNoEnum.SI.getCode());
/* 736:    */     } else {
/* 737:626 */       emi.setLlevaContabilidad(SiNoEnum.NO.getCode());
/* 738:    */     }
/* 739:628 */     emi.setTipoEmision(StringUtil.obtenerTipoEmision(this.cbxTipoEmision.getSelectedItem().toString()));
/* 740:629 */     emi.setPathLogo(this.txtImagen.getText());
/* 741:630 */     emi.setTipoAmbiente(((TipoAmbienteEnum)this.cbxAmbiente.getSelectedItem()).getCode());
/* 742:631 */     emi.setDireccionMatriz(this.txtDireccionMatriz.getText());
/* 743:632 */     emi.setClaveInterna("12345678");
/* 744:633 */     emi.setToken(((TokensValidos)this.cbxComboTokens.getSelectedItem()).name());
/* 745:634 */     return emi;
/* 746:    */   }
/* 747:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.EmisorView
 * JD-Core Version:    0.7.0.1
 */