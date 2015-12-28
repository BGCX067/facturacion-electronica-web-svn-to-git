/*   1:    */ package ec.gob.sri.comprobantes.util;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ import java.util.Properties;
/*   5:    */ import javax.activation.DataHandler;
/*   6:    */ import javax.activation.FileDataSource;
/*   7:    */ import javax.mail.Authenticator;
/*   8:    */ import javax.mail.Message.RecipientType;
/*   9:    */ import javax.mail.MessagingException;
/*  10:    */ import javax.mail.Multipart;
/*  11:    */ import javax.mail.PasswordAuthentication;
/*  12:    */ import javax.mail.Session;
/*  13:    */ import javax.mail.Transport;
/*  14:    */ import javax.mail.internet.InternetAddress;
/*  15:    */ import javax.mail.internet.MimeBodyPart;
/*  16:    */ import javax.mail.internet.MimeMessage;
/*  17:    */ import javax.mail.internet.MimeMultipart;
/*  18:    */ 
/*  19:    */ public class EnvioCorreo
/*  20:    */ {
/*  21:    */   private static String SMTP_AUTH_USER;
/*  22:    */   private static String SMTP_AUTH_PWD;
/*  23:    */   
/*  24:    */   public static void main(String[] args)
/*  25:    */   {
/*  26: 36 */     String from = "me@localhost";
/*  27: 37 */     String to = "me@localhost";
/*  28: 38 */     String subject = "Factura Electrónica";
/*  29: 39 */     String bodyText = "Usted ha recibido una factura electrónica";
/*  30: 40 */     String filename = "message.xml";
/*  31:    */     
/*  32: 42 */     EnvioCorreo demo = new EnvioCorreo();
/*  33:    */     
/*  34: 44 */     demo.enviarCorreo(from, to, subject, bodyText, filename, "abcd", "1234", true);
/*  35:    */   }
/*  36:    */   
/*  37:    */   public void enviarCorreo(String from, String to, String tituloMensaje, String mensajeCuerpo, String nombreArchivo, String nombreUsuario, String contrasenia, boolean autenticacion)
/*  38:    */   {
/*  39: 50 */     SMTP_AUTH_USER = nombreUsuario;
/*  40: 51 */     SMTP_AUTH_PWD = contrasenia;
/*  41:    */     
/*  42:    */ 
/*  43: 54 */     Properties properties = new Properties();
/*  44: 55 */     properties.put("mail.smtp.host", "localhost");
/*  45: 56 */     properties.put("mail.smtp.port", "25");
/*  46:    */     Session session;
/*  47:    */     Session session;
/*  48: 60 */     if (autenticacion == true)
/*  49:    */     {
/*  50: 61 */       properties.put("mail.smtp.auth", "true");
/*  51: 62 */       Authenticator autenticador = new SMTPAuthenticator(null);
/*  52: 63 */       session = Session.getDefaultInstance(properties, autenticador);
/*  53:    */     }
/*  54:    */     else
/*  55:    */     {
/*  56: 65 */       session = Session.getDefaultInstance(properties, null);
/*  57:    */     }
/*  58:    */     try
/*  59:    */     {
/*  60: 70 */       MimeMessage message = new MimeMessage(session);
/*  61: 71 */       message.setFrom(new InternetAddress(from));
/*  62: 72 */       message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
/*  63: 73 */       message.setSubject(tituloMensaje);
/*  64: 74 */       message.setSentDate(new Date());
/*  65:    */       
/*  66:    */ 
/*  67:    */ 
/*  68: 78 */       MimeBodyPart messagePart = new MimeBodyPart();
/*  69: 79 */       messagePart.setText(mensajeCuerpo);
/*  70:    */       
/*  71:    */ 
/*  72: 82 */       MimeBodyPart attachmentPart = new MimeBodyPart();
/*  73: 83 */       FileDataSource fileDataSource = new FileDataSource(nombreArchivo)
/*  74:    */       {
/*  75:    */         public String getContentType()
/*  76:    */         {
/*  77: 87 */           return "text/xml";
/*  78:    */         }
/*  79: 89 */       };
/*  80: 90 */       attachmentPart.setDataHandler(new DataHandler(fileDataSource));
/*  81: 91 */       attachmentPart.setFileName(nombreArchivo);
/*  82:    */       
/*  83: 93 */       Multipart multipart = new MimeMultipart();
/*  84: 94 */       multipart.addBodyPart(messagePart);
/*  85: 95 */       multipart.addBodyPart(attachmentPart);
/*  86:    */       
/*  87: 97 */       message.setContent(multipart);
/*  88:    */       
/*  89: 99 */       Transport.send(message);
/*  90:    */     }
/*  91:    */     catch (MessagingException e)
/*  92:    */     {
/*  93:101 */       e.printStackTrace();
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   private static class SMTPAuthenticator
/*  98:    */     extends Authenticator
/*  99:    */   {
/* 100:    */     public PasswordAuthentication getPasswordAuthentication()
/* 101:    */     {
/* 102:113 */       String username = EnvioCorreo.SMTP_AUTH_USER;
/* 103:114 */       String password = EnvioCorreo.SMTP_AUTH_PWD;
/* 104:115 */       return new PasswordAuthentication(username, password);
/* 105:    */     }
/* 106:    */   }
/* 107:    */ }


/* Location:           C:\Facturacion Electronica\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.EnvioCorreo
 * JD-Core Version:    0.7.0.1
 */