package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		if (head.val == head.next.val) {
			head.next = head.next.next;
		}
		return head;
	}
}
