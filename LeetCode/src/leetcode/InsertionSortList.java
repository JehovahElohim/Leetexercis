package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		ListNode cur = head;
		ListNode headPre = new ListNode(Integer.MIN_VALUE);
		headPre.next = head;
		ListNode tail = headPre;
		ListNode sort = headPre;
		// -1 6 5 3 8
		while (cur != null) {
			while (sort.next != cur) {
				if (sort.next.val >= cur.val) {
					ListNode next = sort.next;
					sort.next = cur;
					cur = cur.next;
					sort.next.next = next;
					tail.next = cur;
					break;
				}
				sort = sort.next;
			}
			if (sort.next == cur) {
				cur = cur.next;
				tail = tail.next;
			}
			sort = headPre;
		}
		return headPre.next;
	}

	public static void main(String args[]) {
		ListNode l = new ListNode(new int[] { 2, 4, 1, 3 });
		insertionSortList(l);
	}
}
