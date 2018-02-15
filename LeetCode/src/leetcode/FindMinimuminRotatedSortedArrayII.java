package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author asus pc
 *
 */
public class FindMinimuminRotatedSortedArrayII {
	public int findMin(int[] nums) {
		return find(nums, 0, nums.length - 1);
	}

	public int find(int[] nums, int start, int end) {

		if (nums[start] < nums[end]||start==end)
			return nums[start];
		int mid = (start + end) / 2;
		while (nums[mid] == nums[start] && start < mid) {
			start++;
		}
		return Math.min(find(nums, start, mid), find(nums, mid + 1, end));
	}
}
