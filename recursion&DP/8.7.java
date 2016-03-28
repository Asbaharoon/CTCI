public class Solution{
	//given string contains no duplicate characters

	//idea is that for P(a1a2a3....an) = insert an to any possible positons in every permutation in P(a1a2a3...an-1).
	//iterative solution, this method takes O(n!) time and O(n!) space.
	public static List<String> permutation1(String str){
		if(str==null){return null;}
		ArrayList<String> all = new ArrayList<String>();
		all.add("");
		int i = 0;
		while(i<str.length()){
			char curr = str.charAt(i);
			ArrayList<String> prev = all;
			all = new ArrayList<String>();
			for(String each : prev){
				for(int i=0;i<=each.length();i++){
					all.add(insertCharAt(each,curr,i));
				}
			}
			i++;
		}
		return all;
	}

	private static String insertCharAt(String str,char ch,int index){
		String first = str.substring(0,index);
		String second = str.substring(index);
		return first + ch + second;
	}

	//recursive solution, also O(n!) time and O(n!) space complexity
	public static List<String> permutation2(String str){
		if(str==null){return null;}
		return recurse(str,str.length()-1);
	}

	private static ArrayList<String> recurse(String str,int index){
		if(index==-1){
			ArrayList<String> empty = new ArrayList<>();
			empty.add("");
			return empty;
		}
		ArrayList<String> prev = recurse(str,index-1);
		char ch = str.charAt(index);
		ArrayList<String> curr = new ArrayList<>();
		for(String each : prev){
			for(int i=0;i<=each.length();i++){
				curr.add(insertCharAt(each,ch,i));
			}
		}
		return curr;
	}  

	//a different recursive approach
	//idea is that: P(a1a2a3a4) = {a1 + P(a2a3a4)} + {a2 + P(a1a3a4) + {a3 + P(a1a2a4)} + {a4 + P(a1a2a3)}}.
	public static List<String> permutation3(String str){
		ArrayList<String> reuslt = new ArrayList<>();
		if(str.length()==0){
			reuslt.add("");
			return result;
		}
		for(int i=0;i<str.length();i++){
			char curr = str.charAt(i);
			String first = str.substring(0,i);
			String second = str.substring(i+1);
			ArrayList<String> restPerms = permutation3(first+second);
			for(String each : restPerms){
				result.add(curr+each);
			}			
		}
		return result;
	}
}