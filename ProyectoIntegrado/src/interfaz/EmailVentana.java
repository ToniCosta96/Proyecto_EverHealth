package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import BDD.Conexio;
import BDD.Email;

public class EmailVentana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCorreo;
	Email em = new Email();
	Conexio c;

	/**
	 * Create the dialog.
	 */
	public EmailVentana(Conexio con) {
		c=con;
		setBounds(400, 200, 300, 180);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setTitle("Confirmar correo electrónico");
		getContentPane().setLayout(new BorderLayout());
		{
			JLabel lblPregunta = new JLabel("\u00BFDeseas enviar la planificaci\u00F3n al siguiente correo?");
			getContentPane().add(lblPregunta, BorderLayout.NORTH);
		}
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setHgap(10);
		fl_contentPanel.setVgap(45);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCorreo = new JLabel("Correo:");
			contentPanel.add(lblCorreo);
		}
		{
			textFieldCorreo = new JTextField();
			contentPanel.add(textFieldCorreo);
			textFieldCorreo.setColumns(15);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Enviar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String [] txt=new String[7];

						try {
						ResultSet rs=null;
						Statement cmd= null;
						rs= cmd.executeQuery("SELECT Nombre, Email, Contrasenya, Genero, Altura, Peso, Objetivo, Actividad FROM Usuario"
								+ "  WHERE Nombre like "+c.getUsuario());	
						while (rs.next()) {
						txt[0]=rs.getString("Nombre");
						txt[1]=rs.getString("Email");
						txt[2]=rs.getString("Contrasenya");
						txt[3]=rs.getString("Genero");
						txt[4]=rs.getString("Altura");
						txt[5]=rs.getString("Peso");						
						txt[6]=rs.getString("Objetivo");
						txt[7]=rs.getString("Actividad");
							
						}
						
						
						System.out.println(txt);
						//Consulta per a obtindre les dades d'usuari des de l'identificador d'usuari c.getUsuario();
						// Nombre, sltur, edad, peso, estat fisic
		
						}catch(Exception e) {
							e.getMessage();
						}
						
						em.ConectaMail(textFieldCorreo.getText(),txt);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
