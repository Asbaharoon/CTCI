public class Solution{
	public static int findMissing(String fileName) throws FileNotFoundException{
		//total number if non-negative number from 0 to 2^31-1
		long numOfInts = (long)Integer.MAX_VALUE + 1;
		//bit verctors
		byte[] vector = new byte[(int)(numOfInts/8)];
		Scanner in = new Scanner(new FileReader(fileName));
		while(in.hasNextInt()){
			int num = in.nextInt();
			vector[num/8] |= 1<<(num%8);
		}
		for(int i=0;i<vector.length;i++){
			for(int j=0;j<8;j++){
				if(vector[i]&(1<<j)==0){
					return i*8+j;
				}
			}
		}
	} 
}