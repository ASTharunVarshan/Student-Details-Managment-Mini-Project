/*
	Title : Student Entry Managment console based mini project
	Author : AS Tharunvarshan
	File : Main.java 
*/

import java.util.*;
import java.io.*;

class StudentDetails 
{
	private Scanner ip = new Scanner(System.in);

	private String RegNo[] = new String[1000];
	private String Name[] = new String[1000];
	private String ParentName[] = new String[1000];
	private String ParentNumber[] = new String[1000];
	private String Address[] = new String[1000];
	private String Staying[] = new String[1000];
	private int counts = 0;
		
	void EnterDetails() 
	{
		System.out.println();
		System.out.print("Enter Register Number           : ");
		RegNo[counts] = ip.nextLine();
		if(counts > 0) // if count is 1 // by the indices it uses 0 1 // so 
		{
			for(int i = counts-1; i >= 0; i--) // i = 0 ; i > = 0 
			{
				if(RegNo[counts].equals(RegNo[i])) // regno of 1 compares to the regno of 0 if equals goes to the start of the method
				{
					System.out.printf("Please Enter the Unique Register number \n");
					EnterDetails();
					return;
				}
			}
		}
		System.out.print("Enter Student Name              : ");
		Name[counts] = ip.nextLine();
		System.out.print("Enter Student's Parent Name     : ");
		ParentName[counts] = ip.nextLine();
		System.out.print("Enter Student's Parent Number   : ");
		ParentNumber[counts] = ip.nextLine();
		System.out.print("Enter Student's Address         : ");
		Address[counts] = ip.nextLine();
		System.out.print("Enter Student's Staying Details : ");
		Staying[counts] = ip.nextLine();

		counts++;
	}

	void ShowDetails() 
	{
		if(counts <= 0) 
		{
			System.out.println("Please Enter the Details");
			EnterDetails();
			return;
		}
		for(int i=0;i<counts;i++) 
		{
			System.out.println();
			System.out.println("Student's Register Number : "+RegNo[i]);
			System.out.println("Student's Name            : "+Name[i]);
			System.out.println("Student's Parent Name     : "+ParentName[i]);
			System.out.println("Student's Parent Number   : "+ParentNumber[i]);
			System.out.println("Student's Address         : "+Address[i]);
			System.out.println("Student's Staying Details : "+Staying[i]);
			System.out.println();
		}
	}

	void ModifyPartData(String RNo) 
	{
		if(counts <= 0) 
		{
			System.out.println("Please Enter the Details");
			EnterDetails();
			return;
		}
		int temp = -1;
		for(int i=0;i<counts;i++) 
		{
			if(RegNo[i].equals(RNo))
			{
				temp = i;
				break;
			}
		}
		if(temp == -1)
		{
			System.out.println("Enter the valid Register Number!");
			return;
		}
		char ch;
		String Before="";
		String After="";  
		String Modify ;
		System.out.println("Enter The choice you want to modify : ");
		System.out.println("Name             --> 1");
		System.out.println("Parent Name      --> 2");
		System.out.println("Parent Number    --> 3");
		System.out.println("Address          --> 4");
		System.out.println("Staying Details  --> 5");
		System.out.println("Nothing Change   --> N");
		ch = ip.next().charAt(0);
		ip.nextLine();
		switch(ch) 
		{
			case '1':
				System.out.print("Enter the New Name : ");
				Modify = ip.nextLine();
				Before = Name[temp];
				After = Name[temp] = Modify;
			break;
				
			case '2':
				System.out.print("Enter the New Parent Name : ");
				Modify = ip.nextLine();
				Before = ParentName[temp];
				After = ParentName[temp] = Modify;
			break;

			case '3':
				System.out.print("Enter the New Parent Number : ");
				Modify = ip.nextLine();
				Before = ParentNumber[temp];
				After = ParentNumber[temp] = Modify;
			break;
				
			case '4':
				System.out.print("Enter the New Address : ");
				Modify = ip.nextLine();
				Before = Address[temp];
				After = Address[temp] = Modify;
			break;

			case '5':
				System.out.print("Enter the New Staying Location : ");
				Modify = ip.nextLine();
				Before = Staying[temp];
				After = Staying[temp] = Modify;
			break;

			default:
				System.out.println("Nothing Changed or Wrongly entered the choice");
			break;
		}
		if(Before.isEmpty() && After.isEmpty())
		{
			System.out.println("No changes");
		}
		else 
		{
			System.out.println("The Register Number : "+RegNo[temp]);
			System.out.println("The Changes ");
			System.out.println(Before +" --> "+After);
		}
	}

