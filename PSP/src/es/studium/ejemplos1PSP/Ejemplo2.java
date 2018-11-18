package es.studium.ejemplos1PSP;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Ejemplo2 {
	public static void main(final String... args) throws
	InterruptedException, ExecutionException {
		//Se muestra la hora actual antes de comenzar la ejecución
		Calendar calendario = new GregorianCalendar();
		System.out.println("Inicio: "+ calendario.get(Calendar.HOUR_OF_DAY) +
				":" + calendario.get(Calendar.MINUTE) + ":" +
				calendario.get(Calendar.SECOND));
		// Crea un pool de 2 hilos
		final ScheduledExecutorService schExService =
				Executors.newScheduledThreadPool(2);
		// Crea un objecto Runnable.
		final Runnable ob = new Ejemplo2().new EjecutaHilo();
		// Se programan los hilos, para que inicien en 2 segundos y después se vayan
		// ejecutando cada 3 segundos
		schExService.scheduleWithFixedDelay(ob, 2, 3, TimeUnit.SECONDS);
		// Espera 10 segundos antes de provocar la finalización
		schExService.awaitTermination(10, TimeUnit.SECONDS);
		// Se provoca la finalización.
		schExService.shutdownNow();
		System.out.println("Completado");
	}
	// Hilo Runnable
	class EjecutaHilo implements Runnable {
		@Override
		public void run() {
			Calendar calendario = new GregorianCalendar();
			System.out.println("Hora de ejecución de la tarea: "+
					calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE)
					+ ":" + calendario.get(Calendar.SECOND));
			System.out.println("Tarea en ejecución");
			System.out.println("Ejecución acabada");
		}
	}
}
