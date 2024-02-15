package com.lcontvir_jaguerher.proyect_pilot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class Noticias {
    @FXML
    private Button editarButton;

    // Este método se llamará cuando se haga clic en el botón "Editar"
    @FXML
    private void handleEditarButtonClick(ActionEvent event) {
        // Cargar la vista del editor desde el archivo FXML
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editor-view.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista del editor
                EditorNoticias editorController = loader.getController();

            // Crear una nueva escena
            Scene scene = new Scene(root);

            // Configurar la escena
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Editor de Noticias");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
