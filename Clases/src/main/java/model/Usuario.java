package model;

public class Usuario {
    private int id;
    private String nombre;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
