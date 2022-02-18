// Author Name: Elizabeth Hodgman
// Date: 01/19/2022
// Course ID: CS-320
// Description: This is the ContactService class - used to get and maintain contact information that is sent to the Contact class

package module3;

import java.util.Vector;
import java.util.Random;


public class ContactService {

	private Vector<Contact> contactsInfo = new Vector<Contact>();
	
	public Vector<Contact> getContacts(){
		return contactsInfo;
	}

	public void addContact(String ID, String f_Name, String l_Name, String phoneNum, String homeAddress) {
		Contact newContact = new Contact(
				ID,
				f_Name,
				l_Name,
				phoneNum,
				homeAddress);
		
		contactsInfo.add(newContact);
	}
	
	// Display contacts in list
	public void displayContacts() {
		for(int i = 0; i < contactsInfo.size(); i++) {
			System.out.println("ID: " + getContacts().elementAt(i).getID() + " Name: "
					+ getContacts().elementAt(i).getFirstName() + " "
					+ getContacts().elementAt(i).getLastName() + " Phone: " 
					+ getContacts().elementAt(i).getPhoneNum() + " Address: "
					+ getContacts().elementAt(i).getAddress()); 
		}
		if(contactsInfo.isEmpty()) {
			System.out.println("No contacts to display");
		}
	}
	
	public void deleteContact(String ID) {
		// Check if ID is accurate
		if(ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID Input");
			
		}
		
		// Check if contact list is empty
		if(contactsInfo.isEmpty()) {
			throw new IllegalArgumentException("No Contacts To Delete");
		}
		
		int index = -1;
		for (Contact i : contactsInfo) {
			if (i.getID() == ID) {
				index = contactsInfo.indexOf(i);
			}
			
		}
		if (index == -1) {
			System.out.println("Contact Not Found.");
			return;
		}
		else{
			contactsInfo.remove(index);
			System.out.println("Contact Removed Successfully");
		}
		
		
	}
	
	private void deleteOldContact(Contact contact) {
		contactsInfo.remove(contact);
	}
	
	public void addUpdatedContact(Contact contact) {
		contactsInfo.add(contact);
	}
	
	public void updateContact(String ID, String updateInfo, int input) {
		// Check if contact info is accurate
		if(ID == null || ID.length() > 10 || updateInfo == null || input < 0) {
			throw new IllegalArgumentException("Invalid Input or ID");
		}
		
		// Check if contact list is empty
		if(contactsInfo.isEmpty()) {
			throw new IllegalArgumentException("No Contacts To Update");
		}
		
		int index = -1;
		for (Contact i : contactsInfo) {
			if (i.getID() == ID) {
				index = contactsInfo.indexOf(i);
			}
			
		}
		if (index == -1) {
			System.out.println("Contact Not Found");
			return;
		}
		
		Contact updateContact = contactsInfo.get(index);
		
		switch (input){
		case 1:{
			updateContact.setFirstName(updateInfo);
			break;
		}
		case 2:{
			updateContact.setLastName(updateInfo);
			break;
		}
		case 3:{
			updateContact.setPhoneNum(updateInfo);
			break;
		}
		case 4:{
			updateContact.setAddress(updateInfo);
			break;
		}
		default:{
			System.out.println("Contact Not Updated - Invalid Input");
			break;
		}
		}
		
		deleteOldContact(contactsInfo.elementAt(index));
		addUpdatedContact(updateContact);
				
	}
	
	public String IDGenerator() {
		int min = 1;
		int max = 999999999;
		
		// Generates a random task ID between 1 and 999999999
		Random ID = new Random();
		int newID = ID.nextInt(max - min + 1) + min;
		String randomID = Integer.toString(newID);
		
		// Generate new ID if one already exists in list
		for (Contact i : contactsInfo) {
			while (i.getID() == randomID) {
				newID = ID.nextInt(max - min + 1) + min;
				randomID = Integer.toString(newID);
			}		
		}
				
		return randomID;
	}

	
}
