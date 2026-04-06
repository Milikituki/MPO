package org.example.login.controller;

import org.example.login.model.Admin;
import org.example.login.model.Trabajador;
import org.example.login.model.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorController {
    List<Usuario> usuarios;

    public GestorController() {
        this.usuarios = new ArrayList<>();
        Admin admin = new Admin();
        admin.setNombre("admin");
        admin.setApellido("admin");
        admin.setDni("admin");
        admin.setCorreo("admin@eroski.es");
        admin.setPass("admin");
        this.usuarios.add(admin);
    }
    public Usuario verificarLogin(String correo, String pass){
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getPass().equals(pass)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean altaTrabajador(String nombre, String apellido, String dni, String correo, String pass) {
        if (verDatos(dni) == null) {
            Trabajador trabajador = new Trabajador();
            trabajador.setNombre(nombre);
            trabajador.setApellido(apellido);
            trabajador.setDni(dni);
            trabajador.setCorreo(correo);
            trabajador.setPass(pass);
            this.usuarios.add(trabajador);
            return true;
        }
        return false;
    }

    public boolean bajaTrabajador(String dni){
        Usuario usuario = verDatos(dni);
        //Aprovechamos el método verDatos y damos por supuesto que si devuelve true (existe) lo almacenamos en la variable de tipo usuario. En el caso de que devolviera null significaría que el usuario no existe, asi que no podría eliminarlo, pero en caso contrario existiría y sí que lo podría eliminar.
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public List<Trabajador> verTrabajadores(){
        List<Trabajador> trabajadores = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Trabajador) {
                trabajadores.add((Trabajador) usuario);
            }
        }
        return trabajadores;
    }

    public Usuario verDatos(String dni){
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean cambiarPassword(String dni, String pass){
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                this.usuarios.get(usuarios.indexOf(usuario)).setPass(pass);
                return true;
            }
        }
        return false;
    }

    public String leerFichero(){
        String linea;
        String contenido = "";
        try (BufferedReader bf = new BufferedReader(new FileReader("horas.txt"))){
            while ((linea = bf.readLine()) != null) {
                contenido =  contenido + linea + "\n";
            }
            return contenido;
        } catch (IOException e) {
            System.out.println("Error al leer fichero");
        }
        return "";
    }
}
