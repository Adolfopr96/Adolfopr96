package es.studium.TallerWIndowBuilder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class tallerWindowBuilder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tallerWindowBuilder frame = new tallerWindowBuilder();
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
	public tallerWindowBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 87);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLabelDeEjemplo = new JLabel("Label de Ejemplo");
		lblLabelDeEjemplo.setBounds(10, 11, 85, 31);
		contentPane.add(lblLabelDeEjemplo);

		textField = new JTextField();
		textField.setBounds(105, 16, 85, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tallerJDialog dlg = new tallerJDialog(textField.getText());
				dlg.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(200, 16, 98, 21);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
	}

}
