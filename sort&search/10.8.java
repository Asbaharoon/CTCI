public class Solution{
	public static void findDuplicates(int[] array){
		if(array==null||array.length<2){return result;}
		//bit vector will take 4000 bytes memory, which is smaller than 4kb(4kb == 4*1024 bytes == 4096 bytes)
		byte[] vector = new byte[32000/8];
		for(int i=0;i<array.length;i++){
			int num = array[i] - 1;
			if(vector[num/8]&(1<<num%8)==0){
				vector[num/8] |= (1<<num%8);								
			}else{
				System.out.println(num+1);
			}
		}
		return result;
	}
}