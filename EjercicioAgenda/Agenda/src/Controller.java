import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Object[]> agenda = new ArrayList<>();
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
                case 2 -> buscarPersona(agenda);
                case 3 -> borrarPredicado(agenda);
                case 4 -> listarPersonas(agenda);
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.print("Opción inválida. ");
            }
        }while(opcion != 5);
    }
    private void agregarPersona(ArrayList<Object[]> listaContactos){
        System.out.print("Nombre: ");
        String nombreContacto = scanner.next();
        System.out.print("Apellido: ");
        String apellidoContacto = scanner.next();
        System.out.print("Teléfono: ");
        int telefonoContacto = scanner.nextInt();
        System.out.print("DNI: ");
        String dniContacto = scanner.next();
        listaContactos.add(new Object[]{nombreContacto, apellidoContacto, telefonoContacto, dniContacto.toUpperCase()});
    }
    private void buscarPersona(ArrayList<Object[]> listaContactos){
        System.out.print("Introduce el DNI a buscar: ");
        String dniBuscar = scanner.next();
        for (int i = 0; i < listaContactos.size(); i++) {
            Object[] contacto = listaContactos.get(i);
            for (int j = 0; j < contacto.length; j++) {
                if (contacto[3].equals(dniBuscar.toUpperCase())){
                    System.out.printf("""
                            🧑🏼‍🦰: %s %s
                            ☎️: %d
                            💳: %s
                            
                            """, contacto[0], contacto[1], (int)contacto[2], contacto[3]);
                    break;
                } else{
                    System.out.println("No se han encontrado coincidencias.");
                    break;
                }
            }
        }

    }
    private void borrarPersona(ArrayList<Object[]> listaContactos){
        System.out.print("Indica el DNI a borrar: ");
        String dniBorrar = scanner.next();

        for (int i = 0; i < listaContactos.size(); i++) {
            Object[] contacto = listaContactos.get(i);
            if (contacto[3].equals(dniBorrar.toUpperCase())){
                listaContactos.remove(i);
                System.out.println("Contacto borrado correctamente.");
                break;
            } else{
                System.out.println("No se ha podido borrar el contacto, inténtelo de nuevo.");
                break;
            }

        }
    }
    private void listarPersonas(ArrayList<Object[]> listaContactos){
        for (Object[] contacto : listaContactos) {
            for (Object item : contacto) {
                System.out.printf("""
                        🧑🏼‍🦰: %s %s
                        ☎️: %d
                        💳: %s
                        
                        """, contacto[0], contacto[1], (int)contacto[2], contacto[3]);
                break;
            }
        }
    }
    private void borrarPredicado(ArrayList<Object[]> listaContactos){
        System.out.print("Introduce el DNI del contacto que deseas borrar: ");
        String dniBorrar = scanner.next();
            boolean borrado = listaContactos.removeIf(contacto -> contacto[3].equals(dniBorrar.toUpperCase()));
            if (borrado){
                System.out.println("Contacto borrado correctamente.");
            }else {
                System.out.println("No se pudo borrar el contacto.");
            }


    }
}
