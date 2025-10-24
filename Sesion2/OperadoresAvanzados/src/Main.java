import controller.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando la clase");

        GestorUsuarios gU = new GestorUsuarios();
        GestorDocumentos gD = new GestorDocumentos();
        gU.validarUsuario("Borja", 31, "borja@gmail.com");



    }
}
