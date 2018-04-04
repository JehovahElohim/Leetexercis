package leetcode;

import java.util.Arrays;

public class HouseRobberII {
	// 相对于上一题，该nums为环。
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		int[][] dp = new int[2][nums.length];
		dp[0][0] = 0;
		dp[0][1] = nums[1];
		for (int i = 2; i < dp[0].length; i++) {
			dp[0][i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
		}
    		dp[1][0] = nums[0];
		dp[1][1] = nums[0];
		for (int i = 2; i < dp[0].length - 1; i++) {
			dp[1][i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 2]);
	}

	// 暴力递归
	public int dfs(int[] nums, int index, boolean robFirst) {
		if (index >= nums.length)
			return 0;
		if (index == nums.length - 1 && robFirst)
			return 0;
		return Math.max(dfs(nums, index + 1, robFirst),
				dfs(nums, index + 2, robFirst) + nums[index]);
	}

	public static void main(String args[]) {
		rob(new int[] { 1, 2, 3, 4 });
	}
}
