/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.CampoModelo;
/*   7:    */ import ec.gob.sri.comprobantes.util.ConstantesDimensiones;
/*   8:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   9:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  10:    */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*  11:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
/*  12:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  13:    */ import ec.gob.sri.comprobantes.view.modals.DialogoCliente;
/*  14:    */ import java.awt.Container;
/*  15:    */ import java.awt.event.ActionEvent;
/*  16:    */ import java.awt.event.ActionListener;
/*  17:    */ import java.sql.SQLException;
/*  18:    */ import java.util.ArrayList;
/*  19:    */ import java.util.List;
/*  20:    */ import javax.swing.BorderFactory;
/*  21:    */ import javax.swing.DefaultComboBoxModel;
/*  22:    */ import javax.swing.GroupLayout;
/*  23:    */ import javax.swing.GroupLayout.Alignment;
/*  24:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  25:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  26:    */ import javax.swing.JButton;
/*  27:    */ import javax.swing.JComboBox;
/*  28:    */ import javax.swing.JLabel;
/*  29:    */ import javax.swing.JOptionPane;
/*  30:    */ import javax.swing.JPanel;
/*  31:    */ import javax.swing.JScrollPane;
/*  32:    */ import javax.swing.JTextArea;
/*  33:    */ import javax.swing.JTextField;
/*  34:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  35:    */ import org.jdesktop.application.Application;
/*  36:    */ import org.jdesktop.application.ApplicationContext;
/*  37:    */ import org.jdesktop.application.ResourceMap;
/*  38:    */ 
/*  39:    */ public class ClienteView
/*  40:    */   extends JPanel
/*  41:    */ {
/*  42: 19 */   Clientes c = null;
/*  43:    */   public static final String ERROR_TITLE = "ERROR";
/*  44: 21 */   ListenerUtil listenerUtil = new ListenerUtil();
/*  45:    */   private JButton btnLimpiar;
/*  46:    */   private JComboBox cbxTipoCliente;
/*  47:    */   private JComboBox cbxTipoIdentificacion;
/*  48:    */   private JButton jButton1;
/*  49:    */   private JButton jButton2;
/*  50:    */   private JLabel jLabel1;
/*  51:    */   private JPanel jPanel6;
/*  52:    */   private JScrollPane jScrollPane1;
/*  53:    */   private JLabel lblCelular;
/*  54:    */   private JLabel lblDetalleCliente;
/*  55:    */   private JLabel lblDireccion;
/*  56:    */   private JLabel lblExt;
/*  57:    */   private JLabel lblIdentificacion;
/*  58:    */   private JLabel lblMail;
/*  59:    */   private JLabel lblRazonSocial;
/*  60:    */   private JLabel lblTelefono;
/*  61:    */   private JPanel pnlCliente;
/*  62:    */   private JTextField txtCelular;
/*  63:    */   private JTextArea txtDireccion;
/*  64:    */   private JTextField txtExt;
/*  65:    */   private JTextField txtIdentificacion;
/*  66:    */   private JTextField txtMail;
/*  67:    */   private JTextField txtRazonSocial;
/*  68:    */   private JTextField txtTelefono;
/*  69:    */   
/*  70:    */   public ClienteView(Clientes c)
/*  71:    */   {
/*  72: 25 */     this.c = c;
/*  73: 26 */     initComponents();
/*  74: 27 */     loadTipoClienteCbx();
/*  75: 28 */     inicializarValidaciones();
/*  76: 29 */     setDatosClientes();
/*  77: 30 */     this.btnLimpiar.setVisible(false);
/*  78: 31 */     this.jButton1.setVisible(true);
/*  79:    */   }
/*  80:    */   
/*  81:    */   public ClienteView()
/*  82:    */   {
/*  83: 35 */     initComponents();
/*  84: 36 */     loadTipoClienteCbx();
/*  85: 37 */     inicializarValidaciones();
/*  86: 38 */     this.btnLimpiar.setVisible(true);
/*  87: 39 */     this.jButton1.setVisible(false);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public ClienteView(Boolean ocultarLimpiar)
/*  91:    */   {
/*  92: 42 */     initComponents();
/*  93: 43 */     loadTipoClienteCbx();
/*  94: 44 */     inicializarValidaciones();
/*  95: 45 */     this.btnLimpiar.setVisible(ocultarLimpiar.booleanValue());
/*  96: 46 */     this.jButton1.setVisible(true);
/*  97:    */   }
/*  98:    */   
/*  99:    */   private void inicializarValidaciones()
/* 100:    */   {
/* 101: 50 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtTelefono, Integer.valueOf(13));
/* 102: 51 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtExt, Integer.valueOf(13));
/* 103: 52 */     this.listenerUtil.listenerSolonumerosLongitud(this.txtCelular, Integer.valueOf(13));
/* 104: 53 */     StringUtil.convertirMayusculas(this.txtRazonSocial);
/* 105: 54 */     this.listenerUtil.listenerLongitud(this.txtRazonSocial, Integer.valueOf(300));
/* 106:    */   }
/* 107:    */   
/* 108:    */   private void loadTipoClienteCbx()
/* 109:    */   {
/* 110: 58 */     TipoClienteEnum[] model = new TipoClienteEnum[3];
/* 111: 59 */     int i = 0;
/* 112: 60 */     for (TipoClienteEnum clienteEnum : TipoClienteEnum.values())
/* 113:    */     {
/* 114: 61 */       model[i] = clienteEnum;
/* 115: 62 */       i++;
/* 116:    */     }
/* 117: 64 */     this.cbxTipoCliente.setModel(new DefaultComboBoxModel(model));
/* 118:    */   }
/* 119:    */   
/* 120:    */   private void setDatosClientes()
/* 121:    */   {
/* 122: 68 */     this.txtRazonSocial.setText(this.c.getApellido());
/* 123: 69 */     this.txtTelefono.setText(this.c.getTelefonoConvencional());
/* 124: 70 */     this.txtCelular.setText(this.c.getCelular());
/* 125: 71 */     this.txtExt.setText(this.c.getExtencion());
/* 126: 72 */     this.txtMail.setText(this.c.getCorreo());
/* 127: 73 */     this.cbxTipoIdentificacion.setSelectedItem(TipoIdentificacionEnum.valueOf(this.c.getTipoIdentificacion()));
/* 128: 74 */     this.txtIdentificacion.setText(this.c.getNumeroIdentificacio());
/* 129: 75 */     this.txtDireccion.setText(this.c.getDireccion());
/* 130: 76 */     this.cbxTipoCliente.setSelectedItem(TipoClienteEnum.valueOf(this.c.getTipoCliente()));
/* 131:    */   }
/* 132:    */   
/* 133:    */   private void initComponents()
/* 134:    */   {
/* 135: 83 */     this.lblDetalleCliente = new JLabel();
/* 136: 84 */     this.pnlCliente = new JPanel();
/* 137: 85 */     this.lblRazonSocial = new JLabel();
/* 138: 86 */     this.txtRazonSocial = new JTextField();
/* 139: 87 */     this.lblIdentificacion = new JLabel();
/* 140: 88 */     this.cbxTipoIdentificacion = new JComboBox();
/* 141: 89 */     this.txtIdentificacion = new JTextField();
/* 142: 90 */     this.lblDireccion = new JLabel();
/* 143: 91 */     this.jScrollPane1 = new JScrollPane();
/* 144: 92 */     this.txtDireccion = new JTextArea();
/* 145: 93 */     this.lblTelefono = new JLabel();
/* 146: 94 */     this.txtTelefono = new JTextField();
/* 147: 95 */     this.lblExt = new JLabel();
/* 148: 96 */     this.txtExt = new JTextField();
/* 149: 97 */     this.lblCelular = new JLabel();
/* 150: 98 */     this.txtCelular = new JTextField();
/* 151: 99 */     this.lblMail = new JLabel();
/* 152:100 */     this.txtMail = new JTextField();
/* 153:101 */     this.jLabel1 = new JLabel();
/* 154:102 */     this.cbxTipoCliente = new JComboBox();
/* 155:103 */     this.jPanel6 = new JPanel();
/* 156:104 */     this.jButton2 = new JButton();
/* 157:105 */     this.jButton1 = new JButton();
/* 158:106 */     this.btnLimpiar = new JButton();
/* 159:    */     
/* 160:108 */     setName("Form");
/* 161:    */     
/* 162:110 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ClienteView.class);
/* 163:111 */     this.lblDetalleCliente.setFont(resourceMap.getFont("lblDetalleCliente.font"));
/* 164:112 */     this.lblDetalleCliente.setText(resourceMap.getString("lblDetalleCliente.text", new Object[0]));
/* 165:113 */     this.lblDetalleCliente.setName("lblDetalleCliente");
/* 166:114 */     this.lblDetalleCliente.setVerticalTextPosition(1);
/* 167:    */     
/* 168:116 */     this.pnlCliente.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("pnlCliente.border.title", new Object[0])));
/* 169:117 */     this.pnlCliente.setName("pnlCliente");
/* 170:    */     
/* 171:119 */     this.lblRazonSocial.setText(resourceMap.getString("lblRazonSocial.text", new Object[0]));
/* 172:120 */     this.lblRazonSocial.setVerticalAlignment(1);
/* 173:121 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 174:    */     
/* 175:123 */     this.txtRazonSocial.setText(resourceMap.getString("txtRazonSocial.text", new Object[0]));
/* 176:124 */     this.txtRazonSocial.setName("txtRazonSocial");
/* 177:125 */     this.txtRazonSocial.setSelectedTextColor(resourceMap.getColor("txtRazonSocial.selectedTextColor"));
/* 178:126 */     this.txtRazonSocial.setSelectionColor(resourceMap.getColor("txtRazonSocial.selectionColor"));
/* 179:    */     
/* 180:128 */     this.lblIdentificacion.setText(resourceMap.getString("lblIdentificacion.text", new Object[0]));
/* 181:129 */     this.lblIdentificacion.setVerticalAlignment(1);
/* 182:130 */     this.lblIdentificacion.setName("lblIdentificacion");
/* 183:    */     
/* 184:132 */     this.cbxTipoIdentificacion.setModel(new DefaultComboBoxModel(TipoIdentificacionEnum.values()));
/* 185:133 */     this.cbxTipoIdentificacion.setName("cbxTipoIdentificacion");
/* 186:134 */     this.cbxTipoIdentificacion.addActionListener(new ActionListener()
/* 187:    */     {
/* 188:    */       public void actionPerformed(ActionEvent evt)
/* 189:    */       {
/* 190:136 */         ClienteView.this.cbxTipoIdentificacionActionPerformed(evt);
/* 191:    */       }
/* 192:139 */     });
/* 193:140 */     this.txtIdentificacion.setText(resourceMap.getString("txtIdentificacion.text", new Object[0]));
/* 194:141 */     this.txtIdentificacion.setToolTipText(resourceMap.getString("txtIdentificacion.toolTipText", new Object[0]));
/* 195:142 */     this.txtIdentificacion.setName("txtIdentificacion");
/* 196:    */     
/* 197:144 */     this.lblDireccion.setText(resourceMap.getString("lblDireccion.text", new Object[0]));
/* 198:145 */     this.lblDireccion.setName("lblDireccion");
/* 199:    */     
/* 200:147 */     this.jScrollPane1.setName("jScrollPane1");
/* 201:    */     
/* 202:149 */     this.txtDireccion.setColumns(20);
/* 203:150 */     this.txtDireccion.setRows(5);
/* 204:151 */     this.txtDireccion.setName("txtDireccion");
/* 205:152 */     this.jScrollPane1.setViewportView(this.txtDireccion);
/* 206:    */     
/* 207:154 */     this.lblTelefono.setText(resourceMap.getString("lblTelefono.text", new Object[0]));
/* 208:155 */     this.lblTelefono.setName("lblTelefono");
/* 209:    */     
/* 210:157 */     this.txtTelefono.setText(resourceMap.getString("txtTelefono.text", new Object[0]));
/* 211:158 */     this.txtTelefono.setName("txtTelefono");
/* 212:    */     
/* 213:160 */     this.lblExt.setText(resourceMap.getString("lblExt.text", new Object[0]));
/* 214:161 */     this.lblExt.setName("lblExt");
/* 215:    */     
/* 216:163 */     this.txtExt.setText(resourceMap.getString("txtExt.text", new Object[0]));
/* 217:164 */     this.txtExt.setName("txtExt");
/* 218:    */     
/* 219:166 */     this.lblCelular.setText(resourceMap.getString("lblCelular.text", new Object[0]));
/* 220:167 */     this.lblCelular.setName("lblCelular");
/* 221:    */     
/* 222:169 */     this.txtCelular.setText(resourceMap.getString("txtCelular.text", new Object[0]));
/* 223:170 */     this.txtCelular.setName("txtCelular");
/* 224:    */     
/* 225:172 */     this.lblMail.setText(resourceMap.getString("lblMail.text", new Object[0]));
/* 226:173 */     this.lblMail.setName("lblMail");
/* 227:174 */     this.lblMail.setVerticalTextPosition(1);
/* 228:    */     
/* 229:176 */     this.txtMail.setText(resourceMap.getString("txtMail.text", new Object[0]));
/* 230:177 */     this.txtMail.setName("txtMail");
/* 231:    */     
/* 232:179 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 233:180 */     this.jLabel1.setName("jLabel1");
/* 234:    */     
/* 235:182 */     this.cbxTipoCliente.setName("cbxTipoCliente");
/* 236:    */     
/* 237:184 */     GroupLayout pnlClienteLayout = new GroupLayout(this.pnlCliente);
/* 238:185 */     this.pnlCliente.setLayout(pnlClienteLayout);
/* 239:186 */     pnlClienteLayout.setHorizontalGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlClienteLayout.createSequentialGroup().addContainerGap().addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addGroup(GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup().addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblIdentificacion).addComponent(this.lblRazonSocial).addComponent(this.lblTelefono).addComponent(this.lblCelular).addComponent(this.lblMail).addComponent(this.lblDireccion)).addGap(18, 18, 18).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtMail, -2, 384, -2).addComponent(this.jScrollPane1, -1, 596, 32767).addComponent(this.txtRazonSocial, -1, 596, 32767).addGroup(pnlClienteLayout.createSequentialGroup().addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtCelular, GroupLayout.Alignment.LEADING).addComponent(this.txtTelefono, GroupLayout.Alignment.LEADING, -1, 141, 32767)).addGap(21, 21, 21).addComponent(this.lblExt).addGap(18, 18, 18).addComponent(this.txtExt, -1, 369, 32767)).addGroup(pnlClienteLayout.createSequentialGroup().addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.cbxTipoCliente, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.cbxTipoIdentificacion, GroupLayout.Alignment.LEADING, 0, 204, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 97, 32767).addComponent(this.txtIdentificacion, -2, 295, -2))))).addContainerGap()));
/* 240:    */     
/* 241:    */ 
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:    */ 
/* 248:    */ 
/* 249:    */ 
/* 250:    */ 
/* 251:    */ 
/* 252:    */ 
/* 253:    */ 
/* 254:    */ 
/* 255:    */ 
/* 256:    */ 
/* 257:    */ 
/* 258:    */ 
/* 259:    */ 
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:    */ 
/* 264:    */ 
/* 265:    */ 
/* 266:    */ 
/* 267:    */ 
/* 268:    */ 
/* 269:    */ 
/* 270:    */ 
/* 271:    */ 
/* 272:    */ 
/* 273:    */ 
/* 274:221 */     pnlClienteLayout.setVerticalGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlClienteLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblRazonSocial).addComponent(this.txtRazonSocial, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblIdentificacion).addComponent(this.cbxTipoIdentificacion, -2, -1, -2).addComponent(this.txtIdentificacion, -2, -1, -2)).addGap(18, 18, 18).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.cbxTipoCliente, -2, -1, -2)).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlClienteLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, -1, -2)).addGroup(pnlClienteLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.lblDireccion))).addGap(18, 18, 18).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTelefono, -2, -1, -2).addComponent(this.lblTelefono).addComponent(this.lblExt).addComponent(this.txtExt, -2, -1, -2)).addGap(18, 18, 18).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCelular, -2, -1, -2).addComponent(this.lblCelular)).addGap(17, 17, 17).addGroup(pnlClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblMail).addComponent(this.txtMail, -2, -1, -2)).addGap(108, 108, 108)));
/* 275:    */     
/* 276:    */ 
/* 277:    */ 
/* 278:    */ 
/* 279:    */ 
/* 280:    */ 
/* 281:    */ 
/* 282:    */ 
/* 283:    */ 
/* 284:    */ 
/* 285:    */ 
/* 286:    */ 
/* 287:    */ 
/* 288:    */ 
/* 289:    */ 
/* 290:    */ 
/* 291:    */ 
/* 292:    */ 
/* 293:    */ 
/* 294:    */ 
/* 295:    */ 
/* 296:    */ 
/* 297:    */ 
/* 298:    */ 
/* 299:    */ 
/* 300:    */ 
/* 301:    */ 
/* 302:    */ 
/* 303:    */ 
/* 304:    */ 
/* 305:    */ 
/* 306:    */ 
/* 307:    */ 
/* 308:    */ 
/* 309:    */ 
/* 310:    */ 
/* 311:    */ 
/* 312:    */ 
/* 313:    */ 
/* 314:261 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel6.border.title", new Object[0])));
/* 315:262 */     this.jPanel6.setName("jPanel6");
/* 316:    */     
/* 317:264 */     this.jButton2.setFont(resourceMap.getFont("jButton2.font"));
/* 318:265 */     this.jButton2.setText(resourceMap.getString("jButton2.text", new Object[0]));
/* 319:266 */     this.jButton2.setName("jButton2");
/* 320:267 */     this.jButton2.addActionListener(new ActionListener()
/* 321:    */     {
/* 322:    */       public void actionPerformed(ActionEvent evt)
/* 323:    */       {
/* 324:269 */         ClienteView.this.jButton2ActionPerformed(evt);
/* 325:    */       }
/* 326:272 */     });
/* 327:273 */     this.jButton1.setFont(resourceMap.getFont("jButton2.font"));
/* 328:274 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/* 329:275 */     this.jButton1.setName("jButton1");
/* 330:276 */     this.jButton1.addActionListener(new ActionListener()
/* 331:    */     {
/* 332:    */       public void actionPerformed(ActionEvent evt)
/* 333:    */       {
/* 334:278 */         ClienteView.this.jButton1ActionPerformed(evt);
/* 335:    */       }
/* 336:281 */     });
/* 337:282 */     this.btnLimpiar.setFont(resourceMap.getFont("jButton2.font"));
/* 338:283 */     this.btnLimpiar.setText(resourceMap.getString("btnLimpiar.text", new Object[0]));
/* 339:284 */     this.btnLimpiar.setName("btnLimpiar");
/* 340:285 */     this.btnLimpiar.addActionListener(new ActionListener()
/* 341:    */     {
/* 342:    */       public void actionPerformed(ActionEvent evt)
/* 343:    */       {
/* 344:287 */         ClienteView.this.btnLimpiarActionPerformed(evt);
/* 345:    */       }
/* 346:290 */     });
/* 347:291 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 348:292 */     this.jPanel6.setLayout(jPanel6Layout);
/* 349:293 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addGap(14, 14, 14).addComponent(this.btnLimpiar).addContainerGap(455, 32767)));
/* 350:    */     
/* 351:    */ 
/* 352:    */ 
/* 353:    */ 
/* 354:    */ 
/* 355:    */ 
/* 356:    */ 
/* 357:    */ 
/* 358:    */ 
/* 359:    */ 
/* 360:304 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnLimpiar).addComponent(this.jButton2).addComponent(this.jButton1)).addContainerGap(-1, 32767)));
/* 361:    */     
/* 362:    */ 
/* 363:    */ 
/* 364:    */ 
/* 365:    */ 
/* 366:    */ 
/* 367:    */ 
/* 368:    */ 
/* 369:    */ 
/* 370:314 */     GroupLayout layout = new GroupLayout(this);
/* 371:315 */     setLayout(layout);
/* 372:316 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.pnlCliente, -1, -1, 32767).addComponent(this.lblDetalleCliente).addComponent(this.jPanel6, -1, -1, 32767)).addContainerGap(-1, 32767)));
/* 373:    */     
/* 374:    */ 
/* 375:    */ 
/* 376:    */ 
/* 377:    */ 
/* 378:    */ 
/* 379:    */ 
/* 380:    */ 
/* 381:    */ 
/* 382:326 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblDetalleCliente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.pnlCliente, -2, 356, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel6, -2, -1, -2).addContainerGap(57, 32767)));
/* 383:    */   }
/* 384:    */   
/* 385:    */   private void btnLimpiarActionPerformed(ActionEvent evt)
/* 386:    */   {
/* 387:339 */     inicializarClientes();
/* 388:    */   }
/* 389:    */   
/* 390:    */   private void jButton2ActionPerformed(ActionEvent evt)
/* 391:    */   {
/* 392:343 */     String valido = validarRequeridos();
/* 393:344 */     if (this.c == null)
/* 394:    */     {
/* 395:345 */       if (valido == null) {
/* 396:346 */         crearCliente();
/* 397:    */       } else {
/* 398:348 */         JOptionPane.showMessageDialog(this, valido, "ERROR", 0);
/* 399:    */       }
/* 400:    */     }
/* 401:351 */     else if (valido == null) {
/* 402:352 */       actualizarCliente();
/* 403:    */     } else {
/* 404:354 */       JOptionPane.showMessageDialog(this, valido, "ERROR", 0);
/* 405:    */     }
/* 406:    */   }
/* 407:    */   
/* 408:    */   private void cbxTipoIdentificacionActionPerformed(ActionEvent evt)
/* 409:    */   {
/* 410:360 */     ListenerUtil util = new ListenerUtil();
/* 411:361 */     util.removeListener(this.txtIdentificacion);
/* 412:362 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.C.getDescripcion())) {
/* 413:363 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_CEDULA);
/* 414:    */     }
/* 415:365 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.R.getDescripcion())) {
/* 416:366 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_RUC);
/* 417:    */     }
/* 418:368 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.P.getDescripcion())) {
/* 419:369 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_PASAPORTE);
/* 420:    */     }
/* 421:371 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.I.getDescripcion())) {
/* 422:372 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_IDENTIFICACION_EXTERIOR);
/* 423:    */     }
/* 424:374 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.L.getDescripcion())) {
/* 425:375 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_PLACA);
/* 426:    */     }
/* 427:    */   }
/* 428:    */   
/* 429:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 430:    */   {
/* 431:380 */     obtenerInstancia(this.jButton1.getParent());
/* 432:    */   }
/* 433:    */   
/* 434:    */   private Clientes crearClienteModel()
/* 435:    */   {
/* 436:384 */     Clientes cliente = new Clientes();
/* 437:385 */     if (this.c != null) {
/* 438:386 */       cliente.setCodCliente(this.c.getCodCliente());
/* 439:    */     }
/* 440:388 */     cliente.setApellido(this.txtRazonSocial.getText());
/* 441:389 */     cliente.setTipoIdentificacion(StringUtil.getTipoIdentificacion(this.cbxTipoIdentificacion.getSelectedItem().toString()));
/* 442:390 */     cliente.setNumeroIdentificacio(this.txtIdentificacion.getText());
/* 443:391 */     cliente.setTelefonoConvencional(this.txtTelefono.getText());
/* 444:392 */     cliente.setExtencion(this.txtExt.getText());
/* 445:393 */     cliente.setCelular(this.txtCelular.getText());
/* 446:394 */     cliente.setCorreo(this.txtMail.getText());
/* 447:395 */     cliente.setDireccion(this.txtDireccion.getText());
/* 448:396 */     cliente.setTipoCliente(((TipoClienteEnum)this.cbxTipoCliente.getSelectedItem()).getCode());
/* 449:397 */     return cliente;
/* 450:    */   }
/* 451:    */   
/* 452:    */   private void crearCliente()
/* 453:    */   {
/* 454:    */     try
/* 455:    */     {
/* 456:402 */       ClientesSQL sql = new ClientesSQL();
/* 457:403 */       sql.crearCliente(crearClienteModel());
/* 458:404 */       JOptionPane.showMessageDialog(this, "Se creó con éxito el cliente", "Mensaje", 1);
/* 459:405 */       inicializarClientes();
/* 460:    */     }
/* 461:    */     catch (SQLException ex)
/* 462:    */     {
/* 463:407 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "ERROR", 0);
/* 464:    */     }
/* 465:    */     catch (ClassNotFoundException ex)
/* 466:    */     {
/* 467:409 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "ERROR", 0);
/* 468:    */     }
/* 469:    */   }
/* 470:    */   
/* 471:    */   private void actualizarCliente()
/* 472:    */   {
/* 473:    */     try
/* 474:    */     {
/* 475:415 */       ClientesSQL sql = new ClientesSQL();
/* 476:416 */       sql.actualizarCliente(crearClienteModel());
/* 477:417 */       JOptionPane.showMessageDialog(this, "Se Actualizo con éxito el cliente", "Mensaje", 1);
/* 478:418 */       obtenerInstancia(this.jButton2.getParent());
/* 479:    */     }
/* 480:    */     catch (SQLException ex)
/* 481:    */     {
/* 482:420 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "ERROR", 0);
/* 483:    */     }
/* 484:    */     catch (ClassNotFoundException ex)
/* 485:    */     {
/* 486:422 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "ERROR", 0);
/* 487:    */     }
/* 488:    */   }
/* 489:    */   
/* 490:    */   private String validarRequeridos()
/* 491:    */   {
/* 492:427 */     if ((this.txtRazonSocial == null) || (this.txtRazonSocial.getText().isEmpty())) {
/* 493:428 */       return "La razón Social es obligatorio.";
/* 494:    */     }
/* 495:430 */     if ((this.cbxTipoIdentificacion.getSelectedItem() == null) || (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase("SELECCIONE"))) {
/* 496:431 */       return "Tipo de identificación es obligatorio.";
/* 497:    */     }
/* 498:433 */     if ((this.txtIdentificacion == null) || (this.txtIdentificacion.getText().isEmpty())) {
/* 499:434 */       return "El número de identificación es obligatorio.";
/* 500:    */     }
/* 501:436 */     if ((this.txtMail == null) || (this.txtMail.getText().isEmpty())) {
/* 502:437 */       return "El correo electrónico es obligatorio";
/* 503:    */     }
/* 504:439 */     if ((this.txtMail != null) && (this.txtMail.getText() != null) && (!StringUtil.validateEmail(this.txtMail.getText()))) {
/* 505:440 */       return "La dirección de Correo electrónico no es válida.";
/* 506:    */     }
/* 507:442 */     String validador = ValidadorCampos.validarTipoDocumento(this.cbxTipoIdentificacion, this.txtIdentificacion);
/* 508:443 */     if (validador == null) {
/* 509:444 */       return validarLongitudes();
/* 510:    */     }
/* 511:446 */     return validador;
/* 512:    */   }
/* 513:    */   
/* 514:    */   private String validarLongitudMayor()
/* 515:    */   {
/* 516:450 */     List<CampoModelo> listaCampos = new ArrayList();
/* 517:451 */     listaCampos.add(obtenerCampoModelo(this.txtDireccion.getText(), "Dirección", Integer.valueOf(300)));
/* 518:452 */     listaCampos.add(obtenerCampoModelo(this.txtRazonSocial.getText(), "Razón Social", Integer.valueOf(300)));
/* 519:453 */     listaCampos.add(obtenerCampoModelo(this.txtTelefono.getText(), "Teléfono", Integer.valueOf(13)));
/* 520:454 */     listaCampos.add(obtenerCampoModelo(this.txtCelular.getText(), "Teléfono Celular", Integer.valueOf(13)));
/* 521:455 */     listaCampos.add(obtenerCampoModelo(this.txtExt.getText(), "Extensión", Integer.valueOf(13)));
/* 522:456 */     return ValidadorCampos.validarCampoLongitudMayor(listaCampos);
/* 523:    */   }
/* 524:    */   
/* 525:    */   private CampoModelo obtenerCampoModelo(String valor, String etiqueta, Integer longitud)
/* 526:    */   {
/* 527:460 */     return new CampoModelo(valor, etiqueta, longitud);
/* 528:    */   }
/* 529:    */   
/* 530:    */   private String validarLongitudes()
/* 531:    */   {
/* 532:464 */     String validar = validarLongitudMayor();
/* 533:465 */     if (validar != null) {
/* 534:466 */       return validar;
/* 535:    */     }
/* 536:468 */     if ((this.txtTelefono.getText() != null) && (!this.txtTelefono.getText().isEmpty()) && (!validarNumerosDetelefono(this.txtTelefono.getText()).booleanValue())) {
/* 537:469 */       return "El campo teléfono convencional solo acepta caracteres numéricos";
/* 538:    */     }
/* 539:471 */     if ((this.txtCelular.getText() != null) && (!this.txtCelular.getText().isEmpty()) && (!validarNumerosDetelefono(this.txtCelular.getText()).booleanValue())) {
/* 540:472 */       return "El campo telefóno celular solo acepta números";
/* 541:    */     }
/* 542:474 */     if ((this.txtExt.getText() != null) && (!this.txtExt.getText().isEmpty()) && (!validarNumerosDetelefono(this.txtExt.getText()).booleanValue())) {
/* 543:475 */       return "El campo extensión solo acepta números";
/* 544:    */     }
/* 545:478 */     return null;
/* 546:    */   }
/* 547:    */   
/* 548:    */   private Boolean validarNumerosDetelefono(String numero)
/* 549:    */   {
/* 550:482 */     return Boolean.valueOf(StringUtil.validarExpresionRegular("\\d+", numero));
/* 551:    */   }
/* 552:    */   
/* 553:    */   private String getuniqueConstraintViolado(String mensaje)
/* 554:    */   {
/* 555:486 */     if (mensaje.contains("UNIQUE_RUC")) {
/* 556:487 */       return "Ya existe el número de Identificación " + this.txtIdentificacion.getText() + " con el mismo tipo de cliente";
/* 557:    */     }
/* 558:489 */     return mensaje;
/* 559:    */   }
/* 560:    */   
/* 561:    */   private void inicializarClientes()
/* 562:    */   {
/* 563:493 */     this.txtCelular.setText("");
/* 564:494 */     this.txtDireccion.setText("");
/* 565:495 */     this.txtExt.setText("");
/* 566:496 */     this.txtIdentificacion.setText("");
/* 567:497 */     this.txtMail.setText("");
/* 568:498 */     this.txtRazonSocial.setText("");
/* 569:499 */     this.txtTelefono.setText("");
/* 570:500 */     this.cbxTipoCliente.setSelectedItem(TipoClienteEnum.C);
/* 571:501 */     this.cbxTipoIdentificacion.setSelectedItem(TipoIdentificacionEnum.C);
/* 572:    */   }
/* 573:    */   
/* 574:    */   private void obtenerInstancia(Container c)
/* 575:    */   {
/* 576:505 */     if ((c instanceof DialogoCliente)) {
/* 577:506 */       c.setVisible(false);
/* 578:    */     } else {
/* 579:508 */       obtenerInstancia(c.getParent());
/* 580:    */     }
/* 581:    */   }
/* 582:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ClienteView
 * JD-Core Version:    0.7.0.1
 */