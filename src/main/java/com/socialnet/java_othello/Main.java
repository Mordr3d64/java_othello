package com.socialnet.java_othello;

public class Main {
    public static void main(String[] args) {
        ReversiGame game = new ReversiGame();

        game.initializeBoard();
        game.printBoard();
        System.out.print(game.getOpponent('W'));

        System.out.println(game.isValidMove(2, 3, 'B')); // true
        System.out.println(game.isValidMove(3, 2, 'B')); // true
        System.out.println(game.isValidMove(4, 5, 'B')); // true
        System.out.println(game.isValidMove(5, 4, 'B')); // true

        System.out.println(game.isValidMove(0, 0, 'B')); // false
        System.out.println(game.isValidMove(3, 3, 'B')); // false (occupied)
        game.startGame();
    }
}