package Main;
import java.io.*;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
public class ReadFile{
	private Word store = new Word();
	private String NameFile;

	public ReadFile(){
		this.NameFile="dtb\\slang.bin";
	}
	public ReadFile(String Name){
		this.NameFile=Name;
	}
	public Word getStore(){
		return store;
	}
	public String readString(){
		InputStream in=null;
		DataInputStream din=null;
		String s="";
		try{
			in=new FileInputStream(NameFile);
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
	public void writeString(String write){
		OutputStream out=null;
		DataOutputStream dout=null;
		try{
			out=new FileOutputStream(NameFile);
			dout=new DataOutputStream(out);
            dout.write(write.getBytes());
            dout.close();
		}
		catch(IOException exc){
			System.out.print(exc);
		}
	}
	public void Read(){
		InputStream in=null;
		DataInputStream din=null;
		try{
			in=new FileInputStream(NameFile);
			din=new DataInputStream(in);
			int count = in.available();
            byte[] arr = new byte[count];
            din.read(arr);
            String s=new String(arr);
            int i;
            int index=0;
            String preCOMMA="";
            String lastCOMMA;
            for(i=0;i<s.length();i++){
            	if(s.charAt(i)=='`'){
            		preCOMMA=s.substring(index,i);
            		index=i+1;
            	}
            	if(s.charAt(i)=='\n'){
            		lastCOMMA=s.substring(index,i);
            		index=i+1;
            		store.add(preCOMMA,lastCOMMA);
            	}
            }
            store.add(preCOMMA,s.substring(index,s.length()));
            din.close();
		}
		catch(IOException exc){
			System.out.print(exc);
		}
	}
}