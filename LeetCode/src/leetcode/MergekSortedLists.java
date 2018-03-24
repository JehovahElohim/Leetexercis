package leetcode;

import java.util.HashMap;
import java.util.TreeMap;

import leetcode.AddTwoNumbers.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < lists.length; i++) {
			ListNode cur = lists[i];
			while (cur != null) {
				if (map.containsKey(cur.val)) {
					map.put(cur.val, map.get(cur.val) + 1);
				} else {
					map.put(cur.val, 1);
				}
				cur = cur.next;
			}
		}
		ListNode node = new ListNode(0);
		ListNode p = node;
		for (Integer integer : map.keySet()) {
			int n = map.get(integer);
			for (int i = 0; i < n; i++) {
				p.next = new ListNode(integer);
				p = p.next;
			}
		}

		return node.next;
	}
	public static void main(String args[]){
		
	}
}
