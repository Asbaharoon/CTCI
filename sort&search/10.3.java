public class Solution{
	//if given array doesn't contain duplicate, worst case O(logn) time, if it may contain duplicate, worst case O(n) time.
	//iterative solution
	public static int search(int[] array,int target){
		if(array==null||array.length==0){return -1;}
		int low = 0;
		int high = array.length-1;
		while(low<=high){
			int mid = low + (high-low)/2;
			if(array[mid]==target){return mid;}
			if(array[mid]>array[low]){
				if(target>=array[low]&&target<array[mid]){
					high = mid - 1;
				}else{
					low = mid + 1;
				}
			}else if(array[mid]<array[low]){
				if(target>array[mid]&&target<=array[high]){
					low = mid + 1;
				}else{
					high = mid - 1;
				}
			}else{ //when array[mid] == array[low], we are not sure which half target may locate. So we can simply remove array[low] from search range because array[low] == array[mid] != target
				low++;
			}
		}
		return -1;//given target not found
	}

	//recursive solution
	public static int search2(int[] array,int target){
		return binSearch(array,target,0,array.length-1);
	}

	private static int binSearch(int[] array,int target,int low,int high){
		if(low>high){
			return -1;
		}
		int mid = low + (high-low)/2;
		if(array[mid]==target){return mid;}
		if(array[mid]>array[low]){
			if(target>=array[low]&&target<array[mid]){
				return binSearch(array,target,low,mid-1);
			}else{
				return binSearch(array,target,mid+1,high);
			}
		}else if(array[mid]<array[low]){
			if(target>array[mid]&&target<array[low]){
				return binSearch(array,target,mid+1,high);
			}else{
				return binSearch(array,target,low,mid-1);
			}
		}else{
			if(array[mid]!=array[high]){
				return binSearch(array,target,mid+1,high);
			}else{
				int result = binSearch(array,target,low,mid-1);
				if(result==-1){
					return binSearch(array,target,mid+1,high);
				}else{
					return result;
				}
			}
		}
	}	
}