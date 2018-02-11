package leetcode;


public class RemoveDuplicatesfromSortedArray {
	/**
	 * ��һ���������飬ԭ��ɾ���ظ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ��������µĳ��ȡ� ��Ϊ��һ������������ռ䣬�����ó����ڴ�������һ�㡣 ���磬
	 * ���������� A = [1,1,2]�� ����Ӧ���س��� = 2��A������[1,2]��
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
