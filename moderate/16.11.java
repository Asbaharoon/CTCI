public class Solution{
	//optimal one-pass iterative solution, takes O(n) time and O(1) space.
	public static Set<Integer> allLengths1(int k,int shortLen,int longLen){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<=k;i++){
			int len = shortLen*i + longLen*(k-i);
			set.add(len);
		}
		return set;
	}

	//recursive DP algorithm
	public static Set<Integer> allLengths2(int k,int shortLen,int longLen){
		HashSet<Integer> set = new HashSet<>();
		HashSet<String> cache = new HashSet<>();
		tryAllComb(0,k,shortLen,longLen,set,cache);
		return set;
	}

	//when we try to build board by using k planks, every time we can make decision, using short plank or longer plank.
	private static void tryAllComb(int total,int remain,int shortLen,int longLen,HashSet<Integer> set,HashSet<String> cache){
		if(remain==0){
			set.add(total);
			return;
		}
		String key = reamin+"#"+total;
		if(cache.contains(key)){return;}
		tryAllComb(total+shortLen,remain-1,shortLen,longLen,set);
		tryAllComb(total+longLen,remain-1,shortLen,longLen,set);
		cache.add(key);
	}
}