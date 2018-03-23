package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 其实是给定了一个beginWord和endWord，还有可用的单词列表，然后我们需要在每次只转换一个字符且转换后的字符在wordList中的情况下，
 * 将beginWord在最短步骤内转换为endWord， Return an empty list if there is no such
 * transformation sequence.
 * 
 * All words have the same length.
 * 
 * All words contain only lowercase alphabetic characters.
 * 
 * You may assume no duplicates in the word list.
 * 
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * @author asus pc
 *
 */
public class WordLadderII {
	public static List<List<String>> findLadders(String beginWord,
			String endWord, List<String> wordList) {
		List<List<String>> res = new LinkedList<List<String>>();

		Map<String, List<String>> map = new HashMap<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		while (!queue.isEmpty()) {
			String s = queue.poll();
			if (s.equals(endWord))
				break;
			if (!map.containsKey(s)) {
				List<String> nextWords = getWordsForBFS(map, s, wordList,
						endWord);
				map.put(s, nextWords);
				for (String string : nextWords) {
					queue.add(string);
				}
			}
		}
		List<String> temp = new LinkedList<String>();
		temp.add(beginWord);
		dfs(res, map, temp, endWord, beginWord);

		int min = Integer.MAX_VALUE;
		for (List<String> l : res) {
			min = Math.min(l.size(), min);
		}

		Iterator<List<String>> it = res.iterator();
		while (it.hasNext()) {
			if (it.next().size() > min)
				it.remove();
		}
		System.out.println(res);
		return res;
	}

	static void dfs(List<List<String>> res, Map<String, List<String>> map,
			List<String> temp, String endWord, String s) {
		List<String> value = map.get(s);
		if (value == null) {
			if (s.equals(endWord))
				res.add(new ArrayList<String>(temp));
			return;
		}
		for (int i = 0; i < value.size(); i++) {
			temp.add(value.get(i));
			dfs(res, map, temp, endWord, value.get(i));
			temp.remove(temp.size() - 1);
		}
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
		System.out.println(s+":"+res);
		return res;
	}

	static boolean isSimilar(String s1, String s2) {
		int len = s1.length();
		boolean diff = false;
		for (int i = 0; i < len; i++) {
			if(s1.charAt(i)!=s2.charAt(i)){
				if(diff)
					return false;
				diff = true;
			}
		}
		return diff;
	}

	public static void main(String args[]) {
		System.out.println(isSimilar("lest", "lose"));
		
//		String beginWord = "leet";
//		String endWord = "code";
//		List<String> list = new ArrayList<String>(Arrays.asList("lest", "leet",
//				"lose", "code", "lode", "robe", "lost"));
//		findLadders(beginWord, endWord, list);
	}
}
