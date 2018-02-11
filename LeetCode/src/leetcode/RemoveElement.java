package leetcode;

/**
 * ��ĿҪ���������ɾ��ָ��ֵ��Ԫ�أ�������������ĳ��ȡ�
 * ����ʹ�ö���Ŀռ䣬����nums����ǰn��Ԫ��Ϊɾ��֮���״̬��˳������ν��
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
