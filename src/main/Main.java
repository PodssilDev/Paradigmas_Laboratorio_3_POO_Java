package main;

import controller.Controlador;
import model.*;
import view.Menu;

/**
 * Clase principal del programa. Permite ejecutar el menu interactivo junto con sus funcionalidades
 * @version 11.0.13.8
 * @autor: John Serrano Carrasco
 */
public class Main {
    /**
     * Aqui se ejecuta el menu junto al controlador
     * @param args En este caso no se necesitan parametros apartes en main
     */
    public static void main(String[] args) {
        Editor editor = new Editor("EntityDocs");

        Controlador controlador = new Controlador(editor);

        Menu menu = new Menu(controlador);

        menu.ejecutarMenu();
    }
}
