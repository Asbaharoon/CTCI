public class Solution{
	//given string contains duplicate characters.
	public static List<String> permutation1(String str){
		if(str==null){return null;}
		ArrayList<String> result = new ArrayList<>();
		HashMap<Character,Integer> map = buildFreqs(str);
		getPerms1("",str.length(),map,result);
		return result;
	}

	private void getPerms1(String prefix,int remainder,HashMap<Character,Integer> map,ArrayList<String> result){
		if(remainder==0){
			result.add(prefix);
			return;
		}
		for(char curr : map.keySet()){
			int count = map.get(curr);
			if(count>0){
				map.put(curr,count-1);
				getPerms1(prefix+curr,remainder-1,map,result);
				map.put(curr,count);
			}
		}
	}

	//different version of solution
	public static List<String> permutation2(String str){
		if(str==null){return null;}
		HashMap<Character,Integer> map = buildFreqs(str);
		return getPerms2(map);
	}

	private static ArrayList<String> getPerms2(HashMap<Character,Integer> map){
		ArrayList<String> result = new ArrayList<>();
		if(map.isEmpty()){
			result.add("");
			return result;
		}
		int count = 0;
		for(Character curr : map.keySet()){
			count = map.get(curr);
			if(count==1){
				map.remove(curr);
			}else{
				map.put(curr,count-1);
			}
			ArrayList<String> prev = getPerms2(map);
			for(String each : prev){
				result.add(curr+each);
			}
			map.put(curr,count);
		}
		return result;
	}

	private static HashMap<Character,Integer> buildFreqs(String str){
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++){
			char curr = str.charAt(i);
			if(map.containsKey(curr)){
				map.put(curr,map.get(curr)+1);
			}else{
				map.put(curr,1);
			}
		}
		return map;
	}
}