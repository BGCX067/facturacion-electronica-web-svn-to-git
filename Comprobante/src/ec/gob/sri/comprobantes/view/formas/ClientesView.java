/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   6:    */ import ec.gob.sri.comprobantes.table.model.ClienteTableModel;
/*   7:    */ import ec.gob.sri.comprobantes.table.model.DeleteEditor;
/*   8:    */ import ec.gob.sri.comprobantes.table.model.DeleteRender;
/*   9:    */ import ec.gob.sri.comprobantes.table.model.MyEditor;
/*  10:    */ import ec.gob.sri.comprobantes.table.model.MyRenderer;
/*  11:    */ import ec.gob.sri.comprobantes.util.ConstantesDimensiones;
/*  12:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*  13:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  14:    */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*  15:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
/*  16:    */ import java.awt.Cursor;
/*  17:    */ import java.awt.event.ActionEvent;
/*  18:    */ import java.awt.event.ActionListener;
/*  19:    */ import java.sql.SQLException;
/*  20:    */ import java.util.ArrayList;
/*  21:    */ import java.util.List;
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
/*  37:    */ import javax.swing.border.SoftBevelBorder;
/*  38:    */ import javax.swing.table.DefaultTableModel;
/*  39:    */ import javax.swing.table.TableColumn;
/*  40:    */ import javax.swing.table.TableColumnModel;
/*  41:    */ import org.jdesktop.application.Application;
/*  42:    */ import org.jdesktop.application.ApplicationContext;
/*  43:    */ import org.jdesktop.application.ResourceMap;
/*  44:    */ 
/*  45:    */ public class ClientesView
/*  46:    */   extends JPanel
/*  47:    */ {
/*  48: 31 */   ListenerUtil listenerUtil = new ListenerUtil();
/*  49: 32 */   ArrayList<Object[]> fila = null;
/*  50: 33 */   ListenerUtil lu = new ListenerUtil();
/*  51:    */   private JButton btnBuscarClientes;
/*  52:    */   private JComboBox cbxTipoIdentificacion;
/*  53:    */   private JPanel jPanel1;
/*  54:    */   private JPanel jPanel2;
/*  55:    */   private JScrollPane jScrollPane1;
/*  56:    */   private JLabel lblIdentificacion;
/*  57:    */   private JLabel lblRazonSocial;
/*  58:    */   private JPanel pnlBusqueda;
/*  59:    */   private JPanel pnlListaClientes;
/*  60:    */   private JScrollPane scrlClientes;
/*  61:    */   private JTable tblClientes;
/*  62:    */   private JTextField txtIdentificacion;
/*  63:    */   private JTextField txtRazonSocial;
/*  64:    */   
/*  65:    */   public ClientesView()
/*  66:    */   {
/*  67: 36 */     initComponents();
/*  68: 37 */     inicializarDatos();
/*  69: 38 */     this.pnlListaClientes.setVisible(false);
/*  70:    */   }
/*  71:    */   
/*  72:    */   private void inicializarDatos()
/*  73:    */   {
/*  74: 42 */     this.tblClientes.setVisible(false);
/*  75: 43 */     this.listenerUtil.listenerLongitudBackSpace(this.txtRazonSocial, Integer.valueOf(100));
/*  76: 44 */     this.listenerUtil.listenerLongitud(this.txtIdentificacion, Integer.valueOf(13));
/*  77: 45 */     StringUtil.convertirMayusculas(this.txtRazonSocial);
/*  78: 46 */     loadComboBusqueda();
/*  79:    */   }
/*  80:    */   
/*  81:    */   private void loadComboBusqueda()
/*  82:    */   {
/*  83: 50 */     List<String> modelo = new ArrayList();
/*  84: 51 */     modelo.add("TODOS");
/*  85: 52 */     for (TipoIdentificacionEnum ti : TipoIdentificacionEnum.values()) {
/*  86: 53 */       modelo.add(ti.getDescripcion());
/*  87:    */     }
/*  88: 55 */     this.cbxTipoIdentificacion.setModel(new DefaultComboBoxModel(modelo.toArray()));
/*  89:    */   }
/*  90:    */   
/*  91:    */   private void valoresLista(List<Clientes> cl)
/*  92:    */   {
/*  93: 59 */     this.fila = new ArrayList();
/*  94: 60 */     for (Clientes clientes : cl)
/*  95:    */     {
/*  96: 61 */       Object[] data1 = new Object[6];
/*  97: 62 */       data1[0] = clientes.getApellido();
/*  98: 63 */       String tipoIdentificacion = StringUtil.getSlectedItem(clientes.getTipoIdentificacion());
/*  99: 64 */       data1[1] = tipoIdentificacion;
/* 100: 65 */       data1[2] = clientes.getNumeroIdentificacio();
/* 101: 66 */       data1[3] = TipoClienteEnum.valueOf(clientes.getTipoCliente()).toString();
/* 102: 67 */       data1[4] = "";
/* 103: 68 */       data1[5] = "";
/* 104: 69 */       this.fila.add(data1);
/* 105:    */     }
/* 106: 71 */     cargarModelo();
/* 107:    */   }
/* 108:    */   
/* 109:    */   private void cargarModelo()
/* 110:    */   {
/* 111: 75 */     ClienteTableModel model = new ClienteTableModel(this.fila);
/* 112: 76 */     this.tblClientes.setAutoResizeMode(0);
/* 113: 77 */     this.tblClientes.setModel(model);
/* 114: 78 */     TableColumn tc = this.tblClientes.getColumnModel().getColumn(4);
/* 115: 79 */     tc.setCellEditor(new MyEditor(this.tblClientes));
/* 116: 80 */     tc.setCellRenderer(new MyRenderer(true));
/* 117:    */     
/* 118: 82 */     TableColumn tc1 = this.tblClientes.getColumnModel().getColumn(5);
/* 119: 83 */     tc1.setCellEditor(new DeleteEditor(this.tblClientes));
/* 120: 84 */     tc1.setCellRenderer(new DeleteRender(true));
/* 121: 85 */     setColumnDimwentiosn();
/* 122:    */   }
/* 123:    */   
/* 124:    */   private void setColumnDimwentiosn()
/* 125:    */   {
/* 126: 89 */     for (int i = 0; i < this.tblClientes.getColumnModel().getColumnCount(); i++)
/* 127:    */     {
/* 128: 90 */       TableColumn column = this.tblClientes.getColumnModel().getColumn(i);
/* 129: 91 */       if (i == 0) {
/* 130: 92 */         column.setPreferredWidth(258);
/* 131:    */       }
/* 132: 94 */       if (i == 1) {
/* 133: 95 */         column.setPreferredWidth(210);
/* 134:    */       }
/* 135: 97 */       if (i == 2) {
/* 136: 98 */         column.setPreferredWidth(180);
/* 137:    */       }
/* 138:100 */       if (i == 3) {
/* 139:101 */         column.setPreferredWidth(120);
/* 140:    */       }
/* 141:103 */       if (i == 4) {
/* 142:104 */         column.setPreferredWidth(70);
/* 143:    */       }
/* 144:106 */       if (i == 6) {
/* 145:107 */         column.setPreferredWidth(70);
/* 146:    */       }
/* 147:    */     }
/* 148:    */   }
/* 149:    */   
/* 150:    */   private void initComponents()
/* 151:    */   {
/* 152:121 */     this.jScrollPane1 = new JScrollPane();
/* 153:122 */     this.jPanel2 = new JPanel();
/* 154:123 */     this.pnlBusqueda = new JPanel();
/* 155:124 */     this.lblIdentificacion = new JLabel();
/* 156:125 */     this.cbxTipoIdentificacion = new JComboBox();
/* 157:126 */     this.txtIdentificacion = new JTextField();
/* 158:127 */     this.lblRazonSocial = new JLabel();
/* 159:128 */     this.txtRazonSocial = new JTextField();
/* 160:129 */     this.jPanel1 = new JPanel();
/* 161:130 */     this.btnBuscarClientes = new JButton();
/* 162:131 */     this.pnlListaClientes = new JPanel();
/* 163:132 */     this.scrlClientes = new JScrollPane();
/* 164:133 */     this.tblClientes = new JTable();
/* 165:    */     
/* 166:135 */     this.jScrollPane1.setName("jScrollPane1");
/* 167:    */     
/* 168:137 */     setName("Form");
/* 169:    */     
/* 170:139 */     this.jPanel2.setName("jPanel2");
/* 171:    */     
/* 172:141 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ClientesView.class);
/* 173:142 */     this.pnlBusqueda.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("pnlBusqueda.border.title", new Object[0])));
/* 174:143 */     this.pnlBusqueda.setName("pnlBusqueda");
/* 175:    */     
/* 176:145 */     this.lblIdentificacion.setText(resourceMap.getString("lblIdentificacion.text", new Object[0]));
/* 177:146 */     this.lblIdentificacion.setName("lblIdentificacion");
/* 178:    */     
/* 179:148 */     this.cbxTipoIdentificacion.setName("cbxTipoIdentificacion");
/* 180:149 */     this.cbxTipoIdentificacion.addActionListener(new ActionListener()
/* 181:    */     {
/* 182:    */       public void actionPerformed(ActionEvent evt)
/* 183:    */       {
/* 184:151 */         ClientesView.this.cbxTipoIdentificacionActionPerformed(evt);
/* 185:    */       }
/* 186:154 */     });
/* 187:155 */     this.txtIdentificacion.setText(resourceMap.getString("txtIdentificacion.text", new Object[0]));
/* 188:156 */     this.txtIdentificacion.setFocusCycleRoot(true);
/* 189:157 */     this.txtIdentificacion.setName("txtIdentificacion");
/* 190:    */     
/* 191:159 */     this.lblRazonSocial.setText(resourceMap.getString("lblRazonSocial.text", new Object[0]));
/* 192:160 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 193:    */     
/* 194:162 */     this.txtRazonSocial.setText(resourceMap.getString("txtRazonSocial.text", new Object[0]));
/* 195:163 */     this.txtRazonSocial.setName("txtRazonSocial");
/* 196:    */     
/* 197:165 */     this.jPanel1.setBackground(resourceMap.getColor("jPanel1.background"));
/* 198:166 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/* 199:167 */     this.jPanel1.setForeground(resourceMap.getColor("jPanel1.foreground"));
/* 200:168 */     this.jPanel1.setName("jPanel1");
/* 201:    */     
/* 202:170 */     this.btnBuscarClientes.setText(resourceMap.getString("btnBuscarClientes.text", new Object[0]));
/* 203:171 */     this.btnBuscarClientes.setName("btnBuscarClientes");
/* 204:172 */     this.btnBuscarClientes.addActionListener(new ActionListener()
/* 205:    */     {
/* 206:    */       public void actionPerformed(ActionEvent evt)
/* 207:    */       {
/* 208:174 */         ClientesView.this.btnBuscarClientesActionPerformed(evt);
/* 209:    */       }
/* 210:177 */     });
/* 211:178 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 212:179 */     this.jPanel1.setLayout(jPanel1Layout);
/* 213:180 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(346, 346, 346).addComponent(this.btnBuscarClientes, -1, 111, 32767).addGap(122, 122, 122)));
/* 214:    */     
/* 215:    */ 
/* 216:    */ 
/* 217:    */ 
/* 218:    */ 
/* 219:    */ 
/* 220:187 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.btnBuscarClientes).addContainerGap()));
/* 221:    */     
/* 222:    */ 
/* 223:    */ 
/* 224:    */ 
/* 225:    */ 
/* 226:    */ 
/* 227:    */ 
/* 228:195 */     GroupLayout pnlBusquedaLayout = new GroupLayout(this.pnlBusqueda);
/* 229:196 */     this.pnlBusqueda.setLayout(pnlBusquedaLayout);
/* 230:197 */     pnlBusquedaLayout.setHorizontalGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addGap(95, 95, 95).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(pnlBusquedaLayout.createSequentialGroup().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addComponent(this.lblIdentificacion, -1, 96, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cbxTipoIdentificacion, -2, 199, -2)).addComponent(this.lblRazonSocial, GroupLayout.Alignment.TRAILING, -1, 299, 32767)).addGap(18, 18, 18).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtIdentificacion, -1, 268, 32767).addComponent(this.txtRazonSocial, -1, 268, 32767)))).addGap(108, 108, 108)));
/* 231:    */     
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:    */ 
/* 237:    */ 
/* 238:    */ 
/* 239:    */ 
/* 240:    */ 
/* 241:    */ 
/* 242:    */ 
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:    */ 
/* 248:    */ 
/* 249:216 */     pnlBusquedaLayout.setVerticalGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblIdentificacion).addComponent(this.cbxTipoIdentificacion, -2, -1, -2).addComponent(this.txtIdentificacion, -2, -1, -2)).addGap(18, 18, 18).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblRazonSocial).addComponent(this.txtRazonSocial, -2, -1, -2)).addGap(31, 31, 31).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(20, 32767)));
/* 250:    */     
/* 251:    */ 
/* 252:    */ 
/* 253:    */ 
/* 254:    */ 
/* 255:    */ 
/* 256:    */ 
/* 257:    */ 
/* 258:    */ 
/* 259:    */ 
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:    */ 
/* 264:    */ 
/* 265:    */ 
/* 266:233 */     this.pnlListaClientes.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("pnlListaClientes.border.title", new Object[0])));
/* 267:234 */     this.pnlListaClientes.setName("pnlListaClientes");
/* 268:    */     
/* 269:236 */     this.scrlClientes.setName("scrlClientes");
/* 270:    */     
/* 271:238 */     this.tblClientes.setBorder(BorderFactory.createEtchedBorder());
/* 272:239 */     this.tblClientes.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 273:    */     
/* 274:    */ 
/* 275:    */ 
/* 276:    */ 
/* 277:    */ 
/* 278:    */ 
/* 279:    */ 
/* 280:247 */     this.tblClientes.setCursor(new Cursor(0));
/* 281:248 */     this.tblClientes.setName("tblClientes");
/* 282:249 */     this.scrlClientes.setViewportView(this.tblClientes);
/* 283:    */     
/* 284:251 */     GroupLayout pnlListaClientesLayout = new GroupLayout(this.pnlListaClientes);
/* 285:252 */     this.pnlListaClientes.setLayout(pnlListaClientesLayout);
/* 286:253 */     pnlListaClientesLayout.setHorizontalGroup(pnlListaClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlListaClientesLayout.createSequentialGroup().addContainerGap().addComponent(this.scrlClientes, -2, 934, -2).addContainerGap(-1, 32767)));
/* 287:    */     
/* 288:    */ 
/* 289:    */ 
/* 290:    */ 
/* 291:    */ 
/* 292:    */ 
/* 293:260 */     pnlListaClientesLayout.setVerticalGroup(pnlListaClientesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlListaClientesLayout.createSequentialGroup().addComponent(this.scrlClientes).addContainerGap()));
/* 294:    */     
/* 295:    */ 
/* 296:    */ 
/* 297:    */ 
/* 298:    */ 
/* 299:    */ 
/* 300:267 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 301:268 */     this.jPanel2.setLayout(jPanel2Layout);
/* 302:269 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.pnlBusqueda, -2, -1, -2).addComponent(this.pnlListaClientes, -2, -1, -2)).addContainerGap(55, 32767)));
/* 303:    */     
/* 304:    */ 
/* 305:    */ 
/* 306:    */ 
/* 307:    */ 
/* 308:    */ 
/* 309:    */ 
/* 310:277 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.pnlBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.pnlListaClientes, -1, -1, 32767).addContainerGap()));
/* 311:    */     
/* 312:    */ 
/* 313:    */ 
/* 314:    */ 
/* 315:    */ 
/* 316:    */ 
/* 317:    */ 
/* 318:    */ 
/* 319:    */ 
/* 320:287 */     GroupLayout layout = new GroupLayout(this);
/* 321:288 */     setLayout(layout);
/* 322:289 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
/* 323:    */     
/* 324:    */ 
/* 325:    */ 
/* 326:    */ 
/* 327:    */ 
/* 328:    */ 
/* 329:296 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
/* 330:    */   }
/* 331:    */   
/* 332:    */   private void btnBuscarClientesActionPerformed(ActionEvent evt)
/* 333:    */   {
/* 334:305 */     buscarClientes();
/* 335:    */   }
/* 336:    */   
/* 337:    */   private void cbxTipoIdentificacionActionPerformed(ActionEvent evt)
/* 338:    */   {
/* 339:309 */     ListenerUtil util = new ListenerUtil();
/* 340:310 */     util.removeListener(this.txtIdentificacion);
/* 341:311 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.C.getDescripcion())) {
/* 342:312 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_CEDULA);
/* 343:    */     }
/* 344:314 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.R.getDescripcion())) {
/* 345:315 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_RUC);
/* 346:    */     }
/* 347:317 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.P.getDescripcion())) {
/* 348:318 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_PASAPORTE);
/* 349:    */     }
/* 350:320 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.I.getDescripcion())) {
/* 351:321 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_IDENTIFICACION_EXTERIOR);
/* 352:    */     }
/* 353:323 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase(TipoIdentificacionEnum.L.getDescripcion())) {
/* 354:324 */       util.listenerLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_PLACA);
/* 355:    */     }
/* 356:    */   }
/* 357:    */   
/* 358:    */   public void buscarClientes()
/* 359:    */   {
/* 360:    */     try
/* 361:    */     {
/* 362:330 */       ClientesSQL clientesDAO = new ClientesSQL();
/* 363:331 */       String tipoIdentificacion = StringUtil.getTipoIdentificacion(this.cbxTipoIdentificacion.getSelectedItem().toString());
/* 364:332 */       List<Clientes> cl = clientesDAO.obtenerClientes(this.txtIdentificacion.getText(), tipoIdentificacion, this.txtRazonSocial.getText());
/* 365:333 */       valoresLista(cl);
/* 366:334 */       this.tblClientes.setVisible(true);
/* 367:335 */       if ((cl == null) || (cl.isEmpty())) {
/* 368:336 */         JOptionPane.showMessageDialog(this, "Búsqueda sin resultados, vuelva a intentar", "Mensaje", 1);
/* 369:    */       }
/* 370:338 */       this.pnlListaClientes.setVisible(true);
/* 371:    */     }
/* 372:    */     catch (SQLException ex)
/* 373:    */     {
/* 374:340 */       JOptionPane.showMessageDialog(this, ex.getMessage(), "Mensaje", 1);
/* 375:    */     }
/* 376:    */     catch (ClassNotFoundException ex)
/* 377:    */     {
/* 378:342 */       JOptionPane.showMessageDialog(this, ex.getMessage(), "Mensaje", 1);
/* 379:    */     }
/* 380:    */   }
/* 381:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ClientesView
 * JD-Core Version:    0.7.0.1
 */