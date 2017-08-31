package uk.ac.qub.methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import application.Main;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;
import uk.ac.qub.sql.SQL;

public class Test {

	public static void main(String[] args) throws SQLException {
		System.out.println("?//");
		try{
		
			File f = new File (FileWriter.load()+"/SaveInffo.txt");
			
			if(!f.exists()){
				f.createNewFile();
			}
			System.out.println("34");
			java.io.FileWriter fw = new java.io.FileWriter(f,false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Hello");
			bw.close();
			fw.close();
			FileReader fr = new FileReader(f.getName());
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			br.close();
			fr.close();
			System.out.println(line+"3");
			System.out.println(f.getPath());
		} catch (Exception e){
			e.printStackTrace();
		}

}
	}
