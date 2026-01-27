package e1;

import java.util.HashMap;

public class Agenda {
    private HashMap<String, String> contactos;
    public Agenda() {
        contactos = new HashMap<>();
    }
    public void agregarContacto(String nombre, String telefono) {
        contactos.put(nombre, telefono);
    }
    public String buscarContacto(String nombre){
        return contactos.getOrDefault(nombre, "No se encontró el contacto");
    }
    public boolean eliminarContacto(String nombre){
        return contactos.remove(nombre) != null;
    }
    public void listarContactos(){
         contactos.forEach((nombre, telefono)-> System.out.println(nombre + " - " + telefono));
    }
    public int contarContactos(){
        System.out.println("El numero de contactos es: " + contactos.size());
        return contactos.size();
    }
    public boolean existeContacto(String nombre){
        if(contactos.containsKey(nombre)){
            System.out.println("El contacto existe");
            return true;
        }else {
            System.out.println("El contacto no existe");
            return false;
        }
    }

    public HashMap<String, String> getContactos() {
        return contactos;
    }

    public void setContactos(HashMap<String, String> contactos) {
        this.contactos = contactos;
    }
}
