package leetcode;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem
 * 
 * @author asus pc
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k1) {
		int k = k1 % nums.length;
		int temp[] = new int[k];
		System.arraycopy(nums, nums.length - k, temp, 0, k);
		System.arraycopy(nums, 0, nums, k, nums.length - k);
		System.arraycopy(temp, 0, nums, 0, k);
	}
}
