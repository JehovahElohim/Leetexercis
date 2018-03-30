package leetcode;

import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		if (n <= 0 || k <= 0)
			return "";
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}
		StringBuilder sb = new StringBuilder();
		int sum = 1;
		for (int i = 1; i < n + 1; i++) {
			sum *= i;
		}
		if (k > sum)
			return "";
		while (n > 0) {
			sum /= n--;
			for (int i = 0; i <= n; i++) {
				if (k > sum * i && k <= sum * (i + 1)) {
					k -= sum * i;
					sb.append(list.get(i));
					list.remove(i);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(getPermutation(5, 44));
	}
}
