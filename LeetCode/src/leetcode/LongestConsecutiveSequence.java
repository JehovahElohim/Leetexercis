package leetcode;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author asus pc
 *
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if(nums.length==0)
			return 0;
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int count = 1;
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				continue;
			else if (nums[i] == nums[i + 1] - 1) {
				count++;
			} else {
				max = Math.max(max, count);
				count =1;
				System.out.println(max);
			}
		}
		System.out.println(Math.max(max, count));
		return max = Math.max(max, count);
	}

	public static void main(String args[]) {
		new LongestConsecutiveSequence()
				.longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6});
	}
}
