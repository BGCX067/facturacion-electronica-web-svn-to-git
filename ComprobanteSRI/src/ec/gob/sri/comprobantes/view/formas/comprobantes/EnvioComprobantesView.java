/*   1:    */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*   2:    */ 
/*   3:    */ import com.thoughtworks.xstream.XStream;
/*   4:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   6:    */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*   7:    */ import ec.gob.sri.comprobantes.modelo.ComprobanteXml;
/*   8:    */ import ec.gob.sri.comprobantes.modelo.LoteXml;
/*   9:    */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*  10:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*  11:    */ import ec.gob.sri.comprobantes.sql.EmisorSQL;
/*  12:    */ import ec.gob.sri.comprobantes.table.model.DateStringComparator;
/*  13:    */ import ec.gob.sri.comprobantes.table.model.FileTableModel;
/*  14:    */ import ec.gob.sri.comprobantes.table.model.ResultadosTableModel;
/*  15:    */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*  16:    */ import ec.gob.sri.comprobantes.util.AutorizacionComprobantesWs;
/*  17:    */ import ec.gob.sri.comprobantes.util.ClaveDeAcceso;
/*  18:    */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*  19:    */ import ec.gob.sri.comprobantes.util.EnvioComprobantesWs;
/*  20:    */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*  21:    */ import ec.gob.sri.comprobantes.util.TipoComprobanteEnum;
/*  22:    */ import ec.gob.sri.comprobantes.util.xml.XStreamUtil;
/*  23:    */ import ec.gob.sri.comprobantes.ws.Comprobante;
/*  24:    */ import ec.gob.sri.comprobantes.ws.Comprobante.Mensajes;
/*  25:    */ import ec.gob.sri.comprobantes.ws.Mensaje;
/*  26:    */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
/*  27:    */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud.Comprobantes;
/*  28:    */ import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
/*  29:    */ import java.awt.Cursor;
/*  30:    */ import java.awt.Dimension;
/*  31:    */ import java.awt.event.ActionEvent;
/*  32:    */ import java.awt.event.ActionListener;
/*  33:    */ import java.awt.event.MouseAdapter;
/*  34:    */ import java.awt.event.MouseEvent;
/*  35:    */ import java.io.ByteArrayOutputStream;
/*  36:    */ import java.io.File;
/*  37:    */ import java.io.IOException;
/*  38:    */ import java.io.OutputStreamWriter;
/*  39:    */ import java.io.Writer;
/*  40:    */ import java.sql.SQLException;
/*  41:    */ import java.text.SimpleDateFormat;
/*  42:    */ import java.util.ArrayList;
/*  43:    */ import java.util.Date;
/*  44:    */ import java.util.List;
/*  45:    */ import java.util.logging.Level;
/*  46:    */ import java.util.logging.Logger;
/*  47:    */ import javax.swing.BorderFactory;
/*  48:    */ import javax.swing.ButtonGroup;
/*  49:    */ import javax.swing.GroupLayout;
/*  50:    */ import javax.swing.GroupLayout.Alignment;
/*  51:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  52:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  53:    */ import javax.swing.JButton;
/*  54:    */ import javax.swing.JFileChooser;
/*  55:    */ import javax.swing.JFrame;
/*  56:    */ import javax.swing.JLabel;
/*  57:    */ import javax.swing.JOptionPane;
/*  58:    */ import javax.swing.JPanel;
/*  59:    */ import javax.swing.JRadioButton;
/*  60:    */ import javax.swing.JScrollPane;
/*  61:    */ import javax.swing.JTable;
/*  62:    */ import javax.swing.JTextField;
/*  63:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  64:    */ import javax.swing.ListSelectionModel;
/*  65:    */ import javax.swing.event.ListSelectionEvent;
/*  66:    */ import javax.swing.table.DefaultTableModel;
/*  67:    */ import javax.swing.table.TableColumn;
/*  68:    */ import javax.swing.table.TableColumnModel;
/*  69:    */ import javax.swing.table.TableModel;
/*  70:    */ import javax.swing.table.TableRowSorter;
/*  71:    */ import org.jdesktop.application.Application;
/*  72:    */ import org.jdesktop.application.ApplicationContext;
/*  73:    */ import org.jdesktop.application.ResourceMap;
/*  74:    */ 
/*  75:    */ public class EnvioComprobantesView
/*  76:    */   extends JPanel
/*  77:    */ {
/*  78:    */   private FileTableModel modelListaArchivos;
/*  79: 65 */   private ResultadosTableModel modelResultado = null;
/*  80: 66 */   private String claveAcceso = null;
/*  81:    */   private Emisor emisor;
/*  82:    */   Long secuencial;
/*  83:    */   private String directorioFirmados;
/*  84: 70 */   private String PARAM_TIPO_LOTE = "0";
/*  85: 71 */   private String VERSION = "1.0.0";
/*  86: 72 */   private int MAX_FILE_SIZE = 500;
/*  87: 73 */   private int showOnlyOnce = 0;
/*  88: 74 */   private int rowEvent = 0;
/*  89: 75 */   static final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy-hhmmss");
/*  90:    */   private JButton btnEnviarLotes;
/*  91:    */   private JButton btnEnvioIndividual;
/*  92:    */   private ButtonGroup buttonGroup1;
/*  93:    */   private JButton jButtonExaminar;
/*  94:    */   private JButton jButtonMostrarArchivos;
/*  95:    */   private JLabel jLabel1;
/*  96:    */   private JLabel jLabel2;
/*  97:    */   private JLabel jLabel3;
/*  98:    */   private JPanel jPanel1;
/*  99:    */   private JRadioButton jRadioButtonDefecto;
/* 100:    */   private JRadioButton jRadioButtonOtro;
/* 101:    */   private JScrollPane jScrollPane1;
/* 102:    */   private JScrollPane jScrollPane2;
/* 103:    */   private JTable jTableResultado;
/* 104:    */   private JTextField jTextFieldDirectorio;
/* 105:    */   private JLabel lblDirSistema;
/* 106:    */   private JTextField lblTamanio;
/* 107:    */   private JTable tableArchivosPorEnviar;
/* 108:    */   
/* 109:    */   public EnvioComprobantesView()
/* 110:    */   {
/* 111: 79 */     initComponents();
/* 112: 80 */     inicializarDatos();
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void inicializarDatos()
/* 116:    */   {
/* 117:    */     try
/* 118:    */     {
/* 119: 85 */       this.modelResultado = new ResultadosTableModel();
/* 120: 86 */       this.jTableResultado.setModel(this.modelResultado);
/* 121: 87 */       this.jTableResultado.setAutoResizeMode(0);
/* 122: 88 */       setColumnWidthResultados();
/* 123: 89 */       this.emisor = new EmisorSQL().obtenerDatosEmisor();
/* 124: 90 */       this.secuencial = new ComprobantesSQL().obtenerMaximo(TipoComprobanteEnum.LOTE.getCode());
/* 125: 91 */       String secuencialComprobante = String.format("%09d", new Object[] { Long.valueOf(this.secuencial.longValue()) });
/* 126: 94 */       if (this.emisor != null)
/* 127:    */       {
/* 128: 95 */         String serie = this.emisor.getCodigoEstablecimiento().concat(this.emisor.getCodPuntoEmision());
/* 129: 96 */         this.claveAcceso = new ClaveDeAcceso().generaClave(new Date(), TipoComprobanteEnum.LOTE.getCode(), this.emisor.getRuc(), this.emisor.getTipoAmbiente(), serie, secuencialComprobante, this.emisor.getClaveInterna(), "1");
/* 130:    */       }
/* 131: 99 */       ConfiguracionDirectorioSQL lista = new ConfiguracionDirectorioSQL();
/* 132:101 */       if (lista.hayRegistros().booleanValue() == true)
/* 133:    */       {
/* 134:102 */         this.directorioFirmados = lista.obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 135:103 */         this.lblDirSistema.setText(this.directorioFirmados);
/* 136:    */       }
/* 137:106 */       this.tableArchivosPorEnviar.addMouseListener(new MouseAdapter()
/* 138:    */       {
/* 139:    */         public void mouseReleased(MouseEvent e)
/* 140:    */         {
/* 141:110 */           int col = EnvioComprobantesView.this.tableArchivosPorEnviar.getSelectedColumn();
/* 142:111 */           int row = EnvioComprobantesView.this.tableArchivosPorEnviar.getSelectedRow();
/* 143:112 */           if (col == 0)
/* 144:    */           {
/* 145:113 */             if (EnvioComprobantesView.this.tableArchivosPorEnviar.getModel().getRowCount() >= 2) {
/* 146:114 */               EnvioComprobantesView.this.btnEnviarLotes.setEnabled(true);
/* 147:    */             }
/* 148:117 */             List<File> archivosSeleccionados = EnvioComprobantesView.this.listaSeleccionados();
/* 149:118 */             String xmlLote = EnvioComprobantesView.this.creaXmlLote(archivosSeleccionados);
/* 150:119 */             if (xmlLote != null)
/* 151:    */             {
/* 152:120 */               Integer tamanioArchivo = Integer.valueOf(xmlLote.getBytes().length / 1024);
/* 153:121 */               EnvioComprobantesView.this.lblTamanio.setText(tamanioArchivo.toString());
/* 154:    */             }
/* 155:    */             else
/* 156:    */             {
/* 157:123 */               EnvioComprobantesView.this.tableArchivosPorEnviar.getModel().setValueAt(Boolean.FALSE, row, col);
/* 158:    */             }
/* 159:    */           }
/* 160:    */         }
/* 161:128 */       });
/* 162:129 */       this.jTableResultado.addMouseListener(new MouseAdapter()
/* 163:    */       {
/* 164:    */         public void mouseClicked(MouseEvent e)
/* 165:    */         {
/* 166:132 */           int col = EnvioComprobantesView.this.jTableResultado.getSelectedColumn();
/* 167:133 */           int row = EnvioComprobantesView.this.jTableResultado.getSelectedRow();
/* 168:134 */           if (EnvioComprobantesView.this.rowEvent != row) {
/* 169:135 */             EnvioComprobantesView.this.showOnlyOnce = 0;
/* 170:    */           }
/* 171:138 */           if ((e.getClickCount() == 1) && (col == 4) && (EnvioComprobantesView.this.showOnlyOnce == 0))
/* 172:    */           {
/* 173:139 */             String contenidoCelda = (String)EnvioComprobantesView.this.jTableResultado.getValueAt(row, col);
/* 174:140 */             JOptionPane.showMessageDialog(new JFrame(), contenidoCelda, "Contenido de la celda", 1);
/* 175:    */             
/* 176:142 */             EnvioComprobantesView.this.showOnlyOnce = 1;
/* 177:143 */             EnvioComprobantesView.this.rowEvent = row;
/* 178:    */           }
/* 179:    */         }
/* 180:    */       });
/* 181:    */     }
/* 182:    */     catch (Exception ex)
/* 183:    */     {
/* 184:149 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, "Error de Casting", ex);
/* 185:    */     }
/* 186:    */   }
/* 187:    */   
/* 188:    */   private void setColumnWidthResultados()
/* 189:    */   {
/* 190:155 */     for (int i = 0; i < this.jTableResultado.getColumnModel().getColumnCount(); i++)
/* 191:    */     {
/* 192:156 */       TableColumn column = this.jTableResultado.getColumnModel().getColumn(i);
/* 193:157 */       if (i == 0) {
/* 194:158 */         column.setPreferredWidth(47);
/* 195:    */       }
/* 196:160 */       if (i == 1) {
/* 197:161 */         column.setPreferredWidth(250);
/* 198:    */       }
/* 199:163 */       if (i == 2) {
/* 200:164 */         column.setPreferredWidth(120);
/* 201:    */       }
/* 202:166 */       if (i == 3) {
/* 203:167 */         column.setPreferredWidth(100);
/* 204:    */       }
/* 205:170 */       if (i == 4) {
/* 206:171 */         column.setPreferredWidth(250);
/* 207:    */       }
/* 208:    */     }
/* 209:    */   }
/* 210:    */   
/* 211:    */   private void setColumnWidthArchivos()
/* 212:    */   {
/* 213:178 */     for (int i = 0; i < this.tableArchivosPorEnviar.getColumnModel().getColumnCount(); i++)
/* 214:    */     {
/* 215:179 */       TableColumn column = this.tableArchivosPorEnviar.getColumnModel().getColumn(i);
/* 216:180 */       if (i == 0) {
/* 217:181 */         column.setPreferredWidth(90);
/* 218:    */       }
/* 219:183 */       if (i == 1) {
/* 220:184 */         column.setPreferredWidth(410);
/* 221:    */       }
/* 222:186 */       if (i == 2) {
/* 223:187 */         column.setPreferredWidth(90);
/* 224:    */       }
/* 225:189 */       if (i == 3) {
/* 226:190 */         column.setPreferredWidth(130);
/* 227:    */       }
/* 228:    */     }
/* 229:    */   }
/* 230:    */   
/* 231:    */   private List<File> listaSeleccionados()
/* 232:    */   {
/* 233:203 */     List<File> archivosSeleccionados = new ArrayList();
/* 234:205 */     for (int i = 0; i < this.modelListaArchivos.getFilenames().length; i++) {
/* 235:206 */       if ((null != this.modelListaArchivos.getSeleccionados()[i]) && (this.modelListaArchivos.getSeleccionados()[i].booleanValue() == true)) {
/* 236:207 */         archivosSeleccionados.add(new File(this.modelListaArchivos.getDirectorio(), this.modelListaArchivos.getFilenames()[i]));
/* 237:    */       }
/* 238:    */     }
/* 239:210 */     return archivosSeleccionados;
/* 240:    */   }
/* 241:    */   
/* 242:    */   private String creaXmlLote(List<File> archivosSeleccionados)
/* 243:    */   {
/* 244:220 */     StringBuilder mensajes = new StringBuilder();
/* 245:221 */     Writer writer = null;
/* 246:222 */     xmlLote = null;
/* 247:    */     try
/* 248:    */     {
/* 249:224 */       LoteXml lote = new LoteXml();
/* 250:225 */       lote.setClaveAcceso(this.claveAcceso);
/* 251:226 */       lote.setRuc(this.emisor.getRuc());
/* 252:227 */       lote.setVersion(this.VERSION);
/* 253:228 */       for (File archivo : archivosSeleccionados)
/* 254:    */       {
/* 255:229 */         String tipoComprobante = ArchivoUtils.obtenerValorXML(archivo, "/*/infoTributaria/codDoc");
/* 256:230 */         if ((tipoComprobante != null) && (tipoComprobante.length() > 0))
/* 257:    */         {
/* 258:231 */           ComprobanteXml item = new ComprobanteXml();
/* 259:    */           
/* 260:    */ 
/* 261:234 */           item.setFileXML(ArchivoUtils.archivoToString(archivo.getPath()));
/* 262:235 */           lote.getComprobantes().add(item);
/* 263:    */         }
/* 264:    */         else
/* 265:    */         {
/* 266:237 */           mensajes.append("\n El archivo: ");
/* 267:238 */           mensajes.append(archivo.getName());
/* 268:239 */           mensajes.append(" no posee información en <codDoc> por lo tanto fue excluido");
/* 269:    */         }
/* 270:    */       }
/* 271:    */       ByteArrayOutputStream outputStream;
/* 272:243 */       if (mensajes.toString().length() != 0)
/* 273:    */       {
/* 274:244 */         JOptionPane.showMessageDialog(new JFrame(), mensajes.toString(), "Error", 0);
/* 275:    */       }
/* 276:    */       else
/* 277:    */       {
/* 278:247 */         XStream xstream = XStreamUtil.getLoteXStream();
/* 279:248 */         xstream.useAttributeFor(LoteXml.class, "version");
/* 280:249 */         outputStream = new ByteArrayOutputStream();
/* 281:250 */         writer = new OutputStreamWriter(outputStream, "UTF-8");
/* 282:251 */         writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/* 283:252 */         xstream.toXML(lote, writer);
/* 284:    */       }
/* 285:253 */       return outputStream.toString("UTF-8");
/* 286:    */     }
/* 287:    */     catch (Exception ex)
/* 288:    */     {
/* 289:256 */       Logger.getLogger(EnvioComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 290:    */     }
/* 291:    */     finally
/* 292:    */     {
/* 293:    */       try
/* 294:    */       {
/* 295:259 */         if (writer != null) {
/* 296:260 */           writer.close();
/* 297:    */         }
/* 298:    */       }
/* 299:    */       catch (IOException ex)
/* 300:    */       {
/* 301:263 */         Logger.getLogger(EnvioComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 302:    */       }
/* 303:    */     }
/* 304:    */   }
/* 305:    */   
/* 306:    */   public void valueChanged(ListSelectionEvent e)
/* 307:    */   {
/* 308:270 */     if (e.getValueIsAdjusting())
/* 309:    */     {
/* 310:271 */       int index = e.getFirstIndex();
/* 311:272 */       this.modelListaArchivos.setValueAt(Boolean.TRUE, index, 0);
/* 312:    */     }
/* 313:    */   }
/* 314:    */   
/* 315:    */   public void actualizaClaveAcceso(String tipoComprobante)
/* 316:    */   {
/* 317:    */     try
/* 318:    */     {
/* 319:284 */       ComprobantesSQL item = new ComprobantesSQL();
/* 320:285 */       item.actualizaSecuencial(tipoComprobante, Long.valueOf(this.secuencial.longValue() + 1L));
/* 321:    */     }
/* 322:    */     catch (SQLException ex)
/* 323:    */     {
/* 324:288 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/* 325:    */     }
/* 326:    */     catch (ClassNotFoundException ex)
/* 327:    */     {
/* 328:290 */       Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
/* 329:    */     }
/* 330:    */   }
/* 331:    */   
/* 332:    */   private void initComponents()
/* 333:    */   {
/* 334:304 */     this.buttonGroup1 = new ButtonGroup();
/* 335:305 */     this.jPanel1 = new JPanel();
/* 336:306 */     this.jRadioButtonDefecto = new JRadioButton();
/* 337:307 */     this.jRadioButtonOtro = new JRadioButton();
/* 338:308 */     this.jTextFieldDirectorio = new JTextField();
/* 339:309 */     this.jButtonExaminar = new JButton();
/* 340:310 */     this.jButtonMostrarArchivos = new JButton();
/* 341:311 */     this.jLabel1 = new JLabel();
/* 342:312 */     this.jScrollPane1 = new JScrollPane();
/* 343:313 */     this.tableArchivosPorEnviar = new JTable();
/* 344:314 */     this.btnEnviarLotes = new JButton();
/* 345:315 */     this.jLabel2 = new JLabel();
/* 346:316 */     this.lblTamanio = new JTextField();
/* 347:317 */     this.jLabel3 = new JLabel();
/* 348:318 */     this.lblDirSistema = new JLabel();
/* 349:319 */     this.btnEnvioIndividual = new JButton();
/* 350:320 */     this.jScrollPane2 = new JScrollPane();
/* 351:321 */     this.jTableResultado = new JTable();
/* 352:    */     
/* 353:323 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(EnvioComprobantesView.class);
/* 354:324 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 355:325 */     this.jPanel1.setName("jPanel1");
/* 356:326 */     this.jPanel1.setPreferredSize(new Dimension(0, 0));
/* 357:    */     
/* 358:328 */     this.buttonGroup1.add(this.jRadioButtonDefecto);
/* 359:329 */     this.jRadioButtonDefecto.setSelected(true);
/* 360:330 */     this.jRadioButtonDefecto.setText(resourceMap.getString("jRadioButtonDefecto.text", new Object[0]));
/* 361:331 */     this.jRadioButtonDefecto.setName("jRadioButtonDefecto");
/* 362:332 */     this.jRadioButtonDefecto.addActionListener(new ActionListener()
/* 363:    */     {
/* 364:    */       public void actionPerformed(ActionEvent evt)
/* 365:    */       {
/* 366:334 */         EnvioComprobantesView.this.jRadioButtonDefectoActionPerformed(evt);
/* 367:    */       }
/* 368:337 */     });
/* 369:338 */     this.buttonGroup1.add(this.jRadioButtonOtro);
/* 370:339 */     this.jRadioButtonOtro.setText(resourceMap.getString("jRadioButtonOtro.text", new Object[0]));
/* 371:340 */     this.jRadioButtonOtro.setName("jRadioButtonOtro");
/* 372:341 */     this.jRadioButtonOtro.addActionListener(new ActionListener()
/* 373:    */     {
/* 374:    */       public void actionPerformed(ActionEvent evt)
/* 375:    */       {
/* 376:343 */         EnvioComprobantesView.this.jRadioButtonOtroActionPerformed(evt);
/* 377:    */       }
/* 378:346 */     });
/* 379:347 */     this.jTextFieldDirectorio.setText(resourceMap.getString("jTextFieldDirectorio.text", new Object[0]));
/* 380:348 */     this.jTextFieldDirectorio.setEnabled(false);
/* 381:349 */     this.jTextFieldDirectorio.setName("jTextFieldDirectorio");
/* 382:    */     
/* 383:351 */     this.jButtonExaminar.setText(resourceMap.getString("jButtonExaminar.text", new Object[0]));
/* 384:352 */     this.jButtonExaminar.setName("jButtonExaminar");
/* 385:353 */     this.jButtonExaminar.addActionListener(new ActionListener()
/* 386:    */     {
/* 387:    */       public void actionPerformed(ActionEvent evt)
/* 388:    */       {
/* 389:355 */         EnvioComprobantesView.this.jButtonExaminarActionPerformed(evt);
/* 390:    */       }
/* 391:358 */     });
/* 392:359 */     this.jButtonMostrarArchivos.setText(resourceMap.getString("jButtonMostrarArchivos.text", new Object[0]));
/* 393:360 */     this.jButtonMostrarArchivos.setName("jButtonMostrarArchivos");
/* 394:361 */     this.jButtonMostrarArchivos.addActionListener(new ActionListener()
/* 395:    */     {
/* 396:    */       public void actionPerformed(ActionEvent evt)
/* 397:    */       {
/* 398:363 */         EnvioComprobantesView.this.jButtonMostrarArchivosActionPerformed(evt);
/* 399:    */       }
/* 400:366 */     });
/* 401:367 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 402:368 */     this.jLabel1.setName("jLabel1");
/* 403:    */     
/* 404:370 */     this.jScrollPane1.setName("jScrollPane1");
/* 405:    */     
/* 406:372 */     this.tableArchivosPorEnviar.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 407:    */     
/* 408:    */ 
/* 409:    */ 
/* 410:    */ 
/* 411:    */ 
/* 412:    */ 
/* 413:    */ 
/* 414:380 */     this.tableArchivosPorEnviar.setName("tableArchivosPorEnviar");
/* 415:381 */     this.jScrollPane1.setViewportView(this.tableArchivosPorEnviar);
/* 416:    */     
/* 417:383 */     this.btnEnviarLotes.setText(resourceMap.getString("btnEnviarLotes.text", new Object[0]));
/* 418:384 */     this.btnEnviarLotes.setEnabled(false);
/* 419:385 */     this.btnEnviarLotes.setName("btnEnviarLotes");
/* 420:386 */     this.btnEnviarLotes.addActionListener(new ActionListener()
/* 421:    */     {
/* 422:    */       public void actionPerformed(ActionEvent evt)
/* 423:    */       {
/* 424:388 */         EnvioComprobantesView.this.btnEnviarLotesActionPerformed(evt);
/* 425:    */       }
/* 426:391 */     });
/* 427:392 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 428:393 */     this.jLabel2.setName("jLabel2");
/* 429:    */     
/* 430:395 */     this.lblTamanio.setEditable(false);
/* 431:396 */     this.lblTamanio.setText(resourceMap.getString("lblTamanio.text", new Object[0]));
/* 432:397 */     this.lblTamanio.setName("lblTamanio");
/* 433:    */     
/* 434:399 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 435:400 */     this.jLabel3.setName("jLabel3");
/* 436:    */     
/* 437:402 */     this.lblDirSistema.setText(resourceMap.getString("lblDirSistema.text", new Object[0]));
/* 438:403 */     this.lblDirSistema.setName("lblDirSistema");
/* 439:    */     
/* 440:405 */     this.btnEnvioIndividual.setText(resourceMap.getString("btnEnvioIndividual.text", new Object[0]));
/* 441:406 */     this.btnEnvioIndividual.setName("btnEnvioIndividual");
/* 442:407 */     this.btnEnvioIndividual.addActionListener(new ActionListener()
/* 443:    */     {
/* 444:    */       public void actionPerformed(ActionEvent evt)
/* 445:    */       {
/* 446:409 */         EnvioComprobantesView.this.btnEnvioIndividualActionPerformed(evt);
/* 447:    */       }
/* 448:412 */     });
/* 449:413 */     this.jScrollPane2.setName("jScrollPane2");
/* 450:    */     
/* 451:415 */     this.jTableResultado.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 452:    */     
/* 453:    */ 
/* 454:    */ 
/* 455:    */ 
/* 456:    */ 
/* 457:    */ 
/* 458:    */ 
/* 459:423 */     this.jTableResultado.setName("jTableResultado");
/* 460:424 */     this.jScrollPane2.setViewportView(this.jTableResultado);
/* 461:    */     
/* 462:426 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 463:427 */     this.jPanel1.setLayout(jPanel1Layout);
/* 464:428 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane2, -1, 823, 32767).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 823, 32767).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnEnviarLotes).addGap(2, 2, 2).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblTamanio, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 141, 32767).addComponent(this.btnEnvioIndividual).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jRadioButtonDefecto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jRadioButtonOtro, GroupLayout.Alignment.LEADING, -1, 226, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextFieldDirectorio, -1, 408, 32767).addComponent(this.lblDirSistema, -1, 408, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonExaminar).addGap(101, 101, 101)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButtonMostrarArchivos).addContainerGap(708, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addContainerGap(498, 32767)))));
/* 465:    */     
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
/* 504:468 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButtonDefecto, -2, 36, -2).addComponent(this.lblDirSistema)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButtonOtro, -2, 27, -2).addComponent(this.jTextFieldDirectorio, -2, -1, -2).addComponent(this.jButtonExaminar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButtonMostrarArchivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnEnviarLotes).addComponent(this.jLabel2).addComponent(this.lblTamanio, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.btnEnvioIndividual)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane2, -2, 309, -2).addGap(46, 46, 46)));
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
/* 530:    */ 
/* 531:    */ 
/* 532:    */ 
/* 533:497 */     GroupLayout layout = new GroupLayout(this);
/* 534:498 */     setLayout(layout);
/* 535:499 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 859, 32767).addContainerGap()));
/* 536:    */     
/* 537:    */ 
/* 538:    */ 
/* 539:    */ 
/* 540:    */ 
/* 541:    */ 
/* 542:506 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 796, 32767).addContainerGap()));
/* 543:    */   }
/* 544:    */   
/* 545:    */   private void jButtonMostrarArchivosActionPerformed(ActionEvent evt)
/* 546:    */   {
/* 547:516 */     mostrarArchivos();
/* 548:517 */     this.modelResultado = new ResultadosTableModel();
/* 549:518 */     this.jTableResultado.setModel(this.modelResultado);
/* 550:519 */     setColumnWidthResultados();
/* 551:    */   }
/* 552:    */   
/* 553:    */   private void mostrarArchivos()
/* 554:    */   {
/* 555:    */     File directorio;
/* 556:    */     File directorio;
/* 557:526 */     if (this.jTextFieldDirectorio.getText().isEmpty()) {
/* 558:527 */       directorio = new File(this.directorioFirmados);
/* 559:    */     } else {
/* 560:529 */       directorio = new File(this.jTextFieldDirectorio.getText());
/* 561:    */     }
/* 562:533 */     this.modelListaArchivos = new FileTableModel(directorio);
/* 563:    */     
/* 564:    */ 
/* 565:536 */     this.tableArchivosPorEnviar.setModel(this.modelListaArchivos);
/* 566:537 */     TableRowSorter<FileTableModel> sorter = new TableRowSorter(this.modelListaArchivos);
/* 567:538 */     this.tableArchivosPorEnviar.setRowSorter(sorter);
/* 568:539 */     sorter.setComparator(3, new DateStringComparator());
/* 569:540 */     this.tableArchivosPorEnviar.setAutoResizeMode(0);
/* 570:541 */     this.jTableResultado.setAutoResizeMode(0);
/* 571:542 */     setColumnWidthArchivos();
/* 572:    */     
/* 573:544 */     this.tableArchivosPorEnviar.getSelectionModel().setSelectionMode(0);
/* 574:    */     
/* 575:546 */     this.tableArchivosPorEnviar.getSelectionModel().addListSelectionListener(this.tableArchivosPorEnviar);
/* 576:547 */     this.tableArchivosPorEnviar.getModel().addTableModelListener(this.tableArchivosPorEnviar);
/* 577:548 */     inicializarDatos();
/* 578:    */   }
/* 579:    */   
/* 580:    */   private void jButtonExaminarActionPerformed(ActionEvent evt)
/* 581:    */   {
/* 582:553 */     this.jRadioButtonOtro.setSelected(true);
/* 583:554 */     JFileChooser chooser = new JFileChooser();
/* 584:555 */     chooser.setCurrentDirectory(new File(this.directorioFirmados));
/* 585:556 */     chooser.setDialogTitle("Seleccionar");
/* 586:557 */     chooser.setFileSelectionMode(1);
/* 587:    */     
/* 588:    */ 
/* 589:560 */     chooser.setAcceptAllFileFilterUsed(false);
/* 590:562 */     if (chooser.showOpenDialog(this) == 0) {
/* 591:563 */       this.jTextFieldDirectorio.setText(chooser.getSelectedFile().getPath());
/* 592:    */     }
/* 593:    */   }
/* 594:    */   
/* 595:    */   private void jRadioButtonOtroActionPerformed(ActionEvent evt)
/* 596:    */   {
/* 597:568 */     if (this.jRadioButtonOtro.isSelected())
/* 598:    */     {
/* 599:569 */       this.jTextFieldDirectorio.setEnabled(true);
/* 600:570 */       this.jTextFieldDirectorio.setEditable(true);
/* 601:    */     }
/* 602:    */   }
/* 603:    */   
/* 604:    */   private void btnEnviarLotesActionPerformed(ActionEvent evt)
/* 605:    */   {
/* 606:    */     try
/* 607:    */     {
/* 608:577 */       setCursor(Cursor.getPredefinedCursor(3));
/* 609:578 */       this.btnEnviarLotes.setEnabled(false);
/* 610:    */       
/* 611:580 */       this.modelResultado = new ResultadosTableModel();
/* 612:581 */       this.jTableResultado.setModel(this.modelResultado);
/* 613:582 */       this.jTableResultado.setAutoResizeMode(0);
/* 614:583 */       setColumnWidthResultados();
/* 615:    */       
/* 616:585 */       List<File> archivosSeleccionados = new ArrayList();
/* 617:586 */       List<Autorizacion> respuestasAutorizacion = null;
/* 618:587 */       String comprobantesProcesados = null;
/* 619:588 */       String xmlLote = null;
/* 620:589 */       File archivoLote = null;
/* 621:    */       
/* 622:    */ 
/* 623:592 */       String respuestaValidacion = null;
/* 624:    */       
/* 625:594 */       StringBuilder mensaje = new StringBuilder();
/* 626:595 */       EnvioComprobantesWs cliente = null;
/* 627:597 */       if (this.emisor.getTipoEmision().equals("1")) {
/* 628:    */         try
/* 629:    */         {
/* 630:600 */           cliente = new EnvioComprobantesWs(FormGenerales.devuelveUrlWs(this.emisor.getTipoAmbiente(), "RecepcionComprobantes"));
/* 631:601 */           archivosSeleccionados = listaSeleccionados();
/* 632:603 */           if (!archivosSeleccionados.isEmpty())
/* 633:    */           {
/* 634:605 */             xmlLote = creaXmlLote(archivosSeleccionados);
/* 635:606 */             String rutaArchivo = this.directorioFirmados + File.separator + "lote-" + dateFormat.format(new Date()) + ".xml";
/* 636:607 */             archivoLote = ArchivoUtils.stringToArchivo(rutaArchivo, xmlLote);
/* 637:610 */             if (archivoLote.length() / 1024L < this.MAX_FILE_SIZE)
/* 638:    */             {
/* 639:611 */               respuestaValidacion = ArchivoUtils.validaArchivoXSD(TipoComprobanteEnum.LOTE.getCode(), archivoLote.getPath());
/* 640:612 */               if (respuestaValidacion == null)
/* 641:    */               {
/* 642:613 */                 int i = 1;
/* 643:    */                 
/* 644:    */ 
/* 645:616 */                 RespuestaSolicitud respuesta = cliente.enviarComprobanteLotes(this.emisor.getRuc(), archivoLote, this.PARAM_TIPO_LOTE, this.VERSION);
/* 646:617 */                 String respuestaEstado = respuesta.getEstado();
/* 647:618 */                 actualizaClaveAcceso(TipoComprobanteEnum.LOTE.getCode());
/* 648:619 */                 if (respuestaEstado.equals("RECIBIDA"))
/* 649:    */                 {
/* 650:621 */                   respuestasAutorizacion = AutorizacionComprobantesWs.autorizarComprobanteLote(this.claveAcceso, rutaArchivo, this.emisor.getTiempoEspera().intValue(), archivosSeleccionados.size(), this.emisor.getTipoAmbiente());
/* 651:625 */                   if (respuestasAutorizacion.isEmpty())
/* 652:    */                   {
/* 653:627 */                     String dirFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 654:628 */                     String dirTransmitidos = dirFirmados + File.separator + "transmitidosSinRespuesta";
/* 655:629 */                     File transmitidos = new File(dirTransmitidos);
/* 656:630 */                     if (!transmitidos.exists()) {
/* 657:631 */                       new File(dirTransmitidos).mkdir();
/* 658:    */                     }
/* 659:634 */                     for (File file : archivosSeleccionados) {
/* 660:635 */                       if (!ArchivoUtils.copiarArchivo(file, transmitidos.getPath() + File.separator + file.getName())) {
/* 661:636 */                         mensaje.append("\nError al mover el archivo a la carpeta de Transmitidos sin Respuesta: " + file.getName());
/* 662:    */                       } else {
/* 663:638 */                         file.delete();
/* 664:    */                       }
/* 665:    */                     }
/* 666:641 */                     if (mensaje.toString().isEmpty() == true) {
/* 667:642 */                       mensaje.append("");
/* 668:    */                     }
/* 669:645 */                     JOptionPane.showMessageDialog(this, "TRANSMITIDO SIN RESPUESTA\nHa ocurrido un error en el proceso de la Autorización, por lo que se traslado el archivo a la carpeta de: transmitidosSinRespuesta" + mensaje.toString(), "Error en la autorizacion", 1);
/* 670:    */                   }
/* 671:    */                   else
/* 672:    */                   {
/* 673:649 */                     for (Autorizacion item : respuestasAutorizacion)
/* 674:    */                     {
/* 675:650 */                       String claveAccesoComprobante = item.getEstado().substring(0, 49);
/* 676:651 */                       String estado = item.getEstado().substring(54, item.getEstado().lastIndexOf("|"));
/* 677:652 */                       comprobantesProcesados = item.getEstado().substring(item.getEstado().lastIndexOf("|") + 1, item.getEstado().length());
/* 678:653 */                       this.modelResultado.addRow(Integer.valueOf(i), claveAccesoComprobante + ".xml", FormGenerales.obtieneTipoDeComprobante(claveAccesoComprobante), estado, AutorizacionComprobantesWs.obtieneMensajesAutorizacion(item));
/* 679:    */                       
/* 680:655 */                       i++;
/* 681:    */                     }
/* 682:657 */                     JOptionPane.showMessageDialog(this, "Se procesaron correctamente: " + comprobantesProcesados + " comprobantes", "", 1);
/* 683:    */                   }
/* 684:    */                 }
/* 685:    */                 else
/* 686:    */                 {
/* 687:661 */                   StringBuilder mensajes = new StringBuilder();
/* 688:662 */                   RespuestaSolicitud.Comprobantes comprobantes = respuesta.getComprobantes();
/* 689:663 */                   for (Comprobante comp : comprobantes.getComprobante())
/* 690:    */                   {
/* 691:664 */                     mensajes.append(comp.getClaveAcceso());
/* 692:665 */                     mensajes.append("\n");
/* 693:666 */                     for (Mensaje m : comp.getMensajes().getMensaje()) {
/* 694:667 */                       mensajes.append(m.getMensaje() + ": " + m.getInformacionAdicional() + "\n");
/* 695:    */                     }
/* 696:669 */                     mensajes.append("\n");
/* 697:    */                   }
/* 698:671 */                   JOptionPane.showMessageDialog(this, "Se ha producido un error al enviar el lote\n" + mensajes.toString(), "Error, Los comprobantes no fueron recibidos", 0);
/* 699:    */                 }
/* 700:    */               }
/* 701:    */               else
/* 702:    */               {
/* 703:675 */                 JOptionPane.showMessageDialog(this, "Error en esquema del lote:\n" + respuestaValidacion, "Se ha producido un error al enviar el lote", 0);
/* 704:    */               }
/* 705:    */             }
/* 706:    */             else
/* 707:    */             {
/* 708:679 */               JOptionPane.showMessageDialog(this, "El tamaño del lote exede el límite permitido (500 Kbytes)", "Error al enviar lote", 0);
/* 709:    */             }
/* 710:    */           }
/* 711:    */           else
/* 712:    */           {
/* 713:683 */             JOptionPane.showMessageDialog(this, "Seleccione al menos un archivo", "Seleccione archivos", 0);
/* 714:    */           }
/* 715:    */         }
/* 716:    */         catch (Exception ex)
/* 717:    */         {
/* 718:687 */           JOptionPane.showMessageDialog(this, "Error al momento de enviar el comprobante", "Error al enviar lote", 0);
/* 719:    */           
/* 720:689 */           Logger.getLogger(EnvioComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 721:    */         }
/* 722:    */       } else {
/* 723:692 */         JOptionPane.showMessageDialog(this, "Solo puede enviar comprobante en estado de Emsión: NORMAL", "Error Emisión Contingencia", 0);
/* 724:    */       }
/* 725:    */     }
/* 726:    */     finally
/* 727:    */     {
/* 728:696 */       setCursor(Cursor.getDefaultCursor());
/* 729:697 */       this.btnEnviarLotes.setEnabled(true);
/* 730:698 */       mostrarArchivos();
/* 731:    */     }
/* 732:    */   }
/* 733:    */   
/* 734:    */   private void btnEnvioIndividualActionPerformed(ActionEvent evt)
/* 735:    */   {
/* 736:    */     try
/* 737:    */     {
/* 738:704 */       setCursor(Cursor.getPredefinedCursor(3));
/* 739:705 */       this.btnEnvioIndividual.setEnabled(false);
/* 740:    */       
/* 741:707 */       this.modelResultado = new ResultadosTableModel();
/* 742:708 */       this.jTableResultado.setModel(this.modelResultado);
/* 743:709 */       this.jTableResultado.setAutoResizeMode(0);
/* 744:710 */       setColumnWidthResultados();
/* 745:    */       
/* 746:712 */       respuestaRecepcion = new RespuestaSolicitud();
/* 747:713 */       respuestaAutoriz = null;
/* 748:    */       
/* 749:    */ 
/* 750:716 */       List<File> archivosSeleccionados = new ArrayList();
/* 751:717 */       archivosSeleccionados = listaSeleccionados();
/* 752:719 */       if (!archivosSeleccionados.isEmpty())
/* 753:    */       {
/* 754:720 */         i = 1;
/* 755:721 */         for (File f : archivosSeleccionados) {
/* 756:    */           try
/* 757:    */           {
/* 758:723 */             String claveAccesoComprobante = ArchivoUtils.obtenerValorXML(f, "/*/infoTributaria/claveAcceso");
/* 759:724 */             String tipoComprobante = ArchivoUtils.obtenerValorXML(f, "/*/infoTributaria/codDoc").substring(1);
/* 760:726 */             if ((tipoComprobante != null) && (claveAccesoComprobante != null))
/* 761:    */             {
/* 762:728 */               respuestaRecepcion = EnvioComprobantesWs.obtenerRespuestaEnvio(f, this.emisor.getRuc(), tipoComprobante, claveAccesoComprobante, FormGenerales.devuelveUrlWs(this.emisor.getTipoAmbiente(), "RecepcionComprobantes"));
/* 763:729 */               if (respuestaRecepcion.getEstado().equals("RECIBIDA"))
/* 764:    */               {
/* 765:732 */                 Thread.currentThread();Thread.sleep(this.emisor.getTiempoEspera().intValue() * 1000);
/* 766:733 */                 respuestaAutoriz = AutorizacionComprobantesWs.autorizarComprobanteIndividual(claveAccesoComprobante, f.getName(), this.emisor.getTipoAmbiente());
/* 767:    */                 
/* 768:735 */                 String estado = null;
/* 769:736 */                 String resultado = null;
/* 770:737 */                 if (respuestaAutoriz.lastIndexOf("|") != -1)
/* 771:    */                 {
/* 772:738 */                   estado = respuestaAutoriz.substring(0, respuestaAutoriz.lastIndexOf("|"));
/* 773:739 */                   resultado = respuestaAutoriz.substring(respuestaAutoriz.lastIndexOf("|") + 1, respuestaAutoriz.length());
/* 774:    */                 }
/* 775:    */                 else
/* 776:    */                 {
/* 777:741 */                   estado = respuestaAutoriz;
/* 778:742 */                   resultado = "Procesado";
/* 779:    */                 }
/* 780:745 */                 if (respuestaAutoriz.equals("AUTORIZADO")) {
/* 781:746 */                   JOptionPane.showMessageDialog(this, "El comprobante fue autorizado por el SRI", "Respuesta", 1);
/* 782:    */                 } else {
/* 783:748 */                   JOptionPane.showMessageDialog(this, "El comprobante fue guardado, firmado y enviado exitósamente, pero no fue Autorizado\n" + estado + "\n" + resultado, "Respuesta", 1);
/* 784:    */                 }
/* 785:751 */                 this.modelResultado.addRow(Integer.valueOf(i), f.getName(), FormGenerales.obtieneTipoDeComprobante(claveAccesoComprobante), estado, FormGenerales.insertarCaracteres(resultado, "\n", 160));
/* 786:    */                 
/* 787:753 */                 f.delete();
/* 788:    */               }
/* 789:754 */               else if (respuestaRecepcion.getEstado().equals("DEVUELTA"))
/* 790:    */               {
/* 791:756 */                 String resultado = FormGenerales.insertarCaracteres(EnvioComprobantesWs.obtenerMensajeRespuesta(respuestaRecepcion), "\n", 160);
/* 792:    */                 
/* 793:    */ 
/* 794:759 */                 this.modelResultado.addRow(Integer.valueOf(i), f.getName(), FormGenerales.obtieneTipoDeComprobante(claveAccesoComprobante), respuestaRecepcion.getEstado(), FormGenerales.insertarCaracteres(resultado, "\n", 160));
/* 795:    */                 
/* 796:    */ 
/* 797:    */ 
/* 798:763 */                 String dirFirmados = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.FIRMADOS.getCode()).getPath();
/* 799:764 */                 String dirRechazados = dirFirmados + File.separator + "rechazados";
/* 800:    */                 
/* 801:766 */                 ArchivoUtils.anadirMotivosRechazo(f, respuestaRecepcion);
/* 802:    */                 
/* 803:768 */                 File rechazados = new File(dirRechazados);
/* 804:769 */                 if (!rechazados.exists()) {
/* 805:770 */                   new File(dirRechazados).mkdir();
/* 806:    */                 }
/* 807:773 */                 if (!ArchivoUtils.copiarArchivo(f, rechazados.getPath() + File.separator + f.getName())) {
/* 808:774 */                   JOptionPane.showMessageDialog(new JFrame(), "Error al mover el archivo a la carpeta rechazados", "Respuesta", 1);
/* 809:    */                 } else {
/* 810:776 */                   f.delete();
/* 811:    */                 }
/* 812:778 */                 JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + resultado, "Se ha producido un error ", 0);
/* 813:    */               }
/* 814:780 */               i++;
/* 815:    */             }
/* 816:    */             else
/* 817:    */             {
/* 818:782 */               String m = "\n En: " + f.getName() + " la información <codDoc> y <claveAcceso> son obligatorias para el envio del archivo";
/* 819:783 */               JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + m, "Se ha producido un error ", 0);
/* 820:    */             }
/* 821:    */           }
/* 822:    */           catch (Exception ex)
/* 823:    */           {
/* 824:786 */             Logger.getLogger(EnvioComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 825:787 */             JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + ex.getMessage(), "Se ha producido un error ", 0);
/* 826:    */           }
/* 827:    */         }
/* 828:    */       }
/* 829:    */     }
/* 830:    */     finally
/* 831:    */     {
/* 832:    */       RespuestaSolicitud respuestaRecepcion;
/* 833:    */       String respuestaAutoriz;
/* 834:    */       int i;
/* 835:792 */       setCursor(Cursor.getDefaultCursor());
/* 836:793 */       this.btnEnvioIndividual.setEnabled(true);
/* 837:794 */       mostrarArchivos();
/* 838:    */     }
/* 839:    */   }
/* 840:    */   
/* 841:    */   private void jRadioButtonDefectoActionPerformed(ActionEvent evt)
/* 842:    */   {
/* 843:799 */     this.jTextFieldDirectorio.setText(null);
/* 844:    */   }
/* 845:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.EnvioComprobantesView
 * JD-Core Version:    0.7.0.1
 */