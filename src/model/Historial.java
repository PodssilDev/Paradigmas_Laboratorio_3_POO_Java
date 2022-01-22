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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "fecha='" + fecha + '\'' +
                ", texto='" + texto + '\'' +
                ", id=" + id +
                '}';
    }
}

