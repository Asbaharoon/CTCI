public class Solution{
	public static boolean isPermuation(String str1,String str2){
		if(str1==null||str2==null||str1.length()!=str2.length()){return false;}
		int[] char_count = new int[128]; //Assumption
		for(int i=0;i<str1.length();i++){
			char_count[str1.charAt(i)]++;
			char_count[str2.charAt{i}]--;
		}
		for(int each : char_count){
			if(each!=0){return false;}
		}
		return true;
	}

	//sort two input strings and check if they are the same.
	public static boolean isPermuation2(String str1,String str2){
		if(str1==null||str2==null||str1.length()!=str2.length()){return false;}
		char[] content1 = str1.toCharArray();
		Arrays.sort(content1);
		char[] content2 = str2.toCharArray();
		Arrays.sort(content2);
		return new String(content1).equals(new String(content2));
	}
}