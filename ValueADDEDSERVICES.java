package dpAssign3;
import java.io.*;
public class ValueADDEDSERVICES 
{

	private File a;
	RandomAccessFile acc;
	private String nameofservices;
	private int employee_id,chargesforservices;
	
	public ValueADDEDSERVICES() throws IOException {
		a = new File("Services.dat");
		if(!a.exists())
			{
				a.createNewFile();
			}
		
		
		
	}
	
	
	public void create_service(int employee_id,String nameofservices,int chargesforservices) throws IOException
	{
	
		acc.seek(acc.length());
		
		acc.writeInt(employee_id);
		acc.writeUTF(nameofservices);
		acc.writeInt(chargesforservices);
	
		
	}
	
	
	public void show_all() throws IOException
	{
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			
		employee_id	=acc.readInt();
		nameofservices = acc.readUTF();
		chargesforservices	=acc.readInt();
		
		System.out.printf("%s %s %s\n",employee_id,nameofservices,chargesforservices);
				
		}
	
		
	
		
		
	}
	
	public void findactivatedservices(int id) throws IOException
	{
		
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			employee_id = acc.readInt();
			nameofservices = acc.readUTF();
			chargesforservices	=acc.readInt();
			
			if(id == employee_id)
			{
				System.out.printf("%s %s %s\n", employee_id, nameofservices,chargesforservices);
				break;
			}
				
				
			
			
		}
	
		
	
		
		
	}
	
	public void deleteid(int delId) throws IOException
	{
		
		File b = new File("temp.dat");
		b.createNewFile();
		RandomAccessFile tempacc = new RandomAccessFile(b,"rw");
		
		
		
		acc.seek(0);
		while(acc.getFilePointer()<acc.length())
		{
			employee_id = acc.readInt();
			nameofservices = acc.readUTF();
			chargesforservices	=acc.readInt();
			
			if(delId != employee_id)
			{
				tempacc.writeInt(employee_id);
				tempacc.writeUTF(nameofservices);
				tempacc.writeInt(chargesforservices);
			}
			
			
		}
		acc.close();
		a.delete();
		tempacc.close();
		b.renameTo(a);
		acc = new RandomAccessFile(a,"rw");
		
		
		
		
		
		
		
		
	}


	public String getNameofservices() {
		return nameofservices;
	}


	public void setNameofservices(String nameofservices) {
		this.nameofservices = nameofservices;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public int getChargesforservices() {
		return chargesforservices;
	}


	public void setChargesforservices(int chargesforservices) {
		this.chargesforservices = chargesforservices;
	}


	public void access() throws IOException
	{
		
		acc = new RandomAccessFile(a,"rw");
		
	}


	public void closeacc() throws IOException
	{
		// TODO Auto-generated method stub
		acc.close();
		
	}
	
	
	
}
