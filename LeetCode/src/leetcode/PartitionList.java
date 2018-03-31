package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.AddTwoNumbers.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x)
				left.add(cur.val);
			else {
				right.add(cur.val);
			}
			cur = cur.next;
		}
		if (left.size() == 0 || right.size() == 0)
			return head;
		ListNode l = new ListNode(-1);
		ListNode ptr = l;
		for (int i = 0; i < left.size(); i++) {
			ptr.next = new ListNode(left.get(i));
			ptr = ptr.next;
		}
		for (int i = 0; i < right.size(); i++) {
			ptr.next = new ListNode(right.get(i));
			ptr = ptr.next;
		}
		return l.next;
	}
}
