package uk.ac.qub.objects;
/**
 * Name of Package - uk.ac.qub.objects Date Last Amended - 08/09/17 
 * Outline - The below is the Room class that
 *         creates room objects that will be used for the Room Administration
 *         screens within the administration console
 * Demographics � 83 LOC 7 Methods
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
		setCode(code);
		setName(name);
	}
	
	/**
	 * Below is the default constructor for the Room class with no
	 * args
	 */
	public Room() {
		
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
	
			this.code = code;
		
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
	
			this.name = name;
	
	}
	
	/**
	 * Below is the toSting method that will display Room info on the
	 * Room Administration screens
	 */
	@Override
	public String toString() {
		return "Room Code:   " + code + "\t Room Name:   " + name;
	}
}
