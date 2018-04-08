package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		List<Stack<Integer>> res = new ArrayList<Stack<Integer>>();
		res.add(new Stack<Integer>());
		res.get(0).push(Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			int mid = 0;
 			int left = 1;
 			int right = res.size() - 1;
			int index = -1;
			while (left <= right && res.size() > 1) {
				mid = (right + left) / 2;
				if (res.get(mid - 1).peek() < nums[i] 
						&& res.get(mid).peek() > nums[i]) {
					res.get(mid).push(nums[i]);
					index = mid;
					break;
				} else if (res.get(mid - 1).peek() > nums[i]
						&& res.get(mid).peek() > nums[i]) { 
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			if (index == -1) {
				res.add(new Stack<Integer>());
				res.get(res.size() - 1).push(nums[i]);
			}
		}
		return res.size() - 1;
	}

	public static void main(String args[]) {
		System.out
				.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}
}
