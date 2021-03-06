package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：给出以前序和中序遍历的二叉树的序列，构造二叉树。 找 index变量的时候出了点问题 没有加上iStart
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return constructTree(preorder, 0, inorder, 0, preorder.length);
	}

	public TreeNode constructTree(int[] preorder, int pStart, int[] inorder,
			int iStart, int length) {
		if (length == 0 || pStart >= preorder.length)
			return null;
		else {
			int root = preorder[pStart];
			int index = -1;
			for (int i = 0; i < length; i++) {
				if (inorder[i + iStart] == root) {
					index = i + iStart;
					break;
				}
			}
			TreeNode tree = new TreeNode(root);
			int leftLen = index - iStart;
			int rightLen = length - index - 1 + iStart;
			if (leftLen > 0)
				tree.left = constructTree(preorder, pStart + 1, inorder,
						iStart, leftLen);
			if (rightLen > 0)
				tree.right = constructTree(preorder, pStart + 1 + leftLen,
						inorder, index + 1, rightLen);
			return tree;
		}

	}

	public static void main(String args[]) {
		new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(
				new int[] { 2,3,1 }, new int[] { 1,2,3 });
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
	@Override
	public String toString() {
		return val+"";
	}
	public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}