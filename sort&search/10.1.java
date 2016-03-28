public class Solution{
	//this method takes O(m+n) time and O(1) space.
	public static void merge(int[] a,int[] b,int sizeA,int sizeB){
		int i = sizeA-1;
		int j = sizeB-1;
		int k = sizeA+sizeB-1;
		while(j>=0){
			if(i>=0&&a[i]>=a[j]){
				a[k] = a[i];
				i--;
			}else{
				a[k] = a[j];
				j--;
			}
			k--;
		}
	}
}