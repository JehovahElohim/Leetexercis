package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		Set<Character> x = new HashSet<>();
		Set<Character> y = new HashSet<>();
		Set<Character> m = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (Character.isDigit(board[i][j])) {
					if (x.contains(board[i][j]))
						return false;
					x.add(board[i][j]);
				} else if (board[i][j] == '.')
					continue;
				else
					return false;
			}
			x.clear();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (Character.isDigit(board[j][i])) {
					if (y.contains(board[j][i]))
						return false;
					y.add(board[j][i]);
				} else if (board[j][i] == '.')
					continue;
				else
					return false;
			}
			y.clear();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = i / 3 * 3; j < 3 + i / 3 * 3; j++) {
				for (int j2 = (i % 3) * 3; j2 < 3 + (i % 3) * 3; j2++) {
					System.out.print(j+","+j2+" ");
					if (Character.isDigit(board[j][j2])) {
						if (m.contains(board[j][j2]))
							return false;
						m.add(board[j][j2]);
					} else if (board[j][j2] == '.')
						continue;
					else
						return false;
				}
			}
			m.clear();
			System.out.println();
		}
		return true;
	}

	public static void main(String args[]) {
		char[][] c = new char[9][9];
		for (int i = 0; i < c.length; i++) {
			Arrays.fill(c[i], '.');
		}
		isValidSudoku(c);
	}
}
