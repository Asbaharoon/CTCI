public class Solution{
	//this method will use O(n) time and O(n) extra space.
	public static boolean isUnique1(String str){
		//if we know the radix, an boolean array can also be used.
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str.length();i++){
			if(!set.add(str.charAt(i))){
				return false;
			}
		}
		return true;
	}

	//this method will use O(n) time and O(1) extra space or you can say O(min(c,n)), also we assume that string is encoded in ASCII.
	public static boolean isUnique4(String str){
		if(str.length()>128){return false;}
		boolean[] char_set = new boolean[128];
		for(int i=0;i<str.length();i++){
			if(char_set[str.charAt(i)]){
				return false;
			}else{
				char_set[str.charAt(i)] = true;
			}
		}
		return true;
	}

	//this method will use O(n) time and O(1) space. The the restriction is str must contain alphabetic letters and non-case sentitive.
	public static boolean isUnique2(String str){
		str = str.toLowerCase();
		int mask = 0;
		for(int i=0;i<str.length();i++){
			int temp = 1<<(str.charAt(i)-'a');
			if(mask&temp!=0){
				return false;
			}else{
				mask |= temp);
			}
		}
		return true;
	}

	//this method will use O(nlogn) time and O(n) extra space.
	public static boolean isUnique3(String str){
		char[] temp = str.toCharArray();
		Array.sort(temp);
		for(int i=1;i<temp.length;i++){
			if(temp[i]==temp[i-1]){
				return false;
			}
		}
		return true;
	}


}




