Student Details Management System

This is a completely console-based project with clear logical implementation using OOP concepts and CRUD operations.

Step 1:

Create a class named StudentDetails.

Behaviours:
private String RegNo[] = new String[1000];
private String Name[] = new String[1000];
private String ParentName[] = new String[1000];
private String ParentNumber[] = new String[1000];
private String Address[] = new String[1000];
private String Staying[] = new String[1000];

Methods:
EnterDetails()      --> Create  
ShowDetails()       --> Read  
ModifyPartData()    --> Update  
DeleteData()        --> Delete  

Step 2:

In the main method, create an object using the class to use the particular department to create the entries.

Example:

public class Main {
    public static void main(String[] args) {
        StudentDetails obj = new StudentDetails();
        // obj.EnterDetails();
        // obj.ShowDetails();
        // obj.ModifyPartData();
        // obj.DeleteData();
    }
}


This project clearly demonstrates OOP concepts and CRUD operations in a console-based environment.
