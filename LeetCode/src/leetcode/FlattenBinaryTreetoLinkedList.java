package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
	public static void flatten(TreeNode root) {
		if (root == null)
			return;
		List<Integer> temp = new ArrayList<Integer>();
		preorder(temp, root);
		if (temp.size() == 1)
			return;
		TreeNode cur = root;
		cur.left = null;
		for (int i = 1; i < temp.size(); i++) { 
			cur.right = new TreeNode(temp.get(i));
			cur = cur.right;
		}
	}

	public static void preorder(List<Integer> temp, TreeNode root) {
		if (root == null)
			return;
		temp.add(root.val);
		preorder(temp, root.left);
		preorder(temp, root.right);
	}

	public static void main(String args[]) {
		flatten(TreeNode.stringToTreeNode("[1,2]"));
	}
}
