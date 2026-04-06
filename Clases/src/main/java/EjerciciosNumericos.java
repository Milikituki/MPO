public class EjerciciosNumericos {
    public int numerosFibonacci(int posicion){
        // calcular el numero de la posicion n de fobonacci
        // 0,1
        if(posicion==0) return 0;
        if(posicion==1) return 1;
        return numerosFibonacci(posicion-1)+numerosFibonacci(posicion-2);
        // return numerosFibonacci(6)+numerosFibonacci(5);
    }
    public void movimientoHanoi(int discos, char torreOrigen, char torreDestino, char torreAuxiliar){
        if(discos==1){
            System.out.println("Movimiento del disco 1 desde "+torreOrigen+" hasta "+torreDestino);
            return;
        }
        movimientoHanoi(discos-1, torreOrigen, torreAuxiliar, torreDestino);
        System.out.println("movimiento del disco "+discos+" desde "+torreOrigen+" hasta "+torreDestino);

        movimientoHanoi(discos-1, torreAuxiliar, torreDestino, torreOrigen);

    }


}
