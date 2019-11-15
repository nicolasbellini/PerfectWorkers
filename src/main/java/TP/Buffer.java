package TP;

import java.math.BigInteger;

public class Buffer extends Thread{
	
	BigInteger[] buffer;
	int size;
	//Para el pull
	int currentPosition = 0;
	//Para el push
	int lastAdded = 0;
	int nextAdd = 0;
	
	public Buffer(int n) {
		this.buffer = new BigInteger[n];
		this.size = n;
	}

	public synchronized void push(BigInteger n) {
		while(bufferLleno()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buffer[nextAdd] = n;
		lastAdded = nextAdd;
		nextAdd = (nextAdd+1) % size;
		notifyAll();
	}

	public synchronized BigInteger get(){
		while(bufferVacio()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		BigInteger a = buffer[currentPosition];
		currentPosition = ((currentPosition + 1) % size);
		notifyAll();
		return a;
	}
	
	private boolean bufferVacio() {
		return nextAdd==0;
	}

	private boolean bufferLleno() {
		return ((nextAdd+1) % size) == 0;
	}
	
	
}
