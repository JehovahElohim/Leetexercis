package _12_;

import java.awt.List;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int sum = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum + nums[i]);
			max = Math.max(max, sum);
		}
		System.out.println(max);
		return max;
		
	}
	public static void main(String args[]) {
		new MaximumSubarray().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
	}
}
