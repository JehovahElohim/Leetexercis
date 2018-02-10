package _2_AddTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 */
// 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，即第一个结点表示最低位，最后一个结点表示最高位。
// 求两个数的相加和，并且以链表形式返回。

public class Solution {
	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode l = new ListNode(0);
		// n为指针
		ListNode n = l;
		// 分为2种情况：2个链表都不为空；有一个链表为空。
		while (l1 != null && l2 != null) {
			n.next = new ListNode(0);
			n = n.next;
			if (l1.val + l2.val + carry >= 10) {
				n.val = l1.val + l2.val + carry - 10;
				carry = 1;
			} else {
				n.val = l1.val + l2.val + carry;
				carry = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 != null) {
			while (l1 != null) {
				n.next = new ListNode(0);
				n = n.next;
				if (l1.val + carry >= 10) {
					n.val = l1.val + carry - 10;
					carry = 1;
				} else {
					n.val = l1.val + carry;
					carry = 0;
				}
				l1 = l1.next;
			}
		} else if (l2 != null) {
			while (l2 != null) {
				n.next = new ListNode(0);
				n = n.next;
				if (l2.val + carry >= 10) {
					n.val = l2.val + carry - 10;
					carry = 1;
				} else {
					n.val = l2.val + carry;
					carry = 0;
				}
				l2 = l2.next;
			}
		}
		if (carry == 1) {
			n.next = new ListNode(0);
			n = n.next;
			n.val = carry;
		}
		return l.next;
	}

	public static void main(String args[]) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode result = addTwoNumbers(l1, l2);
		System.out.println(result);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
