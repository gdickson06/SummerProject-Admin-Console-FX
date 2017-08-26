package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson The below is the Room class that
 *         creates room objects that will be used for the Room Administration
 *         screens within the administration console
 */

public class Room {
	
	/*
	 * creating the variables below to be used in the Room constructors,
	 * getters, setters and toString methods below
	 */
	String code,name;
	
	/**
	 * Below is the primary constructor for the Room class
	 * @param code
	 * @param name
	 */
	public Room(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	/**
	 * Below is the default constructor for the Room class with no
	 * args
	 */
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Below is the getter for retrieving the Room code from the Room object
	 * @return
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Below is the setter for setting the Room Code for the Room Object.
	 * If the Room Code is not provided an exception will be thrown
	 * @param code
	 */
	public void setCode(String code) {
		if(!code.isEmpty()){
			this.code = code;
		} else {
			throw new NullPointerException("No Room Code Entered");
		}
	}
	
	/**
	 * Below is the getter for retrieving the Room Name from the Room object
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Below is the setter for setting the Room Name for the Room Object.
	 * If the Room Name is not provided an exception will be thrown
	 * @param name
	 */
	public void setName(String name) {
		if(!name.isEmpty()){
			this.name = name;
		} else {
			throw new NullPointerException("No Room Name Entered");
		}
	}
	
	/**
	 * Below is the toSting method that will display Room info on the
	 * Room Administration screens
	 */
	@Override
	public String toString() {
		return "Room [roomCode=" + code + ", roomName=" + name + "]";
	}
}
