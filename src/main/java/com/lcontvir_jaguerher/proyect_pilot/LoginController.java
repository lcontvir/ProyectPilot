package com.lcontvir_jaguerher.proyect_pilot;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text errorText;

    public void loginButtonAction() {
        String usuario = userTextField.getText();
        String password = passwordField.getText();

        if (verificarCredenciales(usuario, password)) {
            cambiarAEscenaSiguiente();
        } else {
            errorText.setText("Credenciales incorrectas. Inténtelo de nuevo.");
        }
    }

    private boolean verificarCredenciales(String usuario, String pass) {
        //todo
        return usuario.equals("admin") && pass.equals("admin");
    }

    private void cambiarAEscenaSiguiente() {
        //todo
    }
}