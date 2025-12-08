import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Object> agenda = new ArrayList<>();
    public void mostrarMenu(){
        int opcion;
        do {
            System.out.printf("""
                ------- MENU AGENDA -------
                    1. Agregar persona
                    2. Buscar persona
                    3. Borrar persona
                    4. Listar personas
                    5. Salir
                
                """);
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1 -> agregarPersona(agenda);
                case 2 -> buscarPersona();
                case 3 -> borrarPersona();
                case 4 -> listarPersonas();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.print("Opción inválida. ");
            }
        }while(opcion != 5);
    }
    private void agregarPersona(ArrayList<Object> listaContactos){
        System.out.print("Nombre: ");
        String nombreContacto = scanner.next();
        System.out.print("Apellido: ");
        String apellidoContacto = scanner.next();
        System.out.print("Teléfono: ");
        int telefonoContacto = scanner.nextInt();
        System.out.print("DNI: ");
        String dniContacto = scanner.next();
        listaContactos.add(new Object[]{nombreContacto, apellidoContacto, telefonoContacto, dniContacto});
    }
    private void buscarPersona(){

    }
    private void borrarPersona(){

    }
    private void listarPersonas(){

    }
}
