package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author asus pc
 *
 */
public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public int helper(int[] nums, int start, int end) {
		if (start == end)
			return nums[start];
		int mid = (start + end) / 2;
		if (nums[start] < nums[mid]) {
			return Math.min(nums[start], helper(nums, mid + 1, end));
		} else {
			return Math.min(nums[mid + 1], helper(nums, start, mid));
		}
	}

	public static void main(String args[]) {
		System.out.println(new FindMinimuminRotatedSortedArray()
				.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
	}
}
