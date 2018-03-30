package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	public static List<List<String>> solveNQueens(int n) {
		int[][] res = new int[n][n];
		int[][] visited = new int[n][n];
		List<List<String>> list = new ArrayList<List<String>>();
		dfs(res, visited, list, 0);
		return list;
	}

	public static void dfs(int[][] res, int[][] visited,
			List<List<String>> list, int row) {
		if (row >= res.length) {
			list.add(matrixToString(res));
			return;
		}
		for (int i = 0; i < res.length; i++) {
			if (visited[row][i] == 0) {
				res[row][i] = 1;
				visited(visited, row, i);
				dfs(res, visited, list, row + 1);
				unvisited(visited, row, i);
				res[row][i] = 0;
			}
		}
	}

	public static void visited(int[][] visited, int x, int y) {
		for (int i = 0; i < visited.length; i++) {
			visited[x][i]++;
		}
		for (int i = 0; i < visited.length; i++) {
			visited[i][y]++;
		}
		int x1 = x;
		int y1 = y;
		while (x1 > 0 && y1 > 0) {
			visited[--x1][--y1]++;
		}
		x1 = x;
		y1 = y;
		while (x1 > 0 && y1 < visited.length - 1) {
			visited[--x1][++y1]++;
		}
		x1 = x;
		y1 = y;
		while (x1 < visited.length - 1 && y1 > 0) {
			visited[++x1][--y1]++;
		}
		x1 = x;
		y1 = y;
		while (x1 < visited.length - 1 && y1 < visited.length - 1) {
			visited[++x1][++y1]++;
		}
		visited[x][y]--;
	}

	public static void unvisited(int[][] visited, int x, int y) {
		for (int i = 0; i < visited.length; i++) {
			visited[x][i]--;
		}
		for (int i = 0; i < visited.length; i++) {
			visited[i][y]--;
		}
		int x1 = x;
		int y1 = y;
		while (x1 > 0 && y1 > 0) {
			visited[--x1][--y1]--;
		}
		x1 = x;
		y1 = y;
		while (x1 > 0 && y1 < visited.length - 1) {
			visited[--x1][++y1]--;
		}
		x1 = x;
		y1 = y;
		while (x1 < visited.length - 1 && y1 > 0) {
			visited[++x1][--y1]--;
		}
		x1 = x;
		y1 = y;
		while (x1 < visited.length - 1 && y1 < visited.length - 1) {
			visited[++x1][++y1]--;
		}
		visited[x][y]++;
	}

	public static List<String> matrixToString(int[][] m) {
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < m.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m.length; j++) {
				if (m[i][j] == 1)
					sb.append('Q');
				else if (m[i][j] == 0)
					sb.append('.');
			}
			l.add(sb.toString());
		}
		return l;
	}

	public static void main(String args[]) {
		System.out.println(solveNQueens(4).size());
	}
}
