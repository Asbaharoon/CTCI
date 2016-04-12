public class Solution{
	//This method takes O(A+B) time.
	public static int[] sumSwap(int[] array1,int[] array2){
		Integer target = getDiffTarget(array1,array2);
		if(target==null){return null;}
		HashSet<Integer> map = new HashMap<>();
		for(int each : array2){
			map.add(each);
		}
		for(int one : array1){
			int two = one - target;
			if(map.contains(two)){
				int result = new int[2];
				result[0] = one;
				result[1] = two;
				return result;
			} 
		}
		return null;
	}

	private static Integer getDiffTarget(int[] array1,int[] array2){
		int sum1 = sumOfArray(array1);
		int sum2 = sumOfArray(array2);
		if((sum1-sum2)%2!=0){
			return null;
		}
		return (sum1-sum2)/2;
	}

	private static int sumOfArray(int[] array){
		int sum = 0;
		for(int each : array){
			sum += each;
		}
		return sum;
	}
}