package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import BDD.Email;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmailVentana extends javax.swing.JDialog  {
	Email em = new Email();
	
	private JTextField EmailTxT;

	/**
	 * Create the panel.
	 */
	public EmailVentana() {
		setBackground(new Color(255, 215, 0));
		getContentPane().setLayout(null);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setForeground(new Color(255, 69, 0));
		LabelEmail.setBackground(new Color(255, 69, 0));
		LabelEmail.setBounds(85, 74, 46, 14);
		getContentPane().add(LabelEmail);
		
		EmailTxT = new JTextField();
		EmailTxT.setBounds(182, 71, 86, 20);
		getContentPane().add(EmailTxT);
		EmailTxT.setColumns(10);
		
		
		JButton BotonEnviar = new JButton("Enviar");
		BotonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				em.ConectaMail(EmailTxT.getText());
			}
		});
		BotonEnviar.setBounds(273, 212, 89, 23);
		getContentPane().add(BotonEnviar);
		
		JButton BotonAtras = new JButton("Atras");
		BotonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAtras.setBounds(77, 212, 89, 23);
		getContentPane().add(BotonAtras);

	}
	

}
