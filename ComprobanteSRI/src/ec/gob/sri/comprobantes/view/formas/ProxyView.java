/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Proxy;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ProxySQL;
/*   6:    */ import java.awt.Dimension;
/*   7:    */ import java.awt.event.ActionEvent;
/*   8:    */ import java.awt.event.ActionListener;
/*   9:    */ import java.io.IOException;
/*  10:    */ import java.net.InetAddress;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ import javax.swing.BorderFactory;
/*  15:    */ import javax.swing.GroupLayout;
/*  16:    */ import javax.swing.GroupLayout.Alignment;
/*  17:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  18:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  19:    */ import javax.swing.JButton;
/*  20:    */ import javax.swing.JDialog;
/*  21:    */ import javax.swing.JLabel;
/*  22:    */ import javax.swing.JOptionPane;
/*  23:    */ import javax.swing.JPanel;
/*  24:    */ import javax.swing.JPasswordField;
/*  25:    */ import javax.swing.JSpinner;
/*  26:    */ import javax.swing.JSpinner.NumberEditor;
/*  27:    */ import javax.swing.JTextField;
/*  28:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  29:    */ import javax.swing.SpinnerModel;
/*  30:    */ import javax.swing.SpinnerNumberModel;
/*  31:    */ import javax.swing.border.SoftBevelBorder;
/*  32:    */ import org.jdesktop.application.Application;
/*  33:    */ import org.jdesktop.application.ApplicationContext;
/*  34:    */ import org.jdesktop.application.ResourceMap;
/*  35:    */ 
/*  36:    */ public class ProxyView
/*  37:    */   extends JPanel
/*  38:    */ {
/*  39: 25 */   SpinnerModel modeltau = new SpinnerNumberModel(1, 0, 99999, 1);
/*  40:    */   private JButton btnAyuda;
/*  41:    */   private JButton btnGuardar;
/*  42:    */   private JLabel jLabel1;
/*  43:    */   private JLabel jLabel2;
/*  44:    */   private JLabel jLabel3;
/*  45:    */   private JLabel jLabel4;
/*  46:    */   private JPanel jPanel1;
/*  47:    */   private JPanel jPanel2;
/*  48:    */   private JPanel jPanel3;
/*  49:    */   private JPanel jPanel4;
/*  50:    */   private JLabel lblClave;
/*  51:    */   private JLabel lblProduccion;
/*  52:    */   private JLabel lblPruebas;
/*  53:    */   private JLabel lblUsuario;
/*  54:    */   private JSpinner spnPuerto;
/*  55:    */   private JPasswordField txtClave;
/*  56:    */   private JTextField txtProxy;
/*  57:    */   private JTextField txtUsuario;
/*  58:    */   private JTextField txtWsProduccion;
/*  59:    */   private JTextField txtWsPruebas;
/*  60:    */   
/*  61:    */   public ProxyView()
/*  62:    */   {
/*  63: 28 */     initComponents();
/*  64: 29 */     this.spnPuerto.setModel(this.modeltau);
/*  65: 30 */     loadProXy();
/*  66:    */   }
/*  67:    */   
/*  68:    */   private void loadProXy()
/*  69:    */   {
/*  70:    */     try
/*  71:    */     {
/*  72: 40 */       ProxySQL proxySQL = new ProxySQL();
/*  73: 41 */       Proxy proxy = proxySQL.obtenerProxy();
/*  74: 42 */       if (proxy != null)
/*  75:    */       {
/*  76: 43 */         this.txtProxy.setText(proxy.getUrl());
/*  77: 44 */         this.txtUsuario.setText(proxy.getUsuario());
/*  78: 45 */         this.txtClave.setText(proxy.getClave());
/*  79: 46 */         this.txtWsProduccion.setText(proxy.getWsProduccion());
/*  80: 47 */         this.txtWsPruebas.setText(proxy.getWsPruebas());
/*  81: 48 */         this.spnPuerto.setValue(proxy.getPuerto());
/*  82:    */       }
/*  83:    */     }
/*  84:    */     catch (SQLException ex)
/*  85:    */     {
/*  86: 51 */       Logger.getLogger(ProxyView.class.getName()).log(Level.SEVERE, null, ex);
/*  87:    */     }
/*  88:    */     catch (ClassNotFoundException ex)
/*  89:    */     {
/*  90: 53 */       Logger.getLogger(ProxyView.class.getName()).log(Level.SEVERE, null, ex);
/*  91:    */     }
/*  92:    */   }
/*  93:    */   
/*  94:    */   private void initComponents()
/*  95:    */   {
/*  96: 61 */     this.btnAyuda = new JButton();
/*  97: 62 */     this.jPanel3 = new JPanel();
/*  98: 63 */     this.jLabel1 = new JLabel();
/*  99: 64 */     this.txtProxy = new JTextField();
/* 100: 65 */     this.spnPuerto = new JSpinner();
/* 101: 66 */     this.jLabel2 = new JLabel();
/* 102: 67 */     this.jPanel2 = new JPanel();
/* 103: 68 */     this.lblUsuario = new JLabel();
/* 104: 69 */     this.lblClave = new JLabel();
/* 105: 70 */     this.txtUsuario = new JTextField();
/* 106: 71 */     this.txtClave = new JPasswordField();
/* 107: 72 */     this.jLabel4 = new JLabel();
/* 108: 73 */     this.jPanel4 = new JPanel();
/* 109: 74 */     this.lblProduccion = new JLabel();
/* 110: 75 */     this.lblPruebas = new JLabel();
/* 111: 76 */     this.txtWsProduccion = new JTextField();
/* 112: 77 */     this.txtWsPruebas = new JTextField();
/* 113: 78 */     this.jLabel3 = new JLabel();
/* 114: 79 */     this.jPanel1 = new JPanel();
/* 115: 80 */     this.btnGuardar = new JButton();
/* 116:    */     
/* 117: 82 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ProxyView.class);
/* 118: 83 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/* 119: 84 */     setName("Form");
/* 120:    */     
/* 121: 86 */     this.btnAyuda.setText(resourceMap.getString("btnAyuda.text", new Object[0]));
/* 122: 87 */     this.btnAyuda.setName("btnAyuda");
/* 123: 88 */     this.btnAyuda.addActionListener(new ActionListener()
/* 124:    */     {
/* 125:    */       public void actionPerformed(ActionEvent evt)
/* 126:    */       {
/* 127: 90 */         ProxyView.this.btnAyudaActionPerformed(evt);
/* 128:    */       }
/* 129: 93 */     });
/* 130: 94 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/* 131: 95 */     this.jPanel3.setName("jPanel3");
/* 132:    */     
/* 133: 97 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 134: 98 */     this.jLabel1.setName("jLabel1");
/* 135:    */     
/* 136:100 */     this.txtProxy.setText(resourceMap.getString("txtProxy.text", new Object[0]));
/* 137:101 */     this.txtProxy.setName("txtProxy");
/* 138:    */     
/* 139:103 */     this.spnPuerto.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
/* 140:104 */     this.spnPuerto.setToolTipText(resourceMap.getString("spnPuerto.toolTipText", new Object[0]));
/* 141:105 */     this.spnPuerto.setBorder(BorderFactory.createEtchedBorder());
/* 142:106 */     this.spnPuerto.setEditor(new JSpinner.NumberEditor(this.spnPuerto, "#"));
/* 143:107 */     this.spnPuerto.setName("spnPuerto");
/* 144:    */     
/* 145:109 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 146:110 */     this.jLabel2.setName("jLabel2");
/* 147:    */     
/* 148:112 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 149:113 */     this.jPanel3.setLayout(jPanel3Layout);
/* 150:114 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -1, 75, 32767).addGap(32, 32, 32).addComponent(this.txtProxy, -2, 181, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.jLabel2)).addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.spnPuerto, -2, 104, -2))).addContainerGap()));
/* 151:    */     
/* 152:    */ 
/* 153:    */ 
/* 154:    */ 
/* 155:    */ 
/* 156:    */ 
/* 157:    */ 
/* 158:    */ 
/* 159:    */ 
/* 160:    */ 
/* 161:    */ 
/* 162:    */ 
/* 163:    */ 
/* 164:    */ 
/* 165:    */ 
/* 166:130 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtProxy, -2, -1, -2).addComponent(this.spnPuerto, -2, -1, -2).addComponent(this.jLabel1)).addContainerGap(-1, 32767)));
/* 167:    */     
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:    */ 
/* 176:    */ 
/* 177:    */ 
/* 178:142 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/* 179:143 */     this.jPanel2.setName("jPanel2");
/* 180:    */     
/* 181:145 */     this.lblUsuario.setText(resourceMap.getString("lblUsuario.text", new Object[0]));
/* 182:146 */     this.lblUsuario.setName("lblUsuario");
/* 183:    */     
/* 184:148 */     this.lblClave.setText(resourceMap.getString("lblClave.text", new Object[0]));
/* 185:149 */     this.lblClave.setName("lblClave");
/* 186:    */     
/* 187:151 */     this.txtUsuario.setText(resourceMap.getString("txtUsuario.text", new Object[0]));
/* 188:152 */     this.txtUsuario.setName("txtUsuario");
/* 189:    */     
/* 190:154 */     this.txtClave.setText(resourceMap.getString("txtClave.text", new Object[0]));
/* 191:155 */     this.txtClave.setName("txtClave");
/* 192:    */     
/* 193:157 */     this.jLabel4.setFont(resourceMap.getFont("jLabel4.font"));
/* 194:158 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 195:159 */     this.jLabel4.setName("jLabel4");
/* 196:    */     
/* 197:161 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 198:162 */     this.jPanel2.setLayout(jPanel2Layout);
/* 199:163 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(47, 47, 47).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblUsuario).addComponent(this.lblClave)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 152, -2).addComponent(this.txtClave, -1, 304, 32767).addComponent(this.txtUsuario, -1, 304, 32767)).addContainerGap()));
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
/* 210:    */ 
/* 211:    */ 
/* 212:    */ 
/* 213:177 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtUsuario, -2, -1, -2).addComponent(this.lblUsuario)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtClave, -2, -1, -2).addComponent(this.lblClave)).addContainerGap()));
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
/* 228:192 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title", new Object[0])));
/* 229:193 */     this.jPanel4.setName("jPanel4");
/* 230:    */     
/* 231:195 */     this.lblProduccion.setText(resourceMap.getString("lblProduccion.text", new Object[0]));
/* 232:196 */     this.lblProduccion.setName("lblProduccion");
/* 233:    */     
/* 234:198 */     this.lblPruebas.setText(resourceMap.getString("lblPruebas.text", new Object[0]));
/* 235:199 */     this.lblPruebas.setName("lblPruebas");
/* 236:    */     
/* 237:201 */     this.txtWsProduccion.setText(resourceMap.getString("txtWsProduccion.text", new Object[0]));
/* 238:202 */     this.txtWsProduccion.setName("txtWsProduccion");
/* 239:    */     
/* 240:204 */     this.txtWsPruebas.setText(resourceMap.getString("txtWsPruebas.text", new Object[0]));
/* 241:205 */     this.txtWsPruebas.setName("txtWsPruebas");
/* 242:    */     
/* 243:207 */     this.jLabel3.setFont(resourceMap.getFont("jLabel3.font"));
/* 244:208 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 245:209 */     this.jLabel3.setName("jLabel3");
/* 246:    */     
/* 247:211 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 248:212 */     this.jPanel4.setLayout(jPanel4Layout);
/* 249:213 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblProduccion).addComponent(this.lblPruebas)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtWsPruebas, -1, 289, 32767).addComponent(this.txtWsProduccion, -1, 289, 32767).addComponent(this.jLabel3, -2, 152, -2)).addContainerGap()));
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
/* 263:227 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.txtWsProduccion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtWsPruebas, -2, -1, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.lblProduccion).addGap(18, 18, 18).addComponent(this.lblPruebas))).addContainerGap()));
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
/* 274:    */ 
/* 275:    */ 
/* 276:    */ 
/* 277:    */ 
/* 278:    */ 
/* 279:    */ 
/* 280:244 */     this.jPanel1.setBackground(resourceMap.getColor("jPanel1.background"));
/* 281:245 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/* 282:246 */     this.jPanel1.setName("jPanel1");
/* 283:    */     
/* 284:248 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/* 285:249 */     this.btnGuardar.setName("btnGuardar");
/* 286:250 */     this.btnGuardar.addActionListener(new ActionListener()
/* 287:    */     {
/* 288:    */       public void actionPerformed(ActionEvent evt)
/* 289:    */       {
/* 290:252 */         ProxyView.this.btnGuardarActionPerformed(evt);
/* 291:    */       }
/* 292:255 */     });
/* 293:256 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 294:257 */     this.jPanel1.setLayout(jPanel1Layout);
/* 295:258 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(364, 32767).addComponent(this.btnGuardar).addContainerGap()));
/* 296:    */     
/* 297:    */ 
/* 298:    */ 
/* 299:    */ 
/* 300:    */ 
/* 301:    */ 
/* 302:265 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnGuardar).addContainerGap(-1, 32767)));
/* 303:    */     
/* 304:    */ 
/* 305:    */ 
/* 306:    */ 
/* 307:    */ 
/* 308:    */ 
/* 309:    */ 
/* 310:273 */     GroupLayout layout = new GroupLayout(this);
/* 311:274 */     setLayout(layout);
/* 312:275 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(24, 24, 24).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.btnAyuda, GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(29, 29, 29)));
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
/* 324:287 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.btnAyuda).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(15, 15, 15)));
/* 325:    */   }
/* 326:    */   
/* 327:    */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 328:    */   {
/* 329:305 */     evt.getID();
/* 330:306 */     if ((this.txtWsProduccion.getText() != null) && (!this.txtWsProduccion.getText().isEmpty()) && (this.txtWsPruebas.getText() != null) && (!this.txtWsPruebas.getText().isEmpty()))
/* 331:    */     {
/* 332:307 */       if (validarProxy() == true)
/* 333:    */       {
/* 334:308 */         guardar();
/* 335:    */       }
/* 336:    */       else
/* 337:    */       {
/* 338:310 */         int i = JOptionPane.showConfirmDialog(null, "No se puede conectar al host " + this.txtProxy.getText() + ".\n Desea guardar de todas formas la dirección?", "Advertencia", 0);
/* 339:311 */         if (i == 0) {
/* 340:312 */           guardar();
/* 341:    */         }
/* 342:    */       }
/* 343:    */     }
/* 344:    */     else {
/* 345:316 */       JOptionPane.showMessageDialog(this, "Debe ingresar por lo menos la direccion de un Web Service", "Error", 0);
/* 346:    */     }
/* 347:    */   }
/* 348:    */   
/* 349:    */   private void btnAyudaActionPerformed(ActionEvent evt)
/* 350:    */   {
/* 351:321 */     JDialog jd = new JDialog();
/* 352:322 */     jd.setModal(true);
/* 353:323 */     jd.setSize(new Dimension(750, 400));
/* 354:324 */     jd.setTitle("Ayuda");
/* 355:325 */     jd.add(new AyudaProxy());
/* 356:326 */     jd.setLocationRelativeTo(null);
/* 357:327 */     jd.setVisible(true);
/* 358:    */   }
/* 359:    */   
/* 360:    */   private void guardar()
/* 361:    */   {
/* 362:330 */     ProxySQL proxySQL = new ProxySQL();
/* 363:    */     try
/* 364:    */     {
/* 365:332 */       proxySQL.crearProxy(getProxy());
/* 366:333 */       JOptionPane.showMessageDialog(this, "Se guardó con éxito", "Mensaje", 1);
/* 367:    */     }
/* 368:    */     catch (ClassNotFoundException ex)
/* 369:    */     {
/* 370:335 */       Logger.getLogger(ProxyView.class.getName()).log(Level.SEVERE, null, ex);
/* 371:    */     }
/* 372:    */     catch (SQLException ex)
/* 373:    */     {
/* 374:337 */       Logger.getLogger(ProxyView.class.getName()).log(Level.SEVERE, null, ex);
/* 375:    */     }
/* 376:    */   }
/* 377:    */   
/* 378:    */   private Proxy getProxy()
/* 379:    */   {
/* 380:342 */     return new Proxy(this.txtProxy.getText(), (Integer)this.spnPuerto.getValue(), this.txtUsuario.getText(), this.txtClave.getPassword().toString(), this.txtWsProduccion.getText(), this.txtWsPruebas.getText());
/* 381:    */   }
/* 382:    */   
/* 383:    */   private boolean validarProxy()
/* 384:    */   {
/* 385:    */     try
/* 386:    */     {
/* 387:347 */       InetAddress host = InetAddress.getByName(this.txtProxy.getText());
/* 388:348 */       return host.isReachable(1000);
/* 389:    */     }
/* 390:    */     catch (IOException ex) {}
/* 391:350 */     return false;
/* 392:    */   }
/* 393:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ProxyView
 * JD-Core Version:    0.7.0.1
 */