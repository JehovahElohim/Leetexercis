package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 *
 * ˼·����Node�洢��ǰ�����ֵ��index����Node�������򣬽�������Ԫ�ص����˽�����ӣ����target�������������Ľ�����targetʱ��
 * ��node��index������ǰ�洢���±꣩���
 */

public class TwoSum {

	private static class Node implements Comparable<Node> {
		private int val;
		private int index;
		
		public Node(int val, int index) {
			super();
			this.val = val;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {
			if (o == null) {
				return -1;
			}
			return this.val - o.val;
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		System.out.println(map.size());
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String args[]) {
		int num[] = { 1, 10, 5, 5 };
		int result[] = twoSum(num, 10);
		for (int i : result) {
			System.out.println(i);
		}

	}
}
