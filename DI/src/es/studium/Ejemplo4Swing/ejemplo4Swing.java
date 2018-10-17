package es.studium.Ejemplo4Swing;
import javax.swing.JButton;
import javax.swing.JFrame;
public class ejemplo4Swing
{
	// Constantes y componentes (objetos)
	JButton miBoton;
	// Constructor
	public ejemplo4Swing()
	{
		JFrame ventanaJ = new JFrame("Ejemplo 1");
		miBoton = new JButton("Aceptar");
		ventanaJ.add(miBoton);
		ventanaJ.setSize(200,100);
		ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaJ.setVisible(true);
	}
	public static void main(String args[])
	{
		new ejemplo4Swing();
	}
}