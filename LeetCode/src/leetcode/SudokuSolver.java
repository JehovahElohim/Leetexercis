package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SudokuSolver {
	public static void solveSudoku(char[][] board) {
		List<char[][]> l = new ArrayList<>();
		dfs(board, 0, 0, l);
		char[][] c = l.get(0);
		for (int i = 0; i < 9; i++) {
			board[i] = Arrays.copyOf(c[i], c[i].length);
		}
	}

	public static void dfs(char[][] board, int x, int y, List<char[][]> l) {
		if (l.size() != 0) {
			return;
		}
		if (x == 9) {
			char[][] c = new char[9][9];
			for (int i = 0; i < 9; i++) {
				c[i] = Arrays.copyOf(board[i], board[i].length);
			}
			l.add(c);
			return;
		}

		int x1 = x;
		int y1 = y;
		if (y == 8) {
			y1 = 0;
			x1 = x + 1;
		} else {
			y1 = y + 1;
		}

		if (board[x][y] != '.') {
			dfs(board, x1, y1, l);
			return;
		}
		List<Character> res = findValibleNum(board, x, y);
		for (int i = 0; i < res.size(); i++) {
			board[x][y] = res.get(i);
			dfs(board, x1, y1, l);
			board[x][y] = '.';
		}
	}

	public static List<Character> findValibleNum(char[][] board, int x, int y) {
		if (board[x][y] != '.')
			return null;
		List<Character> res = new ArrayList<Character>();
		boolean[] num = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if (Character.isDigit(board[x][i])) {
				num[board[x][i] - '0'] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (Character.isDigit(board[i][y])) {
				num[board[i][y] - '0'] = true;
			}
		}
		x = x / 3 * 3;
		y = y / 3 * 3;
		for (int i = x; i < 3 + x; i++) {
			for (int j = y; j < 3 + y; j++) {
				if (Character.isDigit(board[i][j])) {
					num[board[i][j] - '0'] = true;
				}
			}
		}
		for (int i = 1; i < num.length; i++) {
			if (!num[i])
				res.add((char) (i + '0'));
		}
		return res;
	}

	public static void toChar(String a) {
		System.out.println(a.replaceAll("\"", "'"));
	}

	public static void main(String args[]) {
		char c[][] = new char[][] {
				{ '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		solveSudoku(c);
		// ["5","1","9","7","4","8","6","3","2"]
		// ["7","8","3","6","5","2","4","1","9"]
		// ["4","2","6","1","3","9","8","7","5"]
		// ["3","5","7","9","8","6","2","4","1"]
		// ["2","6","4","3","1","7","5","9","8"]
		// ["1","9","8","5","2","4","3","6","7"]
		// ["9","7","5","8","6","3","1","2","4"]
		// ["8","3","2","4","9","1","7","5","6"]
		// ["6","4","1","2","7","5","9","8","3"]

	}
}
