/*  1:   */ package ec.gob.sri.comprobantes.view.formas;
/*  2:   */ 
/*  3:   */ import comprobantesdesktop.ComprobantesDesktopApp;
/*  4:   */ import javax.swing.GroupLayout;
/*  5:   */ import javax.swing.GroupLayout.Alignment;
/*  6:   */ import javax.swing.GroupLayout.ParallelGroup;
/*  7:   */ import javax.swing.GroupLayout.SequentialGroup;
/*  8:   */ import javax.swing.JLabel;
/*  9:   */ import javax.swing.JPanel;
/* 10:   */ import org.jdesktop.application.Application;
/* 11:   */ import org.jdesktop.application.ApplicationContext;
/* 12:   */ import org.jdesktop.application.ResourceMap;
/* 13:   */ 
/* 14:   */ public class AyudaProxy
/* 15:   */   extends JPanel
/* 16:   */ {
/* 17:   */   private JLabel jLabel1;
/* 18:   */   
/* 19:   */   public AyudaProxy()
/* 20:   */   {
/* 21:21 */     initComponents();
/* 22:   */   }
/* 23:   */   
/* 24:   */   private void initComponents()
/* 25:   */   {
/* 26:33 */     this.jLabel1 = new JLabel();
/* 27:   */     
/* 28:35 */     setName("Form");
/* 29:   */     
/* 30:37 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(AyudaProxy.class);
/* 31:38 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 32:39 */     this.jLabel1.setName("jLabel1");
/* 33:   */     
/* 34:41 */     GroupLayout layout = new GroupLayout(this);
/* 35:42 */     setLayout(layout);
/* 36:43 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 753, -2).addContainerGap(-1, 32767)));
/* 37:   */     
/* 38:   */ 
/* 39:   */ 
/* 40:   */ 
/* 41:   */ 
/* 42:   */ 
/* 43:50 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel1, -2, -1, -2).addContainerGap(25, 32767)));
/* 44:   */   }
/* 45:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.AyudaProxy
 * JD-Core Version:    0.7.0.1
 */