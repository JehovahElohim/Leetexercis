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
 * ˼·����Node�洢��ǰ�����ֵ��index����Node�������򣬽�������Ԫ�ص����˽�����ӣ�����target�������������Ľ������targetʱ��
 * ��node��index������ǰ�洢���±꣩���
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
		// ����
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
