package mx.unam.ciencias.modelado.proyecto1;

import mx.unam.ciencias.modelado.proyecto1.proxy.ClienteRemoto;

/**
 * Clase main, ejecuta el programa como un cliente.
 */
public class Main {

    /**Instancia de cliente remoto. */
    private static ClienteRemoto menu;

    /**
     * Método main, instancia y ejecuta el main del ClienteRemoto.
     * @param args arreglo de argumentos.
     */
    public static void main(String[] args) {

        menu = new ClienteRemoto();

        menu.main(args);
    }
}
