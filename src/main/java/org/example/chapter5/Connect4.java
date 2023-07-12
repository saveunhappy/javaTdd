package org.example.chapter5;

import java.util.Arrays;
import java.util.StringJoiner;

public class Connect4 {
    public enum Color {
        RED('R'), GREEN('G'), EMPTY(' ');
        private final char value;

        Color(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    //初始化，红色先下
    private Color currentPlayer = Color.RED;
    private static final String DELIMITER = "|";
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private final Color[][] board = new Color[COLUMNS][ROWS];

    public Connect4() {
        for (Color[] column : board) {
            Arrays.fill(column, Color.EMPTY);
        }
    }

    //使用Color.RED指出哪些位置被占据了
    public void putDisc(int column) {
        if (column > 0 && column <= COLUMNS) {
            int numOfDiscs = getNumberOfDiscsInColumn(column - 1);
            if (numOfDiscs < ROWS) {
                board[column - 1][numOfDiscs] = currentPlayer;
                printBoard();        // 4.打印
                switchPlayer();        // 3.切换玩家
            } else {                // 4.打印
                System.out.println(numOfDiscs);
                System.out.println("There's no room for a new disc in this column");
                printBoard();
            }
        } else {                    // 4.打印
            System.out.println("Column out of bounds");
            printBoard();
        }
    }

    private int getNumberOfDiscsInColumn(int column) {
        if (column >= 0 && column < COLUMNS) {
            int row;
            for (row = 0; row < ROWS; row++) {
                if (Color.EMPTY == board[column][row]) {
                    return row;
                }
            }
            return row;
        }
        return -1;
    }

    private void switchPlayer() {
        if (Color.RED == currentPlayer) {
            currentPlayer = Color.GREEN;
        } else {
            currentPlayer = Color.RED;
        }
        System.out.println("Current turn:" + currentPlayer);
    }

    public void printBoard() {
        for (int row = ROWS - 1; row >= 0; row--) {
            StringJoiner stringJoiner = new StringJoiner(DELIMITER, DELIMITER, DELIMITER);
            for (int col = 0; col < COLUMNS; ++col) {
                stringJoiner.add(board[col][row].toString());
            }
            System.out.println(stringJoiner);
        }
    }


}
