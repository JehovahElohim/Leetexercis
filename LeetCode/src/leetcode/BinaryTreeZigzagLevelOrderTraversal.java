package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		TreeNode nextLastNode = root;
		TreeNode lastNode = root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<Integer> temp = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			temp.add(node.val);
			if (node.left != null) {
				nextLastNode = node.left;
				queue.offer(node.left);
			}
			if (node.right != null) {
				nextLastNode = node.right;
				queue.offer(node.right);
			}
			if (node == lastNode) {
				lastNode = nextLastNode;
				res.add(temp);
				temp = new ArrayList<Integer>();
			}
			System.out.println(res);
			for (int i = 0; i < res.size(); i++) {
				if (i % 2 == 1) {
					reverse(res.get(i));
				}
			}
		}
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
