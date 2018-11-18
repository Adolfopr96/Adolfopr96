package es.studium.practicaTema2;

import java.util.Scanner;

public class modeloCamellos extends Thread{
	ThreadGroup tgCamellos = new ThreadGroup("Grupos hilos camellos");
	int numCamellos;
	//Thread tCamellos = new Thread(tgCamellos, "Hilo 1");

	public modeloCamellos()
	{

	}
	public void seleccionarCamellos(ThreadGroup tg, int n)
	{
		String num;
		System.out.println ("Por favor introduzca el número de camellos:");
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in);
		entradaTeclado = entradaEscaner.nextLine ();
		numCamellos= Integer.parseInt(entradaTeclado);
		System.out.println(numCamellos);
		num = Integer.toString(numCamellos);
		for (int i=0; i<=numCamellos;i++)
		{			
			Thread tCamellos= new Thread(tg, "Camello "+num);
			Thread tCamellos2 = new Thread(tg, "Camello "+num);
tg.list();
		}
		//tg.list();
	}

}
