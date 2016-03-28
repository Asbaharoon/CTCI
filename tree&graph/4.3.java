public class Solution{
	//bfs solution
	public static List<List<TreeNode>> listsOfDepth1(TreeNode root){
		List<List<TreeNode>> list = new LinkedList<>();
		if(root==null){return list;}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			list.add(queue);
			LinkedList<TreeNode> prev = queue;
			queue = new LinkedList<>();
			for(TreeNode t : prev){
				if(t.left!=null){queue.add(t.left);}
				if(t.right!=null){queue.add(t.right);}
			}
		}
		return list;
	}

	//dfs solution
	public static List<List<TreeNode>> listsOfDepth2(TreeNode root){
		List<List<TreeNode>> lists = new ArrayList<>();
		addEachLevel(root,lists,0);
		return lists;
	}

	private static void addEachLevel(TreeNode node,List<List<TreeNode>> lists,int level){
		if(node==null){return;}
		LinkedList<TreeNode> list = null;
		if(lists.size()==level){
			//first time visiting this level
			list = new LinkedList<>();
		}else{
			list = lists.get(level);
		}
		list.add(root);
		addEachLevel(node.left,lists,level+1);
		addEachLevel(node.right,lists,level+1);
	}
}
