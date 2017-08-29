package uk.ac.qub.sql;


import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.Main;
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;

public class GroupsConSQL {
	
	/**
	 * This method adds the Groups Conversion for Year 1 and 2
	 * @param lectures
	 * @throws Exception
	 */

	public static void GroupsToGroup(List<Lecture> lectures) throws Exception {
		

		Set<GroupsCon> set = new HashSet<GroupsCon>();
		Set<String> s = new HashSet<String>();
		for(Lecture l :lectures){
			s.add(l.getGroup());
			
		}
		
		for (String string : s) {
			
				List<String> group = ConvertMethods.convert(string);

				for (String cohort : group) {
					set.add(new GroupsCon(string,cohort));
				}
			
		}
		
		System.out.println(set.size());
		PreparedStatement statement = null;
		String statements = null;

		for (GroupsCon g : set) {
			System.out.println(g.toString());
			 try {
			 
				statements = "INSERT INTO GroupConvert " + "VALUES ('" + g.getGroups() + "', '" + g.getCohort() + "')";
				statement = Main.connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
