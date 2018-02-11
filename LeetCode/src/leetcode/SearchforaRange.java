package leetcode;

import java.util.Arrays;

public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {

		int[] result = new int[2];
		int mid = search(nums, target);
		if (mid == -1) {
			return new int[] { -1, -1 };
		}
		int rLeft = mid, rRight = mid;
		while (rLeft >= 0 && nums[rLeft] == target)
			rLeft--;
		while (rRight < nums.length && nums[rRight] == target)
			rRight++;
		result[0] = rLeft + 1;
		result[1] = rRight - 1;
		return result;
	}

	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		int nums[] = { 7};
		int r[] = new SearchforaRange().searchRange(nums, 7);
		System.out.println(r[0] + " " + r[1]);
	}
}
