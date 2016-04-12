public class Solution{
	//this might have overflow problem.
	public static int findMax1(int x,int y){
		//get diff between x and y, if x > y, diff >0, so sign-bit should be 0, otherwise sign-bit is 1.
		int diff = x - y;
		//logic right shift sign-bit to 0th bit, after that diff would be either 000.....001, which is 1 when x<y or 000.....000, which is 0 when x>=y.
		diff = diff>>>31;
		//so if diff is equal to 0, return x, if diff is 1, return y.
		return (1-diff)*x + diff*y;
	}

	//overflow safe version
	public static int findMax2(int x,int y){
		int diff = x - y;
		int signOfX = sign(x);
		int signOfY = sign(y);
		int signOfDiff = sign(diff);
		int isXYSameSign = signOfX ^ signOfY;
		int k = isXYSameSign*signOfX + (1-isXYSameSign)*signOfDiff;
		return k*x + (1-k)*y;
	}

	//reflect what sign bit given num has, return 1 means non-negative, 0 means negative. 
	private static int sign(int num){
		return flip0thbit(num>>>31);
	}

	//flip 0th bit in given integer.
	private static int flip0thbit(int num){
		return 1^num;
	}
}