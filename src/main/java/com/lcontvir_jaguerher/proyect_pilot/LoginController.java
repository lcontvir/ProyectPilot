package com.lcontvir_jaguerher.proyect_pilot;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController{

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text errorText;

    public void loginButtonAction() throws IOException {
        String usuario = userTextField.getText();
        String password = passwordField.getText();

        if (verificarCredenciales(usuario, password)) {
            //Todo
        } else {
            errorText.setText("Credenciales incorrectas. Inténtelo de nuevo.");
        }
    }

    private boolean verificarCredenciales(String usuario, String pass) {
        //todo
        return usuario.equals("admin") && pass.equals("admin");
    }

    public void goToRegister() throws IOException {
        HelloLogin.switchScene("register-view.fxml", 400, 800);
    }
}