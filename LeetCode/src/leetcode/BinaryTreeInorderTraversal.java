package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		inorder(res, root);
		return res;
	}

	public void inorder(List<Integer> res, TreeNode root) {
		if (root == null)
			return;
		inorder(res, root.left);
		res.add(root.val);
		inorder(res, root.right);
	}
}
