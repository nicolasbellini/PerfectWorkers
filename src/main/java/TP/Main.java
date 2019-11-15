package TP;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		ReportFactory rf = new ReportFactory();
		
		int bufferSize = 50;
		int cantNumerosEnBuffer = 10;
		int cantWorkers = 3;
		
		ArrayList<BigInteger> numeros = new ArrayList<BigInteger>();
		for (int i = 1; i <= cantNumerosEnBuffer; i++) {
			numeros.add(BigInteger.valueOf(i));
		}
		
		//Descomentar la cantidad deseada de perfectos.
		numeros.add(BigInteger.valueOf(6));
		numeros.add(BigInteger.valueOf(28L));
		numeros.add(BigInteger.valueOf(496L));
//		numeros.add(BigInteger.valueOf(8128L));
//		numeros.add(BigInteger.valueOf(33550336L));
//		numeros.add(BigInteger.valueOf(8589869056L));
//		numeros.add(BigInteger.valueOf(137438691328L));
		
		ThreadPool tp = new ThreadPool(cantWorkers, bufferSize);
		
		long startTime = System.nanoTime();
		tp.startThreads();
		tp.iniciarBuffer(numeros, cantWorkers);
		tp.getBarrier().callBarrier();

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Tiempo de ejecucion en nanosegundos: " + timeElapsed);

		for (BigInteger bigInteger : tp.getResultado().getResultado()) {
			System.out.println(bigInteger);
		}
		
		//Descomentar para generar reporte
//		List<Integer> bufferSizes = new ArrayList<Integer>();
//		bufferSizes.add(200);
//		bufferSizes.add(400);
//		bufferSizes.add(800);
//		bufferSizes.add(1000);
//		rf.generarReporte(bufferSizes, cantWorkers);
		
	}
	
}

