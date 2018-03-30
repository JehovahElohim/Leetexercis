package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class ReverseNodesink_Group {
	public static ListNode reverseKGroup(ListNode head, int k) {
		// 处理head 添加头节点。
		ListNode h = new ListNode(0);
		h.next = head;
		ListNode header = h;
		for (;;) {
			ListNode subTail = header;
			int k1 = k;
			for (int i = 0; i < k; i++) {
				if (subTail.next == null)
					return h.next;
				subTail = subTail.next;
			}

			ListNode prev = header;
			ListNode cur = header.next;
			ListNode next = null;
			ListNode subHead = cur;

			k1 = k;
			while (k1 > 0) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				k1--;

			}
			header.next = subTail;
			header = subHead;
			header.next = cur;
		}
	}

	public static void main(String args[]) {
		ListNode node = new ListNode(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(reverseKGroup(node, 3));
	}
}
