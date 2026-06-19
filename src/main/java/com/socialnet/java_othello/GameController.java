package com.socialnet.java_othello;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane boardGrid;
    private Button[][] buttons = new Button[8][8];
    private ReversiGame game = new ReversiGame();

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
                Button button = new Button();
                button.setPrefSize(60, 60);
                buttons[i][j] = button;
                boardGrid.add(button, j, i);
            }
        }
        refreshBoard();


    }
}