public class Solution{
	//iterative solution without duplicates
	public static int magicIndex1(int[] A){
		if(A==null||A.length==0){return -1;}
		int i = 0;
		int j = A.length-1;
		while(i<=j){
			int mid = i + (j-i)/2;
			if(A[mid]<mid){
				i = mid + 1;
			}
			else if(A[mid]>mid){
				j = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	//recursive solution without duplicates
	public static int magicIndex2(int[] A){
		return subRoutine(0,A.length-1,A);						
	}

	//essentially is a raw binary search
	private static int subRoutine(int low,int high,int[] A){
		if(low>high){return -1;}
		int mid = low + (high-low)/2;
		if(A[mid]>mid){
			return subRoutine(low,mid-1;A);
		}else if(A[mid]<mid){
			return subRoutine(mid+1,high,A);
		}else{
			return mid;
		}
	}

	//recursive solution with duplicates
	public static int magicIndex3(int[] A){
		return subRoutine2(0,A.length;A);
	}

	//if array contains duplicates, we need to search both side every time.
	private static int subRoutine2(int low,int high,int[] A){
		if(low>high){return -1;}
		int mid = low + (high-low)/2;
		int midValue = A[mid];
		if(mid==midValue){return mid;}
		int leftIndex = Math.min(mid-1,midValue);
		int left = subRoutine2(low,leftIndex,A);
		if(left>=0){return left;}
		int rightIndex = Math.max(mid+1,midValue);
		return subRoutine2(rightIndex,high,A);
	}
}