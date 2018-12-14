

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class apartado1 {
	static RandomAccessFile raf;
	static File fichero = new File("fichero.bin");
	static Scanner teclado = new Scanner(System.in);

	public static void elegirOpcion() throws Exception //Este m�todo se encarga de abrir la opci�n seleccionada
	{
		int opcion;
		do {

			System.out.println("1.A�adir numeros de tipo double al principio del fichero");
			System.out.println("2.A�adir numero de tipo double al final del fichero.");
			System.out.println("3.Mostrar el fichero creado.");
			System.out.println("4.Sustituir un n�mero indicado por el usuario por otro numero que tambi�n te indique el usuario.");
			System.out.println("5.Salir del programa");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1: {
				a�adirNumeroPrincipio();
				break;
			}
			case 2: {
				a�adirNumeroFinal();
				break;
			}
			case 3: {
				leerFichero();
				break;
			}
			case 4: {
				sustituirNumeros();
				break;
			}
			case 5: {
				System.out.println("El programa se ha cerrado correctamente");
				System.exit(0);
			}
			default: {
				System.out.println("Por favor, elija una opci�n v�lida");
			}
			}
		} while (opcion != 5);

	}
	public static void a�adirNumeroPrincipio(){ 
		try
		{
			raf = new RandomAccessFile(fichero, "rw"); 
			double numero;
			System.out.println("Introduce un numero Double para a�adir al principio del fichero: ");
			numero = teclado.nextDouble();
			raf.seek(0); //Se posiciona puntero del random access file en la primera posicion
			raf.writeDouble(numero); //Escribimos el n�mero en la posici�n del puntero.
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		finally {
				try {
					if(raf!=null)
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void a�adirNumeroFinal(){
		try
		{
			raf = new RandomAccessFile(fichero, "rw"); 
			double numero;
			System.out.println("Introduce un numero Double para a�adir al final del fichero: ");
			numero = teclado.nextDouble();
			raf.seek(raf.length());//Posicionamos el puntero en la �ltima posici�n del random access file.
			raf.writeDouble(numero); //escribimos el n�mero en la posici�n del puntero.
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(raf!=null)
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} 
	public static void leerFichero(){
		double numero;
		int i=1;
		try
		{
			raf = new RandomAccessFile(fichero, "r");
			raf.seek(0);//Se posiciona puntero del random access file en la primera posicion
			while (raf.getFilePointer()<raf.length()) {//Mientras el puntero no este en la �ltima posici�n del archivo, 
				//se sigue leyendo el fichero
				numero = raf.readDouble();
				System.out.println("N�mero de la posici�n "+i+": "+numero);
				i++;
			}
		}
		catch (FileNotFoundException eg)
		{
			System.out.println(eg.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(raf!=null)
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void sustituirNumeros() throws IOException{
		double numeroSustituir, nuevo, numero;
		int i = 0;
		try
		{
			raf = new RandomAccessFile(fichero, "rw");
			raf.seek(0);

			System.out.println("Introduce el valor que desea sustituir");
			numeroSustituir = teclado.nextDouble();
			while (raf.getFilePointer()<raf.length()) {//Mientras el puntero no este en la �ltima posici�n del archivo, 
				//se sigue leyendo el fichero
				numero = raf.readDouble();
				if (numero == numeroSustituir) {//Si el n�mero introducido se encuentra en el fichero.
					System.out.println("Encontrado en la posicion " + i);
					System.out.println("Introduce el nuevo valor");
					nuevo = teclado.nextDouble();
					raf.seek(i*8);//intercambiamos el n�mero por la posici�n de int i * 8(Ya que 1 double en java ocupa 8 bytes)
					raf.writeDouble(nuevo);
				}
				i++;
			}
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(raf!=null)
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception
	{
		elegirOpcion();
	}
}

