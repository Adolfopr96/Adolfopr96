package es.studium.EjemploDibujoSwing;
import javax.swing.JFrame;
public class dibujoSwing extends JFrame
{
	private static final long serialVersionUID = 1L;
	public dibujoSwing()
	{
		setTitle("Ejemplo de dibujo");
		add(new miPanel());
		setSize(250, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new dibujoSwing();
	}
}