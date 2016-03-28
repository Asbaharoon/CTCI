public class Solution{
	//this method takes O(b) time(b is the length of bit sequence) and O(1) space.
	public static int flipBitToWin(int num){
		int SEQUENCE_LENGTH = 32;
		if(num==-1){return SEQUENCE_LENGTH;}
		boolean used = false;
		int max = 0;
		int before = 0;
		int after = 0;
		for(int i=0;i<SEQUENCE_LENGTH;i++){
			if(getBit(num,i)){
				if(used){after++;}
				else{before++;}
			}else{
				if(used){
					max = Math.max(max,before+after+1);
					before = after;
					after = 0;
				}else{
					used = true;
				}
			}
		}
		max = Math.max(max,before+after+1);
		return max;
	}

	//helper function checks certain bit in given number, 1 returns true, 0 return false.
	private static boolean getBit(int num,int index){
		return (num&(1<<index))!=0;
	}
}