import java.util.InputMismatchException;
import java.util.Scanner;

public class inicio {

	public static void main(String[] args) throws InterruptedException {
		int numCamellos=0;
		int distanciaCarrera =0;
		//camellos camellos = new  camellos();

		/*Scanner entradaEscaner = new Scanner (System.in);
		try
		{
			do
			{
				System.out.println("Introduzca el número de camellos (Mayor que 0): ");
				numCamellos=entradaEscaner.nextInt();
			}
			while(numCamellos==0);

			do
			{
				System.out.println("Introduzca la distancia de la carrera (Mayor que 0): ");
				distanciaCarrera=entradaEscaner.nextInt();
				//entradaEscaner.close();

			}
			while(distanciaCarrera==0);
		}
		catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			System.out.println("Error, introduzca un número.");
			//introducirDatos();
		}*/
		modeloCamellos mc = new modeloCamellos(8, 8);
	}
}
