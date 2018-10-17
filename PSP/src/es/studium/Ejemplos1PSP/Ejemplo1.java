package es.studium.Ejemplos1PSP;

import java.util.*;
import java.util.concurrent.*;
public class Ejemplo1 {
	static class Multiplicacion implements Callable<Integer> {
		/*
		 * El método run del interface Runnable no devuelve nada.
		 * En la mayor parte de las ocasiones necesitamos que se
		 * ejecute una tarea en paralelo y luego en el futuro nos
		 * devuelva un resultado. ¿Cómo podemos hacer esto?
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
		 * Future representa el resultado de una computación asíncrona.
		 * Se proporcionan métodos para verificar si el cómputo está completo,
		 * para esperar su finalización y para recuperar el resultado del
cómputo.
		 * El resultado solo puede recuperarse usando el método get cuando el
cálculo
		 * se ha completado, bloqueando si es necesario hasta que esté listo.
		 * La cancelación se realiza mediante el método cancel .
		 * Se proporcionan métodos adicionales para determinar si la tarea se
completó
		 * normalmente o se canceló. Una vez que se completa un cómputo, el
cómputo no
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

