public class Solution{
	public static int swap(int input){
		return ((0X55555555&input)<<1) | ((0XAAAAAAAA&input)>>>1);	
	}
}