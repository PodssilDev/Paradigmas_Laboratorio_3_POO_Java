package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que simula un Documento, el cual almacena cuatro strings, dos listas, una de permisos y de historial
 * y un ID Global
 * @version 11.0.13.8
 * @autor: John Serrano Carrasco
 */
public class Documento {
    private String autor;
    private String fechaCreacion;
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
        this.name = name;
        this.texto = texto;
        this.permisos = new ArrayList<>();
        Historial newHistorial = new Historial(texto, 0);
        this.historialVersiones = new ArrayList<>();
        historialVersiones.add(newHistorial);
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
    }

    /**
     * Obtiene el autor (string) de un documento
     * @return String al obtener el autor del documento
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Modifica el autor (string) de un documento
     * @param autor (string). El autor del documento
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la fecha (date) de creacion de un documento
     * @return String si se obtiene la fecha del documento
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Modifica la fecha (date) de creacion de un documento
     * @param fechaCreacion (date). La fecha de creacion de un documento
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene el nombre (string) de un documento
     * @return String Si se obtiene el nombre del documento
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre (string) de un documento
     * @param name (string). El nombre de un documento
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la version actual (string) de un documento
     * @return String Si se obtiene la version actual de un documento
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Modifica la version actual (string) de un documento
     * @param texto (string)
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene la lista de permisos (ArrayList<Permiso>) de un documento
     * @return ArrayList<Permiso> Si se obtiene la lista de permisos del documento
     */
    public ArrayList<Permiso> getPermisos() {
        return permisos;
    }

    /**
     * Modifica la lista de permisos (ArrayList<Permiso>) de un documento
     * @param permisos (ArrayList<Permiso>) Una lista de permisos de un documento
     */
    public void setPermisos(ArrayList<Permiso> permisos) {
        this.permisos = permisos;
    }

    /**
     * Obtiene la lista de historial (ArrayList<Historial>) de versiones de un docuumento
     * @return ArrayList<Historial> Si se obtiene el historial de versiones de un documento
     */
    public ArrayList<Historial> getHistorialVersiones() {
        return historialVersiones;
    }

    /**
     * Modifica la lista de historial (ArrayList<Historial>) de versiones de un docuumento
     * @param historialVersiones ArrayList<Historial>. El historial de versiones de un documento
     */
    public void setHistorialVersiones(ArrayList<Historial> historialVersiones) {
        this.historialVersiones = historialVersiones;
    }

    /**
     * Obtiene el id (Integer) unico de un documento
     * @return Integer Si se obtiene el ID unico de un documento
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifica el id (Integer) unico de un documento
     * @param id (Integer) El ID unico de un documento
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Convierte el contenido de un documento a string
     * @return String Si se convierte todo el contenido del documento a String
     */
    @Override
    public String toString() {
        return "Documento{" +
                "autor='" + autor + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", name='" + name + '\'' +
                ", texto='" + texto + '\'' +
                ", permisos=" + permisos +
                ", historialVersiones=" + historialVersiones +
                ", id=" + id +
                '}';
    }

    /**
     * Agrega un permiso en especifico manteniendo los demas permisos de un Documento
     * @param documento (Documento). Un documento cualquiera
     * @param permiso (Permiso). Un permiso en especifico
     */
    public void agregarPermiso(Documento documento, Permiso permiso) {
        ArrayList<Permiso> listapermisos = getPermisos();
        listapermisos.add(permiso);
        setPermisos(listapermisos);
        return;
    }
}
