/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Clientes;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ClientesSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.CampoModelo;
/*   7:    */ import ec.gob.sri.comprobantes.util.StringUtil;
/*   8:    */ import ec.gob.sri.comprobantes.util.TipoClienteEnum;
/*   9:    */ import ec.gob.sri.comprobantes.util.TipoIdentificacionEnum;
/*  10:    */ import ec.gob.sri.comprobantes.util.ValidadorCampos;
/*  11:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*  12:    */ import java.awt.event.ActionEvent;
/*  13:    */ import java.awt.event.ActionListener;
/*  14:    */ import java.io.BufferedReader;
/*  15:    */ import java.io.File;
/*  16:    */ import java.io.FileNotFoundException;
/*  17:    */ import java.io.FileReader;
/*  18:    */ import java.io.IOException;
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
/*  41:    */ public class CargaMasivaClientes
/*  42:    */   extends JPanel
/*  43:    */ {
/*  44:    */   HashMap<Integer, String> mensajes;
/*  45:    */   private JButton btnCargaCliente;
/*  46:    */   private JButton btnExaminar;
/*  47:    */   private JLabel jLabel1;
/*  48:    */   private JTextField txtDireccion;
/*  49:    */   
/*  50:    */   public CargaMasivaClientes()
/*  51:    */   {
/*  52: 41 */     initComponents();
/*  53:    */   }
/*  54:    */   
/*  55:    */   private void initComponents()
/*  56:    */   {
/*  57: 53 */     this.jLabel1 = new JLabel();
/*  58: 54 */     this.txtDireccion = new JTextField();
/*  59: 55 */     this.btnExaminar = new JButton();
/*  60: 56 */     this.btnCargaCliente = new JButton();
/*  61:    */     
/*  62: 58 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(CargaMasivaClientes.class);
/*  63: 59 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/*  64: 60 */     setName("Form");
/*  65:    */     
/*  66: 62 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  67: 63 */     this.jLabel1.setName("jLabel1");
/*  68:    */     
/*  69: 65 */     this.txtDireccion.setText(resourceMap.getString("txtDireccion.text", new Object[0]));
/*  70: 66 */     this.txtDireccion.setEnabled(false);
/*  71: 67 */     this.txtDireccion.setName("txtDireccion");
/*  72:    */     
/*  73: 69 */     this.btnExaminar.setText(resourceMap.getString("btnExaminar.text", new Object[0]));
/*  74: 70 */     this.btnExaminar.setName("btnExaminar");
/*  75: 71 */     this.btnExaminar.addActionListener(new ActionListener()
/*  76:    */     {
/*  77:    */       public void actionPerformed(ActionEvent evt)
/*  78:    */       {
/*  79: 73 */         CargaMasivaClientes.this.btnExaminarActionPerformed(evt);
/*  80:    */       }
/*  81: 76 */     });
/*  82: 77 */     this.btnCargaCliente.setText(resourceMap.getString("btnCargaCliente.text", new Object[0]));
/*  83: 78 */     this.btnCargaCliente.setName("btnCargaCliente");
/*  84: 79 */     this.btnCargaCliente.addActionListener(new ActionListener()
/*  85:    */     {
/*  86:    */       public void actionPerformed(ActionEvent evt)
/*  87:    */       {
/*  88: 81 */         CargaMasivaClientes.this.btnCargaClienteActionPerformed(evt);
/*  89:    */       }
/*  90: 84 */     });
/*  91: 85 */     GroupLayout layout = new GroupLayout(this);
/*  92: 86 */     setLayout(layout);
/*  93: 87 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtDireccion, -2, 241, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnExaminar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCargaCliente).addContainerGap(-1, 32767)));
/*  94:    */     
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
/* 106:100 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jLabel1).addComponent(this.txtDireccion, -2, -1, -2).addComponent(this.btnExaminar).addComponent(this.btnCargaCliente)).addContainerGap(58, 32767)));
/* 107:    */   }
/* 108:    */   
/* 109:    */   private void btnExaminarActionPerformed(ActionEvent evt)
/* 110:    */   {
/* 111:114 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserTxt();
/* 112:115 */     if (jfc.getSelectedFile() != null) {
/* 113:116 */       this.txtDireccion.setText(jfc.getSelectedFile().getPath());
/* 114:    */     }
/* 115:    */   }
/* 116:    */   
/* 117:    */   private void btnCargaClienteActionPerformed(ActionEvent evt)
/* 118:    */   {
/* 119:121 */     this.mensajes = new HashMap();
/* 120:122 */     if ((this.txtDireccion.getText() != null) && (!this.txtDireccion.getText().isEmpty())) {
/* 121:    */       try
/* 122:    */       {
/* 123:124 */         validarArchivo();
/* 124:    */       }
/* 125:    */       catch (IOException ex)
/* 126:    */       {
/* 127:126 */         Logger.getLogger(CargaMasivaClientes.class.getName()).log(Level.SEVERE, null, ex);
/* 128:    */       }
/* 129:    */     } else {
/* 130:129 */       JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo", "Error", 0);
/* 131:    */     }
/* 132:    */   }
/* 133:    */   
/* 134:    */   private void validarArchivo()
/* 135:    */     throws IOException
/* 136:    */   {
/* 137:133 */     List<Clientes> clienteList = new ArrayList();
/* 138:134 */     BufferedReader entrada = null;
/* 139:    */     try
/* 140:    */     {
/* 141:136 */       File f = new File(this.txtDireccion.getText());
/* 142:137 */       entrada = new BufferedReader(new FileReader(f));
/* 143:138 */       if ((f.exists()) && (f.length() > 0L))
/* 144:    */       {
/* 145:140 */         int i = 1;
/* 146:    */         String lineaClave;
/* 147:141 */         while ((lineaClave = entrada.readLine()) != null)
/* 148:    */         {
/* 149:142 */           String[] cliente = lineaClave.split(",");
/* 150:143 */           Clientes c = obtenerClienete(cliente, i);
/* 151:144 */           if (c != null) {
/* 152:145 */             clienteList.add(c);
/* 153:    */           }
/* 154:147 */           i++;
/* 155:    */         }
/* 156:    */       }
/* 157:150 */       creacionCliente(clienteList);
/* 158:    */     }
/* 159:    */     catch (FileNotFoundException ex)
/* 160:    */     {
/* 161:153 */       Logger.getLogger(CargaMasivaProductos.class.getName()).log(Level.SEVERE, null, ex);
/* 162:    */     }
/* 163:    */     finally
/* 164:    */     {
/* 165:155 */       if (entrada != null) {
/* 166:156 */         entrada.close();
/* 167:    */       }
/* 168:    */     }
/* 169:    */   }
/* 170:    */   
/* 171:    */   private void creacionCliente(List<Clientes> clienteList)
/* 172:    */   {
/* 173:162 */     if ((this.mensajes != null) && (!this.mensajes.isEmpty()))
/* 174:    */     {
/* 175:163 */       presentarMensajesErrorArchivo();
/* 176:    */     }
/* 177:    */     else
/* 178:    */     {
/* 179:165 */       HashMap<String, String> errorCreacion = crearClientes(clienteList);
/* 180:166 */       if ((errorCreacion != null) && (errorCreacion.isEmpty()))
/* 181:    */       {
/* 182:167 */         JOptionPane.showMessageDialog(this, "Se crearon con éxito los  clientes", "Mensaje", 1);
/* 183:    */       }
/* 184:    */       else
/* 185:    */       {
/* 186:170 */         Set<String> keys = errorCreacion.keySet();
/* 187:171 */         String mensajes = "";
/* 188:172 */         for (String key : keys) {
/* 189:173 */           mensajes = mensajes + (String)errorCreacion.get(key) + "\n";
/* 190:    */         }
/* 191:175 */         JOptionPane.showMessageDialog(this, "Se crearon con éxito los  clientes, hubieron problemas con los siguientes registros\n" + mensajes, "Mensaje", 2);
/* 192:    */       }
/* 193:    */     }
/* 194:    */   }
/* 195:    */   
/* 196:    */   private HashMap<String, String> crearClientes(List<Clientes> clientes)
/* 197:    */   {
/* 198:182 */     ClientesSQL clientesSQL = new ClientesSQL();
/* 199:183 */     return clientesSQL.crearClientesMasivos(clientes);
/* 200:    */   }
/* 201:    */   
/* 202:    */   private void presentarMensajesErrorArchivo()
/* 203:    */   {
/* 204:187 */     Set<Integer> keys = this.mensajes.keySet();
/* 205:188 */     String cadena = "";
/* 206:189 */     for (Integer key : keys) {
/* 207:190 */       cadena = cadena + (String)this.mensajes.get(key) + "\n";
/* 208:    */     }
/* 209:192 */     JOptionPane.showMessageDialog(this, cadena, "Error", 0);
/* 210:    */   }
/* 211:    */   
/* 212:    */   private Clientes obtenerClienete(String[] cliente, int i)
/* 213:    */   {
/* 214:196 */     if ((cliente != null) && (cliente.length == 9))
/* 215:    */     {
/* 216:197 */       Clientes c = new Clientes();
/* 217:198 */       c.setApellido(cliente[0]);
/* 218:199 */       c.setTipoIdentificacion(cliente[1]);
/* 219:200 */       c.setNumeroIdentificacio(cliente[2]);
/* 220:201 */       c.setDireccion(cliente[3]);
/* 221:202 */       c.setTelefonoConvencional(cliente[4]);
/* 222:203 */       c.setExtencion(cliente[5]);
/* 223:204 */       c.setCelular(cliente[6]);
/* 224:205 */       c.setCorreo(cliente[7]);
/* 225:206 */       c.setTipoCliente(cliente[8]);
/* 226:207 */       if (validarCliente(c, i)) {
/* 227:208 */         return c;
/* 228:    */       }
/* 229:210 */       return null;
/* 230:    */     }
/* 231:215 */     this.mensajes.put(Integer.valueOf(0), "No se pudo insertar la línea " + i + " no cumple formato");
/* 232:216 */     return null;
/* 233:    */   }
/* 234:    */   
/* 235:    */   private boolean validarCliente(Clientes cliente, int i)
/* 236:    */   {
/* 237:220 */     HashMap<Integer, String> validacion = new HashMap();
/* 238:221 */     if ((cliente.getApellido() == null) || (cliente.getApellido().isEmpty())) {
/* 239:222 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo Apellidos nombres / razón social es obligatorio");
/* 240:    */     }
/* 241:224 */     if ((cliente.getTipoIdentificacion() == null) || (cliente.getTipoIdentificacion().isEmpty())) {
/* 242:225 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo tipo de identificación es obligatorio");
/* 243:    */     }
/* 244:227 */     if ((cliente.getNumeroIdentificacio() == null) || (cliente.getNumeroIdentificacio().isEmpty())) {
/* 245:228 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El número de identificación es obligatorio");
/* 246:    */     }
/* 247:230 */     if ((cliente.getTipoCliente() == null) || (cliente.getTipoCliente().isEmpty())) {
/* 248:231 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El tipo de cliente es obligatorio");
/* 249:    */     }
/* 250:233 */     if ((cliente.getCorreo() == null) || (cliente.getCorreo().isEmpty())) {
/* 251:234 */       validacion.put(Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo correo electrónico es obligatorio");
/* 252:    */     }
/* 253:236 */     validacion = validarLongitudes(cliente, i, validacion);
/* 254:238 */     if ((validacion != null) && (!validacion.isEmpty()))
/* 255:    */     {
/* 256:239 */       this.mensajes.putAll(validacion);
/* 257:240 */       return false;
/* 258:    */     }
/* 259:242 */     return true;
/* 260:    */   }
/* 261:    */   
/* 262:    */   private void ponerMapa(HashMap<Integer, String> validacion, Integer numeroLinea, String cadena)
/* 263:    */   {
/* 264:248 */     if (!validacion.containsKey(numeroLinea))
/* 265:    */     {
/* 266:249 */       validacion.put(numeroLinea, cadena);
/* 267:    */     }
/* 268:    */     else
/* 269:    */     {
/* 270:251 */       String cade = "";
/* 271:252 */       cade = cadena + "\n" + (String)validacion.get(numeroLinea);
/* 272:253 */       validacion.put(numeroLinea, cade);
/* 273:    */     }
/* 274:    */   }
/* 275:    */   
/* 276:    */   private HashMap<Integer, String> validarLongitudes(Clientes c, int i, HashMap<Integer, String> validacion)
/* 277:    */   {
/* 278:258 */     List<CampoModelo> listaCampos = new ArrayList();
/* 279:259 */     listaCampos.add(obtenerCampoModelo(c.getDireccion(), "Dirección", Integer.valueOf(300)));
/* 280:260 */     listaCampos.add(obtenerCampoModelo(c.getApellido(), "Razón Social", Integer.valueOf(300)));
/* 281:261 */     listaCampos.add(obtenerCampoModelo(c.getTelefonoConvencional(), "Teléfono", Integer.valueOf(13)));
/* 282:262 */     listaCampos.add(obtenerCampoModelo(c.getCelular(), "Teléfono Celular", Integer.valueOf(13)));
/* 283:263 */     listaCampos.add(obtenerCampoModelo(c.getExtencion(), "Extensión", Integer.valueOf(13)));
/* 284:264 */     listaCampos.add(obtenerCampoModelo(c.getTipoCliente(), "Tipo cliente", Integer.valueOf(13)));
/* 285:265 */     String camposLongitud = ValidadorCampos.validarCampoLongitudMayor(listaCampos);
/* 286:266 */     if ((camposLongitud != null) && (!camposLongitud.isEmpty())) {
/* 287:267 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + "  " + camposLongitud);
/* 288:    */     }
/* 289:269 */     HashMap<Integer, String> validacionExpresion = validarExpresiones(c, i, validacion);
/* 290:270 */     if ((validacionExpresion != null) && (!validacionExpresion.isEmpty())) {
/* 291:271 */       validacion.putAll(validacionExpresion);
/* 292:    */     }
/* 293:273 */     return validacion;
/* 294:    */   }
/* 295:    */   
/* 296:    */   private HashMap<Integer, String> validarExpresiones(Clientes c, int i, HashMap<Integer, String> validacion)
/* 297:    */   {
/* 298:278 */     if ((c.getTelefonoConvencional() != null) && (!c.getTelefonoConvencional().isEmpty()) && (!validarNumerosDetelefono(c.getTelefonoConvencional()).booleanValue())) {
/* 299:279 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo teléfono convencional solo acepta caracteres numéricos");
/* 300:    */     }
/* 301:281 */     if ((c.getCelular() != null) && (!c.getCelular().isEmpty()) && (!validarNumerosDetelefono(c.getCelular()).booleanValue())) {
/* 302:282 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo telefóno celular solo acepta números");
/* 303:    */     }
/* 304:284 */     if ((c.getExtencion() != null) && (!c.getExtencion().isEmpty()) && (!validarNumerosDetelefono(c.getExtencion()).booleanValue())) {
/* 305:285 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El campo extensión solo acepta números");
/* 306:    */     }
/* 307:288 */     if ((c.getCorreo() != null) && (!c.getCorreo().isEmpty()) && (!StringUtil.validateEmail(c.getCorreo()))) {
/* 308:289 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " Dirección de correo inválida");
/* 309:    */     }
/* 310:292 */     return validarTipoClientes(c, i, validacion);
/* 311:    */   }
/* 312:    */   
/* 313:    */   private HashMap<Integer, String> validarTipoClientes(Clientes c, int i, HashMap<Integer, String> validacion)
/* 314:    */   {
/* 315:296 */     if ((!c.getTipoCliente().equals(TipoClienteEnum.C.getCode())) && (!c.getTipoCliente().equals(TipoClienteEnum.R.getCode())) && (!c.getTipoCliente().equals(TipoClienteEnum.D.getCode()))) {
/* 316:298 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El tipo de cliente solo puede ser (C,R,D)");
/* 317:    */     }
/* 318:301 */     if ((!c.getTipoIdentificacion().equals(TipoIdentificacionEnum.C.getCode())) && (!c.getTipoIdentificacion().equals(TipoIdentificacionEnum.R.getCode())) && (!c.getTipoIdentificacion().equals(TipoIdentificacionEnum.P.getCode()))) {
/* 319:303 */       ponerMapa(validacion, Integer.valueOf(i), "Error en la línea " + new Integer(i).toString() + " El tipo Identificación solo puede ser (C,R,P)");
/* 320:    */     }
/* 321:305 */     return validacion;
/* 322:    */   }
/* 323:    */   
/* 324:    */   private Boolean validarNumerosDetelefono(String numero)
/* 325:    */   {
/* 326:309 */     return Boolean.valueOf(StringUtil.validarExpresionRegular("\\d+", numero));
/* 327:    */   }
/* 328:    */   
/* 329:    */   private CampoModelo obtenerCampoModelo(String valor, String etiqueta, Integer longitud)
/* 330:    */   {
/* 331:313 */     return new CampoModelo(valor, etiqueta, longitud);
/* 332:    */   }
/* 333:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.CargaMasivaClientes
 * JD-Core Version:    0.7.0.1
 */