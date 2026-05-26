package com.socialnet.java_othello;

public class Main {
    public static void main(String[] args) {
        ReversiGame game = new ReversiGame();

        game.initializeBoard();
        game.printBoard();
        System.out.println();
        game.makeMove(2, 3, 'B');
        game.printBoard();
        game.makeMove(2,4, 'W');
        game.printBoard();
        game.makeMove(4, 5, 'B');
        game.printBoard();
        game.makeMove(4,1, 'W');//not valid
        game.printBoard();
        game.makeMove(5, 4, 'W');
        game.printBoard();
    }
}