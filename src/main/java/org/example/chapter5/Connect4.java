package org.example.chapter5;

import java.util.Arrays;

public class Connect4 {
    public enum Color {
        RED('R'), GREEN('G'), EMPTY(' ');
        private final char value;
        Color(char value) { this.value = value; }
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
    //初始化，红色先下
    private Color currentPlayer = Color.RED;
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    private Color[][] board = new Color[COLUMNS][ROWS];
    public Connect4() {
        for (Color[] column : board) {
            Arrays.fill(column, Color.EMPTY);
        }
    }
    //使用Color.RED指出哪些位置被占据了
    public void putDisc(int column) {
        if (column > 0 && column <= COLUMNS) {
            int numOfDiscs =
                    getNumberOfDiscsInColumn(column - 1);
            if (numOfDiscs < ROWS) {
                board[column - 1][numOfDiscs] =
                        currentPlayer;
                switchPlayer();
            }
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


}
