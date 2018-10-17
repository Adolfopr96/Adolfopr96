package es.studium.EjemploEventoSwing;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class eventoSwing extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JButton boton;
	public eventoSwing()
	{
		boton = new JButton("Pulsar");
		add(boton);
		boton.addActionListener(this);
		setSize(250, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Toolkit.getDefaultToolkit().beep();
	}
	public static void main(String[] args)
	{
		new eventoSwing();
	}
}