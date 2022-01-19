package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Documento {
    private String autor;
    private String fechaCreacion;
    private String fechaModificacion;
    private String name;
    private String texto;
    private ArrayList<Permiso> permisos;
    private ArrayList<Historial> historialVersiones;
    private static Integer idGlobal = 0;
    private Integer id;

    public Documento(String autor, String name, String texto) {
        this.autor = autor;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fechaCreacion = tipo.format(tempDate);
        this.fechaModificacion = tipo.format(tempDate);
        this.name = name;
        this.texto = texto;
        this.permisos = new ArrayList<>();
        Historial newHistorial = new Historial(texto, fechaCreacion);
        this.historialVersiones = new ArrayList<>();
        historialVersiones.add(newHistorial);
        idGlobal = idGlobal + 1;
        this.id = idGlobal;


    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList<Permiso> permisos) {
        this.permisos = permisos;
    }

    public ArrayList<Historial> getHistorialVersiones() {
        return historialVersiones;
    }

    public void setHistorialVersiones(ArrayList<Historial> historialVersiones) {
        this.historialVersiones = historialVersiones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "autor='" + autor + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", fechaModificacion='" + fechaModificacion + '\'' +
                ", name='" + name + '\'' +
                ", texto='" + texto + '\'' +
                ", permisos=" + permisos +
                ", historialVersiones=" + historialVersiones +
                ", id=" + id +
                '}';
    }

    public void agregarPermiso(Documento documento, Permiso permiso) {
        ArrayList<Permiso> listapermisos = getPermisos();
        listapermisos.add(permiso);
        setPermisos(listapermisos);
        return;
    }
}
