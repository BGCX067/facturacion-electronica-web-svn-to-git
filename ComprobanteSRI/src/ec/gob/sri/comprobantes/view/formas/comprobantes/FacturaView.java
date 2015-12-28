/*    1:     */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*    2:     */ 
/*    3:     */ import comprobantesdesktop.ComprobantesDesktopApp;
/*    4:     */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*    5:     */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*    6:     */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*    7:     */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*    8:     */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*    9:     */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   10:     */ import ec.gob.sri.comprobantes.exception.TotalDescuentoException;
/*   11:     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   12:     */ import ec.gob.sri.comprobantes.modelo.InformacionAdicionalProducto;
/*   13:     */ import ec.gob.sri.comprobantes.modelo.SubtotalImpuesto;
/*   14:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*   15:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles;
/*   16:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle;
/*   17:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle.DetallesAdicionales;
/*   18:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional;
/*   19:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.Detalles.Detalle.Impuestos;
/*   20:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional;
/*   21:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoAdicional.CampoAdicional;
/*   22:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura;
/*   23:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.TotalConImpuestos;
/*   24:     */ import ec.gob.sri.comprobantes.modelo.factura.Factura.InfoFactura.TotalConImpuestos.TotalImpuesto;
/*   25:     */ import ec.gob.sri.comprobantes.modelo.factura.Impuesto;
/*   26:     */ import ec.gob.sri.comprobantes.modelo.factura.ObjectFactory;
/*   27:     */ import ec.gob.sri.comprobantes.modelo.reportes.FacturaReporte;
/*   28:     */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   29:     */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*   30:     */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   31:     */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   32:     */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   33:     */ import ec.gob.sri.comprobantes.table.model.DatosAdicionalesTableModel;
/*   34:     */ import ec.gob.sri.comprobantes.table.model.EliminarDatoCellEditor;
/*   35:     */ import ec.gob.sri.comprobantes.table.model.EliminarProductoCellEditor;
/*   36:     */ import ec.gob.sri.comprobantes.table.model.EliminarRenderer;
/*   37:     */ import ec.gob.sri.comprobantes.table.model.FacturaModel;
/*   38:     */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*   39:     */ import ec.gob.sri.comprobantes.util.Constantes;
/*   40:     */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*   41:     */ import ec.gob.sri.comprobantes.util.FormGenerales;
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
/*   81:     */ import javax.swing.DefaultCellEditor;
/*   82:     */ import javax.swing.GroupLayout;
/*   83:     */ import javax.swing.GroupLayout.Alignment;
/*   84:     */ import javax.swing.GroupLayout.ParallelGroup;
/*   85:     */ import javax.swing.GroupLayout.SequentialGroup;
/*   86:     */ import javax.swing.ImageIcon;
/*   87:     */ import javax.swing.JButton;
/*   88:     */ import javax.swing.JCheckBox;
/*   89:     */ import javax.swing.JFormattedTextField;
/*   90:     */ import javax.swing.JFrame;
/*   91:     */ import javax.swing.JLabel;
/*   92:     */ import javax.swing.JOptionPane;
/*   93:     */ import javax.swing.JPanel;
/*   94:     */ import javax.swing.JRadioButton;
/*   95:     */ import javax.swing.JScrollPane;
/*   96:     */ import javax.swing.JSeparator;
/*   97:     */ import javax.swing.JTable;
/*   98:     */ import javax.swing.JTextField;
/*   99:     */ import javax.swing.JViewport;
/*  100:     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  101:     */ import javax.swing.SwingUtilities;
/*  102:     */ import javax.swing.table.DefaultTableCellRenderer;
/*  103:     */ import javax.swing.table.DefaultTableModel;
/*  104:     */ import javax.swing.table.TableCellEditor;
/*  105:     */ import javax.swing.table.TableColumn;
/*  106:     */ import javax.swing.table.TableColumnModel;
/*  107:     */ import javax.swing.text.DefaultFormatterFactory;
/*  108:     */ import javax.swing.text.NumberFormatter;
/*  109:     */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*  110:     */ import org.jdesktop.application.Application;
/*  111:     */ import org.jdesktop.application.ApplicationContext;
/*  112:     */ import org.jdesktop.application.ResourceMap;
/*  113:     */ 
/*  114:     */ public final class FacturaView
/*  115:     */   extends JPanel
/*  116:     */ {
/*  117:  88 */   private long VALOR_MAXIMO_CONSUMIDOR_FINAL = 200L;
/*  118:  89 */   private Long secuencial = null;
/*  119:  90 */   private String secuencialComprobante = null;
/*  120:  91 */   private String razonSocialComprador = null;
/*  121:  92 */   private String identificacionComprador = null;
/*  122:  93 */   private InfoTributaria infoTributaria = null;
/*  123:  94 */   private Factura.InfoFactura infoFactura = null;
/*  124:  95 */   private Emisor emisor = null;
/*  125:  96 */   private String serie = null;
/*  126:  97 */   private String claveDeAcceso = null;
/*  127:     */   private Date fechaEmision;
/*  128:  99 */   private BigDecimal subtotal12 = BigDecimal.ZERO;
/*  129: 100 */   private BigDecimal subtotal0 = BigDecimal.ZERO;
/*  130: 101 */   private BigDecimal subtotalNoObjetoIVA = BigDecimal.ZERO;
/*  131: 102 */   private BigDecimal subtotalExentoIVA = BigDecimal.ZERO;
/*  132: 103 */   private BigDecimal subtotalValorICE = BigDecimal.ZERO;
/*  133: 104 */   private BigDecimal subtotalValorIRBPNR = BigDecimal.ZERO;
/*  134: 105 */   private BigDecimal subtotalSinImpuestos = BigDecimal.ZERO;
/*  135: 106 */   private BigDecimal valorIVA = BigDecimal.ZERO;
/*  136: 107 */   private BigDecimal valorPropina = BigDecimal.ZERO;
/*  137: 108 */   private BigDecimal valorDescuento = BigDecimal.ZERO;
/*  138: 109 */   private BigDecimal totalValorFactura = BigDecimal.ZERO;
/*  139:     */   private Clientes clienteSeleccionado;
/*  140: 111 */   private ClaveContingencia claveContingencia = new ClaveContingencia();
/*  141:     */   private DialogoProductos modalProductos;
/*  142:     */   private DialogoCliente modalCliente;
/*  143:     */   private DatosAdicionalesTableModel modeloDatosAdicionales;
/*  144:     */   private FacturaModel modeloDetalle;
/*  145: 116 */   private ObjectFactory facturaFactory = null;
/*  146: 117 */   private String password = null;
/*  147:     */   private JButton btnAnadir;
/*  148:     */   private JButton btnBuscar;
/*  149:     */   private JButton btnFirmarProcesar;
/*  150:     */   private JButton btnGuardar;
/*  151:     */   private JButton btnNuevo;
/*  152:     */   private JButton btnNuevoDato;
/*  153:     */   private JButton btnNuevoDetalle;
/*  154:     */   private Cabecera cabecera1;
/*  155:     */   private JCheckBox chkPropina;
/*  156:     */   private IdentificacionComprobante idenComprob;
/*  157:     */   private ButtonGroup jGroupTipoComprador;
/*  158:     */   private JLabel jLabel16;
/*  159:     */   private JLabel jLabel17;
/*  160:     */   private JLabel jLabel20;
/*  161:     */   private JLabel jLabel21;
/*  162:     */   private JLabel jLabel22;
/*  163:     */   private JLabel jLabel23;
/*  164:     */   private JLabel jLabel25;
/*  165:     */   private JLabel jLabel26;
/*  166:     */   private JLabel jLabel27;
/*  167:     */   private JLabel jLabel28;
/*  168:     */   private JLabel jLabel29;
/*  169:     */   private JLabel jLabel30;
/*  170:     */   private JLabel jLabel32;
/*  171:     */   private JPanel jPanel2;
/*  172:     */   private JPanel jPanel3;
/*  173:     */   private JPanel jPanel4;
/*  174:     */   private JPanel jPanel6;
/*  175:     */   private JPanel jPanelSubtotal;
/*  176:     */   private JScrollPane jScrollPane1;
/*  177:     */   private JScrollPane jScrollPane2;
/*  178:     */   private JSeparator jSeparator2;
/*  179:     */   private JTable jTableDatosAdicionales;
/*  180:     */   private JTable jTableDetalleFactura;
/*  181:     */   private JLabel lblSubtotal0;
/*  182:     */   private JLabel lblSubtotal12;
/*  183:     */   private JLabel lblSubtotalExentoIVA;
/*  184:     */   private JLabel lblSubtotalImpuestos;
/*  185:     */   private JLabel lblSubtotalNoObjetoIVA;
/*  186:     */   private JFormattedTextField lblTotalFactura;
/*  187:     */   private JLabel lblValorICE;
/*  188:     */   private JLabel lblValorIRBPNR;
/*  189:     */   private JLabel lblValorIVA;
/*  190:     */   private JRadioButton radioConsumidorF;
/*  191:     */   private JRadioButton radioIdentificacion;
/*  192:     */   private JTextField txtCedulaComprador;
/*  193:     */   private JTextField txtRazonComprador;
/*  194:     */   private JTextField txtValorPropina;
/*  195:     */   private JTextField txtValorTotalDescuento;
/*  196:     */   
/*  197:     */   public FacturaView()
/*  198:     */   {
/*  199: 123 */     initComponents();
/*  200: 124 */     inicializarDatos();
/*  201: 125 */     actualizaClaveDeAcceso();
/*  202:     */   }
/*  203:     */   
/*  204:     */   public void inicializarDatos()
/*  205:     */   {
/*  206: 129 */     this.facturaFactory = new ObjectFactory();
/*  207:     */     
/*  208: 131 */     this.modeloDatosAdicionales = new DatosAdicionalesTableModel();
/*  209: 132 */     this.jTableDatosAdicionales.setModel(this.modeloDatosAdicionales);
/*  210: 133 */     this.jTableDatosAdicionales.setAutoResizeMode(0);
/*  211: 134 */     TableColumn tc = this.jTableDatosAdicionales.getColumnModel().getColumn(2);
/*  212: 135 */     EliminarDatoCellEditor editord = new EliminarDatoCellEditor(this.jTableDatosAdicionales);
/*  213: 136 */     tc.setCellEditor(editord);
/*  214: 137 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  215: 138 */     setColumnWidthDatosAdicionales();
/*  216:     */     
/*  217: 140 */     this.modeloDetalle = new FacturaModel();
/*  218: 141 */     this.jTableDetalleFactura.setModel(this.modeloDetalle);
/*  219: 142 */     this.jTableDetalleFactura.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
/*  220: 143 */     this.jTableDetalleFactura.setAutoResizeMode(0);
/*  221: 144 */     setColumnWidthDetalle();
/*  222:     */     
/*  223: 146 */     tc = this.jTableDetalleFactura.getColumnModel().getColumn(10);
/*  224: 147 */     EliminarProductoCellEditor editor = new EliminarProductoCellEditor(this.jTableDetalleFactura);
/*  225: 148 */     tc.setCellEditor(editor);
/*  226: 149 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  227:     */     
/*  228: 151 */     DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
/*  229: 152 */     dtcr.setHorizontalAlignment(4);
/*  230: 153 */     tc = this.jTableDetalleFactura.getColumnModel().getColumn(8);
/*  231: 154 */     tc.setCellRenderer(dtcr);
/*  232: 155 */     tc = this.jTableDetalleFactura.getColumnModel().getColumn(9);
/*  233: 156 */     tc.setCellRenderer(dtcr);
/*  234: 157 */     tc = this.jTableDetalleFactura.getColumnModel().getColumn(7);
/*  235: 158 */     tc.setCellRenderer(dtcr);
/*  236: 159 */     tc = this.jTableDetalleFactura.getColumnModel().getColumn(0);
/*  237: 160 */     tc.setCellRenderer(dtcr);
/*  238:     */     
/*  239:     */ 
/*  240: 163 */     this.jTableDetalleFactura.addMouseListener(new MouseAdapter()
/*  241:     */     {
/*  242:     */       public void mouseReleased(MouseEvent e)
/*  243:     */       {
/*  244: 167 */         FacturaView.this.actualizaCeldaTabla();
/*  245:     */       }
/*  246: 170 */     });
/*  247: 171 */     this.jTableDetalleFactura.addKeyListener(new KeyAdapter()
/*  248:     */     {
/*  249:     */       public void keyPressed(KeyEvent e)
/*  250:     */       {
/*  251: 175 */         if ((!FacturaView.this.jTableDetalleFactura.isEditing()) && (FacturaView.this.jTableDetalleFactura.editCellAt(FacturaView.this.jTableDetalleFactura.getSelectedRow(), FacturaView.this.jTableDetalleFactura.getSelectedColumn())))
/*  252:     */         {
/*  253: 176 */           FacturaView.this.jTableDetalleFactura.getEditorComponent().requestFocusInWindow();
/*  254: 177 */           FacturaView.this.btnFirmarProcesar.setEnabled(false);
/*  255: 178 */           FacturaView.this.btnGuardar.setEnabled(false);
/*  256:     */         }
/*  257:     */       }
/*  258:     */       
/*  259:     */       public void keyReleased(KeyEvent e)
/*  260:     */       {
/*  261: 184 */         super.keyReleased(e);
/*  262: 185 */         FacturaView.this.actualizaCeldaTabla();
/*  263: 186 */         FacturaView.this.btnFirmarProcesar.setEnabled(true);
/*  264: 187 */         FacturaView.this.btnGuardar.setEnabled(true);
/*  265:     */       }
/*  266: 191 */     });
/*  267: 192 */     this.idenComprob.jCalendarFecha.addPropertyChangeListener(new PropertyChangeListener()
/*  268:     */     {
/*  269:     */       public void propertyChange(PropertyChangeEvent evt)
/*  270:     */       {
/*  271: 196 */         FacturaView.this.cambioEnBotonDeFecha(evt);
/*  272:     */       }
/*  273:     */     });
/*  274:     */     try
/*  275:     */     {
/*  276: 204 */       ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode());
/*  277: 205 */       if (iv != null)
/*  278:     */       {
/*  279: 206 */         this.secuencial = new ComprobantesSQL().obtenerMaximo(TipoComprobanteEnum.FACTURA.getCode());
/*  280: 207 */         this.secuencialComprobante = String.format("%09d", new Object[] { Long.valueOf(this.secuencial.longValue()) });
/*  281: 208 */         llenaDatosEmisor();
/*  282: 209 */         this.idenComprob.lblEstablecimiento.setText(this.emisor.getCodigoEstablecimiento());
/*  283: 210 */         this.idenComprob.lblPunto.setText(this.emisor.getCodPuntoEmision());
/*  284: 211 */         setDate(new Date());
/*  285:     */       }
/*  286:     */     }
/*  287:     */     catch (Exception ex)
/*  288:     */     {
/*  289: 214 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/*  290:     */     }
/*  291: 217 */     this.idenComprob.lblNumeroComprobante.setText(this.secuencialComprobante);
/*  292:     */   }
/*  293:     */   
/*  294:     */   private void setColumnWidthDetalle()
/*  295:     */   {
/*  296: 221 */     for (int i = 0; i < this.jTableDetalleFactura.getColumnModel().getColumnCount(); i++)
/*  297:     */     {
/*  298: 222 */       TableColumn column = this.jTableDetalleFactura.getColumnModel().getColumn(i);
/*  299: 223 */       if (i == 0) {
/*  300: 224 */         column.setPreferredWidth(75);
/*  301:     */       }
/*  302: 226 */       if (i == 1) {
/*  303: 227 */         column.setPreferredWidth(105);
/*  304:     */       }
/*  305: 229 */       if (i == 2) {
/*  306: 230 */         column.setPreferredWidth(105);
/*  307:     */       }
/*  308: 232 */       if (i == 3) {
/*  309: 233 */         column.setPreferredWidth(250);
/*  310:     */       }
/*  311: 235 */       if (i == 4) {
/*  312: 236 */         column.setPreferredWidth(95);
/*  313:     */       }
/*  314: 238 */       if (i == 7) {
/*  315: 239 */         column.setPreferredWidth(105);
/*  316:     */       }
/*  317: 241 */       if (i == 8) {
/*  318: 242 */         column.setPreferredWidth(105);
/*  319:     */       }
/*  320: 244 */       if (i == 9) {
/*  321: 245 */         column.setPreferredWidth(105);
/*  322:     */       }
/*  323:     */     }
/*  324:     */   }
/*  325:     */   
/*  326:     */   private void setColumnWidthDatosAdicionales()
/*  327:     */   {
/*  328: 251 */     for (int i = 0; i < this.jTableDatosAdicionales.getColumnModel().getColumnCount(); i++)
/*  329:     */     {
/*  330: 252 */       TableColumn column = this.jTableDatosAdicionales.getColumnModel().getColumn(i);
/*  331: 253 */       if (i == 0) {
/*  332: 254 */         column.setPreferredWidth(100);
/*  333:     */       }
/*  334: 256 */       if (i == 1) {
/*  335: 257 */         column.setPreferredWidth(300);
/*  336:     */       }
/*  337: 259 */       if (i == 2) {
/*  338: 260 */         column.setPreferredWidth(105);
/*  339:     */       }
/*  340:     */     }
/*  341:     */   }
/*  342:     */   
/*  343:     */   public void llenaDatosEmisor()
/*  344:     */   {
/*  345: 267 */     this.emisor = FormGenerales.llenaDatosEmisor(this.cabecera1);
/*  346:     */   }
/*  347:     */   
/*  348:     */   private void actualizaCeldaTabla()
/*  349:     */   {
/*  350: 273 */     int row = this.jTableDetalleFactura.getSelectedRow();
/*  351: 274 */     int col = this.jTableDetalleFactura.getSelectedColumn();
/*  352: 275 */     if (col == 0) {
/*  353: 276 */       Double.parseDouble(this.modeloDetalle.getValueAt(row, col).toString());
/*  354:     */     }
/*  355: 278 */     if (col == 5) {
/*  356: 279 */       Double.parseDouble(this.modeloDetalle.getValueAt(row, col).toString());
/*  357:     */     }
/*  358: 281 */     actualizaDetalle();
/*  359:     */   }
/*  360:     */   
/*  361:     */   private void habilitaCamposCliente()
/*  362:     */   {
/*  363: 285 */     this.txtCedulaComprador.setText(null);
/*  364: 286 */     this.txtRazonComprador.setText(null);
/*  365: 287 */     this.txtCedulaComprador.setEnabled(true);
/*  366: 288 */     this.txtRazonComprador.setEnabled(true);
/*  367: 289 */     this.btnBuscar.setEnabled(true);
/*  368: 290 */     this.btnFirmarProcesar.setEnabled(false);
/*  369: 291 */     this.btnGuardar.setEnabled(false);
/*  370:     */   }
/*  371:     */   
/*  372:     */   private void limpiaDatosCliente()
/*  373:     */   {
/*  374: 295 */     this.txtCedulaComprador.setText(null);
/*  375: 296 */     this.txtRazonComprador.setText(null);
/*  376: 297 */     this.txtCedulaComprador.setEnabled(false);
/*  377: 298 */     this.txtRazonComprador.setEnabled(false);
/*  378: 299 */     this.btnBuscar.setEnabled(false);
/*  379: 300 */     this.modeloDatosAdicionales.deleteAllRows();
/*  380: 301 */     this.btnFirmarProcesar.setEnabled(true);
/*  381: 302 */     this.btnGuardar.setEnabled(true);
/*  382:     */   }
/*  383:     */   
/*  384:     */   public void actualizaDetalle()
/*  385:     */   {
/*  386: 312 */     this.subtotal12 = this.modeloDetalle.getSubtotalIva12().setScale(2, RoundingMode.HALF_UP);
/*  387: 313 */     this.subtotal0 = this.modeloDetalle.getSubtotalIva0().setScale(2, RoundingMode.HALF_UP);
/*  388: 314 */     this.subtotalNoObjetoIVA = this.modeloDetalle.getSubtotalNoIva().setScale(2, RoundingMode.HALF_UP);
/*  389: 315 */     this.subtotalExentoIVA = this.modeloDetalle.getSubtotalExentoIVA().setScale(2, RoundingMode.HALF_UP);
/*  390: 316 */     this.subtotalValorICE = this.modeloDetalle.getSubtotalICE().setScale(2, RoundingMode.HALF_UP);
/*  391: 317 */     this.subtotalValorIRBPNR = this.modeloDetalle.getSubtotalIRBPNR().setScale(2, RoundingMode.HALF_UP);
/*  392: 318 */     this.subtotalSinImpuestos = this.subtotal12.add(this.subtotal0.add(this.subtotalNoObjetoIVA)).add(this.subtotalExentoIVA);
/*  393: 319 */     this.valorDescuento = this.modeloDetalle.getTotalDescuento().setScale(2, RoundingMode.HALF_UP);
/*  394: 320 */     this.valorIVA = this.modeloDetalle.calcularTotalIva12().setScale(2, RoundingMode.HALF_UP);
/*  395: 321 */     if (this.txtValorPropina.getText() != null) {
/*  396: 322 */       this.valorPropina = new BigDecimal(this.txtValorPropina.getText());
/*  397:     */     }
/*  398: 324 */     this.lblSubtotal12.setText(this.subtotal12.toString());
/*  399: 325 */     this.lblSubtotal0.setText(this.subtotal0.toString());
/*  400: 326 */     this.lblSubtotalNoObjetoIVA.setText(this.subtotalNoObjetoIVA.toString());
/*  401: 327 */     this.lblSubtotalExentoIVA.setText(this.subtotalExentoIVA.toString());
/*  402: 328 */     this.lblValorICE.setText(this.subtotalValorICE.toString());
/*  403: 329 */     this.lblValorIRBPNR.setText(this.subtotalValorIRBPNR.toString());
/*  404: 330 */     this.lblSubtotalImpuestos.setText(this.subtotalSinImpuestos.toString());
/*  405: 331 */     this.lblValorIVA.setText(this.valorIVA.toString());
/*  406: 332 */     this.totalValorFactura = this.subtotalSinImpuestos.add(this.subtotalValorICE.add(this.valorIVA.add(this.valorPropina)).add(this.subtotalValorIRBPNR));
/*  407: 333 */     this.txtValorTotalDescuento.setText(this.valorDescuento.toString());
/*  408: 334 */     this.lblTotalFactura.setValue(this.totalValorFactura);
/*  409:     */   }
/*  410:     */   
/*  411:     */   private void cambioEnBotonDeFecha(PropertyChangeEvent evt)
/*  412:     */   {
/*  413: 338 */     if ((evt.getNewValue() instanceof Date))
/*  414:     */     {
/*  415: 339 */       setDate((Date)evt.getNewValue());
/*  416: 340 */       actualizaClaveDeAcceso();
/*  417:     */     }
/*  418:     */   }
/*  419:     */   
/*  420:     */   private void initComponents()
/*  421:     */   {
/*  422: 353 */     this.jGroupTipoComprador = new ButtonGroup();
/*  423: 354 */     this.jPanel2 = new JPanel();
/*  424: 355 */     this.radioConsumidorF = new JRadioButton();
/*  425: 356 */     this.radioIdentificacion = new JRadioButton();
/*  426: 357 */     this.jLabel16 = new JLabel();
/*  427: 358 */     this.jLabel17 = new JLabel();
/*  428: 359 */     this.txtCedulaComprador = new JTextField();
/*  429: 360 */     this.btnBuscar = new JButton();
/*  430: 361 */     this.txtRazonComprador = new JTextField();
/*  431: 362 */     this.btnAnadir = new JButton();
/*  432: 363 */     this.jPanel3 = new JPanel();
/*  433: 364 */     this.jScrollPane1 = new JScrollPane();
/*  434: 365 */     this.jTableDetalleFactura = new JTable()
/*  435:     */     {
/*  436:     */       public TableCellEditor getCellEditor(int row, int col)
/*  437:     */       {
/*  438: 369 */         if ((col == 0) || (col == 5))
/*  439:     */         {
/*  440: 370 */           final JFormattedTextField field = new JFormattedTextField(getValueAt(row, col));
/*  441: 371 */           final DefaultCellEditor edit = new DefaultCellEditor(field);
/*  442: 372 */           edit.setClickCountToStart(1);
/*  443: 373 */           field.addFocusListener(new FocusAdapter()
/*  444:     */           {
/*  445:     */             public void focusGained(FocusEvent e)
/*  446:     */             {
/*  447: 375 */               field.selectAll();
/*  448:     */             }
/*  449:     */             
/*  450:     */             public void focusLost(FocusEvent e)
/*  451:     */             {
/*  452: 378 */               field.select(0, 0);
/*  453: 379 */               edit.stopCellEditing();
/*  454:     */             }
/*  455: 381 */           });
/*  456: 382 */           return edit;
/*  457:     */         }
/*  458: 384 */         TableColumn tableColumn = getColumnModel().getColumn(col);
/*  459: 385 */         TableCellEditor editor = tableColumn.getCellEditor();
/*  460: 386 */         if (editor == null) {
/*  461: 387 */           editor = getDefaultEditor(getColumnClass(col));
/*  462:     */         }
/*  463: 389 */         return editor;
/*  464:     */       }
/*  465: 392 */     };
/*  466: 393 */     this.btnNuevoDetalle = new JButton();
/*  467: 394 */     this.jPanel4 = new JPanel();
/*  468: 395 */     this.jScrollPane2 = new JScrollPane();
/*  469: 396 */     this.jTableDatosAdicionales = new JTable();
/*  470: 397 */     this.btnNuevoDato = new JButton();
/*  471: 398 */     this.jPanelSubtotal = new JPanel();
/*  472: 399 */     this.jLabel20 = new JLabel();
/*  473: 400 */     this.jLabel21 = new JLabel();
/*  474: 401 */     this.jLabel22 = new JLabel();
/*  475: 402 */     this.jLabel23 = new JLabel();
/*  476: 403 */     this.jLabel26 = new JLabel();
/*  477: 404 */     this.jLabel27 = new JLabel();
/*  478: 405 */     this.jLabel29 = new JLabel();
/*  479: 406 */     this.jLabel30 = new JLabel();
/*  480: 407 */     this.txtValorPropina = new JTextField();
/*  481: 408 */     this.lblValorIVA = new JLabel();
/*  482: 409 */     this.lblValorICE = new JLabel();
/*  483: 410 */     this.lblSubtotalImpuestos = new JLabel();
/*  484: 411 */     this.lblSubtotalNoObjetoIVA = new JLabel();
/*  485: 412 */     this.lblSubtotal0 = new JLabel();
/*  486: 413 */     this.lblSubtotal12 = new JLabel();
/*  487: 414 */     this.lblTotalFactura = new JFormattedTextField();
/*  488: 415 */     this.jSeparator2 = new JSeparator();
/*  489: 416 */     this.chkPropina = new JCheckBox();
/*  490: 417 */     this.jLabel25 = new JLabel();
/*  491: 418 */     this.lblSubtotalExentoIVA = new JLabel();
/*  492: 419 */     this.jLabel28 = new JLabel();
/*  493: 420 */     this.lblValorIRBPNR = new JLabel();
/*  494: 421 */     this.jLabel32 = new JLabel();
/*  495: 422 */     this.txtValorTotalDescuento = new JTextField();
/*  496: 423 */     this.jPanel6 = new JPanel();
/*  497: 424 */     this.btnFirmarProcesar = new JButton();
/*  498: 425 */     this.btnNuevo = new JButton();
/*  499: 426 */     this.btnGuardar = new JButton();
/*  500: 427 */     this.idenComprob = new IdentificacionComprobante();
/*  501: 428 */     this.cabecera1 = new Cabecera();
/*  502:     */     
/*  503: 430 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(FacturaView.class);
/*  504: 431 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 2, 0, resourceMap.getFont("Form.border.titleFont")));
/*  505: 432 */     setAutoscrolls(true);
/*  506: 433 */     setName("Form");
/*  507: 434 */     addFocusListener(new FocusAdapter()
/*  508:     */     {
/*  509:     */       public void focusGained(FocusEvent evt)
/*  510:     */       {
/*  511: 436 */         FacturaView.this.formFocusGained(evt);
/*  512:     */       }
/*  513: 439 */     });
/*  514: 440 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title", new Object[0]), 0, 0, resourceMap.getFont("jPanel2.border.titleFont")));
/*  515: 441 */     this.jPanel2.setName("jPanel2");
/*  516:     */     
/*  517: 443 */     this.jGroupTipoComprador.add(this.radioConsumidorF);
/*  518: 444 */     this.radioConsumidorF.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  519: 445 */     this.radioConsumidorF.setSelected(true);
/*  520: 446 */     this.radioConsumidorF.setText(resourceMap.getString("radioConsumidorF.text", new Object[0]));
/*  521: 447 */     this.radioConsumidorF.setName("radioConsumidorF");
/*  522: 448 */     this.radioConsumidorF.addActionListener(new ActionListener()
/*  523:     */     {
/*  524:     */       public void actionPerformed(ActionEvent evt)
/*  525:     */       {
/*  526: 450 */         FacturaView.this.radioConsumidorFActionPerformed(evt);
/*  527:     */       }
/*  528: 453 */     });
/*  529: 454 */     this.jGroupTipoComprador.add(this.radioIdentificacion);
/*  530: 455 */     this.radioIdentificacion.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  531: 456 */     this.radioIdentificacion.setText(resourceMap.getString("radioIdentificacion.text", new Object[0]));
/*  532: 457 */     this.radioIdentificacion.setName("radioIdentificacion");
/*  533: 458 */     this.radioIdentificacion.addActionListener(new ActionListener()
/*  534:     */     {
/*  535:     */       public void actionPerformed(ActionEvent evt)
/*  536:     */       {
/*  537: 460 */         FacturaView.this.radioIdentificacionActionPerformed(evt);
/*  538:     */       }
/*  539: 463 */     });
/*  540: 464 */     this.jLabel16.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  541: 465 */     this.jLabel16.setText(resourceMap.getString("jLabel16.text", new Object[0]));
/*  542: 466 */     this.jLabel16.setName("jLabel16");
/*  543:     */     
/*  544: 468 */     this.jLabel17.setFont(resourceMap.getFont("radioConsumidorF.font"));
/*  545: 469 */     this.jLabel17.setText(resourceMap.getString("jLabel17.text", new Object[0]));
/*  546: 470 */     this.jLabel17.setName("jLabel17");
/*  547:     */     
/*  548: 472 */     this.txtCedulaComprador.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  549: 473 */     this.txtCedulaComprador.setText(resourceMap.getString("txtCedulaComprador.text", new Object[0]));
/*  550: 474 */     this.txtCedulaComprador.setEnabled(false);
/*  551: 475 */     this.txtCedulaComprador.setName("txtCedulaComprador");
/*  552:     */     
/*  553: 477 */     this.btnBuscar.setFont(resourceMap.getFont("btnBuscar.font"));
/*  554: 478 */     this.btnBuscar.setText(resourceMap.getString("btnBuscar.text", new Object[0]));
/*  555: 479 */     this.btnBuscar.setEnabled(false);
/*  556: 480 */     this.btnBuscar.setName("btnBuscar");
/*  557: 481 */     this.btnBuscar.addActionListener(new ActionListener()
/*  558:     */     {
/*  559:     */       public void actionPerformed(ActionEvent evt)
/*  560:     */       {
/*  561: 483 */         FacturaView.this.btnBuscarActionPerformed(evt);
/*  562:     */       }
/*  563: 486 */     });
/*  564: 487 */     this.txtRazonComprador.setFont(resourceMap.getFont("txtRazonComprador.font"));
/*  565: 488 */     this.txtRazonComprador.setText(resourceMap.getString("txtRazonComprador.text", new Object[0]));
/*  566: 489 */     this.txtRazonComprador.setEnabled(false);
/*  567: 490 */     this.txtRazonComprador.setName("txtRazonComprador");
/*  568: 491 */     this.txtRazonComprador.addFocusListener(new FocusAdapter()
/*  569:     */     {
/*  570:     */       public void focusGained(FocusEvent evt)
/*  571:     */       {
/*  572: 493 */         FacturaView.this.txtRazonCompradorFocusGained(evt);
/*  573:     */       }
/*  574: 496 */     });
/*  575: 497 */     this.btnAnadir.setFont(resourceMap.getFont("btnBuscar.font"));
/*  576: 498 */     this.btnAnadir.setText(resourceMap.getString("btnAnadir.text", new Object[0]));
/*  577: 499 */     this.btnAnadir.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  578: 500 */     this.btnAnadir.setName("btnAnadir");
/*  579: 501 */     this.btnAnadir.addActionListener(new ActionListener()
/*  580:     */     {
/*  581:     */       public void actionPerformed(ActionEvent evt)
/*  582:     */       {
/*  583: 503 */         FacturaView.this.btnAnadirActionPerformed(evt);
/*  584:     */       }
/*  585: 506 */     });
/*  586: 507 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  587: 508 */     this.jPanel2.setLayout(jPanel2Layout);
/*  588: 509 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.radioConsumidorF).addComponent(this.radioIdentificacion, -2, -1, -2).addComponent(this.jLabel17)).addGap(27, 27, 27).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel16).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtCedulaComprador, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscar, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAnadir, -2, 25, -2)).addComponent(this.txtRazonComprador, -1, 567, 32767)).addContainerGap()));
/*  589:     */     
/*  590:     */ 
/*  591:     */ 
/*  592:     */ 
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
/*  608: 529 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.radioConsumidorF).addComponent(this.jLabel16)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.radioIdentificacion, -2, -1, -2).addComponent(this.txtCedulaComprador, -2, -1, -2).addComponent(this.btnBuscar).addComponent(this.btnAnadir)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jLabel17)).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtRazonComprador, -2, -1, -2))).addContainerGap()));
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
/*  630: 551 */     jPanel2Layout.linkSize(1, new Component[] { this.btnAnadir, this.btnBuscar });
/*  631:     */     
/*  632: 553 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title", new Object[0])));
/*  633: 554 */     this.jPanel3.setName("jPanel3");
/*  634:     */     
/*  635: 556 */     this.jScrollPane1.setName("jScrollPane1");
/*  636:     */     
/*  637: 558 */     this.jTableDetalleFactura.setFont(resourceMap.getFont("jTableDetalleFactura.font"));
/*  638: 559 */     this.jTableDetalleFactura.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/*  639:     */     
/*  640:     */ 
/*  641:     */ 
/*  642:     */ 
/*  643:     */ 
/*  644:     */ 
/*  645:     */ 
/*  646: 567 */     this.jTableDetalleFactura.setName("jTableDetalleFactura");
/*  647: 568 */     this.jTableDetalleFactura.addFocusListener(new FocusAdapter()
/*  648:     */     {
/*  649:     */       public void focusLost(FocusEvent evt)
/*  650:     */       {
/*  651: 570 */         FacturaView.this.jTableDetalleFacturaFocusLost(evt);
/*  652:     */       }
/*  653: 572 */     });
/*  654: 573 */     this.jScrollPane1.setViewportView(this.jTableDetalleFactura);
/*  655:     */     
/*  656: 575 */     this.btnNuevoDetalle.setFont(resourceMap.getFont("btnNuevoDetalle.font"));
/*  657: 576 */     this.btnNuevoDetalle.setText(resourceMap.getString("btnNuevoDetalle.text", new Object[0]));
/*  658: 577 */     this.btnNuevoDetalle.setName("btnNuevoDetalle");
/*  659: 578 */     this.btnNuevoDetalle.addActionListener(new ActionListener()
/*  660:     */     {
/*  661:     */       public void actionPerformed(ActionEvent evt)
/*  662:     */       {
/*  663: 580 */         FacturaView.this.btnNuevoDetalleActionPerformed(evt);
/*  664:     */       }
/*  665: 583 */     });
/*  666: 584 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  667: 585 */     this.jPanel3.setLayout(jPanel3Layout);
/*  668: 586 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnNuevoDetalle).addComponent(this.jScrollPane1, -1, 825, 32767)).addContainerGap()));
/*  669:     */     
/*  670:     */ 
/*  671:     */ 
/*  672:     */ 
/*  673:     */ 
/*  674:     */ 
/*  675:     */ 
/*  676:     */ 
/*  677: 595 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.btnNuevoDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 98, 32767).addContainerGap()));
/*  678:     */     
/*  679:     */ 
/*  680:     */ 
/*  681:     */ 
/*  682:     */ 
/*  683:     */ 
/*  684:     */ 
/*  685:     */ 
/*  686: 604 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel4.border.title", new Object[0])));
/*  687: 605 */     this.jPanel4.setName("jPanel4");
/*  688:     */     
/*  689: 607 */     this.jScrollPane2.setName("jScrollPane2");
/*  690:     */     
/*  691: 609 */     this.jTableDatosAdicionales.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/*  692:     */     
/*  693:     */ 
/*  694:     */ 
/*  695:     */ 
/*  696:     */ 
/*  697:     */ 
/*  698:     */ 
/*  699: 617 */     this.jTableDatosAdicionales.setName("jTableDatosAdicionales");
/*  700: 618 */     this.jScrollPane2.setViewportView(this.jTableDatosAdicionales);
/*  701:     */     
/*  702: 620 */     this.btnNuevoDato.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  703: 621 */     this.btnNuevoDato.setText(resourceMap.getString("btnNuevoDato.text", new Object[0]));
/*  704: 622 */     this.btnNuevoDato.setName("btnNuevoDato");
/*  705: 623 */     this.btnNuevoDato.addActionListener(new ActionListener()
/*  706:     */     {
/*  707:     */       public void actionPerformed(ActionEvent evt)
/*  708:     */       {
/*  709: 625 */         FacturaView.this.btnNuevoDatoActionPerformed(evt);
/*  710:     */       }
/*  711: 628 */     });
/*  712: 629 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  713: 630 */     this.jPanel4.setLayout(jPanel4Layout);
/*  714: 631 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 395, 32767).addComponent(this.btnNuevoDato, -2, 113, -2)).addContainerGap()));
/*  715:     */     
/*  716:     */ 
/*  717:     */ 
/*  718:     */ 
/*  719:     */ 
/*  720:     */ 
/*  721:     */ 
/*  722:     */ 
/*  723: 640 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.btnNuevoDato).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 72, 32767).addContainerGap()));
/*  724:     */     
/*  725:     */ 
/*  726:     */ 
/*  727:     */ 
/*  728:     */ 
/*  729:     */ 
/*  730:     */ 
/*  731:     */ 
/*  732: 649 */     this.jPanelSubtotal.setBorder(BorderFactory.createTitledBorder(""));
/*  733: 650 */     this.jPanelSubtotal.setName("jPanelSubtotal");
/*  734:     */     
/*  735: 652 */     this.jLabel20.setFont(resourceMap.getFont("jLabel23.font"));
/*  736: 653 */     this.jLabel20.setText(resourceMap.getString("jLabel20.text", new Object[0]));
/*  737: 654 */     this.jLabel20.setName("jLabel20");
/*  738:     */     
/*  739: 656 */     this.jLabel21.setFont(resourceMap.getFont("jLabel23.font"));
/*  740: 657 */     this.jLabel21.setText(resourceMap.getString("jLabel21.text", new Object[0]));
/*  741: 658 */     this.jLabel21.setName("jLabel21");
/*  742:     */     
/*  743: 660 */     this.jLabel22.setFont(resourceMap.getFont("jLabel23.font"));
/*  744: 661 */     this.jLabel22.setText(resourceMap.getString("jLabel22.text", new Object[0]));
/*  745: 662 */     this.jLabel22.setName("jLabel22");
/*  746:     */     
/*  747: 664 */     this.jLabel23.setFont(resourceMap.getFont("jLabel23.font"));
/*  748: 665 */     this.jLabel23.setText(resourceMap.getString("jLabel23.text", new Object[0]));
/*  749: 666 */     this.jLabel23.setName("jLabel23");
/*  750:     */     
/*  751: 668 */     this.jLabel26.setFont(resourceMap.getFont("jLabel23.font"));
/*  752: 669 */     this.jLabel26.setText(resourceMap.getString("jLabel26.text", new Object[0]));
/*  753: 670 */     this.jLabel26.setName("jLabel26");
/*  754:     */     
/*  755: 672 */     this.jLabel27.setFont(resourceMap.getFont("jLabel23.font"));
/*  756: 673 */     this.jLabel27.setText(resourceMap.getString("jLabel27.text", new Object[0]));
/*  757: 674 */     this.jLabel27.setName("jLabel27");
/*  758:     */     
/*  759: 676 */     this.jLabel29.setFont(resourceMap.getFont("jLabel23.font"));
/*  760: 677 */     this.jLabel29.setText(resourceMap.getString("jLabel29.text", new Object[0]));
/*  761: 678 */     this.jLabel29.setName("jLabel29");
/*  762:     */     
/*  763: 680 */     this.jLabel30.setFont(resourceMap.getFont("jLabel23.font"));
/*  764: 681 */     this.jLabel30.setText(resourceMap.getString("jLabel30.text", new Object[0]));
/*  765: 682 */     this.jLabel30.setName("jLabel30");
/*  766:     */     
/*  767: 684 */     this.txtValorPropina.setEditable(false);
/*  768: 685 */     this.txtValorPropina.setFont(resourceMap.getFont("jLabel23.font"));
/*  769: 686 */     this.txtValorPropina.setText(resourceMap.getString("txtValorPropina.text", new Object[0]));
/*  770: 687 */     this.txtValorPropina.setName("txtValorPropina");
/*  771: 688 */     this.txtValorPropina.addKeyListener(new KeyAdapter()
/*  772:     */     {
/*  773:     */       public void keyReleased(KeyEvent evt)
/*  774:     */       {
/*  775: 690 */         FacturaView.this.txtValorPropinaKeyReleased(evt);
/*  776:     */       }
/*  777: 693 */     });
/*  778: 694 */     this.lblValorIVA.setFont(resourceMap.getFont("jLabel23.font"));
/*  779: 695 */     this.lblValorIVA.setText(resourceMap.getString("lblValorIVA.text", new Object[0]));
/*  780: 696 */     this.lblValorIVA.setName("lblValorIVA");
/*  781:     */     
/*  782: 698 */     this.lblValorICE.setFont(resourceMap.getFont("jLabel23.font"));
/*  783: 699 */     this.lblValorICE.setText(resourceMap.getString("lblValorICE.text", new Object[0]));
/*  784: 700 */     this.lblValorICE.setName("lblValorICE");
/*  785:     */     
/*  786: 702 */     this.lblSubtotalImpuestos.setFont(resourceMap.getFont("jLabel23.font"));
/*  787: 703 */     this.lblSubtotalImpuestos.setText(resourceMap.getString("lblSubtotalImpuestos.text", new Object[0]));
/*  788: 704 */     this.lblSubtotalImpuestos.setName("lblSubtotalImpuestos");
/*  789:     */     
/*  790: 706 */     this.lblSubtotalNoObjetoIVA.setFont(resourceMap.getFont("jLabel23.font"));
/*  791: 707 */     this.lblSubtotalNoObjetoIVA.setText(resourceMap.getString("lblSubtotalNoObjetoIVA.text", new Object[0]));
/*  792: 708 */     this.lblSubtotalNoObjetoIVA.setName("lblSubtotalNoObjetoIVA");
/*  793:     */     
/*  794: 710 */     this.lblSubtotal0.setFont(resourceMap.getFont("jLabel23.font"));
/*  795: 711 */     this.lblSubtotal0.setText(resourceMap.getString("lblSubtotal0.text", new Object[0]));
/*  796: 712 */     this.lblSubtotal0.setName("lblSubtotal0");
/*  797:     */     
/*  798: 714 */     this.lblSubtotal12.setFont(resourceMap.getFont("jLabel23.font"));
/*  799: 715 */     this.lblSubtotal12.setText(resourceMap.getString("lblSubtotal12.text", new Object[0]));
/*  800: 716 */     this.lblSubtotal12.setName("lblSubtotal12");
/*  801:     */     
/*  802: 718 */     this.lblTotalFactura.setBackground(resourceMap.getColor("lblTotalFactura.background"));
/*  803: 719 */     this.lblTotalFactura.setEditable(false);
/*  804: 720 */     this.lblTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("$#,##0.00;($#,##0.00)"))));
/*  805: 721 */     this.lblTotalFactura.setText(resourceMap.getString("lblTotalFactura.text", new Object[0]));
/*  806: 722 */     this.lblTotalFactura.setMinimumSize(new Dimension(10, 23));
/*  807: 723 */     this.lblTotalFactura.setName("lblTotalFactura");
/*  808:     */     
/*  809: 725 */     this.jSeparator2.setName("jSeparator2");
/*  810:     */     
/*  811: 727 */     this.chkPropina.setText(resourceMap.getString("chkPropina.text", new Object[0]));
/*  812: 728 */     this.chkPropina.setName("chkPropina");
/*  813: 729 */     this.chkPropina.addActionListener(new ActionListener()
/*  814:     */     {
/*  815:     */       public void actionPerformed(ActionEvent evt)
/*  816:     */       {
/*  817: 731 */         FacturaView.this.chkPropinaActionPerformed(evt);
/*  818:     */       }
/*  819: 734 */     });
/*  820: 735 */     this.jLabel25.setFont(resourceMap.getFont("jLabel23.font"));
/*  821: 736 */     this.jLabel25.setText(resourceMap.getString("jLabel25.text", new Object[0]));
/*  822: 737 */     this.jLabel25.setName("jLabel25");
/*  823:     */     
/*  824: 739 */     this.lblSubtotalExentoIVA.setFont(resourceMap.getFont("jLabel23.font"));
/*  825: 740 */     this.lblSubtotalExentoIVA.setText(resourceMap.getString("lblSubtotalExentoIVA.text", new Object[0]));
/*  826: 741 */     this.lblSubtotalExentoIVA.setName("lblSubtotalExentoIVA");
/*  827:     */     
/*  828: 743 */     this.jLabel28.setFont(resourceMap.getFont("jLabel28.font"));
/*  829: 744 */     this.jLabel28.setText(resourceMap.getString("jLabel28.text", new Object[0]));
/*  830: 745 */     this.jLabel28.setName("jLabel28");
/*  831:     */     
/*  832: 747 */     this.lblValorIRBPNR.setFont(resourceMap.getFont("lblValorIRBPNR.font"));
/*  833: 748 */     this.lblValorIRBPNR.setText(resourceMap.getString("lblValorIRBPNR.text", new Object[0]));
/*  834: 749 */     this.lblValorIRBPNR.setName("lblValorIRBPNR");
/*  835:     */     
/*  836: 751 */     this.jLabel32.setFont(resourceMap.getFont("jLabel32.font"));
/*  837: 752 */     this.jLabel32.setText(resourceMap.getString("jLabel32.text", new Object[0]));
/*  838: 753 */     this.jLabel32.setAlignmentY(0.0F);
/*  839: 754 */     this.jLabel32.setName("jLabel32");
/*  840:     */     
/*  841: 756 */     this.txtValorTotalDescuento.setFont(resourceMap.getFont("txtValorTotalDescuento.font"));
/*  842: 757 */     this.txtValorTotalDescuento.setText(resourceMap.getString("txtValorTotalDescuento.text", new Object[0]));
/*  843: 758 */     this.txtValorTotalDescuento.setEnabled(false);
/*  844: 759 */     this.txtValorTotalDescuento.setName("txtValorTotalDescuento");
/*  845: 760 */     this.txtValorTotalDescuento.addKeyListener(new KeyAdapter()
/*  846:     */     {
/*  847:     */       public void keyPressed(KeyEvent evt)
/*  848:     */       {
/*  849: 762 */         FacturaView.this.txtValorTotalDescuentoKeyPressed(evt);
/*  850:     */       }
/*  851:     */       
/*  852:     */       public void keyReleased(KeyEvent evt)
/*  853:     */       {
/*  854: 765 */         FacturaView.this.txtValorTotalDescuentoKeyReleased(evt);
/*  855:     */       }
/*  856: 768 */     });
/*  857: 769 */     GroupLayout jPanelSubtotalLayout = new GroupLayout(this.jPanelSubtotal);
/*  858: 770 */     this.jPanelSubtotal.setLayout(jPanelSubtotalLayout);
/*  859: 771 */     jPanelSubtotalLayout.setHorizontalGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jSeparator2, -2, -1, -2).addGap(408, 408, 408)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addContainerGap().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel21).addComponent(this.jLabel23, -2, 86, -2).addComponent(this.jLabel20).addComponent(this.jLabel22, -2, -1, -2).addComponent(this.jLabel25, -2, -1, -2)).addGap(60, 60, 60)).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.jLabel32, -2, 108, -2).addGap(38, 38, 38)).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.jLabel29, -1, 99, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.chkPropina).addGap(26, 26, 26)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.jLabel30, -1, 86, 32767).addGap(60, 60, 60))))).addGap(5, 5, 5)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel27, -2, 55, -2).addGap(96, 96, 96)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel26, -2, 70, -2).addGap(81, 81, 81)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel28, -2, 96, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.lblValorIRBPNR, -1, 247, 32767).addContainerGap()).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.lblSubtotalNoObjetoIVA, -1, 187, 32767).addContainerGap()).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.lblSubtotalExentoIVA, -1, 247, 32767).addContainerGap()).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.lblSubtotal0, -1, 187, 32767).addContainerGap()).addGroup(jPanelSubtotalLayout.createSequentialGroup().addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblSubtotalImpuestos, -1, 187, 32767).addComponent(this.txtValorTotalDescuento, -1, 187, 32767).addComponent(this.lblValorICE, -1, 187, 32767).addComponent(this.lblValorIVA, -1, 187, 32767).addComponent(this.txtValorPropina, -1, 187, 32767).addComponent(this.lblTotalFactura, -1, 187, 32767)).addGap(70, 70, 70)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addComponent(this.lblSubtotal12, -1, 187, 32767).addContainerGap()))));
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
/*  892:     */ 
/*  893:     */ 
/*  894:     */ 
/*  895:     */ 
/*  896:     */ 
/*  897:     */ 
/*  898:     */ 
/*  899:     */ 
/*  900:     */ 
/*  901:     */ 
/*  902:     */ 
/*  903:     */ 
/*  904:     */ 
/*  905:     */ 
/*  906:     */ 
/*  907:     */ 
/*  908:     */ 
/*  909:     */ 
/*  910:     */ 
/*  911:     */ 
/*  912:     */ 
/*  913:     */ 
/*  914:     */ 
/*  915:     */ 
/*  916:     */ 
/*  917:     */ 
/*  918:     */ 
/*  919:     */ 
/*  920:     */ 
/*  921:     */ 
/*  922:     */ 
/*  923:     */ 
/*  924:     */ 
/*  925:     */ 
/*  926:     */ 
/*  927:     */ 
/*  928:     */ 
/*  929:     */ 
/*  930:     */ 
/*  931: 843 */     jPanelSubtotalLayout.linkSize(0, new Component[] { this.jLabel20, this.jLabel21, this.jLabel22 });
/*  932:     */     
/*  933: 845 */     jPanelSubtotalLayout.linkSize(0, new Component[] { this.lblSubtotal0, this.lblSubtotal12, this.lblSubtotalImpuestos, this.lblSubtotalNoObjetoIVA, this.lblTotalFactura, this.lblValorICE, this.lblValorIVA, this.txtValorPropina });
/*  934:     */     
/*  935: 847 */     jPanelSubtotalLayout.setVerticalGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanelSubtotalLayout.createSequentialGroup().addComponent(this.jLabel23, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel20).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel22, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel25, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel32, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel26).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel28).addGap(11, 11, 11).addComponent(this.jLabel27).addGap(12, 12, 12).addGroup(jPanelSubtotalLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.chkPropina).addComponent(this.jLabel29)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel30).addGap(501, 501, 501).addComponent(this.jSeparator2, -2, 10, -2)).addGroup(jPanelSubtotalLayout.createSequentialGroup().addContainerGap().addComponent(this.lblSubtotalImpuestos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblSubtotal12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblSubtotal0).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblSubtotalNoObjetoIVA).addGap(13, 13, 13).addComponent(this.lblSubtotalExentoIVA).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.txtValorTotalDescuento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblValorICE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblValorIRBPNR).addGap(11, 11, 11).addComponent(this.lblValorIVA).addGap(12, 12, 12).addComponent(this.txtValorPropina, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblTotalFactura, -2, 19, -2).addGap(509, 509, 509)));
/*  936:     */     
/*  937:     */ 
/*  938:     */ 
/*  939:     */ 
/*  940:     */ 
/*  941:     */ 
/*  942:     */ 
/*  943:     */ 
/*  944:     */ 
/*  945:     */ 
/*  946:     */ 
/*  947:     */ 
/*  948:     */ 
/*  949:     */ 
/*  950:     */ 
/*  951:     */ 
/*  952:     */ 
/*  953:     */ 
/*  954:     */ 
/*  955:     */ 
/*  956:     */ 
/*  957:     */ 
/*  958:     */ 
/*  959:     */ 
/*  960:     */ 
/*  961:     */ 
/*  962:     */ 
/*  963:     */ 
/*  964:     */ 
/*  965:     */ 
/*  966:     */ 
/*  967:     */ 
/*  968:     */ 
/*  969:     */ 
/*  970:     */ 
/*  971:     */ 
/*  972:     */ 
/*  973:     */ 
/*  974:     */ 
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
/*  989: 901 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel6.border.title", new Object[0])));
/*  990: 902 */     this.jPanel6.setName("jPanel6");
/*  991:     */     
/*  992: 904 */     this.btnFirmarProcesar.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  993: 905 */     this.btnFirmarProcesar.setText(resourceMap.getString("btnFirmarProcesar.text", new Object[0]));
/*  994: 906 */     this.btnFirmarProcesar.setName("btnFirmarProcesar");
/*  995: 907 */     this.btnFirmarProcesar.addMouseListener(new MouseAdapter()
/*  996:     */     {
/*  997:     */       public void mouseClicked(MouseEvent evt)
/*  998:     */       {
/*  999: 909 */         FacturaView.this.btnFirmarProcesarMouseClicked(evt);
/* 1000:     */       }
/* 1001: 911 */     });
/* 1002: 912 */     this.btnFirmarProcesar.addActionListener(new ActionListener()
/* 1003:     */     {
/* 1004:     */       public void actionPerformed(ActionEvent evt)
/* 1005:     */       {
/* 1006: 914 */         FacturaView.this.btnFirmarProcesarActionPerformed(evt);
/* 1007:     */       }
/* 1008: 917 */     });
/* 1009: 918 */     this.btnNuevo.setFont(resourceMap.getFont("btnNuevoDato.font"));
/* 1010: 919 */     this.btnNuevo.setText(resourceMap.getString("btnNuevo.text", new Object[0]));
/* 1011: 920 */     this.btnNuevo.setName("btnNuevo");
/* 1012: 921 */     this.btnNuevo.addActionListener(new ActionListener()
/* 1013:     */     {
/* 1014:     */       public void actionPerformed(ActionEvent evt)
/* 1015:     */       {
/* 1016: 923 */         FacturaView.this.btnNuevoActionPerformed(evt);
/* 1017:     */       }
/* 1018: 926 */     });
/* 1019: 927 */     this.btnGuardar.setFont(resourceMap.getFont("btnNuevoDato.font"));
/* 1020: 928 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/* 1021: 929 */     this.btnGuardar.setName("btnGuardar");
/* 1022: 930 */     this.btnGuardar.addActionListener(new ActionListener()
/* 1023:     */     {
/* 1024:     */       public void actionPerformed(ActionEvent evt)
/* 1025:     */       {
/* 1026: 932 */         FacturaView.this.btnGuardarActionPerformed(evt);
/* 1027:     */       }
/* 1028: 935 */     });
/* 1029: 936 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1030: 937 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1031: 938 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.btnFirmarProcesar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNuevo, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGuardar).addContainerGap(15, 32767)));
/* 1032:     */     
/* 1033:     */ 
/* 1034:     */ 
/* 1035:     */ 
/* 1036:     */ 
/* 1037:     */ 
/* 1038:     */ 
/* 1039:     */ 
/* 1040:     */ 
/* 1041:     */ 
/* 1042: 949 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnFirmarProcesar).addComponent(this.btnNuevo).addComponent(this.btnGuardar)).addContainerGap(-1, 32767)));
/* 1043:     */     
/* 1044:     */ 
/* 1045:     */ 
/* 1046:     */ 
/* 1047:     */ 
/* 1048:     */ 
/* 1049:     */ 
/* 1050:     */ 
/* 1051:     */ 
/* 1052: 959 */     this.idenComprob.setName("idenComprob");
/* 1053:     */     
/* 1054: 961 */     this.cabecera1.setName("cabecera1");
/* 1055:     */     
/* 1056: 963 */     GroupLayout layout = new GroupLayout(this);
/* 1057: 964 */     setLayout(layout);
/* 1058: 965 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanelSubtotal, -2, -1, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.cabecera1, GroupLayout.Alignment.LEADING, -1, 855, 32767).addComponent(this.idenComprob, -1, 855, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -1, -1, 32767).addGap(8, 8, 8)))));
/* 1059:     */     
/* 1060:     */ 
/* 1061:     */ 
/* 1062:     */ 
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
/* 1082: 989 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cabecera1, -2, 216, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.idenComprob, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2)).addComponent(this.jPanelSubtotal, -2, 339, -2)).addContainerGap(-1, 32767)));
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
/* 1102:1009 */     getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName", new Object[0]));
/* 1103:     */   }
/* 1104:     */   
/* 1105:     */   private void btnNuevoDetalleActionPerformed(ActionEvent evt)
/* 1106:     */   {
/* 1107:1014 */     Component component = (Component)evt.getSource();
/* 1108:1015 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 1109:1016 */     this.modalProductos = new DialogoProductos(frame, true);
/* 1110:1017 */     this.modalProductos.setLocationRelativeTo(null);
/* 1111:1018 */     this.modalProductos.setVisible(true);
/* 1112:     */     
/* 1113:1020 */     Producto seleccionado = this.modalProductos.getProducto();
/* 1114:1022 */     if (seleccionado != null)
/* 1115:     */     {
/* 1116:1024 */       boolean existente = false;
/* 1117:1025 */       boolean tieneImpuestos = false;
/* 1118:1027 */       for (int i = 0; i < this.modeloDetalle.getRowCount(); i++)
/* 1119:     */       {
/* 1120:1028 */         String codPrincipal = (String)this.modeloDetalle.getValueAt(i, 1);
/* 1121:1029 */         String codAuxiliar = (String)this.modeloDetalle.getValueAt(i, 2);
/* 1122:1030 */         String nombre = (String)this.modeloDetalle.getValueAt(i, 3);
/* 1123:1031 */         if (seleccionado.verificarProducto(codPrincipal, codAuxiliar, nombre))
/* 1124:     */         {
/* 1125:1032 */           existente = true;
/* 1126:1033 */           break;
/* 1127:     */         }
/* 1128:     */       }
/* 1129:1037 */       if (seleccionado.getImpuestoProducto().isEmpty() == true) {
/* 1130:1038 */         JOptionPane.showMessageDialog(this, "El producto seleccionado, no tiene asignado ningun impuesto,\nfavor edite el producto e ingrese los impuestos", "Se ha producido un error ", 0);
/* 1131:     */       } else {
/* 1132:1041 */         tieneImpuestos = true;
/* 1133:     */       }
/* 1134:1045 */       if ((!existente) && (tieneImpuestos == true))
/* 1135:     */       {
/* 1136:1046 */         this.modeloDetalle.addRow(seleccionado);
/* 1137:1047 */         actualizaDetalle();
/* 1138:     */       }
/* 1139:1048 */       else if (existente == true)
/* 1140:     */       {
/* 1141:1049 */         JOptionPane.showMessageDialog(this, "El ítem seleccionado ya se encuentra en el detalle de la Factura, favor modifique su cantidad", "Se ha producido un error ", 0);
/* 1142:     */       }
/* 1143:     */     }
/* 1144:     */   }
/* 1145:     */   
/* 1146:     */   public void setDate(String dateString)
/* 1147:     */   {
/* 1148:1062 */     Date date = null;
/* 1149:     */     try
/* 1150:     */     {
/* 1151:1064 */       if ((dateString != null) && (dateString.length() > 0)) {
/* 1152:1065 */         date = Constantes.dateFormat.parse(dateString);
/* 1153:     */       }
/* 1154:     */     }
/* 1155:     */     catch (Exception e)
/* 1156:     */     {
/* 1157:1068 */       date = null;
/* 1158:     */     }
/* 1159:1070 */     setDate(date);
/* 1160:     */   }
/* 1161:     */   
/* 1162:     */   public void setDate(Date date)
/* 1163:     */   {
/* 1164:1080 */     String dateString = "";
/* 1165:1081 */     date = FormGenerales.eliminaHora(date);
/* 1166:1082 */     if ((date != null) && ((date.equals(new Date())) || (date.before(new Date()))))
/* 1167:     */     {
/* 1168:1083 */       dateString = Constantes.dateFormat.format(date);
/* 1169:1084 */       this.idenComprob.textFechaEmision.setText(dateString);
/* 1170:1085 */       this.idenComprob.jCalendarFecha.setTargetDate(date);
/* 1171:1086 */       this.fechaEmision = date;
/* 1172:     */     }
/* 1173:     */     else
/* 1174:     */     {
/* 1175:1088 */       JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/* 1176:     */     }
/* 1177:     */   }
/* 1178:     */   
/* 1179:     */   public void actualizaClaveDeAcceso()
/* 1180:     */   {
/* 1181:1096 */     this.claveDeAcceso = null;
/* 1182:1097 */     llenaDatosEmisor();
/* 1183:1098 */     this.claveContingencia = new FormGenerales().obtieneClaveDeAcceso(this.secuencialComprobante, this.emisor, this.serie, this.claveDeAcceso, this.fechaEmision, TipoComprobanteEnum.FACTURA.getCode());
/* 1184:1101 */     if ((this.claveContingencia.getCodigoComprobante() != null) && (!this.claveContingencia.getCodigoComprobante().isEmpty())) {
/* 1185:1102 */       this.claveDeAcceso = this.claveContingencia.getCodigoComprobante();
/* 1186:     */     }
/* 1187:1104 */     this.idenComprob.lblClaveAcceso.setText(this.claveDeAcceso);
/* 1188:     */   }
/* 1189:     */   
/* 1190:     */   private void buscarCliente(String cadena, int parametro)
/* 1191:     */   {
/* 1192:     */     try
/* 1193:     */     {
/* 1194:1116 */       this.modeloDatosAdicionales.deleteAllRows();
/* 1195:1117 */       this.btnFirmarProcesar.setEnabled(false);
/* 1196:1118 */       this.btnGuardar.setEnabled(false);
/* 1197:1120 */       if (parametro == 1) {
/* 1198:1121 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(cadena, null, TipoClienteEnum.C);
/* 1199:     */       } else {
/* 1200:1123 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(null, cadena, TipoClienteEnum.C);
/* 1201:     */       }
/* 1202:     */     }
/* 1203:     */     catch (Exception ex)
/* 1204:     */     {
/* 1205:1126 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1206:     */     }
/* 1207:1129 */     if (this.clienteSeleccionado != null)
/* 1208:     */     {
/* 1209:1130 */       this.txtCedulaComprador.setText(this.clienteSeleccionado.getNumeroIdentificacio());
/* 1210:1131 */       this.txtRazonComprador.setText(this.clienteSeleccionado.getApellido());
/* 1211:1132 */       if (!this.clienteSeleccionado.getDireccion().isEmpty()) {
/* 1212:1133 */         this.modeloDatosAdicionales.addRow("Dirección", this.clienteSeleccionado.getDireccion());
/* 1213:     */       }
/* 1214:1136 */       if (this.clienteSeleccionado.getTelefonoConvencional().length() > 1)
/* 1215:     */       {
/* 1216:1137 */         StringBuilder telefono = new StringBuilder(this.clienteSeleccionado.getTelefonoConvencional());
/* 1217:1138 */         if (this.clienteSeleccionado.getExtencion().length() > 1)
/* 1218:     */         {
/* 1219:1139 */           telefono.append(" ext. ");
/* 1220:1140 */           telefono.append(this.clienteSeleccionado.getExtencion());
/* 1221:     */         }
/* 1222:1142 */         this.modeloDatosAdicionales.addRow("Teléfono", telefono.toString());
/* 1223:     */       }
/* 1224:1144 */       this.modeloDatosAdicionales.addRow("Email", this.clienteSeleccionado.getCorreo());
/* 1225:1145 */       this.btnFirmarProcesar.setEnabled(true);
/* 1226:1146 */       this.btnGuardar.setEnabled(true);
/* 1227:     */     }
/* 1228:     */     else
/* 1229:     */     {
/* 1230:1150 */       JOptionPane.showMessageDialog(this, "No existen registros almacenados para el dato buscado", "Se ha producido un error ", 1);
/* 1231:     */     }
/* 1232:     */   }
/* 1233:     */   
/* 1234:     */   private Factura generarComprobante()
/* 1235:     */   {
/* 1236:1160 */     Factura factura = null;
/* 1237:     */     try
/* 1238:     */     {
/* 1239:1162 */       if (!llenarObjetoComprobante())
/* 1240:     */       {
/* 1241:1163 */         Factura.Detalles detalles = generarDetalle();
/* 1242:1164 */         Factura.InfoAdicional informacion = generarInformacionAdicional();
/* 1243:1165 */         factura = new Factura();
/* 1244:1166 */         factura.setInfoTributaria(this.infoTributaria);
/* 1245:1167 */         factura.setInfoFactura(this.infoFactura);
/* 1246:1168 */         if (detalles != null) {
/* 1247:1169 */           factura.setDetalles(detalles);
/* 1248:     */         }
/* 1249:1171 */         if (informacion.getCampoAdicional().size() > 0) {
/* 1250:1172 */           factura.setInfoAdicional(informacion);
/* 1251:     */         }
/* 1252:1174 */         factura.setVersion("1.0.0");
/* 1253:1175 */         factura.setId("comprobante");
/* 1254:     */       }
/* 1255:     */     }
/* 1256:     */     catch (TotalDescuentoException ex)
/* 1257:     */     {
/* 1258:1178 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1259:1179 */       JOptionPane.showMessageDialog(this, ex.getMessage(), "Se ha producido un error ", 1);
/* 1260:     */     }
/* 1261:1181 */     return factura;
/* 1262:     */   }
/* 1263:     */   
/* 1264:     */   private Factura.Detalles.Detalle.Impuestos obtenerImpuestosProducto(Producto producto)
/* 1265:     */   {
/* 1266:1193 */     Factura.Detalles.Detalle.Impuestos result = this.facturaFactory.createFacturaDetallesDetalleImpuestos();
/* 1267:1194 */     List<SubtotalImpuesto> lista = new ArrayList();
/* 1268:1196 */     if (this.modeloDetalle.getListaIva0().size() > 0) {
/* 1269:1197 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaIva0(), producto));
/* 1270:     */     }
/* 1271:1199 */     if (this.modeloDetalle.getListaIva12().size() > 0) {
/* 1272:1200 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaIva12(), producto));
/* 1273:     */     }
/* 1274:1202 */     if (this.modeloDetalle.getListaNoIva().size() > 0) {
/* 1275:1203 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaNoIva(), producto));
/* 1276:     */     }
/* 1277:1205 */     if (this.modeloDetalle.getListaICE().size() > 0) {
/* 1278:1206 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaICE(), producto));
/* 1279:     */     }
/* 1280:1208 */     if (this.modeloDetalle.getListaExentoIVA().size() > 0) {
/* 1281:1209 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaExentoIVA(), producto));
/* 1282:     */     }
/* 1283:1211 */     if (this.modeloDetalle.getListaIRBPNR().size() > 0) {
/* 1284:1212 */       lista.addAll(obtieneItems(this.modeloDetalle.getListaIRBPNR(), producto));
/* 1285:     */     }
/* 1286:1216 */     for (SubtotalImpuesto s : lista)
/* 1287:     */     {
/* 1288:1217 */       Impuesto i = new Impuesto();
/* 1289:1218 */       i.setCodigo(String.valueOf(s.getCodigoImpuesto()));
/* 1290:1219 */       i.setCodigoPorcentaje(s.getCodigo());
/* 1291:1220 */       i.setTarifa(s.getPorcentaje().multiply(BigDecimal.valueOf(100L).setScale(0, RoundingMode.HALF_UP)));
/* 1292:1221 */       i.setBaseImponible(s.getBaseImponible());
/* 1293:1222 */       i.setValor(s.getSubtotal());
/* 1294:     */       
/* 1295:1224 */       result.getImpuesto().add(i);
/* 1296:     */     }
/* 1297:1227 */     return result;
/* 1298:     */   }
/* 1299:     */   
/* 1300:     */   private List<SubtotalImpuesto> obtieneItems(List<SubtotalImpuesto> lista, Producto producto)
/* 1301:     */   {
/* 1302:1239 */     List<SubtotalImpuesto> resultado = new ArrayList();
/* 1303:1241 */     for (SubtotalImpuesto s : lista) {
/* 1304:1242 */       if (s.verificarProducto(producto)) {
/* 1305:1243 */         resultado.add(s);
/* 1306:     */       }
/* 1307:     */     }
/* 1308:1246 */     return resultado;
/* 1309:     */   }
/* 1310:     */   
/* 1311:     */   private Factura.Detalles generarDetalle()
/* 1312:     */   {
/* 1313:1256 */     Factura.Detalles resultado = this.facturaFactory.createFacturaDetalles();
/* 1314:1260 */     for (int i = 0; i < this.modeloDetalle.getRowCount(); i++) {
/* 1315:     */       try
/* 1316:     */       {
/* 1317:1262 */         String codigoPrincipal = (String)this.modeloDetalle.getValueAt(i, 1);
/* 1318:1263 */         String codigoAuxiliar = (String)this.modeloDetalle.getValueAt(i, 2);
/* 1319:1264 */         String descripcion = (String)this.modeloDetalle.getValueAt(i, 3);
/* 1320:1265 */         Producto prod = (Producto)new ProductoSQL().obtenerProducto(codigoPrincipal, codigoAuxiliar, descripcion).get(0);
/* 1321:1266 */         Factura.Detalles.Detalle detalle = this.facturaFactory.createFacturaDetallesDetalle();
/* 1322:1267 */         if ((prod.getCodigoPrincipal() != null) && (!prod.getCodigoPrincipal().isEmpty())) {
/* 1323:1268 */           detalle.setCodigoPrincipal(prod.getCodigoPrincipal());
/* 1324:     */         }
/* 1325:1270 */         if ((prod.getCodigoAuxiliar() != null) && (!prod.getCodigoAuxiliar().isEmpty())) {
/* 1326:1271 */           detalle.setCodigoAuxiliar(prod.getCodigoAuxiliar());
/* 1327:     */         }
/* 1328:1283 */         detalle.setDescripcion(prod.getNombre());
/* 1329:1284 */         detalle.setCantidad(new BigDecimal(Double.parseDouble(this.modeloDetalle.getValueAt(i, 0).toString())).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros());
/* 1330:1285 */         detalle.setPrecioUnitario((BigDecimal)this.modeloDetalle.getValueAt(i, 4));
/* 1331:1286 */         detalle.setDescuento((BigDecimal)this.modeloDetalle.getValueAt(i, 5));
/* 1332:1287 */         detalle.setPrecioTotalSinImpuesto((BigDecimal)this.modeloDetalle.getValueAt(i, 6));
/* 1333:     */         
/* 1334:     */ 
/* 1335:1290 */         detalle.setImpuestos(obtenerImpuestosProducto(prod));
/* 1336:     */         
/* 1337:     */ 
/* 1338:1293 */         List<InformacionAdicionalProducto> listaInfo = prod.getInfoAdicionalList();
/* 1339:1295 */         if (!listaInfo.isEmpty())
/* 1340:     */         {
/* 1341:1296 */           Factura.Detalles.Detalle.DetallesAdicionales obj = this.facturaFactory.createFacturaDetallesDetalleDetallesAdicionales();
/* 1342:1298 */           for (InformacionAdicionalProducto item : listaInfo)
/* 1343:     */           {
/* 1344:1299 */             Factura.Detalles.Detalle.DetallesAdicionales.DetAdicional det = this.facturaFactory.createFacturaDetallesDetalleDetallesAdicionalesDetAdicional();
/* 1345:     */             
/* 1346:1301 */             det.setNombre(item.getAtributo());
/* 1347:1302 */             det.setValor(item.getValor());
/* 1348:1303 */             obj.getDetAdicional().add(det);
/* 1349:     */           }
/* 1350:1305 */           detalle.setDetallesAdicionales(obj);
/* 1351:     */         }
/* 1352:1307 */         resultado.getDetalle().add(detalle);
/* 1353:     */       }
/* 1354:     */       catch (Exception ex)
/* 1355:     */       {
/* 1356:1309 */         Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1357:     */       }
/* 1358:     */     }
/* 1359:1312 */     return resultado;
/* 1360:     */   }
/* 1361:     */   
/* 1362:     */   private Factura.InfoAdicional generarInformacionAdicional()
/* 1363:     */   {
/* 1364:1323 */     Factura.InfoAdicional info = this.facturaFactory.createFacturaInfoAdicional();
/* 1365:1325 */     for (int i = 0; i < this.modeloDatosAdicionales.getRowCount(); i++)
/* 1366:     */     {
/* 1367:1326 */       Factura.InfoAdicional.CampoAdicional detalle = new Factura.InfoAdicional.CampoAdicional();
/* 1368:1327 */       detalle.setNombre((String)this.modeloDatosAdicionales.getValueAt(i, 0));
/* 1369:1328 */       detalle.setValue((String)this.modeloDatosAdicionales.getValueAt(i, 1));
/* 1370:     */       
/* 1371:1330 */       info.getCampoAdicional().add(detalle);
/* 1372:     */     }
/* 1373:1332 */     return info;
/* 1374:     */   }
/* 1375:     */   
/* 1376:     */   private Factura.InfoFactura.TotalConImpuestos.TotalImpuesto obtieneTotal(List<SubtotalImpuesto> lista)
/* 1377:     */   {
/* 1378:1343 */     Factura.InfoFactura.TotalConImpuestos.TotalImpuesto impuesto = new Factura.InfoFactura.TotalConImpuestos.TotalImpuesto();
/* 1379:1344 */     BigDecimal baseImponible = BigDecimal.ZERO;
/* 1380:1345 */     BigDecimal total = BigDecimal.ZERO;
/* 1381:     */     
/* 1382:1347 */     SubtotalImpuesto primer = (SubtotalImpuesto)lista.get(0);
/* 1383:     */     
/* 1384:1349 */     impuesto.setCodigo(String.valueOf(primer.getCodigoImpuesto()));
/* 1385:1350 */     impuesto.setCodigoPorcentaje(primer.getCodigo());
/* 1386:1352 */     for (SubtotalImpuesto item : lista)
/* 1387:     */     {
/* 1388:1353 */       total = total.add(item.getSubtotal());
/* 1389:1354 */       baseImponible = baseImponible.add(item.getBaseImponible());
/* 1390:     */     }
/* 1391:1357 */     impuesto.setBaseImponible(baseImponible);
/* 1392:1358 */     impuesto.setValor(total);
/* 1393:     */     
/* 1394:1360 */     return impuesto;
/* 1395:     */   }
/* 1396:     */   
/* 1397:     */   private List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto> obtieneTotales(List<SubtotalImpuesto> lista)
/* 1398:     */   {
/* 1399:1372 */     List<Factura.InfoFactura.TotalConImpuestos.TotalImpuesto> respuesta = new ArrayList();
/* 1400:     */     
/* 1401:1374 */     Factura.InfoFactura.TotalConImpuestos.TotalImpuesto totalImpuesto = null;
/* 1402:     */     
/* 1403:1376 */     BigDecimal baseImponibleGrupo = BigDecimal.ZERO;
/* 1404:1377 */     BigDecimal valorTotalGrupo = BigDecimal.ZERO;
/* 1405:1378 */     String codigoGrupo = null;
/* 1406:1379 */     ArrayList encontrados = new ArrayList();
/* 1407:1381 */     for (SubtotalImpuesto subtotal : lista)
/* 1408:     */     {
/* 1409:1382 */       totalImpuesto = this.facturaFactory.createFacturaInfoFacturaTotalConImpuestosTotalImpuesto();
/* 1410:1383 */       codigoGrupo = subtotal.getCodigo();
/* 1411:1384 */       Collections.sort(encontrados);
/* 1412:1385 */       baseImponibleGrupo = BigDecimal.ZERO;
/* 1413:1386 */       valorTotalGrupo = BigDecimal.ZERO;
/* 1414:1387 */       if (Collections.binarySearch(encontrados, codigoGrupo) < 0)
/* 1415:     */       {
/* 1416:1388 */         for (SubtotalImpuesto i : lista) {
/* 1417:1389 */           if (i.getCodigo().equals(codigoGrupo))
/* 1418:     */           {
/* 1419:1390 */             baseImponibleGrupo = baseImponibleGrupo.add(i.getBaseImponible());
/* 1420:1391 */             valorTotalGrupo = valorTotalGrupo.add(i.getSubtotal());
/* 1421:     */           }
/* 1422:     */         }
/* 1423:1394 */         totalImpuesto.setCodigo(String.valueOf(subtotal.getCodigoImpuesto()));
/* 1424:1395 */         totalImpuesto.setCodigoPorcentaje(codigoGrupo);
/* 1425:1396 */         totalImpuesto.setBaseImponible(baseImponibleGrupo);
/* 1426:1397 */         totalImpuesto.setValor(valorTotalGrupo);
/* 1427:1398 */         respuesta.add(totalImpuesto);
/* 1428:1399 */         encontrados.add(codigoGrupo);
/* 1429:     */       }
/* 1430:     */     }
/* 1431:1402 */     return respuesta;
/* 1432:     */   }
/* 1433:     */   
/* 1434:     */   private Factura.InfoFactura.TotalConImpuestos generaTotalesImpuesto()
/* 1435:     */   {
/* 1436:1412 */     Factura.InfoFactura.TotalConImpuestos respuesta = this.facturaFactory.createFacturaInfoFacturaTotalConImpuestos();
/* 1437:1413 */     Factura.InfoFactura.TotalConImpuestos.TotalImpuesto item = this.facturaFactory.createFacturaInfoFacturaTotalConImpuestosTotalImpuesto();
/* 1438:1415 */     if (this.modeloDetalle.getListaIva0().size() > 0)
/* 1439:     */     {
/* 1440:1416 */       item = obtieneTotal(this.modeloDetalle.getListaIva0());
/* 1441:1417 */       respuesta.getTotalImpuesto().add(item);
/* 1442:     */     }
/* 1443:1419 */     if (this.modeloDetalle.getListaIva12().size() > 0)
/* 1444:     */     {
/* 1445:1420 */       item = obtieneTotal(this.modeloDetalle.getListaIva12());
/* 1446:1421 */       respuesta.getTotalImpuesto().add(item);
/* 1447:     */     }
/* 1448:1423 */     if (this.modeloDetalle.getListaNoIva().size() > 0)
/* 1449:     */     {
/* 1450:1424 */       item = obtieneTotal(this.modeloDetalle.getListaNoIva());
/* 1451:1425 */       respuesta.getTotalImpuesto().add(item);
/* 1452:     */     }
/* 1453:1427 */     if (this.modeloDetalle.getListaExentoIVA().size() > 0)
/* 1454:     */     {
/* 1455:1428 */       item = obtieneTotal(this.modeloDetalle.getListaExentoIVA());
/* 1456:1429 */       respuesta.getTotalImpuesto().add(item);
/* 1457:     */     }
/* 1458:1431 */     if (this.modeloDetalle.getListaICE().size() > 0) {
/* 1459:1432 */       respuesta.getTotalImpuesto().addAll(obtieneTotales(this.modeloDetalle.getListaICE()));
/* 1460:     */     }
/* 1461:1434 */     if (this.modeloDetalle.getListaIRBPNR().size() > 0) {
/* 1462:1435 */       respuesta.getTotalImpuesto().addAll(obtieneTotales(this.modeloDetalle.getListaIRBPNR()));
/* 1463:     */     }
/* 1464:1437 */     return respuesta;
/* 1465:     */   }
/* 1466:     */   
/* 1467:     */   private boolean llenarObjetoComprobante()
/* 1468:     */     throws TotalDescuentoException
/* 1469:     */   {
/* 1470:1446 */     if (this.valorDescuento.compareTo(this.totalValorFactura) > 0) {
/* 1471:1447 */       throw new TotalDescuentoException("El valor total de la factura no puede ser menor ha 0");
/* 1472:     */     }
/* 1473:1450 */     boolean error = false;
/* 1474:1451 */     this.infoTributaria = new InfoTributaria();
/* 1475:1452 */     this.infoTributaria.setSecuencial(this.secuencialComprobante);
/* 1476:1453 */     this.infoTributaria.setAmbiente(this.emisor.getTipoAmbiente());
/* 1477:1454 */     this.infoTributaria.setTipoEmision(this.emisor.getTipoEmision());
/* 1478:1455 */     this.infoTributaria.setRazonSocial(this.emisor.getRazonSocial());
/* 1479:1456 */     this.infoTributaria.setRuc(this.emisor.getRuc());
/* 1480:1457 */     this.infoTributaria.setCodDoc(TipoComprobanteEnum.FACTURA.getCode());
/* 1481:1458 */     this.infoTributaria.setEstab(this.emisor.getCodigoEstablecimiento());
/* 1482:1459 */     this.infoTributaria.setPtoEmi(this.emisor.getCodPuntoEmision());
/* 1483:1460 */     this.infoTributaria.setDirMatriz(this.emisor.getDireccionMatriz());
/* 1484:1462 */     if (this.claveDeAcceso != null)
/* 1485:     */     {
/* 1486:1463 */       this.infoTributaria.setClaveAcceso(this.claveDeAcceso);
/* 1487:     */     }
/* 1488:     */     else
/* 1489:     */     {
/* 1490:1465 */       JOptionPane.showMessageDialog(this, "\nLa clave de Acceso no puede ser nula", "Se ha producido un error ", 0);
/* 1491:     */       
/* 1492:1467 */       error = true;
/* 1493:     */     }
/* 1494:1470 */     if ((this.emisor.getNombreComercial() != null) && (!this.emisor.getNombreComercial().isEmpty())) {
/* 1495:1471 */       this.infoTributaria.setNombreComercial(this.emisor.getNombreComercial());
/* 1496:     */     }
/* 1497:1474 */     this.infoFactura = this.facturaFactory.createFacturaInfoFactura();
/* 1498:1475 */     this.infoFactura.setFechaEmision(Constantes.dateFormat.format(FormGenerales.eliminaHora(this.fechaEmision)));
/* 1499:1477 */     if ((this.emisor.getDirEstablecimiento() != null) && (!this.emisor.getDirEstablecimiento().isEmpty())) {
/* 1500:1478 */       this.infoFactura.setDirEstablecimiento(this.emisor.getDirEstablecimiento());
/* 1501:     */     }
/* 1502:1480 */     String guiaRemision = this.idenComprob.textGuia1.getText() + "-" + this.idenComprob.textGuia2.getText() + "-" + this.idenComprob.textGuia3.getText();
/* 1503:1481 */     if (guiaRemision.length() == 17)
/* 1504:     */     {
/* 1505:1482 */       this.infoFactura.setGuiaRemision(guiaRemision);
/* 1506:     */     }
/* 1507:1483 */     else if (guiaRemision.length() != 2)
/* 1508:     */     {
/* 1509:1484 */       JOptionPane.showMessageDialog(this, "Guía de Remisión debe ser de 15 números: ej: 123-123-123456789", "Se ha producido un error ", 0);
/* 1510:     */       
/* 1511:1486 */       error = true;
/* 1512:     */     }
/* 1513:1488 */     if (this.radioConsumidorF.isSelected())
/* 1514:     */     {
/* 1515:1489 */       this.razonSocialComprador = "CONSUMIDOR FINAL";
/* 1516:1490 */       this.infoFactura.setTipoIdentificacionComprador(TipoCompradorEnum.CONSUMIDOR_FINAL.getCode());
/* 1517:1491 */       this.identificacionComprador = "9999999999999";
/* 1518:1492 */       if (this.totalValorFactura.compareTo(BigDecimal.valueOf(this.VALOR_MAXIMO_CONSUMIDOR_FINAL)) == 1)
/* 1519:     */       {
/* 1520:1493 */         JOptionPane.showMessageDialog(this, "No se pueden emitir facturas mayores a USD 200.00 donde el comprador conste como: CONSUMIDOR FINAL", "Se ha producido un error ", 0);
/* 1521:     */         
/* 1522:1495 */         error = true;
/* 1523:     */       }
/* 1524:     */     }
/* 1525:1497 */     else if ((this.radioIdentificacion.isSelected()) && (this.clienteSeleccionado != null))
/* 1526:     */     {
/* 1527:1498 */       this.razonSocialComprador = this.clienteSeleccionado.getApellido();
/* 1528:1499 */       this.identificacionComprador = this.clienteSeleccionado.getNumeroIdentificacio();
/* 1529:1500 */       this.infoFactura.setTipoIdentificacionComprador(TipoCompradorEnum.retornaCodigo(this.clienteSeleccionado.getTipoIdentificacion()));
/* 1530:     */     }
/* 1531:1502 */     this.infoFactura.setIdentificacionComprador(this.identificacionComprador);
/* 1532:1503 */     this.infoFactura.setRazonSocialComprador(this.razonSocialComprador);
/* 1533:1504 */     this.infoFactura.setTotalSinImpuestos(this.subtotalSinImpuestos);
/* 1534:1505 */     this.infoFactura.setTotalDescuento(this.valorDescuento);
/* 1535:1506 */     if (this.valorPropina.compareTo(this.subtotalSinImpuestos.multiply(BigDecimal.valueOf(0.1D)).setScale(2, RoundingMode.HALF_UP)) <= 0)
/* 1536:     */     {
/* 1537:1507 */       this.infoFactura.setPropina(this.valorPropina);
/* 1538:     */     }
/* 1539:     */     else
/* 1540:     */     {
/* 1541:1509 */       JOptionPane.showMessageDialog(this, "El valor ingresado en el campo Propina exede o es menor al 10% del Subtotal ", "Se ha producido un error ", 0);
/* 1542:     */       
/* 1543:1511 */       error = true;
/* 1544:     */     }
/* 1545:1513 */     if (this.valorPropina.floatValue() == 0.0F) {
/* 1546:1514 */       this.infoFactura.setPropina(BigDecimal.ZERO.setScale(2));
/* 1547:     */     }
/* 1548:1516 */     this.infoFactura.setImporteTotal(this.totalValorFactura);
/* 1549:1517 */     this.infoFactura.setMoneda("DOLAR");
/* 1550:1518 */     this.infoFactura.setTotalConImpuestos(generaTotalesImpuesto());
/* 1551:1519 */     if ((this.emisor.getContribuyenteEspecial() != null) && (!this.emisor.getContribuyenteEspecial().isEmpty())) {
/* 1552:1520 */       this.infoFactura.setContribuyenteEspecial(this.emisor.getContribuyenteEspecial());
/* 1553:     */     }
/* 1554:1522 */     if (this.emisor.getLlevaContabilidad() != null) {
/* 1555:1523 */       if (this.emisor.getLlevaContabilidad().equals("S")) {
/* 1556:1524 */         this.infoFactura.setObligadoContabilidad("SI");
/* 1557:     */       } else {
/* 1558:1526 */         this.infoFactura.setObligadoContabilidad("NO");
/* 1559:     */       }
/* 1560:     */     }
/* 1561:1529 */     return error;
/* 1562:     */   }
/* 1563:     */   
/* 1564:     */   private void txtValorPropinaKeyReleased(KeyEvent evt) {}
/* 1565:     */   
/* 1566:     */   private void btnNuevoDatoActionPerformed(ActionEvent evt)
/* 1567:     */   {
/* 1568:1543 */     this.modeloDatosAdicionales.addRow("", "");
/* 1569:     */   }
/* 1570:     */   
/* 1571:     */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 1572:     */   {
/* 1573:1547 */     visualizar();
/* 1574:     */   }
/* 1575:     */   
/* 1576:     */   public boolean existenICEVacios()
/* 1577:     */   {
/* 1578:1556 */     boolean respuesta = false;
/* 1579:1558 */     for (int i = 0; i < this.modeloDetalle.getRowCount(); i++) {
/* 1580:1559 */       if (((String)this.modeloDetalle.getValueAt(i, 7)).isEmpty() == true)
/* 1581:     */       {
/* 1582:1560 */         respuesta = true;
/* 1583:1561 */         break;
/* 1584:     */       }
/* 1585:     */     }
/* 1586:1564 */     return respuesta;
/* 1587:     */   }
/* 1588:     */   
/* 1589:     */   private void visualizar()
/* 1590:     */   {
/* 1591:1573 */     String respuesta = null;
/* 1592:1574 */     String archivoACrear = null;
/* 1593:1575 */     Factura facturaLLena = null;
/* 1594:     */     try
/* 1595:     */     {
/* 1596:1578 */       if ((this.modeloDetalle.getRowCount() > 0) && (!existenICEVacios()))
/* 1597:     */       {
/* 1598:1580 */         facturaLLena = generarComprobante();
/* 1599:1581 */         archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + this.claveDeAcceso + ".xml";
/* 1600:1582 */         respuesta = ArchivoUtils.crearArchivoXml2(archivoACrear, facturaLLena, this.claveContingencia, this.secuencial, TipoComprobanteEnum.FACTURA.getCode());
/* 1601:1583 */         if (respuesta == null) {
/* 1602:1584 */           JOptionPane.showMessageDialog(this, archivoACrear, "El comprobante fue guardado exitósamente", 1);
/* 1603:     */         }
/* 1604:1587 */         FacturaReporte factura = new FacturaReporte(facturaLLena);
/* 1605:1588 */         generarReporte(factura, null, null);
/* 1606:1589 */         this.btnFirmarProcesar.setEnabled(false);
/* 1607:     */       }
/* 1608:     */       else
/* 1609:     */       {
/* 1610:1591 */         JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE VACIO", 1);
/* 1611:     */       }
/* 1612:     */     }
/* 1613:     */     catch (Exception ex)
/* 1614:     */     {
/* 1615:1595 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1616:     */     }
/* 1617:     */   }
/* 1618:     */   
/* 1619:     */   public void generarReporte(FacturaReporte xml, String numAut, String fechaAut)
/* 1620:     */   {
/* 1621:1601 */     ReporteUtil repUtil = new ReporteUtil();
/* 1622:     */     try
/* 1623:     */     {
/* 1624:1604 */       repUtil.generarReporte("resources/reportes/factura.jasper", xml, numAut, fechaAut);
/* 1625:     */     }
/* 1626:     */     catch (SQLException ex)
/* 1627:     */     {
/* 1628:1606 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1629:     */     }
/* 1630:     */     catch (ClassNotFoundException ex)
/* 1631:     */     {
/* 1632:1608 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1633:     */     }
/* 1634:     */   }
/* 1635:     */   
/* 1636:     */   private void btnFirmarProcesarActionPerformed(ActionEvent evt)
/* 1637:     */   {
/* 1638:     */     try
/* 1639:     */     {
/* 1640:1614 */       setCursor(Cursor.getPredefinedCursor(3));
/* 1641:1615 */       this.btnFirmarProcesar.setEnabled(false);
/* 1642:1616 */       if (validarElementosComprobante().booleanValue() == true)
/* 1643:     */       {
/* 1644:1617 */         if (FormGenerales.validarUrl(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == null) {
/* 1645:1618 */           validarConexionCreacion();
/* 1646:     */         } else {
/* 1647:1620 */           JOptionPane.showMessageDialog(this, "URL MAL CONFIGURADO", "URL MAL CONFIGURADO", 1);
/* 1648:     */         }
/* 1649:     */       }
/* 1650:     */       else {
/* 1651:1623 */         JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE DE VENTA VACIO", 1);
/* 1652:     */       }
/* 1653:     */     }
/* 1654:     */     catch (Exception ex)
/* 1655:     */     {
/* 1656:1626 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1657:1627 */       JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + ex.getMessage(), "Se ha producido un error ", 0);
/* 1658:     */     }
/* 1659:     */     finally
/* 1660:     */     {
/* 1661:1629 */       setCursor(Cursor.getDefaultCursor());
/* 1662:1630 */       this.btnFirmarProcesar.setEnabled(true);
/* 1663:     */     }
/* 1664:     */   }
/* 1665:     */   
/* 1666:     */   private Boolean validarElementosComprobante()
/* 1667:     */   {
/* 1668:1640 */     boolean respuesta = false;
/* 1669:1641 */     if ((this.modeloDetalle.getRowCount() > 0) && (!existenICEVacios())) {
/* 1670:1642 */       respuesta = true;
/* 1671:     */     }
/* 1672:1644 */     return Boolean.valueOf(respuesta);
/* 1673:     */   }
/* 1674:     */   
/* 1675:     */   private void validarConexionCreacion()
/* 1676:     */     throws SQLException, ClassNotFoundException, InterruptedException
/* 1677:     */   {
/* 1678:1657 */     String respuestaCrear = null;
/* 1679:     */     
/* 1680:1659 */     Factura comprobanteXml = generarComprobante();
/* 1681:1660 */     String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1682:1661 */     String archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1683:1664 */     if (FormGenerales.existConnection(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == true)
/* 1684:     */     {
/* 1685:1665 */       if (this.emisor.getTipoEmision().equals(StringUtil.obtenerTipoEmision(TipoEmisionEnum.CONTINGENCIA.getCode())))
/* 1686:     */       {
/* 1687:1666 */         JOptionPane.showMessageDialog(new JPanel(), "Ya existe conexión se cambiara el tipo de emisión a Normal", "Mensaje", 2);
/* 1688:1667 */         actualizaEmisor();
/* 1689:1668 */         emisionNormal(respuestaCrear, archivoACrear, comprobanteXml, nombreArchivo);
/* 1690:     */       }
/* 1691:     */       else
/* 1692:     */       {
/* 1693:1670 */         emisionNormal(respuestaCrear, archivoACrear, comprobanteXml, nombreArchivo);
/* 1694:     */       }
/* 1695:     */     }
/* 1696:     */     else
/* 1697:     */     {
/* 1698:1674 */       int i = JOptionPane.showConfirmDialog(null, "No existe conexión.\n Desea emitir en contingencia?", "Advertencia", 0);
/* 1699:1675 */       if (i == 0) {
/* 1700:1676 */         emisionContingencia(comprobanteXml, archivoACrear, nombreArchivo);
/* 1701:     */       }
/* 1702:     */     }
/* 1703:     */   }
/* 1704:     */   
/* 1705:     */   private void actualizaEmisor()
/* 1706:     */   {
/* 1707:1682 */     this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.NORMAL.getCode(), this.emisor);
/* 1708:     */   }
/* 1709:     */   
/* 1710:     */   private void emisionContingencia(Factura comprobanteXml, String archivoACrear, String nombreArchivo)
/* 1711:     */   {
/* 1712:1693 */     if (FormGenerales.verificarClavesContingencia() == true)
/* 1713:     */     {
/* 1714:1694 */       this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.CONTINGENCIA.getCode(), this.emisor);
/* 1715:1695 */       actualizaClaveDeAcceso();
/* 1716:1696 */       comprobanteXml = generarComprobante();
/* 1717:     */       
/* 1718:1698 */       nombreArchivo = this.claveDeAcceso + ".xml";
/* 1719:1699 */       archivoACrear = archivoACrear.substring(0, archivoACrear.lastIndexOf(File.separator)) + File.separator + nombreArchivo;
/* 1720:     */       
/* 1721:     */ 
/* 1722:1702 */       FormGenerales.creaArchivoEnContingencia(archivoACrear, comprobanteXml, nombreArchivo, this.claveContingencia, this.secuencial, this.emisor, TipoComprobanteEnum.FACTURA.getCode());
/* 1723:     */     }
/* 1724:     */     else
/* 1725:     */     {
/* 1726:1705 */       JOptionPane.showMessageDialog(this, "No se han encontrado claves de contingencia en el Sistema", "Claves no existen", 0);
/* 1727:     */     }
/* 1728:     */   }
/* 1729:     */   
/* 1730:     */   private void emisionNormal(String respuestaCrear, String archivoACrear, Factura comprobanteXml, String nombreArchivo)
/* 1731:     */   {
/* 1732:     */     try
/* 1733:     */     {
/* 1734:1719 */       respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobanteXml, this.claveContingencia, this.secuencial, TipoComprobanteEnum.FACTURA.getCode());
/* 1735:1721 */       if (respuestaCrear == null)
/* 1736:     */       {
/* 1737:1723 */         if (((System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) && (this.password == null)) {
/* 1738:1726 */           this.password = FormGenerales.ingresaPassword();
/* 1739:     */         }
/* 1740:1730 */         ArchivoUtils.firmarEnviarAutorizar(this.emisor, archivoACrear, nombreArchivo, this.infoTributaria.getRuc(), this.infoTributaria.getCodDoc(), this.claveDeAcceso, this.password);
/* 1741:     */       }
/* 1742:     */       else
/* 1743:     */       {
/* 1744:1732 */         JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1745:     */       }
/* 1746:     */     }
/* 1747:     */     catch (Exception ex)
/* 1748:     */     {
/* 1749:1735 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1750:     */     }
/* 1751:     */   }
/* 1752:     */   
/* 1753:     */   private void formFocusGained(FocusEvent evt)
/* 1754:     */   {
/* 1755:1741 */     inicializarDatos();
/* 1756:     */   }
/* 1757:     */   
/* 1758:     */   private void obtenerInstancia(Container c)
/* 1759:     */   {
/* 1760:1744 */     if ((c instanceof JFrame))
/* 1761:     */     {
/* 1762:1745 */       System.out.println("ENTRA");
/* 1763:1746 */       JFrame f = (JFrame)c;
/* 1764:1747 */       f.getContentPane().removeAll();
/* 1765:1748 */       JScrollPane jp = new JScrollPane();
/* 1766:1749 */       jp.getViewport().add(new FacturaView());
/* 1767:1750 */       f.getContentPane().add(jp);
/* 1768:1751 */       f.validate();
/* 1769:1752 */       f.repaint();
/* 1770:     */     }
/* 1771:     */     else
/* 1772:     */     {
/* 1773:1754 */       obtenerInstancia(c.getParent());
/* 1774:     */     }
/* 1775:     */   }
/* 1776:     */   
/* 1777:     */   private void btnNuevoActionPerformed(ActionEvent evt)
/* 1778:     */   {
/* 1779:1760 */     Container c = this.btnNuevo.getParent();
/* 1780:1761 */     obtenerInstancia(c);
/* 1781:     */   }
/* 1782:     */   
/* 1783:     */   private void radioIdentificacionActionPerformed(ActionEvent evt)
/* 1784:     */   {
/* 1785:1766 */     habilitaCamposCliente();
/* 1786:     */   }
/* 1787:     */   
/* 1788:     */   private void radioConsumidorFActionPerformed(ActionEvent evt)
/* 1789:     */   {
/* 1790:1770 */     limpiaDatosCliente();
/* 1791:     */   }
/* 1792:     */   
/* 1793:     */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 1794:     */   {
/* 1795:1776 */     if (!this.txtCedulaComprador.getText().isEmpty()) {
/* 1796:1777 */       buscarCliente(this.txtCedulaComprador.getText(), 1);
/* 1797:1778 */     } else if (!this.txtRazonComprador.getText().isEmpty()) {
/* 1798:1779 */       buscarCliente(this.txtRazonComprador.getText(), 2);
/* 1799:     */     } else {
/* 1800:1781 */       JOptionPane.showMessageDialog(this, "Ingrese el RUC /CI o pasaporte o la Razón Social", "Ingrese campo", 1);
/* 1801:     */     }
/* 1802:     */   }
/* 1803:     */   
/* 1804:     */   private void jTableDetalleFacturaFocusLost(FocusEvent evt) {}
/* 1805:     */   
/* 1806:     */   private void btnFirmarProcesarMouseClicked(MouseEvent evt)
/* 1807:     */   {
/* 1808:1789 */     this.btnFirmarProcesar.setEnabled(false);
/* 1809:     */   }
/* 1810:     */   
/* 1811:     */   private void txtRazonCompradorFocusGained(FocusEvent evt)
/* 1812:     */   {
/* 1813:1793 */     this.txtCedulaComprador.setText(null);
/* 1814:     */   }
/* 1815:     */   
/* 1816:     */   private void btnAnadirActionPerformed(ActionEvent evt)
/* 1817:     */   {
/* 1818:1797 */     Component component = (Component)evt.getSource();
/* 1819:1798 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 1820:1799 */     this.modalCliente = new DialogoCliente(frame, Boolean.FALSE);
/* 1821:1800 */     this.modalCliente.setSize(770, 573);
/* 1822:1801 */     this.modalCliente.setLocationRelativeTo(null);
/* 1823:1802 */     this.modalCliente.setVisible(true);
/* 1824:     */   }
/* 1825:     */   
/* 1826:     */   private void chkPropinaActionPerformed(ActionEvent evt)
/* 1827:     */   {
/* 1828:1806 */     this.valorPropina = this.subtotalSinImpuestos.multiply(BigDecimal.valueOf(0.1D)).setScale(2, RoundingMode.HALF_UP);
/* 1829:1807 */     if (this.chkPropina.isSelected())
/* 1830:     */     {
/* 1831:1808 */       this.txtValorPropina.setText(this.valorPropina.toString());
/* 1832:1809 */       actualizaDetalle();
/* 1833:1810 */       BigDecimal cantidad = new BigDecimal(this.txtValorPropina.getText().toString());
/* 1834:1811 */       if (cantidad.equals(new BigDecimal("0.00"))) {
/* 1835:1812 */         this.chkPropina.setSelected(false);
/* 1836:     */       }
/* 1837:     */     }
/* 1838:     */     else
/* 1839:     */     {
/* 1840:1815 */       this.txtValorPropina.setText("0.00");
/* 1841:1816 */       this.totalValorFactura = this.totalValorFactura.subtract(this.valorPropina);
/* 1842:1817 */       this.lblTotalFactura.setValue(this.totalValorFactura);
/* 1843:     */     }
/* 1844:     */   }
/* 1845:     */   
/* 1846:     */   private void txtValorTotalDescuentoKeyPressed(KeyEvent evt) {}
/* 1847:     */   
/* 1848:     */   private void txtValorTotalDescuentoKeyReleased(KeyEvent evt) {}
/* 1849:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.FacturaView
 * JD-Core Version:    0.7.0.1
 */