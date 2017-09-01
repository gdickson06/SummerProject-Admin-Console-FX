package uk.ac.qub.methods;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import application.ApplicationMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;

public class PDF {
	private static List<String> names;
	private static List<String> cohorts;
	private  static List<String> beginning;
	private String location = "C:/";
	private Lecture l;
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
	private static Font IDFont = new Font(Font.FontFamily.HELVETICA, 30,
            Font.BOLDITALIC,BaseColor.RED);


	public PDF(Lecture l) {
		this.l = l;
	
	}
	




public String getLocation() {
		return location;
	}





	public void setLocation(String location) {
		this.location = location;
	}





/**
 * This method will create the document using the information which is used in the constructor
 * @throws SQLException
 * @throws FileNotFoundException
 * @throws DocumentException
 */
	public void create() throws SQLException, FileNotFoundException, DocumentException {
		
		
		names = new ArrayList<String>();
		cohorts = new ArrayList<String>();
		
		String groupName = l.getGroup();

		List<String> groups = ConvertMethods.convert(groupName);

		for (String group : groups) {
			
			String statement = "Select * from Students where  cohort='" + group + "' AND year_group =" +Integer.parseInt(l.getYear());
			ResultSet students = SQL.SQLstatements(statement);

			while (students.next()) {
				cohorts.add(students.getString("cohort"));
				names.add(students.getString("name"));
			}
		}
		
		beginning = new ArrayList<String>();
		beginning.add(l.getDescription() + " (" + l.getModule() + ")");
		beginning.add("Tutorial Group " + l.getGroup());
		beginning.add("Date : " + l.getStartDate() + "       Time : "
				+ l.getStartTime() + " - " + l.getEndTime());
		beginning.add("Tutor Name: " + l.getStaff());
		beginning.add("Tutor Signature");
		beginning.add(
				"Teaching staff should return completed attendance sheets to the centre for medical education:");
		beginning.add("MBC Site:Reception, Ground Floor, Whitle medical building");
		beginning.add("RVH Site: Reception, First Floor, Mulhouse Building");
		
		
		
			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream(location+"/"+l.getStartDate()+l.getModule()+".pdf"));
			document.open();
			addMetaData(document);
			addContent(document);
			document.close();
		
	}

/**
 * This method will add the metadata to a document
 * @param document
 */
	private void addMetaData(Document document) {
		document.addTitle("Tutorial List");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor(ApplicationMethods.CurrentUser.getName());
		document.addCreator("Medical Hub Administration Console");
	}
	
/**
 * This method will create a table which will be part of a section in a document
 * @param subCatPart
 * @throws BadElementException
 */
	private static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(3);

     

        PdfPCell c1 = new PdfPCell(new Phrase("Cohort"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Name"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Signature"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        
        for(int i=0; i<names.size();i++){
        table.addCell(cohorts.get(i));
        table.addCell(names.get(i));
        table.addCell(" ");
        }

        subCatPart.add(table);

    }
/**
 * This method will add the content to a document
 * @param document
 * @throws DocumentException
 */
	private void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor(beginning.get(0), catFont);
       


        Chapter catPart = new Chapter(new Paragraph(anchor),0);
        catPart.setNumberDepth(0);
        Paragraph subPara = new Paragraph(beginning.get(1));
        
        Section subCatPart = catPart.addSection(subPara);
       subCatPart.setNumberDepth(0);

        subCatPart.add(new Phrase(("ID : " + l.getId()),IDFont));
		for (int i =2; i<beginning.size();i++) {
			subCatPart.add(new Paragraph (beginning.get(i)));
			
		}
		
		subCatPart.add(new Paragraph(" "));
		createTable(subCatPart);
		
		document.add(catPart);
	}
}