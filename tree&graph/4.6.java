public class Solution{
	public static TreeNode successor(TreeNode node){
		if(node==null){return null;}
		if(node.right!=null){
			node = node.right;
			while(node.left!=null){
				node = node.left;
			}
		}else{
			int val = node.val;
			node = node.parent;
			while(node!=null&&node.val<=val){
				node = node.parent;
			}
		}
		return node;
	}
}