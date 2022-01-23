package model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @return Integer
     */
    public static Integer getIdGlobal() {
        return idGlobal;
    }

    
    /** 
     * @param idGlobal
     */
    public static void setIdGlobal(Integer idGlobal) {
        Usuario.idGlobal = idGlobal;
    }

    
    /** 
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    
    /** 
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getUsername() {
        return username;
    }

    
    /** 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /** 
     * @return String
     */
    public String getPassword() {
        return password;
    }

    
    /** 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /** 
     * @return String
     */
    public String getFecha() {
        return fecha;
    }

    
    /** 
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    
    /** 
     * @return String
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
