public class Solution{
	enum SColor {Black,White,Red,Yellow,Green,Blue}
	public static void paintFill(SColor[][] screen,int r,int c,SColor value){
		if(screen[r][c]==value){return;}
		dfs(screen,r,c,screen[r][c],value);
	}

	private static void dfs(SColor[][] screen,int r,int c,SColor old,SColor value){
		if(r<0||c<0||r>=screen.length||c>=screen[0].length){return;} //boundary check
		if(screen[r][c]!=old){return;}
		screen[r][c] = value;
		dfs(screen,r-1,c,old,value); //up
		dfs(screen,r+1,c,old,value); //down
		dfs(screen,r,c+1,old,value); //right
		dfs(screen,r,c-1,old,value); //left
	}
}