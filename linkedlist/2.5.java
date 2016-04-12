public class Solution{
	//iterative solution
	public static int sumLists1(ListNode l1,ListNode l2){
		StringBuilder sum = new StringBuilder();
		int carry = 0;
		while(l1!=null||l2!=null){
			int val = 0;
			if(l2==null){
				val = l1.val + carry;
				l1 = l1.next;			
			}else if(l1==null){
				val = l2.val + carry;
				l2 = l2.next;	
			}else{
				val = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			if(val>=10){
				val = val - 10;
				carry = 1;
			}else{
				carry = 0;
			}
			sum.append(val);
		}
		if(carry==1){sum.append(1);}
		return Integer.parserInt(sum.reverse().toString());
	}

	//recusive solution
	public static int sumLists2(ListNode l1,ListNode l2){
		LinkedList<Integer> result = new LinkedList<>();
		iteration(l1,l2,0,result);
		int num = 0;
		for(int each : result){
			num = 10*num + each;
		}
		return num;
	}

	private static void iteration(ListNode l1,ListNode l2,int carry,LinkedList<Integer> result){
		int value = 0;
		if(l1==null&&l2==null){
			if(carry==1){
				reuslt.addFront(1);
			}
			return;
		}
		else if(l2==null){
			value = l1.val + carry;
		}else if(l1==null){
			value = l2.val + carry;
		}else{
			value = l1.val + l2.val + carry;
		}
		if(value>=10){
			value = value - 10;
			carry = 1;
		}else{
			carry = 0;
		}
		l1 = l1==null?null:l1.next;
		l2 = l2==null?null:l2.next;
		iteration(l1,l2,carry,result);
	}

	//follow-up implementation
	public static int sum(ListNode l1,ListNode l2){
		int len_l1 = getLength(l1);
		int len_l2 = getLength(l2);
		if(len_l1>len_l2){
			l2 = addZeroNode(l2,len_l1-len_l2);
		}else if(len_l1<len_l2){
			l1 = addZeroNode(l1,len_l2-len_l1);
		}
		LinkedList<Integer> result = new LinkedList<>();
		int carry = recurse(l1,l2,result);
		if(carry){
			result.addFront(1);
		}
		int num = 0;
		for(int each : result){
			num = 10*num + each;
		}
		return num;
	}

	private static int recurse(ListNode l1,ListNode l2,LinkedList<Integer> result){
		if(l1==null&&l2==null){
			return 0;
		}else{
			int value = l1.val + l2.val + recurse(l1.next,l2.next,result);
			result.addFront(value>=10?value-10:value);
			return value>=10?1:0;
		}
	}

	private static ListNode addZeroNode(ListNode head,int num){
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode current = dummy;
		while(num>0){
			current.next = new ListNode(0);
			current = current.next;
			num--;
		}
		current.next = head;
		return dummy.next;
	}

	private static int getLength(ListNode head){
		int len = 0;
		while(head!=null){
			head = head.next;
			len++;
		}
		return len;
	}

}