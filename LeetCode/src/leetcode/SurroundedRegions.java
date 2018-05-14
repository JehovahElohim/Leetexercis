package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 2 || board[0].length <= 2)
			return;
		Queue<int[]> queue = init(board);
		boolean[][] notSurrounded = new boolean[board.length][board[0].length];
		while (!queue.isEmpty()) {
			int[] xy = queue.poll();
			if (!notSurrounded[xy[0]][xy[1]]) {
				notSurrounded[xy[0]][xy[1]] = true;
				if (xy[0] > 0 && board[xy[0]][xy[1]] == 'O')
					queue.offer(new int[] { xy[0] - 1, xy[1] });
				if (xy[0] < board.length - 1 && board[xy[0]][xy[1]] == 'O')
					queue.offer(new int[] { xy[0] + 1, xy[1] });
				if (xy[1] > 0 && board[xy[0]][xy[1]] == 'O')
					queue.offer(new int[] { xy[0], xy[1] - 1 });
				if (xy[1] < board[0].length - 1 && board[xy[0]][xy[1]] == 'O')
					queue.offer(new int[] { xy[0], xy[1] + 1 });
			}
		}

		for (int i = 0; i < notSurrounded.length; i++) {
			for (int j = 0; j < notSurrounded[0].length; j++) {
				if (!notSurrounded[i][j])
					board[i][j] = 'X';
			}
		}
	}

	public Queue<int[]> init(char[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O')
				queue.offer(new int[] { i, 0 });
			if (board[i][board[0].length - 1] == 'O')
				queue.offer(new int[] { i, board[0].length - 1 });
		}
		for (int i = 1; i < board[0].length - 1; i++) {
			if (board[0][i] == 'O')
				queue.offer(new int[] { 0, i });
			if (board[board.length - 1][i] == 'O')
				queue.offer(new int[] { board.length - 1, i });
		}
		return queue;
	}
}
