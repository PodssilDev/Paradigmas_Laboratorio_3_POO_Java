package model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return "Historial{" +
                "fecha='" + fecha + '\'' +
                ", texto='" + texto + '\'' +
                ", id=" + id +
                '}';
    }
}

