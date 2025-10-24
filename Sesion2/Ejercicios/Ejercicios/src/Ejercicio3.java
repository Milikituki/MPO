import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Decenas de mil: ");
        String decenaMil = s.next();
        System.out.println("Unidades de mil: ");
        String unidadesMil = s.next();
        System.out.println("Centenas: ");
        String centenas = s.next();
        System.out.println("Decenas: ");
        String decenas = s.next();
        System.out.println("Unidades: ");
        String unidades = s.next();

        String num = decenaMil+unidadesMil+centenas+decenas+unidades;
        System.out.println(num);

//        int num = decenaMil*10000 + unidadesMil*1000 + centenas*100 + decenas*10 + unidades;
//        System.out.println("Numero introducido: "+num);



    }


}
