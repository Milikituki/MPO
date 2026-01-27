package e1;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;
        do {
            System.out.printf("""
                    --- AGENDA ---
                    1. Agregar contacto
                    2. Buscar contacto
                    3. Eliminar contacto
                    4. Listar contactos
                    5. Verificar contacto
                    6. Contactos totales
                    7. Salir%n""");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Nombre: ");
                    String nombre = scanner.next();
                    System.out.println("Teléfono: ");
                    String telefono = scanner.next();
                    if (nombre.isEmpty() || telefono.isEmpty()) {
                        System.out.println("Nombre o teléfono inválidos");
                    } else {
                        agenda.agregarContacto(nombre, telefono);
                        System.out.println("Contacto agregado correctamente");
                    }
                }
                case 2 -> {
                    System.out.println("Indique el nombre del contacto que desea buscar: ");
                    String nombre = scanner.next();
                    agenda.buscarContacto(nombre);
                }
                case 3 -> {
                    System.out.println("Indique el nombre del contacto que desea eliminar: ");
                    String nombre = scanner.next();
                    if (!agenda.existeContacto(nombre)) {
                        System.out.println("Introduzca un nombre válido");
                    } else {
                        agenda.eliminarContacto(nombre);
                        System.out.println("Contacto eliminado correctamente");
                    }
                }
                case 4 -> {
                    agenda.listarContactos();
                }
                case 5 -> {
                    System.out.println("Indique el nombre del contacto que desea verificar: ");
                    String nombre = scanner.next();
                    agenda.existeContacto(nombre);
                }
                case 6 -> agenda.contarContactos();
                case 7 -> System.out.println("Saliendo de la agenda...");
                default -> System.out.println("Opción no válida. Seleccione otra opción");
            }
        } while (opcion != 7);

    }
}
