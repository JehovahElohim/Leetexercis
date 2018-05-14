package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int i = 1;
		int count = 1;
		while (!queue.isEmpty()) {
			count = 0;
			for (int j = 0; j < i; j++) {
				TreeLinkNode t = queue.poll();
				if (t.left != null) {
					queue.offer(t.left);
					count++;
				}
				if (t.right != null) {
					queue.offer(t.right);
					count++;
				}
				t.next = j == i - 1 ? null : queue.peek();
			}
			i = count;
		}
	}
}
