package uk.ac.qub.churst;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import com.opencsv.CSVReader;

import application.ApplicationMethods;

import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.objects.Room;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Student;

public class CSV {

	/**
	 * This method will return staff when fed in a list of metadata
	 * 
	 * @param metadata
	 * @return
	 */
	private static Staff createStaff(List<String> metadata) {

		String name = metadata.get(1);
		String staffNumber = metadata.get(0);
		String type = metadata.get(2);

		return new Staff(staffNumber, name, type);

	}

	/**
	 * This method will return lecture when fed in a list of metadata
	 * 
	 * @param metadata
	 * @return
	 */
	private static Lecture createLecture(List<String> metadata) {
		int week = Integer.parseInt(metadata.get(0));
		String day = metadata.get(1);
		String startDate = metadata.get(2);
		String startTime = ConvertMethods.timeConvert(metadata.get(3));
		String endTime = ConvertMethods.timeConvert(metadata.get(4));
		String group = metadata.get(5);
		String location = metadata.get(6);
		String subject = metadata.get(7);
		String theme = metadata.get(8);
		String format = metadata.get(9);
		String desc = metadata.get(10);
		String staff = metadata.get(11);
		String style = metadata.get(12);
		String module = metadata.get(13);

		return new Lecture(week, day, startDate, startTime, endTime, group, location, subject, theme, format, desc,
				staff, style, module);
	}

	/**
	 * This method will create a Student from a list of metadata
	 * 
	 * @param metadata
	 * @return
	 * @throws Exception
	 */
	private static Student createStudent(List<String> metadata) throws Exception {

		int studentNumber = Integer.parseInt(metadata.get(0));
		String name = metadata.get(1);
		String cohort = metadata.get(2);
		String email = metadata.get(3);

		if (!ApplicationMethods.Cohorts.contains(cohort)) {
			throw new InputMismatchException();
		}
		return new Student(studentNumber, name, cohort, email);

	}

	/**
	 * This method will create a room from a list of metadata
	 * 
	 * @param metadata
	 * @return
	 */
	public static Room createRoom(List<String> metadata) {
		String code = metadata.get(0);
		String name = metadata.get(1);
		return new Room(code, name);
	}

	/**
	 * This method will create a placement from a list of metadata
	 * 
	 * @param metadata
	 * @param year
	 * @return
	 */
	private static Placement createPlacement(List<String> metadata, int year) {

		String group = metadata.get(2);
		String module = metadata.get(3);
		String start = metadata.get(4);
		String end = metadata.get(5);
		String moduleNo = metadata.get(6);
		String hospital = metadata.get(7);
		String preference = metadata.get(8);
		String comments = metadata.get(9);

		return new Placement(year, start, end, hospital, group, comments, module, moduleNo, preference);
	}

	/**
	 * This method will return a list of rooms from the information fed in from
	 * a CSV file
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static List<Room> readRoomsFromCSV(String fileName) throws IOException {
		List<Room> rooms = new ArrayList<>();

		CSVReader reader = new CSVReader(new FileReader(fileName));
		List<String[]> attributes = reader.readAll();
		attributes.remove(0);
		for (String[] s : attributes) {
			List<String> list = Arrays.asList(s);

			if (list.get(0).isEmpty() == false) {
				Room room = createRoom(list);
				rooms.add(room);
			}
		}

		reader.close();

		return rooms;
	}

	/**
	 * This method will read create a list of lectures from a CSV file
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static List<Lecture> readLecturesFromCSV(String fileName) throws IOException {
		List<Lecture> lectures = new ArrayList<>();

		CSVReader reader = new CSVReader(new FileReader(fileName));
		List<String[]> attributes = reader.readAll();
		attributes.remove(0);
		for (String[] s : attributes) {
			List<String> list = Arrays.asList(s);

			if (list.get(0).isEmpty() == false) {
				Lecture lecture = createLecture(list);
				lectures.add(lecture);
			}
		}

		reader.close();

		return lectures;
	}

	/**
	 * This method will create a list of Students from a CSV
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static List<Student> readStudentsFromCSV(String fileName) throws Exception {
		List<Student> students = new ArrayList<>();

		CSVReader reader = new CSVReader(new FileReader(fileName));
		List<String[]> attributes = reader.readAll();
		attributes.remove(0);
		for (String[] s : attributes) {
			List<String> list = Arrays.asList(s);

			if (list.get(0).isEmpty() == false) {
				Student student = createStudent(list);
				students.add(student);
			}
		}

		reader.close();

		return students;
	}

	/**
	 * This method will create a list of staff from a CSV file
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */

	public static List<Staff> readStaffFromCSV(String filename) throws IOException {

		List<Staff> users = new ArrayList<Staff>();

		CSVReader reader = new CSVReader(new FileReader(filename));
		List<String[]> attributes = reader.readAll();
		attributes.remove(0);
		for (String[] s : attributes) {
			List<String> list = Arrays.asList(s);

			Staff u = createStaff(list);
			users.add(u);
		}

		reader.close();

		return users;
	}

	/**
	 * This method will create a list of Placements from a CSV
	 * 
	 * @param filename
	 * @param year
	 * @return
	 * @throws IOException
	 */
	public static List<Placement> readPlacementsFromCSV(String filename, int year) throws IOException {
		List<Placement> placements = new ArrayList<Placement>();

		CSVReader fileReader = new CSVReader(new FileReader(filename));
		List<String[]> attributes = fileReader.readAll();
		attributes.remove(0);
		for (String[] s : attributes) {
			List<String> list = Arrays.asList(s);

			if (list.get(0).isEmpty() == false) {
				Placement placement = createPlacement(list, year);
				placements.add(placement);
			}
		}

		fileReader.close();

		return placements;
	}

}