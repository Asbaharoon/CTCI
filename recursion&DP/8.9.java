public class Solution{
	public static Set<String> parens1(int num){
		HashSet<String> result = new HashSet<>();
		if(num<=0){
			result.add("");
		}else{
			HashSet<String> prev = parens1(num-1);
			for(String str : prev){
				for(int i=0;i<str.length();i++){
					if(str.charAt(i)=='('){
						String s = insertInside(str,i);
						result.add(s);
					}
				}
				result.add("()"+str);
			}
		}
		return result;
	}

	private static String insertInside(String str,int index){
		String first = str.substring(0,index+1);
		String second = str.substring(index+1);
		return first +"()" + second;
	}

	//more efficient implementation
	public static List<String> parens2(int num){
		ArrayList<String> result = new ArrayList<>();
		char[] str = new char[num*2];
		addParens(result,num,num,str,0);
		return result;
	}

	private static void addParens(ArrayList<String> result,int leftRm,int rightRm,Char[] str,int index){
		if(leftRm<0||leftRm>rightRm){return;}
		if(leftRm==0&&rightRm==0){
			result.add(String.copyValueOf(str));															
		}else{
			if(leftRm>0){
				str[index] = '(';
				addParens(result,leftRm-1,rightRm,str,index+1);
			}
			if(rightRm>leftRm){
				str[index] = ')';
				addParens(result,leftRm,rightRm-1,str,index+1);
			}
		}
	}
}