/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import javax.swing.GroupLayout;
/*   5:    */ import javax.swing.GroupLayout.Alignment;
/*   6:    */ import javax.swing.GroupLayout.ParallelGroup;
/*   7:    */ import javax.swing.GroupLayout.SequentialGroup;
/*   8:    */ import javax.swing.JPanel;
/*   9:    */ import javax.swing.JScrollPane;
/*  10:    */ import javax.swing.JTabbedPane;
/*  11:    */ import org.jdesktop.application.Application;
/*  12:    */ import org.jdesktop.application.ApplicationContext;
/*  13:    */ import org.jdesktop.application.ResourceMap;
/*  14:    */ 
/*  15:    */ public class AdministracionProductos
/*  16:    */   extends JPanel
/*  17:    */ {
/*  18:    */   private CargaMasivaProductos cargaMasivaProductos1;
/*  19:    */   private JPanel jPanel2;
/*  20:    */   private JPanel jPanel3;
/*  21:    */   private JScrollPane jScrollPane1;
/*  22:    */   private JTabbedPane jTabbedPane1;
/*  23:    */   private ProductoView productoView1;
/*  24:    */   private ProductosView productosView1;
/*  25:    */   
/*  26:    */   public AdministracionProductos()
/*  27:    */   {
/*  28: 21 */     initComponents();
/*  29:    */   }
/*  30:    */   
/*  31:    */   private void initComponents()
/*  32:    */   {
/*  33: 33 */     this.jTabbedPane1 = new JTabbedPane();
/*  34: 34 */     this.jScrollPane1 = new JScrollPane();
/*  35: 35 */     this.productoView1 = new ProductoView();
/*  36: 36 */     this.jPanel2 = new JPanel();
/*  37: 37 */     this.productosView1 = new ProductosView();
/*  38: 38 */     this.jPanel3 = new JPanel();
/*  39: 39 */     this.cargaMasivaProductos1 = new CargaMasivaProductos();
/*  40:    */     
/*  41: 41 */     setName("Form");
/*  42:    */     
/*  43: 43 */     this.jTabbedPane1.setName("jTabbedPane1");
/*  44:    */     
/*  45: 45 */     this.jScrollPane1.setName("jScrollPane1");
/*  46:    */     
/*  47: 47 */     this.productoView1.setName("productoView1");
/*  48: 48 */     this.jScrollPane1.setViewportView(this.productoView1);
/*  49:    */     
/*  50: 50 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(AdministracionProductos.class);
/*  51: 51 */     this.jTabbedPane1.addTab(resourceMap.getString("jScrollPane1.TabConstraints.tabTitle", new Object[0]), this.jScrollPane1);
/*  52:    */     
/*  53: 53 */     this.jPanel2.setName("jPanel2");
/*  54:    */     
/*  55: 55 */     this.productosView1.setName("productosView1");
/*  56:    */     
/*  57: 57 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  58: 58 */     this.jPanel2.setLayout(jPanel2Layout);
/*  59: 59 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.productosView1, -2, 817, -2).addContainerGap(35, 32767)));
/*  60:    */     
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64:    */ 
/*  65:    */ 
/*  66: 66 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.productosView1, -2, 694, -2).addContainerGap(72, 32767)));
/*  67:    */     
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71:    */ 
/*  72:    */ 
/*  73:    */ 
/*  74: 74 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle", new Object[0]), this.jPanel2);
/*  75:    */     
/*  76: 76 */     this.jPanel3.setName("jPanel3");
/*  77:    */     
/*  78: 78 */     this.cargaMasivaProductos1.setName("cargaMasivaProductos1");
/*  79:    */     
/*  80: 80 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  81: 81 */     this.jPanel3.setLayout(jPanel3Layout);
/*  82: 82 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.cargaMasivaProductos1, -2, -1, -2).addContainerGap(275, 32767)));
/*  83:    */     
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:    */ 
/*  89: 89 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.cargaMasivaProductos1, -2, -1, -2).addContainerGap(624, 32767)));
/*  90:    */     
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97: 97 */     this.jTabbedPane1.addTab(resourceMap.getString("jPanel3.TabConstraints.tabTitle", new Object[0]), this.jPanel3);
/*  98:    */     
/*  99: 99 */     GroupLayout layout = new GroupLayout(this);
/* 100:100 */     setLayout(layout);
/* 101:101 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 903, 32767).addContainerGap()));
/* 102:    */     
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:    */ 
/* 107:    */ 
/* 108:108 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 805, 32767)));
/* 109:    */   }
/* 110:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.AdministracionProductos
 * JD-Core Version:    0.7.0.1
 */