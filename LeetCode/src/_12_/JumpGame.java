package _12_;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example: A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * @author asus pc
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length <= 1)
			return true;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, i + nums[i]);
			if (i >= max) {
				return false;
			}
			if (max >= nums.length - 1) {
				return true;
			}

		}
		return false;

	}

	public static void main(String args[]) {
		System.out.println(new JumpGame().canJump(new int[] { 0 }));
	}
}
