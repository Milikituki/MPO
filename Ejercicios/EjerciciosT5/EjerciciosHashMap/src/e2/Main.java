package e2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Alumno alumno = new Alumno();

        boolean salir = false;
        do {
            System.out.printf("""
                --- GESTOR NOTAS ---
                1. INTRODUCIR ALUMNO
                2. BUSCAR ALUMNO
                3. VER MEJORES EXPEDIENTES
                4. FILTRAR POR NOTA DE CORTE
                5. VACIAR LISTA
                6. MOSTRAR LISTA DE ALUMNOS
                7. SALIR
                Indique una opción:\s""");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el dni: ");
                    String dni = scanner.next();
                    System.out.print("Introduce el nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Introduce el apellido: ");
                    String apellido = scanner.next();
                    System.out.print("Introduce la nota: ");
                    double nota = scanner.nextDouble();
                    alumno =  new Alumno(dni, nombre, apellido, nota);
                    alumno.agregarAlumno(alumno);
                }
                case 2 -> {
                    System.out.print("Introduce el dni del alumno que quieres buscar: ");
                    String dni = scanner.next();
                    alumno.buscarAlumno(dni);
                }
                case 3 ->{
                    System.out.print("Introduce el límite de búsqueda: ");
                    int limite =  scanner.nextInt();
                    alumno.verMejoresExpedientes(limite);
                }
                case 4 -> {
                    System.out.print("Introduce la nota de corte: ");
                    double notaCorte = scanner.nextDouble();
                    alumno.expedientesSuperior(notaCorte);

                }
                case 5 -> alumno.vaciarLista();
                case 6 ->{
                    alumno.mostrarLista();
                }
                case 7 -> salir = true;
            }
        }while(!salir);



    }
}
