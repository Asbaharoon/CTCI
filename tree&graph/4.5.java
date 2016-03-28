public class Solution{
	//this method takes O(n) time and O(logn) space.
	public static boolean isValidBST1(TreeNode root){
		return check(root,null,null);
	}

	private static boolean check(TreeNode node,Integer low,Integer high){
		if(node==null){return true;}	
		return (low==null||node.val>low)&&(high==null||node.val<high)&&check(node.left,low,node.val)&&check(node.right,node.val,high);
	}

	//if the tree doesn't allow duplicates, this in-order traversal method will work.
	private static Integer last_seen = null;
	public static boolean isValidBST2(TreeNode root){
		if(root==null){return true;}
		if(!isValidBST2(root.left)){return false;}
		if(last_seen!=null&&root.val<=last_seen){
			return false;
		}
		last_seen = root.val;
		if(!isValidBST2(root.right)){return false;}
		return true;
	}
}