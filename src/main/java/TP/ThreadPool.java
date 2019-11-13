package TP;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
	
	private ArrayList<PerfectWorker> workers = new ArrayList<PerfectWorker>();
	private Barrier barrier;
	
	public ThreadPool(ArrayList<BigInteger> lista,int cantThreads, int bufferSize) {
		MonitorResultado res = new MonitorResultado();
		this.barrier = new Barrier(cantThreads);
		Buffer buffer = crearBuffer(bufferSize, lista, cantThreads);
		for (int i = 0; i < cantThreads; i++) {
			workers.add(new PerfectWorker(buffer, barrier, res));
		}
		int total = lista.size()  + cantThreads;
		System.out.println("Numeros en buffer: " + total);
		
	}
	
	public Buffer crearBuffer(int bufferSize, List<BigInteger> numeros, int cantThreads) {
		
		Buffer buffer = new Buffer(bufferSize);
		for (int i = 0; i < numeros.size(); i++) {
			buffer.push(numeros.get(i));
		}
		for (int i = 0; i < cantThreads; i++) {
			buffer.push(BigInteger.valueOf(-1));
		}
		
		return buffer;
	}

	public void startThreads() {
		System.out.println("Cantidad de workers: " + workers.size());
		for (PerfectWorker perfectWorker : workers) {
			perfectWorker.start();
		}
	}

	public void callBarrier() {
		barrier.callBarrier();
	}
	
}
