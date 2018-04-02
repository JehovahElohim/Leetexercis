package leetcode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.val == sum && root.left == null && root.right == null)
			return true;
		sum -= root.val;
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
}
