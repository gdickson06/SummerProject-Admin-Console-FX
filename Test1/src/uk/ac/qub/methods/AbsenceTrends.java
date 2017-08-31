package uk.ac.qub.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;
import uk.ac.qub.objects.Lecture;

import uk.ac.qub.sql.SQL;

public class AbsenceTrends {

	/**
	 *This method will filter an absence using a class known as extended absence
	 *this allows the absence to be joined with the student class to give a list of
	 *absences which can be used for the trends
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	
	public static List<Absence> absenceFilter(ExtendedAbsence a) throws SQLException{
		
		ResultSet r;

		List<Absence> absences = new ArrayList<Absence>();
		System.out.println(a.getStudentNumber());
		String statement = "select * from Absences join Students using (student_number) ";
		Boolean start = true;
		if (a.getStart()!=null) {
			statement = statement + " Where end_date >= " + a.getStart();
			start = false;
		}

		if (a.getEnd()!=null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "start_date<=" + a.getEnd();
			start = false;
		}

		if (a.getType()!=null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "type ='" + a.getType() + "'";
			start = false;
		}

		if (a.getStudentNumber()!=0) {
			
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "student_number=" + a.getStudentNumber() + "";
			start = false;
		}

		if(a.getYear()!=0){
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "year_group=" + a.getYear() + "";
			
		}

		statement = statement + ";";

		System.out.println(statement);

		r = SQL.SQLstatements(statement);

	
			if (r.next()) {

				do {
					Absence abs = new Absence(r.getInt("absences_id"),r.getInt("student_number"), r.getInt("lecture_id"), r.getString("start_date"), r.getString("end_date"),
							r.getString("start_time"),r.getString("end_time"), r.getString("reason"), r.getString("type"), r.getBoolean("approved"),r.getBoolean("viewed"));
					
					absences.add(abs);
				} while (r.next());

			}
		
		
			
		
		return absences;
		
		
		
	}
/**
 * This method gives a list of dates between the start and end date
 * @param start
 * @param end
 * @return
 */
	private static List<LocalDate> dates(String start, String end) {

		LocalDate startDate = LocalDate.parse(start);

		LocalDate endDate = LocalDate.parse(end);
		List<LocalDate> totalDates = new ArrayList<>();
		while (!startDate.isAfter(endDate)) {
			totalDates.add(startDate);
			startDate = startDate.plusDays(1);
		}

		return totalDates;
	}
/**
 * This method gives a list of days from a list of LocalDates
 * @param dates
 * @return
 */
	private static List<String> days(List<LocalDate> dates) {

		List<String> days = new ArrayList<String>();

		for (LocalDate l : dates) {
			days.add(l.getDayOfWeek().toString());

		}

		return days;
	}
/**
 * This method shows all of the lectures for a full day absence
 * @param a
 * @return
 * @throws SQLException
 */
	private static List<Lecture> lecturesFullDay(Absence a) throws SQLException {
		String StudentNumber = String.valueOf(a.getStudentNumber());
		String StartDate = a.getStartDate();
		String EndDate = a.getEndDate();
		List<LocalDate> date = dates(StartDate, EndDate);
		String Cohort = null;
		ResultSet r;
		int year=0;
		String statement = "Select * from Students WHERE student_number =" + StudentNumber;

		r = SQL.SQLstatements(statement);

	
		try {
			if (r.next()) {

				Cohort = r.getString("cohort");
				year = r.getInt("year_group");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Lecture> lectures = new ArrayList<Lecture>();

		for (LocalDate ld : date) {
			lectures.addAll(SQL.myLectures(Cohort, ld,year));
		}

		return lectures;
	}
/**
 * This method returns all of the lectures for a partial day of absence
 * @param a
 * @return
 * @throws SQLException
 */
	private static List<Lecture> lectures(Absence a) throws SQLException {
		System.out.println(a.getId());
		String StudentNumber = String.valueOf(a.getStudentNumber());
		String StartDate = a.getStartDate();
		String EndDate = a.getEndDate();
		LocalTime StartTime = LocalTime.parse(a.getStartTime());
		LocalTime EndTime = LocalTime.parse(a.getEndTime());
		List<LocalDate> date = dates(StartDate, EndDate);
		String Cohort = null;
		int year=0;
		ResultSet r;
		String statement = "Select * from Students WHERE student_number =" + StudentNumber;

		r = SQL.SQLstatements(statement);

	

		try {
			if (r.next()) {

				Cohort = r.getString("cohort");
				year = r.getInt("year_group");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		List<Lecture> lectures = new ArrayList<Lecture>();

		for (LocalDate ld : date) {
			lectures.addAll(SQL.myLectures(Cohort, ld,year));
		}
		String time;
		List<Lecture> lectures2 = new ArrayList<Lecture>();
		lectures2.addAll(lectures);
		for (Lecture l : lectures) {
			
			time = l.getStartTime();
			if(time.length()==4){
				time=0+time;
			}
			LocalTime start = LocalTime.parse(time);

			if (start.isBefore(StartTime) || start.isAfter(EndTime) || start.equals(EndTime)) {
				System.out.println(l.toString());
				lectures2.remove(l);
			}
			
		}

		return lectures2;
	}
/**
 * This method gives the number of absences on Monday, Tuesday, Wednesday, Thursday
 * and Friday. This method does not count time off in lectures just if any part
 * of the day was missed. If there were two partial days of absence this will count
 * as two different absences
 * @param absences
 * @return
 */
	public static Map<String, Double> DayTrend(List<Absence> absences) {

		Map<String, Double> data = new LinkedHashMap<String, Double>();
		List<String> days = new ArrayList<String>();

		for (Absence a : absences) {
			days.addAll(days(dates(a.getStartDate(), a.getEndDate())));
		}

		data.put("Monday", (double) Collections.frequency(days, "MONDAY"));
		data.put("Tuesday", (double) Collections.frequency(days, "TUESDAY"));
		data.put("Wednesday", (double) Collections.frequency(days, "WEDNESDAY"));
		data.put("Thursday", (double) Collections.frequency(days, "THURSDAY"));
		data.put("Friday", (double) Collections.frequency(days, "FRIDAY"));

		Double average = (days.size() - Double.valueOf(Collections.frequency(days, "SATURDAY"))
				- Double.valueOf(Collections.frequency(days, "SUNDAY"))) / 5;
		data.put("Average", average);

		return data;
	}

	

/**
 * This method shows the trends of year absences, this shows how many
 * absences are taken per year compared to the average
 * @param absences
 * @return
 * @throws SQLException
 */
	public static Map<String, Double> YearTrends(List<Absence> absences) throws SQLException {
		Map<String, Double> data = new TreeMap<String, Double>();
		
		List<String> years = new ArrayList<String>();
		for (Absence a : absences) {
			String statement = "select * from Absences join Students Using (student_number) WHERE absences_id = " +a.getId();
			ResultSet r = SQL.SQLstatements(statement);

			r.next();
			List<LocalDate> datesOff = dates(r.getString("start_date"),r.getString("end_date"));
			List<String> daysOff = days(datesOff);
			int numOff =0;
			
			for(String s : daysOff){
				
				if(s.equals("MONDAY")||s.equals("TUESDAY")||s.equals("WEDNESDAY")||s.equals("THURSDAY")||s.equals("FRIDAY")){
					numOff++;
				}
			}
			for(int i =0; i<numOff; i++){
			years.add(r.getString("year_group"));
			}
		}

		Set<String> s = new HashSet<String>();
		String [] yearGroups = {"1","2","3","4","5"};
		s.addAll(Arrays.asList(yearGroups));

		for (String year : s) {
			data.put("Year " +String.valueOf(Integer.parseInt(year)), (double) Collections.frequency(years, year));
		}
		System.out.println(absences.size());
		double average = (double)(absences.size())/5;
		System.out.println(average);
		data.put("Average", average);

		return data;
	}
/**
 * This lists all modules and compares to the average number of absences over the searched
 * range, this will assume that there is likely to be at least one absence in all modules
 * over a period of time and this means that modules with 0 absences will be not shown
 * or took into concideration for the average. This is to help with any filtering so that
 * filtering by year would not allow for absences for certain year's modules
 * 
 * @param absences
 * @return
 * @throws SQLException
 */
	public static Map<String, Double> ModuleTrends(List<Absence> absences) throws SQLException {
	
		Map<String, Double> data = new TreeMap<String, Double>();
		List<String> modules = new ArrayList<String>();
		List<Lecture> lectures = new ArrayList<>();
		
		for (Absence a : absences) {
			if(a.getStartTime().equalsIgnoreCase("null")){
			lectures.addAll( lecturesFullDay(a));
			} else {
				
				lectures.addAll(lectures(a));
			}
		}
		
		for(Lecture l : lectures){
			modules.add(l.getModule());
		}
		
		Set<String> s = new HashSet<String>();
		s.addAll(modules);

		for (String module : s) {
			data.put(module, (double) Collections.frequency(modules, module));
		}
		
		double average = (double)modules.size() / (double)SQL.Modules().size();
		Set<String> s1 =SQL.Modules();
		s1.removeAll(modules);
		for(String empty : s1){
			data.put(empty, 0.0);
		}
		
		
		data.put("Average", average);

		return data;
		
		
	}
/**
 * This will show the trends of which staff members have most absences and runs off 
 * the same logic as the module trends method
 * @param absences
 * @return
 * @throws SQLException
 */
	public static Map<String, Double> StaffTrends(List <Absence> absences) throws SQLException {
		Map<String, Double> data = new TreeMap<String, Double>();
		List<String> staff = new ArrayList<String>();
		List<Lecture> lectures = new ArrayList<Lecture>();
		
		for(Absence a : absences){
			if(a.getStartTime().equalsIgnoreCase("null")){
				lectures.addAll(lecturesFullDay(a));
			}else{
			lectures.addAll(lectures(a));
			}
		}
		
		for(Lecture l : lectures){
			staff.addAll(Arrays.asList(l.getStaff().split("/")));
		}
		
		Set<String> s = new HashSet<String>();
		s.addAll(staff);

		for (String staffMember : s) {
			data.put(staffMember, (double) Collections.frequency(staff,staffMember));
		}
		
		double average = (double)absences.size() / (double)SQL.Staff().size();
		data.put("Average", average);
		
		Set<String> nonMissed = SQL.Staff();
		nonMissed.removeAll(staff);
		
		for(String staffMember: nonMissed){
			data.put(staffMember, 0.0);
		}
		

		return data;
	}
	
	public static List<String> topTen(List<Absence>list){
		List<Integer> results = new ArrayList<Integer>();
		List<String> answers = new ArrayList<String>();
		Map<Integer, Integer> answer = new HashMap<>();
		Set<Integer> students = new HashSet<Integer>();
		
		for(Absence a : list){
			results.add(a.getStudentNumber());
		}
		
		students.addAll(results);
		
		for(Integer i : students){
			answer.put(i, Collections.frequency(results, i));
		}
		
	
		
		Map<Integer,Integer> topTen =
			   answer.entrySet().stream()
			       .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
			       .limit(10)
			       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		for(Entry<Integer,Integer> entry : topTen.entrySet()){
			answers.add(entry.getKey().toString() +  " : " +entry.getValue().toString()+ " absences");
		}
		
		Collections.reverse(answers);
		return answers;
	}
	

}
