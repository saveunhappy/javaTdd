package org.example.chapter3;

/**
 * 	需求 1
 *
 * 	首先定义边界，以及将棋子放在哪些地方非法：可将棋子放在3×3棋盘上任何没有棋子的地方。
 * 	可将这个需求分成三个测试：
  1、如果棋子放在超出了X轴边界的地方，就引发 RuntimeException 异常；
  2、如果棋子放在超出了Y轴边界的地方，就引发 RuntimeException 异常；
  3、如果棋子放在已经有棋子的地方，就引发 RuntimeException 异常。
 *
 *	@author hzweiyongqiang
 */
public class DevTicTacToe {

	// 为实现最后一个测试，应将既有棋子的位置存储在一个数组中。
	private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
	private char lastPlayer = '\0';
	private static final int SIZE = 3;

	/**
	 * 	重构 play 方法
	 * 	这个重构过程中，没有改变方法 play 的功能，其行为与以前完全相同，但代码的可读性更强了。
	 *	@param x
	 *	@param y
	 */
	public String play(int x,int y) {
		checkAxis(x);
		checkAxis(y);
		lastPlayer = nextPlayer();	// 记录下一次玩家
		setBox(x, y, lastPlayer);
		if (isWin()) {
			return lastPlayer + " is the winner";
		}
		return "No winner";
	}
	private void checkAxis(int axis) {
		if (axis < 1 || axis >3) {
			throw new RuntimeException("is outside board");
		}
	}
	private void setBox(int x,int y,char lastPlayer) {
		if (board[x-1][y-1] != '\0') {
			throw new RuntimeException("Box is occupied");
		} else {
			board[x-1][y-1] = lastPlayer;
		}
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}
	private boolean isWin() {
		int playerTotal = lastPlayer * 3;
		for (int i = 0; i < SIZE; i++) {
			if ((board[0][i] + board[1][i] + board[2][i]) == playerTotal) {
				// 一个玩家的棋子占据整条水平线就赢了
				return true;
			} else if ((board[i][0] + board[i][1] + board[i][2]) == playerTotal) {
				// 一个玩家的棋子占据整条垂直线就赢了
				return true;
			}
		}
		return false;
	}
}
