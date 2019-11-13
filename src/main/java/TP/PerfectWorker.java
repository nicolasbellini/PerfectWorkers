package TP;

import java.math.BigInteger;

public class PerfectWorker extends Thread {
	
	Buffer buffer;
	Barrier barrier;
	MonitorResultado res;
	
	public PerfectWorker(Buffer f,Barrier b, MonitorResultado res) {
		this.buffer = f;
		this.barrier = b;
		this.res = res;
	}
	
	public void run() {
		System.out.println("Ejecutando thread: " + this.getId());
		boolean negativo = false;
		while(!negativo) {
			BigInteger a = buffer.get();
			if(a.compareTo(BigInteger.valueOf(0)) > 0){
			verificarNumero(a.longValue());
			}
			else {
				negativo = true;
			}
		}
		System.out.println("PerfectWorker con ID: " + this.getId() + " avisa a barrera");
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
        res.addResultado(BigInteger.valueOf(a));
    	}
    }
}