	void DeleteData(String RNo) 
	{
		if(counts <= 0) 
		{
			System.out.println("There is No data, Please Enter the Details");
			EnterDetails();
			return;
		}
		int temp = -1;
		for(int i=0;i<counts;i++) 
		{
			if(RegNo[i].equals(RNo))
			{
				temp = i;
				break;
			}
		}
		if(temp == -1)
		{
			System.out.println("Enter the valid Register Number!");
			return;
		}
		if(counts == 1) 
		{
			counts--;
			System.out.println("Successfully Deleted the Data : "+RNo);
			return;
		}
		/*
			if count == 2; means it have indices of 0 1 2 of data FOR EXAMPLE i have 0 -> 12, 1 -> 13, 2 -> 14 Register Numbers
			user requested to deleted the logs of 13 
			so, in temp it already seleted 
			just i am over write the content to before 
			like index 1 have the 13 
			so i am over write the content of of 14 to its 
		*/
		for(int i=temp; i<counts-1; i++) 
		{
			RegNo[i] = RegNo[i+1];
			Name[i] = Name[i+1];
			ParentName[i] = ParentName[i+1];
			ParentNumber[i] = ParentNumber[i+1];
			Address[i] = Address[i+1];
			Staying[i] = Staying[i+1];
		}
		counts--;
		System.out.println("Successfully Deleted the Data : "+RNo);
	}
	
}

