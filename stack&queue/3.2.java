public class MinStack<T extends Comparable<T>>{
	//helper StackNode class
	private static class StackNode<T extends Comparable<T>>{
		private T val;
		private StackNode<T> next;
		private T min;
		public StackNode(T val){
			this.val = val;
		}
	}

	private StackNode<T> top;

	public void push(T item){
		StackNode<T> newTop = new StackNode<>(item);
		newTop.next = top;
		newTop.min = newTop.val<=top.val?newTop.val:top.val;
		top = newTop;
	}

	public T pop(){
		if(top==null){throw new EmptyStackException();}
		T res = top.val;
		top = top.next;
		return res;
	}

	public T min(){
		if(top==null){throw new EmptyStackException();}
		return top.min;
	}

	public T peek(){
		if(top==null){throw new EmptyStackException();}
		return top.val;
	}

	public boolean isEmpty(){
		return top==null;
	}
}

//slightly efficient implmentation
public class MinStack2{

	Stack<Integer> stack;
	//use an additional stack to store minimum value.
	Stack<Integer> min;

	public MinStack2(){
		stack = new Stack<>();
		min = new Stack<>();
	}

	public void push(int value){
		stack.push(value);
		if(!min.isEmpty()&&value<min.peek()){
			min.push(value);
		}	
	}

	public int pop(){
		if(stack.isEmpty()){throw new EmptyStackException();}
		int res = stack.pop();
		if(res==min.peek()){
			min.pop();
		}
		return res;
	}

	public int peek(){
		if(stack.isEmpty()){throw new EmptyStackException();}
		return stack.peek();
	}

	public int min(){
		if(stack.isEmpty()){throw new EmptyStackException();}
		return min.peek();
	}
}