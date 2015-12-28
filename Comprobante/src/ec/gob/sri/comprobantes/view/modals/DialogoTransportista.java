/*   1:    */ package ec.gob.sri.comprobantes.view.modals;
/*   2:    */ 
/*   3:    */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*   4:    */ import ec.gob.sri.comprobantes.view.formas.TransportistaView;
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
/*  22:    */ public class DialogoTransportista
/*  23:    */   extends JDialog
/*  24:    */ {
/*  25:    */   Transportista transportista;
/*  26:    */   private TransportistaView transportistaView1;
/*  27:    */   
/*  28:    */   public DialogoTransportista(Frame parent, boolean modal)
/*  29:    */   {
/*  30: 23 */     super(parent, modal);
/*  31: 24 */     initComponents();
/*  32:    */   }
/*  33:    */   
/*  34:    */   public DialogoTransportista(Frame parent, boolean modal, Transportista transportista)
/*  35:    */   {
/*  36: 28 */     super(parent, modal);
/*  37: 29 */     this.transportista = transportista;
/*  38: 30 */     initComponentsParameters();
/*  39:    */   }
/*  40:    */   
/*  41:    */   private void initComponentsParameters()
/*  42:    */   {
/*  43: 34 */     this.transportistaView1 = new TransportistaView(this.transportista);
/*  44: 35 */     setDefaultCloseOperation(2);
/*  45: 36 */     setName("Form");
/*  46: 37 */     this.transportistaView1.setName("transportistaView1");
/*  47: 38 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  48: 39 */     getContentPane().setLayout(layout);
/*  49: 40 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.transportistaView1, -2, -1, -2).addContainerGap(-1, 32767)));
/*  50:    */     
/*  51:    */ 
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55: 46 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.transportistaView1, -2, 267, -2).addContainerGap(21, 32767)));
/*  56:    */     
/*  57:    */ 
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61: 52 */     pack();
/*  62:    */   }
/*  63:    */   
/*  64:    */   private void initComponents()
/*  65:    */   {
/*  66: 64 */     this.transportistaView1 = new TransportistaView();
/*  67:    */     
/*  68: 66 */     setDefaultCloseOperation(2);
/*  69: 67 */     setName("Form");
/*  70:    */     
/*  71: 69 */     this.transportistaView1.setName("transportistaView1");
/*  72:    */     
/*  73: 71 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  74: 72 */     getContentPane().setLayout(layout);
/*  75: 73 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.transportistaView1, -2, -1, -2).addContainerGap(-1, 32767)));
/*  76:    */     
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82: 80 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.transportistaView1, -2, 267, -2).addContainerGap(-1, 32767)));
/*  83:    */     
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:    */ 
/*  89:    */ 
/*  90: 88 */     pack();
/*  91:    */   }
/*  92:    */   
/*  93:    */   public static void main(String[] args)
/*  94:    */   {
/*  95:    */     try
/*  96:    */     {
/*  97:101 */       for (UIManager.LookAndFeelInfo info : ) {
/*  98:102 */         if ("Nimbus".equals(info.getName()))
/*  99:    */         {
/* 100:103 */           UIManager.setLookAndFeel(info.getClassName());
/* 101:104 */           break;
/* 102:    */         }
/* 103:    */       }
/* 104:    */     }
/* 105:    */     catch (ClassNotFoundException ex)
/* 106:    */     {
/* 107:108 */       Logger.getLogger(DialogoTransportista.class.getName()).log(Level.SEVERE, null, ex);
/* 108:    */     }
/* 109:    */     catch (InstantiationException ex)
/* 110:    */     {
/* 111:110 */       Logger.getLogger(DialogoTransportista.class.getName()).log(Level.SEVERE, null, ex);
/* 112:    */     }
/* 113:    */     catch (IllegalAccessException ex)
/* 114:    */     {
/* 115:112 */       Logger.getLogger(DialogoTransportista.class.getName()).log(Level.SEVERE, null, ex);
/* 116:    */     }
/* 117:    */     catch (UnsupportedLookAndFeelException ex)
/* 118:    */     {
/* 119:114 */       Logger.getLogger(DialogoTransportista.class.getName()).log(Level.SEVERE, null, ex);
/* 120:    */     }
/* 121:119 */     EventQueue.invokeLater(new Runnable()
/* 122:    */     {
/* 123:    */       public void run()
/* 124:    */       {
/* 125:121 */         DialogoTransportista dialog = new DialogoTransportista(new JFrame(), true);
/* 126:122 */         dialog.addWindowListener(new WindowAdapter()
/* 127:    */         {
/* 128:    */           public void windowClosing(WindowEvent e)
/* 129:    */           {
/* 130:125 */             System.exit(0);
/* 131:    */           }
/* 132:127 */         });
/* 133:128 */         dialog.setVisible(true);
/* 134:    */       }
/* 135:    */     });
/* 136:    */   }
/* 137:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.modals.DialogoTransportista
 * JD-Core Version:    0.7.0.1
 */