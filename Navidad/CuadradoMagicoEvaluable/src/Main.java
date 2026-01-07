import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el tamaño de la matriz: ");
        int n = scanner.nextInt();
        int[][] cuadrado = new int[n][n];

        boolean esValido = false;
        long intentos = 0;



        while(!esValido){
            generarCuadrado(cuadrado);
            intentos++;
            esValido = comprobarValidez(cuadrado);
        }

        System.out.println("--- CUADRADO MAGICO ENCONTRADO ---");
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado.length; j++) {
                System.out.print(cuadrado[i][j] +"\t");
            }
            System.out.println();
        }
        System.out.printf("""
                Constante mágica: %d
                Intentos realizados: %d
                """, sumaFila(cuadrado, 0), intentos);


    }
    public static void generarCuadrado(int[][] matriz){
        boolean[] repetido = new boolean[matriz.length * matriz.length+1];
        int numero;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                do {
                    numero = (int) (Math.random()*(matriz.length* matriz.length))+1;

                }while(repetido[numero]);
                matriz[i][j] = numero;
                repetido[numero] = true;
            }
        }
    }
    public static int sumaFila(int[][] matriz, int fila){
        int suma =0;
        for (int i = 0; i < matriz.length; i++) {
            suma+=matriz[fila][i];
        }
        return suma;
    }
    public static int sumaColumna(int[][] matriz, int columna){
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma+=matriz[i][columna];
        }
        return suma;
    }
    public static int sumaDiagonal1(int[][] matriz){
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma+=matriz[i][i];
        }
        return suma;
    }
    public static int sumaDiagonal2(int[][] matriz){
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma+=matriz[i][matriz.length-1-i];
        }
        return suma;
    }
    public static boolean comprobarValidez(int[][]matriz){
        int suma = sumaFila(matriz, 0);

        for (int i = 0; i < matriz.length; i++) {
            if (sumaFila(matriz, i) != suma){
                return false;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            if (sumaColumna(matriz, i) != suma){
                return false;
            }
        }
        if (sumaDiagonal1(matriz) != suma){
            return false;
        }
        if (sumaDiagonal2(matriz) != suma){
            return false;
        }

        return true;
    }
}
