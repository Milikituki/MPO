package model;

import controller.ControllerGrupos;

public class MainGrupos {
    static void main(String[] args) {
        Usuario usuario1 =  new Usuario("u1", 1);
        Usuario usuario2 =  new Usuario("u2", 2);
        Usuario usuario3 =  new Usuario("u3", 3);
        Usuario usuario4 =  new Usuario("u4", 4);
        Usuario usuario5 =  new Usuario("u5", 5);

        Grupo fp = new Grupo("fp");
        Grupo fp2 = new Grupo("fp2");
        Grupo fp3 = new Grupo("fp3");

        fp2.anadirUsuario(usuario1);
        fp.anadirUsuario(usuario2);
        fp2.anadirUsuario(usuario3);
        fp3.anadirUsuario(usuario4);
        fp3.anadirUsuario(usuario5);
        fp2.anadirSubgrupo(fp3);

        ControllerGrupos controller = new ControllerGrupos();
        if (controller.perteneceA(fp, usuario1)) {
            System.out.println("Encontrado usuario 1");
        } else {
            System.out.println("No encontrado usuario 1");
        }
    }


}
