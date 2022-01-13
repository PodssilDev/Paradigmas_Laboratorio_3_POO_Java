package com.paradigmas;

public class Permiso {
    private Usuario usuario;
    private String permiso;

    public Permiso(Usuario usuario, String permiso) {
        this.usuario = usuario;
        this.permiso = permiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "usuario=" + usuario +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
