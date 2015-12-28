/*   1:    */ package ec.gob.sri.comprobantes.view.modals;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*   4:    */ import ec.gob.sri.comprobantes.view.formas.ClienteView;
/*   5:    */ import ec.gob.sri.comprobantes.view.formas.ClientesView;
/*   6:    */ import java.awt.Container;
/*   7:    */ import java.awt.EventQueue;
/*   8:    */ import java.awt.Frame;
/*   9:    */ import java.awt.event.WindowAdapter;
/*  10:    */ import java.awt.event.WindowEvent;
/*  11:    */ import java.util.logging.Level;
/*  12:    */ import java.util.logging.Logger;
/*  13:    */ import javax.swing.GroupLayout;
/*  14:    */ import javax.swing.GroupLayout.Alignment;
/*  15:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  16:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  17:    */ import javax.swing.JDialog;
/*  18:    */ import javax.swing.JFrame;
/*  19:    */ import javax.swing.UIManager;
/*  20:    */ import javax.swing.UIManager.LookAndFeelInfo;
/*  21:    */ import javax.swing.UnsupportedLookAndFeelException;
/*  22:    */ 
/*  23:    */ public class DialogoCliente
/*  24:    */   extends JDialog
/*  25:    */ {
/*  26:    */   Clientes c;
/*  27:    */   ClientesView clientesView;
/*  28:    */   private ClienteView clienteView1;
/*  29:    */   
/*  30:    */   public DialogoCliente(Frame parent, boolean modal)
/*  31:    */   {
/*  32: 21 */     super(parent, modal);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public DialogoCliente(Frame parent, Boolean limpiarBotones)
/*  36:    */   {
/*  37: 24 */     this(parent, true);
/*  38: 25 */     add(new ClienteView(limpiarBotones));
/*  39:    */   }
/*  40:    */   
/*  41:    */   public DialogoCliente(Frame parent, boolean modal, Clientes c)
/*  42:    */   {
/*  43: 29 */     super(parent, modal);
/*  44: 30 */     this.c = c;
/*  45: 31 */     initComponentsParameters();
/*  46:    */   }
/*  47:    */   
/*  48:    */   private void initComponentsParameters()
/*  49:    */   {
/*  50: 35 */     this.clienteView1 = new ClienteView(this.c);
/*  51: 36 */     setDefaultCloseOperation(2);
/*  52: 37 */     setName("Form");
/*  53: 38 */     this.clienteView1.setName("clienteView1");
/*  54: 39 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  55: 40 */     getContentPane().setLayout(layout);
/*  56: 41 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.clienteView1, -2, -1, -2).addContainerGap(-1, 32767)));
/*  57:    */     
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63: 48 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.clienteView1, -2, 537, -2).addContainerGap(-1, 32767)));
/*  64:    */     
/*  65:    */ 
/*  66:    */ 
/*  67:    */ 
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71: 56 */     pack();
/*  72:    */   }
/*  73:    */   
/*  74:    */   private void initComponents()
/*  75:    */   {
/*  76: 68 */     this.clienteView1 = new ClienteView();
/*  77:    */     
/*  78: 70 */     setDefaultCloseOperation(2);
/*  79: 71 */     setName("Form");
/*  80:    */     
/*  81: 73 */     this.clienteView1.setName("clienteView1");
/*  82:    */     
/*  83: 75 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  84: 76 */     getContentPane().setLayout(layout);
/*  85: 77 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.clienteView1, -2, -1, -2).addContainerGap(21, 32767)));
/*  86:    */     
/*  87:    */ 
/*  88:    */ 
/*  89:    */ 
/*  90:    */ 
/*  91:    */ 
/*  92: 84 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.clienteView1, -2, 549, -2).addContainerGap(24, 32767)));
/*  93:    */     
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99: 91 */     pack();
/* 100:    */   }
/* 101:    */   
/* 102:    */   public static void main(String[] args)
/* 103:    */   {
/* 104:    */     try
/* 105:    */     {
/* 106:104 */       for (UIManager.LookAndFeelInfo info : ) {
/* 107:105 */         if ("Nimbus".equals(info.getName()))
/* 108:    */         {
/* 109:106 */           UIManager.setLookAndFeel(info.getClassName());
/* 110:107 */           break;
/* 111:    */         }
/* 112:    */       }
/* 113:    */     }
/* 114:    */     catch (ClassNotFoundException ex)
/* 115:    */     {
/* 116:111 */       Logger.getLogger(DialogoCliente.class.getName()).log(Level.SEVERE, null, ex);
/* 117:    */     }
/* 118:    */     catch (InstantiationException ex)
/* 119:    */     {
/* 120:113 */       Logger.getLogger(DialogoCliente.class.getName()).log(Level.SEVERE, null, ex);
/* 121:    */     }
/* 122:    */     catch (IllegalAccessException ex)
/* 123:    */     {
/* 124:115 */       Logger.getLogger(DialogoCliente.class.getName()).log(Level.SEVERE, null, ex);
/* 125:    */     }
/* 126:    */     catch (UnsupportedLookAndFeelException ex)
/* 127:    */     {
/* 128:117 */       Logger.getLogger(DialogoCliente.class.getName()).log(Level.SEVERE, null, ex);
/* 129:    */     }
/* 130:122 */     EventQueue.invokeLater(new Runnable()
/* 131:    */     {
/* 132:    */       public void run()
/* 133:    */       {
/* 134:125 */         DialogoCliente dialog = new DialogoCliente(new JFrame(), true);
/* 135:126 */         dialog.addWindowListener(new WindowAdapter()
/* 136:    */         {
/* 137:    */           public void windowClosing(WindowEvent e)
/* 138:    */           {
/* 139:130 */             System.exit(0);
/* 140:    */           }
/* 141:132 */         });
/* 142:133 */         dialog.setVisible(true);
/* 143:    */       }
/* 144:    */     });
/* 145:    */   }
/* 146:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.modals.DialogoCliente
 * JD-Core Version:    0.7.0.1
 */