package uk.ac.qub.objects;

public class Room {
	String code,name;

	public Room(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Room [roomCode=" + code + ", roomName=" + name + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	



}
