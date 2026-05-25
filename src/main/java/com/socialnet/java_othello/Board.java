package com.socialnet.java_othello;
//board setup
public class Board {
    private Disc[][] grid = new Disc[8][8];

    public Disc[][] getGrid() {
        return grid;
    }

    public Disc get(int row, int col) {
        return grid[row][col];
    }

    public void set(int row, int col, Disc disc) {
        grid[row][col] = disc;
    }

    public boolean isEmpty(int row, int col) {
        return grid[row][col] == null;
    }
}