package TP;

public class Barrier {
	
	private int threadsActuales = 0;
	private int threadsObjetivo;
	private boolean terminaronThreads = false;
	
	public Barrier(int to) {
		this.threadsObjetivo = to;
	}
	
	public synchronized void frenarThreads(){
		threadsActuales++;
		while(threadsActuales!=threadsObjetivo) {
			try {
				System.out.println("Workers esperando: " + threadsActuales);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Barrier libera los threads");
		this.terminaronThreads = true;
		notifyAll();
	}
	
	public synchronized long callTime(long startTime) {
		System.out.println("Esperando threads para calcular el tiempo..");
		while(!terminaronThreads) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
//		System.out.println("Tiempo de ejecucion en nanosegundos: " + timeElapsed);
		return timeElapsed;
	}

}
