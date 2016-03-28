public class Solution{
	public static TreeNode FCA(TreeNode root,TreeNode p,TreeNode q){
		if(root==null||root==p||root==q){return root;}
		TreeNode left = FCA(root.left,p,q);
		TreeNode right = FCA(root.right,p,q);
		if(left!=null&&right!=null){return root;}
		return left!=null?left:right;
	}
}