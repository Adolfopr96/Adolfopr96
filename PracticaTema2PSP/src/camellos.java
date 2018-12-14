public class camellos extends Thread implements Comparable<camellos> {
	//La clase extiende de Thread e implemente a Comparable, para poder realizar luego el TOP.
	public int posicionCamello=0;
	///çpublic int posicionPrimero;
	int numCamellos;
	int distanciaCarrera;
	int posFinal;
	int resultado;
	int num=1;
	String posBola="";
	boolean ganador=false;
	camellos listacamellos[];

	//Creamos el constructor de la clase y le pasamos la distancia de la carrera.
	public camellos(ThreadGroup tg, String n)
	{
		super(tg,n);
	}

	public camellos(ThreadGroup tg, String name, int meta) {
		super(tg, name);
		this.distanciaCarrera = meta;
	}
	public  camellos()
	{

	}

	public void run() {
		while(true)
		{
			try {
				//Thread.sleed para comprobar mejor la concurrencia entre hilos.
				Thread.sleep(3000);
				//(int)Math.random()*(750)+500
			} catch (InterruptedException e) {
				//System.out.println(this.getName()+" se ha parado");
				break;
			}

			int probabilidadBola = (int) (Math.random()*(10-0+1)+0);
			if (probabilidadBola<=3)
			{
				resultado=0;
			}
			else if (probabilidadBola>3 && probabilidadBola<=7)
			{
				resultado=1;
			}
			else if (probabilidadBola>7 && probabilidadBola<=9)
			{
				resultado=2;
			}
			else
			{
				resultado=3;
			}

			//Dependiendo del nº aleatorio, el resultado será uno comprendido entre 0 y 3.
			//Mostramos las posiciónes que avanza el camello despues de lanzar.
			//La posActual del camellos ahora es igual a un incremento de esa variable + resultado.
			posicionCamello+=resultado;
			//setPosicionCamello(posicionCamello, resultado);
			//Mostramos la posActual del camello, que lleva sumado el incremento de resultado.
			String mostrarResultado = "";
			if(getPosicionCamello()>modeloCamellos.getPosPrimero())
			{
				modeloCamellos.setPosPrimero(getPosicionCamello());
				mostrarResultado = "El "+ getName() + " avanza "+ resultado + ", va en la posición "+ getPosicionCamello() +" y se encuentra en primera posición";
			}
			else if (getPosicionCamello()==modeloCamellos.getPosPrimero())
			{
				mostrarResultado = "El "+ getName() + " avanza "+ resultado + ", va en la posición "+ getPosicionCamello() +" y va primero empatado con otro camello";

			}
			else
			{
				mostrarResultado = "El "+ getName() + " avanza "+ resultado + ", va en la posición "+ getPosicionCamello() +" a "+obtenerDiferencia(modeloCamellos.getPosPrimero())+ " posiciones del primero.";
			}			
				
			if (getPosicionCamello()>=distanciaCarrera)
			{
				System.out.println(mostrarResultado);
				modeloCamellos.tg.interrupt();
				//this.getThreadGroup().interrupt();
			}
			else
			{
				System.out.println(mostrarResultado);
			}
		
			//System.out.println("--------------------------");
			
		}
	}
	//Método compareTo para realizar el TOP.
	public int compareTo(camellos c) { //Le pasamos un objeto tipo camellos como parámetro.
		//Creamos dos variables tipo Integer.
		Integer camello1 = this.posicionCamello; //Esta varible es igual que el valor de PosActual de camello Actual.
		Integer camello2= c.posicionCamello;
		//Esta variable es igual que la posActual del camello pasado por parámetro, uaunque realmente
		//Es la referencia en memoria de ese camello.
		return camello1.compareTo(camello2);
		//Devolvemos la comparación entre las dos variables anteriormente creadas.
		//La función compareTo se encarga de realizar las comparaciones una a una de cada posición.
		//Para ordenarlas de menor a mayor.
	}
	//Cramos un método sincronizado encargado de obtener las casillas de diferencia con respecto al primero.
	public synchronized int obtenerDiferencia(int posP) { //Le pasamos la posicion del primero por parámetros.
		Integer camello1 = this.posicionCamello;  //Esta varible es igual que el valor de PosActual de camello Actua
		Integer camello2= posP; //Esta variable es igual que posPrimero, que en su defecto, está inicializada en 0.
		return camello2 - camello1;
	}

	//Este bloque de métodos inspectores se encuentra sincronizado para que puedan hacer uso de estas variables de forma concurrente.
	public  int getPosicionCamello() {
		return posicionCamello;
	}
	public void setPosicionCamello(int posicionCamello,int r) {
		this.posicionCamello += r;
	}
	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}
	public void setDistanciaCarrera(int distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}
}