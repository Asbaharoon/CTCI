public class Solution{
	public static void find(int[] array){
		if(array==null||array.length<2){return;}
		//find right sorted part and left sorted part of given array.
		int leftIndex = findLeft(array);
		if(leftIndex==array.length-1){
			System.out.println("Entire array is already sorted. No need for sub-sort");
			return;
		}
		int rightIndex = findRight(array);
		//find minimum value in middle + right sections and find maximum value in left + middle sections.
		int minInMiddle = array[rightIndex];
		int maxInMiddle = array[leftIndex];
		for(int i=leftIndex+1;i<rightIndex;i++){
			if(array[i]>maxInMiddle){maxInMiddle = array[i];}
			if(array[i]<minInMiddle){minInMiddle = array[i];}
		}
		//expand the middle(m and n)
		int m = shrinkRight(array,rightIndex,minInMiddle);
		int n = shrinkLeft(array,leftIndex,maxInMiddle);

		System.out.println("Sort elements from index "+m+" to index "+n+" will make entrie array sorted.");
	}

	private static int shrinkLeft(int[] array,int leftIndex,int minInMiddle){
		while(leftIndex>=0&&array[leftIndex]>minInMiddle){
			leftIndex--;
		}
		return leftIndex + 1;
	}

	private static int shrinkRight(int[] array,int rightIndex,int maxInMiddle){
		while(rightIndex<array.length&&array[rightIndex]<maxInMiddle){
			rightIndex++;
		}
		return rightIndex - 1;
	}

	private static int findLeft(int[] array){
		int index = 1;
		while(index<array.length&&array[index]>=array[index-1]){
			index++;
		}
		return index - 1;
	}

	private static int findRight(int[] array){
		int index = array.length-1;
		while(index>=1&&array[index]>=array[index-1]){
			index--;
		}
		return index;
	}
}