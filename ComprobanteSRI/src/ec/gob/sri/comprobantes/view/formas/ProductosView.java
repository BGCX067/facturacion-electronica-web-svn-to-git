/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Impuesto;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   6:    */ import ec.gob.sri.comprobantes.sql.ImpuestoSQL;
/*   7:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   8:    */ import ec.gob.sri.comprobantes.table.model.DeleteProductoEditor;
/*   9:    */ import ec.gob.sri.comprobantes.table.model.DeleteRender;
/*  10:    */ import ec.gob.sri.comprobantes.table.model.EditorProducto;
/*  11:    */ import ec.gob.sri.comprobantes.table.model.MyRenderer;
/*  12:    */ import ec.gob.sri.comprobantes.table.model.ProductosTableModel;
/*  13:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  14:    */ import ec.gob.sri.comprobantes.util.TipoProductoEnum;
/*  15:    */ import java.awt.event.ActionEvent;
/*  16:    */ import java.awt.event.ActionListener;
/*  17:    */ import java.sql.SQLException;
/*  18:    */ import java.util.ArrayList;
/*  19:    */ import java.util.List;
/*  20:    */ import java.util.logging.Level;
/*  21:    */ import java.util.logging.Logger;
/*  22:    */ import javax.swing.BorderFactory;
/*  23:    */ import javax.swing.DefaultComboBoxModel;
/*  24:    */ import javax.swing.GroupLayout;
/*  25:    */ import javax.swing.GroupLayout.Alignment;
/*  26:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  27:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  28:    */ import javax.swing.JButton;
/*  29:    */ import javax.swing.JComboBox;
/*  30:    */ import javax.swing.JLabel;
/*  31:    */ import javax.swing.JOptionPane;
/*  32:    */ import javax.swing.JPanel;
/*  33:    */ import javax.swing.JScrollPane;
/*  34:    */ import javax.swing.JTable;
/*  35:    */ import javax.swing.JTextField;
/*  36:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  37:    */ import javax.swing.table.DefaultTableModel;
/*  38:    */ import javax.swing.table.TableColumn;
/*  39:    */ import javax.swing.table.TableColumnModel;
/*  40:    */ import org.jdesktop.application.Application;
/*  41:    */ import org.jdesktop.application.ApplicationContext;
/*  42:    */ import org.jdesktop.application.ResourceMap;
/*  43:    */ 
/*  44:    */ public class ProductosView
/*  45:    */   extends JPanel
/*  46:    */ {
/*  47:    */   ArrayList<Object[]> fila;
/*  48:    */   private JComboBox cbxImpuesto;
/*  49:    */   private JComboBox cbxTipoProducto;
/*  50:    */   private JButton jButton1;
/*  51:    */   private JLabel jLabel2;
/*  52:    */   private JLabel jLabel3;
/*  53:    */   private JLabel jLabel4;
/*  54:    */   private JLabel jLabel5;
/*  55:    */   private JLabel jLabel6;
/*  56:    */   private JPanel jPanel1;
/*  57:    */   private JPanel jPanel2;
/*  58:    */   private JPanel jPanel3;
/*  59:    */   private JScrollPane jScrollPane1;
/*  60:    */   private JTable tblProductos;
/*  61:    */   private JTextField txtCodAuxiliar;
/*  62:    */   private JTextField txtNomProducto;
/*  63:    */   private JTextField txtcodPrincipal;
/*  64:    */   
/*  65:    */   public ProductosView()
/*  66:    */   {
/*  67: 39 */     initComponents();
/*  68: 40 */     cargarModeloImpuestos();
/*  69: 41 */     this.cbxTipoProducto.setModel(new DefaultComboBoxModel(TipoProductoEnum.values()));
/*  70: 42 */     inicializarDatos();
/*  71: 43 */     this.tblProductos.setVisible(false);
/*  72:    */   }
/*  73:    */   
/*  74:    */   private void inicializarDatos()
/*  75:    */   {
/*  76: 47 */     this.tblProductos.setVisible(false);
/*  77:    */   }
/*  78:    */   
/*  79:    */   private void cargarModeloImpuestos()
/*  80:    */   {
/*  81:    */     try
/*  82:    */     {
/*  83: 52 */       ImpuestoSQL impSQL = new ImpuestoSQL();
/*  84: 53 */       List<Impuesto> impuestoList = impSQL.obtenerDatosEmisor();
/*  85: 54 */       if ((impuestoList != null) && (!impuestoList.isEmpty()))
/*  86:    */       {
/*  87: 55 */         DefaultComboBoxModel model = new DefaultComboBoxModel(impuestoList.toArray());
/*  88: 56 */         this.cbxImpuesto.setModel(model);
/*  89:    */       }
/*  90:    */     }
/*  91:    */     catch (SQLException ex)
/*  92:    */     {
/*  93: 59 */       Logger.getLogger(ProductosView.class.getName()).log(Level.SEVERE, null, ex);
/*  94:    */     }
/*  95:    */     catch (ClassNotFoundException ex)
/*  96:    */     {
/*  97: 61 */       Logger.getLogger(ProductosView.class.getName()).log(Level.SEVERE, null, ex);
/*  98:    */     }
/*  99:    */   }
/* 100:    */   
/* 101:    */   private void initComponents()
/* 102:    */   {
/* 103: 74 */     this.jPanel1 = new JPanel();
/* 104: 75 */     this.jLabel2 = new JLabel();
/* 105: 76 */     this.jLabel3 = new JLabel();
/* 106: 77 */     this.jLabel4 = new JLabel();
/* 107: 78 */     this.txtcodPrincipal = new JTextField();
/* 108: 79 */     this.txtCodAuxiliar = new JTextField();
/* 109: 80 */     this.txtNomProducto = new JTextField();
/* 110: 81 */     this.jLabel5 = new JLabel();
/* 111: 82 */     this.jLabel6 = new JLabel();
/* 112: 83 */     this.cbxTipoProducto = new JComboBox();
/* 113: 84 */     this.jPanel3 = new JPanel();
/* 114: 85 */     this.jButton1 = new JButton();
/* 115: 86 */     this.cbxImpuesto = new JComboBox();
/* 116: 87 */     this.jPanel2 = new JPanel();
/* 117: 88 */     this.jScrollPane1 = new JScrollPane();
/* 118: 89 */     this.tblProductos = new JTable();
/* 119:    */     
/* 120: 91 */     setName("Form");
/* 121:    */     
/* 122: 93 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ProductosView.class);
/* 123: 94 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 124: 95 */     this.jPanel1.setName("jPanel1");
/* 125:    */     
/* 126: 97 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 127: 98 */     this.jLabel2.setName("jLabel2");
/* 128:    */     
/* 129:100 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 130:101 */     this.jLabel3.setName("jLabel3");
/* 131:    */     
/* 132:103 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 133:104 */     this.jLabel4.setName("jLabel4");
/* 134:    */     
/* 135:106 */     this.txtcodPrincipal.setText(resourceMap.getString("txtcodPrincipal.text", new Object[0]));
/* 136:107 */     this.txtcodPrincipal.setName("txtcodPrincipal");
/* 137:    */     
/* 138:109 */     this.txtCodAuxiliar.setText(resourceMap.getString("txtCodAuxiliar.text", new Object[0]));
/* 139:110 */     this.txtCodAuxiliar.setName("txtCodAuxiliar");
/* 140:    */     
/* 141:112 */     this.txtNomProducto.setText(resourceMap.getString("txtNomProducto.text", new Object[0]));
/* 142:113 */     this.txtNomProducto.setName("txtNomProducto");
/* 143:    */     
/* 144:115 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 145:116 */     this.jLabel5.setName("jLabel5");
/* 146:    */     
/* 147:118 */     this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
/* 148:119 */     this.jLabel6.setName("jLabel6");
/* 149:    */     
/* 150:121 */     this.cbxTipoProducto.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 151:122 */     this.cbxTipoProducto.setName("cbxTipoProducto");
/* 152:    */     
/* 153:124 */     this.jPanel3.setBackground(resourceMap.getColor("jPanel3.background"));
/* 154:125 */     this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
/* 155:126 */     this.jPanel3.setName("jPanel3");
/* 156:    */     
/* 157:128 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/* 158:129 */     this.jButton1.setName("jButton1");
/* 159:130 */     this.jButton1.addActionListener(new ActionListener()
/* 160:    */     {
/* 161:    */       public void actionPerformed(ActionEvent evt)
/* 162:    */       {
/* 163:132 */         ProductosView.this.jButton1ActionPerformed(evt);
/* 164:    */       }
/* 165:135 */     });
/* 166:136 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 167:137 */     this.jPanel3.setLayout(jPanel3Layout);
/* 168:138 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(392, 32767).addComponent(this.jButton1)));
/* 169:    */     
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:144 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1).addContainerGap(13, 32767)));
/* 175:    */     
/* 176:    */ 
/* 177:    */ 
/* 178:    */ 
/* 179:    */ 
/* 180:    */ 
/* 181:    */ 
/* 182:152 */     this.cbxImpuesto.setName("cbxImpuesto");
/* 183:    */     
/* 184:154 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 185:155 */     this.jPanel1.setLayout(jPanel1Layout);
/* 186:156 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6)).addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.cbxTipoProducto, 0, -1, 32767).addComponent(this.cbxImpuesto, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addComponent(this.txtNomProducto).addComponent(this.txtCodAuxiliar).addComponent(this.txtcodPrincipal, -1, 313, 32767)))).addContainerGap()));
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
/* 205:    */ 
/* 206:    */ 
/* 207:    */ 
/* 208:178 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtcodPrincipal, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.txtCodAuxiliar, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.txtNomProducto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbxImpuesto, -2, -1, -2).addComponent(this.jLabel5)).addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cbxTipoProducto, -2, -1, -2).addComponent(this.jLabel6)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addContainerGap(-1, 32767)));
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
/* 236:206 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title", new Object[0])));
/* 237:207 */     this.jPanel2.setName("jPanel2");
/* 238:    */     
/* 239:209 */     this.jScrollPane1.setName("jScrollPane1");
/* 240:    */     
/* 241:211 */     this.tblProductos.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
/* 242:    */     
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:    */ 
/* 248:    */ 
/* 249:    */ 
/* 250:    */ 
/* 251:    */ 
/* 252:222 */     this.tblProductos.setName("tblProductos");
/* 253:223 */     this.jScrollPane1.setViewportView(this.tblProductos);
/* 254:    */     
/* 255:225 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 256:226 */     this.jPanel2.setLayout(jPanel2Layout);
/* 257:227 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 1009, 32767)));
/* 258:    */     
/* 259:    */ 
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:233 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 334, -2).addContainerGap(-1, 32767)));
/* 264:    */     
/* 265:    */ 
/* 266:    */ 
/* 267:    */ 
/* 268:    */ 
/* 269:    */ 
/* 270:240 */     GroupLayout layout = new GroupLayout(this);
/* 271:241 */     setLayout(layout);
/* 272:242 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(144, 144, 144).addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767))).addContainerGap()));
/* 273:    */     
/* 274:    */ 
/* 275:    */ 
/* 276:    */ 
/* 277:    */ 
/* 278:    */ 
/* 279:    */ 
/* 280:    */ 
/* 281:    */ 
/* 282:    */ 
/* 283:    */ 
/* 284:254 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(132, 32767)));
/* 285:    */   }
/* 286:    */   
/* 287:    */   private void valoresLista(List<Producto> cl)
/* 288:    */   {
/* 289:265 */     this.fila = new ArrayList();
/* 290:266 */     for (Producto producto : cl)
/* 291:    */     {
/* 292:267 */       Object[] data1 = new Object[6];
/* 293:268 */       data1[0] = producto.getCodigoPrincipal();
/* 294:269 */       data1[1] = producto.getCodigoAuxiliar();
/* 295:270 */       data1[2] = producto.getNombre();
/* 296:271 */       data1[3] = StringUtil.getSlectedItemTipoProducto(producto.getTipoProducto());
/* 297:272 */       data1[4] = "";
/* 298:273 */       data1[5] = "";
/* 299:274 */       this.fila.add(data1);
/* 300:    */     }
/* 301:276 */     cargarModelo();
/* 302:277 */     this.tblProductos.setVisible(true);
/* 303:    */   }
/* 304:    */   
/* 305:    */   private void cargarModelo()
/* 306:    */   {
/* 307:281 */     ProductosTableModel modelo = new ProductosTableModel(this.fila);
/* 308:282 */     this.tblProductos.setAutoResizeMode(0);
/* 309:283 */     this.tblProductos.setModel(modelo);
/* 310:284 */     TableColumn tc = this.tblProductos.getColumnModel().getColumn(4);
/* 311:285 */     tc.setCellEditor(new EditorProducto(this.tblProductos));
/* 312:286 */     tc.setCellRenderer(new MyRenderer(true));
/* 313:    */     
/* 314:288 */     TableColumn tc1 = this.tblProductos.getColumnModel().getColumn(5);
/* 315:289 */     tc1.setCellEditor(new DeleteProductoEditor(this.tblProductos));
/* 316:290 */     tc1.setCellRenderer(new DeleteRender(true));
/* 317:291 */     setColumnDimwentiosn();
/* 318:    */   }
/* 319:    */   
/* 320:    */   private void setColumnDimwentiosn()
/* 321:    */   {
/* 322:295 */     for (int i = 0; i < this.tblProductos.getColumnModel().getColumnCount(); i++)
/* 323:    */     {
/* 324:296 */       TableColumn column = this.tblProductos.getColumnModel().getColumn(i);
/* 325:297 */       if (i == 0) {
/* 326:298 */         column.setPreferredWidth(105);
/* 327:    */       }
/* 328:300 */       if (i == 1) {
/* 329:301 */         column.setPreferredWidth(105);
/* 330:    */       }
/* 331:303 */       if (i == 2) {
/* 332:304 */         column.setPreferredWidth(240);
/* 333:    */       }
/* 334:306 */       if (i == 3) {
/* 335:307 */         column.setPreferredWidth(150);
/* 336:    */       }
/* 337:309 */       if (i == 4) {
/* 338:310 */         column.setPreferredWidth(70);
/* 339:    */       }
/* 340:312 */       if (i == 5) {
/* 341:313 */         column.setPreferredWidth(70);
/* 342:    */       }
/* 343:    */     }
/* 344:    */   }
/* 345:    */   
/* 346:    */   public void buscar()
/* 347:    */   {
/* 348:    */     try
/* 349:    */     {
/* 350:319 */       ProductoSQL prdSQL = new ProductoSQL();
/* 351:320 */       List<Producto> lista = prdSQL.buscarPorParametros(this.txtcodPrincipal.getText(), this.txtCodAuxiliar.getText(), this.txtNomProducto.getText(), ((TipoProductoEnum)this.cbxTipoProducto.getSelectedItem()).getCode(), ((Impuesto)this.cbxImpuesto.getSelectedItem()).getCodigo());
/* 352:321 */       valoresLista(lista);
/* 353:322 */       if ((lista == null) || (lista.isEmpty())) {
/* 354:323 */         JOptionPane.showMessageDialog(this, "La búsqueda no produjo resultados", "Advertencia", 1);
/* 355:    */       }
/* 356:325 */       this.tblProductos.setVisible(true);
/* 357:    */     }
/* 358:    */     catch (SQLException ex)
/* 359:    */     {
/* 360:327 */       Logger.getLogger(ProductosView.class.getName()).log(Level.SEVERE, null, ex);
/* 361:    */     }
/* 362:    */     catch (ClassNotFoundException ex)
/* 363:    */     {
/* 364:329 */       Logger.getLogger(ProductosView.class.getName()).log(Level.SEVERE, null, ex);
/* 365:    */     }
/* 366:    */   }
/* 367:    */   
/* 368:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 369:    */   {
/* 370:334 */     buscar();
/* 371:    */   }
/* 372:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ProductosView
 * JD-Core Version:    0.7.0.1
 */