package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return result;
		if (nums[0] > 0 || nums[nums.length - 1] < 0)
			return result;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				List<Integer> temp = new ArrayList<Integer>();
				if (nums[i] + nums[left] + nums[right] == 0) {
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					result.add(temp);
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (nums[i] + nums[left] + nums[right] <= 0) {
					left++;
				} else
					right--;
			}

		}
		return result;
	}

	public static void main(String args[]) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };

		List<List<Integer>> list = new _3Sum().threeSum(nums);
		for (List<Integer> list2 : list) {
			System.out.println(list2);
		}
	}
}
