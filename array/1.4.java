public class Solution{
	//assume string only contains letters and space. Method takes O(n) time and O(1) space.
	public static boolean isPalindrome(String str){
		if(str==null||str.length()<2){return true;}
		int i = 0;
		int j = str.length()-1;
		while(i<j){
			while(str.charAt(i)==' '){
				i++;	
			}
			while(str.charAt(j)==' '){
				j--;
			}
			if(str.charAt(i++)!=str.charAt(j--)){return false;}
		}
		return true;
	}

	//assume string only contains letters and space. Method takes O(n) time and O(n) space.
	public static boolean isPalindromePermutation1(String str){
		if(str==null||str.length()<2){return true;}
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str.length();i++){
			char curr = str.charAt(i);
			if(curr!=' '){
				if(set.contains(curr)){
					set.remove();
				}else{
					set.add(curr);
				}
			}
		}
		return set.size()<2?true:false;
	}

	//assume string only contains lowercase letters and space. Method takes O(n) time and O(1) space.
	public static boolean isPalindromePermutation2(String str){
		if(str==null||str.length()<2){return true;}
		int mask = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){continue;}
			int val = str.charAt(i)-'a';
			if(mask&(1<<val)!=0){
				mask &= ~(1<<val);
			}else{
				mask |= 1<<val;
			}
		}
		if(mask==0||mask&(mask-1)==0){return true;}
		return false;
	}
}