package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
		reverse(res);
		return res;
	}

	public static <T> void reverse(List<T> list) {
		int n = list.size() / 2;
		for (int i = 0; i < n; i++) {
			T temp = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, temp);
		}
	}

}
