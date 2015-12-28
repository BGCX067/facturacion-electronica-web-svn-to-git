/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   6:    */ import ec.gob.sri.comprobantes.table.model.AsignarRenderer;
/*   7:    */ import ec.gob.sri.comprobantes.table.model.ListaProductosTableModel;
/*   8:    */ import ec.gob.sri.comprobantes.table.model.SeleccionarProductoCellEditor;
/*   9:    */ import ec.gob.sri.comprobantes.util.CodigoBusquedaEnum;
/*  10:    */ import java.awt.event.ActionEvent;
/*  11:    */ import java.awt.event.ActionListener;
/*  12:    */ import java.sql.SQLException;
/*  13:    */ import java.util.ArrayList;
/*  14:    */ import java.util.List;
/*  15:    */ import java.util.logging.Level;
/*  16:    */ import java.util.logging.Logger;
/*  17:    */ import javax.swing.BorderFactory;
/*  18:    */ import javax.swing.DefaultComboBoxModel;
/*  19:    */ import javax.swing.GroupLayout;
/*  20:    */ import javax.swing.GroupLayout.Alignment;
/*  21:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  22:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  23:    */ import javax.swing.JButton;
/*  24:    */ import javax.swing.JComboBox;
/*  25:    */ import javax.swing.JLabel;
/*  26:    */ import javax.swing.JPanel;
/*  27:    */ import javax.swing.JScrollPane;
/*  28:    */ import javax.swing.JTable;
/*  29:    */ import javax.swing.JTextField;
/*  30:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  31:    */ import javax.swing.table.DefaultTableModel;
/*  32:    */ import javax.swing.table.TableColumn;
/*  33:    */ import javax.swing.table.TableColumnModel;
/*  34:    */ import org.jdesktop.application.Application;
/*  35:    */ import org.jdesktop.application.ApplicationContext;
/*  36:    */ import org.jdesktop.application.ResourceMap;
/*  37:    */ 
/*  38:    */ public class ProductosListView
/*  39:    */   extends JPanel
/*  40:    */ {
/*  41:    */   Producto productoSeleccionado;
/*  42: 31 */   Object[][] fila = (Object[][])null;
/*  43:    */   ListaProductosTableModel modelo;
/*  44:    */   private JButton btnBuscarProducto;
/*  45:    */   private JComboBox cbxTipoCodigo;
/*  46:    */   private JLabel jLabel1;
/*  47:    */   private JLabel jLabel2;
/*  48:    */   private JPanel jPanel1;
/*  49:    */   private JPanel jPanel2;
/*  50:    */   private JScrollPane jScrollPane1;
/*  51:    */   private JLabel lblRazonSocial;
/*  52:    */   private JPanel pnlBusqueda;
/*  53:    */   private JTable tblProductos;
/*  54:    */   private JTextField txtCodigoProducto;
/*  55:    */   private JTextField txtDescripcionProducto;
/*  56:    */   
/*  57:    */   public ProductosListView()
/*  58:    */   {
/*  59: 36 */     initComponents();
/*  60: 37 */     inicializarDatos();
/*  61:    */   }
/*  62:    */   
/*  63:    */   private void inicializarDatos()
/*  64:    */   {
/*  65: 41 */     this.modelo = new ListaProductosTableModel(this.fila);
/*  66:    */     
/*  67: 43 */     this.tblProductos.setModel(this.modelo);
/*  68: 44 */     this.tblProductos.setVisible(false);
/*  69: 45 */     this.tblProductos.setAutoResizeMode(0);
/*  70: 46 */     setColumnWidthProductos();
/*  71:    */     
/*  72: 48 */     ProductoSQL prodSQL = new ProductoSQL();
/*  73: 49 */     List<Producto> listaProductos = new ArrayList();
/*  74:    */     try
/*  75:    */     {
/*  76: 52 */       listaProductos = prodSQL.obtenerProducto(null, null, null);
/*  77:    */     }
/*  78:    */     catch (SQLException ex)
/*  79:    */     {
/*  80: 54 */       Logger.getLogger(ProductosListView.class.getName()).log(Level.SEVERE, null, ex);
/*  81:    */     }
/*  82:    */     catch (ClassNotFoundException ex)
/*  83:    */     {
/*  84: 56 */       Logger.getLogger(ProductosListView.class.getName()).log(Level.SEVERE, null, ex);
/*  85:    */     }
/*  86: 59 */     valoresLista(listaProductos);
/*  87: 60 */     this.tblProductos.setVisible(true);
/*  88:    */   }
/*  89:    */   
/*  90:    */   private void setColumnWidthProductos()
/*  91:    */   {
/*  92: 65 */     for (int i = 0; i < this.tblProductos.getColumnModel().getColumnCount(); i++)
/*  93:    */     {
/*  94: 66 */       TableColumn column = this.tblProductos.getColumnModel().getColumn(i);
/*  95: 67 */       if (i == 0) {
/*  96: 68 */         column.setPreferredWidth(95);
/*  97:    */       }
/*  98: 70 */       if (i == 1) {
/*  99: 71 */         column.setPreferredWidth(95);
/* 100:    */       }
/* 101: 73 */       if (i == 2) {
/* 102: 74 */         column.setPreferredWidth(220);
/* 103:    */       }
/* 104: 76 */       if (i == 3) {
/* 105: 77 */         column.setPreferredWidth(90);
/* 106:    */       }
/* 107: 79 */       if (i == 4) {
/* 108: 80 */         column.setPreferredWidth(80);
/* 109:    */       }
/* 110:    */     }
/* 111:    */   }
/* 112:    */   
/* 113:    */   private void initComponents()
/* 114:    */   {
/* 115: 95 */     this.jLabel1 = new JLabel();
/* 116: 96 */     this.pnlBusqueda = new JPanel();
/* 117: 97 */     this.jLabel2 = new JLabel();
/* 118: 98 */     this.cbxTipoCodigo = new JComboBox();
/* 119: 99 */     this.txtCodigoProducto = new JTextField();
/* 120:100 */     this.lblRazonSocial = new JLabel();
/* 121:101 */     this.txtDescripcionProducto = new JTextField();
/* 122:102 */     this.jPanel2 = new JPanel();
/* 123:103 */     this.btnBuscarProducto = new JButton();
/* 124:104 */     this.jPanel1 = new JPanel();
/* 125:105 */     this.jScrollPane1 = new JScrollPane();
/* 126:106 */     this.tblProductos = new JTable();
/* 127:    */     
/* 128:108 */     setName("Form");
/* 129:    */     
/* 130:110 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ProductosListView.class);
/* 131:111 */     this.jLabel1.setFont(resourceMap.getFont("jLabel1.font"));
/* 132:112 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 133:113 */     this.jLabel1.setName("jLabel1");
/* 134:    */     
/* 135:115 */     this.pnlBusqueda.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("pnlBusqueda.border.title", new Object[0])));
/* 136:116 */     this.pnlBusqueda.setName("pnlBusqueda");
/* 137:    */     
/* 138:118 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 139:119 */     this.jLabel2.setName("jLabel2");
/* 140:    */     
/* 141:121 */     this.cbxTipoCodigo.setModel(new DefaultComboBoxModel(CodigoBusquedaEnum.values()));
/* 142:122 */     this.cbxTipoCodigo.setName("cbxTipoCodigo");
/* 143:    */     
/* 144:124 */     this.txtCodigoProducto.setText(resourceMap.getString("txtCodigoProducto.text", new Object[0]));
/* 145:125 */     this.txtCodigoProducto.setName("txtCodigoProducto");
/* 146:    */     
/* 147:127 */     this.lblRazonSocial.setText(resourceMap.getString("lblRazonSocial.text", new Object[0]));
/* 148:128 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 149:    */     
/* 150:130 */     this.txtDescripcionProducto.setText(resourceMap.getString("txtDescripcionProducto.text", new Object[0]));
/* 151:131 */     this.txtDescripcionProducto.setName("txtDescripcionProducto");
/* 152:    */     
/* 153:133 */     this.jPanel2.setBackground(resourceMap.getColor("jPanel2.background"));
/* 154:134 */     this.jPanel2.setName("jPanel2");
/* 155:    */     
/* 156:136 */     this.btnBuscarProducto.setText(resourceMap.getString("btnBuscarProducto.text", new Object[0]));
/* 157:137 */     this.btnBuscarProducto.setName("btnBuscarProducto");
/* 158:138 */     this.btnBuscarProducto.addActionListener(new ActionListener()
/* 159:    */     {
/* 160:    */       public void actionPerformed(ActionEvent evt)
/* 161:    */       {
/* 162:140 */         ProductosListView.this.btnBuscarProductoActionPerformed(evt);
/* 163:    */       }
/* 164:143 */     });
/* 165:144 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 166:145 */     this.jPanel2.setLayout(jPanel2Layout);
/* 167:146 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(460, 460, 460).addComponent(this.btnBuscarProducto, -1, 81, 32767).addContainerGap()));
/* 168:    */     
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:153 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.btnBuscarProducto).addContainerGap(16, 32767)));
/* 175:    */     
/* 176:    */ 
/* 177:    */ 
/* 178:    */ 
/* 179:    */ 
/* 180:    */ 
/* 181:    */ 
/* 182:161 */     GroupLayout pnlBusquedaLayout = new GroupLayout(this.pnlBusqueda);
/* 183:162 */     this.pnlBusqueda.setLayout(pnlBusquedaLayout);
/* 184:163 */     pnlBusquedaLayout.setHorizontalGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addGap(54, 54, 54).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(pnlBusquedaLayout.createSequentialGroup().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addComponent(this.jLabel2, -2, 114, 32767).addGap(21, 21, 21)).addComponent(this.lblRazonSocial, -2, 135, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtDescripcionProducto, GroupLayout.Alignment.TRAILING, -1, 406, 32767).addGroup(pnlBusquedaLayout.createSequentialGroup().addComponent(this.cbxTipoCodigo, 0, 118, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtCodigoProducto, -1, 276, 32767))))).addGap(48, 48, 48)));
/* 185:    */     
/* 186:    */ 
/* 187:    */ 
/* 188:    */ 
/* 189:    */ 
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:    */ 
/* 194:    */ 
/* 195:    */ 
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:    */ 
/* 200:    */ 
/* 201:    */ 
/* 202:    */ 
/* 203:    */ 
/* 204:    */ 
/* 205:184 */     pnlBusquedaLayout.setVerticalGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.cbxTipoCodigo, -2, -1, -2).addComponent(this.txtCodigoProducto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblRazonSocial).addComponent(this.txtDescripcionProducto, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(31, 32767)));
/* 206:    */     
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:    */ 
/* 211:    */ 
/* 212:    */ 
/* 213:    */ 
/* 214:    */ 
/* 215:    */ 
/* 216:    */ 
/* 217:    */ 
/* 218:    */ 
/* 219:    */ 
/* 220:    */ 
/* 221:    */ 
/* 222:201 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 223:202 */     this.jPanel1.setName("jPanel1");
/* 224:    */     
/* 225:204 */     this.jScrollPane1.setName("jScrollPane1");
/* 226:    */     
/* 227:206 */     this.tblProductos.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 228:    */     
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:214 */     this.tblProductos.setName("tblProductos");
/* 236:215 */     this.jScrollPane1.setViewportView(this.tblProductos);
/* 237:    */     
/* 238:217 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 239:218 */     this.jPanel1.setLayout(jPanel1Layout);
/* 240:219 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 631, 32767).addContainerGap()));
/* 241:    */     
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:226 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 133, 32767).addContainerGap()));
/* 248:    */     
/* 249:    */ 
/* 250:    */ 
/* 251:    */ 
/* 252:    */ 
/* 253:    */ 
/* 254:    */ 
/* 255:234 */     GroupLayout layout = new GroupLayout(this);
/* 256:235 */     setLayout(layout);
/* 257:236 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.pnlBusqueda, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -2, 287, -2)).addContainerGap()));
/* 258:    */     
/* 259:    */ 
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:    */ 
/* 264:    */ 
/* 265:    */ 
/* 266:    */ 
/* 267:246 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.pnlBusqueda, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
/* 268:    */   }
/* 269:    */   
/* 270:    */   private void valoresLista(List<Producto> productos)
/* 271:    */   {
/* 272:261 */     this.fila = new Object[productos.size()][1];
/* 273:262 */     int i = 0;
/* 274:263 */     for (Producto p : productos)
/* 275:    */     {
/* 276:264 */       Object[] data1 = new Object[5];
/* 277:265 */       data1[0] = p.getCodigoPrincipal();
/* 278:266 */       data1[1] = p.getCodigoAuxiliar();
/* 279:267 */       data1[2] = p.getNombre();
/* 280:268 */       data1[3] = p.getValorUnitario();
/* 281:269 */       data1[4] = "";
/* 282:270 */       this.fila[i] = data1;
/* 283:271 */       i++;
/* 284:    */     }
/* 285:273 */     this.modelo = new ListaProductosTableModel(this.fila);
/* 286:274 */     this.tblProductos.setModel(this.modelo);
/* 287:275 */     this.tblProductos.setAutoResizeMode(0);
/* 288:276 */     setColumnWidthProductos();
/* 289:    */     
/* 290:278 */     TableColumn tc = this.tblProductos.getColumnModel().getColumn(4);
/* 291:279 */     SeleccionarProductoCellEditor editor = new SeleccionarProductoCellEditor(this.tblProductos);
/* 292:280 */     tc.setCellEditor(editor);
/* 293:281 */     tc.setCellRenderer(new AsignarRenderer(true));
/* 294:    */   }
/* 295:    */   
/* 296:    */   private void btnBuscarProductoActionPerformed(ActionEvent evt)
/* 297:    */   {
/* 298:    */     try
/* 299:    */     {
/* 300:289 */       ProductoSQL prodSQL = new ProductoSQL();
/* 301:290 */       List<Producto> listaProductos = new ArrayList();
/* 302:    */       
/* 303:    */ 
/* 304:293 */       listaProductos = prodSQL.obtenerProducto(this.cbxTipoCodigo.getSelectedItem().toString().equals(CodigoBusquedaEnum.CODIGO.getCode()) ? this.txtCodigoProducto.getText() : null, this.cbxTipoCodigo.getSelectedItem().toString().equals(CodigoBusquedaEnum.AUXILIAR.getCode()) ? this.txtCodigoProducto.getText() : null, this.txtDescripcionProducto.getText());
/* 305:    */       
/* 306:    */ 
/* 307:    */ 
/* 308:297 */       valoresLista(listaProductos);
/* 309:298 */       this.tblProductos.setVisible(true);
/* 310:    */     }
/* 311:    */     catch (Exception ex)
/* 312:    */     {
/* 313:301 */       Logger.getLogger(ProductosListView.class.getName()).log(Level.SEVERE, null, ex);
/* 314:    */     }
/* 315:    */   }
/* 316:    */   
/* 317:    */   public Producto getProductoSeleccionado()
/* 318:    */   {
/* 319:320 */     return this.productoSeleccionado;
/* 320:    */   }
/* 321:    */   
/* 322:    */   public void setProductoSeleccionado(Producto productoSeleccionado)
/* 323:    */   {
/* 324:324 */     this.productoSeleccionado = productoSeleccionado;
/* 325:    */   }
/* 326:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ProductosListView
 * JD-Core Version:    0.7.0.1
 */