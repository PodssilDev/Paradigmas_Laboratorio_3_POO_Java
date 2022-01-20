package main;

import controller.Controlador;
import model.*;
import view.Menu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor("EntityDocs");
        Controlador controlador = new Controlador(editor);
        controlador.register("John", "010203");
        controlador.register("Dulca", "090807");
        controlador.register("Nico", "9999");
        controlador.login("John", "010203");
        controlador.create("doc1", "cont1");
        ArrayList<String> listusernames = new ArrayList<>();
        listusernames.add("Dulca");
        listusernames.add("Nicos");
        controlador.share(listusernames,1, "Escritura");
        controlador.share(listusernames,1, "Lectura");
        System.out.println(editor.toString());


        //ArrayList<String> usernamesListFiltrada = new ArrayList<String>();
        //usernamesListFiltrada.add("hola");
        //System.out.println(usernamesListFiltrada.get(0));
        //Editor editor = new Editor("EntityDocs");
        //Controlador controlador = new Controlador(editor);

        //Menu menu = new Menu(controlador);

        //menu.ejecutarMenu();
    }
}
