

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class apartado2 {
	static Scanner teclado = new Scanner(System.in);
	static DataOutputStream dos;
	static DataInputStream dis;


	public static void elegirOpcionApartado2() throws IOException { //Este método se encarga de abrir la opción seleccionada
		{
			int opcion;
			do {
				System.out.println("1.Crear fichero binario");
				System.out.println("2.Mostrar Fichero");
				System.out.println("3.Salir del pograma");
				opcion = teclado.nextInt();

				switch (opcion) {
				case 1: {
					crearFichero();
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
					break;
				}
				}
			} while (opcion != 3);
		}
	}
	public static void crearFichero(){	
		String Nombre;
		int Edad = 0;
		String Nacimiento;
		try
		{
			FileOutputStream fos = new FileOutputStream("datos.bin"); //Se crea el fichero binario.
			dos = new DataOutputStream(fos);
			System.out.println("Introduce tu nombre:");
			Nombre = teclado.next();
			System.out.println("Introduce tu edad:");
			Edad = teclado.nextInt();
			System.out.println("Introduce tu Ciudad de nacimiento:");
			Nacimiento = teclado.next();

			dos.writeUTF(Nombre);//Escribimos el nombre como string.
			dos.writeInt(Edad);//Escrbimos la edad como int.
			dos.writeUTF(Nacimiento);//Escribios la fecha como string.
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		finally {
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void mostrarFichero(){
		try
		{
			FileInputStream fis = new FileInputStream("datos.bin");
			dis = new DataInputStream(fis);
			while (dis.available()>0) {//Si el data input stream es mayor que cero, es decir, que hay cosas para leer, muestra su contenido dependiendo de su tipo.			
				System.out.println("Nombre: "+dis.readUTF());
				System.out.println("Edad: "+dis.readInt());
				System.out.println("Lugar de nacimiento: "+dis.readUTF());
			}
		}
		catch (FileNotFoundException eg)
		{
			System.out.println(eg.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
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
	public static void main(String[] args) throws IOException {
		try {
			elegirOpcionApartado2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
