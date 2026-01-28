package e2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Alumno {
    private String dni, nombre, apellido;
    private double nota;
    private static HashMap<String, Alumno> alumnos = new HashMap<>();

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
        for (int i = 0; i < limite && i < volcado.size(); i++) {
            System.out.printf("%dº - %s, %.2f%n", i+1, volcado.get(i).getNombre(),volcado.get(i).getNota());
        }
    }
    public void expedientesSuperior(double notaCorte){
        if (alumnos.isEmpty()){
            System.out.println("No hay alumnos en la lista");
        }
        for (Alumno alumno : alumnos.values()){
            if (alumno.getNota() >= notaCorte){
                System.out.println(alumno.getNota());
            }
        }
    }
    public void vaciarLista(){
        alumnos.clear();
        System.out.println("Lista borrada");
    }
    public void mostrarLista(){
        System.out.println("--- LISTA DE ALUMNOS ---");
        for (Alumno alumno : alumnos.values()) {
            System.out.println(alumno.toString());
        }
    }

    @Override
    public String toString() {
        return "Alumno [" +
                "Nota: " + nota +
                ", Apellido='" + apellido + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", DNI:'" + dni + '\'' +
                ']';
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
