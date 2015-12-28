/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*   5:    */ import ec.gob.sri.comprobantes.sql.TransportistaSQL;
/*   6:    */ import ec.gob.sri.comprobantes.table.model.DeleteRender;
/*   7:    */ import ec.gob.sri.comprobantes.table.model.DeleteTransportista;
/*   8:    */ import ec.gob.sri.comprobantes.table.model.EditorTransportistas;
/*   9:    */ import ec.gob.sri.comprobantes.table.model.MyRenderer;
/*  10:    */ import ec.gob.sri.comprobantes.table.model.TransportistaTableModel;
/*  11:    */ import ec.gob.sri.comprobantes.util.ConstantesDimensiones;
/*  12:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*  13:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*  14:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
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
/*  37:    */ import javax.swing.border.SoftBevelBorder;
/*  38:    */ import javax.swing.table.DefaultTableModel;
/*  39:    */ import javax.swing.table.TableColumn;
/*  40:    */ import javax.swing.table.TableColumnModel;
/*  41:    */ import org.jdesktop.application.Application;
/*  42:    */ import org.jdesktop.application.ApplicationContext;
/*  43:    */ import org.jdesktop.application.ResourceMap;
/*  44:    */ 
/*  45:    */ public class TransportistasView
/*  46:    */   extends JPanel
/*  47:    */ {
/*  48: 26 */   ArrayList<Object[]> fila = null;
/*  49:    */   private JButton btnBuscarTransportista;
/*  50:    */   private JComboBox cbxTipoIdentificacion;
/*  51:    */   private JLabel jLabel1;
/*  52:    */   private JLabel jLabel2;
/*  53:    */   private JPanel jPanel1;
/*  54:    */   private JPanel jPanel2;
/*  55:    */   private JScrollPane jScrollPane1;
/*  56:    */   private JLabel lblRazonSocial;
/*  57:    */   private JPanel pnlBusqueda;
/*  58:    */   private JTable tblTransportistas;
/*  59:    */   private JTextField txtIdentificacion;
/*  60:    */   private JTextField txtRazonSocial;
/*  61:    */   
/*  62:    */   public TransportistasView()
/*  63:    */   {
/*  64: 30 */     initComponents();
/*  65: 31 */     inicializarDatos();
/*  66:    */   }
/*  67:    */   
/*  68:    */   private void inicializarDatos()
/*  69:    */   {
/*  70: 35 */     List<String> tiposIdentificacion = new ArrayList();
/*  71: 36 */     tiposIdentificacion.add("TODOS");
/*  72: 37 */     for (TipoIdentificacionEnum ti : TipoIdentificacionEnum.obtenerTipoIdentificacionTransportista()) {
/*  73: 38 */       tiposIdentificacion.add(ti.getDescripcion());
/*  74:    */     }
/*  75: 40 */     this.cbxTipoIdentificacion.setModel(new DefaultComboBoxModel(tiposIdentificacion.toArray()));
/*  76: 41 */     this.jPanel1.setVisible(false);
/*  77: 42 */     StringUtil.convertirMayusculas(this.txtRazonSocial);
/*  78:    */   }
/*  79:    */   
/*  80:    */   private void initComponents()
/*  81:    */   {
/*  82: 54 */     this.jLabel1 = new JLabel();
/*  83: 55 */     this.pnlBusqueda = new JPanel();
/*  84: 56 */     this.jLabel2 = new JLabel();
/*  85: 57 */     this.cbxTipoIdentificacion = new JComboBox();
/*  86: 58 */     this.txtIdentificacion = new JTextField();
/*  87: 59 */     this.lblRazonSocial = new JLabel();
/*  88: 60 */     this.txtRazonSocial = new JTextField();
/*  89: 61 */     this.jPanel2 = new JPanel();
/*  90: 62 */     this.btnBuscarTransportista = new JButton();
/*  91: 63 */     this.jPanel1 = new JPanel();
/*  92: 64 */     this.jScrollPane1 = new JScrollPane();
/*  93: 65 */     this.tblTransportistas = new JTable();
/*  94:    */     
/*  95: 67 */     setName("Form");
/*  96:    */     
/*  97: 69 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(TransportistasView.class);
/*  98: 70 */     this.jLabel1.setFont(resourceMap.getFont("jLabel1.font"));
/*  99: 71 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 100: 72 */     this.jLabel1.setName("jLabel1");
/* 101:    */     
/* 102: 74 */     this.pnlBusqueda.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("pnlBusqueda.border.title", new Object[0])));
/* 103: 75 */     this.pnlBusqueda.setName("pnlBusqueda");
/* 104:    */     
/* 105: 77 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 106: 78 */     this.jLabel2.setName("jLabel2");
/* 107:    */     
/* 108: 80 */     this.cbxTipoIdentificacion.setName("cbxTipoIdentificacion");
/* 109: 81 */     this.cbxTipoIdentificacion.addActionListener(new ActionListener()
/* 110:    */     {
/* 111:    */       public void actionPerformed(ActionEvent evt)
/* 112:    */       {
/* 113: 83 */         TransportistasView.this.cbxTipoIdentificacionActionPerformed(evt);
/* 114:    */       }
/* 115: 86 */     });
/* 116: 87 */     this.txtIdentificacion.setText(resourceMap.getString("txtIdentificacion.text", new Object[0]));
/* 117: 88 */     this.txtIdentificacion.setName("txtIdentificacion");
/* 118:    */     
/* 119: 90 */     this.lblRazonSocial.setText(resourceMap.getString("lblRazonSocial.text", new Object[0]));
/* 120: 91 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 121:    */     
/* 122: 93 */     this.txtRazonSocial.setText(resourceMap.getString("txtRazonSocial.text", new Object[0]));
/* 123: 94 */     this.txtRazonSocial.setName("txtRazonSocial");
/* 124:    */     
/* 125: 96 */     this.jPanel2.setBackground(resourceMap.getColor("jPanel2.background"));
/* 126: 97 */     this.jPanel2.setBorder(new SoftBevelBorder(0));
/* 127: 98 */     this.jPanel2.setName("jPanel2");
/* 128:    */     
/* 129:100 */     this.btnBuscarTransportista.setText(resourceMap.getString("btnBuscarTransportista.text", new Object[0]));
/* 130:101 */     this.btnBuscarTransportista.setName("btnBuscarTransportista");
/* 131:102 */     this.btnBuscarTransportista.addActionListener(new ActionListener()
/* 132:    */     {
/* 133:    */       public void actionPerformed(ActionEvent evt)
/* 134:    */       {
/* 135:104 */         TransportistasView.this.btnBuscarTransportistaActionPerformed(evt);
/* 136:    */       }
/* 137:107 */     });
/* 138:108 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 139:109 */     this.jPanel2.setLayout(jPanel2Layout);
/* 140:110 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(587, 587, 587).addComponent(this.btnBuscarTransportista, -1, -1, 32767).addContainerGap()));
/* 141:    */     
/* 142:    */ 
/* 143:    */ 
/* 144:    */ 
/* 145:    */ 
/* 146:    */ 
/* 147:117 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.btnBuscarTransportista).addContainerGap(16, 32767)));
/* 148:    */     
/* 149:    */ 
/* 150:    */ 
/* 151:    */ 
/* 152:    */ 
/* 153:    */ 
/* 154:    */ 
/* 155:125 */     GroupLayout pnlBusquedaLayout = new GroupLayout(this.pnlBusqueda);
/* 156:126 */     this.pnlBusqueda.setLayout(pnlBusquedaLayout);
/* 157:127 */     pnlBusquedaLayout.setHorizontalGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, pnlBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(pnlBusquedaLayout.createSequentialGroup().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addComponent(this.lblRazonSocial, -1, 369, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(pnlBusquedaLayout.createSequentialGroup().addComponent(this.jLabel2, -1, 136, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cbxTipoIdentificacion, -2, 221, -2).addGap(12, 12, 12))).addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtIdentificacion, GroupLayout.Alignment.TRAILING, -1, 295, 32767).addComponent(this.txtRazonSocial, GroupLayout.Alignment.TRAILING, -1, 295, 32767)))).addContainerGap()));
/* 158:    */     
/* 159:    */ 
/* 160:    */ 
/* 161:    */ 
/* 162:    */ 
/* 163:    */ 
/* 164:    */ 
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:    */ 
/* 176:    */ 
/* 177:    */ 
/* 178:148 */     pnlBusquedaLayout.setVerticalGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pnlBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, pnlBusquedaLayout.createSequentialGroup().addComponent(this.txtIdentificacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtRazonSocial, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, pnlBusquedaLayout.createSequentialGroup().addGroup(pnlBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.cbxTipoIdentificacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblRazonSocial))).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(31, 32767)));
/* 179:    */     
/* 180:    */ 
/* 181:    */ 
/* 182:    */ 
/* 183:    */ 
/* 184:    */ 
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
/* 198:168 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/* 199:169 */     this.jPanel1.setName("jPanel1");
/* 200:    */     
/* 201:171 */     this.jScrollPane1.setName("jScrollPane1");
/* 202:    */     
/* 203:173 */     this.tblTransportistas.setModel(new DefaultTableModel(new Object[0][], new String[0]));
/* 204:    */     
/* 205:    */ 
/* 206:    */ 
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:    */ 
/* 211:181 */     this.tblTransportistas.setName("tblTransportistas");
/* 212:182 */     this.jScrollPane1.setViewportView(this.tblTransportistas);
/* 213:    */     
/* 214:184 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 215:185 */     this.jPanel1.setLayout(jPanel1Layout);
/* 216:186 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 668, 32767).addContainerGap()));
/* 217:    */     
/* 218:    */ 
/* 219:    */ 
/* 220:    */ 
/* 221:    */ 
/* 222:    */ 
/* 223:193 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 155, -2).addContainerGap(-1, 32767)));
/* 224:    */     
/* 225:    */ 
/* 226:    */ 
/* 227:    */ 
/* 228:    */ 
/* 229:    */ 
/* 230:    */ 
/* 231:201 */     GroupLayout layout = new GroupLayout(this);
/* 232:202 */     setLayout(layout);
/* 233:203 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel1, -1, 380, 32767).addGap(344, 344, 344)).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.pnlBusqueda, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap()));
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
/* 246:216 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.pnlBusqueda, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
/* 247:    */   }
/* 248:    */   
/* 249:    */   private void valoresLista(List<Transportista> cl)
/* 250:    */   {
/* 251:230 */     this.fila = new ArrayList();
/* 252:231 */     for (Transportista tran : cl)
/* 253:    */     {
/* 254:232 */       Object[] data1 = new Object[5];
/* 255:233 */       data1[0] = tran.getRazonSocial();
/* 256:234 */       String tipoIdentificacion = StringUtil.getSlectedItem(tran.getTipoIdentificacion());
/* 257:235 */       data1[1] = tipoIdentificacion;
/* 258:236 */       data1[2] = tran.getIdentificacion();
/* 259:237 */       data1[3] = "";
/* 260:238 */       data1[4] = "";
/* 261:239 */       this.fila.add(data1);
/* 262:    */     }
/* 263:241 */     cargarModelo();
/* 264:    */   }
/* 265:    */   
/* 266:    */   private void cargarModelo()
/* 267:    */   {
/* 268:245 */     TransportistaTableModel modelo = new TransportistaTableModel(this.fila);
/* 269:246 */     this.tblTransportistas.setAutoResizeMode(4);
/* 270:247 */     this.tblTransportistas.setModel(modelo);
/* 271:248 */     TableColumn tc = this.tblTransportistas.getColumnModel().getColumn(3);
/* 272:249 */     tc.setCellEditor(new EditorTransportistas(this.tblTransportistas));
/* 273:250 */     tc.setCellRenderer(new MyRenderer(true));
/* 274:    */     
/* 275:252 */     TableColumn tc1 = this.tblTransportistas.getColumnModel().getColumn(4);
/* 276:253 */     tc1.setCellEditor(new DeleteTransportista(this.tblTransportistas));
/* 277:254 */     tc1.setCellRenderer(new DeleteRender(true));
/* 278:    */   }
/* 279:    */   
/* 280:    */   private void btnBuscarTransportistaActionPerformed(ActionEvent evt)
/* 281:    */   {
/* 282:    */     try
/* 283:    */     {
/* 284:264 */       TransportistaSQL tranSQL = new TransportistaSQL();
/* 285:265 */       List<Transportista> trans = tranSQL.obtenerTransportista(StringUtil.getTipoIdentificacion(this.cbxTipoIdentificacion.getSelectedItem().toString()), this.txtIdentificacion.getText(), this.txtRazonSocial.getText());
/* 286:266 */       if ((trans == null) || (trans.isEmpty()))
/* 287:    */       {
/* 288:267 */         JOptionPane.showMessageDialog(this, "Búsqueda sin resultados, vuelva a intentar", "Mensaje", 1);
/* 289:268 */         this.jPanel1.setVisible(false);
/* 290:    */       }
/* 291:    */       else
/* 292:    */       {
/* 293:270 */         valoresLista(trans);
/* 294:271 */         this.tblTransportistas.setVisible(true);
/* 295:272 */         this.jPanel1.setVisible(true);
/* 296:    */       }
/* 297:    */     }
/* 298:    */     catch (SQLException ex)
/* 299:    */     {
/* 300:275 */       Logger.getLogger(TransportistasView.class.getName()).log(Level.SEVERE, null, ex);
/* 301:    */     }
/* 302:    */     catch (ClassNotFoundException ex)
/* 303:    */     {
/* 304:277 */       Logger.getLogger(TransportistasView.class.getName()).log(Level.SEVERE, null, ex);
/* 305:    */     }
/* 306:    */   }
/* 307:    */   
/* 308:    */   private void cbxTipoIdentificacionActionPerformed(ActionEvent evt)
/* 309:    */   {
/* 310:282 */     ListenerUtil util = new ListenerUtil();
/* 311:283 */     util.removeListener(this.txtIdentificacion);
/* 312:284 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase("CEDULA")) {
/* 313:285 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_CEDULA);
/* 314:    */     }
/* 315:287 */     if (this.cbxTipoIdentificacion.getSelectedItem().toString().equalsIgnoreCase("RUC")) {
/* 316:288 */       util.listenerSolonumerosLongitud(this.txtIdentificacion, ConstantesDimensiones.LONGITUD_RUC);
/* 317:    */     }
/* 318:    */   }
/* 319:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.TransportistasView
 * JD-Core Version:    0.7.0.1
 */