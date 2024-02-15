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
import java.util.Objects;

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

        Usuario.setInstancia(verificarCredenciales(usuario, password));

        if(Usuario.getInstancia().getUsername() != null){
            goToNoticias();
        }
        else{
            errorText.setText("Credenciales incorrectas. Inténtelo de nuevo.");
        }
    }

    private Usuario verificarCredenciales(String usuario, String pass) {
        Usuario usuarioEncontrado = null;
        for (Usuario user:
             Usuario.ListaUsuarios) {
            if(Objects.equals(user.getUsername(), usuario)){
                if(Objects.equals(user.getPassword(), pass)){
                    usuarioEncontrado = user;
                }
            }
        }
        return usuarioEncontrado;
    }

    public void goToRegister() throws IOException {
        HelloLogin.switchScene("register-view.fxml", 400, 800, "Registro");
    }
    public void goToNoticias() throws IOException {
        HelloLogin.switchScene("noticias-view.fxml", 800, 500, "Noticias");
    }
}