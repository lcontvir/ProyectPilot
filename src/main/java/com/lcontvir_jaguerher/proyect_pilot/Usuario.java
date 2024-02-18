package com.lcontvir_jaguerher.proyect_pilot;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {

    // Instancia única del usuario principal
    private static Usuario UsuarioPrincipal;

    // Lista que almacena todos los usuarios registrados
    public static ArrayList<Usuario> ListaUsuarios = new ArrayList<>();

    // Atributos de un usuario
    private String username;
    private String email;
    private String password;
    private LocalDate fechaNacimiento;
    private int clearance;

    // Constructor privado para evitar la creación de instancias fuera de la clase
    private Usuario() {
    }

    // Método estático para obtener la única instancia del singleton
    public static Usuario getInstancia() {
        if (UsuarioPrincipal == null) {
            UsuarioPrincipal = new Usuario();
        }
        return UsuarioPrincipal;
    }

    // Setter para actualizar la instancia del usuario
    public static void setInstancia(Usuario user) {
        UsuarioPrincipal = user;
    }

    // Getters y setters para cada atributo del usuario

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getClearance() {
        return clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }
}
