package dpAssign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Contracted_Employees extends Employee{
	
	private String contractexpire;
	
	public Contracted_Employees() throws IOException {
		a = new File("Contract_emp.dat");
		if(!a.exists())
			{
				a.createNewFile();
			}
		
		
		
	}
	
	
	public void create_an_account(int employee_id,String Name,String address,int contact_no,int Cnic,String Start_date,String contractexpire) throws IOException
	{
	
		acc.seek(acc.length());
		
		acc.writeInt(employee_id);
		acc.writeUTF(Name);
		acc.writeUTF(address);
		acc.writeInt(contact_no);
		acc.writeInt(Cnic);
		acc.writeUTF(Start_date);
		acc.writeUTF(contractexpire);
		
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
			contractexpire =acc.readUTF();
			System.out.println(employee_id+Name+address+contact_no+Cnic+Start_date+ contractexpire);
			
			
			
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
			contractexpire = acc.readUTF();
			if(employee_id == findId)
			{
				System.out.println(employee_id+Name+address+contact_no+Cnic+Start_date+contractexpire);
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
			contractexpire = acc.readUTF();
			if(delId != employee_id)
			{
				tempacc.writeInt(this.employee_id);
				tempacc.writeUTF(this.Name);
				tempacc.writeUTF(this.address);
				tempacc.writeInt(this.contact_no);
				tempacc.writeInt(this.Cnic);
				tempacc.writeUTF(this.Start_date);
				tempacc.writeUTF(contractexpire);
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
	public String getcontractexpire() {
		return contractexpire;
	}


	public void setcontractexpire(String contractexpire) {
		this.contractexpire = contractexpire;
	}


}
