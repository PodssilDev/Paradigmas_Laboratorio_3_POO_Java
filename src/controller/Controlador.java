package controller;

import model.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Controlador {
    private Editor editor;


    public Controlador(Editor editor) {
        this.editor = editor;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public boolean estaConectado() {
        Editor actual = getEditor();
        return actual.isConectado();
    }

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
    }

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
    }

    public void logout() {
        Editor editor = getEditor();
        editor.setConectado(false);

    }

    public void create(String nombreDoc, String contenido) {
        Editor editor = getEditor();
        Documento newDocumento = new Documento(editor.getActivo().getUsername(), nombreDoc, contenido);
        editor.agregarDocumento(newDocumento);
        System.out.println("Se ha creado correctamente un documento.");
    }

    public void share(ArrayList<String> usernamesList, Integer iDDocumento, String permisoADar) {
        Editor editor = getEditor();
        Permiso permiso;
        boolean filtrado = false;
        ArrayList<String> usernamesListFiltrada = new ArrayList<String>();
        for (int i = 0; i < usernamesList.size(); i++) {
            for (int j = 0; j < editor.getRegistrados().size(); j++) {
                if (editor.getRegistrados().get(j).getUsername().equals(usernamesList.get(i))) {
                    usernamesListFiltrada.add(usernamesList.get(i));
                }
            }
        }
        if(usernamesListFiltrada.size() == 0){
            System.out.println("No hay usuarios validos para dar permisos.");
            return;
        }
        for (int i = 0; i < editor.getDocumentos().size(); i++) {
            if (editor.getDocumentos().get(i).getId() == iDDocumento) {
                for (int j = 0; j < usernamesListFiltrada.size(); j++) {
                    if(filtrado == false){
                        for (int k = 0; k < usernamesList.size(); k++) {
                            for (int m = 0; j < editor.getDocumentos().get(i).getPermisos().size(); m++) {
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
                return;
            }
        }
        System.out.println("El documento no es valido");
        return;
    }
}
