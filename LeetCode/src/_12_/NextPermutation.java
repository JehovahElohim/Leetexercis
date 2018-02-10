package _12_;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums.length == 0)
			return;
		int index = 0;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] < nums[i - 1]) {
				continue;
			} else {
				index = i - 1;
				break;
			}
		}
		int j;
		for (j = nums.length - 1; j > 0; j--) {
			if (nums[index] < nums[j]) {
				int temp = nums[index];
				nums[index] = nums[j];
				nums[j] = temp;
				break;
			}
		}
		Arrays.sort(nums, j == 0 ? 0 : index + 1, nums.length);
	}

	public static void main(String args[]) {
		int nums[] = { 2, 2, 7, 5, 4, 2, 3, 1, 2 };
		new NextPermutation().nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i);
		}
	}
}
