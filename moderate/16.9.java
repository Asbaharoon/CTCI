public class Solution{
	public static int multiply(int x,int y){
		if(x==0||y==0){return 0;}
		int result = 0;
		if(x>0||y>0){
			int i = x>0?x:y;
			int j = x>0?y:x;
			for(int k=0;k<i;k++){
				result += j;
			}
		}else{
			int x = subtract(0,x);
			int y = subtract(0,y);
			for(int i=0;i<x;i++){
				result += y;
			}
		}
		return result;
	}

	public static int subtract(int x,int y){
		int temp = 0;
		if(y==0){return x;}
		else if(y>0){
			for(int i=0;i<y;i++){
				temp += -1;
			}
		}else{
			while(y!=0){
				temp++;
				y = y + 1;
			}
		}
		return x + temp;
	}

	public static int divide(int x,int y){
		if(y==0){throw new IllegalArgumentException();}
		if(x==0){return 0;}
		int count = 0;
		while(true){
			x = subtract(x-y);
			
		}
	}
}