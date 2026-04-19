package com.socialnet.java_othello;

public class ReversiGame {

    static final char EMPTY = '.';
    static final char BLACK = 'B';
    static final char WHITE = 'W';

    Disc[][] board = new Disc[8][8];

    boolean isEmpty(int row, int col) {
        return board[row][col] == null;
    }

    char getOpponent(char player) {
        return (player == 'B') ? 'W' : 'B';
    }

    public void initializeBoard() {
        // Empty board (null = empty)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

        // Starting pieces
        board[3][3] = new Disc('W');
        board[3][4] = new Disc('B');
        board[4][3] = new Disc('B');
        board[4][4] = new Disc('W');
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].getColor() + " ");
                }
            }
            System.out.println();
        }
    }
}