public class Solution{
	public static boolean oneAway(String str1,String str2){
		if(Math.abs(str1.length()-str2.length())>1){return false;}
		int i = 0;
		int j = 0;
		int diff = 0;
		while(i<str1.length()||j<str2.length()){
			if(i==str1.length()){
				diff++;
				j++;
			}else if(j==str2.length()){
				diff++;
				i++;
			}
			else if(str1.charAt(i)!=str2.charAt(i)){
				diff++;
				if(str1.length()>str2.length()){i++;}
				else if(str1.length()>str2.length()){j++;}
				else{
					i++;
					j++;
				}
			}else{
				i++;
				j++;
			}
		}
		if(diff>1){return false;}
		return true;
	}
}