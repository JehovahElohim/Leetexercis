package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if(root==null)
			return ;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int i = 1;
		while (!queue.isEmpty()) {
			for (int j = 0; j < i; j++) {
				TreeLinkNode t = queue.poll();
				if (t.left != null) {
					queue.offer(t.left);
					queue.offer(t.right);
				}
				t.next = j == i - 1 ? null : queue.peek();
			}
			i = i << 1;
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}