package es.studium.tiradaDados;
public class JoinHilos implements Runnable {
	private TiradaDados xobj ;
	public JoinHilos ( TiradaDados m ) {
		xobj = m ;
	}
	public void run ( ) {
		try {
			Thread.sleep ( 1000 ) ;
			int resultadoDado = ( int ) ( Math.random( ) * 6 ) + 1 ;
			xobj. setSumaTirada( resultadoDado ) ;
			System.out.println( "Tirada del hilo" + Thread.currentThread().getName ( ) + ":" + resultadoDado ) ;
		} catch ( InterruptedException e ) {
		}
	}
	public static void main ( String [ ] args ) throws
	InterruptedException {
		TiradaDados tirada = new TiradaDados( 0 ) ;
		JoinHilos obj1 = new JoinHilos( tirada ) ;
		JoinHilos obj2 = new JoinHilos( tirada ) ;
		JoinHilos obj3 = new JoinHilos( tirada ) ;
		Thread hilo_1 = new Thread( obj1 ) ;
		hilo_1.setName( "Dado 1" ) ;
		Thread hilo_2 = new Thread( obj2 ) ;
		hilo_2.setName( "Dado 2" ) ;
		Thread hilo_3 = new Thread( obj3 ) ;
		hilo_3.setName( "Dado 3" ) ;
		hilo_1.start( ) ;
		hilo_2.start( ) ;
		hilo_3.start( ) ;
		hilo_1.join( ) ; // Espera el hilo_1 que el hilo principal, que lo ha invocado termine
		hilo_2.join( ) ;
		hilo_3.join( ) ;
		System.out.println("Total tirada:" + tirada.getSumaTirada( )) ;
		System.out.println("Final del Hilo Principal") ;
	}
	static class TiradaDados {
		private int tiradaDados ;
		public TiradaDados ( int y ) {
			tiradaDados = y ;
		}
		public synchronized int getSumaTirada ( ) {
			return tiradaDados ;
		}
		public synchronized void setSumaTirada ( int y ) {
			tiradaDados += y ;
		}
	}		
}
