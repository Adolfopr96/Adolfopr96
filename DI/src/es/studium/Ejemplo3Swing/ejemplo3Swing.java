package es.studium.Ejemplo3Swing;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
public class ejemplo3Swing
{
	// Constantes y componentes (objetos)
	Container panel;
	JButton miBoton;
	// Constructor
	public ejemplo3Swing()
	{
		JFrame ventanaJ = new JFrame("Ejemplo 1");
		miBoton = new JButton("Aceptar");
		panel = ventanaJ.getContentPane();
		panel.add(miBoton);
		ventanaJ.setSize(200,100);
		ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJ.setVisible(true);
	}
	public static void main(String args[])
	{
		new ejemplo3Swing();
	}
}
