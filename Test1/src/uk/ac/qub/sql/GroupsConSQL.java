package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;

public class GroupsConSQL {

	public static void GroupsToGroup(List<Lecture> lectures) throws Exception {
		// Using the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		Set<GroupsCon> set = new HashSet<GroupsCon>();

		for (Lecture l : lectures) {
			try {
				List<String> group = ConvertGroup.convert(l.getGroup());

				for (String s : group) {
					set.add(new GroupsCon(l.getGroup(), s));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(l.toString());
			}
		}
		//
		PreparedStatement statement = null;
		String statements = null;

		for (GroupsCon g : set) {
			try {
				statements = "INSERT INTO groups " + "VALUES ('" + g.getGroups() + "', '" + g.getCohort() + "')";
				statement = connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}