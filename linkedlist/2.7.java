public class Solution{
	//mathod takes O(m+n) time and O(1) space.
	public static ListNode isIntersect(ListNode l1,ListNode l2){
		if(l1==null||l2==null){return null;}
		ListNode one = l1;
		ListNode two = l2;
		while(one!=null||two!=null){
			if(one.next==null){one=l2;}
			if(two.next==null){two=l1;}
			if(one==two){return one;}
			one = one.next;
			two = two.next;
		}
		return null;
	}
}