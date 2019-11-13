package TP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
        table.addCell("NThreads");
        table.addCell("NPerfects");
        table.addCell("Tiempo(Nanosegundos)");
        for(int i = 0; i < parametros.size(); i++){
            table.addCell(parametros.get(i).toString());
        }
        document.add(table);
        document.close();
        System.out.println("Se creo reporte");
    }
		
//		public void generarReporte() {
//			for (int i = 1; i <= cantThreads; i++) {
//				for (int j = 0; j <= cantPerfectos; j++) {
//					ThreadPool tp = 
//							new ThreadPool(perfectos, i, j, bufferlength);
//					long startTime = System.nanoTime();
//					long startTime2 = System.currentTimeMillis();
//					System.out.println("Se corren los threads..");
//					datos.add((long) i);
//					datos.add((long) j);
//					tp.startThreads();
//					datos.add((long) tp.callTime(startTime));
//					System.out.println("********FIN FOR PERFECTOS*******");
//				}
//			System.out.println("////////////FINALIZADO////////////");
//			}
//			try {
//				rf.crearReporte(datos);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			}
//		}
    
}
