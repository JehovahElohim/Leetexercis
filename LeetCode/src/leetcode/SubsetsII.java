package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * @author asus pc 思路：在本次调用的函数中需要设置一个List记录 已经出现的 数字。或者 先排序 有重复元素的话指针向右移。
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfsHelper(result, 0, temp, nums);
		for (List<Integer> integers : result) {
			for (Integer integer : integers) {
				System.out.print(integer + " ");
			}
			System.out.println(",");
		}
		return result;

	}

	public void dfsHelper(List<List<Integer>> result, int index,
			List<Integer> temp, int[] nums) {
		result.add(new ArrayList<Integer>(temp));
		List<Integer> dul = new ArrayList<Integer>();
		for (int i = index; i < nums.length; i++) {
			if (dul.contains(nums[i])) {
				continue;
			}
			dul.add(nums[i]);
			temp.add(nums[i]);
			dfsHelper(result, i + 1, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String args[]) {
		new SubsetsII().subsetsWithDup(new int[] { 4, 4, 4, 1, 4 });
	}
}
