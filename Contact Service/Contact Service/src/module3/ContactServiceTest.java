// Author Name: Elizabeth Hodgman
// Date: 01/19/2022
// Course ID: CS-320
// Description: This is the unit tests for the ContactService class

package module3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class ContactServiceTest {
	
	@Test
	@DisplayName("Adding a New Contact")
	void testAddContact() {
		
		// Create a new contact
		ContactService contactService = new ContactService();
		String randomID = contactService.IDGenerator();
		// Make sure list is empty
		contactService.displayContacts();
		// Add the new contact to list
		contactService.addContact(randomID, "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		// Confirm contact was added and list is not empty
		assertTrue(!contactService.getContacts().isEmpty());
		assertTrue(contactService.getContacts().elementAt(0).getID().equals(randomID));
		// Display contact list
		contactService.displayContacts();
	}
	
	@Test
	@DisplayName("Testing Unique IDs")
	void testUniqueID() {
		
		// Create a new contact list
		ContactService contactService = new ContactService();
		// generate random IDS
		String randomID1 = contactService.IDGenerator();
		String randomID2 = contactService.IDGenerator();
		String randomID3 = contactService.IDGenerator();
		// Add the new contacts to list
		contactService.addContact(randomID1, "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		contactService.addContact(randomID2, "Trevor", "Olund", "7633108445", "11516 Ilex St");
		contactService.addContact(randomID3, "Lori", "Aspinwall", "7638987818", "11516 Ilex St");
		// Display contacts to show IDs
		contactService.displayContacts();
		// Check if IDs are the same
		assertTrue(contactService.getContacts().elementAt(0).getID() != contactService.getContacts().elementAt(1).getID());
		assertTrue(contactService.getContacts().elementAt(1).getID() != contactService.getContacts().elementAt(2).getID());
		assertTrue(contactService.getContacts().elementAt(0).getID() != contactService.getContacts().elementAt(2).getID());
	}
	
	@Test
	@DisplayName("Delete Contact by ID")
	void testDeleteContact() {
		ContactService contactService = new ContactService();
		// Generate IDs
		String randomID1 = contactService.IDGenerator();
		String randomID2 = contactService.IDGenerator();
		String randomID3 = contactService.IDGenerator();
		// Try to remove a contact before adding contacts
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.deleteContact(randomID1);
		});
		
		// Add new contacts
		contactService.addContact(randomID1, "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		contactService.addContact(randomID2, "Trevor", "Olund", "7633108445", "11516 Ilex St");
		contactService.addContact(randomID3, "Lori", "Aspinwall", "7638987818", "11516 Ilex St");
		// Delete a nonexistent contact ID
		contactService.deleteContact("123");
		// Try to remove with long ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.deleteContact("12345678910");
		});	
		// Try to remove with null ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.deleteContact(null);
		});	
		// Contact list is not empty
		// Contact not removed because contact doesn't exist
		contactService.displayContacts();
		assertTrue(!contactService.getContacts().isEmpty());
		// Delete last contact in list - has 2 contacts
		contactService.deleteContact(randomID3);
		contactService.displayContacts();
		// Remove other contacts
		contactService.deleteContact(randomID1);
		contactService.deleteContact(randomID2);
		// List is empty, count is zero, contacts successfully removed
		contactService.displayContacts();
		assertTrue(contactService.getContacts().isEmpty());
		
	}
	
	@Test
	@DisplayName("Update Contact With Invalid Input")
	void testUpdateContactWithErrors() {
		ContactService contactService = new ContactService();
		String randomID = contactService.IDGenerator();
		// Contact list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "Liz", 1);
		});
		
		// Create new contact, add to list
		contactService.addContact(randomID, "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		// check that contact was added
		assertTrue(!contactService.getContacts().isEmpty());
		
		// ID is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("12345678910", "Liz", 1);
		});
		// ID is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(null, "Liz", 1);
		});
		// Name is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, null, 1);
		});
		// Selection value is less than zero
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "Liz", -1);
		});
		// Updated first name too long - more than 10
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "ElizabethHodgman", 1);
		});
		// Updated last name too long - more than 10
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "ElizabethHodgman", 2);
		});
		// Updated phone number too long - more than 10
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "17632271940", 3);
		});
		// Updated phone number too short - less than 10
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "763227", 3);
		});
		// Updated address too long - more than 30
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, "12345 ABCDEFGHIJKLMNOPQRSTUVWXYZ St", 4);
		});
		// Updated first name null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, null, 1);
		});
		// Updated last name null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, null, 2);
		});
		// Updated phone number null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, null, 3);
		});
		// Updated address null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(randomID, null, 4);
		});
		
		// Print "Contact Not Found" - Wrong ID
		contactService.updateContact("123456789", "Liz", 1);
		
		// Print "Contact Not Updated - Invalid Input"(switch default)
		contactService.updateContact(randomID, "Liz", 5);
		
	}
	
	@Test
	@DisplayName("Update Contact With Valid Input")
	void testUpdateContactWithCorrectInput() {
		ContactService contactService = new ContactService();
		String randomID = contactService.IDGenerator();
		contactService.addContact(randomID, "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		assertTrue(!contactService.getContacts().isEmpty());
		// Display original contact
		contactService.displayContacts();
		
		// Update First Name
		contactService.updateContact(randomID, "Liz", 1);
		assertTrue(contactService.getContacts().elementAt(0).getFirstName().equals("Liz"));
		// Update Last Name
		contactService.updateContact(randomID, "Olund", 2);
		assertTrue(contactService.getContacts().elementAt(0).getLastName().equals("Olund"));
		// Update Phone Number
		contactService.updateContact(randomID, "7638987818", 3);
		assertTrue(contactService.getContacts().elementAt(0).getPhoneNum().equals("7638987818"));
		// Updated Address
		contactService.updateContact(randomID, "12345 Northdale Blvd", 4);
		assertTrue(contactService.getContacts().elementAt(0).getAddress().equals("12345 Northdale Blvd"));
				
		// Check that list has been updated
		// Check for updated first and last name
		assertTrue((contactService.getContacts().elementAt(0).getFirstName().equals("Liz")) && (contactService.getContacts().elementAt(0).getLastName().equals("Olund")));
		// Display contact with updates (ID is the same)
		contactService.displayContacts();
	}

}