public class Solution{
	public static int search(String[] array,String target){
		if(array==null||target==0||target==""){return -1;}
		//initial search range
		int low = 0;
		int high = array.length-1;
		while(low<=high){
			int mid = low + (high-low)/2;
			String middle = array[mid];
			//if middle String is empty String, we use linear search to find its closest non-empty string.
			if(middle.length()==0){
				int left = mid - 1;
				int right = mid + 1;
				while(true){
					if(left<low&&right>high){
						return -1;
					}else if(left>=low&&array[left].length()!=0){
						mid = left;
						break;
					}else if(right<=high&&array[right].length!=0){
						mid = right;
						break;
					}
					left--;
					right++;
				}
			}
			//perform normal binary search
			if(middle.compareTo(target)>0){
				high = mid - 1;
			}else if(middle.compareTo(target)<0){
				low = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}