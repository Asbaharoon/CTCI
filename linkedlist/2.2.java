public class Solution{
	//this method takes O(n) time and O(1) space
	public static ListNode findKthToLast1(ListNode head,int k){
		//count the length of entire list
		int len = 0;
		ListNode it = head;
		while(it!=null){
			len++;
			it = it.next;
		}
		//get the kth node to the last;
		len = len - k;
		while(len>0){
			len--;
			head = head.next;
		}
		return head;
	}

	//recursive method, essentially it's a post-order dfs. It takes O(n) time and O(n) space;
	private ListNode kth = null;

	public ListNode findKthToLast2(ListNode head,int k){
		backward(head,k);
		return kth;
	}

	private int backward(ListNode node,int k){
		if(node==null){return 0;}
		int num = 1 + backward(node.next,k);
		if(num==k){kth=node;}
		return num;
	}

	//use two pointers, p1 is k steps forward than another p2. So when p1 reaches the end of list, p2 is pointing to the kth element to the last.
	//this takes O(n) time and O(1) space.
	public ListNode findKthToLast3(ListNode head,int k){
		if(head=null){return head;}
		ListNode p1 = head;
		ListNode p2 = head;
		while(k>0){
			if(p1.next==null){return null;}//boundary check
			p1 = p1.next;
			k--;
		}
		while(p1!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}