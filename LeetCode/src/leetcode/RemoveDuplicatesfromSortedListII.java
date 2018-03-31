package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode header = new ListNode(-1);
		header.next = head;
		ListNode prev = header;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			ListNode next = cur.next;
			if (cur.val == next.val) {
				while (next != null && cur.val == next.val) {
					next = next.next;
				}
				prev.next = next;
			} else {
				prev = prev.next;
			}
			cur = prev.next;
		}

		return header.next;
	}

	public static void main(String args[]) {
		System.out.println(deleteDuplicates(new ListNode(new int[] { })));
	}

}
