

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class apartado2 {
	 public static void elegirOpcion() {
	        int opcion;
	        do {
	            Scanner teclado = new Scanner(System.in);
	            System.out.println("1.Crear fichero binario");
	            System.out.println("2.Mostrar Fichero");
	            System.out.println("3.Salir del pograma");
	 
	            opcion = teclado.nextInt();
	 
	            switch (opcion) {
	                case 1: {
	                    crearFichero();
	                }
	                case 2: {
	                    mostrarFichero();
	                }
	                case 3: {
	                    System.out.println("Gracias por usar el prorama");
	                }
	                default: {
	    				System.out.println("Por favor, elija una opción válida");
	    			}
	 
	            }
	        } while (opcion != 3);
	 
	    }
	    public static void crearFichero() {
	        DataOutputStream dos = null;
	 
	        try {
	            FileOutputStream fos = new FileOutputStream("datos.bin");
	            dos = new DataOutputStream(fos);
	            escribirFichero(dos);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (dos != null) {
	                    dos.close();
	                }
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	 
	            }
	        }
	    }
	 
	    public static void escribirFichero(DataOutputStream dos) throws Exception {
	        Scanner teclado = new Scanner(System.in);
	 
	        String Nombre;
	        int Edad;
	        String Nacimiento;
	 
	        System.out.println("Introduce tu nombre:");
	        Nombre = teclado.next();
	        System.out.println("Introduce tu edad:");
	        Edad = teclado.nextInt();
	        System.out.println("Introduce tu Ciudad de nacimiento:");
	        Nacimiento = teclado.next();
	 
	        dos.writeUTF(Nombre);
	        dos.writeInt(Edad);
	        dos.writeUTF(Nacimiento);
	 
	    }
	 
	    public static void mostrarFichero() {
	        DataInputStream dis = null;
	        try {
	            FileInputStream fis = new FileInputStream("datos.bin");
	            dis = new DataInputStream(fis);
	            leerFichero(dis);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	 
	        } finally {
	            try {
	                if (dis != null) {
	                    dis.close();
	                }
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	 
	            }
	        }
	    }
	 
	    public static void leerFichero(DataInputStream dis) throws Exception {
	        while (true) {
	            System.out.println("Nombre: "+dis.readUTF());
	            System.out.println("Edad: "+dis.readInt());
	            System.out.println("Lugar de nacimiento: "+dis.readUTF());
	 
	        }
	    }
	 
	    public static void main(String[] args) {
	 
	        elegirOpcion();
	    }
}
