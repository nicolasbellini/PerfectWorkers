package TP;
public class PerfectWorker extends Thread {
	
	Buffer buffer;
	Barrier barrier;
	
	public PerfectWorker(Buffer f,Barrier b) {
		this.buffer = f;
		this.barrier = b;
	}
	
	public void run() {
		System.out.println("Ejecutando thread: " + this.getId());
		boolean negativo = false;
		while(!negativo) {
			long a = buffer.get();
			if(a > 0){
			verificarNumero(a);
			}
			else {
				negativo = true;
			}
		}
		System.out.println(this.getClass().getName() + " con ID: " + this.getId() + " avisa a barrera");
		barrier.frenarThreads();
	}

    public synchronized void verificarNumero(long a) {
    long sum = 0;
    for(long i = 1; i < a; i++){
        if(a % i == 0){
            sum = sum + i;
        	}
    	}
    if(sum == a){
        System.out.println(a + " es un numero perfecto.");
    	}
    }
}
