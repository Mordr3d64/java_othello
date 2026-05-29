package com.socialnet.java_othello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReversiApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader =
                new FXMLLoader(ReversiApplication.class.getResource("game-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Reversi");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}