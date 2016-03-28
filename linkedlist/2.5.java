public class Solution{
	public static int sumLists(ListNode l1,ListNode l2){
		StringBuilder sum = new StringBuilder();
		boolean carry = false;
		while(l1!=null||l2!=null){
			int val = 0;
			if(l2==null){
				val = l1.val + carry==true?1:0;
				l1 = l1.next;			
			}else if(l1==null){
				val = l2.val + carry==true?1:0;
				l2 = l2.next;	
			}else{
				val = l1.val + l2.val + carry==true?1:0;
				l1 = l1.next;
				l2 = l2.next;
			}
			if(val>=10){
				val = val - 10;
				carry = true;
			}else{
				carry = false;
			}
			sum.append(val);
		}
		if(carry==true){sum.append(1);}
		return Integer.parserInt(sum.reverse().toString());
	}
}