public class Solution{
	//iterative solution and this takes O(n^2) time and space. 
	public static ArrayList<ArrayList<Integer>> subsets1(ArrayList<Integer> set){
		int n = set.size();//0 to n-1
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());//add empty set
		int i = 0;
		while(i<n){
			int num = set.get(i);//get ith element from the set
			ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<>();
			for(ArrayList<Integer> subset : res){
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(num);
				newSubsets.add(newSubset);
			}
			res.addAll(newSubsets);
			i++;
		}
		return res;
	}

	//combinatorics method
	public static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> set){
		int n = set.size();
		int max = 1<<n; //calculate 2^n, (exclusive)
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		for(int i=0;i<max;i++){
			ArrayList<Integer> subset = convertIntToSet(i,set);
			allSubsets.add(subset);
		}
		return allSubsets;
	}

	private ArrayList<Integer> convertIntToSet(int i,ArrayList<Integer> set){
		ArrayList<Integer> subset = new ArrayList<>();
		int index = 0;
		for(int k=i;k>0;k>>=1){
			if((k&1)==1){
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}
}