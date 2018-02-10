package _12_;

/**
 * 题目要求从数组中删除指定值的元素，并返回新数组的长度。
 * 不能使用额外的空间，并且nums最后的前n个元素为删除之后的状态，顺序无所谓。
 * @author asus pc
 *
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == val) {
				nums[i] = nums[--len];
				i--;
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();
		return len;

	}

	public static void main(String args[]) {
		int nums[] = { 1, 1, 2, 2, 3 };
		System.out.println(new RemoveElement().removeElement(nums, 1));
	}
}
