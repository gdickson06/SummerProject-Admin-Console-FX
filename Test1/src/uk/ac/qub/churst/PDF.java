package uk.ac.qub.churst;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDF {

	public PDF() {
		// TODO Auto-generated constructor stub
	}
	
	private static PDDocument _pdfDocument;
	 
	private static void populateAndCopy(File originalPdf, String targetPdf) throws IOException {
		_pdfDocument = PDDocument.load(originalPdf);
		
		_pdfDocument.save(targetPdf);
		_pdfDocument.close();
	}

}
