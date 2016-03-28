public class Solution{
	public static void sortAnagrams1(String[] array){
		Arrays.sort(array,new AnagramComparator());
	}

	public class AnagramComparator implements Comparator<String>{
		@override 
		public int compare(String s1,String s2){
			return sortString(s1).compareTo(sortString(s2))
		}

		private static String sortString(String str){
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
		}
	}

	public static void sortAnagrams2(String[] array){
		if(array==null){return null;}
		HashMap<String,ArrayList<String>> map = new HashMap<>();
		for(String each : array){
			String key = sortString(each);
			if(map.containsKey(key)){
				ArrayList<String> list = map.get(key);
				list.add(each);
			}else{
				ArrayList<String> list = new ArrayList<>();
				list.add(each);
				map.put(key,list);
			}			
		}
		int index = 0;
		for(String key : map.keySet()){
			ArrayList<String> list = map.get(key);
			for(String each : list){
				array[index] = each;
				index++;
			}
		}
	}

	private static String sortString(String str){
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}