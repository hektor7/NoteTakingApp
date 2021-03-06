package com.hektor7.noteTakingApp;

import com.hektor7.noteTakingApp.ui.FXMLPage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(FXMLPage.LIST.getPageUrl());

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Note Taking :)");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
