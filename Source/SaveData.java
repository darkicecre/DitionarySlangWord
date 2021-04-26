package Main;
import java.io.*;
public class SaveData{
	private Word save=new Word();
	public SaveData(){}
	public SaveData(Word data){
		save=data;
	}
	public void write(String name,String data){
		OutputStream out=null;
		DataOutputStream dout=null;
		try{
			out=new FileOutputStream(name);
			dout=new DataOutputStream(out);
			byte[]arr=data.getBytes();
			dout.write(arr);
			dout.close();
		}
		catch(IOException exc){
			System.out.print(exc);
		}
	}
	public String read(String name){
		InputStream in=null;
		DataInputStream din=null;
		String s="";
		try{
			in=new FileInputStream(name);
			din=new DataInputStream(in);
			int count = in.available();
            byte[] arr = new byte[count];
            din.read(arr);
            s=new String(arr);
            din.close();
		}
		catch(IOException exc){
			System.out.print(exc);
		}
		return s;
	}
	public void saveToDatabase(){
		write("dtb\\dtb.bin",save.exportString());
	}
	public void deleteAllHistory(){
		write("dtb\\history.txt","");
	}
	public void saveHistory(String history){
		String s=read("dtb\\history.txt");
		int count=0;
		InputStream in=null;
		DataInputStream din=null;
		try{
			in=new FileInputStream("dtb\\history.txt");
			din=new DataInputStream(in);
			count = in.available();
		}
		catch(IOException exc){
			System.out.print(exc);
		}
		if(count!=0){
			s=s+"\n";
		}
		write("dtb\\history.txt",s+history);
	}
	public String getHistory(){
		String s=read("dtb\\history.txt");
		if(s.length()==0){
			Date date=new Date();
			s=s+date.getDateTime()+" NULL`NULL";
		}
		return s;
	}
}