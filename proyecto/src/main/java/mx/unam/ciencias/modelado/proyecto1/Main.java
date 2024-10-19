package mx.unam.ciencias.modelado.proyecto1;

import mx.unam.ciencias.modelado.proyecto1.proxy.ClienteRemoto;

public class Main {

    private static ClienteRemoto menu;

    public static void main(String[] args) {
        System.out.println("Hola Mundo");

        menu = new ClienteRemoto();
        
        menu.main(args);
    }
}
