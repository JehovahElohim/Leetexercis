package leetcode;

import java.nio.Buffer;

/**
 * 本题是给一个整数的数组，让你按顺序找出第一个缺失的正整数。也就是说从1开始查找，找到了1再找2，这样一直找到缺失的第一个正整数。比如[1,2,0]
 * return 3,[3,4,-1,1] return 2. 要求时间复杂度O(n) ，空间复杂度为常数。
 * 
 * @author asus pc 思路：每个下标具有标记意义，再顺序遍历
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length&& nums[nums[i]-1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
				i--;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return nums.length + 1;

	}

	public static void main(String args[]) {

		System.out.println(new FirstMissingPositive()
				.firstMissingPositive(new int[] { 3, 4, -1, 1, 19 }));
	}
}
