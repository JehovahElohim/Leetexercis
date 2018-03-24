package leetcode;

import java.util.Arrays;

public class UniqueBinarySearchTrees {
	public static int numTrees(int n) {
		double[] dp = new double[n + 1];
		dp[0] = 1;
		for (double i = 1; i < dp.length; i++) {
			dp[(int) i] = (4 * i - 2) / (i + 1) * dp[(int) (i - 1)];
		}
		System.out.println(Arrays.toString(dp));
		return (int)dp[n];
	}
	public static void main(String args[]){
		System.out.println(numTrees(3));
	}
}
