public class Solution{
	//common iterative solution
	public static void shuffle(int[] array){
		if(array==null||array.length<2){return;}
		for(int i=0;i<array.length;i++){
			int index = (int)(Math.random()*(i+1));	//generate a rondom number ranged from 0 to i(inclusive)
			swap(array,i,index);
		}
	}

	private static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	//recursive solution
	public static void shuffleRecursive(int[] array){
		if(array==null||array.length<2){return;}
		shuffleRecursive(array,array.length-1);
	}

	private static void shuffleRecursive(int[] array,int index){
		if(index==0){return;}
		shuffleRecursive(array,index-1);
		int r = (int)Math.random()*(index+1);
		swap(array,index,r);
	}
}