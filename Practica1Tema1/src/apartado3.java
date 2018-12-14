

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class apartado3 {
	static Scanner teclado = new Scanner(System.in);
	static DataInputStream dis;
	static DataOutputStream dos;


	public static void elegirOpcion() throws IOException { //Este método se encarga de abrir la opción seleccionada
		{
			int opcion;
			do {
				System.out.println("1.Crear fichero txt");
				System.out.println("2.Mostrar Fichero");
				System.out.println("3.Salir del pograma");

				opcion = teclado.nextInt();

				switch (opcion) {
				case 1: {
					escribirFichero();
					break;
				}
				case 2: {
					mostrarFichero();
					break;
				}
				case 3: {
					System.out.println("El programa se ha cerrado correctamente");
					System.exit(0);
				}
				default: {
					System.out.println("Por favor, elija una opción válida");
				}

				}
			} while (opcion != 3);
		}

	}
	public static void escribirFichero(){	 
		String nombre, primerApellido, segundoApellido, lugarNacimiento;
		try
		{
			FileOutputStream fos = new FileOutputStream("datos.txt"); //Creamos el fichero de texto donde se guardara la información.
			dos = new DataOutputStream(fos);
			System.out.println("Introduce tu nombre:");
			nombre = teclado.next();
			System.out.println("Introduce tu primer apellido:");
			primerApellido = teclado.next();
			System.out.println("Introduce tu segundo apellido");
			segundoApellido =teclado.next();
			System.out.println("Introduce tu Ciudad de nacimiento:");
			lugarNacimiento = teclado.next();

			dos.writeUTF(nombre);//Escribimos el nombre como string.
			dos.writeUTF(primerApellido);//Escribimos el primer apellido como string.
			dos.writeUTF(segundoApellido);//Escribimos el segundo apellido como string.
			dos.writeUTF(lugarNacimiento);//Escribimos el lugar de nacimiento como string.
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		finally {
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mostrarFichero(){
		try
		{
			FileInputStream fis = new FileInputStream("datos.txt");
			dis = new DataInputStream(fis);
			while (dis.available()>0) {//Si el data input stream es mayor que cero, es decir, que hay cosas para leer, 
				//muestra su contenido dependiendo de su tipo.			
				System.out.println("Nombre: "+dis.readUTF());
				System.out.println("Nombre: "+dis.readUTF());
				System.out.println("Primer Apellido: "+dis.readUTF());
				System.out.println("Segundo Apellido: "+dis.readUTF());
				System.out.println("Lugar de nacimiento: "+dis.readUTF());
			}
		}
		catch (FileNotFoundException eg)
		{
			System.out.println(eg.getMessage());
		}
		catch (Exception e) {
			e.getMessage();
			}
		finally {
			try {
				if(dis!=null)
					dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
	{	 
		try {
			elegirOpcion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
