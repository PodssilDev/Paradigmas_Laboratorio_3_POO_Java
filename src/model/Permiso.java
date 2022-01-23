package model;

public class Permiso {
    private String usuario;
    private String permiso;

    public Permiso(String usuario, String permiso) {
        this.usuario = usuario;
        this.permiso = permiso;
    }

    
    /** 
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }

    
    /** 
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    /** 
     * @return String
     */
    public String getPermiso() {
        return permiso;
    }

    
    /** 
     * @param permiso
     */
    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Permiso{" +
                "usuario=" + usuario +
                ", permiso='" + permiso + '\'' +
                '}';
    }
}
