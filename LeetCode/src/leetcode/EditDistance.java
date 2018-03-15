package leetcode;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * 
 *
 *
 * 思路：DP https://www.zhihu.com/question/23139644?sort=created
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1.equals(""))
			return word2.length();
		else if (word2.equals(""))
			return word1.length();

		int dp[][] = new int[word2.length() + 1][word1.length() + 1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
		}
		for (int j = 0; j < dp.length; j++) {
			dp[j][0] = j;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = word1.charAt(j - 1) == word2.charAt(i - 1) ? dp[i - 1][j - 1]
						: Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
								dp[i - 1][j - 1]) + 1;
			}
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[word2.length()][word1.length()];
	}

	public static void main(String args[]) {
		new EditDistance().minDistance("a", "b");
	}
}
