package dpAssign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccountBuilder 
{

	public String Name,Membership_Type;
	public int Id,Cnic,Contact_no;
	
	public RandomAccessFile acc;
	public File a;
	
	public AccountBuilder() throws IOException
	{
		a = new File("AccountBuilder.dat");
		if(!a.exists())
			{
				a.createNewFile();
			}
		
		
		
		
		
	}
	
	
	
	
	public void create_an_account(String Name,String Membership_Type,int Id,int Cnic,int Contact_no) throws IOException
	{
	
		acc.seek(acc.length());
		this.Name = Name;
		this.Membership_Type = Membership_Type;
		this.Id = Id;
		this.Cnic = Cnic;
		this.Contact_no = Contact_no;
		
		acc.writeUTF(this.Name);
		acc.writeUTF(this.Membership_Type);
		acc.writeInt(this.Id);
		acc.writeInt(this.Cnic);
		acc.writeInt(this.Contact_no);
		
		
	}
	
	
	public void show_all() throws IOException
	{
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			Name = acc.readUTF();
			Membership_Type = acc.readUTF();
			Id = acc.readInt();
			Cnic = acc.readInt();
			Contact_no = acc.readInt();
			
			
			System.out.println(Name+Membership_Type+Id+Cnic+Contact_no);
			
			
		}
	
		
	
		
		
	}
	
	public void findaccount(int findId) throws IOException
	{
		
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			Name = acc.readUTF();
			Membership_Type = acc.readUTF();
			Id = acc.readInt();
			Cnic = acc.readInt();
			Contact_no = acc.readInt();
			if(Id == findId)
			{
				System.out.println(Name+Membership_Type+Id+Cnic+Contact_no);
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
			Name = acc.readUTF();
			Membership_Type = acc.readUTF();
			Id = acc.readInt();
			Cnic = acc.readInt();
			Contact_no = acc.readInt();
			
			if(delId != Id)
			{
				tempacc.writeUTF(this.Name);
				tempacc.writeUTF(this.Membership_Type);
				tempacc.writeInt(this.Id);
				tempacc.writeInt(this.Cnic);
				tempacc.writeInt(this.Contact_no);
				
				
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
	
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMembership_Type() {
		return Membership_Type;
	}
	public void setMembership_Type(String membership_Type) {
		Membership_Type = membership_Type;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCnic() {
		return Cnic;
	}
	public void setCnic(int cnic) {
		Cnic = cnic;
	}
	public int getContact_no() {
		return Contact_no;
	}
	public void setContact_no(int contact_no) {
		Contact_no = contact_no;
	}
	
	
	
	
	
	
	
}
