import java.util.Scanner;

public class EjerciciosNotion {
    Scanner scanner = new Scanner(System.in);
    public void e1(){
        String contrasenia;
        do {
            System.out.print("Indica la contraseña: ");
            contrasenia = scanner.next();
        }while(!validarContrasenia(contrasenia));
        System.out.println("Contraseña creada correctamente.");


    }
    private boolean validarContrasenia(String password){
        if (password.length() < 8){
            System.out.println("Contraseña inválida: La contraseña debe contener al menos 8 carácteres");
            return false;
        }
        if (!contieneMayuscula(password)){
            System.out.println("Contraseña inválida: La contraseña debe contener al menos una mayúscula");
            return false;
        }
        if (!contieneNumero(password)){
            System.out.println("Contraseña inválida: La contraseña debe contener al menos un dígito");
            return false;
        }
        return true;

    }
    private boolean contieneMayuscula(String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    private boolean contieneNumero(String password){
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public void e2(){
        int[] array = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(buscarNumero(array, 88));

    }
    private int buscarNumero(int[] numeros, int objetivo){
        int indice = -1;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo){
                indice = i;
                break;
            }
        }
        return indice;
    }
    public void e3(){
        int[] array = {1,2,3,4,5,6,7,8,9,0};
        mostrarPares(array);

    }
    private void mostrarPares(int[] numeros){
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] %2 != 0){
                continue;
            }
            if (numeros[i] %2 == 0){
                System.out.printf("El número %d es par%n", numeros[i]);
            }
        }
    }
    public void e4(){
        double[] array = {1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,-0.5};
        System.out.println("La nota promedio de las notas es: " +calcularPromedio(array));
    }
    private double calcularPromedio(double[] notas){
        double sumaNotas = 0;
        int notasValidas = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 0 || notas[i] > 10){
                continue;
            }
            notasValidas++;
            sumaNotas += notas[i];
        }
        if (notasValidas == 0){
            return 0.0;
        }
        return sumaNotas/notasValidas;
    }
    public void e5(){
        intentarLogin("Milikituki", "Milikituki123");
    }
    private boolean intentarLogin(String usuarioCorrecto, String passwordCorrecto){
        String usuario, password;

        for (int i = 0; i < 4; i++) {
            System.out.print("Usuario: ");
            usuario = scanner.next();
            System.out.print("Contraseña: ");
            password = scanner.next();
            if (usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto)){
                System.out.println("Login correcto");
                return true;
            }
            System.out.println("Credenciales incorrectas, inténtelo de nuevo.");
        }
        return false;
    }
    public void e6(){
        String[] tareas = {"Fregar - Medio", "Limpiar baño - Urgente", "Futbol - Urgente", "Comprar huevos - Bajo"};
        System.out.println(procesarTareas(tareas));
    }
    private String procesarTareas(String[] tareas){

        for (int i = 0; i < tareas.length; i++) {
            if (tareas[i].toUpperCase().contains("URGENTE")){
                return tareas[i];
            }
        }
        return "No hay tareas urgentes";
    }
    public void e7(){
        generarFibonacci(100000);
    }
    private void generarFibonacci(int limite){
        int inicio1 = 0;
        int inicio2 = 1;
        System.out.println(inicio1);
        System.out.println(inicio2);
        int siguienteNumero = 1;
        while (true){
            siguienteNumero = inicio1 + inicio2;
            System.out.println(siguienteNumero);
            inicio1 = inicio2;
            inicio2 = siguienteNumero;
            System.out.println(siguienteNumero);
            if (siguienteNumero > limite){
                break;
            }
        }

    }
    public void e8(){
        int[] array = {123,654,7980,43,12,65,98};
        System.out.println(contarEdadesValidas(array));
        System.out.println();
        mostrarEdadesValidas(array);
    }
    private int contarEdadesValidas(int[] edades){
        int contador = 0;
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] > 120 || edades[i] < 0){
                continue;
            }
            contador++;
        }
        return contador;
    }
    private void mostrarEdadesValidas(int[] edades){
        for (int i = 0; i < edades.length; i++) {
            if (edades[i] < 120 && edades[i] > 0){
                System.out.println(edades[i]);
            }
        }
    }
    public void e9(){
        String[] palabras = {"treu", "palabra", "caca"};
        System.out.println(contadorVocales("Aquesta pilota no, que treu caca"));
        System.out.println(contienePalabraProhibida("Aquesta pilota no, que treu caca",palabras));
        System.out.println(primeraPalabraLarga("Aquesta pilota no, que treu caca", 6));
    }
    private int contadorVocales(String texto){
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {

            if (!(Character.toLowerCase(texto.charAt(i)) == 'a') && !(Character.toLowerCase(texto.charAt(i)) == 'e') && !(Character.toLowerCase(texto.charAt(i)) == 'i') && !(Character.toLowerCase(texto.charAt(i)) == 'o') && !(Character.toLowerCase(texto.charAt(i)) == 'u')){
                continue;
            }
            contador++;
        }
        return contador;
    }
    private boolean contienePalabraProhibida(String texto, String[] palabrasProhibidas){
        for (int i = 0; i < palabrasProhibidas.length; i++) {
            if (texto.toLowerCase().contains(palabrasProhibidas[i])){
                return true;
            }
        }
        return false;
    }
    private String primeraPalabraLarga(String texto, int longitudMinima){
        String[] palabras = texto.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() >= longitudMinima){
                return palabras[i];
            }
        }
        return "No se ha encontrado ninguna palabra";
    }
}
