package model;

/**
 * Clase que simula un Permiso, el cual contiene dos strings
 * @version 11.0.13.8
 * @autor: John Serrano Carrasco
 */
public class Permiso {
    private String usuario;
    private String permiso;

    public Permiso(String usuario, String permiso) {
        this.usuario = usuario;
        this.permiso = permiso;
    }

    /**
     * Obtiene el username (String) del usuario al que le corresponde el permiso
     * @return String Si se obtiene el username al que le corresponde el permiso
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Modifica el username (String) del usuario al que le corresponde el permiso
     * @param usuario (Stirng). Un username de un usuario al que se le asigna un permiso
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el permiso (String) correspondiente
     * @return String Si se obtiene el permiso
     */
    public String getPermiso() {
        return permiso;
    }

    /**
     * Modifica el permiso (String) correspondiente
     * @param permiso (String). Corresponde a un grado de acceso al que se le da a un Usuario
     */
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    /**
     * Transforma todo un permiso a String
     * @return String Si transforma todo el contenido de un Permiso a String.
     */
    @Override
    public String toString() {
        return "Permiso{" +
                "usuario=" + usuario +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
