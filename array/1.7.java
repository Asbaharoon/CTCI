public class Solution{
	//this method takes O(n^2) time and O(1) space.
	public static void rotate90(int[][] image,int n){
		//transpose a square matrix
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
		}
		//reverse every row is related to rotate 90 degree clockwisely
		//reverse every column is related to rotate 270 degree clockwisely or rotate 90 degree conterclockwisely.
		for(int i=0;i<n;i++){
			for(int j=0;j<n/2;j++){
				int temp = image[i][j];
				image[i][j] = image[i][n-1-j];
				image[i][n-1-j] = temp;
			}	
		}
	}

	//this method takes O(n^2) time and O(1) space.
	public static void rotate(int[][] image,int n){
		//rotate layer by layer, from outmost layer to inner layer 
		for(int layer=0;layer<n/2;layer++){
			int first = layer;
			int last = n-1-layer;
			//in each layer, rotate entry by entry
			for(int i=first;i<last;i++){
				int offset = i - first;
				//cache top entry
				int top = matrix[first][i];
				//left to top
				matrix[first][i] = matrix[last-offset][first];
				//bottom to left
				matrix[last-offset][first] = matrix[last][last-offset];
				//right to bottom
				matrix[last][last-offset] = matrix[i][last];
				//top to right
				matrix[i][last] = top;
			}
		}									
	}
}