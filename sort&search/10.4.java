public class Solution{
	//find the length in O(logn) time and search in O(logn) time, so in total, it takes O(logn) to search the element.
	public static int search(Listy list,int target){
		if(list==null||target<=0){return -1;}
		//use O(logn) time to find possible last index.
		int lastIndex = 1;
		while(list.elementAt(lastIndex)!=-1&&list.elementAt(i)<target){
			lastIndex *= 2;
		}
		//tweaked binary search part
		int low=lastIndex/2;
		int high = lastIndex;
		while(low<=high){
			int mid = low + (high-low)/2;
			if(list.elementAt(mid)==-1||list.elementAt(mid)>target){
				high = mid - 1;
			}else if(list.elementAt(mid)<target){
				low = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}