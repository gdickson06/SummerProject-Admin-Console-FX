package uk.ac.qub.objects;

public class Staff {
	
	String Name,Email,Password;

	public Staff(String name, String email, String password) {
		Name = name;
		Email = email;
		Password = password;
	}

	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Staff [Name=" + Name + ", Email=" + Email + ", Password=" + Password + "]";
	}
	
	

	

}
