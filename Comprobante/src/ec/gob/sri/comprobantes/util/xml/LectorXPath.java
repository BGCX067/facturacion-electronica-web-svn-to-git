/*  1:   */ package ec.gob.sri.comprobantes.util.xml;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.util.logging.Level;
/*  5:   */ import java.util.logging.Logger;
/*  6:   */ import javax.xml.namespace.QName;
/*  7:   */ import javax.xml.parsers.DocumentBuilder;
/*  8:   */ import javax.xml.parsers.DocumentBuilderFactory;
/*  9:   */ import javax.xml.parsers.ParserConfigurationException;
/* 10:   */ import javax.xml.xpath.XPath;
/* 11:   */ import javax.xml.xpath.XPathExpression;
/* 12:   */ import javax.xml.xpath.XPathExpressionException;
/* 13:   */ import javax.xml.xpath.XPathFactory;
/* 14:   */ import org.w3c.dom.Document;
/* 15:   */ import org.xml.sax.SAXException;
/* 16:   */ 
/* 17:   */ public class LectorXPath
/* 18:   */ {
/* 19:   */   private String xmlFile;
/* 20:   */   private Document xmlDocument;
/* 21:   */   private XPath xPath;
/* 22:   */   
/* 23:   */   public LectorXPath(String xmlFile)
/* 24:   */   {
/* 25:30 */     this.xmlFile = xmlFile;
/* 26:31 */     inicializar();
/* 27:   */   }
/* 28:   */   
/* 29:   */   private void inicializar()
/* 30:   */   {
/* 31:   */     try
/* 32:   */     {
/* 33:36 */       this.xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.xmlFile);
/* 34:   */       
/* 35:38 */       this.xPath = XPathFactory.newInstance().newXPath();
/* 36:   */     }
/* 37:   */     catch (IOException ex)
/* 38:   */     {
/* 39:41 */       Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
/* 40:   */     }
/* 41:   */     catch (SAXException ex)
/* 42:   */     {
/* 43:43 */       Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
/* 44:   */     }
/* 45:   */     catch (ParserConfigurationException ex)
/* 46:   */     {
/* 47:45 */       Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
/* 48:   */     }
/* 49:   */   }
/* 50:   */   
/* 51:   */   public Object leerArchivo(String expression, QName returnType)
/* 52:   */   {
/* 53:   */     try
/* 54:   */     {
/* 55:51 */       XPathExpression xPathExpression = this.xPath.compile(expression);
/* 56:52 */       return xPathExpression.evaluate(this.xmlDocument, returnType);
/* 57:   */     }
/* 58:   */     catch (XPathExpressionException ex)
/* 59:   */     {
/* 60:54 */       Logger.getLogger(LectorXPath.class.getName()).log(Level.SEVERE, null, ex);
/* 61:   */     }
/* 62:55 */     return null;
/* 63:   */   }
/* 64:   */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.LectorXPath
 * JD-Core Version:    0.7.0.1
 */