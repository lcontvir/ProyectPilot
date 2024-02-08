package com.lcontvir_jaguerher.proyect_pilot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloLogin extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloLogin.class.getResource("login-view.fxml"));

        Scene escena = new Scene(fxmlLoader.load(), 400, 300);

        primaryStage.setMinHeight(330);
        primaryStage.setMinWidth(400);

        primaryStage.setTitle("Inicio de Sesión");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void switchScene(String fxmlFile) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloLogin.class.getResource(fxmlFile));
        Scene escena = new Scene(loader.load(), 400, 300);
        stage.setScene(escena);
    }

    public static void switchScene(String fxmlFile, int minwidth, int minheigh) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloLogin.class.getResource(fxmlFile));
        Scene escena = new Scene(loader.load());
        stage.setScene(escena);
        stage.setMinHeight(minheigh);
        stage.setMinWidth(minwidth);
    }
}
