public class Solution{
	//this method takes O(n) time and O(logn) space;
	public static TreeNode buildBST(int[] array){
		return build(array,0,array.length-1);
	}	

	private static TreeNode build(int[] array,int low,int high){
		if(low>high){return null;}
		int mid = low + (high-low)/2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = build(array,low,mid-1);
		node.right = build(array,mid+1,high);
		return node;
	}
}