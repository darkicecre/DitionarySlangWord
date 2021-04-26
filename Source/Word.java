package Main;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class Word{
	private TreeMap<String,String> map=new TreeMap<String,String>();
	public String random(){
		String s="";
		Random generator = new Random();
		int random = generator.nextInt(map.size());
		int index=0;
		Set<String> KSet = map.keySet();
		for(String key:KSet){
			if(index==random){
				String r = map.get(key);
				int i=0;
				for(i=0;i<r.length();i++){
					if(r.charAt(i)=='|'||r.charAt(i)==','||r.charAt(i)=='/'){
						r=r.substring(0,i);
						break;
					}
				}
				s=key+" - "+r;
				break;
			}
			else{
				index=index+1;
			}
		}
		return s;
	}
	public String randomNotHave(String definition,String slang,boolean isS){
		Random generator = new Random();
		String s="";
		String k="";
		while(true){
			int index=0;
			int random = generator.nextInt(map.size());
			Set<String> KSet = map.keySet();
			for(String key:KSet){
				if(index==random){
					s=key;
					k=map.get(key);
					break;
				}
				else{
					index=index+1;
				}
			}
			if(k.contains(definition)==false&&s!=slang){
				break;
			}
		}
		if(isS==true){
			return s;
		}
		else{
			int i=0;
			for(i=0;i<k.length();i++){
				if(k.charAt(i)=='|'||k.charAt(i)==','||k.charAt(i)=='/'){
					k=k.substring(0,i);
					break;
				}
			}
			return k;
		}
	}
	private String convertHTML(String data,int sizeColumn){
		String result = "<html>";
		int index=0;
		int count=data.length()/sizeColumn;
		for(index=0;index<count;index++){
			result=result+data.substring(index*sizeColumn,(index+1)*sizeColumn)+"<br>";
		}
		result=result+data.substring(count*sizeColumn,data.length())+"</html>";
		return result;
	}
	public String[] guessDefinition(){
		Random generator = new Random();
		int random = generator.nextInt(map.size());
		String s="";
		String k="";
		int index=0;
		Set<String> KSet = map.keySet();
		for(String key:KSet){
			if(index==random){
				s=key;
				k=map.get(key);
				int i=0;
				for(i=0;i<k.length();i++){
					if(k.charAt(i)=='|'||k.charAt(i)==','||k.charAt(i)=='/'){
						k=k.substring(0,i);
						break;
					}
				}
				break;
			}
			else{
				index=index+1;
			}
		}
		String[] result=new String[6];
		int b1 = generator.nextInt(4);
		result[b1]=convertHTML(k,18);
		int b2 = generator.nextInt(4);
		while(b2==b1){
			b2=generator.nextInt(4);
		}
		result[b2]=convertHTML(randomNotHave(k,s,false),18);
		int b3 = generator.nextInt(4);
		while(b3==b1||b3==b2){
			b3=generator.nextInt(4);
		}
		result[b3]=convertHTML(randomNotHave(k,result[b2],false),18);

		result[6-b1-b2-b3]=convertHTML(randomNotHave(k,result[b2],false),18);
		while(result[6-b1-b2-b3]==result[b3]){
			result[6-b1-b2-b3]=convertHTML(randomNotHave(k,result[b2],false),18);
		}
		b1=b1+1;
		result[4]=s;
		result[5]=""+b1;
		return result;

	}
	public String[] guessSlang(){
		Random generator = new Random();
		int random = generator.nextInt(map.size());
		String s="";
		String k="";
		int index=0;
		Set<String> KSet = map.keySet();
		for(String key:KSet){
			if(index==random){
				s=key;
				k=map.get(key);
				int i=0;
				for(i=0;i<k.length();i++){
					if(k.charAt(i)=='|'||k.charAt(i)==','||k.charAt(i)=='/'){
						k=k.substring(0,i);
						break;
					}
				}
				break;
			}
			else{
				index=index+1;
			}
		}
		String[] result=new String[6];
		int b1 = generator.nextInt(4);
		result[b1]=s;
		int b2 = generator.nextInt(4);
		while(b2==b1){
			b2=generator.nextInt(4);
		}
		result[b2]=randomNotHave(k,s,true);
		int b3 = generator.nextInt(4);
		while(b3==b1||b3==b2){
			b3=generator.nextInt(4);
		}
		result[b3]=randomNotHave(k,result[b2],true);

		result[6-b1-b2-b3]=randomNotHave(k,result[b2],true);
		while(result[6-b1-b2-b3]==result[b3]){
			result[6-b1-b2-b3]=randomNotHave(k,result[b2],true);
		}
		b1=b1+1;
		result[4]=k;
		result[5]=""+b1;
		return result;
	}
	public void add(String key,String value){
		map.put(key,value);
	}
	public void print(){
		Set<String> KSet = map.keySet();
		for(String key:KSet){
			System.out.println(key+" - "+map.get(key));
		}
	}
	public void remove(String key){
		map.remove(key);
	}
	public String find(String key){
		return map.get(key);
	}
	public void reset(){
		ReadFile rootData=new ReadFile();
		rootData.Read();
		this.map=rootData.getStore().map;
	}
	public String[][] dictionary(){
		String[][] res = new String[map.size()][3];
		Set<String> KSet = map.keySet();
		int index=0;
		for(String key:KSet){
			res[index][0]=""+index;
			res[index][1]=key;
			res[index][2]=map.get(key);
			index=index+1;
		}
		return res;
	}
	public List<String> findD(String value){
		List<String> list=new ArrayList<String>();
		Set<String> keySet = map.keySet();
        for (String key : keySet) {
        	if(map.get(key).contains(value)){
        		list.add(key);
        	}
        }
        return list;
	}
	public String exportString(){
		Set<String> KSet = map.keySet();
		String result="";
		for(String key:KSet){
			result=result+key+"`"+map.get(key)+"\n";
		}
		return result.substring(0, result.length() - 1);
	}
}