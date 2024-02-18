package com.lcontvir_jaguerher.proyect_pilot;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField userTextField; // Campo de texto para el nombre de usuario

    @FXML
    private PasswordField passwordField; // Campo de texto para la contraseña

    @FXML
    private Text errorText; // Texto para mostrar mensajes de error

    // Método llamado cuando se presiona el botón de inicio de sesión
    public void loginButtonAction() throws IOException {
        String usuario = userTextField.getText(); // Obtener el nombre de usuario ingresado
        String password = passwordField.getText(); // Obtener la contraseña ingresada

        // Verificar las credenciales ingresadas
        Usuario.setInstancia(verificarCredenciales(usuario, password));

        // Si se encontró un usuario válido, navegar a la vista de noticias, de lo contrario, mostrar un mensaje de error
        if (Usuario.getInstancia().getUsername() != null) {
            goToNoticias();
        } else {
            errorText.setText("Credenciales incorrectas. Inténtelo de nuevo.");
        }
    }

    // Método para verificar las credenciales ingresadas
    private Usuario verificarCredenciales(String usuario, String pass) {
        Usuario usuarioEncontrado = null;
        // Iterar sobre la lista de usuarios para encontrar una coincidencia de nombre de usuario y contraseña
        for (Usuario user : Usuario.ListaUsuarios) {
            if (Objects.equals(user.getUsername(), usuario)) {
                if (Objects.equals(user.getPassword(), pass)) {
                    usuarioEncontrado = user;
                }
            }
        }
        return usuarioEncontrado; // Devolver el usuario encontrado (o null si no se encontró ninguna coincidencia)
    }

    // Método para navegar a la vista de registro
    public void goToRegister() throws IOException {
        HelloLogin.switchScene("register-view.fxml", 400, 800, "Registro");
    }

    // Método para navegar a la vista de noticias
    public void goToNoticias() throws IOException {
        HelloLogin.switchScene("noticias-view.fxml", 800, 500, "Noticias");
    }
}
