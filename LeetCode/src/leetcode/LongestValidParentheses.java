package leetcode;

import java.util.Stack;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int len = s.length();
		int start = -1;
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - start);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				} else {
					start = i;
				}
			}
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		new LongestValidParentheses().longestValidParentheses(")()())");
	}

}
