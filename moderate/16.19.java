public class Solution{
	//this problem essentially is to find number of connected components in disconnected graph, can be achieved by dfs or bfs.
	//this solution takes O(mn) time(m is land.length and n is land[0].length) and O(mn) space(optional, depends on if we can modify original given matrix).
	public static List<Integer> pondSizes(int[][] land){
		ArrayList<Integer> result = new ArrayList<>();
		if(land==null||land.length==0){return result;}
		boolean[][] visited = new boolean[land.length][land[0].length];
		for(int r=0;r<land.length;r++){
			for(int c=0;c<land[0].length;c++){
				if(!visited[r][c]&&land[r][c]==0){
					int size = computeSize(visited,land,r,c);
					result.add(size);
				}
			}
		}
		return result;
	}

	private static int computeSize(boolean[][] visited,int[][] land,int row,int col){
		if(row<0||row>=land.length||col<0||col>=land[0].length||visited[row][col]||land[row][col]!=0){
			return 0;
		}
		int size = 1;
		visited[row][col] = true;
		for(int i=-1;i<=1;i++){
			for(int j=-1;j<=1;j++){
				size += computeSize(visited,land,row+i,col+j);
			}
		}
		return size;
	}
}