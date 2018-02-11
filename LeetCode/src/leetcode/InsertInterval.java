package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author asus pc
 * 思路：先找到插入位置，在判断是否合并
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int len = intervals.size();
		for (int i = 0; i < len; i++) {
			if (intervals.get(i).end >= newInterval.start) {
				if (intervals.get(i).start > newInterval.end) {
					intervals.add(i, newInterval);
					return intervals;
				}
				Interval i1 = intervals.get(i);
				int max = Math.max(i1.end, newInterval.end);

				while (i < len - 1
						&& newInterval.end >= intervals.get(i + 1).start) {
					max = Math.max(max, intervals.get(i + 1).end);
					intervals.remove(i + 1);
					len--;
				}
				i1.end = max;
				i1.start = Math.min(i1.start, newInterval.start);
				return intervals;
			}
		}
		intervals.add(newInterval);
		return intervals;

	}

	public static void main(String arsgs[]) {
		List<Interval> a = new ArrayList<Interval>();
		a.add(new Interval(1, 5));
		a.add(new Interval(3, 5));
		a.add(new Interval(6, 7));
		a.add(new Interval(8, 10));
		a.add(new Interval(12, 19));
		new InsertInterval().insert(a, new Interval(4, 9));
	}
}
