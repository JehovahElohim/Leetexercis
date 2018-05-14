package leetcode;

import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}

public class MaxPointsonaLine {

	public int maxPoints(Point[] points) {
		Map<Line, Integer> lines = new HashMap<Line, Integer>();
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				Line t = buildLine(points[i], points[j]);
				if (t != null)
					lines.put(t, 0);
			}
		}
		if (lines.isEmpty())
			return points.length;
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			for (Map.Entry<Line, Integer> entry : lines.entrySet()) {
				if (entry != null && entry.getKey().isOnLine(points[i])) {
					max = Math.max(entry.getValue() + 1, max);
					lines.put(entry.getKey(), entry.getValue() + 1);
				}
			}
		}
		return max;
	}

	public Line buildLine(Point a, Point b) {
		if (a.x == b.x && a.y == b.y)
			return null;
		else
			return new Line(a, b);
	}

	public static class Line {
		Point a;
		Point b;

		public Line(Point a, Point b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			Line other = (Line) obj;
			if (isOnLine(other.a) && isOnLine(other.b))
				return true;
			else
				return false;
		}

		public boolean isOnLine(Point p) {
			if ((p.x == a.x && p.y == a.y) || (p.x == b.x && p.y == b.y)) {
				return true;
			}
			if (((long)a.x - p.x) * ((long)b.y - p.y) == ((long)b.x - p.x) * ((long)a.y - p.y))
			{
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Line [a=" + a + ", b=" + b + "]";
		}
	}
}
