package com.arkhash.coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WRCC extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // it loads the FXML file "main-view.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(WRCC.class.getResource("main-view.fxml"));
        // loads the new scene
        Scene scene = new Scene(fxmlLoader.load());
        // creates the title for the window
        stage.setTitle("WRCC");
        // sets the scene to the stage
        stage.setScene(scene);
        // displays the stage
        stage.show();
    }

    public static void main(String[] args) {
        // here the application is launched
        launch();
    }
}