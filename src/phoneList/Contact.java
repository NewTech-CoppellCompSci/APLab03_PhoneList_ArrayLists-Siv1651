package phoneList;

/*
 * This contains info for a single contact
 * 
 * Parameters Needed to Store
 *   - Contact's Name
 *   - Contact's Phone Number
 *   
 * Needed Methods
 *   - Constructor(s)
 *   - getter methods
 *   - Setter methods not necessary unless Constructor
 *        initialize variables.
 *   - Override toString() so that Contact can
 *        be printed as part of a list.
 * 
 */



public class Contact {
	
	String name;
	String phoneNumber;
	
	public Contact(String name, String phoneNumber) {
		
		this.name = name;
		this.phoneNumber= phoneNumber;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public String getPhoneNumber() {
		
		return this.phoneNumber;
	}
	
	public void setName(String newName) {
		
		this.name = newName;
	}
	
	public void setPhoneNumber(String newNumber) {
		
		this.phoneNumber = newNumber;
	}
	
	public String toString() {
		
		return "Name: " + this.name + "\nPhone Number: " + this.phoneNumber;
	}

}
