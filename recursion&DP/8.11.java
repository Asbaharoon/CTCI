public class Solution{
	public static int numOfWays(int amount){
		int[] changes = {25,10,5,1};
		int[][] memo = new int[amount+1][changes.length];//cache repeatedly calculated value
		return makeChange(amount,changes,0,memo);
	}

	private static int makeChange(int amount,int[] changes,int index,int[][] memo){
		if(memo[amount][index]>0){return memo[amount][index];}
		if(amount==0||index>=changes.length-1){return 1;}
		if(memo[amount]!=0){return memo[amount];}
		int change = changes[index];
		int ways = 0;
		for(int i=0;i*change<=amount;i++){
			ways += makeChange(amount-i*change,changes,index+1);
		}
		memo[amount][index] = ways;
		return ways;
	}
}