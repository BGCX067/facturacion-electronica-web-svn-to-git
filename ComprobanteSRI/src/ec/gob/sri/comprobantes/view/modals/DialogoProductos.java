/*   1:    */ package ec.gob.sri.comprobantes.view.modals;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   4:    */ import ec.gob.sri.comprobantes.view.formas.ProductosListView;
/*   5:    */ import java.awt.Container;
/*   6:    */ import java.awt.EventQueue;
/*   7:    */ import java.awt.Frame;
/*   8:    */ import java.awt.event.WindowAdapter;
/*   9:    */ import java.awt.event.WindowEvent;
/*  10:    */ import java.util.logging.Level;
/*  11:    */ import java.util.logging.Logger;
/*  12:    */ import javax.swing.GroupLayout;
/*  13:    */ import javax.swing.GroupLayout.Alignment;
/*  14:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  15:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  16:    */ import javax.swing.JDialog;
/*  17:    */ import javax.swing.JFrame;
/*  18:    */ import javax.swing.UIManager;
/*  19:    */ import javax.swing.UIManager.LookAndFeelInfo;
/*  20:    */ import javax.swing.UnsupportedLookAndFeelException;
/*  21:    */ 
/*  22:    */ public class DialogoProductos
/*  23:    */   extends JDialog
/*  24:    */ {
/*  25:    */   private Producto producto;
/*  26:    */   private ProductosListView productosListView1;
/*  27:    */   
/*  28:    */   public DialogoProductos(Frame parent, boolean modal)
/*  29:    */   {
/*  30: 27 */     super(parent, modal);
/*  31: 28 */     initComponents();
/*  32:    */   }
/*  33:    */   
/*  34:    */   private void initComponents()
/*  35:    */   {
/*  36: 40 */     this.productosListView1 = new ProductosListView();
/*  37:    */     
/*  38: 42 */     setDefaultCloseOperation(2);
/*  39: 43 */     setName("Form");
/*  40:    */     
/*  41: 45 */     this.productosListView1.setName("productosListView1");
/*  42:    */     
/*  43: 47 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  44: 48 */     getContentPane().setLayout(layout);
/*  45: 49 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.productosListView1, -2, -1, -2).addContainerGap(-1, 32767)));
/*  46:    */     
/*  47:    */ 
/*  48:    */ 
/*  49:    */ 
/*  50:    */ 
/*  51:    */ 
/*  52: 56 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.productosListView1, -2, -1, -2).addContainerGap()));
/*  53:    */     
/*  54:    */ 
/*  55:    */ 
/*  56:    */ 
/*  57:    */ 
/*  58:    */ 
/*  59:    */ 
/*  60: 64 */     pack();
/*  61:    */   }
/*  62:    */   
/*  63:    */   public static void main(String[] args)
/*  64:    */   {
/*  65:    */     try
/*  66:    */     {
/*  67: 77 */       for (UIManager.LookAndFeelInfo info : ) {
/*  68: 78 */         if ("Nimbus".equals(info.getName()))
/*  69:    */         {
/*  70: 79 */           UIManager.setLookAndFeel(info.getClassName());
/*  71: 80 */           break;
/*  72:    */         }
/*  73:    */       }
/*  74:    */     }
/*  75:    */     catch (ClassNotFoundException ex)
/*  76:    */     {
/*  77: 84 */       Logger.getLogger(DialogoProductos.class.getName()).log(Level.SEVERE, null, ex);
/*  78:    */     }
/*  79:    */     catch (InstantiationException ex)
/*  80:    */     {
/*  81: 86 */       Logger.getLogger(DialogoProductos.class.getName()).log(Level.SEVERE, null, ex);
/*  82:    */     }
/*  83:    */     catch (IllegalAccessException ex)
/*  84:    */     {
/*  85: 88 */       Logger.getLogger(DialogoProductos.class.getName()).log(Level.SEVERE, null, ex);
/*  86:    */     }
/*  87:    */     catch (UnsupportedLookAndFeelException ex)
/*  88:    */     {
/*  89: 90 */       Logger.getLogger(DialogoProductos.class.getName()).log(Level.SEVERE, null, ex);
/*  90:    */     }
/*  91: 95 */     EventQueue.invokeLater(new Runnable()
/*  92:    */     {
/*  93:    */       public void run()
/*  94:    */       {
/*  95: 98 */         DialogoProductos dialog = new DialogoProductos(new JFrame(), true);
/*  96: 99 */         dialog.addWindowListener(new WindowAdapter()
/*  97:    */         {
/*  98:    */           public void windowClosing(WindowEvent e)
/*  99:    */           {
/* 100:103 */             System.exit(0);
/* 101:    */           }
/* 102:105 */         });
/* 103:106 */         dialog.setVisible(true);
/* 104:    */       }
/* 105:    */     });
/* 106:    */   }
/* 107:    */   
/* 108:    */   public Producto getProducto()
/* 109:    */   {
/* 110:115 */     return this.producto;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setProducto(Producto producto)
/* 114:    */   {
/* 115:119 */     this.producto = producto;
/* 116:    */   }
/* 117:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.modals.DialogoProductos
 * JD-Core Version:    0.7.0.1
 */