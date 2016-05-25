package BDD;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Email implements Runnable{
	private Properties props;
	private Session session;
	private String email;
	private boolean bienvenida;
	
	public Email(String email){
		this.email=email;
		bienvenida=true;
		Thread procesoEmail=new Thread(this, "ProcesoEmail");
		procesoEmail.setPriority(3);
		procesoEmail.start();
	}
	public Email(String email, DefaultTableModel dtm){
		this.email=email;
		bienvenida=false;
		Thread procesoEmail=new Thread(this, "ProcesoEmail");
		procesoEmail.setPriority(3);
		procesoEmail.start();
	}
    
	private void conectaMail(String email){
	    props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "true");
	    
	    session = Session.getDefaultInstance(
	            props, 
	            new javax.mail.Authenticator() {
	                protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
	                    //
	                    return new javax.mail.PasswordAuthentication("everhealthdam@gmail.com","alpatodam");
	                                
	                }}
	            );
	    
    }  
	private void conectaMailBienvenida(String email){
		 try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("everhealthdam@gmail.com"));
		        message.setRecipients (Message.RecipientType.TO, InternetAddress.parse(email));
		        message.setSubject("Bienvenido a Ever Health");   
		        message.setText("En Everhealth podrás planificarte comodamente tu dieta");
		 
		        Transport.send(message);
		        JOptionPane.showMessageDialog(null, "Mensaje enviado");
		    } catch (Exception e) {    
		    	System.out.println("ERROR");
		    }
	}
	private void conectaMailPlanificacion(){
		//Aquí se añade el archivo adjunto
	}
	@Override
	public void run() {
		if(bienvenida){
			/*Mensaje de bienvenida*/
			conectaMail(email);
			conectaMailBienvenida(email);
		}else{
			/*Mensaje de planificación*/
			//conectaMail(email);
			//conectaMailPlanificacion();
		}
	}
}

