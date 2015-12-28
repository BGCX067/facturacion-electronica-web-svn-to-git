/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.ClaveContingencia;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ClavesSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.Constantes;
/*   7:    */ import ec.gob.sri.comprobantes.util.SiNoEnum;
/*   8:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*   9:    */ import java.awt.event.ActionEvent;
/*  10:    */ import java.awt.event.ActionListener;
/*  11:    */ import java.io.BufferedReader;
/*  12:    */ import java.io.File;
/*  13:    */ import java.io.FileNotFoundException;
/*  14:    */ import java.io.FileReader;
/*  15:    */ import java.io.IOException;
/*  16:    */ import java.sql.SQLException;
/*  17:    */ import java.util.ArrayList;
/*  18:    */ import java.util.HashMap;
/*  19:    */ import java.util.List;
/*  20:    */ import java.util.Set;
/*  21:    */ import java.util.logging.Level;
/*  22:    */ import java.util.logging.Logger;
/*  23:    */ import javax.swing.BorderFactory;
/*  24:    */ import javax.swing.GroupLayout;
/*  25:    */ import javax.swing.GroupLayout.Alignment;
/*  26:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  27:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  28:    */ import javax.swing.JButton;
/*  29:    */ import javax.swing.JFileChooser;
/*  30:    */ import javax.swing.JLabel;
/*  31:    */ import javax.swing.JOptionPane;
/*  32:    */ import javax.swing.JPanel;
/*  33:    */ import javax.swing.JTextField;
/*  34:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  35:    */ import javax.swing.border.SoftBevelBorder;
/*  36:    */ import org.jdesktop.application.Application;
/*  37:    */ import org.jdesktop.application.ApplicationContext;
/*  38:    */ import org.jdesktop.application.ResourceMap;
/*  39:    */ 
/*  40:    */ public class ClavesContingenciaView
/*  41:    */   extends JPanel
/*  42:    */ {
/*  43:    */   private static final String ERROR_MESSAGE = "Error";
/*  44:    */   private HashMap<Integer, String> mapaError;
/*  45:    */   private List<ClaveContingencia> clavesList;
/*  46:    */   private JButton btnCargar;
/*  47:    */   private JButton btnExaminar;
/*  48:    */   private JPanel jPanel1;
/*  49:    */   private JLabel lblClaves;
/*  50:    */   private JTextField txtUrlClaves;
/*  51:    */   
/*  52:    */   public ClavesContingenciaView()
/*  53:    */   {
/*  54: 31 */     initComponents();
/*  55:    */   }
/*  56:    */   
/*  57:    */   private void initComponents()
/*  58:    */   {
/*  59: 44 */     this.lblClaves = new JLabel();
/*  60: 45 */     this.txtUrlClaves = new JTextField();
/*  61: 46 */     this.btnExaminar = new JButton();
/*  62: 47 */     this.jPanel1 = new JPanel();
/*  63: 48 */     this.btnCargar = new JButton();
/*  64:    */     
/*  65: 50 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(ClavesContingenciaView.class);
/*  66: 51 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/*  67: 52 */     setName("Form");
/*  68:    */     
/*  69: 54 */     this.lblClaves.setText(resourceMap.getString("lblClaves.text", new Object[0]));
/*  70: 55 */     this.lblClaves.setName("lblClaves");
/*  71:    */     
/*  72: 57 */     this.txtUrlClaves.setText(resourceMap.getString("txtUrlClaves.text", new Object[0]));
/*  73: 58 */     this.txtUrlClaves.setEnabled(false);
/*  74: 59 */     this.txtUrlClaves.setName("txtUrlClaves");
/*  75:    */     
/*  76: 61 */     this.btnExaminar.setText(resourceMap.getString("btnExaminar.text", new Object[0]));
/*  77: 62 */     this.btnExaminar.setName("btnExaminar");
/*  78: 63 */     this.btnExaminar.addActionListener(new ActionListener()
/*  79:    */     {
/*  80:    */       public void actionPerformed(ActionEvent evt)
/*  81:    */       {
/*  82: 65 */         ClavesContingenciaView.this.btnExaminarActionPerformed(evt);
/*  83:    */       }
/*  84: 68 */     });
/*  85: 69 */     this.jPanel1.setBackground(resourceMap.getColor("jPanel1.background"));
/*  86: 70 */     this.jPanel1.setBorder(new SoftBevelBorder(0));
/*  87: 71 */     this.jPanel1.setName("jPanel1");
/*  88:    */     
/*  89: 73 */     this.btnCargar.setText(resourceMap.getString("btnCargar.text", new Object[0]));
/*  90: 74 */     this.btnCargar.setName("btnCargar");
/*  91: 75 */     this.btnCargar.addActionListener(new ActionListener()
/*  92:    */     {
/*  93:    */       public void actionPerformed(ActionEvent evt)
/*  94:    */       {
/*  95: 77 */         ClavesContingenciaView.this.btnCargarActionPerformed(evt);
/*  96:    */       }
/*  97: 80 */     });
/*  98: 81 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  99: 82 */     this.jPanel1.setLayout(jPanel1Layout);
/* 100: 83 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(244, 32767).addComponent(this.btnCargar)));
/* 101:    */     
/* 102:    */ 
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106: 89 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(14, 32767).addComponent(this.btnCargar).addContainerGap()));
/* 107:    */     
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114: 97 */     GroupLayout layout = new GroupLayout(this);
/* 115: 98 */     setLayout(layout);
/* 116: 99 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblClaves).addGap(18, 18, 18).addComponent(this.txtUrlClaves, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnExaminar)).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
/* 117:    */     
/* 118:    */ 
/* 119:    */ 
/* 120:    */ 
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:    */ 
/* 125:    */ 
/* 126:    */ 
/* 127:    */ 
/* 128:    */ 
/* 129:    */ 
/* 130:113 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblClaves).addComponent(this.txtUrlClaves, -2, -1, -2).addComponent(this.btnExaminar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
/* 131:    */   }
/* 132:    */   
/* 133:    */   private void btnExaminarActionPerformed(ActionEvent evt)
/* 134:    */   {
/* 135:129 */     evt.getID();
/* 136:130 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserTxt();
/* 137:131 */     if (jfc.getSelectedFile() != null) {
/* 138:132 */       this.txtUrlClaves.setText(jfc.getSelectedFile().getPath());
/* 139:    */     }
/* 140:    */   }
/* 141:    */   
/* 142:    */   private String getuniqueConstraintViolado(String mensaje)
/* 143:    */   {
/* 144:136 */     if (mensaje.contains("UNIQUE_CLAVE")) {
/* 145:137 */       return "Las Claves ya se encuentran registradas ";
/* 146:    */     }
/* 147:139 */     return mensaje;
/* 148:    */   }
/* 149:    */   
/* 150:    */   private void btnCargarActionPerformed(ActionEvent evt)
/* 151:    */   {
/* 152:143 */     evt.getID();
/* 153:144 */     if ((this.txtUrlClaves != null) && (!this.txtUrlClaves.getText().isEmpty())) {
/* 154:    */       try
/* 155:    */       {
/* 156:146 */         validarArchivo();
/* 157:147 */         if ((this.mapaError == null) || (this.mapaError.isEmpty()))
/* 158:    */         {
/* 159:148 */           ClavesSQL claveSQL = new ClavesSQL();
/* 160:149 */           claveSQL.insertarClaves(getClavesList());
/* 161:150 */           JOptionPane.showMessageDialog(this, "Se cargaron exitosamente las claves", "Información", 2);
/* 162:    */         }
/* 163:    */         else
/* 164:    */         {
/* 165:152 */           JOptionPane.showMessageDialog(this, mensajesError(), "Error", 0);
/* 166:    */         }
/* 167:    */       }
/* 168:    */       catch (IOException ex)
/* 169:    */       {
/* 170:155 */         JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 171:    */       }
/* 172:    */       catch (SQLException ex)
/* 173:    */       {
/* 174:157 */         JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 175:    */       }
/* 176:    */       catch (ClassNotFoundException ex)
/* 177:    */       {
/* 178:159 */         JOptionPane.showMessageDialog(this, getuniqueConstraintViolado(ex.getMessage()), "Error", 0);
/* 179:    */       }
/* 180:    */     } else {
/* 181:162 */       JOptionPane.showMessageDialog(this, "Debe Seleccionar un archivo de claves ", "Advertencia", 2);
/* 182:    */     }
/* 183:    */   }
/* 184:    */   
/* 185:    */   private String mensajesError()
/* 186:    */   {
/* 187:167 */     String error = "";
/* 188:168 */     if ((this.mapaError != null) && (!this.mapaError.isEmpty()))
/* 189:    */     {
/* 190:169 */       Set<Integer> keys = this.mapaError.keySet();
/* 191:170 */       for (Object key : keys) {
/* 192:171 */         error = error + (String)this.mapaError.get(key);
/* 193:    */       }
/* 194:    */     }
/* 195:174 */     return error;
/* 196:    */   }
/* 197:    */   
/* 198:    */   private HashMap<Integer, String> validarArchivo()
/* 199:    */     throws IOException
/* 200:    */   {
/* 201:177 */     this.mapaError = new HashMap();
/* 202:178 */     List<ClaveContingencia> list = new ArrayList();
/* 203:179 */     BufferedReader entrada = null;
/* 204:    */     try
/* 205:    */     {
/* 206:181 */       File f = new File(this.txtUrlClaves.getText());
/* 207:182 */       entrada = new BufferedReader(new FileReader(f));
/* 208:183 */       if ((f.exists()) && (f.length() > 0L))
/* 209:    */       {
/* 210:185 */         int i = 1;
/* 211:    */         String lineaClave;
/* 212:186 */         while ((lineaClave = entrada.readLine()) != null)
/* 213:    */         {
/* 214:187 */           if (lineaClave.length() != Constantes.LONGITUD_CLAVE_CONTINGENCIA.intValue()) {
/* 215:188 */             this.mapaError.put(Integer.valueOf(i), "Error en la línea " + i + " no cumple con el formato de clave\n");
/* 216:    */           } else {
/* 217:190 */             list.add(getClaveContingencia(lineaClave));
/* 218:    */           }
/* 219:192 */           i++;
/* 220:    */         }
/* 221:194 */         setClavesList(list);
/* 222:    */       }
/* 223:    */     }
/* 224:    */     catch (FileNotFoundException ex)
/* 225:    */     {
/* 226:197 */       Logger.getLogger(ClavesContingenciaView.class.getName()).log(Level.SEVERE, null, ex);
/* 227:    */     }
/* 228:    */     finally
/* 229:    */     {
/* 230:199 */       if (entrada != null) {
/* 231:200 */         entrada.close();
/* 232:    */       }
/* 233:    */     }
/* 234:203 */     return this.mapaError;
/* 235:    */   }
/* 236:    */   
/* 237:    */   private ClaveContingencia getClaveContingencia(String lineaClave)
/* 238:    */     throws IOException
/* 239:    */   {
/* 240:207 */     ClaveContingencia cc = new ClaveContingencia();
/* 241:208 */     cc.setClave(lineaClave);
/* 242:209 */     cc.setUsada(SiNoEnum.NO.getCode());
/* 243:210 */     return cc;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public List<ClaveContingencia> getClavesList()
/* 247:    */   {
/* 248:217 */     return this.clavesList;
/* 249:    */   }
/* 250:    */   
/* 251:    */   public void setClavesList(List<ClaveContingencia> clavesList)
/* 252:    */   {
/* 253:224 */     this.clavesList = clavesList;
/* 254:    */   }
/* 255:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.ClavesContingenciaView
 * JD-Core Version:    0.7.0.1
 */