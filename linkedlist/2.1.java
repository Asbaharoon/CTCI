public class Solution{
	//this method takes o(n) time and O(n) space.
	public static void removeDuplicate1(ListNode head){
		HashSet<Integer> set = new HashSet<>();
		ListNode prev = null;
		while(head!=null){
			if(set.add(head.val)){
				prev = head;
				
			}else{
				prev.next = head.next;
			}
			head = head.next;
		}
	}
}
	//if extra space is not allowed. This method takes O(n^2) time, O(1) space.
	public static void removeDuplicate2(ListNode head){
		for(;head!=null;head=head.next){
			int val = haed.val;
			ListNode it = head.next;
			ListNode prev = head;
			while(it!=null){
				if(it.val = val){
					prev.next = it.next;
				}else{
					prev = it;
				}
				it = it.next;
			}
		}
	}

//definition of liinked list node 
public class ListNode{
	int val;
	ListNode next;
	public ListNode(int value){
		val = value;
	}
}