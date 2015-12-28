/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.common.comprobantes.conexion.ConexionBD;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionBDSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*   7:    */ import java.awt.event.ActionEvent;
/*   8:    */ import java.awt.event.ActionListener;
/*   9:    */ import java.io.File;
/*  10:    */ import java.io.FileNotFoundException;
/*  11:    */ import java.io.FileOutputStream;
/*  12:    */ import java.io.IOException;
/*  13:    */ import java.sql.SQLException;
/*  14:    */ import java.util.Properties;
/*  15:    */ import java.util.logging.Level;
/*  16:    */ import java.util.logging.Logger;
/*  17:    */ import javax.swing.BorderFactory;
/*  18:    */ import javax.swing.GroupLayout;
/*  19:    */ import javax.swing.GroupLayout.Alignment;
/*  20:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  21:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  22:    */ import javax.swing.JButton;
/*  23:    */ import javax.swing.JDialog;
/*  24:    */ import javax.swing.JFileChooser;
/*  25:    */ import javax.swing.JLabel;
/*  26:    */ import javax.swing.JOptionPane;
/*  27:    */ import javax.swing.JPanel;
/*  28:    */ import javax.swing.JTextField;
/*  29:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  30:    */ import javax.swing.border.SoftBevelBorder;
/*  31:    */ import org.jdesktop.application.Application;
/*  32:    */ import org.jdesktop.application.ApplicationContext;
/*  33:    */ import org.jdesktop.application.ResourceMap;
/*  34:    */ 
/*  35:    */ public class ConfiguracionBD
/*  36:    */   extends JPanel
/*  37:    */ {
/*  38: 24 */   ConexionBD cbd = new ConexionBD();
/*  39:    */   private JButton btnActualizarBD;
/*  40:    */   private JButton btnCambiarBD;
/*  41:    */   private JButton btnCrearBD;
/*  42:    */   private JButton btnExaminar;
/*  43:    */   private JPanel jPanel1;
/*  44:    */   private JLabel lblUrlDB;
/*  45:    */   private JTextField txtUrlBaseDatos;
/*  46:    */   
/*  47:    */   public ConfiguracionBD()
/*  48:    */   {
/*  49: 28 */     initComponents();
/*  50: 29 */     loadBdConfiguracion();
/*  51:    */   }
/*  52:    */   
/*  53:    */   private void loadBdConfiguracion()
/*  54:    */   {
/*  55: 33 */     ConfiguracionBDSQL sqlDB = new ConfiguracionBDSQL();
/*  56:    */     try
/*  57:    */     {
/*  58: 35 */       String direccionBD = sqlDB.getConfiguracionBD();
/*  59: 36 */       if (direccionBD != null) {
/*  60: 37 */         this.txtUrlBaseDatos.setText(direccionBD);
/*  61:    */       }
/*  62:    */     }
/*  63:    */     catch (SQLException ex)
/*  64:    */     {
/*  65: 40 */       Logger.getLogger(ConfiguracionBD.class.getName()).log(Level.SEVERE, null, ex);
/*  66:    */     }
/*  67:    */     catch (ClassNotFoundException ex)
/*  68:    */     {
/*  69: 42 */       Logger.getLogger(ConfiguracionBD.class.getName()).log(Level.SEVERE, null, ex);
/*  70:    */     }
/*  71:    */   }
/*  72:    */   
/*  73:    */   private void initComponents()
/*  74:    */   {
/*  75: 55 */     this.lblUrlDB = new JLabel();
/*  76: 56 */     this.txtUrlBaseDatos = new JTextField();
/*  77: 57 */     this.btnExaminar = new JButton();
/*  78: 58 */     this.jPanel1 = new JPanel();
/*  79: 59 */     this.btnCrearBD = new JButton();
/*  80: 60 */     this.btnActualizarBD = new JButton();
/*  81: 61 */     this.btnCambiarBD = new JButton();
/*  82:    */     
/*  83: 63 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ConfiguracionBD.class);
/*  84: 64 */     setBorder(BorderFactory.createTitledBorder(null, resourceMap.getString("Form.border.title", new Object[0]), 0, 0, resourceMap.getFont("Form.border.titleFont")));
/*  85: 65 */     setName("Form");
/*  86:    */     
/*  87: 67 */     this.lblUrlDB.setText(resourceMap.getString("lblUrlDB.text", new Object[0]));
/*  88: 68 */     this.lblUrlDB.setName("lblUrlDB");
/*  89:    */     
/*  90: 70 */     this.txtUrlBaseDatos.setText(resourceMap.getString("txtUrlBaseDatos.text", new Object[0]));
/*  91: 71 */     this.txtUrlBaseDatos.setDisabledTextColor(resourceMap.getColor("txtUrlBaseDatos.disabledTextColor"));
/*  92: 72 */     this.txtUrlBaseDatos.setEnabled(false);
/*  93: 73 */     this.txtUrlBaseDatos.setName("txtUrlBaseDatos");
/*  94:    */     
/*  95: 75 */     this.btnExaminar.setText(resourceMap.getString("btnExaminar.text", new Object[0]));
/*  96: 76 */     this.btnExaminar.setName("btnExaminar");
/*  97: 77 */     this.btnExaminar.addActionListener(new ActionListener()
/*  98:    */     {
/*  99:    */       public void actionPerformed(ActionEvent evt)
/* 100:    */       {
/* 101: 79 */         ConfiguracionBD.this.btnExaminarActionPerformed(evt);
/* 102:    */       }
/* 103: 82 */     });
/* 104: 83 */     this.jPanel1.setBackground(resourceMap.getColor("jPanel1.background"));
/* 105: 84 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/* 106: 85 */     this.jPanel1.setName("jPanel1");
/* 107:    */     
/* 108: 87 */     this.btnCrearBD.setText(resourceMap.getString("btnCrearBD.text", new Object[0]));
/* 109: 88 */     this.btnCrearBD.setName("btnCrearBD");
/* 110: 89 */     this.btnCrearBD.addActionListener(new ActionListener()
/* 111:    */     {
/* 112:    */       public void actionPerformed(ActionEvent evt)
/* 113:    */       {
/* 114: 91 */         ConfiguracionBD.this.btnCrearBDActionPerformed(evt);
/* 115:    */       }
/* 116: 94 */     });
/* 117: 95 */     this.btnActualizarBD.setText(resourceMap.getString("btnActualizarBD.text", new Object[0]));
/* 118: 96 */     this.btnActualizarBD.setName("btnActualizarBD");
/* 119: 97 */     this.btnActualizarBD.addActionListener(new ActionListener()
/* 120:    */     {
/* 121:    */       public void actionPerformed(ActionEvent evt)
/* 122:    */       {
/* 123: 99 */         ConfiguracionBD.this.btnActualizarBDActionPerformed(evt);
/* 124:    */       }
/* 125:102 */     });
/* 126:103 */     this.btnCambiarBD.setText(resourceMap.getString("btnSeleccionarBD.text", new Object[0]));
/* 127:104 */     this.btnCambiarBD.setName("btnSeleccionarBD");
/* 128:105 */     this.btnCambiarBD.addActionListener(new ActionListener()
/* 129:    */     {
/* 130:    */       public void actionPerformed(ActionEvent evt)
/* 131:    */       {
/* 132:107 */         ConfiguracionBD.this.btnCambiarBDActionPerformed(evt);
/* 133:    */       }
/* 134:110 */     });
/* 135:111 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 136:112 */     this.jPanel1.setLayout(jPanel1Layout);
/* 137:113 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.btnCrearBD).addGap(71, 71, 71).addComponent(this.btnCambiarBD).addGap(69, 69, 69).addComponent(this.btnActualizarBD).addContainerGap()));
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
/* 148:124 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnCrearBD).addComponent(this.btnActualizarBD).addComponent(this.btnCambiarBD)).addContainerGap(17, 32767)));
/* 149:    */     
/* 150:    */ 
/* 151:    */ 
/* 152:    */ 
/* 153:    */ 
/* 154:    */ 
/* 155:    */ 
/* 156:    */ 
/* 157:    */ 
/* 158:    */ 
/* 159:135 */     GroupLayout layout = new GroupLayout(this);
/* 160:136 */     setLayout(layout);
/* 161:137 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jPanel1, -1, 627, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.lblUrlDB, -1, 196, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtUrlBaseDatos, -1, 311, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnExaminar, -1, 112, 32767))).addGap(18, 18, 18)));
/* 162:    */     
/* 163:    */ 
/* 164:    */ 
/* 165:    */ 
/* 166:    */ 
/* 167:    */ 
/* 168:    */ 
/* 169:    */ 
/* 170:    */ 
/* 171:    */ 
/* 172:    */ 
/* 173:    */ 
/* 174:    */ 
/* 175:    */ 
/* 176:    */ 
/* 177:153 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblUrlDB).addComponent(this.txtUrlBaseDatos, -2, -1, -2).addComponent(this.btnExaminar)).addGap(26, 26, 26).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(92, 32767)));
/* 178:    */   }
/* 179:    */   
/* 180:    */   private void mostrarChooser()
/* 181:    */   {
/* 182:168 */     JDialog jd = new JDialog();
/* 183:169 */     JFileChooser jfc = new JFileChooser();
/* 184:170 */     jfc.setFileSelectionMode(1);
/* 185:171 */     jfc.showOpenDialog(jd);
/* 186:    */   }
/* 187:    */   
/* 188:    */   private void crearBaseDatos()
/* 189:    */   {
/* 190:    */     try
/* 191:    */     {
/* 192:177 */       this.cbd.crearBaseDatos(this.txtUrlBaseDatos.getText());
/* 193:178 */       crearFileConfiguracion();
/* 194:179 */       JOptionPane.showMessageDialog(this, "Se ha creado con éxito la base de Datos");
/* 195:    */     }
/* 196:    */     catch (FileNotFoundException ex)
/* 197:    */     {
/* 198:181 */       Logger.getLogger(ConfiguracionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 199:    */     }
/* 200:    */     catch (IOException ex)
/* 201:    */     {
/* 202:183 */       Logger.getLogger(ConfiguracionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 203:    */     }
/* 204:    */     catch (SQLException ex)
/* 205:    */     {
/* 206:185 */       JOptionPane.showMessageDialog(this, "Se ṕrodujo un error en la aplicación " + ex.getMessage(), "Error", 0);
/* 207:    */     }
/* 208:    */     catch (ClassNotFoundException ex)
/* 209:    */     {
/* 210:187 */       JOptionPane.showMessageDialog(this, "No se encontro el JDBC para la base de datos " + ex.getMessage(), "Error", 0);
/* 211:    */     }
/* 212:    */   }
/* 213:    */   
/* 214:    */   private void cambiarBaseDatos()
/* 215:    */   {
/* 216:    */     try
/* 217:    */     {
/* 218:193 */       this.cbd.cambiarBaseDatos(this.txtUrlBaseDatos.getText());
/* 219:194 */       crearFileConfiguracion();
/* 220:195 */       JOptionPane.showMessageDialog(this, "Se cambio con éxito la base de Datos");
/* 221:    */     }
/* 222:    */     catch (FileNotFoundException ex)
/* 223:    */     {
/* 224:197 */       Logger.getLogger(ConfiguracionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 225:    */     }
/* 226:    */     catch (IOException ex)
/* 227:    */     {
/* 228:199 */       Logger.getLogger(ConfiguracionBD.class.getName()).log(Level.SEVERE, null, ex);
/* 229:    */     }
/* 230:    */     catch (SQLException ex)
/* 231:    */     {
/* 232:201 */       JOptionPane.showMessageDialog(this, "Se ṕrodujo un error en la aplicación " + ex.getMessage(), "Error", 0);
/* 233:    */     }
/* 234:    */     catch (ClassNotFoundException ex)
/* 235:    */     {
/* 236:203 */       JOptionPane.showMessageDialog(this, "No se encontro el JDBC para la base de datos " + ex.getMessage(), "Error", 0);
/* 237:    */     }
/* 238:    */   }
/* 239:    */   
/* 240:    */   private void actualizarBaseDatos()
/* 241:    */   {
/* 242:    */     try
/* 243:    */     {
/* 244:209 */       this.cbd.actualizarBaseDatos(this.txtUrlBaseDatos.getText());
/* 245:210 */       JOptionPane.showMessageDialog(this, "Se actualizó con éxito la base de Datos");
/* 246:    */     }
/* 247:    */     catch (SQLException ex)
/* 248:    */     {
/* 249:212 */       JOptionPane.showMessageDialog(this, "Se ṕrodujo un error en la aplicación " + ex.getMessage(), "Error", 0);
/* 250:    */     }
/* 251:    */     catch (ClassNotFoundException ex)
/* 252:    */     {
/* 253:214 */       JOptionPane.showMessageDialog(this, "No se encontro el JDBC para la base de datos " + ex.getMessage(), "Error", 0);
/* 254:    */     }
/* 255:    */   }
/* 256:    */   
/* 257:    */   private void crearFileConfiguracion()
/* 258:    */     throws FileNotFoundException, IOException
/* 259:    */   {
/* 260:219 */     Properties prop = new Properties();
/* 261:220 */     prop.setProperty("database", this.txtUrlBaseDatos.getText());
/* 262:221 */     String userHome = System.getProperty("user.home");
/* 263:222 */     prop.store(new FileOutputStream(userHome + "/comprobantes.properties"), null);
/* 264:    */   }
/* 265:    */   
/* 266:    */   private void btnExaminarActionPerformed(ActionEvent evt)
/* 267:    */   {
/* 268:226 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserDirectorios();
/* 269:227 */     if (jfc.getSelectedFile() != null) {
/* 270:228 */       this.txtUrlBaseDatos.setText(jfc.getSelectedFile().getPath());
/* 271:    */     }
/* 272:    */   }
/* 273:    */   
/* 274:    */   private void btnActualizarBDActionPerformed(ActionEvent evt)
/* 275:    */   {
/* 276:234 */     if ((this.txtUrlBaseDatos == null) || (this.txtUrlBaseDatos.getText().isEmpty())) {
/* 277:235 */       JOptionPane.showMessageDialog(new JPanel(), "Debe seleccionar un directorio");
/* 278:    */     } else {
/* 279:237 */       actualizarBaseDatos();
/* 280:    */     }
/* 281:    */   }
/* 282:    */   
/* 283:    */   private void btnCambiarBDActionPerformed(ActionEvent evt)
/* 284:    */   {
/* 285:244 */     if ((this.txtUrlBaseDatos == null) || (this.txtUrlBaseDatos.getText().isEmpty())) {
/* 286:245 */       JOptionPane.showMessageDialog(new JPanel(), "Debe seleccionar un directorio");
/* 287:    */     } else {
/* 288:247 */       cambiarBaseDatos();
/* 289:    */     }
/* 290:    */   }
/* 291:    */   
/* 292:    */   private void btnCrearBDActionPerformed(ActionEvent evt)
/* 293:    */   {
/* 294:252 */     if ((this.txtUrlBaseDatos == null) || (this.txtUrlBaseDatos.getText().isEmpty())) {
/* 295:253 */       JOptionPane.showMessageDialog(new JPanel(), "Debe seleccionar un directorio");
/* 296:    */     } else {
/* 297:255 */       crearBaseDatos();
/* 298:    */     }
/* 299:    */   }
/* 300:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ConfiguracionBD
 * JD-Core Version:    0.7.0.1
 */