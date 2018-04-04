package leetcode;


public class RangeSumQuery_Immutable {

	public int[] dp = null;

	public RangeSumQuery_Immutable(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		dp = new int[nums.length + 1];
		dp[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i + 1] = dp[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return dp[j] - dp[i];
	}
}
