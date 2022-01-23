package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
     * @return String
     */
    public String getAutor() {
        return autor;
    }

    
    /** 
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    
    /** 
     * @return String
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    
    /** 
     * @param fechaCreacion
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return String
     */
    public String getTexto() {
        return texto;
    }

    
    /** 
     * @param texto
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    
    /** 
     * @return ArrayList<Permiso>
     */
    public ArrayList<Permiso> getPermisos() {
        return permisos;
    }

    
    /** 
     * @param permisos
     */
    public void setPermisos(ArrayList<Permiso> permisos) {
        this.permisos = permisos;
    }

    
    /** 
     * @return ArrayList<Historial>
     */
    public ArrayList<Historial> getHistorialVersiones() {
        return historialVersiones;
    }

    
    /** 
     * @param historialVersiones
     */
    public void setHistorialVersiones(ArrayList<Historial> historialVersiones) {
        this.historialVersiones = historialVersiones;
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
     * @param documento
     * @param permiso
     */
    public void agregarPermiso(Documento documento, Permiso permiso) {
        ArrayList<Permiso> listapermisos = getPermisos();
        listapermisos.add(permiso);
        setPermisos(listapermisos);
        return;
    }
}
