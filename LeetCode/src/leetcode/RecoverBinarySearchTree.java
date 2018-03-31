package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree {
	public static void recoverTree(TreeNode root) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		inorder(null, root, res);
		if (res.size() == 2) {
			int temp = res.get(0).val;
			res.get(0).val = res.get(1).val;
			res.get(1).val = temp;
		} else if (res.size() == 4) {
			int temp = res.get(0).val;
			res.get(0).val = res.get(3).val;
			res.get(3).val = temp;
		}
	}

	public static TreeNode inorder(TreeNode prev, TreeNode cur, List<TreeNode> res) {
		if (cur == null)
			return null;
		if (cur.left != null)
			prev = inorder(prev, cur.left, res);
		if (prev != null && prev.val > cur.val) {
			res.add(prev);
			res.add(cur);
		}
		prev = cur;
		if (cur.right != null)
			prev = inorder(prev, cur.right, res);
		return prev;
	}

	public static void main(String args[]) {
		recoverTree(TreeNode.stringToTreeNode("[4,2,6,1,3,5,7]"));
	}
}
