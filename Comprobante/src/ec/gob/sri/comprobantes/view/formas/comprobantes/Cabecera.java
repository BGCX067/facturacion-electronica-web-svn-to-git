/*   1:    */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import java.awt.Component;
/*   5:    */ import java.awt.Dimension;
/*   6:    */ import javax.swing.BorderFactory;
/*   7:    */ import javax.swing.GroupLayout;
/*   8:    */ import javax.swing.GroupLayout.Alignment;
/*   9:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  10:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  11:    */ import javax.swing.JLabel;
/*  12:    */ import javax.swing.JPanel;
/*  13:    */ import javax.swing.JScrollPane;
/*  14:    */ import javax.swing.JTextArea;
/*  15:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  16:    */ import org.jdesktop.application.Application;
/*  17:    */ import org.jdesktop.application.ApplicationContext;
/*  18:    */ import org.jdesktop.application.ResourceMap;
/*  19:    */ 
/*  20:    */ public class Cabecera
/*  21:    */   extends JPanel
/*  22:    */ {
/*  23:    */   private JLabel jLabel1;
/*  24:    */   private JLabel jLabel2;
/*  25:    */   private JLabel jLabel4;
/*  26:    */   private JLabel jLabel5;
/*  27:    */   private JLabel jLabel6;
/*  28:    */   private JLabel jLabel7;
/*  29:    */   private JLabel jLabel8;
/*  30:    */   private JPanel jPanelCabecera;
/*  31:    */   private JScrollPane jScrollPane3;
/*  32:    */   private JScrollPane jScrollPane4;
/*  33:    */   private JScrollPane jScrollPane5;
/*  34:    */   private JScrollPane jScrollPane6;
/*  35:    */   public JLabel lblContribuyente;
/*  36:    */   public JTextArea lblDirecEstabl;
/*  37:    */   public JTextArea lblDirecMatriz;
/*  38:    */   public JTextArea lblNombreComercial;
/*  39:    */   public JLabel lblObligado;
/*  40:    */   public JTextArea lblRazonSocial;
/*  41:    */   public JLabel lblRuc;
/*  42:    */   
/*  43:    */   public Cabecera()
/*  44:    */   {
/*  45: 23 */     initComponents();
/*  46:    */   }
/*  47:    */   
/*  48:    */   private void initComponents()
/*  49:    */   {
/*  50: 35 */     this.jPanelCabecera = new JPanel();
/*  51: 36 */     this.jLabel1 = new JLabel();
/*  52: 37 */     this.jLabel2 = new JLabel();
/*  53: 38 */     this.jLabel4 = new JLabel();
/*  54: 39 */     this.jLabel5 = new JLabel();
/*  55: 40 */     this.jLabel6 = new JLabel();
/*  56: 41 */     this.jLabel7 = new JLabel();
/*  57: 42 */     this.jLabel8 = new JLabel();
/*  58: 43 */     this.lblRuc = new JLabel();
/*  59: 44 */     this.jScrollPane3 = new JScrollPane();
/*  60: 45 */     this.lblDirecEstabl = new JTextArea();
/*  61: 46 */     this.jScrollPane4 = new JScrollPane();
/*  62: 47 */     this.lblNombreComercial = new JTextArea();
/*  63: 48 */     this.jScrollPane5 = new JScrollPane();
/*  64: 49 */     this.lblRazonSocial = new JTextArea();
/*  65: 50 */     this.jScrollPane6 = new JScrollPane();
/*  66: 51 */     this.lblDirecMatriz = new JTextArea();
/*  67: 52 */     this.lblObligado = new JLabel();
/*  68: 53 */     this.lblContribuyente = new JLabel();
/*  69:    */     
/*  70: 55 */     setName("Form");
/*  71: 56 */     setPreferredSize(new Dimension(790, 240));
/*  72:    */     
/*  73: 58 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(Cabecera.class);
/*  74: 59 */     this.jPanelCabecera.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanelCabecera.border.title", new Object[0])));
/*  75: 60 */     this.jPanelCabecera.setFont(resourceMap.getFont("jPanelCabecera.font"));
/*  76: 61 */     this.jPanelCabecera.setName("jPanelCabecera");
/*  77:    */     
/*  78: 63 */     this.jLabel1.setFont(resourceMap.getFont("jLabel8.font"));
/*  79: 64 */     this.jLabel1.setHorizontalAlignment(2);
/*  80: 65 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  81: 66 */     this.jLabel1.setName("jLabel1");
/*  82:    */     
/*  83: 68 */     this.jLabel2.setBackground(resourceMap.getColor("jLabel2.background"));
/*  84: 69 */     this.jLabel2.setFont(resourceMap.getFont("jLabel8.font"));
/*  85: 70 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/*  86: 71 */     this.jLabel2.setName("jLabel2");
/*  87:    */     
/*  88: 73 */     this.jLabel4.setFont(resourceMap.getFont("jLabel8.font"));
/*  89: 74 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/*  90: 75 */     this.jLabel4.setName("jLabel4");
/*  91:    */     
/*  92: 77 */     this.jLabel5.setFont(resourceMap.getFont("jLabel8.font"));
/*  93: 78 */     this.jLabel5.setText(resourceMap.getString("jLabel5.text", new Object[0]));
/*  94: 79 */     this.jLabel5.setName("jLabel5");
/*  95:    */     
/*  96: 81 */     this.jLabel6.setFont(resourceMap.getFont("jLabel8.font"));
/*  97: 82 */     this.jLabel6.setText(resourceMap.getString("jLabel6.text", new Object[0]));
/*  98: 83 */     this.jLabel6.setName("jLabel6");
/*  99:    */     
/* 100: 85 */     this.jLabel7.setFont(resourceMap.getFont("jLabel8.font"));
/* 101: 86 */     this.jLabel7.setText(resourceMap.getString("jLabel7.text", new Object[0]));
/* 102: 87 */     this.jLabel7.setName("jLabel7");
/* 103:    */     
/* 104: 89 */     this.jLabel8.setFont(resourceMap.getFont("jLabel8.font"));
/* 105: 90 */     this.jLabel8.setText(resourceMap.getString("jLabel8.text", new Object[0]));
/* 106: 91 */     this.jLabel8.setName("jLabel8");
/* 107:    */     
/* 108: 93 */     this.lblRuc.setFont(resourceMap.getFont("lblNombreComercial.font"));
/* 109: 94 */     this.lblRuc.setText(resourceMap.getString("lblRuc.text", new Object[0]));
/* 110: 95 */     this.lblRuc.setName("lblRuc");
/* 111:    */     
/* 112: 97 */     this.jScrollPane3.setName("jScrollPane3");
/* 113:    */     
/* 114: 99 */     this.lblDirecEstabl.setColumns(20);
/* 115:100 */     this.lblDirecEstabl.setFont(resourceMap.getFont("lblNombreComercial.font"));
/* 116:101 */     this.lblDirecEstabl.setLineWrap(true);
/* 117:102 */     this.lblDirecEstabl.setRows(4);
/* 118:103 */     this.lblDirecEstabl.setEnabled(false);
/* 119:104 */     this.lblDirecEstabl.setName("lblDirecEstabl");
/* 120:105 */     this.jScrollPane3.setViewportView(this.lblDirecEstabl);
/* 121:    */     
/* 122:107 */     this.jScrollPane4.setName("jScrollPane4");
/* 123:    */     
/* 124:109 */     this.lblNombreComercial.setColumns(20);
/* 125:110 */     this.lblNombreComercial.setFont(resourceMap.getFont("lblNombreComercial.font"));
/* 126:111 */     this.lblNombreComercial.setLineWrap(true);
/* 127:112 */     this.lblNombreComercial.setRows(4);
/* 128:113 */     this.lblNombreComercial.setEnabled(false);
/* 129:114 */     this.lblNombreComercial.setName("lblNombreComercial");
/* 130:115 */     this.jScrollPane4.setViewportView(this.lblNombreComercial);
/* 131:    */     
/* 132:117 */     this.jScrollPane5.setName("jScrollPane5");
/* 133:    */     
/* 134:119 */     this.lblRazonSocial.setColumns(20);
/* 135:120 */     this.lblRazonSocial.setFont(resourceMap.getFont("lblNombreComercial.font"));
/* 136:121 */     this.lblRazonSocial.setLineWrap(true);
/* 137:122 */     this.lblRazonSocial.setRows(4);
/* 138:123 */     this.lblRazonSocial.setEnabled(false);
/* 139:124 */     this.lblRazonSocial.setName("lblRazonSocial");
/* 140:125 */     this.jScrollPane5.setViewportView(this.lblRazonSocial);
/* 141:    */     
/* 142:127 */     this.jScrollPane6.setName("jScrollPane6");
/* 143:    */     
/* 144:129 */     this.lblDirecMatriz.setColumns(20);
/* 145:130 */     this.lblDirecMatriz.setFont(resourceMap.getFont("lblNombreComercial.font"));
/* 146:131 */     this.lblDirecMatriz.setLineWrap(true);
/* 147:132 */     this.lblDirecMatriz.setRows(4);
/* 148:133 */     this.lblDirecMatriz.setEnabled(false);
/* 149:134 */     this.lblDirecMatriz.setName("lblDirecMatriz");
/* 150:135 */     this.jScrollPane6.setViewportView(this.lblDirecMatriz);
/* 151:    */     
/* 152:137 */     this.lblObligado.setFont(resourceMap.getFont("lblObligado.font"));
/* 153:138 */     this.lblObligado.setText(resourceMap.getString("lblObligado.text", new Object[0]));
/* 154:139 */     this.lblObligado.setName("lblObligado");
/* 155:    */     
/* 156:141 */     this.lblContribuyente.setFont(resourceMap.getFont("lblContribuyente.font"));
/* 157:142 */     this.lblContribuyente.setText(resourceMap.getString("lblContribuyente.text", new Object[0]));
/* 158:143 */     this.lblContribuyente.setName("lblContribuyente");
/* 159:    */     
/* 160:145 */     GroupLayout jPanelCabeceraLayout = new GroupLayout(this.jPanelCabecera);
/* 161:146 */     this.jPanelCabecera.setLayout(jPanelCabeceraLayout);
/* 162:147 */     jPanelCabeceraLayout.setHorizontalGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createSequentialGroup().addContainerGap().addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createSequentialGroup().addComponent(this.jLabel5, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(jPanelCabeceraLayout.createSequentialGroup().addComponent(this.jLabel7, -1, 124, 32767).addGap(34, 34, 34))).addGroup(jPanelCabeceraLayout.createSequentialGroup().addComponent(this.jLabel8, -2, -1, -2).addGap(53, 53, 53))).addComponent(this.jLabel4).addComponent(this.jLabel2).addComponent(this.jLabel1, -2, -1, -2)).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createSequentialGroup().addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblRuc, -2, 197, -2)).addComponent(this.jScrollPane6, -1, 567, 32767).addComponent(this.jScrollPane3, -1, 567, 32767).addComponent(this.jScrollPane5, GroupLayout.Alignment.TRAILING, -1, 567, 32767).addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING, -1, 567, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanelCabeceraLayout.createSequentialGroup().addComponent(this.lblContribuyente, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 84, 32767).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblObligado, -2, 30, -2).addGap(172, 172, 172)))));
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
/* 178:    */ 
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
/* 200:185 */     jPanelCabeceraLayout.setVerticalGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanelCabeceraLayout.createSequentialGroup().addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.lblRuc)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jScrollPane4, -2, 27, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, -1, -2).addComponent(this.jScrollPane5, -2, 27, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.lblObligado, -2, 20, -2)).addComponent(this.lblContribuyente, -2, 20, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addComponent(this.jScrollPane6, -2, 27, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanelCabeceraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8, -2, -1, -2).addComponent(this.jScrollPane3, -2, 26, -2)).addContainerGap(-1, 32767)));
/* 201:    */     
/* 202:    */ 
/* 203:    */ 
/* 204:    */ 
/* 205:    */ 
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
/* 232:217 */     jPanelCabeceraLayout.linkSize(1, new Component[] { this.jScrollPane3, this.jScrollPane4, this.jScrollPane5, this.jScrollPane6 });
/* 233:    */     
/* 234:219 */     GroupLayout layout = new GroupLayout(this);
/* 235:220 */     setLayout(layout);
/* 236:221 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelCabecera, -1, 761, 32767));
/* 237:    */     
/* 238:    */ 
/* 239:    */ 
/* 240:225 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanelCabecera, -2, 210, -2));
/* 241:    */   }
/* 242:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.Cabecera
 * JD-Core Version:    0.7.0.1
 */