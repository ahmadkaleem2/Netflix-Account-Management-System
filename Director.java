package dpAssign3;

import java.io.IOException;
import java.util.Scanner;
public class Director {
 private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws IOException 
	{
		
		while(true)
		{
			System.out.print("Main Menu\n0:Exit\n1: Employee Menu\n2: Account Menu\n3: Value Added Services");
			int choice = input.nextInt();
			
			if(choice ==0)
			{
				System.exit(0);
			}
			else if(choice ==1)
			{	
				EmployeeMenu();
			}
			else if(choice ==2)
			{
				AccountMenu();
			}
			else if(choice==3)
			{
				Services();
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
	
	}
	public static void Perm_Employee() throws IOException
	{
		Permanent_Employees e = new Permanent_Employees();
		e.access();
		
		
		
		
		while(true)
		{
		System.out.println("What do you want to do?\n0: Main Menu\n1: Add an Employee\n2:View All Employee\n3:Search An Employee\n4:Delete An Employee Record");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
				int employee_id = input.nextInt();
				String Name = input.next();
				String address = input.next();
				int contact_no = input.nextInt();
				int Cnic = input.nextInt();
				String Start_date = input.next();
				String timetoretirement = input.next();
				
				
				e.create_an_account(employee_id, Name, address, contact_no, Cnic, Start_date, timetoretirement);
			}
			else if(choice==2)
			{
				e.show_all();
			}
			else if(choice==3)
			{
				int id = input.nextInt();
				e.findaccount(id);
			}
			else if(choice==4)
			{
				int delId = input.nextInt();
				
				e.deleteaccount(delId);
			}
			
			
			
		}
		e.closeacc();
	}
	public static void Contract_Employee() throws IOException
	{
		Contracted_Employees e = new Contracted_Employees();
		e.access();
		
		
		
		
		while(true)
		{
		System.out.println("What do you want to do?\n0: Main Menu\n1: Add an Employee\n2:View All Employee\n3:Search An Employee\n4:Delete An Employee Record");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
				int employee_id = input.nextInt();
				String Name = input.next();
				String address = input.next();
				int contact_no = input.nextInt();
				int Cnic = input.nextInt();
				String Start_date = input.next();
				String contractexpire = input.next();
				
				
				e.create_an_account(employee_id, Name, address, contact_no, Cnic, Start_date, contractexpire);
			}
			else if(choice==2)
			{
				e.show_all();
			}
			else if(choice==3)
			{
				int id = input.nextInt();
				e.findaccount(id);
			}
			else if(choice==4)
			{
				int delId = input.nextInt();
				
				e.deleteaccount(delId);
			}
			
			
			
		}
		e.closeacc();
		
	}
	
	public static void EmployeeMenu() throws IOException
	{
		
		
		
		
		
		while(true)
		{
		System.out.println("What do you want to do?\n0:Main Menu\n1:Permanent Employee\n2:Contracted Employee");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
				Perm_Employee();
			}
			else if(choice==2)
			{	
				Contract_Employee();
			}
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void AccountMenu() throws IOException
	{
		
		while(true)
		{
		System.out.println("What do you want to do?\n0:Main Menu\n1:Silver Account\n2:Gold Account");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
				Silver_account();
			}
			else if(choice==2)
			{	
				Gold_account();
			}
			
			
			
		}
		
		
	}
	
	public static void Gold_account() throws IOException
	{
		GoldAccount_Builder e = new GoldAccount_Builder();
		e.access();
		
		
		
		
		while(true)
		{
		System.out.println("What do you want to do?\n0: Back\n1: Add an Account\n2:View All Accounts\n3:Search An Account\n4:Delete An Account");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
			
				String Name = input.next();
				String Membership_Type = input.next();
				int Id = input.nextInt();
				int Cnic = input.nextInt();
				int Contact_no = input.nextInt();
				String incentives = input.next();
				int chargesfortransactions = input.nextInt();
				String membership_details = input.next();
				
				
			e.create_an_account(Name, Membership_Type, Id, Cnic, Contact_no, incentives, chargesfortransactions, membership_details);
			}
			else if(choice==2)
			{
				e.show_all();
			}
			else if(choice==3)
			{
				int id = input.nextInt();
				e.findaccount(id);
			}
			else if(choice==4)
			{
				int delId = input.nextInt();
				
				e.deleteaccount(delId);
			}
			
			
			
		}
		e.closeacc();
	}
	
	public static void Silver_account() throws IOException
	{
		Silveraccount_builder e = new Silveraccount_builder();
		e.access();
		
		
		
		
		while(true)
		{
		System.out.println("What do you want to do?\n0: Back\n1: Add an Account\n2:View All Accounts\n3:Search An Account\n4:Delete An Account");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
				String Name = input.next();
				String Membership_Type = input.next();
				int Id = input.nextInt();
				int Cnic = input.nextInt();
				int Contact_no = input.nextInt();
				int chargesfortransactions = input.nextInt();
				String membership_details = input.next();
				
				
				e.create_an_account(Name, Membership_Type, Id, Cnic, Contact_no, chargesfortransactions, membership_details);
			}
			else if(choice==2)
			{
				e.show_all();
			}
			else if(choice==3)
			{
				int id = input.nextInt();
				e.findaccount(id);
			}
			else if(choice==4)
			{
				int delId = input.nextInt();
				
				e.deleteaccount(delId);
			}
			
			
			
		}
		e.closeacc();
		
	}
	
	public static void Services() throws IOException
	{
		ValueADDEDSERVICES e = new ValueADDEDSERVICES();
		e.access();
		
		
		
		
		while(true)
		{
		System.out.println("What do you want to do?\n0: Back\n1: Add an Account\n2:View All Accounts\n3:Search An Account\n4:Delete An Account");
		int choice = input.nextInt();
			if(choice==0)
			{
				break;
			}
			else if(choice==1)
			{
				int employee_id = input.nextInt();
				String nameofservices = input.next();
				int chargesforservices = input.nextInt();
				
			e.create_service(employee_id, nameofservices, chargesforservices);
			}
			else if(choice==2)
			{
				e.show_all();
			}
			else if(choice==3)
			{
				int id = input.nextInt();
				e.findactivatedservices(id);
			}
			else if(choice==4)
			{
				int delId = input.nextInt();
				
				e.deleteid(delId);
			}
			
			
			
		}
		e.closeacc();
	}

}
