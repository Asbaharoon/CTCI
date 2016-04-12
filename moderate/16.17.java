public class Solution{
	public static int getLargestSum(int[] array){
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for(int i=0;i<array.length;i++){
			currSum = Math.max(currSum+array[i],array[i]); //if previous sum doesn't contribute, we can get rid of previous sum.
			maxSum = Math.max(maxSum,currSum);
		}
		return maxSum;
	}
}