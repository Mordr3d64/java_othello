package com.socialnet.java_othello;

public class ReversiGame {

    static final char EMPTY = '.';
    static final char BLACK = 'B';
    static final char WHITE = 'W';

    Board board = new Board();

    char getOpponent(char player) {
        return (player == 'B') ? 'W' : 'B';
    }

    public void initializeBoard() {
        // Clear board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.set(i, j, null);
            }
        }

        // Starting pieces
        board.set(3, 3, new Disc('W'));
        board.set(3, 4, new Disc('B'));
        board.set(4, 3, new Disc('B'));
        board.set(4, 4, new Disc('W'));
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
                if (board.isEmpty(i, j)) {
                    System.out.print(". ");
                } else {
                    System.out.print(board.get(i, j).getColor() + " ");
                }
            }
            System.out.println();
        }
    }
}