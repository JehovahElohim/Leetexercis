package leetcode;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * @author asus pc
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1;
		for (int i = 0; i <= right; i++) {
			if (nums[i] == 0) {
				nums[i] = nums[left];
				nums[left++] = 0;
			} else if (nums[i] == 2) {
				nums[i--] = nums[right];
				nums[right--] = 2;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}
	public static void main(String args[]){
		new SortColors().sortColors(new int[]{2,0,1,2});
	}
}
