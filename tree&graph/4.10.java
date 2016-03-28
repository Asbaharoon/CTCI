public class Solution{
	//this method takes roughly O(n+km) time(k is occurences of t2's root in t1) and O(logn+logm) space.
	public static boolean isSubTree(TreeNode t1,TreeNode t2){
		if(t2==null){return true;}
		return travseral(t1,t2);
	}

	private static boolean travseral(TreeNode t1,TreeNode t2){
		if(t1==null){return false;}
		boolean res = false;
		if(t1.val==t2.val){
			res = isSameTree(t1,t2);
			if(res){return true};
		}
		res ||= travseral(t1.left,t2);
		if(res){return true;}
		res ||= travseral(t1.right,t2);
		if(res){return true;}
		return res;	
	}

	private static boolean isSameTree(TreeNode t1,TreeNode t2){
		if(t1==null&&t2==null){return true;}
		if(t1==null||t2==null){return false;}
		if(t1.val!=t2.val){return false;}
		boolean left = isSameTree(t1.left,t2.left);
		if(!left){return false;}
		boolean right = isSameTree(t1.right,t2.right);
		if(!right){return false;}
		return true;
	}
}