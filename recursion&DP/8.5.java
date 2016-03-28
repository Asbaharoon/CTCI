public class Solution{
	//method one
	public static int multiply1(int x,int y){
		int smaller = x>y?y:x;
		int bigger = smaller==x?y:x;
		HashMap<Integer,Integer> cache = new HashMap<>();
		return divide1(smaller,bigger,cache);
	}

	private static int divide1(int x,int y,HashMap<Integer,Integer> cache){
		if(x==0){return 0;}
		if(x==1){return y;}
		if(cache.containsKey(x)){return cache.get(x);}
		int mid = x>>1;
		int res = divide1(mid,y) + divide1(x-mid,y);
		cache.put(x,res);
		return res;
	}

	//method two
	public static int multiply2(int x,int y){
		int smaller = x>y?y:x;
		int bigger = smaller==x?y:x;
		return divide(smaller,bigger);
	}

	private static int divide2(int x,int y){
		if(x==0){return 0;}
		if(x==1){return y;}
		int mid = x>>1;
		int first = divide2(mid,y);
		int second = 0;
		if(x%2==0){
			second = first;
		}else{
			second = first + y;
		}
		return first + second;
	}
}