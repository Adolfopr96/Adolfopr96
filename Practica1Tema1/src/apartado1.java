

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class apartado1 {
	 static RandomAccessFile raf = null;

	public static void elegirOpcion() throws Exception
	{
		Scanner teclado = new Scanner(System.in);
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
				crearFichero();
				a�adirNumeroPrincipio(raf);
				raf.close();
				break;
			}
			case 2: {
				crearFichero();
				a�adirNumeroFinal(raf);
				raf.close();
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
				System.out.println("Gracias por usar el programa....");
				break;
			}
			default: {
				System.out.println("Por favor, elija una opci�n v�lida");
			}
			}
		} while (opcion != 5);

	}
	public static void crearFichero() {
       
        try {
            File fichero = new File("fichero.bin");
            raf = new RandomAccessFile(fichero, "rw");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
    }
 
    public static void a�adirNumeroPrincipio(RandomAccessFile raf) throws Exception {
        Scanner teclado = new Scanner(System.in);
        double numero;
        System.out.println("Introduce un numero Double para a�adir al principio del fichero: ");
        numero = teclado.nextDouble();
        raf.seek(0);
        raf.writeDouble(numero); 
    } 
    public static void a�adirNumeroFinal(RandomAccessFile raf) throws Exception {
        Scanner teclado = new Scanner(System.in);
        double numero;
        System.out.println("Introduce un numero Double para a�adir al principio del fichero: ");
        numero = teclado.nextDouble();
        raf.seek(raf.length());
        raf.writeDouble(numero); 
    } 
    public static void leerFichero() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File("fichero.bin");
            raf = new RandomAccessFile(fichero, "r");
            mostrarFichero(raf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
    public static void mostrarFichero(RandomAccessFile raf) throws Exception {
        double numero;
        int i=0;
        raf.seek(0);
        while (true) {
            numero = raf.readDouble();
            System.out.println("N�mero de la posici�n "+i+": "+numero);
            i++;
        }
    }
 
    public static void sustituirNumeros() {
        Scanner teclado = new Scanner(System.in);
        double sustituir, nuevo, numero;
        int i = 0;
 
        RandomAccessFile raf = null;
 
        try {
            File fichero = new File("fichero.bin");
            raf = new RandomAccessFile(fichero, "rw");
            raf.seek(0);
 
            System.out.println("Introduce el valor que desea sustituir");
            sustituir = teclado.nextDouble();
 
            System.out.println("Introduce el nuevo valor");
            nuevo = teclado.nextDouble();
 
            while (true) {
                numero = raf.readDouble();
                if (numero == sustituir) {
                    System.out.println("Encontrado en la posicion " + i);
                    raf.seek(i*8);//Necesaria explicaci�n.
                    raf.writeDouble(nuevo);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
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

