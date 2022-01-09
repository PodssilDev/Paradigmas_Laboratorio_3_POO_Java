package com.paradigmas;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class User {
    // attributes
    private static Integer idGlobal = 0;
    private Integer id;
    private String username;
    private String password;
    private String fecha;
    private ArrayList<User> documentos;

    public User(String username, String password) {
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
        this.username = username;
        this.password = password;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
        this.documentos = new ArrayList<>();
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

    public ArrayList<User> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ArrayList<User> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fecha='" + fecha + '\'' +
                ", documentos=" + documentos +
                '}';
    }
}
