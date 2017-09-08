package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.Main;
import uk.ac.qub.methods.ConvertMethods;
import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;

/**
 * Name of Package - uk.ac.qub.sql Date Last Amended - 08/09/17 Outline - This
 * class will contain the method to upload the GroupsCon to the databse
 * absence Demographics – 64 LOC 1 Methods
 */
public class GroupsConSQL {

	/**
	 * This method adds the Groups Conversion for Year 1 and 2
	 * 
	 * @param lectures
	 * @throws Exception
	 */

	public static void GroupsToGroup(List<Lecture> lectures) throws Exception {

		Set<GroupsCon> set = new HashSet<GroupsCon>();
		Set<String> s = new HashSet<String>();
		for (Lecture l : lectures) {
			s.add(l.getGroup());

		}

		for (String string : s) {

			List<String> group = ConvertMethods.convert(string);

			for (String cohort : group) {
				set.add(new GroupsCon(string, cohort));
			}

		}

		PreparedStatement statement = null;
		String statements = null;

		for (GroupsCon g : set) {
			try {

				statements = "INSERT INTO GroupConvert " + "VALUES ('" + g.getGroups().replaceAll("'", "''") + "', '"
						+ g.getCohort().replaceAll("'", "''") + "')";
				statement = Main.connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
