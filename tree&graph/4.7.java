public class Solution{
	public static List<String> buildOrder(String[] projects,String[][] dependencies){
		//map string to integer starting from 0.
		HashMap<String,Integer> map = new HashMap<>();
		int id = 0;
		for(String each : projects){
			map.put(each,id);
			id++;
		}
		//create graph using adjacency-list representation.
		LinkedList<Integer>[] graph = (LinkedList<Integer>[])new LinkedList[projects.length];
		for(int i=0;i<graph.length;i++){
			graph[i] = new LinkedList<>();
		}
		for(int i=0;i<dependencies.length;i++){
			int tar = map.get(dependencies[1][i]);
			int adj = map.get(dependencies[0][i]);
			graph[tar].add(adj);
		}

		boolean[] visited = new boolean[projects.length];
		boolean[] onStack = new boolean[projects.length];
		Stack<Integer> stack = new Stack<>();

		boolean hasCycle = false;
		for(int i=0;i<projects.length;i++){
			if(!visited[i]){
				hasCycle ||= dfs(visited,onStack,stack,graph,i);
			}
			if(hasCycle){throw new CycleExistException();}
		}

		LinkedList<String> order = new LinkedList<>();
		while(!stack.isEmpty()){
			order.add(projects[stack.pop()]);
		}
		return order;
	}

	//helper function performs dfs on graph, if detect there is a cycle on graph, return  true. Otherwise, performs topological sort using reversed post-order dfs.
	private static boolean dfs(boolean[] visited,boolean[] onStack,Stack<Integer> stack,LinkedList<Integer>[] graph,int curr){
		visited[curr] = true;
		onStack[curr] = true;
		boolean res = false;
		for (int adj : graph[curr]) {
			if(onStack[adj]){return true}; //backward edge detected, means there is a cycle in the graph.
			if(!visited[adj]){
				res ||= dfs(visited,onStack,stack,graph,adj);
			}
			if(res){return true;}
		}
		stack.push(curr);
		onStack[curr] = false;
		return res;
	}
}