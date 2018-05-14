package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

import leetcode.AddTwoNumbers.ListNode;

public class ____ {
	static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
	public static int[] arr = { 5, 7, 9, 4, 1, 3 };

	public static void main(String args[]) throws IOException,
			InterruptedException, ExecutionException {
		 System.out.println("Factorial Trailing Zeroes".replaceAll(" ", "")
		 .replaceAll("-", "_"));
		// System.out.println("46,89],[50,53],[52,68],[72,45],[77,81".replaceAll(
		// "\\[", "{").replaceAll("\\]", "}"));
		//
//		TreeNode tree = TreeNode.stringToTreeNode("[5,7,9,4,1,3]");
//
//		List<String> temp = new ArrayList<>();
//		temp.add("Tree（5,7,9,4,1,3）");
//		for (int i = 1; i <= 6; i++) {
//			temp.add("NotTravel（" + i + "）");
//		}
//		temp.add("Point（1）");
//		List<List<String>> res = new ArrayList<List<String>>();
//		res.add(new ArrayList<String>(temp));
//		t(tree, 1, res, temp);
//		for (int i = 0; i < res.size(); i++) {
//			for (int j = 0; j < res.get(i).size(); j++) {
//				if (j == 0)
//					System.out.print(res.get(i).get(j) + "\t\t\t\t\t\t\t");
//				else
//					System.out.print(res.get(i).get(j) + "\t\t\t\t\t\t\t\t");
//				if (i + 1 < res.size())
//					System.out.print(res.get(i + 1).get(j));
//				System.out.println();
//			}
//			i++;
//			System.out.println();
//		}
	}

	public static void t(TreeNode tree, int index, List<List<String>> res,
			List<String> temp) {
		if (tree == null) {
			// temp.remove("Point（" + index + "）");
			// temp.add("Point（" + index / 2 + "）");
			return;
		}
		temp.remove("NotTravel（" + index + "）");
		temp.add("Traversal（" + index + "," + arr[index - 1] + "）");
		res.add(new ArrayList<String>(temp));

		// temp.remove("Point（" + index + "）");
		// temp.add("Point（" + index * 2 + "）");
		res.add(new ArrayList<String>(temp));
		t(tree.left, index * 2, res, temp);

		// temp.remove("Point（" + index + "）");
		// temp.add("Point（" + index * 2 + 1 + "）");
		res.add(new ArrayList<String>(temp));
		t(tree.right, index * 2 + 1, res, temp);
	}

	public int JumpFloorII(int target) {
		if (target <= 0)
			return 0;
		if (target == 1)
			return 1;
		int dp[] = new int[target + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= target; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += dp[j];
			}
			dp[i] = sum;
		}
		return dp[target];
	}

	public void heapsort(int[] arr) {
		// 构造大根堆
		int len = arr.length;
		int nonLeaf = len / 2 - 1;
		for (int i = nonLeaf; i >= 0; i--) {
			adjustHeap(arr, i, len);
		}
		// 交换堆顶和末尾元素
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, i, 0);
			adjustHeap(arr, 0, i);
		}
	}

	public static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];// 先取出当前元素i
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
			if (k + 1 < length && arr[k] < arr[k + 1]) {// 如果左子结点小于右子结点，k指向右子结点
				k++;
			}
			if (arr[k] > temp) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;// 将temp值放到最终的位置
	}

	public void quickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int p = partition(arr, start, end);
		quickSort(arr, start, p - 1);
		quickSort(arr, p + 1, end);
	}

	public int partition(int[] arr, int l, int r) {
		int b = r;
		int a = arr[r];
		for (; l < r; l++) {
			if (arr[l] > a) {
				swap(arr, l--, --r);
			}
		}
		swap(arr, r, b);
		return r;
	}

	public void swap(int[] arr, int a, int b) {
		if (a == b)
			return;
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}
}