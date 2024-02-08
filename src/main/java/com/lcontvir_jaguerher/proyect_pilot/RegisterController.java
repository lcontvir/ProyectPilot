package com.lcontvir_jaguerher.proyect_pilot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;

public class RegisterController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private Text errorText;

    // Método para el botón de registro
    @FXML
    private void Registrarme() {
        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        LocalDate dob = dobDatePicker.getValue();

        // Validación básica (puedes agregar más validaciones según tus requisitos)
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || dob == null) {
            errorText.setText("Por favor, complete todos los campos.");
        } else if (!password.equals(confirmPassword)) {
            errorText.setText("Las contraseñas no coinciden.");
        } else {
            // Realizar la lógica de registro aquí
            // Por ejemplo, puedes llamar a un método en tu servicio de registro
            // o mostrar un mensaje de éxito
            errorText.setText("Usuario registrado exitosamente.");
        }
    }

    // Método para el botón de volver al inicio de sesión
    @FXML
    private void BotonLogin() {
        try{
            VolverInicio();
        }catch (Exception e){
            System.out.println("No se puede ir al inicio");
        }
    }

    public void VolverInicio() throws IOException {
        HelloLogin.switchScene("login-view.fxml", 400, 300);
    }

}