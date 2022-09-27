package phoneList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the 
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {

	/*
	 * Instance Variables
	 */
	
	ArrayList<Contact> contacts;
	
	//Constructor
	public PhoneList() {
		
		contacts = new ArrayList<Contact>();
	}
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for contact's name and number
	 *   - create a new Contact object with that input
	 *   - add that object to the phone list
	 *        in alphabetical order
	 *        Hint: compareTo(String other)
	 *   - tell the user what the new contact is and that 
	 *        it's been added
	 */
	//addcontact method
	public void addContact() {
		
		//print asking for the contacts name
		System.out.println("\nAdd Contact:\nWhat's the contact's name?");
		//create scanner
		Scanner inKey = new Scanner(System.in); 
		//get name from scanner
		String name = inKey.next();
		//ask for the phone number
		System.out.println("What's the contact's phone number?");
		//get the phone number as a string
		String phoneNumber = inKey.next();
		
		//create a new contact
		Contact contact = new Contact(name, phoneNumber);
		//add contact to an arraylist
		contacts.add(contacts.size(), contact);
		//print the contact was added and the contact info
		System.out.println("New contact added!\nName: " + name + "\nPhone Number: " + phoneNumber);
	}
	
	
	
	/*
	 * This should do the following
	 * (whatever order you feel is best)
	 *   - ask the user for the contact's name
	 *   - search through the list for that contact
	 *   - if the contact is not found
	 *        tell the user and end the method
	 *   - if the contact is found
	 *        Remove the item from the list
	 *        Print the contact's name and number
	 *        Say that contact has been removed
	 *        Remove the item from the list
	 *        
	 */
	public void removeContact() {
		
		//new list to remove the contacts frmo the arraylist without the "checkForComodification" error
		List<Contact> removeFromContacts = new ArrayList<Contact>();
		
		//ask for the contacts name
		System.out.println("\nRemove Contact:\nWhat's the contact's name?");
		
		//create a new scanner
		Scanner inKey = new Scanner(System.in); 
		//get the inputted name
		String name = inKey.next();
		//create a boolean "hasfound" so the loop can stop
		boolean hasFound = false;
		//for every contact in the list
		for (Contact contact : contacts) {
			//if hasnt found the contact yet
			if (!hasFound) {
				//check if the current contacts name is the same as the input 
				if (contact.getName().equalsIgnoreCase(name)) {
					//set found to true
					hasFound = true;
					//add that contact to the remove list
					removeFromContacts.add(contact);
					//print that it removed them
					System.out.println("Removed contact '" + name + "'!");
				}
			}
		}
		//remove the contact from the contacts
		contacts.removeAll(removeFromContacts);
		//if hasnt found at all
		if (!hasFound) {
			//print that it couldnt find the contact
			System.out.println("Couldn't find a contact with the name " + name + "!");
		}
	}
	
	
	/*
	 * This should
	 *   - Print all items in list
	 *   - Must be headers for all columns
	 *   - print in alphabetical order
	 *   - print line of something to "box" the list
	 *       Examples:
	 *          *****************
	 *          -----------------
	 *          #################
	 */
	//printlist method
	public void printList() {
		//create contact list
		System.out.print("\n       CONTACT LIST\n");
		//print out a header
		for (int i = 0; i < 26; i++) { 
			
			System.out.print("-");
		}
		//create a new line
		System.out.print("|\n");
		//for every contact
		for (Contact contact : contacts) {
			//print the contacts as a string
			System.out.println(contact.toString());
			//print the footer
			for (int i = 0; i < 26; i++) { 
				
				System.out.print("-");
			}
			//print new wall
			System.out.print("|\n");
		}
	}

	
	
	/*
	 * GET FAMILIAR WITH THIS MENU!!!!
	 * 
	 * I will be asking you to create programs with menus.
	 * You may do them however you like.  But here is an example
	 * of how to manage them.
	 * 
	 */
	//menu method
	public void menu() {
		//create int input
		int input = 0;
		//menu string to send
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {
				String inputString = getString("\n" + menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
			//check for the input using switch
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				System.out.println("\nNot a valid input.\n"
								 + "Please try again.");
			}
			
			
		
		}
		
	}
	
	//getstring method
	public String getString(String str) {
		//create a new scanner
		Scanner inKey = new Scanner(System.in);
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		//return the new line
		return inKey.nextLine();
		
	}
	
	//main method
	public static void main(String[] args) {
		//create a new phonelist
		PhoneList app = new PhoneList();
		//open the menu
		app.menu();
	}
}
