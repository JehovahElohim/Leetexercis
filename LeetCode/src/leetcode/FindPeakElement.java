package leetcode;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers.
 * 
 * Note: Your solution should be in logarithmic complexity.
 * 思路：如果中间元素大于其相邻后续元素，则中间元素左侧
 * (包含该中间元素）必包含一个局部最大值。如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。
 * 
 * @author asus pc
 *
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int start = 0, end = nums.length;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (start == end)
				return start;
			else if (nums[mid] > nums[mid + 1])
				end = mid;
			else {
				start = mid + 1;
			}
		}
		return start;
	}
}
