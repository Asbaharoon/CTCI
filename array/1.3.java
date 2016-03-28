public class Solution{
	//method 1
	public static void URLify(char[] str,int len){
		for(int i=0;i<len/2;i++){
			char temp = str[i];
			str[i] = str[len-1-i];
			str[len-1-i] = temp;
		}
		int n = str.length;
		while(len>0){
			if(str[--len]!=' '){
				str[--n] = str[len];
			}else{
				str[--n] = '%';
				str[--n] = '2';
				str[--n] = '0';
			}
		}
		for(int i=0;i<str.length/2;i++){
			char temp = str[i];
			str[i] = str[len-1-i];
			str[len-1-i] = temp;
		}
	}

	//method 2
	public static void replaceSpace(char[] str,int len){
		int count = 0;
		for(int i=len-1;i>=0;i--){
			if(str[i]==' '){count++;}
		}
		int newLen = len + 2*count;
		for(int i=len-1;i>=0;i--){
			if(str[i]==' '){
				str[--newLen] = '0';
				str[--newLen] = '2';
				str[--newLen] = '%';									
			}else{
				str[--newLen] = str[i];
			}
		}
	}
}