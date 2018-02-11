package leetcode;

/**
 * ��һ���ϸ���������������ת����[0,1,2,3,4,5]��ת3λ��Ϊ[3,4,5,0,1,2]����������������ҵ�Ŀ�����֡������ڷ����±꣬�����ڷ���
 * -1��
 * 
 * ע��㣺 �����в������ظ������� ��֪��������ת�˶���λ ���ӣ� ����: nums = [4, 5, 6, 7, 0, 1, 2], target = 6
 * ���: 2 ����: nums = [4, 5, 6, 7, 0, 1, 2], target = 3 ���: -1
 * 
 * @author asus pc ���ַ�
 */
public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;

		int left = 0;
		int right = nums.length - 1;
		// ����м����С�����ҵ��� ���Ұ���������
		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == nums[mid])
				return mid;
			if (nums[mid] < nums[right]) {
				if (target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			} else if (nums[mid] >= nums[right]) {
				if (target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}

		}
		return -1;

	}

	public static void main(String args[]) {
		int nums[] = { 5,6,7, 0,1,2,4 };
		System.out.println(new SearchinRotatedSortedArray().search(nums, 1));
	}
}
