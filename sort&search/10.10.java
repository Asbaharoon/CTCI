public class BST_Rank{

	private TreeNode root;

	public void track(int x){
		root = insert(root,x);
	}

	private static TreeNode insert(TreeNode root,int value){
		if(root==null){return new TreeNode(value);}
		if(root.val>value){
			root.sizeOfLeft++;
			root.left = insert(root.left,value);
		}else if(root.val<value){
			root.right = insert(root.right,value);
		}else{
			root.sizeOfLeft++;
		}
		return root;
	}

	public int getRankOfNumber(int x){
		int res = rank(root,x);
		return res==-1?-1:res+1;
	}

	private static int rank(TreeNode root,int value){
		if(root==null){return -1;}
		if(root.val>value){
			return rank(root.left,value);
		}else if(root.val<value){
			return root.sizeOfLeft + 1 + rank(root.right,value);
		}else{
			return root.sizeOfLeft;
		}
	}

	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		//evey node in the tree stores its left subtree's size.
		int sizeOfLeft;

		public TreeNode(int value){
			val = value;
			sizeOfLeft = 0;
		}
	}
}