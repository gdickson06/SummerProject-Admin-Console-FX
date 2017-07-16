package uk.ac.qub.objects;

public class User {
	
	String UserName,Name,Password,Type;

	

	public User(String userName, String name, String password, String type) {
		super();
		UserName = userName;
		Name = name;
		Password = password;
		Type = type;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
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

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	
	

}
