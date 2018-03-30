package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author asus pc
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		List<Integer> temp = new LinkedList<Integer>();
		dfs(res, temp, k, n, 0);
		return res;
	}

	public void dfs(List<List<Integer>> res, List<Integer> temp, int k, int n,
			int index) {
		if (temp.size() == k) {
			res.add(new LinkedList<Integer>(temp));
			return;
		}
		for (int i = index; i < n; i++) {
			temp.add(i + 1);
			dfs(res, temp, k, n, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
