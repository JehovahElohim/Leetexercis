package leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author asus pc
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int start = 0;
		boolean zero = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zero = true;
				max = Math.max(max, helper(nums, start, i));
				start = i + 1;
			}
		}
		if (nums[nums.length - 1] != 0)
			max = Math.max(max, helper(nums, start, nums.length));
		if (zero)
			max = Math.max(max, 0);
		// System.out.println(max);
		return max;
	}

	public int helper(int[] nums, int start, int end) {
		if (end <= start)
			return 0;
		else if (start == end - 1)
			return nums[start];
		int max = 0;
		// 记录奇数出现次数
		int count = 0;
		// 分别记录左部，中部，右部的乘积
		int leftTotal = 1, midTotal = 1, rightTotal = 1;
		// 以2个下标划分数组为中部，左部，右部。
		int leftIndex = -1, rightIndex = -1;
		for (int i = start; i < end; i++) {
			if (nums[i] < 0) {
				count++;
				rightIndex = i;
				if (leftIndex == -1)
					leftIndex = i;
			}
			if (leftIndex == -1)
				leftTotal *= nums[i];
		}
		if (leftIndex != rightIndex || leftIndex != -1) {
			for (int i = leftIndex + 1; i < rightIndex; i++) {
				midTotal *= nums[i];
			}
		}
		if (rightIndex != -1) {
			for (int i = rightIndex + 1; i < end; i++) {
				rightTotal *= nums[i];
			}
		}
		// System.out.println(leftTotal);
		// System.out.println(midTotal);
		// System.out.println(rightTotal);
		if (count % 2 == 0) {
			int total = leftTotal * rightTotal * midTotal;
			max = Math.max(max, leftIndex != -1 && rightIndex != -1 ? (total
					* nums[leftIndex] * nums[rightIndex]) : total);
		} else {
			if (leftIndex != rightIndex) {
				System.out.println(555);
				max = Math.max(midTotal * nums[rightIndex] * rightTotal,
						midTotal * nums[leftIndex] * leftTotal);
			} else {
				max = Math.max(leftTotal, rightTotal);
			}
		}
		return max;

	}

	public int maxProduct1(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] dpMax = new int[nums.length];
		int[] dpMin = new int[nums.length];
		dpMax[0] = nums[0];
		dpMin[0] = nums[0];
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dpMax[i] = Math.max(nums[i],
					Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
			dpMin[i] = Math.min(nums[i],
					Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
			res = Math.max(res, dpMax[i]);
		}
		for (int i = 0; i < dpMin.length; i++) {
			System.out.print(dpMin[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < dpMin.length; i++) {
			System.out.print(dpMax[i] + " ");
		}
		return res;
	}

	public static void main(String args[]) {
		new MaximumProductSubarray().maxProduct1(new int[] { 0,1, -3 });
	}
}
