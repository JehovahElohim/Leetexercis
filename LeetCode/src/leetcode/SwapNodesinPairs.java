package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class SwapNodesinPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null)
			return head;
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null && cur.next != null) {
			next = cur.next;
			cur.next = next.next;
			next.next = cur;
			if (prev != null) {
				prev.next = next;
			}else{
				head = next;
			}
			cur = cur.next;
			prev = next.next;
		}
		return head;
	}

	public static void main(String args[]) {
		ListNode node = new ListNode(new int[] {});

		System.out.println(swapPairs(node));
	}
}
