package _12_;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * @author asus pc 2、使用栈的目的就是构造这样的升序序列，按照以上方法求解。
 * 
 *         但是height本身不一定是升序的，应该怎样构建栈？
 * 
 *         比如2,1,5,6,2,3
 * 
 *         （1）2进栈。s={2}, result = 0
 * 
 *         （2）1比2小，不满足升序条件，因此将2弹出，并记录当前结果为2*1=2。
 * 
 *         将2替换为1重新进栈。s={1,1}, result = 2
 * 
 *         （3）5比1大，满足升序条件，进栈。s={1,1,5},result = 2
 * 
 *         （4）6比5大，满足升序条件，进栈。s={1,1,5,6},result = 2
 * 
 *         （5）2比6小，不满足升序条件，因此将6弹出，并记录当前结果为6*1=6。s={1,1,5},result = 6
 * 
 *         2比5小，不满足升序条件，因此将5弹出，并记录当前结果为5*2=10（因为已经弹出的5,6是升序的）。s={1,1},result =
 *         10
 * 
 *         2比1大，将弹出的5,6替换为2重新进栈。s={1,1,2,2,2},result = 10
 * 
 *         （6）3比2大，满足升序条件，进栈。s={1,1,2,2,2,3},result = 10
 * 
 *         栈构建完成，满足升序条件，因此按照升序处理办法得到上述的max(height[i]*(size-i))=max{3*1, 2*2,
 *         2*3, 2*4, 1*5, 1*6}=8<10
 */
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		if (heights.length == 1)
			return heights[0];
		Stack<Integer> s = new Stack<Integer>();
		s.push(heights[0]);
		int max = 0;
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] >= s.peek()) {
				s.push(heights[i]);
			} else {
				int j = 0;
				while (s.size() != 0 && heights[i] < s.peek()) {
					max = Math.max(max, s.pop() * (++j));
				}
				while (j >=0) {
					s.push(heights[i]);
					j--;
				}
			}
		}
		max = Math.max(max, s.get(0) * s.size());
		for (int i = 0; i < s.size() - 1; i++) {
			if (s.get(i) != s.get(i + 1))
				max = Math.max((s.size() - i-1) * s.get(i + 1), max);
		}
		return max;
	}

	public static void main(String args[]) {
		new LargestRectangleinHistogram().largestRectangleArea(new int[] { 2,
				1, 2 });
	}
}
