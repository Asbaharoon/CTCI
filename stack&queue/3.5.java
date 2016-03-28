public class Solution(){
	//method uses the same paradigm as insertion sort. Insert new element from stack to temp, temp's elements maintain descending order.
	//this method takes O(N^2) time and O(N) space.
	public static void sortStack(Stack<Integer> stack){
		Stack<Integer> temp = new Stack<>();
		int curr = 0;
		while(!stack.isEmpty()){
			curr = stack.pop();
			while(!temp.isEmpty()&&curr<temp.peek()){
				stack.push(temp.pop());
			}
			temp.push(curr);
		}
		while(!temp.isEmpty()){
			stack.push(temp.pop());
		}
	}
}