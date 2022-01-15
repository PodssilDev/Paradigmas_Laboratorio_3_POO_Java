package model;

public class Historial {
    private String fecha;
    private String texto;
    private static Integer idGlobal = 0;
    private Integer id;

    public Historial(String texto, String fecha) {
        this.fecha = fecha;
        this.texto = texto;
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
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
