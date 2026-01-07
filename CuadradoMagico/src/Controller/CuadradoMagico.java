package Controller;

import java.util.Scanner;

public class CuadradoMagico {

    private int[][] cuadrado;
    private int n;

    public void valorMatriz(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿De cuánto quieres que sea el cuadrado? ");
        n = scanner.nextInt();
        cuadrado = new int[n][n];
    }
    public void empezarJuego(){
        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[i].length; j++) {
                int aleatorio;
                do{
                    aleatorio = (int) (Math.random()*n*n)+1;
                }while(estaNumero(aleatorio));
                cuadrado[i][j] = aleatorio;
            }
        }
        for (int[] fila : cuadrado) {
            for (int item : fila) {
                System.out.print(item+"\t");
            }
            System.out.println();
        }


    }
    private boolean estaNumero(int num){
        for (int[] fila : cuadrado) {
            for (int item : fila) {
                if (item == num){
                    return true;
                }
            }
        }
        return false;
    }


}
