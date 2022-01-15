package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Editor {
    private String name;
    private String date;
    private ArrayList<Usuario> registrados;
    private Usuario activo;
    private boolean conectado;
    private ArrayList<Documento> documentos;

    public Editor(String name) {
        this.name = name;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.date = tipo.format(tempDate);
        this.registrados = new ArrayList<>();
        this.conectado = false;
        this.documentos = new ArrayList<>();

        Usuario user1 = new Usuario("MrDoo","lol123");
        Usuario user2 = new Usuario("dulca","test");

        registrados.add(user1);
        registrados.add(user2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Usuario> getRegistrados() {
        return registrados;
    }

    public void setRegistrados(ArrayList<Usuario> registrados) {
        this.registrados = registrados;
    }

    public Usuario getActivo() {
        return activo;
    }

    public void setActivo(Usuario activo) {
        this.activo = activo;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", registrados=" + registrados +
                ", activo=" + activo +
                ", conectado=" + conectado +
                ", documentos=" + documentos +
                '}';
    }

    public void agregarUsuario(Usuario usuario){
        ArrayList<Usuario> listaUsers = getRegistrados();
        listaUsers.add(usuario);
        setRegistrados(listaUsers);
    }

    public void agregarDocumento(Documento documento){
        ArrayList<Documento> listaDocumentos = getDocumentos();
        listaDocumentos.add(documento);
        setDocumentos(listaDocumentos);
    }
}
