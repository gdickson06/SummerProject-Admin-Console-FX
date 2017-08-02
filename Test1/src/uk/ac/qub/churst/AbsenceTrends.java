package uk.ac.qub.churst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SQL;

public class AbsenceTrends {

	/**
	 * This method will return a list of filtered absences filtered by the
	 * controller on the AbsenceTrendsController Class, this will use a special
	 * object called Extended Absence which will only take the information from
	 * the search terms. For Year this can be gotten through joining the student
	 * table Day will need to have all the absences passed into java and
	 * information be passed to there Staff again need the absences passed to
	 * java and information be converted through other method Cohort can be
	 * joined to the student table Module passed to jav Date Happily taken from
	 * the absence table Student number again taken from the absence table Type
	 * can be taken from the absence too
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public static List<Absence> filteredAbsence(ExtendedAbsence ea) throws SQLException {
		ResultSet r;

		List<Absence> absences = new ArrayList<Absence>();

		String statement = "select * from absence join students using(StudentNumber)";
		Boolean start = true;

		if (ea.getDate() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "'" + ea.getDate() + "' BETWEEN StartTime AND EndTime";
			start = false;
		}

		if (ea.getType() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "type ='" + ea.getType() + "'";
			start = false;
		}

		if (ea.getCohort() != null) {

			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "Cohort ='" + ea.getCohort() + "'";
			start = false;
		}

		if (ea.getStudentNumber() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "StudentNumber ='" + ea.getStudentNumber() + "'";
		}

		if (ea.getStudentNumber() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "StudentNumber ='" + ea.getStudentNumber() + "'";
		}

		statement = statement + ";";

		System.out.println(statement);

		r = SQL.SQLstatements(statement);

		try {
			if (r.next()) {

				do {
					Absence a = new Absence(r.getInt("id"), r.getInt("StudentNumber"), r.getInt("LectureID"),
							r.getString("StartDate"), r.getString("EndDate"), r.getString("StartTime"),
							r.getString("EndTime"), r.getString("Reason"), r.getString("Type"),
							r.getBoolean("Approved"));

					absences.add(a);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This is where the java will be doing the filtering
		// Starting with the easy one

		List<Absence> remove = new ArrayList<Absence>();
		if (ea.getDay() != null) {
			for (Absence a : absences) {
				List<String> days = days(dates(a.getStartDate(), a.getEndDate()));
				if (!days.contains(ea.getDay())) {
					remove.add(a);
				}
			}
		}

		// Now for the painful ones module first

		if (ea.getModule() != null) {
			for (Absence a : absences) {

				List<Lecture> lectures = lecturesFullDay(a);

				if (!a.getStartTime().isEmpty() && !a.getEndTime().isEmpty()) {
					lectures.addAll(lectures(a));
				} else {
					lectures.addAll(lecturesFullDay(a));
				}

				List<String> modules = new ArrayList<String>();

				for (Lecture l : lectures) {
					modules.add(l.getModule());
				}

				if (!modules.contains(ea.getModule())) {
					remove.add(a);
				}
			}

		}

		if (ea.getStaff() != null) {
			for (Absence a : absences) {

				List<Lecture> lectures = lecturesFullDay(a);

				if (!a.getStartTime().isEmpty() && !a.getEndTime().isEmpty()) {
					lectures.addAll(lectures(a));
				} else {
					lectures.addAll(lecturesFullDay(a));
				}

				List<String> staff = new ArrayList<String>();

				for (Lecture l : lectures) {
					staff.add(l.getStaff());
				}

				Boolean removal = true;

				for (String s : staff) {
					if (s.contains(ea.getStaff())) {
						removal = false;
					}
				}

				if (removal) {
					remove.add(a);
				}
			}

		}

		// FINALLY

		absences.removeAll(remove);

		return absences;
	}

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

	private static List<String> days(List<LocalDate> dates) {

		List<String> days = new ArrayList<String>();

		for (LocalDate l : dates) {
			days.add(l.getDayOfWeek().toString());

		}

		return days;
	}

	private static List<Lecture> lecturesFullDay(Absence a) throws SQLException {
		String StudentNumber = String.valueOf(a.getStudentNumber());
		String StartDate = a.getStartDate();
		String EndDate = a.getEndDate();
		List<LocalDate> date = dates(StartDate, EndDate);
		String Cohort = null;
		ResultSet r;
		String statement = "Select * from students WHERE StudentNumber =" + StudentNumber;

		r = SQL.SQLstatements(statement);

		r.next();

		try {
			if (r.next()) {

				Cohort = r.getString("Cohort");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Lecture> lectures = new ArrayList<Lecture>();

		for (LocalDate ld : date) {
			lectures.addAll(SQL.myLectures(Cohort, ld));
		}

		return lectures;
	}

	private static List<Lecture> lectures(Absence a) throws SQLException {
		String StudentNumber = String.valueOf(a.getStudentNumber());
		String StartDate = a.getStartDate();
		String EndDate = a.getEndDate();
		LocalTime StartTime = LocalTime.parse(a.getStartTime());
		LocalTime EndTime = LocalTime.parse(a.getEndTime());
		List<LocalDate> date = dates(StartDate, EndDate);
		String Cohort = null;
		ResultSet r;
		String statement = "Select * from students WHERE StudentNumber =" + StudentNumber;

		r = SQL.SQLstatements(statement);

		r.next();

		try {
			if (r.next()) {

				Cohort = r.getString("Cohort");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Lecture> lectures = new ArrayList<Lecture>();

		for (LocalDate ld : date) {
			lectures.addAll(SQL.myLectures(Cohort, ld));
		}

		for (Lecture l : lectures) {
			LocalTime start = LocalTime.parse(l.getStartTime());

			if (start.isBefore(start) || start.isAfter(EndTime) || start.equals(EndTime)) {
				lectures.remove(l);
			}
		}

		return lectures;
	}

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

	public static Map<String, Double> DateTrend(List<Absence> absences) {

		Map<String, Double> data = new TreeMap<String, Double>();
		List<LocalDate> dates = new ArrayList<LocalDate>();

		for (Absence a : absences) {
			dates.addAll(dates(a.getStartDate(), a.getEndDate()));
		}

		Set<LocalDate> s = new HashSet<LocalDate>();
		s.addAll(dates);

		for (LocalDate ld : s) {
			data.put(ld.toString(), (double) Collections.frequency(dates, ld));
		}
		// Need to amend this as it doesnt count 0 days
		double average = absences.size() / s.size();
		data.put("Average", average);

		return data;
	}

	public static Map<String, Double> StudentNumber(List<Absence> absences) {
		Map<String, Double> data = new TreeMap<String, Double>();
		List<String> stuNo = new ArrayList<String>();

		for (Absence a : absences) {
			stuNo.add(String.valueOf(a.getStudentNumber()));
		}

		Set<String> s = new HashSet<String>();
		s.addAll(stuNo);

		for (String StuNo : s) {
			data.put(StuNo.toString(), (double) Collections.frequency(stuNo, stuNo));
		}
		// Need to amend this as it doesnt count 0 days
		double average = absences.size() / s.size();
		data.put("Average", average);

		return data;

	}

	public static Map<String, Double> YearTrends(List<Absence> absences) throws SQLException {
		Map<String, Double> data = new TreeMap<String, Double>();
		
		List<String> years = new ArrayList<String>();
		for (Absence a : absences) {
			String statement = "select * from absence join students Using (StudentNumber) WHERE absence.id = " +a.getId();
			ResultSet r = SQL.SQLstatements(statement);

			r.next();
			years.add(r.getString("IntakeYear"));

		}

		Set<String> s = new HashSet<String>();
		s.addAll(years);

		for (String year : s) {
			data.put(year, (double) Collections.frequency(years, year));
		}
		// Need to amend this as it doesnt count 0 days
		double average = absences.size() / s.size();
		data.put("Average", average);

		return data;
	}

	public static Map<String, Double> ModuleTrends(List<Absence> absences) throws SQLException {
		
		Map<String, Double> data = new TreeMap<String, Double>();
		List<String> modules = new ArrayList<String>();
		List<Lecture> lectures = new ArrayList<>();
		for (Absence a : absences) {
			lectures.addAll( lecturesFullDay(a));
		}
		
		for(Lecture l : lectures){
			modules.add(l.getModule());
		}
		
		Set<String> s = new HashSet<String>();
		s.addAll(modules);

		for (String module : s) {
			data.put(module, (double) Collections.frequency(modules, module));
		}
		// Need to amend this as it doesnt count 0 days
		double average = absences.size() / s.size();
		data.put("Average", average);

		return data;
		
		
	}

	public static Map<String, Double> StaffTrends(List <Absence> absences) throws SQLException {
		Map<String, Double> data = new TreeMap<String, Double>();
		List<String> staff = new ArrayList<String>();
		List<Lecture> lectures = new ArrayList<Lecture>();
		
		for(Absence a : absences){
			lectures.addAll(lectures(a));
		}
		
		for(Lecture l : lectures){
			staff.addAll(Arrays.asList(l.getStaff().split("/")));
		}
		
		Set<String> s = new HashSet<String>();
		s.addAll(staff);

		for (String staffMember : s) {
			data.put(staffMember, (double) Collections.frequency(staff,staffMember));
		}
		// Need to amend this as it doesnt count 0 days
		double average = absences.size() / s.size();
		data.put("Average", average);

		return data;
	}

	public static Map<String, Double> CohortTrends(List<Absence> absences) throws SQLException {
		Map<String, Double> data = new TreeMap<String, Double>();
		String statement = "select * from absence join students Using (StudentNumber)";
		ResultSet r = SQL.SQLstatements(statement);

		List<String> cohorts = new ArrayList<String>();

		if (r.next()) {

			do {
				cohorts.add(r.getString("IntakeYear") + r.getString("Cohort"));
			} while (r.next());
		}

		Set<String> s = new HashSet<String>();
		s.addAll(cohorts);

		for (String cohort : s) {
			data.put(cohort, (double) Collections.frequency(cohorts, cohort));
		}
		// Need to amend this as it doesnt count 0 days
		double average = absences.size() / s.size();
		data.put("Average", average);

		return data;
	}

}
