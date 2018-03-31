package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode header = new ListNode(0);
		header.next = head;
		ListNode prev = null;
		ListNode cur = header;
		ListNode next = null;
		ListNode left = null;
		while (n >= 0) {
			next = cur.next;
			if (m > 0) {
				m--;
			} else {
				if (m == 0) {
					left = prev;
					m--;
				}
				cur.next = prev;
			}
			prev = cur;
			cur = next;
			n--;
		}
		if (left != null) {
			left.next.next = cur;
			left.next = prev;
		}
		return header.next;
	}

	public static void main(String args[]) {
		System.out.println(reverseBetween(new ListNode(new int[] { 3,5 }), 1, 2));
	}
}
