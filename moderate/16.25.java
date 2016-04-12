public class LRUCache{

	private int max_size;
	private HashMap<Integer,ListNode> mapping;
	private ListNode head;
	private ListNode tail;
	private int curr_size;

	public LRUCache(int max_size){
		this.max_size = max_size;
		mapping = new HashMap<>();
		curr_size = 0;
	}

	public void insert(int key,String value){
		if(curr_size==max_size){removeFromList(tail);}
		ListNode node = null;
		if(mapping.containsKey(key)){
			node = mapping.get(key);
			node.value = value;
			removeFromList(node);
		}else{
			node = new ListNode(key,value);
			mapping.put(key,value);
		}
		updateToFront(node);
	}

	public String getValue(int key){
		String result = null;
		if(mapping.containsKey(key)){
			ListNode node = mapping.get(key);
			result = node.value;
			this.removeFromList(node);
			this.updateToFront(node);
		}
		return result;
	}

	public boolean remove(int key){
		ListNode node = mapping.get(key);
		if(node==null){return false;}
		this.removeFromList(node);
		mapping.remove(key);
		return true;
	}

	//remove given node from the internal list;
	private void removeFromList(ListNode node){
		if(node==null){return;}
		if(node.prev!=null){node.prev.next=node.next;}
		if(node.next!=null){node.next.prev=node.prev;}
		if(node==tail){tail=node.prev;}
		if(node==head){head=node.next;}
		curr_size--;
	}

	//inserting given node to the front of internal list;
	private void updateToFront(ListNode node){
		if(head==null){
			head = node;
			tail = node;
		}else{
			node.next = head;
			head.prev = node;
			head = node;
		}
		curr_size++;
	}

	//nested static class for ListNode
	private static class ListNode{
		public int key;
		public String value;
		public ListNode prev;
		public ListNode next;
		public ListNode(int key,String value){
			this.key = key;
			this.value = value;
		}
	}
}