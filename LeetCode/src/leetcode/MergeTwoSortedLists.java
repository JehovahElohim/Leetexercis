package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.AddTwoNumbers.ListNode;

public class MergeTwoSortedLists {
	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode node = null;
		if (l1.val < l2.val) {
			node = l1;
			cur1 = cur1.next;
		} else {
			node = l2;
			cur2 = cur2.next;
		}
		ListNode ptr = node;
		while (cur1 != null && cur2 != null) {
			if (cur1.val > cur2.val) {
				ptr.next = cur2;
				cur2 = cur2.next;
			} else {
				ptr.next = cur1;
				cur1 = cur1.next;
			}
			ptr = ptr.next;
		}
		if (cur1 == null)
			ptr.next = cur2;
		if (cur2 == null)
			ptr.next = cur1;
		return node;
	}

	public static void main(String args[]) {
		List l1 = null;
		List l2 = l1;
		l1 = new ArrayList<>();
		System.out.println(l2);

		System.out.println(mergeTwoLists(new ListNode(new int[] { 1, 2, 4 }),
				new ListNode(new int[] { 1, 3, 4 })));
	}
}
