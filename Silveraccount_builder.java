package dpAssign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Silveraccount_builder extends AccountBuilder{

	private String membership_details;
	private int chargesfortransactions;
	
	public Silveraccount_builder() throws IOException
	{
		a = new File("Silveraccount_builder.dat");
		if(!a.exists())
			{
				a.createNewFile();
			}
		
		
	
	}
	
	public void create_an_account(String Name,String Membership_Type,int Id,int Cnic,int Contact_no,int chargesfortransactions,String membership_details) throws IOException
	{
	
		acc.seek(acc.length());
		
		
		
		
		acc.writeUTF(Name);
		acc.writeUTF(Membership_Type);
		acc.writeInt(Id);
		acc.writeInt(Cnic);
		acc.writeInt(Contact_no);
		
		acc.writeInt(chargesfortransactions);
		acc.writeUTF(membership_details);
		
	}
	
	
	public void show_all() throws IOException
	{
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			Name = acc.readUTF();
			Membership_Type= acc.readUTF();
			Id =acc.readInt();
			Cnic = acc.readInt();
			Contact_no = acc.readInt();
		
			chargesfortransactions= acc.readInt();
			membership_details= acc.readUTF();
			
			
			System.out.println(Name+Membership_Type+Id+Cnic+Contact_no+chargesfortransactions+membership_details);
			
			
		}
	
		
	
		
		
	}
	
	public void findaccount(int findId) throws IOException
	{
		
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			Name = acc.readUTF();
			Membership_Type= acc.readUTF();
			Id =acc.readInt();
			Cnic = acc.readInt();
			Contact_no = acc.readInt();
			
			chargesfortransactions= acc.readInt();
			membership_details= acc.readUTF();
			if(Id == findId)
			{
				System.out.println(Name+Membership_Type+Id+Cnic+Contact_no+chargesfortransactions+membership_details);
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
			Membership_Type= acc.readUTF();
			Id =acc.readInt();
			Cnic = acc.readInt();
			Contact_no = acc.readInt();
			
			chargesfortransactions= acc.readInt();
			membership_details= acc.readUTF();
			
			if(delId != Id)
			{
				tempacc.writeUTF(Name);
				tempacc.writeUTF(Membership_Type);
				tempacc.writeInt(Id);
				tempacc.writeInt(Cnic);
				tempacc.writeInt(Contact_no);
			
				tempacc.writeInt(chargesfortransactions);
				tempacc.writeUTF(membership_details);
				
				
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
	





	public int getChargesfortransactions() {
		return chargesfortransactions;
	}




	public void setChargesfortransactions(int chargesfortransactions) {
		this.chargesfortransactions = chargesfortransactions;
	}




	public String getMembership_details() {
		return membership_details;
	}




	public void setMembership_details(String membership_details) {
		this.membership_details = membership_details;
	}

}
