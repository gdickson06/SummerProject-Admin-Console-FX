package uk.ac.qub.objects;

public class User extends Staff{
	
	

	@Override
	public String toString() {
		return "User [Type=" + Type + ", Name=" + Name + ", StaffNumber=" + StaffNumber + ", Password=" + Password
				+ "]";
	}

	String Type;





	public User(String name, String StaffNumber, String password, String type) {
		super(name, StaffNumber, password);
		Type = type;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	
	

}
