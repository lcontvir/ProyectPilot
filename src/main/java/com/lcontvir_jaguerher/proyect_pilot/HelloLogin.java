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

        Scene escena = new Scene(fxmlLoader.load(), 400, 430);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(430);


        primaryStage.setTitle("Inicio de Sesion");
        primaryStage.setScene(escena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void switchScene(String fxmlFile, int minwidth, int minheigh, String titulo) throws IOException {

        FXMLLoader loader = new FXMLLoader(HelloLogin.class.getResource(fxmlFile));
        Scene escena = new Scene(loader.load());

        double widthAnterior = stage.getWidth();
        double heighAnterior = stage.getHeight();

        if(heighAnterior < minheigh){
            heighAnterior = minheigh;
        }
        if(widthAnterior < minwidth){
            widthAnterior = minwidth;
        }

        boolean Fs = stage.isFullScreen();

        stage.setScene(escena);
        stage.sizeToScene();

        stage.setHeight(heighAnterior);
        stage.setWidth(widthAnterior);
        stage.setMinWidth(minwidth);
        stage.setMinHeight(minheigh);
        stage.setFullScreen(Fs);
        stage.setTitle(titulo);

    }
}
