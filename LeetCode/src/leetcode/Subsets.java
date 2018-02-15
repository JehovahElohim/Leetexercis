package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * @author asus pc
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		helper(res, 0, temp, nums);
		return res;
	}

	public void helper(List<List<Integer>> result, int index,
			List<Integer> temp, int[] nums) {
		List<Integer> list = new ArrayList<Integer>(temp);
		result.add(list);
	
		for (int i = index; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(result, i+1, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}
}
