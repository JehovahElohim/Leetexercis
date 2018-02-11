package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CombinationSum {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<Integer> temp = new ArrayList<Integer>();
		helper(candidates, 0, target, temp);
		Arrays.sort(candidates);
		return result;
	}

	public void helper(int[] nums, int index, int target, List<Integer> temp) {
		if (target < 0)
			return;
		else if (target == 0) {
			List<Integer> a = new ArrayList<Integer>(temp);
			result.add(a);
		} else {
			for (int i = index; i < nums.length; i++) {
				temp.add(nums[i]);
				helper(nums, i, target - nums[i], temp);
				temp.remove(temp.size() - 1);
			}
		}

	}

}

class CombinationSumII {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> temp = new ArrayList<Integer>();
		helper(candidates, 0, target, temp);
		return result;

	}

	public void helper(int nums[], int index, int target, List<Integer> temp) {
		if (target < 0)
			return;
		else if (target == 0) {
			System.out.println(temp);
			result.add(new ArrayList<Integer>(temp));
		} else {
			for (int i = index; i < nums.length; i++) {
				temp.add(nums[i]);
				helper(nums, i + 1, target - nums[i], temp);
				temp.remove(temp.size() - 1);
				// ������ظ�Ԫ��
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					i++;
				}
			}
		}
	}

}
