package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
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

		return dp[len];
	}
}
