package TP;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
	
	private ArrayList<PerfectWorker> workers = new ArrayList<PerfectWorker>();
	private Barrier barrier;
	private Buffer buffer;
	private MonitorResultado resultado;
	
	public ThreadPool(int cantThreads, int bufferSize) {
		resultado = new MonitorResultado();
		this.barrier = new Barrier(cantThreads);
		this.buffer = new Buffer(bufferSize);
		for (int i = 0; i < cantThreads; i++) {
			workers.add(new PerfectWorker(buffer, barrier, resultado));
		}
//		int total = lista.size()  + cantThreads;
//		System.out.println("Numeros en buffer: " + total);
		
	}
	
	public void iniciarBuffer(List<BigInteger> numeros, int cantThreads) {

		for (int i = 0; i < numeros.size(); i++) {
			buffer.push(numeros.get(i));
		}
		for (int i = 0; i < cantThreads; i++) {
			buffer.push(BigInteger.valueOf(-1));
		}
	}

	public void startThreads() {
		System.out.println("Cantidad de workers: " + workers.size());
		for (PerfectWorker perfectWorker : workers) {
			perfectWorker.start();
		}
	}

	public ArrayList<PerfectWorker> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<PerfectWorker> workers) {
		this.workers = workers;
	}

	public Barrier getBarrier() {
		return barrier;
	}

	public void setBarrier(Barrier barrier) {
		this.barrier = barrier;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public MonitorResultado getResultado() {
		return resultado;
	}

	public void setResultado(MonitorResultado resultado) {
		this.resultado = resultado;
	}
	
}
