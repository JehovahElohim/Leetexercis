package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')' || s.charAt(i) == ']'
					|| s.charAt(i) == '}') {
				if (stack.isEmpty())
					return false;
				char ch = stack.pop();
				switch (ch) {
				case '(':
					if (s.charAt(i) != ')')
						return false;
					break;
				case '[':
					if (s.charAt(i) != ']')
						return false;
					break;
				case '{':
					if (s.charAt(i) != '}')
						return false;
					break;
				default:
					break;
				}
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}
