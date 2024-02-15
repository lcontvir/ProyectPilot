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

        // Validación básica
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || dob == null) {
            errorText.setText("Por favor, complete todos los campos.");
        }else if (!email.matches("^(.+)@(.+)$")) {
            errorText.setText("Ingrese un email válido.");
        }else if (username.length() < 3 || !username.matches("[a-zA-Z]+")) {
            errorText.setText("Nombre de usuario debe tener al menos 3 caracteres no numéricos.");
        } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
            errorText.setText("La contraseña debe contener al menos un número, una mayúscula, una minúscula y un símbolo, y tener al menos 8 caracteres.");
        } else if (!password.equals(confirmPassword)) {
            errorText.setText("Las contraseñas no coinciden.");
        } else if (dob.getYear() < 1900) {
            errorText.setText("La fecha de nacimiento no puede ser anterior a 1900.");
        } else {
            String respuesta = "";
            for (Usuario user : Usuario.ListaUsuarios) {
                if (user.getEmail().equals(email)) {
                    respuesta = "Ese email ya está registrado.";
                } else if (user.getUsername().equals(username)) {
                    respuesta = "Ese nombre de usuario ya está registrado.";
                }
            }
            if (respuesta.isEmpty()) {
                errorText.setText("Usuario registrado exitosamente.");
                Usuario usuario = Usuario.getInstancia();
                usuario.setEmail(email);
                usuario.setPassword(password);
                usuario.setUsername(username);
                usuario.setFechaNacimiento(dob);
                usuario.setClearance(0);
                Usuario.ListaUsuarios.add(Usuario.getInstancia());
            }
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
        HelloLogin.switchScene("login-view.fxml", 400, 430, "Inicio de Sesion");
    }

}