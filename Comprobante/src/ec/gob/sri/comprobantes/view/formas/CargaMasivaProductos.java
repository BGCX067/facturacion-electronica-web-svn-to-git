/*   1:    */ package ec.gob.sri.comprobantes.view.formas;
/*   2:    */ 
/*   3:    */ import comprobantesdesktop.ComprobantesDesktopApp;
/*   4:    */ import ec.gob.sri.comprobantes.administracion.modelo.Producto;
/*   5:    */ import ec.gob.sri.comprobantes.sql.ProductoSQL;
/*   6:    */ import ec.gob.sri.comprobantes.util.components.SRIFileChooser;
/*   7:    */ import java.awt.event.ActionEvent;
/*   8:    */ import java.awt.event.ActionListener;
/*   9:    */ import java.io.BufferedReader;
/*  10:    */ import java.io.File;
/*  11:    */ import java.io.FileNotFoundException;
/*  12:    */ import java.io.FileReader;
/*  13:    */ import java.io.IOException;
/*  14:    */ import java.math.BigDecimal;
/*  15:    */ import java.sql.SQLException;
/*  16:    */ import java.util.ArrayList;
/*  17:    */ import java.util.HashMap;
/*  18:    */ import java.util.List;
/*  19:    */ import java.util.Set;
/*  20:    */ import java.util.logging.Level;
/*  21:    */ import java.util.logging.Logger;
/*  22:    */ import javax.swing.BorderFactory;
/*  23:    */ import javax.swing.GroupLayout;
/*  24:    */ import javax.swing.GroupLayout.Alignment;
/*  25:    */ import javax.swing.GroupLayout.ParallelGroup;
/*  26:    */ import javax.swing.GroupLayout.SequentialGroup;
/*  27:    */ import javax.swing.JButton;
/*  28:    */ import javax.swing.JFileChooser;
/*  29:    */ import javax.swing.JLabel;
/*  30:    */ import javax.swing.JOptionPane;
/*  31:    */ import javax.swing.JPanel;
/*  32:    */ import javax.swing.JTextField;
/*  33:    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*  34:    */ import org.jdesktop.application.Application;
/*  35:    */ import org.jdesktop.application.ApplicationContext;
/*  36:    */ import org.jdesktop.application.ResourceMap;
/*  37:    */ 
/*  38:    */ public class CargaMasivaProductos
/*  39:    */   extends JPanel
/*  40:    */ {
/*  41:    */   HashMap<Integer, String> mensajes;
/*  42:    */   private JButton btnCargar;
/*  43:    */   private JButton examinar;
/*  44:    */   private JLabel lblSeleccione;
/*  45:    */   private JTextField txtArchivoProductos;
/*  46:    */   
/*  47:    */   public CargaMasivaProductos()
/*  48:    */   {
/*  49: 39 */     initComponents();
/*  50:    */   }
/*  51:    */   
/*  52:    */   private void initComponents()
/*  53:    */   {
/*  54: 51 */     this.lblSeleccione = new JLabel();
/*  55: 52 */     this.txtArchivoProductos = new JTextField();
/*  56: 53 */     this.examinar = new JButton();
/*  57: 54 */     this.btnCargar = new JButton();
/*  58:    */     
/*  59: 56 */     ResourceMap resourceMap = ((ComprobantesDesktopApp)Application.getInstance(ComprobantesDesktopApp.class)).getContext().getResourceMap(CargaMasivaProductos.class);
/*  60: 57 */     setBorder(BorderFactory.createTitledBorder(resourceMap.getString("Form.border.title", new Object[0])));
/*  61: 58 */     setName("Form");
/*  62:    */     
/*  63: 60 */     this.lblSeleccione.setText(resourceMap.getString("lblSeleccione.text", new Object[0]));
/*  64: 61 */     this.lblSeleccione.setName("lblSeleccione");
/*  65:    */     
/*  66: 63 */     this.txtArchivoProductos.setText(resourceMap.getString("txtArchivoProductos.text", new Object[0]));
/*  67: 64 */     this.txtArchivoProductos.setName("txtArchivoProductos");
/*  68:    */     
/*  69: 66 */     this.examinar.setText(resourceMap.getString("examinar.text", new Object[0]));
/*  70: 67 */     this.examinar.setActionCommand(resourceMap.getString("examinar.actionCommand", new Object[0]));
/*  71: 68 */     this.examinar.setName("examinar");
/*  72: 69 */     this.examinar.addActionListener(new ActionListener()
/*  73:    */     {
/*  74:    */       public void actionPerformed(ActionEvent evt)
/*  75:    */       {
/*  76: 71 */         CargaMasivaProductos.this.examinarActionPerformed(evt);
/*  77:    */       }
/*  78: 74 */     });
/*  79: 75 */     this.btnCargar.setText(resourceMap.getString("btnCargar.text", new Object[0]));
/*  80: 76 */     this.btnCargar.setName("btnCargar");
/*  81: 77 */     this.btnCargar.addActionListener(new ActionListener()
/*  82:    */     {
/*  83:    */       public void actionPerformed(ActionEvent evt)
/*  84:    */       {
/*  85: 79 */         CargaMasivaProductos.this.btnCargarActionPerformed(evt);
/*  86:    */       }
/*  87: 82 */     });
/*  88: 83 */     GroupLayout layout = new GroupLayout(this);
/*  89: 84 */     setLayout(layout);
/*  90: 85 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.lblSeleccione).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtArchivoProductos, -2, 326, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.examinar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCargar).addContainerGap(-1, 32767)));
/*  91:    */     
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:    */ 
/*  97:    */ 
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103: 98 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblSeleccione).addComponent(this.txtArchivoProductos, -2, -1, -2).addComponent(this.examinar).addComponent(this.btnCargar)).addContainerGap(41, 32767)));
/* 104:    */   }
/* 105:    */   
/* 106:    */   private void examinarActionPerformed(ActionEvent evt)
/* 107:    */   {
/* 108:112 */     JFileChooser jfc = SRIFileChooser.obtenerFileChooserTxt();
/* 109:113 */     if (jfc.getSelectedFile() != null) {
/* 110:114 */       this.txtArchivoProductos.setText(jfc.getSelectedFile().getPath());
/* 111:    */     }
/* 112:    */   }
/* 113:    */   
/* 114:    */   private void btnCargarActionPerformed(ActionEvent evt)
/* 115:    */   {
/* 116:119 */     this.mensajes = new HashMap();
/* 117:    */     try
/* 118:    */     {
/* 119:121 */       if ((this.txtArchivoProductos.getText() != null) && (!this.txtArchivoProductos.getText().isEmpty())) {
/* 120:122 */         validarArchivo();
/* 121:    */       } else {
/* 122:124 */         JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo", "Error", 0);
/* 123:    */       }
/* 124:    */     }
/* 125:    */     catch (IOException ex)
/* 126:    */     {
/* 127:127 */       Logger.getLogger(CargaMasivaProductos.class.getName()).log(Level.SEVERE, null, ex);
/* 128:    */     }
/* 129:    */   }
/* 130:    */   
/* 131:    */   private void validarArchivo()
/* 132:    */     throws IOException
/* 133:    */   {
/* 134:132 */     List<Producto> productoList = new ArrayList();
/* 135:133 */     BufferedReader entrada = null;
/* 136:    */     try
/* 137:    */     {
/* 138:135 */       File f = new File(this.txtArchivoProductos.getText());
/* 139:136 */       entrada = new BufferedReader(new FileReader(f));
/* 140:137 */       if ((f.exists()) && (f.length() > 0L))
/* 141:    */       {
/* 142:139 */         int i = 1;
/* 143:    */         String lineaClave;
/* 144:140 */         while ((lineaClave = entrada.readLine()) != null)
/* 145:    */         {
/* 146:141 */           String[] prod = lineaClave.split(",");
/* 147:142 */           if (obtenerProducto(prod, i) != null) {
/* 148:143 */             productoList.add(obtenerProducto(prod, i));
/* 149:    */           }
/* 150:145 */           i++;
/* 151:    */         }
/* 152:    */       }
/* 153:148 */       if ((this.mensajes != null) && (!this.mensajes.isEmpty())) {
/* 154:149 */         presentarMensajesErrorArchivo();
/* 155:    */       } else {
/* 156:151 */         guardarProducto(productoList);
/* 157:    */       }
/* 158:    */     }
/* 159:    */     catch (FileNotFoundException ex)
/* 160:    */     {
/* 161:154 */       Logger.getLogger(CargaMasivaProductos.class.getName()).log(Level.SEVERE, null, ex);
/* 162:    */     }
/* 163:    */     finally
/* 164:    */     {
/* 165:156 */       if (entrada != null) {
/* 166:157 */         entrada.close();
/* 167:    */       }
/* 168:    */     }
/* 169:    */   }
/* 170:    */   
/* 171:    */   private void guardarProducto(List<Producto> listaProducto)
/* 172:    */   {
/* 173:162 */     ProductoSQL productoSQL = new ProductoSQL();
/* 174:163 */     if (!listaProducto.isEmpty()) {
/* 175:    */       try
/* 176:    */       {
/* 177:165 */         productoSQL.crearProducto(listaProducto);
/* 178:166 */         JOptionPane.showMessageDialog(this, "Se crearon con éxito los productos.\n Debe asociar los impuestos a los productos cargados", "Error", 1);
/* 179:    */       }
/* 180:    */       catch (SQLException ex)
/* 181:    */       {
/* 182:168 */         JOptionPane.showMessageDialog(this, uniqueConstraint(ex.getMessage()), "Error", 0);
/* 183:169 */         Logger.getLogger(CargaMasivaProductos.class.getName()).log(Level.SEVERE, null, ex);
/* 184:    */       }
/* 185:    */       catch (ClassNotFoundException ex)
/* 186:    */       {
/* 187:171 */         Logger.getLogger(CargaMasivaProductos.class.getName()).log(Level.SEVERE, null, ex);
/* 188:    */       }
/* 189:    */     }
/* 190:    */   }
/* 191:    */   
/* 192:    */   private String uniqueConstraint(String error)
/* 193:    */   {
/* 194:176 */     if (error.contains("UNIQUE_CODD_PRODUCTO")) {
/* 195:177 */       return "Existen productos con código ya existentes";
/* 196:    */     }
/* 197:179 */     return error;
/* 198:    */   }
/* 199:    */   
/* 200:    */   private void presentarMensajesErrorArchivo()
/* 201:    */   {
/* 202:182 */     Set<Integer> keys = this.mensajes.keySet();
/* 203:183 */     String cadena = "";
/* 204:184 */     for (Integer key : keys) {
/* 205:185 */       cadena = cadena + (String)this.mensajes.get(key) + "\n";
/* 206:    */     }
/* 207:187 */     JOptionPane.showMessageDialog(this, cadena, "Error", 0);
/* 208:    */   }
/* 209:    */   
/* 210:    */   private Producto obtenerProducto(String[] producto, int numeroLinea)
/* 211:    */   {
/* 212:190 */     if ((producto != null) && (producto.length == 5)) {
/* 213:    */       try
/* 214:    */       {
/* 215:192 */         Producto prod = new Producto();
/* 216:193 */         if ((producto[0] == null) || (producto[0].isEmpty())) {
/* 217:195 */           producto[0] = null;
/* 218:    */         }
/* 219:197 */         if ((producto[1] == null) || (producto[1].isEmpty())) {
/* 220:199 */           producto[1] = null;
/* 221:    */         }
/* 222:201 */         prod.setCodigoPrincipal(producto[0]);
/* 223:202 */         prod.setCodigoAuxiliar(producto[1]);
/* 224:203 */         prod.setNombre(producto[2]);
/* 225:204 */         prod.setValorUnitario(new BigDecimal(producto[3]));
/* 226:205 */         prod.setTipoProducto(producto[4]);
/* 227:206 */         if (validarProducto(prod, numeroLinea)) {
/* 228:207 */           return prod;
/* 229:    */         }
/* 230:209 */         return null;
/* 231:    */       }
/* 232:    */       catch (NumberFormatException e)
/* 233:    */       {
/* 234:212 */         this.mensajes.put(Integer.valueOf(numeroLinea), "Error en el producto de la línea  " + numeroLinea + " el campo valor unitario debe sun número decimal");
/* 235:213 */         return null;
/* 236:    */       }
/* 237:    */     }
/* 238:216 */     this.mensajes.put(Integer.valueOf(numeroLinea), "no se pudo insertar la línea " + numeroLinea + " no cumple formato");
/* 239:217 */     return null;
/* 240:    */   }
/* 241:    */   
/* 242:    */   private boolean validarProducto(Producto p, int i)
/* 243:    */   {
/* 244:220 */     HashMap<Integer, String> validacion = new HashMap();
/* 245:221 */     if ((p.getCodigoPrincipal() == null) || (p.getCodigoPrincipal().isEmpty())) {
/* 246:222 */       validacion.put(Integer.valueOf(i), "Error en el producto de la línea  " + i + " el campo Código principal es obligatorio");
/* 247:    */     }
/* 248:224 */     if ((p.getNombre() == null) || (p.getNombre().isEmpty())) {
/* 249:225 */       validacion.put(Integer.valueOf(i), "Error en el producto de la línea  " + i + " el campo nombre es obligatorio");
/* 250:    */     }
/* 251:227 */     if ((p.getTipoProducto() == null) || (p.getTipoProducto().isEmpty())) {
/* 252:228 */       validacion.put(Integer.valueOf(i), "Error en el producto de la línea  " + i + " el campo Tipo Producto principal es obligatorio");
/* 253:    */     }
/* 254:230 */     if ((p.getTipoProducto().equals("B")) && ((p.getCodigoPrincipal() == null) || (p.getCodigoPrincipal().isEmpty()))) {
/* 255:231 */       validacion.put(Integer.valueOf(i), "Error en el producto de la línea  " + i + " el codigo principal es obligatorio para el tipo bien");
/* 256:    */     }
/* 257:233 */     validacion = validarLongitudes(p, i, validacion);
/* 258:235 */     if ((validacion != null) && (!validacion.isEmpty()))
/* 259:    */     {
/* 260:236 */       this.mensajes.putAll(validacion);
/* 261:237 */       return false;
/* 262:    */     }
/* 263:239 */     return true;
/* 264:    */   }
/* 265:    */   
/* 266:    */   private HashMap<Integer, String> validarLongitudes(Producto p, int i, HashMap<Integer, String> validacion)
/* 267:    */   {
/* 268:244 */     if ((p.getCodigoPrincipal() != null) && (!p.getCodigoPrincipal().isEmpty()) && (p.getCodigoPrincipal().length() > 25)) {
/* 269:245 */       ponerMapa(validacion, Integer.valueOf(i), "Error en el producto de la línea  " + i + "la longitud del máxima del campo Código principal es de 25 caracteres");
/* 270:    */     }
/* 271:247 */     if ((p.getNombre() != null) && (!p.getNombre().isEmpty()) && (p.getNombre().length() > 300)) {
/* 272:248 */       ponerMapa(validacion, Integer.valueOf(i), "Error en el producto de la línea  " + i + " la longitud del máxima del campo nombre es de 300 caracteres");
/* 273:    */     }
/* 274:250 */     if ((p.getTipoProducto() != null) && (!p.getTipoProducto().isEmpty()) && (p.getTipoProducto().length() != 1)) {
/* 275:251 */       ponerMapa(validacion, Integer.valueOf(i), "Error en el producto de la línea  " + i + "la longitud del máxima del campo Tipo Producto principal es de 1 caracter");
/* 276:253 */     } else if ((p.getTipoProducto() != null) && (!p.getTipoProducto().isEmpty()) && (p.getTipoProducto().length() == 1) && 
/* 277:254 */       (!obtenerTipoProductoValidacion(p.getTipoProducto()))) {
/* 278:255 */       ponerMapa(validacion, Integer.valueOf(i), "Error en el producto de la línea  " + i + " el campo tipo Producto puede ser Bienn o servicio(B o S)");
/* 279:    */     }
/* 280:259 */     return validacion;
/* 281:    */   }
/* 282:    */   
/* 283:    */   private void ponerMapa(HashMap<Integer, String> validacion, Integer numeroLinea, String cadena)
/* 284:    */   {
/* 285:262 */     if (!validacion.containsKey(numeroLinea))
/* 286:    */     {
/* 287:263 */       validacion.put(numeroLinea, cadena);
/* 288:    */     }
/* 289:    */     else
/* 290:    */     {
/* 291:265 */       String cade = "";
/* 292:266 */       cade = cadena + "\n" + (String)validacion.get(numeroLinea);
/* 293:267 */       validacion.put(numeroLinea, cade);
/* 294:    */     }
/* 295:    */   }
/* 296:    */   
/* 297:    */   private boolean obtenerTipoProductoValidacion(String tipoProducto)
/* 298:    */   {
/* 299:271 */     if ((!tipoProducto.equals("B")) && 
/* 300:272 */       (!tipoProducto.equals("S"))) {
/* 301:273 */       return Boolean.FALSE.booleanValue();
/* 302:    */     }
/* 303:276 */     return Boolean.TRUE.booleanValue();
/* 304:    */   }
/* 305:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.view.formas.CargaMasivaProductos
 * JD-Core Version:    0.7.0.1
 */