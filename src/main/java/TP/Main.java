package TP;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) {
		
		ReportFactory rf = new ReportFactory();
		
		int bufferSize = 300;
		int cantNumerosEnBuffer = 250;
		int cantWorkers = 3;
		
		ArrayList<BigInteger> numeros = new ArrayList<BigInteger>();
		for (int i = 1; i <= cantNumerosEnBuffer; i++) {
			numeros.add(BigInteger.valueOf(i));
		}
		numeros.add(BigInteger.valueOf(6));
		numeros.add(BigInteger.valueOf(28L));
		numeros.add(BigInteger.valueOf(496L));
//		numeros.add(BigInteger.valueOf(8128L));
//		numeros.add(BigInteger.valueOf(33550336L));
//		numeros.add(BigInteger.valueOf(8589869056L));
//		numeros.add(BigInteger.valueOf(137438691328L));
		
		ArrayList<Long> datos = new ArrayList<Long>();
		
		ThreadPool tp1 = new ThreadPool(numeros, cantWorkers, bufferSize);
		
		long startTime = System.nanoTime();
		tp1.startThreads();
		tp1.callBarrier();

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Tiempo de ejecucion en nanosegundos: " + timeElapsed);

//		rf.generarReporte();
		
	}
	
}

