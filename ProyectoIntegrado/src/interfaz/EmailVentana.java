package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmailVentana extends JPanel {
	private JTextField EmailTxT;
	private JTextField PassTxT;

	/**
	 * Create the panel.
	 */
	public EmailVentana() {
		setBackground(new Color(255, 215, 0));
		setLayout(null);
		
		JLabel LabelEmail = new JLabel("Email:");
		LabelEmail.setForeground(new Color(255, 69, 0));
		LabelEmail.setBackground(new Color(255, 69, 0));
		LabelEmail.setBounds(85, 74, 46, 14);
		add(LabelEmail);
		
		EmailTxT = new JTextField();
		EmailTxT.setBounds(182, 71, 86, 20);
		add(EmailTxT);
		EmailTxT.setColumns(10);
		
		JLabel LabelPass = new JLabel("Contrase\u00F1a:");
		LabelPass.setForeground(new Color(255, 69, 0));
		LabelPass.setBounds(85, 134, 75, 14);
		add(LabelPass);
		
		PassTxT = new JTextField();
		PassTxT.setBounds(182, 131, 86, 20);
		add(PassTxT);
		PassTxT.setColumns(10);
		
		JButton BotonEnviar = new JButton("Enviar");
		BotonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BotonEnviar.setBounds(290, 242, 89, 23);
		add(BotonEnviar);
		
		JButton BotonAtras = new JButton("Atras");
		BotonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BotonAtras.setBounds(42, 242, 89, 23);
		add(BotonAtras);

	}
}
