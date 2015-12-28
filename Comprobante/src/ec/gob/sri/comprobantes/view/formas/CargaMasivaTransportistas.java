/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Transportista;
/*   5:    */ import ec.gob.sri.comprobantes.sql.TransportistaSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.CampoModelo;
/*   7:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   8:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
/*   9:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  10:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*  11:    */ import java.awt.event.ActionEvent;
/*  12:    */ import java.awt.event.ActionListener;
/*  13:    */ import java.io.BufferedReader;
/*  14:    */ import java.io.File;
/*  15:    */ import java.io.FileNotFoundException;
/*  16:    */ import java.io.FileReader;
/*  17:    */ import java.io.IOException;
/*  18:    */ import java.io.PrintStream;
/*  19:    */ import java.util.ArrayList;
/*  20:    */ import java.util.HashMap;
/*  21:    */ import java.util.List;
/*  22:    */ import java.util.Set;
/*  23:    */ import java.util.logging.Level;
/*  24:    */ import java.util.logging.Logger;
/*  25:    */ import javax.swing.BorderFactory;
/*  26:    */ import javax.swing.GroupLayout;
/*  27:    */ import javax.swing.GroupLayout.Alignment;
/*  28:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  29:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  30:    */ import javax.swing.JButton;
/*  31:    */ import javax.swing.JFileChooser;
/*  32:    */ import javax.swing.JLabel;
/*  33:    */ import javax.swing.JOptionPane;
/*  34:    */ import javax.swing.JPanel;
/*  35:    */ import javax.swing.JTextField;
/*  36:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  37:    */ import org.jdesktop.application.Application;
/*  38:    */ import org.jdesktop.application.ApplicationContext;
/*  39:    */ import org.jdesktop.application.ResourceMap;
/*  40:    */ 
/*  41:    */ public class CargaMasivaTransportistas
/*  42:    */   extends JPanel
/*  43:    */ {
/*  44:    */   HashMap<Integer, String> mensajes;
/*  45:    */   private JButton btnCargaArchivo;
/*  46:    */   private JButton jButton1;
/*  47:    */   private JLabel jLabel1;
/*  48:    */   private JTextField txtDireccion;
/*  49:    */   
/*  50:    */   public CargaMasivaTransportistas()
/*  51:    */   {
/*  52: 45 */     initComponents();
/*  53:    */   }
/*  54:    */   
/*  55:    */   private void initComponents()
/*  56:    */   {
/*  57: 57 */     this.jLabel1 = new JLabel();
/*  58: 58 */     this.txtDireccion = new JTextField();
/*  59: 59 */     this.jButton1 = new JButton();
/*  60: 60 */     this.btnCargaArchivo = new JButton();
/*  61:    */     
/*  62: 62 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(CargaMasivaTransportistas.class);
/*  63: 63 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/*  64: 64 */     setName("Form");
/*  65:    */     
/*  66: 66 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  67: 67 */     this.jLabel1.setName("jLabel1");
/*  68:    */     
/*  69: 69 */     this.txtDireccion.setEditable(false);
/*  70: 70 */     this.txtDireccion.setText(resourceMap.getString("txtDireccion.text", new Object[0]));
/*  71: 71 */     this.txtDireccion.setEnabled(false);
/*  72: 72 */     this.txtDireccion.setName("txtDireccion");
/*  73:    */     
/*  74: 74 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/*  75: 75 */     this.jButton1.setName("jButton1");
/*  76: 76 */     this.jButton1.addActionListener(new ActionListener()
/*  77:    */     {
/*  78:    */       public void actionPerformed(ActionEvent evt)
/*  79:    */       {
/*  80: 78 */         CargaMasivaTransportistas.this.jButton1ActionPerformed(evt);
/*  81:    */       }
/*  82: 81 */     });
/*  83: 82 */     this.btnCargaArchivo.setText(resourceMap.getString("btnCargaArchivo.text", new Object[0]));
/*  84: 83 */     this.btnCargaArchivo.setName("btnCargaArchivo");
/*  85: 84 */     this.btnCargaArchivo.addActionListener(new ActionListener()
/*  86:    */     {
/*  87:    */       public void actionPerformed(ActionEvent evt)
/*  88:    */       {
/*  89: 86 */         CargaMasivaTransportistas.this.btnCargaArchivoActionPerformed(evt);
/*  90:    */       }
/*  91: 89 */     });
/*  92: 90 */     GroupLayout layout = new GroupLayout(this);
/*  93: 91 */     setLayout(layout);
/*  94: 92 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtDireccion, -1, 298, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 34, -2).addGap(18, 18, 18).addComponent(this.btnCargaArchivo).addGap(22, 22, 22)));
/*  95:    */     
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:    */ 
/* 105:    */ 
/* 106:104 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(78, 78, 78).addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel1).addComponent(this.txtDireccion, -2, -1, -2).addComponent(this.jButton1).addComponent(this.btnCargaArchivo)).addContainerGap(64, 32767)));
/* 107:    */   }
/* 108:    */   
/* 109:    */   private void jButton1ActionPerformed(ActionEvent evt)
/* 110:    */   {
/* 111:118 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserTxt();
/* 112:119 */     if (jfc.getSelectedFile() != null) {
/* 113:120 */       this.txtDireccion.setText(jfc.getSelectedFile().getPath());
/* 114:    */     }
/* 115:    */   }
/* 116:    */   
/* 117:    */   private void validarArchivo()
/* 118:    */     throws IOException
/* 119:    */   {
/* 120:125 */     List<Transportista> clienteList = new ArrayList();
/* 121:126 */     BufferedReader entrada = null;
/* 122:    */     try
/* 123:    */     {
/* 124:128 */       File f = new File(this.txtDireccion.getText());
/* 125:129 */       entrada = new BufferedReader(new FileReader(f));
/* 126:130 */       if ((f.exists()) && (f.length() > 0L))
/* 127:    */       {
/* 128:132 */         int i = 1;
/* 129:    */         String lineaClave;
/* 130:133 */         while ((lineaClave = entrada.readLine()) != null)
/* 131:    */         {
/* 132:134 */           String[] transportistas = lineaClave.split(",");
/* 133:135 */           Transportista t = obtenerTRansportista(transportistas, i);
/* 134:136 */           if (t != null) {
/* 135:137 */             clienteList.add(t);
/* 136:    */           }
/* 137:139 */           i++;
/* 138:    */         }
/* 139:    */       }
/* 140:142 */       creacionTransportistas(clienteList);
/* 141:    */     }
/* 142:    */     catch (FileNotFoundException ex)
/* 143:    */     {
/* 144:145 */       Logger.getLogger(CargaMasivaProductos.class.getName()).log(Level.SEVERE, null, ex);
/* 145:    */     }
/* 146:    */     finally
/* 147:    */     {
/* 148:147 */       if (entrada != null) {
/* 149:148 */         entrada.close();
/* 150:    */       }
/* 151:    */     }
/* 152:    */   }
/* 153:    */   
/* 154:    */   private void creacionTransportistas(List<Transportista> transList)
/* 155:    */   {
/* 156:154 */     if ((this.mensajes != null) && (!this.mensajes.isEmpty()))
/* 157:    */     {
/* 158:155 */       presentarMensajesErrorArchivo();
/* 159:    */     }
/* 160:    */     else
/* 161:    */     {
/* 162:157 */       TransportistaSQL tranasQSL = new TransportistaSQL();
/* 163:158 */       tranasQSL.crearTransportista(transList);
/* 164:159 */       JOptionPane.showMessageDialog(this, "Se crearon con éxito los transportistas", "Mensaje", 1);
/* 165:    */     }
/* 166:    */   }
/* 167:    */   
/* 168:    */   private Transportista obtenerTRansportista(String[] transportistas, int i)
/* 169:    */   {
/* 170:165 */     if ((transportistas != null) && (transportistas.length == 5))
/* 171:    */     {
/* 172:166 */       Transportista trans = new Transportista();
/* 173:167 */       trans.setRazonSocial(transportistas[0]);
/* 174:168 */       trans.setTipoIdentificacion(transportistas[1]);
/* 175:169 */       trans.setIdentificacion(transportistas[2]);
/* 176:170 */       trans.setMail(transportistas[3]);
/* 177:171 */       trans.setPlaca(transportistas[3]);
/* 178:172 */       if (validarTransportista(trans, i).booleanValue()) {
/* 179:173 */         return trans;
/* 180:    */       }
/* 181:175 */       return null;
/* 182:    */     }
/* 183:179 */     return null;
/* 184:    */   }
/* 185:    */   
/* 186:    */   private void presentarMensajesErrorArchivo()
/* 187:    */   {
/* 188:183 */     Set<Integer> keys = this.mensajes.keySet();
/* 189:184 */     String cadena = "";
/* 190:185 */     for (Integer key : keys) {
/* 191:186 */       cadena = cadena + (String)this.mensajes.get(key) + "\n";
/* 192:    */     }
/* 193:188 */     JOptionPane.showMessageDialog(this, cadena, "Error", 0);
/* 194:    */   }
/* 195:    */   
/* 196:    */   private Boolean validarTransportista(Transportista trans, int i)
/* 197:    */   {
/* 198:192 */     HashMap<Integer, String> validacion = new HashMap();
/* 199:193 */     if ((trans.getRazonSocial() == null) || (trans.getRazonSocial().isEmpty())) {
/* 200:194 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo Apellidos nombres / razón social es obligatorio");
/* 201:    */     }
/* 202:196 */     if ((trans.getTipoIdentificacion() == null) || (trans.getTipoIdentificacion().isEmpty())) {
/* 203:197 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo tipo de identificación es obligatorio");
/* 204:    */     }
/* 205:199 */     if ((trans.getIdentificacion() == null) || (trans.getIdentificacion().isEmpty())) {
/* 206:200 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El número de identificación es obligatorio");
/* 207:    */     }
/* 208:202 */     if ((trans.getMail() == null) || (trans.getMail().isEmpty())) {
/* 209:203 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo correo electrónico es obligatorio");
/* 210:    */     }
/* 211:205 */     validacion = validarLongitudes(trans, i, validacion);
/* 212:207 */     if ((validacion != null) && (!validacion.isEmpty()))
/* 213:    */     {
/* 214:208 */       this.mensajes.putAll(validacion);
/* 215:209 */       return Boolean.valueOf(false);
/* 216:    */     }
/* 217:211 */     return Boolean.valueOf(true);
/* 218:    */   }
/* 219:    */   
/* 220:    */   private HashMap<Integer, String> validarLongitudes(Transportista c, int i, HashMap<Integer, String> validacion)
/* 221:    */   {
/* 222:216 */     List<CampoModelo> listaCampos = new ArrayList();
/* 223:    */     
/* 224:218 */     listaCampos.add(obtenerCampoModelo(c.getRazonSocial(), "Razón Social", Integer.valueOf(300)));
/* 225:    */     
/* 226:220 */     String camposLongitud = ValidadorCampos.validarCampoLongitudMayor(listaCampos);
/* 227:221 */     if ((camposLongitud != null) && (!camposLongitud.isEmpty())) {
/* 228:222 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + "  " + camposLongitud);
/* 229:    */     }
/* 230:224 */     HashMap<Integer, String> validacionExpresion = validarExpresiones(c, i, validacion);
/* 231:225 */     if ((validacionExpresion != null) && (!validacionExpresion.isEmpty())) {
/* 232:226 */       validacion.putAll(validacionExpresion);
/* 233:    */     }
/* 234:228 */     return validacion;
/* 235:    */   }
/* 236:    */   
/* 237:    */   private HashMap<Integer, String> validarExpresiones(Transportista c, int i, HashMap<Integer, String> validacion)
/* 238:    */   {
/* 239:233 */     if ((c.getMail() != null) && (!c.getMail().isEmpty()) && (!StringUtil.validateEmail(c.getMail()))) {
/* 240:234 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " Dirección de correo inválida");
/* 241:    */     }
/* 242:237 */     return validarTipoClientes(c, i, validacion);
/* 243:    */   }
/* 244:    */   
/* 245:    */   private HashMap<Integer, String> validarTipoClientes(Transportista c, int i, HashMap<Integer, String> validacion)
/* 246:    */   {
/* 247:241 */     System.out.println("" + c.getTipoIdentificacion() + "  " + TipoIdentificacionEnum.C.getCode());
/* 248:242 */     if ((!c.getTipoIdentificacion().equals(TipoIdentificacionEnum.C.getCode())) && (!c.getTipoIdentificacion().equals(TipoIdentificacionEnum.R.getCode())) && (!c.getTipoIdentificacion().equals(TipoIdentificacionEnum.P.getCode()))) {
/* 249:244 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El tipo Identificación solo puede ser (C,R,P)");
/* 250:    */     }
/* 251:246 */     return validacion;
/* 252:    */   }
/* 253:    */   
/* 254:    */   private CampoModelo obtenerCampoModelo(String valor, String etiqueta, Integer longitud)
/* 255:    */   {
/* 256:250 */     return new CampoModelo(valor, etiqueta, longitud);
/* 257:    */   }
/* 258:    */   
/* 259:    */   private void ponerMapa(HashMap<Integer, String> validacion, Integer numeroLinea, String cadena)
/* 260:    */   {
/* 261:254 */     if (!validacion.containsKey(numeroLinea))
/* 262:    */     {
/* 263:255 */       validacion.put(numeroLinea, cadena);
/* 264:    */     }
/* 265:    */     else
/* 266:    */     {
/* 267:257 */       String cade = "";
/* 268:258 */       cade = cadena + "\n" + (String)validacion.get(numeroLinea);
/* 269:259 */       validacion.put(numeroLinea, cade);
/* 270:    */     }
/* 271:    */   }
/* 272:    */   
/* 273:    */   private void btnCargaArchivoActionPerformed(ActionEvent evt)
/* 274:    */   {
/* 275:263 */     this.mensajes = new HashMap();
/* 276:264 */     if ((this.txtDireccion.getText() != null) && (!this.txtDireccion.getText().isEmpty())) {
/* 277:    */       try
/* 278:    */       {
/* 279:266 */         validarArchivo();
/* 280:    */       }
/* 281:    */       catch (IOException ex)
/* 282:    */       {
/* 283:268 */         Logger.getLogger(CargaMasivaClientes.class.getName()).log(Level.SEVERE, null, ex);
/* 284:    */       }
/* 285:    */     } else {
/* 286:271 */       JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo", "Error", 0);
/* 287:    */     }
/* 288:    */   }
/* 289:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.CargaMasivaTransportistas
 * JD-Core Version:    0.7.0.1
 */