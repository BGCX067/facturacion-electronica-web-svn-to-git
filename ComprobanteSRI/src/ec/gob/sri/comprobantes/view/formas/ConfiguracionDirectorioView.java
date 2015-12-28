/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*   7:    */ import java.awt.event.ActionEvent;
/*   8:    */ import java.awt.event.ActionListener;
/*   9:    */ import java.io.File;
/*  10:    */ import java.sql.SQLException;
/*  11:    */ import java.util.ArrayList;
/*  12:    */ import java.util.HashMap;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.Set;
/*  15:    */ import java.util.logging.Level;
/*  16:    */ import java.util.logging.Logger;
/*  17:    */ import javax.swing.BorderFactory;
/*  18:    */ import javax.swing.GroupLayout;
/*  19:    */ import javax.swing.GroupLayout.Alignment;
/*  20:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  21:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  22:    */ import javax.swing.JButton;
/*  23:    */ import javax.swing.JFileChooser;
/*  24:    */ import javax.swing.JLabel;
/*  25:    */ import javax.swing.JOptionPane;
/*  26:    */ import javax.swing.JPanel;
/*  27:    */ import javax.swing.JTextField;
/*  28:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  29:    */ import javax.swing.border.SoftBevelBorder;
/*  30:    */ import org.jdesktop.application.Application;
/*  31:    */ import org.jdesktop.application.ApplicationContext;
/*  32:    */ import org.jdesktop.application.ResourceMap;
/*  33:    */ 
/*  34:    */ public class ConfiguracionDirectorioView
/*  35:    */   extends JPanel
/*  36:    */ {
/*  37: 23 */   ConfiguracionDirectorioSQL confDirectorio = null;
/*  38:    */   private JButton btnCompAutorizados;
/*  39:    */   private JButton btnCompFirmados;
/*  40:    */   private JButton btnCompNoAutorizados;
/*  41:    */   private JButton btnComprobantes;
/*  42:    */   private JButton btnCrearDirectorio;
/*  43:    */   private JPanel jPanel1;
/*  44:    */   private JLabel lblCompAutorizados;
/*  45:    */   private JLabel lblCompFirmados;
/*  46:    */   private JLabel lblCompNoAutorizados;
/*  47:    */   private JLabel lblComprobantes;
/*  48:    */   private JTextField txtComNoAutorizados;
/*  49:    */   private JTextField txtCompAutorizados;
/*  50:    */   private JTextField txtCompFirmados;
/*  51:    */   private JTextField txtComprobantes;
/*  52:    */   
/*  53:    */   public ConfiguracionDirectorioView()
/*  54:    */   {
/*  55: 27 */     initComponents();
/*  56:    */     
/*  57: 29 */     loadDirectorios();
/*  58:    */   }
/*  59:    */   
/*  60:    */   private void loadDirectorios()
/*  61:    */   {
/*  62:    */     try
/*  63:    */     {
/*  64: 34 */       this.confDirectorio = new ConfiguracionDirectorioSQL();
/*  65:    */       
/*  66: 36 */       List<ConfiguracionDirectorio> listDir = this.confDirectorio.obtenerTodosDirectorios();
/*  67: 37 */       if (listDir != null) {
/*  68: 38 */         for (ConfiguracionDirectorio configuracionDirectorio : listDir)
/*  69:    */         {
/*  70: 39 */           if (configuracionDirectorio.getCodigoDirectorio().intValue() == 1) {
/*  71: 40 */             this.txtComprobantes.setText(configuracionDirectorio.getPath());
/*  72:    */           }
/*  73: 42 */           if (configuracionDirectorio.getCodigoDirectorio().intValue() == 2) {
/*  74: 43 */             this.txtCompFirmados.setText(configuracionDirectorio.getPath());
/*  75:    */           }
/*  76: 45 */           if (configuracionDirectorio.getCodigoDirectorio().intValue() == 3) {
/*  77: 46 */             this.txtCompAutorizados.setText(configuracionDirectorio.getPath());
/*  78:    */           }
/*  79: 48 */           if (configuracionDirectorio.getCodigoDirectorio().intValue() == 4) {
/*  80: 49 */             this.txtComNoAutorizados.setText(configuracionDirectorio.getPath());
/*  81:    */           }
/*  82:    */         }
/*  83:    */       }
/*  84:    */     }
/*  85:    */     catch (SQLException ex)
/*  86:    */     {
/*  87: 54 */       Logger.getLogger(ConfiguracionDirectorioView.class.getName()).log(Level.SEVERE, null, ex);
/*  88:    */     }
/*  89:    */     catch (ClassNotFoundException ex)
/*  90:    */     {
/*  91: 56 */       Logger.getLogger(ConfiguracionDirectorioView.class.getName()).log(Level.SEVERE, null, ex);
/*  92:    */     }
/*  93:    */   }
/*  94:    */   
/*  95:    */   private void initComponents()
/*  96:    */   {
/*  97: 76 */     this.lblComprobantes = new JLabel();
/*  98: 77 */     this.lblCompFirmados = new JLabel();
/*  99: 78 */     this.lblCompAutorizados = new JLabel();
/* 100: 79 */     this.lblCompNoAutorizados = new JLabel();
/* 101: 80 */     this.txtComNoAutorizados = new JTextField();
/* 102: 81 */     this.txtCompAutorizados = new JTextField();
/* 103: 82 */     this.txtCompFirmados = new JTextField();
/* 104: 83 */     this.txtComprobantes = new JTextField();
/* 105: 84 */     this.btnComprobantes = new JButton();
/* 106: 85 */     this.btnCompFirmados = new JButton();
/* 107: 86 */     this.btnCompAutorizados = new JButton();
/* 108: 87 */     this.btnCompNoAutorizados = new JButton();
/* 109: 88 */     this.jPanel1 = new JPanel();
/* 110: 89 */     this.btnCrearDirectorio = new JButton();
/* 111:    */     
/* 112: 91 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ConfiguracionDirectorioView.class);
/* 113: 92 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 0, 0, resourceMap.getFont("Form.border.titleFont")));
/* 114: 93 */     setName("Form");
/* 115:    */     
/* 116: 95 */     this.lblComprobantes.setText(resourceMap.getString("lblComprobantes.text", new Object[0]));
/* 117: 96 */     this.lblComprobantes.setName("lblComprobantes");
/* 118:    */     
/* 119: 98 */     this.lblCompFirmados.setText(resourceMap.getString("lblCompFirmados.text", new Object[0]));
/* 120: 99 */     this.lblCompFirmados.setName("lblCompFirmados");
/* 121:    */     
/* 122:101 */     this.lblCompAutorizados.setText(resourceMap.getString("lblCompAutorizados.text", new Object[0]));
/* 123:102 */     this.lblCompAutorizados.setName("lblCompAutorizados");
/* 124:    */     
/* 125:104 */     this.lblCompNoAutorizados.setText(resourceMap.getString("lblCompNoAutorizados.text", new Object[0]));
/* 126:105 */     this.lblCompNoAutorizados.setName("lblCompNoAutorizados");
/* 127:    */     
/* 128:107 */     this.txtComNoAutorizados.setText(resourceMap.getString("txtComNoAutorizados.text", new Object[0]));
/* 129:108 */     this.txtComNoAutorizados.setDisabledTextColor(resourceMap.getColor("txtComprobantes.disabledTextColor"));
/* 130:109 */     this.txtComNoAutorizados.setEnabled(false);
/* 131:110 */     this.txtComNoAutorizados.setName("txtComNoAutorizados");
/* 132:    */     
/* 133:112 */     this.txtCompAutorizados.setText(resourceMap.getString("txtCompAutorizados.text", new Object[0]));
/* 134:113 */     this.txtCompAutorizados.setDisabledTextColor(resourceMap.getColor("txtComprobantes.disabledTextColor"));
/* 135:114 */     this.txtCompAutorizados.setEnabled(false);
/* 136:115 */     this.txtCompAutorizados.setName("txtCompAutorizados");
/* 137:    */     
/* 138:117 */     this.txtCompFirmados.setText(resourceMap.getString("txtCompFirmados.text", new Object[0]));
/* 139:118 */     this.txtCompFirmados.setDisabledTextColor(resourceMap.getColor("txtComprobantes.disabledTextColor"));
/* 140:119 */     this.txtCompFirmados.setEnabled(false);
/* 141:120 */     this.txtCompFirmados.setName("txtCompFirmados");
/* 142:    */     
/* 143:122 */     this.txtComprobantes.setText(resourceMap.getString("txtComprobantes.text", new Object[0]));
/* 144:123 */     this.txtComprobantes.setDisabledTextColor(resourceMap.getColor("txtComprobantes.disabledTextColor"));
/* 145:124 */     this.txtComprobantes.setEnabled(false);
/* 146:125 */     this.txtComprobantes.setName("txtComprobantes");
/* 147:    */     
/* 148:127 */     this.btnComprobantes.setText(resourceMap.getString("btnComprobantes.text", new Object[0]));
/* 149:128 */     this.btnComprobantes.setName("btnComprobantes");
/* 150:129 */     this.btnComprobantes.addActionListener(new ActionListener()
/* 151:    */     {
/* 152:    */       public void actionPerformed(ActionEvent evt)
/* 153:    */       {
/* 154:131 */         ConfiguracionDirectorioView.this.btnComprobantesActionPerformed(evt);
/* 155:    */       }
/* 156:134 */     });
/* 157:135 */     this.btnCompFirmados.setText(resourceMap.getString("btnCompFirmados.text", new Object[0]));
/* 158:136 */     this.btnCompFirmados.setName("btnCompFirmados");
/* 159:137 */     this.btnCompFirmados.addActionListener(new ActionListener()
/* 160:    */     {
/* 161:    */       public void actionPerformed(ActionEvent evt)
/* 162:    */       {
/* 163:139 */         ConfiguracionDirectorioView.this.btnCompFirmadosActionPerformed(evt);
/* 164:    */       }
/* 165:142 */     });
/* 166:143 */     this.btnCompAutorizados.setText(resourceMap.getString("btnCompAutorizados.text", new Object[0]));
/* 167:144 */     this.btnCompAutorizados.setName("btnCompAutorizados");
/* 168:145 */     this.btnCompAutorizados.addActionListener(new ActionListener()
/* 169:    */     {
/* 170:    */       public void actionPerformed(ActionEvent evt)
/* 171:    */       {
/* 172:147 */         ConfiguracionDirectorioView.this.btnCompAutorizadosActionPerformed(evt);
/* 173:    */       }
/* 174:150 */     });
/* 175:151 */     this.btnCompNoAutorizados.setText(resourceMap.getString("btnCompNoAutorizados.text", new Object[0]));
/* 176:152 */     this.btnCompNoAutorizados.setName("btnCompNoAutorizados");
/* 177:153 */     this.btnCompNoAutorizados.addActionListener(new ActionListener()
/* 178:    */     {
/* 179:    */       public void actionPerformed(ActionEvent evt)
/* 180:    */       {
/* 181:155 */         ConfiguracionDirectorioView.this.btnCompNoAutorizadosActionPerformed(evt);
/* 182:    */       }
/* 183:158 */     });
/* 184:159 */     this.jPanel1.setBackground(resourceMap.getColor("jPanel1.background"));
/* 185:160 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/* 186:161 */     this.jPanel1.setName("jPanel1");
/* 187:    */     
/* 188:163 */     this.btnCrearDirectorio.setText(resourceMap.getString("btnCrearDirectorio.text", new Object[0]));
/* 189:164 */     this.btnCrearDirectorio.setName("btnCrearDirectorio");
/* 190:165 */     this.btnCrearDirectorio.addActionListener(new ActionListener()
/* 191:    */     {
/* 192:    */       public void actionPerformed(ActionEvent evt)
/* 193:    */       {
/* 194:167 */         ConfiguracionDirectorioView.this.btnCrearDirectorioActionPerformed(evt);
/* 195:    */       }
/* 196:170 */     });
/* 197:171 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 198:172 */     this.jPanel1.setLayout(jPanel1Layout);
/* 199:173 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(458, 32767).addComponent(this.btnCrearDirectorio, -2, 144, -2)));
/* 200:    */     
/* 201:    */ 
/* 202:    */ 
/* 203:    */ 
/* 204:    */ 
/* 205:179 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.btnCrearDirectorio).addContainerGap()));
/* 206:    */     
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:    */ 
/* 211:    */ 
/* 212:    */ 
/* 213:187 */     GroupLayout layout = new GroupLayout(this);
/* 214:188 */     setLayout(layout);
/* 215:189 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblCompNoAutorizados, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.lblCompAutorizados, -1, -1, 32767).addGap(19, 19, 19)).addGroup(layout.createSequentialGroup().addComponent(this.lblCompFirmados, -1, -1, 32767).addGap(36, 36, 36)).addGroup(layout.createSequentialGroup().addComponent(this.lblComprobantes, -1, -1, 32767).addGap(25, 25, 25))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtComprobantes, -1, 306, 32767).addComponent(this.txtCompFirmados, -1, 306, 32767).addComponent(this.txtCompAutorizados, -1, 306, 32767).addComponent(this.txtComNoAutorizados, -1, 306, 32767)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnComprobantes, -1, -1, 32767).addComponent(this.btnCompFirmados, -1, -1, 32767).addComponent(this.btnCompAutorizados, -1, -1, 32767).addComponent(this.btnCompNoAutorizados, -1, -1, 32767)).addGap(24, 24, 24)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18)))));
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
/* 239:    */ 
/* 240:    */ 
/* 241:    */ 
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:    */ 
/* 248:    */ 
/* 249:223 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblComprobantes).addComponent(this.txtComprobantes, -2, -1, -2).addComponent(this.btnComprobantes)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblCompFirmados).addComponent(this.txtCompFirmados, -2, -1, -2).addComponent(this.btnCompFirmados)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblCompAutorizados).addComponent(this.txtCompAutorizados, -2, -1, -2).addComponent(this.btnCompAutorizados)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblCompNoAutorizados).addComponent(this.txtComNoAutorizados, -2, -1, -2).addComponent(this.btnCompNoAutorizados)).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(19, 19, 19)));
/* 250:    */   }
/* 251:    */   
/* 252:    */   private void btnComprobantesActionPerformed(ActionEvent evt)
/* 253:    */   {
/* 254:254 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserDirectorios();
/* 255:255 */     if (jfc.getSelectedFile() != null) {
/* 256:256 */       this.txtComprobantes.setText(jfc.getSelectedFile().getPath());
/* 257:    */     }
/* 258:    */   }
/* 259:    */   
/* 260:    */   private void btnCompFirmadosActionPerformed(ActionEvent evt)
/* 261:    */   {
/* 262:261 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserDirectorios();
/* 263:262 */     if (jfc.getSelectedFile() != null) {
/* 264:263 */       this.txtCompFirmados.setText(jfc.getSelectedFile().getPath());
/* 265:    */     }
/* 266:    */   }
/* 267:    */   
/* 268:    */   private void btnCompAutorizadosActionPerformed(ActionEvent evt)
/* 269:    */   {
/* 270:268 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserDirectorios();
/* 271:269 */     if (jfc.getSelectedFile() != null) {
/* 272:270 */       this.txtCompAutorizados.setText(jfc.getSelectedFile().getPath());
/* 273:    */     }
/* 274:    */   }
/* 275:    */   
/* 276:    */   private void btnCompNoAutorizadosActionPerformed(ActionEvent evt)
/* 277:    */   {
/* 278:275 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserDirectorios();
/* 279:276 */     if (jfc.getSelectedFile() != null) {
/* 280:277 */       this.txtComNoAutorizados.setText(jfc.getSelectedFile().getPath());
/* 281:    */     }
/* 282:    */   }
/* 283:    */   
/* 284:    */   private void btnCrearDirectorioActionPerformed(ActionEvent evt)
/* 285:    */   {
/* 286:282 */     if (hayCamposVacios().booleanValue()) {
/* 287:283 */       JOptionPane.showMessageDialog(this, "Debe seleccionar todos los directorios");
/* 288:    */     } else {
/* 289:285 */       validarExisteDirectorio();
/* 290:    */     }
/* 291:    */   }
/* 292:    */   
/* 293:    */   private void validarExisteDirectorio()
/* 294:    */   {
/* 295:    */     try
/* 296:    */     {
/* 297:291 */       this.confDirectorio = new ConfiguracionDirectorioSQL();
/* 298:292 */       if (this.confDirectorio.hayRegistros().booleanValue() == true)
/* 299:    */       {
/* 300:293 */         int i = JOptionPane.showConfirmDialog(this, "Los directorios ya encuentran configurados.\n Desea cambiar la ubicación de los directorios?", "Advertencia", 0);
/* 301:294 */         if (i == 0) {
/* 302:295 */           grabarDirectorios();
/* 303:    */         }
/* 304:    */       }
/* 305:    */       else
/* 306:    */       {
/* 307:298 */         grabarDirectorios();
/* 308:    */       }
/* 309:    */     }
/* 310:    */     catch (ClassNotFoundException ex)
/* 311:    */     {
/* 312:301 */       Logger.getLogger(ConfiguracionDirectorioView.class.getName()).log(Level.SEVERE, null, ex);
/* 313:    */     }
/* 314:    */     catch (SQLException ex)
/* 315:    */     {
/* 316:303 */       Logger.getLogger(ConfiguracionDirectorioView.class.getName()).log(Level.SEVERE, null, ex);
/* 317:    */     }
/* 318:    */   }
/* 319:    */   
/* 320:    */   private void grabarDirectorios()
/* 321:    */   {
/* 322:    */     try
/* 323:    */     {
/* 324:310 */       this.confDirectorio = new ConfiguracionDirectorioSQL();
/* 325:311 */       this.confDirectorio.crearDirectorios(obtenerDirectoriosGrabar());
/* 326:312 */       JOptionPane.showMessageDialog(this, "Los datos se han grabado con éxito");
/* 327:    */     }
/* 328:    */     catch (ClassNotFoundException ex)
/* 329:    */     {
/* 330:314 */       JOptionPane.showMessageDialog(this, "No se encontro el JDBC para la base de datos " + ex.getMessage(), "Error", 0);
/* 331:    */     }
/* 332:    */     catch (SQLException ex)
/* 333:    */     {
/* 334:316 */       JOptionPane.showMessageDialog(this, "Se produjo un error en el sistema " + ex.getMessage(), "Error", 0);
/* 335:    */     }
/* 336:    */   }
/* 337:    */   
/* 338:    */   private List<ConfiguracionDirectorio> obtenerDirectoriosGrabar()
/* 339:    */   {
/* 340:321 */     List<ConfiguracionDirectorio> directoriosGrabar = new ArrayList();
/* 341:322 */     HashMap<Integer, ConfiguracionDirectorio> map = getConfiguracionDirectorio();
/* 342:323 */     Set<Integer> keys = map.keySet();
/* 343:324 */     for (Integer key : keys) {
/* 344:325 */       directoriosGrabar.add(map.get(key));
/* 345:    */     }
/* 346:327 */     return directoriosGrabar;
/* 347:    */   }
/* 348:    */   
/* 349:    */   private HashMap<Integer, ConfiguracionDirectorio> getConfiguracionDirectorio()
/* 350:    */   {
/* 351:331 */     HashMap<Integer, ConfiguracionDirectorio> map = new HashMap();
/* 352:332 */     map.put(Integer.valueOf(1), new ConfiguracionDirectorio(1, this.txtComprobantes.getText()));
/* 353:333 */     map.put(Integer.valueOf(2), new ConfiguracionDirectorio(2, this.txtCompFirmados.getText()));
/* 354:334 */     map.put(Integer.valueOf(3), new ConfiguracionDirectorio(3, this.txtCompAutorizados.getText()));
/* 355:335 */     map.put(Integer.valueOf(4), new ConfiguracionDirectorio(4, this.txtComNoAutorizados.getText()));
/* 356:336 */     return map;
/* 357:    */   }
/* 358:    */   
/* 359:    */   private Boolean hayCamposVacios()
/* 360:    */   {
/* 361:340 */     if ((this.txtComprobantes.getText() == null) || (this.txtComprobantes.getText().isEmpty()) || (this.txtCompFirmados.getText() == null) || (this.txtCompFirmados.getText().isEmpty()) || (this.txtCompAutorizados.getText() == null) || (this.txtCompAutorizados.getText().isEmpty()) || (this.txtComNoAutorizados.getText() == null) || (this.txtComNoAutorizados.getText().isEmpty())) {
/* 362:344 */       return Boolean.TRUE;
/* 363:    */     }
/* 364:346 */     return Boolean.FALSE;
/* 365:    */   }
/* 366:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ConfiguracionDirectorioView
 * JD-Core Version:    0.7.0.1
 */