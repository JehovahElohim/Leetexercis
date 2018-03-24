package leetcode;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		boolean bothBST = isValidBST(root.left) && isValidBST(root.right);
		if (bothBST) {
			Integer big = findBigger(root.right);
			Integer small = findSmaller(root.left);
			if (small != null && big != null) {
				if (root.val > small && root.val < big)
					return true;
			} else if (small != null) {
				if (root.val > small)
					return true;
			} else if (big != null) {
				if (root.val < big)
					return true;
			} else {
				return true;
			}
		}
		return false;
	}

	public static Integer findBigger(TreeNode rightChild) {
		if (rightChild == null)
			return null;
		TreeNode p = rightChild;
		while (p.left != null) {
			p = p.left;
		}
		return p.val;
	}

	public static Integer findSmaller(TreeNode leftChild) {
		if (leftChild == null)
			return null;
		TreeNode p = leftChild;
		while (p.right != null) {
			p = p.right;
		}
		return p.val;
	}
}
