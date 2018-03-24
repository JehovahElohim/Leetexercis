package leetcode;

import org.hamcrest.core.IsSame;

public class SymmetricTree {
	public static boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		return compare(root.left, root.right);
	}

	public static boolean compare(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return compare(left.left, right.right)
				&& compare(left.right, right.left) && left.val == right.val;
	}

	public static void main(String args[]) {
		TreeNode root = TreeNode.stringToTreeNode("[1,2,2,3,4,4,3]");
		System.out.println(isSymmetric(root));
	}
}
