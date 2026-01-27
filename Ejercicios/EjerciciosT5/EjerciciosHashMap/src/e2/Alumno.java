package e2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Alumno {
    private String dni, nombre, apellido;
    private double nota;
    private HashMap<String, Alumno> alumnos;

    public Alumno(){}
    public Alumno(String dni, String nombre, String apellido, double nota) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public void agregarAlumno(Alumno alumno){
        alumnos.put(alumno.getDni(), alumno);
    }
    public void buscarAlumno(String dni){
        if (alumnos.containsKey(dni)){
            System.out.println("Nota del alumno: " + alumnos.get(dni).getNota());
        }else{
            System.out.println("Alumno no encontrado");
        }
    }
    public void verMejoresExpedientes(int limite){
        ArrayList<Alumno> volcado = new ArrayList<>(alumnos.values());
        volcado.sort(Comparator.comparingDouble(Alumno::getNota));
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    public HashMap<String, Alumno> getContactos() {
        return alumnos;
    }

    public void setContactos(HashMap<String, Alumno> contactos) {
        this.alumnos = contactos;
    }
}
