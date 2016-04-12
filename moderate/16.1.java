public class Solution{
	public static void swap1(int a, int b){
		a = a - b;// diff = a - b;
		b = b + a;// b = b + diff; 
		a = b - a;// a = b - diff; 
	}

	public static void swap2(int a,int b){
		a = a ^ b; 
		b = a ^ b;
		a = a ^ b;
	}
}