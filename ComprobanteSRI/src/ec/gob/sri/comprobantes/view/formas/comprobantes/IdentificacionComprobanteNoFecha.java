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
/*  12:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  13:    */ import org.jdesktop.application.Application;
/*  14:    */ import org.jdesktop.application.ApplicationContext;
/*  15:    */ import org.jdesktop.application.ResourceMap;
/*  16:    */ 
/*  17:    */ public class IdentificacionComprobanteNoFecha
/*  18:    */   extends JPanel
/*  19:    */ {
/*  20:    */   private JLabel jLabel11;
/*  21:    */   private JLabel jLabel25;
/*  22:    */   private JLabel jLabel28;
/*  23:    */   private JLabel jLabel9;
/*  24:    */   private JPanel jPanel1;
/*  25:    */   public JLabel lblClaveAcceso;
/*  26:    */   public JLabel lblEstablecimiento;
/*  27:    */   public JLabel lblNumeroComprobante;
/*  28:    */   public JLabel lblPunto;
/*  29:    */   
/*  30:    */   public IdentificacionComprobanteNoFecha()
/*  31:    */   {
/*  32: 17 */     initComponents();
/*  33:    */   }
/*  34:    */   
/*  35:    */   private void initComponents()
/*  36:    */   {
/*  37: 29 */     this.jPanel1 = new JPanel();
/*  38: 30 */     this.jLabel9 = new JLabel();
/*  39: 31 */     this.lblNumeroComprobante = new JLabel();
/*  40: 32 */     this.jLabel11 = new JLabel();
/*  41: 33 */     this.lblClaveAcceso = new JLabel();
/*  42: 34 */     this.lblEstablecimiento = new JLabel();
/*  43: 35 */     this.lblPunto = new JLabel();
/*  44: 36 */     this.jLabel25 = new JLabel();
/*  45: 37 */     this.jLabel28 = new JLabel();
/*  46:    */     
/*  47: 39 */     setName("Form");
/*  48: 40 */     setPreferredSize(new Dimension(743, 40));
/*  49:    */     
/*  50: 42 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(IdentificacionComprobanteNoFecha.class);
/*  51: 43 */     this.jPanel1.setBorder(BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title", new Object[0])));
/*  52: 44 */     this.jPanel1.setName("jPanel1");
/*  53:    */     
/*  54: 46 */     this.jLabel9.setFont(resourceMap.getFont("jLabel9.font"));
/*  55: 47 */     this.jLabel9.setText(resourceMap.getString("jLabel9.text", new Object[0]));
/*  56: 48 */     this.jLabel9.setName("jLabel9");
/*  57:    */     
/*  58: 50 */     this.lblNumeroComprobante.setFont(resourceMap.getFont("jLabel9.font"));
/*  59: 51 */     this.lblNumeroComprobante.setText(resourceMap.getString("lblNumeroComprobante.text", new Object[0]));
/*  60: 52 */     this.lblNumeroComprobante.setName("lblNumeroComprobante");
/*  61:    */     
/*  62: 54 */     this.jLabel11.setFont(resourceMap.getFont("jLabel9.font"));
/*  63: 55 */     this.jLabel11.setText(resourceMap.getString("jLabel11.text", new Object[0]));
/*  64: 56 */     this.jLabel11.setName("jLabel11");
/*  65:    */     
/*  66: 58 */     this.lblClaveAcceso.setFont(resourceMap.getFont("jLabel9.font"));
/*  67: 59 */     this.lblClaveAcceso.setHorizontalAlignment(4);
/*  68: 60 */     this.lblClaveAcceso.setText(resourceMap.getString("lblClaveAcceso.text", new Object[0]));
/*  69: 61 */     this.lblClaveAcceso.setName("lblClaveAcceso");
/*  70:    */     
/*  71: 63 */     this.lblEstablecimiento.setFont(resourceMap.getFont("jLabel9.font"));
/*  72: 64 */     this.lblEstablecimiento.setText(resourceMap.getString("lblEstablecimiento.text", new Object[0]));
/*  73: 65 */     this.lblEstablecimiento.setName("lblEstablecimiento");
/*  74:    */     
/*  75: 67 */     this.lblPunto.setFont(resourceMap.getFont("jLabel9.font"));
/*  76: 68 */     this.lblPunto.setText(resourceMap.getString("lblPunto.text", new Object[0]));
/*  77: 69 */     this.lblPunto.setName("lblPunto");
/*  78:    */     
/*  79: 71 */     this.jLabel25.setFont(resourceMap.getFont("jLabel9.font"));
/*  80: 72 */     this.jLabel25.setText(resourceMap.getString("jLabel25.text", new Object[0]));
/*  81: 73 */     this.jLabel25.setName("jLabel25");
/*  82:    */     
/*  83: 75 */     this.jLabel28.setFont(resourceMap.getFont("jLabel9.font"));
/*  84: 76 */     this.jLabel28.setText(resourceMap.getString("jLabel28.text", new Object[0]));
/*  85: 77 */     this.jLabel28.setName("jLabel28");
/*  86:    */     
/*  87: 79 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  88: 80 */     this.jPanel1.setLayout(jPanel1Layout);
/*  89: 81 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblEstablecimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblPunto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblNumeroComprobante).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 94, 32767).addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblClaveAcceso, -2, 355, -2).addContainerGap()));
/*  90:    */     
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:    */ 
/* 110:102 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.lblEstablecimiento).addComponent(this.jLabel9).addComponent(this.lblPunto).addComponent(this.jLabel25).addComponent(this.jLabel28).addComponent(this.lblNumeroComprobante).addComponent(this.lblClaveAcceso).addComponent(this.jLabel11)).addContainerGap(-1, 32767)));
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
/* 125:117 */     GroupLayout layout = new GroupLayout(this);
/* 126:118 */     setLayout(layout);
/* 127:119 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
/* 128:    */     
/* 129:    */ 
/* 130:    */ 
/* 131:123 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/* 132:    */   }
/* 133:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.comprobantes.IdentificacionComprobanteNoFecha
 * JD-Core Version:    0.7.0.1
 */