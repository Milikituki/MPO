import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese cantidad de bebidas: ");
        int bebidas = s.nextInt();
        System.out.println("Ingrese cantidad de bocadillos: ");
        int bocadillos = s.nextInt();
        System.out.println("Ingrese el precio de la bebida: ");
        double precioBebida = s.nextDouble();
        System.out.println("Ingrese el precio del bocadillo: ");
        double precioBocadillo = s.nextDouble();
        System.out.println("Ingrese el número de alumnos: ");
        int numeroAlumnos = s.nextInt();
        double total = total(precioBebida, precioBocadillo, bebidas, bocadillos);
        double totPrecioBebida = precioBebida*bebidas;
        double totPrecioBocata = precioBocadillo*bocadillos;
        double cadaAlumno = total/numeroAlumnos;
        System.out.printf("""
                Total: %.2f€
                    Bocadillos: %.2f€
                    Bebidas: %.2f€
                Cada alumno debe pagar: %.2f€
                """, total, totPrecioBocata, totPrecioBebida, cadaAlumno);


    }
    public static double total(double pBebida, double pBocata, int bebida, int bocata){
        double total = (bebida*pBebida)+(bocata*pBocata);
        return total;
    }
}
