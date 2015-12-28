/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ConfiguracionDirectorio;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ConfiguracionDirectorioSQL;
/*   6:    */ import ec.gob.sri.comprobantes.table.model.VisualizacionTableModel;
/*   7:    */ import ec.gob.sri.comprobantes.table.model.VisualizadorEditor;
/*   8:    */ import ec.gob.sri.comprobantes.table.model.VisualizadorRender;
/*   9:    */ import ec.gob.sri.comprobantes.util.DirectorioEnum;
/*  10:    */ import java.awt.event.ActionEvent;
/*  11:    */ import java.awt.event.ActionListener;
/*  12:    */ import java.io.File;
/*  13:    */ import java.sql.SQLException;
/*  14:    */ import java.util.logging.Level;
/*  15:    */ import java.util.logging.Logger;
/*  16:    */ import javax.swing.BorderFactory;
/*  17:    */ import javax.swing.ButtonGroup;
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
/*  28:    */ import javax.swing.JRadioButton;
/*  29:    */ import javax.swing.JScrollPane;
/*  30:    */ import javax.swing.JTable;
/*  31:    */ import javax.swing.JTextField;
/*  32:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  33:    */ import javax.swing.table.DefaultTableModel;
/*  34:    */ import javax.swing.table.TableColumn;
/*  35:    */ import javax.swing.table.TableColumnModel;
/*  36:    */ import org.jdesktop.application.Application;
/*  37:    */ import org.jdesktop.application.ApplicationContext;
/*  38:    */ import org.jdesktop.application.ResourceMap;
/*  39:    */ 
/*  40:    */ public class VisualizacionRIDE
/*  41:    */   extends JPanel
/*  42:    */ {
/*  43:    */   private ButtonGroup btGrpOptions;
/*  44:    */   private JButton jButton1;
/*  45:    */   private JButton jButton2;
/*  46:    */   private JPanel jPanel1;
/*  47:    */   private JPanel jPanel2;
/*  48:    */   private JRadioButton jRadioButton1;
/*  49:    */   private JScrollPane jScrollPane1;
/*  50:    */   private JLabel lblDirectorioDefecto;
/*  51:    */   private JRadioButton rbtnDirDefecto;
/*  52:    */   private JTable tblArchivos;
/*  53:    */   private JTextField txtDirectorio;
/*  54:    */   
/*  55:    */   public VisualizacionRIDE()
/*  56:    */   {
/*  57: 36 */     initComponents();
/*  58: 37 */     cargarDirectorioPorDefecto();
/*  59: 38 */     this.tblArchivos.setVisible(false);
/*  60:    */   }
/*  61:    */   
/*  62:    */   private Boolean cargarDirectorioPorDefecto()
/*  63:    */   {
/*  64:    */     try
/*  65:    */     {
/*  66: 43 */       ConfiguracionDirectorio dir = new ConfiguracionDirectorioSQL().obtenerDirectorio(DirectorioEnum.AUTORIZADOS.getCode());
/*  67: 44 */       if (dir != null)
/*  68:    */       {
/*  69: 45 */         this.lblDirectorioDefecto.setText(dir.getPath());
/*  70: 46 */         return Boolean.valueOf(true);
/*  71:    */       }
/*  72:    */     }
/*  73:    */     catch (SQLException ex)
/*  74:    */     {
/*  75: 50 */       JOptionPane.showMessageDialog(null, "No se encuentra configurado el directorio por defecto", "Error", 500);
/*  76: 51 */       Logger.getLogger(VisualizacionRIDE.class.getName()).log(Level.SEVERE, null, ex);
/*  77:    */     }
/*  78:    */     catch (ClassNotFoundException ex)
/*  79:    */     {
/*  80: 53 */       Logger.getLogger(VisualizacionRIDE.class.getName()).log(Level.SEVERE, null, ex);
/*  81:    */     }
/*  82: 55 */     return Boolean.valueOf(false);
/*  83:    */   }
/*  84:    */   
/*  85:    */   private void cargarTablaArchivos()
/*  86:    */   {
/*  87: 59 */     Boolean existe = cargarDirectorioPorDefecto();
/*  88:    */     
/*  89: 61 */     File directorio = null;
/*  90: 62 */     if (this.txtDirectorio.getText().isEmpty())
/*  91:    */     {
/*  92: 63 */       if (existe.booleanValue() == true) {
/*  93: 64 */         directorio = new File(this.lblDirectorioDefecto.getText());
/*  94:    */       } else {
/*  95: 66 */         JOptionPane.showMessageDialog(this, "No se encuentra configurado el directorio de comprobantes autorizados", "Error", 0);
/*  96:    */       }
/*  97:    */     }
/*  98:    */     else {
/*  99: 69 */       directorio = new File(this.txtDirectorio.getText());
/* 100:    */     }
/* 101: 71 */     VisualizacionTableModel modelListaArchivos = new VisualizacionTableModel(directorio);
/* 102: 72 */     this.tblArchivos.setAutoResizeMode(0);
/* 103: 73 */     this.tblArchivos.setModel(modelListaArchivos);
/* 104: 74 */     TableColumn tc = this.tblArchivos.getColumnModel().getColumn(3);
/* 105: 75 */     tc.setCellEditor(new VisualizadorEditor(this.tblArchivos, directorio));
/* 106: 76 */     tc.setCellRenderer(new VisualizadorRender(true));
/* 107: 77 */     tc.setWidth(15);
/* 108: 78 */     this.tblArchivos.setVisible(true);
/* 109: 79 */     setColumnDimwentiosn();
/* 110:    */   }
/* 111:    */   
/* 112:    */   private void setColumnDimwentiosn()
/* 113:    */   {
/* 114: 83 */     for (int i = 0; i < this.tblArchivos.getColumnModel().getColumnCount(); i++)
/* 115:    */     {
/* 116: 84 */       TableColumn column = this.tblArchivos.getColumnModel().getColumn(i);
/* 117: 85 */       if (i == 4) {
/* 118: 86 */         column.setPreferredWidth(70);
/* 119:    */       }
/* 120:    */     }
/* 121:    */   }
/* 122:    */   
/* 123:    */   private void initComponents()
/* 124:    */   {
/* 125: 99 */     this.btGrpOptions = new ButtonGroup();
/* 126:100 */     this.jPanel1 = new JPanel();
/* 127:101 */     this.jRadioButton1 = new JRadioButton();
/* 128:102 */     this.rbtnDirDefecto = new JRadioButton();
/* 129:103 */     this.txtDirectorio = new JTextField();
/* 130:104 */     this.jButton1 = new JButton();
/* 131:105 */     this.lblDirectorioDefecto = new JLabel();
/* 132:106 */     this.jButton2 = new JButton();
/* 133:107 */     this.jPanel2 = new JPanel();
/* 134:108 */     this.jScrollPane1 = new JScrollPane();
/* 135:109 */     this.tblArchivos = new JTable();
/* 136:    */     
/* 137:111 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(VisualizacionRIDE.class);
/* 138:112 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/* 139:113 */     setName("Form");
/* 140:    */     
/* 141:115 */     this.jPanel1.setName("jPanel1");
/* 142:    */     
/* 143:117 */     this.btGrpOptions.add(this.jRadioButton1);
/* 144:118 */     this.jRadioButton1.setText(resourceMap.getString("jRadioButton1.text", new Object[0]));
/* 145:119 */     this.jRadioButton1.setName("jRadioButton1");
/* 146:    */     
/* 147:121 */     this.btGrpOptions.add(this.rbtnDirDefecto);
/* 148:122 */     this.rbtnDirDefecto.setSelected(true);
/* 149:123 */     this.rbtnDirDefecto.setText(resourceMap.getString("rbtnDirDefecto.text", new Object[0]));
/* 150:124 */     this.rbtnDirDefecto.setName("rbtnDirDefecto");
/* 151:125 */     this.rbtnDirDefecto.addActionListener(new ActionListener()
/* 152:    */     {
/* 153:    */       public void actionPerformed(ActionEvent evt)
/* 154:    */       {
/* 155:127 */         VisualizacionRIDE.this.rbtnDirDefectoActionPerformed(evt);
/* 156:    */       }
/* 157:130 */     });
/* 158:131 */     this.txtDirectorio.setText(resourceMap.getString("txtDirectorio.text", new Object[0]));
/* 159:132 */     this.txtDirectorio.setName("txtDirectorio");
/* 160:    */     
/* 161:134 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/* 162:135 */     this.jButton1.setName("jButton1");
/* 163:136 */     this.jButton1.addActionListener(new ActionListener()
/* 164:    */     {
/* 165:    */       public void actionPerformed(ActionEvent evt)
/* 166:    */       {
/* 167:138 */         VisualizacionRIDE.this.jButton1ActionPerformed(evt);
/* 168:    */       }
/* 169:141 */     });
/* 170:142 */     this.lblDirectorioDefecto.setText(resourceMap.getString("lblDirectorioDefecto.text", new Object[0]));
/* 171:143 */     this.lblDirectorioDefecto.setName("lblDirectorioDefecto");
/* 172:    */     
/* 173:145 */     this.jButton2.setText(resourceMap.getString("jButton2.text", new Object[0]));
/* 174:146 */     this.jButton2.setName("jButton2");
/* 175:147 */     this.jButton2.addActionListener(new ActionListener()
/* 176:    */     {
/* 177:    */       public void actionPerformed(ActionEvent evt)
/* 178:    */       {
/* 179:149 */         VisualizacionRIDE.this.jButton2ActionPerformed(evt);
/* 180:    */       }
/* 181:152 */     });
/* 182:153 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 183:154 */     this.jPanel1.setLayout(jPanel1Layout);
/* 184:155 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton1).addComponent(this.rbtnDirDefecto)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblDirectorioDefecto, -1, 345, 32767).addComponent(this.txtDirectorio, GroupLayout.Alignment.TRAILING, -2, 345, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addContainerGap(97, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton2).addContainerGap(705, 32767)))));
/* 185:    */     
/* 186:    */ 
/* 187:    */ 
/* 188:    */ 
/* 189:    */ 
/* 190:    */ 
/* 191:    */ 
/* 192:    */ 
/* 193:    */ 
/* 194:    */ 
/* 195:    */ 
/* 196:    */ 
/* 197:    */ 
/* 198:    */ 
/* 199:    */ 
/* 200:    */ 
/* 201:    */ 
/* 202:    */ 
/* 203:    */ 
/* 204:175 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.rbtnDirDefecto).addComponent(this.lblDirectorioDefecto, -2, 22, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButton1).addComponent(this.jButton1).addComponent(this.txtDirectorio, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, 32767).addComponent(this.jButton2).addContainerGap()));
/* 205:    */     
/* 206:    */ 
/* 207:    */ 
/* 208:    */ 
/* 209:    */ 
/* 210:    */ 
/* 211:    */ 
/* 212:    */ 
/* 213:    */ 
/* 214:    */ 
/* 215:    */ 
/* 216:    */ 
/* 217:    */ 
/* 218:    */ 
/* 219:    */ 
/* 220:    */ 
/* 221:192 */     this.jPanel2.setName("jPanel2");
/* 222:    */     
/* 223:194 */     this.jScrollPane1.setName("jScrollPane1");
/* 224:    */     
/* 225:196 */     this.tblArchivos.setModel(new DefaultTableModel(new Object[][] { new Object[0], new Object[0], new Object[0], new Object[0] }, new String[0]));
/* 226:    */     
/* 227:    */ 
/* 228:    */ 
/* 229:    */ 
/* 230:    */ 
/* 231:    */ 
/* 232:    */ 
/* 233:    */ 
/* 234:    */ 
/* 235:    */ 
/* 236:207 */     this.tblArchivos.setName("tblArchivos");
/* 237:208 */     this.jScrollPane1.setViewportView(this.tblArchivos);
/* 238:    */     
/* 239:210 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 240:211 */     this.jPanel2.setLayout(jPanel2Layout);
/* 241:212 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 794, 32767).addContainerGap()));
/* 242:    */     
/* 243:    */ 
/* 244:    */ 
/* 245:    */ 
/* 246:    */ 
/* 247:    */ 
/* 248:219 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 472, 32767).addContainerGap()));
/* 249:    */     
/* 250:    */ 
/* 251:    */ 
/* 252:    */ 
/* 253:    */ 
/* 254:    */ 
/* 255:    */ 
/* 256:227 */     GroupLayout layout = new GroupLayout(this);
/* 257:228 */     setLayout(layout);
/* 258:229 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addGap(12, 12, 12)));
/* 259:    */     
/* 260:    */ 
/* 261:    */ 
/* 262:    */ 
/* 263:    */ 
/* 264:    */ 
/* 265:236 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(35, 35, 35).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
/* 266:    */   }
/* 267:    */   
/* 268:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 269:    */   {
/* 270:247 */     JDialog dialogoImagen = new JDialog();
/* 271:248 */     JFileChooser jfc = new JFileChooser();
/* 272:249 */     jfc.setFileSelectionMode(1);
/* 273:250 */     jfc.setAcceptAllFileFilterUsed(false);
/* 274:251 */     jfc.showOpenDialog(dialogoImagen);
/* 275:252 */     if (jfc.getSelectedFile() != null) {
/* 276:253 */       this.txtDirectorio.setText(jfc.getSelectedFile().getPath());
/* 277:    */     }
/* 278:    */   }
/* 279:    */   
/* 280:    */   private void jButton2ActionPerformed(ActionEvent evt)
/* 281:    */   {
/* 282:258 */     cargarTablaArchivos();
/* 283:    */   }
/* 284:    */   
/* 285:    */   private void rbtnDirDefectoActionPerformed(ActionEvent evt)
/* 286:    */   {
/* 287:262 */     this.txtDirectorio.setText(null);
/* 288:    */   }
/* 289:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.VisualizacionRIDE
 * JD-Core Version:    0.7.0.1
 */