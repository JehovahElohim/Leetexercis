package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class RemoveNthNodeFromEndofList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode cur = head;
		ListNode pre = head;
		while (n > 0) {
			cur = cur.next;
			n--;
		}
		if (cur == null) {
			head = head.next;
		} else {
			ListNode prev = null;
			while (cur != null) {
				prev = pre;
				pre = pre.next;
				cur = cur.next;
			}
			prev.next = pre.next;
			pre.next = null;
		}
		return head;
	}

	public static void main(String args[]) {
		ListNode list = new ListNode(new int[] { 1 });
		System.out.println(removeNthFromEnd(list, 1));
	}
}
