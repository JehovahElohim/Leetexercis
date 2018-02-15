package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：构造杨三角
 * 
 * @author asus pc
 *
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> pre = null;
		for (int i = 0; i < numRows; i++) {
			List<Integer> now = new ArrayList<Integer>();
			now.add(1);
			for (int j = 1; j < i+1; j++) {
				if (j == i) {
					now.add(1);
				} else {
					now.add(pre.get(j - 1) + pre.get(j));
				}
			}
			pre = now;
			result.add(now);
			
		}
		return result;
	}
	public static void main(String args[]){
		new PascalTriangle().generate(3);
	}
}
