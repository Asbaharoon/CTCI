public class Solution{
	public static List<String> canReach(int[][] grid){
		if(grid==null||grid.length==0||grid[0][0]==1){return null;}
		List<String> path = new LinkedList<>();
		int[][] memo = new int[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				memo[i][j] = grid[i][j];			
			}
		}
		boolean res = hasPath(grid.length-1,grid[0].length-1,memo,path);
		if(res){return path;}
		return null;
	}

	private static boolean hasPath(int r,int c,int[][] grid,List<String> path){
		if(r<0||c<0||grid[r][c]==1){return false;}
		if(r==0&&c==0){return true;}		
		boolean result = false;
		result = hasPath(r-1,c,grid,path);
		if(result){
			path.add("down");
			return true;
		}
		result = hasPath(r,c-1,grid,path);
		if(result){
			path.add("right");
			return true;
		}
		grid[r][c] = 1;
		return false;
	}

	//a different implementation.
	public static List<Point> findPath(boolean[][] grid){
		if(grid==null||grid.length==0){return null;}
		ArrayList<Point> path = new ArrayList<>();
		HashMap<Point,Boolean> memo = new HashMap<>();
		if(getPath(grid.length-1,grid[0].length-1,grid,path,memo)){
			return path;
		}
		return null;
	}

	private static boolean getPath(int row,int col,boolean[][] grid,ArrayList<Point> path,HashMap<Point,Boolean> memo){
		if(row<0||col<0||!grid[row][col]){return false;}
		Point curr = new Point(row,col);
		if(memo.containsKey(curr)){
			return memo.get(curr);
		}
		boolean isOrigin = (row==0)&&(col==0);
		boolean result = false;
		if(isOrigin||getPath(row-1,col,grid)||getPath(row,col-1,grid)){
			path.add(new Point(row,col));
			result = true;
		}
		memo.put(curr,result);
		return result;
	}
}