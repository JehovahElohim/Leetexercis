package leetcode;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		int n = nums[0];
		for (int i = 1; i < nums.length; i++) {
			n = n ^ nums[i];
		}
		return n;
	}
}
