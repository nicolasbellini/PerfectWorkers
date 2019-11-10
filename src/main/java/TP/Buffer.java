package TP;

public class Buffer extends Thread{
	
	long[] buffer;
	int size;
	//Para el pull
	int currentPosition = 0;
	//Para el push
	int lastAdded = 0;
	int nextAdd = 0;
	
	public Buffer(int n) {
		this.buffer = new long[n];
		this.size = n;
	}

	public synchronized void push(long n) {
		while(bufferLleno()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buffer[nextAdd] = n;
		lastAdded = nextAdd;
		nextAdd++;
		notifyAll();
	}

	public synchronized long get(){
		while(bufferVacio()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long a = buffer[currentPosition];
		currentPosition++;
		notifyAll();
		return a;
	}
	
	private boolean bufferVacio() {
		return nextAdd==0;
	}

	private boolean bufferLleno() {
		return (nextAdd+1 % size) == 0;
	}
	
	
}
