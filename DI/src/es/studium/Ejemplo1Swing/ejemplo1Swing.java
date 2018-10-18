package es.studium.Ejemplo1Swing;
import javax.swing.JFrame;
public class ejemplo1Swing extends JFrame
{
	private static final long serialVersionUID = 1L;
	// Constructor
	public ejemplo1Swing()
	{
		setTitle("Ejemplo 1");
		setSize(250,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new ejemplo1Swing();
	}
}