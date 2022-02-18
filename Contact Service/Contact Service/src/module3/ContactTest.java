// Author Name: Elizabeth Hodgman
// Date: 01/19/2022
// Course ID: CS-320
// Description: This is the unit tests for the Contact test

package module3;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


public class ContactTest {

	@Test
	@DisplayName("Contact ID is Null")
	void testIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		});
			
	}
	
	@Test
	@DisplayName("Contact First Name is Null")
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("8434483", null, "Hodgman", "7632271940", "11516 Ilex St");
		});
			
	}
	
	@Test
	@DisplayName("Contact Last Name is Null")
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("8434483", "Elizabeth", null, "7632271940", "11516 Ilex St");
		});
			
	}
	
	@Test
	@DisplayName("Contact Phone Number is Null")
	void testPhoneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("8434483", "Elizabeth", "Hodgman", null, "11516 Ilex St");
		});
			
	}
	
	@Test
	@DisplayName("Contact Address is Null")
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", null);
		});
			
	}
	
	@Test
	@DisplayName("Set All Attributes to Null")
	void testAllNullAttributes() {
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNum(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);
		});
	}
	
	@Test
	@DisplayName("Getters function")
	void testGetters() {
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		assertTrue(contact.getFirstName().equals("Elizabeth"));
		assertTrue(contact.getLastName().equals("Hodgman"));
		assertTrue(contact.getPhoneNum().equals("7632271940"));
		assertTrue(contact.getAddress().equals("11516 Ilex St"));
		assertTrue(contact.getID().equals("8434483"));
	}
	
	@Test
	@DisplayName("Set New First Name")
	void testSetNewFirstName() {
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		contact.setFirstName("Liz");
		assertTrue(contact.getFirstName().equals("Liz"));
	}
	
	@Test
	@DisplayName("Set New Last Name")
	void testSetNewLastName() {
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		contact.setLastName("Olund");
		assertTrue(contact.getLastName().equals("Olund"));
	}
	
	@Test
	@DisplayName("Set New Phone Number")
	void testSetNewPhoneNumber() {
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		contact.setPhoneNum("7638987818");
		assertTrue(contact.getPhoneNum().equals("7638987818"));
	}
	
	@Test
	@DisplayName("Set New Address")
	void testSetNewAddress() {
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		contact.setAddress("12345 Northdale Blvd");
		assertTrue(contact.getAddress().equals("12345 Northdale Blvd"));
	}
	
	@Test
	@DisplayName("Attributes Too Big")
	void testSetMoreThanAllowedCharacters() {		
		Contact contact = new Contact("8434483", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName("Abcdefghijk");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName("Lmnopqrstuv");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNum("12345678910");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress("12345 ABCDEFGHIJKLMNOPQRSTUVWXYZ St");
		});
	}
	
	@Test
	@DisplayName("ID Too Long")
	void testLongID() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("12345678910", "Elizabeth", "Hodgman", "7632271940", "11516 Ilex St");
		});
	}
	
	@Test
	@DisplayName("Phone Number Too Small")
	void testPhoneLessThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("8434483", "Elizabeth", "Hodgman", "763227", "11516 Ilex St");
		});
	}
}