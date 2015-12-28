/*   1:    */ package ec.gob.sri.comprobantes.view.formas.comprobantes;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import java.awt.Dimension;
/*   5:    */ import javax.swing.BorderFactory;
/*   6:    */ import javax.swing.GroupLayout;
/*   7:    */ import javax.swing.GroupLayout.Alignment;
/*   8:    */ import javax.swing.GroupLayout.ParallelGroup;
/*   9:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  10:    */ import javax.swing.JLabel;
/*  11:    */ import javax.swing.JPanel;
/*  12:    */ import javax.swing.JTextField;
/*  13:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  14:    */ import net.sourceforge.jcalendarbutton.JCalendarButton;
/*  15:    */ import org.jdesktop.application.Application;
/*  16:    */ import org.jdesktop.application.ApplicationContext;
/*  17:    */ import org.jdesktop.application.ResourceMap;
/*  18:    */ 
/*  19:    */ public class IdentificacionComprobanteNoGuia
/*  20:    */   extends JPanel
/*  21:    */ {
/*  22:    */   public JCalendarButton jCalendarFecha;
/*  23:    */   private JLabel jLabel11;
/*  24:    */   private JLabel jLabel12;
/*  25:    */   private JLabel jLabel25;
/*  26:    */   private JLabel jLabel28;
/*  27:    */   private JLabel jLabel9;
/*  28:    */   private JPanel jPanel1;
/*  29:    */   public JLabel lblClaveAcceso;
/*  30:    */   public JLabel lblEstablecimiento;
/*  31:    */   public JLabel lblNumeroComprobante;
/*  32:    */   public JLabel lblPunto;
/*  33:    */   public JTextField textFechaEmision;
/*  34:    */   
/*  35:    */   public IdentificacionComprobanteNoGuia()
/*  36:    */   {
/*  37: 17 */     initComponents();
/*  38:    */   }
/*  39:    */   
/*  40:    */   private void initComponents()
/*  41:    */   {
/*  42: 29 */     this.jPanel1 = new JPanel();
/*  43: 30 */     this.jLabel9 = new JLabel();
/*  44: 31 */     this.lblNumeroComprobante = new JLabel();
/*  45: 32 */     this.jLabel12 = new JLabel();
/*  46: 33 */     this.textFechaEmision = new JTextField();
/*  47: 34 */     this.jLabel11 = new JLabel();
/*  48: 35 */     this.lblClaveAcceso = new JLabel();
/*  49: 36 */     this.jCalendarFecha = new JCalendarButton();
/*  50: 37 */     this.lblEstablecimiento = new JLabel();
/*  51: 38 */     this.lblPunto = new JLabel();
/*  52: 39 */     this.jLabel25 = new JLabel();
/*  53: 40 */     this.jLabel28 = new JLabel();
/*  54:    */     
/*  55: 42 */     setName("Form");
/*  56: 43 */     setPreferredSize(new Dimension(743, 80));
/*  57:    */     
/*  58: 45 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(IdentificacionComprobanteNoGuia.class);
/*  59: 46 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/*  60: 47 */     this.jPanel1.setName("jPanel1");
/*  61:    */     
/*  62: 49 */     this.jLabel9.setFont(resourceMap.getFont("jLabel9.font"));
/*  63: 50 */     this.jLabel9.setText(resourceMap.getString("jLabel9.text", new Object[0]));
/*  64: 51 */     this.jLabel9.setName("jLabel9");
/*  65:    */     
/*  66: 53 */     this.lblNumeroComprobante.setFont(resourceMap.getFont("jLabel9.font"));
/*  67: 54 */     this.lblNumeroComprobante.setText(resourceMap.getString("lblNumeroComprobante.text", new Object[0]));
/*  68: 55 */     this.lblNumeroComprobante.setName("lblNumeroComprobante");
/*  69:    */     
/*  70: 57 */     this.jLabel12.setFont(resourceMap.getFont("jLabel9.font"));
/*  71: 58 */     this.jLabel12.setText(resourceMap.getString("jLabel12.text", new Object[0]));
/*  72: 59 */     this.jLabel12.setName("jLabel12");
/*  73:    */     
/*  74: 61 */     this.textFechaEmision.setEditable(false);
/*  75: 62 */     this.textFechaEmision.setFont(resourceMap.getFont("textFechaEmision.font"));
/*  76: 63 */     this.textFechaEmision.setToolTipText(resourceMap.getString("textFechaEmision.toolTipText", new Object[0]));
/*  77: 64 */     this.textFechaEmision.setName("textFechaEmision");
/*  78:    */     
/*  79: 66 */     this.jLabel11.setFont(resourceMap.getFont("jLabel9.font"));
/*  80: 67 */     this.jLabel11.setText(resourceMap.getString("jLabel11.text", new Object[0]));
/*  81: 68 */     this.jLabel11.setName("jLabel11");
/*  82:    */     
/*  83: 70 */     this.lblClaveAcceso.setFont(resourceMap.getFont("jLabel9.font"));
/*  84: 71 */     this.lblClaveAcceso.setHorizontalAlignment(4);
/*  85: 72 */     this.lblClaveAcceso.setText(resourceMap.getString("lblClaveAcceso.text", new Object[0]));
/*  86: 73 */     this.lblClaveAcceso.setName("lblClaveAcceso");
/*  87:    */     
/*  88: 75 */     this.jCalendarFecha.setName("jCalendarFecha");
/*  89:    */     
/*  90: 77 */     this.lblEstablecimiento.setFont(resourceMap.getFont("lblEstablecimiento.font"));
/*  91: 78 */     this.lblEstablecimiento.setText(resourceMap.getString("lblEstablecimiento.text", new Object[0]));
/*  92: 79 */     this.lblEstablecimiento.setName("lblEstablecimiento");
/*  93:    */     
/*  94: 81 */     this.lblPunto.setFont(resourceMap.getFont("lblEstablecimiento.font"));
/*  95: 82 */     this.lblPunto.setText(resourceMap.getString("lblPunto.text", new Object[0]));
/*  96: 83 */     this.lblPunto.setName("lblPunto");
/*  97:    */     
/*  98: 85 */     this.jLabel25.setText(resourceMap.getString("jLabel25.text", new Object[0]));
/*  99: 86 */     this.jLabel25.setName("jLabel25");
/* 100:    */     
/* 101: 88 */     this.jLabel28.setText(resourceMap.getString("jLabel28.text", new Object[0]));
/* 102: 89 */     this.jLabel28.setName("jLabel28");
/* 103:    */     
/* 104: 91 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 105: 92 */     this.jPanel1.setLayout(jPanel1Layout);
/* 106: 93 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblEstablecimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblPunto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblNumeroComprobante)).addComponent(this.jLabel12)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblClaveAcceso, -2, 355, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.textFechaEmision, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCalendarFecha, -2, 30, -2))).addContainerGap()));
/* 107:    */     
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:    */ 
/* 116:    */ 
/* 117:    */ 
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:    */ 
/* 131:    */ 
/* 132:    */ 
/* 133:    */ 
/* 134:    */ 
/* 135:    */ 
/* 136:123 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblEstablecimiento).addComponent(this.jLabel9).addComponent(this.lblPunto).addComponent(this.jLabel25).addComponent(this.jLabel28).addComponent(this.lblNumeroComprobante).addComponent(this.lblClaveAcceso).addComponent(this.jLabel11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel12).addComponent(this.textFechaEmision, -2, -1, -2).addComponent(this.jCalendarFecha, -2, 24, -2)).addContainerGap(12, 32767)));
/* 137:    */     
/* 138:    */ 
/* 139:    */ 
/* 140:    */ 
/* 141:    */ 
/* 142:    */ 
/* 143:    */ 
/* 144:    */ 
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
/* 156:143 */     GroupLayout layout = new GroupLayout(this);
/* 157:144 */     setLayout(layout);
/* 158:145 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/* 159:    */     
/* 160:    */ 
/* 161:    */ 
/* 162:149 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 163:    */   }
/* 164:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.IdentificacionComprobanteNoGuia
 * JD-Core Version:    0.7.0.1
 */