package controller;

import model.*;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 
 */
public class Controlador {
    private Editor editor;
    
    public Controlador(Editor editor) {
        this.editor = editor;
    }

    
    /** 
     * @return Editor
     */
    public Editor getEditor() {
        return editor;
    }

    
    /** 
     * @param editor
     */
    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    
    /** 
     * @return boolean
     */
    public boolean estaConectado() {
        Editor actual = getEditor();
        return actual.isConectado();
    }

    
    /** 
     * @param username
     * @param password
     */
    // AUTHENTICATION
    
    public void register(String username, String password) {
        Editor editor = getEditor();
        int i = 0;
        while (i < editor.getRegistrados().size()) {
            if (editor.getRegistrados().get(i).getUsername().equals(username)) {
                System.out.println("No se puede registrar, el Username ya esta registrado.");
                return;
            }
            i++;
        }
        Usuario newUser = new Usuario(username, password);
        editor.agregarUsuario(newUser);
        System.out.println("El usuario se ha registrado con exito!");
        return;
    }

    
    /** 
     * Metodo que loguea a un usuario 
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        Editor editor = getEditor();
        int i = 0;
        while (i < editor.getRegistrados().size()) {
            if (editor.getRegistrados().get(i).getUsername().equals(username) && editor.getRegistrados().get(i).getPassword().equals(password)) {
                editor.setActivo(editor.getRegistrados().get(i));
                editor.setConectado(true);
                return;
            }
            i++;
        }
        System.out.println("El usuario " + username + " no esta registrado en el editor, o bien, la contrasena ingresada es incorrecta.");
        return;
    }

    public void logout() {
        Editor editor = getEditor();
        editor.setConectado(false);
        return; 

    }

    
    /** 
     * @param nombreDoc
     * @param contenido
     */
    public void create(String nombreDoc, String contenido) {
        Editor editor = getEditor();
        Documento newDocumento = new Documento(editor.getActivo().getUsername(), nombreDoc, contenido);
        editor.agregarDocumento(newDocumento);
        System.out.println("Se ha creado correctamente un documento.");
        return;
    }

    
    /** 
     * @param usernamesList
     * @param iDDocumento
     * @param permisoADar
     */
    public void share(ArrayList<String> usernamesList, Integer iDDocumento, String permisoADar) {
        Editor editor = getEditor();
        boolean valido = false;
        Permiso permiso;
        boolean filtrado = false;
        ArrayList<String> usernamesListFiltrada = new ArrayList<String>();
        if ((permisoADar.equals("Escritura")) || (permisoADar.equals("Lectura")) || (permisoADar.equals("Comentario"))) {
            valido = true;
        }
        if (valido == false) {
            System.out.println("El permiso que se quiere dar no es valido, intentelo nuevamente.");
            return;
        }
        for (int i = 0; i < usernamesList.size(); i++) {
            for (int j = 0; j < editor.getRegistrados().size(); j++) {
                if (editor.getRegistrados().get(j).getUsername().equals(usernamesList.get(i))) {
                    usernamesListFiltrada.add(usernamesList.get(i));
                }
            }
        }
        if (usernamesListFiltrada.size() == 0) {
            System.out.println("No hay usuarios validos para dar permisos.");
            return;
        }
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                if (!editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getAutor())) {
                    System.out.println("El usuario no puede dar permisos en este documento");
                    return;
                }
                for (int j = 0; j < usernamesListFiltrada.size(); j++) {
                    if (filtrado == false) {
                        for (int k = 0; k < usernamesList.size(); k++) {
                            for (int m = 0; m < editor.getDocumentos().get(i).getPermisos().size(); m++) {
                                if (editor.getDocumentos().get(i).getPermisos().get(m).getUsuario().equals(usernamesList.get(k))) {
                                    editor.getDocumentos().get(i).getPermisos().remove(m);
                                }
                            }
                        }
                        filtrado = true;
                    }
                    permiso = new Permiso(usernamesListFiltrada.get(j), permisoADar);
                    editor.getDocumentos().get(i).agregarPermiso(editor.getDocumentos().get(i), permiso);
                    editor.agregarDocumentoLimpio(editor.getDocumentos().get(i));
                }
                System.out.println("Se compartio el documento con exito!");
                System.out.println("Los usuarios elegidos ahora tienen permiso de " + permisoADar);
                return;
            }
        }
        System.out.println("El ID de documento " + iDDocumento + " no es valido");
        return;
    }

    
    /** 
     * @param iDDocumento
     * @param textoAgregar
     */
    public void add(Integer iDDocumento, String textoAgregar) {
        Editor editor = getEditor();
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                if (editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getAutor())) {
                    String newtexto = editor.getDocumentos().get(i).getTexto().concat(textoAgregar);
                    Historial newver = new Historial(newtexto, editor.getDocumentos().get(i).getHistorialVersiones().size());
                    editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                    editor.getDocumentos().get(i).setTexto(newtexto);
                    System.out.println("Se ha agregado con exito el texto al final del documento!");
                    return;
                }
                for (int j = 0; j < editor.getDocumentos().get(i).getPermisos().size(); j++) {
                    if (editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getPermisos().get(j).getUsuario())) {
                        if (editor.getDocumentos().get(i).getPermisos().get(j).getPermiso().equals("Escritura")) {
                            String newtexto = editor.getDocumentos().get(i).getTexto().concat(textoAgregar);
                            Historial newver = new Historial(newtexto, editor.getDocumentos().get(i).getHistorialVersiones().size());
                            editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                            editor.getDocumentos().get(i).setTexto(newtexto);
                            System.out.println("Se ha agregado con exito el texto al final del documento!");
                            return;
                        }
                    }
                }
                System.out.println("El usuario no es el autor del texto ni tampoco tiene permisos de escritura!");
                System.out.println("No se puede agregar el texto.");
                return;
            }
        }
        System.out.println("El ID de documento " + iDDocumento + " no es valido.");
        return;
    }

    
    /** 
     * @param iDDocumento
     * @param iDVersion
     */
    public void rollback(Integer iDDocumento, Integer iDVersion) {
        Editor editor = getEditor();
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                if (!editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getAutor())) {
                    System.out.println("El usuario no puede restaurar versiones en este documento.");
                    return;
                }
                for (int j = 0; j < editor.getDocumentos().get(i).getHistorialVersiones().size(); j++) {
                    if (editor.getDocumentos().get(i).getHistorialVersiones().get(j).getId().equals(iDVersion)) {
                        editor.getDocumentos().get(i).setTexto(editor.getDocumentos().get(i).getHistorialVersiones().get(j).getTexto());
                        System.out.println("La version " + iDVersion + " ha sido restaurada con exito!");
                        return;
                    }
                }
                System.out.println("La version " + iDVersion + " no puede ser restaurada ya que no existe.");
                return;
            }
        }
        System.out.println("El ID de documento " + iDDocumento + " no es valido.");
        return;
    }

    
    /** 
     * @param iDDocumento
     */
    public void revokeAccess(Integer iDDocumento) {
        Editor editor = getEditor();
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                if (!editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getAutor())) {
                    System.out.println("El usuario no puede revocar accesos en este documento.");
                    return;
                }
                ArrayList<Permiso> newListPermiso = new ArrayList<Permiso>();
                editor.getDocumentos().get(i).setPermisos(newListPermiso);
                System.out.println("Se han revocado todos los accesos del documento con exito!");
                return;
            }
        }
        System.out.println("El ID de documento " + iDDocumento + " no es valido.");
        return;
    }

    
    /** 
     * @param searchText
     */
    public void search(String searchText) {
        Editor editor = getEditor();
        ArrayList<Documento> documentsList = new ArrayList<Documento>();
        ArrayList<Documento> documentsListFound = new ArrayList<Documento>();
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getAutor().equals(editor.getActivo().getUsername())) {
                documentsList.add(editor.getDocumentos().get(i));
            } else {
                for (int j = 0; j < editor.getDocumentos().get(i).getPermisos().size(); j++) {
                    if (editor.getDocumentos().get(i).getPermisos().get(j).getUsuario().equals(editor.getActivo().getUsername())) {
                        documentsList.add(editor.getDocumentos().get(i));
                    }
                }
            }
        }
        if (documentsList.size() == 0) {
            System.out.println("El usuario no tiene documentos en los que pueda realizar busquedas");
            return;
        }
        for (int i = 0; i < documentsList.size(); i++) {
            for (int j = 0; j < documentsList.get(i).getHistorialVersiones().size(); j++) {
                if (documentsList.get(i).getHistorialVersiones().get(j).getTexto().contains(searchText)) {
                    documentsListFound.add(documentsList.get(i));
                    break;
                }
            }
        }
        if (documentsListFound.size() == 0) {
            System.out.println("No se encontraron documentos que contengan el texto buscado");
            return;

        } else {
            System.out.println("Se encontraron Documentos! Los nombres, autores e IDs de estos son: ");
            for (int i = 0; i < documentsListFound.size(); i++) {
                System.out.println("Nombre: " + documentsListFound.get(i).getName());
                System.out.println("ID: " + documentsListFound.get(i).getId());
                System.out.println("Autor: " + documentsListFound.get(i).getAutor());
                System.out.println("----------------------------");
            }
        }
        return;
    }

    public void visualize() {
        Editor editor = getEditor();
        System.out.println(editor.toString());
        return;
    }

    
    /** 
     * @param iDDocumento
     * @param textSize
     */
    public void delete(Integer iDDocumento, Integer textSize) {
        Editor editor = getEditor();
        String newText = "";
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                if (editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getAutor())) {
                    if (editor.getDocumentos().get(i).getTexto().length() <= textSize) {
                        Historial newver = new Historial(newText, editor.getDocumentos().get(i).getHistorialVersiones().size());
                        editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                        editor.getDocumentos().get(i).setTexto(newText);
                        System.out.println("Se ha eliminado con exito el texto!");
                        return;
                    } else {
                        newText = editor.getDocumentos().get(i).getTexto().substring(0, editor.getDocumentos().get(i).getTexto().length() - textSize);
                        Historial newver = new Historial(newText, editor.getDocumentos().get(i).getHistorialVersiones().size());
                        editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                        editor.getDocumentos().get(i).setTexto(newText);
                        System.out.println("Se ha eliminado con exito el texto!");
                        return;
                    }
                }
                for (int j = 0; j < editor.getDocumentos().get(i).getPermisos().size(); j++) {
                    if (editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getPermisos().get(j).getUsuario())) {
                        if (editor.getDocumentos().get(i).getTexto().length() <= textSize) {
                            Historial newver = new Historial(newText, editor.getDocumentos().get(i).getHistorialVersiones().size());
                            editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                            editor.getDocumentos().get(i).setTexto(newText);
                            System.out.println("Se ha eliminado con exito el texto!");
                            return;
                        } else {
                            newText = editor.getDocumentos().get(i).getTexto().substring(0, editor.getDocumentos().get(i).getTexto().length() - textSize);
                            Historial newver = new Historial(newText, editor.getDocumentos().get(i).getHistorialVersiones().size());
                            editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                            editor.getDocumentos().get(i).setTexto(newText);
                            System.out.println("Se ha eliminado con exito el texto!");
                            return;
                        }
                    }
                }
                System.out.println("El usuario no es el autor del texto ni tampoco tiene permisos de escritura!");
                System.out.println("No se puede agregar el texto.");
                return;
            }
        }
        System.out.println("El ID de documento " + iDDocumento + " no es valido.");
        return;
    }

    
    /** 
     * @param iDDocumento
     * @param searchText
     * @param replaceText
     */
    public void searchAndReplace(Integer iDDocumento, String searchText, String replaceText) {
        Editor editor = getEditor();
        boolean habilitado = false;
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                if (editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getAutor())) {
                    habilitado = true;
                }
                if (habilitado == false) {
                    for (int j = 0; j < editor.getDocumentos().get(i).getPermisos().size(); j++) {
                        if (editor.getActivo().getUsername().equals(editor.getDocumentos().get(i).getPermisos().get(j).getUsuario())) {
                            habilitado = true;
                        }
                    }
                }
                if(habilitado == true){
                    if(editor.getDocumentos().get(i).getTexto().contains(searchText)){
                        String newText = editor.getDocumentos().get(i).getTexto().replaceAll(searchText, replaceText);
                        Historial newver = new Historial(newText, editor.getDocumentos().get(i).getHistorialVersiones().size());
                        editor.getDocumentos().get(i).getHistorialVersiones().add(newver);
                        editor.getDocumentos().get(i).setTexto(newText);
                        System.out.println("Se han reemplazado todas las coincidencias del texto con exito!");
                        return;
                    }else{
                        System.out.println("La version activa del documento no contiene el texto que se quiere reemplazar.");
                        return;
                    }
                }else{
                    System.out.println("El usuario no es el autor del documento ni tiene los permisos para reemplazar el texto");
                    return;
                }
            }
        }
        System.out.println("El ID de documento " + iDDocumento + " no es valido.");
        return;
    }

}