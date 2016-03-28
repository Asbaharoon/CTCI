public class Solution{
	//method takes O(n) time and O(n) space
	public static boolean isPalindrome(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		Stack<Integer> stack = new Stack<>();
		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			stack.push(slow.val);
			slow = slow.next;
		}
		//if fast is not null, this means list's length is odd. We skip the middle node.
		if(fast!=null){slow=slow.next;}
		while(slow!=null){
			if(slow.val!=stack.pop()){return false;}
			slow = slow.next;
		}
		return true;
	}
}