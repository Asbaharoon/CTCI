public class Solution{
	public static boolean deleteNode(ListNode node){
		//if given node is null or it's the last node in list, there's no way to delete it, return false means failure.
		if(node==null||node.next==null){return false;}
		//copy given node's next node's val to given node and remove next node from the list, it takes O(1) time and O(1) space;
		ListNode nextNode = node.next;
		node.val = nextNode.val;
		node.next = nextNode.next;	
		return true;
	}
}