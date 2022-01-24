package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase que simula un Editor, el cual almacena dos strings, una lista de usuarios, una lista de documentos,
 * un usuario y un booleano.
 * @version 11.0.13.8
 * @autor: John Serrano Carrasco
 */
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

        // Usuarios cargados inicialmente
        Usuario user1 = new Usuario("user1", "pass1");
        Usuario user2 = new Usuario("user2", "pass2");
        Usuario user3 = new Usuario("user3", "pass3");
        Usuario user4 = new Usuario("user4", "pass4");
        Usuario user5 = new Usuario("user5", "pass5");

        registrados.add(user1);
        registrados.add(user2);
        registrados.add(user3);
        registrados.add(user4);
        registrados.add(user5);

        // Documentos cargados incialmente
        Documento doc1 = new Documento("user1", "doc1", "cont1");
        Documento doc2 = new Documento("user1", "doc2", "cont2");
        Documento doc3 = new Documento("user2", "doc3", "cont3");
        Documento doc4 = new Documento("user2", "doc4", "cont4");
        Documento doc5 = new Documento("user3", "doc5", "cont5");
        Documento doc6 = new Documento("user3", "doc6", "cont6");
        Documento doc7 = new Documento("user4", "doc7", "cont7");
        Documento doc8 = new Documento("user4", "doc8", "cont8");
        Documento doc9 = new Documento("user5", "doc9", "cont9");
        Documento doc10 = new Documento("user5", "doc10", "cont10");

        documentos.add(doc1);
        documentos.add(doc2);
        documentos.add(doc3);
        documentos.add(doc4);
        documentos.add(doc5);
        documentos.add(doc6);
        documentos.add(doc7);
        documentos.add(doc8);
        documentos.add(doc9);
        documentos.add(doc10);
    }

    /**
     * Obtiene el nombre (String) del Editor
     * @return String Si se obtiene el nombre del editor
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre (String) del editor
     * @param name (String) El nombre del editor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la fecha (Date) de un Editor
     * @return String Si se obtiene la fecha (date) de un Editor
     */
    public String getDate() {
        return date;
    }

    /**
     * Modifica la fecha (Date) de un Editor
     * @param date (date) La fecha de creacion un Editor
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Obtiene la lista de usuarios (ArrayList<Usuario>) registrados en el Editor
     * @return ArrayList<Usuario> Si se obtiene toda la lista de usuarios registrados
     */
    public ArrayList<Usuario> getRegistrados() {
        return registrados;
    }

    /**
     * Modifica la lista de usuarios (ArrayList<Usuario>) registrados en el Editor
     * @param registrados Una lista de usuarios
     */
    public void setRegistrados(ArrayList<Usuario> registrados) {
        this.registrados = registrados;
    }

    /**
     * Obtiene al usuario (Usuario) activo en el Editor
     * @return Usuario Si se obtiene al usuario que tiene la sesion activa en el editor
     */
    public Usuario getActivo() {
        return activo;
    }

    /**
     * Modifica al usuario (Usuario) activo en el Editor
     * @param activo (Usuario). Corresponde a un usuario conectado en el Editor
     */
    public void setActivo(Usuario activo) {
        this.activo = activo;
    }

    /**
     * Booleano que verifica si hay un Usuario con sesion activa en el Editor
     * @return boolean True o False dependiendo de si hay un Usuario activo en el Editor
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * Modifica el booleano para saber si un Usuario esta conectado
     * @param conectado (boolean) Indica si un usuario esta conectado o no
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    /**
     * Obtiene la lista de documentos (ArrayList<Documento>) de un Editor
     * @return ArrayList<Documento> Si se obtiene la lista de documentos del Editor
     */
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Modifica la lsita de documentos (ArrayList<Documento>) de un Editor
     * @param documentos (ArrayList<Documento>). Corresponde a una lista de documentos
     */
    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    /**
     * Transforma todo casi todo el contenido del editor en un string quue al imprimirlo muestra
     * bastante informacion importante al usuario dependiendo si esta conectado o no
     * @return String Si es que toda la informacion del editor se transforma a String
     */
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

    /**
     * Agrega un nuevo usuario (Usuario) a la lista de usuarios registrados del Editor
     * @param usuario (Usuario). Usuario a registrar en el Editor
     */
    public void agregarUsuario(Usuario usuario){
        ArrayList<Usuario> listaUsers = getRegistrados();
        listaUsers.add(usuario);
        setRegistrados(listaUsers);
        return;
    }

    /**
     * Agrega un documento (Documento) nuevo al editor
     * @param documento (Documento). Corresponde al documento a agregar al editor
     */
    public void agregarDocumento(Documento documento){
        ArrayList<Documento> listaDocumentos = getDocumentos();
        listaDocumentos.add(documento);
        setDocumentos(listaDocumentos);
        return;
    }

    /**
     * Elimina el documento y agrega el mismo documento pero actualizado
     * @param documento (Documento). Corresponde al documento a actualizar en el Editor
     */
    public void agregarDocumentoLimpio(Documento documento) {
        ArrayList<Documento> listaDocumentos = getDocumentos();
        for (int i = 0; i < listaDocumentos.size(); i++) {
            if (listaDocumentos.get(i).getId().equals(documento.getId())) {
                listaDocumentos.remove(i);
            }
        }
        listaDocumentos.add(documento);
        setDocumentos(listaDocumentos);
        return;
    }
}
