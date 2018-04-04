package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		dfs(root, sum, res, temp);
		return res;
	}

	public void dfs(TreeNode root, int sum, List<List<Integer>> res,
			List<Integer> temp) {
		if (root == null)
			return;
		temp.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(temp));
		}
		dfs(root.left, sum - root.val, res, temp);
		dfs(root.right, sum - root.val, res, temp);
		temp.remove(temp.size() - 1);
	}
}
