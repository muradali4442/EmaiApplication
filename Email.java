package emailapp;

import java.util.Scanner;

public class Email {
private String firstname;
private String lastname;
private String password;
private String department;
private String alternateEmail;
private int defaultPasswordlength=10;
private int mailboxCapacity=500;
private String email;
private String companysuffix= "tu-ilmenau.de";

//Constructor to receive the 1st name and last name

public Email(String firstname, String lastname) {
	this.firstname=firstname;
	this.lastname=lastname;
	//System.out.println("Email Created: " +this.firstname+ " " +this.lastname);
	
	//call a method asking for the department and also return the department
	this.department=SetDepartment();
	//System.out.println("Department " +this.department);
	
	//call a method that returns a random password
	this.password=randomPassword(defaultPasswordlength);
	System.out.println("your password is: " +this.password);
	
	//Combine elements to generate email
	email= firstname.toLowerCase() + "." + lastname.toLowerCase()+ "@" + department + "." +companysuffix;
	//System.out.println("your emails is:" + email);
}



//Ask for the department
private String SetDepartment() {
	System.out.print("New worker " +firstname+ "\nDepartment Code \n1 for sale\n2 for development\n3 for accounting\n0 for none\nEnter the department\n");
	Scanner in= new Scanner(System.in);
	int dptChoice= in.nextInt();
	if(dptChoice==1) {return "sales";}
	else if(dptChoice==2) {return "dev";}
	else if(dptChoice==3) {return "acct";}
	else {return "";}
	
}
//generate a random password

private String randomPassword(int length) {
	String passwordSet="ABCDEFGHIJKLmnopqrstuvWXYZ0123456789!@#$%&*";
	char[]password= new char [length];
	for (int i=0; i<length; i++) {
		int rand=(int) (Math.random() * passwordSet.length());
		password[i]=passwordSet.charAt(rand);
		//System.out.println(rand);
		//System.out.println(passwordSet.charAt(rand));
		
	}
	return new String(password);
	
	
}


//set the maibox capacity
public void setMailboxCapacity(int capacity) {
	this.mailboxCapacity =capacity;
}
//set th ealternate email
public void setAlternateemail(String altEmail) {
	this.alternateEmail=altEmail;
}

//change the password
public void changePassword(String password) {
	this.password=password;
}

public int getMailboxCapacity() {return mailboxCapacity;}
public String getAlternateEmail() {return alternateEmail;}
public String getPassword() {return password;}

public String showInfo() {
	return "Display Name: " +firstname + " " +lastname +
			"\nCompnay Email: " +email +
			"\nMailbox Capacity: " +mailboxCapacity + "mb";
	
}

}
