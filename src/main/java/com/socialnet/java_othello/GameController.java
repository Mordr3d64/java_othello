package com.socialnet.java_othello;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane boardGrid;
    @FXML
    private Label statusLabel;
    private Button[][] buttons = new Button[8][8];
    private ReversiGame game = new ReversiGame();

    private void handleSquareClick(int row, int col) {
        char currentPlayer = game.currentPlayer;
        if (!game.hasValidMove(currentPlayer)) {
            game.skipTurnIfNoMoves();
            refreshBoard();
            statusLabel.setText("No legal moves for " + currentPlayer + "; turn skipped to " + game.currentPlayer);
            System.out.println("No legal moves for " + currentPlayer + "; turn skipped to " + game.currentPlayer);
            return;
        }

        boolean legalMove = game.makeMove(row, col, currentPlayer);
        if (legalMove) {
            refreshBoard();
            statusLabel.setText("Legal move at (" + row + ", " + col + "). Current player: " + game.currentPlayer);
            System.out.println("Legal move at (" + row + ", " + col + ")");
        } else {
            statusLabel.setText("Illegal move at (" + row + ", " + col + ")");
            System.out.println("Illegal move at (" + row + ", " + col + ")");
        }
    }

    private void refreshBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Button button = buttons[row][col];
                button.setGraphic(null);
                if (!game.board.isEmpty(row, col)) {
                    button.setGraphic(game.board.get(row, col).createGraphic());
                }
            }
        }
    }
    @FXML
    public void initialize() {
        game.startGame();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final int row = i;
                final int col = j;
                Button button = new Button();
                button.setPrefSize(60, 60);
                button.setOnAction(event -> handleSquareClick(row, col));
                buttons[i][j] = button;
                boardGrid.add(button, j, i);
            }
        }
        
        refreshBoard();
        statusLabel.setText("Current player: " + game.currentPlayer);
    }
}