package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que simula un Historial de versiones, que contiene un string, una date y un integer
 * @version 11.0.13.8
 * @autor: John Serrano Carrasco
 */
public class Historial {
    private String fecha;
    private String texto;
    private Integer id;

    public Historial(String texto, Integer id) {
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
        this.texto = texto;
        this.id = id;
    }

    /**
     * Obtiene la fecha (String) de un Historial de versiones
     * @return String Si se obtiene la fecha (String) de la version del historial
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Modifica la fecha (string) de un Historial de versiones
     * @param fecha (String) Una fecha en formato string
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el texto (String) de una version de un historial
     * @return String Si se obtiene el texto (String) de una version de un Historial
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Modifica el texto (String) de una version de un Historial
     * @param texto (String) Un texto de una version de un historial
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Obtiene el ID (Integer) unico de una version de un Historial
     * @return Integer (Integer) Si se obtiene el ID de una version de un Historial
     */
    public Integer getId() {
        return id;
    }

    /**
     * Modifica el ID (Integer) unico de una version de un Historial
     * @param id (Integer). Corresponde a un ID Unico de una version de un Historial
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Convierte todo el contenido de un Historial a un String
     * @return String Si se transforma todo el contenido de una version de historial a String
     */
    @Override
    public String toString() {
        return "Historial{" +
                "fecha='" + fecha + '\'' +
                ", texto='" + texto + '\'' +
                ", id=" + id +
                '}';
    }
}
