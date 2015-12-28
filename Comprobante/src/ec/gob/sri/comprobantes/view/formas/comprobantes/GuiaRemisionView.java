/*    1:     */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*    2:     */ 
/*    3:     */ import comprobantesdesktop.ComprobantesDesktopApp;
/*    4:     */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*    5:     */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*    6:     */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*    7:     */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*    8:     */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*    9:     */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*   10:     */ import ec.gob.sri.comprobantes.modelo.DestinatarioProducto;
/*   11:     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   12:     */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*   13:     */ import ec.gob.sri.comprobantes.modelo.guia.Destinatario;
/*   14:     */ import ec.gob.sri.comprobantes.modelo.guia.Destinatario.Detalles;
/*   15:     */ import ec.gob.sri.comprobantes.modelo.guia.Detalle;
/*   16:     */ import ec.gob.sri.comprobantes.modelo.guia.Detalle.DetallesAdicionales;
/*   17:     */ import ec.gob.sri.comprobantes.modelo.guia.Detalle.DetallesAdicionales.DetAdicional;
/*   18:     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*   19:     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.Destinatarios;
/*   20:     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoAdicional;
/*   21:     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoAdicional.CampoAdicional;
/*   22:     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision.InfoGuiaRemision;
/*   23:     */ import ec.gob.sri.comprobantes.modelo.guia.ObjectFactory;
/*   24:     */ import ec.gob.sri.comprobantes.modelo.reportes.GuiaRemisionReporte;
/*   25:     */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   26:     */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*   27:     */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   28:     */ import ec.gob.sri.comprobantes.sql.TransportistaSQL;
/*   29:     */ import ec.gob.sri.comprobantes.table.model.DatosAdicionalesTableModel;
/*   30:     */ import ec.gob.sri.comprobantes.table.model.DestinatarioTableModel;
/*   31:     */ import ec.gob.sri.comprobantes.table.model.EliminarCellEditor;
/*   32:     */ import ec.gob.sri.comprobantes.table.model.EliminarDatoCellEditor;
/*   33:     */ import ec.gob.sri.comprobantes.table.model.EliminarRenderer;
/*   34:     */ import ec.gob.sri.comprobantes.table.model.ProductoTableModel;
/*   35:     */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*   36:     */ import ec.gob.sri.comprobantes.util.Constantes;
/*   37:     */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*   38:     */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*   39:     */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   40:     */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   41:     */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*   42:     */ import ec.gob.sri.comprobantes.util.TipoCompradorEnum;
/*   43:     */ import ec.gob.sri.comprobantes.util.TipoComprobanteEnum;
/*   44:     */ import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
/*   45:     */ import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
/*   46:     */ import ec.gob.sri.comprobantes.view.modals.DialogoCliente;
/*   47:     */ import ec.gob.sri.comprobantes.view.modals.DialogoProductos;
/*   48:     */ import ec.gob.sri.comprobantes.view.modals.DialogoTransportista;
/*   49:     */ import java.awt.Component;
/*   50:     */ import java.awt.Cursor;
/*   51:     */ import java.awt.Dimension;
/*   52:     */ import java.awt.event.ActionEvent;
/*   53:     */ import java.awt.event.ActionListener;
/*   54:     */ import java.awt.event.FocusAdapter;
/*   55:     */ import java.awt.event.FocusEvent;
/*   56:     */ import java.awt.event.KeyAdapter;
/*   57:     */ import java.awt.event.KeyEvent;
/*   58:     */ import java.awt.event.MouseAdapter;
/*   59:     */ import java.awt.event.MouseEvent;
/*   60:     */ import java.beans.PropertyChangeEvent;
/*   61:     */ import java.beans.PropertyChangeListener;
/*   62:     */ import java.io.File;
/*   63:     */ import java.math.BigDecimal;
/*   64:     */ import java.sql.SQLException;
/*   65:     */ import java.text.ParseException;
/*   66:     */ import java.text.SimpleDateFormat;
/*   67:     */ import java.util.Date;
/*   68:     */ import java.util.List;
/*   69:     */ import java.util.logging.Level;
/*   70:     */ import java.util.logging.Logger;
/*   71:     */ import javax.accessibility.AccessibleContext;
/*   72:     */ import javax.swing.BorderFactory;
/*   73:     */ import javax.swing.ButtonGroup;
/*   74:     */ import javax.swing.DefaultComboBoxModel;
/*   75:     */ import javax.swing.GroupLayout;
/*   76:     */ import javax.swing.GroupLayout.Alignment;
/*   77:     */ import javax.swing.GroupLayout.ParallelGroup;
/*   78:     */ import javax.swing.GroupLayout.SequentialGroup;
/*   79:     */ import javax.swing.ImageIcon;
/*   80:     */ import javax.swing.JButton;
/*   81:     */ import javax.swing.JComboBox;
/*   82:     */ import javax.swing.JFrame;
/*   83:     */ import javax.swing.JLabel;
/*   84:     */ import javax.swing.JOptionPane;
/*   85:     */ import javax.swing.JPanel;
/*   86:     */ import javax.swing.JScrollPane;
/*   87:     */ import javax.swing.JTable;
/*   88:     */ import javax.swing.JTextArea;
/*   89:     */ import javax.swing.JTextField;
/*   90:     */ import javax.swing.JToggleButton;
/*   91:     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*   92:     */ import javax.swing.SwingUtilities;
/*   93:     */ import javax.swing.table.DefaultTableCellRenderer;
/*   94:     */ import javax.swing.table.TableColumn;
/*   95:     */ import javax.swing.table.TableColumnModel;
/*   96:     */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*   97:     */ import org.jdesktop.application.Application;
/*   98:     */ import org.jdesktop.application.ApplicationContext;
/*   99:     */ import org.jdesktop.application.ResourceMap;
/*  100:     */ 
/*  101:     */ public final class GuiaRemisionView
/*  102:     */   extends JPanel
/*  103:     */ {
/*  104:  81 */   private Long secuencial = null;
/*  105:  82 */   private String secuencialComprobante = null;
/*  106:  83 */   private InfoTributaria infoTributaria = null;
/*  107:  84 */   private GuiaRemision.InfoGuiaRemision infoGuiaRemision = null;
/*  108:  85 */   private Emisor emisor = null;
/*  109:  86 */   private String serie = null;
/*  110:  87 */   private String claveDeAcceso = null;
/*  111:     */   private Date fechaEmision;
/*  112:     */   private DialogoProductos modalProductos;
/*  113:     */   private Clientes destinatarioSeleccionado;
/*  114:     */   private Transportista transportistaSeleccionado;
/*  115:     */   private ClaveContingencia claveContingencia;
/*  116:     */   private DatosAdicionalesTableModel modeloDatosAdicionales;
/*  117:     */   private ProductoTableModel modeloProductos;
/*  118:     */   private DestinatarioTableModel modeloDetalle;
/*  119:     */   private DialogoCliente modalCliente;
/*  120:     */   private DialogoTransportista modalTransportista;
/*  121:  98 */   private ObjectFactory factory = null;
/*  122:  99 */   private String password = null;
/*  123: 100 */   private ListenerUtil listenerUtil = new ListenerUtil();
/*  124:     */   private JButton btnAnadir;
/*  125:     */   private JButton btnFirmarProcesar;
/*  126:     */   private JButton btnGuardar;
/*  127:     */   private JButton btnNuevoDato;
/*  128:     */   private JButton btnNuevoDestin;
/*  129:     */   private JButton btnNuevoDestinatario;
/*  130:     */   private JButton btnSeleccionProducto;
/*  131:     */   private Cabecera cabecera1;
/*  132:     */   private JComboBox comboTipoDocModificado;
/*  133:     */   private IdentificacionComprobanteNoFecha idenComprob;
/*  134:     */   private JButton jButton1;
/*  135:     */   private JButton jButton4;
/*  136:     */   private JCalendarButton jCalendarEmisionDoc;
/*  137:     */   private JCalendarButton jCalendarFechaFin;
/*  138:     */   private JCalendarButton jCalendarFechaInicio;
/*  139:     */   private ButtonGroup jGroupTipoComprador;
/*  140:     */   private JLabel jLabel1;
/*  141:     */   private JLabel jLabel10;
/*  142:     */   private JLabel jLabel14;
/*  143:     */   private JLabel jLabel16;
/*  144:     */   private JLabel jLabel17;
/*  145:     */   private JLabel jLabel18;
/*  146:     */   private JLabel jLabel19;
/*  147:     */   private JLabel jLabel2;
/*  148:     */   private JLabel jLabel20;
/*  149:     */   private JLabel jLabel21;
/*  150:     */   private JLabel jLabel22;
/*  151:     */   private JLabel jLabel23;
/*  152:     */   private JLabel jLabel24;
/*  153:     */   private JLabel jLabel26;
/*  154:     */   private JLabel jLabel27;
/*  155:     */   private JLabel jLabel29;
/*  156:     */   private JLabel jLabel30;
/*  157:     */   private JPanel jPanel2;
/*  158:     */   private JPanel jPanel3;
/*  159:     */   private JPanel jPanel4;
/*  160:     */   private JPanel jPanel5;
/*  161:     */   private JPanel jPanel6;
/*  162:     */   private JScrollPane jScrollPane1;
/*  163:     */   private JScrollPane jScrollPane2;
/*  164:     */   private JScrollPane jScrollPane3;
/*  165:     */   private JScrollPane jScrollPane4;
/*  166:     */   private JScrollPane jScrollPane5;
/*  167:     */   private JScrollPane jScrollPane6;
/*  168:     */   private JScrollPane jScrollPane7;
/*  169:     */   private JTable jTableDatosAdicionales;
/*  170:     */   private JTable jTableDestinatarios;
/*  171:     */   private JTable jTableProductos;
/*  172:     */   private JToggleButton jToggleButton1;
/*  173:     */   private JToggleButton jToggleButton2;
/*  174:     */   private JTextField textFechaEmisionDoc;
/*  175:     */   private JTextField textFechaFin;
/*  176:     */   private JTextField textFechaIni;
/*  177:     */   private JTextField textNro1;
/*  178:     */   private JTextField textNro2;
/*  179:     */   private JTextField textNro3;
/*  180:     */   private JTextField txtCedulaDest;
/*  181:     */   private JTextField txtCedulaTrans;
/*  182:     */   private JTextField txtCodEstabDest;
/*  183:     */   private JTextArea txtDirecDest;
/*  184:     */   private JTextArea txtDirecPartida;
/*  185:     */   private JTextField txtDocAduanero;
/*  186:     */   private JTextArea txtMotivoTraslado;
/*  187:     */   private JTextField txtNumAutDoc;
/*  188:     */   private JTextField txtPlaca;
/*  189:     */   private JTextField txtRazonSocDest;
/*  190:     */   private JTextField txtRazonSocTrans;
/*  191:     */   private JTextArea txtRuta;
/*  192:     */   
/*  193:     */   public GuiaRemisionView()
/*  194:     */   {
/*  195: 103 */     initComponents();
/*  196:     */     
/*  197: 105 */     inicializarDatos();
/*  198: 106 */     actualizaClaveDeAcceso();
/*  199:     */   }
/*  200:     */   
/*  201:     */   public void inicializarDatos()
/*  202:     */   {
/*  203: 110 */     this.factory = new ObjectFactory();
/*  204: 111 */     setDateComprobante(new Date(), 2);
/*  205: 112 */     setDateComprobante(new Date(), 3);
/*  206:     */     
/*  207: 114 */     String[] opciones = { "FACTURA" };
/*  208: 115 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(opciones));
/*  209:     */     
/*  210: 117 */     this.modeloDatosAdicionales = new DatosAdicionalesTableModel();
/*  211: 118 */     this.jTableDatosAdicionales.setModel(this.modeloDatosAdicionales);
/*  212: 119 */     this.jTableDatosAdicionales.setAutoResizeMode(0);
/*  213: 120 */     TableColumn tc = this.jTableDatosAdicionales.getColumnModel().getColumn(2);
/*  214: 121 */     EliminarDatoCellEditor editord = new EliminarDatoCellEditor(this.jTableDatosAdicionales);
/*  215: 122 */     tc.setCellEditor(editord);
/*  216: 123 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  217: 124 */     setColumnWidthDatosAdicionales();
/*  218:     */     
/*  219: 126 */     this.modeloProductos = new ProductoTableModel();
/*  220: 127 */     this.jTableProductos.setModel(this.modeloProductos);
/*  221: 128 */     tc = this.jTableProductos.getColumnModel().getColumn(5);
/*  222: 129 */     EliminarCellEditor editor = new EliminarCellEditor(this.jTableProductos);
/*  223: 130 */     tc.setCellEditor(editor);
/*  224: 131 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  225: 132 */     this.jTableProductos.setAutoResizeMode(0);
/*  226: 133 */     setColumnWidthDetalle();
/*  227:     */     
/*  228: 135 */     DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
/*  229: 136 */     dtcr.setHorizontalAlignment(4);
/*  230: 137 */     tc = this.jTableProductos.getColumnModel().getColumn(1);
/*  231: 138 */     tc.setCellRenderer(dtcr);
/*  232:     */     
/*  233: 140 */     this.modeloDetalle = new DestinatarioTableModel();
/*  234: 141 */     this.jTableDestinatarios.setModel(this.modeloDetalle);
/*  235: 142 */     tc = this.jTableDestinatarios.getColumnModel().getColumn(6);
/*  236: 143 */     EliminarCellEditor editor2 = new EliminarCellEditor(this.jTableDestinatarios);
/*  237: 144 */     tc.setCellEditor(editor2);
/*  238: 145 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  239: 146 */     this.jTableDestinatarios.setAutoResizeMode(0);
/*  240: 147 */     setColumnWidthDestinatario();
/*  241:     */     
/*  242:     */ 
/*  243: 150 */     this.jTableProductos.addMouseListener(new MouseAdapter()
/*  244:     */     {
/*  245:     */       public void mouseReleased(MouseEvent e)
/*  246:     */       {
/*  247: 154 */         GuiaRemisionView.this.actualizaCeldaTabla();
/*  248:     */       }
/*  249: 157 */     });
/*  250: 158 */     this.jCalendarFechaInicio.addPropertyChangeListener(new PropertyChangeListener()
/*  251:     */     {
/*  252:     */       public void propertyChange(PropertyChangeEvent evt)
/*  253:     */       {
/*  254: 161 */         GuiaRemisionView.this.cambioEnBotonDeFecha(evt, 2);
/*  255:     */       }
/*  256: 164 */     });
/*  257: 165 */     this.jCalendarFechaFin.addPropertyChangeListener(new PropertyChangeListener()
/*  258:     */     {
/*  259:     */       public void propertyChange(PropertyChangeEvent evt)
/*  260:     */       {
/*  261: 168 */         GuiaRemisionView.this.cambioEnBotonDeFecha(evt, 3);
/*  262:     */       }
/*  263: 171 */     });
/*  264: 172 */     this.jCalendarEmisionDoc.addPropertyChangeListener(new PropertyChangeListener()
/*  265:     */     {
/*  266:     */       public void propertyChange(PropertyChangeEvent evt)
/*  267:     */       {
/*  268: 175 */         GuiaRemisionView.this.cambioEnBotonDeFecha(evt, 4);
/*  269:     */       }
/*  270:     */     });
/*  271:     */     try
/*  272:     */     {
/*  273: 181 */       llenaDatosEmisor();
/*  274: 183 */       if (this.emisor != null)
/*  275:     */       {
/*  276: 184 */         this.secuencial = new ComprobantesSQL().obtenerMaximo(TipoComprobanteEnum.GUIA_DE_REMISION.getCode());
/*  277: 185 */         this.secuencialComprobante = String.format("%09d", new Object[] { Long.valueOf(this.secuencial.longValue()) });
/*  278: 186 */         this.idenComprob.lblEstablecimiento.setText(this.emisor.getCodigoEstablecimiento());
/*  279: 187 */         this.idenComprob.lblPunto.setText(this.emisor.getCodPuntoEmision());
/*  280:     */         
/*  281: 189 */         llenaDatosEmisor();
/*  282: 190 */         setDate(new Date());
/*  283:     */       }
/*  284:     */     }
/*  285:     */     catch (Exception ex)
/*  286:     */     {
/*  287: 193 */       Logger.getLogger(GuiaRemisionView.class.getName()).log(Level.SEVERE, null, ex);
/*  288:     */     }
/*  289: 195 */     this.idenComprob.lblNumeroComprobante.setText(this.secuencialComprobante);
/*  290: 196 */     this.textNro3.setText(null);
/*  291:     */   }
/*  292:     */   
/*  293:     */   private void setColumnWidthDetalle()
/*  294:     */   {
/*  295: 203 */     for (int i = 0; i < this.jTableProductos.getColumnModel().getColumnCount(); i++)
/*  296:     */     {
/*  297: 204 */       TableColumn column = this.jTableProductos.getColumnModel().getColumn(i);
/*  298: 205 */       if (i == 0) {
/*  299: 206 */         column.setPreferredWidth(60);
/*  300:     */       }
/*  301: 208 */       if (i == 1) {
/*  302: 209 */         column.setPreferredWidth(102);
/*  303:     */       }
/*  304: 211 */       if (i == 2) {
/*  305: 212 */         column.setPreferredWidth(102);
/*  306:     */       }
/*  307: 214 */       if (i == 3) {
/*  308: 215 */         column.setPreferredWidth(122);
/*  309:     */       }
/*  310: 217 */       if (i == 4) {
/*  311: 218 */         column.setPreferredWidth(415);
/*  312:     */       }
/*  313: 220 */       if (i == 5) {
/*  314: 221 */         column.setPreferredWidth(100);
/*  315:     */       }
/*  316: 223 */       if (i == 6) {
/*  317: 224 */         column.setPreferredWidth(105);
/*  318:     */       }
/*  319:     */     }
/*  320:     */   }
/*  321:     */   
/*  322:     */   private void setColumnWidthDestinatario()
/*  323:     */   {
/*  324: 233 */     for (int i = 0; i < this.jTableDestinatarios.getColumnModel().getColumnCount(); i++)
/*  325:     */     {
/*  326: 234 */       TableColumn column = this.jTableDestinatarios.getColumnModel().getColumn(i);
/*  327: 235 */       if (i == 0) {
/*  328: 236 */         column.setPreferredWidth(80);
/*  329:     */       }
/*  330: 238 */       if (i == 1) {
/*  331: 239 */         column.setPreferredWidth(110);
/*  332:     */       }
/*  333: 241 */       if (i == 2) {
/*  334: 242 */         column.setPreferredWidth(300);
/*  335:     */       }
/*  336: 244 */       if (i == 3) {
/*  337: 245 */         column.setPreferredWidth(124);
/*  338:     */       }
/*  339: 247 */       if (i == 4) {
/*  340: 248 */         column.setPreferredWidth(100);
/*  341:     */       }
/*  342: 250 */       if (i == 5) {
/*  343: 251 */         column.setPreferredWidth(80);
/*  344:     */       }
/*  345: 253 */       if (i == 6) {
/*  346: 254 */         column.setPreferredWidth(105);
/*  347:     */       }
/*  348:     */     }
/*  349:     */   }
/*  350:     */   
/*  351:     */   private void setColumnWidthDatosAdicionales()
/*  352:     */   {
/*  353: 260 */     for (int i = 0; i < this.jTableDatosAdicionales.getColumnModel().getColumnCount(); i++)
/*  354:     */     {
/*  355: 261 */       TableColumn column = this.jTableDatosAdicionales.getColumnModel().getColumn(i);
/*  356: 262 */       if (i == 0) {
/*  357: 263 */         column.setPreferredWidth(100);
/*  358:     */       }
/*  359: 265 */       if (i == 1) {
/*  360: 266 */         column.setPreferredWidth(300);
/*  361:     */       }
/*  362: 268 */       if (i == 2) {
/*  363: 269 */         column.setPreferredWidth(105);
/*  364:     */       }
/*  365:     */     }
/*  366:     */   }
/*  367:     */   
/*  368:     */   private void actualizaCeldaTabla()
/*  369:     */   {
/*  370:     */     try
/*  371:     */     {
/*  372: 277 */       int row = this.jTableProductos.getSelectedRow();
/*  373: 278 */       int col = this.jTableProductos.getSelectedColumn();
/*  374: 279 */       if (col == 1) {
/*  375: 280 */         Double.parseDouble(this.modeloProductos.getValueAt(row, col).toString());
/*  376:     */       }
/*  377:     */     }
/*  378:     */     catch (Exception ex)
/*  379:     */     {
/*  380: 283 */       Logger.getLogger(GuiaRemisionView.class.getName()).log(Level.SEVERE, "Error de Casting", ex);
/*  381:     */     }
/*  382:     */   }
/*  383:     */   
/*  384:     */   public void llenaDatosEmisor()
/*  385:     */   {
/*  386: 292 */     this.emisor = FormGenerales.llenaDatosEmisor(this.cabecera1);
/*  387:     */   }
/*  388:     */   
/*  389:     */   private void cambioEnBotonDeFecha(PropertyChangeEvent evt, int id)
/*  390:     */   {
/*  391: 297 */     if ((evt.getNewValue() instanceof Date)) {
/*  392: 298 */       if (id == 2)
/*  393:     */       {
/*  394: 299 */         setDate((Date)evt.getNewValue());
/*  395: 300 */         actualizaClaveDeAcceso();
/*  396:     */       }
/*  397:     */       else
/*  398:     */       {
/*  399: 302 */         setDateComprobante((Date)evt.getNewValue(), id);
/*  400:     */       }
/*  401:     */     }
/*  402:     */   }
/*  403:     */   
/*  404:     */   private void initComponents()
/*  405:     */   {
/*  406: 316 */     this.jGroupTipoComprador = new ButtonGroup();
/*  407: 317 */     this.jPanel2 = new JPanel();
/*  408: 318 */     this.jLabel17 = new JLabel();
/*  409: 319 */     this.jLabel16 = new JLabel();
/*  410: 320 */     this.textFechaIni = new JTextField();
/*  411: 321 */     this.jCalendarFechaInicio = new JCalendarButton();
/*  412: 322 */     this.jLabel18 = new JLabel();
/*  413: 323 */     this.textFechaFin = new JTextField();
/*  414: 324 */     this.jCalendarFechaFin = new JCalendarButton();
/*  415: 325 */     this.jScrollPane3 = new JScrollPane();
/*  416: 326 */     this.txtDirecPartida = new JTextArea();
/*  417: 327 */     this.jLabel10 = new JLabel();
/*  418: 328 */     this.jLabel14 = new JLabel();
/*  419: 329 */     this.txtPlaca = new JTextField();
/*  420: 330 */     this.jLabel30 = new JLabel();
/*  421: 331 */     this.txtCedulaTrans = new JTextField();
/*  422: 332 */     this.jToggleButton1 = new JToggleButton();
/*  423: 333 */     this.txtRazonSocTrans = new JTextField();
/*  424: 334 */     this.jButton1 = new JButton();
/*  425: 335 */     this.jPanel3 = new JPanel();
/*  426: 336 */     this.jScrollPane7 = new JScrollPane();
/*  427: 337 */     this.jTableDestinatarios = new JTable();
/*  428: 338 */     this.btnNuevoDestinatario = new JButton();
/*  429: 339 */     this.btnNuevoDestin = new JButton();
/*  430: 340 */     this.jPanel4 = new JPanel();
/*  431: 341 */     this.jScrollPane2 = new JScrollPane();
/*  432: 342 */     this.jTableDatosAdicionales = new JTable();
/*  433: 343 */     this.btnNuevoDato = new JButton();
/*  434: 344 */     this.jPanel6 = new JPanel();
/*  435: 345 */     this.btnFirmarProcesar = new JButton();
/*  436: 346 */     this.jButton4 = new JButton();
/*  437: 347 */     this.btnGuardar = new JButton();
/*  438: 348 */     this.jPanel5 = new JPanel();
/*  439: 349 */     this.jLabel19 = new JLabel();
/*  440: 350 */     this.textNro1 = new JTextField();
/*  441: 351 */     this.textNro2 = new JTextField();
/*  442: 352 */     this.textNro3 = new JTextField();
/*  443: 353 */     this.jLabel20 = new JLabel();
/*  444: 354 */     this.jLabel21 = new JLabel();
/*  445: 355 */     this.jScrollPane5 = new JScrollPane();
/*  446: 356 */     this.txtMotivoTraslado = new JTextArea();
/*  447: 357 */     this.jLabel22 = new JLabel();
/*  448: 358 */     this.textFechaEmisionDoc = new JTextField();
/*  449: 359 */     this.jCalendarEmisionDoc = new JCalendarButton();
/*  450: 360 */     this.jLabel23 = new JLabel();
/*  451: 361 */     this.jLabel24 = new JLabel();
/*  452: 362 */     this.txtDocAduanero = new JTextField();
/*  453: 363 */     this.jLabel26 = new JLabel();
/*  454: 364 */     this.txtCodEstabDest = new JTextField();
/*  455: 365 */     this.jLabel27 = new JLabel();
/*  456: 366 */     this.jScrollPane6 = new JScrollPane();
/*  457: 367 */     this.txtRuta = new JTextArea();
/*  458: 368 */     this.comboTipoDocModificado = new JComboBox();
/*  459: 369 */     this.jLabel29 = new JLabel();
/*  460: 370 */     this.jScrollPane1 = new JScrollPane();
/*  461: 371 */     this.jTableProductos = new JTable();
/*  462: 372 */     this.btnSeleccionProducto = new JButton();
/*  463: 373 */     this.jToggleButton2 = new JToggleButton();
/*  464: 374 */     this.txtRazonSocDest = new JTextField();
/*  465: 375 */     this.jScrollPane4 = new JScrollPane();
/*  466: 376 */     this.txtDirecDest = new JTextArea();
/*  467: 377 */     this.txtNumAutDoc = new JTextField();
/*  468: 378 */     this.jLabel1 = new JLabel();
/*  469: 379 */     this.btnAnadir = new JButton();
/*  470: 380 */     this.txtCedulaDest = new JTextField();
/*  471: 381 */     this.jLabel2 = new JLabel();
/*  472: 382 */     this.cabecera1 = new Cabecera();
/*  473: 383 */     this.idenComprob = new IdentificacionComprobanteNoFecha();
/*  474:     */     
/*  475: 385 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(GuiaRemisionView.class);
/*  476: 386 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 2, 0, resourceMap.getFont("Form.border.titleFont")));
/*  477: 387 */     setMaximumSize(new Dimension(133, 25));
/*  478: 388 */     setMinimumSize(new Dimension(133, 25));
/*  479: 389 */     setName("Form");
/*  480:     */     
/*  481: 391 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/*  482: 392 */     this.jPanel2.setName("jPanel2");
/*  483:     */     
/*  484: 394 */     this.jLabel17.setFont(resourceMap.getFont("jLabel17.font"));
/*  485: 395 */     this.jLabel17.setText(resourceMap.getString("jLabel17.text", new Object[0]));
/*  486: 396 */     this.jLabel17.setName("jLabel17");
/*  487:     */     
/*  488: 398 */     this.jLabel16.setFont(resourceMap.getFont("jLabel17.font"));
/*  489: 399 */     this.jLabel16.setHorizontalAlignment(2);
/*  490: 400 */     this.jLabel16.setText(resourceMap.getString("jLabel16.text", new Object[0]));
/*  491: 401 */     this.jLabel16.setName("jLabel16");
/*  492:     */     
/*  493: 403 */     this.textFechaIni.setEditable(false);
/*  494: 404 */     this.textFechaIni.setFont(resourceMap.getFont("textFechaIni.font"));
/*  495: 405 */     this.textFechaIni.setText(resourceMap.getString("textFechaIni.text", new Object[0]));
/*  496: 406 */     this.textFechaIni.setName("textFechaIni");
/*  497:     */     
/*  498: 408 */     this.jCalendarFechaInicio.setText(resourceMap.getString("jCalendarFechaInicio.text", new Object[0]));
/*  499: 409 */     this.jCalendarFechaInicio.setName("jCalendarFechaInicio");
/*  500:     */     
/*  501: 411 */     this.jLabel18.setFont(resourceMap.getFont("jLabel17.font"));
/*  502: 412 */     this.jLabel18.setHorizontalAlignment(4);
/*  503: 413 */     this.jLabel18.setText(resourceMap.getString("jLabel18.text", new Object[0]));
/*  504: 414 */     this.jLabel18.setName("jLabel18");
/*  505:     */     
/*  506: 416 */     this.textFechaFin.setEditable(false);
/*  507: 417 */     this.textFechaFin.setFont(resourceMap.getFont("textFechaIni.font"));
/*  508: 418 */     this.textFechaFin.setName("textFechaFin");
/*  509:     */     
/*  510: 420 */     this.jCalendarFechaFin.setName("jCalendarFechaFin");
/*  511:     */     
/*  512: 422 */     this.jScrollPane3.setName("jScrollPane3");
/*  513:     */     
/*  514: 424 */     this.txtDirecPartida.setColumns(20);
/*  515: 425 */     this.txtDirecPartida.setFont(resourceMap.getFont("txtDirecPartida.font"));
/*  516: 426 */     this.txtDirecPartida.setRows(5);
/*  517: 427 */     this.txtDirecPartida.setText(resourceMap.getString("txtDirecPartida.text", new Object[0]));
/*  518: 428 */     this.txtDirecPartida.setName("txtDirecPartida");
/*  519: 429 */     this.txtDirecPartida.addKeyListener(new KeyAdapter()
/*  520:     */     {
/*  521:     */       public void keyPressed(KeyEvent evt)
/*  522:     */       {
/*  523: 431 */         GuiaRemisionView.this.txtDirecPartidaKeyPressed(evt);
/*  524:     */       }
/*  525:     */       
/*  526:     */       public void keyReleased(KeyEvent evt)
/*  527:     */       {
/*  528: 434 */         GuiaRemisionView.this.txtDirecPartidaKeyReleased(evt);
/*  529:     */       }
/*  530: 436 */     });
/*  531: 437 */     this.jScrollPane3.setViewportView(this.txtDirecPartida);
/*  532:     */     
/*  533: 439 */     this.jLabel10.setFont(resourceMap.getFont("jLabel17.font"));
/*  534: 440 */     this.jLabel10.setText(resourceMap.getString("jLabel10.text", new Object[0]));
/*  535: 441 */     this.jLabel10.setName("jLabel10");
/*  536:     */     
/*  537: 443 */     this.jLabel14.setFont(resourceMap.getFont("jLabel17.font"));
/*  538: 444 */     this.jLabel14.setText(resourceMap.getString("jLabel14.text", new Object[0]));
/*  539: 445 */     this.jLabel14.setName("jLabel14");
/*  540:     */     
/*  541: 447 */     this.txtPlaca.setEditable(false);
/*  542: 448 */     this.txtPlaca.setFont(resourceMap.getFont("txtCedulaTrans.font"));
/*  543: 449 */     this.txtPlaca.setText(resourceMap.getString("txtPlaca.text", new Object[0]));
/*  544: 450 */     this.txtPlaca.setName("txtPlaca");
/*  545:     */     
/*  546: 452 */     this.jLabel30.setFont(resourceMap.getFont("jLabel17.font"));
/*  547: 453 */     this.jLabel30.setText(resourceMap.getString("jLabel30.text", new Object[0]));
/*  548: 454 */     this.jLabel30.setName("jLabel30");
/*  549:     */     
/*  550: 456 */     this.txtCedulaTrans.setFont(resourceMap.getFont("txtCedulaTrans.font"));
/*  551: 457 */     this.txtCedulaTrans.setText(resourceMap.getString("txtCedulaTrans.text", new Object[0]));
/*  552: 458 */     this.txtCedulaTrans.setName("txtCedulaTrans");
/*  553: 459 */     this.txtCedulaTrans.addFocusListener(new FocusAdapter()
/*  554:     */     {
/*  555:     */       public void focusGained(FocusEvent evt)
/*  556:     */       {
/*  557: 461 */         GuiaRemisionView.this.txtCedulaTransFocusGained(evt);
/*  558:     */       }
/*  559: 464 */     });
/*  560: 465 */     this.jToggleButton1.setFont(resourceMap.getFont("jToggleButton1.font"));
/*  561: 466 */     this.jToggleButton1.setText(resourceMap.getString("jToggleButton1.text", new Object[0]));
/*  562: 467 */     this.jToggleButton1.setName("jToggleButton1");
/*  563: 468 */     this.jToggleButton1.addActionListener(new ActionListener()
/*  564:     */     {
/*  565:     */       public void actionPerformed(ActionEvent evt)
/*  566:     */       {
/*  567: 470 */         GuiaRemisionView.this.jToggleButton1ActionPerformed(evt);
/*  568:     */       }
/*  569: 473 */     });
/*  570: 474 */     this.txtRazonSocTrans.setFont(resourceMap.getFont("txtCedulaTrans.font"));
/*  571: 475 */     this.txtRazonSocTrans.setText(resourceMap.getString("txtRazonSocTrans.text", new Object[0]));
/*  572: 476 */     this.txtRazonSocTrans.setName("txtRazonSocTrans");
/*  573: 477 */     this.txtRazonSocTrans.addFocusListener(new FocusAdapter()
/*  574:     */     {
/*  575:     */       public void focusGained(FocusEvent evt)
/*  576:     */       {
/*  577: 479 */         GuiaRemisionView.this.txtRazonSocTransFocusGained(evt);
/*  578:     */       }
/*  579: 482 */     });
/*  580: 483 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/*  581: 484 */     this.jButton1.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  582: 485 */     this.jButton1.setName("jButton1");
/*  583: 486 */     this.jButton1.addActionListener(new ActionListener()
/*  584:     */     {
/*  585:     */       public void actionPerformed(ActionEvent evt)
/*  586:     */       {
/*  587: 488 */         GuiaRemisionView.this.jButton1ActionPerformed(evt);
/*  588:     */       }
/*  589: 491 */     });
/*  590: 492 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  591: 493 */     this.jPanel2.setLayout(jPanel2Layout);
/*  592: 494 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel30, -2, -1, -2).addComponent(this.jLabel17, -2, -1, -2).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -2, 377, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtCedulaTrans).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jToggleButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 25, -2)).addComponent(this.txtRazonSocTrans, GroupLayout.Alignment.LEADING, -2, 347, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel18).addComponent(this.jLabel16).addComponent(this.jLabel14)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtPlaca).addComponent(this.textFechaFin, -2, 89, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCalendarFechaFin, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.textFechaIni, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCalendarFechaInicio, -2, -1, -2))).addContainerGap(140, 32767)));
/*  593:     */     
/*  594:     */ 
/*  595:     */ 
/*  596:     */ 
/*  597:     */ 
/*  598:     */ 
/*  599:     */ 
/*  600:     */ 
/*  601:     */ 
/*  602:     */ 
/*  603:     */ 
/*  604:     */ 
/*  605:     */ 
/*  606:     */ 
/*  607:     */ 
/*  608:     */ 
/*  609:     */ 
/*  610:     */ 
/*  611:     */ 
/*  612:     */ 
/*  613:     */ 
/*  614:     */ 
/*  615:     */ 
/*  616:     */ 
/*  617:     */ 
/*  618:     */ 
/*  619:     */ 
/*  620:     */ 
/*  621:     */ 
/*  622:     */ 
/*  623:     */ 
/*  624:     */ 
/*  625:     */ 
/*  626:     */ 
/*  627:     */ 
/*  628:     */ 
/*  629:     */ 
/*  630:     */ 
/*  631: 533 */     jPanel2Layout.linkSize(0, new Component[] { this.textFechaFin, this.textFechaIni });
/*  632:     */     
/*  633: 535 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel17, -2, -1, -2).addComponent(this.txtCedulaTrans, -2, -1, -2).addComponent(this.jButton1, -2, 23, -2).addComponent(this.jToggleButton1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel30, -2, -1, -2).addComponent(this.txtRazonSocTrans, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 38, 32767).addComponent(this.jLabel10))).addGroup(jPanel2Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.textFechaIni, -2, -1, -2).addComponent(this.jCalendarFechaInicio, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.textFechaFin, -2, -1, -2).addComponent(this.jCalendarFechaFin, -2, -1, -2).addComponent(this.jLabel18))).addComponent(this.jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtPlaca, -2, -1, -2).addComponent(this.jLabel14)))).addContainerGap()));
/*  634:     */     
/*  635:     */ 
/*  636:     */ 
/*  637:     */ 
/*  638:     */ 
/*  639:     */ 
/*  640:     */ 
/*  641:     */ 
/*  642:     */ 
/*  643:     */ 
/*  644:     */ 
/*  645:     */ 
/*  646:     */ 
/*  647:     */ 
/*  648:     */ 
/*  649:     */ 
/*  650:     */ 
/*  651:     */ 
/*  652:     */ 
/*  653:     */ 
/*  654:     */ 
/*  655:     */ 
/*  656:     */ 
/*  657:     */ 
/*  658:     */ 
/*  659:     */ 
/*  660:     */ 
/*  661:     */ 
/*  662:     */ 
/*  663:     */ 
/*  664:     */ 
/*  665:     */ 
/*  666:     */ 
/*  667:     */ 
/*  668:     */ 
/*  669:     */ 
/*  670:     */ 
/*  671: 573 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/*  672: 574 */     this.jPanel3.setName("jPanel3");
/*  673:     */     
/*  674: 576 */     this.jScrollPane7.setName("jScrollPane7");
/*  675:     */     
/*  676: 578 */     this.jTableDestinatarios.setFont(resourceMap.getFont("btnNuevoDestinatario.font"));
/*  677: 579 */     this.jTableDestinatarios.setName("jTableDestinatarios");
/*  678: 580 */     this.jScrollPane7.setViewportView(this.jTableDestinatarios);
/*  679:     */     
/*  680: 582 */     this.btnNuevoDestinatario.setFont(resourceMap.getFont("btnNuevoDestinatario.font"));
/*  681: 583 */     this.btnNuevoDestinatario.setText(resourceMap.getString("btnNuevoDestinatario.text", new Object[0]));
/*  682: 584 */     this.btnNuevoDestinatario.setName("btnNuevoDestinatario");
/*  683: 585 */     this.btnNuevoDestinatario.addActionListener(new ActionListener()
/*  684:     */     {
/*  685:     */       public void actionPerformed(ActionEvent evt)
/*  686:     */       {
/*  687: 587 */         GuiaRemisionView.this.btnNuevoDestinatarioActionPerformed(evt);
/*  688:     */       }
/*  689: 590 */     });
/*  690: 591 */     this.btnNuevoDestin.setFont(resourceMap.getFont("btnNuevoDestinatario.font"));
/*  691: 592 */     this.btnNuevoDestin.setText(resourceMap.getString("btnNuevoDestin.text", new Object[0]));
/*  692: 593 */     this.btnNuevoDestin.setName("btnNuevoDestin");
/*  693: 594 */     this.btnNuevoDestin.addActionListener(new ActionListener()
/*  694:     */     {
/*  695:     */       public void actionPerformed(ActionEvent evt)
/*  696:     */       {
/*  697: 596 */         GuiaRemisionView.this.btnNuevoDestinActionPerformed(evt);
/*  698:     */       }
/*  699: 599 */     });
/*  700: 600 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  701: 601 */     this.jPanel3.setLayout(jPanel3Layout);
/*  702: 602 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.btnNuevoDestinatario).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNuevoDestin, -2, 155, -2).addContainerGap(727, 32767)).addComponent(this.jScrollPane7, -1, 1013, 32767));
/*  703:     */     
/*  704:     */ 
/*  705:     */ 
/*  706:     */ 
/*  707:     */ 
/*  708:     */ 
/*  709:     */ 
/*  710:     */ 
/*  711: 611 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnNuevoDestinatario).addComponent(this.btnNuevoDestin)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane7, -2, 97, -2).addContainerGap(-1, 32767)));
/*  712:     */     
/*  713:     */ 
/*  714:     */ 
/*  715:     */ 
/*  716:     */ 
/*  717:     */ 
/*  718:     */ 
/*  719:     */ 
/*  720:     */ 
/*  721:     */ 
/*  722:     */ 
/*  723: 623 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title", new Object[0])));
/*  724: 624 */     this.jPanel4.setName("jPanel4");
/*  725:     */     
/*  726: 626 */     this.jScrollPane2.setName("jScrollPane2");
/*  727:     */     
/*  728: 628 */     this.jTableDatosAdicionales.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  729: 629 */     this.jTableDatosAdicionales.setName("jTableDatosAdicionales");
/*  730: 630 */     this.jScrollPane2.setViewportView(this.jTableDatosAdicionales);
/*  731:     */     
/*  732: 632 */     this.btnNuevoDato.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  733: 633 */     this.btnNuevoDato.setText(resourceMap.getString("btnNuevoDato.text", new Object[0]));
/*  734: 634 */     this.btnNuevoDato.setName("btnNuevoDato");
/*  735: 635 */     this.btnNuevoDato.addActionListener(new ActionListener()
/*  736:     */     {
/*  737:     */       public void actionPerformed(ActionEvent evt)
/*  738:     */       {
/*  739: 637 */         GuiaRemisionView.this.btnNuevoDatoActionPerformed(evt);
/*  740:     */       }
/*  741: 640 */     });
/*  742: 641 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  743: 642 */     this.jPanel4.setLayout(jPanel4Layout);
/*  744: 643 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 513, 32767).addComponent(this.btnNuevoDato, -2, 113, -2)).addContainerGap()));
/*  745:     */     
/*  746:     */ 
/*  747:     */ 
/*  748:     */ 
/*  749:     */ 
/*  750:     */ 
/*  751:     */ 
/*  752:     */ 
/*  753: 652 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.btnNuevoDato).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 73, -2).addContainerGap(-1, 32767)));
/*  754:     */     
/*  755:     */ 
/*  756:     */ 
/*  757:     */ 
/*  758:     */ 
/*  759:     */ 
/*  760:     */ 
/*  761:     */ 
/*  762: 661 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel6.border.title", new Object[0])));
/*  763: 662 */     this.jPanel6.setName("jPanel6");
/*  764: 663 */     this.jPanel6.setPreferredSize(new Dimension(495, 180));
/*  765:     */     
/*  766: 665 */     this.btnFirmarProcesar.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  767: 666 */     this.btnFirmarProcesar.setText(resourceMap.getString("btnFirmarProcesar.text", new Object[0]));
/*  768: 667 */     this.btnFirmarProcesar.setEnabled(false);
/*  769: 668 */     this.btnFirmarProcesar.setName("btnFirmarProcesar");
/*  770: 669 */     this.btnFirmarProcesar.addActionListener(new ActionListener()
/*  771:     */     {
/*  772:     */       public void actionPerformed(ActionEvent evt)
/*  773:     */       {
/*  774: 671 */         GuiaRemisionView.this.btnFirmarProcesarActionPerformed(evt);
/*  775:     */       }
/*  776: 674 */     });
/*  777: 675 */     this.jButton4.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  778: 676 */     this.jButton4.setText(resourceMap.getString("jButton4.text", new Object[0]));
/*  779: 677 */     this.jButton4.setName("jButton4");
/*  780: 678 */     this.jButton4.addActionListener(new ActionListener()
/*  781:     */     {
/*  782:     */       public void actionPerformed(ActionEvent evt)
/*  783:     */       {
/*  784: 680 */         GuiaRemisionView.this.jButton4ActionPerformed(evt);
/*  785:     */       }
/*  786: 683 */     });
/*  787: 684 */     this.btnGuardar.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  788: 685 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/*  789: 686 */     this.btnGuardar.setEnabled(false);
/*  790: 687 */     this.btnGuardar.setName("btnGuardar");
/*  791: 688 */     this.btnGuardar.addActionListener(new ActionListener()
/*  792:     */     {
/*  793:     */       public void actionPerformed(ActionEvent evt)
/*  794:     */       {
/*  795: 690 */         GuiaRemisionView.this.btnGuardarActionPerformed(evt);
/*  796:     */       }
/*  797: 693 */     });
/*  798: 694 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  799: 695 */     this.jPanel6.setLayout(jPanel6Layout);
/*  800: 696 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.btnFirmarProcesar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGuardar).addContainerGap(38, 32767)));
/*  801:     */     
/*  802:     */ 
/*  803:     */ 
/*  804:     */ 
/*  805:     */ 
/*  806:     */ 
/*  807:     */ 
/*  808:     */ 
/*  809:     */ 
/*  810:     */ 
/*  811: 707 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnFirmarProcesar).addComponent(this.jButton4).addComponent(this.btnGuardar)).addContainerGap(20, 32767)));
/*  812:     */     
/*  813:     */ 
/*  814:     */ 
/*  815:     */ 
/*  816:     */ 
/*  817:     */ 
/*  818:     */ 
/*  819:     */ 
/*  820:     */ 
/*  821: 717 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel5.border.title", new Object[0])));
/*  822: 718 */     this.jPanel5.setMaximumSize(new Dimension(0, 0));
/*  823: 719 */     this.jPanel5.setMinimumSize(new Dimension(32767, 32767));
/*  824: 720 */     this.jPanel5.setName("jPanel5");
/*  825: 721 */     this.jPanel5.setPreferredSize(new Dimension(0, 0));
/*  826:     */     
/*  827: 723 */     this.jLabel19.setFont(resourceMap.getFont("jLabel15.font"));
/*  828: 724 */     this.jLabel19.setText(resourceMap.getString("jLabel19.text", new Object[0]));
/*  829: 725 */     this.jLabel19.setName("jLabel19");
/*  830:     */     
/*  831: 727 */     this.textNro1.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  832: 728 */     this.textNro1.setName("textNro1");
/*  833: 729 */     this.textNro1.addFocusListener(new FocusAdapter()
/*  834:     */     {
/*  835:     */       public void focusLost(FocusEvent evt)
/*  836:     */       {
/*  837: 731 */         GuiaRemisionView.this.textNro1FocusLost(evt);
/*  838:     */       }
/*  839: 733 */     });
/*  840: 734 */     this.textNro1.addKeyListener(new KeyAdapter()
/*  841:     */     {
/*  842:     */       public void keyPressed(KeyEvent evt)
/*  843:     */       {
/*  844: 736 */         GuiaRemisionView.this.textNro1KeyPressed(evt);
/*  845:     */       }
/*  846: 739 */     });
/*  847: 740 */     this.textNro2.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  848: 741 */     this.textNro2.setName("textNro2");
/*  849: 742 */     this.textNro2.addFocusListener(new FocusAdapter()
/*  850:     */     {
/*  851:     */       public void focusLost(FocusEvent evt)
/*  852:     */       {
/*  853: 744 */         GuiaRemisionView.this.textNro2FocusLost(evt);
/*  854:     */       }
/*  855: 746 */     });
/*  856: 747 */     this.textNro2.addKeyListener(new KeyAdapter()
/*  857:     */     {
/*  858:     */       public void keyPressed(KeyEvent evt)
/*  859:     */       {
/*  860: 749 */         GuiaRemisionView.this.textNro2KeyPressed(evt);
/*  861:     */       }
/*  862: 752 */     });
/*  863: 753 */     this.textNro3.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  864: 754 */     this.textNro3.setText(resourceMap.getString("textNro3.text", new Object[0]));
/*  865: 755 */     this.textNro3.setName("textNro3");
/*  866: 756 */     this.textNro3.addFocusListener(new FocusAdapter()
/*  867:     */     {
/*  868:     */       public void focusLost(FocusEvent evt)
/*  869:     */       {
/*  870: 758 */         GuiaRemisionView.this.textNro3FocusLost(evt);
/*  871:     */       }
/*  872: 760 */     });
/*  873: 761 */     this.textNro3.addKeyListener(new KeyAdapter()
/*  874:     */     {
/*  875:     */       public void keyPressed(KeyEvent evt)
/*  876:     */       {
/*  877: 763 */         GuiaRemisionView.this.textNro3KeyPressed(evt);
/*  878:     */       }
/*  879: 766 */     });
/*  880: 767 */     this.jLabel20.setFont(resourceMap.getFont("jLabel15.font"));
/*  881: 768 */     this.jLabel20.setText(resourceMap.getString("jLabel20.text", new Object[0]));
/*  882: 769 */     this.jLabel20.setName("jLabel20");
/*  883:     */     
/*  884: 771 */     this.jLabel21.setFont(resourceMap.getFont("jLabel15.font"));
/*  885: 772 */     this.jLabel21.setText(resourceMap.getString("jLabel21.text", new Object[0]));
/*  886: 773 */     this.jLabel21.setName("jLabel21");
/*  887:     */     
/*  888: 775 */     this.jScrollPane5.setName("jScrollPane5");
/*  889:     */     
/*  890: 777 */     this.txtMotivoTraslado.setColumns(20);
/*  891: 778 */     this.txtMotivoTraslado.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  892: 779 */     this.txtMotivoTraslado.setRows(5);
/*  893: 780 */     this.txtMotivoTraslado.setName("txtMotivoTraslado");
/*  894: 781 */     this.txtMotivoTraslado.addKeyListener(new KeyAdapter()
/*  895:     */     {
/*  896:     */       public void keyPressed(KeyEvent evt)
/*  897:     */       {
/*  898: 783 */         GuiaRemisionView.this.txtMotivoTrasladoKeyPressed(evt);
/*  899:     */       }
/*  900:     */       
/*  901:     */       public void keyReleased(KeyEvent evt)
/*  902:     */       {
/*  903: 786 */         GuiaRemisionView.this.txtMotivoTrasladoKeyReleased(evt);
/*  904:     */       }
/*  905: 788 */     });
/*  906: 789 */     this.jScrollPane5.setViewportView(this.txtMotivoTraslado);
/*  907:     */     
/*  908: 791 */     this.jLabel22.setFont(resourceMap.getFont("jLabel15.font"));
/*  909: 792 */     this.jLabel22.setText(resourceMap.getString("jLabel22.text", new Object[0]));
/*  910: 793 */     this.jLabel22.setName("jLabel22");
/*  911:     */     
/*  912: 795 */     this.textFechaEmisionDoc.setEditable(false);
/*  913: 796 */     this.textFechaEmisionDoc.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  914: 797 */     this.textFechaEmisionDoc.setName("textFechaEmisionDoc");
/*  915: 798 */     this.textFechaEmisionDoc.setPreferredSize(new Dimension(15, 20));
/*  916: 799 */     this.textFechaEmisionDoc.setRequestFocusEnabled(false);
/*  917:     */     
/*  918: 801 */     this.jCalendarEmisionDoc.setName("jCalendarEmisionDoc");
/*  919:     */     
/*  920: 803 */     this.jLabel23.setFont(resourceMap.getFont("jLabel15.font"));
/*  921: 804 */     this.jLabel23.setText(resourceMap.getString("jLabel23.text", new Object[0]));
/*  922: 805 */     this.jLabel23.setName("jLabel23");
/*  923:     */     
/*  924: 807 */     this.jLabel24.setFont(resourceMap.getFont("jLabel15.font"));
/*  925: 808 */     this.jLabel24.setText(resourceMap.getString("jLabel24.text", new Object[0]));
/*  926: 809 */     this.jLabel24.setName("jLabel24");
/*  927:     */     
/*  928: 811 */     this.txtDocAduanero.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  929: 812 */     this.txtDocAduanero.setText(resourceMap.getString("txtDocAduanero.text", new Object[0]));
/*  930: 813 */     this.txtDocAduanero.setName("txtDocAduanero");
/*  931: 814 */     this.txtDocAduanero.addKeyListener(new KeyAdapter()
/*  932:     */     {
/*  933:     */       public void keyPressed(KeyEvent evt)
/*  934:     */       {
/*  935: 816 */         GuiaRemisionView.this.txtDocAduaneroKeyPressed(evt);
/*  936:     */       }
/*  937: 819 */     });
/*  938: 820 */     this.jLabel26.setFont(resourceMap.getFont("jLabel15.font"));
/*  939: 821 */     this.jLabel26.setText(resourceMap.getString("jLabel26.text", new Object[0]));
/*  940: 822 */     this.jLabel26.setName("jLabel26");
/*  941:     */     
/*  942: 824 */     this.txtCodEstabDest.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  943: 825 */     this.txtCodEstabDest.setText(resourceMap.getString("txtCodEstabDest.text", new Object[0]));
/*  944: 826 */     this.txtCodEstabDest.setName("txtCodEstabDest");
/*  945: 827 */     this.txtCodEstabDest.addKeyListener(new KeyAdapter()
/*  946:     */     {
/*  947:     */       public void keyPressed(KeyEvent evt)
/*  948:     */       {
/*  949: 829 */         GuiaRemisionView.this.txtCodEstabDestKeyPressed(evt);
/*  950:     */       }
/*  951: 832 */     });
/*  952: 833 */     this.jLabel27.setFont(resourceMap.getFont("jLabel27.font"));
/*  953: 834 */     this.jLabel27.setText(resourceMap.getString("jLabel27.text", new Object[0]));
/*  954: 835 */     this.jLabel27.setName("jLabel27");
/*  955:     */     
/*  956: 837 */     this.jScrollPane6.setName("jScrollPane6");
/*  957:     */     
/*  958: 839 */     this.txtRuta.setColumns(20);
/*  959: 840 */     this.txtRuta.setFont(resourceMap.getFont("txtCedulaDest.font"));
/*  960: 841 */     this.txtRuta.setRows(5);
/*  961: 842 */     this.txtRuta.setName("txtRuta");
/*  962: 843 */     this.txtRuta.addKeyListener(new KeyAdapter()
/*  963:     */     {
/*  964:     */       public void keyPressed(KeyEvent evt)
/*  965:     */       {
/*  966: 845 */         GuiaRemisionView.this.txtRutaKeyPressed(evt);
/*  967:     */       }
/*  968:     */       
/*  969:     */       public void keyReleased(KeyEvent evt)
/*  970:     */       {
/*  971: 848 */         GuiaRemisionView.this.txtRutaKeyReleased(evt);
/*  972:     */       }
/*  973: 850 */     });
/*  974: 851 */     this.jScrollPane6.setViewportView(this.txtRuta);
/*  975:     */     
/*  976: 853 */     this.comboTipoDocModificado.setFont(resourceMap.getFont("comboTipoDocModificado.font"));
/*  977: 854 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  978: 855 */     this.comboTipoDocModificado.setName("comboTipoDocModificado");
/*  979:     */     
/*  980: 857 */     this.jLabel29.setFont(resourceMap.getFont("jLabel15.font"));
/*  981: 858 */     this.jLabel29.setText(resourceMap.getString("jLabel29.text", new Object[0]));
/*  982: 859 */     this.jLabel29.setName("jLabel29");
/*  983:     */     
/*  984: 861 */     this.jScrollPane1.setName("jScrollPane1");
/*  985:     */     
/*  986: 863 */     this.jTableProductos.setFont(resourceMap.getFont("jTableProductos.font"));
/*  987: 864 */     this.jTableProductos.setName("jTableProductos");
/*  988: 865 */     this.jScrollPane1.setViewportView(this.jTableProductos);
/*  989:     */     
/*  990: 867 */     this.btnSeleccionProducto.setFont(resourceMap.getFont("btnSeleccionProducto.font"));
/*  991: 868 */     this.btnSeleccionProducto.setText(resourceMap.getString("btnSeleccionProducto.text", new Object[0]));
/*  992: 869 */     this.btnSeleccionProducto.setName("btnSeleccionProducto");
/*  993: 870 */     this.btnSeleccionProducto.addActionListener(new ActionListener()
/*  994:     */     {
/*  995:     */       public void actionPerformed(ActionEvent evt)
/*  996:     */       {
/*  997: 872 */         GuiaRemisionView.this.btnSeleccionProductoActionPerformed(evt);
/*  998:     */       }
/*  999: 875 */     });
/* 1000: 876 */     this.jToggleButton2.setFont(resourceMap.getFont("jToggleButton2.font"));
/* 1001: 877 */     this.jToggleButton2.setText(resourceMap.getString("jToggleButton2.text", new Object[0]));
/* 1002: 878 */     this.jToggleButton2.setName("jToggleButton2");
/* 1003: 879 */     this.jToggleButton2.addActionListener(new ActionListener()
/* 1004:     */     {
/* 1005:     */       public void actionPerformed(ActionEvent evt)
/* 1006:     */       {
/* 1007: 881 */         GuiaRemisionView.this.jToggleButton2ActionPerformed(evt);
/* 1008:     */       }
/* 1009: 884 */     });
/* 1010: 885 */     this.txtRazonSocDest.setFont(resourceMap.getFont("txtCedulaDest.font"));
/* 1011: 886 */     this.txtRazonSocDest.setText(resourceMap.getString("txtRazonSocDest.text", new Object[0]));
/* 1012: 887 */     this.txtRazonSocDest.setName("txtRazonSocDest");
/* 1013: 888 */     this.txtRazonSocDest.addFocusListener(new FocusAdapter()
/* 1014:     */     {
/* 1015:     */       public void focusGained(FocusEvent evt)
/* 1016:     */       {
/* 1017: 890 */         GuiaRemisionView.this.txtRazonSocDestFocusGained(evt);
/* 1018:     */       }
/* 1019: 893 */     });
/* 1020: 894 */     this.jScrollPane4.setName("jScrollPane4");
/* 1021:     */     
/* 1022: 896 */     this.txtDirecDest.setColumns(20);
/* 1023: 897 */     this.txtDirecDest.setFont(resourceMap.getFont("txtCedulaDest.font"));
/* 1024: 898 */     this.txtDirecDest.setRows(4);
/* 1025: 899 */     this.txtDirecDest.setName("txtDirecDest");
/* 1026: 900 */     this.txtDirecDest.addKeyListener(new KeyAdapter()
/* 1027:     */     {
/* 1028:     */       public void keyPressed(KeyEvent evt)
/* 1029:     */       {
/* 1030: 902 */         GuiaRemisionView.this.txtDirecDestKeyPressed(evt);
/* 1031:     */       }
/* 1032:     */       
/* 1033:     */       public void keyReleased(KeyEvent evt)
/* 1034:     */       {
/* 1035: 905 */         GuiaRemisionView.this.txtDirecDestKeyReleased(evt);
/* 1036:     */       }
/* 1037: 907 */     });
/* 1038: 908 */     this.jScrollPane4.setViewportView(this.txtDirecDest);
/* 1039:     */     
/* 1040: 910 */     this.txtNumAutDoc.setFont(resourceMap.getFont("txtCedulaDest.font"));
/* 1041: 911 */     this.txtNumAutDoc.setText(resourceMap.getString("txtNumAutDoc.text", new Object[0]));
/* 1042: 912 */     this.txtNumAutDoc.setName("txtNumAutDoc");
/* 1043: 913 */     this.txtNumAutDoc.addActionListener(new ActionListener()
/* 1044:     */     {
/* 1045:     */       public void actionPerformed(ActionEvent evt)
/* 1046:     */       {
/* 1047: 915 */         GuiaRemisionView.this.txtNumAutDocActionPerformed(evt);
/* 1048:     */       }
/* 1049: 917 */     });
/* 1050: 918 */     this.txtNumAutDoc.addKeyListener(new KeyAdapter()
/* 1051:     */     {
/* 1052:     */       public void keyPressed(KeyEvent evt)
/* 1053:     */       {
/* 1054: 920 */         GuiaRemisionView.this.txtNumAutDocKeyPressed(evt);
/* 1055:     */       }
/* 1056: 923 */     });
/* 1057: 924 */     this.jLabel1.setFont(resourceMap.getFont("jLabel15.font"));
/* 1058: 925 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 1059: 926 */     this.jLabel1.setName("jLabel1");
/* 1060:     */     
/* 1061: 928 */     this.btnAnadir.setName("btnAnadir");
/* 1062: 929 */     this.btnAnadir.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/* 1063: 930 */     this.btnAnadir.addActionListener(new ActionListener()
/* 1064:     */     {
/* 1065:     */       public void actionPerformed(ActionEvent evt)
/* 1066:     */       {
/* 1067: 932 */         GuiaRemisionView.this.btnAnadirActionPerformed(evt);
/* 1068:     */       }
/* 1069: 935 */     });
/* 1070: 936 */     this.txtCedulaDest.setFont(resourceMap.getFont("txtCedulaDest.font"));
/* 1071: 937 */     this.txtCedulaDest.setText(resourceMap.getString("txtCedulaDest.text", new Object[0]));
/* 1072: 938 */     this.txtCedulaDest.setName("txtCedulaDest");
/* 1073:     */     
/* 1074: 940 */     this.jLabel2.setFont(resourceMap.getFont("jLabel2.font"));
/* 1075: 941 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 1076: 942 */     this.jLabel2.setName("jLabel2");
/* 1077:     */     
/* 1078: 944 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1079: 945 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1080: 946 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1003, 32767).addComponent(this.jLabel27).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING).addComponent(this.jLabel21, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -1, 530, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel20, -2, -1, -2).addComponent(this.jLabel2, -2, -1, -2).addComponent(this.jLabel23, -2, 99, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addComponent(this.txtCedulaDest).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jToggleButton2).addGap(10, 10, 10).addComponent(this.btnAnadir, -2, 25, -2)).addComponent(this.txtRazonSocDest, -2, 353, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel26).addComponent(this.jLabel24).addComponent(this.jLabel22).addComponent(this.jLabel29).addComponent(this.jLabel19).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.textNro1, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textNro2, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textNro3, -2, 69, -2)).addComponent(this.txtNumAutDoc, -2, 234, -2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtCodEstabDest, GroupLayout.Alignment.LEADING).addComponent(this.txtDocAduanero, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.comboTipoDocModificado, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.textFechaEmisionDoc, GroupLayout.Alignment.LEADING, -2, 100, -2)).addGap(18, 18, 18).addComponent(this.jCalendarEmisionDoc, -2, -1, -2)))).addContainerGap()).addComponent(this.btnSeleccionProducto))));
/* 1081:     */     
/* 1082:     */ 
/* 1083:     */ 
/* 1084:     */ 
/* 1085:     */ 
/* 1086:     */ 
/* 1087:     */ 
/* 1088:     */ 
/* 1089:     */ 
/* 1090:     */ 
/* 1091:     */ 
/* 1092:     */ 
/* 1093:     */ 
/* 1094:     */ 
/* 1095:     */ 
/* 1096:     */ 
/* 1097:     */ 
/* 1098:     */ 
/* 1099:     */ 
/* 1100:     */ 
/* 1101:     */ 
/* 1102:     */ 
/* 1103:     */ 
/* 1104:     */ 
/* 1105:     */ 
/* 1106:     */ 
/* 1107:     */ 
/* 1108:     */ 
/* 1109:     */ 
/* 1110:     */ 
/* 1111:     */ 
/* 1112:     */ 
/* 1113:     */ 
/* 1114:     */ 
/* 1115:     */ 
/* 1116:     */ 
/* 1117:     */ 
/* 1118:     */ 
/* 1119:     */ 
/* 1120:     */ 
/* 1121:     */ 
/* 1122:     */ 
/* 1123:     */ 
/* 1124:     */ 
/* 1125:     */ 
/* 1126:     */ 
/* 1127:     */ 
/* 1128:     */ 
/* 1129:     */ 
/* 1130:     */ 
/* 1131:     */ 
/* 1132:     */ 
/* 1133:     */ 
/* 1134:     */ 
/* 1135:     */ 
/* 1136:     */ 
/* 1137:     */ 
/* 1138:1004 */     jPanel5Layout.linkSize(0, new Component[] { this.jLabel20, this.jLabel23 });
/* 1139:     */     
/* 1140:1006 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel2, -2, -1, -2).addComponent(this.txtCedulaDest, -2, -1, -2).addComponent(this.btnAnadir).addComponent(this.jToggleButton2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel20, -2, -1, -2).addComponent(this.txtRazonSocDest, -2, 22, -2)).addGap(20, 20, 20).addComponent(this.jLabel23).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 36, -2).addGap(18, 18, 18).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane5, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel27).addGap(1, 1, 1).addComponent(this.jScrollPane6, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnSeleccionProducto)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel26).addComponent(this.txtCodEstabDest, -2, -1, -2)).addGap(6, 6, 6).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.txtDocAduanero, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.textFechaEmisionDoc, -2, -1, -2).addComponent(this.jLabel22).addComponent(this.jCalendarEmisionDoc, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel29).addComponent(this.comboTipoDocModificado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.textNro1, -2, -1, -2).addComponent(this.jLabel19).addComponent(this.textNro2, -2, -1, -2).addComponent(this.textNro3, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addComponent(this.txtNumAutDoc, -2, -1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 108, -2).addContainerGap(31, 32767)));
/* 1141:     */     
/* 1142:     */ 
/* 1143:     */ 
/* 1144:     */ 
/* 1145:     */ 
/* 1146:     */ 
/* 1147:     */ 
/* 1148:     */ 
/* 1149:     */ 
/* 1150:     */ 
/* 1151:     */ 
/* 1152:     */ 
/* 1153:     */ 
/* 1154:     */ 
/* 1155:     */ 
/* 1156:     */ 
/* 1157:     */ 
/* 1158:     */ 
/* 1159:     */ 
/* 1160:     */ 
/* 1161:     */ 
/* 1162:     */ 
/* 1163:     */ 
/* 1164:     */ 
/* 1165:     */ 
/* 1166:     */ 
/* 1167:     */ 
/* 1168:     */ 
/* 1169:     */ 
/* 1170:     */ 
/* 1171:     */ 
/* 1172:     */ 
/* 1173:     */ 
/* 1174:     */ 
/* 1175:     */ 
/* 1176:     */ 
/* 1177:     */ 
/* 1178:     */ 
/* 1179:     */ 
/* 1180:     */ 
/* 1181:     */ 
/* 1182:     */ 
/* 1183:     */ 
/* 1184:     */ 
/* 1185:     */ 
/* 1186:     */ 
/* 1187:     */ 
/* 1188:     */ 
/* 1189:     */ 
/* 1190:     */ 
/* 1191:     */ 
/* 1192:     */ 
/* 1193:     */ 
/* 1194:     */ 
/* 1195:     */ 
/* 1196:     */ 
/* 1197:     */ 
/* 1198:     */ 
/* 1199:     */ 
/* 1200:     */ 
/* 1201:1067 */     jPanel5Layout.linkSize(1, new Component[] { this.btnAnadir, this.jToggleButton2 });
/* 1202:     */     
/* 1203:1069 */     this.cabecera1.setMaximumSize(new Dimension(777, 243));
/* 1204:1070 */     this.cabecera1.setMinimumSize(new Dimension(777, 243));
/* 1205:1071 */     this.cabecera1.setName("cabecera1");
/* 1206:1072 */     this.cabecera1.setPreferredSize(new Dimension(777, 243));
/* 1207:     */     
/* 1208:1074 */     this.idenComprob.setName("idenComprob");
/* 1209:     */     
/* 1210:1076 */     GroupLayout layout = new GroupLayout(this);
/* 1211:1077 */     setLayout(layout);
/* 1212:1078 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel5, -2, 1025, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel4, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jPanel6, -2, 462, -2)).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.idenComprob, -1, 1025, 32767).addComponent(this.cabecera1, GroupLayout.Alignment.TRAILING, -1, 1025, 32767)).addContainerGap()));
/* 1213:     */     
/* 1214:     */ 
/* 1215:     */ 
/* 1216:     */ 
/* 1217:     */ 
/* 1218:     */ 
/* 1219:     */ 
/* 1220:     */ 
/* 1221:     */ 
/* 1222:     */ 
/* 1223:     */ 
/* 1224:     */ 
/* 1225:     */ 
/* 1226:     */ 
/* 1227:     */ 
/* 1228:1094 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.cabecera1, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.idenComprob, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(8, 8, 8).addComponent(this.jPanel5, -2, 483, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addGap(12, 12, 12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -2, 64, -2).addComponent(this.jPanel4, -2, -1, -2)).addContainerGap(-1, 32767)));
/* 1229:     */     
/* 1230:     */ 
/* 1231:     */ 
/* 1232:     */ 
/* 1233:     */ 
/* 1234:     */ 
/* 1235:     */ 
/* 1236:     */ 
/* 1237:     */ 
/* 1238:     */ 
/* 1239:     */ 
/* 1240:     */ 
/* 1241:     */ 
/* 1242:     */ 
/* 1243:     */ 
/* 1244:     */ 
/* 1245:     */ 
/* 1246:     */ 
/* 1247:1113 */     getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName", new Object[0]));
/* 1248:     */   }
/* 1249:     */   
/* 1250:     */   private void btnNuevoDestinatarioActionPerformed(ActionEvent evt)
/* 1251:     */   {
/* 1252:1117 */     StringBuilder mensajes = new StringBuilder();
/* 1253:1118 */     boolean error = false;
/* 1254:1119 */     if ((this.modeloProductos.getRowCount() > 0) && (this.destinatarioSeleccionado != null) && (this.transportistaSeleccionado != null))
/* 1255:     */     {
/* 1256:1121 */       Destinatario item = new Destinatario();
/* 1257:1123 */       if (this.txtDirecDest.getText().isEmpty() == true)
/* 1258:     */       {
/* 1259:1124 */         mensajes.append("\n Ingrese la Dirección de Destino");
/* 1260:1125 */         error = true;
/* 1261:     */       }
/* 1262:     */       else
/* 1263:     */       {
/* 1264:1127 */         item.setDirDestinatario(this.txtDirecDest.getText());
/* 1265:     */       }
/* 1266:1130 */       if (!this.txtCodEstabDest.getText().isEmpty()) {
/* 1267:1131 */         item.setCodEstabDestino(this.txtCodEstabDest.getText());
/* 1268:     */       }
/* 1269:1134 */       if (!this.txtDocAduanero.getText().isEmpty()) {
/* 1270:1135 */         item.setDocAduaneroUnico(this.txtDocAduanero.getText());
/* 1271:     */       }
/* 1272:1138 */       if (!this.txtNumAutDoc.getText().isEmpty()) {
/* 1273:1139 */         if ((this.txtNumAutDoc.getText().length() == 37) || (this.txtNumAutDoc.getText().length() == 10))
/* 1274:     */         {
/* 1275:1140 */           item.setNumAutDocSustento(this.txtNumAutDoc.getText());
/* 1276:     */         }
/* 1277:     */         else
/* 1278:     */         {
/* 1279:1142 */           mensajes.append("\n El Nro. de Autorización del comprobante debe de ser de 10 o 37 dígitos");
/* 1280:1143 */           error = true;
/* 1281:     */         }
/* 1282:     */       }
/* 1283:1147 */       if (!this.textFechaEmisionDoc.getText().isEmpty()) {
/* 1284:1148 */         item.setFechaEmisionDocSustento(this.textFechaEmisionDoc.getText());
/* 1285:     */       }
/* 1286:1151 */       if (this.txtMotivoTraslado.getText().isEmpty() == true)
/* 1287:     */       {
/* 1288:1152 */         mensajes.append("\n Ingrese el Motivo de Traslado");
/* 1289:1153 */         error = true;
/* 1290:     */       }
/* 1291:     */       else
/* 1292:     */       {
/* 1293:1155 */         item.setMotivoTraslado(this.txtMotivoTraslado.getText());
/* 1294:     */       }
/* 1295:1158 */       if ((!this.textNro1.getText().isEmpty()) && (!this.textNro1.getText().isEmpty()) && (!this.textNro1.getText().isEmpty())) {
/* 1296:1159 */         if ((this.textNro1.getText().length() != 3) && (this.textNro2.getText().length() != 3) && (this.textNro3.getText().length() != 9))
/* 1297:     */         {
/* 1298:1160 */           mensajes.append("\n El Nro. de comprobante debe de ser de 15 caracteres");
/* 1299:1161 */           error = true;
/* 1300:     */         }
/* 1301:     */         else
/* 1302:     */         {
/* 1303:1163 */           item.setNumDocSustento(this.textNro1.getText() + "-" + this.textNro2.getText() + "-" + this.textNro3.getText());
/* 1304:     */         }
/* 1305:     */       }
/* 1306:1167 */       if ((((String)this.comboTipoDocModificado.getSelectedItem()).equals("FACTURA")) && (item.getNumDocSustento() != null)) {
/* 1307:1169 */         item.setCodDocSustento(TipoComprobanteEnum.FACTURA.getCode());
/* 1308:     */       }
/* 1309:1172 */       if (!this.txtRuta.getText().isEmpty()) {
/* 1310:1173 */         item.setRuta(this.txtRuta.getText());
/* 1311:     */       }
/* 1312:1175 */       if (!error)
/* 1313:     */       {
/* 1314:1176 */         item.setIdentificacionDestinatario(this.destinatarioSeleccionado.getNumeroIdentificacio());
/* 1315:1177 */         item.setRazonSocialDestinatario(this.destinatarioSeleccionado.getApellido());
/* 1316:1178 */         List<Producto> productos = this.modeloProductos.getProductos();
/* 1317:     */         
/* 1318:1180 */         this.modeloDetalle.addRow(this.modeloDetalle.getRowCount() + 1, item, productos);
/* 1319:1181 */         this.btnGuardar.setEnabled(true);
/* 1320:1182 */         this.btnFirmarProcesar.setEnabled(true);
/* 1321:     */       }
/* 1322:     */       else
/* 1323:     */       {
/* 1324:1184 */         JOptionPane.showMessageDialog(this, mensajes.toString(), "Se ha producido un error ", 0);
/* 1325:     */       }
/* 1326:     */     }
/* 1327:     */     else
/* 1328:     */     {
/* 1329:1187 */       JOptionPane.showMessageDialog(this, "Debe seleccionar un Transportista, un Destinatario y debe añadir al menos un Producto al detalle ", "Se ha producido un error ", 0);
/* 1330:     */     }
/* 1331:     */   }
/* 1332:     */   
/* 1333:     */   public void setDate(String dateString)
/* 1334:     */   {
/* 1335:1198 */     Date date = null;
/* 1336:     */     try
/* 1337:     */     {
/* 1338:1200 */       if ((dateString != null) && (dateString.length() > 0)) {
/* 1339:1201 */         date = Constantes.dateFormat.parse(dateString);
/* 1340:     */       }
/* 1341:     */     }
/* 1342:     */     catch (Exception e)
/* 1343:     */     {
/* 1344:1204 */       date = null;
/* 1345:     */     }
/* 1346:1206 */     setDate(date);
/* 1347:     */   }
/* 1348:     */   
/* 1349:     */   public void setDate(Date date)
/* 1350:     */   {
/* 1351:1215 */     String dateString = "";
/* 1352:1216 */     date = FormGenerales.eliminaHora(date);
/* 1353:1217 */     Date hoy = FormGenerales.eliminaHora(new Date());
/* 1354:1218 */     if ((date != null) && ((date.equals(hoy)) || (date.after(hoy))))
/* 1355:     */     {
/* 1356:1219 */       dateString = Constantes.dateFormat.format(date);
/* 1357:1220 */       this.textFechaIni.setText(dateString);
/* 1358:1221 */       this.jCalendarFechaInicio.setTargetDate(date);
/* 1359:1222 */       this.fechaEmision = FormGenerales.eliminaHora(date);
/* 1360:     */     }
/* 1361:     */     else
/* 1362:     */     {
/* 1363:1224 */       JOptionPane.showMessageDialog(this, "No se permiten fechas menores a la del día de hoy", "Se ha producido un error ", 1);
/* 1364:     */     }
/* 1365:     */   }
/* 1366:     */   
/* 1367:     */   public void actualizaClaveDeAcceso()
/* 1368:     */   {
/* 1369:1232 */     this.claveDeAcceso = null;
/* 1370:1233 */     llenaDatosEmisor();
/* 1371:1234 */     this.claveContingencia = new FormGenerales().obtieneClaveDeAcceso(this.secuencialComprobante, this.emisor, this.serie, this.claveDeAcceso, this.fechaEmision, TipoComprobanteEnum.GUIA_DE_REMISION.getCode());
/* 1372:1237 */     if ((this.claveContingencia.getCodigoComprobante() != null) && (!this.claveContingencia.getCodigoComprobante().isEmpty())) {
/* 1373:1238 */       this.claveDeAcceso = this.claveContingencia.getCodigoComprobante();
/* 1374:     */     }
/* 1375:1240 */     this.idenComprob.lblClaveAcceso.setText(this.claveDeAcceso);
/* 1376:     */   }
/* 1377:     */   
/* 1378:     */   public void setDateComprobante(Date date, int id)
/* 1379:     */   {
/* 1380:1249 */     String dateString = "";
/* 1381:1250 */     if (date != null)
/* 1382:     */     {
/* 1383:1251 */       date = FormGenerales.eliminaHora(date);
/* 1384:1252 */       dateString = Constantes.dateFormat.format(date);
/* 1385:1253 */       Date hoy = FormGenerales.eliminaHora(new Date());
/* 1386:1255 */       if (id == 2)
/* 1387:     */       {
/* 1388:1256 */         this.textFechaIni.setText(dateString);
/* 1389:1257 */         this.jCalendarFechaInicio.setTargetDate(date);
/* 1390:     */       }
/* 1391:1259 */       if (id == 3)
/* 1392:     */       {
/* 1393:1260 */         this.textFechaFin.setText(dateString);
/* 1394:1261 */         this.jCalendarFechaFin.setTargetDate(date);
/* 1395:     */       }
/* 1396:1263 */       if (id == 4) {
/* 1397:1264 */         if ((date.equals(hoy)) || (date.before(hoy)))
/* 1398:     */         {
/* 1399:1265 */           this.textFechaEmisionDoc.setText(dateString);
/* 1400:1266 */           this.jCalendarEmisionDoc.setTargetDate(date);
/* 1401:     */         }
/* 1402:     */         else
/* 1403:     */         {
/* 1404:1268 */           JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/* 1405:     */         }
/* 1406:     */       }
/* 1407:     */     }
/* 1408:     */   }
/* 1409:     */   
/* 1410:     */   void buscarCliente(String cadena, int parametro)
/* 1411:     */   {
/* 1412:1275 */     this.modeloDatosAdicionales.deleteAllRows();
/* 1413:     */     try
/* 1414:     */     {
/* 1415:1278 */       if (parametro == 1) {
/* 1416:1279 */         this.destinatarioSeleccionado = new ClientesSQL().obtenerClientesTipo(cadena, null, TipoClienteEnum.D);
/* 1417:     */       } else {
/* 1418:1281 */         this.destinatarioSeleccionado = new ClientesSQL().obtenerClientesTipo(null, cadena, TipoClienteEnum.D);
/* 1419:     */       }
/* 1420:     */     }
/* 1421:     */     catch (Exception ex)
/* 1422:     */     {
/* 1423:1284 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1424:     */     }
/* 1425:1286 */     if (this.destinatarioSeleccionado != null)
/* 1426:     */     {
/* 1427:1287 */       this.txtCedulaDest.setText(this.destinatarioSeleccionado.getNumeroIdentificacio());
/* 1428:1288 */       this.txtRazonSocDest.setText(this.destinatarioSeleccionado.getApellido());
/* 1429:     */     }
/* 1430:     */     else
/* 1431:     */     {
/* 1432:1290 */       JOptionPane.showMessageDialog(this, "No existen registros almacenados para el dato buscado", "Se ha producido un error ", 1);
/* 1433:     */     }
/* 1434:     */   }
/* 1435:     */   
/* 1436:     */   void buscarTransportista(String cadena, int parametro)
/* 1437:     */   {
/* 1438:1295 */     this.modeloDatosAdicionales.deleteAllRows();
/* 1439:     */     
/* 1440:1297 */     TransportistaSQL consulta = new TransportistaSQL();
/* 1441:1298 */     List<Transportista> lista = null;
/* 1442:     */     try
/* 1443:     */     {
/* 1444:1300 */       if (parametro == 1) {
/* 1445:1301 */         lista = consulta.obtenerTransportista(null, cadena, null);
/* 1446:     */       } else {
/* 1447:1304 */         lista = consulta.obtenerTransportista(null, null, cadena);
/* 1448:     */       }
/* 1449:     */     }
/* 1450:     */     catch (Exception ex)
/* 1451:     */     {
/* 1452:1307 */       Logger.getLogger(GuiaRemisionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1453:     */     }
/* 1454:1309 */     if (!lista.isEmpty()) {
/* 1455:1310 */       this.transportistaSeleccionado = ((Transportista)lista.get(0));
/* 1456:     */     }
/* 1457:1313 */     if (this.transportistaSeleccionado != null)
/* 1458:     */     {
/* 1459:1314 */       this.txtCedulaTrans.setText(this.transportistaSeleccionado.getIdentificacion());
/* 1460:1315 */       this.txtRazonSocTrans.setText(this.transportistaSeleccionado.getRazonSocial());
/* 1461:1316 */       this.txtPlaca.setText(this.transportistaSeleccionado.getPlaca());
/* 1462:     */     }
/* 1463:     */     else
/* 1464:     */     {
/* 1465:1318 */       JOptionPane.showMessageDialog(this, "No existen registros almacenados para el dato buscado", "Se ha producido un error ", 1);
/* 1466:     */     }
/* 1467:     */   }
/* 1468:     */   
/* 1469:     */   private GuiaRemision generarComprobante()
/* 1470:     */   {
/* 1471:1328 */     GuiaRemision guia = null;
/* 1472:1330 */     if (!llenarObjetoComprobante())
/* 1473:     */     {
/* 1474:1331 */       GuiaRemision.Destinatarios destinatarios = obtenerDestinatarios();
/* 1475:1332 */       if (destinatarios != null)
/* 1476:     */       {
/* 1477:1334 */         GuiaRemision.InfoAdicional informacion = generarInformacionAdicional();
/* 1478:     */         
/* 1479:1336 */         guia = this.factory.createGuiaRemision();
/* 1480:1337 */         guia.setVersion("1.0.0");
/* 1481:1338 */         guia.setId("comprobante");
/* 1482:1339 */         guia.setInfoTributaria(this.infoTributaria);
/* 1483:1340 */         guia.setInfoGuiaRemision(this.infoGuiaRemision);
/* 1484:1341 */         guia.setDestinatarios(destinatarios);
/* 1485:1343 */         if (!informacion.getCampoAdicional().isEmpty()) {
/* 1486:1344 */           guia.setInfoAdicional(informacion);
/* 1487:     */         }
/* 1488:     */       }
/* 1489:     */     }
/* 1490:1349 */     return guia;
/* 1491:     */   }
/* 1492:     */   
/* 1493:     */   GuiaRemision.Destinatarios obtenerDestinatarios()
/* 1494:     */   {
/* 1495:1359 */     GuiaRemision.Destinatarios resultado = this.factory.createGuiaRemisionDestinatarios();
/* 1496:1360 */     boolean error = false;
/* 1497:1362 */     for (DestinatarioProducto item : this.modeloDetalle.getDestinatarios())
/* 1498:     */     {
/* 1499:1363 */       Destinatario destinatario = this.factory.createDestinatario();
/* 1500:     */       
/* 1501:1365 */       Destinatario.Detalles detalles = this.factory.createDestinatarioDetalles();
/* 1502:1366 */       destinatario = item.getDestinatario();
/* 1503:1369 */       for (Producto prod : item.getProductos())
/* 1504:     */       {
/* 1505:1371 */         Detalle detalle = this.factory.createDetalle();
/* 1506:1372 */         detalle.setCantidad(new BigDecimal(prod.getCantidad().doubleValue()));
/* 1507:1373 */         if ((prod.getCodigoPrincipal() != null) && (!prod.getCodigoPrincipal().isEmpty())) {
/* 1508:1374 */           detalle.setCodigoInterno(prod.getCodigoPrincipal());
/* 1509:     */         }
/* 1510:1376 */         if ((prod.getCodigoAuxiliar() != null) && (!prod.getCodigoAuxiliar().isEmpty())) {
/* 1511:1377 */           detalle.setCodigoAdicional(prod.getCodigoAuxiliar());
/* 1512:     */         }
/* 1513:1379 */         detalle.setDescripcion(prod.getNombre());
/* 1514:     */         
/* 1515:     */ 
/* 1516:1382 */         List<InformacionAdicionalProducto> listaInfo = prod.getInfoAdicionalList();
/* 1517:1384 */         if (!listaInfo.isEmpty())
/* 1518:     */         {
/* 1519:1385 */           Detalle.DetallesAdicionales obj = this.factory.createDetalleDetallesAdicionales();
/* 1520:1387 */           for (InformacionAdicionalProducto info : listaInfo)
/* 1521:     */           {
/* 1522:1388 */             Detalle.DetallesAdicionales.DetAdicional det = this.factory.createDetalleDetallesAdicionalesDetAdicional();
/* 1523:1389 */             det.setNombre(info.getAtributo());
/* 1524:1390 */             det.setValor(info.getValor());
/* 1525:1391 */             obj.getDetAdicional().add(det);
/* 1526:     */           }
/* 1527:1393 */           detalle.setDetallesAdicionales(obj);
/* 1528:     */         }
/* 1529:1395 */         detalles.getDetalle().add(detalle);
/* 1530:     */       }
/* 1531:1397 */       destinatario.setDetalles(detalles);
/* 1532:     */       
/* 1533:1399 */       resultado.getDestinatario().add(destinatario);
/* 1534:1400 */       destinatario = null;
/* 1535:1401 */       detalles = null;
/* 1536:     */     }
/* 1537:1404 */     if (error == true) {
/* 1538:1405 */       resultado = null;
/* 1539:     */     }
/* 1540:1407 */     return resultado;
/* 1541:     */   }
/* 1542:     */   
/* 1543:     */   private GuiaRemision.InfoAdicional generarInformacionAdicional()
/* 1544:     */   {
/* 1545:1418 */     GuiaRemision.InfoAdicional info = this.factory.createGuiaRemisionInfoAdicional();
/* 1546:1420 */     for (int i = 0; i < this.modeloDatosAdicionales.getRowCount(); i++)
/* 1547:     */     {
/* 1548:1421 */       GuiaRemision.InfoAdicional.CampoAdicional detalle = this.factory.createGuiaRemisionInfoAdicionalCampoAdicional();
/* 1549:1422 */       detalle.setNombre((String)this.modeloDatosAdicionales.getValueAt(i, 0));
/* 1550:1423 */       detalle.setValue((String)this.modeloDatosAdicionales.getValueAt(i, 1));
/* 1551:     */       
/* 1552:1425 */       info.getCampoAdicional().add(detalle);
/* 1553:     */     }
/* 1554:1427 */     return info;
/* 1555:     */   }
/* 1556:     */   
/* 1557:     */   private boolean llenarObjetoComprobante()
/* 1558:     */   {
/* 1559:1434 */     StringBuilder mensajes = new StringBuilder();
/* 1560:1435 */     boolean error = false;
/* 1561:1436 */     this.infoTributaria = this.factory.createInfoTributaria();
/* 1562:     */     
/* 1563:1438 */     this.infoTributaria.setSecuencial(this.secuencialComprobante);
/* 1564:1439 */     this.infoTributaria.setAmbiente(this.emisor.getTipoAmbiente());
/* 1565:1440 */     this.infoTributaria.setTipoEmision(this.emisor.getTipoEmision());
/* 1566:1441 */     this.infoTributaria.setRazonSocial(this.emisor.getRazonSocial());
/* 1567:1442 */     this.infoTributaria.setRuc(this.emisor.getRuc());
/* 1568:1443 */     this.infoTributaria.setCodDoc(TipoComprobanteEnum.GUIA_DE_REMISION.getCode());
/* 1569:1444 */     this.infoTributaria.setEstab(this.emisor.getCodigoEstablecimiento());
/* 1570:1445 */     this.infoTributaria.setPtoEmi(this.emisor.getCodPuntoEmision());
/* 1571:1446 */     this.infoTributaria.setDirMatriz(this.emisor.getDireccionMatriz());
/* 1572:1448 */     if (this.claveDeAcceso != null)
/* 1573:     */     {
/* 1574:1449 */       this.infoTributaria.setClaveAcceso(this.claveDeAcceso);
/* 1575:     */     }
/* 1576:     */     else
/* 1577:     */     {
/* 1578:1451 */       JOptionPane.showMessageDialog(this, "\nLa clave de Acceso no puede ser nula", "Se ha producido un error ", 0);
/* 1579:     */       
/* 1580:1453 */       error = true;
/* 1581:     */     }
/* 1582:1456 */     if ((this.emisor.getNombreComercial() != null) && (!this.emisor.getNombreComercial().isEmpty())) {
/* 1583:1457 */       this.infoTributaria.setNombreComercial(this.emisor.getNombreComercial());
/* 1584:     */     }
/* 1585:1460 */     this.infoGuiaRemision = this.factory.createGuiaRemisionInfoGuiaRemision();
/* 1586:1462 */     if ((this.emisor.getDirEstablecimiento() != null) && (!this.emisor.getDirEstablecimiento().isEmpty())) {
/* 1587:1463 */       this.infoGuiaRemision.setDirEstablecimiento(this.emisor.getDirEstablecimiento());
/* 1588:     */     }
/* 1589:1466 */     if (!this.txtDirecPartida.getText().isEmpty())
/* 1590:     */     {
/* 1591:1467 */       this.infoGuiaRemision.setDirPartida(this.txtDirecPartida.getText());
/* 1592:     */     }
/* 1593:     */     else
/* 1594:     */     {
/* 1595:1469 */       mensajes.append("\nIngrese la dirección de partida del transportista");
/* 1596:1470 */       error = true;
/* 1597:     */     }
/* 1598:1473 */     if (!this.textFechaIni.getText().isEmpty())
/* 1599:     */     {
/* 1600:1474 */       this.infoGuiaRemision.setFechaIniTransporte(this.textFechaIni.getText());
/* 1601:     */     }
/* 1602:     */     else
/* 1603:     */     {
/* 1604:1476 */       mensajes.append("\nIngrese la fecha de inicio del transporte");
/* 1605:1477 */       error = true;
/* 1606:     */     }
/* 1607:1480 */     if ((this.textFechaFin.getText() != null) && (!this.textFechaFin.getText().isEmpty()))
/* 1608:     */     {
/* 1609:     */       try
/* 1610:     */       {
/* 1611:1482 */         Date fin = Constantes.dateFormat.parse(this.textFechaFin.getText());
/* 1612:1483 */         Date ini = Constantes.dateFormat.parse(this.textFechaIni.getText());
/* 1613:1485 */         if (fin.before(ini))
/* 1614:     */         {
/* 1615:1486 */           mensajes.append("La fecha de fin de transporte  no puede ser anterior a la fecha de inicio");
/* 1616:1487 */           error = true;
/* 1617:     */         }
/* 1618:     */         else
/* 1619:     */         {
/* 1620:1489 */           this.infoGuiaRemision.setFechaFinTransporte(this.textFechaFin.getText());
/* 1621:     */         }
/* 1622:     */       }
/* 1623:     */       catch (ParseException ex)
/* 1624:     */       {
/* 1625:1492 */         Logger.getLogger(GuiaRemisionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1626:     */       }
/* 1627:     */     }
/* 1628:     */     else
/* 1629:     */     {
/* 1630:1495 */       mensajes.append("\nIngrese la fecha de fin del transporte");
/* 1631:1496 */       error = true;
/* 1632:     */     }
/* 1633:1516 */     if (this.transportistaSeleccionado != null)
/* 1634:     */     {
/* 1635:1517 */       this.infoGuiaRemision.setRazonSocialTransportista(this.transportistaSeleccionado.getRazonSocial());
/* 1636:1518 */       this.infoGuiaRemision.setRucTransportista(this.transportistaSeleccionado.getIdentificacion());
/* 1637:1519 */       this.infoGuiaRemision.setPlaca(this.txtPlaca.getText());
/* 1638:1520 */       this.infoGuiaRemision.setTipoIdentificacionTransportista(TipoCompradorEnum.retornaCodigo(this.transportistaSeleccionado.getTipoIdentificacion()));
/* 1639:     */     }
/* 1640:     */     else
/* 1641:     */     {
/* 1642:1523 */       mensajes.append("\nSeleccione un Transportista");
/* 1643:1524 */       error = true;
/* 1644:     */     }
/* 1645:1527 */     if ((this.emisor.getContribuyenteEspecial() != null) && (!this.emisor.getContribuyenteEspecial().isEmpty())) {
/* 1646:1528 */       this.infoGuiaRemision.setContribuyenteEspecial(this.emisor.getContribuyenteEspecial());
/* 1647:     */     }
/* 1648:1530 */     if (this.emisor.getLlevaContabilidad() != null) {
/* 1649:1531 */       if (this.emisor.getLlevaContabilidad().equals("S")) {
/* 1650:1532 */         this.infoGuiaRemision.setObligadoContabilidad("SI");
/* 1651:     */       } else {
/* 1652:1534 */         this.infoGuiaRemision.setObligadoContabilidad("NO");
/* 1653:     */       }
/* 1654:     */     }
/* 1655:1538 */     if (error == true) {
/* 1656:1539 */       JOptionPane.showMessageDialog(this, mensajes.toString(), "Se ha producido un error ", 0);
/* 1657:     */     }
/* 1658:1542 */     return error;
/* 1659:     */   }
/* 1660:     */   
/* 1661:     */   private void limpiarFormulario()
/* 1662:     */   {
/* 1663:1546 */     limpiarDestinatario();
/* 1664:1547 */     this.modeloDatosAdicionales.deleteAllRows();
/* 1665:     */     
/* 1666:1549 */     this.txtCedulaTrans.setText(null);
/* 1667:1550 */     this.txtRazonSocTrans.setText(null);
/* 1668:1551 */     this.transportistaSeleccionado = null;
/* 1669:1552 */     this.txtPlaca.setText(null);
/* 1670:1553 */     this.txtDirecPartida.setText(null);
/* 1671:     */     
/* 1672:1555 */     this.btnFirmarProcesar.setEnabled(false);
/* 1673:1556 */     this.btnGuardar.setEnabled(false);
/* 1674:     */   }
/* 1675:     */   
/* 1676:     */   private void limpiarDestinatario()
/* 1677:     */   {
/* 1678:1560 */     this.textNro1.setText(null);
/* 1679:1561 */     this.textNro2.setText(null);
/* 1680:1562 */     this.textNro3.setText(null);
/* 1681:1563 */     this.textFechaEmisionDoc.setText(null);
/* 1682:1564 */     this.jCalendarEmisionDoc.setTargetDate(null);
/* 1683:1565 */     this.txtDocAduanero.setText(null);
/* 1684:1566 */     this.txtCodEstabDest.setText(null);
/* 1685:1567 */     this.txtRuta.setText(null);
/* 1686:1568 */     this.txtMotivoTraslado.setText(null);
/* 1687:1569 */     this.txtDirecDest.setText(null);
/* 1688:     */     
/* 1689:1571 */     this.txtCedulaDest.setText(null);
/* 1690:1572 */     this.txtRazonSocDest.setText(null);
/* 1691:1573 */     this.txtNumAutDoc.setText(null);
/* 1692:1574 */     this.destinatarioSeleccionado = null;
/* 1693:     */   }
/* 1694:     */   
/* 1695:     */   private void btnNuevoDatoActionPerformed(ActionEvent evt)
/* 1696:     */   {
/* 1697:1578 */     this.modeloDatosAdicionales.addRow("", "");
/* 1698:     */   }
/* 1699:     */   
/* 1700:     */   private String validarGuiaRemision()
/* 1701:     */   {
/* 1702:1581 */     if (this.modeloDetalle.getRowCount() <= 0) {
/* 1703:1582 */       return "Debe agregar por lo menos un detalle";
/* 1704:     */     }
/* 1705:1585 */     return null;
/* 1706:     */   }
/* 1707:     */   
/* 1708:     */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 1709:     */   {
/* 1710:1588 */     String respuestaCrear = null;
/* 1711:1589 */     GuiaRemision xmlRespuesta = null;
/* 1712:1590 */     String archivoACrear = null;
/* 1713:     */     try
/* 1714:     */     {
/* 1715:1593 */       if (this.modeloDetalle.getRowCount() > 0)
/* 1716:     */       {
/* 1717:1595 */         xmlRespuesta = generarComprobante();
/* 1718:     */         
/* 1719:1597 */         String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1720:1598 */         archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1721:     */         
/* 1722:     */ 
/* 1723:1601 */         respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, xmlRespuesta, this.claveContingencia, this.secuencial, TipoComprobanteEnum.GUIA_DE_REMISION.getCode());
/* 1724:1603 */         if (respuestaCrear == null) {
/* 1725:1604 */           this.btnFirmarProcesar.setEnabled(false);
/* 1726:     */         }
/* 1727:     */       }
/* 1728:1607 */       visualizar();
/* 1729:     */     }
/* 1730:     */     catch (Exception ex)
/* 1731:     */     {
/* 1732:1609 */       Logger.getLogger(GuiaRemisionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1733:     */     }
/* 1734:     */   }
/* 1735:     */   
/* 1736:     */   private void visualizar()
/* 1737:     */   {
/* 1738:1615 */     String respuesta = null;
/* 1739:1616 */     String archivoACrear = null;
/* 1740:1617 */     GuiaRemision guiaRemision = null;
/* 1741:     */     try
/* 1742:     */     {
/* 1743:1620 */       if (this.modeloDetalle.getRowCount() > 0)
/* 1744:     */       {
/* 1745:1622 */         guiaRemision = generarComprobante();
/* 1746:1623 */         archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + this.claveDeAcceso + ".xml";
/* 1747:1624 */         respuesta = ArchivoUtils.crearArchivoXml2(archivoACrear, guiaRemision, this.claveContingencia, this.secuencial, TipoComprobanteEnum.FACTURA.getCode());
/* 1748:1625 */         if (respuesta == null) {
/* 1749:1626 */           JOptionPane.showMessageDialog(this, archivoACrear, "El comprobante fue guardado exitósamente", 1);
/* 1750:     */         }
/* 1751:1629 */         GuiaRemisionReporte guia = new GuiaRemisionReporte(guiaRemision);
/* 1752:     */         
/* 1753:1631 */         generarReporte(guia, null, null, guiaRemision);
/* 1754:1632 */         this.btnFirmarProcesar.setEnabled(false);
/* 1755:     */       }
/* 1756:     */       else
/* 1757:     */       {
/* 1758:1634 */         JOptionPane.showMessageDialog(this, "Al menos debe añadir un DESTINATARIO en la Guía de Remisión", "COMPROBANTE VACIO", 1);
/* 1759:     */       }
/* 1760:     */     }
/* 1761:     */     catch (Exception ex)
/* 1762:     */     {
/* 1763:1638 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1764:     */     }
/* 1765:     */   }
/* 1766:     */   
/* 1767:     */   public void generarReporte(GuiaRemisionReporte xml, String numAut, String fechaAut, GuiaRemision guiaRemision)
/* 1768:     */   {
/* 1769:1644 */     ReporteUtil repUtil = new ReporteUtil();
/* 1770:     */     try
/* 1771:     */     {
/* 1772:1647 */       repUtil.generarReporte("resources/reportes/guiaRemisionFinal.jasper", xml, numAut, fechaAut, guiaRemision);
/* 1773:     */     }
/* 1774:     */     catch (SQLException ex)
/* 1775:     */     {
/* 1776:1649 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1777:     */     }
/* 1778:     */     catch (ClassNotFoundException ex)
/* 1779:     */     {
/* 1780:1651 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1781:     */     }
/* 1782:     */   }
/* 1783:     */   
/* 1784:     */   private void btnFirmarProcesarActionPerformed(ActionEvent evt)
/* 1785:     */   {
/* 1786:     */     try
/* 1787:     */     {
/* 1788:1657 */       setCursor(Cursor.getPredefinedCursor(3));
/* 1789:1658 */       this.btnFirmarProcesar.setEnabled(false);
/* 1790:1660 */       if (validarElementosComprobante().booleanValue() == true) {
/* 1791:     */         try
/* 1792:     */         {
/* 1793:1662 */           if (FormGenerales.validarUrl(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == null) {
/* 1794:1663 */             validarConexionCreacion();
/* 1795:     */           } else {
/* 1796:1665 */             JOptionPane.showMessageDialog(this, "URL MAL CONFIGURADO", "URL MAL CONFIGURADO", 1);
/* 1797:     */           }
/* 1798:     */         }
/* 1799:     */         catch (Exception ex)
/* 1800:     */         {
/* 1801:1668 */           Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1802:     */         }
/* 1803:     */       } else {
/* 1804:1671 */         JOptionPane.showMessageDialog(this, "Al menos debe añadir un DESTINATARIO en la Guía de Remisión", "COMPROBANTE DE VENTA VACIO", 1);
/* 1805:     */       }
/* 1806:     */     }
/* 1807:     */     catch (Exception ex)
/* 1808:     */     {
/* 1809:1674 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1810:1675 */       JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + ex.getMessage(), "Se ha producido un error ", 0);
/* 1811:     */     }
/* 1812:     */     finally
/* 1813:     */     {
/* 1814:1677 */       setCursor(Cursor.getDefaultCursor());
/* 1815:1678 */       this.btnFirmarProcesar.setEnabled(true);
/* 1816:     */     }
/* 1817:     */   }
/* 1818:     */   
/* 1819:     */   private Boolean validarElementosComprobante()
/* 1820:     */   {
/* 1821:1688 */     boolean resp = false;
/* 1822:1689 */     if (this.modeloDetalle.getRowCount() > 0) {
/* 1823:1690 */       resp = true;
/* 1824:     */     }
/* 1825:1692 */     return Boolean.valueOf(resp);
/* 1826:     */   }
/* 1827:     */   
/* 1828:     */   private void validarConexionCreacion()
/* 1829:     */     throws SQLException, ClassNotFoundException, InterruptedException
/* 1830:     */   {
/* 1831:1704 */     String respuestaCrear = null;
/* 1832:     */     
/* 1833:1706 */     GuiaRemision comprobanteXml = generarComprobante();
/* 1834:1707 */     String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1835:1708 */     String archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1836:1711 */     if (FormGenerales.existConnection(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == true)
/* 1837:     */     {
/* 1838:1712 */       if (this.emisor.getTipoEmision().equals(StringUtil.obtenerTipoEmision(TipoEmisionEnum.CONTINGENCIA.getCode())))
/* 1839:     */       {
/* 1840:1713 */         JOptionPane.showMessageDialog(new JPanel(), "Ya existe conexión se cambiara el tipo de emisión a Normal", "Mensaje", 2);
/* 1841:1714 */         actualizaEmisor();
/* 1842:1715 */         emisionNormal(respuestaCrear, archivoACrear, comprobanteXml, nombreArchivo);
/* 1843:     */       }
/* 1844:     */       else
/* 1845:     */       {
/* 1846:1718 */         emisionNormal(respuestaCrear, archivoACrear, comprobanteXml, nombreArchivo);
/* 1847:     */       }
/* 1848:     */     }
/* 1849:     */     else
/* 1850:     */     {
/* 1851:1722 */       int i = JOptionPane.showConfirmDialog(null, "No existe conexión.\n Desea emitir en contingencia?", "Advertencia", 0);
/* 1852:1723 */       if (i == 0) {
/* 1853:1724 */         emisionContingencia(comprobanteXml, archivoACrear, nombreArchivo);
/* 1854:     */       }
/* 1855:     */     }
/* 1856:     */   }
/* 1857:     */   
/* 1858:     */   private void actualizaEmisor()
/* 1859:     */   {
/* 1860:1730 */     this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.NORMAL.getCode(), this.emisor);
/* 1861:     */   }
/* 1862:     */   
/* 1863:     */   private void emisionContingencia(GuiaRemision comprobanteXml, String archivoACrear, String nombreArchivo)
/* 1864:     */   {
/* 1865:1734 */     if (FormGenerales.verificarClavesContingencia() == true)
/* 1866:     */     {
/* 1867:1735 */       this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.CONTINGENCIA.getCode(), this.emisor);
/* 1868:1736 */       actualizaClaveDeAcceso();
/* 1869:1737 */       comprobanteXml = generarComprobante();
/* 1870:     */       
/* 1871:1739 */       nombreArchivo = this.claveDeAcceso + ".xml";
/* 1872:1740 */       archivoACrear = archivoACrear.substring(0, archivoACrear.lastIndexOf(File.separator)) + File.separator + nombreArchivo;
/* 1873:     */       
/* 1874:     */ 
/* 1875:1743 */       FormGenerales.creaArchivoEnContingencia(archivoACrear, comprobanteXml, nombreArchivo, this.claveContingencia, this.secuencial, this.emisor, TipoComprobanteEnum.GUIA_DE_REMISION.getCode());
/* 1876:     */     }
/* 1877:     */     else
/* 1878:     */     {
/* 1879:1746 */       JOptionPane.showMessageDialog(this, "No se han encontrado claves de contingencia en el Sistema", "Claves no existen", 0);
/* 1880:     */     }
/* 1881:     */   }
/* 1882:     */   
/* 1883:     */   private void emisionNormal(String respuestaCrear, String archivoACrear, GuiaRemision comprobanteXml, String nombreArchivo)
/* 1884:     */   {
/* 1885:     */     try
/* 1886:     */     {
/* 1887:1752 */       respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobanteXml, this.claveContingencia, this.secuencial, TipoComprobanteEnum.GUIA_DE_REMISION.getCode());
/* 1888:1754 */       if (respuestaCrear == null)
/* 1889:     */       {
/* 1890:1755 */         if (((System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) && (this.password == null)) {
/* 1891:1758 */           this.password = FormGenerales.ingresaPassword();
/* 1892:     */         }
/* 1893:1762 */         ArchivoUtils.firmarEnviarAutorizar(this.emisor, archivoACrear, nombreArchivo, this.infoTributaria.getRuc(), this.infoTributaria.getCodDoc(), this.claveDeAcceso, this.password);
/* 1894:     */       }
/* 1895:     */       else
/* 1896:     */       {
/* 1897:1764 */         JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1898:     */       }
/* 1899:     */     }
/* 1900:     */     catch (Exception ex)
/* 1901:     */     {
/* 1902:1769 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1903:     */     }
/* 1904:     */   }
/* 1905:     */   
/* 1906:     */   private void jButton4ActionPerformed(ActionEvent evt)
/* 1907:     */   {
/* 1908:1775 */     inicializarDatos();
/* 1909:1776 */     limpiarFormulario();
/* 1910:1777 */     actualizaClaveDeAcceso();
/* 1911:     */   }
/* 1912:     */   
/* 1913:     */   private void jToggleButton1ActionPerformed(ActionEvent evt)
/* 1914:     */   {
/* 1915:1782 */     this.txtPlaca.setText(null);
/* 1916:1784 */     if (!this.txtCedulaTrans.getText().isEmpty()) {
/* 1917:1785 */       buscarTransportista(this.txtCedulaTrans.getText(), 1);
/* 1918:1786 */     } else if (!this.txtRazonSocTrans.getText().isEmpty()) {
/* 1919:1787 */       buscarTransportista(this.txtRazonSocTrans.getText(), 2);
/* 1920:     */     } else {
/* 1921:1789 */       JOptionPane.showMessageDialog(this, "Ingrese el RUC /CI o pasaporte o la Razón Social", "Ingrese campo", 1);
/* 1922:     */     }
/* 1923:     */   }
/* 1924:     */   
/* 1925:     */   private void txtCodEstabDestKeyPressed(KeyEvent evt)
/* 1926:     */   {
/* 1927:1794 */     if (FormGenerales.validaSoloNumeros(evt, this.txtCodEstabDest) == true) {
/* 1928:1795 */       processKeyEvent(evt);
/* 1929:     */     }
/* 1930:1798 */     if (FormGenerales.validaLongitud(evt, 3, this.txtCodEstabDest) == true) {
/* 1931:1799 */       processKeyEvent(evt);
/* 1932:     */     }
/* 1933:     */   }
/* 1934:     */   
/* 1935:     */   private void txtNumAutDocActionPerformed(ActionEvent evt) {}
/* 1936:     */   
/* 1937:     */   private void txtNumAutDocKeyPressed(KeyEvent evt)
/* 1938:     */   {
/* 1939:1808 */     if (FormGenerales.validaSoloNumeros(evt, this.txtNumAutDoc) == true) {
/* 1940:1809 */       processKeyEvent(evt);
/* 1941:     */     }
/* 1942:1811 */     if (FormGenerales.validaLongitud(evt, 37, this.txtNumAutDoc) == true) {
/* 1943:1812 */       processKeyEvent(evt);
/* 1944:     */     }
/* 1945:     */   }
/* 1946:     */   
/* 1947:     */   private void txtCedulaTransFocusGained(FocusEvent evt) {}
/* 1948:     */   
/* 1949:     */   private void txtRazonSocTransFocusGained(FocusEvent evt) {}
/* 1950:     */   
/* 1951:     */   private void txtRazonSocDestFocusGained(FocusEvent evt) {}
/* 1952:     */   
/* 1953:     */   private void txtDocAduaneroKeyPressed(KeyEvent evt)
/* 1954:     */   {
/* 1955:1829 */     if (FormGenerales.validaSoloNumeros(evt, this.txtDocAduanero) == true) {
/* 1956:1830 */       processKeyEvent(evt);
/* 1957:     */     }
/* 1958:1832 */     if (FormGenerales.validaLongitud(evt, 20, this.txtDocAduanero) == true) {
/* 1959:1833 */       processKeyEvent(evt);
/* 1960:     */     }
/* 1961:     */   }
/* 1962:     */   
/* 1963:     */   private void textNro3FocusLost(FocusEvent evt)
/* 1964:     */   {
/* 1965:1838 */     if (!this.textNro3.getText().isEmpty()) {
/* 1966:1839 */       this.textNro3.setText(String.format("%09d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro3.getText())) }));
/* 1967:     */     }
/* 1968:     */   }
/* 1969:     */   
/* 1970:     */   private void textNro1FocusLost(FocusEvent evt)
/* 1971:     */   {
/* 1972:1844 */     if (!this.textNro1.getText().isEmpty()) {
/* 1973:1845 */       this.textNro1.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro1.getText())) }));
/* 1974:     */     }
/* 1975:     */   }
/* 1976:     */   
/* 1977:     */   private void textNro2FocusLost(FocusEvent evt)
/* 1978:     */   {
/* 1979:1850 */     if (!this.textNro2.getText().isEmpty()) {
/* 1980:1851 */       this.textNro2.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro2.getText())) }));
/* 1981:     */     }
/* 1982:     */   }
/* 1983:     */   
/* 1984:     */   private void btnNuevoDestinActionPerformed(ActionEvent evt)
/* 1985:     */   {
/* 1986:1857 */     this.modeloProductos = new ProductoTableModel();
/* 1987:1858 */     this.modeloProductos = new ProductoTableModel();
/* 1988:1859 */     this.jTableProductos.setModel(this.modeloProductos);
/* 1989:1860 */     TableColumn tc = this.jTableProductos.getColumnModel().getColumn(5);
/* 1990:1861 */     EliminarCellEditor editor = new EliminarCellEditor(this.jTableProductos);
/* 1991:1862 */     tc.setCellEditor(editor);
/* 1992:1863 */     tc.setCellRenderer(new EliminarRenderer(true));
/* 1993:1864 */     this.jTableProductos.setAutoResizeMode(0);
/* 1994:1865 */     setColumnWidthDetalle();
/* 1995:1866 */     limpiarDestinatario();
/* 1996:     */   }
/* 1997:     */   
/* 1998:     */   private void txtDirecPartidaKeyReleased(KeyEvent evt)
/* 1999:     */   {
/* 2000:1871 */     if (FormGenerales.validaTextArea(evt, 300, this.txtDirecPartida) == true) {
/* 2001:1872 */       processKeyEvent(evt);
/* 2002:     */     }
/* 2003:     */   }
/* 2004:     */   
/* 2005:     */   private void txtDirecDestKeyReleased(KeyEvent evt)
/* 2006:     */   {
/* 2007:1877 */     if (FormGenerales.validaTextArea(evt, 300, this.txtDirecDest) == true) {
/* 2008:1878 */       processKeyEvent(evt);
/* 2009:     */     }
/* 2010:     */   }
/* 2011:     */   
/* 2012:     */   private void txtMotivoTrasladoKeyReleased(KeyEvent evt)
/* 2013:     */   {
/* 2014:1883 */     if (FormGenerales.validaTextArea(evt, 300, this.txtMotivoTraslado) == true) {
/* 2015:1884 */       processKeyEvent(evt);
/* 2016:     */     }
/* 2017:     */   }
/* 2018:     */   
/* 2019:     */   private void txtRutaKeyReleased(KeyEvent evt)
/* 2020:     */   {
/* 2021:1889 */     if (FormGenerales.validaTextArea(evt, 300, this.txtRuta) == true) {
/* 2022:1890 */       processKeyEvent(evt);
/* 2023:     */     }
/* 2024:     */   }
/* 2025:     */   
/* 2026:     */   private void txtDirecPartidaKeyPressed(KeyEvent evt)
/* 2027:     */   {
/* 2028:1895 */     FormGenerales.validaTextArea(evt, 300, this.txtDirecPartida);
/* 2029:     */   }
/* 2030:     */   
/* 2031:     */   private void txtDirecDestKeyPressed(KeyEvent evt)
/* 2032:     */   {
/* 2033:1899 */     FormGenerales.validaTextArea(evt, 300, this.txtDirecDest);
/* 2034:     */   }
/* 2035:     */   
/* 2036:     */   private void txtMotivoTrasladoKeyPressed(KeyEvent evt)
/* 2037:     */   {
/* 2038:1903 */     FormGenerales.validaTextArea(evt, 300, this.txtMotivoTraslado);
/* 2039:     */   }
/* 2040:     */   
/* 2041:     */   private void txtRutaKeyPressed(KeyEvent evt)
/* 2042:     */   {
/* 2043:1907 */     FormGenerales.validaTextArea(evt, 300, this.txtRuta);
/* 2044:     */   }
/* 2045:     */   
/* 2046:     */   private void jButton1ActionPerformed(ActionEvent evt)
/* 2047:     */   {
/* 2048:1911 */     Component component = (Component)evt.getSource();
/* 2049:1912 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 2050:1913 */     this.modalTransportista = new DialogoTransportista(frame, true);
/* 2051:1914 */     this.modalTransportista.setLocationRelativeTo(null);
/* 2052:1915 */     this.modalTransportista.setVisible(true);
/* 2053:     */   }
/* 2054:     */   
/* 2055:     */   private void jToggleButton2ActionPerformed(ActionEvent evt)
/* 2056:     */   {
/* 2057:1921 */     if (!this.txtCedulaDest.getText().isEmpty()) {
/* 2058:1921 */       buscarCliente(this.txtCedulaDest.getText(), 1);
/* 2059:1921 */     } else if (!this.txtRazonSocDest.getText().isEmpty()) {
/* 2060:1921 */       buscarCliente(this.txtRazonSocDest.getText(), 2);
/* 2061:     */     } else {
/* 2062:1921 */       JOptionPane.showMessageDialog(this, "Ingrese el RUC /CI o pasaporte o la Razón Social", "Ingrese campo", 1);
/* 2063:     */     }
/* 2064:     */   }
/* 2065:     */   
/* 2066:     */   private void btnAnadirActionPerformed(ActionEvent evt)
/* 2067:     */   {
/* 2068:1924 */     Component component = (Component)evt.getSource();
/* 2069:1925 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 2070:1926 */     this.modalCliente = new DialogoCliente(frame, Boolean.FALSE);
/* 2071:1927 */     this.modalCliente.setSize(841, 573);
/* 2072:1928 */     this.modalCliente.setLocationRelativeTo(null);
/* 2073:1929 */     this.modalCliente.setVisible(true);
/* 2074:     */   }
/* 2075:     */   
/* 2076:     */   private void btnSeleccionProductoActionPerformed(ActionEvent evt)
/* 2077:     */   {
/* 2078:1932 */     Component component = (Component)evt.getSource();
/* 2079:1933 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 2080:1934 */     this.modalProductos = new DialogoProductos(frame, true);
/* 2081:1935 */     this.modalProductos.setTitle("Productos");
/* 2082:1936 */     this.modalProductos.setLocationRelativeTo(null);
/* 2083:1937 */     this.modalProductos.setVisible(true);
/* 2084:     */     
/* 2085:1939 */     Producto seleccionado = this.modalProductos.getProducto();
/* 2086:1940 */     if (seleccionado != null)
/* 2087:     */     {
/* 2088:1941 */       boolean existente = false;
/* 2089:1942 */       boolean tieneImpuestos = false;
/* 2090:1944 */       for (int i = 0; i < this.modeloProductos.getRowCount(); i++)
/* 2091:     */       {
/* 2092:1945 */         String codPrincipal = (String)this.modeloProductos.getValueAt(i, 2);
/* 2093:1946 */         String codAuxiliar = (String)this.modeloProductos.getValueAt(i, 3);
/* 2094:1947 */         String nombre = (String)this.modeloProductos.getValueAt(i, 4);
/* 2095:1948 */         if (seleccionado.verificarProducto(codPrincipal, codAuxiliar, nombre))
/* 2096:     */         {
/* 2097:1949 */           existente = true;
/* 2098:1950 */           break;
/* 2099:     */         }
/* 2100:     */       }
/* 2101:1953 */       if (seleccionado.getImpuestoProducto().isEmpty() == true) {
/* 2102:1954 */         JOptionPane.showMessageDialog(this, "El producto seleccionado, no tiene asignado ningun impuesto,\nfavor edite el producto e ingrese los impuestos", "Se ha producido un error ", 0);
/* 2103:     */       } else {
/* 2104:1957 */         tieneImpuestos = true;
/* 2105:     */       }
/* 2106:1959 */       if ((!existente) && (tieneImpuestos == true)) {
/* 2107:1960 */         this.modeloProductos.addRow(this.modeloProductos.getRowCount() + 1, seleccionado);
/* 2108:1961 */       } else if (existente == true) {
/* 2109:1962 */         JOptionPane.showMessageDialog(this, "El ítem seleccionado ya se encuentra en el detalle de la Factura, favor modifique su cantidad", "Se ha producido un error ", 0);
/* 2110:     */       }
/* 2111:     */     }
/* 2112:     */   }
/* 2113:     */   
/* 2114:     */   private void textNro1KeyPressed(KeyEvent evt)
/* 2115:     */   {
/* 2116:1969 */     if (FormGenerales.validaSoloNumeros(evt, this.textNro1) == true) {
/* 2117:1970 */       processKeyEvent(evt);
/* 2118:     */     }
/* 2119:1972 */     if (FormGenerales.validaLongitud(evt, 3, this.textNro1) == true) {
/* 2120:1973 */       processKeyEvent(evt);
/* 2121:     */     }
/* 2122:     */   }
/* 2123:     */   
/* 2124:     */   private void textNro2KeyPressed(KeyEvent evt)
/* 2125:     */   {
/* 2126:1978 */     if (FormGenerales.validaSoloNumeros(evt, this.textNro2) == true) {
/* 2127:1979 */       processKeyEvent(evt);
/* 2128:     */     }
/* 2129:1981 */     if (FormGenerales.validaLongitud(evt, 3, this.textNro2) == true) {
/* 2130:1982 */       processKeyEvent(evt);
/* 2131:     */     }
/* 2132:     */   }
/* 2133:     */   
/* 2134:     */   private void textNro3KeyPressed(KeyEvent evt)
/* 2135:     */   {
/* 2136:1987 */     if (FormGenerales.validaSoloNumeros(evt, this.textNro3) == true) {
/* 2137:1988 */       processKeyEvent(evt);
/* 2138:     */     }
/* 2139:1990 */     if (FormGenerales.validaLongitud(evt, 9, this.textNro3) == true) {
/* 2140:1991 */       processKeyEvent(evt);
/* 2141:     */     }
/* 2142:     */   }
/* 2143:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.GuiaRemisionView
 * JD-Core Version:    0.7.0.1
 */