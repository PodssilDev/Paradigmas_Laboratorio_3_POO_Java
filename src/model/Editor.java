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

        Usuario user1 = new Usuario("MrDoo", "lol123");
        Usuario user2 = new Usuario("dulca", "test");

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
        String retorno = new String();
        ArrayList<Documento> documentsList = new ArrayList<Documento>();
        retorno = "Nombre del editor: " + getName() + "\n";
        retorno = retorno + "Fecha de creacion de la plataforma: " + getDate() + "\n";
        retorno = retorno + "------------------" + "\n";
        if (isConectado() == true) {
            retorno = retorno + "Usuario online actualmente: " + getActivo().getUsername() + "\n";
            retorno = retorno + "Cuenta creada con la fecha de: " + getActivo().getFecha() + "\n";
            retorno = retorno + "------------------" + "\n";
            for (int i = 0; i < getDocumentos().size(); i++) {
                if (getDocumentos().get(i).getAutor().equals(getActivo().getUsername())) {
                    documentsList.add(getDocumentos().get(i));
                } else {
                    for (int j = 0; j < getDocumentos().get(i).getPermisos().size(); j++) {
                        if (getDocumentos().get(i).getPermisos().get(j).getUsuario().equals(getActivo().getUsername())) {
                            documentsList.add(getDocumentos().get(i));
                        }
                    }
                }
            }
            if (documentsList.size() == 0) {
                retorno = retorno + "El usuario no tiene documentos propios ni compartidos.";
                return retorno;
            }
            retorno = retorno + "El usuario cuenta con " + documentsList.size() + " documentos propios o compartidos" + "\n";
            for (int i = 0; i < documentsList.size(); i++) {
                retorno = retorno + "------------------" + "\n";
                retorno = retorno + "ID: " + documentsList.get(i).getId() + "\n";
                retorno = retorno + "Propietario: " + documentsList.get(i).getAutor() + "\n";
                retorno = retorno + "Nombre: " + documentsList.get(i).getName() + "\n";
                retorno = retorno + "Contenido: " + documentsList.get(i).getTexto() + "\n";
                if (documentsList.get(i).getPermisos().size() == 0) {
                    retorno = retorno + "El documento no ha sido compartido con otros usuarios" + "\n";
                } else {
                    retorno = retorno + "El documento ha sido compartido con " + documentsList.get(i).getPermisos().size() + " usuarios" + "\n";
                    for (int j = 0; j < documentsList.get(i).getPermisos().size(); j++) {
                        retorno = retorno + "------------------" + "\n";
                        retorno = retorno + "Usuario al que se le dio permiso: " + documentsList.get(i).getPermisos().get(j).getUsuario() + "\n";
                        retorno = retorno + "Permiso concedido: " + documentsList.get(i).getPermisos().get(j).getPermiso() + "\n";
                    }
                }
                retorno = retorno + "El documento tiene " + documentsList.get(i).getHistorialVersiones().size() + " versiones" + "\n";
            }
            return retorno;

        } else {
            if (getDocumentos().size() == 0) {
                retorno = retorno + "Aun no se han creado documentos en el editor." + "\n";
                return retorno;
            } else {
                retorno = retorno + "Los documentos creados en la plataforma son:" + "\n";
                for (int i = 0; i < getDocumentos().size(); i++) {
                    retorno = retorno + "------------------" + "\n";
                    retorno = retorno + "ID: " + getDocumentos().get(i).getId() + "\n";
                    retorno = retorno + "Propietario: " + getDocumentos().get(i).getAutor() + "\n";
                    retorno = retorno + "Nombre: " + getDocumentos().get(i).getName() + "\n";
                    retorno = retorno + "Contenido: " + getDocumentos().get(i).getTexto() + "\n";
                    retorno = retorno + "El documento tiene " + getDocumentos().get(i).getHistorialVersiones().size() + " versiones" + "\n";
                }
                return retorno;
            }
        }
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

    public void agregarDocumentoLimpio(Documento documento) {
        ArrayList<Documento> listaDocumentos = getDocumentos();
        for (int i = 0; i < listaDocumentos.size(); i++) {
            if (listaDocumentos.get(i).getId().equals(documento.getId())) {
                listaDocumentos.remove(i);
            }
        }
        listaDocumentos.add(documento);
        setDocumentos(listaDocumentos);
    }
}
