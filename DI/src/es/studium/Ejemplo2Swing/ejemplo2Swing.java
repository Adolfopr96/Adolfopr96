package es.studium.Ejemplo2Swing;
import javax.swing.JFrame;
public class ejemplo2Swing
{
	// Constructor
	public ejemplo2Swing()
	{
		JFrame ventanaJ = new JFrame("Ejemplo 1");
		ventanaJ.setSize(250,250);
		ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJ.setLocationRelativeTo(null);
		ventanaJ.setVisible(true);
	}
	public static void main(String args[])
	{
		new ejemplo2Swing();
	}
}