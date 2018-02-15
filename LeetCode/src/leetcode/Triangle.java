package leetcode;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * @author asus pc 动态规划
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		int result[] = new int[len];
		for (int i = 0; i < result.length; i++) {
			result[i] = triangle.get(len-1).get(i);
		}
		
		for (int j = len - 2; j >= 0; j--) {
			for (int i = 0; i < j+1; i++) {
				result[i] = Math.min(result[i], result[i + 1]) + triangle.get(j).get(i);
			}
		}
		return result[0];
	}
}
