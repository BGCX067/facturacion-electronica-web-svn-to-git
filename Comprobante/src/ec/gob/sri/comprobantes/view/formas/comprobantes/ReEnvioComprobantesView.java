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
/*  12:    */ import ec.gob.sri.comprobantes.util.AutorizacionComprobantesWs;
/*  13:    */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*  14:    */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*  15:    */ import java.awt.Cursor;
/*  16:    */ import java.awt.Dimension;
/*  17:    */ import java.awt.event.ActionEvent;
/*  18:    */ import java.awt.event.ActionListener;
/*  19:    */ import java.awt.event.MouseAdapter;
/*  20:    */ import java.awt.event.MouseEvent;
/*  21:    */ import java.io.File;
/*  22:    */ import java.text.SimpleDateFormat;
/*  23:    */ import java.util.ArrayList;
/*  24:    */ import java.util.List;
/*  25:    */ import java.util.logging.Level;
/*  26:    */ import java.util.logging.Logger;
/*  27:    */ import javax.accessibility.AccessibleContext;
/*  28:    */ import javax.swing.BorderFactory;
/*  29:    */ import javax.swing.ButtonGroup;
/*  30:    */ import javax.swing.GroupLayout;
/*  31:    */ import javax.swing.GroupLayout.Alignment;
/*  32:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  33:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  34:    */ import javax.swing.JButton;
/*  35:    */ import javax.swing.JCheckBox;
/*  36:    */ import javax.swing.JFileChooser;
/*  37:    */ import javax.swing.JFrame;
/*  38:    */ import javax.swing.JLabel;
/*  39:    */ import javax.swing.JOptionPane;
/*  40:    */ import javax.swing.JPanel;
/*  41:    */ import javax.swing.JRadioButton;
/*  42:    */ import javax.swing.JScrollPane;
/*  43:    */ import javax.swing.JTable;
/*  44:    */ import javax.swing.JTextField;
/*  45:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  46:    */ import javax.swing.ListSelectionModel;
/*  47:    */ import javax.swing.event.ListSelectionEvent;
/*  48:    */ import javax.swing.table.DefaultTableModel;
/*  49:    */ import javax.swing.table.TableColumn;
/*  50:    */ import javax.swing.table.TableColumnModel;
/*  51:    */ import javax.swing.table.TableModel;
/*  52:    */ import javax.swing.table.TableRowSorter;
/*  53:    */ import org.jdesktop.application.Application;
/*  54:    */ import org.jdesktop.application.ApplicationContext;
/*  55:    */ import org.jdesktop.application.ResourceMap;
/*  56:    */ 
/*  57:    */ public class ReEnvioComprobantesView
/*  58:    */   extends JPanel
/*  59:    */ {
/*  60:    */   private FileTableModel modelListaArchivos;
/*  61: 49 */   private ResultadosTableModel modelResultado = null;
/*  62:    */   private Emisor emisor;
/*  63:    */   private String dirTransmitidosSinResp;
/*  64: 52 */   private int showOnlyOnce = 0;
/*  65: 53 */   private int rowEvent = 0;
/*  66: 54 */   static final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy-hhmmss");
/*  67:    */   private JButton btnEnvioIndividual;
/*  68:    */   private ButtonGroup buttonGroup1;
/*  69:    */   private JCheckBox checkSeleccionarTodos;
/*  70:    */   private JButton jButtonExaminar;
/*  71:    */   private JButton jButtonMostrarArchivos;
/*  72:    */   private JLabel jLabel1;
/*  73:    */   private JPanel jPanel1;
/*  74:    */   private JRadioButton jRadioButtonDefecto;
/*  75:    */   private JRadioButton jRadioButtonOtro;
/*  76:    */   private JScrollPane jScrollPane1;
/*  77:    */   private JScrollPane jScrollPane2;
/*  78:    */   private JTable jTableResultado;
/*  79:    */   private JTextField jTextFieldDirectorio;
/*  80:    */   private JLabel lblDirSistema;
/*  81:    */   private JTable tableArchivosPorEnviar;
/*  82:    */   
/*  83:    */   public ReEnvioComprobantesView()
/*  84:    */   {
/*  85: 58 */     initComponents();
/*  86: 59 */     inicializarDatos();
/*  87: 60 */     this.jTableResultado.setVisible(false);
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void inicializarDatos()
/*  91:    */   {
/*  92:    */     try
/*  93:    */     {
/*  94: 68 */       ConfiguracionDirectorioSQL lista = new ConfiguracionDirectorioSQL();
/*  95: 69 */       if (lista.hayRegistros().booleanValue())
/*  96:    */       {
/*  97: 70 */         String firmados = lista.obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/*  98: 71 */         this.emisor = new EmisorSQL().obtenerDatosEmisor();
/*  99:    */         
/* 100: 73 */         this.dirTransmitidosSinResp = (firmados + File.separator + "transmitidosSinRespuesta");
/* 101: 74 */         File transmitidos = new File(this.dirTransmitidosSinResp);
/* 102: 75 */         if (!transmitidos.exists()) {
/* 103: 76 */           new File(this.dirTransmitidosSinResp).mkdir();
/* 104:    */         }
/* 105: 78 */         this.lblDirSistema.setText(this.dirTransmitidosSinResp);
/* 106:    */       }
/* 107: 82 */       this.jTableResultado.addMouseListener(new MouseAdapter()
/* 108:    */       {
/* 109:    */         public void mouseClicked(MouseEvent e)
/* 110:    */         {
/* 111: 85 */           int col = ReEnvioComprobantesView.this.jTableResultado.getSelectedColumn();
/* 112: 86 */           int row = ReEnvioComprobantesView.this.jTableResultado.getSelectedRow();
/* 113: 87 */           if (ReEnvioComprobantesView.this.rowEvent != row) {
/* 114: 88 */             ReEnvioComprobantesView.this.showOnlyOnce = 0;
/* 115:    */           }
/* 116: 91 */           if ((e.getClickCount() == 1) && (col == 4) && (ReEnvioComprobantesView.this.showOnlyOnce == 0))
/* 117:    */           {
/* 118: 92 */             String contenidoCelda = (String)ReEnvioComprobantesView.this.jTableResultado.getValueAt(row, col);
/* 119: 93 */             JOptionPane.showMessageDialog(new JFrame(), contenidoCelda, "Contenido de la celda", 1);
/* 120:    */             
/* 121: 95 */             ReEnvioComprobantesView.this.showOnlyOnce = 1;
/* 122: 96 */             ReEnvioComprobantesView.this.rowEvent = row;
/* 123:    */           }
/* 124:    */         }
/* 125:    */       });
/* 126:    */     }
/* 127:    */     catch (Exception ex)
/* 128:    */     {
/* 129:102 */       ex.printStackTrace();
/* 130:    */     }
/* 131:    */   }
/* 132:    */   
/* 133:    */   private void setColumnWidthResultados()
/* 134:    */   {
/* 135:111 */     for (int i = 0; i < this.jTableResultado.getColumnModel().getColumnCount(); i++)
/* 136:    */     {
/* 137:112 */       TableColumn column = this.jTableResultado.getColumnModel().getColumn(i);
/* 138:113 */       if (i == 0) {
/* 139:114 */         column.setPreferredWidth(47);
/* 140:    */       }
/* 141:116 */       if (i == 1) {
/* 142:117 */         column.setPreferredWidth(250);
/* 143:    */       }
/* 144:119 */       if (i == 2) {
/* 145:120 */         column.setPreferredWidth(120);
/* 146:    */       }
/* 147:122 */       if (i == 3) {
/* 148:123 */         column.setPreferredWidth(100);
/* 149:    */       }
/* 150:126 */       if (i == 4) {
/* 151:127 */         column.setPreferredWidth(250);
/* 152:    */       }
/* 153:    */     }
/* 154:    */   }
/* 155:    */   
/* 156:    */   private void setColumnWidthArchivos()
/* 157:    */   {
/* 158:137 */     for (int i = 0; i < this.tableArchivosPorEnviar.getColumnModel().getColumnCount(); i++)
/* 159:    */     {
/* 160:138 */       TableColumn column = this.tableArchivosPorEnviar.getColumnModel().getColumn(i);
/* 161:139 */       if (i == 0) {
/* 162:140 */         column.setPreferredWidth(90);
/* 163:    */       }
/* 164:142 */       if (i == 1) {
/* 165:143 */         column.setPreferredWidth(410);
/* 166:    */       }
/* 167:145 */       if (i == 2) {
/* 168:146 */         column.setPreferredWidth(90);
/* 169:    */       }
/* 170:148 */       if (i == 3) {
/* 171:149 */         column.setPreferredWidth(130);
/* 172:    */       }
/* 173:    */     }
/* 174:    */   }
/* 175:    */   
/* 176:    */   private List<File> listaSeleccionados()
/* 177:    */   {
/* 178:162 */     List<File> archivosSeleccionados = new ArrayList();
/* 179:164 */     for (int i = 0; i < this.modelListaArchivos.getFilenames().length; i++) {
/* 180:165 */       if ((null != this.modelListaArchivos.getSeleccionados()[i]) && (this.modelListaArchivos.getSeleccionados()[i].booleanValue() == true)) {
/* 181:166 */         archivosSeleccionados.add(new File(this.modelListaArchivos.getDirectorio(), this.modelListaArchivos.getFilenames()[i]));
/* 182:    */       }
/* 183:    */     }
/* 184:169 */     return archivosSeleccionados;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public void valueChanged(ListSelectionEvent e)
/* 188:    */   {
/* 189:173 */     if (e.getValueIsAdjusting())
/* 190:    */     {
/* 191:174 */       int index = e.getFirstIndex();
/* 192:175 */       this.modelListaArchivos.setValueAt(Boolean.TRUE, index, 0);
/* 193:    */     }
/* 194:    */   }
/* 195:    */   
/* 196:    */   private void initComponents()
/* 197:    */   {
/* 198:188 */     this.buttonGroup1 = new ButtonGroup();
/* 199:189 */     this.jPanel1 = new JPanel();
/* 200:190 */     this.jRadioButtonDefecto = new JRadioButton();
/* 201:191 */     this.jRadioButtonOtro = new JRadioButton();
/* 202:192 */     this.jTextFieldDirectorio = new JTextField();
/* 203:193 */     this.jButtonExaminar = new JButton();
/* 204:194 */     this.jButtonMostrarArchivos = new JButton();
/* 205:195 */     this.jLabel1 = new JLabel();
/* 206:196 */     this.jScrollPane1 = new JScrollPane();
/* 207:197 */     this.tableArchivosPorEnviar = new JTable();
/* 208:198 */     this.lblDirSistema = new JLabel();
/* 209:199 */     this.btnEnvioIndividual = new JButton();
/* 210:200 */     this.jScrollPane2 = new JScrollPane();
/* 211:201 */     this.jTableResultado = new JTable();
/* 212:202 */     this.checkSeleccionarTodos = new JCheckBox();
/* 213:    */     
/* 214:204 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ReEnvioComprobantesView.class);
/* 215:205 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 216:206 */     this.jPanel1.setName("jPanel1");
/* 217:207 */     this.jPanel1.setPreferredSize(new Dimension(0, 0));
/* 218:    */     
/* 219:209 */     this.buttonGroup1.add(this.jRadioButtonDefecto);
/* 220:210 */     this.jRadioButtonDefecto.setSelected(true);
/* 221:211 */     this.jRadioButtonDefecto.setText(resourceMap.getString("jRadioButtonDefecto.text", new Object[0]));
/* 222:212 */     this.jRadioButtonDefecto.setName("jRadioButtonDefecto");
/* 223:213 */     this.jRadioButtonDefecto.addActionListener(new ActionListener()
/* 224:    */     {
/* 225:    */       public void actionPerformed(ActionEvent evt)
/* 226:    */       {
/* 227:215 */         ReEnvioComprobantesView.this.jRadioButtonDefectoActionPerformed(evt);
/* 228:    */       }
/* 229:218 */     });
/* 230:219 */     this.buttonGroup1.add(this.jRadioButtonOtro);
/* 231:220 */     this.jRadioButtonOtro.setText(resourceMap.getString("jRadioButtonOtro.text", new Object[0]));
/* 232:221 */     this.jRadioButtonOtro.setName("jRadioButtonOtro");
/* 233:222 */     this.jRadioButtonOtro.addActionListener(new ActionListener()
/* 234:    */     {
/* 235:    */       public void actionPerformed(ActionEvent evt)
/* 236:    */       {
/* 237:224 */         ReEnvioComprobantesView.this.jRadioButtonOtroActionPerformed(evt);
/* 238:    */       }
/* 239:227 */     });
/* 240:228 */     this.jTextFieldDirectorio.setText(resourceMap.getString("jTextFieldDirectorio.text", new Object[0]));
/* 241:229 */     this.jTextFieldDirectorio.setEnabled(false);
/* 242:230 */     this.jTextFieldDirectorio.setName("jTextFieldDirectorio");
/* 243:    */     
/* 244:232 */     this.jButtonExaminar.setText(resourceMap.getString("jButtonExaminar.text", new Object[0]));
/* 245:233 */     this.jButtonExaminar.setName("jButtonExaminar");
/* 246:234 */     this.jButtonExaminar.addActionListener(new ActionListener()
/* 247:    */     {
/* 248:    */       public void actionPerformed(ActionEvent evt)
/* 249:    */       {
/* 250:236 */         ReEnvioComprobantesView.this.jButtonExaminarActionPerformed(evt);
/* 251:    */       }
/* 252:239 */     });
/* 253:240 */     this.jButtonMostrarArchivos.setText(resourceMap.getString("jButtonMostrarArchivos.text", new Object[0]));
/* 254:241 */     this.jButtonMostrarArchivos.setName("jButtonMostrarArchivos");
/* 255:242 */     this.jButtonMostrarArchivos.addActionListener(new ActionListener()
/* 256:    */     {
/* 257:    */       public void actionPerformed(ActionEvent evt)
/* 258:    */       {
/* 259:244 */         ReEnvioComprobantesView.this.jButtonMostrarArchivosActionPerformed(evt);
/* 260:    */       }
/* 261:247 */     });
/* 262:248 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 263:249 */     this.jLabel1.setName("jLabel1");
/* 264:    */     
/* 265:251 */     this.jScrollPane1.setName("jScrollPane1");
/* 266:    */     
/* 267:253 */     this.tableArchivosPorEnviar.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 268:    */     
/* 269:    */ 
/* 270:    */ 
/* 271:    */ 
/* 272:    */ 
/* 273:    */ 
/* 274:    */ 
/* 275:261 */     this.tableArchivosPorEnviar.setName("tableArchivosPorEnviar");
/* 276:262 */     this.jScrollPane1.setViewportView(this.tableArchivosPorEnviar);
/* 277:    */     
/* 278:264 */     this.lblDirSistema.setText(resourceMap.getString("lblDirSistema.text", new Object[0]));
/* 279:265 */     this.lblDirSistema.setName("lblDirSistema");
/* 280:    */     
/* 281:267 */     this.btnEnvioIndividual.setText(resourceMap.getString("btnEnvioIndividual.text", new Object[0]));
/* 282:268 */     this.btnEnvioIndividual.setName("btnEnvioIndividual");
/* 283:269 */     this.btnEnvioIndividual.addActionListener(new ActionListener()
/* 284:    */     {
/* 285:    */       public void actionPerformed(ActionEvent evt)
/* 286:    */       {
/* 287:271 */         ReEnvioComprobantesView.this.btnEnvioIndividualActionPerformed(evt);
/* 288:    */       }
/* 289:274 */     });
/* 290:275 */     this.jScrollPane2.setName("jScrollPane2");
/* 291:    */     
/* 292:277 */     this.jTableResultado.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
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
/* 303:288 */     this.jTableResultado.setName("jTableResultado");
/* 304:289 */     this.jScrollPane2.setViewportView(this.jTableResultado);
/* 305:    */     
/* 306:291 */     this.checkSeleccionarTodos.setText(resourceMap.getString("checkSeleccionarTodos.text", new Object[0]));
/* 307:292 */     this.checkSeleccionarTodos.setName("checkSeleccionarTodos");
/* 308:293 */     this.checkSeleccionarTodos.addActionListener(new ActionListener()
/* 309:    */     {
/* 310:    */       public void actionPerformed(ActionEvent evt)
/* 311:    */       {
/* 312:295 */         ReEnvioComprobantesView.this.checkSeleccionarTodosActionPerformed(evt);
/* 313:    */       }
/* 314:298 */     });
/* 315:299 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 316:300 */     this.jPanel1.setLayout(jPanel1Layout);
/* 317:301 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane2, -1, 1045, 32767).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 1045, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.checkSeleccionarTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 696, 32767).addComponent(this.btnEnvioIndividual).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jRadioButtonDefecto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jRadioButtonOtro, GroupLayout.Alignment.LEADING, -1, 226, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblDirSistema, -1, 630, 32767).addComponent(this.jTextFieldDirectorio, -1, 630, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonExaminar).addGap(101, 101, 101)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButtonMostrarArchivos).addContainerGap(930, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addContainerGap(720, 32767)))));
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
/* 350:    */ 
/* 351:335 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblDirSistema, -2, 24, -2).addComponent(this.jRadioButtonDefecto, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButtonOtro, -2, 27, -2).addComponent(this.jTextFieldDirectorio, -2, -1, -2).addComponent(this.jButtonExaminar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonMostrarArchivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnEnvioIndividual).addComponent(this.checkSeleccionarTodos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane2, -2, 309, -2).addGap(46, 46, 46)));
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
/* 367:    */ 
/* 368:    */ 
/* 369:    */ 
/* 370:    */ 
/* 371:    */ 
/* 372:    */ 
/* 373:    */ 
/* 374:    */ 
/* 375:    */ 
/* 376:    */ 
/* 377:361 */     GroupLayout layout = new GroupLayout(this);
/* 378:362 */     setLayout(layout);
/* 379:363 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 1081, 32767).addContainerGap()));
/* 380:    */     
/* 381:    */ 
/* 382:    */ 
/* 383:    */ 
/* 384:    */ 
/* 385:    */ 
/* 386:370 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 796, 32767).addContainerGap()));
/* 387:    */     
/* 388:    */ 
/* 389:    */ 
/* 390:    */ 
/* 391:    */ 
/* 392:    */ 
/* 393:    */ 
/* 394:378 */     this.jPanel1.getAccessibleContext().setAccessibleName(resourceMap.getString("jPanel1.AccessibleContext.accessibleName", new Object[0]));
/* 395:    */   }
/* 396:    */   
/* 397:    */   private void jButtonMostrarArchivosActionPerformed(ActionEvent evt)
/* 398:    */   {
/* 399:382 */     mostrarArchivos();
/* 400:383 */     this.modelResultado = new ResultadosTableModel();
/* 401:384 */     this.jTableResultado.setModel(this.modelResultado);
/* 402:385 */     setColumnWidthResultados();
/* 403:    */   }
/* 404:    */   
/* 405:    */   private void mostrarArchivos()
/* 406:    */   {
/* 407:    */     File directorio;
/* 408:    */     File directorio;
/* 409:395 */     if (this.jTextFieldDirectorio.getText().isEmpty()) {
/* 410:396 */       directorio = new File(this.dirTransmitidosSinResp);
/* 411:    */     } else {
/* 412:398 */       directorio = new File(this.jTextFieldDirectorio.getText());
/* 413:    */     }
/* 414:402 */     this.modelListaArchivos = new FileTableModel(directorio);
/* 415:    */     
/* 416:    */ 
/* 417:405 */     this.tableArchivosPorEnviar.setModel(this.modelListaArchivos);
/* 418:406 */     TableRowSorter<FileTableModel> sorter = new TableRowSorter(this.modelListaArchivos);
/* 419:407 */     this.tableArchivosPorEnviar.setRowSorter(sorter);
/* 420:408 */     sorter.setComparator(3, new DateStringComparator());
/* 421:409 */     this.tableArchivosPorEnviar.setAutoResizeMode(0);
/* 422:410 */     this.jTableResultado.setAutoResizeMode(0);
/* 423:411 */     setColumnWidthArchivos();
/* 424:    */     
/* 425:413 */     this.tableArchivosPorEnviar.getSelectionModel().setSelectionMode(0);
/* 426:    */     
/* 427:415 */     this.tableArchivosPorEnviar.getSelectionModel().addListSelectionListener(this.tableArchivosPorEnviar);
/* 428:416 */     this.tableArchivosPorEnviar.getModel().addTableModelListener(this.tableArchivosPorEnviar);
/* 429:417 */     inicializarDatos();
/* 430:    */   }
/* 431:    */   
/* 432:    */   private void jButtonExaminarActionPerformed(ActionEvent evt)
/* 433:    */   {
/* 434:427 */     this.jRadioButtonOtro.setSelected(true);
/* 435:428 */     JFileChooser chooser = new JFileChooser();
/* 436:429 */     chooser.setCurrentDirectory(new File(this.dirTransmitidosSinResp));
/* 437:430 */     chooser.setDialogTitle("Seleccionar");
/* 438:431 */     chooser.setFileSelectionMode(1);
/* 439:    */     
/* 440:    */ 
/* 441:434 */     chooser.setAcceptAllFileFilterUsed(false);
/* 442:436 */     if (chooser.showOpenDialog(this) == 0) {
/* 443:437 */       this.jTextFieldDirectorio.setText(chooser.getSelectedFile().getPath());
/* 444:    */     }
/* 445:    */   }
/* 446:    */   
/* 447:    */   private void jRadioButtonOtroActionPerformed(ActionEvent evt)
/* 448:    */   {
/* 449:442 */     if (this.jRadioButtonOtro.isSelected())
/* 450:    */     {
/* 451:443 */       this.jTextFieldDirectorio.setEnabled(true);
/* 452:444 */       this.jTextFieldDirectorio.setEditable(true);
/* 453:    */     }
/* 454:    */   }
/* 455:    */   
/* 456:    */   private void btnEnvioIndividualActionPerformed(ActionEvent evt)
/* 457:    */   {
/* 458:    */     try
/* 459:    */     {
/* 460:456 */       setCursor(Cursor.getPredefinedCursor(3));
/* 461:457 */       this.btnEnvioIndividual.setEnabled(false);
/* 462:    */       
/* 463:459 */       this.modelResultado = new ResultadosTableModel();
/* 464:460 */       this.jTableResultado.setModel(this.modelResultado);
/* 465:461 */       this.jTableResultado.setAutoResizeMode(0);
/* 466:462 */       setColumnWidthResultados();
/* 467:    */       
/* 468:464 */       respuestaAutoriz = null;
/* 469:    */       
/* 470:466 */       List<File> archivosSeleccionados = new ArrayList();
/* 471:467 */       archivosSeleccionados = listaSeleccionados();
/* 472:469 */       if (!archivosSeleccionados.isEmpty())
/* 473:    */       {
/* 474:470 */         i = 1;
/* 475:471 */         for (File archivo : archivosSeleccionados) {
/* 476:    */           try
/* 477:    */           {
/* 478:473 */             String claveAccesoComprobante = ArchivoUtils.obtenerValorXML(archivo, "/*/infoTributaria/claveAcceso");
/* 479:474 */             String tipoComprobante = ArchivoUtils.obtenerValorXML(archivo, "/*/infoTributaria/codDoc").substring(1);
/* 480:476 */             if ((tipoComprobante != null) && (claveAccesoComprobante != null))
/* 481:    */             {
/* 482:479 */               respuestaAutoriz = AutorizacionComprobantesWs.autorizarComprobanteIndividual(claveAccesoComprobante, archivo.getName(), this.emisor.getTipoAmbiente());
/* 483:    */               
/* 484:481 */               String estado = null;
/* 485:482 */               String resultado = null;
/* 486:483 */               if (respuestaAutoriz.lastIndexOf("|") != -1)
/* 487:    */               {
/* 488:484 */                 estado = respuestaAutoriz.substring(0, respuestaAutoriz.lastIndexOf("|"));
/* 489:485 */                 resultado = respuestaAutoriz.substring(respuestaAutoriz.lastIndexOf("|") + 1, respuestaAutoriz.length());
/* 490:    */               }
/* 491:    */               else
/* 492:    */               {
/* 493:487 */                 estado = respuestaAutoriz;
/* 494:488 */                 resultado = "Procesado";
/* 495:    */               }
/* 496:491 */               if (respuestaAutoriz.equals("AUTORIZADO")) {
/* 497:492 */                 JOptionPane.showMessageDialog(this, "El comprobante fue autorizado por el SRI", "Respuesta", 1);
/* 498:    */               } else {
/* 499:494 */                 JOptionPane.showMessageDialog(this, "El comprobante fue guardado, firmado y enviado exitósamente, pero no fue Autorizado\n" + estado + "\n" + resultado, "Respuesta", 1);
/* 500:    */               }
/* 501:497 */               this.modelResultado.addRow(Integer.valueOf(i), archivo.getName(), FormGenerales.obtieneTipoDeComprobante(claveAccesoComprobante), estado, FormGenerales.insertarCaracteres(resultado, "\n", 160));
/* 502:    */               
/* 503:499 */               archivo.delete();
/* 504:    */               
/* 505:501 */               i++;
/* 506:    */             }
/* 507:    */             else
/* 508:    */             {
/* 509:503 */               String m = "\n En: " + archivo.getName() + " la información <codDoc> y <claveAcceso> son obligatorias para el envio del archivo";
/* 510:504 */               JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + m, "Se ha producido un error ", 0);
/* 511:    */             }
/* 512:506 */             this.jTableResultado.setVisible(false);
/* 513:    */           }
/* 514:    */           catch (Exception ex)
/* 515:    */           {
/* 516:508 */             Logger.getLogger(ReEnvioComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 517:    */           }
/* 518:    */         }
/* 519:    */       }
/* 520:    */     }
/* 521:    */     finally
/* 522:    */     {
/* 523:    */       String respuestaAutoriz;
/* 524:    */       int i;
/* 525:513 */       setCursor(Cursor.getDefaultCursor());
/* 526:514 */       this.btnEnvioIndividual.setEnabled(true);
/* 527:515 */       mostrarArchivos();
/* 528:    */     }
/* 529:    */   }
/* 530:    */   
/* 531:    */   private void jRadioButtonDefectoActionPerformed(ActionEvent evt)
/* 532:    */   {
/* 533:520 */     this.jTextFieldDirectorio.setText(null);
/* 534:    */   }
/* 535:    */   
/* 536:    */   private void checkSeleccionarTodosActionPerformed(ActionEvent evt)
/* 537:    */   {
/* 538:525 */     if (this.checkSeleccionarTodos.isSelected()) {
/* 539:525 */       this.modelListaArchivos.seleccionarTodos(true);
/* 540:    */     } else {
/* 541:525 */       this.modelListaArchivos.seleccionarTodos(false);
/* 542:    */     }
/* 543:525 */     this.modelListaArchivos.fireTableDataChanged();
/* 544:    */   }
/* 545:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.ReEnvioComprobantesView
 * JD-Core Version:    0.7.0.1
 */