public class Main 
{
	public static void main(String args[]) 
	{
		Scanner ip = new Scanner(System.in);
		StudentDetails CSEDept = new StudentDetails();
		StudentDetails ECEDept = new StudentDetails();
		StudentDetails EEEDept = new StudentDetails();
		StudentDetails CivilDept = new StudentDetails();
		StudentDetails MechDept = new StudentDetails();
		char choices;
		char choice;
		String MTemp;
		while(true) 
		{
			System.out.println("Enter Your Department :- ");
			System.out.println("CSE                   --> 1");
			System.out.println("ECE                   --> 2");
			System.out.println("EEE                   --> 3");
			System.out.println("Civil                 --> 4");
			System.out.println("Mech                  --> 5");
			System.out.println("Exit                  --> N");
			choices = ip.next().charAt(0);
			System.out.println();
			switch(choices) 
			{
				case '1':
					while(true) 
					{
						System.out.println();
						System.out.println("Enter Your Choice for CSE :- ");
						System.out.println("Data Entry                 --> 1");
						System.out.println("Show Details               --> 2");
						System.out.println("Modify the Particular Data --> 3");
						System.out.println("Delete the Data            --> 4");
						System.out.println("Exit                       --> N");
						choice = ip.next().charAt(0);
						switch(choice)
						{
							case '1':
								CSEDept.EnterDetails();
								break;
							case '2':
								CSEDept.ShowDetails();
								break;
							case '3':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								CSEDept.ModifyPartData(MTemp);
								break;
							case '4':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								CSEDept.DeleteData(MTemp);
								break;
							default:
								if(choice == 'n' || choice == 'N')
									break;
								else 
									System.out.println("Enter the valid choices or N ");
								break;
						}
						if(choice == 'n' || choice == 'N')
							break;
					}
				break;

				case '2':
					while(true) 
					{
						System.out.println();
						System.out.println("Enter Your Choice for ECE :- ");
						System.out.println("Data Entry                 --> 1");
						System.out.println("Show Details               --> 2");
						System.out.println("Modify the Particular Data --> 3");
						System.out.println("Delete the Data            --> 4");
						System.out.println("Exit                       --> N");
						choice = ip.next().charAt(0);
						switch(choice)
						{
							case '1':
								ECEDept.EnterDetails();
								break;
							case '2':
								ECEDept.ShowDetails();
								break;
							case '3':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								ECEDept.ModifyPartData(MTemp);
								break;
							case '4':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								ECEDept.DeleteData(MTemp);
								break;								
							default:
								if(choice == 'n' || choice == 'N')
									break;
								else 
									System.out.println("Enter the valid choices or N ");
								break;
						}
						if(choice == 'n' || choice == 'N')
							break;
					}
				break;

				case '3':
					while(true) 
					{
						System.out.println();
						System.out.println("Enter Your Choice for EEE :- ");
						System.out.println("Data Entry                 --> 1");
						System.out.println("Show Details               --> 2");
						System.out.println("Modify the Particular Data --> 3");
						System.out.println("Delete the Data            --> 4");
						System.out.println("Exit                       --> N");
						choice = ip.next().charAt(0);
						switch(choice)
						{
							case '1':
								EEEDept.EnterDetails();
								break;
							case '2':
								EEEDept.ShowDetails();
								break;
							case '3':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								EEEDept.ModifyPartData(MTemp);
								break;						
							case '4':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								EEEDept.DeleteData(MTemp);
								break;	
							default:
								if(choice == 'n' || choice == 'N')
									break;
								else 
									System.out.println("Enter the valid choices or N ");
								break;
						}
						if(choice == 'n' || choice == 'N')
							break;
					}
				break;

				case '4':
					while(true) 
					{
						System.out.println();
						System.out.println("Enter Your Choice for Civil :- ");
						System.out.println("Data Entry                 --> 1");
						System.out.println("Show Details               --> 2");
						System.out.println("Modify the Particular Data --> 3");
						System.out.println("Delete the Data            --> 4");
						System.out.println("Exit                       --> N");
						choice = ip.next().charAt(0);
						switch(choice)
						{
							case '1':
								CivilDept.EnterDetails();
								break;
							case '2':
								CivilDept.ShowDetails();
								break;
							case '3':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								CivilDept.ModifyPartData(MTemp);
								break;				
							case '4':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								CivilDept.DeleteData(MTemp);
								break;			
							default:
								if(choice == 'n' || choice == 'N')
									break;
								else 
									System.out.println("Enter the valid choices or N ");
								break;
						}
						if(choice == 'n' || choice == 'N')
							break;
					}
				break;

				case '5':
					while(true) 
					{
						System.out.println();
						System.out.println("Enter Your Choice for Mech :- ");
						System.out.println("Data Entry                 --> 1");
						System.out.println("Show Details               --> 2");
						System.out.println("Modify the Particular Data --> 3");
						System.out.println("Delete the Data            --> 4");
						System.out.println("Exit                       --> N");
						choice = ip.next().charAt(0);
						switch(choice)
						{
							case '1':
								MechDept.EnterDetails();
								break;
							case '2':
								MechDept.ShowDetails();
								break;
							case '3':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								MechDept.ModifyPartData(MTemp);
								break;						
							case '4':
								System.out.print("Enter the Register Number : ");
								MTemp = ip.next();
								MechDept.DeleteData(MTemp);
								break;		
							default:
								if(choice == 'n' || choice == 'N')
									break;
								else 
									System.out.println("Enter the valid choices or N to exit");
								break;
						}
						if(choice == 'n' || choice == 'N')
							break;
					}
				break;
				default:
					if(choices == 'n' || choices == 'N')
						break;
					else 
						System.out.println("Enter the Valid Department ID Given below or N to exit ");
				break;
			}

			if(choices == 'n' || choices == 'N') 
				break;
		}
	}
}