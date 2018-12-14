

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class apartado1 {
	static RandomAccessFile raf;
	static File fichero = new File("fichero.bin");
	static Scanner teclado = new Scanner(System.in);

	public static void elegirOpcion() throws Exception //Este método se encarga de abrir la opción seleccionada
	{
		int opcion;
		do {

			System.out.println("1.Añadir numeros de tipo double al principio del fichero");
			System.out.println("2.Añadir numero de tipo double al final del fichero.");
			System.out.println("3.Mostrar el fichero creado.");
			System.out.println("4.Sustituir un número indicado por el usuario por otro numero que también te indique el usuario.");
			System.out.println("5.Salir del programa");
			opcion = teclado.nextInt();

			switch (opcion) {
			case 1: {
				añadirNumeroPrincipio();
				break;
			}
			case 2: {
				añadirNumeroFinal();
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
				System.out.println("Por favor, elija una opción válida");
			}
			}
		} while (opcion != 5);

	}
	public static void añadirNumeroPrincipio(){ 
		try
		{
			raf = new RandomAccessFile(fichero, "rw"); 
			double numero;
			System.out.println("Introduce un numero Double para añadir al principio del fichero: ");
			numero = teclado.nextDouble();
			raf.seek(0); //Se posiciona puntero del random access file en la primera posicion
			raf.writeDouble(numero); //Escribimos el número en la posición del puntero.
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

	public static void añadirNumeroFinal(){
		try
		{
			raf = new RandomAccessFile(fichero, "rw"); 
			double numero;
			System.out.println("Introduce un numero Double para añadir al final del fichero: ");
			numero = teclado.nextDouble();
			raf.seek(raf.length());//Posicionamos el puntero en la última posición del random access file.
			raf.writeDouble(numero); //escribimos el número en la posición del puntero.
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
			while (raf.getFilePointer()<raf.length()) {//Mientras el puntero no este en la última posición del archivo, 
				//se sigue leyendo el fichero
				numero = raf.readDouble();
				System.out.println("Número de la posición "+i+": "+numero);
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
			while (raf.getFilePointer()<raf.length()) {//Mientras el puntero no este en la última posición del archivo, 
				//se sigue leyendo el fichero
				numero = raf.readDouble();
				if (numero == numeroSustituir) {//Si el número introducido se encuentra en el fichero.
					System.out.println("Encontrado en la posicion " + i);
					System.out.println("Introduce el nuevo valor");
					nuevo = teclado.nextDouble();
					raf.seek(i*8);//intercambiamos el número por la posición de int i * 8(Ya que 1 double en java ocupa 8 bytes)
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

