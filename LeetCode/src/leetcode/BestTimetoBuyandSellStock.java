package leetcode;

/**
 * 　给一个数组prices[]，prices[i]代表股票在第i天的售价，求出只做一次交易(一次买入和卖出)能得到的最大收益。
 * 
 * @author asus pc
 *
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int max = 0;
		int low = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] > prices[i + 1]) {
				low = prices[i + 1] < prices[low] ? i + 1 : low;
			} else
				max = Math.max(max, prices[i + 1] - prices[low]);
		}
//		System.out.println(max);
		return max;
	}

	public static void main(String args[]) {
		new BestTimetoBuyandSellStock().maxProfit(new int[] {7, 1, 5, 3, 6, 4 });
	}
}
