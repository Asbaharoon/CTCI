public class Solution{
	public static final GRID_SIZE = 8;

	public static ArrayList<Integer[]> listAll(){
		ArrayList<Integer[]> result = new ArrayList<>();
		Integer[] columns = new Integer[GRID_SIZE];
		placeQueens(0,columns,result);
		return result;
	}

	private static void placeQueens(int row,Integer[] columns,ArrayList<Integer> result){
		if(row==GRID_SIZE){
			result.add(columns.clone());
		}else{
			for(int col=0;col<GRID_SIZE;col++){
				if(checkValid(columns,row,col)){
					columns[row] = col;
					placeQueens(row+1,columns,result);
				}
			}
		}
	}

	private static boolean checkValid(Integer[] columns,int row,int col){
		for(int i=0;i<row;i++){
			//check if current column has been taken.
			if(columns[i]==col){return false;}
			//check if current spot's diagonals have been taken. 
			int diff = row - i;
			if(col-diff>=0&&columns[i]==col-diff){
				return false;
			}
			if(col+diff<GRID_SIZE&&columns[i]==col+diff){
				return false;
			}
		}
		return true;
	}
}