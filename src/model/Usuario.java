package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que simula un Usuario, el cual tiene un Integer, una Date y dos Strings
 * @version 11.0.13.8
 * @autor: John Serrano Carrasco
 */
public class Usuario{
    private static Integer idGlobal = 0;
    private Integer id;
    private String username;
    private String password;
    private String fecha;

    public Usuario(String username, String password) {
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
        this.username = username;
        this.password = password;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
    }

    /**
     * Obtiene el ID (Integer) unico de un Usuario
     * @return Integer Si se obtiene el ID unico de un Usuario
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifica el ID (Integer) unico de un Usuario
     * @param id (Integer). Corresponde al ID unico de un Usuario
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el Username (String) de un Usuario
     * @return String Si se obtiene el Username de un Usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Modifica el Username (String) de un Usuario
     * @param username (String). Corresponde al nombre de usuario de un Usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el password (String) de un Usuario
     * @return String Si se otbeien el password de un Usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Modifica el password (String) de un Usuario
     * @param password (String). Corresponde al password de un Usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la fecha de registro de un Usuario
     * @return String Si se obtiene la fecha de registro de un Usuario
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Modifica la fecha de un registro de un Usuario
     * @param fecha (String). Corresponde a la fecha de registro de un Usuario
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Transforma todo el contenido de un Usuario a String
     * @return String Si se convierte todo el contenido de un Usuario a String
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
