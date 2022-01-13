package com.paradigmas;

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

    public static Integer getIdGlobal() {
        return idGlobal;
    }

    public static void setIdGlobal(Integer idGlobal) {
        Usuario.idGlobal = idGlobal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


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
