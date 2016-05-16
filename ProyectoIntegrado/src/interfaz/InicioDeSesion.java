package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BDD.CargarIdioma;
import BDD.Conexio;
import BDD.Consultas;

public class InicioDeSesion extends JFrame {

	private static Conexio conexio;
	private static String arrayIdioma[];
	private JPanel contentPane;
	private JLabel lblNombreDeUsuario;
	private JTextField textFieldNombre;
	private JLabel lblContrasea;
	private JLabel lblCrearUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		conexio=new Conexio();
		new CargarIdioma(conexio, arrayIdioma);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDeSesion frame = new InicioDeSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioDeSesion() {
		setTitle("Iniciar sesi\u00F3n.");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(".\\img\\logoEverHealth1.png").getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panelCampos = new JPanel();
		panelCampos.setOpaque(false);
		contentPane.add(panelCampos);
		panelCampos.setLayout(new GridLayout(2, 2, 0, 0));
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCampos.add(lblNombreDeUsuario);
		
		textFieldNombre = new JTextField();
		panelCampos.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelCampos.add(lblContrasea);
		
		passwordField = new JPasswordField();
		panelCampos.add(passwordField);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		contentPane.add(panelBotones);
		
		JButton btnNewButton = new JButton("Iniciar sesión.");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Aquí se accede a la base de datos para introducir el usuario.
				if(new Consultas(conexio).iniciarSesionUsuario(textFieldNombre.getText(), String.valueOf(passwordField.getPassword()))){
					conexio.setUsuario(textFieldNombre.getText());
					ventanas('m');
					dispose();
				}else{
					//Mostrar mensaje de error.
					JOptionPane.showMessageDialog(null,
						    "Usuario o contraseña incorrectos.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
					//Quitar
					ventanas('m');
					dispose();
				}
			}
		});
		panelBotones.add(btnNewButton);
		
		lblCrearUsuario = new JLabel("Crear usuario.");
		lblCrearUsuario.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCrearUsuario.setText("Crear usuario.");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrearUsuario.setText("<html><u>Crear usuario.</u></html>");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanas('c');
				dispose();
			}
		});
		panelBotones.add(lblCrearUsuario);
	}
	
	public void ventanas(char ventana){
		Ventanas frame = new Ventanas(ventana, conexio, arrayIdioma);
		frame.setVisible(true);
	}
}
