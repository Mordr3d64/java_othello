package com.socialnet.java_othello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReversiGameTest {

    @Test
    void skipTurnIfNoMovesSwitchesPlayer() {
        ReversiGame game = new ReversiGame();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                game.board.set(row, col, new Disc('B'));
            }
        }
        game.currentPlayer = 'W';

        game.skipTurnIfNoMoves();

        assertEquals('B', game.currentPlayer);
    }

    @Test
    void makeMoveReturnsFalseForIllegalMove() {
        ReversiGame game = new ReversiGame();
        game.initializeBoard();
        game.currentPlayer = 'B';

        assertFalse(game.makeMove(0, 0, 'B'));
        assertTrue(game.hasValidMove('B'));
    }

    @Test
    void gameOverDetectedWhenOneSideHasNoDiscsLeft() {
        ReversiGame game = new ReversiGame();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                game.board.set(row, col, new Disc('B'));
            }
        }

        assertTrue(game.isGameOver());
        assertEquals("Game over! Winner: B (64-0)", game.getGameResultMessage());
    }
}
