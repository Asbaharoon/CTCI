public class Solution{
	//top-down DP
	public static int tripleStair1(int n){
		if(n<=0){return 0;}
		return running(n,new int[n+1]); 
	}

	private static int running(int i,int[] memo){
		if(i==1||i==2){return i;}
		if(i==3){return 4;}
		if(memo[i]==0){
			memo[i] = running(i-1,memo) + running(i-2,memo) + running(i-3,memo);
		}
		return memo[i];
	}

	//bottom-up DP
	public static int tripleStair2(int n){
		if(n<=0){return 0;}
		if(n==1||n==2){return i;}
		if(n==3){return 4;}
		int one = 1;
		int two = 2;
		int three = 4;
		for(int i=4;i<n;i++){
			int res = one + two + three;
			one = two;
			two = three;
			three = res;
		}
		return one + two + three;		
	}
}