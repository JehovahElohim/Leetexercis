package _2018wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:
 * 'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 * 
 * 输入描述: 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
 * 
 * 
 * 输出描述: 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 * 
 * 如样例所示: s = "aaabbaaac" 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 * 
 * 输入例子1: aaabbaaac
 * 
 * 输出例子1: 2.25
 * 
 * @author asus pc
 *
 */
public class _3 {
	// public static void main(String args[]) {
	// Scanner in = new Scanner(System.in);
	//
	// while (in.hasNext()) {
	// String s = in.nextLine();
	//
	// System.out.println();
	// }
	// }
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			int len = s.length();
			List<Integer> result = new ArrayList<>();
			int count = 1;
			for (int i = 1; i < len; i++) {
				if (s.charAt(i - 1) == s.charAt(i)) {
					count++;

				} else {
					result.add(count);
					count = 1;
				}
				if (i == len - 1)
					result.add(count);
			}
			int total = 0;
			for (Integer integer : result) {
				total += integer;
			}

			double res = (double) total / result.size();
			int r = (int) Math.round(res * 100);
			String a = (double) r / 100 + "";
			if (a.indexOf('.') + 3 != a.length())
				System.out.println(a + "0");
			else
				System.out.println((double) r / 100);
		}
	}
}
