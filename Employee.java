package dpAssign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Employee 
{

	public int employee_id;
	public String Name;
	public String address;
	public int contact_no;
	public int Cnic;
	public String Start_date;
	
	public File a;
	
	public RandomAccessFile acc;
	
	
	
	public Employee() throws IOException
	{
		a = new File("Employee.dat");
		if(!a.exists())
			{
				a.createNewFile();
			}
		
		
		
		
		
	}
	
	
	
	
	public void create_an_account(int employee_id,String Name,String address,int contact_no,int Cnic,String Start_date) throws IOException
	{
	
		acc.seek(acc.length());
		
		acc.writeInt(employee_id);
		acc.writeUTF(Name);
		acc.writeUTF(address);
		acc.writeInt(contact_no);
		acc.writeInt(Cnic);
		acc.writeUTF(Start_date);
		
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
			
			System.out.println(employee_id+Name+address+contact_no+Cnic+Start_date);
			
			
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
			
			if(employee_id == findId)
			{
				System.out.println(employee_id+Name+address+contact_no+Cnic+Start_date);
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
			
			if(delId != employee_id)
			{
				tempacc.writeInt(this.employee_id);
				tempacc.writeUTF(this.Name);
				tempacc.writeUTF(this.address);
				tempacc.writeInt(this.contact_no);
				tempacc.writeInt(this.Cnic);
				tempacc.writeUTF(this.Start_date);
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact_no() {
		return contact_no;
	}
	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}
	public int getCnic() {
		return Cnic;
	}
	public void setCnic(int cnic) {
		Cnic = cnic;
	}
	public String getStart_date() {
		return Start_date;
	}
	public void setStart_date(String start_date) {
		Start_date = start_date;
	}
	
	
	
	
	
	
}
