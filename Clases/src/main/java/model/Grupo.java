package model;

import java.util.HashSet;
import java.util.Set;

public class Grupo {
    private String nombre;
    private Set<Usuario> usuarios;
    private Set<Grupo> subgrupos;

    public Grupo() {
        usuarios = new HashSet<>();
        subgrupos = new HashSet<>();
    }

    public Grupo(String nombre) {
        usuarios = new HashSet<Usuario>();
        subgrupos = new HashSet<Grupo>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Grupo> getSubgrupos() {
        return subgrupos;
    }

    public void setSubgrupos(Set<Grupo> subgrupos) {
        this.subgrupos = subgrupos;
    }

    public void anadirUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public void anadirSubgrupo(Grupo grupo){
        subgrupos.add(grupo);
    }
}
