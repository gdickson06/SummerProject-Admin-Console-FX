package uk.ac.qub.methods;

import java.time.LocalDate;
import java.util.List;

import application.ApplicationMethods;

public class test {

	public static void main(String[] args) {
	List<LocalDate> e = AbsenceTrends.dates("2013-01-01","2013-01-02");
	
	for(LocalDate r : e){
		System.out.println(r.toString());
	}
	}

}
