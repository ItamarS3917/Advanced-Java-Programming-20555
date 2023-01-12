package com.example.triviagame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TriviaGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TriviaGameApplication.class.getResource("triviaGame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 670, 470);
        stage.setTitle("Hello To The Trivia Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}