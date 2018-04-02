package leetcode;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	public static TreeNode build(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int i = (left + right) / 2;
		TreeNode root = new TreeNode(nums[i]);
		root.left = build(nums, left, i - 1);
		root.right = build(nums, i + 1, right);
		return root;
	}
}
