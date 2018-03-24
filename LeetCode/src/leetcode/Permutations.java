package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();	
		Set<Integer> set = new HashSet<>();
		dfs(nums, res, temp, set);
		return res;
	}

	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp,
			Set<Integer> set) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<Integer>(temp));
		}
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				temp.add(nums[i]);
				set.add(nums[i]);
				dfs(nums, res, temp, set);
				temp.remove(temp.size() - 1);
				set.remove(nums[i]);
			}

		}
	}
	public static void main(String args[]){
		
	}
}
