package com.socialnet.java_othello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReversiApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ReversiApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(loader.load());

        // give the menu controller the primary stage so it can switch scenes
        Object controller = loader.getController();
        if (controller instanceof com.socialnet.java_othello.MainMenuController) {
            ((com.socialnet.java_othello.MainMenuController) controller).setStage(stage);
        }

        stage.setTitle("Reversi");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}