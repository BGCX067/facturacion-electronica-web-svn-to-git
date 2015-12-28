/*    1:     */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*    2:     */ 
/*    3:     */ import comprobantesdesktop.ComprobantesDesktopApp;
/*    4:     */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*    5:     */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*    6:     */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*    7:     */ import ec.gob.sri.comprobantes.administracion.modelo.Emisor;
/*    8:     */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*    9:     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
/*   10:     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*   11:     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.Impuestos;
/*   12:     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional;
/*   13:     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoAdicional.CampoAdicional;
/*   14:     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion.InfoCompRetencion;
/*   15:     */ import ec.gob.sri.comprobantes.modelo.rentencion.Impuesto;
/*   16:     */ import ec.gob.sri.comprobantes.modelo.rentencion.ObjectFactory;
/*   17:     */ import ec.gob.sri.comprobantes.modelo.reportes.ComprobanteRetencionReporte;
/*   18:     */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   19:     */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*   20:     */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   21:     */ import ec.gob.sri.comprobantes.sql.ImpuestoValorSQL;
/*   22:     */ import ec.gob.sri.comprobantes.table.model.DatosAdicionalesTableModel;
/*   23:     */ import ec.gob.sri.comprobantes.table.model.EliminarCellEditor;
/*   24:     */ import ec.gob.sri.comprobantes.table.model.EliminarDatoCellEditor;
/*   25:     */ import ec.gob.sri.comprobantes.table.model.EliminarRenderer;
/*   26:     */ import ec.gob.sri.comprobantes.table.model.RetencionTableModel;
/*   27:     */ import ec.gob.sri.comprobantes.util.ArchivoUtils;
/*   28:     */ import ec.gob.sri.comprobantes.util.Constantes;
/*   29:     */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*   30:     */ import ec.gob.sri.comprobantes.util.FormGenerales;
/*   31:     */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   32:     */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   33:     */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*   34:     */ import ec.gob.sri.comprobantes.util.TipoCompradorEnum;
/*   35:     */ import ec.gob.sri.comprobantes.util.TipoComprobanteEnum;
/*   36:     */ import ec.gob.sri.comprobantes.util.TipoEmisionEnum;
/*   37:     */ import ec.gob.sri.comprobantes.util.TipoImpuestoEnum;
/*   38:     */ import ec.gob.sri.comprobantes.util.TipoImpuestoIvaEnum;
/*   39:     */ import ec.gob.sri.comprobantes.util.reportes.ReporteUtil;
/*   40:     */ import ec.gob.sri.comprobantes.view.modals.DialogoCliente;
/*   41:     */ import java.awt.Component;
/*   42:     */ import java.awt.Cursor;
/*   43:     */ import java.awt.Dimension;
/*   44:     */ import java.awt.event.ActionEvent;
/*   45:     */ import java.awt.event.ActionListener;
/*   46:     */ import java.awt.event.FocusAdapter;
/*   47:     */ import java.awt.event.FocusEvent;
/*   48:     */ import java.awt.event.ItemEvent;
/*   49:     */ import java.awt.event.ItemListener;
/*   50:     */ import java.awt.event.KeyAdapter;
/*   51:     */ import java.awt.event.KeyEvent;
/*   52:     */ import java.beans.PropertyChangeEvent;
/*   53:     */ import java.beans.PropertyChangeListener;
/*   54:     */ import java.io.File;
/*   55:     */ import java.math.BigDecimal;
/*   56:     */ import java.math.RoundingMode;
/*   57:     */ import java.sql.SQLException;
/*   58:     */ import java.text.DecimalFormat;
/*   59:     */ import java.text.DecimalFormatSymbols;
/*   60:     */ import java.text.SimpleDateFormat;
/*   61:     */ import java.util.ArrayList;
/*   62:     */ import java.util.Calendar;
/*   63:     */ import java.util.Date;
/*   64:     */ import java.util.List;
/*   65:     */ import java.util.Locale;
/*   66:     */ import java.util.logging.Level;
/*   67:     */ import java.util.logging.Logger;
/*   68:     */ import javax.accessibility.AccessibleContext;
/*   69:     */ import javax.swing.BorderFactory;
/*   70:     */ import javax.swing.ButtonGroup;
/*   71:     */ import javax.swing.DefaultComboBoxModel;
/*   72:     */ import javax.swing.GroupLayout;
/*   73:     */ import javax.swing.GroupLayout.Alignment;
/*   74:     */ import javax.swing.GroupLayout.ParallelGroup;
/*   75:     */ import javax.swing.GroupLayout.SequentialGroup;
/*   76:     */ import javax.swing.ImageIcon;
/*   77:     */ import javax.swing.JButton;
/*   78:     */ import javax.swing.JComboBox;
/*   79:     */ import javax.swing.JFormattedTextField;
/*   80:     */ import javax.swing.JFrame;
/*   81:     */ import javax.swing.JLabel;
/*   82:     */ import javax.swing.JOptionPane;
/*   83:     */ import javax.swing.JPanel;
/*   84:     */ import javax.swing.JScrollPane;
/*   85:     */ import javax.swing.JTable;
/*   86:     */ import javax.swing.JTextField;
/*   87:     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*   88:     */ import javax.swing.SwingUtilities;
/*   89:     */ import javax.swing.table.TableColumn;
/*   90:     */ import javax.swing.table.TableColumnModel;
/*   91:     */ import javax.swing.text.DateFormatter;
/*   92:     */ import javax.swing.text.DefaultFormatterFactory;
/*   93:     */ import javax.swing.text.NumberFormatter;
/*   94:     */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*   95:     */ import org.jdesktop.application.Application;
/*   96:     */ import org.jdesktop.application.ApplicationContext;
/*   97:     */ import org.jdesktop.application.ResourceMap;
/*   98:     */ 
/*   99:     */ public final class ComprobanteRetencionView
/*  100:     */   extends JPanel
/*  101:     */ {
/*  102:  77 */   Long secuencial = null;
/*  103:  78 */   private String secuencialComprobante = null;
/*  104:  79 */   private String razonSociaSujetoReten = null;
/*  105:  80 */   private String identSujetoRetenido = null;
/*  106:  81 */   private InfoTributaria infoTributaria = null;
/*  107:  82 */   private ComprobanteRetencion.InfoCompRetencion infoCompRetencion = null;
/*  108:  83 */   private Emisor emisor = null;
/*  109:  84 */   private String serie = null;
/*  110:  85 */   private String claveDeAcceso = null;
/*  111:     */   private Date fechaEmision;
/*  112:     */   private Clientes clienteSeleccionado;
/*  113:     */   private ClaveContingencia claveContingencia;
/*  114:     */   private DatosAdicionalesTableModel modeloDatosAdicionales;
/*  115:     */   private RetencionTableModel modeloDetalle;
/*  116:     */   private DialogoCliente modalCliente;
/*  117:  92 */   private ObjectFactory factory = null;
/*  118:  93 */   private String password = null;
/*  119:     */   private JButton btnAdicionarDetalle;
/*  120:     */   private JButton btnAnadir;
/*  121:     */   public JButton btnBuscar;
/*  122:     */   private JButton btnFirmarProcesar;
/*  123:     */   private JButton btnGuardar;
/*  124:     */   private JButton btnNuevo;
/*  125:     */   private JButton btnNuevoDato;
/*  126:     */   private Cabecera cabecera1;
/*  127:     */   private JComboBox comboConceptoReten;
/*  128:     */   private JComboBox comboImpuesto;
/*  129:     */   private JComboBox comboTipoDocModificado;
/*  130:     */   private IdentificacionComprobanteNoGuia idenComprob;
/*  131:     */   private JCalendarButton jCalendarCompModifica;
/*  132:     */   private ButtonGroup jGroupTipoComprador;
/*  133:     */   private JLabel jLabel1;
/*  134:     */   private JLabel jLabel10;
/*  135:     */   private JLabel jLabel14;
/*  136:     */   private JLabel jLabel16;
/*  137:     */   private JLabel jLabel17;
/*  138:     */   private JLabel jLabel18;
/*  139:     */   private JLabel jLabel19;
/*  140:     */   private JLabel jLabel2;
/*  141:     */   private JLabel jLabel20;
/*  142:     */   private JLabel jLabel21;
/*  143:     */   private JLabel jLabel22;
/*  144:     */   private JLabel jLabel23;
/*  145:     */   private JLabel jLabel3;
/*  146:     */   private JLabel jLabel4;
/*  147:     */   private JLabel jLabel5;
/*  148:     */   private JPanel jPanel2;
/*  149:     */   private JPanel jPanel3;
/*  150:     */   private JPanel jPanel4;
/*  151:     */   private JPanel jPanel6;
/*  152:     */   private JPanel jPanel7;
/*  153:     */   private JScrollPane jScrollPane1;
/*  154:     */   private JScrollPane jScrollPane2;
/*  155:     */   private JTable jTableDatosAdicionales;
/*  156:     */   private JTable jTableDetalleComprobante;
/*  157:     */   private JTextField textFechaCompModif;
/*  158:     */   private JTextField textNumCompModif;
/*  159:     */   private JFormattedTextField txtAnio;
/*  160:     */   private JFormattedTextField txtBaseImponible;
/*  161:     */   public JTextField txtCedulaComprador;
/*  162:     */   private JTextField txtCodDoc;
/*  163:     */   private JFormattedTextField txtImpuesto;
/*  164:     */   private JFormattedTextField txtMes;
/*  165:     */   public JTextField txtRazonComprador;
/*  166:     */   private JFormattedTextField txtValorRetenido;
/*  167:     */   
/*  168:     */   public ComprobanteRetencionView()
/*  169:     */   {
/*  170:  96 */     initComponents();
/*  171:  97 */     inicializarDatos();
/*  172:  98 */     actualizaClaveDeAcceso();
/*  173:  99 */     ListenerUtil lu = new ListenerUtil();
/*  174: 100 */     lu.listenerSolonumerosLongitud(this.textNumCompModif, Integer.valueOf(15));
/*  175: 101 */     lu.listenerSolonumerosLongitud(this.txtMes, Integer.valueOf(2));
/*  176: 102 */     lu.listenerSolonumerosLongitud(this.txtAnio, Integer.valueOf(4));
/*  177:     */   }
/*  178:     */   
/*  179:     */   public void inicializarDatos()
/*  180:     */   {
/*  181: 106 */     this.factory = new ObjectFactory();
/*  182: 107 */     this.modeloDatosAdicionales = new DatosAdicionalesTableModel();
/*  183: 108 */     this.jTableDatosAdicionales.setModel(this.modeloDatosAdicionales);
/*  184: 109 */     this.jTableDatosAdicionales.setAutoResizeMode(0);
/*  185: 110 */     TableColumn tc = this.jTableDatosAdicionales.getColumnModel().getColumn(2);
/*  186: 111 */     EliminarDatoCellEditor editord = new EliminarDatoCellEditor(this.jTableDatosAdicionales);
/*  187: 112 */     tc.setCellEditor(editord);
/*  188: 113 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  189: 114 */     setColumnWidthDatosAdicionales();
/*  190:     */     
/*  191: 116 */     this.modeloDetalle = new RetencionTableModel();
/*  192: 117 */     this.jTableDetalleComprobante.setModel(this.modeloDetalle);
/*  193: 118 */     tc = this.jTableDetalleComprobante.getColumnModel().getColumn(9);
/*  194: 119 */     EliminarCellEditor editor = new EliminarCellEditor(this.jTableDetalleComprobante);
/*  195: 120 */     tc.setCellEditor(editor);
/*  196: 121 */     tc.setCellRenderer(new EliminarRenderer(true));
/*  197: 122 */     this.jTableDetalleComprobante.setAutoResizeMode(0);
/*  198: 123 */     setColumnWidthDetalle();
/*  199:     */     
/*  200:     */ 
/*  201: 126 */     String[] opciones = { TipoComprobanteEnum.FACTURA.getDescripcion(), TipoComprobanteEnum.NOTA_DE_DEBITO.getDescripcion(), TipoComprobanteEnum.LIQUIDACION_DE_COMPRAS.getDescripcion(), "OTROS" };
/*  202:     */     
/*  203: 128 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(opciones));
/*  204:     */     
/*  205: 130 */     String[] impuestos = { "Seleccione...", TipoImpuestoEnum.IVA.getDescripcion(), TipoImpuestoEnum.RENTA.getDescripcion() };
/*  206: 131 */     this.comboImpuesto.setModel(new DefaultComboBoxModel(impuestos));
/*  207:     */     
/*  208:     */ 
/*  209: 134 */     this.idenComprob.jCalendarFecha.addPropertyChangeListener(new PropertyChangeListener()
/*  210:     */     {
/*  211:     */       public void propertyChange(PropertyChangeEvent evt)
/*  212:     */       {
/*  213: 137 */         ComprobanteRetencionView.this.cambioEnBotonDeFecha(evt, 1);
/*  214:     */       }
/*  215: 140 */     });
/*  216: 141 */     this.jCalendarCompModifica.addPropertyChangeListener(new PropertyChangeListener()
/*  217:     */     {
/*  218:     */       public void propertyChange(PropertyChangeEvent evt)
/*  219:     */       {
/*  220: 144 */         ComprobanteRetencionView.this.cambioEnBotonDeFecha(evt, 2);
/*  221:     */       }
/*  222:     */     });
/*  223:     */     try
/*  224:     */     {
/*  225: 152 */       ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo(TipoImpuestoIvaEnum.IVA_VENTA_12.getCode());
/*  226: 153 */       if (iv != null)
/*  227:     */       {
/*  228: 154 */         this.secuencial = new ComprobantesSQL().obtenerMaximo(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode());
/*  229: 155 */         this.secuencialComprobante = String.format("%09d", new Object[] { Long.valueOf(this.secuencial.longValue()) });
/*  230: 156 */         llenaDatosEmisor();
/*  231: 157 */         this.idenComprob.lblEstablecimiento.setText(this.emisor.getCodigoEstablecimiento());
/*  232: 158 */         this.idenComprob.lblPunto.setText(this.emisor.getCodPuntoEmision());
/*  233: 159 */         setDate(new Date());
/*  234:     */       }
/*  235:     */     }
/*  236:     */     catch (Exception ex)
/*  237:     */     {
/*  238: 162 */       Logger.getLogger(ComprobanteRetencionView.class.getName()).log(Level.SEVERE, null, ex);
/*  239:     */     }
/*  240: 164 */     this.idenComprob.lblNumeroComprobante.setText(this.secuencialComprobante);
/*  241:     */   }
/*  242:     */   
/*  243:     */   private void setColumnWidthDetalle()
/*  244:     */   {
/*  245: 171 */     for (int i = 0; i < this.jTableDetalleComprobante.getColumnModel().getColumnCount(); i++)
/*  246:     */     {
/*  247: 172 */       TableColumn column = this.jTableDetalleComprobante.getColumnModel().getColumn(i);
/*  248: 173 */       if (i == 0) {
/*  249: 174 */         column.setPreferredWidth(75);
/*  250:     */       }
/*  251: 176 */       if (i == 1) {
/*  252: 177 */         column.setPreferredWidth(50);
/*  253:     */       }
/*  254: 179 */       if (i == 2) {
/*  255: 180 */         column.setPreferredWidth(220);
/*  256:     */       }
/*  257: 182 */       if (i == 3) {
/*  258: 183 */         column.setPreferredWidth(95);
/*  259:     */       }
/*  260: 185 */       if (i == 4) {
/*  261: 186 */         column.setPreferredWidth(70);
/*  262:     */       }
/*  263: 188 */       if (i == 5) {
/*  264: 189 */         column.setPreferredWidth(50);
/*  265:     */       }
/*  266: 191 */       if (i == 6) {
/*  267: 192 */         column.setPreferredWidth(111);
/*  268:     */       }
/*  269: 194 */       if (i == 8) {
/*  270: 195 */         column.setPreferredWidth(40);
/*  271:     */       }
/*  272: 197 */       if (i == 9) {
/*  273: 198 */         column.setPreferredWidth(105);
/*  274:     */       }
/*  275:     */     }
/*  276:     */   }
/*  277:     */   
/*  278:     */   private void setColumnWidthDatosAdicionales()
/*  279:     */   {
/*  280: 204 */     for (int i = 0; i < this.jTableDatosAdicionales.getColumnModel().getColumnCount(); i++)
/*  281:     */     {
/*  282: 205 */       TableColumn column = this.jTableDatosAdicionales.getColumnModel().getColumn(i);
/*  283: 206 */       if (i == 0) {
/*  284: 207 */         column.setPreferredWidth(100);
/*  285:     */       }
/*  286: 209 */       if (i == 1) {
/*  287: 210 */         column.setPreferredWidth(300);
/*  288:     */       }
/*  289: 212 */       if (i == 2) {
/*  290: 213 */         column.setPreferredWidth(105);
/*  291:     */       }
/*  292:     */     }
/*  293:     */   }
/*  294:     */   
/*  295:     */   public void llenaDatosEmisor()
/*  296:     */   {
/*  297: 224 */     this.emisor = FormGenerales.llenaDatosEmisor(this.cabecera1);
/*  298:     */   }
/*  299:     */   
/*  300:     */   private void cambioEnBotonDeFecha(PropertyChangeEvent evt, int id)
/*  301:     */   {
/*  302: 234 */     if ((evt.getNewValue() instanceof Date)) {
/*  303: 235 */       if (id == 1)
/*  304:     */       {
/*  305: 236 */         setDate((Date)evt.getNewValue());
/*  306: 237 */         actualizaClaveDeAcceso();
/*  307:     */       }
/*  308:     */       else
/*  309:     */       {
/*  310: 239 */         setDateComprobante((Date)evt.getNewValue());
/*  311:     */       }
/*  312:     */     }
/*  313:     */   }
/*  314:     */   
/*  315:     */   private void initComponents()
/*  316:     */   {
/*  317: 253 */     this.jGroupTipoComprador = new ButtonGroup();
/*  318: 254 */     this.jPanel2 = new JPanel();
/*  319: 255 */     this.jLabel17 = new JLabel();
/*  320: 256 */     this.txtCedulaComprador = new JTextField();
/*  321: 257 */     this.btnBuscar = new JButton();
/*  322: 258 */     this.txtRazonComprador = new JTextField();
/*  323: 259 */     this.jLabel20 = new JLabel();
/*  324: 260 */     this.jLabel10 = new JLabel();
/*  325: 261 */     this.jLabel1 = new JLabel();
/*  326: 262 */     this.jLabel2 = new JLabel();
/*  327: 263 */     this.txtMes = new JFormattedTextField();
/*  328: 264 */     this.txtAnio = new JFormattedTextField();
/*  329: 265 */     this.btnAnadir = new JButton();
/*  330: 266 */     this.jLabel5 = new JLabel();
/*  331: 267 */     this.jPanel3 = new JPanel();
/*  332: 268 */     this.jScrollPane1 = new JScrollPane();
/*  333: 269 */     this.jTableDetalleComprobante = new JTable();
/*  334: 270 */     this.btnAdicionarDetalle = new JButton();
/*  335: 271 */     this.jPanel4 = new JPanel();
/*  336: 272 */     this.jScrollPane2 = new JScrollPane();
/*  337: 273 */     this.jTableDatosAdicionales = new JTable();
/*  338: 274 */     this.btnNuevoDato = new JButton();
/*  339: 275 */     this.jPanel6 = new JPanel();
/*  340: 276 */     this.btnFirmarProcesar = new JButton();
/*  341: 277 */     this.btnNuevo = new JButton();
/*  342: 278 */     this.btnGuardar = new JButton();
/*  343: 279 */     this.jPanel7 = new JPanel();
/*  344: 280 */     this.jLabel18 = new JLabel();
/*  345: 281 */     this.comboImpuesto = new JComboBox();
/*  346: 282 */     this.comboConceptoReten = new JComboBox();
/*  347: 283 */     this.txtBaseImponible = new JFormattedTextField();
/*  348: 284 */     this.jLabel21 = new JLabel();
/*  349: 285 */     this.txtImpuesto = new JFormattedTextField();
/*  350: 286 */     this.jLabel22 = new JLabel();
/*  351: 287 */     this.txtValorRetenido = new JFormattedTextField();
/*  352: 288 */     this.jLabel23 = new JLabel();
/*  353: 289 */     this.jLabel14 = new JLabel();
/*  354: 290 */     this.comboTipoDocModificado = new JComboBox();
/*  355: 291 */     this.jLabel16 = new JLabel();
/*  356: 292 */     this.textFechaCompModif = new JTextField();
/*  357: 293 */     this.jCalendarCompModifica = new JCalendarButton();
/*  358: 294 */     this.jLabel19 = new JLabel();
/*  359: 295 */     this.textNumCompModif = new JTextField();
/*  360: 296 */     this.txtCodDoc = new JTextField();
/*  361: 297 */     this.jLabel3 = new JLabel();
/*  362: 298 */     this.jLabel4 = new JLabel();
/*  363: 299 */     this.cabecera1 = new Cabecera();
/*  364: 300 */     this.idenComprob = new IdentificacionComprobanteNoGuia();
/*  365:     */     
/*  366: 302 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ComprobanteRetencionView.class);
/*  367: 303 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 2, 0, resourceMap.getFont("Form.border.titleFont")));
/*  368: 304 */     setName("Form");
/*  369:     */     
/*  370: 306 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/*  371: 307 */     this.jPanel2.setName("jPanel2");
/*  372:     */     
/*  373: 309 */     this.jLabel17.setFont(resourceMap.getFont("jLabel20.font"));
/*  374: 310 */     this.jLabel17.setText(resourceMap.getString("jLabel17.text", new Object[0]));
/*  375: 311 */     this.jLabel17.setName("jLabel17");
/*  376:     */     
/*  377: 313 */     this.txtCedulaComprador.setFont(resourceMap.getFont("txtCedulaComprador.font"));
/*  378: 314 */     this.txtCedulaComprador.setName("txtCedulaComprador");
/*  379:     */     
/*  380: 316 */     this.btnBuscar.setText(resourceMap.getString("btnBuscar.text", new Object[0]));
/*  381: 317 */     this.btnBuscar.setName("btnBuscar");
/*  382: 318 */     this.btnBuscar.addActionListener(new ActionListener()
/*  383:     */     {
/*  384:     */       public void actionPerformed(ActionEvent evt)
/*  385:     */       {
/*  386: 320 */         ComprobanteRetencionView.this.btnBuscarActionPerformed(evt);
/*  387:     */       }
/*  388: 323 */     });
/*  389: 324 */     this.txtRazonComprador.setFont(resourceMap.getFont("txtRazonComprador.font"));
/*  390: 325 */     this.txtRazonComprador.setName("txtRazonComprador");
/*  391: 326 */     this.txtRazonComprador.addFocusListener(new FocusAdapter()
/*  392:     */     {
/*  393:     */       public void focusGained(FocusEvent evt)
/*  394:     */       {
/*  395: 328 */         ComprobanteRetencionView.this.txtRazonCompradorFocusGained(evt);
/*  396:     */       }
/*  397: 331 */     });
/*  398: 332 */     this.jLabel20.setFont(resourceMap.getFont("jLabel20.font"));
/*  399: 333 */     this.jLabel20.setText(resourceMap.getString("jLabel20.text", new Object[0]));
/*  400: 334 */     this.jLabel20.setName("jLabel20");
/*  401:     */     
/*  402: 336 */     this.jLabel10.setFont(resourceMap.getFont("jLabel20.font"));
/*  403: 337 */     this.jLabel10.setText(resourceMap.getString("jLabel10.text", new Object[0]));
/*  404: 338 */     this.jLabel10.setName("jLabel10");
/*  405:     */     
/*  406: 340 */     this.jLabel1.setFont(resourceMap.getFont("jLabel20.font"));
/*  407: 341 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  408: 342 */     this.jLabel1.setName("jLabel1");
/*  409:     */     
/*  410: 344 */     this.jLabel2.setFont(resourceMap.getFont("jLabel20.font"));
/*  411: 345 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/*  412: 346 */     this.jLabel2.setName("jLabel2");
/*  413:     */     
/*  414: 348 */     this.txtMes.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("MM"))));
/*  415: 349 */     this.txtMes.setHorizontalAlignment(0);
/*  416: 350 */     this.txtMes.setText(resourceMap.getString("txtMes.text", new Object[0]));
/*  417: 351 */     this.txtMes.setName("txtMes");
/*  418:     */     
/*  419: 353 */     this.txtAnio.setText(resourceMap.getString("txtAnio.text", new Object[0]));
/*  420: 354 */     this.txtAnio.setFont(resourceMap.getFont("txtAnio.font"));
/*  421: 355 */     this.txtAnio.setName("txtAnio");
/*  422:     */     
/*  423: 357 */     this.btnAnadir.setName("btnAnadir");
/*  424: 358 */     this.btnAnadir.setIcon(new ImageIcon("resources/icons/anadir.gif"));
/*  425: 359 */     this.btnAnadir.addActionListener(new ActionListener()
/*  426:     */     {
/*  427:     */       public void actionPerformed(ActionEvent evt)
/*  428:     */       {
/*  429: 361 */         ComprobanteRetencionView.this.btnAnadirActionPerformed(evt);
/*  430:     */       }
/*  431: 364 */     });
/*  432: 365 */     this.jLabel5.setFont(resourceMap.getFont("jLabel5.font"));
/*  433: 366 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/*  434: 367 */     this.jLabel5.setEnabled(false);
/*  435: 368 */     this.jLabel5.setName("jLabel5");
/*  436:     */     
/*  437: 370 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  438: 371 */     this.jPanel2.setLayout(jPanel2Layout);
/*  439: 372 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel20, -2, -1, -2).addGap(18, 18, 18).addComponent(this.txtCedulaComprador, -2, 286, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnBuscar, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAnadir, -2, 25, -2).addGap(27, 27, 27).addComponent(this.jLabel10).addGap(33, 33, 33).addComponent(this.jLabel1).addGap(4, 4, 4).addComponent(this.txtMes, -2, 30, -2).addGap(18, 18, 18).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, 32767).addComponent(this.txtAnio, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel17).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtRazonComprador, -2, 852, -2))).addContainerGap()));
/*  440:     */     
/*  441:     */ 
/*  442:     */ 
/*  443:     */ 
/*  444:     */ 
/*  445:     */ 
/*  446:     */ 
/*  447:     */ 
/*  448:     */ 
/*  449:     */ 
/*  450:     */ 
/*  451:     */ 
/*  452:     */ 
/*  453:     */ 
/*  454:     */ 
/*  455:     */ 
/*  456:     */ 
/*  457:     */ 
/*  458:     */ 
/*  459:     */ 
/*  460:     */ 
/*  461:     */ 
/*  462:     */ 
/*  463:     */ 
/*  464:     */ 
/*  465:     */ 
/*  466:     */ 
/*  467:     */ 
/*  468:     */ 
/*  469:     */ 
/*  470: 403 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.txtCedulaComprador, -2, -1, -2).addComponent(this.btnBuscar).addComponent(this.btnAnadir).addComponent(this.jLabel1).addComponent(this.txtMes, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.txtAnio, -2, -1, -2).addComponent(this.jLabel10).addComponent(this.jLabel5).addComponent(this.jLabel20, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.txtRazonComprador, -2, -1, -2)).addGap(12, 12, 12)));
/*  471:     */     
/*  472:     */ 
/*  473:     */ 
/*  474:     */ 
/*  475:     */ 
/*  476:     */ 
/*  477:     */ 
/*  478:     */ 
/*  479:     */ 
/*  480:     */ 
/*  481:     */ 
/*  482:     */ 
/*  483:     */ 
/*  484:     */ 
/*  485:     */ 
/*  486:     */ 
/*  487:     */ 
/*  488:     */ 
/*  489:     */ 
/*  490:     */ 
/*  491:     */ 
/*  492: 425 */     jPanel2Layout.linkSize(1, new Component[] { this.btnAnadir, this.btnBuscar });
/*  493:     */     
/*  494: 427 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title", new Object[0]), 0, 0, resourceMap.getFont("jPanel3.border.titleFont")));
/*  495: 428 */     this.jPanel3.setName("jPanel3");
/*  496:     */     
/*  497: 430 */     this.jScrollPane1.setName("jScrollPane1");
/*  498:     */     
/*  499: 432 */     this.jTableDetalleComprobante.setFont(resourceMap.getFont("jTableDetalleComprobante.font"));
/*  500: 433 */     this.jTableDetalleComprobante.setAutoResizeMode(4);
/*  501: 434 */     this.jTableDetalleComprobante.setName("jTableDetalleComprobante");
/*  502: 435 */     this.jScrollPane1.setViewportView(this.jTableDetalleComprobante);
/*  503:     */     
/*  504: 437 */     this.btnAdicionarDetalle.setFont(resourceMap.getFont("btnAdicionarDetalle.font"));
/*  505: 438 */     this.btnAdicionarDetalle.setText(resourceMap.getString("btnAdicionarDetalle.text", new Object[0]));
/*  506: 439 */     this.btnAdicionarDetalle.setEnabled(false);
/*  507: 440 */     this.btnAdicionarDetalle.setName("btnAdicionarDetalle");
/*  508: 441 */     this.btnAdicionarDetalle.addActionListener(new ActionListener()
/*  509:     */     {
/*  510:     */       public void actionPerformed(ActionEvent evt)
/*  511:     */       {
/*  512: 443 */         ComprobanteRetencionView.this.btnAdicionarDetalleActionPerformed(evt);
/*  513:     */       }
/*  514: 446 */     });
/*  515: 447 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  516: 448 */     this.jPanel3.setLayout(jPanel3Layout);
/*  517: 449 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1071, 32767).addComponent(this.btnAdicionarDetalle, -2, 218, -2)).addContainerGap()));
/*  518:     */     
/*  519:     */ 
/*  520:     */ 
/*  521:     */ 
/*  522:     */ 
/*  523:     */ 
/*  524:     */ 
/*  525:     */ 
/*  526: 458 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.btnAdicionarDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 91, -2).addContainerGap(-1, 32767)));
/*  527:     */     
/*  528:     */ 
/*  529:     */ 
/*  530:     */ 
/*  531:     */ 
/*  532:     */ 
/*  533:     */ 
/*  534:     */ 
/*  535: 467 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel4.border.title", new Object[0]), 0, 0, resourceMap.getFont("jPanel4.border.titleFont")));
/*  536: 468 */     this.jPanel4.setName("jPanel4");
/*  537:     */     
/*  538: 470 */     this.jScrollPane2.setName("jScrollPane2");
/*  539:     */     
/*  540: 472 */     this.jTableDatosAdicionales.setName("jTableDatosAdicionales");
/*  541: 473 */     this.jScrollPane2.setViewportView(this.jTableDatosAdicionales);
/*  542:     */     
/*  543: 475 */     this.btnNuevoDato.setFont(resourceMap.getFont("btnNuevoDato.font"));
/*  544: 476 */     this.btnNuevoDato.setText(resourceMap.getString("btnNuevoDato.text", new Object[0]));
/*  545: 477 */     this.btnNuevoDato.setName("btnNuevoDato");
/*  546: 478 */     this.btnNuevoDato.addActionListener(new ActionListener()
/*  547:     */     {
/*  548:     */       public void actionPerformed(ActionEvent evt)
/*  549:     */       {
/*  550: 480 */         ComprobanteRetencionView.this.btnNuevoDatoActionPerformed(evt);
/*  551:     */       }
/*  552: 483 */     });
/*  553: 484 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  554: 485 */     this.jPanel4.setLayout(jPanel4Layout);
/*  555: 486 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 468, 32767).addComponent(this.btnNuevoDato)).addContainerGap()));
/*  556:     */     
/*  557:     */ 
/*  558:     */ 
/*  559:     */ 
/*  560:     */ 
/*  561:     */ 
/*  562:     */ 
/*  563:     */ 
/*  564: 495 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.btnNuevoDato).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 68, 32767)));
/*  565:     */     
/*  566:     */ 
/*  567:     */ 
/*  568:     */ 
/*  569:     */ 
/*  570:     */ 
/*  571:     */ 
/*  572: 503 */     this.jPanel6.setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel6.border.title", new Object[0]), 0, 0, resourceMap.getFont("jPanel6.border.titleFont")));
/*  573: 504 */     this.jPanel6.setName("jPanel6");
/*  574: 505 */     this.jPanel6.setPreferredSize(new Dimension(440, 90));
/*  575:     */     
/*  576: 507 */     this.btnFirmarProcesar.setFont(resourceMap.getFont("btnFirmarProcesar.font"));
/*  577: 508 */     this.btnFirmarProcesar.setText(resourceMap.getString("btnFirmarProcesar.text", new Object[0]));
/*  578: 509 */     this.btnFirmarProcesar.setEnabled(false);
/*  579: 510 */     this.btnFirmarProcesar.setName("btnFirmarProcesar");
/*  580: 511 */     this.btnFirmarProcesar.addActionListener(new ActionListener()
/*  581:     */     {
/*  582:     */       public void actionPerformed(ActionEvent evt)
/*  583:     */       {
/*  584: 513 */         ComprobanteRetencionView.this.btnFirmarProcesarActionPerformed(evt);
/*  585:     */       }
/*  586: 516 */     });
/*  587: 517 */     this.btnNuevo.setFont(resourceMap.getFont("btnNuevo.font"));
/*  588: 518 */     this.btnNuevo.setText(resourceMap.getString("btnNuevo.text", new Object[0]));
/*  589: 519 */     this.btnNuevo.setName("btnNuevo");
/*  590: 520 */     this.btnNuevo.addActionListener(new ActionListener()
/*  591:     */     {
/*  592:     */       public void actionPerformed(ActionEvent evt)
/*  593:     */       {
/*  594: 522 */         ComprobanteRetencionView.this.btnNuevoActionPerformed(evt);
/*  595:     */       }
/*  596: 525 */     });
/*  597: 526 */     this.btnGuardar.setFont(resourceMap.getFont("btnGuardar.font"));
/*  598: 527 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/*  599: 528 */     this.btnGuardar.setEnabled(false);
/*  600: 529 */     this.btnGuardar.setName("btnGuardar");
/*  601: 530 */     this.btnGuardar.addActionListener(new ActionListener()
/*  602:     */     {
/*  603:     */       public void actionPerformed(ActionEvent evt)
/*  604:     */       {
/*  605: 532 */         ComprobanteRetencionView.this.btnGuardarActionPerformed(evt);
/*  606:     */       }
/*  607: 535 */     });
/*  608: 536 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  609: 537 */     this.jPanel6.setLayout(jPanel6Layout);
/*  610: 538 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.btnFirmarProcesar, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNuevo, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGuardar).addContainerGap(165, 32767)));
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
/*  621: 549 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnFirmarProcesar).addComponent(this.btnNuevo).addComponent(this.btnGuardar)).addContainerGap(19, 32767)));
/*  622:     */     
/*  623:     */ 
/*  624:     */ 
/*  625:     */ 
/*  626:     */ 
/*  627:     */ 
/*  628:     */ 
/*  629:     */ 
/*  630:     */ 
/*  631: 559 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel7.border.title", new Object[0]), 0, 0, resourceMap.getFont("jPanel7.border.titleFont")));
/*  632: 560 */     this.jPanel7.setName("jPanel7");
/*  633:     */     
/*  634: 562 */     this.jLabel18.setFont(resourceMap.getFont("jLabel14.font"));
/*  635: 563 */     this.jLabel18.setText(resourceMap.getString("jLabel18.text", new Object[0]));
/*  636: 564 */     this.jLabel18.setName("jLabel18");
/*  637:     */     
/*  638: 566 */     this.comboImpuesto.setFont(resourceMap.getFont("comboImpuesto.font"));
/*  639: 567 */     this.comboImpuesto.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  640: 568 */     this.comboImpuesto.setName("comboImpuesto");
/*  641: 569 */     this.comboImpuesto.addActionListener(new ActionListener()
/*  642:     */     {
/*  643:     */       public void actionPerformed(ActionEvent evt)
/*  644:     */       {
/*  645: 571 */         ComprobanteRetencionView.this.comboImpuestoActionPerformed(evt);
/*  646:     */       }
/*  647: 574 */     });
/*  648: 575 */     this.comboConceptoReten.setFont(resourceMap.getFont("comboConceptoReten.font"));
/*  649: 576 */     this.comboConceptoReten.setName("comboConceptoReten");
/*  650: 577 */     this.comboConceptoReten.addItemListener(new ItemListener()
/*  651:     */     {
/*  652:     */       public void itemStateChanged(ItemEvent evt)
/*  653:     */       {
/*  654: 579 */         ComprobanteRetencionView.this.comboConceptoRetenItemStateChanged(evt);
/*  655:     */       }
/*  656: 581 */     });
/*  657: 582 */     this.comboConceptoReten.addActionListener(new ActionListener()
/*  658:     */     {
/*  659:     */       public void actionPerformed(ActionEvent evt)
/*  660:     */       {
/*  661: 584 */         ComprobanteRetencionView.this.comboConceptoRetenActionPerformed(evt);
/*  662:     */       }
/*  663: 587 */     });
/*  664: 588 */     this.txtBaseImponible.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("us", "EN"))))));
/*  665: 589 */     this.txtBaseImponible.setName("txtBaseImponible");
/*  666: 590 */     this.txtBaseImponible.addFocusListener(new FocusAdapter()
/*  667:     */     {
/*  668:     */       public void focusLost(FocusEvent evt)
/*  669:     */       {
/*  670: 592 */         ComprobanteRetencionView.this.txtBaseImponibleFocusLost(evt);
/*  671:     */       }
/*  672: 595 */     });
/*  673: 596 */     this.jLabel21.setFont(resourceMap.getFont("jLabel14.font"));
/*  674: 597 */     this.jLabel21.setText(resourceMap.getString("jLabel21.text", new Object[0]));
/*  675: 598 */     this.jLabel21.setName("jLabel21");
/*  676:     */     
/*  677: 600 */     this.txtImpuesto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("us", "EN"))))));
/*  678: 601 */     this.txtImpuesto.setEnabled(false);
/*  679: 602 */     this.txtImpuesto.setName("txtImpuesto");
/*  680:     */     
/*  681: 604 */     this.jLabel22.setFont(resourceMap.getFont("jLabel14.font"));
/*  682: 605 */     this.jLabel22.setText(resourceMap.getString("jLabel22.text", new Object[0]));
/*  683: 606 */     this.jLabel22.setName("jLabel22");
/*  684:     */     
/*  685: 608 */     this.txtValorRetenido.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("us", "EN"))))));
/*  686: 609 */     this.txtValorRetenido.setName("txtValorRetenido");
/*  687: 610 */     this.txtValorRetenido.addFocusListener(new FocusAdapter()
/*  688:     */     {
/*  689:     */       public void focusGained(FocusEvent evt)
/*  690:     */       {
/*  691: 612 */         ComprobanteRetencionView.this.txtValorRetenidoFocusGained(evt);
/*  692:     */       }
/*  693: 615 */     });
/*  694: 616 */     this.jLabel23.setFont(resourceMap.getFont("jLabel14.font"));
/*  695: 617 */     this.jLabel23.setText(resourceMap.getString("jLabel23.text", new Object[0]));
/*  696: 618 */     this.jLabel23.setName("jLabel23");
/*  697:     */     
/*  698: 620 */     this.jLabel14.setFont(resourceMap.getFont("jLabel14.font"));
/*  699: 621 */     this.jLabel14.setText(resourceMap.getString("jLabel14.text", new Object[0]));
/*  700: 622 */     this.jLabel14.setName("jLabel14");
/*  701:     */     
/*  702: 624 */     this.comboTipoDocModificado.setFont(resourceMap.getFont("comboTipoDocModificado.font"));
/*  703: 625 */     this.comboTipoDocModificado.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*  704: 626 */     this.comboTipoDocModificado.setName("comboTipoDocModificado");
/*  705: 627 */     this.comboTipoDocModificado.addActionListener(new ActionListener()
/*  706:     */     {
/*  707:     */       public void actionPerformed(ActionEvent evt)
/*  708:     */       {
/*  709: 629 */         ComprobanteRetencionView.this.comboTipoDocModificadoActionPerformed(evt);
/*  710:     */       }
/*  711: 632 */     });
/*  712: 633 */     this.jLabel16.setFont(resourceMap.getFont("jLabel14.font"));
/*  713: 634 */     this.jLabel16.setText(resourceMap.getString("jLabel16.text", new Object[0]));
/*  714: 635 */     this.jLabel16.setName("jLabel16");
/*  715:     */     
/*  716: 637 */     this.textFechaCompModif.setEditable(false);
/*  717: 638 */     this.textFechaCompModif.setFont(resourceMap.getFont("textFechaCompModif.font"));
/*  718: 639 */     this.textFechaCompModif.setText(resourceMap.getString("textFechaCompModif.text", new Object[0]));
/*  719: 640 */     this.textFechaCompModif.setName("textFechaCompModif");
/*  720:     */     
/*  721: 642 */     this.jCalendarCompModifica.setText(resourceMap.getString("jCalendarCompModifica.text", new Object[0]));
/*  722: 643 */     this.jCalendarCompModifica.setName("jCalendarCompModifica");
/*  723:     */     
/*  724: 645 */     this.jLabel19.setFont(resourceMap.getFont("jLabel14.font"));
/*  725: 646 */     this.jLabel19.setText(resourceMap.getString("jLabel19.text", new Object[0]));
/*  726: 647 */     this.jLabel19.setName("jLabel19");
/*  727:     */     
/*  728: 649 */     this.textNumCompModif.setFont(resourceMap.getFont("textNumCompModif.font"));
/*  729: 650 */     this.textNumCompModif.setName("textNumCompModif");
/*  730:     */     
/*  731: 652 */     this.txtCodDoc.setText(resourceMap.getString("txtCodDoc.text", new Object[0]));
/*  732: 653 */     this.txtCodDoc.setEnabled(false);
/*  733: 654 */     this.txtCodDoc.setName("txtCodDoc");
/*  734: 655 */     this.txtCodDoc.setPreferredSize(new Dimension(20, 20));
/*  735: 656 */     this.txtCodDoc.addKeyListener(new KeyAdapter()
/*  736:     */     {
/*  737:     */       public void keyPressed(KeyEvent evt)
/*  738:     */       {
/*  739: 658 */         ComprobanteRetencionView.this.txtCodDocKeyPressed(evt);
/*  740:     */       }
/*  741: 661 */     });
/*  742: 662 */     this.jLabel3.setFont(resourceMap.getFont("jLabel3.font"));
/*  743: 663 */     this.jLabel3.setHorizontalAlignment(4);
/*  744: 664 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/*  745: 665 */     this.jLabel3.setEnabled(false);
/*  746: 666 */     this.jLabel3.setName("jLabel3");
/*  747:     */     
/*  748: 668 */     this.jLabel4.setFont(resourceMap.getFont("jLabel4.font"));
/*  749: 669 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/*  750: 670 */     this.jLabel4.setEnabled(false);
/*  751: 671 */     this.jLabel4.setName("jLabel4");
/*  752:     */     
/*  753: 673 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  754: 674 */     this.jPanel7.setLayout(jPanel7Layout);
/*  755: 675 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14).addComponent(this.jLabel16)).addGap(26, 26, 26).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.comboTipoDocModificado, -2, 138, -2).addComponent(this.comboImpuesto, -2, 138, -2).addComponent(this.textFechaCompModif, -2, 132, -2)).addGap(19, 19, 19).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCalendarCompModifica, -2, -1, -2).addComponent(this.txtCodDoc, -2, 26, -2))).addComponent(this.jLabel4))).addComponent(this.comboConceptoReten, 0, -1, 32767)).addComponent(this.jLabel18)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtBaseImponible, -2, 85, -2).addComponent(this.jLabel21)).addGap(13, 13, 13).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.txtImpuesto, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorRetenido)).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel22).addGap(18, 18, 18).addComponent(this.jLabel23)))).addGroup(jPanel7Layout.createSequentialGroup().addGap(87, 87, 87).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel3).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel19).addGap(42, 42, 42).addComponent(this.textNumCompModif, -2, 263, -2))))).addContainerGap(83, 32767)));
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
/*  803:     */ 
/*  804:     */ 
/*  805: 725 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel14).addComponent(this.comboTipoDocModificado, -2, -1, -2).addComponent(this.txtCodDoc, -2, -1, -2).addComponent(this.jLabel19).addComponent(this.textNumCompModif, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel16).addComponent(this.jCalendarCompModifica, -2, -1, -2).addComponent(this.textFechaCompModif, -2, -1, -2)).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.jLabel22).addComponent(this.jLabel23))).addComponent(this.jLabel18).addComponent(this.comboImpuesto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.txtImpuesto, -2, -1, -2).addComponent(this.txtBaseImponible, -2, -1, -2).addComponent(this.txtValorRetenido, -2, -1, -2).addComponent(this.comboConceptoReten, -2, -1, -2)).addContainerGap(20, 32767)));
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
/*  842: 762 */     jPanel7Layout.linkSize(1, new Component[] { this.txtBaseImponible, this.txtImpuesto, this.txtValorRetenido });
/*  843:     */     
/*  844: 764 */     this.cabecera1.setMaximumSize(new Dimension(820, 245));
/*  845: 765 */     this.cabecera1.setMinimumSize(new Dimension(820, 245));
/*  846: 766 */     this.cabecera1.setName("cabecera1");
/*  847: 767 */     this.cabecera1.setPreferredSize(new Dimension(820, 245));
/*  848:     */     
/*  849: 769 */     this.idenComprob.setName("idenComprob");
/*  850:     */     
/*  851: 771 */     GroupLayout layout = new GroupLayout(this);
/*  852: 772 */     setLayout(layout);
/*  853: 773 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel7, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.idenComprob, -1, 1103, 32767).addComponent(this.cabecera1, -1, 1103, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel4, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, 597, -2)).addComponent(this.jPanel3, -1, -1, 32767))));
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
/*  868: 788 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cabecera1, -2, 212, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.idenComprob, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel6, -2, 64, -2).addGap(55, 55, 55)).addComponent(this.jPanel4, -1, -1, 32767))));
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
/*  888: 808 */     getAccessibleContext().setAccessibleName(resourceMap.getString("Form.AccessibleContext.accessibleName", new Object[0]));
/*  889:     */   }
/*  890:     */   
/*  891:     */   public void setDate(String dateString)
/*  892:     */   {
/*  893: 816 */     Date date = null;
/*  894:     */     try
/*  895:     */     {
/*  896: 818 */       if ((dateString != null) && (dateString.length() > 0)) {
/*  897: 819 */         date = Constantes.dateFormat.parse(dateString);
/*  898:     */       }
/*  899:     */     }
/*  900:     */     catch (Exception e)
/*  901:     */     {
/*  902: 822 */       date = null;
/*  903:     */     }
/*  904: 824 */     setDate(date);
/*  905:     */   }
/*  906:     */   
/*  907:     */   public void setDate(Date date)
/*  908:     */   {
/*  909: 832 */     String dateString = "";
/*  910: 833 */     date = FormGenerales.eliminaHora(date);
/*  911: 834 */     Date hoy = FormGenerales.eliminaHora(new Date());
/*  912: 835 */     if ((date != null) && ((date.equals(hoy)) || (date.before(hoy))))
/*  913:     */     {
/*  914: 836 */       dateString = Constantes.dateFormat.format(date);
/*  915: 837 */       this.idenComprob.textFechaEmision.setText(dateString);
/*  916: 838 */       this.idenComprob.jCalendarFecha.setTargetDate(date);
/*  917: 839 */       this.fechaEmision = date;
/*  918:     */     }
/*  919:     */     else
/*  920:     */     {
/*  921: 842 */       JOptionPane.showMessageDialog(this, "No se permiten fechas mayores a la del día de hoy", "Se ha producido un error ", 1);
/*  922:     */     }
/*  923:     */   }
/*  924:     */   
/*  925:     */   public void actualizaClaveDeAcceso()
/*  926:     */   {
/*  927: 850 */     this.claveDeAcceso = null;
/*  928: 851 */     llenaDatosEmisor();
/*  929: 852 */     this.claveContingencia = new FormGenerales().obtieneClaveDeAcceso(this.secuencialComprobante, this.emisor, this.serie, this.claveDeAcceso, this.fechaEmision, TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode());
/*  930: 855 */     if ((this.claveContingencia.getCodigoComprobante() != null) && (!this.claveContingencia.getCodigoComprobante().isEmpty())) {
/*  931: 856 */       this.claveDeAcceso = this.claveContingencia.getCodigoComprobante();
/*  932:     */     }
/*  933: 858 */     this.idenComprob.lblClaveAcceso.setText(this.claveDeAcceso);
/*  934:     */   }
/*  935:     */   
/*  936:     */   public void setDateComprobante(Date date)
/*  937:     */   {
/*  938: 867 */     String dateString = "";
/*  939: 868 */     date = FormGenerales.eliminaHora(date);
/*  940: 869 */     if (date != null) {
/*  941: 870 */       dateString = Constantes.dateFormat.format(date);
/*  942:     */     }
/*  943: 872 */     this.textFechaCompModif.setText(dateString);
/*  944: 873 */     this.jCalendarCompModifica.setTargetDate(date);
/*  945:     */   }
/*  946:     */   
/*  947:     */   private void buscarCliente(String cadena, int parametro)
/*  948:     */   {
/*  949:     */     try
/*  950:     */     {
/*  951: 878 */       this.modeloDatosAdicionales.deleteAllRows();
/*  952: 879 */       this.btnFirmarProcesar.setEnabled(false);
/*  953: 880 */       this.btnGuardar.setEnabled(false);
/*  954: 883 */       if (parametro == 1) {
/*  955: 884 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(cadena, null, TipoClienteEnum.R);
/*  956:     */       } else {
/*  957: 886 */         this.clienteSeleccionado = new ClientesSQL().obtenerClientesTipo(null, cadena, TipoClienteEnum.R);
/*  958:     */       }
/*  959:     */     }
/*  960:     */     catch (Exception ex)
/*  961:     */     {
/*  962: 889 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/*  963:     */     }
/*  964: 891 */     if (this.clienteSeleccionado != null)
/*  965:     */     {
/*  966: 892 */       this.txtCedulaComprador.setText(this.clienteSeleccionado.getNumeroIdentificacio());
/*  967: 893 */       this.txtRazonComprador.setText(this.clienteSeleccionado.getApellido());
/*  968: 894 */       if (!this.clienteSeleccionado.getDireccion().isEmpty()) {
/*  969: 895 */         this.modeloDatosAdicionales.addRow("Dirección", this.clienteSeleccionado.getDireccion());
/*  970:     */       }
/*  971: 897 */       if (this.clienteSeleccionado.getTelefonoConvencional().length() > 1)
/*  972:     */       {
/*  973: 898 */         StringBuilder telefono = new StringBuilder(this.clienteSeleccionado.getTelefonoConvencional());
/*  974: 899 */         if (this.clienteSeleccionado.getExtencion().length() > 1)
/*  975:     */         {
/*  976: 900 */           telefono.append(" ext. ");
/*  977: 901 */           telefono.append(this.clienteSeleccionado.getExtencion());
/*  978:     */         }
/*  979: 903 */         this.modeloDatosAdicionales.addRow("Teléfono", telefono.toString());
/*  980:     */       }
/*  981: 905 */       this.modeloDatosAdicionales.addRow("Email", this.clienteSeleccionado.getCorreo());
/*  982:     */     }
/*  983:     */     else
/*  984:     */     {
/*  985: 907 */       JOptionPane.showMessageDialog(this, "No existen registros almacenados para el dato buscado", "Se ha producido un error ", 1);
/*  986:     */     }
/*  987:     */   }
/*  988:     */   
/*  989:     */   private ComprobanteRetencion generarComprobante()
/*  990:     */   {
/*  991: 912 */     ComprobanteRetencion compRetencion = null;
/*  992: 914 */     if (!llenarObjetoComprobante())
/*  993:     */     {
/*  994: 916 */       ComprobanteRetencion.Impuestos impuestos = obtenerImpuestos();
/*  995: 917 */       ComprobanteRetencion.InfoAdicional informacion = generarInformacionAdicional();
/*  996: 919 */       if (impuestos != null)
/*  997:     */       {
/*  998: 920 */         compRetencion = this.factory.createComprobanteRetencion();
/*  999: 921 */         compRetencion.setVersion("1.0.0");
/* 1000: 922 */         compRetencion.setId("comprobante");
/* 1001: 923 */         compRetencion.setInfoTributaria(this.infoTributaria);
/* 1002: 924 */         compRetencion.setInfoCompRetencion(this.infoCompRetencion);
/* 1003:     */         
/* 1004: 926 */         compRetencion.setImpuestos(impuestos);
/* 1005: 927 */         if (informacion.getCampoAdicional().size() > 0) {
/* 1006: 928 */           compRetencion.setInfoAdicional(informacion);
/* 1007:     */         }
/* 1008:     */       }
/* 1009:     */     }
/* 1010: 932 */     return compRetencion;
/* 1011:     */   }
/* 1012:     */   
/* 1013:     */   ComprobanteRetencion.Impuestos obtenerImpuestos()
/* 1014:     */   {
/* 1015: 943 */     ComprobanteRetencion.Impuestos resultado = this.factory.createComprobanteRetencionImpuestos();
/* 1016:     */     
/* 1017: 945 */     boolean error = false;
/* 1018:     */     try
/* 1019:     */     {
/* 1020: 948 */       for (int i = 0; i < this.modeloDetalle.getRowCount(); i++)
/* 1021:     */       {
/* 1022: 949 */         Object[] item = this.modeloDetalle.getRow(i);
/* 1023:     */         
/* 1024: 951 */         ImpuestoValor iv = new ImpuestoValorSQL().obtenerValorPorCodigo((String)item[0]);
/* 1025: 952 */         if (iv != null)
/* 1026:     */         {
/* 1027: 954 */           Impuesto ir = this.factory.createImpuesto();
/* 1028: 955 */           ir.setCodigo(String.valueOf(iv.getCodigoImpuesto()));
/* 1029: 956 */           ir.setCodigoRetencion(iv.getCodigo());
/* 1030: 957 */           ir.setPorcentajeRetener((BigDecimal)item[4]);
/* 1031: 958 */           ir.setBaseImponible((BigDecimal)item[3]);
/* 1032: 959 */           ir.setValorRetenido((BigDecimal)item[5]);
/* 1033: 960 */           ir.setCodDocSustento((String)item[8]);
/* 1034: 961 */           String numeroDocSustento = "".equals((String)item[6]) ? null : item[6].toString();
/* 1035: 962 */           ir.setNumDocSustento(numeroDocSustento);
/* 1036: 963 */           ir.setFechaEmisionDocSustento((String)item[7]);
/* 1037: 964 */           resultado.getImpuesto().add(ir);
/* 1038:     */         }
/* 1039:     */       }
/* 1040:     */     }
/* 1041:     */     catch (Exception ex)
/* 1042:     */     {
/* 1043: 969 */       Logger.getLogger(ComprobanteRetencionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1044:     */     }
/* 1045: 972 */     if (error == true) {
/* 1046: 973 */       resultado = null;
/* 1047:     */     }
/* 1048: 975 */     return resultado;
/* 1049:     */   }
/* 1050:     */   
/* 1051:     */   private ComprobanteRetencion.InfoAdicional generarInformacionAdicional()
/* 1052:     */   {
/* 1053: 985 */     ComprobanteRetencion.InfoAdicional info = this.factory.createComprobanteRetencionInfoAdicional();
/* 1054: 987 */     for (int i = 0; i < this.modeloDatosAdicionales.getRowCount(); i++)
/* 1055:     */     {
/* 1056: 988 */       ComprobanteRetencion.InfoAdicional.CampoAdicional detalle = this.factory.createComprobanteRetencionInfoAdicionalCampoAdicional();
/* 1057: 989 */       detalle.setNombre((String)this.modeloDatosAdicionales.getValueAt(i, 0));
/* 1058: 990 */       detalle.setValue((String)this.modeloDatosAdicionales.getValueAt(i, 1));
/* 1059:     */       
/* 1060: 992 */       info.getCampoAdicional().add(detalle);
/* 1061:     */     }
/* 1062: 994 */     return info;
/* 1063:     */   }
/* 1064:     */   
/* 1065:     */   private boolean llenarObjetoComprobante()
/* 1066:     */   {
/* 1067:1001 */     StringBuilder mensajes = new StringBuilder();
/* 1068:1002 */     boolean error = false;
/* 1069:     */     
/* 1070:1004 */     this.infoTributaria = this.factory.createInfoTributaria();
/* 1071:     */     
/* 1072:1006 */     this.infoTributaria.setAmbiente(this.emisor.getTipoAmbiente());
/* 1073:1007 */     this.infoTributaria.setTipoEmision(this.emisor.getTipoEmision());
/* 1074:1008 */     this.infoTributaria.setRazonSocial(this.emisor.getRazonSocial());
/* 1075:1009 */     this.infoTributaria.setRuc(this.emisor.getRuc());
/* 1076:1010 */     this.infoTributaria.setCodDoc(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode());
/* 1077:1011 */     this.infoTributaria.setEstab(this.emisor.getCodigoEstablecimiento());
/* 1078:1012 */     this.infoTributaria.setPtoEmi(this.emisor.getCodPuntoEmision());
/* 1079:1013 */     this.infoTributaria.setSecuencial(this.secuencialComprobante);
/* 1080:1014 */     this.infoTributaria.setDirMatriz(this.emisor.getDireccionMatriz());
/* 1081:1016 */     if (this.claveDeAcceso != null)
/* 1082:     */     {
/* 1083:1017 */       this.infoTributaria.setClaveAcceso(this.claveDeAcceso);
/* 1084:     */     }
/* 1085:     */     else
/* 1086:     */     {
/* 1087:1019 */       JOptionPane.showMessageDialog(this, "\nLa clave de Acceso no puede ser nula", "Se ha producido un error ", 0);
/* 1088:     */       
/* 1089:1021 */       error = true;
/* 1090:     */     }
/* 1091:1024 */     if ((this.emisor.getNombreComercial() != null) && (!this.emisor.getNombreComercial().isEmpty())) {
/* 1092:1025 */       this.infoTributaria.setNombreComercial(this.emisor.getNombreComercial());
/* 1093:     */     }
/* 1094:1028 */     this.infoCompRetencion = this.factory.createComprobanteRetencionInfoCompRetencion();
/* 1095:     */     
/* 1096:1030 */     this.infoCompRetencion.setFechaEmision(Constantes.dateFormat.format(FormGenerales.eliminaHora(this.fechaEmision)));
/* 1097:1032 */     if ((this.emisor.getDirEstablecimiento() != null) && (!this.emisor.getDirEstablecimiento().isEmpty())) {
/* 1098:1033 */       this.infoCompRetencion.setDirEstablecimiento(this.emisor.getDirEstablecimiento());
/* 1099:     */     }
/* 1100:1036 */     if (this.clienteSeleccionado != null)
/* 1101:     */     {
/* 1102:1037 */       this.razonSociaSujetoReten = this.clienteSeleccionado.getApellido();
/* 1103:1038 */       this.identSujetoRetenido = this.clienteSeleccionado.getNumeroIdentificacio();
/* 1104:1039 */       this.infoCompRetencion.setIdentificacionSujetoRetenido(this.identSujetoRetenido);
/* 1105:1040 */       this.infoCompRetencion.setRazonSocialSujetoRetenido(this.razonSociaSujetoReten);
/* 1106:1041 */       this.infoCompRetencion.setTipoIdentificacionSujetoRetenido(TipoCompradorEnum.retornaCodigo(this.clienteSeleccionado.getTipoIdentificacion()));
/* 1107:     */     }
/* 1108:     */     else
/* 1109:     */     {
/* 1110:1043 */       mensajes.append("\nLos datos de Sujeto Retenido son obligatorios");
/* 1111:1044 */       error = true;
/* 1112:     */     }
/* 1113:1046 */     if (this.textFechaCompModif.getText().isEmpty())
/* 1114:     */     {
/* 1115:1047 */       mensajes.append("\nIngrese la fecha de emisión del comprobante a modificar");
/* 1116:1048 */       error = true;
/* 1117:     */     }
/* 1118:1051 */     Date fechaIngresada = null;
/* 1119:1052 */     if ((this.txtMes.getText().isEmpty()) || (this.txtAnio.getText().isEmpty()))
/* 1120:     */     {
/* 1121:1053 */       mensajes.append("\nEl mes y el año del período fiscal son obligatorios");
/* 1122:1054 */       error = true;
/* 1123:     */     }
/* 1124:     */     else
/* 1125:     */     {
/* 1126:1056 */       Calendar cal = Calendar.getInstance();
/* 1127:1057 */       cal.setTime(new Date());
/* 1128:1058 */       cal.set(1, Integer.parseInt(this.txtAnio.getText()));
/* 1129:1059 */       cal.set(2, Integer.parseInt(this.txtMes.getText()) - 1);
/* 1130:1060 */       cal.set(11, 0);
/* 1131:1061 */       cal.set(12, 0);
/* 1132:1062 */       cal.set(13, 0);
/* 1133:1063 */       cal.set(14, 0);
/* 1134:1064 */       fechaIngresada = cal.getTime();
/* 1135:1066 */       if (fechaIngresada.after(new Date()))
/* 1136:     */       {
/* 1137:1067 */         mensajes.append("\nEl período fiscal no puede ser mayor a la fecha actual");
/* 1138:1068 */         error = true;
/* 1139:     */       }
/* 1140:     */       else
/* 1141:     */       {
/* 1142:1070 */         this.infoCompRetencion.setPeriodoFiscal(this.txtMes.getText() + "/" + this.txtAnio.getText());
/* 1143:     */       }
/* 1144:     */     }
/* 1145:1074 */     if ((this.emisor.getContribuyenteEspecial() != null) && (!this.emisor.getContribuyenteEspecial().isEmpty())) {
/* 1146:1075 */       this.infoCompRetencion.setContribuyenteEspecial(this.emisor.getContribuyenteEspecial());
/* 1147:     */     }
/* 1148:1077 */     if (this.emisor.getLlevaContabilidad() != null) {
/* 1149:1078 */       if (this.emisor.getLlevaContabilidad().equals("S")) {
/* 1150:1079 */         this.infoCompRetencion.setObligadoContabilidad("SI");
/* 1151:     */       } else {
/* 1152:1081 */         this.infoCompRetencion.setObligadoContabilidad("NO");
/* 1153:     */       }
/* 1154:     */     }
/* 1155:1085 */     if (error == true) {
/* 1156:1086 */       JOptionPane.showMessageDialog(this, mensajes.toString(), "Se ha producido un error ", 0);
/* 1157:     */     }
/* 1158:1089 */     return error;
/* 1159:     */   }
/* 1160:     */   
/* 1161:     */   private void limpiarFormulario()
/* 1162:     */   {
/* 1163:1093 */     this.textNumCompModif.setText(null);
/* 1164:1094 */     this.txtBaseImponible.setValue(null);
/* 1165:1095 */     this.txtImpuesto.setValue(null);
/* 1166:1096 */     this.txtValorRetenido.setValue(null);
/* 1167:1097 */     this.textFechaCompModif.setText(null);
/* 1168:1098 */     this.jCalendarCompModifica.setTargetDate(null);
/* 1169:1099 */     this.txtCedulaComprador.setText(null);
/* 1170:1100 */     this.txtRazonComprador.setText(null);
/* 1171:1101 */     this.txtMes.setText(null);
/* 1172:1102 */     this.txtAnio.setText(null);
/* 1173:1103 */     this.txtCodDoc.setText(null);
/* 1174:     */     
/* 1175:1105 */     this.comboConceptoReten.setModel(new DefaultComboBoxModel(new String[] { "Seleccione Impuesto..." }));
/* 1176:     */   }
/* 1177:     */   
/* 1178:     */   private void btnNuevoDatoActionPerformed(ActionEvent evt)
/* 1179:     */   {
/* 1180:1109 */     this.modeloDatosAdicionales.addRow("", "");
/* 1181:     */   }
/* 1182:     */   
/* 1183:     */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 1184:     */   {
/* 1185:1113 */     String respuestaCrear = null;
/* 1186:1114 */     ComprobanteRetencion comprobanteLleno = null;
/* 1187:1115 */     String archivoACrear = null;
/* 1188:     */     try
/* 1189:     */     {
/* 1190:1118 */       if (this.modeloDetalle.getRowCount() > 0)
/* 1191:     */       {
/* 1192:1120 */         comprobanteLleno = generarComprobante();
/* 1193:     */         
/* 1194:1122 */         String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1195:1123 */         archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1196:     */         
/* 1197:     */ 
/* 1198:1126 */         respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobanteLleno, this.claveContingencia, this.secuencial, TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode());
/* 1199:1129 */         if (respuestaCrear == null)
/* 1200:     */         {
/* 1201:1130 */           JOptionPane.showMessageDialog(this, archivoACrear, "El comprobante fue guardado exitósamente", 1);
/* 1202:     */           
/* 1203:     */ 
/* 1204:     */ 
/* 1205:1134 */           ComprobanteRetencionReporte crr = new ComprobanteRetencionReporte(comprobanteLleno);
/* 1206:     */           
/* 1207:1136 */           generarReporte(crr, null, null);
/* 1208:1137 */           this.btnFirmarProcesar.setEnabled(false);
/* 1209:     */         }
/* 1210:     */       }
/* 1211:     */       else
/* 1212:     */       {
/* 1213:1140 */         JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE DE VENTA VACIO", 1);
/* 1214:     */       }
/* 1215:     */     }
/* 1216:     */     catch (Exception ex)
/* 1217:     */     {
/* 1218:1144 */       Logger.getLogger(ComprobanteRetencionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1219:     */     }
/* 1220:     */   }
/* 1221:     */   
/* 1222:     */   public void generarReporte(ComprobanteRetencionReporte xml, String numAut, String fechaAut)
/* 1223:     */   {
/* 1224:1149 */     ReporteUtil repUtil = new ReporteUtil();
/* 1225:     */     try
/* 1226:     */     {
/* 1227:1151 */       repUtil.generarReporte("resources/reportes/comprobanteRetencion.jasper", xml, numAut, fechaAut);
/* 1228:     */     }
/* 1229:     */     catch (SQLException ex)
/* 1230:     */     {
/* 1231:1153 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1232:     */     }
/* 1233:     */     catch (ClassNotFoundException ex)
/* 1234:     */     {
/* 1235:1155 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1236:     */     }
/* 1237:     */   }
/* 1238:     */   
/* 1239:     */   private void comboImpuestoActionPerformed(ActionEvent evt)
/* 1240:     */   {
/* 1241:1159 */     List<ImpuestoValor> listado = new ArrayList();
/* 1242:     */     try
/* 1243:     */     {
/* 1244:1161 */       if (((String)this.comboImpuesto.getSelectedItem()).equals(TipoImpuestoEnum.IVA.getDescripcion())) {
/* 1245:1162 */         listado = new ImpuestoValorSQL().obtenerIVARetencion();
/* 1246:1163 */       } else if (((String)this.comboImpuesto.getSelectedItem()).equals(TipoImpuestoEnum.RENTA.getDescripcion())) {
/* 1247:1164 */         listado = new ImpuestoValorSQL().obtenerValorImpuestoRenta();
/* 1248:     */       }
/* 1249:     */     }
/* 1250:     */     catch (SQLException ex)
/* 1251:     */     {
/* 1252:1167 */       Logger.getLogger(ComprobanteRetencionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1253:     */     }
/* 1254:     */     catch (ClassNotFoundException ex)
/* 1255:     */     {
/* 1256:1169 */       Logger.getLogger(ComprobanteRetencionView.class.getName()).log(Level.SEVERE, null, ex);
/* 1257:     */     }
/* 1258:1173 */     for (ImpuestoValor iv : listado) {
/* 1259:1174 */       if ((iv.getTipoImpuesto().equals("A")) && (iv.getPorcentajeRentencion().intValue() == 70)) {
/* 1260:1175 */         iv.setDescripcion("70%");
/* 1261:     */       }
/* 1262:     */     }
/* 1263:1178 */     this.comboConceptoReten.setModel(new DefaultComboBoxModel(listado.toArray()));
/* 1264:1179 */     ImpuestoValor iv = (ImpuestoValor)this.comboConceptoReten.getSelectedItem();
/* 1265:1180 */     if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.IVA.getCode()) {
/* 1266:1181 */       this.txtImpuesto.setValue(iv.getPorcentajeRentencion());
/* 1267:     */     } else {
/* 1268:1183 */       this.txtImpuesto.setValue(iv.getPorcentaje());
/* 1269:     */     }
/* 1270:     */   }
/* 1271:     */   
/* 1272:     */   private void comboConceptoRetenActionPerformed(ActionEvent evt)
/* 1273:     */   {
/* 1274:1190 */     ImpuestoValor iv = null;
/* 1275:1191 */     if ((this.comboConceptoReten.getSelectedItem() != null) && (((ImpuestoValor)this.comboConceptoReten.getSelectedItem()).getCodigo() != null))
/* 1276:     */     {
/* 1277:1192 */       iv = (ImpuestoValor)this.comboConceptoReten.getSelectedItem();
/* 1278:1195 */       if (iv.getCodigoImpuesto().intValue() == TipoImpuestoEnum.IVA.getCode()) {
/* 1279:1196 */         iv.setPorcentaje(iv.getPorcentajeRentencion());
/* 1280:     */       }
/* 1281:     */     }
/* 1282:1201 */     if ((iv.getPorcentaje().doubleValue() != 0.0D) && (iv.getPorcentajeRentencion().doubleValue() != 0.0D) && (iv.getCodigoImpuesto().intValue() != TipoImpuestoEnum.IVA.getCode()))
/* 1283:     */     {
/* 1284:1203 */       this.txtImpuesto.setEnabled(true);
/* 1285:1204 */       this.txtImpuesto.setValue(null);
/* 1286:1205 */       this.txtValorRetenido.setValue(null);
/* 1287:     */     }
/* 1288:1206 */     else if ((iv.getPorcentaje().doubleValue() == 0.0D) && (iv.getPorcentaje().doubleValue() == 0.0D))
/* 1289:     */     {
/* 1290:1208 */       this.txtImpuesto.setEnabled(true);
/* 1291:1209 */       this.txtImpuesto.setValue(null);
/* 1292:1210 */       this.txtValorRetenido.setValue(null);
/* 1293:     */     }
/* 1294:     */     else
/* 1295:     */     {
/* 1296:1213 */       this.txtImpuesto.setValue(iv.getPorcentaje());
/* 1297:1214 */       this.txtImpuesto.setEnabled(false);
/* 1298:1215 */       this.txtValorRetenido.setValue(null);
/* 1299:     */     }
/* 1300:1217 */     this.txtBaseImponible.requestFocus();
/* 1301:1218 */     this.txtValorRetenido.setEnabled(true);
/* 1302:     */   }
/* 1303:     */   
/* 1304:     */   private void comboConceptoRetenItemStateChanged(ItemEvent evt) {}
/* 1305:     */   
/* 1306:     */   private void txtBaseImponibleFocusLost(FocusEvent evt) {}
/* 1307:     */   
/* 1308:     */   private void txtValorRetenidoFocusGained(FocusEvent evt)
/* 1309:     */   {
/* 1310:1230 */     BigDecimal valorTotal = BigDecimal.ZERO;
/* 1311:1231 */     BigDecimal impuesto = BigDecimal.ZERO;
/* 1312:1232 */     BigDecimal baseImponible = BigDecimal.ZERO;
/* 1313:1235 */     if ((this.txtImpuesto.getValue() instanceof Long)) {
/* 1314:1236 */       impuesto = BigDecimal.valueOf(((Long)this.txtImpuesto.getValue()).longValue());
/* 1315:1237 */     } else if ((this.txtImpuesto.getValue() instanceof Double)) {
/* 1316:1238 */       impuesto = BigDecimal.valueOf(((Double)this.txtImpuesto.getValue()).doubleValue());
/* 1317:     */     }
/* 1318:1242 */     ImpuestoValor iv = null;
/* 1319:1243 */     if ((this.comboConceptoReten.getSelectedItem() != null) && (((ImpuestoValor)this.comboConceptoReten.getSelectedItem()).getCodigo() != null))
/* 1320:     */     {
/* 1321:1244 */       iv = (ImpuestoValor)this.comboConceptoReten.getSelectedItem();
/* 1322:1247 */       if ((iv.getPorcentaje().doubleValue() != 0.0D) && (iv.getPorcentajeRentencion().doubleValue() != 0.0D) && (iv.getCodigoImpuesto().intValue() != TipoImpuestoEnum.IVA.getCode())) {
/* 1323:1249 */         if ((impuesto.doubleValue() < iv.getPorcentaje().doubleValue()) || (impuesto.doubleValue() > iv.getPorcentajeRentencion().doubleValue()))
/* 1324:     */         {
/* 1325:1251 */           JOptionPane.showMessageDialog(this, "El valor del Impuesto debe encontrarse entre: " + iv.getPorcentaje() + " y " + iv.getPorcentajeRentencion(), "ERROR EN VALOR DEL IMPUESTO", 1);
/* 1326:     */           
/* 1327:1253 */           this.txtImpuesto.setValue(null);
/* 1328:1254 */           this.txtImpuesto.setValue(Double.valueOf(iv.getPorcentaje().doubleValue()));
/* 1329:     */         }
/* 1330:     */       }
/* 1331:     */     }
/* 1332:1259 */     if (impuesto.doubleValue() != 0.0D)
/* 1333:     */     {
/* 1334:1261 */       if ((this.txtBaseImponible.getValue() instanceof Long)) {
/* 1335:1262 */         baseImponible = BigDecimal.valueOf(((Long)this.txtBaseImponible.getValue()).longValue());
/* 1336:     */       } else {
/* 1337:1264 */         baseImponible = BigDecimal.valueOf(((Double)this.txtBaseImponible.getValue()).doubleValue());
/* 1338:     */       }
/* 1339:1267 */       valorTotal = baseImponible.multiply(impuesto).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP);
/* 1340:1268 */       this.txtValorRetenido.setValue(valorTotal);
/* 1341:1269 */       this.btnAdicionarDetalle.setEnabled(true);
/* 1342:     */     }
/* 1343:     */     else
/* 1344:     */     {
/* 1345:1272 */       this.txtImpuesto.requestFocus();
/* 1346:     */     }
/* 1347:     */   }
/* 1348:     */   
/* 1349:     */   private void btnAdicionarDetalleActionPerformed(ActionEvent evt)
/* 1350:     */   {
/* 1351:1278 */     BigDecimal impuesto = BigDecimal.ZERO;
/* 1352:1279 */     BigDecimal baseImponible = BigDecimal.ZERO;
/* 1353:     */     
/* 1354:1281 */     ImpuestoValor iv = null;
/* 1355:1282 */     if ((this.comboConceptoReten.getSelectedItem() != null) && (((ImpuestoValor)this.comboConceptoReten.getSelectedItem()).getCodigo() != null)) {
/* 1356:1283 */       iv = (ImpuestoValor)this.comboConceptoReten.getSelectedItem();
/* 1357:     */     }
/* 1358:1286 */     if ((this.txtImpuesto.getValue() instanceof Long)) {
/* 1359:1287 */       impuesto = BigDecimal.valueOf(((Long)this.txtImpuesto.getValue()).longValue());
/* 1360:1288 */     } else if ((this.txtImpuesto.getValue() instanceof Double)) {
/* 1361:1289 */       impuesto = BigDecimal.valueOf(((Double)this.txtImpuesto.getValue()).doubleValue());
/* 1362:     */     }
/* 1363:1292 */     if ((this.txtBaseImponible.getValue() instanceof Long)) {
/* 1364:1293 */       baseImponible = BigDecimal.valueOf(((Long)this.txtBaseImponible.getValue()).longValue());
/* 1365:     */     } else {
/* 1366:1295 */       baseImponible = BigDecimal.valueOf(((Double)this.txtBaseImponible.getValue()).doubleValue());
/* 1367:     */     }
/* 1368:1298 */     String tipoDoc = null;
/* 1369:1299 */     if (((String)this.comboTipoDocModificado.getSelectedItem()).equals("OTROS"))
/* 1370:     */     {
/* 1371:1300 */       if ((this.txtCodDoc.getText() == null) || (this.txtCodDoc.getText().isEmpty()))
/* 1372:     */       {
/* 1373:1301 */         JOptionPane.showMessageDialog(this, "\nIngrese el Código del Documento al que se refiere la opción OTROS", "Se ha producido un error ", 0);
/* 1374:1302 */         this.txtCodDoc.requestFocus();
/* 1375:     */       }
/* 1376:     */       else
/* 1377:     */       {
/* 1378:1304 */         tipoDoc = this.txtCodDoc.getText();
/* 1379:     */       }
/* 1380:     */     }
/* 1381:     */     else {
/* 1382:1307 */       tipoDoc = TipoComprobanteEnum.retornaCodigo((String)this.comboTipoDocModificado.getSelectedItem());
/* 1383:     */     }
/* 1384:1310 */     if (tipoDoc != null) {
/* 1385:1311 */       if ((this.textNumCompModif.getText().isEmpty()) && (!((String)this.comboTipoDocModificado.getSelectedItem()).equals("OTROS")))
/* 1386:     */       {
/* 1387:1312 */         JOptionPane.showMessageDialog(this, "\nIngrese el número de comprobante a modificar", "Se ha producido un error ", 0);
/* 1388:1313 */         this.textNumCompModif.requestFocus();
/* 1389:     */       }
/* 1390:1314 */       else if ((this.textNumCompModif.getText().length() < 15) && (!((String)this.comboTipoDocModificado.getSelectedItem()).equals("OTROS")))
/* 1391:     */       {
/* 1392:1315 */         JOptionPane.showMessageDialog(this, "\n El Nro. del Comprobante debe de ser de 15 dígitos", "Se ha producido un error ", 0);
/* 1393:1316 */         this.textNumCompModif.requestFocus();
/* 1394:     */       }
/* 1395:1317 */       else if (this.textFechaCompModif.getText().isEmpty())
/* 1396:     */       {
/* 1397:1318 */         JOptionPane.showMessageDialog(this, "\nIngrese la fecha de emisión del comprobante a modificar", "Se ha producido un error ", 0);
/* 1398:     */       }
/* 1399:1319 */       else if (FormGenerales.eliminaHora(this.jCalendarCompModifica.getTargetDate()).after(this.fechaEmision))
/* 1400:     */       {
/* 1401:1320 */         JOptionPane.showMessageDialog(this, "La fecha del Comprobante de Retención no puede ser menor a la fecha de emisión del Documento de Sustento", "Se ha producido un error ", 0);
/* 1402:1321 */         this.textFechaCompModif.requestFocus();
/* 1403:     */       }
/* 1404:     */       else
/* 1405:     */       {
/* 1406:1323 */         this.modeloDetalle.addRow(iv, baseImponible, impuesto, baseImponible.multiply(impuesto).divide(BigDecimal.valueOf(100L), 2, RoundingMode.HALF_UP), this.textNumCompModif.getText(), this.textFechaCompModif.getText(), tipoDoc);
/* 1407:1324 */         this.btnFirmarProcesar.setEnabled(true);
/* 1408:1325 */         this.btnGuardar.setEnabled(true);
/* 1409:     */       }
/* 1410:     */     }
/* 1411:     */   }
/* 1412:     */   
/* 1413:     */   private void btnFirmarProcesarActionPerformed(ActionEvent evt)
/* 1414:     */   {
/* 1415:     */     try
/* 1416:     */     {
/* 1417:1332 */       setCursor(Cursor.getPredefinedCursor(3));
/* 1418:1333 */       this.btnFirmarProcesar.setEnabled(false);
/* 1419:1335 */       if (validarElementosComprobante().booleanValue() == true)
/* 1420:     */       {
/* 1421:1336 */         if (FormGenerales.validarUrl(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == null) {
/* 1422:1337 */           validarConexionCreacion();
/* 1423:     */         } else {
/* 1424:1339 */           JOptionPane.showMessageDialog(this, "URL MAL CONFIGURADO", "URL MAL CONFIGURADO", 1);
/* 1425:     */         }
/* 1426:     */       }
/* 1427:     */       else {
/* 1428:1343 */         JOptionPane.showMessageDialog(this, "\nAl menos debe añadir un item al comprobante, todas las columnas de ICE e IRBPNR deben estar llenas", "COMPROBANTE DE VENTA VACIO", 1);
/* 1429:     */       }
/* 1430:     */     }
/* 1431:     */     catch (Exception ex)
/* 1432:     */     {
/* 1433:1346 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1434:1347 */       JOptionPane.showMessageDialog(new JFrame(), "Error al tratar de enviar el comprobante hacia el SRI:\n" + ex.getMessage(), "Se ha producido un error ", 0);
/* 1435:     */     }
/* 1436:     */     finally
/* 1437:     */     {
/* 1438:1349 */       setCursor(Cursor.getDefaultCursor());
/* 1439:1350 */       this.btnFirmarProcesar.setEnabled(true);
/* 1440:     */     }
/* 1441:     */   }
/* 1442:     */   
/* 1443:     */   private Boolean validarElementosComprobante()
/* 1444:     */   {
/* 1445:1360 */     boolean response = false;
/* 1446:1361 */     if (this.modeloDetalle.getRowCount() > 0) {
/* 1447:1362 */       response = true;
/* 1448:     */     }
/* 1449:1364 */     return Boolean.valueOf(response);
/* 1450:     */   }
/* 1451:     */   
/* 1452:     */   private void validarConexionCreacion()
/* 1453:     */     throws SQLException, ClassNotFoundException, InterruptedException
/* 1454:     */   {
/* 1455:1376 */     String respuestaCrear = null;
/* 1456:     */     
/* 1457:1378 */     ComprobanteRetencion comprobanteXml = generarComprobante();
/* 1458:1379 */     String nombreArchivo = this.claveDeAcceso + ".xml";
/* 1459:1380 */     String archivoACrear = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.GENERADOS.getCode()).getPath() + File.separator + nombreArchivo;
/* 1460:1383 */     if (FormGenerales.existConnection(this.emisor.getTipoAmbiente(), "RecepcionComprobantes") == true)
/* 1461:     */     {
/* 1462:1384 */       if (this.emisor.getTipoEmision().equals(StringUtil.obtenerTipoEmision(TipoEmisionEnum.CONTINGENCIA.getCode())))
/* 1463:     */       {
/* 1464:1385 */         JOptionPane.showMessageDialog(new JPanel(), "Ya existe conexión se cambiara el tipo de emisión a Normal", "Mensaje", 2);
/* 1465:1386 */         actualizaEmisor();
/* 1466:1387 */         emisionNormal(respuestaCrear, archivoACrear, comprobanteXml, nombreArchivo);
/* 1467:     */       }
/* 1468:     */       else
/* 1469:     */       {
/* 1470:1389 */         emisionNormal(respuestaCrear, archivoACrear, comprobanteXml, nombreArchivo);
/* 1471:     */       }
/* 1472:     */     }
/* 1473:     */     else
/* 1474:     */     {
/* 1475:1393 */       int i = JOptionPane.showConfirmDialog(null, "No existe conexión.\n Desea emitir en contingencia?", "Advertencia", 0);
/* 1476:1394 */       if (i == 0) {
/* 1477:1395 */         emisionContingencia(comprobanteXml, archivoACrear, nombreArchivo);
/* 1478:     */       }
/* 1479:     */     }
/* 1480:     */   }
/* 1481:     */   
/* 1482:     */   private void actualizaEmisor()
/* 1483:     */   {
/* 1484:1401 */     this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.NORMAL.getCode(), this.emisor);
/* 1485:     */   }
/* 1486:     */   
/* 1487:     */   private void emisionContingencia(ComprobanteRetencion comprobanteXml, String archivoACrear, String nombreArchivo)
/* 1488:     */   {
/* 1489:1405 */     if (FormGenerales.verificarClavesContingencia() == true)
/* 1490:     */     {
/* 1491:1406 */       this.emisor = FormGenerales.actualizaEmisor(TipoEmisionEnum.CONTINGENCIA.getCode(), this.emisor);
/* 1492:1407 */       actualizaClaveDeAcceso();
/* 1493:1408 */       comprobanteXml = generarComprobante();
/* 1494:     */       
/* 1495:1410 */       nombreArchivo = this.claveDeAcceso + ".xml";
/* 1496:1411 */       archivoACrear = archivoACrear.substring(0, archivoACrear.lastIndexOf(File.separator)) + File.separator + nombreArchivo;
/* 1497:     */       
/* 1498:     */ 
/* 1499:1414 */       FormGenerales.creaArchivoEnContingencia(archivoACrear, comprobanteXml, nombreArchivo, this.claveContingencia, this.secuencial, this.emisor, TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode());
/* 1500:     */     }
/* 1501:     */     else
/* 1502:     */     {
/* 1503:1417 */       JOptionPane.showMessageDialog(this, "No se han encontrado claves de contingencia en el Sistema", "Claves no existen", 0);
/* 1504:     */     }
/* 1505:     */   }
/* 1506:     */   
/* 1507:     */   private void emisionNormal(String respuestaCrear, String archivoACrear, ComprobanteRetencion comprobanteXml, String nombreArchivo)
/* 1508:     */   {
/* 1509:     */     try
/* 1510:     */     {
/* 1511:1423 */       respuestaCrear = ArchivoUtils.crearArchivoXml2(archivoACrear, comprobanteXml, this.claveContingencia, this.secuencial, TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode());
/* 1512:1425 */       if (respuestaCrear == null)
/* 1513:     */       {
/* 1514:1426 */         if (((System.getProperty("os.name").toUpperCase().indexOf("LINUX") == 0) || (System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)) && (this.password == null)) {
/* 1515:1428 */           this.password = FormGenerales.ingresaPassword();
/* 1516:     */         }
/* 1517:1432 */         ArchivoUtils.firmarEnviarAutorizar(this.emisor, archivoACrear, nombreArchivo, this.infoTributaria.getRuc(), this.infoTributaria.getCodDoc(), this.claveDeAcceso, this.password);
/* 1518:     */       }
/* 1519:     */       else
/* 1520:     */       {
/* 1521:1434 */         JOptionPane.showMessageDialog(this, "Error al tratar de crear el archivo correspondiente al comprobante:\n" + respuestaCrear, "Se ha producido un error ", 0);
/* 1522:     */       }
/* 1523:     */     }
/* 1524:     */     catch (Exception ex)
/* 1525:     */     {
/* 1526:1437 */       Logger.getLogger(FacturaView.class.getName()).log(Level.SEVERE, null, ex);
/* 1527:     */     }
/* 1528:     */   }
/* 1529:     */   
/* 1530:     */   private void btnNuevoActionPerformed(ActionEvent evt)
/* 1531:     */   {
/* 1532:1442 */     inicializarDatos();
/* 1533:1443 */     limpiarFormulario();
/* 1534:1444 */     actualizaClaveDeAcceso();
/* 1535:     */   }
/* 1536:     */   
/* 1537:     */   private void btnBuscarActionPerformed(ActionEvent evt)
/* 1538:     */   {
/* 1539:1449 */     if (!this.txtCedulaComprador.getText().isEmpty()) {
/* 1540:1450 */       buscarCliente(this.txtCedulaComprador.getText(), 1);
/* 1541:1451 */     } else if (!this.txtRazonComprador.getText().isEmpty()) {
/* 1542:1452 */       buscarCliente(this.txtRazonComprador.getText(), 2);
/* 1543:     */     } else {
/* 1544:1454 */       JOptionPane.showMessageDialog(this, "Ingrese el RUC /CI o pasaporte o la Razón Social", "Ingrese campo", 1);
/* 1545:     */     }
/* 1546:     */   }
/* 1547:     */   
/* 1548:     */   private void comboTipoDocModificadoActionPerformed(ActionEvent evt)
/* 1549:     */   {
/* 1550:1459 */     if (((String)this.comboTipoDocModificado.getSelectedItem()).equals("OTROS") == true)
/* 1551:     */     {
/* 1552:1460 */       this.txtCodDoc.setEnabled(true);
/* 1553:1461 */       this.txtCodDoc.requestFocus();
/* 1554:     */     }
/* 1555:     */     else
/* 1556:     */     {
/* 1557:1463 */       this.txtCodDoc.setEnabled(false);
/* 1558:1464 */       this.txtCodDoc.setText(null);
/* 1559:     */     }
/* 1560:     */   }
/* 1561:     */   
/* 1562:     */   private void txtCodDocKeyPressed(KeyEvent evt)
/* 1563:     */   {
/* 1564:1469 */     if (FormGenerales.validaSoloNumeros(evt, this.txtCodDoc) == true) {
/* 1565:1470 */       processKeyEvent(evt);
/* 1566:     */     }
/* 1567:1472 */     if (FormGenerales.validaLongitud(evt, 2, this.txtCodDoc) == true) {
/* 1568:1473 */       processKeyEvent(evt);
/* 1569:     */     }
/* 1570:     */   }
/* 1571:     */   
/* 1572:     */   private void txtRazonCompradorFocusGained(FocusEvent evt) {}
/* 1573:     */   
/* 1574:     */   private void btnAnadirActionPerformed(ActionEvent evt)
/* 1575:     */   {
/* 1576:1482 */     Component component = (Component)evt.getSource();
/* 1577:1483 */     JFrame frame = (JFrame)SwingUtilities.getRoot(component);
/* 1578:1484 */     this.modalCliente = new DialogoCliente(frame, Boolean.FALSE);
/* 1579:1485 */     this.modalCliente.setSize(841, 573);
/* 1580:1486 */     this.modalCliente.setLocationRelativeTo(null);
/* 1581:1487 */     this.modalCliente.setVisible(true);
/* 1582:     */   }
/* 1583:     */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.ComprobanteRetencionView
 * JD-Core Version:    0.7.0.1
 */