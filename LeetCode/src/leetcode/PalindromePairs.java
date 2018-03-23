package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Map<String, Integer> map = new HashMap<String, Integer>();// 记录word和下标的K-V，使其取下标时为O（1）
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		// 先逆序所有的words，看能否找到与其的匹配
		StringBuilder reverse = new StringBuilder();
		Integer temp = null;
		for (int i = 0; i < words.length; i++) {
			reverse.append(words[i]).reverse();
			if (!reverse.toString().equals(words[i])) {
				if ((temp = map.get(reverse.toString())) != null) {
					addPair(res, temp, i);
				}
			}
			reverse.delete(0, reverse.length());
		}
		
		for (int i = 0; i < words.length; i++) {
			List<Integer> indexs = manacher(words[i]);
			for (Integer integer : indexs) {
				String sub = words[i].substring(integer);
				reverse.append(sub).reverse();
				if (!reverse.toString().equals(words[i])) {
					if ((temp = map.get(reverse.toString())) != null) {
						addPair(res, temp, i);
					}
				}
				reverse.delete(0, reverse.length());
			}

			String rev = reverse(words[i]);
			indexs = manacher(rev);
			for (Integer integer : indexs) {
				String sub = rev.substring(integer);
				reverse.append(sub);
				if (!reverse.toString().equals(words[i])) {
					if ((temp = map.get(reverse.toString())) != null) {
						addPair(res, i, temp);
					}
				}
				reverse.delete(0, reverse.length());
			}
		}
		System.out.println(res);
		return res;
	}

	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}

	public static void addPair(List<List<Integer>> res, int left, int right) {
		List<Integer> pair = new ArrayList<Integer>(2);
		pair.add(left);
		pair.add(right);
		res.add(pair);
	}

	public static List<Integer> manacher(String s) {
		int[] mnc = new int[s.length() * 2 + 2];
		// 用来存储以包含s[0]的回文下标
		List<Integer> res = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append('$').append('#');
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i)).append('#');
		}
		sb.append('_');

		int max = 1;
		int rightBorder = 1;
		for (int i = 1; i < mnc.length; i++) {
			if (i < rightBorder)
				mnc[i] = Math.min(mnc[2 * max - i], rightBorder - i);
			while (sb.charAt(mnc[i] + i) == sb.charAt(i - mnc[i])) {
				mnc[i]++;
			}
			if (rightBorder < i + mnc[i]) {
				max = i;
				rightBorder = i + mnc[i];
			}
			// 通过数组求出包含第一个字母的回文串，加入的元素是：该下标之前的字符串 为回文
			if (i != 1 && i - mnc[i] <= 0) {
				res.add((i + mnc[i]) / 2 - 1);
			}
		}
		// System.out.println(sb);
		// System.out.println(Arrays.toString(mnc));
		// System.out.println(res);
		return res;
	}

	public static void main(String args[]) {
		// manacher("ab");
		palindromePairs(new String[] { "abcd","dcba","lls","s","sssll" });
	}

}
