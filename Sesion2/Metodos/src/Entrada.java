public class Entrada {
    public static void main(String[] args) {
        System.out.println("Ejecución de metodos");
        System.out.println("Hola Borja");
        saludar("Borja");
        despedir();
        Operaciones nuevaVariable = new Operaciones(); //new para hacer objetos complejos
        nuevaVariable.sumar(5,6);
        nuevaVariable.restar(9,6);

        System.out.println("¿El número es válido? "+nuevaVariable.validarNumero(12));
    }

    public static void saludar(String nombre){
        System.out.println("Hola "+nombre);
        System.out.println("Este método se va a repetir en el saludo");
    }

    public static void despedir(){
        System.out.println("Hasta luego");
        System.out.println("Ya hemos acabado");
    }


}
