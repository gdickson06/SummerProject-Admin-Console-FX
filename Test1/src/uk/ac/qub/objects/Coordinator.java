package uk.ac.qub.objects;

public class Coordinator extends Staff {
	
	public Coordinator(String name, String email, String password) {
		super(name, email, password);
		// TODO Auto-generated constructor stub
	}

	String module;

	public Coordinator(String name, String email, String password, String module) {
		super(name, email, password);
		this.module = module;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	

}
