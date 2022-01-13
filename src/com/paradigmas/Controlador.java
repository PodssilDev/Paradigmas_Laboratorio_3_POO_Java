package com.paradigmas;

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

    public boolean estaConectado(){
        Editor actual = getEditor();
        return actual.isConectado();
    }

    // AUTHENTICATION

    public void register(String username, String password){
        Editor editor = getEditor();
        int i = 0;
        while (i < editor.getRegistrados().size()) {
            if(editor.getRegistrados().get(i).getUsername().equals(username)){
                System.out.println("No se puede registrar, el Username ya esta registrado.");
                return;
            }
            i++;
        }
        Usuario newUser = new Usuario(username,password);
        editor.agregarUsuario(newUser);
        System.out.println("El usuario se ha registrado con exito!");
    }

    public void login(String username, String password){
        Editor editor = getEditor();
        int i = 0;
        while (i < editor.getRegistrados().size()) {
            if (editor.getRegistrados().get(i).getUsername().equals(username) && editor.getRegistrados().get(i).getPassword().equals(password)){
                editor.setActivo(editor.getRegistrados().get(i));
                editor.setConectado(true);
                return;
            }
            i++;
        }
        System.out.println("El usuario " + username + " no esta registrado en el editor, o bien, la contrasena ingresada es incorrecta.");
    }

    public void logout(){
        Editor editor = getEditor();
        editor.setConectado(false);

    }

    // CREATE

    // constructor


}
