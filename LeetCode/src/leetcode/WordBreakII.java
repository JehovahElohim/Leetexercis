package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public static List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < wordDict.size(); i++) {
			set.add(wordDict.get(i));
		}
		int len = s.length();
		boolean dp[] = new boolean[len + 1];
		dp[0] = true;
		Set<Integer> sIndex = new HashSet<Integer>();
		sIndex.add(0);
		for (int i = 1; i < dp.length; i++) {
			for (Integer integer : sIndex) {
				if (set.contains(s.substring(integer, i))) {
					dp[i] = true;
					sIndex.add(i);
					break;
				}
			}
		}
		List<String> list = new ArrayList<String>();
		if (!dp[len])
			return list;
		List<Integer> indexList = new ArrayList<Integer>(sIndex);
		Collections.sort(indexList);
		List<Integer> temp = new ArrayList<>();
		temp.add(0);
		dfs(s, temp, list, indexList, set, 0);
		return list;
	}

	public static void dfs(String proto, List<Integer> temp, List<String> list,
			List<Integer> indexList, Set<String> wordSet, int index) {
		if (index == indexList.size()-1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < temp.size(); i++) {
				sb.append(proto.substring(temp.get(i - 1), temp.get(i)))
						.append(' ');
			}
			if (sb.length() > 0)
				sb.deleteCharAt(sb.length() - 1);
			list.add(sb.toString());
		}
		// index是indexList的下标
		for (int i = index+1; i < indexList.size(); i++) {
 			String s1 = proto.substring(indexList.get(index),
 					indexList.get(i));
			if (wordSet.contains(s1)) {
				temp.add(indexList.get(i));
				dfs(proto, temp, list, indexList, wordSet, i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("cats");
		list.add("and");
		list.add("sand");
		list.add("dog");

		wordBreak("catsanddog", list);
	}
}
