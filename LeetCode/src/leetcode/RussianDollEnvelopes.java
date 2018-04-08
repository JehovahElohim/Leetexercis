package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	public static int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0)
			return 0;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] - o2[0] != 0)
					return o1[0] - o2[0];
				else {
					return o1[1] - o2[0];
				}
			}
		});
		int dp[] = new int[envelopes.length];
		dp[0] = 1;
		int max = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0]
						&& envelopes[i][1] > envelopes[j][1]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			dp[i] = Math.max(1, dp[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(Arrays.deepToString(envelopes));
		System.out.println(Arrays.toString(dp));
		return max;
	}

	public static void main(String args[]) {
		maxEnvelopes(new int[][] { { 1, 1 } });
	}
}
