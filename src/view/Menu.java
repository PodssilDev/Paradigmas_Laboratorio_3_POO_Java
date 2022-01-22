package view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import controller.Controlador;

public class Menu {
    private Controlador controlador;


    public Menu(Controlador controlador) {
        this.controlador = controlador;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void ejecutarMenu() {
        Scanner input = new Scanner(System.in);
        boolean salirMenu = false;
        int eleccion;
        int eleccionShare;
        String username;
        String password;
        Controlador controlador = getControlador();
        while (!salirMenu) {
            if (controlador.estaConectado() == false) {
                System.out.println("### Bienvenido al editor colaborativo " + controlador.getEditor().getName() + " ###");
                System.out.println("Escoja la opcion que desea realizar: ");
                System.out.println("1. Loguearse");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                try {
                    System.out.println("Introduzca su eleccion: ");
                    eleccion = input.nextInt();
                    switch (eleccion) {
                        case 1:
                            System.out.println("Su opcion fue la numero 1: Loguearse");
                            System.out.println("Ingrese el nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese la contrasena para el usuario " + username);
                            password = input.nextLine();
                            controlador.login(username, password);
                            break;
                        case 2:
                            System.out.println("Su opcion fue la numero 2: Registrarse");
                            System.out.println("Ingrese el nombre de usuario: ");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese una contrasena: ");
                            password = input.nextLine();
                            controlador.register(username, password);
                            break;
                        case 3:
                            System.out.println("Gracias por utilizar " + controlador.getEditor().getName());
                            salirMenu = true;
                            input.close();
                            break;
                        default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    input.next();
                }
            } else {
                System.out.println("### Editor " + controlador.getEditor().getName() + " ###");
                System.out.println("## Logueado como: " + controlador.getEditor().getActivo().getUsername() + " ##");
                System.out.println("Escoja una accion a realizar:");
                System.out.println("1. Crear nuevo documento");
                System.out.println("2. Compartir documento");
                System.out.println("3. Agregar contenido a un documento");
                System.out.println("4. Restaurar version de un documento");
                System.out.println("5. Revocar acceso a un documento");
                System.out.println("6. Buscar en los documentos");
                System.out.println("7. Visualizar documentos");
                System.out.println("8. Cerrar sesion");
                System.out.println("9. Cerrar el editor");
                try {
                    System.out.println("Ingrese una de las opciones anteriores: ");
                    eleccion = input.nextInt();
                    switch (eleccion) {
                        case 1: // CREATE
                            System.out.println("Ingrese el nombre del documento: ");
                            input.nextLine();
                            String nameDoc = input.nextLine();
                            System.out.println("Ingrese el contenido del documento: ");
                            String contentDoc = input.nextLine();
                            controlador.create(nameDoc, contentDoc);
                            break;

                        case 2:
                            boolean salirShare = false;
                            ArrayList<String> userList = new ArrayList<String>();
                            System.out.println("Permiso de escribir: Escritura");
                            System.out.println("Permiso de lectura: Lectura");
                            System.out.println("Permiso de comentar: Comentario");
                            System.out.println("Considerando lo anterior, ingrese el permiso que desea dar, respetando la mayuscula de la primera letra");
                            input.nextLine();
                            String permiso = input.nextLine();
                            System.out.println("Ingrese el ID del documento que desea compartir: ");
                            Integer documentID = input.nextInt();
                            System.out.println("Ingrese el username del usuario al que desea compartir el documento");
                            input.nextLine();
                            String user = input.nextLine();
                            userList.add(user);
                            while (!salirShare) {
                                System.out.println("¿Desea dar permisos a otro usuario?");
                                System.out.println("1. Dar permisos a otro usuario");
                                System.out.println("2. Finalizar proceso de compartir");
                                try{
                                    System.out.println("Introduzca su eleccion: ");
                                    eleccionShare = input.nextInt();
                                    switch (eleccionShare) {
                                        case 1:
                                            System.out.println("Ingrese el username del usuario al que desea compartir el documento");
                                            input.nextLine();
                                            user = input.nextLine();
                                            userList.add(user);
                                            break;
                                        case 2:
                                            salirShare = true;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                                    input.next();
                                }
                            }
                            controlador.share(userList, documentID, permiso);
                            break;

                        case 3:
                            System.out.println("Ingrese el ID del documento que desea editar: ");
                            documentID = input.nextInt();
                            System.out.println("Ingrese el texto que desea agregar al final del documento: ");
                            input.nextLine();
                            String newText = input.nextLine();
                            controlador.add(documentID, newText);
                            break;

                        case 8: // logout
                            controlador.logout();
                            break;

                        case 9:
                            System.out.println("Gracias por utilizar " + controlador.getEditor().getName());
                            salirMenu = true;
                            input.close();
                            break;

                        default:
                            System.out.println("Seleccione nuevamente una de las opciones anteriores");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("El menu solo admite como entrada numeros y alguna de las opciones anteriores");
                    input.next();
                }
            }
        }
    }
}
