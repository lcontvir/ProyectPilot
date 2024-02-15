package com.lcontvir_jaguerher.proyect_pilot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloLogin extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloLogin.class.getResource("noticias-view.fxml"));


        Scene scene = new Scene(fxmlLoader.load(),500,800);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(800);


        primaryStage.setTitle("Inicio de Sesión");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
