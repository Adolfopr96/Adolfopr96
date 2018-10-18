package es.studium.Ejemplos1PSP;

import java.util.*;
import java.util.concurrent.*;
public class Ejemplo1 {
	static class Multiplicacion implements Callable<Integer> {
		/*
		 * El m�todo run del interface Runnable no devuelve nada.
		 * En la mayor parte de las ocasiones necesitamos que se
		 * ejecute una tarea en paralelo y luego en el futuro nos
		 * devuelva un resultado. �C�mo podemos hacer esto?
		 * Con el interface Callable.
		 */
		private int operador1;
		private int operador2;
		public Multiplicacion(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
		}
		@Override
		public Integer call() throws Exception {
			return operador1 * operador2;
		}
	}
	public static void main(String[] args) throws InterruptedException,
	ExecutionException {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)
				Executors.newFixedThreadPool(3);
		// Creamos un pool con 3 hilos
		List<Multiplicacion> listaTareas= new ArrayList<Multiplicacion>();
		// Creamos la lista de tareas como un listado de Multiplicacion
		// y Multiplicacion eran objetos Callable que usaremos para tareas que devuelven valores
		for (int i = 0; i < 10; i++) {
			Multiplicacion calcula = new Multiplicacion((int)(Math.random()*10),
					(int)(Math.random()*10));
			listaTareas.add(calcula);
		}
		// Cargamos la lista de tareas con Multiplicaciones creadas con multiplicandos generados
		// aleatoriamente.
		List <Future<Integer>> listaResultados;
		/*
		 * Future representa el resultado de una computaci�n as�ncrona.
		 * Se proporcionan m�todos para verificar si el c�mputo est� completo,
		 * para esperar su finalizaci�n y para recuperar el resultado del
c�mputo.
		 * El resultado solo puede recuperarse usando el m�todo get cuando el
c�lculo
		 * se ha completado, bloqueando si es necesario hasta que est� listo.
		 * La cancelaci�n se realiza mediante el m�todo cancel .
		 * Se proporcionan m�todos adicionales para determinar si la tarea se
complet�
		 * normalmente o se cancel�. Una vez que se completa un c�mputo, el
c�mputo no
		 * se puede cancelar.*/
		listaResultados = executor.invokeAll(listaTareas);
		// Se cargan los valores devueltos por el listado de tareas en el listado de resultados
		executor.shutdown();
		// Acabamos con la pool de hilos creada al principio ya que hemos finalizado de recibir sus valores
		for (int i = 0; i < listaResultados.size(); i++) {
			Future<Integer> resultado = listaResultados.get(i);
			try {
				System.out.println("El resultado de la tarea "+i+ " es:" +
						resultado.get());
				// Mostarmos los resultados haciendo uso del metodo get.
			} catch (InterruptedException | ExecutionException e) {
			}
		}
	}
}

