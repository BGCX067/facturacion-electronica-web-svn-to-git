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
/*  14:    */ public class AdministracionClientes
/*  15:    */   extends JPanel
/*  16:    */ {
/*  17:    */   private CargaMasivaClientes cargaMasivaClientes1;
/*  18:    */   private ClienteView clienteView1;
/*  19:    */   private ClientesView clientesView1;
/*  20:    */   private JPanel jPanel1;
/*  21:    */   private JPanel jPanel2;
/*  22:    */   private JPanel jPanel3;
/*  23:    */   private JTabbedPane jTabbedPane1;
/*  24:    */   
/*  25:    */   public AdministracionClientes()
/*  26:    */   {
/*  27: 21 */     initComponents();
/*  28:    */   }
/*  29:    */   
/*  30:    */   private void initComponents()
/*  31:    */   {
/*  32: 33 */     this.jTabbedPane1 = new JTabbedPane();
/*  33: 34 */     this.jPanel1 = new JPanel();
/*  34: 35 */     this.clienteView1 = new ClienteView();
/*  35: 36 */     this.jPanel2 = new JPanel();
/*  36: 37 */     this.clientesView1 = new ClientesView();
/*  37: 38 */     this.jPanel3 = new JPanel();
/*  38: 39 */     this.cargaMasivaClientes1 = new CargaMasivaClientes();
/*  39:    */     
/*  40: 41 */     setName("Form");
/*  41:    */     
/*  42: 43 */     this.jTabbedPane1.setName("jTabbedPane1");
/*  43:    */     
/*  44: 45 */     this.jPanel1.setName("jPanel1");
/*  45:    */     
/*  46: 47 */     this.clienteView1.setName("clienteView1");
/*  47:    */     
/*  48: 49 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  49: 50 */     this.jPanel1.setLayout(jPanel1Layout);
/*  50: 51 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.clienteView1, -1, 1108, 32767).addContainerGap()));
/*  51:    */     
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55:    */ 
/*  56: 57 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.clienteView1, -1, 587, 32767).addContainerGap()));
/*  57:    */     
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64: 65 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(AdministracionClientes.class);
/*  65: 66 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle", new Object[0]), this.jPanel1);
/*  66:    */     
/*  67: 68 */     this.jPanel2.setName("jPanel2");
/*  68:    */     
/*  69: 70 */     this.clientesView1.setName("clientesView1");
/*  70:    */     
/*  71: 72 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  72: 73 */     this.jPanel2.setLayout(jPanel2Layout);
/*  73: 74 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.clientesView1, -2, -1, -2).addContainerGap(322, 32767)));
/*  74:    */     
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79: 80 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.clientesView1, -2, -1, -2).addContainerGap(365, 32767)));
/*  80:    */     
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86: 87 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle", new Object[0]), this.jPanel2);
/*  87:    */     
/*  88: 89 */     this.jPanel3.setName("jPanel3");
/*  89:    */     
/*  90: 91 */     this.cargaMasivaClientes1.setName("cargaMasivaClientes1");
/*  91:    */     
/*  92: 93 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  93: 94 */     this.jPanel3.setLayout(jPanel3Layout);
/*  94: 95 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.cargaMasivaClientes1, -2, -1, -2).addContainerGap(547, 32767)));
/*  95:    */     
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:102 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.cargaMasivaClientes1, -2, -1, -2).addContainerGap(457, 32767)));
/* 102:    */     
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:110 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel3.TabConstraints.tabTitle", new Object[0]), this.jPanel3);
/* 110:    */     
/* 111:112 */     GroupLayout layout = new GroupLayout(this);
/* 112:113 */     setLayout(layout);
/* 113:114 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
/* 114:    */     
/* 115:    */ 
/* 116:    */ 
/* 117:118 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
/* 118:    */   }
/* 119:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.AdministracionClientes
 * JD-Core Version:    0.7.0.1
 */