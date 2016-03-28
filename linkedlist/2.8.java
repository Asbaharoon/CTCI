public class Solution{
	public static boolean isCycle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				return true;
			}
		}
		return false;
	}

	public static ListNode cycleStart(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				while(head!=slow){
					head = head.next;
					slow = slow.next;
				}
				return head;
			}
		}
		return null;
	}
}