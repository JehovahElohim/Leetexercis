package _1_TwoSum;

import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 *
 * 思路：用Node存储当前数组的值和index，对Node进行排序，将排序后的元素的两端进行相加，根据target进行收敛。最后的结果等于target时，
 * 把node的index（即以前存储的下标）输出
 */

public class Solution {

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
		int result[] = new int[2];

		Node temp[] = new Node[nums.length];

		for (int i = 0; i < nums.length; i++) {
			temp[i] = new Node(nums[i], i);
		}
		// 排序
		Arrays.sort(temp);
		for (Node node : temp) {
			System.out.println(node.val);
		}
		int j = temp.length - 1;
		int i = 0;

		while (j > i) {
			if (temp[i].val + temp[j].val == target) {
				result[0] = temp[i].index;
				result[1] = temp[j].index;
				break;
			} else if (temp[i].val + temp[j].val < target) {
				i++;
			} else if (temp[i].val + temp[j].val > target) {
				j--;
			}
		}

		return result;

	}

	public static void main(String args[]) {
		int num[] = { 3, 2, 4 };
		int result[] = twoSum(num, 6);
		for (int i : result) {
			System.out.println(i);
		}

	}
}
