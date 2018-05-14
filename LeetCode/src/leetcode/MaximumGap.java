package leetcode;

import java.util.Arrays;

public class MaximumGap {
	public static int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		int[] maxs = new int[nums.length + 1];
		int[] mins = new int[nums.length + 1];
		long max = Integer.MIN_VALUE;
		long min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
			maxs[i] = Integer.MIN_VALUE;
			mins[i] = Integer.MAX_VALUE;
		}
		if (max == min)
			return 0;
		maxs[nums.length] = Integer.MIN_VALUE;
		mins[nums.length] = Integer.MAX_VALUE;
		int len = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		for (int j = 0; j < nums.length; j++) {
			long index = (nums[j] - min) / len;
			maxs[(int) index] = Math.max(maxs[(int) index], nums[j]);
			mins[(int) index] = Math.min(mins[(int) index], nums[j]);
		}
		int res = Integer.MIN_VALUE; // 最后要求的最大距离
		int pre = maxs[0];
		for (int i = 1; i <= nums.length; i++) {
			if (mins[i] == Integer.MAX_VALUE && maxs[i] == Integer.MIN_VALUE)
				continue; // 空桶不管它
			res = Math.max(res, mins[i] - pre);
			pre = maxs[i];
		}
		return res;
	}

	public static void main(String args[]) {
		System.out.println(maximumGap(new int[] { 15252, 16764, 27963, 7817,
				26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521,
				6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604,
				17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926,
				22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740 }));
	}
}
