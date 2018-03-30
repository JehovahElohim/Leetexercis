package _2018wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String[] ints = readInts(s);
		String matrix[][] = new String[ints.length][ints.length];
		matrix[0] = ints;
		for (int i = 1; i < matrix.length; i++) {
			matrix[i] = readInts(s);
		}

		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - 1 - i; j++) {
				String temp = matrix[j][matrix.length - i - 1];// 1 2 1 1
				int ii = i;
				int jj = j;
				for (int j2 = 0; j2 < 4; j2++) {
					if (j2 == 3) {
						matrix[jj][matrix.length - ii - 1] = temp;
					} else {
						matrix[jj][matrix.length - ii - 1] = matrix[ii][jj];
						int t1 = ii;
						ii = matrix.length - jj - 1;
						jj = t1;
					}
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < matrix.length; j++) {
				if (j == matrix.length - 1)
					sb.append(matrix[i][j]);
				else
					sb.append(matrix[i][j]).append(' ');
			}
			System.out.println(sb);
		}
	}

	public static String[] readInts(Scanner s) {
		String a = s.nextLine();
		a = a.trim();
		String[] ss = a.split(" ");
		for (int i = 0; i < ss.length; i++) {
			ss[i] = ss[i].replaceAll("　", "");
		}
		List<String> l = new ArrayList<>();
		for (int i = 0; i < ss.length; i++) {
			if (!ss[i].equals("") && !ss[i].equals("　")) {
				l.add(ss[i]);
			}
		}
		String res[] = new String[l.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = l.get(i);
		}
		return res;
	}
}
