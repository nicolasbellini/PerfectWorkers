package TP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class ReportFactory {
	
	public void crearReporte(List<Long> parametros) throws FileNotFoundException, DocumentException {
		
		File file = new File("c:/test.pdf");
        file.getParentFile().mkdirs();
		
		Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("reporte.pdf"));
        document.open();
        PdfPTable table = new PdfPTable(3);
        table.addCell("Cant Workers");
        table.addCell("BufferSize");
        table.addCell("Tiempo(Nanosegundos)");
        for(int i = 0; i < parametros.size(); i++){
            table.addCell(parametros.get(i).toString());
        }
        document.add(table);
        document.close();
        System.out.println("Se creo reporte");
    }
		
//		public void generarReporte(List<Integer> bufferSizes, int cantWorkers) {
//			
//			ArrayList<BigInteger> numeros;
//			List<Long> parametros = new ArrayList<Long>();
//			for (int i = 1; i <= cantWorkers; i++) {
//				for (int j = 0; j < bufferSizes.size(); j++) {
//					numeros = new ArrayList<BigInteger>();
//					//Crea la lista llenando el buffer hasta el maximo(deja lugar para -1);
//					for (int n = 1; n <= (bufferSizes.get(j) - i); n++) {
//						numeros.add(BigInteger.valueOf(n));
//					}
//					//Agrega los negativos
//					for (int h = 0; h < i; h++) {
//						numeros.add(BigInteger.valueOf(-1));
//					}
//					System.out.println(numeros.size());
//					System.out.println(bufferSizes.get(j));
//					ThreadPool tp =
//							new ThreadPool(numeros, i, 1500);
//					parametros.add((long) i);
//					parametros.add((long) bufferSizes.get(j));
//					long startTime = System.nanoTime();
//					tp.startThreads();
//					tp.callBarrier();
//					long endTime = System.nanoTime();
//					long timeElapsed = endTime - startTime;
//					parametros.add(timeElapsed);
//				}
//			}
//			try {
//				crearReporte(parametros);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			}
//		}
    
}
