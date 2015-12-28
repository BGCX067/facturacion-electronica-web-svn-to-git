/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import javax.swing.GroupLayout;
/*   5:    */ import javax.swing.GroupLayout.Alignment;
/*   6:    */ import javax.swing.GroupLayout.ParallelGroup;
/*   7:    */ import javax.swing.GroupLayout.SequentialGroup;
/*   8:    */ import javax.swing.JPanel;
/*   9:    */ import javax.swing.JTabbedPane;
/*  10:    */ import org.jdesktop.application.Application;
/*  11:    */ import org.jdesktop.application.ApplicationContext;
/*  12:    */ import org.jdesktop.application.ResourceMap;
/*  13:    */ 
/*  14:    */ public class AdministracionTransportistas
/*  15:    */   extends JPanel
/*  16:    */ {
/*  17:    */   private CargaMasivaTransportistas cargaMasivaTransportistas1;
/*  18:    */   private JPanel jPanel1;
/*  19:    */   private JPanel jPanel2;
/*  20:    */   private JPanel jPanel3;
/*  21:    */   private JTabbedPane jTabbedPane1;
/*  22:    */   private TransportistaView transportistaView1;
/*  23:    */   private TransportistasView transportistasView1;
/*  24:    */   
/*  25:    */   public AdministracionTransportistas()
/*  26:    */   {
/*  27: 21 */     initComponents();
/*  28:    */   }
/*  29:    */   
/*  30:    */   private void initComponents()
/*  31:    */   {
/*  32: 33 */     this.jTabbedPane1 = new JTabbedPane();
/*  33: 34 */     this.jPanel1 = new JPanel();
/*  34: 35 */     this.transportistaView1 = new TransportistaView();
/*  35: 36 */     this.jPanel2 = new JPanel();
/*  36: 37 */     this.transportistasView1 = new TransportistasView();
/*  37: 38 */     this.jPanel3 = new JPanel();
/*  38: 39 */     this.cargaMasivaTransportistas1 = new CargaMasivaTransportistas();
/*  39:    */     
/*  40: 41 */     setName("Form");
/*  41:    */     
/*  42: 43 */     this.jTabbedPane1.setName("jTabbedPane1");
/*  43:    */     
/*  44: 45 */     this.jPanel1.setName("jPanel1");
/*  45:    */     
/*  46: 47 */     this.transportistaView1.setName("transportistaView1");
/*  47:    */     
/*  48: 49 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  49: 50 */     this.jPanel1.setLayout(jPanel1Layout);
/*  50: 51 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.transportistaView1, -2, -1, -2).addContainerGap(278, 32767)));
/*  51:    */     
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55:    */ 
/*  56:    */ 
/*  57: 58 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.transportistaView1, -2, 273, -2).addContainerGap(389, 32767)));
/*  58:    */     
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64:    */ 
/*  65: 66 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(AdministracionTransportistas.class);
/*  66: 67 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle", new Object[0]), this.jPanel1);
/*  67:    */     
/*  68: 69 */     this.jPanel2.setName("jPanel2");
/*  69:    */     
/*  70: 71 */     this.transportistasView1.setName("transportistasView1");
/*  71:    */     
/*  72: 73 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  73: 74 */     this.jPanel2.setLayout(jPanel2Layout);
/*  74: 75 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.transportistasView1, -1, 885, 32767).addContainerGap()));
/*  75:    */     
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81: 82 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.transportistasView1, -2, 613, -2).addContainerGap(38, 32767)));
/*  82:    */     
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:    */ 
/*  89: 90 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle", new Object[0]), this.jPanel2);
/*  90:    */     
/*  91: 92 */     this.jPanel3.setName("jPanel3");
/*  92:    */     
/*  93: 94 */     this.cargaMasivaTransportistas1.setName("cargaMasivaTransportistas1");
/*  94:    */     
/*  95: 96 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  96: 97 */     this.jPanel3.setLayout(jPanel3Layout);
/*  97: 98 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.cargaMasivaTransportistas1, -2, -1, -2).addContainerGap(308, 32767)));
/*  98:    */     
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:105 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.cargaMasivaTransportistas1, -2, -1, -2).addContainerGap(474, 32767)));
/* 105:    */     
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:113 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel3.TabConstraints.tabTitle", new Object[0]), this.jPanel3);
/* 113:    */     
/* 114:115 */     GroupLayout layout = new GroupLayout(this);
/* 115:116 */     setLayout(layout);
/* 116:117 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -1, 910, 32767));
/* 117:    */     
/* 118:    */ 
/* 119:    */ 
/* 120:121 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 701, -2).addContainerGap(-1, 32767)));
/* 121:    */   }
/* 122:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.AdministracionTransportistas
 * JD-Core Version:    0.7.0.1
 */