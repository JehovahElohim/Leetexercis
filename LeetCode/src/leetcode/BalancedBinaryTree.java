package leetcode;

public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isBalanced(root.left) && isBalanced(root.right)
				&& Math.abs((depth(root.left) - depth(root.right))) <= 1;
	}

	public static int depth(TreeNode r) {
		if (r == null)
			return 0;
		return Math.max(depth(r.left), depth(r.right)) + 1;
	}

	public static void main(String args[]) {
		System.out.println(isBalanced(TreeNode
				.stringToTreeNode("[1,2,2,3,null,null,3,4,null,null,4]")));

	}
}
