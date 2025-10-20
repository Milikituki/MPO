import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduzca el valor de la compra: ");
        double compraIVA = s.nextDouble();
        System.out.println("Introduzca el IVA (%): ");
        int iva = s.nextInt();
        double ivaAplicado = (double)iva/100;
        double compraSinIVA = compraIVA/(1+ivaAplicado);
        double ivaEuros = compraIVA-compraSinIVA;
        System.out.printf("""
                Base imponible: %.2f
                IVA(%d%%): %.2f
                
                Total: %.2f
                """, compraSinIVA, iva, ivaEuros, compraIVA);

    }
}
