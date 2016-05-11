package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmailVentana extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCorreo;

	/**
	 * Create the dialog.
	 */
	public EmailVentana() {
		setBounds(400, 200, 300, 180);
		setResizable(false);
		setModalityType(DEFAULT_MODALITY_TYPE);
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
			textFieldCorreo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
