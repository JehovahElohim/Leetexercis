package leetcode;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> stack = new Stack<>();
	/** initialize your data structure here. */
	private Stack<Integer> m = new Stack<>();

	public MinStack() {
	}

	public void push(int x) {
		stack.push(x);
		if(stack.size()==0)
			m.push(1);
		else if (getMin() >= x) {
			m.push(stack.size());
		}
	}

	public void pop() {
		if (m.size() == m.peek())
			m.pop();
		stack.pop();
	}

	public int top() {
		if (stack.size() == 0)
			return 0;
		return stack.peek();
	}

	public int getMin() {
		if (stack.size() == 0)
			return 0;
		System.out.println(123);
		return stack.get(m.peek() - 1);
	}
}
