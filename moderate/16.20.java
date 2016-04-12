public class Solution{
	//brite-force algorithm, can be optimized by using a tries data structure for faster word look-up
	public static List<String> t9_1(String number,HashSet<String> wordList){
		LinkedList<String> result = new LinkedList<>();
		if(number==null||number.length()==0){return result;}
		char[][] t9Letters = {null,null,{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		generateAllWords("",number,t9Letters,result,wordList);
		return result;
	}

	private static void generateAllWords(String prefix,String remainder,char[][] t9Letters,LinkedList<String> result,HashSet<String> wordList){
		if(remainder.length()==0){
			if(wordList.contains(prefix)){
				result.add(prefix);
			}
			return;
		}
		char currChar = remainder.charAt(0);
		int currNum = -1;
		if(Character.isDigit(currChar)){
			curr = Character.getNumericValue(currChar);
		}
		char[] charSet = currNum==-1?null:t9Letters[curr];
		remainder = remainder.substring(1);
		if(charSet==null){
			generateAllWords(prefix,remainder,t9Letters,result,wordList);

		}else{
			for(char each : charSet){
				generateAllWords(prefix+each,remainder,t9Letters,result,wordList);
			}
		}
	}

	//optimized, precomputed version
	public static List<String> t9_2(String number,HashMap<String,ArrayList<String>> dict){
		if(number!=null&&dict.containsKey(number)){
			return dict.get(number);
		}
		return new ArrayList<String>();
	}

	public static HashMap<String,ArrayList<String>> precomputed(String[] wordList){
		HashMap<String,ArrayList<String>> dict = new HashMap<>();
		for(String each : wordList){
			String num = getNumberValue(each);
			if(dict.containsKey(num)){
				ArrayList<String> list = dict.get(num);
				list.add(each);
			}else{
				ArrayList<String> list = new ArrayList<>();
				list.add(each);
				dict.put(num,list);
			}
		}
		return dict;
	}

	private static String getNumberValue(String word){
		StringBuilder number = new StringBuilder();
		HashMap<Character,Character> map = getCharToNumChar();
		for(int i=0;i<word.length();i++){
			char curr = word.charAt(i);
			if(map.containsKey(curr)){
				number.append(map.get(curr));
			}
		}
		return number.toString();
	}

	private static HashMap<Character,Character> getCharToNumChar(){
		char[][] t9Letters = {null,null,{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
		HashMap<Character,Character> map = new HashMap<>();
		for(int i=2;i<t9Letters.length;i++){
			for(char each : t9Letters[i]){
				map.put(each,Character.forDigit(i,10));
			}
		}
	}
}