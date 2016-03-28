public class Solution{
	public static void setZero(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRow = false;
		boolean firstColumn = false;
		//check if first row contains zero
		for(int i=0;i<n;i++){
			if(matrix[0][i]==0){
				firstRow = true;
				break;
			}
		}
		//check if first column contains zero
		for(int i=0;i<m;i++){
			if(matrix[i][0]==0){
				firstColumn = true;
				break;
			}
		}
		//check rest of matrix and set corresponding index in first row and first column to zero.
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j]==0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;					
				}
			}
		}
		//set rows and columns to zero based on previous result.
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][0]==0||matrix[0][j]){
					matrix[i][j] = 0;					
				}
			}
		}
		//if first row contains zero, set entire first row to zero.
		if(firstRow){
			for(int i=0;i<n;i++){
					matrix[0][i] = 0;
				}
			}
		//if first column contains zero, set entire first column to zero.
		if(firstColumn){
			for (int i=0;i<m;i++) {
				matrix[]i[0] = 0;
			}
		}

	}
}