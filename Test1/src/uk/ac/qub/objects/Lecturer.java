package uk.ac.qub.objects;

public class Lecturer {
	
	String module,name,email;

	public Lecturer(String name, String email, String module) {
		this.module = module;
		this.name = name;
		this.email = email;
	}
	
	

	public String getModule() {
		return module;
	}



	public void setModule(String module) {
		this.module = module;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Lecturer [module=" + module + ", name=" + name + ", email=" + email + "]";
	}


}
