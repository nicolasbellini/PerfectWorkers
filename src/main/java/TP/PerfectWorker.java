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
				verificarNumero(a);
			}
			else {
				negativo = true;
			}
		}
		System.out.println("PerfectWorker con ID: " + this.getId() + " avisa a barrera");
		barrier.frenarThreads();
	}
	
    public synchronized void verificarNumero(BigInteger a) {
    BigInteger sum = BigInteger.valueOf(0);
    for(BigInteger i = BigInteger.valueOf(1); i.compareTo(a) < 0; i = i.add(BigInteger.valueOf(1))){
        if(a.divideAndRemainder(i)[1]  == BigInteger.valueOf(0)){
            sum = sum.add(i);
        	}
    	}
    if(sum == a){
        System.out.println(a + " es un numero perfecto.");
        res.addResultado(a);
    	}
    else {
    	System.out.println(a);
    }
    }
}
