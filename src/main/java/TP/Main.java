package TP;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

public class Main {

	public static void main(String[] args) {
		
		int bufferlength = 210;
		//Maximo 7
		int cantPerfectos = 5;
		int cantThreads = 3;
		
		ArrayList<Long> perfectos = new ArrayList<Long>();
		perfectos.add(6L);
		perfectos.add(28L);
		perfectos.add(496L);
		perfectos.add(8128L);
		perfectos.add(33550336L);
		perfectos.add(8589869056L);
		perfectos.add(137438691328L);
		
		ReportFactory rf = new ReportFactory();
		ArrayList<Long> datos = new ArrayList<Long>();
		
		for (int i = 1; i <= cantThreads; i++) {
			for (int j = 0; j < cantPerfectos; j++) {
				ThreadPool tp = 
						new ThreadPool(perfectos, i, j, bufferlength);
				long startTime = System.nanoTime();
//				System.out.println("Se corren los threads..");
				datos.add((long) i);
				datos.add((long) j);
				tp.startThreads();
				datos.add((long) tp.callTime(startTime));
			}
		}
		try {
			rf.crearReporte(datos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	

}
