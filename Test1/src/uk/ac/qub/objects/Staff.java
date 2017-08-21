package uk.ac.qub.objects;

public class Staff {

	@Override
	public String toString() {
		return "staff number:" + staff_number + " name:" + name + ", access level:" + access_level ;
	}

	String staff_number, name, access_level;
	
	

	public Staff(String staff_number, String name, String access_level) {
		this.staff_number = staff_number;
		this.name = name;
		this.access_level = access_level;
	}

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public String getStaff_number() {
		return staff_number;
	}

	public void setStaff_number(String staff_number) {
		this.staff_number = staff_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccess_level() {
		return access_level;
	}

	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}

}
