package BDD;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;

public class Email {
	
	public Email(String email){
		ConectaMail(email);
	}
	public Email(String email, DefaultTableModel dtm){
		
	}
    
private void ConectaMail(String email){
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "true");
    
    Session session = Session.getDefaultInstance(
            props, 
            new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                    
                    return new javax.mail.PasswordAuthentication("everhealthdam@gmail.com","alpatodam");
                                
                }}
            );
    
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("everhealthdam@gmail.com"));
        message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Bienvenido a Ever Health");
   
        message.setText("Perfil de usuario");
        
        MimeBodyPart contenido = new MimeBodyPart();
        contenido.setDataHandler(new DataHandler(new FileDataSource("/Escritorio/Prueba.txt")));
        contenido.setFileName("/Escritorio/Prueba.txt");
     
    
       // message.setContent(adjunto,null);;
 
        Transport.send(message);
        JOptionPane.showMessageDialog(null, "Mensaje enviado");
    } catch (Exception e) {    
    	System.out.println("ERROR");
    }
    }    
}