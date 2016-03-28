public class Solution{
	//this method takes O(n) time and O(1) space.
	public static ListNode partition(ListNode head,int val){
		if(head==null){return head;}
		ListNode newHead  = head;
		ListNode more = null;
		while(head!=null){
			if(head.val<val&&more!=null){
				int temp = more.val;
				more.val = head.val;
				head.val = temp;
				more = more.next;
			}else if(head.val>=val&&more==null){
				more = head;
			}
			head = head.next;
		}
		return newHead;
	}
}