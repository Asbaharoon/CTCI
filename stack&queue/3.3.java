public class SetOfStacks<T>{
	private LinkedList<Stack<T>> list;
	private Stack<T> currStack;
	private int capacity;
	private int currSize;

	public SetOfStacks(int capacity){
		this.capacity = capacity;
		list = new LinkedList<>();
		currStack = new Stack<>();
		list.add(currStack);
	}

	public void push(T item){
		if(currSize==capacity){
			currStack = new Stack<>();
			list.add(currStack);
			currSize = 0;
		}	
		currStack.push(item);
		currSize++;							
	}

	public T pop(){
		if(isEmpty()){throw new EmptyStackException();}
		if(currSize==0){
			list.removeLast();
			currStack = list.peek();
			currSize = capacity;																																	
		}
		currSize--;
		return currStack.pop();
	}

	public T peek(){
		if(isEmpty()){throw new EmptyStackException();}
		if(currSize==0){
			list.removeLast();
			currStack = list.peek();
			currSize = capacity;																																	
		}
		return currStack.peek();		
	}

	public boolean isEmpty(){
		return list.isEmpty();			
	}
}