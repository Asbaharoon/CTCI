public class Solution{
	//iterative solution
	public static int[] generateSet(int[] array,int m){
		int[] set = new int[m];
		for(int i=0;i<m;i++){
			set[i] = array[i];
		}
		for(int i=m;i<array.length;i++){
			int r = (int)Math.random()*(i+1);
			if(r<m){
				set[r] = array[i];
			}
		}
		return set;																
	}

	//recursive solution
	public static int[] generateSetRecursive(int[] array,int m){
		int[] set = new int[m];
		generateSetRecursive(set,array,array.length-1,m);
		return set;
	}

	private static void generateSetRecursive(int[] set,int[] array,int index,int m){
		if(index==m-1){
			for(int i=0;i<m;i++){
				set[i] = array[i];
			}
			return;
		}
		generateSetRecursive(set,array,index-1,m);
		int r = (int)(Math.random()*(index+1));
		if(r<m){
			set[r] = array[index];
		}
	}
}