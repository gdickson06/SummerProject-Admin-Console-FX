package uk.ac.qub.churst;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.objects.Room;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Student;
import uk.ac.qub.objects.User;

public class CSV {
	
	

	/**
	 * This method takes the String and returns a router with the 1-5 areas of
	 * the String array
	 * 
	 * @param metadata
	 * @return
	 */
	private static Coordinator createCoordinator (List<String> metadata){
		//String name, String StaffNumber, String password, String module, String email
		
		String name = metadata.get(1);
		String staffNumber = metadata.get(2);
		String password = metadata.get(3);
		String module = metadata.get(4);
		String email = metadata.get(5);
		
		return new Coordinator(name,staffNumber,password,module,email);
	}
	
	public static User createUser(List<String> metadata){
		
		//String name, String StaffNumber, String password, String type
		String name = metadata.get(1);
		String staffNumber = metadata.get(2);
		String password = metadata.get(3);
		String type = metadata.get(0);
		
		return new User(name, staffNumber, password, type);
		
	}
	
	
	private static Lecture createLecture(List<String> metadata) {
		int week = Integer.parseInt(metadata.get(0));
		String day = metadata.get(1);
		String startDate = metadata.get(2);
		String startTime = ConvertGroup.timeConvert(metadata.get(3));
		String endTime = ConvertGroup.timeConvert(metadata.get(4));
		String group = metadata.get(5);
		String location = metadata.get(6);
		String subject = metadata.get(7);
		String theme = metadata.get(8);
		String format = metadata.get(9);
		String desc = metadata.get(10);
		String staff = metadata.get(11);
		String style = metadata.get(12);
		String module = metadata.get(13);
		

		return new Lecture(week, day, startDate, startTime, endTime,group,location,subject,theme,format,desc,staff,style,module);
	}
	
	public static Student createStudent(List<String> metadata){
		
		int studentNumber = Integer.parseInt(metadata.get(0));
		String name = metadata.get(1);
		String firstGroup = metadata.get(2);
		String email = metadata.get(3);
		
		
		return new Student(studentNumber, name, firstGroup,email);
	}
	
	public static Room createRoom(List<String>metadata){
		String code = metadata.get(0);
		String name= metadata.get(1);
		return new Room(code,name);
	}
	//creating placement
	public static Placement createPlacement(List<String> metadata, int year){
		int week = Integer.parseInt(metadata.get(0));
		String startDate = metadata.get(1);
		String endDate = metadata.get(2);
		String subject = metadata.get(3);
		String location = metadata.get(4);
		String clinicalTeacher = metadata.get(5);
		String cohort = metadata.get(6);
		int yearGroup = year;
		String note = metadata.get(7);
		
		return new Placement(week,startDate,endDate, subject, location, clinicalTeacher, cohort, yearGroup, note);	
	}

	public static List<Room>readRoomsFromCSV(String fileName){
		List<Room> rooms = new ArrayList<>();

		try  {
			
				CSVReader reader = new CSVReader(new FileReader(fileName));
			     List<String[]> attributes = reader.readAll();
			     attributes.remove(0);
			     for(String[] s: attributes){
			    List<String> list = Arrays.asList(s);
			    
			    if(list.get(0).isEmpty()==false){
				Room room = createRoom(list);
				rooms.add(room);
			    }
			     }
				
			reader.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Error");
		}
		
		// return the list of lectures
		return rooms;
	}
	

	public static List<Lecture> readLecturesFromCSV(String fileName) {
		List<Lecture> lectures = new ArrayList<>();

		try  {
			
				CSVReader reader = new CSVReader(new FileReader(fileName));
			     List<String[]> attributes = reader.readAll();
			     attributes.remove(0);
			     for(String[] s: attributes){
			    List<String> list = Arrays.asList(s);
			    
			    if(list.get(0).isEmpty()==false){
				Lecture lecture = createLecture(list);
				lectures.add(lecture);
			    }
			     }
				
			reader.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Error");
		}
		
		// return the list of lectures
		return lectures;
	}
	
	public static List<Student> readStudentsFromCSV(String fileName) throws Exception {
		List<Student> students = new ArrayList<>();

		
			
				CSVReader reader = new CSVReader(new FileReader(fileName));
			     List<String[]> attributes = reader.readAll();
			     attributes.remove(0);
			     for(String[] s: attributes){
			    List<String> list = Arrays.asList(s);
			    
			    if(list.get(0).isEmpty()==false){
				Student student = createStudent(list);
				students.add(student);
			    }
			     }
				
			reader.close();
			
		
		
		// return the list of lectures
		return students;
	}
	
	
	
	
	
	
	
public static List<Staff> readStaffFromCSV (String filename){
		
		List<Staff> users = new ArrayList<Staff>();
		
		try  {
			
			CSVReader reader = new CSVReader(new FileReader(filename));
		     List<String[]> attributes = reader.readAll();
		     attributes.remove(0);
		     for(String[] s: attributes){
		    List<String> list = Arrays.asList(s);
		    
		    if(list.get(0).isEmpty()==false){
		    	if(list.get(0).equalsIgnoreCase("Module Coordinator")){
			Coordinator c = createCoordinator(list);
			users.add(c);
		    	} else {
		    		User u = createUser(list);
		    		users.add(u);
		    	}
		    }
		     }
			
		reader.close();
		
	} catch (IOException ioe) {
		ioe.printStackTrace();
		System.out.println("Error");
	}
		
		
		return users;
	}
	
	
public static List<Placement> readPlacementsFromCSV(String filename, int year){
	List<Placement> placements = new ArrayList<Placement>();
	try {
		CSVReader fileReader = new CSVReader(new FileReader(filename));
		List<String[]> attributes = fileReader.readAll();
		attributes.remove(0);
		for(String[] s: attributes){
		List<String> list = Arrays.asList(s);
		    
		if(list.get(0).isEmpty()==false){
				Placement placement = createPlacement(list,year);
				placements.add(placement);
			}
		}
		
		fileReader.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Error reading placements from CSV");
	}
	return placements;
}

}