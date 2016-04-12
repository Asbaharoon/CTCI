public class Solution{
	//addition is equal to addition without carry + only do the carry rather than addition.
	public static int addWithoutPlus1(int x,int y){
		if(y==0){return x;}
		int sumWithoutCarry = x^y;
		int onlyCarry = (a&b)<<1;
		addWithoutPlus(sumWithoutCarry,onlyCarry);
	}

	//based on recursive solution, we can derive iterative version of solution.
	public static int addWithoutPlus2(int x,int y){
		while(y!=0){
			int sum = x^y; //add without carry.
			int carry = (a&b)<<1; //carry but don't add.
			int x = sum;
			int y = carry;
		}
		return x;
	}
}