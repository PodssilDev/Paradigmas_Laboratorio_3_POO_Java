package model;

public class Permiso {
    private String usuario;
    private String permiso;

    public Permiso(String usuario, String permiso) {
        this.usuario = usuario;
        this.permiso = permiso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
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
