/*    1:     */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*    2:     */ 
/*    3:     */ import comprobantesdesktop.ComprobantesDesktopApp;
/*    4:     */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*    5:     */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*    6:     */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*    7:     */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*    8:     */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*    9:     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   10:     */ import ec.gob.sri.comprobantes.modelo.notadebito.Impuesto;
/*   11:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*   12:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoAdicional;
/*   13:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoAdicional.CampoAdicional;
/*   14:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoNotaDebito;
/*   15:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.InfoNotaDebito.Impuestos;
/*   16:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.Motivos;
/*   17:     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito.Motivos.Motivo;
/*   18:     */ import ec.gob.sri.comprobantes.modelo.notadebito.ObjectFactory;
/*   19:     */ import ec.gob.sri.comprobantes.modelo.reportes.NotaDebitoReporte;
/*   20:     */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   21:     */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*   22:     */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   23:     */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   24:     */ import ec.gob.sri.comprobantes.table.model.DatosAdicionalesTableModel;
/*   25:     */ import ec.gob.sri.comprobantes.table.model.EliminarCellEditor;
/*   26:     */ import ec.gob.sri.comprobantes.table.model.EliminarDatoCellEditor;
/*   27:     */ import ec.gob.sri.comprobantes.table.model.EliminarRenderer;
/*   28:     */ import ec.gob.sri.comprobantes.table.model.NotaDebitoTableModel;
/*   29:     */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*   30:     */ import ec.gob.sri.comprobantes.util.Constantes;
/*   31:     */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*   32:     */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*   33:     */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   34:     */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   35:     */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*   36:     */ import ec.gob.sri.comprobantes.util.TipoCompradorEnum;
/*   37:     */ import ec.gob.sri.comprobantes.util.TipoComprobanteEnum;
/*   38:     */ import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
/*   39:     */ import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
/*   40:     */ import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
/*   41:     */ import ec.gob.sri.comprobantes.view.modals.DialogoCliente;
/*   42:     */ import java.awt.Component;
/*   43:     */ import java.awt.Container;
/*   44:     */ import java.awt.Cursor;
/*   45:     */ import java.awt.Dimension;
/*   46:     */ import java.awt.event.ActionEvent;
/*   47:     */ import java.awt.event.ActionListener;
/*   48:     */ import java.awt.event.FocusAdapter;
/*   49:     */ import java.awt.event.FocusEvent;
/*   50:     */ import java.awt.event.KeyAdapter;
/*   51:     */ import java.awt.event.KeyEvent;
/*   52:     */ import java.awt.event.MouseAdapter;
/*   53:     */ import java.awt.event.MouseEvent;
/*   54:     */ import java.beans.PropertyChangeEvent;
/*   55:     */ import java.beans.PropertyChangeListener;
/*   56:     */ import java.io.File;
/*   57:     */ import java.io.PrintStream;
/*   58:     */ import java.math.BigDecimal;
/*   59:     */ import java.math.RoundingMode;
/*   60:     */ import java.sql.SQLException;
/*   61:     */ import java.text.DecimalFormat;
/*   62:     */ import java.text.SimpleDateFormat;
/*   63:     */ import java.util.Date;
/*   64:     */ import java.util.List;
/*   65:     */ import java.util.logging.Level;
/*   66:     */ import java.util.logging.Logger;
/*   67:     */ import javax.accessibility.AccessibleContext;
/*   68:     */ import javax.swing.BorderFactory;
/*   69:     */ import javax.swing.ButtonGroup;
/*   70:     */ import javax.swing.DefaultComboBoxModel;
/*   71:     */ import javax.swing.GroupLayout;
/*   72:     */ import javax.swing.GroupLayout.Alignment;
/*   73:     */ import javax.swing.GroupLayout.ParallelGroup;
/*   74:     */ import javax.swing.GroupLayout.SequentialGroup;
/*   75:     */ import javax.swing.ImageIcon;
/*   76:     */ import javax.swing.JButton;
/*   77:     */ import javax.swing.JComboBox;
/*   78:     */ import javax.swing.JFormattedTextField;
/*   79:     */ import javax.swing.JFrame;
/*   80:     */ import javax.swing.JLabel;
/*   81:     */ import javax.swing.JOptionPane;
/*   82:     */ import javax.swing.JPanel;
/*   83:     */ import javax.swing.JRadioButton;
/*   84:     */ import javax.swing.JScrollPane;
/*   85:     */ import javax.swing.JTable;
/*   86:     */ import javax.swing.JTextField;
/*   87:     */ import javax.swing.JViewport;
/*   88:     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*   89:     */ import javax.swing.SwingUtilities;
/*   90:     */ import javax.swing.table.TableColumn;
/*   91:     */ import javax.swing.table.TableColumnModel;
/*   92:     */ import javax.swing.text.DefaultFormatterFactory;
/*   93:     */ import javax.swing.text.NumberFormatter;
/*   94:     */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*   95:     */ import org.jdesktop.application.Application;
/*   96:     */ import org.jdesktop.application.ApplicationContext;
/*   97:     */ import org.jdesktop.application.ResourceMap;
/*   98:     */ 
/*   99:     */ public final class NotaDeDebitoView
/*  100:     */   extends JPanel
/*  101:     */ {
/*  102:  74 */   private BigDecimal porcentajeIva = BigDecimal.ZERO;
/*  103:  75 */   Long secuencial = null;
/*  104:  76 */   private String secuencialComprobante = null;
/*  105:  77 */   private String razonSocialComprador = null;
/*  106:  78 */   private String identificacionComprador = null;
/*  107:  79 */   private InfoTributaria infoTributaria = null;
/*  108:  80 */   private NotaDebito.InfoNotaDebito infoNotaDebito = null;
/*  109:  81 */   private Emisor emisor = null;
/*  110:  82 */   private String serie = null;
/*  111:  83 */   private String claveDeAcceso = null;
/*  112:     */   private Date fechaEmision;
/*  113:  85 */   private BigDecimal subtotal12 = BigDecimal.ZERO;
/*  114:  86 */   private BigDecimal subtotal0 = BigDecimal.ZERO;
/*  115:  87 */   private BigDecimal subtotalNoObjetoIVA = BigDecimal.ZERO;
/*  116:  88 */   private BigDecimal subtotalExentoIVA = BigDecimal.ZERO;
/*  117:  89 */   private BigDecimal subtotalValorICE = BigDecimal.ZERO;
/*  118:  90 */   private BigDecimal subtotalSinImpuestos = BigDecimal.ZERO;
/*  119:  91 */   private BigDecimal valorIVA = BigDecimal.ZERO;
/*  120:  92 */   private BigDecimal valorTotalComprobante = BigDecimal.ZERO;
/*  121:     */   private Clientes clienteSeleccionado;
/*  122:     */   private ClaveContingencia claveContingencia;
/*  123:     */   private DatosAdicionalesTableModel modeloDatosAdicionales;
/*  124:     */   private NotaDebitoTableModel modeloDetalle;
/*  125:     */   private DialogoCliente modalCliente;
/*  126:  98 */   private ObjectFactory factory = null;
/*  127:  99 */   private String password = null;
/*  128:     */   private JButton btnActualiza0;
/*  129:     */   private JButton btnActualiza12;
/*  130:     */   private JButton btnActualizaExcentoIVA;
/*  131:     */   private JButton btnActualizaNoObjetoIVA;
/*  132:     */   private JButton btnAnadir;
/*  133:     */   private JButton btnBuscar;
/*  134:     */   private JButton btnFirmarProcesar;
/*  135:     */   private JButton btnGuardar;
/*  136:     */   private JButton btnNuevoDato;
/*  137:     */   private JButton btnNuevoDetalle;
/*  138:     */   private JButton btnRecalcular;
/*  139:     */   private Cabecera cabecera1;
/*  140:     */   private JComboBox comboTipoDocModificado;
/*  141:     */   private IdentificacionComprobanteNoGuia idenComprob;
/*  142:     */   private JButton jButton4;
/*  143:     */   private JCalendarButton jCalendarCompModifica;
/*  144:     */   private ButtonGroup jGroupTipoComprador;
/*  145:     */   private JLabel jLabel10;
/*  146:     */   private JLabel jLabel14;
/*  147:     */   private JLabel jLabel16;
/*  148:     */   private JLabel jLabel17;
/*  149:     */   private JLabel jLabel19;
/*  150:     */   private JLabel jLabel20;
/*  151:     */   private JLabel jLabel21;
/*  152:     */   private JLabel jLabel22;
/*  153:     */   private JLabel jLabel23;
/*  154:     */   private JLabel jLabel24;
/*  155:     */   private JLabel jLabel26;
/*  156:     */   private JLabel jLabel27;
/*  157:     */   private JLabel jLabel30;
/*  158:     */   private JScrollPane jScrollPane1;
/*  159:     */   private JScrollPane jScrollPane2;
/*  160:     */   private JTable jTableDatosAdicionales;
/*  161:     */   private JTable jTableDetalleComprobante;
/*  162:     */   private JPanel panAcciones;
/*  163:     */   private JPanel panComprador;
/*  164:     */   private JPanel panDatos;
/*  165:     */   private JPanel panDetalle;
/*  166:     */   private JPanel panDocModif;
/*  167:     */   private JPanel panTotal;
/*  168:     */   private JRadioButton radioConsumidorF;
/*  169:     */   private JRadioButton radioIdentificacion;
/*  170:     */   private JTextField textNro1;
/*  171:     */   private JTextField textNro2;
/*  172:     */   private JTextField textNro3;
/*  173:     */   private JTextField txtCedulaComprador;
/*  174:     */   private JTextField txtCodigoICE;
/*  175:     */   private JTextField txtFechaCompModif;
/*  176:     */   private JTextField txtRazonComprador;
/*  177:     */   private JFormattedTextField txtSubtotal0;
/*  178:     */   private JFormattedTextField txtSubtotal12;
/*  179:     */   private JFormattedTextField txtSubtotalExcentoIVA;
/*  180:     */   private JFormattedTextField txtSubtotalNoObjetoIVA;
/*  181:     */   private JFormattedTextField txtTotalSinImpuestos;
/*  182:     */   private JFormattedTextField txtValorICE;
/*  183:     */   private JFormattedTextField txtValorIva12;
/*  184:     */   private JFormattedTextField txtValorTotal;
/*  185:     */   
/*  186:     */   public NotaDeDebitoView()
/*  187:     */   {
/*  188: 102 */     initComponents();
/*  189: 103 */     inicializarDatos();
/*  190: 104 */     actualizaClaveDeAcceso();
/*  191: 105 */     this.txtValorICE.setText("0.00");
/*  192: 106 */     ListenerUtil lu = new ListenerUtil();
/*  193: 107 */     lu.listenerSolonumerosLongitud(this.textNro1, Integer.valueOf(3));
/*  194: 108 */     lu.listenerSolonumerosLongitud(this.textNro2, Integer.valueOf(3));
/*  195: 109 */     lu.listenerSolonumerosLongitud(this.textNro3, Integer.valueOf(9));
/*  196:     */   }
/*  197:     */   
/*  198:     */   public void inicializarDatos()
/*  199:     */   {
/*  200: 113 */     this.factory = new ObjectFactory();
/*  201: 114 */     this.modeloDatosAdicionales = new DatosAdicionalesTableModel();
/*  202: 115 */     this.jTableDatosAdicionales.setModel(this.modeloDatosAdicionales);
/*  203: 116 */     this.jTableDatosAdicionales.setAutoResizeMode(0);
/*  204: 117 */     TableColumn tc = this.jTableDatosAdicionales.getColumnModel().getColumn(2);
/*  205: 118 */     EliminarDatoCellEditor editord = new EliminarDatoCellEditor(this.jTableDatosAdicionales);
/*  206: 119 */     tc.setCellEditor(editord);
/*  207: 120 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  208: 121 */     setColumnWidthDatosAdicionales();
/*  209:     */     
/*  210: 123 */     this.modeloDetalle = new NotaDebitoTableModel();
/*  211: 124 */     this.jTableDetalleComprobante.setModel(this.modeloDetalle);
/*  212: 125 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(3);
/*  213: 126 */     EliminarCellEditor editor = new EliminarCellEditor(this.jTableDetalleComprobante);
/*  214: 127 */     tc.setCellEditor(editor);
/*  215: 128 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  216: 129 */     this.jTableDetalleComprobante.setAutoResizeMode(0);
/*  217: 130 */     setColumnWidthDetalle();
/*  218:     */     
/*  219:     */ 
/*  220: 133 */     this.jTableDetalleComprobante.addMouseListener(new MouseAdapter()
/*  221:     */     {
/*  222:     */       public void mouseReleased(MouseEvent e)
/*  223:     */       {
/*  224: 137 */         NotaDeDebitoView.this.actualizaCeldaTabla();
/*  225:     */       }
/*  226:     */       
/*  227:     */       public void mouseClicked(MouseEvent e)
/*  228:     */       {
/*  229: 142 */         super.mouseClicked(e);
/*  230: 143 */         NotaDeDebitoView.this.actualizaCeldaTabla();
/*  231:     */       }
/*  232: 146 */     });
/*  233: 147 */     this.jTableDetalleComprobante.addKeyListener(new KeyAdapter()
/*  234:     */     {
/*  235:     */       public void keyTyped(KeyEvent e)
/*  236:     */       {
/*  237: 151 */         super.keyTyped(e);
/*  238: 152 */         NotaDeDebitoView.this.actualizaCeldaTabla();
/*  239:     */       }
/*  240: 156 */     });
/*  241: 157 */     String[] opciones = { "FACTURA" };
/*  242: 158 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(opciones));
/*  243:     */     
/*  244:     */ 
/*  245: 161 */     this.idenComprob.jCalendarFecha.addPropertyChangeListener(new PropertyChangeListener()
/*  246:     */     {
/*  247:     */       public void propertyChange(PropertyChangeEvent evt)
/*  248:     */       {
/*  249: 164 */         NotaDeDebitoView.this.cambioEnBotonDeFecha(evt, 1);
/*  250:     */       }
/*  251: 167 */     });
/*  252: 168 */     this.jCalendarCompModifica.addPropertyChangeListener(new PropertyChangeListener()
/*  253:     */     {
/*  254:     */       public void propertyChange(PropertyChangeEvent evt)
/*  255:     */       {
/*  256: 171 */         NotaDeDebitoView.this.cambioEnBotonDeFecha(evt, 2);
/*  257:     */       }
/*  258:     */     });
/*  259:     */     try
/*  260:     */     {
/*  261: 179 */       ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode());
/*  262: 180 */       if (iv != null)
/*  263:     */       {
/*  264: 181 */         this.porcentajeIva = BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D).setScale(2, RoundingMode.HALF_UP);
/*  265: 182 */         this.secuencial = new ComprobantesSQL().obtenerMaximo(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode());
/*  266: 183 */         this.secuencialComprobante = String.format("%09d", new Object[] { Long.valueOf(this.secuencial.longValue()) });
/*  267: 184 */         llenaDatosEmisor();
/*  268: 185 */         this.idenComprob.lblEstablecimiento.setText(this.emisor.getCodigoEstablecimiento());
/*  269: 186 */         this.idenComprob.lblPunto.setText(this.emisor.getCodPuntoEmision());
/*  270: 187 */         setDate(new Date());
/*  271:     */       }
/*  272:     */     }
/*  273:     */     catch (Exception ex)
/*  274:     */     {
/*  275: 190 */       Logger.getLogger(NotaDeDebitoView.class.getName()).log(Level.SEVERE, null, ex);
/*  276:     */     }
/*  277: 192 */     this.idenComprob.lblNumeroComprobante.setText(this.secuencialComprobante);
/*  278:     */   }
/*  279:     */   
/*  280:     */   private void setColumnWidthDetalle()
/*  281:     */   {
/*  282: 200 */     for (int i = 0; i < this.jTableDetalleComprobante.getColumnModel().getColumnCount(); i++)
/*  283:     */     {
/*  284: 201 */       TableColumn column = this.jTableDetalleComprobante.getColumnModel().getColumn(i);
/*  285: 202 */       if (i == 0) {
/*  286: 203 */         column.setPreferredWidth(85);
/*  287:     */       }
/*  288: 205 */       if (i == 1) {
/*  289: 206 */         column.setPreferredWidth(295);
/*  290:     */       }
/*  291: 208 */       if (i == 2) {
/*  292: 209 */         column.setPreferredWidth(295);
/*  293:     */       }
/*  294: 211 */       if (i == 3) {
/*  295: 212 */         column.setPreferredWidth(105);
/*  296:     */       }
/*  297:     */     }
/*  298:     */   }
/*  299:     */   
/*  300:     */   private void setColumnWidthDatosAdicionales()
/*  301:     */   {
/*  302: 218 */     for (int i = 0; i < this.jTableDatosAdicionales.getColumnModel().getColumnCount(); i++)
/*  303:     */     {
/*  304: 219 */       TableColumn column = this.jTableDatosAdicionales.getColumnModel().getColumn(i);
/*  305: 220 */       if (i == 0) {
/*  306: 221 */         column.setPreferredWidth(100);
/*  307:     */       }
/*  308: 223 */       if (i == 1) {
/*  309: 224 */         column.setPreferredWidth(300);
/*  310:     */       }
/*  311: 226 */       if (i == 2) {
/*  312: 227 */         column.setPreferredWidth(105);
/*  313:     */       }
/*  314:     */     }
/*  315:     */   }
/*  316:     */   
/*  317:     */   private void actualizaCeldaTabla()
/*  318:     */   {
/*  319:     */     try
/*  320:     */     {
/*  321: 238 */       int row = this.jTableDetalleComprobante.getSelectedRow();
/*  322: 239 */       int col = this.jTableDetalleComprobante.getSelectedColumn();
/*  323: 240 */       if (col == 2)
/*  324:     */       {
/*  325: 241 */         Double.parseDouble(this.modeloDetalle.getValueAt(row, col).toString());
/*  326: 242 */         actualizaDetalle();
/*  327:     */       }
/*  328:     */     }
/*  329:     */     catch (Exception ex)
/*  330:     */     {
/*  331: 246 */       Logger.getLogger(NotaDeDebitoView.class.getName()).log(Level.SEVERE, "Error de Casting", ex);
/*  332:     */     }
/*  333:     */   }
/*  334:     */   
/*  335:     */   public void llenaDatosEmisor()
/*  336:     */   {
/*  337: 255 */     this.emisor = FormGenerales.llenaDatosEmisor(this.cabecera1);
/*  338:     */   }
/*  339:     */   
/*  340:     */   public void actualizaDetalle()
/*  341:     */   {
/*  342: 265 */     BigDecimal porcentaje = BigDecimal.ZERO;
/*  343: 266 */     if (this.txtSubtotal12.getValue() != null)
/*  344:     */     {
/*  345: 267 */       this.subtotal12 = BigDecimal.valueOf(((Number)this.txtSubtotal12.getValue()).doubleValue());
/*  346: 268 */       porcentaje = this.porcentajeIva;
/*  347:     */     }
/*  348:     */     else
/*  349:     */     {
/*  350: 270 */       this.subtotal12 = BigDecimal.ZERO;
/*  351:     */     }
/*  352: 273 */     if (this.txtSubtotal0.getValue() != null) {
/*  353: 274 */       this.subtotal0 = BigDecimal.valueOf(((Number)this.txtSubtotal0.getValue()).doubleValue());
/*  354:     */     } else {
/*  355: 276 */       this.subtotal0 = BigDecimal.ZERO;
/*  356:     */     }
/*  357: 279 */     if (this.txtSubtotalNoObjetoIVA.getValue() != null) {
/*  358: 280 */       this.subtotalNoObjetoIVA = BigDecimal.valueOf(((Number)this.txtSubtotalNoObjetoIVA.getValue()).doubleValue());
/*  359:     */     } else {
/*  360: 282 */       this.subtotalNoObjetoIVA = BigDecimal.ZERO;
/*  361:     */     }
/*  362: 284 */     if (this.txtSubtotalExcentoIVA.getValue() != null) {
/*  363: 285 */       this.subtotalExentoIVA = BigDecimal.valueOf(((Number)this.txtSubtotalExcentoIVA.getValue()).doubleValue());
/*  364:     */     } else {
/*  365: 287 */       this.subtotalExentoIVA = BigDecimal.ZERO;
/*  366:     */     }
/*  367: 290 */     this.subtotalSinImpuestos = this.subtotal12.add(this.subtotal0.add(this.subtotalNoObjetoIVA).add(this.subtotalExentoIVA));
/*  368: 291 */     this.valorIVA = this.subtotal12.add(this.subtotalValorICE).multiply(porcentaje).setScale(2, RoundingMode.HALF_UP);
/*  369: 292 */     this.valorTotalComprobante = this.subtotalSinImpuestos.add(this.subtotalValorICE.add(this.valorIVA));
/*  370: 293 */     this.txtTotalSinImpuestos.setValue(this.subtotalSinImpuestos);
/*  371: 294 */     this.txtValorIva12.setValue(this.valorIVA);
/*  372: 295 */     this.txtValorTotal.setValue(this.valorTotalComprobante);
/*  373:     */   }
/*  374:     */   
/*  375:     */   private void cambioEnBotonDeFecha(PropertyChangeEvent evt, int id)
/*  376:     */   {
/*  377: 299 */     if ((evt.getNewValue() instanceof Date)) {
/*  378: 300 */       if (id == 1)
/*  379:     */       {
/*  380: 301 */         setDate((Date)evt.getNewValue());
/*  381: 302 */         actualizaClaveDeAcceso();
/*  382:     */       }
/*  383:     */       else
/*  384:     */       {
/*  385: 304 */         setDateComprobante((Date)evt.getNewValue());
/*  386:     */       }
/*  387:     */     }
/*  388:     */   }
/*  389:     */   
/*  390:     */   private void initComponents()
/*  391:     */   {
/*  392: 318 */     this.jGroupTipoComprador = new ButtonGroup();
/*  393: 319 */     this.panComprador = new JPanel();
/*  394: 320 */     this.radioConsumidorF = new JRadioButton();
/*  395: 321 */     this.radioIdentificacion = new JRadioButton();
/*  396: 322 */     this.jLabel17 = new JLabel();
/*  397: 323 */     this.txtCedulaComprador = new JTextField();
/*  398: 324 */     this.btnBuscar = new JButton();
/*  399: 325 */     this.txtRazonComprador = new JTextField();
/*  400: 326 */     this.btnAnadir = new JButton();
/*  401: 327 */     this.panDetalle = new JPanel();
/*  402: 328 */     this.jScrollPane1 = new JScrollPane();
/*  403: 329 */     this.jTableDetalleComprobante = new JTable();
/*  404: 330 */     this.btnNuevoDetalle = new JButton();
/*  405: 331 */     this.panDatos = new JPanel();
/*  406: 332 */     this.jScrollPane2 = new JScrollPane();
/*  407: 333 */     this.jTableDatosAdicionales = new JTable();
/*  408: 334 */     this.btnNuevoDato = new JButton();
/*  409: 335 */     this.panTotal = new JPanel();
/*  410: 336 */     this.jLabel20 = new JLabel();
/*  411: 337 */     this.jLabel21 = new JLabel();
/*  412: 338 */     this.jLabel22 = new JLabel();
/*  413: 339 */     this.jLabel23 = new JLabel();
/*  414: 340 */     this.jLabel26 = new JLabel();
/*  415: 341 */     this.jLabel27 = new JLabel();
/*  416: 342 */     this.jLabel30 = new JLabel();
/*  417: 343 */     this.btnActualiza12 = new JButton();
/*  418: 344 */     this.btnActualiza0 = new JButton();
/*  419: 345 */     this.btnActualizaNoObjetoIVA = new JButton();
/*  420: 346 */     this.txtValorICE = new JFormattedTextField();
/*  421: 347 */     this.txtSubtotal12 = new JFormattedTextField();
/*  422: 348 */     this.txtSubtotal0 = new JFormattedTextField();
/*  423: 349 */     this.txtSubtotalNoObjetoIVA = new JFormattedTextField();
/*  424: 350 */     this.txtTotalSinImpuestos = new JFormattedTextField();
/*  425: 351 */     this.txtValorIva12 = new JFormattedTextField();
/*  426: 352 */     this.txtValorTotal = new JFormattedTextField();
/*  427: 353 */     this.btnRecalcular = new JButton();
/*  428: 354 */     this.txtCodigoICE = new JTextField();
/*  429: 355 */     this.jLabel10 = new JLabel();
/*  430: 356 */     this.jLabel24 = new JLabel();
/*  431: 357 */     this.txtSubtotalExcentoIVA = new JFormattedTextField();
/*  432: 358 */     this.btnActualizaExcentoIVA = new JButton();
/*  433: 359 */     this.panAcciones = new JPanel();
/*  434: 360 */     this.btnFirmarProcesar = new JButton();
/*  435: 361 */     this.jButton4 = new JButton();
/*  436: 362 */     this.btnGuardar = new JButton();
/*  437: 363 */     this.panDocModif = new JPanel();
/*  438: 364 */     this.jLabel14 = new JLabel();
/*  439: 365 */     this.comboTipoDocModificado = new JComboBox();
/*  440: 366 */     this.jLabel16 = new JLabel();
/*  441: 367 */     this.jLabel19 = new JLabel();
/*  442: 368 */     this.txtFechaCompModif = new JTextField();
/*  443: 369 */     this.textNro1 = new JTextField();
/*  444: 370 */     this.textNro2 = new JTextField();
/*  445: 371 */     this.textNro3 = new JTextField();
/*  446: 372 */     this.jCalendarCompModifica = new JCalendarButton();
/*  447: 373 */     this.cabecera1 = new Cabecera();
/*  448: 374 */     this.idenComprob = new IdentificacionComprobanteNoGuia();
/*  449:     */     
/*  450: 376 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(NotaDeDebitoView.class);
/*  451: 377 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 2, 0, resourceMap.getFont("Form.border.titleFont")));
/*  452: 378 */     setName("Form");
/*  453:     */     
/*  454: 380 */     this.panComprador.setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("panComprador.border.title", new Object[0]), 0, 0, resourceMap.getFont("panComprador.border.titleFont")));
/*  455: 381 */     this.panComprador.setName("panComprador");
/*  456:     */     
/*  457: 383 */     this.jGroupTipoComprador.add(this.radioConsumidorF);
/*  458: 384 */     this.radioConsumidorF.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  459: 385 */     this.radioConsumidorF.setSelected(true);
/*  460: 386 */     this.radioConsumidorF.setText(resourceMap.getString("radioConsumidorF.text", new Object[0]));
/*  461: 387 */     this.radioConsumidorF.setName("radioConsumidorF");
/*  462: 388 */     this.radioConsumidorF.addActionListener(new ActionListener()
/*  463:     */     {
/*  464:     */       public void actionPerformed(ActionEvent evt)
/*  465:     */       {
/*  466: 390 */         NotaDeDebitoView.this.radioConsumidorFActionPerformed(evt);
/*  467:     */       }
/*  468: 393 */     });
/*  469: 394 */     this.jGroupTipoComprador.add(this.radioIdentificacion);
/*  470: 395 */     this.radioIdentificacion.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  471: 396 */     this.radioIdentificacion.setText(resourceMap.getString("radioIdentificacion.text", new Object[0]));
/*  472: 397 */     this.radioIdentificacion.setName("radioIdentificacion");
/*  473: 398 */     this.radioIdentificacion.addActionListener(new ActionListener()
/*  474:     */     {
/*  475:     */       public void actionPerformed(ActionEvent evt)
/*  476:     */       {
/*  477: 400 */         NotaDeDebitoView.this.radioIdentificacionActionPerformed(evt);
/*  478:     */       }
/*  479: 403 */     });
/*  480: 404 */     this.jLabel17.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  481: 405 */     this.jLabel17.setText(resourceMap.getString("jLabel17.text", new Object[0]));
/*  482: 406 */     this.jLabel17.setName("jLabel17");
/*  483:     */     
/*  484: 408 */     this.txtCedulaComprador.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  485: 409 */     this.txtCedulaComprador.setEnabled(false);
/*  486: 410 */     this.txtCedulaComprador.setName("txtCedulaComprador");
/*  487:     */     
/*  488: 412 */     this.btnBuscar.setFont(resourceMap.getFont("btnBuscar.font"));
/*  489: 413 */     this.btnBuscar.setText(resourceMap.getString("btnBuscar.text", new Object[0]));
/*  490: 414 */     this.btnBuscar.setEnabled(false);
/*  491: 415 */     this.btnBuscar.setName("btnBuscar");
/*  492: 416 */     this.btnBuscar.addActionListener(new ActionListener()
/*  493:     */     {
/*  494:     */       public void actionPerformed(ActionEvent evt)
/*  495:     */       {
/*  496: 418 */         NotaDeDebitoView.this.btnBuscarActionPerformed(evt);
/*  497:     */       }
/*  498: 421 */     });
/*  499: 422 */     this.txtRazonComprador.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  500: 423 */     this.txtRazonComprador.setEnabled(false);
/*  501: 424 */     this.txtRazonComprador.setName("txtRazonComprador");
/*  502: 425 */     this.txtRazonComprador.addFocusListener(new FocusAdapter()
/*  503:     */     {
/*  504:     */       public void focusGained(FocusEvent evt)
/*  505:     */       {
/*  506: 427 */         NotaDeDebitoView.this.txtRazonCompradorFocusGained(evt);
/*  507:     */       }
/*  508: 430 */     });
/*  509: 431 */     this.btnAnadir.setFont(resourceMap.getFont("btnAnadir.font"));
/*  510: 432 */     this.btnAnadir.setName("btnAnadir");
/*  511: 433 */     this.btnAnadir.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  512: 434 */     this.btnAnadir.addActionListener(new ActionListener()
/*  513:     */     {
/*  514:     */       public void actionPerformed(ActionEvent evt)
/*  515:     */       {
/*  516: 436 */         NotaDeDebitoView.this.btnAnadirActionPerformed(evt);
/*  517:     */       }
/*  518: 439 */     });
/*  519: 440 */     GroupLayout panCompradorLayout = new GroupLayout(this.panComprador);
/*  520: 441 */     this.panComprador.setLayout(panCompradorLayout);
/*  521: 442 */     panCompradorLayout.setHorizontalGroup(panCompradorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panCompradorLayout.createSequentialGroup().addContainerGap().addGroup(panCompradorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.radioConsumidorF).addGroup(panCompradorLayout.createSequentialGroup().addComponent(this.radioIdentificacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtCedulaComprador, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscar, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAnadir, -2, 25, -2)).addGroup(panCompradorLayout.createSequentialGroup().addComponent(this.jLabel17).addGap(28, 28, 28).addComponent(this.txtRazonComprador, -1, 568, 32767))).addContainerGap()));
/*  522:     */     
/*  523:     */ 
/*  524:     */ 
/*  525:     */ 
/*  526:     */ 
/*  527:     */ 
/*  528:     */ 
/*  529:     */ 
/*  530:     */ 
/*  531:     */ 
/*  532:     */ 
/*  533:     */ 
/*  534:     */ 
/*  535:     */ 
/*  536:     */ 
/*  537:     */ 
/*  538:     */ 
/*  539:     */ 
/*  540:     */ 
/*  541: 462 */     panCompradorLayout.setVerticalGroup(panCompradorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panCompradorLayout.createSequentialGroup().addComponent(this.radioConsumidorF).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panCompradorLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.radioIdentificacion, -2, -1, -2).addComponent(this.txtCedulaComprador, -2, -1, -2).addComponent(this.btnBuscar).addComponent(this.btnAnadir)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panCompradorLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel17).addComponent(this.txtRazonComprador, -2, -1, -2)).addContainerGap(-1, 32767)));
/*  542:     */     
/*  543:     */ 
/*  544:     */ 
/*  545:     */ 
/*  546:     */ 
/*  547:     */ 
/*  548:     */ 
/*  549:     */ 
/*  550:     */ 
/*  551:     */ 
/*  552:     */ 
/*  553:     */ 
/*  554:     */ 
/*  555:     */ 
/*  556:     */ 
/*  557:     */ 
/*  558: 479 */     panCompradorLayout.linkSize(1, new Component[] { this.btnAnadir, this.btnBuscar });
/*  559:     */     
/*  560: 481 */     this.panDetalle.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("panDetalle.border.title", new Object[0])));
/*  561: 482 */     this.panDetalle.setName("panDetalle");
/*  562:     */     
/*  563: 484 */     this.jScrollPane1.setName("jScrollPane1");
/*  564:     */     
/*  565: 486 */     this.jTableDetalleComprobante.setFont(resourceMap.getFont("jTableDetalleComprobante.font"));
/*  566: 487 */     this.jTableDetalleComprobante.setName("jTableDetalleComprobante");
/*  567: 488 */     this.jScrollPane1.setViewportView(this.jTableDetalleComprobante);
/*  568:     */     
/*  569: 490 */     this.btnNuevoDetalle.setFont(resourceMap.getFont("btnNuevoDetalle.font"));
/*  570: 491 */     this.btnNuevoDetalle.setText(resourceMap.getString("btnNuevoDetalle.text", new Object[0]));
/*  571: 492 */     this.btnNuevoDetalle.setName("btnNuevoDetalle");
/*  572: 493 */     this.btnNuevoDetalle.addActionListener(new ActionListener()
/*  573:     */     {
/*  574:     */       public void actionPerformed(ActionEvent evt)
/*  575:     */       {
/*  576: 495 */         NotaDeDebitoView.this.btnNuevoDetalleActionPerformed(evt);
/*  577:     */       }
/*  578: 498 */     });
/*  579: 499 */     GroupLayout panDetalleLayout = new GroupLayout(this.panDetalle);
/*  580: 500 */     this.panDetalle.setLayout(panDetalleLayout);
/*  581: 501 */     panDetalleLayout.setHorizontalGroup(panDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDetalleLayout.createSequentialGroup().addContainerGap().addGroup(panDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 805, 32767).addComponent(this.btnNuevoDetalle)).addContainerGap()));
/*  582:     */     
/*  583:     */ 
/*  584:     */ 
/*  585:     */ 
/*  586:     */ 
/*  587:     */ 
/*  588:     */ 
/*  589:     */ 
/*  590: 510 */     panDetalleLayout.setVerticalGroup(panDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDetalleLayout.createSequentialGroup().addComponent(this.btnNuevoDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 68, 32767).addContainerGap()));
/*  591:     */     
/*  592:     */ 
/*  593:     */ 
/*  594:     */ 
/*  595:     */ 
/*  596:     */ 
/*  597:     */ 
/*  598:     */ 
/*  599: 519 */     this.panDatos.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("panDatos.border.title", new Object[0])));
/*  600: 520 */     this.panDatos.setName("panDatos");
/*  601:     */     
/*  602: 522 */     this.jScrollPane2.setName("jScrollPane2");
/*  603:     */     
/*  604: 524 */     this.jTableDatosAdicionales.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  605: 525 */     this.jTableDatosAdicionales.setName("jTableDatosAdicionales");
/*  606: 526 */     this.jScrollPane2.setViewportView(this.jTableDatosAdicionales);
/*  607:     */     
/*  608: 528 */     this.btnNuevoDato.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  609: 529 */     this.btnNuevoDato.setText(resourceMap.getString("btnNuevoDato.text", new Object[0]));
/*  610: 530 */     this.btnNuevoDato.setName("btnNuevoDato");
/*  611: 531 */     this.btnNuevoDato.addActionListener(new ActionListener()
/*  612:     */     {
/*  613:     */       public void actionPerformed(ActionEvent evt)
/*  614:     */       {
/*  615: 533 */         NotaDeDebitoView.this.btnNuevoDatoActionPerformed(evt);
/*  616:     */       }
/*  617: 536 */     });
/*  618: 537 */     GroupLayout panDatosLayout = new GroupLayout(this.panDatos);
/*  619: 538 */     this.panDatos.setLayout(panDatosLayout);
/*  620: 539 */     panDatosLayout.setHorizontalGroup(panDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDatosLayout.createSequentialGroup().addContainerGap().addGroup(panDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 465, 32767).addComponent(this.btnNuevoDato, -2, 113, -2)).addContainerGap()));
/*  621:     */     
/*  622:     */ 
/*  623:     */ 
/*  624:     */ 
/*  625:     */ 
/*  626:     */ 
/*  627:     */ 
/*  628:     */ 
/*  629: 548 */     panDatosLayout.setVerticalGroup(panDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDatosLayout.createSequentialGroup().addComponent(this.btnNuevoDato).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 72, -2).addContainerGap(-1, 32767)));
/*  630:     */     
/*  631:     */ 
/*  632:     */ 
/*  633:     */ 
/*  634:     */ 
/*  635:     */ 
/*  636:     */ 
/*  637:     */ 
/*  638: 557 */     this.panTotal.setBorder(BorderFactory.createTitledBorder(""));
/*  639: 558 */     this.panTotal.setName("panTotal");
/*  640:     */     
/*  641: 560 */     this.jLabel20.setFont(resourceMap.getFont("jLabel23.font"));
/*  642: 561 */     this.jLabel20.setText(resourceMap.getString("jLabel20.text", new Object[0]));
/*  643: 562 */     this.jLabel20.setName("jLabel20");
/*  644:     */     
/*  645: 564 */     this.jLabel21.setFont(resourceMap.getFont("jLabel23.font"));
/*  646: 565 */     this.jLabel21.setText(resourceMap.getString("jLabel21.text", new Object[0]));
/*  647: 566 */     this.jLabel21.setName("jLabel21");
/*  648:     */     
/*  649: 568 */     this.jLabel22.setFont(resourceMap.getFont("jLabel23.font"));
/*  650: 569 */     this.jLabel22.setText(resourceMap.getString("jLabel22.text", new Object[0]));
/*  651: 570 */     this.jLabel22.setName("jLabel22");
/*  652:     */     
/*  653: 572 */     this.jLabel23.setFont(resourceMap.getFont("jLabel23.font"));
/*  654: 573 */     this.jLabel23.setText(resourceMap.getString("jLabel23.text", new Object[0]));
/*  655: 574 */     this.jLabel23.setName("jLabel23");
/*  656:     */     
/*  657: 576 */     this.jLabel26.setFont(resourceMap.getFont("jLabel23.font"));
/*  658: 577 */     this.jLabel26.setText(resourceMap.getString("jLabel26.text", new Object[0]));
/*  659: 578 */     this.jLabel26.setName("jLabel26");
/*  660:     */     
/*  661: 580 */     this.jLabel27.setFont(resourceMap.getFont("jLabel23.font"));
/*  662: 581 */     this.jLabel27.setText(resourceMap.getString("jLabel27.text", new Object[0]));
/*  663: 582 */     this.jLabel27.setName("jLabel27");
/*  664:     */     
/*  665: 584 */     this.jLabel30.setFont(resourceMap.getFont("jLabel23.font"));
/*  666: 585 */     this.jLabel30.setText(resourceMap.getString("jLabel30.text", new Object[0]));
/*  667: 586 */     this.jLabel30.setName("jLabel30");
/*  668:     */     
/*  669: 588 */     this.btnActualiza12.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  670: 589 */     this.btnActualiza12.setToolTipText(resourceMap.getString("btnActualiza12.toolTipText", new Object[0]));
/*  671: 590 */     this.btnActualiza12.setName("btnActualiza12");
/*  672: 591 */     this.btnActualiza12.addActionListener(new ActionListener()
/*  673:     */     {
/*  674:     */       public void actionPerformed(ActionEvent evt)
/*  675:     */       {
/*  676: 593 */         NotaDeDebitoView.this.btnActualiza12ActionPerformed(evt);
/*  677:     */       }
/*  678: 596 */     });
/*  679: 597 */     this.btnActualiza0.setToolTipText(resourceMap.getString("btnActualiza0.toolTipText", new Object[0]));
/*  680: 598 */     this.btnActualiza0.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  681: 599 */     this.btnActualiza0.setName("btnActualiza0");
/*  682: 600 */     this.btnActualiza0.addActionListener(new ActionListener()
/*  683:     */     {
/*  684:     */       public void actionPerformed(ActionEvent evt)
/*  685:     */       {
/*  686: 602 */         NotaDeDebitoView.this.btnActualiza0ActionPerformed(evt);
/*  687:     */       }
/*  688: 605 */     });
/*  689: 606 */     this.btnActualizaNoObjetoIVA.setToolTipText(resourceMap.getString("btnActualizaNoObjetoIVA.toolTipText", new Object[0]));
/*  690: 607 */     this.btnActualizaNoObjetoIVA.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  691: 608 */     this.btnActualizaNoObjetoIVA.setName("btnActualizaNoObjetoIVA");
/*  692: 609 */     this.btnActualizaNoObjetoIVA.addActionListener(new ActionListener()
/*  693:     */     {
/*  694:     */       public void actionPerformed(ActionEvent evt)
/*  695:     */       {
/*  696: 611 */         NotaDeDebitoView.this.btnActualizaNoObjetoIVAActionPerformed(evt);
/*  697:     */       }
/*  698: 614 */     });
/*  699: 615 */     this.txtValorICE.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  700: 616 */     this.txtValorICE.setToolTipText(resourceMap.getString("txtValorICE.toolTipText", new Object[0]));
/*  701: 617 */     this.txtValorICE.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  702: 618 */     this.txtValorICE.setName("txtValorICE");
/*  703: 619 */     this.txtValorICE.addFocusListener(new FocusAdapter()
/*  704:     */     {
/*  705:     */       public void focusLost(FocusEvent evt)
/*  706:     */       {
/*  707: 621 */         NotaDeDebitoView.this.txtValorICEFocusLost(evt);
/*  708:     */       }
/*  709: 624 */     });
/*  710: 625 */     this.txtSubtotal12.setEditable(false);
/*  711: 626 */     this.txtSubtotal12.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  712: 627 */     this.txtSubtotal12.setToolTipText(resourceMap.getString("txtSubtotal12.toolTipText", new Object[0]));
/*  713: 628 */     this.txtSubtotal12.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  714: 629 */     this.txtSubtotal12.setName("txtSubtotal12");
/*  715:     */     
/*  716: 631 */     this.txtSubtotal0.setEditable(false);
/*  717: 632 */     this.txtSubtotal0.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  718: 633 */     this.txtSubtotal0.setText(resourceMap.getString("txtSubtotal0.text", new Object[0]));
/*  719: 634 */     this.txtSubtotal0.setToolTipText(resourceMap.getString("txtSubtotal0.toolTipText", new Object[0]));
/*  720: 635 */     this.txtSubtotal0.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  721: 636 */     this.txtSubtotal0.setName("txtSubtotal0");
/*  722:     */     
/*  723: 638 */     this.txtSubtotalNoObjetoIVA.setEditable(false);
/*  724: 639 */     this.txtSubtotalNoObjetoIVA.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  725: 640 */     this.txtSubtotalNoObjetoIVA.setText(resourceMap.getString("txtSubtotalNoObjetoIVA.text", new Object[0]));
/*  726: 641 */     this.txtSubtotalNoObjetoIVA.setToolTipText(resourceMap.getString("txtSubtotalNoObjetoIVA.toolTipText", new Object[0]));
/*  727: 642 */     this.txtSubtotalNoObjetoIVA.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  728: 643 */     this.txtSubtotalNoObjetoIVA.setName("txtSubtotalNoObjetoIVA");
/*  729:     */     
/*  730: 645 */     this.txtTotalSinImpuestos.setBorder(null);
/*  731: 646 */     this.txtTotalSinImpuestos.setEditable(false);
/*  732: 647 */     this.txtTotalSinImpuestos.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  733: 648 */     this.txtTotalSinImpuestos.setText(resourceMap.getString("txtTotalSinImpuestos.text", new Object[0]));
/*  734: 649 */     this.txtTotalSinImpuestos.setToolTipText(resourceMap.getString("txtTotalSinImpuestos.toolTipText", new Object[0]));
/*  735: 650 */     this.txtTotalSinImpuestos.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  736: 651 */     this.txtTotalSinImpuestos.setName("txtTotalSinImpuestos");
/*  737:     */     
/*  738: 653 */     this.txtValorIva12.setBorder(null);
/*  739: 654 */     this.txtValorIva12.setEditable(false);
/*  740: 655 */     this.txtValorIva12.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  741: 656 */     this.txtValorIva12.setText(resourceMap.getString("txtValorIva12.text", new Object[0]));
/*  742: 657 */     this.txtValorIva12.setToolTipText(resourceMap.getString("txtValorIva12.toolTipText", new Object[0]));
/*  743: 658 */     this.txtValorIva12.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  744: 659 */     this.txtValorIva12.setName("txtValorIva12");
/*  745:     */     
/*  746: 661 */     this.txtValorTotal.setBorder(null);
/*  747: 662 */     this.txtValorTotal.setEditable(false);
/*  748: 663 */     this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("$#,##0.00"))));
/*  749: 664 */     this.txtValorTotal.setHorizontalAlignment(2);
/*  750: 665 */     this.txtValorTotal.setText(resourceMap.getString("txtValorTotal.text", new Object[0]));
/*  751: 666 */     this.txtValorTotal.setToolTipText(resourceMap.getString("txtValorTotal.toolTipText", new Object[0]));
/*  752: 667 */     this.txtValorTotal.setFont(resourceMap.getFont("txtTotalSinImpuestos.font"));
/*  753: 668 */     this.txtValorTotal.setName("txtValorTotal");
/*  754: 669 */     this.txtValorTotal.setPreferredSize(new Dimension(0, 20));
/*  755:     */     
/*  756: 671 */     this.btnRecalcular.setText(resourceMap.getString("btnRecalcular.text", new Object[0]));
/*  757: 672 */     this.btnRecalcular.setIcon(new ImageIcon("resources/icons/refresh.png"));
/*  758: 673 */     this.btnRecalcular.setToolTipText(resourceMap.getString("btnRecalcular.toolTipText", new Object[0]));
/*  759: 674 */     this.btnRecalcular.setName("btnRecalcular");
/*  760: 675 */     this.btnRecalcular.addActionListener(new ActionListener()
/*  761:     */     {
/*  762:     */       public void actionPerformed(ActionEvent evt)
/*  763:     */       {
/*  764: 677 */         NotaDeDebitoView.this.btnRecalcularActionPerformed(evt);
/*  765:     */       }
/*  766: 680 */     });
/*  767: 681 */     this.txtCodigoICE.setFont(resourceMap.getFont("txtCodigoICE.font"));
/*  768: 682 */     this.txtCodigoICE.setText(resourceMap.getString("txtCodigoICE.text", new Object[0]));
/*  769: 683 */     this.txtCodigoICE.setToolTipText(resourceMap.getString("txtCodigoICE.toolTipText", new Object[0]));
/*  770: 684 */     this.txtCodigoICE.setName("txtCodigoICE");
/*  771:     */     
/*  772: 686 */     this.jLabel10.setFont(resourceMap.getFont("jLabel23.font"));
/*  773: 687 */     this.jLabel10.setText(resourceMap.getString("jLabel10.text", new Object[0]));
/*  774: 688 */     this.jLabel10.setName("jLabel10");
/*  775:     */     
/*  776: 690 */     this.jLabel24.setFont(resourceMap.getFont("jLabel24.font"));
/*  777: 691 */     this.jLabel24.setText(resourceMap.getString("jLabel24.text", new Object[0]));
/*  778: 692 */     this.jLabel24.setName("jLabel24");
/*  779:     */     
/*  780: 694 */     this.txtSubtotalExcentoIVA.setEditable(false);
/*  781: 695 */     this.txtSubtotalExcentoIVA.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
/*  782: 696 */     this.txtSubtotalExcentoIVA.setToolTipText(resourceMap.getString("txtSubtotalExcentoIVA.toolTipText", new Object[0]));
/*  783: 697 */     this.txtSubtotalExcentoIVA.setFont(resourceMap.getFont("txtSubtotalExcentoIVA.font"));
/*  784: 698 */     this.txtSubtotalExcentoIVA.setName("txtSubtotalExcentoIVA");
/*  785:     */     
/*  786: 700 */     this.btnActualizaExcentoIVA.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  787: 701 */     this.btnActualizaExcentoIVA.setToolTipText(resourceMap.getString("btnActualizaExcentoIVA.toolTipText", new Object[0]));
/*  788: 702 */     this.btnActualizaExcentoIVA.setName("btnActualizaExcentoIVA");
/*  789: 703 */     this.btnActualizaExcentoIVA.addActionListener(new ActionListener()
/*  790:     */     {
/*  791:     */       public void actionPerformed(ActionEvent evt)
/*  792:     */       {
/*  793: 705 */         NotaDeDebitoView.this.btnActualizaExcentoIVAActionPerformed(evt);
/*  794:     */       }
/*  795: 708 */     });
/*  796: 709 */     GroupLayout panTotalLayout = new GroupLayout(this.panTotal);
/*  797: 710 */     this.panTotal.setLayout(panTotalLayout);
/*  798: 711 */     panTotalLayout.setHorizontalGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panTotalLayout.createSequentialGroup().addContainerGap().addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panTotalLayout.createSequentialGroup().addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel23).addComponent(this.jLabel21, -1, -1, 32767).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.jLabel22)).addComponent(this.jLabel24, GroupLayout.Alignment.TRAILING, -1, 103, 32767)).addGap(18, 18, 18).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtSubtotalNoObjetoIVA, -1, 109, 32767).addComponent(this.txtSubtotal0, -1, 109, 32767).addComponent(this.txtSubtotal12, -1, 109, 32767).addComponent(this.txtSubtotalExcentoIVA, -1, 110, 32767))).addGroup(GroupLayout.Alignment.TRAILING, panTotalLayout.createSequentialGroup().addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel26).addComponent(this.jLabel30).addComponent(this.jLabel27, GroupLayout.Alignment.TRAILING, -1, 100, 32767)).addGap(18, 18, 18).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtValorICE, -1, 113, 32767).addComponent(this.txtValorIva12, -1, 109, 32767).addComponent(this.txtValorTotal, -1, 109, 32767)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel10, -1, -1, 32767).addComponent(this.btnActualizaNoObjetoIVA, 0, 0, 32767).addComponent(this.btnActualiza12, 0, 0, 32767).addComponent(this.btnActualiza0, -2, 22, 32767).addComponent(this.btnActualizaExcentoIVA, 0, 0, 32767).addComponent(this.btnRecalcular, 0, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCodigoICE, -2, 33, -2).addContainerGap()).addGroup(panTotalLayout.createSequentialGroup().addGap(114, 114, 114).addComponent(this.txtTotalSinImpuestos, -1, 109, 32767).addGap(95, 95, 95)));
/*  799:     */     
/*  800:     */ 
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
/*  811:     */ 
/*  812:     */ 
/*  813:     */ 
/*  814:     */ 
/*  815:     */ 
/*  816:     */ 
/*  817:     */ 
/*  818:     */ 
/*  819:     */ 
/*  820:     */ 
/*  821:     */ 
/*  822:     */ 
/*  823:     */ 
/*  824:     */ 
/*  825:     */ 
/*  826:     */ 
/*  827:     */ 
/*  828:     */ 
/*  829:     */ 
/*  830:     */ 
/*  831:     */ 
/*  832:     */ 
/*  833:     */ 
/*  834:     */ 
/*  835:     */ 
/*  836:     */ 
/*  837:     */ 
/*  838:     */ 
/*  839:     */ 
/*  840:     */ 
/*  841:     */ 
/*  842:     */ 
/*  843:     */ 
/*  844: 757 */     panTotalLayout.linkSize(0, new Component[] { this.txtSubtotal0, this.txtSubtotal12, this.txtSubtotalNoObjetoIVA, this.txtTotalSinImpuestos, this.txtValorIva12, this.txtValorTotal });
/*  845:     */     
/*  846: 759 */     panTotalLayout.linkSize(0, new Component[] { this.jLabel20, this.jLabel21, this.jLabel22, this.jLabel23, this.jLabel26, this.jLabel27, this.jLabel30 });
/*  847:     */     
/*  848: 761 */     panTotalLayout.setVerticalGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panTotalLayout.createSequentialGroup().addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel23, -2, -1, -2).addComponent(this.txtTotalSinImpuestos, -2, 20, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel20).addComponent(this.txtSubtotal12, -2, 20, -2).addComponent(this.btnActualiza12, 0, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel21).addComponent(this.txtSubtotal0, -1, 20, 32767).addComponent(this.btnActualiza0, 0, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel22, -2, -1, -2).addComponent(this.txtSubtotalNoObjetoIVA, -1, 20, 32767).addComponent(this.btnActualizaNoObjetoIVA, 0, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel24, -2, -1, -2).addComponent(this.txtSubtotalExcentoIVA, -2, -1, -2).addComponent(this.btnActualizaExcentoIVA, -2, 22, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel26).addComponent(this.txtValorICE, -2, 20, -2).addComponent(this.txtCodigoICE, -2, -1, -2).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel27).addComponent(this.txtValorIva12, -2, 20, -2)).addGap(9, 9, 9).addGroup(panTotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel30).addComponent(this.txtValorTotal, -2, 20, -2).addComponent(this.btnRecalcular, -2, 23, -2)).addGap(38, 38, 38)));
/*  849:     */     
/*  850:     */ 
/*  851:     */ 
/*  852:     */ 
/*  853:     */ 
/*  854:     */ 
/*  855:     */ 
/*  856:     */ 
/*  857:     */ 
/*  858:     */ 
/*  859:     */ 
/*  860:     */ 
/*  861:     */ 
/*  862:     */ 
/*  863:     */ 
/*  864:     */ 
/*  865:     */ 
/*  866:     */ 
/*  867:     */ 
/*  868:     */ 
/*  869:     */ 
/*  870:     */ 
/*  871:     */ 
/*  872:     */ 
/*  873:     */ 
/*  874:     */ 
/*  875:     */ 
/*  876:     */ 
/*  877:     */ 
/*  878:     */ 
/*  879:     */ 
/*  880:     */ 
/*  881:     */ 
/*  882:     */ 
/*  883:     */ 
/*  884:     */ 
/*  885:     */ 
/*  886:     */ 
/*  887:     */ 
/*  888:     */ 
/*  889:     */ 
/*  890:     */ 
/*  891:     */ 
/*  892: 805 */     panTotalLayout.linkSize(1, new Component[] { this.btnActualiza12, this.txtSubtotal12 });
/*  893:     */     
/*  894: 807 */     panTotalLayout.linkSize(1, new Component[] { this.btnActualiza0, this.txtSubtotal0 });
/*  895:     */     
/*  896: 809 */     panTotalLayout.linkSize(1, new Component[] { this.btnActualizaNoObjetoIVA, this.txtSubtotalNoObjetoIVA });
/*  897:     */     
/*  898: 811 */     this.panAcciones.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("panAcciones.border.title", new Object[0])));
/*  899: 812 */     this.panAcciones.setName("panAcciones");
/*  900:     */     
/*  901: 814 */     this.btnFirmarProcesar.setFont(resourceMap.getFont("btnGuardar.font"));
/*  902: 815 */     this.btnFirmarProcesar.setText(resourceMap.getString("btnFirmarProcesar.text", new Object[0]));
/*  903: 816 */     this.btnFirmarProcesar.setName("btnFirmarProcesar");
/*  904: 817 */     this.btnFirmarProcesar.addActionListener(new ActionListener()
/*  905:     */     {
/*  906:     */       public void actionPerformed(ActionEvent evt)
/*  907:     */       {
/*  908: 819 */         NotaDeDebitoView.this.btnFirmarProcesarActionPerformed(evt);
/*  909:     */       }
/*  910: 822 */     });
/*  911: 823 */     this.jButton4.setFont(resourceMap.getFont("btnGuardar.font"));
/*  912: 824 */     this.jButton4.setText(resourceMap.getString("jButton4.text", new Object[0]));
/*  913: 825 */     this.jButton4.setName("jButton4");
/*  914: 826 */     this.jButton4.addActionListener(new ActionListener()
/*  915:     */     {
/*  916:     */       public void actionPerformed(ActionEvent evt)
/*  917:     */       {
/*  918: 828 */         NotaDeDebitoView.this.jButton4ActionPerformed(evt);
/*  919:     */       }
/*  920: 831 */     });
/*  921: 832 */     this.btnGuardar.setFont(resourceMap.getFont("btnGuardar.font"));
/*  922: 833 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/*  923: 834 */     this.btnGuardar.setName("btnGuardar");
/*  924: 835 */     this.btnGuardar.addActionListener(new ActionListener()
/*  925:     */     {
/*  926:     */       public void actionPerformed(ActionEvent evt)
/*  927:     */       {
/*  928: 837 */         NotaDeDebitoView.this.btnGuardarActionPerformed(evt);
/*  929:     */       }
/*  930: 840 */     });
/*  931: 841 */     GroupLayout panAccionesLayout = new GroupLayout(this.panAcciones);
/*  932: 842 */     this.panAcciones.setLayout(panAccionesLayout);
/*  933: 843 */     panAccionesLayout.setHorizontalGroup(panAccionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panAccionesLayout.createSequentialGroup().addContainerGap().addComponent(this.btnFirmarProcesar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGuardar).addContainerGap(29, 32767)));
/*  934:     */     
/*  935:     */ 
/*  936:     */ 
/*  937:     */ 
/*  938:     */ 
/*  939:     */ 
/*  940:     */ 
/*  941:     */ 
/*  942:     */ 
/*  943:     */ 
/*  944: 854 */     panAccionesLayout.setVerticalGroup(panAccionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panAccionesLayout.createSequentialGroup().addGroup(panAccionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnFirmarProcesar).addComponent(this.btnGuardar).addComponent(this.jButton4)).addContainerGap(-1, 32767)));
/*  945:     */     
/*  946:     */ 
/*  947:     */ 
/*  948:     */ 
/*  949:     */ 
/*  950:     */ 
/*  951:     */ 
/*  952:     */ 
/*  953:     */ 
/*  954: 864 */     this.panDocModif.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("panDocModif.border.title", new Object[0])));
/*  955: 865 */     this.panDocModif.setName("panDocModif");
/*  956:     */     
/*  957: 867 */     this.jLabel14.setFont(resourceMap.getFont("jLabel14.font"));
/*  958: 868 */     this.jLabel14.setText(resourceMap.getString("jLabel14.text", new Object[0]));
/*  959: 869 */     this.jLabel14.setName("jLabel14");
/*  960:     */     
/*  961: 871 */     this.comboTipoDocModificado.setFont(resourceMap.getFont("comboTipoDocModificado.font"));
/*  962: 872 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  963: 873 */     this.comboTipoDocModificado.setToolTipText(resourceMap.getString("comboTipoDocModificado.toolTipText", new Object[0]));
/*  964: 874 */     this.comboTipoDocModificado.setName("comboTipoDocModificado");
/*  965:     */     
/*  966: 876 */     this.jLabel16.setFont(resourceMap.getFont("jLabel14.font"));
/*  967: 877 */     this.jLabel16.setText(resourceMap.getString("jLabel16.text", new Object[0]));
/*  968: 878 */     this.jLabel16.setName("jLabel16");
/*  969:     */     
/*  970: 880 */     this.jLabel19.setFont(resourceMap.getFont("jLabel14.font"));
/*  971: 881 */     this.jLabel19.setText(resourceMap.getString("jLabel19.text", new Object[0]));
/*  972: 882 */     this.jLabel19.setName("jLabel19");
/*  973:     */     
/*  974: 884 */     this.txtFechaCompModif.setEditable(false);
/*  975: 885 */     this.txtFechaCompModif.setFont(resourceMap.getFont("txtFechaCompModif.font"));
/*  976: 886 */     this.txtFechaCompModif.setText(resourceMap.getString("txtFechaCompModif.text", new Object[0]));
/*  977: 887 */     this.txtFechaCompModif.setToolTipText(resourceMap.getString("txtFechaCompModif.toolTipText", new Object[0]));
/*  978: 888 */     this.txtFechaCompModif.setName("txtFechaCompModif");
/*  979:     */     
/*  980: 890 */     this.textNro1.setFont(resourceMap.getFont("txtFechaCompModif.font"));
/*  981: 891 */     this.textNro1.setToolTipText(resourceMap.getString("textNro1.toolTipText", new Object[0]));
/*  982: 892 */     this.textNro1.setName("textNro1");
/*  983: 893 */     this.textNro1.addFocusListener(new FocusAdapter()
/*  984:     */     {
/*  985:     */       public void focusLost(FocusEvent evt)
/*  986:     */       {
/*  987: 895 */         NotaDeDebitoView.this.textNro1FocusLost(evt);
/*  988:     */       }
/*  989: 898 */     });
/*  990: 899 */     this.textNro2.setFont(resourceMap.getFont("txtFechaCompModif.font"));
/*  991: 900 */     this.textNro2.setToolTipText(resourceMap.getString("textNro2.toolTipText", new Object[0]));
/*  992: 901 */     this.textNro2.setName("textNro2");
/*  993: 902 */     this.textNro2.addFocusListener(new FocusAdapter()
/*  994:     */     {
/*  995:     */       public void focusLost(FocusEvent evt)
/*  996:     */       {
/*  997: 904 */         NotaDeDebitoView.this.textNro2FocusLost(evt);
/*  998:     */       }
/*  999: 907 */     });
/* 1000: 908 */     this.textNro3.setFont(resourceMap.getFont("txtFechaCompModif.font"));
/* 1001: 909 */     this.textNro3.setToolTipText(resourceMap.getString("textNro3.toolTipText", new Object[0]));
/* 1002: 910 */     this.textNro3.setName("textNro3");
/* 1003: 911 */     this.textNro3.addFocusListener(new FocusAdapter()
/* 1004:     */     {
/* 1005:     */       public void focusLost(FocusEvent evt)
/* 1006:     */       {
/* 1007: 913 */         NotaDeDebitoView.this.textNro3FocusLost(evt);
/* 1008:     */       }
/* 1009: 916 */     });
/* 1010: 917 */     this.jCalendarCompModifica.setText(resourceMap.getString("jCalendarCompModifica.text", new Object[0]));
/* 1011: 918 */     this.jCalendarCompModifica.setName("jCalendarCompModifica");
/* 1012:     */     
/* 1013: 920 */     GroupLayout panDocModifLayout = new GroupLayout(this.panDocModif);
/* 1014: 921 */     this.panDocModif.setLayout(panDocModifLayout);
/* 1015: 922 */     panDocModifLayout.setHorizontalGroup(panDocModifLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDocModifLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.comboTipoDocModificado, -2, 105, -2).addGap(119, 119, 119).addGroup(panDocModifLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel19).addComponent(this.jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panDocModifLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDocModifLayout.createSequentialGroup().addComponent(this.txtFechaCompModif, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCalendarCompModifica, -2, -1, -2)).addGroup(panDocModifLayout.createSequentialGroup().addComponent(this.textNro1, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textNro2, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textNro3, -2, 121, -2))).addContainerGap(76, 32767)));
/* 1016:     */     
/* 1017:     */ 
/* 1018:     */ 
/* 1019:     */ 
/* 1020:     */ 
/* 1021:     */ 
/* 1022:     */ 
/* 1023:     */ 
/* 1024:     */ 
/* 1025:     */ 
/* 1026:     */ 
/* 1027:     */ 
/* 1028:     */ 
/* 1029:     */ 
/* 1030:     */ 
/* 1031:     */ 
/* 1032:     */ 
/* 1033:     */ 
/* 1034:     */ 
/* 1035:     */ 
/* 1036:     */ 
/* 1037:     */ 
/* 1038:     */ 
/* 1039:     */ 
/* 1040: 947 */     panDocModifLayout.setVerticalGroup(panDocModifLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panDocModifLayout.createSequentialGroup().addGroup(panDocModifLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.comboTipoDocModificado, -2, -1, -2).addComponent(this.jLabel14).addComponent(this.jLabel16).addComponent(this.txtFechaCompModif, -2, -1, -2).addComponent(this.jCalendarCompModifica, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(panDocModifLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.textNro1, -2, -1, -2).addComponent(this.textNro2, -2, -1, -2).addComponent(this.textNro3, -2, -1, -2)).addContainerGap()));
/* 1041:     */     
/* 1042:     */ 
/* 1043:     */ 
/* 1044:     */ 
/* 1045:     */ 
/* 1046:     */ 
/* 1047:     */ 
/* 1048:     */ 
/* 1049:     */ 
/* 1050:     */ 
/* 1051:     */ 
/* 1052:     */ 
/* 1053:     */ 
/* 1054:     */ 
/* 1055:     */ 
/* 1056:     */ 
/* 1057:     */ 
/* 1058: 965 */     this.cabecera1.setMaximumSize(new Dimension(777, 243));
/* 1059: 966 */     this.cabecera1.setMinimumSize(new Dimension(777, 243));
/* 1060: 967 */     this.cabecera1.setName("cabecera1");
/* 1061: 968 */     this.cabecera1.setPreferredSize(new Dimension(777, 243));
/* 1062:     */     
/* 1063: 970 */     this.idenComprob.setName("idenComprob");
/* 1064:     */     
/* 1065: 972 */     GroupLayout layout = new GroupLayout(this);
/* 1066: 973 */     setLayout(layout);
/* 1067: 974 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panComprador, -1, -1, 32767).addComponent(this.idenComprob, -1, 837, 32767).addComponent(this.cabecera1, -1, 837, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panAcciones, -1, -1, 32767).addComponent(this.panDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panTotal, -2, -1, -2).addGap(3, 3, 3)).addComponent(this.panDocModif, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.panDetalle, -1, -1, 32767)).addContainerGap()));
/* 1068:     */     
/* 1069:     */ 
/* 1070:     */ 
/* 1071:     */ 
/* 1072:     */ 
/* 1073:     */ 
/* 1074:     */ 
/* 1075:     */ 
/* 1076:     */ 
/* 1077:     */ 
/* 1078:     */ 
/* 1079:     */ 
/* 1080:     */ 
/* 1081:     */ 
/* 1082:     */ 
/* 1083:     */ 
/* 1084:     */ 
/* 1085:     */ 
/* 1086: 993 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cabecera1, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.idenComprob, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panComprador, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panDocModif, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panDetalle, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panAcciones, -2, -1, -2)).addComponent(this.panTotal, -1, -1, 32767)).addContainerGap()));
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
/* 1108:1015 */     getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName", new Object[0]));
/* 1109:     */   }
/* 1110:     */   
/* 1111:     */   private void btnNuevoDetalleActionPerformed(ActionEvent evt)
/* 1112:     */   {
/* 1113:     */     try
/* 1114:     */     {
/* 1115:1020 */       this.modeloDetalle.addRow(Integer.valueOf(this.modeloDetalle.getRowCount() + 1), "", BigDecimal.ZERO);
/* 1116:     */     }
/* 1117:     */     catch (SQLException ex)
/* 1118:     */     {
/* 1119:1022 */       Logger.getLogger(NotaDeDebitoView.class.getName()).log(Level.SEVERE, null, ex);
/* 1120:     */     }
/* 1121:1024 */     actualizaDetalle();
/* 1122:     */   }
/* 1123:     */   
/* 1124:     */   public void setDate(String dateString)
/* 1125:     */   {
/* 1126:1034 */     Date date = null;
/* 1127:     */     try
/* 1128:     */     {
/* 1129:1036 */       if ((dateString != null) && (dateString.length() > 0)) {
/* 1130:1037 */         date = Constantes.dateFormat.parse(dateString);
/* 1131:     */       }
/* 1132:     */     }
/* 1133:     */     catch (Exception e)
/* 1134:     */     {
/* 1135:1040 */       date = null;
/* 1136:     */     }
/* 1137:1042 */     setDate(date);
/* 1138:     */   }
/* 1139:     */   
/* 1140:     */   public void setDate(Date date)
/* 1141:     */   {
/* 1142:1051 */     String dateString = "";
/* 1143:1052 */     date = FormGenerales.eliminaHora(date);
/* 1144:1053 */     Date hoy = FormGenerales.eliminaHora(new Date());
/* 1145:1054 */     if ((date != null) && ((date.equals(hoy)) || (date.before(hoy))))
/* 1146:     */     {
/* 1147:1055 */       dateString = Constantes.dateFormat.format(date);
/* 1148:1056 */       this.idenComprob.textFechaEmision.setText(dateString);
/* 1149:1057 */       this.idenComprob.jCalendarFecha.setTargetDate(date);
/* 1150:1058 */       this.fechaEmision = date;
/* 1151:     */     }
/* 1152:     */     else
/* 1153:     */     {
/* 1154:1060 */       JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/* 1155:     */     }
/* 1156:     */   }
/* 1157:     */   
/* 1158:     */   public void actualizaClaveDeAcceso()
/* 1159:     */   {
/* 1160:1068 */     this.claveDeAcceso = null;
/* 1161:1069 */     llenaDatosEmisor();
/* 1162:1070 */     this.claveContingencia = new FormGenerales().obtieneClaveDeAcceso(this.secuencialComprobante, this.emisor, this.serie, this.claveDeAcceso, this.fechaEmision, TipoComprobanteEnum.NOTA_DE_DEBITO.getCode());
/* 1163:1073 */     if ((this.claveContingencia.getCodigoComprobante() != null) && (!this.claveContingencia.getCodigoComprobante().isEmpty())) {
/* 1164:1074 */       this.claveDeAcceso = this.claveContingencia.getCodigoComprobante();
/* 1165:     */     }
/* 1166:1076 */     this.idenComprob.lblClaveAcceso.setText(this.claveDeAcceso);
/* 1167:     */   }
/* 1168:     */   
/* 1169:     */   public void setDateComprobante(Date date)
/* 1170:     */   {
/* 1171:1085 */     String dateString = "";
/* 1172:1086 */     date = FormGenerales.eliminaHora(date);
/* 1173:1087 */     Date hoy = FormGenerales.eliminaHora(new Date());
/* 1174:1088 */     if ((date != null) && ((date.equals(hoy)) || (date.before(hoy))))
/* 1175:     */     {
/* 1176:1089 */       dateString = Constantes.dateFormat.format(date);
/* 1177:1090 */       this.txtFechaCompModif.setText(dateString);
/* 1178:1091 */       this.idenComprob.jCalendarFecha.setTargetDate(date);
/* 1179:     */     }
/* 1180:     */     else
/* 1181:     */     {
/* 1182:1093 */       JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/* 1183:     */     }
/* 1184:     */   }
/* 1185:     */   
/* 1186:     */   private void buscarCliente(String cadena, int parametro)
/* 1187:     */   {
/* 1188:1105 */     this.btnFirmarProcesar.setEnabled(false);
/* 1189:1106 */     this.btnGuardar.setEnabled(false);
/* 1190:1107 */     this.modeloDatosAdicionales.deleteAllRows();
/* 1191:     */     try
/* 1192:     */     {
/* 1193:1109 */       if (parametro == 1) {
/* 1194:1110 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(cadena, null, TipoClienteEnum.C);
/* 1195:     */       } else {
/* 1196:1112 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(null, cadena, TipoClienteEnum.C);
/* 1197:     */       }
/* 1198:     */     }
/* 1199:     */     catch (Exception ex)
/* 1200:     */     {
/* 1201:1115 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1202:     */     }
/* 1203:1118 */     if (this.clienteSeleccionado != null)
/* 1204:     */     {
/* 1205:1119 */       this.txtCedulaComprador.setText(this.clienteSeleccionado.getNumeroIdentificacio());
/* 1206:1120 */       this.txtRazonComprador.setText(this.clienteSeleccionado.getApellido());
/* 1207:1122 */       if (!this.clienteSeleccionado.getDireccion().isEmpty()) {
/* 1208:1123 */         this.modeloDatosAdicionales.addRow("Dirección", this.clienteSeleccionado.getDireccion());
/* 1209:     */       }
/* 1210:1125 */       this.modeloDatosAdicionales.addRow("Email", this.clienteSeleccionado.getCorreo());
/* 1211:1126 */       if (this.clienteSeleccionado.getTelefonoConvencional().length() > 1)
/* 1212:     */       {
/* 1213:1127 */         StringBuilder telefono = new StringBuilder(this.clienteSeleccionado.getTelefonoConvencional());
/* 1214:1128 */         if (this.clienteSeleccionado.getExtencion().length() > 1)
/* 1215:     */         {
/* 1216:1129 */           telefono.append(" ext. ");
/* 1217:1130 */           telefono.append(this.clienteSeleccionado.getExtencion());
/* 1218:     */         }
/* 1219:1132 */         this.modeloDatosAdicionales.addRow("Teléfono", telefono.toString());
/* 1220:     */       }
/* 1221:1135 */       this.btnFirmarProcesar.setEnabled(true);
/* 1222:1136 */       this.btnGuardar.setEnabled(true);
/* 1223:     */     }
/* 1224:     */     else
/* 1225:     */     {
/* 1226:1138 */       JOptionPane.showMessageDialog(this, "No existen registros almacenados para el dato buscado", "Se ha producido un error ", 1);
/* 1227:     */     }
/* 1228:     */   }
/* 1229:     */   
/* 1230:     */   private NotaDebito generarComprobante()
/* 1231:     */   {
/* 1232:1148 */     NotaDebito notaDeDebito = null;
/* 1233:1150 */     if (!llenarObjetoComprobante())
/* 1234:     */     {
/* 1235:1151 */       notaDeDebito = this.factory.createNotaDebito();
/* 1236:     */       
/* 1237:1153 */       NotaDebito.InfoNotaDebito.Impuestos impuestos = obtenerImpuestos();
/* 1238:1154 */       NotaDebito.InfoAdicional informacion = generarInformacionAdicional();
/* 1239:1156 */       if (impuestos != null)
/* 1240:     */       {
/* 1241:1157 */         notaDeDebito.setInfoTributaria(this.infoTributaria);
/* 1242:1158 */         this.infoNotaDebito.setImpuestos(impuestos);
/* 1243:1159 */         notaDeDebito.setInfoNotaDebito(this.infoNotaDebito);
/* 1244:1161 */         if (informacion.getCampoAdicional().size() > 0) {
/* 1245:1162 */           notaDeDebito.setInfoAdicional(informacion);
/* 1246:     */         }
/* 1247:1165 */         notaDeDebito.setMotivos(obtenerMotivos());
/* 1248:1166 */         notaDeDebito.setVersion("1.0.0");
/* 1249:1167 */         notaDeDebito.setId("comprobante");
/* 1250:     */       }
/* 1251:     */       else
/* 1252:     */       {
/* 1253:1169 */         notaDeDebito = null;
/* 1254:     */       }
/* 1255:     */     }
/* 1256:1172 */     return notaDeDebito;
/* 1257:     */   }
/* 1258:     */   
/* 1259:     */   NotaDebito.InfoNotaDebito.Impuestos obtenerImpuestos()
/* 1260:     */   {
/* 1261:1183 */     NotaDebito.InfoNotaDebito.Impuestos resultado = this.factory.createNotaDebitoInfoNotaDebitoImpuestos();
/* 1262:     */     
/* 1263:1185 */     boolean error = false;
/* 1264:     */     try
/* 1265:     */     {
/* 1266:1187 */       if (this.subtotalValorICE.intValue() > 0)
/* 1267:     */       {
/* 1268:1188 */         Impuesto i = this.factory.createImpuesto();
/* 1269:1189 */         if (this.txtCodigoICE.getText().isEmpty())
/* 1270:     */         {
/* 1271:1190 */           JOptionPane.showMessageDialog(this, "Ingrese el código ICE correspondiente al impuesto", "Se ha producido un error ", 0);
/* 1272:     */           
/* 1273:1192 */           error = true;
/* 1274:     */         }
/* 1275:     */         else
/* 1276:     */         {
/* 1277:1195 */           ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(this.txtCodigoICE.getText());
/* 1278:1196 */           if (iv != null)
/* 1279:     */           {
/* 1280:1197 */             i.setCodigo(String.valueOf(iv.getCodigoImpuesto()));
/* 1281:1198 */             i.setCodigoPorcentaje(iv.getCodigo());
/* 1282:1199 */             i.setTarifa(BigDecimal.ZERO.setScale(2));
/* 1283:1200 */             i.setBaseImponible(subtotalActivo());
/* 1284:1201 */             i.setValor(this.subtotalValorICE);
/* 1285:     */             
/* 1286:1203 */             resultado.getImpuesto().add(i);
/* 1287:     */           }
/* 1288:     */           else
/* 1289:     */           {
/* 1290:1205 */             JOptionPane.showMessageDialog(this, "El código de ICE ingresado no se encuentra registrado", "Se ha producido un error ", 0);
/* 1291:     */             
/* 1292:1207 */             this.txtCodigoICE.setText(null);
/* 1293:1208 */             this.txtCodigoICE.requestFocus();
/* 1294:1209 */             error = true;
/* 1295:     */           }
/* 1296:     */         }
/* 1297:     */       }
/* 1298:1214 */       if (this.subtotal12.intValue() > 0)
/* 1299:     */       {
/* 1300:1215 */         Impuesto i = this.factory.createImpuesto();
/* 1301:1216 */         ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode());
/* 1302:1217 */         if (iv != null)
/* 1303:     */         {
/* 1304:1218 */           BigDecimal porcentaje = BigDecimal.valueOf(iv.getPorcentaje().doubleValue() / 100.0D).setScale(2, RoundingMode.HALF_UP);
/* 1305:     */           
/* 1306:1220 */           i.setCodigo(String.valueOf(iv.getCodigoImpuesto()));
/* 1307:1221 */           i.setCodigoPorcentaje(iv.getCodigo());
/* 1308:1222 */           i.setTarifa(porcentaje.multiply(BigDecimal.valueOf(100L).setScale(0, RoundingMode.HALF_UP)));
/* 1309:1223 */           i.setBaseImponible(this.subtotal12.add(this.subtotalValorICE));
/* 1310:1224 */           i.setValor(this.subtotal12.add(this.subtotalValorICE).multiply(porcentaje).setScale(2, RoundingMode.HALF_UP));
/* 1311:     */           
/* 1312:1226 */           resultado.getImpuesto().add(i);
/* 1313:     */         }
/* 1314:     */       }
/* 1315:1229 */       if (this.subtotal0.intValue() > 0)
/* 1316:     */       {
/* 1317:1230 */         Impuesto i = this.factory.createImpuesto();
/* 1318:1231 */         ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_0.getCode());
/* 1319:1232 */         if (iv != null)
/* 1320:     */         {
/* 1321:1234 */           i.setCodigo(String.valueOf(iv.getCodigoImpuesto()));
/* 1322:1235 */           i.setCodigoPorcentaje(iv.getCodigo());
/* 1323:1236 */           i.setTarifa(BigDecimal.valueOf(0L).setScale(2, RoundingMode.HALF_UP));
/* 1324:1237 */           i.setBaseImponible(this.subtotal0.add(this.subtotalValorICE));
/* 1325:1238 */           i.setValor(BigDecimal.ZERO);
/* 1326:     */           
/* 1327:1240 */           resultado.getImpuesto().add(i);
/* 1328:     */         }
/* 1329:     */       }
/* 1330:1243 */       if (this.subtotalNoObjetoIVA.intValue() > 0)
/* 1331:     */       {
/* 1332:1244 */         Impuesto i = this.factory.createImpuesto();
/* 1333:1245 */         ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_NO_OBJETO.getCode());
/* 1334:1246 */         if (iv != null)
/* 1335:     */         {
/* 1336:1248 */           i.setCodigo(String.valueOf(iv.getCodigoImpuesto()));
/* 1337:1249 */           i.setCodigoPorcentaje(iv.getCodigo());
/* 1338:1250 */           i.setTarifa(BigDecimal.valueOf(0L).setScale(2, RoundingMode.HALF_UP));
/* 1339:1251 */           i.setBaseImponible(this.subtotalNoObjetoIVA.add(this.subtotalValorICE));
/* 1340:1252 */           i.setValor(BigDecimal.ZERO);
/* 1341:     */           
/* 1342:1254 */           resultado.getImpuesto().add(i);
/* 1343:     */         }
/* 1344:     */       }
/* 1345:1257 */       if (this.subtotalExentoIVA.intValue() > 0)
/* 1346:     */       {
/* 1347:1258 */         Impuesto i = this.factory.createImpuesto();
/* 1348:1259 */         ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_EXCENTO.getCode());
/* 1349:1260 */         if (iv != null)
/* 1350:     */         {
/* 1351:1262 */           i.setCodigo(String.valueOf(iv.getCodigoImpuesto()));
/* 1352:1263 */           i.setCodigoPorcentaje(iv.getCodigo());
/* 1353:1264 */           i.setTarifa(BigDecimal.valueOf(0L).setScale(2, RoundingMode.HALF_UP));
/* 1354:1265 */           i.setBaseImponible(this.subtotalExentoIVA.add(this.subtotalValorICE));
/* 1355:1266 */           i.setValor(BigDecimal.ZERO);
/* 1356:     */           
/* 1357:1268 */           resultado.getImpuesto().add(i);
/* 1358:     */         }
/* 1359:     */       }
/* 1360:     */     }
/* 1361:     */     catch (Exception ex)
/* 1362:     */     {
/* 1363:1272 */       Logger.getLogger(NotaDeDebitoView.class.getName()).log(Level.SEVERE, null, ex);
/* 1364:1273 */       return null;
/* 1365:     */     }
/* 1366:1276 */     if (error == true) {
/* 1367:1277 */       resultado = null;
/* 1368:     */     }
/* 1369:1279 */     return resultado;
/* 1370:     */   }
/* 1371:     */   
/* 1372:     */   BigDecimal subtotalActivo()
/* 1373:     */   {
/* 1374:1284 */     BigDecimal valor = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
/* 1375:1285 */     if (this.subtotal12.intValue() > 0) {
/* 1376:1286 */       valor = this.subtotal12;
/* 1377:1287 */     } else if (this.subtotal0.intValue() > 0) {
/* 1378:1288 */       valor = this.subtotal0;
/* 1379:1289 */     } else if (this.subtotalNoObjetoIVA.intValue() > 0) {
/* 1380:1290 */       valor = this.subtotalNoObjetoIVA;
/* 1381:     */     }
/* 1382:1292 */     return valor;
/* 1383:     */   }
/* 1384:     */   
/* 1385:     */   private NotaDebito.InfoAdicional generarInformacionAdicional()
/* 1386:     */   {
/* 1387:1303 */     NotaDebito.InfoAdicional info = this.factory.createNotaDebitoInfoAdicional();
/* 1388:1305 */     for (int i = 0; i < this.modeloDatosAdicionales.getRowCount(); i++)
/* 1389:     */     {
/* 1390:1306 */       NotaDebito.InfoAdicional.CampoAdicional detalle = new NotaDebito.InfoAdicional.CampoAdicional();
/* 1391:1307 */       detalle.setNombre((String)this.modeloDatosAdicionales.getValueAt(i, 0));
/* 1392:1308 */       detalle.setValue((String)this.modeloDatosAdicionales.getValueAt(i, 1));
/* 1393:     */       
/* 1394:1310 */       info.getCampoAdicional().add(detalle);
/* 1395:     */     }
/* 1396:1312 */     return info;
/* 1397:     */   }
/* 1398:     */   
/* 1399:     */   private NotaDebito.Motivos obtenerMotivos()
/* 1400:     */   {
/* 1401:1316 */     NotaDebito.Motivos resultado = this.factory.createNotaDebitoMotivos();
/* 1402:1318 */     for (int i = 0; i < this.modeloDetalle.getRowCount(); i++)
/* 1403:     */     {
/* 1404:1319 */       NotaDebito.Motivos.Motivo mot = this.factory.createNotaDebitoMotivosMotivo();
/* 1405:1320 */       mot.setRazon((String)this.modeloDetalle.getValueAt(i, 1));
/* 1406:1321 */       mot.setValor(((BigDecimal)this.modeloDetalle.getValueAt(i, 2)).setScale(2, RoundingMode.HALF_UP));
/* 1407:1322 */       resultado.getMotivo().add(mot);
/* 1408:     */     }
/* 1409:1324 */     return resultado;
/* 1410:     */   }
/* 1411:     */   
/* 1412:     */   private String validarCaomposObligatorios()
/* 1413:     */   {
/* 1414:1328 */     StringBuilder mensajes = new StringBuilder();
/* 1415:1329 */     if ((this.txtFechaCompModif.getText() == null) || (this.txtFechaCompModif.getText().isEmpty())) {
/* 1416:1330 */       mensajes.append("\nIngrese la fecha de emisión del comprobante a modificar");
/* 1417:     */     }
/* 1418:1332 */     if ((this.textNro1.getText() == null) || (this.textNro1.getText().isEmpty()) || (this.textNro2.getText() == null) || (this.textNro2.getText().isEmpty()) || (this.textNro3.getText() == null) || (this.textNro3.getText().isEmpty())) {
/* 1419:1335 */       mensajes.append("\nEl número de comprobante es obligatorio y debe ser de 15 caracteres");
/* 1420:     */     }
/* 1421:1337 */     if ((this.modeloDetalle.getRowCount() < 0) || (this.modeloDetalle.getValueAt(0, 1) == null) || (((BigDecimal)this.modeloDetalle.getValueAt(0, 2)).doubleValue() < 0.0D)) {
/* 1422:1339 */       mensajes.append("\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas");
/* 1423:     */     }
/* 1424:1341 */     return mensajes.toString();
/* 1425:     */   }
/* 1426:     */   
/* 1427:     */   private boolean llenarObjetoComprobante()
/* 1428:     */   {
/* 1429:1349 */     StringBuilder mensajes = new StringBuilder();
/* 1430:1350 */     boolean error = false;
/* 1431:1351 */     this.infoTributaria = new InfoTributaria();
/* 1432:     */     
/* 1433:1353 */     this.infoTributaria.setSecuencial(this.secuencialComprobante);
/* 1434:1354 */     this.infoTributaria.setAmbiente(this.emisor.getTipoAmbiente());
/* 1435:1355 */     this.infoTributaria.setTipoEmision(this.emisor.getTipoEmision());
/* 1436:1356 */     this.infoTributaria.setRazonSocial(this.emisor.getRazonSocial());
/* 1437:1357 */     this.infoTributaria.setRuc(this.emisor.getRuc());
/* 1438:1358 */     this.infoTributaria.setCodDoc(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode());
/* 1439:1359 */     this.infoTributaria.setEstab(this.emisor.getCodigoEstablecimiento());
/* 1440:1360 */     this.infoTributaria.setPtoEmi(this.emisor.getCodPuntoEmision());
/* 1441:1361 */     this.infoTributaria.setDirMatriz(this.emisor.getDireccionMatriz());
/* 1442:1363 */     if (this.claveDeAcceso != null)
/* 1443:     */     {
/* 1444:1364 */       this.infoTributaria.setClaveAcceso(this.claveDeAcceso);
/* 1445:     */     }
/* 1446:     */     else
/* 1447:     */     {
/* 1448:1366 */       mensajes.append("\nLa clave de Acceso no puede ser nula");
/* 1449:1367 */       error = true;
/* 1450:     */     }
/* 1451:1370 */     if ((this.emisor.getNombreComercial() != null) && (!this.emisor.getNombreComercial().isEmpty())) {
/* 1452:1371 */       this.infoTributaria.setNombreComercial(this.emisor.getNombreComercial());
/* 1453:     */     }
/* 1454:1374 */     this.infoNotaDebito = this.factory.createNotaDebitoInfoNotaDebito();
/* 1455:1375 */     this.infoNotaDebito.setFechaEmision(Constantes.dateFormat.format(FormGenerales.eliminaHora(this.fechaEmision)));
/* 1456:1377 */     if ((this.emisor.getDirEstablecimiento() != null) && (!this.emisor.getDirEstablecimiento().isEmpty())) {
/* 1457:1378 */       this.infoNotaDebito.setDirEstablecimiento(this.emisor.getDirEstablecimiento());
/* 1458:     */     }
/* 1459:1381 */     if (this.radioConsumidorF.isSelected())
/* 1460:     */     {
/* 1461:1382 */       this.razonSocialComprador = "CONSUMIDOR FINAL";
/* 1462:1383 */       this.infoNotaDebito.setTipoIdentificacionComprador(TipoCompradorEnum.CONSUMIDOR_FINAL.getCode());
/* 1463:1384 */       this.identificacionComprador = "9999999999999";
/* 1464:     */     }
/* 1465:1386 */     else if ((this.radioIdentificacion.isSelected()) && (this.clienteSeleccionado != null))
/* 1466:     */     {
/* 1467:1387 */       this.razonSocialComprador = this.clienteSeleccionado.getApellido();
/* 1468:1388 */       this.identificacionComprador = this.clienteSeleccionado.getNumeroIdentificacio();
/* 1469:1389 */       this.infoNotaDebito.setTipoIdentificacionComprador(TipoCompradorEnum.retornaCodigo(this.clienteSeleccionado.getTipoIdentificacion()));
/* 1470:     */     }
/* 1471:1392 */     this.infoNotaDebito.setIdentificacionComprador(this.identificacionComprador);
/* 1472:1393 */     this.infoNotaDebito.setRazonSocialComprador(this.razonSocialComprador);
/* 1473:1396 */     if (((String)this.comboTipoDocModificado.getSelectedItem()).equals("FACTURA")) {
/* 1474:1397 */       this.infoNotaDebito.setCodDocModificado(TipoComprobanteEnum.FACTURA.getCode());
/* 1475:     */     }
/* 1476:1399 */     this.infoNotaDebito.setNumDocModificado(this.textNro1.getText() + "-" + this.textNro2.getText() + "-" + this.textNro3.getText());
/* 1477:1400 */     this.infoNotaDebito.setFechaEmisionDocSustento(this.txtFechaCompModif.getText());
/* 1478:1401 */     if (!this.txtValorTotal.getText().isEmpty())
/* 1479:     */     {
/* 1480:1402 */       this.infoNotaDebito.setTotalSinImpuestos(this.subtotalSinImpuestos);
/* 1481:1403 */       this.infoNotaDebito.setValorTotal(this.valorTotalComprobante);
/* 1482:     */     }
/* 1483:     */     else
/* 1484:     */     {
/* 1485:1405 */       mensajes.append("\nNo se ha calculado el Valor Total del comprobante");
/* 1486:1406 */       error = true;
/* 1487:     */     }
/* 1488:1408 */     if ((this.emisor.getContribuyenteEspecial() != null) && (!this.emisor.getContribuyenteEspecial().isEmpty())) {
/* 1489:1409 */       this.infoNotaDebito.setContribuyenteEspecial(this.emisor.getContribuyenteEspecial());
/* 1490:     */     }
/* 1491:1411 */     if (this.emisor.getLlevaContabilidad() != null) {
/* 1492:1412 */       if (this.emisor.getLlevaContabilidad().equals("S")) {
/* 1493:1413 */         this.infoNotaDebito.setObligadoContabilidad("SI");
/* 1494:     */       } else {
/* 1495:1415 */         this.infoNotaDebito.setObligadoContabilidad("NO");
/* 1496:     */       }
/* 1497:     */     }
/* 1498:1419 */     if (error == true) {
/* 1499:1420 */       JOptionPane.showMessageDialog(this, mensajes.toString(), "Se ha producido un error ", 0);
/* 1500:     */     }
/* 1501:1423 */     return error;
/* 1502:     */   }
/* 1503:     */   
/* 1504:     */   private void habilitaCamposCliente()
/* 1505:     */   {
/* 1506:1427 */     this.txtCedulaComprador.setText(null);
/* 1507:1428 */     this.txtRazonComprador.setText(null);
/* 1508:1429 */     this.txtCedulaComprador.setEnabled(true);
/* 1509:1430 */     this.txtRazonComprador.setEnabled(true);
/* 1510:1431 */     this.btnBuscar.setEnabled(true);
/* 1511:1432 */     this.btnFirmarProcesar.setEnabled(false);
/* 1512:1433 */     this.btnGuardar.setEnabled(false);
/* 1513:     */   }
/* 1514:     */   
/* 1515:     */   private void limpiaDatosCliente()
/* 1516:     */   {
/* 1517:1437 */     this.txtCedulaComprador.setText(null);
/* 1518:1438 */     this.txtRazonComprador.setText(null);
/* 1519:1439 */     this.txtCedulaComprador.setEnabled(false);
/* 1520:1440 */     this.txtRazonComprador.setEnabled(false);
/* 1521:1441 */     this.btnBuscar.setEnabled(false);
/* 1522:1442 */     this.modeloDatosAdicionales.deleteAllRows();
/* 1523:1443 */     this.btnFirmarProcesar.setEnabled(true);
/* 1524:1444 */     this.btnGuardar.setEnabled(true);
/* 1525:     */   }
/* 1526:     */   
/* 1527:     */   private void btnNuevoDatoActionPerformed(ActionEvent evt)
/* 1528:     */   {
/* 1529:1448 */     this.modeloDatosAdicionales.addRow("", "");
/* 1530:     */   }
/* 1531:     */   
/* 1532:     */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 1533:     */   {
/* 1534:1452 */     String respuestaCrear = null;
/* 1535:1453 */     String archivoACrear = null;
/* 1536:1454 */     NotaDebito notaDebitoLlena = null;
/* 1537:     */     try
/* 1538:     */     {
/* 1539:1456 */       if ((validarCaomposObligatorios() == null) || (validarCaomposObligatorios().isEmpty()))
/* 1540:     */       {
/* 1541:1457 */         notaDebitoLlena = generarComprobante();
/* 1542:1458 */         String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1543:1459 */         archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1544:1460 */         respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, notaDebitoLlena, this.claveContingencia, this.secuencial, TipoComprobanteEnum.NOTA_DE_DEBITO.getCode());
/* 1545:1463 */         if (respuestaCrear == null)
/* 1546:     */         {
/* 1547:1464 */           JOptionPane.showMessageDialog(this, archivoACrear, "El comprobante fue guardado exitósamente", 1);
/* 1548:     */           
/* 1549:1466 */           NotaDebitoReporte nd = new NotaDebitoReporte(notaDebitoLlena);
/* 1550:1467 */           generarReporte(nd, null, null);
/* 1551:1468 */           this.btnFirmarProcesar.setEnabled(false);
/* 1552:     */         }
/* 1553:     */         else
/* 1554:     */         {
/* 1555:1470 */           JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1556:     */         }
/* 1557:     */       }
/* 1558:     */       else
/* 1559:     */       {
/* 1560:1473 */         JOptionPane.showMessageDialog(this, validarCaomposObligatorios(), "COMPROBANTE DE VENTA VACIO", 1);
/* 1561:     */       }
/* 1562:     */     }
/* 1563:     */     catch (Exception ex)
/* 1564:     */     {
/* 1565:1476 */       Logger.getLogger(NotaDeDebitoView.class.getName()).log(Level.SEVERE, null, ex);
/* 1566:     */     }
/* 1567:     */   }
/* 1568:     */   
/* 1569:     */   public void generarReporte(NotaDebitoReporte xml, String numAut, String fechaAut)
/* 1570:     */   {
/* 1571:1481 */     ReporteUtil repUtil = new ReporteUtil();
/* 1572:     */     try
/* 1573:     */     {
/* 1574:1483 */       repUtil.generarReporte("resources/reportes/notaDebitoFinal.jasper", xml, numAut, fechaAut);
/* 1575:     */     }
/* 1576:     */     catch (SQLException ex)
/* 1577:     */     {
/* 1578:1485 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1579:     */     }
/* 1580:     */     catch (ClassNotFoundException ex)
/* 1581:     */     {
/* 1582:1487 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1583:     */     }
/* 1584:     */   }
/* 1585:     */   
/* 1586:     */   private void btnActualiza12ActionPerformed(ActionEvent evt)
/* 1587:     */   {
/* 1588:1492 */     if (this.modeloDetalle.getRowCount() > 0)
/* 1589:     */     {
/* 1590:1493 */       this.txtSubtotal12.setValue(this.modeloDetalle.getTotalIva());
/* 1591:1494 */       this.txtSubtotal0.setValue(null);
/* 1592:1495 */       this.subtotal0 = BigDecimal.ZERO;
/* 1593:1496 */       this.txtSubtotalNoObjetoIVA.setValue(null);
/* 1594:1497 */       this.subtotalNoObjetoIVA = BigDecimal.ZERO;
/* 1595:1498 */       this.txtSubtotalExcentoIVA.setValue(null);
/* 1596:1499 */       this.subtotalExentoIVA = BigDecimal.ZERO;
/* 1597:1500 */       actualizaDetalle();
/* 1598:     */     }
/* 1599:     */   }
/* 1600:     */   
/* 1601:     */   private void btnActualiza0ActionPerformed(ActionEvent evt)
/* 1602:     */   {
/* 1603:1505 */     if (this.modeloDetalle.getRowCount() > 0)
/* 1604:     */     {
/* 1605:1506 */       this.txtSubtotal0.setValue(this.modeloDetalle.getTotalIva());
/* 1606:1507 */       this.subtotal0 = BigDecimal.valueOf(((Number)this.txtSubtotal0.getValue()).doubleValue());
/* 1607:1508 */       this.txtSubtotal12.setValue(null);
/* 1608:1509 */       this.subtotal12 = BigDecimal.ZERO;
/* 1609:1510 */       this.txtSubtotalNoObjetoIVA.setValue(null);
/* 1610:1511 */       this.subtotalNoObjetoIVA = BigDecimal.ZERO;
/* 1611:1512 */       this.txtSubtotalExcentoIVA.setValue(null);
/* 1612:1513 */       this.subtotalExentoIVA = BigDecimal.ZERO;
/* 1613:1514 */       actualizaDetalle();
/* 1614:     */     }
/* 1615:     */   }
/* 1616:     */   
/* 1617:     */   private void btnActualizaNoObjetoIVAActionPerformed(ActionEvent evt)
/* 1618:     */   {
/* 1619:1519 */     if (this.modeloDetalle.getRowCount() > 0)
/* 1620:     */     {
/* 1621:1520 */       this.txtSubtotalNoObjetoIVA.setValue(this.modeloDetalle.getTotalIva());
/* 1622:1521 */       this.subtotalNoObjetoIVA = BigDecimal.valueOf(((Number)this.txtSubtotalNoObjetoIVA.getValue()).doubleValue());
/* 1623:1522 */       this.txtSubtotal12.setValue(null);
/* 1624:1523 */       this.subtotal12 = BigDecimal.ZERO;
/* 1625:1524 */       this.txtSubtotal0.setValue(null);
/* 1626:1525 */       this.subtotal0 = BigDecimal.ZERO;
/* 1627:1526 */       this.txtSubtotalExcentoIVA.setValue(null);
/* 1628:1527 */       this.subtotalExentoIVA = BigDecimal.ZERO;
/* 1629:1528 */       actualizaDetalle();
/* 1630:     */     }
/* 1631:     */   }
/* 1632:     */   
/* 1633:     */   private void recalcular()
/* 1634:     */   {
/* 1635:1533 */     if (this.txtValorICE.getValue() != null) {
/* 1636:1534 */       this.subtotalValorICE = BigDecimal.valueOf(((Number)this.txtValorICE.getValue()).doubleValue());
/* 1637:     */     }
/* 1638:1536 */     actualizaDetalle();
/* 1639:1537 */     this.btnGuardar.setEnabled(true);
/* 1640:1538 */     this.btnFirmarProcesar.setEnabled(true);
/* 1641:     */   }
/* 1642:     */   
/* 1643:     */   private void btnRecalcularActionPerformed(ActionEvent evt)
/* 1644:     */   {
/* 1645:1542 */     recalcular();
/* 1646:     */   }
/* 1647:     */   
/* 1648:     */   private void txtValorICEFocusLost(FocusEvent evt)
/* 1649:     */   {
/* 1650:1546 */     System.out.println("----" + this.txtValorICE.getText());
/* 1651:1547 */     if ((this.txtValorICE.getText() != null) && (this.txtValorICE.getText().equals(""))) {
/* 1652:1548 */       this.txtValorICE.setText("0.00");
/* 1653:     */     }
/* 1654:1550 */     this.btnGuardar.setEnabled(false);
/* 1655:1551 */     this.btnFirmarProcesar.setEnabled(false);
/* 1656:     */   }
/* 1657:     */   
/* 1658:     */   private void btnFirmarProcesarActionPerformed(ActionEvent evt)
/* 1659:     */   {
/* 1660:     */     try
/* 1661:     */     {
/* 1662:1556 */       setCursor(Cursor.getPredefinedCursor(3));
/* 1663:1557 */       this.btnFirmarProcesar.setEnabled(false);
/* 1664:1558 */       if (validarElementosComprobante().booleanValue() == true)
/* 1665:     */       {
/* 1666:1559 */         if (FormGenerales.validarUrl(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == null) {
/* 1667:1560 */           validarConexionCreacion();
/* 1668:     */         } else {
/* 1669:1562 */           JOptionPane.showMessageDialog(this, "URL MAL CONFIGURADO", "URL MAL CONFIGURADO", 1);
/* 1670:     */         }
/* 1671:     */       }
/* 1672:     */       else {
/* 1673:1565 */         JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE DE VENTA VACIO", 1);
/* 1674:     */       }
/* 1675:     */     }
/* 1676:     */     catch (Exception ex)
/* 1677:     */     {
/* 1678:1569 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1679:1570 */       JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + ex.getMessage(), "Se ha producido un error ", 0);
/* 1680:     */     }
/* 1681:     */     finally
/* 1682:     */     {
/* 1683:1572 */       setCursor(Cursor.getDefaultCursor());
/* 1684:1573 */       this.btnFirmarProcesar.setEnabled(true);
/* 1685:     */     }
/* 1686:     */   }
/* 1687:     */   
/* 1688:     */   private Boolean validarElementosComprobante()
/* 1689:     */   {
/* 1690:1583 */     boolean resp = false;
/* 1691:1584 */     if (this.modeloDetalle.getRowCount() > 0) {
/* 1692:1585 */       resp = true;
/* 1693:     */     }
/* 1694:1587 */     return Boolean.valueOf(resp);
/* 1695:     */   }
/* 1696:     */   
/* 1697:     */   private void validarConexionCreacion()
/* 1698:     */     throws SQLException, ClassNotFoundException, InterruptedException
/* 1699:     */   {
/* 1700:1601 */     String respuestaCrear = null;
/* 1701:     */     
/* 1702:1603 */     NotaDebito notaDebitoLlena = generarComprobante();
/* 1703:1604 */     String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1704:1605 */     String archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1705:1608 */     if (FormGenerales.existConnection(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == true)
/* 1706:     */     {
/* 1707:1609 */       if (this.emisor.getTipoEmision().equals(StringUtil.obtenerTipoEmision(TipoEmisionEnum.CONTINGENCIA.getCode())))
/* 1708:     */       {
/* 1709:1610 */         JOptionPane.showMessageDialog(new JPanel(), "Ya existe conexión se cambiara el tipo de emisión a Normal", "Mensaje", 2);
/* 1710:1611 */         actualizaEmisor();
/* 1711:1612 */         emisionNormal(respuestaCrear, archivoACrear, notaDebitoLlena, nombreArchivo);
/* 1712:     */       }
/* 1713:     */       else
/* 1714:     */       {
/* 1715:1614 */         emisionNormal(respuestaCrear, archivoACrear, notaDebitoLlena, nombreArchivo);
/* 1716:     */       }
/* 1717:     */     }
/* 1718:     */     else
/* 1719:     */     {
/* 1720:1618 */       int i = JOptionPane.showConfirmDialog(null, "No existe conexión.\n Desea emitir en contingencia?", "Advertencia", 0);
/* 1721:1619 */       if (i == 0) {
/* 1722:1620 */         emisionContingencia(notaDebitoLlena, archivoACrear, nombreArchivo);
/* 1723:     */       }
/* 1724:     */     }
/* 1725:     */   }
/* 1726:     */   
/* 1727:     */   private void actualizaEmisor()
/* 1728:     */   {
/* 1729:1626 */     this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.NORMAL.getCode(), this.emisor);
/* 1730:     */   }
/* 1731:     */   
/* 1732:     */   private void emisionContingencia(NotaDebito comprobanteXml, String archivoACrear, String nombreArchivo)
/* 1733:     */   {
/* 1734:1630 */     if (FormGenerales.verificarClavesContingencia() == true)
/* 1735:     */     {
/* 1736:1631 */       this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.CONTINGENCIA.getCode(), this.emisor);
/* 1737:1632 */       actualizaClaveDeAcceso();
/* 1738:1633 */       comprobanteXml = generarComprobante();
/* 1739:     */       
/* 1740:1635 */       nombreArchivo = this.claveDeAcceso + ".xml";
/* 1741:1636 */       archivoACrear = archivoACrear.substring(0, archivoACrear.lastIndexOf(File.separator)) + File.separator + nombreArchivo;
/* 1742:     */       
/* 1743:     */ 
/* 1744:1639 */       FormGenerales.creaArchivoEnContingencia(archivoACrear, comprobanteXml, nombreArchivo, this.claveContingencia, this.secuencial, this.emisor, TipoComprobanteEnum.NOTA_DE_DEBITO.getCode());
/* 1745:     */     }
/* 1746:     */     else
/* 1747:     */     {
/* 1748:1642 */       JOptionPane.showMessageDialog(this, "No se han encontrado claves de contingencia en el Sistema", "Claves no existen", 0);
/* 1749:     */     }
/* 1750:     */   }
/* 1751:     */   
/* 1752:     */   private void emisionNormal(String respuestaCrear, String archivoACrear, NotaDebito comprobanteXml, String nombreArchivo)
/* 1753:     */   {
/* 1754:     */     try
/* 1755:     */     {
/* 1756:1649 */       respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobanteXml, this.claveContingencia, this.secuencial, TipoComprobanteEnum.NOTA_DE_DEBITO.getCode());
/* 1757:1651 */       if (respuestaCrear == null)
/* 1758:     */       {
/* 1759:1652 */         if (((System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) && (this.password == null)) {
/* 1760:1655 */           this.password = FormGenerales.ingresaPassword();
/* 1761:     */         }
/* 1762:1659 */         ArchivoUtils.firmarEnviarAutorizar(this.emisor, archivoACrear, nombreArchivo, this.infoTributaria.getRuc(), this.infoTributaria.getCodDoc(), this.claveDeAcceso, this.password);
/* 1763:     */       }
/* 1764:     */       else
/* 1765:     */       {
/* 1766:1661 */         JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1767:     */       }
/* 1768:     */     }
/* 1769:     */     catch (Exception ex)
/* 1770:     */     {
/* 1771:1664 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1772:     */     }
/* 1773:     */   }
/* 1774:     */   
/* 1775:     */   private void obtenerInstancia(Container c)
/* 1776:     */   {
/* 1777:1670 */     if ((c instanceof JFrame))
/* 1778:     */     {
/* 1779:1671 */       System.out.println("ENTRA");
/* 1780:1672 */       JFrame f = (JFrame)c;
/* 1781:1673 */       f.getContentPane().removeAll();
/* 1782:1674 */       JScrollPane jp = new JScrollPane();
/* 1783:1675 */       jp.getViewport().add(new NotaDeDebitoView());
/* 1784:1676 */       f.getContentPane().add(jp);
/* 1785:1677 */       f.validate();
/* 1786:1678 */       f.repaint();
/* 1787:     */     }
/* 1788:     */     else
/* 1789:     */     {
/* 1790:1680 */       obtenerInstancia(c.getParent());
/* 1791:     */     }
/* 1792:     */   }
/* 1793:     */   
/* 1794:     */   private void jButton4ActionPerformed(ActionEvent evt)
/* 1795:     */   {
/* 1796:1685 */     Container c = this.jButton4.getParent();
/* 1797:1686 */     obtenerInstancia(c);
/* 1798:     */   }
/* 1799:     */   
/* 1800:     */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 1801:     */   {
/* 1802:1691 */     if (!this.txtCedulaComprador.getText().isEmpty()) {
/* 1803:1692 */       buscarCliente(this.txtCedulaComprador.getText(), 1);
/* 1804:1693 */     } else if (!this.txtRazonComprador.getText().isEmpty()) {
/* 1805:1694 */       buscarCliente(this.txtRazonComprador.getText(), 2);
/* 1806:     */     } else {
/* 1807:1696 */       JOptionPane.showMessageDialog(this, "Ingrese el RUC /CI o pasaporte o la Razón Social", "Ingrese campo", 1);
/* 1808:     */     }
/* 1809:     */   }
/* 1810:     */   
/* 1811:     */   private void radioConsumidorFActionPerformed(ActionEvent evt)
/* 1812:     */   {
/* 1813:1701 */     limpiaDatosCliente();
/* 1814:     */   }
/* 1815:     */   
/* 1816:     */   private void radioIdentificacionActionPerformed(ActionEvent evt)
/* 1817:     */   {
/* 1818:1705 */     habilitaCamposCliente();
/* 1819:     */   }
/* 1820:     */   
/* 1821:     */   private void txtRazonCompradorFocusGained(FocusEvent evt)
/* 1822:     */   {
/* 1823:1709 */     this.txtCedulaComprador.setText(null);
/* 1824:     */   }
/* 1825:     */   
/* 1826:     */   private void textNro1FocusLost(FocusEvent evt)
/* 1827:     */   {
/* 1828:     */     try
/* 1829:     */     {
/* 1830:1714 */       this.textNro1.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro1.getText())) }));
/* 1831:     */     }
/* 1832:     */     catch (NumberFormatException ne) {}
/* 1833:     */   }
/* 1834:     */   
/* 1835:     */   private void textNro2FocusLost(FocusEvent evt)
/* 1836:     */   {
/* 1837:     */     try
/* 1838:     */     {
/* 1839:1721 */       this.textNro2.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro2.getText())) }));
/* 1840:     */     }
/* 1841:     */     catch (NumberFormatException ne) {}
/* 1842:     */   }
/* 1843:     */   
/* 1844:     */   private void textNro3FocusLost(FocusEvent evt)
/* 1845:     */   {
/* 1846:     */     try
/* 1847:     */     {
/* 1848:1728 */       this.textNro3.setText(String.format("%09d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro3.getText())) }));
/* 1849:     */     }
/* 1850:     */     catch (NumberFormatException ne) {}
/* 1851:     */   }
/* 1852:     */   
/* 1853:     */   private void btnAnadirActionPerformed(ActionEvent evt)
/* 1854:     */   {
/* 1855:1734 */     Component component = (Component)evt.getSource();
/* 1856:1735 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 1857:1736 */     this.modalCliente = new DialogoCliente(frame, Boolean.FALSE);
/* 1858:1737 */     this.modalCliente.setSize(770, 573);
/* 1859:1738 */     this.modalCliente.setLocationRelativeTo(null);
/* 1860:1739 */     this.modalCliente.setVisible(true);
/* 1861:     */   }
/* 1862:     */   
/* 1863:     */   private void btnActualizaExcentoIVAActionPerformed(ActionEvent evt)
/* 1864:     */   {
/* 1865:1743 */     if (this.modeloDetalle.getRowCount() > 0)
/* 1866:     */     {
/* 1867:1744 */       this.txtSubtotalExcentoIVA.setValue(this.modeloDetalle.getTotalIva());
/* 1868:1745 */       this.subtotalExentoIVA = BigDecimal.valueOf(((Number)this.txtSubtotalExcentoIVA.getValue()).doubleValue());
/* 1869:1746 */       this.txtSubtotal12.setValue(null);
/* 1870:1747 */       this.subtotal12 = BigDecimal.ZERO;
/* 1871:1748 */       this.txtSubtotal0.setValue(null);
/* 1872:1749 */       this.subtotal0 = BigDecimal.ZERO;
/* 1873:1750 */       this.txtSubtotalNoObjetoIVA.setValue(null);
/* 1874:1751 */       this.subtotalNoObjetoIVA = BigDecimal.ZERO;
/* 1875:1752 */       actualizaDetalle();
/* 1876:     */     }
/* 1877:     */   }
/* 1878:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.NotaDeDebitoView
 * JD-Core Version:    0.7.0.1
 */