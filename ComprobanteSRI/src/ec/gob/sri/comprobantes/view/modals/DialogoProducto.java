/*   1:    */ package ec.gob.sri.comprobantes.view.modals;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ImpuestoValor;
/*   5:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   6:    */ import ec.gob.sri.comprobantes.view.formas.ProductoView;
/*   7:    */ import java.awt.Container;
/*   8:    */ import java.awt.EventQueue;
/*   9:    */ import java.awt.Frame;
/*  10:    */ import java.awt.event.WindowAdapter;
/*  11:    */ import java.awt.event.WindowEvent;
/*  12:    */ import java.util.List;
/*  13:    */ import java.util.logging.Level;
/*  14:    */ import java.util.logging.Logger;
/*  15:    */ import javax.swing.GroupLayout;
/*  16:    */ import javax.swing.GroupLayout.Alignment;
/*  17:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  18:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  19:    */ import javax.swing.JDialog;
/*  20:    */ import javax.swing.JFrame;
/*  21:    */ import javax.swing.JScrollPane;
/*  22:    */ import javax.swing.UIManager;
/*  23:    */ import javax.swing.UIManager.LookAndFeelInfo;
/*  24:    */ import javax.swing.UnsupportedLookAndFeelException;
/*  25:    */ import org.jdesktop.application.Application;
/*  26:    */ import org.jdesktop.application.ApplicationContext;
/*  27:    */ import org.jdesktop.application.ResourceMap;
/*  28:    */ 
/*  29:    */ public class DialogoProducto
/*  30:    */   extends JDialog
/*  31:    */ {
/*  32:    */   Producto produto;
/*  33:    */   List<ImpuestoValor> listIVA;
/*  34:    */   List<ImpuestoValor> listICE;
/*  35:    */   private JScrollPane jScrollPane1;
/*  36:    */   private ProductoView productoView1;
/*  37:    */   
/*  38:    */   public DialogoProducto(Frame parent, boolean modal)
/*  39:    */   {
/*  40: 27 */     super(parent, modal);
/*  41: 28 */     initComponents();
/*  42:    */   }
/*  43:    */   
/*  44:    */   public DialogoProducto(Frame parent, boolean modal, Producto produto)
/*  45:    */   {
/*  46: 31 */     super(parent, modal);
/*  47: 32 */     this.produto = produto;
/*  48: 33 */     InitComponentsParameters();
/*  49:    */   }
/*  50:    */   
/*  51:    */   private void InitComponentsParameters()
/*  52:    */   {
/*  53: 38 */     this.productoView1 = new ProductoView(this.produto);
/*  54: 39 */     setDefaultCloseOperation(2);
/*  55: 40 */     setName("Form");
/*  56: 41 */     this.productoView1.setName("productoView1");
/*  57: 42 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  58: 43 */     getContentPane().setLayout(layout);
/*  59: 44 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.productoView1, -2, -1, -2).addContainerGap(-1, 32767)));
/*  60:    */     
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64:    */ 
/*  65:    */ 
/*  66: 51 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(25, 32767).addComponent(this.productoView1, -2, 667, -2).addContainerGap()));
/*  67:    */     
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71:    */ 
/*  72:    */ 
/*  73:    */ 
/*  74: 59 */     pack();
/*  75:    */   }
/*  76:    */   
/*  77:    */   private void initComponents()
/*  78:    */   {
/*  79: 70 */     this.jScrollPane1 = new JScrollPane();
/*  80: 71 */     this.productoView1 = new ProductoView();
/*  81:    */     
/*  82: 73 */     setDefaultCloseOperation(2);
/*  83: 74 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(DialogoProducto.class);
/*  84: 75 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  85: 76 */     setName("Form");
/*  86:    */     
/*  87: 78 */     this.jScrollPane1.setName("jScrollPane1");
/*  88:    */     
/*  89: 80 */     this.productoView1.setAutoscrolls(true);
/*  90: 81 */     this.productoView1.setName("productoView1");
/*  91: 82 */     this.jScrollPane1.setViewportView(this.productoView1);
/*  92:    */     
/*  93: 84 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  94: 85 */     getContentPane().setLayout(layout);
/*  95: 86 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 901, 32767)));
/*  96:    */     
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101: 92 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 739, -2).addContainerGap(-1, 32767)));
/* 102:    */     
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:    */ 
/* 107:    */ 
/* 108:    */ 
/* 109:100 */     pack();
/* 110:    */   }
/* 111:    */   
/* 112:    */   public static void main(String[] args)
/* 113:    */   {
/* 114:    */     try
/* 115:    */     {
/* 116:113 */       for (UIManager.LookAndFeelInfo info : ) {
/* 117:114 */         if ("Nimbus".equals(info.getName()))
/* 118:    */         {
/* 119:115 */           UIManager.setLookAndFeel(info.getClassName());
/* 120:116 */           break;
/* 121:    */         }
/* 122:    */       }
/* 123:    */     }
/* 124:    */     catch (ClassNotFoundException ex)
/* 125:    */     {
/* 126:120 */       Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 127:    */     }
/* 128:    */     catch (InstantiationException ex)
/* 129:    */     {
/* 130:122 */       Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 131:    */     }
/* 132:    */     catch (IllegalAccessException ex)
/* 133:    */     {
/* 134:124 */       Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 135:    */     }
/* 136:    */     catch (UnsupportedLookAndFeelException ex)
/* 137:    */     {
/* 138:126 */       Logger.getLogger(DialogoProducto.class.getName()).log(Level.SEVERE, null, ex);
/* 139:    */     }
/* 140:131 */     EventQueue.invokeLater(new Runnable()
/* 141:    */     {
/* 142:    */       public void run()
/* 143:    */       {
/* 144:135 */         DialogoProducto dialog = new DialogoProducto(new JFrame(), true);
/* 145:136 */         dialog.addWindowListener(new WindowAdapter()
/* 146:    */         {
/* 147:    */           public void windowClosing(WindowEvent e)
/* 148:    */           {
/* 149:140 */             System.exit(0);
/* 150:    */           }
/* 151:142 */         });
/* 152:143 */         dialog.setVisible(true);
/* 153:    */       }
/* 154:    */     });
/* 155:    */   }
/* 156:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.modals.DialogoProducto
 * JD-Core Version:    0.7.0.1
 */