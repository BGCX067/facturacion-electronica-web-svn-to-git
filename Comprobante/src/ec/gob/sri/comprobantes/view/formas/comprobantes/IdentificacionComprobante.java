/*   1:    */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.util.ListenerUtil;
/*   5:    */ import java.awt.event.FocusAdapter;
/*   6:    */ import java.awt.event.FocusEvent;
/*   7:    */ import javax.swing.BorderFactory;
/*   8:    */ import javax.swing.GroupLayout;
/*   9:    */ import javax.swing.GroupLayout.Alignment;
/*  10:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  11:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  12:    */ import javax.swing.JLabel;
/*  13:    */ import javax.swing.JPanel;
/*  14:    */ import javax.swing.JTextField;
/*  15:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  16:    */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*  17:    */ import org.jdesktop.application.Application;
/*  18:    */ import org.jdesktop.application.ApplicationContext;
/*  19:    */ import org.jdesktop.application.ResourceMap;
/*  20:    */ 
/*  21:    */ public class IdentificacionComprobante
/*  22:    */   extends JPanel
/*  23:    */ {
/*  24:    */   public JCalendarButton jCalendarFecha;
/*  25:    */   private JLabel jLabel11;
/*  26:    */   private JLabel jLabel12;
/*  27:    */   private JLabel jLabel15;
/*  28:    */   private JLabel jLabel25;
/*  29:    */   private JLabel jLabel28;
/*  30:    */   private JLabel jLabel9;
/*  31:    */   private JPanel jPanel1;
/*  32:    */   public JLabel lblClaveAcceso;
/*  33:    */   public JLabel lblEstablecimiento;
/*  34:    */   public JLabel lblNumeroComprobante;
/*  35:    */   public JLabel lblPunto;
/*  36:    */   public JTextField textFechaEmision;
/*  37:    */   public JTextField textGuia1;
/*  38:    */   public JTextField textGuia2;
/*  39:    */   public JTextField textGuia3;
/*  40:    */   
/*  41:    */   public IdentificacionComprobante()
/*  42:    */   {
/*  43: 19 */     initComponents();
/*  44: 20 */     ListenerUtil lu = new ListenerUtil();
/*  45: 21 */     lu.listenerSolonumerosLongitud(this.textGuia1, Integer.valueOf(3));
/*  46: 22 */     lu.listenerSolonumerosLongitud(this.textGuia2, Integer.valueOf(3));
/*  47: 23 */     lu.listenerSolonumerosLongitud(this.textGuia3, Integer.valueOf(9));
/*  48:    */   }
/*  49:    */   
/*  50:    */   private void initComponents()
/*  51:    */   {
/*  52: 35 */     this.jPanel1 = new JPanel();
/*  53: 36 */     this.jLabel9 = new JLabel();
/*  54: 37 */     this.lblNumeroComprobante = new JLabel();
/*  55: 38 */     this.jLabel12 = new JLabel();
/*  56: 39 */     this.textFechaEmision = new JTextField();
/*  57: 40 */     this.jLabel15 = new JLabel();
/*  58: 41 */     this.textGuia1 = new JTextField();
/*  59: 42 */     this.textGuia3 = new JTextField();
/*  60: 43 */     this.textGuia2 = new JTextField();
/*  61: 44 */     this.jLabel11 = new JLabel();
/*  62: 45 */     this.lblClaveAcceso = new JLabel();
/*  63: 46 */     this.jCalendarFecha = new JCalendarButton();
/*  64: 47 */     this.lblEstablecimiento = new JLabel();
/*  65: 48 */     this.lblPunto = new JLabel();
/*  66: 49 */     this.jLabel25 = new JLabel();
/*  67: 50 */     this.jLabel28 = new JLabel();
/*  68:    */     
/*  69: 52 */     setName("Form");
/*  70:    */     
/*  71: 54 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(IdentificacionComprobante.class);
/*  72: 55 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/*  73: 56 */     this.jPanel1.setFont(resourceMap.getFont("jPanel1.font"));
/*  74: 57 */     this.jPanel1.setName("jPanel1");
/*  75:    */     
/*  76: 59 */     this.jLabel9.setFont(resourceMap.getFont("jLabel9.font"));
/*  77: 60 */     this.jLabel9.setText(resourceMap.getString("jLabel9.text", new Object[0]));
/*  78: 61 */     this.jLabel9.setName("jLabel9");
/*  79:    */     
/*  80: 63 */     this.lblNumeroComprobante.setFont(resourceMap.getFont("jLabel11.font"));
/*  81: 64 */     this.lblNumeroComprobante.setText(resourceMap.getString("lblNumeroComprobante.text", new Object[0]));
/*  82: 65 */     this.lblNumeroComprobante.setName("lblNumeroComprobante");
/*  83:    */     
/*  84: 67 */     this.jLabel12.setFont(resourceMap.getFont("jLabel11.font"));
/*  85: 68 */     this.jLabel12.setText(resourceMap.getString("jLabel12.text", new Object[0]));
/*  86: 69 */     this.jLabel12.setName("jLabel12");
/*  87:    */     
/*  88: 71 */     this.textFechaEmision.setEditable(false);
/*  89: 72 */     this.textFechaEmision.setName("textFechaEmision");
/*  90:    */     
/*  91: 74 */     this.jLabel15.setFont(resourceMap.getFont("jLabel11.font"));
/*  92: 75 */     this.jLabel15.setText(resourceMap.getString("jLabel15.text", new Object[0]));
/*  93: 76 */     this.jLabel15.setName("jLabel15");
/*  94:    */     
/*  95: 78 */     this.textGuia1.setName("textGuia1");
/*  96: 79 */     this.textGuia1.addFocusListener(new FocusAdapter()
/*  97:    */     {
/*  98:    */       public void focusLost(FocusEvent evt)
/*  99:    */       {
/* 100: 81 */         IdentificacionComprobante.this.textGuia1FocusLost(evt);
/* 101:    */       }
/* 102: 84 */     });
/* 103: 85 */     this.textGuia3.setName("textGuia3");
/* 104: 86 */     this.textGuia3.addFocusListener(new FocusAdapter()
/* 105:    */     {
/* 106:    */       public void focusLost(FocusEvent evt)
/* 107:    */       {
/* 108: 88 */         IdentificacionComprobante.this.textGuia3FocusLost(evt);
/* 109:    */       }
/* 110: 91 */     });
/* 111: 92 */     this.textGuia2.setName("textGuia2");
/* 112: 93 */     this.textGuia2.addFocusListener(new FocusAdapter()
/* 113:    */     {
/* 114:    */       public void focusLost(FocusEvent evt)
/* 115:    */       {
/* 116: 95 */         IdentificacionComprobante.this.textGuia2FocusLost(evt);
/* 117:    */       }
/* 118: 98 */     });
/* 119: 99 */     this.jLabel11.setFont(resourceMap.getFont("jLabel11.font"));
/* 120:100 */     this.jLabel11.setText(resourceMap.getString("jLabel11.text", new Object[0]));
/* 121:101 */     this.jLabel11.setName("jLabel11");
/* 122:    */     
/* 123:103 */     this.lblClaveAcceso.setFont(resourceMap.getFont("lblClaveAcceso.font"));
/* 124:104 */     this.lblClaveAcceso.setHorizontalAlignment(4);
/* 125:105 */     this.lblClaveAcceso.setText(resourceMap.getString("lblClaveAcceso.text", new Object[0]));
/* 126:106 */     this.lblClaveAcceso.setName("lblClaveAcceso");
/* 127:    */     
/* 128:108 */     this.jCalendarFecha.setName("jCalendarFecha");
/* 129:    */     
/* 130:110 */     this.lblEstablecimiento.setText(resourceMap.getString("lblEstablecimiento.text", new Object[0]));
/* 131:111 */     this.lblEstablecimiento.setName("lblEstablecimiento");
/* 132:    */     
/* 133:113 */     this.lblPunto.setText(resourceMap.getString("lblPunto.text", new Object[0]));
/* 134:114 */     this.lblPunto.setName("lblPunto");
/* 135:    */     
/* 136:116 */     this.jLabel25.setText(resourceMap.getString("jLabel25.text", new Object[0]));
/* 137:117 */     this.jLabel25.setName("jLabel25");
/* 138:    */     
/* 139:119 */     this.jLabel28.setText(resourceMap.getString("jLabel28.text", new Object[0]));
/* 140:120 */     this.jLabel28.setName("jLabel28");
/* 141:    */     
/* 142:122 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 143:123 */     this.jPanel1.setLayout(jPanel1Layout);
/* 144:124 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblEstablecimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblPunto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblNumeroComprobante, -2, 73, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textFechaEmision, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCalendarFecha, -2, 30, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 216, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel15).addGap(8, 8, 8))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.textGuia1, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textGuia2, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.textGuia3, -2, 88, -2)).addComponent(this.lblClaveAcceso)).addContainerGap()));
/* 145:    */     
/* 146:    */ 
/* 147:    */ 
/* 148:    */ 
/* 149:    */ 
/* 150:    */ 
/* 151:    */ 
/* 152:    */ 
/* 153:    */ 
/* 154:    */ 
/* 155:    */ 
/* 156:    */ 
/* 157:    */ 
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
/* 178:    */ 
/* 179:    */ 
/* 180:    */ 
/* 181:    */ 
/* 182:    */ 
/* 183:    */ 
/* 184:    */ 
/* 185:165 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addComponent(this.lblEstablecimiento).addComponent(this.jLabel25).addComponent(this.lblPunto).addComponent(this.jLabel28).addComponent(this.lblNumeroComprobante).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblClaveAcceso, -2, 14, -2).addComponent(this.jLabel11))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel12).addComponent(this.textFechaEmision, -2, -1, -2).addComponent(this.jCalendarFecha, -2, 24, -2).addComponent(this.jLabel15).addComponent(this.textGuia1, -2, -1, -2).addComponent(this.textGuia2, -2, -1, -2).addComponent(this.textGuia3, -2, -1, -2)).addContainerGap(-1, 32767)));
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
/* 205:    */ 
/* 206:    */ 
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:190 */     GroupLayout layout = new GroupLayout(this);
/* 211:191 */     setLayout(layout);
/* 212:192 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 213:    */     
/* 214:    */ 
/* 215:    */ 
/* 216:196 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 217:    */   }
/* 218:    */   
/* 219:    */   private void textGuia3FocusLost(FocusEvent evt)
/* 220:    */   {
/* 221:    */     try
/* 222:    */     {
/* 223:204 */       this.textGuia3.setText(String.format("%09d", new Object[] { Integer.valueOf(Integer.parseInt(this.textGuia3.getText())) }));
/* 224:    */     }
/* 225:    */     catch (NumberFormatException ex) {}
/* 226:    */   }
/* 227:    */   
/* 228:    */   private void textGuia2FocusLost(FocusEvent evt)
/* 229:    */   {
/* 230:    */     try
/* 231:    */     {
/* 232:211 */       this.textGuia2.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textGuia2.getText())) }));
/* 233:    */     }
/* 234:    */     catch (NumberFormatException ex) {}
/* 235:    */   }
/* 236:    */   
/* 237:    */   private void textGuia1FocusLost(FocusEvent evt)
/* 238:    */   {
/* 239:    */     try
/* 240:    */     {
/* 241:218 */       this.textGuia1.setText(String.format("%03d", new Object[] { Integer.valueOf(Integer.parseInt(this.textGuia1.getText())) }));
/* 242:    */     }
/* 243:    */     catch (NumberFormatException ex) {}
/* 244:    */   }
/* 245:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.IdentificacionComprobante
 * JD-Core Version:    0.7.0.1
 */