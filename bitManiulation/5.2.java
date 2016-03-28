public class Solution{
	public static String binToStr(Double input){
		if(input>=1||input<=0){return "ERROR";}
		StringBuilder res = new StringBuilder();
		res.append('.');
		while(input>0){
			if(res.length()>=32){
				return "ERROR";
			}
			input = input*2;
			if(input>=1){
				res.append('1');
				input -= 1;
			}else{
				res.append('0');
			}
		}
		return res.toString();
	}
}