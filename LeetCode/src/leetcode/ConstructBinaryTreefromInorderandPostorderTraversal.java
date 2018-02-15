package leetcode;

import java.util.HashMap;
/**
 * 题目：给出以后序和中序遍历的二叉树的序列，构造二叉树。
 * 改进：用HashMap存下标；
 * @author asus pc
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
		for (int i = 0; i < postorder.length; i++) {
			cache.put(inorder[i], i);
		}
		return builder(inorder, 0, postorder, 0, inorder.length, cache);
	}

	public TreeNode builder(int[] inorder, int iStart, int[] postorder,
			int pStart, int length, HashMap<Integer, Integer> cache) {
		if (length == 0)
			return null;
		else {
			int root = postorder[pStart + length - 1];
			int index = cache.get(root);
			TreeNode tree = new TreeNode(root);
			int leftLen = index - iStart;
			int rightLen = length - leftLen - 1;
			if (leftLen > 0)
				tree.left = builder(inorder, iStart, postorder, pStart,
						leftLen, cache);
			if (rightLen > 0)
				tree.right = builder(inorder, index + 1, postorder, pStart
						+ leftLen, rightLen, cache);
			return tree;
		}
	}
}
