package com.lcontvir_jaguerher.proyect_pilot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloLogin extends Application {

    public static Stage stage; // ventana principal

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage; // Asignar la ventana principal
        FXMLLoader fxmlLoader = new FXMLLoader(HelloLogin.class.getResource("login-view.fxml"));

        // Crea una nueva escena con el contenido cargado desde el archivo FXML
        Scene scene = new Scene(fxmlLoader.load(), 400, 430);
        primaryStage.setMinWidth(400); // Establece el ancho mínimo
        primaryStage.setMinHeight(430); // Establece el alto mínimo

        primaryStage.setTitle("Inicio de Sesion"); // Establece el título
        primaryStage.setScene(scene); // Establece la escena en la ventana principal
        primaryStage.show(); // Muestra la ventana principal
    }

    // Método principal de lanzamiento de la aplicación
    public static void main(String[] args) {
        launch(args);
    }

    // Método para cambiar entre escenas
    public static void switchScene(String fxmlFile, int minWidth, int minHeight, String title) throws IOException {

        // Carga la nueva escena desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(HelloLogin.class.getResource(fxmlFile));
        Scene scene = new Scene(loader.load());

        double previousWidth = stage.getWidth(); // Ancho anterior
        double previousHeight = stage.getHeight(); // Alto anterior

        // Ajusta las dimensiones mínimas si la ventana anterior era más pequeña
        if (previousHeight < minHeight) {
            previousHeight = minHeight;
        }
        if (previousWidth < minWidth) {
            previousWidth = minWidth;
        }

        boolean isFullScreen = stage.isFullScreen(); // Verifica si estaba en pantalla completa

        stage.setScene(scene); // Establece la nueva escena en la ventana
        stage.sizeToScene(); // Ajusta el tamaño de la ventana según el contenido

        // Restaura las dimensiones y el estado de pantalla completa de la ventana
        stage.setHeight(previousHeight);
        stage.setWidth(previousWidth);
        stage.setMinWidth(minWidth);
        stage.setMinHeight(minHeight);
        stage.setFullScreen(isFullScreen);
        stage.setTitle(title); // Establece el título de la ventana
    }
}
