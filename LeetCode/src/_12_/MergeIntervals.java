package _12_;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * 
 * @author asus pc 思路：先排序，再合并
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new helper());
		int len = intervals.size();
		for (int i = 0; i < len - 1; i++) {
			Interval i1 = intervals.get(i);
			Interval i2 = intervals.get(i + 1);
			if (i1.end >= i2.start) {
				i1.end = Math.max(i1.end, i2.end);
				intervals.remove(i + 1);
				i--;
				len--;
			}
		}
		return intervals;
	}

	public static void main(String args[]) {
	}

	class helper extends Interval implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.start - o2.start < 0)
				return -1;
			else if (o1.start == o2.start)
				return o1.end - o2.end;
			else
				return 1;
		}

	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}