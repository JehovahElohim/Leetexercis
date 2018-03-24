package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		TreeNode last = root; // 当前行的最后节点
		TreeNode nLast = root; // 下一行的最右节点
		List<Integer> temp = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			temp.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
				nLast = node.left;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nLast = node.right;
			}
			if (node == last) {
				last = nLast;
				res.add(temp);
				temp = new ArrayList<Integer>();
			}
		}
		return res;
	}
}
