package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FractiontoRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		boolean neg = false;
		if (numerator < 0 && denominator > 0 || numerator > 0
				&& denominator < 0) {
			neg = true;
		}
		long numerators = Math.abs((long) numerator);
		long denominators = Math.abs((long) denominator);
		long zh = numerators / denominators;
		long yu = numerators % denominators;
		if (yu == 0) {
			if (neg)
				return "-" + zh + "";
			else
				return zh + "";
		}
		Map<Long, Integer> map = new HashMap<>();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (!map.containsKey(yu)) {
			map.put(yu, i++);
			sb.append(yu * 10 / denominators);
			yu = (yu * 10) % denominators;
			if (yu == 0) {
				if (neg)
					return "-" + zh + "." + sb.toString();
				else
					return zh + "." + sb.toString();
			}
		}
		sb.insert(map.get(yu), "(");
		sb.append(')');
		if (neg)
			return "-" + zh + "." + sb.toString();
		else
			return zh + "." + sb.toString();
	}

	public static void main(String args[]) {
		System.out.println(Math.sqrt(676));
	}
}
