package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			if (slow == fast) {
				slow = slow.next;
				ListNode cur = head;
				while (slow != cur) {
					slow = slow.next;
					cur = cur.next;
				}
				return cur;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return null;
	}
}
