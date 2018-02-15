package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author asus pc
 *
 */

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		// 动态规划
		// 第j天前完成第i笔交易时的price最大值
		int[][] sell = new int[2][prices.length];
		// 第j天前完成第i次买入时的price最大值
		int[][] buy = new int[2][prices.length];
		for (int i = 0; i < buy.length; i++) {
			for (int j = 0; j < prices.length; j++) {
				if (j == 0) {
					buy[i][j] = -prices[j];
				} else if (i == 0) {
					buy[i][j] = Math.max(-prices[j], buy[i][j - 1]);
				} else {
					buy[i][j] = Math.max(sell[i - 1][j] - prices[j],
							buy[i][j - 1]);
				}
				if (j != 0)
					sell[i][j] = Math
							.max(buy[i][j] + prices[j], sell[i][j - 1]);

			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < prices.length; j++) {
				System.out.print(buy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Sell");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < prices.length; j++) {
				System.out.print(sell[i][j] + " ");
			}
			System.out.println();
		}
		return sell[sell.length - 1][prices.length - 1];
	}

	public static void main(String args[]) {
		new BestTimetoBuyandSellStockIII().maxProfit(new int[] { 1,2});
	}
}
