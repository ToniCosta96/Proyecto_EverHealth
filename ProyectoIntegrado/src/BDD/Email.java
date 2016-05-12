package BDD;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Email {

		
	 // CLASE ENCARGADA DE RECOGER LAS VARIABLES DE LA
							// CLASE PROPERTIES Y CONSTRUIRA UNA SESION CON
							// ELLAS

	public void ConectaMail(String mail) {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "stmp.gmail.com"); // smtp ES EL SERVIDOR RESERVADO PARA ENVIO DE EMAILS
		prop.put("mail.smtp.socketFactory.port", "465"); // PUERTO ASIGNADO A CONEXIONES ADMITIDAS POR SSL (CONEXION DE SEGURIDAD)
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "true");

		
	Session sesion = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			
		protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
   				 
   	    return new javax.mail.PasswordAuthentication("everhealthdam@gmail.com","alpatodam");

 }
	 
	 
	    }
	   		);

		
    try {
      	 Message message = new MimeMessage(sesion);
      	 message.setFrom(new InternetAddress(mail));
      	 message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(mail));
      	 message.setSubject("PUTA VES NANO");
      	 message.setText("Hola, gracias por usar nuestra aplicacion, estamos trabajando en mejorarla");;
      	 Transport.send(message);
      	 JOptionPane.showMessageDialog(null, "Mensaje enviado");
       } catch (Exception e) {
      	 
       }
   }    
   }
