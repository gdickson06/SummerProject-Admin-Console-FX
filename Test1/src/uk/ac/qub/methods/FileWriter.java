package uk.ac.qub.methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;

import java.io.IOException;
/**
 * Name of Package - uk.ac.qub.methods
 * Date Last Amended - 08/09/17
 * Outline - This class will contain the methods to read and write from a txt file
 * Demographics – 46 LOC 2 Methods 
 */
public class FileWriter {
/**
 * This method will save the local info
 * @param info
 */
	public static void save (String info){
		try{
			File f = new File ("SaveInfo.txt");
			
			if(!f.exists()){
				f.createNewFile();
			}
			
			java.io.FileWriter fw = new java.io.FileWriter(f,false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(info);
			bw.close();
			fw.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
/**
 * This method will load the local data	
 * @return
 * @throws IOException
 */
	public static String load () throws IOException{
		
		File f = new File ("SaveInfo.txt");
		FileReader fr = new FileReader(f.getName());
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		br.close();
		fr.close();
		
		return line;
	}

}
