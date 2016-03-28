public class Solution{
	//Graph is represented as adjacency-list.
	public static boolean isRoute(LinkedList<Integer>[] adj,int s,int d){
		boolean[] visited = new boolean[graph.V()];
		return dfs(adj,visited,s,d);
	}

	private static boolean dfs(LinkedList<Integer>[] adj,boolean[] visited,int curr,int d){
			visited[curr] = true;
			if(curr==d){return true;}
			boolean res = false;
			for(int each : adj[curr]){
				if(!visited[each]){
					res ||= dfs(adj,visited,each,d);
					if(res) break;
				}
			}
			return res;
	}
}