package dpAssign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Permanent_Employees extends Employee{

	private String timetoretirement;
	
	


	public Permanent_Employees() throws IOException {
		a = new File("Permanent_Employee.dat");
		if(!a.exists())
			{
				a.createNewFile();
			}
		
		
		
	}
	
	
	public void create_an_account(int employee_id,String Name,String address,int contact_no,int Cnic,String Start_date,String timetoretirement) throws IOException
	{
	
		acc.seek(acc.length());
		
		acc.writeInt(employee_id);
		acc.writeUTF(Name);
		acc.writeUTF(address);
		acc.writeInt(contact_no);
		acc.writeInt(Cnic);
		acc.writeUTF(Start_date);
		acc.writeUTF(timetoretirement);
		
	}
	
	
	public void show_all() throws IOException
	{
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			
			 employee_id = acc.readInt();
			 Name = acc.readUTF();
			
			address = acc.readUTF();
			contact_no = acc.readInt();
			Cnic = acc.readInt();
			Start_date = acc.readUTF();
			timetoretirement =acc.readUTF();
			System.out.println(employee_id+Name+address+contact_no+Cnic+Start_date+ timetoretirement);
			
			
			
		}
	
		
	
		
		
	}
	
	public void findaccount(int findId) throws IOException
	{
		
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			employee_id = acc.readInt();
			 Name = acc.readUTF();
			
			address = acc.readUTF();
			contact_no = acc.readInt();
			Cnic = acc.readInt();
			Start_date = acc.readUTF();
			timetoretirement = acc.readUTF();
			if(employee_id == findId)
			{
				System.out.println(employee_id+Name+address+contact_no+Cnic+Start_date+timetoretirement);
				break;
			}
				
				
			
			
		}
	
		
	
		
		
	}
	
	public void deleteaccount(int delId) throws IOException
	{
		
		File b = new File("temp.dat");
		b.createNewFile();
		RandomAccessFile tempacc = new RandomAccessFile(b,"rw");
		
		
		
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			employee_id = acc.readInt();
			 Name = acc.readUTF();
			
			address = acc.readUTF();
			contact_no = acc.readInt();
			Cnic = acc.readInt();
			Start_date = acc.readUTF();
			timetoretirement = acc.readUTF();
			if(delId != employee_id)
			{
				tempacc.writeInt(this.employee_id);
				tempacc.writeUTF(this.Name);
				tempacc.writeUTF(this.address);
				tempacc.writeInt(this.contact_no);
				tempacc.writeInt(this.Cnic);
				tempacc.writeUTF(this.Start_date);
				tempacc.writeUTF(timetoretirement);
			}
			
			
		}
		acc.close();
		a.delete();
		tempacc.close();
		b.renameTo(a);
		acc = new RandomAccessFile(a,"rw");
		
		
		
		
		
		
		
		
	}
	
	public void access() throws FileNotFoundException 
	{
		acc = new RandomAccessFile(a,"rw");
	}
	public void closeacc() throws IOException
	{
		acc.close();
	}
	public String getTimetoretirement() {
		return timetoretirement;
	}


	public void setTimetoretirement(String timetoretirement) {
		this.timetoretirement = timetoretirement;
	}

}
