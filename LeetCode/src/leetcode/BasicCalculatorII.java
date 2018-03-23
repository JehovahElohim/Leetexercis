package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BasicCalculatorII {
	public static int calculate(String s) {
		Queue<Integer> digits = new LinkedList<Integer>();
		Queue<Character> signs = new LinkedList<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch))
				sb.append(ch);
			else if (ch != ' ') {
				digits.add(Integer.valueOf(sb.toString()));
				sb.delete(0, sb.length());
				if (ch == '-') {
					signs.add('+');
					sb.append("-");
				} else {
					signs.add(s.charAt(i));
					
				}
				
			}
		}
		digits.add(Integer.valueOf(sb.toString()));
		System.out.println(digits);
		System.out.println(signs);
		Stack<Integer> digit = new Stack<Integer>();
		Stack<Character> sign = new Stack<Character>();
		digit.push(digits.poll());
		while (!signs.isEmpty()) {
			while (!signs.isEmpty() && signs.peek() == '+') {
				sign.push(signs.poll());
				digit.push(digits.poll());
			}
			if (!signs.isEmpty() &&signs.peek() == '*') {
				signs.poll();
				int a = digits.poll() * digit.pop();
				digit.push(a);
			} else if (!signs.isEmpty() &&signs.peek() == '/') {
				signs.poll();
				int a = digit.pop() / digits.poll();
				digit.push(a);
			}
		}
		int sum = 0;
		for (Integer i : digit) {
			sum += i;
		}
		return sum;
	}

	public static void main(String args[]) {
		System.out.println(calculate("0-2147483647"));
	}
}
