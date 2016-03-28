public class Solution{
	public static boolean isRotation(String s1,String s2){
		if(s1==null||s2==null||s1.length()!=s2.length()||s1.length()!=0){return false; }
		String s1s1 = s1 + s1;
		return isSubstring(s1s1,s2);
	}

	public static boolean isSubstring(String s1,String s2){
		//function already pre-defined.
	}
}