/*    1:     */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*    2:     */ 
/*    3:     */ import comprobantesdesktop.ComprobantesDesktopApp;
/*    4:     */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*    5:     */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*    6:     */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*    7:     */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*    8:     */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*    9:     */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   10:     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   11:     */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*   12:     */ import ec.gob.sri.comprobantes.modelo.SubtotalImpuesto;
/*   13:     */ import ec.gob.sri.comprobantes.modelo.notacredito.Impuesto;
/*   14:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*   15:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles;
/*   16:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle;
/*   17:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle.DetallesAdicionales;
/*   18:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional;
/*   19:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.Detalles.Detalle.Impuestos;
/*   20:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoAdicional;
/*   21:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoAdicional.CampoAdicional;
/*   22:     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito.InfoNotaCredito;
/*   23:     */ import ec.gob.sri.comprobantes.modelo.notacredito.ObjectFactory;
/*   24:     */ import ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos;
/*   25:     */ import ec.gob.sri.comprobantes.modelo.notacredito.TotalConImpuestos.TotalImpuesto;
/*   26:     */ import ec.gob.sri.comprobantes.modelo.reportes.NotaCreditoReporte;
/*   27:     */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   28:     */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*   29:     */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   30:     */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   31:     */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   32:     */ import ec.gob.sri.comprobantes.table.model.DatosAdicionalesTableModel;
/*   33:     */ import ec.gob.sri.comprobantes.table.model.EliminarDatoCellEditor;
/*   34:     */ import ec.gob.sri.comprobantes.table.model.EliminarProductoCellEditor;
/*   35:     */ import ec.gob.sri.comprobantes.table.model.EliminarRenderer;
/*   36:     */ import ec.gob.sri.comprobantes.table.model.NotaCreditoModel;
/*   37:     */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*   38:     */ import ec.gob.sri.comprobantes.util.Constantes;
/*   39:     */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*   40:     */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*   41:     */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   42:     */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   43:     */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*   44:     */ import ec.gob.sri.comprobantes.util.TipoCompradorEnum;
/*   45:     */ import ec.gob.sri.comprobantes.util.TipoComprobanteEnum;
/*   46:     */ import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
/*   47:     */ import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
/*   48:     */ import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
/*   49:     */ import ec.gob.sri.comprobantes.view.modals.DialogoCliente;
/*   50:     */ import ec.gob.sri.comprobantes.view.modals.DialogoProductos;
/*   51:     */ import java.awt.Component;
/*   52:     */ import java.awt.Container;
/*   53:     */ import java.awt.Cursor;
/*   54:     */ import java.awt.Dimension;
/*   55:     */ import java.awt.event.ActionEvent;
/*   56:     */ import java.awt.event.ActionListener;
/*   57:     */ import java.awt.event.FocusAdapter;
/*   58:     */ import java.awt.event.FocusEvent;
/*   59:     */ import java.awt.event.KeyAdapter;
/*   60:     */ import java.awt.event.KeyEvent;
/*   61:     */ import java.awt.event.MouseAdapter;
/*   62:     */ import java.awt.event.MouseEvent;
/*   63:     */ import java.beans.PropertyChangeEvent;
/*   64:     */ import java.beans.PropertyChangeListener;
/*   65:     */ import java.io.File;
/*   66:     */ import java.io.PrintStream;
/*   67:     */ import java.math.BigDecimal;
/*   68:     */ import java.math.RoundingMode;
/*   69:     */ import java.sql.SQLException;
/*   70:     */ import java.text.DecimalFormat;
/*   71:     */ import java.text.SimpleDateFormat;
/*   72:     */ import java.util.ArrayList;
/*   73:     */ import java.util.Collections;
/*   74:     */ import java.util.Date;
/*   75:     */ import java.util.List;
/*   76:     */ import java.util.logging.Level;
/*   77:     */ import java.util.logging.Logger;
/*   78:     */ import javax.accessibility.AccessibleContext;
/*   79:     */ import javax.swing.BorderFactory;
/*   80:     */ import javax.swing.ButtonGroup;
/*   81:     */ import javax.swing.DefaultComboBoxModel;
/*   82:     */ import javax.swing.GroupLayout;
/*   83:     */ import javax.swing.GroupLayout.Alignment;
/*   84:     */ import javax.swing.GroupLayout.ParallelGroup;
/*   85:     */ import javax.swing.GroupLayout.SequentialGroup;
/*   86:     */ import javax.swing.ImageIcon;
/*   87:     */ import javax.swing.JButton;
/*   88:     */ import javax.swing.JComboBox;
/*   89:     */ import javax.swing.JFormattedTextField;
/*   90:     */ import javax.swing.JFrame;
/*   91:     */ import javax.swing.JLabel;
/*   92:     */ import javax.swing.JOptionPane;
/*   93:     */ import javax.swing.JPanel;
/*   94:     */ import javax.swing.JRadioButton;
/*   95:     */ import javax.swing.JScrollPane;
/*   96:     */ import javax.swing.JTable;
/*   97:     */ import javax.swing.JTextArea;
/*   98:     */ import javax.swing.JTextField;
/*   99:     */ import javax.swing.JViewport;
/*  100:     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  101:     */ import javax.swing.SwingUtilities;
/*  102:     */ import javax.swing.table.DefaultTableCellRenderer;
/*  103:     */ import javax.swing.table.TableColumn;
/*  104:     */ import javax.swing.table.TableColumnModel;
/*  105:     */ import javax.swing.text.DefaultFormatterFactory;
/*  106:     */ import javax.swing.text.NumberFormatter;
/*  107:     */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*  108:     */ import org.jdesktop.application.Application;
/*  109:     */ import org.jdesktop.application.ApplicationContext;
/*  110:     */ import org.jdesktop.application.ResourceMap;
/*  111:     */ 
/*  112:     */ public final class NotaCreditoView
/*  113:     */   extends JPanel
/*  114:     */ {
/*  115:  85 */   private long VALOR_MAXIMO_CONSUMIDOR_FINAL = 200L;
/*  116:  86 */   private Long secuencial = null;
/*  117:  87 */   private String secuencialComprobante = null;
/*  118:  88 */   private String razonSocialComprador = null;
/*  119:  89 */   private String identificacionComprador = null;
/*  120:  90 */   private InfoTributaria infoTributaria = null;
/*  121:  91 */   private NotaCredito.InfoNotaCredito infoNotaCredito = null;
/*  122:  92 */   private Emisor emisor = null;
/*  123:  93 */   private String serie = null;
/*  124:  94 */   private String claveDeAcceso = null;
/*  125:     */   private Date fechaEmision;
/*  126:  96 */   private BigDecimal subtotal12 = BigDecimal.ZERO;
/*  127:  97 */   private BigDecimal subtotal0 = BigDecimal.ZERO;
/*  128:  98 */   private BigDecimal subtotalNoObjetoIVA = BigDecimal.ZERO;
/*  129:  99 */   private BigDecimal subtotalExentoIVA = BigDecimal.ZERO;
/*  130: 100 */   private BigDecimal subtotalValorICE = BigDecimal.ZERO;
/*  131: 101 */   private BigDecimal subtotalSinImpuestos = BigDecimal.ZERO;
/*  132: 102 */   private BigDecimal valorIVA = BigDecimal.ZERO;
/*  133: 103 */   private BigDecimal valorPropina = BigDecimal.ZERO;
/*  134: 104 */   private BigDecimal valorDescuento = BigDecimal.ZERO;
/*  135: 105 */   private BigDecimal totalValorComprobante = BigDecimal.ZERO;
/*  136: 106 */   private BigDecimal subtotalValorIRBPNR = BigDecimal.ZERO;
/*  137:     */   private Clientes clienteSeleccionado;
/*  138:     */   private ClaveContingencia claveContingencia;
/*  139:     */   private DialogoProductos modalProductos;
/*  140:     */   private DialogoCliente modalCliente;
/*  141:     */   private DatosAdicionalesTableModel modeloDatosAdicionales;
/*  142:     */   private NotaCreditoModel modeloDetalle;
/*  143:     */   private ObjectFactory factory;
/*  144:     */   private String password;
/*  145:     */   private JButton btnAnadir;
/*  146:     */   private JButton btnBuscar;
/*  147:     */   private JButton btnFirmarProcesar;
/*  148:     */   private JButton btnGuardar;
/*  149:     */   private JButton btnNuevoDato;
/*  150:     */   private JButton btnNuevoDetalle;
/*  151:     */   private Cabecera cabecera1;
/*  152:     */   private JComboBox comboTipoDocModificado;
/*  153:     */   private IdentificacionComprobanteNoGuia idenComprob;
/*  154:     */   private JButton jButton4;
/*  155:     */   private JCalendarButton jCalendarCompModifica;
/*  156:     */   private ButtonGroup jGroupTipoComprador;
/*  157:     */   private JLabel jLabel14;
/*  158:     */   private JLabel jLabel15;
/*  159:     */   private JLabel jLabel17;
/*  160:     */   private JLabel jLabel18;
/*  161:     */   private JLabel jLabel19;
/*  162:     */   private JLabel jLabel20;
/*  163:     */   private JLabel jLabel21;
/*  164:     */   private JLabel jLabel22;
/*  165:     */   private JLabel jLabel23;
/*  166:     */   private JLabel jLabel25;
/*  167:     */   private JLabel jLabel26;
/*  168:     */   private JLabel jLabel27;
/*  169:     */   private JLabel jLabel28;
/*  170:     */   private JLabel jLabel29;
/*  171:     */   private JLabel jLabel30;
/*  172:     */   private JPanel jPanel2;
/*  173:     */   private JPanel jPanel3;
/*  174:     */   private JPanel jPanel4;
/*  175:     */   private JPanel jPanel5;
/*  176:     */   private JPanel jPanel6;
/*  177:     */   private JPanel jPanelSubtotal;
/*  178:     */   private JScrollPane jScrollPane1;
/*  179:     */   private JScrollPane jScrollPane2;
/*  180:     */   private JScrollPane jScrollPane7;
/*  181:     */   private JTable jTableDatosAdicionales;
/*  182:     */   private JTable jTableDetalleComprobante;
/*  183:     */   private JLabel lblSubtotal0;
/*  184:     */   private JLabel lblSubtotal12;
/*  185:     */   private JLabel lblSubtotalExentoIVA;
/*  186:     */   private JLabel lblSubtotalImpuestos;
/*  187:     */   private JLabel lblSubtotalNoObjetoIVA;
/*  188:     */   private JFormattedTextField lblTotalFactura;
/*  189:     */   private JLabel lblValorIRBPNR;
/*  190:     */   private JLabel lblValorIVA;
/*  191:     */   private JLabel lblValorIce;
/*  192:     */   private JRadioButton radioConsumidorF;
/*  193:     */   private JRadioButton radioIdentificacion;
/*  194:     */   private JTextField textFechaCompModif;
/*  195:     */   private JTextField textNro1;
/*  196:     */   private JTextField textNro2;
/*  197:     */   private JTextField textNro3;
/*  198:     */   private JTextField txtCedulaComprador;
/*  199:     */   public JTextArea txtMotivo;
/*  200:     */   private JTextField txtRazonComprador;
/*  201:     */   private JTextField txtValorDetallesDescuento;
/*  202:     */   
/*  203:     */   public NotaCreditoView()
/*  204:     */   {
/*  205: 117 */     initComponents();
/*  206: 118 */     inicializarDatos();
/*  207: 119 */     actualizaClaveDeAcceso();
/*  208: 120 */     ListenerUtil lu = new ListenerUtil();
/*  209: 121 */     lu.listenerSolonumerosLongitud(this.textNro1, Integer.valueOf(3));
/*  210: 122 */     lu.listenerSolonumerosLongitud(this.textNro2, Integer.valueOf(3));
/*  211: 123 */     lu.listenerSolonumerosLongitud(this.textNro3, Integer.valueOf(9));
/*  212:     */   }
/*  213:     */   
/*  214:     */   public void inicializarDatos()
/*  215:     */   {
/*  216: 127 */     this.factory = new ObjectFactory();
/*  217: 128 */     String[] opciones = { "FACTURA" };
/*  218: 129 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(opciones));
/*  219: 130 */     this.modeloDatosAdicionales = new DatosAdicionalesTableModel();
/*  220: 131 */     this.jTableDatosAdicionales.setModel(this.modeloDatosAdicionales);
/*  221: 132 */     this.jTableDatosAdicionales.setAutoResizeMode(0);
/*  222: 133 */     TableColumn tc = this.jTableDatosAdicionales.getColumnModel().getColumn(2);
/*  223: 134 */     EliminarDatoCellEditor editord = new EliminarDatoCellEditor(this.jTableDatosAdicionales);
/*  224: 135 */     tc.setCellEditor(editord);
/*  225: 136 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  226: 137 */     setColumnWidthDatosAdicionales();
/*  227: 138 */     this.modeloDetalle = new NotaCreditoModel();
/*  228: 139 */     this.jTableDetalleComprobante.setModel(this.modeloDetalle);
/*  229: 140 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(10);
/*  230: 141 */     EliminarProductoCellEditor editor = new EliminarProductoCellEditor(this.jTableDetalleComprobante);
/*  231: 142 */     tc.setCellEditor(editor);
/*  232: 143 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  233: 144 */     this.jTableDetalleComprobante.setAutoResizeMode(0);
/*  234: 145 */     setColumnWidthDetalle();
/*  235: 146 */     DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
/*  236: 147 */     dtcr.setHorizontalAlignment(4);
/*  237: 148 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(5);
/*  238: 149 */     tc.setCellRenderer(dtcr);
/*  239: 150 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(8);
/*  240: 151 */     tc.setCellRenderer(dtcr);
/*  241: 152 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(9);
/*  242: 153 */     tc.setCellRenderer(dtcr);
/*  243: 154 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(7);
/*  244: 155 */     tc.setCellRenderer(dtcr);
/*  245: 156 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(0);
/*  246: 157 */     tc.setCellRenderer(dtcr);
/*  247: 158 */     this.jTableDetalleComprobante.addMouseListener(new MouseAdapter()
/*  248:     */     {
/*  249:     */       public void mouseReleased(MouseEvent e)
/*  250:     */       {
/*  251: 162 */         NotaCreditoView.this.actualizaCeldaTabla();
/*  252:     */       }
/*  253: 165 */     });
/*  254: 166 */     this.jTableDetalleComprobante.addKeyListener(new KeyAdapter()
/*  255:     */     {
/*  256:     */       public void keyTyped(KeyEvent e)
/*  257:     */       {
/*  258: 170 */         super.keyTyped(e);
/*  259: 171 */         NotaCreditoView.this.actualizaCeldaTabla();
/*  260: 172 */         NotaCreditoView.this.btnFirmarProcesar.setEnabled(false);
/*  261: 173 */         NotaCreditoView.this.btnGuardar.setEnabled(false);
/*  262:     */       }
/*  263:     */       
/*  264:     */       public void keyReleased(KeyEvent e)
/*  265:     */       {
/*  266: 178 */         super.keyReleased(e);
/*  267: 179 */         NotaCreditoView.this.actualizaCeldaTabla();
/*  268: 180 */         NotaCreditoView.this.btnFirmarProcesar.setEnabled(true);
/*  269: 181 */         NotaCreditoView.this.btnGuardar.setEnabled(true);
/*  270:     */       }
/*  271: 185 */     });
/*  272: 186 */     this.idenComprob.jCalendarFecha.addPropertyChangeListener(new PropertyChangeListener()
/*  273:     */     {
/*  274:     */       public void propertyChange(PropertyChangeEvent evt)
/*  275:     */       {
/*  276: 189 */         NotaCreditoView.this.cambioEnBotonDeFecha(evt, 1);
/*  277:     */       }
/*  278: 192 */     });
/*  279: 193 */     this.jCalendarCompModifica.addPropertyChangeListener(new PropertyChangeListener()
/*  280:     */     {
/*  281:     */       public void propertyChange(PropertyChangeEvent evt)
/*  282:     */       {
/*  283: 196 */         NotaCreditoView.this.cambioEnBotonDeFecha(evt, 2);
/*  284:     */       }
/*  285:     */     });
/*  286:     */     try
/*  287:     */     {
/*  288: 204 */       ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode());
/*  289: 205 */       if (iv != null)
/*  290:     */       {
/*  291: 206 */         this.secuencial = new ComprobantesSQL().obtenerMaximo(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode());
/*  292: 207 */         this.secuencialComprobante = String.format("%09d", new Object[] { Long.valueOf(this.secuencial.longValue()) });
/*  293: 208 */         llenaDatosEmisor();
/*  294: 209 */         this.idenComprob.lblEstablecimiento.setText(this.emisor.getCodigoEstablecimiento());
/*  295: 210 */         this.idenComprob.lblPunto.setText(this.emisor.getCodPuntoEmision());
/*  296: 211 */         setDate(new Date());
/*  297:     */       }
/*  298:     */     }
/*  299:     */     catch (Exception ex)
/*  300:     */     {
/*  301: 214 */       Logger.getLogger(NotaCreditoView.class.getName()).log(Level.SEVERE, null, ex);
/*  302:     */     }
/*  303: 217 */     this.idenComprob.lblNumeroComprobante.setText(this.secuencialComprobante);
/*  304:     */   }
/*  305:     */   
/*  306:     */   private void setColumnWidthDatosAdicionales()
/*  307:     */   {
/*  308: 222 */     for (int i = 0; i < this.jTableDatosAdicionales.getColumnModel().getColumnCount(); i++)
/*  309:     */     {
/*  310: 223 */       TableColumn column = this.jTableDatosAdicionales.getColumnModel().getColumn(i);
/*  311: 224 */       if (i == 0) {
/*  312: 225 */         column.setPreferredWidth(100);
/*  313:     */       }
/*  314: 227 */       if (i == 1) {
/*  315: 228 */         column.setPreferredWidth(300);
/*  316:     */       }
/*  317: 230 */       if (i == 2) {
/*  318: 231 */         column.setPreferredWidth(105);
/*  319:     */       }
/*  320:     */     }
/*  321:     */   }
/*  322:     */   
/*  323:     */   private void setColumnWidthDetalle()
/*  324:     */   {
/*  325: 241 */     for (int i = 0; i < this.jTableDetalleComprobante.getColumnModel().getColumnCount(); i++)
/*  326:     */     {
/*  327: 242 */       TableColumn column = this.jTableDetalleComprobante.getColumnModel().getColumn(i);
/*  328: 243 */       if (i == 0) {
/*  329: 244 */         column.setPreferredWidth(75);
/*  330:     */       }
/*  331: 246 */       if (i == 1) {
/*  332: 247 */         column.setPreferredWidth(105);
/*  333:     */       }
/*  334: 249 */       if (i == 2) {
/*  335: 250 */         column.setPreferredWidth(105);
/*  336:     */       }
/*  337: 252 */       if (i == 3) {
/*  338: 253 */         column.setPreferredWidth(250);
/*  339:     */       }
/*  340: 255 */       if (i == 4) {
/*  341: 256 */         column.setPreferredWidth(95);
/*  342:     */       }
/*  343: 258 */       if (i == 7) {
/*  344: 259 */         column.setPreferredWidth(105);
/*  345:     */       }
/*  346: 261 */       if (i == 8) {
/*  347: 262 */         column.setPreferredWidth(105);
/*  348:     */       }
/*  349: 264 */       if (i == 9) {
/*  350: 265 */         column.setPreferredWidth(105);
/*  351:     */       }
/*  352:     */     }
/*  353:     */   }
/*  354:     */   
/*  355:     */   private void actualizaCeldaTabla()
/*  356:     */   {
/*  357:     */     try
/*  358:     */     {
/*  359: 275 */       int row = this.jTableDetalleComprobante.getSelectedRow();
/*  360: 276 */       int col = this.jTableDetalleComprobante.getSelectedColumn();
/*  361: 277 */       if (col == 0) {
/*  362: 278 */         Double.parseDouble(this.modeloDetalle.getValueAt(row, col).toString());
/*  363:     */       }
/*  364: 280 */       if ((col == 4) || (col == 5)) {
/*  365: 281 */         Double.parseDouble(this.modeloDetalle.getValueAt(row, col).toString());
/*  366:     */       }
/*  367: 283 */       actualizaDetalle();
/*  368:     */     }
/*  369:     */     catch (Exception ex)
/*  370:     */     {
/*  371: 285 */       Logger.getLogger(NotaCreditoView.class.getName()).log(Level.SEVERE, "Error de Casting", ex);
/*  372:     */     }
/*  373:     */   }
/*  374:     */   
/*  375:     */   public void llenaDatosEmisor()
/*  376:     */   {
/*  377: 294 */     this.emisor = FormGenerales.llenaDatosEmisor(this.cabecera1);
/*  378:     */   }
/*  379:     */   
/*  380:     */   public void actualizaDetalle()
/*  381:     */   {
/*  382: 304 */     this.subtotal12 = this.modeloDetalle.getSubtotalIva12().setScale(2, RoundingMode.HALF_UP);
/*  383: 305 */     this.subtotal0 = this.modeloDetalle.getSubtotalIva0().setScale(2, RoundingMode.HALF_UP);
/*  384: 306 */     this.subtotalNoObjetoIVA = this.modeloDetalle.getSubtotalNoIva().setScale(2, RoundingMode.HALF_UP);
/*  385: 307 */     this.subtotalExentoIVA = this.modeloDetalle.getSubtotalExentoIVA().setScale(2, RoundingMode.HALF_UP);
/*  386: 308 */     this.subtotalValorIRBPNR = this.modeloDetalle.getSubtotalIRBPNR().setScale(2, RoundingMode.HALF_UP);
/*  387: 309 */     this.subtotalSinImpuestos = this.subtotal12.add(this.subtotal0.add(this.subtotalNoObjetoIVA).add(this.subtotalExentoIVA)).setScale(2, RoundingMode.HALF_UP);
/*  388: 310 */     this.subtotalValorICE = this.modeloDetalle.getSubtotalICE().setScale(2, RoundingMode.HALF_UP);
/*  389: 311 */     this.valorDescuento = this.modeloDetalle.getTotalDescuento().setScale(2, RoundingMode.HALF_UP);
/*  390: 312 */     this.valorIVA = this.modeloDetalle.calcularTotalIva12().setScale(2, RoundingMode.HALF_UP);
/*  391: 313 */     this.totalValorComprobante = this.subtotalSinImpuestos.add(this.subtotalValorICE.add(this.valorIVA.add(this.valorPropina))).add(this.subtotalValorIRBPNR);
/*  392: 314 */     this.lblSubtotal12.setText(this.subtotal12.toString());
/*  393: 315 */     this.lblSubtotalExentoIVA.setText(this.subtotalExentoIVA.toString());
/*  394: 316 */     this.lblSubtotal0.setText(this.subtotal0.toString());
/*  395: 317 */     this.lblSubtotalNoObjetoIVA.setText(this.subtotalNoObjetoIVA.toString());
/*  396: 318 */     this.lblValorIce.setText(this.subtotalValorICE.toString());
/*  397: 319 */     this.lblValorIRBPNR.setText(this.subtotalValorIRBPNR.toString());
/*  398: 320 */     this.lblSubtotalImpuestos.setText(this.subtotalSinImpuestos.toString());
/*  399: 321 */     this.lblValorIVA.setText(this.valorIVA.toString());
/*  400: 322 */     this.lblTotalFactura.setValue(this.totalValorComprobante);
/*  401: 323 */     this.txtValorDetallesDescuento.setText(this.valorDescuento.toString());
/*  402:     */   }
/*  403:     */   
/*  404:     */   private void cambioEnBotonDeFecha(PropertyChangeEvent evt, int id)
/*  405:     */   {
/*  406: 327 */     if ((evt.getNewValue() instanceof Date)) {
/*  407: 328 */       if (id == 1)
/*  408:     */       {
/*  409: 329 */         setDate((Date)evt.getNewValue());
/*  410: 330 */         actualizaClaveDeAcceso();
/*  411:     */       }
/*  412:     */       else
/*  413:     */       {
/*  414: 332 */         setDateComprobante((Date)evt.getNewValue());
/*  415:     */       }
/*  416:     */     }
/*  417:     */   }
/*  418:     */   
/*  419:     */   private void initComponents()
/*  420:     */   {
/*  421: 346 */     this.jGroupTipoComprador = new ButtonGroup();
/*  422: 347 */     this.jPanel2 = new JPanel();
/*  423: 348 */     this.radioConsumidorF = new JRadioButton();
/*  424: 349 */     this.radioIdentificacion = new JRadioButton();
/*  425: 350 */     this.jLabel17 = new JLabel();
/*  426: 351 */     this.txtCedulaComprador = new JTextField();
/*  427: 352 */     this.btnBuscar = new JButton();
/*  428: 353 */     this.txtRazonComprador = new JTextField();
/*  429: 354 */     this.btnAnadir = new JButton();
/*  430: 355 */     this.jPanel3 = new JPanel();
/*  431: 356 */     this.jScrollPane1 = new JScrollPane();
/*  432: 357 */     this.jTableDetalleComprobante = new JTable();
/*  433: 358 */     this.btnNuevoDetalle = new JButton();
/*  434: 359 */     this.jPanel4 = new JPanel();
/*  435: 360 */     this.jScrollPane2 = new JScrollPane();
/*  436: 361 */     this.jTableDatosAdicionales = new JTable();
/*  437: 362 */     this.btnNuevoDato = new JButton();
/*  438: 363 */     this.jPanelSubtotal = new JPanel();
/*  439: 364 */     this.jLabel20 = new JLabel();
/*  440: 365 */     this.jLabel21 = new JLabel();
/*  441: 366 */     this.jLabel22 = new JLabel();
/*  442: 367 */     this.jLabel23 = new JLabel();
/*  443: 368 */     this.jLabel26 = new JLabel();
/*  444: 369 */     this.jLabel27 = new JLabel();
/*  445: 370 */     this.jLabel30 = new JLabel();
/*  446: 371 */     this.lblValorIVA = new JLabel();
/*  447: 372 */     this.lblSubtotalImpuestos = new JLabel();
/*  448: 373 */     this.lblTotalFactura = new JFormattedTextField();
/*  449: 374 */     this.lblSubtotal12 = new JLabel();
/*  450: 375 */     this.lblSubtotal0 = new JLabel();
/*  451: 376 */     this.lblSubtotalNoObjetoIVA = new JLabel();
/*  452: 377 */     this.lblValorIce = new JLabel();
/*  453: 378 */     this.jLabel25 = new JLabel();
/*  454: 379 */     this.lblSubtotalExentoIVA = new JLabel();
/*  455: 380 */     this.jLabel28 = new JLabel();
/*  456: 381 */     this.lblValorIRBPNR = new JLabel();
/*  457: 382 */     this.jLabel29 = new JLabel();
/*  458: 383 */     this.txtValorDetallesDescuento = new JTextField();
/*  459: 384 */     this.jPanel6 = new JPanel();
/*  460: 385 */     this.btnFirmarProcesar = new JButton();
/*  461: 386 */     this.jButton4 = new JButton();
/*  462: 387 */     this.btnGuardar = new JButton();
/*  463: 388 */     this.jPanel5 = new JPanel();
/*  464: 389 */     this.jLabel14 = new JLabel();
/*  465: 390 */     this.comboTipoDocModificado = new JComboBox();
/*  466: 391 */     this.jLabel18 = new JLabel();
/*  467: 392 */     this.jLabel19 = new JLabel();
/*  468: 393 */     this.textFechaCompModif = new JTextField();
/*  469: 394 */     this.textNro1 = new JTextField();
/*  470: 395 */     this.textNro2 = new JTextField();
/*  471: 396 */     this.textNro3 = new JTextField();
/*  472: 397 */     this.jCalendarCompModifica = new JCalendarButton();
/*  473: 398 */     this.jScrollPane7 = new JScrollPane();
/*  474: 399 */     this.txtMotivo = new JTextArea();
/*  475: 400 */     this.jLabel15 = new JLabel();
/*  476: 401 */     this.cabecera1 = new Cabecera();
/*  477: 402 */     this.idenComprob = new IdentificacionComprobanteNoGuia();
/*  478:     */     
/*  479: 404 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(NotaCreditoView.class);
/*  480: 405 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 2, 0, resourceMap.getFont("Form.border.titleFont")));
/*  481: 406 */     setName("Form");
/*  482: 407 */     setRequestFocusEnabled(false);
/*  483:     */     
/*  484: 409 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/*  485: 410 */     this.jPanel2.setName("jPanel2");
/*  486:     */     
/*  487: 412 */     this.jGroupTipoComprador.add(this.radioConsumidorF);
/*  488: 413 */     this.radioConsumidorF.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  489: 414 */     this.radioConsumidorF.setSelected(true);
/*  490: 415 */     this.radioConsumidorF.setText(resourceMap.getString("radioConsumidorF.text", new Object[0]));
/*  491: 416 */     this.radioConsumidorF.setName("radioConsumidorF");
/*  492: 417 */     this.radioConsumidorF.addActionListener(new ActionListener()
/*  493:     */     {
/*  494:     */       public void actionPerformed(ActionEvent evt)
/*  495:     */       {
/*  496: 419 */         NotaCreditoView.this.radioConsumidorFActionPerformed(evt);
/*  497:     */       }
/*  498: 422 */     });
/*  499: 423 */     this.jGroupTipoComprador.add(this.radioIdentificacion);
/*  500: 424 */     this.radioIdentificacion.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  501: 425 */     this.radioIdentificacion.setText(resourceMap.getString("radioIdentificacion.text", new Object[0]));
/*  502: 426 */     this.radioIdentificacion.setName("radioIdentificacion");
/*  503: 427 */     this.radioIdentificacion.addActionListener(new ActionListener()
/*  504:     */     {
/*  505:     */       public void actionPerformed(ActionEvent evt)
/*  506:     */       {
/*  507: 429 */         NotaCreditoView.this.radioIdentificacionActionPerformed(evt);
/*  508:     */       }
/*  509: 432 */     });
/*  510: 433 */     this.jLabel17.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  511: 434 */     this.jLabel17.setText(resourceMap.getString("jLabel17.text", new Object[0]));
/*  512: 435 */     this.jLabel17.setName("jLabel17");
/*  513:     */     
/*  514: 437 */     this.txtCedulaComprador.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  515: 438 */     this.txtCedulaComprador.setEnabled(false);
/*  516: 439 */     this.txtCedulaComprador.setName("txtCedulaComprador");
/*  517:     */     
/*  518: 441 */     this.btnBuscar.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  519: 442 */     this.btnBuscar.setText(resourceMap.getString("btnBuscar.text", new Object[0]));
/*  520: 443 */     this.btnBuscar.setEnabled(false);
/*  521: 444 */     this.btnBuscar.setName("btnBuscar");
/*  522: 445 */     this.btnBuscar.addActionListener(new ActionListener()
/*  523:     */     {
/*  524:     */       public void actionPerformed(ActionEvent evt)
/*  525:     */       {
/*  526: 447 */         NotaCreditoView.this.btnBuscarActionPerformed(evt);
/*  527:     */       }
/*  528: 450 */     });
/*  529: 451 */     this.txtRazonComprador.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  530: 452 */     this.txtRazonComprador.setEnabled(false);
/*  531: 453 */     this.txtRazonComprador.setName("txtRazonComprador");
/*  532: 454 */     this.txtRazonComprador.addFocusListener(new FocusAdapter()
/*  533:     */     {
/*  534:     */       public void focusGained(FocusEvent evt)
/*  535:     */       {
/*  536: 456 */         NotaCreditoView.this.txtRazonCompradorFocusGained(evt);
/*  537:     */       }
/*  538: 459 */     });
/*  539: 460 */     this.btnAnadir.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  540: 461 */     this.btnAnadir.setName("btnAnadir");
/*  541: 462 */     this.btnAnadir.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  542: 463 */     this.btnAnadir.addActionListener(new ActionListener()
/*  543:     */     {
/*  544:     */       public void actionPerformed(ActionEvent evt)
/*  545:     */       {
/*  546: 465 */         NotaCreditoView.this.btnAnadirActionPerformed(evt);
/*  547:     */       }
/*  548: 468 */     });
/*  549: 469 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  550: 470 */     this.jPanel2.setLayout(jPanel2Layout);
/*  551: 471 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.radioConsumidorF).addComponent(this.radioIdentificacion, -2, 247, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCedulaComprador, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscar, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAnadir, -2, 25, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel17).addGap(40, 40, 40).addComponent(this.txtRazonComprador, -2, 469, -2))).addContainerGap(473, 32767)));
/*  552:     */     
/*  553:     */ 
/*  554:     */ 
/*  555:     */ 
/*  556:     */ 
/*  557:     */ 
/*  558:     */ 
/*  559:     */ 
/*  560:     */ 
/*  561:     */ 
/*  562:     */ 
/*  563:     */ 
/*  564:     */ 
/*  565:     */ 
/*  566:     */ 
/*  567:     */ 
/*  568:     */ 
/*  569:     */ 
/*  570:     */ 
/*  571:     */ 
/*  572: 492 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.radioConsumidorF).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.radioIdentificacion, -2, -1, -2).addComponent(this.txtCedulaComprador, -2, 20, -2).addComponent(this.btnBuscar, -2, 20, -2).addComponent(this.btnAnadir, -2, 20, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.txtRazonComprador, -2, 20, -2).addComponent(this.jLabel17)).addContainerGap()));
/*  573:     */     
/*  574:     */ 
/*  575:     */ 
/*  576:     */ 
/*  577:     */ 
/*  578:     */ 
/*  579:     */ 
/*  580:     */ 
/*  581:     */ 
/*  582:     */ 
/*  583:     */ 
/*  584:     */ 
/*  585:     */ 
/*  586:     */ 
/*  587:     */ 
/*  588:     */ 
/*  589: 509 */     jPanel2Layout.linkSize(1, new Component[] { this.btnAnadir, this.btnBuscar });
/*  590:     */     
/*  591: 511 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/*  592: 512 */     this.jPanel3.setName("jPanel3");
/*  593:     */     
/*  594: 514 */     this.jScrollPane1.setName("jScrollPane1");
/*  595:     */     
/*  596: 516 */     this.jTableDetalleComprobante.setFont(resourceMap.getFont("jTableDetalleComprobante.font"));
/*  597: 517 */     this.jTableDetalleComprobante.setName("jTableDetalleComprobante");
/*  598: 518 */     this.jScrollPane1.setViewportView(this.jTableDetalleComprobante);
/*  599:     */     
/*  600: 520 */     this.btnNuevoDetalle.setFont(resourceMap.getFont("btnNuevoDetalle.font"));
/*  601: 521 */     this.btnNuevoDetalle.setText(resourceMap.getString("btnNuevoDetalle.text", new Object[0]));
/*  602: 522 */     this.btnNuevoDetalle.setName("btnNuevoDetalle");
/*  603: 523 */     this.btnNuevoDetalle.addActionListener(new ActionListener()
/*  604:     */     {
/*  605:     */       public void actionPerformed(ActionEvent evt)
/*  606:     */       {
/*  607: 525 */         NotaCreditoView.this.btnNuevoDetalleActionPerformed(evt);
/*  608:     */       }
/*  609: 528 */     });
/*  610: 529 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  611: 530 */     this.jPanel3.setLayout(jPanel3Layout);
/*  612: 531 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1184, 32767).addComponent(this.btnNuevoDetalle, -2, 143, -2)).addContainerGap()));
/*  613:     */     
/*  614:     */ 
/*  615:     */ 
/*  616:     */ 
/*  617:     */ 
/*  618:     */ 
/*  619:     */ 
/*  620:     */ 
/*  621: 540 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.btnNuevoDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 77, 32767)));
/*  622:     */     
/*  623:     */ 
/*  624:     */ 
/*  625:     */ 
/*  626:     */ 
/*  627:     */ 
/*  628:     */ 
/*  629: 548 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title", new Object[0])));
/*  630: 549 */     this.jPanel4.setName("jPanel4");
/*  631:     */     
/*  632: 551 */     this.jScrollPane2.setName("jScrollPane2");
/*  633:     */     
/*  634: 553 */     this.jTableDatosAdicionales.setName("jTableDatosAdicionales");
/*  635: 554 */     this.jScrollPane2.setViewportView(this.jTableDatosAdicionales);
/*  636:     */     
/*  637: 556 */     this.btnNuevoDato.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  638: 557 */     this.btnNuevoDato.setText(resourceMap.getString("btnNuevoDato.text", new Object[0]));
/*  639: 558 */     this.btnNuevoDato.setName("btnNuevoDato");
/*  640: 559 */     this.btnNuevoDato.addActionListener(new ActionListener()
/*  641:     */     {
/*  642:     */       public void actionPerformed(ActionEvent evt)
/*  643:     */       {
/*  644: 561 */         NotaCreditoView.this.btnNuevoDatoActionPerformed(evt);
/*  645:     */       }
/*  646: 564 */     });
/*  647: 565 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  648: 566 */     this.jPanel4.setLayout(jPanel4Layout);
/*  649: 567 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, 595, -2).addComponent(this.btnNuevoDato, -2, 113, -2)).addContainerGap(20, 32767)));
/*  650:     */     
/*  651:     */ 
/*  652:     */ 
/*  653:     */ 
/*  654:     */ 
/*  655:     */ 
/*  656:     */ 
/*  657: 575 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.btnNuevoDato, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 83, 32767).addContainerGap()));
/*  658:     */     
/*  659:     */ 
/*  660:     */ 
/*  661:     */ 
/*  662:     */ 
/*  663:     */ 
/*  664:     */ 
/*  665:     */ 
/*  666: 584 */     this.jPanelSubtotal.setBorder(BorderFactory.createTitledBorder(""));
/*  667: 585 */     this.jPanelSubtotal.setName("jPanelSubtotal");
/*  668:     */     
/*  669: 587 */     this.jLabel20.setFont(resourceMap.getFont("jLabel23.font"));
/*  670: 588 */     this.jLabel20.setText(resourceMap.getString("jLabel20.text", new Object[0]));
/*  671: 589 */     this.jLabel20.setName("jLabel20");
/*  672:     */     
/*  673: 591 */     this.jLabel21.setFont(resourceMap.getFont("jLabel23.font"));
/*  674: 592 */     this.jLabel21.setText(resourceMap.getString("jLabel21.text", new Object[0]));
/*  675: 593 */     this.jLabel21.setName("jLabel21");
/*  676:     */     
/*  677: 595 */     this.jLabel22.setFont(resourceMap.getFont("jLabel23.font"));
/*  678: 596 */     this.jLabel22.setText(resourceMap.getString("jLabel22.text", new Object[0]));
/*  679: 597 */     this.jLabel22.setName("jLabel22");
/*  680:     */     
/*  681: 599 */     this.jLabel23.setFont(resourceMap.getFont("jLabel23.font"));
/*  682: 600 */     this.jLabel23.setText(resourceMap.getString("jLabel23.text", new Object[0]));
/*  683: 601 */     this.jLabel23.setName("jLabel23");
/*  684:     */     
/*  685: 603 */     this.jLabel26.setFont(resourceMap.getFont("jLabel23.font"));
/*  686: 604 */     this.jLabel26.setText(resourceMap.getString("jLabel26.text", new Object[0]));
/*  687: 605 */     this.jLabel26.setName("jLabel26");
/*  688:     */     
/*  689: 607 */     this.jLabel27.setFont(resourceMap.getFont("jLabel23.font"));
/*  690: 608 */     this.jLabel27.setText(resourceMap.getString("jLabel27.text", new Object[0]));
/*  691: 609 */     this.jLabel27.setName("jLabel27");
/*  692:     */     
/*  693: 611 */     this.jLabel30.setFont(resourceMap.getFont("jLabel23.font"));
/*  694: 612 */     this.jLabel30.setText(resourceMap.getString("jLabel30.text", new Object[0]));
/*  695: 613 */     this.jLabel30.setName("jLabel30");
/*  696:     */     
/*  697: 615 */     this.lblValorIVA.setFont(resourceMap.getFont("jLabel23.font"));
/*  698: 616 */     this.lblValorIVA.setText(resourceMap.getString("lblValorIVA.text", new Object[0]));
/*  699: 617 */     this.lblValorIVA.setName("lblValorIVA");
/*  700:     */     
/*  701: 619 */     this.lblSubtotalImpuestos.setFont(resourceMap.getFont("jLabel23.font"));
/*  702: 620 */     this.lblSubtotalImpuestos.setText(resourceMap.getString("lblSubtotalImpuestos.text", new Object[0]));
/*  703: 621 */     this.lblSubtotalImpuestos.setName("lblSubtotalImpuestos");
/*  704:     */     
/*  705: 623 */     this.lblTotalFactura.setBackground(resourceMap.getColor("lblTotalFactura.background"));
/*  706: 624 */     this.lblTotalFactura.setEditable(false);
/*  707: 625 */     this.lblTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("$#,##0.00;($#,##0.00)"))));
/*  708: 626 */     this.lblTotalFactura.setText(resourceMap.getString("lblTotalFactura.text", new Object[0]));
/*  709: 627 */     this.lblTotalFactura.setName("lblTotalFactura");
/*  710:     */     
/*  711: 629 */     this.lblSubtotal12.setFont(resourceMap.getFont("jLabel23.font"));
/*  712: 630 */     this.lblSubtotal12.setText(resourceMap.getString("lblSubtotal12.text", new Object[0]));
/*  713: 631 */     this.lblSubtotal12.setName("lblSubtotal12");
/*  714:     */     
/*  715: 633 */     this.lblSubtotal0.setFont(resourceMap.getFont("jLabel23.font"));
/*  716: 634 */     this.lblSubtotal0.setText(resourceMap.getString("lblSubtotal0.text", new Object[0]));
/*  717: 635 */     this.lblSubtotal0.setName("lblSubtotal0");
/*  718:     */     
/*  719: 637 */     this.lblSubtotalNoObjetoIVA.setFont(resourceMap.getFont("jLabel23.font"));
/*  720: 638 */     this.lblSubtotalNoObjetoIVA.setText(resourceMap.getString("lblSubtotalNoObjetoIVA.text", new Object[0]));
/*  721: 639 */     this.lblSubtotalNoObjetoIVA.setName("lblSubtotalNoObjetoIVA");
/*  722:     */     
/*  723: 641 */     this.lblValorIce.setFont(resourceMap.getFont("jLabel23.font"));
/*  724: 642 */     this.lblValorIce.setText(resourceMap.getString("lblValorIce.text", new Object[0]));
/*  725: 643 */     this.lblValorIce.setName("lblValorIce");
/*  726:     */     
/*  727: 645 */     this.jLabel25.setFont(resourceMap.getFont("jLabel25.font"));
/*  728: 646 */     this.jLabel25.setText(resourceMap.getString("jLabel25.text", new Object[0]));
/*  729: 647 */     this.jLabel25.setName("jLabel25");
/*  730:     */     
/*  731: 649 */     this.lblSubtotalExentoIVA.setFont(resourceMap.getFont("lblSubtotalExentoIVA.font"));
/*  732: 650 */     this.lblSubtotalExentoIVA.setText(resourceMap.getString("lblSubtotalExentoIVA.text", new Object[0]));
/*  733: 651 */     this.lblSubtotalExentoIVA.setName("lblSubtotalExentoIVA");
/*  734:     */     
/*  735: 653 */     this.jLabel28.setFont(resourceMap.getFont("jLabel28.font"));
/*  736: 654 */     this.jLabel28.setText(resourceMap.getString("jLabel28.text", new Object[0]));
/*  737: 655 */     this.jLabel28.setName("jLabel28");
/*  738:     */     
/*  739: 657 */     this.lblValorIRBPNR.setFont(resourceMap.getFont("lblValorIRBPNR.font"));
/*  740: 658 */     this.lblValorIRBPNR.setText(resourceMap.getString("lblValorIRBPNR.text", new Object[0]));
/*  741: 659 */     this.lblValorIRBPNR.setName("lblValorIRBPNR");
/*  742:     */     
/*  743: 661 */     this.jLabel29.setFont(resourceMap.getFont("jLabel29.font"));
/*  744: 662 */     this.jLabel29.setText(resourceMap.getString("jLabel29.text", new Object[0]));
/*  745: 663 */     this.jLabel29.setName("jLabel29");
/*  746:     */     
/*  747: 665 */     this.txtValorDetallesDescuento.setFont(resourceMap.getFont("txtValorDetallesDescuento.font"));
/*  748: 666 */     this.txtValorDetallesDescuento.setText(resourceMap.getString("txtValorDetallesDescuento.text", new Object[0]));
/*  749: 667 */     this.txtValorDetallesDescuento.setEnabled(false);
/*  750: 668 */     this.txtValorDetallesDescuento.setName("txtValorDetallesDescuento");
/*  751:     */     
/*  752: 670 */     GroupLayout jPanelSubtotalLayout = new GroupLayout(this.jPanelSubtotal);
/*  753: 671 */     this.jPanelSubtotal.setLayout(jPanelSubtotalLayout);
/*  754: 672 */     jPanelSubtotalLayout.setHorizontalGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel27)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 478, 32767)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 474, 32767)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 480, 32767)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel30).addGap(481, 481, 481)).addGroup(GroupLayout.Alignment.TRAILING, jPanelSubtotalLayout.createSequentialGroup().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addContainerGap().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel26).addComponent(this.jLabel25, -2, -1, -2).addComponent(this.jLabel22, -2, -1, -2).addComponent(this.jLabel29, -2, -1, -2))).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel23, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, 32767).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblSubtotalImpuestos, -2, 313, -2).addComponent(this.lblSubtotal12, -2, 313, -2).addComponent(this.lblSubtotal0, -2, 313, -2).addComponent(this.lblSubtotalNoObjetoIVA, -2, 313, -2).addComponent(this.lblSubtotalExentoIVA, -1, 391, 32767).addComponent(this.txtValorDetallesDescuento, -2, 224, -2).addComponent(this.lblValorIce, -1, 391, 32767).addComponent(this.lblValorIRBPNR, -1, 391, 32767).addComponent(this.lblValorIVA, -1, 391, 32767).addComponent(this.lblTotalFactura, -2, 204, -2)))).addContainerGap()));
/*  755:     */     
/*  756:     */ 
/*  757:     */ 
/*  758:     */ 
/*  759:     */ 
/*  760:     */ 
/*  761:     */ 
/*  762:     */ 
/*  763:     */ 
/*  764:     */ 
/*  765:     */ 
/*  766:     */ 
/*  767:     */ 
/*  768:     */ 
/*  769:     */ 
/*  770:     */ 
/*  771:     */ 
/*  772:     */ 
/*  773:     */ 
/*  774:     */ 
/*  775:     */ 
/*  776:     */ 
/*  777:     */ 
/*  778:     */ 
/*  779:     */ 
/*  780:     */ 
/*  781:     */ 
/*  782:     */ 
/*  783:     */ 
/*  784:     */ 
/*  785:     */ 
/*  786:     */ 
/*  787:     */ 
/*  788:     */ 
/*  789:     */ 
/*  790:     */ 
/*  791:     */ 
/*  792:     */ 
/*  793:     */ 
/*  794:     */ 
/*  795:     */ 
/*  796:     */ 
/*  797:     */ 
/*  798:     */ 
/*  799:     */ 
/*  800:     */ 
/*  801:     */ 
/*  802:     */ 
/*  803: 721 */     jPanelSubtotalLayout.setVerticalGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.lblSubtotalImpuestos).addComponent(this.jLabel23, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel20).addComponent(this.lblSubtotal12)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.lblSubtotal0)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel22, -2, -1, -2).addComponent(this.lblSubtotalNoObjetoIVA)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel25, -2, -1, -2).addComponent(this.lblSubtotalExentoIVA)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorDetallesDescuento, -2, -1, -2).addComponent(this.jLabel29, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel26).addComponent(this.lblValorIce)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel28).addComponent(this.lblValorIRBPNR)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel27).addComponent(this.lblValorIVA)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel30).addComponent(this.lblTotalFactura, -2, 20, -2)).addGap(28, 28, 28)));
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
/*  844:     */ 
/*  845:     */ 
/*  846:     */ 
/*  847:     */ 
/*  848: 766 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel6.border.title", new Object[0])));
/*  849: 767 */     this.jPanel6.setName("jPanel6");
/*  850:     */     
/*  851: 769 */     this.btnFirmarProcesar.setFont(resourceMap.getFont("btnGuardar.font"));
/*  852: 770 */     this.btnFirmarProcesar.setText(resourceMap.getString("btnFirmarProcesar.text", new Object[0]));
/*  853: 771 */     this.btnFirmarProcesar.setName("btnFirmarProcesar");
/*  854: 772 */     this.btnFirmarProcesar.addActionListener(new ActionListener()
/*  855:     */     {
/*  856:     */       public void actionPerformed(ActionEvent evt)
/*  857:     */       {
/*  858: 774 */         NotaCreditoView.this.btnFirmarProcesarActionPerformed(evt);
/*  859:     */       }
/*  860: 777 */     });
/*  861: 778 */     this.jButton4.setFont(resourceMap.getFont("btnGuardar.font"));
/*  862: 779 */     this.jButton4.setText(resourceMap.getString("jButton4.text", new Object[0]));
/*  863: 780 */     this.jButton4.setName("jButton4");
/*  864: 781 */     this.jButton4.addActionListener(new ActionListener()
/*  865:     */     {
/*  866:     */       public void actionPerformed(ActionEvent evt)
/*  867:     */       {
/*  868: 783 */         NotaCreditoView.this.jButton4ActionPerformed(evt);
/*  869:     */       }
/*  870: 786 */     });
/*  871: 787 */     this.btnGuardar.setFont(resourceMap.getFont("btnGuardar.font"));
/*  872: 788 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/*  873: 789 */     this.btnGuardar.setHorizontalTextPosition(0);
/*  874: 790 */     this.btnGuardar.setName("btnGuardar");
/*  875: 791 */     this.btnGuardar.addActionListener(new ActionListener()
/*  876:     */     {
/*  877:     */       public void actionPerformed(ActionEvent evt)
/*  878:     */       {
/*  879: 793 */         NotaCreditoView.this.btnGuardarActionPerformed(evt);
/*  880:     */       }
/*  881: 796 */     });
/*  882: 797 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  883: 798 */     this.jPanel6.setLayout(jPanel6Layout);
/*  884: 799 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.btnFirmarProcesar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnGuardar).addContainerGap(155, 32767)));
/*  885:     */     
/*  886:     */ 
/*  887:     */ 
/*  888:     */ 
/*  889:     */ 
/*  890:     */ 
/*  891:     */ 
/*  892:     */ 
/*  893:     */ 
/*  894:     */ 
/*  895: 810 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnFirmarProcesar).addComponent(this.jButton4).addComponent(this.btnGuardar)).addContainerGap(22, 32767)));
/*  896:     */     
/*  897:     */ 
/*  898:     */ 
/*  899:     */ 
/*  900:     */ 
/*  901:     */ 
/*  902:     */ 
/*  903:     */ 
/*  904:     */ 
/*  905: 820 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel5.border.title", new Object[0])));
/*  906: 821 */     this.jPanel5.setName("jPanel5");
/*  907:     */     
/*  908: 823 */     this.jLabel14.setFont(resourceMap.getFont("jLabel15.font"));
/*  909: 824 */     this.jLabel14.setText(resourceMap.getString("jLabel14.text", new Object[0]));
/*  910: 825 */     this.jLabel14.setName("jLabel14");
/*  911:     */     
/*  912: 827 */     this.comboTipoDocModificado.setFont(resourceMap.getFont("jLabel15.font"));
/*  913: 828 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  914: 829 */     this.comboTipoDocModificado.setName("comboTipoDocModificado");
/*  915:     */     
/*  916: 831 */     this.jLabel18.setFont(resourceMap.getFont("jLabel15.font"));
/*  917: 832 */     this.jLabel18.setText(resourceMap.getString("jLabel18.text", new Object[0]));
/*  918: 833 */     this.jLabel18.setName("jLabel18");
/*  919:     */     
/*  920: 835 */     this.jLabel19.setFont(resourceMap.getFont("jLabel15.font"));
/*  921: 836 */     this.jLabel19.setText(resourceMap.getString("jLabel19.text", new Object[0]));
/*  922: 837 */     this.jLabel19.setName("jLabel19");
/*  923:     */     
/*  924: 839 */     this.textFechaCompModif.setEditable(false);
/*  925: 840 */     this.textFechaCompModif.setFont(resourceMap.getFont("jLabel15.font"));
/*  926: 841 */     this.textFechaCompModif.setName("textFechaCompModif");
/*  927:     */     
/*  928: 843 */     this.textNro1.setFont(resourceMap.getFont("jLabel15.font"));
/*  929: 844 */     this.textNro1.setName("textNro1");
/*  930: 845 */     this.textNro1.addFocusListener(new FocusAdapter()
/*  931:     */     {
/*  932:     */       public void focusLost(FocusEvent evt)
/*  933:     */       {
/*  934: 847 */         NotaCreditoView.this.textNro1FocusLost(evt);
/*  935:     */       }
/*  936: 850 */     });
/*  937: 851 */     this.textNro2.setFont(resourceMap.getFont("jLabel15.font"));
/*  938: 852 */     this.textNro2.setName("textNro2");
/*  939: 853 */     this.textNro2.addFocusListener(new FocusAdapter()
/*  940:     */     {
/*  941:     */       public void focusLost(FocusEvent evt)
/*  942:     */       {
/*  943: 855 */         NotaCreditoView.this.textNro2FocusLost(evt);
/*  944:     */       }
/*  945: 858 */     });
/*  946: 859 */     this.textNro3.setFont(resourceMap.getFont("jLabel15.font"));
/*  947: 860 */     this.textNro3.setName("textNro3");
/*  948: 861 */     this.textNro3.addFocusListener(new FocusAdapter()
/*  949:     */     {
/*  950:     */       public void focusLost(FocusEvent evt)
/*  951:     */       {
/*  952: 863 */         NotaCreditoView.this.textNro3FocusLost(evt);
/*  953:     */       }
/*  954: 866 */     });
/*  955: 867 */     this.jCalendarCompModifica.setName("jCalendarCompModifica");
/*  956:     */     
/*  957: 869 */     this.jScrollPane7.setName("jScrollPane7");
/*  958:     */     
/*  959: 871 */     this.txtMotivo.setColumns(20);
/*  960: 872 */     this.txtMotivo.setFont(resourceMap.getFont("jLabel15.font"));
/*  961: 873 */     this.txtMotivo.setLineWrap(true);
/*  962: 874 */     this.txtMotivo.setRows(3);
/*  963: 875 */     this.txtMotivo.setText(resourceMap.getString("txtMotivo.text", new Object[0]));
/*  964: 876 */     this.txtMotivo.setEnabled(true);
/*  965: 877 */     this.txtMotivo.setName("txtMotivo");
/*  966: 878 */     this.jScrollPane7.setViewportView(this.txtMotivo);
/*  967:     */     
/*  968: 880 */     this.jLabel15.setFont(resourceMap.getFont("jLabel15.font"));
/*  969: 881 */     this.jLabel15.setText(resourceMap.getString("jLabel15.text", new Object[0]));
/*  970: 882 */     this.jLabel15.setName("jLabel15");
/*  971:     */     
/*  972: 884 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  973: 885 */     this.jPanel5.setLayout(jPanel5Layout);
/*  974: 886 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(27, 27, 27).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel15)).addGap(21, 21, 21).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.comboTipoDocModificado, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 255, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textNro1, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textNro2, -2, 32, -2)).addComponent(this.jLabel18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.textFechaCompModif, -2, 92, -2).addComponent(this.textNro3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCalendarCompModifica, -2, -1, -2)).addComponent(this.jScrollPane7, -1, 765, 32767)).addGap(264, 264, 264)));
/*  975:     */     
/*  976:     */ 
/*  977:     */ 
/*  978:     */ 
/*  979:     */ 
/*  980:     */ 
/*  981:     */ 
/*  982:     */ 
/*  983:     */ 
/*  984:     */ 
/*  985:     */ 
/*  986:     */ 
/*  987:     */ 
/*  988:     */ 
/*  989:     */ 
/*  990:     */ 
/*  991:     */ 
/*  992:     */ 
/*  993:     */ 
/*  994:     */ 
/*  995:     */ 
/*  996:     */ 
/*  997:     */ 
/*  998:     */ 
/*  999:     */ 
/* 1000:     */ 
/* 1001:     */ 
/* 1002:     */ 
/* 1003: 915 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel14).addComponent(this.comboTipoDocModificado, -2, 20, -2).addComponent(this.jLabel18).addComponent(this.textFechaCompModif, -2, 20, -2).addComponent(this.jCalendarCompModifica, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel19).addComponent(this.textNro1, -2, 20, -2).addComponent(this.textNro2, -2, 20, -2).addComponent(this.textNro3, -2, 20, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel15).addComponent(this.jScrollPane7, -2, 31, -2)).addContainerGap(18, 32767)));
/* 1004:     */     
/* 1005:     */ 
/* 1006:     */ 
/* 1007:     */ 
/* 1008:     */ 
/* 1009:     */ 
/* 1010:     */ 
/* 1011:     */ 
/* 1012:     */ 
/* 1013:     */ 
/* 1014:     */ 
/* 1015:     */ 
/* 1016:     */ 
/* 1017:     */ 
/* 1018:     */ 
/* 1019:     */ 
/* 1020:     */ 
/* 1021:     */ 
/* 1022:     */ 
/* 1023:     */ 
/* 1024:     */ 
/* 1025: 937 */     this.cabecera1.setMaximumSize(new Dimension(777, 245));
/* 1026: 938 */     this.cabecera1.setMinimumSize(new Dimension(777, 245));
/* 1027: 939 */     this.cabecera1.setName("cabecera1");
/* 1028: 940 */     this.cabecera1.setPreferredSize(new Dimension(777, 245));
/* 1029:     */     
/* 1030: 942 */     this.idenComprob.setName("idenComprob");
/* 1031:     */     
/* 1032: 944 */     GroupLayout layout = new GroupLayout(this);
/* 1033: 945 */     setLayout(layout);
/* 1034: 946 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel5, -1, -1, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.idenComprob, -1, 1213, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.jPanelSubtotal, -2, -1, -2).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.cabecera1, -1, 1213, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -1, -1, 32767).addGap(7, 7, 7)))));
/* 1035:     */     
/* 1036:     */ 
/* 1037:     */ 
/* 1038:     */ 
/* 1039:     */ 
/* 1040:     */ 
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
/* 1058:     */ 
/* 1059:     */ 
/* 1060:     */ 
/* 1061:     */ 
/* 1062: 974 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cabecera1, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.idenComprob, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(9, 9, 9).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addGap(87, 87, 87)).addGroup(layout.createSequentialGroup().addComponent(this.jPanelSubtotal, -1, 296, 32767).addContainerGap()))));
/* 1063:     */     
/* 1064:     */ 
/* 1065:     */ 
/* 1066:     */ 
/* 1067:     */ 
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
/* 1086: 998 */     getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName", new Object[0]));
/* 1087:     */   }
/* 1088:     */   
/* 1089:     */   private void btnNuevoDetalleActionPerformed(ActionEvent evt)
/* 1090:     */   {
/* 1091:1004 */     Component component = (Component)evt.getSource();
/* 1092:1005 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 1093:1006 */     this.modalProductos = new DialogoProductos(frame, true);
/* 1094:1007 */     this.modalProductos.setTitle("Productos");
/* 1095:1008 */     this.modalProductos.setLocationRelativeTo(null);
/* 1096:1009 */     this.modalProductos.setVisible(true);
/* 1097:     */     
/* 1098:1011 */     Producto seleccionado = this.modalProductos.getProducto();
/* 1099:1013 */     if (seleccionado != null)
/* 1100:     */     {
/* 1101:1014 */       boolean existente = false;
/* 1102:1015 */       boolean tieneImpuestos = false;
/* 1103:1017 */       for (int i = 0; i < this.modeloDetalle.getRowCount(); i++)
/* 1104:     */       {
/* 1105:1018 */         String codPrincipal = (String)this.modeloDetalle.getValueAt(i, 1);
/* 1106:1019 */         String codAuxiliar = (String)this.modeloDetalle.getValueAt(i, 2);
/* 1107:1020 */         String nombre = (String)this.modeloDetalle.getValueAt(i, 3);
/* 1108:1021 */         if (seleccionado.verificarProducto(codPrincipal, codAuxiliar, nombre))
/* 1109:     */         {
/* 1110:1022 */           existente = true;
/* 1111:1023 */           break;
/* 1112:     */         }
/* 1113:     */       }
/* 1114:1026 */       if (seleccionado.getImpuestoProducto().isEmpty() == true) {
/* 1115:1027 */         JOptionPane.showMessageDialog(this, "El producto seleccionado, no tiene asignado ningun impuesto,\nfavor edite el producto e ingrese los impuestos", "Se ha producido un error ", 0);
/* 1116:     */       } else {
/* 1117:1030 */         tieneImpuestos = true;
/* 1118:     */       }
/* 1119:1032 */       if ((!existente) && (tieneImpuestos == true))
/* 1120:     */       {
/* 1121:1033 */         this.modeloDetalle.addRow(seleccionado);
/* 1122:1034 */         actualizaDetalle();
/* 1123:     */       }
/* 1124:1035 */       else if (existente == true)
/* 1125:     */       {
/* 1126:1036 */         JOptionPane.showMessageDialog(this, "El ítem seleccionado ya se encuentra en el detalle de la Factura, favor modifique su cantidad", "Se ha producido un error ", 0);
/* 1127:     */       }
/* 1128:     */     }
/* 1129:     */   }
/* 1130:     */   
/* 1131:     */   public void setDate(String dateString)
/* 1132:     */   {
/* 1133:1049 */     Date date = null;
/* 1134:     */     try
/* 1135:     */     {
/* 1136:1051 */       if ((dateString != null) && (dateString.length() > 0)) {
/* 1137:1052 */         date = Constantes.dateFormat.parse(dateString);
/* 1138:     */       }
/* 1139:     */     }
/* 1140:     */     catch (Exception e)
/* 1141:     */     {
/* 1142:1055 */       date = null;
/* 1143:     */     }
/* 1144:1057 */     setDate(date);
/* 1145:     */   }
/* 1146:     */   
/* 1147:     */   public void setDate(Date date)
/* 1148:     */   {
/* 1149:1066 */     String dateString = "";
/* 1150:1067 */     date = FormGenerales.eliminaHora(date);
/* 1151:1068 */     Date hoy = FormGenerales.eliminaHora(new Date());
/* 1152:1069 */     if ((date != null) && ((date.equals(hoy)) || (date.before(hoy))))
/* 1153:     */     {
/* 1154:1070 */       dateString = Constantes.dateFormat.format(date);
/* 1155:1071 */       this.idenComprob.textFechaEmision.setText(dateString);
/* 1156:1072 */       this.idenComprob.jCalendarFecha.setTargetDate(date);
/* 1157:1073 */       this.fechaEmision = date;
/* 1158:     */     }
/* 1159:     */     else
/* 1160:     */     {
/* 1161:1075 */       JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/* 1162:     */     }
/* 1163:     */   }
/* 1164:     */   
/* 1165:     */   public void setDateComprobante(Date date)
/* 1166:     */   {
/* 1167:1085 */     String dateString = "";
/* 1168:1086 */     date = FormGenerales.eliminaHora(date);
/* 1169:1087 */     Date hoy = FormGenerales.eliminaHora(new Date());
/* 1170:1088 */     if ((date != null) && ((date.equals(hoy)) || (date.before(hoy))))
/* 1171:     */     {
/* 1172:1089 */       dateString = Constantes.dateFormat.format(date);
/* 1173:1090 */       this.textFechaCompModif.setText(dateString);
/* 1174:1091 */       this.idenComprob.jCalendarFecha.setTargetDate(date);
/* 1175:     */     }
/* 1176:     */     else
/* 1177:     */     {
/* 1178:1093 */       JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/* 1179:     */     }
/* 1180:     */   }
/* 1181:     */   
/* 1182:     */   public void actualizaClaveDeAcceso()
/* 1183:     */   {
/* 1184:1101 */     this.claveDeAcceso = null;
/* 1185:1102 */     llenaDatosEmisor();
/* 1186:1103 */     this.claveContingencia = new FormGenerales().obtieneClaveDeAcceso(this.secuencialComprobante, this.emisor, this.serie, this.claveDeAcceso, this.fechaEmision, TipoComprobanteEnum.NOTA_DE_CREDITO.getCode());
/* 1187:1106 */     if ((this.claveContingencia.getCodigoComprobante() != null) && (!this.claveContingencia.getCodigoComprobante().isEmpty())) {
/* 1188:1107 */       this.claveDeAcceso = this.claveContingencia.getCodigoComprobante();
/* 1189:     */     }
/* 1190:1109 */     this.idenComprob.lblClaveAcceso.setText(this.claveDeAcceso);
/* 1191:     */   }
/* 1192:     */   
/* 1193:     */   private void buscarCliente(String cadena, int parametro)
/* 1194:     */   {
/* 1195:     */     try
/* 1196:     */     {
/* 1197:1121 */       this.modeloDatosAdicionales.deleteAllRows();
/* 1198:1123 */       if (parametro == 1) {
/* 1199:1124 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(cadena, null, TipoClienteEnum.C);
/* 1200:     */       } else {
/* 1201:1126 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(null, cadena, TipoClienteEnum.C);
/* 1202:     */       }
/* 1203:     */     }
/* 1204:     */     catch (Exception ex)
/* 1205:     */     {
/* 1206:1129 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1207:     */     }
/* 1208:1132 */     if (this.clienteSeleccionado != null)
/* 1209:     */     {
/* 1210:1133 */       this.txtCedulaComprador.setText(this.clienteSeleccionado.getNumeroIdentificacio());
/* 1211:1134 */       this.txtRazonComprador.setText(this.clienteSeleccionado.getApellido());
/* 1212:1135 */       if (!this.clienteSeleccionado.getDireccion().isEmpty()) {
/* 1213:1136 */         this.modeloDatosAdicionales.addRow("Dirección", this.clienteSeleccionado.getDireccion());
/* 1214:     */       }
/* 1215:1138 */       if (this.clienteSeleccionado.getTelefonoConvencional().length() > 1)
/* 1216:     */       {
/* 1217:1139 */         StringBuilder telefono = new StringBuilder(this.clienteSeleccionado.getTelefonoConvencional());
/* 1218:1140 */         if (this.clienteSeleccionado.getExtencion().length() > 1)
/* 1219:     */         {
/* 1220:1141 */           telefono.append(" ext. ");
/* 1221:1142 */           telefono.append(this.clienteSeleccionado.getExtencion());
/* 1222:     */         }
/* 1223:1144 */         this.modeloDatosAdicionales.addRow("Teléfono", telefono.toString());
/* 1224:     */       }
/* 1225:1146 */       this.modeloDatosAdicionales.addRow("Email", this.clienteSeleccionado.getCorreo());
/* 1226:     */     }
/* 1227:     */     else
/* 1228:     */     {
/* 1229:1148 */       JOptionPane.showMessageDialog(this, "No existen registros almacenados para el dato buscado", "Se ha producido un error ", 1);
/* 1230:     */     }
/* 1231:     */   }
/* 1232:     */   
/* 1233:     */   private NotaCredito generarComprobante()
/* 1234:     */   {
/* 1235:1159 */     NotaCredito notaCredito = null;
/* 1236:1160 */     if (!llenarObjetoComprobante())
/* 1237:     */     {
/* 1238:1161 */       notaCredito = this.factory.createNotaCredito();
/* 1239:1162 */       NotaCredito.InfoAdicional informacion = generarInformacionAdicional();
/* 1240:1163 */       notaCredito.setInfoTributaria(this.infoTributaria);
/* 1241:1164 */       notaCredito.setInfoNotaCredito(this.infoNotaCredito);
/* 1242:1165 */       notaCredito.setDetalles(generarDetalle());
/* 1243:1166 */       if (informacion.getCampoAdicional().size() > 0) {
/* 1244:1167 */         notaCredito.setInfoAdicional(informacion);
/* 1245:     */       }
/* 1246:1169 */       notaCredito.setVersion("1.0.0");
/* 1247:1170 */       notaCredito.setId("comprobante");
/* 1248:     */     }
/* 1249:1172 */     return notaCredito;
/* 1250:     */   }
/* 1251:     */   
/* 1252:     */   private NotaCredito.Detalles generarDetalle()
/* 1253:     */   {
/* 1254:1181 */     NotaCredito.Detalles resultado = this.factory.createNotaCreditoDetalles();
/* 1255:1182 */     for (int i = 0; i < this.modeloDetalle.getRowCount(); i++) {
/* 1256:     */       try
/* 1257:     */       {
/* 1258:1184 */         String codigoPrincipal = (String)this.modeloDetalle.getValueAt(i, 1);
/* 1259:1185 */         String codigoAuxiliar = (String)this.modeloDetalle.getValueAt(i, 2);
/* 1260:1186 */         String descripcion = (String)this.modeloDetalle.getValueAt(i, 3);
/* 1261:1187 */         Producto prod = (Producto)new ProductoSQL().obtenerProducto(codigoPrincipal, codigoAuxiliar, descripcion).get(0);
/* 1262:1188 */         BigDecimal descuento = (BigDecimal)this.modeloDetalle.getValueAt(i, 5);
/* 1263:1189 */         NotaCredito.Detalles.Detalle detalle = this.factory.createNotaCreditoDetallesDetalle();
/* 1264:1190 */         if ((prod.getCodigoPrincipal() != null) && (!prod.getCodigoPrincipal().isEmpty())) {
/* 1265:1191 */           detalle.setCodigoInterno(prod.getCodigoPrincipal());
/* 1266:     */         }
/* 1267:1193 */         if ((prod.getCodigoAuxiliar() != null) && (!prod.getCodigoAuxiliar().isEmpty())) {
/* 1268:1194 */           detalle.setCodigoAdicional(prod.getCodigoAuxiliar());
/* 1269:     */         }
/* 1270:1196 */         detalle.setDescripcion(prod.getNombre());
/* 1271:1197 */         detalle.setCantidad(new BigDecimal(Double.parseDouble(this.modeloDetalle.getValueAt(i, 0).toString())).setScale(2, RoundingMode.HALF_UP));
/* 1272:1198 */         detalle.setPrecioUnitario((BigDecimal)this.modeloDetalle.getValueAt(i, 4));
/* 1273:1199 */         detalle.setDescuento(descuento);
/* 1274:1200 */         detalle.setPrecioTotalSinImpuesto((BigDecimal)this.modeloDetalle.getValueAt(i, 6));
/* 1275:1201 */         detalle.setImpuestos(obtenerImpuestosProducto(prod));
/* 1276:1202 */         List<InformacionAdicionalProducto> listaInfo = prod.getInfoAdicionalList();
/* 1277:1203 */         if (!listaInfo.isEmpty())
/* 1278:     */         {
/* 1279:1204 */           NotaCredito.Detalles.Detalle.DetallesAdicionales obj = this.factory.createNotaCreditoDetallesDetalleDetallesAdicionales();
/* 1280:1205 */           for (InformacionAdicionalProducto item : listaInfo)
/* 1281:     */           {
/* 1282:1206 */             NotaCredito.Detalles.Detalle.DetallesAdicionales.DetAdicional det = this.factory.createNotaCreditoDetallesDetalleDetallesAdicionalesDetAdicional();
/* 1283:     */             
/* 1284:1208 */             det.setNombre(item.getAtributo());
/* 1285:1209 */             det.setValor(item.getValor());
/* 1286:1210 */             obj.getDetAdicional().add(det);
/* 1287:     */           }
/* 1288:1212 */           detalle.setDetallesAdicionales(obj);
/* 1289:     */         }
/* 1290:1214 */         resultado.getDetalle().add(detalle);
/* 1291:     */       }
/* 1292:     */       catch (Exception ex)
/* 1293:     */       {
/* 1294:1216 */         Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1295:     */       }
/* 1296:     */     }
/* 1297:1219 */     return resultado;
/* 1298:     */   }
/* 1299:     */   
/* 1300:     */   private NotaCredito.Detalles.Detalle.Impuestos obtenerImpuestosProducto(Producto producto)
/* 1301:     */   {
/* 1302:1230 */     NotaCredito.Detalles.Detalle.Impuestos result = this.factory.createNotaCreditoDetallesDetalleImpuestos();
/* 1303:1231 */     List<SubtotalImpuesto> lista = new ArrayList();
/* 1304:1232 */     if (this.modeloDetalle.getListaIva0().size() > 0) {
/* 1305:1233 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaIva0(), producto));
/* 1306:     */     }
/* 1307:1235 */     if (this.modeloDetalle.getListaIva12().size() > 0) {
/* 1308:1236 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaIva12(), producto));
/* 1309:     */     }
/* 1310:1238 */     if (this.modeloDetalle.getListaNoIva().size() > 0) {
/* 1311:1239 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaNoIva(), producto));
/* 1312:     */     }
/* 1313:1241 */     if (this.modeloDetalle.getListaExentoIVA().size() > 0) {
/* 1314:1242 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaExentoIVA(), producto));
/* 1315:     */     }
/* 1316:1244 */     if (this.modeloDetalle.getListaICE().size() > 0) {
/* 1317:1245 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaICE(), producto));
/* 1318:     */     }
/* 1319:1247 */     if (this.modeloDetalle.getListaIRBPNR().size() > 0) {
/* 1320:1248 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaIRBPNR(), producto));
/* 1321:     */     }
/* 1322:1250 */     for (SubtotalImpuesto s : lista)
/* 1323:     */     {
/* 1324:1251 */       Impuesto i = new Impuesto();
/* 1325:1252 */       i.setCodigo(String.valueOf(s.getCodigoImpuesto()));
/* 1326:1253 */       i.setCodigoPorcentaje(s.getCodigo());
/* 1327:1254 */       i.setTarifa(s.getPorcentaje().multiply(BigDecimal.valueOf(100L).setScale(0, RoundingMode.HALF_UP)));
/* 1328:1255 */       i.setBaseImponible(s.getBaseImponible());
/* 1329:1256 */       i.setValor(s.getSubtotal());
/* 1330:1257 */       result.getImpuesto().add(i);
/* 1331:     */     }
/* 1332:1259 */     return result;
/* 1333:     */   }
/* 1334:     */   
/* 1335:     */   List<SubtotalImpuesto> obtieneItems(List<SubtotalImpuesto> lista, Producto producto)
/* 1336:     */   {
/* 1337:1270 */     List<SubtotalImpuesto> resultado = new ArrayList();
/* 1338:1271 */     for (SubtotalImpuesto s : lista) {
/* 1339:1272 */       if (s.verificarProducto(producto)) {
/* 1340:1273 */         resultado.add(s);
/* 1341:     */       }
/* 1342:     */     }
/* 1343:1276 */     return resultado;
/* 1344:     */   }
/* 1345:     */   
/* 1346:     */   private NotaCredito.InfoAdicional generarInformacionAdicional()
/* 1347:     */   {
/* 1348:1286 */     NotaCredito.InfoAdicional info = this.factory.createNotaCreditoInfoAdicional();
/* 1349:1287 */     for (int i = 0; i < this.modeloDatosAdicionales.getRowCount(); i++)
/* 1350:     */     {
/* 1351:1288 */       NotaCredito.InfoAdicional.CampoAdicional detalle = this.factory.createNotaCreditoInfoAdicionalCampoAdicional();
/* 1352:1289 */       detalle.setNombre((String)this.modeloDatosAdicionales.getValueAt(i, 0));
/* 1353:1290 */       detalle.setValue((String)this.modeloDatosAdicionales.getValueAt(i, 1));
/* 1354:1291 */       info.getCampoAdicional().add(detalle);
/* 1355:     */     }
/* 1356:1293 */     return info;
/* 1357:     */   }
/* 1358:     */   
/* 1359:     */   private TotalConImpuestos.TotalImpuesto obtieneTotal(List<SubtotalImpuesto> lista)
/* 1360:     */   {
/* 1361:1303 */     TotalConImpuestos.TotalImpuesto impuesto = this.factory.createTotalConImpuestosTotalImpuesto();
/* 1362:1304 */     BigDecimal baseImponible = BigDecimal.ZERO;
/* 1363:1305 */     BigDecimal total = BigDecimal.ZERO;
/* 1364:1306 */     SubtotalImpuesto primer = (SubtotalImpuesto)lista.get(0);
/* 1365:1307 */     impuesto.setCodigo(String.valueOf(primer.getCodigoImpuesto()));
/* 1366:1308 */     impuesto.setCodigoPorcentaje(primer.getCodigo());
/* 1367:1309 */     for (SubtotalImpuesto item : lista)
/* 1368:     */     {
/* 1369:1310 */       total = total.add(item.getSubtotal());
/* 1370:1311 */       baseImponible = baseImponible.add(item.getBaseImponible());
/* 1371:     */     }
/* 1372:1313 */     impuesto.setBaseImponible(baseImponible);
/* 1373:1314 */     impuesto.setValor(total);
/* 1374:1315 */     return impuesto;
/* 1375:     */   }
/* 1376:     */   
/* 1377:     */   private TotalConImpuestos generaTotalesImpuesto()
/* 1378:     */   {
/* 1379:1324 */     TotalConImpuestos respuesta = this.factory.createTotalConImpuestos();
/* 1380:1325 */     TotalConImpuestos.TotalImpuesto item = this.factory.createTotalConImpuestosTotalImpuesto();
/* 1381:1326 */     if (this.modeloDetalle.getListaIva0().size() > 0)
/* 1382:     */     {
/* 1383:1327 */       item = obtieneTotal(this.modeloDetalle.getListaIva0());
/* 1384:1328 */       respuesta.getTotalImpuesto().add(item);
/* 1385:     */     }
/* 1386:1330 */     if (this.modeloDetalle.getListaIva12().size() > 0)
/* 1387:     */     {
/* 1388:1331 */       item = obtieneTotal(this.modeloDetalle.getListaIva12());
/* 1389:1332 */       respuesta.getTotalImpuesto().add(item);
/* 1390:     */     }
/* 1391:1334 */     if (this.modeloDetalle.getListaNoIva().size() > 0)
/* 1392:     */     {
/* 1393:1335 */       item = obtieneTotal(this.modeloDetalle.getListaNoIva());
/* 1394:1336 */       respuesta.getTotalImpuesto().add(item);
/* 1395:     */     }
/* 1396:1338 */     if (this.modeloDetalle.getListaExentoIVA().size() > 0)
/* 1397:     */     {
/* 1398:1339 */       item = obtieneTotal(this.modeloDetalle.getListaExentoIVA());
/* 1399:1340 */       respuesta.getTotalImpuesto().add(item);
/* 1400:     */     }
/* 1401:1342 */     if (this.modeloDetalle.getListaICE().size() > 0) {
/* 1402:1343 */       respuesta.getTotalImpuesto().addAll(obtieneTotales(this.modeloDetalle.getListaICE()));
/* 1403:     */     }
/* 1404:1345 */     if (this.modeloDetalle.getListaIRBPNR().size() > 0) {
/* 1405:1346 */       respuesta.getTotalImpuesto().addAll(obtieneTotales(this.modeloDetalle.getListaIRBPNR()));
/* 1406:     */     }
/* 1407:1348 */     return respuesta;
/* 1408:     */   }
/* 1409:     */   
/* 1410:     */   private List<TotalConImpuestos.TotalImpuesto> obtieneTotales(List<SubtotalImpuesto> lista)
/* 1411:     */   {
/* 1412:1359 */     List<TotalConImpuestos.TotalImpuesto> respuesta = new ArrayList();
/* 1413:1360 */     TotalConImpuestos.TotalImpuesto item = null;
/* 1414:1361 */     BigDecimal baseImponible = BigDecimal.ZERO;
/* 1415:1362 */     BigDecimal valorTotalGrupo = BigDecimal.ZERO;
/* 1416:1363 */     String codigoGrupo = null;
/* 1417:1364 */     ArrayList encontrados = new ArrayList();
/* 1418:1365 */     for (SubtotalImpuesto busc : lista)
/* 1419:     */     {
/* 1420:1366 */       baseImponible = BigDecimal.ZERO;
/* 1421:1367 */       valorTotalGrupo = BigDecimal.ZERO;
/* 1422:1368 */       item = this.factory.createTotalConImpuestosTotalImpuesto();
/* 1423:1369 */       codigoGrupo = busc.getCodigo();
/* 1424:1370 */       Collections.sort(encontrados);
/* 1425:1371 */       if (Collections.binarySearch(encontrados, codigoGrupo) < 0)
/* 1426:     */       {
/* 1427:1372 */         for (SubtotalImpuesto i : lista) {
/* 1428:1373 */           if (i.getCodigo().equals(codigoGrupo))
/* 1429:     */           {
/* 1430:1374 */             baseImponible = baseImponible.add(i.getBaseImponible());
/* 1431:1375 */             valorTotalGrupo = valorTotalGrupo.add(i.getSubtotal());
/* 1432:     */           }
/* 1433:     */         }
/* 1434:1378 */         item.setCodigo(String.valueOf(busc.getCodigoImpuesto()));
/* 1435:1379 */         item.setCodigoPorcentaje(codigoGrupo);
/* 1436:1380 */         item.setBaseImponible(baseImponible);
/* 1437:1381 */         item.setValor(valorTotalGrupo);
/* 1438:1382 */         respuesta.add(item);
/* 1439:1383 */         encontrados.add(codigoGrupo);
/* 1440:     */       }
/* 1441:     */     }
/* 1442:1386 */     return respuesta;
/* 1443:     */   }
/* 1444:     */   
/* 1445:     */   private boolean llenarObjetoComprobante()
/* 1446:     */   {
/* 1447:1393 */     StringBuilder mensajes = new StringBuilder();
/* 1448:1394 */     boolean error = false;
/* 1449:1395 */     this.infoTributaria = new InfoTributaria();
/* 1450:1396 */     this.infoTributaria.setSecuencial(this.secuencialComprobante);
/* 1451:1397 */     this.infoTributaria.setAmbiente(this.emisor.getTipoAmbiente());
/* 1452:1398 */     this.infoTributaria.setTipoEmision(this.emisor.getTipoEmision());
/* 1453:1399 */     this.infoTributaria.setRazonSocial(this.emisor.getRazonSocial());
/* 1454:1400 */     this.infoTributaria.setRuc(this.emisor.getRuc());
/* 1455:1401 */     this.infoTributaria.setCodDoc(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode());
/* 1456:1402 */     this.infoTributaria.setEstab(this.emisor.getCodigoEstablecimiento());
/* 1457:1403 */     this.infoTributaria.setPtoEmi(this.emisor.getCodPuntoEmision());
/* 1458:1404 */     this.infoTributaria.setDirMatriz(this.emisor.getDireccionMatriz());
/* 1459:1405 */     if (this.claveDeAcceso != null)
/* 1460:     */     {
/* 1461:1406 */       this.infoTributaria.setClaveAcceso(this.claveDeAcceso);
/* 1462:     */     }
/* 1463:     */     else
/* 1464:     */     {
/* 1465:1408 */       JOptionPane.showMessageDialog(this, "\nLa clave de Acceso no puede ser nula", "Se ha producido un error ", 0);
/* 1466:     */       
/* 1467:1410 */       error = true;
/* 1468:     */     }
/* 1469:1412 */     if ((this.emisor.getNombreComercial() != null) && (!this.emisor.getNombreComercial().isEmpty())) {
/* 1470:1413 */       this.infoTributaria.setNombreComercial(this.emisor.getNombreComercial());
/* 1471:     */     }
/* 1472:1415 */     this.infoNotaCredito = this.factory.createNotaCreditoInfoNotaCredito();
/* 1473:1416 */     this.infoNotaCredito.setFechaEmision(Constantes.dateFormat.format(FormGenerales.eliminaHora(this.fechaEmision)));
/* 1474:1417 */     if ((this.emisor.getDirEstablecimiento() != null) && (!this.emisor.getDirEstablecimiento().isEmpty())) {
/* 1475:1418 */       this.infoNotaCredito.setDirEstablecimiento(this.emisor.getDirEstablecimiento());
/* 1476:     */     }
/* 1477:1420 */     if (this.radioConsumidorF.isSelected())
/* 1478:     */     {
/* 1479:1421 */       this.razonSocialComprador = "CONSUMIDOR FINAL";
/* 1480:1422 */       this.infoNotaCredito.setTipoIdentificacionComprador(TipoCompradorEnum.CONSUMIDOR_FINAL.getCode());
/* 1481:1423 */       this.identificacionComprador = "9999999999999";
/* 1482:1424 */       if (this.totalValorComprobante.compareTo(BigDecimal.valueOf(this.VALOR_MAXIMO_CONSUMIDOR_FINAL)) == 1)
/* 1483:     */       {
/* 1484:1425 */         mensajes.append("No se pueden emitir facturas mayores a USD 200.00 donde el comprador conste como: CONSUMIDOR FINAL");
/* 1485:1426 */         error = true;
/* 1486:     */       }
/* 1487:     */     }
/* 1488:1428 */     else if ((this.radioIdentificacion.isSelected()) && (this.clienteSeleccionado != null))
/* 1489:     */     {
/* 1490:1429 */       this.razonSocialComprador = this.clienteSeleccionado.getApellido();
/* 1491:1430 */       this.identificacionComprador = this.clienteSeleccionado.getNumeroIdentificacio();
/* 1492:1431 */       this.infoNotaCredito.setTipoIdentificacionComprador(TipoCompradorEnum.retornaCodigo(this.clienteSeleccionado.getTipoIdentificacion()));
/* 1493:     */     }
/* 1494:1433 */     this.infoNotaCredito.setIdentificacionComprador(this.identificacionComprador);
/* 1495:1434 */     this.infoNotaCredito.setRazonSocialComprador(this.razonSocialComprador);
/* 1496:1435 */     this.infoNotaCredito.setTotalSinImpuestos(this.subtotalSinImpuestos);
/* 1497:1436 */     this.infoNotaCredito.setValorModificacion(this.totalValorComprobante);
/* 1498:1437 */     this.infoNotaCredito.setMoneda("DOLAR");
/* 1499:1438 */     this.infoNotaCredito.setTotalConImpuestos(generaTotalesImpuesto());
/* 1500:1439 */     if (((String)this.comboTipoDocModificado.getSelectedItem()).equals("FACTURA")) {
/* 1501:1440 */       this.infoNotaCredito.setCodDocModificado(TipoComprobanteEnum.FACTURA.getCode());
/* 1502:     */     }
/* 1503:1442 */     this.infoNotaCredito.setNumDocModificado(this.textNro1.getText() + "-" + this.textNro2.getText() + "-" + this.textNro3.getText());
/* 1504:1443 */     this.infoNotaCredito.setFechaEmisionDocSustento(this.textFechaCompModif.getText());
/* 1505:1444 */     this.infoNotaCredito.setMotivo(this.txtMotivo.getText());
/* 1506:1445 */     if ((this.emisor.getContribuyenteEspecial() != null) && (!this.emisor.getContribuyenteEspecial().isEmpty())) {
/* 1507:1446 */       this.infoNotaCredito.setContribuyenteEspecial(this.emisor.getContribuyenteEspecial());
/* 1508:     */     }
/* 1509:1448 */     if (this.emisor.getLlevaContabilidad() != null) {
/* 1510:1449 */       if (this.emisor.getLlevaContabilidad().equals("S")) {
/* 1511:1450 */         this.infoNotaCredito.setObligadoContabilidad("SI");
/* 1512:     */       } else {
/* 1513:1452 */         this.infoNotaCredito.setObligadoContabilidad("NO");
/* 1514:     */       }
/* 1515:     */     }
/* 1516:1455 */     if (error == true) {
/* 1517:1456 */       JOptionPane.showMessageDialog(this, mensajes.toString(), "Se ha producido un error ", 0);
/* 1518:     */     }
/* 1519:1458 */     return error;
/* 1520:     */   }
/* 1521:     */   
/* 1522:     */   private String validarObligatorios()
/* 1523:     */   {
/* 1524:1462 */     StringBuilder mensajes = new StringBuilder();
/* 1525:1463 */     if ((this.textNro1.getText() == null) || (this.textNro1.getText().isEmpty()) || (this.textNro2.getText() == null) || (this.textNro2.getText().isEmpty()) || (this.textNro3.getText() == null) || (this.textNro3.getText().isEmpty())) {
/* 1526:1466 */       mensajes.append("\nEl número de comprobante es obligatorio y debe ser de 15 caracteres");
/* 1527:     */     }
/* 1528:1468 */     if ((this.textFechaCompModif.getText() == null) || (this.textFechaCompModif.getText().isEmpty())) {
/* 1529:1469 */       mensajes.append("\nIngrese la fecha de emisión del comprobante a modificar");
/* 1530:     */     }
/* 1531:1471 */     if ((this.txtMotivo.getText() == null) || (this.txtMotivo.getText().isEmpty())) {
/* 1532:1472 */       mensajes.append("\nIngrese el motivo de modificación  del comprobante");
/* 1533:     */     }
/* 1534:1475 */     if (this.modeloDetalle.getRowCount() <= 0) {
/* 1535:1476 */       mensajes.append("\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas");
/* 1536:     */     }
/* 1537:1478 */     return mensajes.toString();
/* 1538:     */   }
/* 1539:     */   
/* 1540:     */   private void habilitaCamposCliente()
/* 1541:     */   {
/* 1542:1482 */     this.txtCedulaComprador.setText(null);
/* 1543:1483 */     this.txtRazonComprador.setText(null);
/* 1544:1484 */     this.txtCedulaComprador.setEnabled(true);
/* 1545:1485 */     this.txtRazonComprador.setEnabled(true);
/* 1546:1486 */     this.btnBuscar.setEnabled(true);
/* 1547:     */   }
/* 1548:     */   
/* 1549:     */   private void limpiaDatosCliente()
/* 1550:     */   {
/* 1551:1490 */     this.txtCedulaComprador.setText(null);
/* 1552:1491 */     this.txtRazonComprador.setText(null);
/* 1553:1492 */     this.txtCedulaComprador.setEnabled(false);
/* 1554:1493 */     this.txtRazonComprador.setEnabled(false);
/* 1555:1494 */     this.btnBuscar.setEnabled(false);
/* 1556:1495 */     this.modeloDatosAdicionales.deleteAllRows();
/* 1557:     */   }
/* 1558:     */   
/* 1559:     */   private void btnNuevoDatoActionPerformed(ActionEvent evt)
/* 1560:     */   {
/* 1561:1499 */     this.modeloDatosAdicionales.addRow("", "");
/* 1562:     */   }
/* 1563:     */   
/* 1564:     */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 1565:     */   {
/* 1566:1503 */     if ((this.modeloDetalle.getRowCount() > 0) && (!existenICEVacios()))
/* 1567:     */     {
/* 1568:1504 */       String respuestaCrear = null;
/* 1569:1505 */       String archivoACrear = null;
/* 1570:1506 */       NotaCredito notaLlena = null;
/* 1571:     */       try
/* 1572:     */       {
/* 1573:1508 */         String validaObl = validarObligatorios();
/* 1574:1509 */         if ((validaObl == null) || (validaObl.isEmpty()))
/* 1575:     */         {
/* 1576:1510 */           notaLlena = generarComprobante();
/* 1577:1511 */           String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1578:1512 */           archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1579:1513 */           respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, notaLlena, this.claveContingencia, this.secuencial, TipoComprobanteEnum.NOTA_DE_CREDITO.getCode());
/* 1580:1515 */           if (respuestaCrear == null)
/* 1581:     */           {
/* 1582:1516 */             JOptionPane.showMessageDialog(this, archivoACrear, "El comprobante fue guardado exitósamente", 1);
/* 1583:     */             
/* 1584:1518 */             NotaCreditoReporte ncr = new NotaCreditoReporte(notaLlena);
/* 1585:1519 */             generarReporte(ncr, null, null);
/* 1586:1520 */             this.btnFirmarProcesar.setEnabled(false);
/* 1587:     */           }
/* 1588:     */           else
/* 1589:     */           {
/* 1590:1522 */             JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1591:     */           }
/* 1592:     */         }
/* 1593:     */         else
/* 1594:     */         {
/* 1595:1525 */           JOptionPane.showMessageDialog(this, validaObl, "Campos Obligatorios", 1);
/* 1596:     */         }
/* 1597:     */       }
/* 1598:     */       catch (Exception ex)
/* 1599:     */       {
/* 1600:1529 */         Logger.getLogger(NotaCreditoView.class.getName()).log(Level.SEVERE, null, ex);
/* 1601:     */       }
/* 1602:     */     }
/* 1603:     */     else
/* 1604:     */     {
/* 1605:1532 */       JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE VACIO", 1);
/* 1606:     */     }
/* 1607:     */   }
/* 1608:     */   
/* 1609:     */   public boolean existenICEVacios()
/* 1610:     */   {
/* 1611:1537 */     boolean respuesta = false;
/* 1612:1539 */     for (int i = 0; i < this.modeloDetalle.getRowCount(); i++) {
/* 1613:1540 */       if (((String)this.modeloDetalle.getValueAt(i, 7)).isEmpty() == true)
/* 1614:     */       {
/* 1615:1541 */         respuesta = true;
/* 1616:1542 */         break;
/* 1617:     */       }
/* 1618:     */     }
/* 1619:1545 */     return respuesta;
/* 1620:     */   }
/* 1621:     */   
/* 1622:     */   public void generarReporte(NotaCreditoReporte xml, String numAut, String fechaAut)
/* 1623:     */   {
/* 1624:1549 */     ReporteUtil repUtil = new ReporteUtil();
/* 1625:     */     try
/* 1626:     */     {
/* 1627:1551 */       repUtil.generarReporte("resources/reportes/notaCreditoFinal.jasper", xml, numAut, fechaAut);
/* 1628:     */     }
/* 1629:     */     catch (SQLException ex)
/* 1630:     */     {
/* 1631:1553 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1632:     */     }
/* 1633:     */     catch (ClassNotFoundException ex)
/* 1634:     */     {
/* 1635:1555 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1636:     */     }
/* 1637:     */   }
/* 1638:     */   
/* 1639:     */   private void btnFirmarProcesarActionPerformed(ActionEvent evt)
/* 1640:     */   {
/* 1641:     */     try
/* 1642:     */     {
/* 1643:1560 */       if ((this.modeloDetalle.getRowCount() > 0) && (!existenICEVacios()))
/* 1644:     */       {
/* 1645:1561 */         setCursor(Cursor.getPredefinedCursor(3));
/* 1646:1562 */         this.btnFirmarProcesar.setEnabled(false);
/* 1647:1563 */         if (validarElementosComprobante().booleanValue() == true)
/* 1648:     */         {
/* 1649:1564 */           if (FormGenerales.validarUrl(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == null) {
/* 1650:1565 */             validarConexionCreacion();
/* 1651:     */           } else {
/* 1652:1567 */             JOptionPane.showMessageDialog(this, "URL MAL CONFIGURADO", "URL MAL CONFIGURADO", 1);
/* 1653:     */           }
/* 1654:     */         }
/* 1655:     */         else {
/* 1656:1570 */           JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE DE VENTA VACIO", 1);
/* 1657:     */         }
/* 1658:     */       }
/* 1659:     */       else
/* 1660:     */       {
/* 1661:1573 */         JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE VACIO", 1);
/* 1662:     */       }
/* 1663:     */     }
/* 1664:     */     catch (Exception ex)
/* 1665:     */     {
/* 1666:1577 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1667:1578 */       JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + ex.getMessage(), "Se ha producido un error ", 0);
/* 1668:     */     }
/* 1669:     */     finally
/* 1670:     */     {
/* 1671:1580 */       setCursor(Cursor.getDefaultCursor());
/* 1672:1581 */       this.btnFirmarProcesar.setEnabled(true);
/* 1673:     */     }
/* 1674:     */   }
/* 1675:     */   
/* 1676:     */   private Boolean validarElementosComprobante()
/* 1677:     */   {
/* 1678:1591 */     boolean resp = false;
/* 1679:1592 */     if (this.modeloDetalle.getRowCount() > 0) {
/* 1680:1593 */       resp = true;
/* 1681:     */     }
/* 1682:1595 */     return Boolean.valueOf(resp);
/* 1683:     */   }
/* 1684:     */   
/* 1685:     */   private void validarConexionCreacion()
/* 1686:     */     throws SQLException, ClassNotFoundException, InterruptedException
/* 1687:     */   {
/* 1688:1608 */     String respuestaCrear = null;
/* 1689:     */     
/* 1690:1610 */     NotaCredito notaLlena = generarComprobante();
/* 1691:1611 */     String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1692:1612 */     String archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1693:1615 */     if (FormGenerales.existConnection(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == true)
/* 1694:     */     {
/* 1695:1616 */       if (this.emisor.getTipoEmision().equals(StringUtil.obtenerTipoEmision(TipoEmisionEnum.CONTINGENCIA.getCode())))
/* 1696:     */       {
/* 1697:1617 */         JOptionPane.showMessageDialog(new JPanel(), "Ya existe conexión se cambiara el tipo de emisión a Normal", "Mensaje", 2);
/* 1698:1618 */         actualizaEmisor();
/* 1699:1619 */         emisionNormal(respuestaCrear, archivoACrear, notaLlena, nombreArchivo);
/* 1700:     */       }
/* 1701:     */       else
/* 1702:     */       {
/* 1703:1622 */         emisionNormal(respuestaCrear, archivoACrear, notaLlena, nombreArchivo);
/* 1704:     */       }
/* 1705:     */     }
/* 1706:     */     else
/* 1707:     */     {
/* 1708:1626 */       int i = JOptionPane.showConfirmDialog(null, "No existe conexión.\n Desea emitir en contingencia?", "Advertencia", 0);
/* 1709:1627 */       if (i == 0) {
/* 1710:1628 */         emisionContingencia(notaLlena, archivoACrear, nombreArchivo);
/* 1711:     */       }
/* 1712:     */     }
/* 1713:     */   }
/* 1714:     */   
/* 1715:     */   private void actualizaEmisor()
/* 1716:     */   {
/* 1717:1637 */     this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.NORMAL.getCode(), this.emisor);
/* 1718:     */   }
/* 1719:     */   
/* 1720:     */   private void emisionContingencia(NotaCredito comprobanteXml, String archivoACrear, String nombreArchivo)
/* 1721:     */   {
/* 1722:1648 */     if (FormGenerales.verificarClavesContingencia() == true)
/* 1723:     */     {
/* 1724:1649 */       this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.CONTINGENCIA.getCode(), this.emisor);
/* 1725:1650 */       actualizaClaveDeAcceso();
/* 1726:1651 */       comprobanteXml = generarComprobante();
/* 1727:     */       
/* 1728:1653 */       nombreArchivo = this.claveDeAcceso + ".xml";
/* 1729:1654 */       archivoACrear = archivoACrear.substring(0, archivoACrear.lastIndexOf(File.separator)) + File.separator + nombreArchivo;
/* 1730:     */       
/* 1731:     */ 
/* 1732:1657 */       FormGenerales.creaArchivoEnContingencia(archivoACrear, comprobanteXml, nombreArchivo, this.claveContingencia, this.secuencial, this.emisor, TipoComprobanteEnum.NOTA_DE_CREDITO.getCode());
/* 1733:     */     }
/* 1734:     */     else
/* 1735:     */     {
/* 1736:1660 */       JOptionPane.showMessageDialog(this, "No se han encontrado claves de contingencia en el Sistema", "Claves no existen", 0);
/* 1737:     */     }
/* 1738:     */   }
/* 1739:     */   
/* 1740:     */   private void emisionNormal(String respuestaCrear, String archivoACrear, NotaCredito comprobanteXml, String nombreArchivo)
/* 1741:     */   {
/* 1742:     */     try
/* 1743:     */     {
/* 1744:1674 */       respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobanteXml, this.claveContingencia, this.secuencial, TipoComprobanteEnum.NOTA_DE_CREDITO.getCode());
/* 1745:1677 */       if (respuestaCrear == null)
/* 1746:     */       {
/* 1747:1678 */         if (((System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) && (this.password == null)) {
/* 1748:1681 */           this.password = FormGenerales.ingresaPassword();
/* 1749:     */         }
/* 1750:1685 */         ArchivoUtils.firmarEnviarAutorizar(this.emisor, archivoACrear, nombreArchivo, this.infoTributaria.getRuc(), this.infoTributaria.getCodDoc(), this.claveDeAcceso, this.password);
/* 1751:     */       }
/* 1752:     */       else
/* 1753:     */       {
/* 1754:1687 */         JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1755:     */       }
/* 1756:     */     }
/* 1757:     */     catch (Exception ex)
/* 1758:     */     {
/* 1759:1690 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1760:     */     }
/* 1761:     */   }
/* 1762:     */   
/* 1763:     */   private void obtenerInstancia(Container c)
/* 1764:     */   {
/* 1765:1696 */     if ((c instanceof JFrame))
/* 1766:     */     {
/* 1767:1697 */       System.out.println("ENTRA");
/* 1768:1698 */       JFrame f = (JFrame)c;
/* 1769:1699 */       f.getContentPane().removeAll();
/* 1770:1700 */       JScrollPane jp = new JScrollPane();
/* 1771:1701 */       jp.getViewport().add(new NotaCreditoView());
/* 1772:1702 */       f.getContentPane().add(jp);
/* 1773:1703 */       f.validate();
/* 1774:1704 */       f.repaint();
/* 1775:     */     }
/* 1776:     */     else
/* 1777:     */     {
/* 1778:1706 */       obtenerInstancia(c.getParent());
/* 1779:     */     }
/* 1780:     */   }
/* 1781:     */   
/* 1782:     */   private void jButton4ActionPerformed(ActionEvent evt)
/* 1783:     */   {
/* 1784:1710 */     Container c = this.jButton4.getParent();
/* 1785:1711 */     obtenerInstancia(c);
/* 1786:     */   }
/* 1787:     */   
/* 1788:     */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 1789:     */   {
/* 1790:1716 */     if (!this.txtCedulaComprador.getText().isEmpty()) {
/* 1791:1717 */       buscarCliente(this.txtCedulaComprador.getText(), 1);
/* 1792:1718 */     } else if (!this.txtRazonComprador.getText().isEmpty()) {
/* 1793:1719 */       buscarCliente(this.txtRazonComprador.getText(), 2);
/* 1794:     */     } else {
/* 1795:1721 */       JOptionPane.showMessageDialog(this, "Ingrese el RUC /CI o pasaporte o la Razón Social", "Ingrese campo", 1);
/* 1796:     */     }
/* 1797:     */   }
/* 1798:     */   
/* 1799:     */   private void radioConsumidorFActionPerformed(ActionEvent evt)
/* 1800:     */   {
/* 1801:1727 */     limpiaDatosCliente();
/* 1802:     */   }
/* 1803:     */   
/* 1804:     */   private void radioIdentificacionActionPerformed(ActionEvent evt)
/* 1805:     */   {
/* 1806:1731 */     habilitaCamposCliente();
/* 1807:     */   }
/* 1808:     */   
/* 1809:     */   private void txtRazonCompradorFocusGained(FocusEvent evt)
/* 1810:     */   {
/* 1811:1735 */     this.txtCedulaComprador.setText(null);
/* 1812:     */   }
/* 1813:     */   
/* 1814:     */   private void textNro1FocusLost(FocusEvent evt)
/* 1815:     */   {
/* 1816:     */     try
/* 1817:     */     {
/* 1818:1740 */       this.textNro1.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro1.getText())) }));
/* 1819:     */     }
/* 1820:     */     catch (NumberFormatException ne) {}
/* 1821:     */   }
/* 1822:     */   
/* 1823:     */   private void textNro2FocusLost(FocusEvent evt)
/* 1824:     */   {
/* 1825:     */     try
/* 1826:     */     {
/* 1827:1747 */       this.textNro2.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro2.getText())) }));
/* 1828:     */     }
/* 1829:     */     catch (NumberFormatException ne) {}
/* 1830:     */   }
/* 1831:     */   
/* 1832:     */   private void textNro3FocusLost(FocusEvent evt)
/* 1833:     */   {
/* 1834:     */     try
/* 1835:     */     {
/* 1836:1754 */       this.textNro3.setText(String.format("%09d", new Object[] { Integer.valueOf(Integer.parseInt(this.textNro3.getText())) }));
/* 1837:     */     }
/* 1838:     */     catch (NumberFormatException ne) {}
/* 1839:     */   }
/* 1840:     */   
/* 1841:     */   private void btnAnadirActionPerformed(ActionEvent evt)
/* 1842:     */   {
/* 1843:1760 */     Component component = (Component)evt.getSource();
/* 1844:1761 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 1845:1762 */     this.modalCliente = new DialogoCliente(frame, Boolean.FALSE);
/* 1846:1763 */     this.modalCliente.setSize(841, 573);
/* 1847:1764 */     this.modalCliente.setLocationRelativeTo(null);
/* 1848:1765 */     this.modalCliente.setVisible(true);
/* 1849:     */   }
/* 1850:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.NotaCreditoView
 * JD-Core Version:    0.7.0.1
 */