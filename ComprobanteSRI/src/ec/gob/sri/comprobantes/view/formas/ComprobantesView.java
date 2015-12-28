/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Comprobante;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ComprobantesSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.ConstantesDimensiones;
/*   7:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   8:    */ import java.awt.event.ActionEvent;
/*   9:    */ import java.awt.event.ActionListener;
/*  10:    */ import java.math.BigInteger;
/*  11:    */ import java.sql.SQLException;
/*  12:    */ import java.util.ArrayList;
/*  13:    */ import java.util.List;
/*  14:    */ import java.util.logging.Level;
/*  15:    */ import java.util.logging.Logger;
/*  16:    */ import javax.swing.BorderFactory;
/*  17:    */ import javax.swing.GroupLayout;
/*  18:    */ import javax.swing.GroupLayout.Alignment;
/*  19:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  20:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  21:    */ import javax.swing.JButton;
/*  22:    */ import javax.swing.JLabel;
/*  23:    */ import javax.swing.JOptionPane;
/*  24:    */ import javax.swing.JPanel;
/*  25:    */ import javax.swing.JTextField;
/*  26:    */ import javax.swing.border.SoftBevelBorder;
/*  27:    */ import org.jdesktop.application.Application;
/*  28:    */ import org.jdesktop.application.ApplicationContext;
/*  29:    */ import org.jdesktop.application.ResourceMap;
/*  30:    */ 
/*  31:    */ public class ComprobantesView
/*  32:    */   extends JPanel
/*  33:    */ {
/*  34:    */   private JButton btnGuardar;
/*  35:    */   private JLabel jLabel1;
/*  36:    */   private JLabel jLabel2;
/*  37:    */   private JLabel jLabel3;
/*  38:    */   private JLabel jLabel4;
/*  39:    */   private JLabel jLabel5;
/*  40:    */   private JPanel jPanel1;
/*  41:    */   private JTextField txtCR;
/*  42:    */   private JTextField txtFactura;
/*  43:    */   private JTextField txtGR;
/*  44:    */   private JTextField txtNC;
/*  45:    */   private JTextField txtND;
/*  46:    */   
/*  47:    */   public ComprobantesView()
/*  48:    */   {
/*  49: 33 */     initComponents();
/*  50: 34 */     loadComprobantes();
/*  51: 35 */     loadListeners();
/*  52:    */   }
/*  53:    */   
/*  54:    */   private void loadListeners()
/*  55:    */   {
/*  56: 38 */     ListenerUtil util = new ListenerUtil();
/*  57: 39 */     util.listenerSolonumerosLongitud(this.txtCR, ConstantesDimensiones.LONGITUD_SECUENCIAS);
/*  58: 40 */     util.listenerSolonumerosLongitud(this.txtFactura, ConstantesDimensiones.LONGITUD_SECUENCIAS);
/*  59: 41 */     util.listenerSolonumerosLongitud(this.txtNC, ConstantesDimensiones.LONGITUD_SECUENCIAS);
/*  60: 42 */     util.listenerSolonumerosLongitud(this.txtND, ConstantesDimensiones.LONGITUD_SECUENCIAS);
/*  61: 43 */     util.listenerSolonumerosLongitud(this.txtGR, ConstantesDimensiones.LONGITUD_SECUENCIAS);
/*  62:    */   }
/*  63:    */   
/*  64:    */   private void loadComprobantes()
/*  65:    */   {
/*  66:    */     try
/*  67:    */     {
/*  68: 48 */       ComprobantesSQL sql = new ComprobantesSQL();
/*  69: 49 */       List<Comprobante> lista = sql.obtenerComprobantes();
/*  70: 50 */       for (Comprobante comprobante : lista)
/*  71:    */       {
/*  72: 51 */         if (comprobante.getCodigo().equals("01")) {
/*  73: 52 */           this.txtFactura.setText(comprobante.getInicioSecuencia().toString());
/*  74:    */         }
/*  75: 54 */         if (comprobante.getCodigo().equals("04")) {
/*  76: 55 */           this.txtNC.setText(comprobante.getInicioSecuencia().toString());
/*  77:    */         }
/*  78: 57 */         if (comprobante.getCodigo().equals("05")) {
/*  79: 58 */           this.txtND.setText(comprobante.getInicioSecuencia().toString());
/*  80:    */         }
/*  81: 60 */         if (comprobante.getCodigo().equals("06")) {
/*  82: 61 */           this.txtGR.setText(comprobante.getInicioSecuencia().toString());
/*  83:    */         }
/*  84: 63 */         if (comprobante.getCodigo().equals("07")) {
/*  85: 64 */           this.txtCR.setText(comprobante.getInicioSecuencia().toString());
/*  86:    */         }
/*  87:    */       }
/*  88:    */     }
/*  89:    */     catch (SQLException ex) {}catch (ClassNotFoundException ex) {}
/*  90:    */   }
/*  91:    */   
/*  92:    */   private void initComponents()
/*  93:    */   {
/*  94: 83 */     this.jLabel1 = new JLabel();
/*  95: 84 */     this.jLabel2 = new JLabel();
/*  96: 85 */     this.jLabel3 = new JLabel();
/*  97: 86 */     this.jLabel4 = new JLabel();
/*  98: 87 */     this.jLabel5 = new JLabel();
/*  99: 88 */     this.txtFactura = new JTextField();
/* 100: 89 */     this.txtNC = new JTextField();
/* 101: 90 */     this.txtND = new JTextField();
/* 102: 91 */     this.txtGR = new JTextField();
/* 103: 92 */     this.txtCR = new JTextField();
/* 104: 93 */     this.jPanel1 = new JPanel();
/* 105: 94 */     this.btnGuardar = new JButton();
/* 106:    */     
/* 107: 96 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ComprobantesView.class);
/* 108: 97 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/* 109: 98 */     setName("Form");
/* 110:    */     
/* 111:100 */     this.jLabel1.setFont(resourceMap.getFont("jLabel1.font"));
/* 112:101 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 113:102 */     this.jLabel1.setName("jLabel1");
/* 114:    */     
/* 115:104 */     this.jLabel2.setFont(resourceMap.getFont("jLabel1.font"));
/* 116:105 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 117:106 */     this.jLabel2.setName("jLabel2");
/* 118:    */     
/* 119:108 */     this.jLabel3.setFont(resourceMap.getFont("jLabel1.font"));
/* 120:109 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 121:110 */     this.jLabel3.setName("jLabel3");
/* 122:    */     
/* 123:112 */     this.jLabel4.setFont(resourceMap.getFont("jLabel1.font"));
/* 124:113 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 125:114 */     this.jLabel4.setName("jLabel4");
/* 126:    */     
/* 127:116 */     this.jLabel5.setFont(resourceMap.getFont("jLabel1.font"));
/* 128:117 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/* 129:118 */     this.jLabel5.setName("jLabel5");
/* 130:    */     
/* 131:120 */     this.txtFactura.setText(resourceMap.getString("txtFactura.text", new Object[0]));
/* 132:121 */     this.txtFactura.setName("txtFactura");
/* 133:    */     
/* 134:123 */     this.txtNC.setText(resourceMap.getString("txtNC.text", new Object[0]));
/* 135:124 */     this.txtNC.setName("txtNC");
/* 136:    */     
/* 137:126 */     this.txtND.setText(resourceMap.getString("txtND.text", new Object[0]));
/* 138:127 */     this.txtND.setName("txtND");
/* 139:    */     
/* 140:129 */     this.txtGR.setText(resourceMap.getString("txtGR.text", new Object[0]));
/* 141:130 */     this.txtGR.setName("txtGR");
/* 142:    */     
/* 143:132 */     this.txtCR.setText(resourceMap.getString("txtCR.text", new Object[0]));
/* 144:133 */     this.txtCR.setName("txtCR");
/* 145:    */     
/* 146:135 */     this.jPanel1.setBackground(resourceMap.getColor("jPanel1.background"));
/* 147:136 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/* 148:137 */     this.jPanel1.setName("jPanel1");
/* 149:    */     
/* 150:139 */     this.btnGuardar.setText(resourceMap.getString("btnGuardar.text", new Object[0]));
/* 151:140 */     this.btnGuardar.setName("btnGuardar");
/* 152:141 */     this.btnGuardar.addActionListener(new ActionListener()
/* 153:    */     {
/* 154:    */       public void actionPerformed(ActionEvent evt)
/* 155:    */       {
/* 156:143 */         ComprobantesView.this.btnGuardarActionPerformed(evt);
/* 157:    */       }
/* 158:146 */     });
/* 159:147 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 160:148 */     this.jPanel1.setLayout(jPanel1Layout);
/* 161:149 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(274, 32767).addComponent(this.btnGuardar).addGap(59, 59, 59)));
/* 162:    */     
/* 163:    */ 
/* 164:    */ 
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:156 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnGuardar).addContainerGap(-1, 32767)));
/* 169:    */     
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:    */ 
/* 176:164 */     GroupLayout layout = new GroupLayout(this);
/* 177:165 */     setLayout(layout);
/* 178:166 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(51, 51, 51).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5, -2, -1, -2)).addGap(30, 30, 30).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtCR).addComponent(this.txtGR).addComponent(this.txtND).addComponent(this.txtNC).addComponent(this.txtFactura, -2, 167, -2)))).addContainerGap(19, 32767)));
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
/* 198:    */ 
/* 199:    */ 
/* 200:    */ 
/* 201:    */ 
/* 202:190 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtFactura, -2, -1, -2).addComponent(this.jLabel1)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtNC, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtND, -2, -1, -2).addComponent(this.jLabel3)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtGR, -2, -1, -2).addComponent(this.jLabel4)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtCR, -2, -1, -2).addComponent(this.jLabel5, -2, -1, -2)).addGap(34, 34, 34).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(26, 32767)));
/* 203:    */   }
/* 204:    */   
/* 205:    */   private void btnGuardarActionPerformed(ActionEvent evt)
/* 206:    */   {
/* 207:    */     try
/* 208:    */     {
/* 209:221 */       ComprobantesSQL compSQL = new ComprobantesSQL();
/* 210:222 */       compSQL.ActualizarSecuencial(obtenerComprobantes());
/* 211:223 */       JOptionPane.showMessageDialog(this, "Se ha actualizado con éxito las secuencias");
/* 212:    */     }
/* 213:    */     catch (SQLException ex)
/* 214:    */     {
/* 215:225 */       Logger.getLogger(ComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 216:    */     }
/* 217:    */     catch (ClassNotFoundException ex)
/* 218:    */     {
/* 219:227 */       Logger.getLogger(ComprobantesView.class.getName()).log(Level.SEVERE, null, ex);
/* 220:    */     }
/* 221:    */   }
/* 222:    */   
/* 223:    */   private List<Comprobante> obtenerComprobantes()
/* 224:    */   {
/* 225:232 */     List<Comprobante> comprobanteList = new ArrayList();
/* 226:233 */     for (int i = 0; i < 5; i++)
/* 227:    */     {
/* 228:234 */       if (i == 0) {
/* 229:235 */         comprobanteList.add(obtenerComprobante("01", new BigInteger(this.txtFactura.getText())));
/* 230:    */       }
/* 231:237 */       if (i == 1) {
/* 232:238 */         comprobanteList.add(obtenerComprobante("04", new BigInteger(this.txtNC.getText())));
/* 233:    */       }
/* 234:240 */       if (i == 2) {
/* 235:241 */         comprobanteList.add(obtenerComprobante("05", new BigInteger(this.txtND.getText())));
/* 236:    */       }
/* 237:243 */       if (i == 3) {
/* 238:244 */         comprobanteList.add(obtenerComprobante("06", new BigInteger(this.txtGR.getText())));
/* 239:    */       }
/* 240:246 */       if (i == 4) {
/* 241:247 */         comprobanteList.add(obtenerComprobante("07", new BigInteger(this.txtCR.getText())));
/* 242:    */       }
/* 243:    */     }
/* 244:250 */     return comprobanteList;
/* 245:    */   }
/* 246:    */   
/* 247:    */   private Comprobante obtenerComprobante(String codigo, BigInteger secuencial)
/* 248:    */   {
/* 249:253 */     return new Comprobante(codigo, secuencial);
/* 250:    */   }
/* 251:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ComprobantesView
 * JD-Core Version:    0.7.0.1
 */