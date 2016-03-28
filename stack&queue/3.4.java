public class MyQueue<T>{
	private Stack<T> stack1;
	private Stack<T> stack2;

	public MyQueue(){
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void add(T item){
		stack1.push(item);
	}	

	//"lazy" implementation of remove and peek
	public T remove(){
		shift();
		return stack2.pop();
	}

	public T peek(){
		shift();
		return stack2.peek();
	}

	private void shift(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}

	public boolean isEmpty(){
		return stack1.isEmpty()&&stack2.isEmpty();
	}

	public int size(){
		return stack1.size() + stack2.size();
	}
}