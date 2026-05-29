package com.socialnet.java_othello;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML
    private GridPane boardGrid;
    private Button[][] buttons = new Button[8][8];
    private ReversiGame game = new ReversiGame();

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
    }
}