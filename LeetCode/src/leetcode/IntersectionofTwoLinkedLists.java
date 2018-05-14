package leetcode;

import leetcode.AddTwoNumbers.ListNode;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode curA = headA;
		ListNode curB = headB;
		while (curA != null && curB != null) {
			curA = curA.next;
			curB = curB.next;
			if (curA == curB)
				return curA;
		}
		ListNode cur;
		ListNode head;
		ListNode headShort;
		if (curA == null) {
			head = headB;
			cur = curB;
			headShort = headA;
		} else {
			head = headA;
			cur = curA;
			headShort = headB;
		}
		while (cur != null && head != null) {
			cur = cur.next;
			head = head.next;
		}
		while (head != null && headShort != null) {
			head = head.next;
			headShort = headShort.next;
			if (head == headShort)
				return curA;

		}
		return null;
	}
}
