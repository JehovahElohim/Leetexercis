package leetcode;


public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		int[] temp = new int[1];
		int res[] = new int[1];
		preorder(res, root, temp);
		return res[0];
	}

	public void preorder(int res[], TreeNode root, int temp[]) {
		if (root == null)
			return;
		temp[0] = temp[0] * 10 + root.val;
		if (root.left == null && root.right == null) {
			res[0] += temp[0];
		}
		if (root.left != null)
			preorder(res, root.left, temp);
		if (root.right != null)
			preorder(res, root.right, temp);
		temp[0] = (temp[0] - root.val) / 10;
	}
}
