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
			while (cur.val == next.val) {
				
			}
		}

		return header.next;
		// if (head == null || head.next == null)
		// return head;
		// head.next = deleteDuplicates(head.next);
		// if (head.val == head.next.val) {
		// head.next = head.next.next;
		// }
		// return head;
	}

	public static void main(String args[]) {
		System.out.println(deleteDuplicates(new ListNode(new int[] { 1, 1, 2,
				2, 3, 3, 4, 4 })));
	}

}
