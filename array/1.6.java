public class Solution{
	//this method constructs entire compressed string, then compare its length to original string.
	public static String compress1(String str){
		if(str==null||str.length()<2){return str;}
		StringBuilder res = new StringBuilder();
		int index = 0;
		while(index<str.length()){
			int count = 0;
			char curr = str.charAt(index); 
			while(index<str.length()&&str.charAt(index)==curr){
				index++;
				count++;
			}
			res.append(curr);
			res.append(count);
		}
		return res.toString().length()>=str.length()?str:res.toString();
	}

	//this method first computes the length of compressed string then compare to original string, if shorter, then construct it.
	public static String compress2(String str){
		int compressLength = getLength(str);
		if(compressLength>=str.length()){return str;}

		StringBuilder compressed = new StringBuilder(compressLength);//we already know the length, so internal char array doesn't need resize.
		int count = 0;
		for(int i=0;i<str,length();i++){
			count++;
			if(i+1>=str.length()||str.charAt(i)!=str.charAt(i+1)){
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}
		return compressed.toString();
	}

	//helper function for getting the compressed string's length.
	private static int getLength(String str){
		int newLength = 0;
		int count = 0;
		for(int i=0;i<str.length();i++){
			count++;
			if(i+1>=str.length()||str.charAt(i)!=str.charAt(i+1)){
				newLength += (1+String.valueOf(count).length());
				count = 0;
			}
		}
		return newLength;
	}
}