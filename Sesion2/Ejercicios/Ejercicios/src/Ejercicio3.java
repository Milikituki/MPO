import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el número de segundos que quieres convertir: ");
        int segundos = s.nextInt();
        //horas - segundos -> *3600
        //horas - minutos -> *60
        //minutos - segundos -> *60
        int minutos = (segundos%3600)/60;
        int horas = segundos/3600;
        int segundosRestantes = segundos%60;
        System.out.printf("""
                %d hora(s), %d minuto(s) y %d segundo(s)
                """, horas, minutos, segundosRestantes);
    }
}
