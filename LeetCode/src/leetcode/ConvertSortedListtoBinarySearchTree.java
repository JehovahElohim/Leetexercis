package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.AddTwoNumbers.ListNode;

public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> l = convert(head);
		return build(l, 0, l.size() - 1);
	}

	public static TreeNode build(List<Integer> nums, int left, int right) {
		if (left > right)
			return null;
		int i = (left + right) / 2;
		TreeNode root = new TreeNode(nums.get(i));
		root.left = build(nums, left, i - 1);
		root.right = build(nums, i + 1, right);
		return root;
	}

	public static List<Integer> convert(ListNode node) {
		List<Integer> s = new ArrayList<Integer>();
		while (node != null) {
			s.add(node.val);
			node = node.next;
		}
		return s;
	}
}
