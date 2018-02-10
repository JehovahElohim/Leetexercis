package _12_;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String args[]) {
		int nums[] = {1};
		System.out.println(new SearchInsertPosition().searchInsert(nums, -1));
	}
}
