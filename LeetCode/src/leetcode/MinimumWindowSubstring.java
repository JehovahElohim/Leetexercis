package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author asus pc
 *
 */
public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		if (t == null || s == null || t.equals("") || s.length() < t.length())
			return "";
		// map键为t的字符，存入t中出现的次数和窗口中出现的次数
		Map<Character, Node> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			Node n = map.get(t.charAt(i));
			if (n == null)
				map.put(t.charAt(i), new Node(1, 0));
			else {
				n.realCount++;
			}
		}
		// 维护一个队列 ，遇到包含t的字符串
		// ，进入队列；否则继续遍历。当压入队列后，t的字符存在于窗口中，则开始循环退出队列，直到窗口不符合规则为止。
		Queue<Integer> indexs = new LinkedList<Integer>();

		int res[] = new int[2];
		int min = Integer.MAX_VALUE;

		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			Node n = map.get(s.charAt(i));
			if (n != null) {
				// 如果窗口达标
				if (indexs.size() == 0)
					left = i;
				indexs.add(i);
				n.count++;
				if (check(map)) {
					Node node;
					while (check(map)) {
						int index = indexs.poll();
						node = map.get(s.charAt(index));
						node.count--;
						left = index;
					}
					if (min > right - left) {
						min = right - left;
						res[0] = left;
						res[1] = right;
					}
				}
			}
			right++;
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1]);
	}

	// 检查窗口的子串是否达标
	public static boolean check(Map<Character, Node> map) {
		for (Node node : map.values()) {
			if (node.count < node.realCount)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		System.out.println(minWindow("aaabbbvvdd", "abvd"));
	}

	static class Node {
		// t中的字符出现次数
		int realCount;
		// 窗口的出现次数
		int count;

		// 窗口中的下标
		public Node(int realCount, int count) {
			super();
			this.realCount = realCount;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [realCount=" + realCount + ", count=" + count + "]";
		}

	}
}
