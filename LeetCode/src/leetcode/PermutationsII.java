package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		List<List<Integer>> res;
		Set<List<Integer>> set = new HashSet<>();
		Set<Integer> visited = new HashSet<Integer>();
		dfs(set, temp, nums, visited);
		res = new ArrayList<List<Integer>>(set);
		return res;
	}

	public static void dfs(Set<List<Integer>> set, List<Integer> temp,
			int[] nums, Set<Integer> visited) {
		if (temp.size() == nums.length) {
			set.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i] && !visited.contains(i - 1)) {
				System.out.println(123);
				continue;
			}
			if (!visited.contains(i)) {
				temp.add(nums[i]);
				visited.add(i);
				dfs(set, temp, nums, visited);
				visited.remove(i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static void main(String args[]) {
		System.out.println(permuteUnique(new int[] { 1, 1, 1,2 }));
	}
}
