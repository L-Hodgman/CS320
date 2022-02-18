// Author Name: Elizabeth Hodgman
// Date: 01/19/2022
// Course ID: CS-320
// Description: This is the Contact class - used to create and store contact information provided in the ContactService class

package module3;

public class Contact {
	 private final String contactID; // Can not be null & can not be more than 10 characters long 
	 private String firstName;       // Can not be null & can not be more than 10 characters long 
	 private String lastName;        // Can not be null & can not be more than 10 characters long 
	 private String phone;           // Can not be null - exactly 10 characters long
	 private String address;         // Can not be null - not more than 30 characters long
	 
	 // Construct Contact
	 public Contact(String ID, String f_Name, String l_Name, String phoneNum, String homeAddress) {
		 // ID
		 if(ID == null || ID.length() > 10) {
			 throw new IllegalArgumentException("Invalid ID");
		 }		 
		 contactID = ID;
		 
		 // First Name
		 if(f_Name == null || f_Name.length() > 10) {
			 throw new IllegalArgumentException("Invalid First Name Input");
		 }
		 firstName = f_Name;
		 
		 // Last Name
		 if(l_Name == null || l_Name.length() > 10) {
			 throw new IllegalArgumentException("Invalid Last Name Input");
		 }
		 lastName = l_Name;
		 
		 // Phone Number
		 if(phoneNum == null || phoneNum.length() > 10 || phoneNum.length() < 10) {
			 throw new IllegalArgumentException("Invalid Phone Number Input");
		 }
		 phone = phoneNum;
		 
		 // Address
		 if(homeAddress == null || homeAddress.length() > 30) {
			 throw new IllegalArgumentException("Invalid Address Input");
		 }
		 address = homeAddress;
		 
	 }
	 
	 // Getters
	 public String getID() {
		 return contactID;
	 }
	 
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public String getPhoneNum() {
		 return phone;
	 }
	 
	 public String getAddress() {
		 return address;
	 }
	 
	 // Setters
	 public void setFirstName(String f_Name) {
		 if(f_Name == null || f_Name.length() > 10) {
			 throw new IllegalArgumentException("Invalid First Name Input");
		 }
		 firstName = f_Name;
	 }
	 
	 public void setLastName(String l_Name) {
		 if(l_Name == null || l_Name.length() > 10) {
			 throw new IllegalArgumentException("Invalid Last Name Input");
		 }
		 lastName = l_Name;
	 }
	 
	 public void setPhoneNum(String phoneNum) {
		 if(phoneNum == null || phoneNum.length() > 10 || phoneNum.length() < 10) {
			 throw new IllegalArgumentException("Invalid Phone Number Input");
		 }
		 phone = phoneNum;
	 }
	 
	 public void setAddress(String homeAddress) {
		 if(homeAddress == null || homeAddress.length() > 30) {
			 throw new IllegalArgumentException("Invalid Address Input");
		 }
		 address = homeAddress;	 
	 }
	 
}