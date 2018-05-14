package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord,
			List<String> wordList) {
		Map<String, List<String>> map = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		int i = 1;
		int next = 0;
		int count = 1;
		queue.add(beginWord);
		while (!queue.isEmpty()) {
			next = 0;
			for (int j = 0; j < i; j++) {
				String s = queue.poll();
				if (s.equals(endWord))
					return count;
				if (!map.containsKey(s)) {
					List<String> nextWords = getWordsForBFS(map, s, wordList,
							endWord);
					map.put(s, nextWords);
					for (String string : nextWords) {
						queue.add(string);
						next++;
					}
				}
			}
			i = next;
			count++;
		}
		return 0;
	}

	static List<String> getWordsForBFS(Map<String, List<String>> map, String s,
			List<String> wordList, String endWord) {
		List<String> res = new ArrayList<>();
		int len = wordList.size();
		for (int i = 0; i < len; i++) {
			String temp = wordList.get(i);
			if (isSimilar(s, temp)) {
				if (temp.equals(endWord)) {
					res.clear();
					res.add(endWord);
					break;
				}
				if (!map.containsKey(temp))
					res.add(temp);
			}
		}
		return res;
	}

	static boolean isSimilar(String s1, String s2) {
		int len = s1.length();
		boolean diff = false;
		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (diff)
					return false;
				diff = true;
			}
		}
		return diff;
	}

	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");

		System.out.println(ladderLength("hit", "cog", list));
	}
}
