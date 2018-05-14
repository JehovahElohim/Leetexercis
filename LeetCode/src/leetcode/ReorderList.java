package leetcode;


import leetcode.AddTwoNumbers.ListNode;

public class ReorderList {
	public static void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode np = new ListNode(-1);
		np.next = head;

		ListNode mid = np;
		ListNode tail = np;

		while (tail != null && tail.next != null) {
			mid = mid.next;
			tail = tail.next.next;
		}

		ListNode prev = null;
		ListNode cur = null;
		ListNode next = null;
		// 结点为奇数
		if (tail == null) {
			cur = mid;
		}// 结点为偶数
		else if (tail.next == null) {
			cur = mid.next;
		}
		// 右半部分倒置
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		// prev为Ln。
		ListNode right = prev;
		ListNode left = np.next;
		ListNode leftNext = null;
		ListNode rightNext = null;
		while (right != null && right.next != null) {
			leftNext = left.next;
			left.next = right;
			rightNext = right.next;
			left = leftNext;
			right.next = left;
			right = rightNext;
		}
	}

	public static void main(String args[]) {
		ListNode n = new ListNode(null);
		reorderList(n);
		System.out.println(n);
	}
}
