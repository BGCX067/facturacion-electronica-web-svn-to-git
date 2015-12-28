/*   1:    */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   6:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   7:    */ import ec.gob.sri.comprobantes.sql.EmisorSQL;
/*   8:    */ import ec.gob.sri.comprobantes.table.model.DateStringComparator;
/*   9:    */ import ec.gob.sri.comprobantes.table.model.FileTableModel;
/*  10:    */ import ec.gob.sri.comprobantes.table.model.ResultadosTableModel;
/*  11:    */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*  12:    */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*  13:    */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*  14:    */ import ec.gob.sri.comprobantes.util.TokensValidos;
/*  15:    */ import java.awt.Cursor;
/*  16:    */ import java.awt.Dimension;
/*  17:    */ import java.awt.event.ActionEvent;
/*  18:    */ import java.awt.event.ActionListener;
/*  19:    */ import java.awt.event.MouseAdapter;
/*  20:    */ import java.awt.event.MouseEvent;
/*  21:    */ import java.io.File;
/*  22:    */ import java.sql.SQLException;
/*  23:    */ import java.util.ArrayList;
/*  24:    */ import java.util.List;
/*  25:    */ import java.util.logging.Level;
/*  26:    */ import java.util.logging.Logger;
/*  27:    */ import javax.swing.BorderFactory;
/*  28:    */ import javax.swing.ButtonGroup;
/*  29:    */ import javax.swing.DefaultComboBoxModel;
/*  30:    */ import javax.swing.GroupLayout;
/*  31:    */ import javax.swing.GroupLayout.Alignment;
/*  32:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  33:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  34:    */ import javax.swing.JButton;
/*  35:    */ import javax.swing.JCheckBox;
/*  36:    */ import javax.swing.JComboBox;
/*  37:    */ import javax.swing.JFileChooser;
/*  38:    */ import javax.swing.JFrame;
/*  39:    */ import javax.swing.JLabel;
/*  40:    */ import javax.swing.JOptionPane;
/*  41:    */ import javax.swing.JPanel;
/*  42:    */ import javax.swing.JRadioButton;
/*  43:    */ import javax.swing.JScrollPane;
/*  44:    */ import javax.swing.JTable;
/*  45:    */ import javax.swing.JTextField;
/*  46:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  47:    */ import javax.swing.ListSelectionModel;
/*  48:    */ import javax.swing.event.ListSelectionEvent;
/*  49:    */ import javax.swing.table.DefaultTableModel;
/*  50:    */ import javax.swing.table.TableColumn;
/*  51:    */ import javax.swing.table.TableColumnModel;
/*  52:    */ import javax.swing.table.TableRowSorter;
/*  53:    */ import org.jdesktop.application.Application;
/*  54:    */ import org.jdesktop.application.ApplicationContext;
/*  55:    */ import org.jdesktop.application.ResourceMap;
/*  56:    */ 
/*  57:    */ public class FirmaDigitalView
/*  58:    */   extends JPanel
/*  59:    */ {
/*  60: 48 */   private ResultadosTableModel modelResultado = null;
/*  61:    */   private FileTableModel modelListaArchivos;
/*  62:    */   private String tokenSeleccionado;
/*  63:    */   private String directorioGenerados;
/*  64:    */   private String directorioFirmados;
/*  65: 53 */   private Emisor emisor = null;
/*  66: 54 */   private int showOnlyOnce = 0;
/*  67: 55 */   private int rowEvent = 0;
/*  68:    */   private ButtonGroup buttonGroup1;
/*  69:    */   private JCheckBox checkSeleccionarTodos;
/*  70:    */   private JButton jButtonExaminar;
/*  71:    */   private JButton jButtonFirmarArchivos;
/*  72:    */   private JButton jButtonMostrarArchivos;
/*  73:    */   private JComboBox jComboListaTokens;
/*  74:    */   private JLabel jLabel1;
/*  75:    */   private JPanel jPanel1;
/*  76:    */   private JRadioButton jRadioButtonDefecto;
/*  77:    */   private JRadioButton jRadioButtonOtro;
/*  78:    */   private JScrollPane jScrollPane1;
/*  79:    */   private JScrollPane jScrollPane2;
/*  80:    */   private JTable jTableArchivosPorFirmar;
/*  81:    */   private JTable jTableResultado;
/*  82:    */   private JTextField jTextFieldDirectorio;
/*  83:    */   private JLabel lblDirSistema;
/*  84:    */   
/*  85:    */   public FirmaDigitalView()
/*  86:    */   {
/*  87: 59 */     initComponents();
/*  88: 60 */     inicializarDatos();
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void inicializarDatos()
/*  92:    */   {
/*  93:    */     try
/*  94:    */     {
/*  95: 68 */       this.modelResultado = new ResultadosTableModel();
/*  96: 69 */       this.jTableResultado.setModel(this.modelResultado);
/*  97:    */       
/*  98: 71 */       setColumnWidthResultados();
/*  99:    */       
/* 100: 73 */       this.emisor = new EmisorSQL().obtenerDatosEmisor();
/* 101: 75 */       if (this.emisor != null)
/* 102:    */       {
/* 103: 76 */         this.jComboListaTokens.setSelectedItem(TokensValidos.valueOf(TokensValidos.class, this.emisor.getToken()));
/* 104: 77 */         this.tokenSeleccionado = ((TokensValidos)this.jComboListaTokens.getSelectedItem()).name();
/* 105:    */         
/* 106: 79 */         this.lblDirSistema.setText(this.directorioGenerados);
/* 107:    */       }
/* 108: 82 */       if (new ConfiguracionDirectorioSQL().hayRegistros().booleanValue() == true) {
/* 109: 83 */         this.directorioGenerados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath();
/* 110:    */       }
/* 111: 86 */       this.jTableResultado.addMouseListener(new MouseAdapter()
/* 112:    */       {
/* 113:    */         public void mouseClicked(MouseEvent e)
/* 114:    */         {
/* 115: 90 */           int col = FirmaDigitalView.this.jTableResultado.getSelectedColumn();
/* 116: 91 */           int row = FirmaDigitalView.this.jTableResultado.getSelectedRow();
/* 117: 92 */           if (FirmaDigitalView.this.rowEvent != row) {
/* 118: 93 */             FirmaDigitalView.this.showOnlyOnce = 0;
/* 119:    */           }
/* 120: 96 */           if ((e.getClickCount() == 1) && (col == 4) && (FirmaDigitalView.this.showOnlyOnce == 0))
/* 121:    */           {
/* 122: 97 */             String contenidoCelda = (String)FirmaDigitalView.this.jTableResultado.getValueAt(row, col);
/* 123: 98 */             JOptionPane.showMessageDialog(new JFrame(), contenidoCelda, "Contenido de la celda", 1);
/* 124:    */             
/* 125:100 */             FirmaDigitalView.this.showOnlyOnce = 1;
/* 126:101 */             FirmaDigitalView.this.rowEvent = row;
/* 127:    */           }
/* 128:    */         }
/* 129:    */       });
/* 130:    */     }
/* 131:    */     catch (SQLException ex)
/* 132:    */     {
/* 133:106 */       Logger.getLogger(FirmaDigitalView.class.getName()).log(Level.SEVERE, null, ex);
/* 134:    */     }
/* 135:    */     catch (ClassNotFoundException ex)
/* 136:    */     {
/* 137:108 */       Logger.getLogger(FirmaDigitalView.class.getName()).log(Level.SEVERE, null, ex);
/* 138:    */     }
/* 139:    */   }
/* 140:    */   
/* 141:    */   private void setColumnWidthResultados()
/* 142:    */   {
/* 143:116 */     for (int i = 0; i < this.jTableResultado.getColumnModel().getColumnCount(); i++)
/* 144:    */     {
/* 145:117 */       TableColumn column = this.jTableResultado.getColumnModel().getColumn(i);
/* 146:118 */       if (i == 0) {
/* 147:119 */         column.setPreferredWidth(47);
/* 148:    */       }
/* 149:121 */       if (i == 1) {
/* 150:122 */         column.setPreferredWidth(250);
/* 151:    */       }
/* 152:124 */       if (i == 2) {
/* 153:125 */         column.setPreferredWidth(120);
/* 154:    */       }
/* 155:127 */       if (i == 3) {
/* 156:128 */         column.setPreferredWidth(100);
/* 157:    */       }
/* 158:130 */       if (i == 4) {
/* 159:131 */         column.setPreferredWidth(250);
/* 160:    */       }
/* 161:    */     }
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void valueChanged(ListSelectionEvent e)
/* 165:    */   {
/* 166:141 */     if (e.getValueIsAdjusting())
/* 167:    */     {
/* 168:142 */       int index = e.getFirstIndex();
/* 169:143 */       this.modelListaArchivos.setValueAt(Boolean.TRUE, index, 0);
/* 170:    */     }
/* 171:    */   }
/* 172:    */   
/* 173:    */   private void initComponents()
/* 174:    */   {
/* 175:156 */     this.buttonGroup1 = new ButtonGroup();
/* 176:157 */     this.jPanel1 = new JPanel();
/* 177:158 */     this.jRadioButtonDefecto = new JRadioButton();
/* 178:159 */     this.jRadioButtonOtro = new JRadioButton();
/* 179:160 */     this.jTextFieldDirectorio = new JTextField();
/* 180:161 */     this.jButtonExaminar = new JButton();
/* 181:162 */     this.jButtonMostrarArchivos = new JButton();
/* 182:163 */     this.jLabel1 = new JLabel();
/* 183:164 */     this.jScrollPane1 = new JScrollPane();
/* 184:165 */     this.jTableArchivosPorFirmar = new JTable();
/* 185:166 */     this.jButtonFirmarArchivos = new JButton();
/* 186:167 */     this.jComboListaTokens = new JComboBox();
/* 187:168 */     this.checkSeleccionarTodos = new JCheckBox();
/* 188:169 */     this.lblDirSistema = new JLabel();
/* 189:170 */     this.jScrollPane2 = new JScrollPane();
/* 190:171 */     this.jTableResultado = new JTable();
/* 191:    */     
/* 192:173 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(FirmaDigitalView.class);
/* 193:174 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 194:175 */     this.jPanel1.setName("jPanel1");
/* 195:176 */     this.jPanel1.setPreferredSize(new Dimension(0, 0));
/* 196:    */     
/* 197:178 */     this.buttonGroup1.add(this.jRadioButtonDefecto);
/* 198:179 */     this.jRadioButtonDefecto.setSelected(true);
/* 199:180 */     this.jRadioButtonDefecto.setText(resourceMap.getString("jRadioButtonDefecto.text", new Object[0]));
/* 200:181 */     this.jRadioButtonDefecto.setName("jRadioButtonDefecto");
/* 201:182 */     this.jRadioButtonDefecto.addActionListener(new ActionListener()
/* 202:    */     {
/* 203:    */       public void actionPerformed(ActionEvent evt)
/* 204:    */       {
/* 205:184 */         FirmaDigitalView.this.jRadioButtonDefectoActionPerformed(evt);
/* 206:    */       }
/* 207:187 */     });
/* 208:188 */     this.buttonGroup1.add(this.jRadioButtonOtro);
/* 209:189 */     this.jRadioButtonOtro.setText(resourceMap.getString("jRadioButtonOtro.text", new Object[0]));
/* 210:190 */     this.jRadioButtonOtro.setName("jRadioButtonOtro");
/* 211:191 */     this.jRadioButtonOtro.addActionListener(new ActionListener()
/* 212:    */     {
/* 213:    */       public void actionPerformed(ActionEvent evt)
/* 214:    */       {
/* 215:193 */         FirmaDigitalView.this.jRadioButtonOtroActionPerformed(evt);
/* 216:    */       }
/* 217:196 */     });
/* 218:197 */     this.jTextFieldDirectorio.setText(resourceMap.getString("jTextFieldDirectorio.text", new Object[0]));
/* 219:198 */     this.jTextFieldDirectorio.setEnabled(false);
/* 220:199 */     this.jTextFieldDirectorio.setName("jTextFieldDirectorio");
/* 221:    */     
/* 222:201 */     this.jButtonExaminar.setText(resourceMap.getString("jButtonExaminar.text", new Object[0]));
/* 223:202 */     this.jButtonExaminar.setName("jButtonExaminar");
/* 224:203 */     this.jButtonExaminar.addActionListener(new ActionListener()
/* 225:    */     {
/* 226:    */       public void actionPerformed(ActionEvent evt)
/* 227:    */       {
/* 228:205 */         FirmaDigitalView.this.jButtonExaminarActionPerformed(evt);
/* 229:    */       }
/* 230:208 */     });
/* 231:209 */     this.jButtonMostrarArchivos.setText(resourceMap.getString("jButtonMostrarArchivos.text", new Object[0]));
/* 232:210 */     this.jButtonMostrarArchivos.setName("jButtonMostrarArchivos");
/* 233:211 */     this.jButtonMostrarArchivos.addActionListener(new ActionListener()
/* 234:    */     {
/* 235:    */       public void actionPerformed(ActionEvent evt)
/* 236:    */       {
/* 237:213 */         FirmaDigitalView.this.jButtonMostrarArchivosActionPerformed(evt);
/* 238:    */       }
/* 239:216 */     });
/* 240:217 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 241:218 */     this.jLabel1.setName("jLabel1");
/* 242:    */     
/* 243:220 */     this.jScrollPane1.setName("jScrollPane1");
/* 244:    */     
/* 245:222 */     this.jTableArchivosPorFirmar.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 246:    */     
/* 247:    */ 
/* 248:    */ 
/* 249:    */ 
/* 250:    */ 
/* 251:    */ 
/* 252:    */ 
/* 253:230 */     this.jTableArchivosPorFirmar.setName("jTableArchivosPorFirmar");
/* 254:231 */     this.jScrollPane1.setViewportView(this.jTableArchivosPorFirmar);
/* 255:    */     
/* 256:233 */     this.jButtonFirmarArchivos.setText(resourceMap.getString("jButtonFirmarArchivos.text", new Object[0]));
/* 257:234 */     this.jButtonFirmarArchivos.setEnabled(false);
/* 258:235 */     this.jButtonFirmarArchivos.setName("jButtonFirmarArchivos");
/* 259:236 */     this.jButtonFirmarArchivos.setPreferredSize(new Dimension(113, 23));
/* 260:237 */     this.jButtonFirmarArchivos.addActionListener(new ActionListener()
/* 261:    */     {
/* 262:    */       public void actionPerformed(ActionEvent evt)
/* 263:    */       {
/* 264:239 */         FirmaDigitalView.this.jButtonFirmarArchivosActionPerformed(evt);
/* 265:    */       }
/* 266:242 */     });
/* 267:243 */     this.jComboListaTokens.setModel(new DefaultComboBoxModel(TokensValidos.values()));
/* 268:244 */     this.jComboListaTokens.setName("jComboListaTokens");
/* 269:245 */     this.jComboListaTokens.addActionListener(new ActionListener()
/* 270:    */     {
/* 271:    */       public void actionPerformed(ActionEvent evt)
/* 272:    */       {
/* 273:247 */         FirmaDigitalView.this.jComboListaTokensActionPerformed(evt);
/* 274:    */       }
/* 275:250 */     });
/* 276:251 */     this.checkSeleccionarTodos.setText(resourceMap.getString("checkSeleccionarTodos.text", new Object[0]));
/* 277:252 */     this.checkSeleccionarTodos.setName("checkSeleccionarTodos");
/* 278:253 */     this.checkSeleccionarTodos.addActionListener(new ActionListener()
/* 279:    */     {
/* 280:    */       public void actionPerformed(ActionEvent evt)
/* 281:    */       {
/* 282:255 */         FirmaDigitalView.this.checkSeleccionarTodosActionPerformed(evt);
/* 283:    */       }
/* 284:258 */     });
/* 285:259 */     this.lblDirSistema.setText(resourceMap.getString("lblDirSistema.text", new Object[0]));
/* 286:260 */     this.lblDirSistema.setName("lblDirSistema");
/* 287:    */     
/* 288:262 */     this.jScrollPane2.setName("jScrollPane2");
/* 289:    */     
/* 290:264 */     this.jTableResultado.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } }, new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
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
/* 301:275 */     this.jTableResultado.setAutoResizeMode(0);
/* 302:276 */     this.jTableResultado.setName("jTableResultado");
/* 303:277 */     this.jScrollPane2.setViewportView(this.jTableResultado);
/* 304:278 */     this.jTableResultado.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTableResultado.columnModel.title0", new Object[0]));
/* 305:279 */     this.jTableResultado.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTableResultado.columnModel.title1", new Object[0]));
/* 306:280 */     this.jTableResultado.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTableResultado.columnModel.title2", new Object[0]));
/* 307:281 */     this.jTableResultado.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTableResultado.columnModel.title3", new Object[0]));
/* 308:    */     
/* 309:283 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 310:284 */     this.jPanel1.setLayout(jPanel1Layout);
/* 311:285 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 826, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jRadioButtonDefecto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jRadioButtonOtro, GroupLayout.Alignment.LEADING, -1, 226, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jTextFieldDirectorio, -1, 428, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonExaminar)).addComponent(this.lblDirSistema, -1, 506, 32767)).addGap(82, 82, 82)).addComponent(this.jButtonMostrarArchivos).addComponent(this.jLabel1).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 826, 32767).addComponent(this.checkSeleccionarTodos).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jComboListaTokens, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonFirmarArchivos, -2, 139, -2))).addContainerGap()));
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
/* 324:    */ 
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
/* 339:313 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButtonDefecto, -2, 36, -2).addComponent(this.lblDirSistema)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButtonOtro, -2, 27, -2).addComponent(this.jTextFieldDirectorio, -2, -1, -2).addComponent(this.jButtonExaminar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonMostrarArchivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.checkSeleccionarTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jComboListaTokens, -2, 22, -2).addComponent(this.jButtonFirmarArchivos, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 327, -2).addContainerGap(111, 32767)));
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
/* 360:    */ 
/* 361:    */ 
/* 362:    */ 
/* 363:    */ 
/* 364:    */ 
/* 365:    */ 
/* 366:    */ 
/* 367:341 */     GroupLayout layout = new GroupLayout(this);
/* 368:342 */     setLayout(layout);
/* 369:343 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 862, 32767).addContainerGap()));
/* 370:    */     
/* 371:    */ 
/* 372:    */ 
/* 373:    */ 
/* 374:    */ 
/* 375:    */ 
/* 376:350 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 917, 32767).addContainerGap()));
/* 377:    */   }
/* 378:    */   
/* 379:    */   private void jButtonMostrarArchivosActionPerformed(ActionEvent evt)
/* 380:    */   {
/* 381:365 */     mostrarArchivos();
/* 382:366 */     this.modelResultado = new ResultadosTableModel();
/* 383:367 */     this.jTableResultado.setModel(this.modelResultado);
/* 384:368 */     this.jTableResultado.setAutoResizeMode(0);
/* 385:369 */     this.jTableArchivosPorFirmar.setAutoResizeMode(0);
/* 386:370 */     setColumnWidthResultados();
/* 387:    */   }
/* 388:    */   
/* 389:    */   private void mostrarArchivos()
/* 390:    */   {
/* 391:    */     File directorio;
/* 392:    */     File directorio;
/* 393:378 */     if (this.jTextFieldDirectorio.getText().isEmpty()) {
/* 394:379 */       directorio = new File(this.directorioGenerados);
/* 395:    */     } else {
/* 396:381 */       directorio = new File(this.jTextFieldDirectorio.getText());
/* 397:    */     }
/* 398:385 */     this.modelListaArchivos = new FileTableModel(directorio);
/* 399:    */     
/* 400:    */ 
/* 401:388 */     this.jTableArchivosPorFirmar.setModel(this.modelListaArchivos);
/* 402:389 */     TableRowSorter<FileTableModel> sorter = new TableRowSorter(this.modelListaArchivos);
/* 403:390 */     this.jTableArchivosPorFirmar.setRowSorter(sorter);
/* 404:391 */     sorter.setComparator(3, new DateStringComparator());
/* 405:392 */     this.jTableArchivosPorFirmar.setAutoResizeMode(0);
/* 406:    */     
/* 407:394 */     this.jTableArchivosPorFirmar.getSelectionModel().setSelectionMode(0);
/* 408:    */     
/* 409:396 */     this.jTableArchivosPorFirmar.getSelectionModel().addListSelectionListener(this.jTableArchivosPorFirmar);
/* 410:397 */     setColumnWidthArchivos();
/* 411:    */   }
/* 412:    */   
/* 413:    */   private void setColumnWidthArchivos()
/* 414:    */   {
/* 415:405 */     for (int i = 0; i < this.jTableArchivosPorFirmar.getColumnModel().getColumnCount(); i++)
/* 416:    */     {
/* 417:406 */       TableColumn column = this.jTableArchivosPorFirmar.getColumnModel().getColumn(i);
/* 418:407 */       if (i == 0) {
/* 419:408 */         column.setPreferredWidth(90);
/* 420:    */       }
/* 421:410 */       if (i == 1) {
/* 422:411 */         column.setPreferredWidth(410);
/* 423:    */       }
/* 424:413 */       if (i == 2) {
/* 425:414 */         column.setPreferredWidth(90);
/* 426:    */       }
/* 427:416 */       if (i == 3) {
/* 428:417 */         column.setPreferredWidth(130);
/* 429:    */       }
/* 430:    */     }
/* 431:    */   }
/* 432:    */   
/* 433:    */   private void jButtonExaminarActionPerformed(ActionEvent evt)
/* 434:    */   {
/* 435:429 */     this.jRadioButtonOtro.setSelected(true);
/* 436:430 */     JFileChooser chooser = new JFileChooser();
/* 437:431 */     chooser.setCurrentDirectory(new File(this.directorioGenerados));
/* 438:432 */     chooser.setDialogTitle("Seleccionar");
/* 439:433 */     chooser.setFileSelectionMode(1);
/* 440:    */     
/* 441:    */ 
/* 442:436 */     chooser.setAcceptAllFileFilterUsed(false);
/* 443:438 */     if (chooser.showOpenDialog(this) == 0) {
/* 444:439 */       this.jTextFieldDirectorio.setText(chooser.getSelectedFile().getPath());
/* 445:    */     }
/* 446:    */   }
/* 447:    */   
/* 448:    */   private void jButtonFirmarArchivosActionPerformed(ActionEvent evt)
/* 449:    */   {
/* 450:    */     try
/* 451:    */     {
/* 452:450 */       String password = null;
/* 453:451 */       setCursor(Cursor.getPredefinedCursor(3));
/* 454:452 */       this.jButtonFirmarArchivos.setEnabled(false);
/* 455:    */       
/* 456:454 */       this.modelResultado = new ResultadosTableModel();
/* 457:455 */       this.jTableResultado.setModel(this.modelResultado);
/* 458:456 */       setColumnWidthResultados();
/* 459:457 */       List<File> archivosSeleccionados = new ArrayList();
/* 460:    */       
/* 461:459 */       this.directorioFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 462:462 */       for (int i = 0; i < this.modelListaArchivos.getFilenames().length; i++) {
/* 463:463 */         if ((null != this.modelListaArchivos.getSeleccionados()[i]) && (this.modelListaArchivos.getSeleccionados()[i].booleanValue() == true)) {
/* 464:464 */           archivosSeleccionados.add(new File(this.modelListaArchivos.getDirectorio(), this.modelListaArchivos.getFilenames()[i]));
/* 465:    */         }
/* 466:    */       }
/* 467:468 */       int i = 1;
/* 468:469 */       if (!archivosSeleccionados.isEmpty())
/* 469:    */       {
/* 470:470 */         if ((this.tokenSeleccionado.equals("ANF_TOKEN")) || (System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) {
/* 471:473 */           password = FormGenerales.ingresaPassword();
/* 472:    */         }
/* 473:476 */         String respuestaFirmado = null;
/* 474:477 */         for (File archivo : archivosSeleccionados)
/* 475:    */         {
/* 476:479 */           respuestaFirmado = ArchivoUtils.firmarArchivo(this.emisor, archivo.getPath(), this.directorioFirmados, this.tokenSeleccionado, password);
/* 477:480 */           String tipo = FormGenerales.obtieneTipoDeComprobante(ArchivoUtils.obtenerValorXML(archivo, "/*/infoTributaria/claveAcceso"));
/* 478:    */           
/* 479:482 */           String resultado = respuestaFirmado == null ? "Firmado" : "Error al firmar";
/* 480:483 */           if (respuestaFirmado != null) {
/* 481:484 */             respuestaFirmado = respuestaFirmado.equals("no match") ? "Contraseña incorrecta" : respuestaFirmado;
/* 482:    */           } else {
/* 483:486 */             archivo.delete();
/* 484:    */           }
/* 485:488 */           this.modelResultado.addRow(Integer.valueOf(i), archivo.getName(), tipo == null ? "Clave inválida" : tipo, resultado, FormGenerales.insertarCaracteres(respuestaFirmado == null ? "Firma válida" : respuestaFirmado, "\n", 160));
/* 486:    */           
/* 487:490 */           i++;
/* 488:491 */           respuestaFirmado = null;
/* 489:    */         }
/* 490:493 */         JOptionPane.showMessageDialog(this, "Ha finalizado el firmado de archivos en lote.\nRevisar tabla con resultados individuales ", "", 1);
/* 491:    */       }
/* 492:    */       else
/* 493:    */       {
/* 494:497 */         JOptionPane.showMessageDialog(this, "Seleccione al menos un archivo", "Seleccione archivos", 0);
/* 495:    */       }
/* 496:    */     }
/* 497:    */     catch (Exception ex)
/* 498:    */     {
/* 499:501 */       Logger.getLogger(FirmaDigitalView.class.getName()).log(Level.SEVERE, null, ex);
/* 500:    */     }
/* 501:    */     finally
/* 502:    */     {
/* 503:503 */       setCursor(Cursor.getDefaultCursor());
/* 504:504 */       this.jButtonFirmarArchivos.setEnabled(true);
/* 505:505 */       mostrarArchivos();
/* 506:    */     }
/* 507:    */   }
/* 508:    */   
/* 509:    */   private void jComboListaTokensActionPerformed(ActionEvent evt)
/* 510:    */   {
/* 511:510 */     this.tokenSeleccionado = ((TokensValidos)this.jComboListaTokens.getSelectedItem()).name();
/* 512:511 */     this.jButtonFirmarArchivos.setEnabled(true);
/* 513:    */   }
/* 514:    */   
/* 515:    */   private void jRadioButtonOtroActionPerformed(ActionEvent evt)
/* 516:    */   {
/* 517:515 */     if (this.jRadioButtonOtro.isSelected())
/* 518:    */     {
/* 519:516 */       this.jTextFieldDirectorio.setEnabled(true);
/* 520:517 */       this.jTextFieldDirectorio.setEditable(true);
/* 521:    */     }
/* 522:    */   }
/* 523:    */   
/* 524:    */   private void checkSeleccionarTodosActionPerformed(ActionEvent evt)
/* 525:    */   {
/* 526:527 */     if (this.checkSeleccionarTodos.isSelected()) {
/* 527:528 */       this.modelListaArchivos.seleccionarTodos(true);
/* 528:    */     } else {
/* 529:530 */       this.modelListaArchivos.seleccionarTodos(false);
/* 530:    */     }
/* 531:532 */     this.modelListaArchivos.fireTableDataChanged();
/* 532:    */   }
/* 533:    */   
/* 534:    */   private void jRadioButtonDefectoActionPerformed(ActionEvent evt)
/* 535:    */   {
/* 536:536 */     this.jTextFieldDirectorio.setText(null);
/* 537:    */   }
/* 538:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.FirmaDigitalView
 * JD-Core Version:    0.7.0.1
 */