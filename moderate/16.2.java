public class Solution{
	//this method takes O(n) time and O(1) space;
	//single query
	public static int checkFrequency1(String[] book,String target){
		target = target.trim().toLowerCase();
		int count = 0;
		for(String each : book){
			if(each.trim().toLowerCase().equals(target)) count++;
		}
		return count;
	}

	//repetitive queries
	private static HashMap<String,Integer> freq = null;
	public static int checkFrequency2(String[] book,String target){
		if(book==null||target==null){return -1;}
		//pre-processing on entire book for repetitive queries.
		if(freq==null){
			freq = new HashMap<>();
			for(String each : book){
				each = each.trim().toLowerCase();
				if(freq.containsKey(each)){
					freq.put(each,freq.get(each)+1);
				}else{	
					freq.put(each,1);
				}
			}
		}
		target = target.trim().toLowerCase();
		if(!frq.containsKey()){return 0;}
		return freq.get(target);
	}
}