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
        for (int i = 0; i <= 3; i++) {
            System.out.println("Usuario: ");
            usuario = scanner.next();
            System.out.println("Contraseña: ");
            password = scanner.next();
            if (usuario.equals(usuarioCorrecto) && password.equals(passwordCorrecto)){
                break;
            }
            return true;
        }
        return false;
    }
}
