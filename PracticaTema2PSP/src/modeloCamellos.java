import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class modeloCamellos {

	int num=1;
	int distanciaCarrera;
	int posCamello;
	static int posPrimero=-1;

	int numCamellos;
	static camellos listacamellos[];
	int i=0;
	static ThreadGroup tg = new ThreadGroup("Grupo camellos");

	//Contructor de la clase al que le pasamos el nº de camellos y la distancia de la carrera.
	public modeloCamellos(int n,int d) throws InterruptedException
	{	
		listacamellos = new camellos[n];
		for (int i = 0 ; i < n; i++) {
			listacamellos[i] = new camellos(tg, "camello "+num, d);
			listacamellos[i].start();
			num++;
		}
		for (camellos c : listacamellos) {
			c.join();
		}
		//La carrera ha finalizado, se procede a mostrar el TOP.
		System.out.println("Carrera finalizada");
		System.out.println("La clasificación es la siguiente:");
		//Como la clase camellos implemente Comparable, podemos llamar a la función .sort de la clase Arrays. Esta función llama al método compareTo.
		Arrays.sort(listacamellos,Collections.reverseOrder());//Al estar ordenador de menor a mayor, hacemos reverseOrder para obtener el TOP de forma descendente.
		for (camellos c : listacamellos)//Con este for extendido recorremos todos los objetos camellos ya ORDENADOS.
		{
			System.out.println(c.getName().toString()+ " -- Posición: "+ c.getPosicionCamello());
			//Se muestra el nombre y posActual de cada camello(TOP).
		}
	}	
	public static int getPosPrimero() {
		return posPrimero;
	}
	public static void setPosPrimero(int posPrimero) {
		modeloCamellos.posPrimero = posPrimero;
	}
}