/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*   5:    */ import ec.gob.sri.comprobantes.sql.TransportistaSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.ConstantesDimensiones;
/*   7:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   8:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   9:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
/*  10:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  11:    */ import ec.gob.sri.comprobantes.view.modals.DialogoTransportista;
/*  12:    */ import java.awt.Container;
/*  13:    */ import java.awt.event.ActionEvent;
/*  14:    */ import java.awt.event.ActionListener;
/*  15:    */ import java.io.PrintStream;
/*  16:    */ import java.sql.SQLException;
/*  17:    */ import java.util.regex.Matcher;
/*  18:    */ import java.util.regex.Pattern;
/*  19:    */ import javax.swing.BorderFactory;
/*  20:    */ import javax.swing.DefaultComboBoxModel;
/*  21:    */ import javax.swing.GroupLayout;
/*  22:    */ import javax.swing.GroupLayout.Alignment;
/*  23:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  24:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  25:    */ import javax.swing.JButton;
/*  26:    */ import javax.swing.JComboBox;
/*  27:    */ import javax.swing.JLabel;
/*  28:    */ import javax.swing.JOptionPane;
/*  29:    */ import javax.swing.JPanel;
/*  30:    */ import javax.swing.JTextField;
/*  31:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  32:    */ import javax.swing.border.SoftBevelBorder;
/*  33:    */ import org.jdesktop.application.Application;
/*  34:    */ import org.jdesktop.application.ApplicationContext;
/*  35:    */ import org.jdesktop.application.ResourceMap;
/*  36:    */ 
/*  37:    */ public class TransportistaView
/*  38:    */   extends JPanel
/*  39:    */ {
/*  40:    */   Transportista transportista;
/*  41:    */   private JButton btnCancelar;
/*  42:    */   private JButton btnGuardar;
/*  43:    */   private JButton btnLimpiar;
/*  44:    */   private JComboBox cbxTipoIdentificacion;
/*  45:    */   private JLabel jLabel1;
/*  46:    */   private JPanel jPanel1;
/*  47:    */   private JPanel jPanel2;
/*  48:    */   private JLabel lblIdentificacion;
/*  49:    */   private JLabel lblMail;
/*  50:    */   private JLabel lblPlaca;
/*  51:    */   private JLabel lblRazonSocial;
/*  52:    */   private JTextField txtIdentificacion;
/*  53:    */   private JTextField txtMail;
/*  54:    */   private JTextField txtPlaca;
/*  55:    */   private JTextField txtRazonSocial;
/*  56:    */   
/*  57:    */   public TransportistaView()
/*  58:    */   {
/*  59: 36 */     initComponents();
/*  60: 37 */     inicializarLongitudFields();
/*  61: 38 */     inicializarControles();
/*  62: 39 */     this.btnCancelar.setVisible(false);
/*  63: 40 */     this.btnLimpiar.setVisible(true);
/*  64:    */   }
/*  65:    */   
/*  66:    */   public TransportistaView(Transportista transportista)
/*  67:    */   {
/*  68: 44 */     this.transportista = transportista;
/*  69: 45 */     initComponents();
/*  70: 46 */     setDatosTRansportistas();
/*  71: 47 */     inicializarLongitudFields();
/*  72: 48 */     this.btnCancelar.setVisible(true);
/*  73: 49 */     this.btnLimpiar.setVisible(false);
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void inicializarControles()
/*  77:    */   {
/*  78: 54 */     this.cbxTipoIdentificacion.setModel(new DefaultComboBoxModel(TipoIdentificacionEnum.obtenerTipoIdentificacionTransportista()));
/*  79:    */   }
/*  80:    */   
/*  81:    */   private void inicializarLongitudFields()
/*  82:    */   {
/*  83: 58 */     ListenerUtil listenerUtil = new ListenerUtil();
/*  84: 59 */     listenerUtil.listenerLongitud(this.txtPlaca, Integer.valueOf(20));
/*  85: 60 */     StringUtil.convertirMayusculas(this.txtRazonSocial);
/*  86:    */   }
/*  87:    */   
/*  88:    */   private void setDatosTRansportistas()
/*  89:    */   {
/*  90: 64 */     this.txtRazonSocial.setText(this.transportista.getRazonSocial());
/*  91: 65 */     this.txtMail.setText(this.transportista.getMail());
/*  92: 66 */     this.txtPlaca.setText(this.transportista.getPlaca());
/*  93: 67 */     this.cbxTipoIdentificacion.setSelectedItem(TipoIdentificacionEnum.valueOf(this.transportista.getTipoIdentificacion()));
/*  94: 68 */     this.txtIdentificacion.setText(this.transportista.getIdentificacion());
/*  95:    */   }
/*  96:    */   
/*  97:    */   private void initComponents()
/*  98:    */   {
/*  99: 80 */     this.jPanel1 = new JPanel();
/* 100: 81 */     this.lblRazonSocial = new JLabel();
/* 101: 82 */     this.txtRazonSocial = new JTextField();
/* 102: 83 */     this.lblIdentificacion = new JLabel();
/* 103: 84 */     this.cbxTipoIdentificacion = new JComboBox();
/* 104: 85 */     this.txtIdentificacion = new JTextField();
/* 105: 86 */     this.lblMail = new JLabel();
/* 106: 87 */     this.txtMail = new JTextField();
/* 107: 88 */     this.lblPlaca = new JLabel();
/* 108: 89 */     this.txtPlaca = new JTextField();
/* 109: 90 */     this.jPanel2 = new JPanel();
/* 110: 91 */     this.btnCancelar = new JButton();
/* 111: 92 */     this.btnGuardar = new JButton();
/* 112: 93 */     this.btnLimpiar = new JButton();
/* 113: 94 */     this.jLabel1 = new JLabel();
/* 114:    */     
/* 115: 96 */     setName("Form");
/* 116:    */     
/* 117: 98 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(TransportistaView.class);
/* 118: 99 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 119:100 */     this.jPanel1.setName("jPanel1");
/* 120:    */     
/* 121:102 */     this.lblRazonSocial.setText(resourceMap.getString("lblRazonSocial.text", new Object[0]));
/* 122:103 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 123:    */     
/* 124:105 */     this.txtRazonSocial.setText(resourceMap.getString("txtRazonSocial.text", new Object[0]));
/* 125:106 */     this.txtRazonSocial.setName("txtRazonSocial");
/* 126:    */     
/* 127:108 */     this.lblIdentificacion.setText(resourceMap.getString("lblIdentificacion.text", new Object[0]));
/* 128:109 */     this.lblIdentificacion.setName("lblIdentificacion");
/* 129:    */     
/* 130:111 */     this.cbxTipoIdentificacion.setModel(new DefaultComboBoxModel(TipoIdentificacionEnum.obtenerTipoIdentificacionTransportista()));
/* 131:112 */     this.cbxTipoIdentificacion.setName("cbxTipoIdentificacion");
/* 132:113 */     this.cbxTipoIdentificacion.addActionListener(new ActionListener()
/* 133:    */     {
/* 134:    */       public void actionPerformed(ActionEvent evt)
/* 135:    */       {
/* 136:115 */         TransportistaView.this.cbxTipoIdentificacionActionPerformed(evt);
/* 137:    */       }
/* 138:118 */     });
/* 139:119 */     this.txtIdentificacion.setText(resourceMap.getString("txtIdentificacion.text", new Object[0]));
/* 140:120 */     this.txtIdentificacion.setName("txtIdentificacion");
/* 141:    */     
/* 142:122 */     this.lblMail.setText(resourceMap.getString("lblMail.text", new Object[0]));
/* 143:123 */     this.lblMail.setName("lblMail");
/* 144:    */     
/* 145:125 */     this.txtMail.setText(resourceMap.getString("txtMail.text", new Object[0]));
/* 146:126 */     this.txtMail.setName("txtMail");
/* 147:    */     
/* 148:128 */     this.lblPlaca.setText(resourceMap.getString("lblPlaca.text", new Object[0]));
/* 149:129 */     this.lblPlaca.setName("lblPlaca");
/* 150:    */     
/* 151:131 */     this.txtPlaca.setText(resourceMap.getString("txtPlaca.text", new Object[0]));
/* 152:132 */     this.txtPlaca.setToolTipText(resourceMap.getString("txtPlaca.toolTipText", new Object[0]));
/* 153:133 */     this.txtPlaca.setName("txtPlaca");
/* 154:    */     
/* 155:135 */     this.jPanel2.setBackground(resourceMap.getColor("jPanel2.background"));
/* 156:136 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/* 157:137 */     this.jPanel2.setName("jPanel2");
/* 158:    */     
/* 159:139 */     this.btnCancelar.setText(resourceMap.getString("btnCancelar.text", new Object[0]));
/* 160:140 */     this.btnCancelar.setName("btnCancelar");
/* 161:141 */     this.btnCancelar.addActionListener(new ActionListener()
/* 162:    */     {
/* 163:    */       public void actionPerformed(ActionEvent evt)
/* 164:    */       {
/* 165:143 */         TransportistaView.this.btnCancelarActionPerformed(evt);
/* 166:    */       }
/* 167:146 */     });
/* 168:147 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/* 169:148 */     this.btnGuardar.setName("btnGuardar");
/* 170:149 */     this.btnGuardar.addActionListener(new ActionListener()
/* 171:    */     {
/* 172:    */       public void actionPerformed(ActionEvent evt)
/* 173:    */       {
/* 174:151 */         TransportistaView.this.btnGuardarActionPerformed(evt);
/* 175:    */       }
/* 176:154 */     });
/* 177:155 */     this.btnLimpiar.setText(resourceMap.getString("btnLimpiar.text", new Object[0]));
/* 178:156 */     this.btnLimpiar.setName("btnLimpiar");
/* 179:157 */     this.btnLimpiar.addActionListener(new ActionListener()
/* 180:    */     {
/* 181:    */       public void actionPerformed(ActionEvent evt)
/* 182:    */       {
/* 183:159 */         TransportistaView.this.btnLimpiarActionPerformed(evt);
/* 184:    */       }
/* 185:162 */     });
/* 186:163 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 187:164 */     this.jPanel2.setLayout(jPanel2Layout);
/* 188:165 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(110, 110, 110).addComponent(this.btnGuardar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCancelar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnLimpiar).addContainerGap(121, 32767)));
/* 189:    */     
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:    */ 
/* 194:    */ 
/* 195:    */ 
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:176 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnLimpiar).addComponent(this.btnCancelar).addComponent(this.btnGuardar)).addContainerGap(-1, 32767)));
/* 200:    */     
/* 201:    */ 
/* 202:    */ 
/* 203:    */ 
/* 204:    */ 
/* 205:    */ 
/* 206:    */ 
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:187 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 211:188 */     this.jPanel1.setLayout(jPanel1Layout);
/* 212:189 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(37, 37, 37).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblRazonSocial, -2, 234, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblIdentificacion).addComponent(this.lblMail, -2, 57, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtMail, -2, 234, -2).addGap(18, 18, 18).addComponent(this.lblPlaca).addGap(18, 18, 18).addComponent(this.txtPlaca, -1, 167, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.cbxTipoIdentificacion, 0, 209, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtRazonSocial, GroupLayout.Alignment.TRAILING).addComponent(this.txtIdentificacion, GroupLayout.Alignment.TRAILING, -1, 251, 32767))))).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
/* 213:    */     
/* 214:    */ 
/* 215:    */ 
/* 216:    */ 
/* 217:    */ 
/* 218:    */ 
/* 219:    */ 
/* 220:    */ 
/* 221:    */ 
/* 222:    */ 
/* 223:    */ 
/* 224:    */ 
/* 225:    */ 
/* 226:    */ 
/* 227:    */ 
/* 228:    */ 
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:    */ 
/* 237:    */ 
/* 238:    */ 
/* 239:216 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblRazonSocial).addComponent(this.txtRazonSocial, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbxTipoIdentificacion, -2, -1, -2).addComponent(this.lblIdentificacion).addComponent(this.txtIdentificacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtPlaca, -2, -1, -2).addComponent(this.lblPlaca)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtMail, -2, -1, -2).addComponent(this.lblMail))).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
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
/* 263:240 */     this.jLabel1.setFont(resourceMap.getFont("jLabel1.font"));
/* 264:241 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 265:242 */     this.jLabel1.setName("jLabel1");
/* 266:    */     
/* 267:244 */     GroupLayout layout = new GroupLayout(this);
/* 268:245 */     setLayout(layout);
/* 269:246 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.jLabel1)).addContainerGap()));
/* 270:    */     
/* 271:    */ 
/* 272:    */ 
/* 273:    */ 
/* 274:    */ 
/* 275:    */ 
/* 276:    */ 
/* 277:    */ 
/* 278:255 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
/* 279:    */   }
/* 280:    */   
/* 281:    */   private void inicializarDatos()
/* 282:    */   {
/* 283:267 */     this.txtIdentificacion.setText("");
/* 284:268 */     this.txtMail.setText("");
/* 285:269 */     this.txtPlaca.setText("");
/* 286:270 */     this.txtRazonSocial.setText("");
/* 287:271 */     this.cbxTipoIdentificacion.setSelectedItem(TipoIdentificacionEnum.C);
/* 288:    */   }
/* 289:    */   
/* 290:    */   private void obtenerInstancia(Container c)
/* 291:    */   {
/* 292:275 */     if ((c instanceof DialogoTransportista)) {
/* 293:276 */       c.setVisible(false);
/* 294:    */     } else {
/* 295:278 */       obtenerInstancia(c.getParent());
/* 296:    */     }
/* 297:    */   }
/* 298:    */   
/* 299:    */   private void btnCancelarActionPerformed(ActionEvent evt)
/* 300:    */   {
/* 301:282 */     obtenerInstancia(this.btnCancelar.getParent());
/* 302:    */   }
/* 303:    */   
/* 304:    */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 305:    */   {
/* 306:287 */     TransportistaSQL transSQL = new TransportistaSQL();
/* 307:    */     try
/* 308:    */     {
/* 309:289 */       String valido = validarCamposObligatorios();
/* 310:290 */       if (valido == null)
/* 311:    */       {
/* 312:291 */         if (this.transportista == null)
/* 313:    */         {
/* 314:292 */           transSQL.crearTransportista(obtenerTransportista());
/* 315:293 */           JOptionPane.showMessageDialog(this, "Se creo con éxito el transportista", "Mensaje", 1);
/* 316:294 */           inicializarDatos();
/* 317:    */         }
/* 318:    */         else
/* 319:    */         {
/* 320:296 */           transSQL.actualizarTransportista(obtenerTransportista());
/* 321:297 */           JOptionPane.showMessageDialog(this, "Se actualizó el transportista", "Mensaje", 1);
/* 322:298 */           obtenerInstancia(this.btnGuardar.getParent());
/* 323:    */         }
/* 324:    */       }
/* 325:    */       else {
/* 326:302 */         JOptionPane.showMessageDialog(this, valido, "Error", 0);
/* 327:    */       }
/* 328:    */     }
/* 329:    */     catch (SQLException ex)
/* 330:    */     {
/* 331:305 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 332:    */     }
/* 333:    */     catch (ClassNotFoundException ex)
/* 334:    */     {
/* 335:307 */       JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 336:    */     }
/* 337:    */   }
/* 338:    */   
/* 339:    */   private String getuniqueConstraintViolado(String mensaje)
/* 340:    */   {
/* 341:311 */     if (mensaje.contains("UNIQUE_RUC_TRA")) {
/* 342:312 */       return "Ya existe un transportista registrado con el número de Itentificación " + this.txtIdentificacion.getText();
/* 343:    */     }
/* 344:314 */     return mensaje;
/* 345:    */   }
/* 346:    */   
/* 347:    */   private String validarMailPlaca()
/* 348:    */   {
/* 349:318 */     if ((this.txtMail.getText() != null) && (!this.txtMail.getText().equals("")))
/* 350:    */     {
/* 351:319 */       Boolean mailValido = Boolean.valueOf(StringUtil.validateEmail(this.txtMail.getText()));
/* 352:321 */       if (!mailValido.booleanValue()) {
/* 353:322 */         return "La dirección de Correo electrónico no es válida.";
/* 354:    */       }
/* 355:324 */       if (!validarPlaca().booleanValue()) {
/* 356:325 */         return "El campo placa solo acepta letras y números ";
/* 357:    */       }
/* 358:    */     }
/* 359:328 */     String validador = ValidadorCampos.validarTipoDocumento(this.cbxTipoIdentificacion, this.txtIdentificacion);
/* 360:329 */     if (validador == null) {
/* 361:330 */       return null;
/* 362:    */     }
/* 363:332 */     return validador;
/* 364:    */   }
/* 365:    */   
/* 366:    */   private Boolean validarPlaca()
/* 367:    */   {
/* 368:336 */     if ((this.txtPlaca != null) && (this.txtPlaca.getText() != null) && (!this.txtPlaca.getText().contains("_")))
/* 369:    */     {
/* 370:337 */       Pattern p = Pattern.compile("^[A-Z0-9a-z]*$");
/* 371:338 */       Matcher m = p.matcher(this.txtPlaca.getText());
/* 372:339 */       return Boolean.valueOf(m.find());
/* 373:    */     }
/* 374:341 */     return Boolean.valueOf(false);
/* 375:    */   }
/* 376:    */   
/* 377:    */   private void cbxTipoIdentificacionActionPerformed(ActionEvent evt)
/* 378:    */   {
/* 379:346 */     ListenerUtil util = new ListenerUtil();
/* 380:347 */     util.removeListener(this.txtIdentificacion);
/* 381:348 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.C.getDescripcion())) {
/* 382:349 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_CEDULA);
/* 383:    */     }
/* 384:351 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.R.getDescripcion())) {
/* 385:352 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_RUC);
/* 386:    */     }
/* 387:354 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.P.getDescripcion())) {
/* 388:355 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_PASAPORTE);
/* 389:    */     }
/* 390:357 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.I.getDescripcion())) {
/* 391:358 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_IDENTIFICACION_EXTERIOR);
/* 392:    */     }
/* 393:360 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.L.getDescripcion())) {
/* 394:361 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_PLACA);
/* 395:    */     }
/* 396:    */   }
/* 397:    */   
/* 398:    */   private void btnLimpiarActionPerformed(ActionEvent evt)
/* 399:    */   {
/* 400:366 */     inicializarDatos();
/* 401:    */   }
/* 402:    */   
/* 403:    */   private String validarCamposObligatorios()
/* 404:    */   {
/* 405:369 */     if ((this.txtRazonSocial != null) && (this.txtRazonSocial.getText().isEmpty())) {
/* 406:370 */       return " El campo razón social es obligatorio";
/* 407:    */     }
/* 408:372 */     if ((this.txtIdentificacion != null) && (this.txtIdentificacion.getText().isEmpty())) {
/* 409:373 */       return "El campo identificación es obligatorio";
/* 410:    */     }
/* 411:375 */     if ((this.cbxTipoIdentificacion.getSelectedItem() != null) && (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase("SELECCIONE"))) {
/* 412:376 */       return "El tipo de identificacion es obligatorio";
/* 413:    */     }
/* 414:378 */     if ((this.txtPlaca != null) && (this.txtPlaca.getText().isEmpty())) {
/* 415:379 */       return " El campo placa es obligatorio";
/* 416:    */     }
/* 417:381 */     return validarMailPlaca();
/* 418:    */   }
/* 419:    */   
/* 420:    */   private Transportista obtenerTransportista()
/* 421:    */   {
/* 422:386 */     Transportista t = new Transportista();
/* 423:387 */     if (this.transportista != null) {
/* 424:388 */       t.setCodigo(this.transportista.getCodigo());
/* 425:    */     }
/* 426:390 */     t.setIdentificacion(this.txtIdentificacion.getText());
/* 427:391 */     System.out.println(this.cbxTipoIdentificacion.getSelectedItem().toString());
/* 428:392 */     TipoIdentificacionEnum tipoIdentificacionEnum = TipoIdentificacionEnum.obtenerTipoIdentificacionEnumPorDescripcion(this.cbxTipoIdentificacion.getSelectedItem().toString());
/* 429:393 */     t.setTipoIdentificacion(tipoIdentificacionEnum.getCode());
/* 430:394 */     t.setRazonSocial(this.txtRazonSocial.getText());
/* 431:395 */     t.setMail(this.txtMail.getText());
/* 432:396 */     t.setPlaca(this.txtPlaca.getText());
/* 433:397 */     return t;
/* 434:    */   }
/* 435:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.TransportistaView
 * JD-Core Version:    0.7.0.1
 */