public class Solution{
	//this method takes O(nlogn) time.
	public static void sort1(int[] array){
		if(array==null||array.length<3){return;}
		Arrays.sort(array);
		for(int i=1;i<array.length;i+=2){
			int temp = array[i];
			array[i] = array[i-1];
			array[i-1] = temp;
		}
	}

	//this method takes O(n) time.
	public static void sort2(int[] array){
		if(array==null||array.length<3){return;}
		for(int i=1;i<array.length;i+=2){
			int index = indexOfLocalMax(array,i);
			if(i!=index){
				swap(array,i,index);
			}
		}		
	}

	private static void swap(int[] array,int i,int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static int indexOfLocalMax(int[] array,int i){
		int prev = array[i-1];
		int curr = array[i];
		int after = i+1==array.length?Integer.MIN_VALUE:array[i+1];
		int max = Math.max(prev,Math.max(curr,after));
		if(max==prev){return i-1;}
		else if(max==curr){
			return i;
		}else{
			return i+1;
		}
	}
}