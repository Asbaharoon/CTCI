public class Solution{
	//this method takes O(n) time and O(h) space.(h is the height of tree.)
	public static boolean isBalance1(TreeNode root){
		return check(root)!=-1;
	}

	private static int check(TreeNode node){
		if(node==null){return 0;}
		int left = check(node.left);
		if(left==-1){return -1;}
		int right = check(node.right);
		if(right==-1){return -1;}
		//post-order : bottom-up approach
		return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
	}

	//this method's implementation is based on the balanced tree definition.
	public static boolean isBalance2(TreeNode root){
		//pre-order : top-down approach
		if(root==null){return true;}
		int diff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(diff)>1){return false;}
		return isBalance2(root.left)&&isBalance2(root.right);				
	}

	//helper function to get height od a given tree.
	private static int getHeight(TreeNode root){
		if(root==null){return 0;}
		return Math.max(getHeight(root.left),getHeight(root.right))+1;
	}
}