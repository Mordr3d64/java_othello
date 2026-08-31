package com.socialnet.java_othello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button pvpButton;
    @FXML
    private Button pveButton;
    @FXML
    private Button exitButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        pvpButton.setOnAction(e -> openGame("PVP"));
        pveButton.setOnAction(e -> openDifficultyMenu());
        exitButton.setOnAction(e -> {
            if (stage != null) stage.close();
            else System.exit(0);
        });
    }

    private void openGame(String mode) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game-view.fxml"));
            Scene scene = new Scene(loader.load());
            GameController controller = loader.getController();
            controller.setMode(mode);
            stage.setScene(scene);
            stage.setTitle("Reversi - " + mode);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void openDifficultyMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("difficulty-menu.fxml"));
            Scene scene = new Scene(loader.load());
            DifficultyController controller = loader.getController();
            controller.setStage(stage);
            stage.setScene(scene);
            stage.setTitle("Select Difficulty");
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
