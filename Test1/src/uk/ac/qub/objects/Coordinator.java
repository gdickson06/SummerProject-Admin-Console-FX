package uk.ac.qub.objects;

public class Coordinator extends Staff {
	
	
	@Override
	public String toString() {
		return "Coordinator [module=" + module + ", email=" + email + ", Name=" + Name + ", StaffNumber=" + StaffNumber
				+ ", Password=" + Password + "]";
	}

	String module, email;

	

	

	public Coordinator(String name, String StaffNumber, String password, String module, String email) {
		super(name, StaffNumber, password);
		this.module = module;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	

}
