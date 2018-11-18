package es.studium.agenciaViajes;
//Implementamos Runnable para poder crear hilos sobre sus instancias
public class agenciaViajes implements Runnable {
	private AsientosAvion aa = new AsientosAvion();
	public void run(){
		synchronized (this) {
			gestionaAsientosAvion(3);
			if(aa.getAsientosLibres()<=0)
				System.out.println("No hay asientos libres");
		}}
	public void gestionaAsientosAvion(int numAsientosReserva){
		//Comprobamos si hay asientos suficientes
		if(aa.getAsientosLibres()>=numAsientosReserva)
		{
			System.out.println(Thread.currentThread().getName()+" hará una reserva de "+
					numAsientosReserva +" plazas");
			try {
				Thread.sleep(1000); //// dormimos el hilo durante un segundo
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			//Hacemos la reserva de los asientos
			aa.reservaAsientos(numAsientosReserva);
			System.out.println(Thread.currentThread().getName() + " Reserva realizada con éxito."+" Las plazas libres ahora son "+aa.getAsientosLibres());
		}else{
			System.out.println("No hay plazas suficientes para el cliente." +
					Thread.currentThread().getName()+" Las plazas libres son "+aa.getAsientosLibres());
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		agenciaViajes objAg = new agenciaViajes();
		//creamos los dos hilos sobre la misma instancia
		Thread Hilo_1 = new Thread(objAg);
		Thread Hilo_2 = new Thread(objAg);
		Hilo_1.setName("Cliente 1");
		Hilo_2.setName("Cliente 2");
		Hilo_1.start();
		Hilo_2.start();
	}
}
class AsientosAvion {
	//empezamos con 5 asientos libres en el avión
	private int asientosLibres = 5;
	public int getAsientosLibres(){
		return asientosLibres ;
	}
	public boolean getAsientosLibres(int numPlazas){
		if (numPlazas<=asientosLibres )
			return true;
		else
			return false;
	}
	public void reservaAsientos(int numAsientosReserva){
		asientosLibres = asientosLibres - numAsientosReserva;
	}
}