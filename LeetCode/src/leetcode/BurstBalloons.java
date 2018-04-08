package leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BurstBalloons {

	public static void main(String args[]) {
		System.out.println(maxCoins(new int[] { 3, 5, 8 }));
		System.out.println();
		System.out.println(dp(new int[] { 3, 5, 8 }));
	}

	public static int dp(int[] nums) {
		int[] ints = new int[nums.length + 2];
		ints[0] = 1;
		ints[nums.length + 1] = 1;
		System.arraycopy(nums, 0, ints, 1, nums.length);

		int dp[][] = new int[ints.length][ints.length];
		int n = nums.length + 2;
		for (int k = 2; k < n; ++k) {
			for (int left = 0; left < n - k; ++left) {
				int right = left + k;
 				for (int i = left + 1; i < right; ++i) {
					dp[left][right] = Math.max(dp[left][right], ints[left]
							* ints[i] * ints[right] + dp[left][i]
							+ dp[i][right]);
				}
			}
		}
		return dp[0][n - 1];

	}

	public static int maxCoins(int[] nums) {
		Map<Compr, Integer> map = new HashMap<Compr, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(new Compr(new int[] { 1, nums[i], 1 }), nums[i]);
		}
		int[] ints = new int[nums.length + 2];
		ints[0] = 1;
		ints[nums.length + 1] = 1;
		System.arraycopy(nums, 0, ints, 1, nums.length);
		int a = dfs(ints, map);
		return a == Integer.MIN_VALUE ? 0 : a;
	}

	public static int dfs(int[] nums, Map<Compr, Integer> cache) {
		Integer x = cache.get(new Compr(nums));
		if (x != null) {
			return x;
		} else {
			int max = Integer.MIN_VALUE;
			for (int i = 1; i <= nums.length - 2; i++) {
				int t[] = new int[nums.length - 1];
				System.arraycopy(nums, 0, t, 0, i);
				System.arraycopy(nums, i + 1, t, i, t.length - i);
				int res = dfs(t, cache) + nums[i] * nums[i - 1] * nums[i + 1];
				max = Math.max(max, res);
			}
			Compr cc = new Compr(nums);
			if (!cache.containsKey(cc))
				cache.put(cc, max);
			return max;
		}
	}
	//
	// public static int getOnes(long[] compress) {
	// int count = 0;
	// for (int i = 0; i < compress.length; i++) {
	// count += compress[i] & (compress[i] - 1);
	// }
	// return count;
	// }

}

class Compr {
	int cc[];

	Compr(int l[]) {
		cc = l;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cc);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compr other = (Compr) obj;
		if (!Arrays.equals(cc, other.cc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compr [cc=" + Arrays.toString(cc) + "]";
	}

}
