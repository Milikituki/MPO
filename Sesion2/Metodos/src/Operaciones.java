public class Operaciones {

    public void sumar(int num1, int num2){
        int resultado = num1+num2;
        System.out.println("El resultado de la suma es: "+resultado);
    }

    public void sumar(double num1, double num2){
        double resultado = num1+num2;
        System.out.println("El resultado de la suma es: "+resultado);
    }
    public void sumar (double num1, int num2){
        int resultado = (int)num1+num2;
    }

    public void restar(int num1, int num2){
        int resultado = num1+num2;
        System.out.println("El resultado de la resta es: "+resultado);
    }
    public int multiplicar(int num1, int num2){
        return num1*num2;
    }
    public boolean validarNumero(int numero){
        return numero>10;
    }
}
