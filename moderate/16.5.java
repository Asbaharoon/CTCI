public class Solution{
	public static int numOfTrailingZeros(int n){
		if(n<0){return -1;}
		int count = 0;
		int base = 5;
		while(n>=base){
			count += n/base;
			base *= 5;
		}
		return count;
	}
}