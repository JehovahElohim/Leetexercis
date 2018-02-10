package _12_;

/**
 * 把一个严格升序的数组进行旋转，如[0,1,2,3,4,5]旋转3位成为[3,4,5,0,1,2]。在这样的数组中找到目标数字。如果存在返回下标，不存在返回
 * -1。
 * 
 * 注意点： 数组中不存在重复的数字 不知道数组旋转了多少位 例子： 输入: nums = [4, 5, 6, 7, 0, 1, 2], target = 6
 * 输出: 2 输入: nums = [4, 5, 6, 7, 0, 1, 2], target = 3 输出: -1
 * 
 * @author asus pc 二分法
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;

		int left = 0;
		int right = nums.length - 1;
		// 如果中间的数小于最右的数 则右半边是有序的
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid])
				return mid;
			if (nums[mid] < nums[right]) {
				if (target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			} else if (nums[mid] >= nums[right]) {
				if (target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}

		}
		return -1;

	}

	public static void main(String args[]) {
		int nums[] = { 5,6,7, 0,1,2,4 };
		System.out.println(new SearchinRotatedSortedArray().search(nums, 1));
	}
}
