package uk.ac.qub.objects;

public abstract class Staff {
	
	@Override
	public String toString() {
		return "Staff [Name=" + Name + ", StaffNumber=" + StaffNumber + ", Password=" + Password + "]";
	}



	String Name,StaffNumber,Password;

	public Staff(String name, String StaffNumber, String password) {
		Name = name;
		this.StaffNumber = StaffNumber;
		Password = password;
	}

	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}



	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}



	public String getStaffNumber() {
		return StaffNumber;
	}



	public void setStaffNumber(String staffNumber) {
		StaffNumber = staffNumber;
	}

	
	
	

	

}
