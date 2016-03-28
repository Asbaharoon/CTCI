public class Solution{
	//brute-force algorithm. Running time of this method is O(nlogn) for balanced binary tree.
	public static int PathsWithSum(TreeNode root,int sum){
		int[] total = new int[1];
		checkAll(root,sum,total);
		return total[0];
	}

	//this method performs checkSub function on every node in the tree, which is n.
	private static void checkAll(TreeNode root,int sum,int[] total){
		if(root==null){return;}
		checkSingle(root,0,sum,total);
		checkAll(root.left,sum,total);
		checkAll(root.right,sum,total);
	}

	//this function takes O(logn) time in worst case for a balanced binary tree
	private static void checkSingle(TreeNode node,int accu,int sum,int[] total){
		if(node==null){return;}
		accu += node.val;
		if(accu==sum){total[0]++;}
		checkSingle(node.left,accu,sum,total);
		checkSingle(node.right,accu,sum,total);
	}
}