package com.paradigmas;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }
    // Do while?
    public void ejecutarMenu(){
        Scanner input = new Scanner(System.in);
        int eleccion;
        System.out.println("### Bienvenido a EntityDocs ###");
        System.out.println("Escoja la opcion que desea realizar: ");
        System.out.println("1. LOGEARSE");
        System.out.println("2. REGISTRARSE");
        System.out.println("3. SALIR");
        System.out.println("Introduzca la opcion deseada: ");
        eleccion = input.nextInt();
        if(eleccion == 5){
            System.out.println("Ha sido desconectado exitosamente del editor");
        }
    }
}
