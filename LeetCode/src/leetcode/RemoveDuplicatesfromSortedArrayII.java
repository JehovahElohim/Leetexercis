package leetcode;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 * 思路：如果出现次数>2 指针后移，否则把nums【i】移动到指针处，指针后移 
 * @author asus pc
 *
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 3)
			return nums.length;
		int count = 1;
		int index = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				count++;
				if (count <= 2) {
					nums[index++] = nums[i];
				}
			} else {
				count = 1;
				nums[index++] = nums[i];
			}
		}
		return index;
	}
}
