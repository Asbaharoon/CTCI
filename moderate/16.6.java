public class Solution{
	public static int smallestDiff(int[] array1,int[] array2){
		if(array1==null||array1.length==0||array2==null||array2.length==0){return -1;}
		Arrays.sort(array1);
		Arrays.sort(array2);
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while(i<array1.length&&j<array2.length){
			int diff = array2[j]-array1[i];
			if(diff>0){
				i++;
			}else{
				j++;
			}
			min = Math.min(min,Math.abs(diff));
		}
		return min;
	}
}