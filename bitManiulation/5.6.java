public class Solution{
	public static int conversion(int A,int B){
		int num = A ^ B;
		int count = 0;
		while(num!=0){
			num = num & (num-1);//this clears the rightmost 1 in bits.
			count++;
		}
		return count;
	}
}