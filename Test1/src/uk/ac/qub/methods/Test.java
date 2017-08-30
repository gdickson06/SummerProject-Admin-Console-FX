package uk.ac.qub.methods;

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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Main.connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		} catch (Exception e) {
			GeneralMethods.show("Database connection error, please check your internet connection", "Error");
		}
		ExtendedAbsence ea = new ExtendedAbsence();
		ea.setStudentNumber(12345678);
		List<Absence> as = AbsenceTrends.absenceFilter(ea);
		
		Map<String,Double> fj = AbsenceTrends.YearTrends(as);
		System.out.println(fj.toString());
		
		System.out.println(as.size());
	}

}
