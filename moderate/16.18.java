public class Solution{
	//brute-force algorithm, this method takes O(n^4),n is the length of string value;
	public static boolean isMatching1(String pattern, String value){
		if(pattern==null||value==null){return false;}
		if(pattern.length()==0){return value.length()==0;}
		if(pattern.length()==1){return true;}

		int size = value.length();
		for(int aSize=1;aSize<size;aSize++){
			String a = value.substring(0,aSize);
			for(int bStart=aSize;bStart<size;bStart++){
				for(int bEnd=bStart+1;bEnd<=size;bEnd++){
					String b = value.substring(bStart,bEnd);
					String candidate = generateString(pattern,a,b);
					if(value.equals(candidate)){
						return true;
					}
				}
			}
		}
		return false;
	}

	//optimized solution, this takes O(n^2) time.
	public static boolean isMatching2(String pattern,String value){
		if(pattern==null||value==null){return false;}
		if(pattern.length()==0){return value.length()==0;}
		if(pattern.length()==1){return true;}	
		
		int size = value.length();
		char first = pattern.charAt(0);
		char second = first=='a'?'b':'a';
		int numOfFirst = countOFFirst(first,pattern);
		int numOfSecond = pattern.length() - numOfFirst;
		int maxFirstSize = (size - numOfSecond*1)/numOfFirst;
		int firstSecondIndex = pattern.indexof(second);

		for(int sizeFirst=1;sizeFirst<=maxFirstSize;sizeFirst++){
			String strOfFirst = value.substring(0,sizeFirst);
			int sizeSecond = (size - sizeFirst*numOfFirst)/numOfSecond;
			String strOfSecond = value.substring(sizeFirst*firstSecondIndex,sizeFirst*firstSecondIndex+sizeSecond);
			String candidate = generateString(pattern,strOfFirst,strOfSecond);
			if(candidate.equals(value)){
				return true;
			}
		}
		return false;
	}

	private static int countOFFirst(char first,String pattern){
		int count = 0;
		for(int i=0;i<pattern.length();i++){
			if(pattern.charAt(i)==first)count++;
		}
		return count;	
	}

	private static String generateString(String pattern,String a,String b){
		StringBuilder str = new StringBuilder();
		char first = pattern.charAt(0);
		for(int i=0;i<pattern.length();i++){
			if(pattern.charAt(i)==first){
				str.append(a);
			}else{
				str.append(b);
			}
		}
		return str.toString();
	}
}