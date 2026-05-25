package com.socialnet.java_othello;
//everything else logic
import java.util.ArrayList;
import java.util.List;

public class ReversiGame {

    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static final char EMPTY = '.';
    static final char BLACK = 'B';
    static final char WHITE = 'W';

    Board board = new Board();

    char currentPlayer = 'B'; // Black starts

    char getOpponent(char player) {
        return (player == 'B') ? 'W' : 'B';
    }

    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.set(i, j, null);
            }
        }

        board.set(3, 3, new Disc('W'));
        board.set(3, 4, new Disc('B'));
        board.set(4, 3, new Disc('B'));
        board.set(4, 4, new Disc('W'));
    }

    //testcommit
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

    boolean checkDirection(int row, int col, int dx, int dy, char player) {
        char opponent = getOpponent(player);

        int i = row + dx;
        int j = col + dy;

        // Step 1: must have opponent first
        if (i < 0 || i >= 8 || j < 0 || j >= 8 ||
                board.isEmpty(i, j) ||
                board.get(i, j).getColor() != opponent) {
            return false;
        }

        // Step 2: move along direction
        i += dx;
        j += dy;

        while (i >= 0 && i < 8 && j >= 0 && j < 8) {

            if (board.isEmpty(i, j)) return false;

            if (board.get(i, j).getColor() == player) {
                return true;
            }

            i += dx;
            j += dy;
        }

        return false;
    }

    boolean isValidMove(int row, int col, char player) {

        // Must be empty
        if (!board.isEmpty(row, col)) return false;

        for (int d = 0; d < 8; d++) {

            if (checkDirection(row, col, dx[d], dy[d], player)) {
                return true;
            }

        }

        return false;
    }

    boolean hasValidMove(char player) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (isValidMove(i, j, player)) {
                    return true;
                }

            }
        }

        return false;
    }

    // ===== VALID MOVE LIST =====

    public List<Move> getValidMoves(char player) {

        List<Move> validMoves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (isValidMove(i, j, player)) {
                    validMoves.add(new Move(i, j));
                }

            }
        }

        return validMoves;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'B') ? 'W' : 'B';
    }

    //3
    public void makeMove(int row, int col, char player) {

    }

    //2
    private void flipDiscs(int row, int col, char player) {

    }

    //1
    private void flipDirection(int row, int col, int dx, int dy, char player) {

    }

    void startGame() {
        //black first
        //check for possible moves
    }
}