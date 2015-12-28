/*  1:   */ package ec.gob.sri.comprobantes.util.xml;
/*  2:   */ 
/*  3:   */ import java.io.File;
/*  4:   */ import javax.xml.transform.stream.StreamSource;
/*  5:   */ import javax.xml.validation.Schema;
/*  6:   */ import javax.xml.validation.SchemaFactory;
/*  7:   */ import javax.xml.validation.Validator;
/*  8:   */ import org.xml.sax.SAXException;
/*  9:   */ 
/* 10:   */ public class ValidadorEstructuraDocumento
/* 11:   */ {
/* 12:   */   private File archivoXSD;
/* 13:   */   private File archivoXML;
/* 14:   */   
/* 15:   */   public String validacion()
/* 16:   */   {
/* 17:35 */     validarArchivo(this.archivoXSD, "archivoXSD");
/* 18:36 */     validarArchivo(this.archivoXML, "archivoXML");
/* 19:   */     
/* 20:38 */     String mensaje = null;
/* 21:   */     
/* 22:40 */     SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
/* 23:   */     Schema schema;
/* 24:   */     try
/* 25:   */     {
/* 26:43 */       schema = schemaFactory.newSchema(this.archivoXSD);
/* 27:   */     }
/* 28:   */     catch (SAXException e)
/* 29:   */     {
/* 30:45 */       throw new IllegalStateException("Existe un error en la sintaxis del esquema", e);
/* 31:   */     }
/* 32:47 */     Validator validator = schema.newValidator();
/* 33:   */     try
/* 34:   */     {
/* 35:49 */       validator.validate(new StreamSource(this.archivoXML));
/* 36:   */     }
/* 37:   */     catch (Exception e)
/* 38:   */     {
/* 39:52 */       return e.getMessage();
/* 40:   */     }
/* 41:54 */     return mensaje;
/* 42:   */   }
/* 43:   */   
/* 44:   */   protected void validarArchivo(File archivo, String nombre)
/* 45:   */     throws IllegalStateException
/* 46:   */   {
/* 47:61 */     if ((null == archivo) || (archivo.length() <= 0L)) {
/* 48:62 */       throw new IllegalStateException(nombre + " es nulo o esta vacio");
/* 49:   */     }
/* 50:   */   }
/* 51:   */   
/* 52:   */   public File getArchivoXSD()
/* 53:   */   {
/* 54:70 */     return this.archivoXSD;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setArchivoXSD(File archivoXSD)
/* 58:   */   {
/* 59:77 */     this.archivoXSD = archivoXSD;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public File getArchivoXML()
/* 63:   */   {
/* 64:84 */     return this.archivoXML;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setArchivoXML(File archivoXML)
/* 68:   */   {
/* 69:91 */     this.archivoXML = archivoXML;
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.ValidadorEstructuraDocumento
 * JD-Core Version:    0.7.0.1
 */