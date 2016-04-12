public class Solution{
	public static List<Pair> 2Sum(int[] array,int target){
		ArrayList<Pair> result = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<array.length;i++){
			int curr = array[i];
			if(map.containsKey(curr)){
				result.add(new Pair(curr,map.get(curr)));
			}else{
				map.put(target-curr,curr);
			}
		}
		return result;
	}

	public class Pair{
		private int x;
		private int y;
		public Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
