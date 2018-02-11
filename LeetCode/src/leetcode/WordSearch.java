package leetcode;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once. For example
 * 
 * Given board =
 * 
 * [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ] word = "ABCCED",
 * -> returns true, word = "SEE", -> returns true, word = "ABCB", -> returns
 * false.
 * 
 * @author asus pc 思路：DFS
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word.equals(""))
			return true;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(board, visited, i, j, word, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, boolean[][] visited, int x, int y,
			String word, int index) {
		if (index == word.length())
			return true;
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return false;
		if (visited[x][y])
			return false;
		if (board[x][y] != word.charAt(index))
			return false;
		visited[x][y] = true;
		if (dfs(board, visited, x - 1, y, word, index + 1))
			return true;
		if (dfs(board, visited, x + 1, y, word, index + 1))
			return true;
		if (dfs(board, visited, x, y - 1, word, index + 1))
			return true;
		if (dfs(board, visited, x, y + 1, word, index + 1))
			return true;
		visited[x][y] = false;

		return false;
	}
}
