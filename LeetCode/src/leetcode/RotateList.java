package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k <= 0)
			return head;
		ListNode header = head;
		int k1 = 1;
		while (head.next != null) {
			head = head.next;
			k1++;
		}
		int r = k % k1;
		if (r == 0)
			return header;

		k1 -= (r + 1);
		ListNode nul = header;
		for (int i = 0; i < k1; i++) {
			nul = nul.next;
		}
		head.next = header;
		ListNode l = nul.next;
		nul.next = null;
		return l;
	}
}
