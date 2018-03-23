package _2018wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String bds = s.nextLine();
		String[] nums = bds.split("\\+");
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i].equals(nums[i + 1])) {
				count++;
			} else {
				sb.append(nums[i]).append("*").append(count).append("+");
				count = 1;
			}
		}
		sb.append(nums[nums.length - 1]).append("*").append(count);
		int sum = 0;

		String[] res = sb.toString().split("\\+");
		for (int i = 0; i < res.length; i++) {
			String[] temp = res[i].split("\\*");
			sum += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
		}

		System.out.println(sb.toString());
		System.out.println(sum);
	}

	public static List<Integer> readInts(Scanner s) {
		String a = s.nextLine();
		String[] ss = a.split(" ");
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < ss.length; i++) {
			if (!ss.equals(""))
				res.add(Integer.parseInt(ss[i]));
		}
		return res;
	}

	public static int[] readInts(Scanner s, int n) {
		String a = s.nextLine();
		String[] ss = a.split(" ");
		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (!ss.equals(""))
				res[i] = Integer.parseInt(ss[i]);
		}
		return res;
	}

	public static String[] readStrings(Scanner s, int n) {
		String a = s.nextLine();
		String[] ss = a.split(" ");
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			if (!ss.equals(""))
				res[i] = ss[i];
		}
		return res;
	}

	public static List<String> readStrings(Scanner s) {
		String a = s.nextLine();
		String[] ss = a.split(" ");
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < ss.length; i++) {
			if (!ss.equals(""))
				res.add(ss[i]);
		}
		return res;
	}

	public static int[][] readIntMatrix(Scanner s, int l, int w) {
		int[][] res = new int[l][w];
		for (int i = 0; i < l; i++) {
			String ss = s.nextLine();
			for (int j = 0; j < w; j++) {
				res[i][j] = ss.charAt(w);
			}
		}
		return res;
	}

	public static char[][] readCharMatrix(Scanner s, int l, int w) {
		char[][] res = new char[l][w];
		for (int i = 0; i < l; i++) {
			String ss = s.nextLine();
			for (int j = 0; j < w; j++) {
				res[i][j] = ss.charAt(w);
			}
		}
		return res;
	}

	public static int readInt(Scanner s) {
		String a = s.nextLine();
		return Integer.parseInt(a);
	}

	public static String readString(Scanner s) {
		String a = s.nextLine();
		return a;
	}

}
