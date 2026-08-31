package com.socialnet.java_othello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DifficultyController {

    @FXML
    private Button easyButton;
    @FXML
    private Button mediumButton;
    @FXML
    private Button hardButton;
    @FXML
    private Button backButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        easyButton.setOnAction(e -> openGameWithDifficulty("Easy"));
        mediumButton.setOnAction(e -> openGameWithDifficulty("Medium"));
        hardButton.setOnAction(e -> openGameWithDifficulty("Hard"));
        backButton.setOnAction(e -> goBack());
    }

    private void openGameWithDifficulty(String difficulty) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Scene scene = new Scene(loader.load());
            GameController controller = loader.getController();
            controller.setMode("PVE");
            controller.setDifficulty(difficulty);
            stage.setScene(scene);
            stage.setTitle("Reversi - PVE - " + difficulty);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void goBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-menu.fxml"));
            Scene scene = new Scene(loader.load());
            MainMenuController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(scene);
            stage.setTitle("Reversi");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
