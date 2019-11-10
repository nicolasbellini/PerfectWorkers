package TP;
import java.util.ArrayList;

public class ThreadPool {
	
	private ArrayList<PerfectWorker> workers = new ArrayList<PerfectWorker>();
	private Barrier barrier;
	private ArrayList<Long> listaPerfectos;
	
	public ThreadPool(ArrayList<Long> listaPerfectos,int cantThreadsParaBarrier, int nPerfectos, int bufferSize) {
		this.listaPerfectos = listaPerfectos;
		this.barrier = new Barrier(cantThreadsParaBarrier);
		Buffer buffer = crearBufferConNPerfectNumbers(nPerfectos, bufferSize);
		for (int i = 0; i < cantThreadsParaBarrier; i++) {
			workers.add(new PerfectWorker(buffer, barrier));
		}
		
	}
	
	public Buffer crearBufferConNPerfectNumbers(int nPerfectos, int bufferSize) {
		
		Buffer buffer = new Buffer(bufferSize);
		
		for (int i = 1; i < 200; i++) {
			if(i!=6 && i!=28) {
				buffer.push(i);
			}
		}
		
		for (int i = 0; i < nPerfectos; i++) {
			buffer.push(this.listaPerfectos.get(i));
		}
		
		buffer.push(-1);
		buffer.push(-1);
		buffer.push(-1);
		buffer.push(-1);
		buffer.push(-1);
		return buffer;
	}

	public void startThreads() {
		System.out.println("Cantidad de workers: " + workers.size());
		for (PerfectWorker perfectWorker : workers) {
			perfectWorker.start();
		}
	}

	public long callTime(long startTime) {
		return(barrier.callTime(startTime));
		
	}
	
}
