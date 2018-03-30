package _2018wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		 int len = readInt(s);
		 int[] num = new int[len];
		 for (int i = 0; i < num.length; i++) {
		 num[i] = readInt(s);
		 }
//		int[] num = new int[] { 1, 2, 4, 0, 0, 0,142, 214, 12,  0 };
		int r = num.length - 1;
		for (int i = 0; i <= r; i++) {
			if (num[i] == 0) {
				for (int j = i + 1; j < num.length; j++) {
					num[j - 1] = num[j];
				}
				num[r] = 0;
				r--;
				i--;
			}
		}
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

	public static void swap(int num[], int i, int j) {
		num[i] = num[i] ^ num[j];
		num[j] = num[i] ^ num[j];
		num[i] = num[i] ^ num[j];
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
