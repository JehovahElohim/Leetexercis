package leetcode;

public class BinaryTreeMaximumPathSum {
	public static int maxPathSum(TreeNode root) {
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		search(res, root);
		return res[0];
	}

	public static int search(int[] res, TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;
		int left = search(res, root.left);
		int right = search(res, root.right);
		int max = root.val;
		if (left >= 0)
			max += left;
		if (right >= 0)
			max += right;
		res[0] = Math.max(res[0], max);
		if (left == Integer.MIN_VALUE && right == Integer.MIN_VALUE)
			return root.val;
		if (left == Integer.MIN_VALUE)
			return Math.max(root.val, root.val + right);
		if (right == Integer.MIN_VALUE)
			return Math.max(root.val, root.val + left);
		return Math.max(Math.max(left, right) + root.val, root.val);
	}

	public static void main(String args[]) {
		TreeNode root = TreeNode.stringToTreeNode("[2,-1]");
		System.out.println(maxPathSum(root));
	}
}
