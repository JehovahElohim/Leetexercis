package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public List<List<String>> findLadders(String beginWord, String endWord,
			List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		return null;
	}

	public void bfs(String beginWord, String endWord, List<String> wordList,
			List<List<String>> result, List<String> temp) {
		int len = beginWord.length();
		List<String> accord = new ArrayList<String>();
		for (String string : wordList) {
			boolean diff = false;
			for (int i = 0; i < len; i++) {
				if (string.charAt(i) != beginWord.charAt(i)) {
					if (diff)
						break;
					else {
						diff = true;
					}
				}
				if (i == len - 1 && diff) {
					accord.add(string);
				}
			}
		}
		for (String string : accord) {
			bfs(beginWord, endWord, wordList, result, temp);
		}
		
	}

	public static void main(String args[]) {
		String beginWord = "hot";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>(
				Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log",
						"cog" }));
		int len = beginWord.length();
		List<String> accord = new ArrayList<String>();
		for (String string : wordList) {
			boolean diff = false;
			for (int i = 0; i < len; i++) {
				if (string.charAt(i) != beginWord.charAt(i)) {
					if (diff)
						break;
					else {
						diff = true;
					}
				}
				if (i == len - 1 && diff) {
					accord.add(string);
					System.out.print(string+" ");
				}
			}
		}
	}
}
