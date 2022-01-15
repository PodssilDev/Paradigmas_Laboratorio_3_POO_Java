package main;

import controller.Controlador;
import model.*;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor("EntityDocs");

        Controlador controlador = new Controlador(editor);

        Menu menu = new Menu(controlador);

        menu.ejecutarMenu();
    }
}
