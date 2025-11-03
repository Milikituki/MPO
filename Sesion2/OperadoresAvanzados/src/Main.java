import controller.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando la clase");

        GestorUsuarios gU = new GestorUsuarios();
        GestorDocumentos gD = new GestorDocumentos();
        gU.validarUsuario("Borja", 31, "borja@gmail.com");

        //------------------------------------------//

        String palabraCifrar = "Esta frase la quiero cifrar";
        for (int i = 0; i < palabraCifrar.length(); i++) {
            int codigo = (int)palabraCifrar.charAt(i);
            if (i%2==0){
                codigo*=2;
            }else {codigo*=3;}
            System.out.print(codigo+" ");

        }



    }
}
