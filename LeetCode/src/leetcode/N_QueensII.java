package leetcode;


public class N_QueensII {
	public static int totalNQueens(int n) {
		int[][] res = new int[n][n];
		int[][] visited = new int[n][n];
		return dfs(res, visited, 0);
	}

	public static int dfs(int[][] res, int[][] visited, int row) {
		if (row >= res.length) {
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < res.length; i++) {
			if (visited[row][i] == 0) {
				res[row][i] = 1;
				visited(visited, row, i);
				sum += dfs(res, visited, row + 1);
				unvisited(visited, row, i);
				res[row][i] = 0;
			}
		}
		return sum;
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
	public static void main(String args[]) {
		System.out.println(totalNQueens(4));
	}
}
