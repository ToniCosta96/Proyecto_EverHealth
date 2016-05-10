package interfaz;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import sun.rmi.transport.Transport;

public class Email {

	private final Properties prop = new Properties();
	
	

	private Session sesion; // CLASE ENCARGADA DE RECOGER LAS VARIABLES DE LA
							// CLASE PROPERTIES Y CONSTRUIRA UNA SESION CON
							// ELLAS

	private void ConectaMail() {

		prop.put("mail.smtp.host", "mail.gmail.com"); // smtp ES EL SERVIDOR RESERVADO PARA ENVIO DE EMAILS
		prop.put("mail.smtp.starttls.enable", "true"); // INSTANCIAMOS EL SERVIDOR COMO TRUE
		prop.put("mail.smtp.socketFactory.port", "465"); // PUERTO ASIGNADO A CONEXIONES ADMITIDAS POR SSL (CONEXION DE SEGURIDAD)
		prop.put("mail.smtp.socketFactory.port", "true"); // INSTANCIAMOS LA LLAMADA A TRUE
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "true");

		

		sesion = Session.getDefaultInstance(prop,
		   		 new javax.mail.Authenticator() {
 protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
   				 
   	 return new javax.mail.PasswordAuthentication("everhealthdam@gmail.com","alpatodam");

 }
	 
	 
	    }
	   		);
		
		try{
			
			MimeMessage prueba = new MimeMessage(sesion); // LLAMAR DESDE UNA CLASE MIMESSAGE LLAMADA prueba A LA SESION PREV CREADA
			
			prueba.setFrom(new InternetAddress("everhealthdam@gmailcom")); 
			prueba.addRecipient(Message.RecipientType.TO, new InternetAddress());// RECIBE LA DIRECC DEL EMISOR TIPO INTERN.ADRESS, PASA EL CONTEN. A STRING
			
			prueba.setSubject("PRUEBA"); // ASUNTO
			prueba.setText("TEXTO A VER QUE SALE"); // CONTENIDO DEL MAIL
			
			javax.mail.Transport t = sesion.getTransport("smtp");  // CREAR INSTANCIA DE PROPOTOCOLO DE TRANSPORTE
		
			 JOptionPane.showMessageDialog(null, "Mensaje enviado");
			t.close();
		

		}catch(Exception e){
			System.out.println("ERROR");
		}
		
		
	}
}
