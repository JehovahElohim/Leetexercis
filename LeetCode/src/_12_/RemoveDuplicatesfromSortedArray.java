package _12_;


public class RemoveDuplicatesfromSortedArray {
	/**
	 * 给定一个有序数组，原地删除重复元素，使得每个元素只出现一次，并返回新的长度。 不为另一个数组分配额外空间，必须用常量内存做到这一点。 例如，
	 * 给定输入数组 A = [1,1,2]， 函数应返回长度 = 2，A现在是[1,2]。
	 */
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int count = 0;
		for (int i = 1; i < nums.length ; i++) {
			if(nums[i]==nums[count]){
				continue;
			}
			else{
				count++;
				nums[count] = nums[i];
			}
		}
		return count+1;

	}

	public static void main(String args[]) {
		int nums[] = { 1, 1, 2, 2, 3 };
		System.out.println(new RemoveDuplicatesfromSortedArray()
				.removeDuplicates(nums));
	}
}
