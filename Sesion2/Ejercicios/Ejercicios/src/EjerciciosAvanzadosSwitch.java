import EnumsEjercicios.Monedas;

import java.util.Scanner;

public class EjerciciosAvanzadosSwitch {
    Scanner scanner = new Scanner(System.in);
    public void e1(){
        //Crea un programa que convierta una calificación numérica en su equivalente alfabético usando un switch
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la calificación:");
        double calificacion = scanner.nextDouble();
        char letra = ' ';
        int rango = 0;
        if (calificacion >= 0 && calificacion <= 3.99){
            rango = 0;
        } else if (calificacion >= 4.00 && calificacion <= 4.99){
            rango = 1;
        } else if (calificacion >= 5.00 && calificacion <= 6.99){
            rango = 2;
        } else if (calificacion >= 7.00 && calificacion <= 8.99){
            rango = 3;
        } else if (calificacion >= 9.00 && calificacion <= 10.00){
            rango = 4;
        } else{
            System.out.println("Calificación incorrecta");
        }
        switch (rango){
            case 0 -> letra = 'F';
            case 1 -> letra = 'D';
            case 2 -> letra = 'C';
            case 3 -> letra = 'B';
            case 4 -> letra = 'A';
            default -> {
                System.out.println("Calificación por letra incorrecta.");
            }
        }
        System.out.printf("Nota: %.2f - Calificación: %c", calificacion, letra);

    }
    public void e2(){
        Monedas monedas;
        System.out.printf("Indica la cantidad en euros: ");
        double euros = scanner.nextDouble();
        double cantidad = 0;
        System.out.printf("¿A qué moneda quieres hacer la conversion? (dolar, libra, ye, peso): ");
        String conversion = scanner.next();
        monedas = Monedas.valueOf(conversion);

        switch (monedas){
            case dolar -> {
                cantidad = euros*1.16;
                System.out.printf("%.2f EUROS son %.2f DOLARES", euros, cantidad);
            }
            case libra -> {
                cantidad = euros*0.88;
                System.out.printf("%.2f EUROS son %.2f LIBRAS", euros, cantidad);

            }
            case yen -> {
                cantidad = euros*175;
                System.out.printf("%.2f EUROS son %.2f YENES", euros, cantidad);

            }
            case peso -> {
                cantidad = euros*21.21;
                System.out.printf("%.2f EUROS son %.2f PESOS", euros, cantidad);

            }
        }

    }

}
