public class Solution{
	public static int insertion(int N,int M,int i,int j){
		//create a mask that has a bunch of zero in the middle.
		int maskL = -1<<(j+1);
		int maskR = (1<<i) - 1;
		int mask = maskL | maskR;
		//clear bits from i to j in N
		int N = N & mask;
		//line up M to N in respect of i
		int M = M<<i;
		return N | M; //merge cleared N and shifted M
	}
}